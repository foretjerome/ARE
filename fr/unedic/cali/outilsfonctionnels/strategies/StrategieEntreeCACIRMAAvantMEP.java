package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnChargeSansFiltre;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementEntreeCA;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementEntreeCIRMA;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class StrategieEntreeCACIRMAAvantMEP
  implements StrategiePECCACIRMAetCUISpec
{
  public int mapperTypeContratParticulier(int p_typeContratParticulier)
  {
    int retourType = 0;
    switch (p_typeContratParticulier)
    {
    case 21: 
      retourType = 21;
      break;
    case 22: 
      retourType = 22;
      break;
    default: 
      retourType = p_typeContratParticulier;
    }
    return retourType;
  }
  
  public void ajouterEvenementCA(ChronologiePeriodes p_evenementsRetour, ObjetChronoPeriodePriseEnChargeSansFiltre p_periodePriseEnCharge, Periode p_periodeUT, Damj p_dateDJA)
  {
    PeriodeEvenementEntreeCA evenementCA = new PeriodeEvenementEntreeCA(p_periodePriseEnCharge.getDateDebut(), p_periodePriseEnCharge.getDateFin());
    p_evenementsRetour.ajouter(evenementCA);
  }
  
  public void ajouterEvenementCIRMA(ChronologiePeriodes p_evenementsRetour, ObjetChronoPeriodePriseEnChargeSansFiltre p_periodePriseEnCharge, Periode p_periodeUT, Damj p_dateDJA)
  {
    PeriodeEvenementEntreeCIRMA evenementCIRMA = new PeriodeEvenementEntreeCIRMA(p_periodePriseEnCharge.getDateDebut(), p_periodePriseEnCharge.getDateFin());
    p_evenementsRetour.ajouter(evenementCIRMA);
  }
  
  public boolean estActiviteChevauchantPecTypeParticulierPourNeutralisationPFM(ObjetChronoPeriodePriseEnChargeSansFiltre p_periodePriseEnChargeSansFiltre)
  {
    if ((p_periodePriseEnChargeSansFiltre.getSituationEmploi().equals("CAV")) || (p_periodePriseEnChargeSansFiltre.getSituationEmploi().equals("RMA"))) {
      return true;
    }
    return false;
  }
  
  public void ajouterAnomalieM09(ObjetChronoPeriodePriseEnChargeSansFiltre p_periodePriseEnChargeSansFiltre, Damj p_dateFinUT, IndividuSpec p_individu)
    throws CoucheLogiqueException
  {}
}

/* Location:
 * Qualified Name:     StrategieEntreeCACIRMAAvantMEP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */