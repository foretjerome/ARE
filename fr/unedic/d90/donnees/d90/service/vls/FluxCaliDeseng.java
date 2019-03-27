package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;

public abstract class FluxCaliDeseng
{
  public static FluxCaliDeseng getInstance()
  {
    return new _FluxCaliDesengImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getCxala();
  
  public abstract void setCxala(String paramString);
  
  public abstract String getCodeErreurCxala();
  
  public abstract void setCodeErreurCxala(String paramString);
  
  public abstract String getRsin();
  
  public abstract void setRsin(String paramString);
  
  public abstract String getCodeErreurRsin();
  
  public abstract void setCodeErreurRsin(String paramString);
  
  public abstract String getCxass();
  
  public abstract void setCxass(String paramString);
  
  public abstract String getCodeErreurCxass();
  
  public abstract void setCodeErreurCxass(String paramString);
  
  public abstract Damj getDateAppel();
  
  public abstract void setDateAppel(Damj paramDamj);
  
  public abstract String getCodeErreurDateAppel();
  
  public abstract void setCodeErreurDateAppel(String paramString);
  
  public abstract String getIdAide();
  
  public abstract void setIdAide(String paramString);
  
  public abstract String getCodeErreurIdAide();
  
  public abstract void setCodeErreurIdAide(String paramString);
}

/* Location:
 * Qualified Name:     FluxCaliDeseng
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */