package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeGaec;
import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreInvestigationFrauduleuse;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreNegation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ChampsPeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListePeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.RetourLireListePeriodes;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.OutilOptimisationChronologie;
import fr.unedic.util.temps.Temporel;
import java.util.Iterator;

public class MapperGa
{
  public static LireListePeriodeResultat mapperPeriodes(RetourLireListePeriodes p_donneesIn)
    throws CoucheLogiqueException
  {
    LireListePeriodeResultat resultat = new LireListePeriodeResultat();
    
    ListePeriodeActivite listePeriodeActiviteGa = p_donneesIn.getListePeriodeActivite();
    ChronologiePeriodes listePeriodeActiviteCali = mapperListePeriodeActiviteGa(listePeriodeActiviteGa);
    
    ChronologiePeriodes listePeriodePasseProfessionnelEcartees = contruireChronologiePasseProfessionnelEcartes(listePeriodeActiviteCali);
    ChronologiePeriodes listePeriodePasseProfessionnelCali = contruireChronologiePasseProfessionnel(listePeriodeActiviteCali);
    
    resultat.setChronoPeriodesPasseProfessionnelEcartees(listePeriodePasseProfessionnelEcartees);
    resultat.setChronoPeriodesPasseProfessionnel(listePeriodePasseProfessionnelCali);
    return resultat;
  }
  
  private static FiltreTemporel determinerFiltrePeriodesAEcarter()
  {
    FiltreInvestigationFrauduleuse filtre = new FiltreInvestigationFrauduleuse();
    
    filtre.ajouterStatusInvestigationFrauduleuse(4);
    return filtre;
  }
  
  private static ChronologiePeriodes contruireChronologiePasseProfessionnel(ChronologiePeriodes p_chronologie)
  {
    if (p_chronologie != null) {
      return (ChronologiePeriodes)p_chronologie.copier(new FiltreNegation(determinerFiltrePeriodesAEcarter()));
    }
    return null;
  }
  
  private static ChronologiePeriodes contruireChronologiePasseProfessionnelEcartes(ChronologiePeriodes p_chronologie)
  {
    if (p_chronologie != null) {
      return (ChronologiePeriodes)p_chronologie.copier(determinerFiltrePeriodesAEcarter());
    }
    return null;
  }
  
  public static ChronologiePeriodes mapperListePeriodeActiviteGa(ListePeriodeActivite p_listePeriodeActiviteGa)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes listePeriodeActiviteCali = new ChronologiePeriodes();
    OutilOptimisationChronologie outilOptimisationChronologie = new OutilOptimisationChronologie(listePeriodeActiviteCali);
    if (p_listePeriodeActiviteGa != null)
    {
      int nbPeriodeActivite = p_listePeriodeActiviteGa.getNbListPeriodeActivite();
      for (int i = 0; i < nbPeriodeActivite; i++)
      {
        PeriodeActivite periodeActiviteGa = p_listePeriodeActiviteGa.getListePeriodeActivite(i);
        
        ChronologiePeriodes listeActivitesCali = mapperPeriodeActiviteGa(periodeActiviteGa);
        
        listeActivitesCali.iterer();
        while ((listeActivitesCali != null) && (listeActivitesCali.encoreSuivant()))
        {
          Temporel tempo = listeActivitesCali.elementSuivant();
          
          outilOptimisationChronologie.ajouter(tempo);
        }
      }
    }
    return (ChronologiePeriodes)outilOptimisationChronologie.getChronologieTriee();
  }
  
  private static ChronologiePeriodes mapperPeriodeActiviteGa(PeriodeActivite p_periodeActiviteGa)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes listePeriodeActiviteCali = new ChronologiePeriodes();
    
    ChampsPeriodeActivite champsPeriodeActivite = p_periodeActiviteGa.getChampsPeriodeActivite();
    
    String typePeriode = champsPeriodeActivite.getTypePeriode();
    if (typePeriode.equals("9"))
    {
      listePeriodeActiviteCali.ajouter(MapperContratTravail.mapper(p_periodeActiviteGa));
    }
    else if (typePeriode.equals("7"))
    {
      listePeriodeActiviteCali.ajouter(MapperBulletinSalaire.mapper(p_periodeActiviteGa));
    }
    else if (typePeriode.equals("5"))
    {
      listePeriodeActiviteCali.ajouter(MapperActionFormation.mapper(p_periodeActiviteGa));
    }
    else if ((typePeriode.equals("10")) || (typePeriode.equals("8")))
    {
      PeriodeGaec periodeActiviteCali = MapperEvenementPersonnel.mapperEvenementPersonnel(p_periodeActiviteGa);
      if (periodeActiviteCali != null) {
        listePeriodeActiviteCali.ajouter(periodeActiviteCali);
      }
    }
    else if (typePeriode.equals("6"))
    {
      PeriodeGaec periodeActiviteCali = MapperFormationNonIndemnisable.mapper(p_periodeActiviteGa);
      listePeriodeActiviteCali.ajouter(periodeActiviteCali);
    }
    else if ((typePeriode.equals("11")) || (typePeriode.equals("12")) || (typePeriode.equals("13")) || (typePeriode.equals("20")) || (typePeriode.equals("21")))
    {
      PeriodeGaec periodeActiviteCali = MapperDsm.mapper(p_periodeActiviteGa);
      if (periodeActiviteCali != null) {
        listePeriodeActiviteCali.ajouter(periodeActiviteCali);
      }
    }
    else if (typePeriode.equals("17"))
    {
      PeriodeGaec periodeActiviteCali = MapperPans.mapperPans(p_periodeActiviteGa);
      if (periodeActiviteCali != null) {
        listePeriodeActiviteCali.ajouter(periodeActiviteCali);
      }
    }
    else if (typePeriode.equals("18"))
    {
      PeriodeGaec periodeActiviteCali = MapperPans.mapperPansNonInstallee(p_periodeActiviteGa);
      if (periodeActiviteCali != null) {
        listePeriodeActiviteCali.ajouter(periodeActiviteCali);
      }
    }
    else if (typePeriode.equals("16"))
    {
      listePeriodeActiviteCali.ajouter(MapperChequeEmploiService.mapper(p_periodeActiviteGa));
    }
    for (Iterator iter = listePeriodeActiviteCali.iterer(); iter.hasNext();)
    {
      PeriodeGaecSpec activiteSalarie = (PeriodeGaecSpec)iter.next();
      
      activiteSalarie.setDateConnaissanceInfo(champsPeriodeActivite.getDateConnaissanceInfo());
      if (champsPeriodeActivite.getMigree() != null) {
        activiteSalarie.setEstMigree(champsPeriodeActivite.getMigree().booleanValue());
      }
      activiteSalarie.setIncoherencePeriode(champsPeriodeActivite.getIncoherencePeriode());
    }
    return listePeriodeActiviteCali;
  }
}

/* Location:
 * Qualified Name:     MapperGa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */