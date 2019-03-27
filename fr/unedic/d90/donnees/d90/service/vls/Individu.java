package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class Individu
{
  public static Individu getInstance()
  {
    return new _IndividuImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getIdentifiantSigma();
  
  public abstract void setIdentifiantSigma(String paramString);
  
  public abstract String getCodeErreurIdentifiantSigma();
  
  public abstract void setCodeErreurIdentifiantSigma(String paramString);
  
  public abstract String getCodeAntenne();
  
  public abstract void setCodeAntenne(String paramString);
  
  public abstract String getCodeErreurCodeAntenne();
  
  public abstract void setCodeErreurCodeAntenne(String paramString);
  
  public abstract String getNomPopulation();
  
  public abstract void setNomPopulation(String paramString);
  
  public abstract String getCodeErreurNomPopulation();
  
  public abstract void setCodeErreurNomPopulation(String paramString);
  
  public abstract Damj getDateReexecution();
  
  public abstract void setDateReexecution(Damj paramDamj);
  
  public abstract String getCodeErreurDateReexecution();
  
  public abstract void setCodeErreurDateReexecution(String paramString);
  
  public abstract BigDecimal getIdentifiantBNI();
  
  public abstract void setIdentifiantBNI(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIdentifiantBNI();
  
  public abstract void setCodeErreurIdentifiantBNI(String paramString);
}

/* Location:
 * Qualified Name:     Individu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */