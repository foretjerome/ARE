package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;

public abstract class FluxCali
{
  public static FluxCali getInstance()
  {
    return new _FluxCaliImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getCxass();
  
  public abstract void setCxass(String paramString);
  
  public abstract String getCodeErreurCxass();
  
  public abstract void setCodeErreurCxass(String paramString);
  
  public abstract String getRsin();
  
  public abstract void setRsin(String paramString);
  
  public abstract String getCodeErreurRsin();
  
  public abstract void setCodeErreurRsin(String paramString);
  
  public abstract String getCxala();
  
  public abstract void setCxala(String paramString);
  
  public abstract String getCodeErreurCxala();
  
  public abstract void setCodeErreurCxala(String paramString);
  
  public abstract Damj getDateTraitement();
  
  public abstract void setDateTraitement(Damj paramDamj);
  
  public abstract String getCodeErreurDateTraitement();
  
  public abstract void setCodeErreurDateTraitement(String paramString);
  
  public abstract Damj getDateReexecution();
  
  public abstract void setDateReexecution(Damj paramDamj);
  
  public abstract String getCodeErreurDateReexecution();
  
  public abstract void setCodeErreurDateReexecution(String paramString);
}

/* Location:
 * Qualified Name:     FluxCali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */