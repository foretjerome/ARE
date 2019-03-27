package fr.unedic.cali.dom;

import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;

public abstract interface ResultatTraitementReliquatSpec
{
  public abstract boolean isReliquatValide();
  
  public abstract boolean getReliquatValide();
  
  public abstract void setContexteExamen(int paramInt);
  
  public abstract void setReliquatValide(boolean paramBoolean);
  
  public abstract Quantite getQuantiteReliquat();
  
  public abstract void setQuantiteReliquat(Quantite paramQuantite);
  
  public abstract void setCauseNonvalidite(int paramInt);
  
  public abstract void setDateNonValidite(Damj paramDamj);
  
  public abstract Damj getDateNonValidite();
}

/* Location:
 * Qualified Name:     ResultatTraitementReliquatSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */