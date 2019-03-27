package fr.unedic.cali.dom.spec;

import fr.unedic.util.temps.Damj;

public abstract interface ConventionGestionSpec
{
  public static final String SIGNATAIRE_UNEDIC = "1";
  public static final String SIGNATAIRE_POLE_EMPLOI = "2";
  public static final String AUCUNE_AIDE = "01";
  public static final String AIDES_ARCE_ADR = "02";
  public static final String TOUTES_AIDES = "03";
  public static final String CONVENTION_EMPLOI_JEUNE = "555";
  public static final String CONVENTION_POLE_EMPLOI = "556";
  public static final String CONVENTION_PE_SANS_PCRC = "1401EPEIRC";
  public static final String CONVENTION_PE_AVEC_PCRC = "1401EPEAAR";
  
  public abstract String getNumeroConventionGestion();
  
  public abstract String getCodeAffectation();
  
  public abstract String getSignataire();
  
  public abstract boolean estPrecompteCRC();
  
  public abstract String getApplicationAides();
  
  public abstract Damj getDebutValidite();
  
  public abstract void setDebutValidite(Damj paramDamj);
  
  public abstract Damj getFinValidite();
  
  public abstract void setFinValidite(Damj paramDamj);
  
  public abstract String getLibelleAffectation();
  
  public abstract void setLibelleAffectation(String paramString);
  
  public abstract boolean isEstAideAdr();
  
  public abstract void setEstAideAdr(boolean paramBoolean);
  
  public abstract boolean isEstAideAllocationDeces();
  
  public abstract void setEstAideAllocationDeces(boolean paramBoolean);
  
  public abstract boolean isEstAideArce();
  
  public abstract void setEstAideArce(boolean paramBoolean);
  
  public abstract boolean isEstAideCongeNonPaye();
  
  public abstract boolean isEstAideFinDroit();
  
  public abstract void setEstAideCongeNonPaye(boolean paramBoolean);
  
  public abstract void setEstAideFinDroit(boolean paramBoolean);
  
  public abstract boolean estIdExterneObligatoire();
}

/* Location:
 * Qualified Name:     ConventionGestionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */