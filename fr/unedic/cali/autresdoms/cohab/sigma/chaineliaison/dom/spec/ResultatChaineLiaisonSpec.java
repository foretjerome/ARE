package fr.unedic.cali.autresdoms.cohab.sigma.chaineliaison.dom.spec;

public abstract interface ResultatChaineLiaisonSpec
{
  public abstract boolean isFluxV1V2Correct();
  
  public abstract boolean isFluxV2V1Correct();
  
  public abstract boolean isFluxV2V2Correct();
  
  public abstract void setFluxV1V2Correct(boolean paramBoolean);
  
  public abstract void setFluxV2V1Correct(boolean paramBoolean);
  
  public abstract void setFluxV2V2Correct(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     ResultatChaineLiaisonSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */