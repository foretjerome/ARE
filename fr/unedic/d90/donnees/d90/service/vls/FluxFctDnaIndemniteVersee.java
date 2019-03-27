package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class FluxFctDnaIndemniteVersee
{
  public static FluxFctDnaIndemniteVersee getInstance()
  {
    return new _FluxFctDnaIndemniteVerseeImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getTypeIndemnite();
  
  public abstract void setTypeIndemnite(String paramString);
  
  public abstract String getCodeErreurTypeIndemnite();
  
  public abstract void setCodeErreurTypeIndemnite(String paramString);
  
  public abstract String getNature();
  
  public abstract void setNature(String paramString);
  
  public abstract String getCodeErreurNature();
  
  public abstract void setCodeErreurNature(String paramString);
  
  public abstract String getIndicMontant();
  
  public abstract void setIndicMontant(String paramString);
  
  public abstract String getCodeErreurIndicMontant();
  
  public abstract void setCodeErreurIndicMontant(String paramString);
  
  public abstract Damj getDateDebut();
  
  public abstract void setDateDebut(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebut();
  
  public abstract void setCodeErreurDateDebut(String paramString);
  
  public abstract Damj getDateFin();
  
  public abstract void setDateFin(Damj paramDamj);
  
  public abstract String getCodeErreurDateFin();
  
  public abstract void setCodeErreurDateFin(String paramString);
  
  public abstract BigDecimal getMontantIndemnite();
  
  public abstract void setMontantIndemnite(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurMontantIndemnite();
  
  public abstract void setCodeErreurMontantIndemnite(String paramString);
}

/* Location:
 * Qualified Name:     FluxFctDnaIndemniteVersee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */