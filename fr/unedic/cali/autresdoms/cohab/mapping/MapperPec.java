package fr.unedic.cali.autresdoms.cohab.mapping;

import fr.unedic.cali.autresdoms.cohab.dom.IndividuCohabAbstrait;
import fr.unedic.cali.autresdoms.cohab.dom.LirePecResultat;
import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnChargeSansFiltre;
import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.spec.PeriodePriseEnChargeSpec;
import java.util.Collection;
import java.util.Iterator;

public class MapperPec
{
  public static void mapperPec(IndividuCohabAbstrait individu, Collection listePec)
  {
    LirePecResultat resultat = new LirePecResultat();
    Iterator iterateur;
    if (listePec != null) {
      for (iterateur = listePec.iterator(); iterateur.hasNext();)
      {
        PeriodePriseEnChargeSpec periodePecCojac = (PeriodePriseEnChargeSpec)iterateur.next();
        ObjetChronoPeriodePriseEnCharge periodePecCali = new ObjetChronoPeriodePriseEnCharge(periodePecCojac.getDateDebut(), periodePecCojac.getDateFin());
        periodePecCali.setMotifAnnulation(periodePecCojac.getMotifAnnulation());
        periodePecCali.setCategorie(periodePecCojac.getCategorie());
        periodePecCali.setIdentifiantPec(periodePecCojac.getIdentifiantPec());
        periodePecCali.setAleIndividu(periodePecCojac.getAleIndividu());
        periodePecCali.setDateDispenseRechercheEmploi(periodePecCojac.getDateDispense());
        
        periodePecCali.setTypePec(periodePecCojac.getTypePec());
        periodePecCali.setSousType(periodePecCojac.getSousTypePec());
        periodePecCali.setDemandeurEmploi(periodePecCojac.getDemandeurEmploi());
        periodePecCali.setActualise(periodePecCojac.getActualise());
        
        periodePecCali.setCodeAuTitre(periodePecCojac.getCodeAuTitre());
        
        periodePecCali.setCodePays(periodePecCojac.getCodePays());
        periodePecCali.setContexteEESSI(periodePecCojac.getContexteEESSI());
        periodePecCali.setContextePECNonIndemnisable(periodePecCojac.getContextePECNonIndemnisable());
        
        periodePecCali.setNumeroAffiliation(periodePecCojac.getNumeroAffiliation());
        periodePecCali.setNumeroSiren(periodePecCojac.getNumeroSiren());
        periodePecCali.setIdentifiantBne(periodePecCojac.getIdentifiantBne());
        
        periodePecCali.setSituationEmploi(periodePecCojac.getSituationEmploi());
        
        resultat.ajouterPeriodePriseEnCharge(periodePecCali);
      }
    }
    individu.setChronologiePecFusionneesFinCI(resultat.getChronoPeriodesPriseEnCharge());
  }
  
  public static void mapperPecSansFiltre(IndividuCohabAbstrait individu, Collection listePec)
  {
    LirePecResultat resultat = new LirePecResultat();
    Iterator iterateur;
    if (listePec != null) {
      for (iterateur = listePec.iterator(); iterateur.hasNext();)
      {
        PeriodePriseEnChargeSpec periodePecCojac = (PeriodePriseEnChargeSpec)iterateur.next();
        ObjetChronoPeriodePriseEnChargeSansFiltre periodePecCali = new ObjetChronoPeriodePriseEnChargeSansFiltre(periodePecCojac.getDateDebut(), periodePecCojac.getDateFin());
        periodePecCali.setMotifAnnulation(periodePecCojac.getMotifAnnulation());
        periodePecCali.setCategorie(periodePecCojac.getCategorie());
        periodePecCali.setIdentifiantPec(periodePecCojac.getIdentifiantPec());
        periodePecCali.setAleIndividu(periodePecCojac.getAleIndividu());
        periodePecCali.setDateDispenseRechercheEmploi(periodePecCojac.getDateDispense());
        periodePecCali.setEstDispenseRechercheEmploi(periodePecCojac.isDispense());
        periodePecCali.setEstCes(periodePecCojac.isCes());
        periodePecCali.setTypePec(periodePecCojac.getTypePec());
        periodePecCali.setSousType(periodePecCojac.getSousTypePec());
        periodePecCali.setEstActualisable(periodePecCojac.isActualisable());
        periodePecCali.setSituationEmploi(periodePecCojac.getSituationEmploi());
        periodePecCali.setCodeAuTitre(periodePecCojac.getCodeAuTitre());
        periodePecCali.setDemandeurEmploi(periodePecCojac.getDemandeurEmploi());
        periodePecCali.setActualise(periodePecCojac.getActualise());
        periodePecCali.setContexteEESSI(periodePecCojac.getContexteEESSI());
        periodePecCali.setCodePays(periodePecCojac.getCodePays());
        periodePecCali.setContextePECNonIndemnisable(periodePecCojac.getContextePECNonIndemnisable());
        
        periodePecCali.setNumeroAffiliation(periodePecCojac.getNumeroAffiliation());
        periodePecCali.setNumeroSiren(periodePecCojac.getNumeroSiren());
        periodePecCali.setIdentifiantBne(periodePecCojac.getIdentifiantBne());
        
        periodePecCali.setSituationEmploi(periodePecCojac.getSituationEmploi());
        
        resultat.ajouterPeriodePriseEnCharge(periodePecCali);
      }
    }
    individu.setChronologiePecNonFusionneesFinCI(resultat.getChronoPeriodesPriseEnCharge());
  }
  
  public static ObjetChronoPeriodePriseEnCharge rechercheEtMappingUnePec(int idPec, Collection listePec)
  {
    ObjetChronoPeriodePriseEnCharge periodePecCali = null;
    Iterator iterateur = listePec.iterator();
    while (iterateur.hasNext())
    {
      PeriodePriseEnChargeSpec periodePecCojac = (PeriodePriseEnChargeSpec)iterateur.next();
      if (periodePecCojac.getIdentifiantPec() == idPec)
      {
        periodePecCali = mapperUnePec(periodePecCojac);
        break;
      }
    }
    return periodePecCali;
  }
  
  private static ObjetChronoPeriodePriseEnCharge mapperUnePec(PeriodePriseEnChargeSpec periodePecCojac)
  {
    ObjetChronoPeriodePriseEnCharge periodePecCali = new ObjetChronoPeriodePriseEnCharge(periodePecCojac.getDateDebut(), periodePecCojac.getDateFin());
    periodePecCali.setMotifAnnulation(periodePecCojac.getMotifAnnulation());
    periodePecCali.setCategorie(periodePecCojac.getCategorie());
    periodePecCali.setIdentifiantPec(periodePecCojac.getIdentifiantPec());
    periodePecCali.setAleIndividu(periodePecCojac.getAleIndividu());
    periodePecCali.setDateDispenseRechercheEmploi(null);
    
    return periodePecCali;
  }
}

/* Location:
 * Qualified Name:     MapperPec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */