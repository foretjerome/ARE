package fr.pe.cali.liquidation.outilsfonctionnels.dom;

import fr.unedic.util.temps.Damj;

public class ResultatImputationSuiteArce
{
  private boolean isDeuxVersementEffectue;
  private Damj nouvelleDateLimiteIndemnisation;
  private boolean isDateLimiteImputee;
  
  public boolean isDeuxVersementEffectue()
  {
    return isDeuxVersementEffectue;
  }
  
  public void setDeuxVersementEffectue(boolean isDeuxVersementEffectue)
  {
    this.isDeuxVersementEffectue = isDeuxVersementEffectue;
  }
  
  public Damj getNouvelleDateLimiteIndemnisation()
  {
    return nouvelleDateLimiteIndemnisation;
  }
  
  public void setNouvelleDateLimiteIndemnisation(Damj nouvelleDateLimiteIndemnisation)
  {
    this.nouvelleDateLimiteIndemnisation = nouvelleDateLimiteIndemnisation;
  }
  
  public boolean isDateLimiteImputee()
  {
    return isDateLimiteImputee;
  }
  
  public void setDateLimiteImputee(boolean isDateLimiteImputee)
  {
    this.isDateLimiteImputee = isDateLimiteImputee;
  }
}

/* Location:
 * Qualified Name:     ResultatImputationSuiteArce
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */