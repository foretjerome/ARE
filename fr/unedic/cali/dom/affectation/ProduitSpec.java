package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.io.Serializable;
import java.util.List;

public abstract interface ProduitSpec
  extends FacadeLiquidationProduitSpec, Serializable
{
  public static final int TYPE_INCONNU = -1;
  public static final int TYPE_ASU_CRP = 1;
  public static final int TYPE_ASU_CSP = 2;
  public static final int TYPE_SOL_ASS = 3;
  public static final int TYPE_SOL_ATS = 4;
  public static final int TYPE_ASU_ARE = 5;
  public static final int TYPE_ASU_SPECTACLE = 6;
  public static final int TYPE_ASU_PMVS = 7;
  public static final int TYPE_ASU_RECHARGEMENT = 8;
  public static final int CODE_ASU_CGE01_02 = 1;
  public static final int CODE_FOR_AFF03_01 = 2;
  public static final int CODE_ASU_SPE02_01 = 3;
  public static final int CODE_RBF_HBT01_01 = 4;
  public static final int CODE_RBF_TPT02_01 = 5;
  public static final int CODE_RBF_RTN03_01 = 6;
  public static final int CODE_RBF_FPO04_01 = 7;
  public static final int CODE_ASU_CSA06_01 = 8;
  public static final int CODE_SOL_CGE01_01 = 9;
  public static final int CODE_SOL_CPA02_01 = 10;
  public static final int CODE_FOR_RPS02_01 = 11;
  public static final int CODE_SOL_AER05_01 = 12;
  public static final int CODE_ASU_CGE01_03 = 13;
  public static final int CODE_ASU_CSA06_02 = 14;
  public static final int CODE_ASU_MNT09_01 = 15;
  public static final int CODE_INR_CES01_01 = 16;
  public static final int CODE_INR_PFM01_01 = 17;
  public static final int CODE_INR_RCE04_01 = 18;
  public static final int CODE_ASU_CSR04_01 = 19;
  public static final int CODE_ASU_SPE02_03 = 20;
  public static final int CODE_RBF_HBT01_02 = 24;
  public static final int CODE_RBF_TPT02_02 = 25;
  public static final int CODE_RBF_RTN03_02 = 26;
  public static final int CODE_ASU_SSP07_03 = 27;
  public static final int CODE_ASU_FDS12_01 = 28;
  public static final int CODE_ASU_FDS12_02 = 29;
  public static final int CODE_SOL_ATA06_01 = 30;
  public static final int CODE_ASU_CGE01_04 = 31;
  public static final int CODE_ASU_CSA06_03 = 32;
  public static final int CODE_ASU_CSR04_02 = 33;
  public static final int CODE_FOR_RFP04_01 = 34;
  public static final int CODE_RBF_FPO04_02 = 35;
  public static final int CODE_ASU_CVA10_01 = 36;
  public static final int CODE_ASU_CAA14_01 = 37;
  public static final int CODE_INR_ADR03_02 = 38;
  public static final int CODE_ASU_CVE13_01 = 39;
  public static final int CODE_SOL_SUB09_01 = 40;
  public static final int CODE_RET_ACO01_01 = 41;
  public static final int CODE_ASU_EUR05_01 = 42;
  public static final int CODE_ASU_DDM16_01 = 43;
  public static final int CODE_PRR_PRL02_01 = 44;
  public static final int CODE_ASU_EXP03_01 = 45;
  public static final int CODE_FOR_AFF03_03 = 47;
  public static final int CODE_PRR_PLF03_01 = 46;
  public static final int CODE_ASU_CGE01_05 = 48;
  public static final int CODE_ASU_CSA06_04 = 49;
  public static final int CODE_ASU_CAA14_02 = 50;
  public static final int CODE_ASU_CVA10_02 = 51;
  public static final int CODE_SOL_AER05_02 = 52;
  public static final int CODE_DEC_CGE01_01 = 53;
  public static final int CODE_ASU_MAY17_02 = 54;
  public static final int CODE_SOL_AER05_03 = 55;
  public static final int CODE_RBF_MOB07_01 = 56;
  public static final int CODE_RBF_AGE08_01 = 57;
  public static final int CODE_RBF_AIDES_01 = 58;
  public static final int CODE_FOR_CSP05_01 = 59;
  public static final int CODE_ASU_CGE01_06 = 60;
  public static final int CODE_ASU_CSA06_05 = 61;
  public static final int CODE_ASU_CGE01_6B = 62;
  public static final int CODE_ASU_CSA06_5B = 63;
  public static final int CODE_ASU_SPE02_04 = 64;
  public static final int CODE_ASU_SSP07_04 = 65;
  public static final int CODE_ASU_CAA14_03 = 66;
  public static final int CODE_ASU_CVA10_03 = 67;
  public static final int CODE_INR_PAR09_01 = 68;
  public static final int CODE_SOL_AER05_04 = 69;
  public static final int CODE_ASU_MAY17_03 = 70;
  public static final int CODE_ASU_SPE02_05 = 71;
  public static final int CODE_ASU_CGE01_07 = 72;
  public static final int CODE_ASU_CSA06_06 = 73;
  public static final int CODE_ASU_SPE02_06 = 74;
  public static final int CODE_ASU_SSP07_05 = 75;
  public static final int CODE_ASU_FDS12_03 = 76;
  public static final int CODE_RBF_MOB07_01_DEROGATOIRE = 9999;
  public static final int CODE_RBF_MOB07_01_TRANSPORT = 9998;
  public static final int CODE_RBF_MOB07_01_HEBERGEMENT = 9997;
  public static final int CODE_RBF_MOB07_01_RESTAURATION = 9996;
  public static final String NOM_ASU_CGE01_02 = "ASU_CGE01_02";
  public static final String NOM_ASU_CGE01_03 = "ASU_CGE01_03";
  public static final String NOM_ASU_SPE02_01 = "ASU_SPE02_01";
  public static final String NOM_ASU_SPE02_03 = "ASU_SPE02_03";
  public static final String NOM_ASU_SPE02_04 = "ASU_SPE02_04";
  public static final String NOM_ASU_SPE02_05 = "ASU_SPE02_05";
  public static final String NOM_ASU_SPE02_06 = "ASU_SPE02_06";
  public static final String NOM_ASU_CSA06_01 = "ASU_CSA06_01";
  public static final String NOM_ASU_CSA06_02 = "ASU_CSA06_02";
  public static final String NOM_ASU_MNT09_01 = "ASU_MNT09_01";
  public static final String NOM_ASU_CSR04_01 = "ASU_CSR04_01";
  public static final String NOM_ASU_SSP07_03 = "ASU_SSP07_03";
  public static final String NOM_ASU_SSP07_04 = "ASU_SSP07_04";
  public static final String NOM_ASU_SSP07_05 = "ASU_SSP07_05";
  public static final String NOM_ASU_FDS12_01 = "ASU_FDS12_01";
  public static final String NOM_ASU_FDS12_02 = "ASU_FDS12_02";
  public static final String NOM_ASU_FDS12_03 = "ASU_FDS12_03";
  public static final String NOM_ASU_CGE01_04 = "ASU_CGE01_04";
  public static final String NOM_ASU_CSA06_03 = "ASU_CSA06_03";
  public static final String NOM_ASU_CSR04_02 = "ASU_CSR04_02";
  public static final String NOM_ASU_CVA10_01 = "ASU_CVA10_01";
  public static final String NOM_ASU_CAA14_01 = "ASU_CAA14_01";
  public static final String NOM_ASU_CVE13_01 = "ASU_CVE13_01";
  public static final String NOM_ASU_EUR05_01 = "ASU_EUR05_01";
  public static final String NOM_ASU_DDM16_01 = "ASU_DDM16_01";
  public static final String NOM_ASU_EXP03_01 = "ASU_EXP03_01";
  public static final String NOM_ASU_CGE01_05 = "ASU_CGE01_05";
  public static final String NOM_ASU_CSA06_04 = "ASU_CSA06_04";
  public static final String NOM_ASU_CVA10_02 = "ASU_CVA10_02";
  public static final String NOM_ASU_CAA14_02 = "ASU_CAA14_02";
  public static final String NOM_ASU_CVA10_03 = "ASU_CVA10_03";
  public static final String NOM_ASU_CAA14_03 = "ASU_CAA14_03";
  public static final String NOM_ASU_MAY17_02 = "ASU_MAY17_02";
  public static final String NOM_ASU_MAY17_03 = "ASU_MAY17_03";
  public static final String NOM_ASU_CGE01_06 = "ASU_CGE01_06";
  public static final String NOM_ASU_CGE01_6B = "ASU_CGE01_6B";
  public static final String NOM_ASU_CGE01_07 = "ASU_CGE01_07";
  public static final String NOM_ASU_CSA06_05 = "ASU_CSA06_05";
  public static final String NOM_ASU_CSA06_5B = "ASU_CSA06_5B";
  public static final String NOM_ASU_CSA06_06 = "ASU_CSA06_06";
  public static final String NOM_SOL_CGE01_01 = "SOL_CGE01_01";
  public static final String NOM_SOL_ATA06_01 = "SOL_ATA06_01";
  public static final String NOM_SOL_CPA02_01 = "SOL_CPA02_01";
  public static final String NOM_SOL_AER05_01 = "SOL_AER05_01";
  public static final String NOM_SOL_AER05_02 = "SOL_AER05_02";
  public static final String NOM_SOL_AER05_03 = "SOL_AER05_03";
  public static final String NOM_SOL_AER05_04 = "SOL_AER05_04";
  public static final String NOM_SOL_SUB09_01 = "SOL_SUB09_01";
  public static final String NOM_RBF_HBT01_01 = "RBF_HBT01_01";
  public static final String NOM_RBF_TPT02_01 = "RBF_TPT02_01";
  public static final String NOM_RBF_RTN03_01 = "RBF_RTN03_01";
  public static final String NOM_RBF_FPO04_01 = "RBF_FPO04_01";
  public static final String NOM_RBF_FPO04_02 = "RBF_FPO04_02";
  public static final String NOM_RBF_HBT01_02 = "RBF_HBT01_02";
  public static final String NOM_RBF_TPT02_02 = "RBF_TPT02_02";
  public static final String NOM_RBF_RTN03_02 = "RBF_RTN03_02";
  public static final String NOM_RBF_MOB07_01 = "RBF_MOB07_01";
  public static final String NOM_RBF_AGE08_01 = "RBF_AGE08_01";
  public static final String NOM_RBF_AIDES_01 = "RBF_AIDES_01";
  public static final String NOM_RBF_MOB07_01_DEROGATOIRE = "RBF_MOB07_01_DE";
  public static final String NOM_RBF_MOB07_01_TRANSPORT = "RBF_MOB07_01_TR";
  public static final String NOM_RBF_MOB07_01_HEBERGEMENT = "RBF_MOB07_01_HE";
  public static final String NOM_RBF_MOB07_01_RESTAURATION = "RBF_MOB07_01_RE";
  public static final String NOM_FOR_AFF03_01 = "FOR_AFF03_01";
  public static final String NOM_FOR_RPS02_01 = "FOR_RPS02_01";
  public static final String NOM_FOR_RFP04_01 = "FOR_RFP04_01";
  public static final String NOM_FOR_AFF03_03 = "FOR_AFF03_03";
  public static final String NOM_FOR_CSP05_01 = "FOR_CSP05_01";
  public static final String NOM_INR_CES06_01 = "INR_CES06_01";
  public static final String NOM_INR_PFM01_01 = "INR_PFM01_01";
  public static final String NOM_INR_RCE04_01 = "INR_RCE04_01";
  public static final String NOM_INR_PAR09_01 = "INR_PAR09_01";
  public static final String NOM_INR_ADR03_02 = "INR_ADR03_02";
  public static final String NOM_RET_ACO01_01 = "RET_ACO01_01";
  public static final String NOM_PRR_PRL02_01 = "PRR_PRL02_01";
  public static final String NOM_PRR_PLF03_01 = "PRR_PLF03_01";
  public static final String NOM_DEC_CGE01_01 = "DEC_CGE01_01";
  public static final int TYPE_PAIEMENT_PERIODIQUE = 0;
  public static final int TYPE_PAIEMENT_PONCTUEL = 1;
  
  public abstract boolean estActif(Damj paramDamj);
  
  public abstract String getLibelleCourt();
  
  public abstract String getLibelleLong();
  
  public abstract LigneSpec getLigne();
  
  public abstract String getNom();
  
  public abstract Periode getPeriodeValidite();
  
  public abstract void setLigne(LigneSpec paramLigneSpec);
  
  public abstract void setLibelleCourt(String paramString);
  
  public abstract void setLibelleLong(String paramString);
  
  public abstract void setPeriodeValidite(Periode paramPeriode);
  
  public abstract void ajouterReglement(Reglement paramReglement);
  
  public abstract List getListeReglements();
  
  public abstract boolean contientReglement(Reglement paramReglement);
  
  public abstract boolean contientReglement(String paramString);
  
  public abstract Reglement getReglement(String paramString);
  
  public abstract void setListeReglements(List paramList);
  
  public abstract int getCode();
  
  public abstract void setCode(int paramInt);
  
  public abstract String getNomUnique();
  
  public abstract void setNomUnique(String paramString);
  
  public abstract int getTypePaiement();
  
  public abstract boolean estIdentiqueAuProduit(ProduitSpec paramProduitSpec);
  
  public abstract boolean estCompetenceFinanciereSecteurPublic(AttributionSpec paramAttributionSpec);
  
  public abstract void ajouterElementForcable(ElementForcable paramElementForcable);
  
  public abstract List getListeElementsForcables();
  
  public abstract boolean contientElementForcable(ElementForcable paramElementForcable);
  
  public abstract ElementForcable getElementForcable(String paramString);
}

/* Location:
 * Qualified Name:     ProduitSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */