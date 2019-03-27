package fr.unedic.cali.dom;

import fr.unedic.cali.parcours.DomLiquidationDemande;
import fr.unedic.util.services.ContexteService;

public class DomDesengagementAide
  extends DomLiquidationDemande
{
  private ContexteService contexteService;
  private String referenceExterne;
  private Long cxalaf;
  private String codePe;
  private String rsin;
  
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
  
  public String getReferenceExterne()
  {
    return referenceExterne;
  }
  
  public void setReferenceExterne(String referenceExterne)
  {
    this.referenceExterne = referenceExterne;
  }
  
  public ContexteService getContexteService()
  {
    return contexteService;
  }
  
  public void setContexteService(ContexteService contexteService)
  {
    this.contexteService = contexteService;
  }
}

/* Location:
 * Qualified Name:     DomDesengagementAide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */