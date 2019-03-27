package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class Flux
{
  public static Flux getInstance()
  {
    return new _FluxImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract FluxCAF getFluxCAF();
  
  public abstract void setFluxCAF(FluxCAF paramFluxCAF);
  
  public abstract FluxCAF setNewFluxCAF();
  
  public abstract FluxETT getFluxETT();
  
  public abstract void setFluxETT(FluxETT paramFluxETT);
  
  public abstract FluxETT setNewFluxETT();
  
  public abstract FluxCSS getFluxCSS();
  
  public abstract void setFluxCSS(FluxCSS paramFluxCSS);
  
  public abstract FluxCSS setNewFluxCSS();
  
  public abstract FluxDSM getFluxDSM();
  
  public abstract void setFluxDSM(FluxDSM paramFluxDSM);
  
  public abstract FluxDSM setNewFluxDSM();
  
  public abstract FluxGUSO getFluxGUSO();
  
  public abstract void setFluxGUSO(FluxGUSO paramFluxGUSO);
  
  public abstract FluxGUSO setNewFluxGUSO();
  
  public abstract FluxCPAM getFluxCPAM();
  
  public abstract void setFluxCPAM(FluxCPAM paramFluxCPAM);
  
  public abstract FluxCPAM setNewFluxCPAM();
  
  public abstract FluxAEM getFluxAEM();
  
  public abstract void setFluxAEM(FluxAEM paramFluxAEM);
  
  public abstract FluxAEM setNewFluxAEM();
  
  public abstract FluxBS getFluxBS();
  
  public abstract void setFluxBS(FluxBS paramFluxBS);
  
  public abstract FluxBS setNewFluxBS();
  
  public abstract FluxPasDna getFluxPasDna();
  
  public abstract void setFluxPasDna(FluxPasDna paramFluxPasDna);
  
  public abstract FluxPasDna setNewFluxPasDna();
  
  public abstract FluxFctDna getFluxFctDna();
  
  public abstract void setFluxFctDna(FluxFctDna paramFluxFctDna);
  
  public abstract FluxFctDna setNewFluxFctDna();
  
  public abstract FluxCali getFluxCali();
  
  public abstract void setFluxCali(FluxCali paramFluxCali);
  
  public abstract FluxCali setNewFluxCali();
  
  public abstract FluxMSA getFluxMSA();
  
  public abstract void setFluxMSA(FluxMSA paramFluxMSA);
  
  public abstract FluxMSA setNewFluxMSA();
  
  public abstract FluxDMM getFluxDMM();
  
  public abstract void setFluxDMM(FluxDMM paramFluxDMM);
  
  public abstract FluxDMM setNewFluxDMM();
  
  public abstract FluxAE getFluxAE();
  
  public abstract void setFluxAE(FluxAE paramFluxAE);
  
  public abstract FluxAE setNewFluxAE();
  
  public abstract String getMotifAnomalie();
  
  public abstract void setMotifAnomalie(String paramString);
  
  public abstract String getCodeErreurMotifAnomalie();
  
  public abstract void setCodeErreurMotifAnomalie(String paramString);
  
  public abstract String getCommentaire();
  
  public abstract void setCommentaire(String paramString);
  
  public abstract String getCodeErreurCommentaire();
  
  public abstract void setCodeErreurCommentaire(String paramString);
  
  public abstract String getTypeFlux();
  
  public abstract void setTypeFlux(String paramString);
  
  public abstract String getCodeErreurTypeFlux();
  
  public abstract void setCodeErreurTypeFlux(String paramString);
  
  public abstract String getIdFlux();
  
  public abstract void setIdFlux(String paramString);
  
  public abstract String getCodeErreurIdFlux();
  
  public abstract void setCodeErreurIdFlux(String paramString);
  
  public abstract String getVersion();
  
  public abstract void setVersion(String paramString);
  
  public abstract String getCodeErreurVersion();
  
  public abstract void setCodeErreurVersion(String paramString);
  
  public abstract String getIdTechPas();
  
  public abstract void setIdTechPas(String paramString);
  
  public abstract String getCodeErreurIdTechPas();
  
  public abstract void setCodeErreurIdTechPas(String paramString);
  
  public abstract String getNumeroContrat();
  
  public abstract void setNumeroContrat(String paramString);
  
  public abstract String getCodeErreurNumeroContrat();
  
  public abstract void setCodeErreurNumeroContrat(String paramString);
  
  public abstract Damj getDateTraitement();
  
  public abstract void setDateTraitement(Damj paramDamj);
  
  public abstract String getCodeErreurDateTraitement();
  
  public abstract void setCodeErreurDateTraitement(String paramString);
  
  public abstract Damj getDateVisa();
  
  public abstract void setDateVisa(Damj paramDamj);
  
  public abstract String getCodeErreurDateVisa();
  
  public abstract void setCodeErreurDateVisa(String paramString);
  
  public abstract Damj getDateConnaissanceInfo();
  
  public abstract void setDateConnaissanceInfo(Damj paramDamj);
  
  public abstract String getCodeErreurDateConnaissanceInfo();
  
  public abstract void setCodeErreurDateConnaissanceInfo(String paramString);
  
  public abstract BigDecimal getIndicateurOrigine();
  
  public abstract void setIndicateurOrigine(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIndicateurOrigine();
  
  public abstract void setCodeErreurIndicateurOrigine(String paramString);
  
  public abstract BigDecimal getIdPeriodeActivite();
  
  public abstract void setIdPeriodeActivite(BigDecimal paramBigDecimal);
  
  public abstract String getCodeErreurIdPeriodeActivite();
  
  public abstract void setCodeErreurIdPeriodeActivite(String paramString);
  
  public abstract FluxDSN getFluxDSN();
  
  public abstract void setFluxDSN(FluxDSN paramFluxDSN);
  
  public abstract FluxDSN setNewFluxDSN();
  
  public abstract FluxCtPasDsn getFluxCtPasDsn();
  
  public abstract void setFluxCtPasDsn(FluxCtPasDsn paramFluxCtPasDsn);
  
  public abstract FluxCtPasDsn setNewFluxCtPasDsn();
  
  public abstract FluxPrimeIndemDsn getFluxPrimeIndemDsn();
  
  public abstract void setFluxPrimeIndemDsn(FluxPrimeIndemDsn paramFluxPrimeIndemDsn);
  
  public abstract FluxPrimeIndemDsn setNewFluxPrimeIndemDsn();
  
  public abstract FluxAbsenceFormation getFluxAbsenceFormation();
  
  public abstract void setFluxAbsenceFormation(FluxAbsenceFormation paramFluxAbsenceFormation);
  
  public abstract FluxAbsenceFormation setNewFluxAbsenceFormation();
  
  public abstract FluxPeriodeAbsenceFormation getFluxPeriodeAbsenceFormation();
  
  public abstract void setFluxPeriodeAbsenceFormation(FluxPeriodeAbsenceFormation paramFluxPeriodeAbsenceFormation);
  
  public abstract FluxPeriodeAbsenceFormation setNewFluxPeriodeAbsenceFormation();
  
  public abstract FluxCaliDeseng getFluxCaliDeseng();
  
  public abstract void setFluxCaliDeseng(FluxCaliDeseng paramFluxCaliDeseng);
  
  public abstract FluxCaliDeseng setNewFluxCaliDeseng();
}

/* Location:
 * Qualified Name:     Flux
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */