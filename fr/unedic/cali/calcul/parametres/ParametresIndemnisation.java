package fr.unedic.cali.calcul.parametres;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.dom.EvenementParametre;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieStandard;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.Iterator;
import java.util.ListIterator;

public class ParametresIndemnisation
{
  private ChronologieStandard m_chronoEvenementsParametre = null;
  private static ParametresIndemnisation s_parametreIndemnisation = new ParametresIndemnisation();
  private static ThreadLocal s_initHolder = new ThreadLocal();
  private boolean m_initialisationOK = false;
  
  private void dedoublonner()
  {
    ListIterator iterateur = m_chronoEvenementsParametre.iterer();
    EvenementParametre evtCourant = null;
    EvenementParametre evtSuivant = null;
    Damj dateEvtCourant = null;
    Damj dateEvtSuivant = null;
    if (iterateur.hasNext())
    {
      evtCourant = (EvenementParametre)iterateur.next();
      dateEvtCourant = evtCourant.getDateEffet();
    }
    while (iterateur.hasNext())
    {
      evtSuivant = (EvenementParametre)iterateur.next();
      dateEvtSuivant = evtSuivant.getDateEffet();
      if (dateEvtCourant.coincideAvec(dateEvtSuivant))
      {
        iterateur.previous();
        iterateur.previous();
        iterateur.remove();
        iterateur.next();
      }
      evtCourant = evtSuivant;
      dateEvtCourant = dateEvtSuivant;
    }
  }
  
  public EvenementParametre getElementActif(Damj p_date)
  {
    EvenementParametre evtCourant = null;
    
    Iterator it = m_chronoEvenementsParametre.iterer();
    while (it.hasNext())
    {
      EvenementParametre evt = (EvenementParametre)it.next();
      if (!evt.getDateEffet().estAvantOuCoincideAvec(p_date)) {
        break;
      }
      evtCourant = evt;
    }
    return evtCourant;
  }
  
  public Chronologie getParametresActifs(Periode p_periode)
  {
    return m_chronoEvenementsParametre.elementsDeDebutDans(p_periode);
  }
  
  public static ParametresIndemnisation getParametresIndemnisation()
  {
    if (s_initHolder.get() == null) {
      synchronized (ParametresIndemnisation.class)
      {
        if (!s_parametreIndemnisation.isInitialisationOK()) {
          s_parametreIndemnisation.initialiser();
        }
        s_initHolder.set(Boolean.TRUE);
      }
    }
    return s_parametreIndemnisation;
  }
  
  private void initialiser()
  {
    AccesForfaitMensuellePansAgricole forfaitPansAgricole = new AccesForfaitMensuellePansAgricole();
    AccesForfaitMensuellePansNonAgricolePremiereAnnee forfaitPansNonAgricolePremiereAnnee = new AccesForfaitMensuellePansNonAgricolePremiereAnnee();
    AccesForfaitMensuellePansNonAgricoleDeuxiemeAnnee forfaitPansNonAgricoleDeuxiemeAnne = new AccesForfaitMensuellePansNonAgricoleDeuxiemeAnnee();
    AccesSmicHoraire smicHoraire = new AccesSmicHoraire();
    AccesTauxCotisationAccidentTravail tauxCotisationAccidentTravail = new AccesTauxCotisationAccidentTravail();
    AccesTauxCotisationSocialeObligatoireSurSalaire tauxCotisationSocialeObligatoireSurSalaire = new AccesTauxCotisationSocialeObligatoireSurSalaire();
    
    ChronologieStandard chronoForfaitPansAgricole = forfaitPansAgricole.getChronoValeursParametre();
    ChronologieStandard chronoForfaitPansNonAgricolePremiereAnnee = forfaitPansNonAgricolePremiereAnnee.getChronoValeursParametre();
    ChronologieStandard chronoForfaitPansNonAgricoleDeuxiemeAnnee = forfaitPansNonAgricoleDeuxiemeAnne.getChronoValeursParametre();
    ChronologieStandard chronoSmicHoraire = smicHoraire.getChronoValeursParametre();
    ChronologieStandard chronoTauxCotisationAccidentTravail = tauxCotisationAccidentTravail.getChronoValeursParametre();
    ChronologieStandard chronoTauxCotisationSocialeObligatoireSurSalaire = tauxCotisationSocialeObligatoireSurSalaire.getChronoValeursParametre();
    
    m_chronoEvenementsParametre = new ChronologieStandard();
    m_chronoEvenementsParametre.ajouter(chronoForfaitPansAgricole);
    m_chronoEvenementsParametre.ajouter(chronoForfaitPansNonAgricolePremiereAnnee);
    m_chronoEvenementsParametre.ajouter(chronoForfaitPansNonAgricoleDeuxiemeAnnee);
    m_chronoEvenementsParametre.ajouter(chronoSmicHoraire);
    m_chronoEvenementsParametre.ajouter(chronoTauxCotisationAccidentTravail);
    m_chronoEvenementsParametre.ajouter(chronoTauxCotisationSocialeObligatoireSurSalaire);
    
    Iterator iterateurChrono = m_chronoEvenementsParametre.iterer();
    
    EvenementParametre evtCourant = null;
    EvenementParametre evtPrecedent = null;
    if (iterateurChrono.hasNext())
    {
      evtPrecedent = (EvenementParametre)iterateurChrono.next();
    }
    else
    {
      m_initialisationOK = true;
      return;
    }
    while (iterateurChrono.hasNext())
    {
      evtCourant = (EvenementParametre)iterateurChrono.next();
      evtCourant.repercuter(evtPrecedent);
      evtPrecedent = evtCourant;
    }
    dedoublonner();
    
    m_initialisationOK = true;
  }
  
  public boolean isInitialisationOK()
  {
    return m_initialisationOK;
  }
  
  public static void main(String[] p_args)
  {
    ParametresIndemnisation singletonParam = getParametresIndemnisation();
    if (Log.isTraceActive(ParametresIndemnisation.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, ParametresIndemnisation.class, "main", m_chronoEvenementsParametre.toString());
    }
  }
  
  public void setInitialisationOK(boolean p_initialisationOK)
  {
    m_initialisationOK = p_initialisationOK;
  }
}

/* Location:
 * Qualified Name:     ParametresIndemnisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */