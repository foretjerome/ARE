package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;

public class DomDispositifsCspListerParIndividu
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec individu;
  private ContexteService contexteService;
  
  public IndividuSpec getIndividu()
  {
    return individu;
  }
  
  public void setIndividu(IndividuSpec individu)
  {
    this.individu = individu;
  }
  
  public ContexteService getContexteService()
  {
    return contexteService;
  }
  
  public void setContexteService(ContexteService contexteService)
  {
    this.contexteService = contexteService;
  }
  
  public static ContexteService getContexteService(Contexte contexte)
  {
    return ((DomReexecutionCali)contexte.getDonnees()).getContexteService();
  }
}

/* Location:
 * Qualified Name:     DomDispositifsCspListerParIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */