package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class FluxDSM
{
  public static FluxDSM getInstance()
  {
    return new _FluxDSMImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract ListeDSMTravail getListeDSMTravail();
  
  public abstract void setListeDSMTravail(ListeDSMTravail paramListeDSMTravail);
  
  public abstract ListeDSMTravail setNewListeDSMTravail();
  
  public abstract String getFlagA8A10();
  
  public abstract void setFlagA8A10(String paramString);
  
  public abstract String getCodeErreurFlagA8A10();
  
  public abstract void setCodeErreurFlagA8A10(String paramString);
  
  public abstract String getDeclareJustifie();
  
  public abstract void setDeclareJustifie(String paramString);
  
  public abstract String getCodeErreurDeclareJustifie();
  
  public abstract void setCodeErreurDeclareJustifie(String paramString);
  
  public abstract String getIndicateurPresenceTravail();
  
  public abstract void setIndicateurPresenceTravail(String paramString);
  
  public abstract String getCodeErreurIndicateurPresenceTravail();
  
  public abstract void setCodeErreurIndicateurPresenceTravail(String paramString);
  
  public abstract String getOrigineSaisieDsm();
  
  public abstract void setOrigineSaisieDsm(String paramString);
  
  public abstract String getCodeErreurOrigineSaisieDsm();
  
  public abstract void setCodeErreurOrigineSaisieDsm(String paramString);
  
  public abstract Damj getDateDebutFormation();
  
  public abstract void setDateDebutFormation(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutFormation();
  
  public abstract void setCodeErreurDateDebutFormation(String paramString);
  
  public abstract Damj getDateFinFormation();
  
  public abstract void setDateFinFormation(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinFormation();
  
  public abstract void setCodeErreurDateFinFormation(String paramString);
  
  public abstract Damj getDateDebutMaladie();
  
  public abstract void setDateDebutMaladie(Damj paramDamj);
  
  public abstract String getCodeErreurDateDebutMaladie();
  
  public abstract void setCodeErreurDateDebutMaladie(String paramString);
  
  public abstract Damj getDateFinMaladie();
  
  public abstract void setDateFinMaladie(Damj paramDamj);
  
  public abstract String getCodeErreurDateFinMaladie();
  
  public abstract void setCodeErreurDateFinMaladie(String paramString);
  
  public abstract Damj getMoisActualisation();
  
  public abstract void setMoisActualisation(Damj paramDamj);
  
  public abstract String getCodeErreurMoisActualisation();
  
  public abstract void setCodeErreurMoisActualisation(String paramString);
  
  public abstract BigDecimal getNbreHeuresActRed();
  
  public abstract void setNbreHeuresActRed(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurNbreHeuresActRed();
  
  public abstract void setCodeErreurNbreHeuresActRed(String paramString);
}

/* Location:
 * Qualified Name:     FluxDSM
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */