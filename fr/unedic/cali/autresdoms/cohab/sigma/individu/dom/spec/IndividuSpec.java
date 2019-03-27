package fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.spec;

import fr.unedic.util.temps.Damj;

public abstract interface IndividuSpec
{
  public static final String ETAT_CIVIL_MONSIEUR = "MR";
  public static final String ETAT_CIVIL_MADAME = "MME";
  public static final String ETAT_CIVIL_MADEMOISELLE = "MLLE";
  public static final String INDIVIDU_MIGRE = "M";
  public static final String INDIVIDU_NON_MIGRE = "";
  public static final String INDIVIDU_MIGRATION_EN_COURS = "C";
  
  public abstract Damj getDernierJourAtteste();
  
  public abstract void setDernierJourAtteste(Damj paramDamj);
  
  public abstract Damj getDateNaissance();
  
  public abstract Damj getDateDeces();
  
  public abstract void setDateNaissance(Damj paramDamj);
  
  public abstract void setDateDeces(Damj paramDamj);
  
  public abstract String getNom();
  
  public abstract void setNomMarital(String paramString);
  
  public abstract String getNomMarital();
  
  public abstract void setNom(String paramString);
  
  public abstract String getPrenom();
  
  public abstract void setPrenom(String paramString);
  
  public abstract String getNumeroAllocataire();
  
  public abstract void setNumeroAllocataire(String paramString);
  
  public abstract Damj getDateLiquidationRetraite();
  
  public abstract void setDateLiquidationRetraite(Damj paramDamj);
  
  public abstract Damj getDateRetraiteAnticipe();
  
  public abstract void setDateRetraiteAnticipe(Damj paramDamj);
  
  public abstract String getMotifRetraiteAnticipe();
  
  public abstract void setMotifRetraiteAnticipe(String paramString);
  
  public abstract TrimestreRetraiteSpec getTrimestreRetraite();
  
  public abstract void setTrimestreRetraite(TrimestreRetraiteSpec paramTrimestreRetraiteSpec);
  
  public abstract String getEtatCivil();
  
  public abstract void setEtatCivil(String paramString);
  
  public abstract boolean isBeneficiaireSapa();
  
  public abstract void setBeneficiaireSapa(boolean paramBoolean);
  
  public abstract boolean isBeneficiaireRsa();
  
  public abstract void setBeneficiaireRsa(boolean paramBoolean);
  
  public abstract boolean isAcompteNonSolde();
  
  public abstract void setAcompteNonSolde(boolean paramBoolean);
  
  public abstract boolean isExclusionIndividuelle();
  
  public abstract void setExclusionIndividuelle(boolean paramBoolean);
  
  public abstract boolean isIndividuMigre();
  
  public abstract void setIndividuMigre(boolean paramBoolean);
  
  public abstract void setEtatMigration(String paramString);
  
  public abstract String getEtatMigration();
  
  public abstract Damj getDateLimiteIndemnisation();
  
  public abstract void setDateLimiteIndemnisation(Damj paramDamj);
  
  public abstract String getCodeAntenne();
  
  public abstract void setCodeAntenne(String paramString);
  
  public abstract String getReferenceExterne();
  
  public abstract void setReferenceExterne(String paramString);
  
  public abstract void setRsodDernierAdmission(String paramString);
  
  public abstract String getRsodDernierAdmission();
  
  public abstract void setDateDeCalculAuPlusTot(Damj paramDamj);
  
  public abstract Damj getDateDeCalculAuPlusTot();
  
  public abstract Damj getDatePeremptionTitreSejour();
  
  public abstract void setDatePeremptionTitreSejour(Damj paramDamj);
  
  public abstract Damj getDjams();
  
  public abstract void setDjams(Damj paramDamj);
  
  public abstract Damj getDateDerniereOD();
  
  public abstract void setDateDerniereOD(Damj paramDamj);
  
  public abstract boolean estAlerteAD();
  
  public abstract void setEstAlerteAD(boolean paramBoolean);
  
  public abstract boolean estDeployeeAD();
  
  public abstract void setEstDeployeeAD(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     IndividuSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */