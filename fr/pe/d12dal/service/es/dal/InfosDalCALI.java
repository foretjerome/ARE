package fr.pe.d12dal.service.es.dal;

import java.util.Date;

public abstract class InfosDalCALI
{
  public static InfosDalCALI getInstance()
  {
    return new _InfosDalCALIImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getRefusPropositionFNE();
  
  public abstract void setRefusPropositionFNE(String paramString);
  
  public abstract String getCodeErreurRefusPropositionFNE();
  
  public abstract void setCodeErreurRefusPropositionFNE(String paramString);
  
  public abstract Boolean getArtisteNonSalarie();
  
  public abstract void setArtisteNonSalarie(Boolean paramBoolean);
  
  public abstract String getCodeErreurArtisteNonSalarie();
  
  public abstract void setCodeErreurArtisteNonSalarie(String paramString);
  
  public abstract Boolean getMarinPecheur();
  
  public abstract void setMarinPecheur(Boolean paramBoolean);
  
  public abstract String getCodeErreurMarinPecheur();
  
  public abstract void setCodeErreurMarinPecheur(String paramString);
  
  public abstract Boolean getDockerOccasionnel();
  
  public abstract void setDockerOccasionnel(Boolean paramBoolean);
  
  public abstract String getCodeErreurDockerOccasionnel();
  
  public abstract void setCodeErreurDockerOccasionnel(String paramString);
  
  public abstract Boolean getDetenuLibere();
  
  public abstract void setDetenuLibere(Boolean paramBoolean);
  
  public abstract String getCodeErreurDetenuLibere();
  
  public abstract void setCodeErreurDetenuLibere(String paramString);
  
  public abstract Boolean getSalarieExpatrie();
  
  public abstract void setSalarieExpatrie(Boolean paramBoolean);
  
  public abstract String getCodeErreurSalarieExpatrie();
  
  public abstract void setCodeErreurSalarieExpatrie(String paramString);
  
  public abstract String getStatutDemande();
  
  public abstract void setStatutDemande(String paramString);
  
  public abstract String getCodeErreurStatutDemande();
  
  public abstract void setCodeErreurStatutDemande(String paramString);
  
  public abstract String getRefExterne();
  
  public abstract void setRefExterne(String paramString);
  
  public abstract String getCodeErreurRefExterne();
  
  public abstract void setCodeErreurRefExterne(String paramString);
  
  public abstract InfosDalCALI_periodesAffiliations getPeriodesAffiliations();
  
  public abstract void setPeriodesAffiliations(InfosDalCALI_periodesAffiliations paramInfosDalCALI_periodesAffiliations);
  
  public abstract InfosDalCALI_periodesAffiliations setNewInfosDalCALI_periodesAffiliations();
  
  /**
   * @deprecated
   */
  public abstract InfosDalCALI_periodesAffiliations setNewPeriodesAffiliations();
  
  public abstract InfosLiquidationDal getInfosLiquidationDAL();
  
  public abstract void setInfosLiquidationDAL(InfosLiquidationDal paramInfosLiquidationDal);
  
  public abstract InfosLiquidationDal setNewInfosLiquidationDal();
  
  public abstract InfosLiquidationDal setNewInfosLiquidationDAL();
  
  public abstract String getIdentifiantDemandeInstruction();
  
  public abstract void setIdentifiantDemandeInstruction(String paramString);
  
  public abstract String getCodeErreurIdentifiantDemandeInstruction();
  
  public abstract void setCodeErreurIdentifiantDemandeInstruction(String paramString);
  
  public abstract Date getDateDJA();
  
  public abstract void setDateDJA(Date paramDate);
  
  public abstract String getCodeErreurDateDJA();
  
  public abstract void setCodeErreurDateDJA(String paramString);
}

/* Location:
 * Qualified Name:     InfosDalCALI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */