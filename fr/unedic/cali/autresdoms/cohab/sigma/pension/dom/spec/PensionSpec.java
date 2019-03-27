package fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec;

import java.util.Collection;

public abstract interface PensionSpec
{
  public abstract void ajouterAvantageVieillesse(AvantageVieillesseSpec paramAvantageVieillesseSpec);
  
  public abstract Collection getListeAvantageVieillesse();
  
  public abstract void ajouterPensionInvalidite(PensionInvaliditeSpec paramPensionInvaliditeSpec);
  
  public abstract Collection getListePensionInvalidite();
}

/* Location:
 * Qualified Name:     PensionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */