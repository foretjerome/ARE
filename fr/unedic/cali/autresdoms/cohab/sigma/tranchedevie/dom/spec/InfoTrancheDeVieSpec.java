package fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec;

public abstract interface InfoTrancheDeVieSpec
{
  public abstract String getIdentifiantBNI();
  
  public abstract void setIdentifiantBNI(String paramString);
  
  public abstract String getIdentifiantNCP();
  
  public abstract void setIdentifiantNCP(String paramString);
  
  public abstract String getRSIN();
  
  public abstract void setRSIN(String paramString);
  
  public abstract String getCodeAssedic();
  
  public abstract void setCodeAssedic(String paramString);
  
  public abstract Boolean getTopReferent();
  
  public abstract void setTopReferent(Boolean paramBoolean);
  
  public abstract String getCodeAntenne();
  
  public abstract void setCodeAntenne(String paramString);
  
  public abstract String getIdentifiantDNA();
  
  public abstract void setIdentifiantDNA(String paramString);
}

/* Location:
 * Qualified Name:     InfoTrancheDeVieSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */