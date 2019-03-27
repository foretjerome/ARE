package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class DsmTravail
{
  public static DsmTravail getInstance()
  {
    return new _DsmTravailImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getRaisonSociale();
  
  public abstract void setRaisonSociale(String paramString);
  
  public abstract String getCodeErreurRaisonSociale();
  
  public abstract void setCodeErreurRaisonSociale(String paramString);
  
  public abstract Damj getDateDebutTravail();
  
  public abstract void setDateDebutTravail(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutTravail();
  
  public abstract void setCodeErreurDateDebutTravail(String paramString);
  
  public abstract Damj getDateFinTravail();
  
  public abstract void setDateFinTravail(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinTravail();
  
  public abstract void setCodeErreurDateFinTravail(String paramString);
  
  public abstract BigDecimal getSalaireBrut();
  
  public abstract void setSalaireBrut(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurSalaireBrut();
  
  public abstract void setCodeErreurSalaireBrut(String paramString);
  
  public abstract BigDecimal getNbreHeuresDeclarees();
  
  public abstract void setNbreHeuresDeclarees(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbreHeuresDeclarees();
  
  public abstract void setCodeErreurNbreHeuresDeclarees(String paramString);
  
  public abstract BigDecimal getNbreCachetsDeclares();
  
  public abstract void setNbreCachetsDeclares(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbreCachetsDeclares();
  
  public abstract void setCodeErreurNbreCachetsDeclares(String paramString);
}

/* Location:
 * Qualified Name:     DsmTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */