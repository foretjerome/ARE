package fr.unedic.cali.dom;

import fr.unedic.util.Quantite;

public abstract interface ImputationSpec
{
  public abstract boolean estImpute();
  
  public abstract Quantite getResteAImputer();
  
  public abstract void setImpute(boolean paramBoolean);
  
  public abstract void setResteAImputer(Quantite paramQuantite);
  
  public abstract QuantiteDroitSpec getQuantiteDroit();
  
  public abstract void setQuantiteDroit(QuantiteDroitSpec paramQuantiteDroitSpec);
}

/* Location:
 * Qualified Name:     ImputationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */