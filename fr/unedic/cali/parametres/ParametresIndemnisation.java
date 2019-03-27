package fr.unedic.cali.parametres;

import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieStandard;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.Iterator;
import java.util.ListIterator;

public class ParametresIndemnisation
{
  private static ParametresIndemnisation s_parametreIndemnisation = new ParametresIndemnisation();
  private static ThreadLocal s_initHolder = new ThreadLocal();
  private ChronologieStandard m_chronoEvenementsParametre = null;
  private boolean m_initialisationOK = false;
  
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
    m_chronoEvenementsParametre = new ChronologieStandard();
    
    m_chronoEvenementsParametre.ajouter(new AccesSmicMensuelBase35h().getChronoValeursParametre());
    
    m_chronoEvenementsParametre.ajouter(new AccesSmicJournalierBase35h().getChronoValeursParametre());
    
    m_chronoEvenementsParametre.ajouter(new AccesSmigJournalierMayotteBase39h().getChronoValeursParametre());
    
    m_chronoEvenementsParametre.ajouter(new AccesPlafondJournalierSecuriteSociale().getChronoValeursParametre());
    
    m_chronoEvenementsParametre.ajouter(new AccesPlafondMensuelSecuriteSociale().getChronoValeursParametre());
    
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
    EvenementParametre evtCourant = new EvenementParametre(p_date);
    
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
  
  public ChronologieStandard getChronoEvenementsParametre()
  {
    return m_chronoEvenementsParametre;
  }
  
  public boolean isInitialisationOK()
  {
    return m_initialisationOK;
  }
  
  public void setInitialisationOK(boolean p_newInitialisationOK)
  {
    m_initialisationOK = p_newInitialisationOK;
  }
}

/* Location:
 * Qualified Name:     ParametresIndemnisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */