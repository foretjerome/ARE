package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.autresdoms.ga.dom.DeclareTravail;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAvecStatut;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitAbstrait;
import fr.unedic.cali.outilsfonctionnels.OutillagePEC;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourNumeroGamme;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DeterminerPopulationIndividu
{
  public static final int POPULATION_CAS_GENERAL = 0;
  public static final int POPULATION_A8_A10 = 1;
  
  public static ChronologiePeriodes determinerPopulationIndividu(IndividuSpec p_individu, Damj p_dateDebut, Damj p_dateFin)
  {
    ChronologiePeriodes retour = new ChronologiePeriodes();
    Damj dateCourante = p_dateDebut;
    while (dateCourante.estAvantOuCoincideAvec(p_dateFin))
    {
      int populationCourante = determinerPopulationIndividu(p_individu, dateCourante);
      PeriodeAvecStatut periodeCourante = new PeriodeAvecStatut(dateCourante, populationCourante);
      
      retour.ajouter(periodeCourante);
      
      dateCourante = dateCourante.getDebutMoisSuivant();
    }
    return retour;
  }
  
  public static int determinerPopulationIndividu(IndividuSpec p_individu, Damj p_date)
  {
    ObjetChronoPeriodePriseEnCharge periodePec = OutillagePEC.getPeriodePECIndemnisableContenant(p_individu, p_date);
    if (periodePec != null)
    {
      if (p_individu.getListeStatutDSM() == null) {
        p_individu.setListeStatutDSM(recupererListeDSMTravail(p_individu));
      }
      Iterator it = p_individu.getListeStatutDSM().iterator();
      while (it.hasNext())
      {
        PeriodeAvecStatut periodeStatut = (PeriodeAvecStatut)it.next();
        if ((p_date.estApresOuCoincideAvec(periodeStatut.getDateDebut())) && (p_date.estAvantOuCoincideAvec(periodeStatut.getDateFin()))) {
          return periodeStatut.getStatut();
        }
      }
      FiltreET filtre = new FiltreET();
      filtre.ajouterFiltre(new FiltreDemandePourNumeroGamme(1));
      filtre.ajouterFiltre(new FiltreAttributionSurDecisions());
      AttributionSpec attributionArePrecedente = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(p_individu.getChronoDemandeAssurance(), p_date.getDebutMois().lendemain(), filtre);
      if ((attributionArePrecedente != null) && (ProduitAbstrait.estDuType(6, attributionArePrecedente.getProduit()))) {
        return 1;
      }
    }
    return 0;
  }
  
  public static Collection recupererListeDSMTravail(IndividuSpec p_individu)
  {
    List listeDSM = new ArrayList();
    ChronologiePeriodes listePeriodesGAEC = p_individu.getChronoPeriodePasseProfessionnelSansFiltrageDNJ();
    if (listePeriodesGAEC != null)
    {
      Iterator it = listePeriodesGAEC.iterer();
      while (it.hasNext())
      {
        Object periodeGAEC = it.next();
        if ((periodeGAEC instanceof DeclareTravail)) {
          listeDSM.add(periodeGAEC);
        }
      }
    }
    ArrayList listePeriode = new ArrayList();
    for (int i = 0; i < listeDSM.size(); i++)
    {
      DeclareTravail dsm = (DeclareTravail)listeDSM.get(i);
      if ((String.valueOf(61).equals(dsm.getOrigineInfo())) || (String.valueOf(69).equals(dsm.getOrigineInfo()))) {
        listePeriode = traitementDsmSpectacle(listePeriode, dsm);
      } else {
        listePeriode = traitementDsmCasGeneral(listePeriode, dsm);
      }
    }
    return listePeriode;
  }
  
  private static ArrayList traitementDsmSpectacle(ArrayList p_listePeriode, DeclareTravail p_dsm)
  {
    ArrayList nouvelleListe = new ArrayList();
    
    boolean traitementDsm = false;
    boolean dsmAjoute = false;
    Periode periodeDsm = new Periode(p_dsm.getDateDebut().getDebutMois(), p_dsm.getDateFin().getFinMois());
    for (int i = 0; i < p_listePeriode.size(); i++)
    {
      PeriodeAvecStatut periodeStatutExistante = (PeriodeAvecStatut)p_listePeriode.get(i);
      if (periodeStatutExistante.chevauche(periodeDsm))
      {
        traitementDsm = true;
        if (periodeStatutExistante.getStatut() == 1)
        {
          periodeDsm.setDebut(Damj.min(periodeDsm.getDebut(), periodeStatutExistante.getDateDebut()));
          periodeDsm.setFin(Damj.max(periodeDsm.getFin(), periodeStatutExistante.getDateFin()));
        }
        else
        {
          if (periodeStatutExistante.getDateDebut().estAvant(periodeDsm.getDebut()))
          {
            PeriodeAvecStatut periodeStatut = new PeriodeAvecStatut(periodeStatutExistante.getDateDebut(), periodeDsm.getDebut().getFinMoisPrecedent(), periodeStatutExistante.getStatut());
            
            nouvelleListe.add(periodeStatut);
          }
          if (periodeStatutExistante.getDateFin().estApres(periodeDsm.getFin()))
          {
            PeriodeAvecStatut periodeStatut = new PeriodeAvecStatut(periodeDsm.getDebut(), periodeDsm.getFin(), 1);
            nouvelleListe.add(periodeStatut);
            dsmAjoute = true;
            
            periodeStatut = new PeriodeAvecStatut(periodeDsm.getFin().getDebutMoisSuivant(), periodeStatutExistante.getDateFin(), periodeStatutExistante.getStatut());
            
            nouvelleListe.add(periodeStatut);
          }
        }
      }
      else
      {
        if ((traitementDsm) && (!dsmAjoute))
        {
          PeriodeAvecStatut periodeStatut = new PeriodeAvecStatut(periodeDsm.getDebut(), periodeDsm.getFin(), 1);
          nouvelleListe.add(periodeStatut);
          dsmAjoute = true;
        }
        nouvelleListe.add(periodeStatutExistante);
      }
    }
    if (!dsmAjoute)
    {
      PeriodeAvecStatut periodeStatut = new PeriodeAvecStatut(periodeDsm.getDebut(), periodeDsm.getFin(), 1);
      nouvelleListe.add(periodeStatut);
    }
    return nouvelleListe;
  }
  
  private static ArrayList traitementDsmCasGeneral(ArrayList p_listePeriode, DeclareTravail p_dsm)
  {
    ArrayList nouvelleListe = new ArrayList();
    
    boolean ajouterDsm = true;
    boolean traitementDSM = false;
    Periode periodeDsm = new Periode(p_dsm.getDateDebut().getDebutMois(), p_dsm.getDateFin().getFinMois());
    for (int i = 0; (i < p_listePeriode.size()) && (ajouterDsm); i++)
    {
      PeriodeAvecStatut periodeStatutExistante = (PeriodeAvecStatut)p_listePeriode.get(i);
      if (periodeStatutExistante.chevauche(periodeDsm))
      {
        traitementDSM = true;
        if (periodeStatutExistante.getStatut() == 1)
        {
          if (periodeDsm.getDebut().estAvant(periodeStatutExistante.getDateDebut()))
          {
            PeriodeAvecStatut periodeStatut = new PeriodeAvecStatut(periodeDsm.getDebut(), periodeStatutExistante.getDateDebut().getFinMoisPrecedent(), 0);
            
            nouvelleListe.add(periodeStatut);
          }
          if (periodeDsm.getFin().estApres(periodeStatutExistante.getDateFin())) {
            periodeDsm.setDebut(periodeStatutExistante.getDateFin().getDebutMoisSuivant());
          } else {
            ajouterDsm = false;
          }
          nouvelleListe.add(periodeStatutExistante);
        }
        else
        {
          periodeDsm.setDebut(Damj.min(periodeDsm.getDebut(), periodeStatutExistante.getDateDebut()));
          periodeDsm.setFin(Damj.max(periodeDsm.getFin(), periodeStatutExistante.getDateFin()));
        }
      }
      else
      {
        if ((traitementDSM) && (ajouterDsm))
        {
          PeriodeAvecStatut periodeStatut = new PeriodeAvecStatut(periodeDsm.getDebut(), periodeDsm.getFin(), 0);
          
          nouvelleListe.add(periodeStatut);
          ajouterDsm = false;
        }
        nouvelleListe.add(periodeStatutExistante);
      }
    }
    if (ajouterDsm)
    {
      PeriodeAvecStatut periodeStatut = new PeriodeAvecStatut(periodeDsm.getDebut(), periodeDsm.getFin(), 0);
      
      nouvelleListe.add(periodeStatut);
    }
    return nouvelleListe;
  }
}

/* Location:
 * Qualified Name:     DeterminerPopulationIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */