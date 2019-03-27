package fr.unedic.cali.calcul;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoRemplissage;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.Unite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.Iterator;

public class OutillageCalculADate
{
  public static ChronologiePeriodes boucheLesTrous(ChronologiePeriodes p_chronologie, Class p_classePeriodeBoucheTrous, Damj p_dateDebut, Damj p_dateFin)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoRetour = null;
    ObjetChronoPeriode periodeBoucheTrou = null;
    Damj dateFinPeriodePrecedente = null;
    ObjetChronoPeriode periodeCourante = null;
    chronoRetour = new ChronologiePeriodes();
    try
    {
      if (p_chronologie.estVide())
      {
        periodeBoucheTrou = (ObjetChronoPeriode)p_classePeriodeBoucheTrous.newInstance();
        periodeBoucheTrou.setDateDebut(p_dateDebut);
        periodeBoucheTrou.setDateFin(p_dateFin);
        chronoRetour.ajouter(periodeBoucheTrou);
      }
      else
      {
        periodeCourante = (ObjetChronoPeriode)p_chronologie.premierElement();
        if (periodeCourante.getDateDebut().estApres(p_dateDebut))
        {
          periodeBoucheTrou = (ObjetChronoPeriode)p_classePeriodeBoucheTrous.newInstance();
          periodeBoucheTrou.setDateDebut(p_dateDebut);
          periodeBoucheTrou.setDateFin(periodeCourante.getDateDebut().veille());
          chronoRetour.ajouter(periodeBoucheTrou);
        }
        p_chronologie.iterer();
        while (p_chronologie.encoreSuivant())
        {
          periodeCourante = (ObjetChronoPeriode)p_chronologie.elementSuivant();
          if ((dateFinPeriodePrecedente != null) && (periodeCourante.getDateDebut().estApres(dateFinPeriodePrecedente.lendemain())))
          {
            periodeBoucheTrou = (ObjetChronoPeriode)p_classePeriodeBoucheTrous.newInstance();
            periodeBoucheTrou.setDateDebut(dateFinPeriodePrecedente.lendemain());
            periodeBoucheTrou.setDateFin(periodeCourante.getDateDebut().veille());
            chronoRetour.ajouter(periodeBoucheTrou);
          }
          chronoRetour.ajouter(periodeCourante);
          if (dateFinPeriodePrecedente != null) {
            dateFinPeriodePrecedente = Damj.max(periodeCourante.getDateFin(), dateFinPeriodePrecedente);
          } else {
            dateFinPeriodePrecedente = periodeCourante.getDateFin();
          }
        }
        if (dateFinPeriodePrecedente.estAvant(p_dateFin))
        {
          periodeBoucheTrou = (ObjetChronoPeriode)p_classePeriodeBoucheTrous.newInstance();
          periodeBoucheTrou.setDateDebut(dateFinPeriodePrecedente.lendemain());
          periodeBoucheTrou.setDateFin(p_dateFin);
          chronoRetour.ajouter(periodeBoucheTrou);
        }
      }
    }
    catch (IllegalAccessException iae)
    {
      throw new CoucheLogiqueException("HG_PR_CALI_L_PROBLEME_D_INSTANCIATION", "Impossible d'instancier un objet", iae);
    }
    catch (InstantiationException ie)
    {
      throw new CoucheLogiqueException("HG_PR_CALI_L_PROBLEME_D_INSTANCIATION", "Impossible d'instancier un objet", ie);
    }
    return chronoRetour;
  }
  
  public static Damj remplirTrousChronologieParIndemnisation(ChronologiePeriodes p_chronologieRemplissage, Quantite p_nbBases, Periode p_periode)
  {
    return remplirTrousChronologieRemplissage(p_chronologieRemplissage, p_nbBases, 2, p_periode);
  }
  
  public static void remplirTrousChronologieParDecalage(ChronologiePeriodes p_chronologieRemplissage, Quantite p_nbBases, Periode p_periode)
  {
    remplirTrousChronologieRemplissage(p_chronologieRemplissage, p_nbBases, 3, p_periode);
  }
  
  public static Damj remplirTrousChronologieParDecalageEtRetourneDate(ChronologiePeriodes p_chronologieRemplissage, Quantite p_nbBases, Periode p_periode)
  {
    return remplirTrousChronologieRemplissage(p_chronologieRemplissage, p_nbBases, 3, p_periode);
  }
  
  public static ChronologiePeriodes creationChronologieRemplissageAvecSuspensifs(ChronologiePeriodes p_chronologiePeriodesSuspensives, Damj p_dateDeDebut, Damj p_dateDeFin)
    throws CoucheLogiqueException
  {
    return boucheLesTrous(p_chronologiePeriodesSuspensives, ObjetChronoRemplissage.class, p_dateDeDebut, p_dateDeFin);
  }
  
  private static Damj remplirTrousChronologieRemplissage(ChronologiePeriodes p_chronologieRemplissage, Quantite p_nbreBaseAConsommer, int p_nouveauType, Periode p_periode)
  {
    Iterator iterator = null;
    ObjetChronoPeriode objetChronoPeriode = null;
    ObjetChronoRemplissage objetChronoRemplissage = null;
    ObjetChronoRemplissage nouvelObjetChronoRemplissage = null;
    Quantite nbreBaseAConsommer = null;
    Damj dernierJour = null;
    if (p_nbreBaseAConsommer.getUnite().getNom().equals("mois"))
    {
      BigDecimal moisJours = new BigDecimal(Damj.getNbJoursMois(p_periode.getDebut().getMois(), p_periode.getDebut().getAnnee())).multiply(p_nbreBaseAConsommer.getValeur());
      moisJours = moisJours.setScale(0, 4);
      nbreBaseAConsommer = new QuantiteJour(new BigDecimal(moisJours.intValue()));
    }
    else
    {
      nbreBaseAConsommer = p_nbreBaseAConsommer;
    }
    iterator = p_chronologieRemplissage.iterer();
    while ((iterator.hasNext()) && (nbreBaseAConsommer.getValeurEntiere() != 0))
    {
      objetChronoPeriode = (ObjetChronoPeriode)iterator.next();
      if ((objetChronoPeriode instanceof ObjetChronoRemplissage))
      {
        objetChronoRemplissage = (ObjetChronoRemplissage)objetChronoPeriode;
        if (objetChronoRemplissage.getType() == 0) {
          if (objetChronoRemplissage.getDuree() <= nbreBaseAConsommer.getValeurEntiere())
          {
            objetChronoRemplissage.setType(p_nouveauType);
            
            nbreBaseAConsommer = nbreBaseAConsommer.soustraire(new Quantite(new BigDecimal(objetChronoRemplissage.getDuree()), nbreBaseAConsommer.getUnite()));
            
            dernierJour = objetChronoRemplissage.getDateFin();
          }
          else
          {
            nouvelObjetChronoRemplissage = new ObjetChronoRemplissage(p_nouveauType, objetChronoRemplissage.getDateDebut(), objetChronoRemplissage.getDateDebut().deplacerVersAvant(new DureeCalendaire(0, 0, nbreBaseAConsommer.getValeurEntiere())).veille());
            
            objetChronoRemplissage.setDateDebut(nouvelObjetChronoRemplissage.getDateFin().lendemain());
            
            p_chronologieRemplissage.ajouter(nouvelObjetChronoRemplissage);
            
            nbreBaseAConsommer = new Quantite(new BigDecimal(0), nbreBaseAConsommer.getUnite());
            
            dernierJour = nouvelObjetChronoRemplissage.getDateFin();
          }
        }
      }
    }
    return dernierJour;
  }
  
  public static ChronologiePeriodes retourneLesTrous(ChronologiePeriodes p_chronologie, Class p_classePeriodeBoucheTrous, Damj p_dateDebut, Damj p_dateFin)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoRetour = null;
    ObjetChronoPeriode periodeBoucheTrou = null;
    Damj dateFinPeriodePrecedente = null;
    ObjetChronoPeriode periodeCourante = null;
    
    chronoRetour = new ChronologiePeriodes();
    try
    {
      if (p_chronologie.estVide())
      {
        periodeBoucheTrou = (ObjetChronoPeriode)p_classePeriodeBoucheTrous.newInstance();
        periodeBoucheTrou.setDateDebut(p_dateDebut);
        periodeBoucheTrou.setDateFin(p_dateFin);
        chronoRetour.ajouter(periodeBoucheTrou);
      }
      else
      {
        periodeCourante = (ObjetChronoPeriode)p_chronologie.premierElement();
        if (periodeCourante.getDateDebut().estApres(p_dateDebut))
        {
          periodeBoucheTrou = (ObjetChronoPeriode)p_classePeriodeBoucheTrous.newInstance();
          periodeBoucheTrou.setDateDebut(p_dateDebut);
          periodeBoucheTrou.setDateFin(periodeCourante.getDateDebut().veille());
          chronoRetour.ajouter(periodeBoucheTrou);
        }
        p_chronologie.iterer();
        while (p_chronologie.encoreSuivant())
        {
          periodeCourante = (ObjetChronoPeriode)p_chronologie.elementSuivant();
          if ((dateFinPeriodePrecedente != null) && (periodeCourante.getDateDebut().estApres(dateFinPeriodePrecedente.lendemain())))
          {
            periodeBoucheTrou = (ObjetChronoPeriode)p_classePeriodeBoucheTrous.newInstance();
            periodeBoucheTrou.setDateDebut(dateFinPeriodePrecedente.lendemain());
            periodeBoucheTrou.setDateFin(periodeCourante.getDateDebut().veille());
            chronoRetour.ajouter(periodeBoucheTrou);
          }
          if (dateFinPeriodePrecedente != null) {
            dateFinPeriodePrecedente = Damj.max(periodeCourante.getDateFin(), dateFinPeriodePrecedente);
          } else {
            dateFinPeriodePrecedente = periodeCourante.getDateFin();
          }
        }
        if (dateFinPeriodePrecedente.estAvant(p_dateFin))
        {
          periodeBoucheTrou = (ObjetChronoPeriode)p_classePeriodeBoucheTrous.newInstance();
          periodeBoucheTrou.setDateDebut(dateFinPeriodePrecedente.lendemain());
          periodeBoucheTrou.setDateFin(p_dateFin);
          chronoRetour.ajouter(periodeBoucheTrou);
        }
      }
    }
    catch (IllegalAccessException iae)
    {
      throw new CoucheLogiqueException("HG_PR_CALI_L_PROBLEME_D_INSTANCIATION", "Impossible d'instancier un objet", iae);
    }
    catch (InstantiationException ie)
    {
      throw new CoucheLogiqueException("HG_PR_CALI_L_PROBLEME_D_INSTANCIATION", "Impossible d'instancier un objet", ie);
    }
    return chronoRetour;
  }
}

/* Location:
 * Qualified Name:     OutillageCalculADate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */