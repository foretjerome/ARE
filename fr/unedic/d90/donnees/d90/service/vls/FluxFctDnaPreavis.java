package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;

public abstract class FluxFctDnaPreavis
{
  public static FluxFctDnaPreavis getInstance()
  {
    return new _FluxFctDnaPreavisImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getTypePreavis();
  
  public abstract void setTypePreavis(String paramString);
  
  public abstract String getCodeErreurTypePreavis();
  
  public abstract void setCodeErreurTypePreavis(String paramString);
  
  public abstract Damj getDateDebutPreavis();
  
  public abstract void setDateDebutPreavis(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutPreavis();
  
  public abstract void setCodeErreurDateDebutPreavis(String paramString);
  
  public abstract Damj getDateFinPreavis();
  
  public abstract void setDateFinPreavis(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinPreavis();
  
  public abstract void setCodeErreurDateFinPreavis(String paramString);
}

/* Location:
 * Qualified Name:     FluxFctDnaPreavis
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */