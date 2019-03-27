package fr.unedic.cali.dom.prechargement;

import fr.unedic.cali.parcours.DomLiquidationDemande;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;

public class DomLectureContexteExamen
  extends DomLiquidationDemande
{
  private ContexteService contexteService;
  private Damj dateEtude;
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
  
  public Damj getDateEtude()
  {
    return dateEtude;
  }
  
  public void setDateEtude(Damj dateEtude)
  {
    this.dateEtude = dateEtude;
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
 * Qualified Name:     DomLectureContexteExamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */