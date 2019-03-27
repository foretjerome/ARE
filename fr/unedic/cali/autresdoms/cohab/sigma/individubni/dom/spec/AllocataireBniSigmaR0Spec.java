package fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom.spec;

public abstract interface AllocataireBniSigmaR0Spec
{
  public static final String MIGRE_NCP = "M";
  public static final String NON_MIGRE_NCP = " ";
  public static final String DEMIGRE_NCP = "A";
  
  public abstract String getCodeEtatMigrationNCP();
  
  public abstract void setCodeEtatMigrationNCP(String paramString);
  
  public abstract String getOrigineCertification();
  
  public abstract void setOrigineCertification(String paramString);
  
  public abstract String getNumeroAllocataire();
  
  public abstract String getIdentifiantSigma();
  
  public abstract String getCodeAssedic();
  
  public abstract void setNumeroAllocataire(String paramString);
  
  public abstract void setIdentifiantSigma(String paramString);
  
  public abstract void setCodeAssedic(String paramString);
}

/* Location:
 * Qualified Name:     AllocataireBniSigmaR0Spec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */