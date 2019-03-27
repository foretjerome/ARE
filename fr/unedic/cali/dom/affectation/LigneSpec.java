package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.util.List;

public abstract interface LigneSpec
  extends Serializable
{
  public static final String ASU_CGE01 = "ASU_CGE01";
  public static final String ASU_SPE02 = "ASU_SPE02";
  public static final String ASU_CSA06 = "ASU_CSA06";
  public static final String ASU_CSR04 = "ASU_CSR04";
  public static final String ASU_MNT09 = "ASU_MNT09";
  public static final String ASU_SSP07 = "ASU_SSP07";
  public static final String ASU_FDS12 = "ASU_FDS12";
  public static final String ASU_CVA10 = "ASU_CVA10";
  public static final String ASU_CAA14 = "ASU_CAA14";
  public static final String ASU_CVE13 = "ASU_CVE13";
  public static final String ASU_EXP03 = "ASU_EXP03";
  public static final String SOL_CGE01 = "SOL_CGE01";
  public static final String SOL_CPA02 = "SOL_CPA02";
  public static final String SOL_AER05 = "SOL_AER05";
  public static final String SOL_ATA06 = "SOL_ATA06";
  public static final String SOL_SUB09 = "SOL_SUB09";
  public static final String RBF_HBT01 = "RBF_HBT01";
  public static final String RBF_TPT02 = "RBF_TPT02";
  public static final String RBF_RTN03 = "RBF_RTN03";
  public static final String RBF_FPO04 = "RBF_FPO04";
  public static final String RBF_MOB07 = "RBF_MOB07";
  public static final String RBF_AGE08 = "RBF_AGE08";
  public static final String FOR_AFF03 = "FOR_AFF03";
  public static final String FOR_RPS02 = "FOR_RPS02";
  public static final String FOR_RFP04 = "FOR_RFP04";
  public static final String INR_CES06 = "INR_CES06";
  public static final String INR_PFM01 = "INR_PFM01";
  public static final String INR_RCE04 = "INR_RCE04";
  public static final String INR_ADR03 = "INR_ADR03";
  public static final String INR_PAR09 = "INR_PAR09";
  public static final String RET_ACO01 = "RET_ACO01";
  public static final String ASU_EUR05 = "ASU_EUR05";
  public static final String ASU_DDM16 = "ASU_DDM16";
  public static final String ASU_MAY17 = "ASU_MAY17";
  public static final String RBF_AIDES = "RBF_AIDES";
  public static final String FOR_CSP05 = "FOR_CSP05";
  public static final String PRR_PRL02 = "PRR_PRL02";
  public static final String PRR_PLF03 = "PRR_PLF03";
  public static final String DEC_CGE01 = "DEC_CGE01";
  
  public abstract void ajouterProduit(ProduitSpec paramProduitSpec);
  
  public abstract void setListeProduits(List<ProduitSpec> paramList);
  
  public abstract List<ProduitSpec> getListeProduits();
  
  public abstract GammeSpec getGamme();
  
  public abstract void setGamme(GammeSpec paramGammeSpec);
  
  public abstract ProduitSpec getProduitActif(Damj paramDamj);
  
  public abstract String getLibelle();
  
  public abstract void setLibelle(String paramString);
  
  public abstract String getNomUnique();
  
  public abstract void setNomUnique(String paramString);
}

/* Location:
 * Qualified Name:     LigneSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */