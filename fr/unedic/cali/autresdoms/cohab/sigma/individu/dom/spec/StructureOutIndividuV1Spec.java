package fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.spec;

import fr.unedic.util.temps.Damj;

public abstract interface StructureOutIndividuV1Spec
{
  public static final String VALEUR_FBMIG_INDIVIDU_MIGRE = "M";
  public static final String VALEUR_FBMIG_INDIVIDU_MIGRE_EN_ANO_CCS = "P";
  public static final String VALEUR_FBMIG_AUTRE_MIGRE = "V";
  
  public abstract String getNom();
  
  public abstract void setNom(String paramString);
  
  public abstract String getNomMarital();
  
  public abstract void setNomMarital(String paramString);
  
  public abstract String getPrenom();
  
  public abstract void setPrenom(String paramString);
  
  public abstract Damj getDateNaissance();
  
  public abstract void setDateNaissance(Damj paramDamj);
  
  public abstract Damj getDateLiquidationRetraite();
  
  public abstract void setDateLiquidationRetraite(Damj paramDamj);
  
  public abstract Damj getDateRetraiteAnticipe();
  
  public abstract void setDateRetraiteAnticipe(Damj paramDamj);
  
  public abstract String getMotifRetraiteAnticipe();
  
  public abstract void setMotifRetraiteAnticipe(String paramString);
  
  public abstract Damj getDateAcquisitionTrimestres();
  
  public abstract void setDateAcquisitionTrimestres(Damj paramDamj);
  
  public abstract int getNombreTrimestre();
  
  public abstract void setNombreTrimestre(int paramInt);
  
  public abstract String getEtatCivil();
  
  public abstract void setEtatCivil(String paramString);
  
  public abstract boolean isBeneficiaireSapa();
  
  public abstract void setBeneficiaireSapa(boolean paramBoolean);
  
  public abstract boolean isAcompteNonSolde();
  
  public abstract void setAcompteNonSolde(boolean paramBoolean);
  
  public abstract boolean isExclusionIndividuelle();
  
  public abstract void setExclusionIndividuelle(boolean paramBoolean);
  
  public abstract boolean isIndividuMigre();
  
  public abstract void setIndividuMigre(boolean paramBoolean);
  
  public abstract Damj getDernierJourAtteste();
  
  public abstract void setDernierJourAtteste(Damj paramDamj);
  
  public abstract void setEtatMigration(String paramString);
  
  public abstract String getEtatMigration();
  
  public abstract void setDateCentTrimestres(Damj paramDamj);
  
  public abstract Damj getDateCentTrimestres();
  
  public abstract Damj getDateLimiteIndemnisation();
  
  public abstract void setDateLimiteIndemnisation(Damj paramDamj);
  
  public abstract String getCodeAntenne();
  
  public abstract void setCodeAntenne(String paramString);
  
  public abstract void setRsodDernierAdmission(String paramString);
  
  public abstract String getRsodDernierAdmission();
  
  public abstract void setDateCalculAuPlusTot(Damj paramDamj);
  
  public abstract Damj getDateCalculAuPlusTot();
  
  public abstract Damj getDateDerniereOD();
  
  public abstract void setDateDerniereOD(Damj paramDamj);
  
  public abstract boolean estAlerteAD();
  
  public abstract void setEstAlerteAD(boolean paramBoolean);
  
  public abstract boolean estDeployeeAD();
  
  public abstract void setEstDeployeeAD(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     StructureOutIndividuV1Spec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */