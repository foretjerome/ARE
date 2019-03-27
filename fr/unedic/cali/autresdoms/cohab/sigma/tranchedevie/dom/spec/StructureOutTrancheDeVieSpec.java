package fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec;

import java.math.BigDecimal;

public abstract interface StructureOutTrancheDeVieSpec
{
  public abstract BigDecimal getIdentifiantBNI();
  
  public abstract void setIdentifiantBNI(BigDecimal paramBigDecimal);
  
  public abstract String getIdentifiantNCP();
  
  public abstract void setIdentifiantNCP(String paramString);
  
  public abstract String getRSIN();
  
  public abstract void setRSIN(String paramString);
  
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
 * Qualified Name:     StructureOutTrancheDeVieSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */