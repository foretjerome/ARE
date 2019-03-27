package fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec;

public abstract interface AllocataireNcpSpec
{
  public static final String MIGRE_NCP = "M";
  public static final String NON_MIGRE_NCP = " ";
  public static final String DEMIGRE_NCP = "A";
  
  public abstract String getAliasNcp();
  
  public abstract void setAliasNcp(String paramString);
  
  public abstract String getNumeroAllocataire();
  
  public abstract void setNumeroAllocataire(String paramString);
  
  public abstract String getIdentifiantSigma();
  
  public abstract void setIdentifiantSigma(String paramString);
  
  public abstract String getCodeAssedic();
  
  public abstract void setCodeAssedic(String paramString);
  
  public abstract String getTopReferent();
  
  public abstract void setTopReferent(String paramString);
  
  public abstract String getCodeAntenne();
  
  public abstract void setCodeAntenne(String paramString);
  
  public abstract String getIdentifiantDNA();
  
  public abstract void setIdentifiantDNA(String paramString);
}

/* Location:
 * Qualified Name:     AllocataireNcpSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */