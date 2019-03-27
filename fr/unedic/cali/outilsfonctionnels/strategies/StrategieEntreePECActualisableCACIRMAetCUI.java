package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnChargeSansFiltre;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.Anomalie;
import fr.unedic.cali.outilsfonctionnels.GestionAnomalies;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class StrategieEntreePECActualisableCACIRMAetCUI
  implements StrategiePECCACIRMAetCUISpec
{
  public int mapperTypeContratParticulier(int p_typeContratParticulier)
  {
    int retourType = 0;
    switch (p_typeContratParticulier)
    {
    case 21: 
      retourType = 211;
      break;
    case 22: 
      retourType = 221;
      break;
    default: 
      retourType = p_typeContratParticulier;
    }
    return retourType;
  }
  
  public void ajouterEvenementCA(ChronologiePeriodes p_evenementsRetour, ObjetChronoPeriodePriseEnChargeSansFiltre p_periodePriseEnCharge, Periode p_periodeUT, Damj p_dateDJA) {}
  
  public void ajouterEvenementCIRMA(ChronologiePeriodes p_evenementsRetour, ObjetChronoPeriodePriseEnChargeSansFiltre p_periodePriseEnCharge, Periode p_periodeUT, Damj p_dateDJA) {}
  
  public boolean estActiviteChevauchantPecTypeParticulierPourNeutralisationPFM(ObjetChronoPeriodePriseEnChargeSansFiltre p_periodePriseEnChargeSansFiltre)
  {
    return false;
  }
  
  public void ajouterAnomalieM09(ObjetChronoPeriodePriseEnChargeSansFiltre p_periodePriseEnChargeSansFiltre, Damj p_dateFinUT, IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    if (("5".equals(p_periodePriseEnChargeSansFiltre.getCategorie())) && ("1".equals(p_periodePriseEnChargeSansFiltre.getTypePec())) && ("7".equals(p_periodePriseEnChargeSansFiltre.getSousType())) && (!p_periodePriseEnChargeSansFiltre.isEstActualisable()))
    {
      boolean ajouterAnomalie = false;
      if (("1".equals(p_periodePriseEnChargeSansFiltre.getCodeAuTitre())) && (("RMA".equals(p_periodePriseEnChargeSansFiltre.getSituationEmploi())) || ("CAV".equals(p_periodePriseEnChargeSansFiltre.getSituationEmploi())))) {
        ajouterAnomalie = true;
      } else if (("CUN".equals(p_periodePriseEnChargeSansFiltre.getSituationEmploi())) || ("CUM".equals(p_periodePriseEnChargeSansFiltre.getSituationEmploi())) || ("EAN".equals(p_periodePriseEnChargeSansFiltre.getSituationEmploi())) || ("EAP".equals(p_periodePriseEnChargeSansFiltre.getSituationEmploi())) || ("EAM".equals(p_periodePriseEnChargeSansFiltre.getSituationEmploi()))) {
        ajouterAnomalie = true;
      }
      if (ajouterAnomalie) {
        GestionAnomalies.ajouteAnomalie(new Anomalie("M09", p_dateFinUT, ""), p_individu);
      }
    }
  }
}

/* Location:
 * Qualified Name:     StrategieEntreePECActualisableCACIRMAetCUI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */