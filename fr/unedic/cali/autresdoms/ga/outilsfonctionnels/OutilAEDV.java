package fr.unedic.cali.autresdoms.ga.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeIntensite;
import fr.unedic.cali.outilsfonctionnels.DetectionTypeChomage;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;

public final class OutilAEDV
{
  private static final BigDecimal SEUIL_INTENSITE_HORAIRE_HEBDO = new BigDecimal("17");
  private static final BigDecimal SEUIL_INTENSITE_HORAIRE_MENSUEL = new BigDecimal("73.67");
  private static final BigDecimal SEUIL_INTENSITE_HORAIRE_ANNUEL = new BigDecimal("780.54");
  private static final int SEUIL_NB_JOURS_CONTRAT = 8;
  
  public static boolean verificationPresenceAEDV(ActiviteSalarie periodeAct)
  {
    return (estUneAEDVNonLegitime(periodeAct)) && (periodeAct.estUneFct()) && (estIntensiteHoraireSuffisante(periodeAct)) && (estDureeContratSuffisante(periodeAct)) && (!periodeAct.getCollectionOrigineInformationPAS().contains(Integer.valueOf(10))) && (!periodeAct.isEstPeriodeMayotte());
  }
  
  public static boolean verificationPresenceAEDVMayotte(ActiviteSalarie periodeAct)
  {
    return (estUneAEDVNonLegitime(periodeAct)) && (periodeAct.estUneFct()) && (estDureeContratSuffisante(periodeAct)) && (!periodeAct.getCollectionOrigineInformationPAS().contains(Integer.valueOf(10)));
  }
  
  private static boolean estUneAEDVNonLegitime(ActiviteSalarie activiteSalarie)
  {
    return !DetectionTypeChomage.estChomageLegitime(activiteSalarie.getContrat().getCodeMotifFin(), activiteSalarie.getContrat().getContexteDemission());
  }
  
  private static boolean estDureeContratSuffisante(ActiviteSalarie activiteSalarie)
  {
    return activiteSalarie.getDuree() >= 8;
  }
  
  private static boolean estIntensiteHoraireSuffisante(ActiviteSalarie activiteSalarie)
  {
    boolean aLesConditions = false;
    Chronologie listePeriodeIntensite = activiteSalarie.getListePeriodeIntensite();
    if ((listePeriodeIntensite == null) || (listePeriodeIntensite.estVide()))
    {
      aLesConditions = true;
    }
    else
    {
      Iterator<PeriodeIntensite> ite = listePeriodeIntensite.iterer();
      while (listePeriodeIntensite.encoreSuivant())
      {
        PeriodeIntensite periodeIntensite = (PeriodeIntensite)ite.next();
        if ((periodeIntensite.getDateFin().coincideAvec(activiteSalarie.getDateFin())) && (verificationIntensite(periodeIntensite))) {
          aLesConditions = true;
        }
      }
    }
    return aLesConditions;
  }
  
  private static boolean verificationIntensite(PeriodeIntensite periodeIntensite)
  {
    return (estIntensiteHebdoDepassee(periodeIntensite)) || (estIntensiteMensuelDepassee(periodeIntensite)) || (estIntensiteAnnuelDepassee(periodeIntensite));
  }
  
  private static boolean estIntensiteHebdoDepassee(PeriodeIntensite periodeIntensite)
  {
    return (1 == periodeIntensite.getUniteHoraire()) && (periodeIntensite.getHorairesSalarie().compareTo(SEUIL_INTENSITE_HORAIRE_HEBDO) >= 0);
  }
  
  private static boolean estIntensiteMensuelDepassee(PeriodeIntensite periodeIntensite)
  {
    return (3 == periodeIntensite.getUniteHoraire()) && (periodeIntensite.getHorairesSalarie().compareTo(SEUIL_INTENSITE_HORAIRE_MENSUEL) >= 0);
  }
  
  private static boolean estIntensiteAnnuelDepassee(PeriodeIntensite periodeIntensite)
  {
    return (2 == periodeIntensite.getUniteHoraire()) && (periodeIntensite.getHorairesSalarie().compareTo(SEUIL_INTENSITE_HORAIRE_ANNUEL) >= 0);
  }
}

/* Location:
 * Qualified Name:     OutilAEDV
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */