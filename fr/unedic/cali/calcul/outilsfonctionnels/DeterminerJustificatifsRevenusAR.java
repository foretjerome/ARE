package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.calcul.dom.EvenementParametre;
import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.cali.calcul.parametres.ParametresIndemnisation;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.fabriques.FabriqueStrategieJustificatifsRevenusAR;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieJustificatifsRevenusARSpec;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class DeterminerJustificatifsRevenusAR
{
  public static final BigDecimal COEF_PLAFOND_HEURES_BS = new BigDecimal("5.6");
  private static List<String> produitsFiltre = new ArrayList();
  
  static
  {
    produitsFiltre.add("ASU_SPE02_01");
    produitsFiltre.add("ASU_SPE02_03");
    produitsFiltre.add("ASU_SPE02_04");
    produitsFiltre.add("ASU_SPE02_05");
    produitsFiltre.add("ASU_SPE02_06");
    produitsFiltre.add("ASU_SSP07_03");
    produitsFiltre.add("ASU_SSP07_04");
    produitsFiltre.add("ASU_SSP07_05");
    produitsFiltre.add("ASU_FDS12_01");
    produitsFiltre.add("ASU_FDS12_02");
    produitsFiltre.add("ASU_FDS12_03");
  }
  
  public static boolean verifierConditionsRevenus(PeriodeActiviteEmploiCalcul paec, AttributionSpec attribution)
  {
    boolean conditionsRemplies = false;
    
    CritereStrategie critereStrategie = new CritereStrategie();
    critereStrategie.setDatePivot(paec.getDateDebut());
    if ((attribution != null) && (estUnProduitSpectacle(attribution))) {
      critereStrategie.setProduitSpectacle(true);
    }
    StrategieJustificatifsRevenusARSpec strategieJustificatifsRevenusARCourante = (StrategieJustificatifsRevenusARSpec)FabriqueStrategieJustificatifsRevenusAR.getInstance().getStrategie(critereStrategie);
    
    conditionsRemplies = strategieJustificatifsRevenusARCourante.verifierConditionsRevenus(paec);
    
    return conditionsRemplies;
  }
  
  public static void traitementRevenusBS(ChronologiePeriodes periodesEmploi, Damj dateCalculSmicHoraire, AttributionSpec attribution)
  {
    periodesEmploi.iterer();
    while (periodesEmploi.encoreSuivant())
    {
      ObjetChronoPeriodeCalcul periodeEmploiCourante = (ObjetChronoPeriodeCalcul)periodesEmploi.elementSuivant();
      if (((periodeEmploiCourante instanceof PeriodeActiviteEmploiCalcul)) && 
        (verifierConditionsRevenus((PeriodeActiviteEmploiCalcul)periodeEmploiCourante, attribution)))
      {
        PeriodeActiviteEmploiCalcul paecCourante = (PeriodeActiviteEmploiCalcul)periodeEmploiCourante;
        BigDecimal nbHeuresBS = paecCourante.getGain().divide(ParametresIndemnisation.getParametresIndemnisation().getElementActif(dateCalculSmicHoraire).getSmicHoraire(), 4);
        
        BigDecimal plafondHeures = new BigDecimal(paecCourante.getDuree()).multiply(COEF_PLAFOND_HEURES_BS);
        if (nbHeuresBS.compareTo(plafondHeures) > 0) {
          paecCourante.setNombreHeures(plafondHeures);
        } else {
          paecCourante.setNombreHeures(nbHeuresBS);
        }
      }
    }
  }
  
  private static boolean estUnProduitSpectacle(AttributionSpec attribution)
  {
    return produitsFiltre.contains(attribution.getProduit().getNom());
  }
}

/* Location:
 * Qualified Name:     DeterminerJustificatifsRevenusAR
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */