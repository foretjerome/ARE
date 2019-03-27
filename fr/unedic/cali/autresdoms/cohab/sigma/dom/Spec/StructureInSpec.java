package fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec;

import fr.unedic.util.services.ContexteServiceSpec;

public abstract interface StructureInSpec
{
  public abstract String getIdentifiantIndividu();
  
  public abstract void setIdentifiantIndividu(String paramString);
  
  public abstract String getCodeAssedic();
  
  public abstract void setCodeAssedic(String paramString);
  
  public abstract void setContexteService(ContexteServiceSpec paramContexteServiceSpec);
  
  public abstract ContexteServiceSpec getContexteService();
}

/* Location:
 * Qualified Name:     StructureInSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */