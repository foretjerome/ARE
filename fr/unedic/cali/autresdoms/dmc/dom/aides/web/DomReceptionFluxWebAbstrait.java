package fr.unedic.cali.autresdoms.dmc.dom.aides.web;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.parcours.DomLiquidationDemande;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class DomReceptionFluxWebAbstrait
  extends DomLiquidationDemande
{
  private ContexteService contexteService;
  private IndividuSpec individu;
  private String idDemandeWeb;
  private Long cxalaf;
  private String codePe;
  private String rsin;
  private Boolean topRessources;
  private Boolean topInscription;
  private Integer origineDemande;
  private Integer contexteDemande;
  private Integer situationMobilite;
  private Integer motifDemande;
  private Damj dateDepot;
  private Integer statutDemande;
  private Boolean demandeAdmissible;
  private Boolean financementAutre;
  private BigDecimal montantFinancementAutre;
  private Integer natureContrat;
  
  public String getIdDemandeWeb()
  {
    return idDemandeWeb;
  }
  
  public void setIdDemandeWeb(String idDemande)
  {
    idDemandeWeb = idDemande;
  }
  
  public Long getCxalaf()
  {
    return cxalaf;
  }
  
  public void setCxalaf(Long cxalaf)
  {
    this.cxalaf = cxalaf;
  }
  
  public String getCodePe()
  {
    return codePe;
  }
  
  public void setCodePe(String codePe)
  {
    this.codePe = codePe;
  }
  
  public String getRsin()
  {
    return rsin;
  }
  
  public void setRsin(String rsin)
  {
    this.rsin = rsin;
  }
  
  public Boolean getTopRessources()
  {
    return topRessources;
  }
  
  public void setTopRessources(Boolean topRessources)
  {
    this.topRessources = topRessources;
  }
  
  public Boolean getTopInscription()
  {
    return topInscription;
  }
  
  public void setTopInscription(Boolean topInscription)
  {
    this.topInscription = topInscription;
  }
  
  public Damj getDateDepot()
  {
    return dateDepot;
  }
  
  public void setDateDepot(Damj dateDepot)
  {
    this.dateDepot = dateDepot;
  }
  
  public Boolean getDemandeAdmissible()
  {
    return demandeAdmissible;
  }
  
  public void setDemandeAdmissible(Boolean demandeAdmissible)
  {
    this.demandeAdmissible = demandeAdmissible;
  }
  
  public BigDecimal getMontantFinancementAutre()
  {
    return montantFinancementAutre;
  }
  
  public void setMontantFinancementAutre(BigDecimal montantFinancementAutre)
  {
    this.montantFinancementAutre = montantFinancementAutre;
  }
  
  public Integer getOrigineDemande()
  {
    return origineDemande;
  }
  
  public void setOrigineDemande(Integer origineDemande)
  {
    this.origineDemande = origineDemande;
  }
  
  public Integer getContexteDemande()
  {
    return contexteDemande;
  }
  
  public void setContexteDemande(Integer contexteDemande)
  {
    this.contexteDemande = contexteDemande;
  }
  
  public Integer getSituationMobilite()
  {
    return situationMobilite;
  }
  
  public void setSituationMobilite(Integer actionReclassement)
  {
    situationMobilite = actionReclassement;
  }
  
  public Integer getMotifDemande()
  {
    return motifDemande;
  }
  
  public void setMotifDemande(Integer motifDemande)
  {
    this.motifDemande = motifDemande;
  }
  
  public Integer getStatutDemande()
  {
    return statutDemande;
  }
  
  public void setStatutDemande(Integer statutDemande)
  {
    this.statutDemande = statutDemande;
  }
  
  public Boolean getFinancementAutre()
  {
    return financementAutre;
  }
  
  public void setFinancementAutre(Boolean financementAutre)
  {
    this.financementAutre = financementAutre;
  }
  
  public Integer getNatureContrat()
  {
    return natureContrat;
  }
  
  public void setNatureContrat(Integer natureContrat)
  {
    this.natureContrat = natureContrat;
  }
  
  public ContexteService getContexteService()
  {
    return contexteService;
  }
  
  public IndividuSpec getIndividu()
  {
    return individu;
  }
  
  public void setContexteService(ContexteService contexteService)
  {
    this.contexteService = contexteService;
  }
  
  public void setIndividu(IndividuSpec individu)
  {
    this.individu = individu;
  }
}

/* Location:
 * Qualified Name:     DomReceptionFluxWebAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */