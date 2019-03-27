package fr.unedic.cali.parcours.lecturebasepivot;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.parcours.DomCaliOptimise;
import fr.unedic.util.services.ContexteService;

public class DomLireBasePivot
  extends DomCaliOptimise
{
  private ContexteService contexteService;
  private String codePE;
  private String cxala;
  private String referenceExterne;
  
  public IndividuSpec getIndividu()
  {
    return null;
  }
  
  public void setIndividu(IndividuSpec individu)
  {
    throw new UnsupportedOperationException("méthode interdite");
  }
  
  public ContexteService getContexteService()
  {
    return contexteService;
  }
  
  public void setContexteService(ContexteService contexteService)
  {
    this.contexteService = contexteService;
  }
  
  public String getCodePE()
  {
    return codePE;
  }
  
  public void setCodePE(String codePE)
  {
    this.codePE = codePE;
  }
  
  public String getCxala()
  {
    return cxala;
  }
  
  public void setCxala(String cxala)
  {
    this.cxala = cxala;
  }
  
  public String getReferenceExterne()
  {
    return referenceExterne;
  }
  
  public void setReferenceExterne(String referenceExterne)
  {
    this.referenceExterne = referenceExterne;
  }
}

/* Location:
 * Qualified Name:     DomLireBasePivot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */