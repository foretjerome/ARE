package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Heure;
import java.math.BigDecimal;

public abstract class ContexteService
{
  public static ContexteService getInstance()
  {
    return new _ContexteServiceImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getIdFlux();
  
  public abstract void setIdFlux(String paramString);
  
  public abstract String getCodeErreurIdFlux();
  
  public abstract void setCodeErreurIdFlux(String paramString);
  
  public abstract String getContexteEmission();
  
  public abstract void setContexteEmission(String paramString);
  
  public abstract String getCodeErreurContexteEmission();
  
  public abstract void setCodeErreurContexteEmission(String paramString);
  
  public abstract String getSrcCodeAssedic();
  
  public abstract void setSrcCodeAssedic(String paramString);
  
  public abstract String getCodeErreurSrcCodeAssedic();
  
  public abstract void setCodeErreurSrcCodeAssedic(String paramString);
  
  public abstract String getSrcCodeApplication();
  
  public abstract void setSrcCodeApplication(String paramString);
  
  public abstract String getCodeErreurSrcCodeApplication();
  
  public abstract void setCodeErreurSrcCodeApplication(String paramString);
  
  public abstract String getSrcCodeDomaine();
  
  public abstract void setSrcCodeDomaine(String paramString);
  
  public abstract String getCodeErreurSrcCodeDomaine();
  
  public abstract void setCodeErreurSrcCodeDomaine(String paramString);
  
  public abstract String getSrcCodeProcessus();
  
  public abstract void setSrcCodeProcessus(String paramString);
  
  public abstract String getCodeErreurSrcCodeProcessus();
  
  public abstract void setCodeErreurSrcCodeProcessus(String paramString);
  
  public abstract String getSrcCodeTransaction();
  
  public abstract void setSrcCodeTransaction(String paramString);
  
  public abstract String getCodeErreurSrcCodeTransaction();
  
  public abstract void setCodeErreurSrcCodeTransaction(String paramString);
  
  public abstract String getSrcCodeProgramme();
  
  public abstract void setSrcCodeProgramme(String paramString);
  
  public abstract String getCodeErreurSrcCodeProgramme();
  
  public abstract void setCodeErreurSrcCodeProgramme(String paramString);
  
  public abstract String getSrcCodeAgent();
  
  public abstract void setSrcCodeAgent(String paramString);
  
  public abstract String getCodeErreurSrcCodeAgent();
  
  public abstract void setCodeErreurSrcCodeAgent(String paramString);
  
  public abstract String getDstCodeAssedic();
  
  public abstract void setDstCodeAssedic(String paramString);
  
  public abstract String getCodeErreurDstCodeAssedic();
  
  public abstract void setCodeErreurDstCodeAssedic(String paramString);
  
  public abstract String getDstCodeApplication();
  
  public abstract void setDstCodeApplication(String paramString);
  
  public abstract String getCodeErreurDstCodeApplication();
  
  public abstract void setCodeErreurDstCodeApplication(String paramString);
  
  public abstract String getDstCodeDomaine();
  
  public abstract void setDstCodeDomaine(String paramString);
  
  public abstract String getCodeErreurDstCodeDomaine();
  
  public abstract void setCodeErreurDstCodeDomaine(String paramString);
  
  public abstract String getCodeActivite();
  
  public abstract void setCodeActivite(String paramString);
  
  public abstract String getCodeErreurCodeActivite();
  
  public abstract void setCodeErreurCodeActivite(String paramString);
  
  public abstract String getIdCourantTracker();
  
  public abstract void setIdCourantTracker(String paramString);
  
  public abstract String getCodeErreurIdCourantTracker();
  
  public abstract void setCodeErreurIdCourantTracker(String paramString);
  
  public abstract String getIdOrigineTracker();
  
  public abstract void setIdOrigineTracker(String paramString);
  
  public abstract String getCodeErreurIdOrigineTracker();
  
  public abstract void setCodeErreurIdOrigineTracker(String paramString);
  
  public abstract String getIdPrecedentTracker();
  
  public abstract void setIdPrecedentTracker(String paramString);
  
  public abstract String getCodeErreurIdPrecedentTracker();
  
  public abstract void setCodeErreurIdPrecedentTracker(String paramString);
  
  public abstract String getCodeFlux();
  
  public abstract void setCodeFlux(String paramString);
  
  public abstract String getCodeErreurCodeFlux();
  
  public abstract void setCodeErreurCodeFlux(String paramString);
  
  public abstract String getEnvtNature();
  
  public abstract void setEnvtNature(String paramString);
  
  public abstract String getCodeErreurEnvtNature();
  
  public abstract void setCodeErreurEnvtNature(String paramString);
  
  public abstract String getEnvtBase();
  
  public abstract void setEnvtBase(String paramString);
  
  public abstract String getCodeErreurEnvtBase();
  
  public abstract void setCodeErreurEnvtBase(String paramString);
  
  public abstract String getEnvtServeur();
  
  public abstract void setEnvtServeur(String paramString);
  
  public abstract String getCodeErreurEnvtServeur();
  
  public abstract void setCodeErreurEnvtServeur(String paramString);
  
  public abstract String getAdresseIP();
  
  public abstract void setAdresseIP(String paramString);
  
  public abstract String getCodeErreurAdresseIP();
  
  public abstract void setCodeErreurAdresseIP(String paramString);
  
  public abstract String getTypeEntite();
  
  public abstract void setTypeEntite(String paramString);
  
  public abstract String getCodeErreurTypeEntite();
  
  public abstract void setCodeErreurTypeEntite(String paramString);
  
  public abstract String getRsin();
  
  public abstract void setRsin(String paramString);
  
  public abstract String getCodeErreurRsin();
  
  public abstract void setCodeErreurRsin(String paramString);
  
  public abstract String getIdEntiteAutre();
  
  public abstract void setIdEntiteAutre(String paramString);
  
  public abstract String getCodeErreurIdEntiteAutre();
  
  public abstract void setCodeErreurIdEntiteAutre(String paramString);
  
  public abstract String getCodeAntenne();
  
  public abstract void setCodeAntenne(String paramString);
  
  public abstract String getCodeErreurCodeAntenne();
  
  public abstract void setCodeErreurCodeAntenne(String paramString);
  
  public abstract Damj getDateCreation();
  
  public abstract void setDateCreation(Damj paramDamj);
  
  public abstract String getCodeErreurDateCreation();
  
  public abstract void setCodeErreurDateCreation(String paramString);
  
  public abstract Damj getDateTraitement();
  
  public abstract void setDateTraitement(Damj paramDamj);
  
  public abstract String getCodeErreurDateTraitement();
  
  public abstract void setCodeErreurDateTraitement(String paramString);
  
  public abstract Heure getHeureCreation();
  
  public abstract void setHeureCreation(Heure paramHeure);
  
  public abstract String getCodeErreurHeureCreation();
  
  public abstract void setCodeErreurHeureCreation(String paramString);
  
  public abstract BigDecimal getCxala();
  
  public abstract void setCxala(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurCxala();
  
  public abstract void setCodeErreurCxala(String paramString);
}

/* Location:
 * Qualified Name:     ContexteService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */