package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ObjetChronoPeriodePriseEnChargeSansFiltre
  extends ObjetChronoPeriodePriseEnCharge
{
  private static final long serialVersionUID = -2335634058751090237L;
  private boolean m_estActualisable;
  public static final String MOTIF_CI_PEC_ENTREE_CIRMA = "29";
  public static final String MOTIF_CI_PEC_ENTREE_CA = "30";
  public static final String MOTIF_CI_PEC_ACCORD_STATUT_REFUGIE = "80";
  public static final String CATEGORIE_PEC = "5";
  public static final String TYPE_PEC = "1";
  public static final String SOUS_TYPE_PEC = "7";
  public static final String CODE_AU_TITRE_PEC = "1";
  public static final String SITUATION_PARTICULIERE_PEC_CA = "CAV";
  public static final String SITUATION_PARTICULIERE_PEC_CIRMA = "RMA";
  public static final String SITUATION_PARTICULIERE_PEC_CAE = "CAE";
  public static final String SITUATION_PARTICULIERE_PEC_CUI_CUN = "CUN";
  public static final String SITUATION_PARTICULIERE_PEC_CUI_CUM = "CUM";
  public static final String SITUATION_PARTICULIERE_PEC_CUI_EAN = "EAN";
  public static final String SITUATION_PARTICULIERE_PEC_CUI_EAP = "EAP";
  public static final String SITUATION_PARTICULIERE_PEC_CUI_EAM = "EAM";
  public static final String TYPE_PEC_ACCRE = "6";
  public static final String SOUS_TYPE_PEC_ACCRE = "3";
  public static final String TYPE_PEC_ADR = "1";
  public static final String SOUS_TYPE_PEC_ADR = "9";
  public static final String TYPE_PEC_ARCE = "1";
  public static final String SOUS_TYPE_PEC_ARCE = "7";
  public static final String SITUATION_EMPLOI_ARCE = "CEN";
  public static final String CODE_AU_TITRE_ARCE = "3";
  public static final String TYPE_PEC_FORMATION = "2";
  public static final String SOUS_TYPE_PEC_FORMATION = "1";
  public static final String TYPE_PEC_EUROPEENNE = "2";
  public static final String SOUS_TYPE_PEC_EUROPEENNE = "7";
  public static final String TYPE_PEC_FNE = "3";
  public static final String SOUS_TYPE_PEC_FNE = "1";
  
  public ObjetChronoPeriodePriseEnChargeSansFiltre() {}
  
  public ObjetChronoPeriodePriseEnChargeSansFiltre(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetChronoPeriodePriseEnChargeSansFiltre(Periode p_periode)
  {
    super(p_periode);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodePriseEnChargeSansFiltre copie = new ObjetChronoPeriodePriseEnChargeSansFiltre();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    ObjetChronoPeriodePriseEnChargeSansFiltre copie = (ObjetChronoPeriodePriseEnChargeSansFiltre)p_copie;
    
    super.copieElements(p_copie);
    
    copie.setEstActualisable(isEstActualisable());
    copie.setSousType(getSousType());
    copie.setTypePec(getTypePec());
  }
  
  public boolean isEstActualisable()
  {
    return m_estActualisable;
  }
  
  public void setEstActualisable(boolean p_estActualisable)
  {
    m_estActualisable = p_estActualisable;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodePriseEnChargeSansFiltre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */