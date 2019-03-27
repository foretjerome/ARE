package fr.unedic.cali.dom;

import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.UniteTraitementAvant;
import fr.unedic.util.temps.Damj;

public abstract interface PoursuiteSpec
  extends AttributionSpec
{
  public abstract Damj getPjp();
  
  public abstract void setUniteTraitement(UniteTraitement paramUniteTraitement);
  
  public abstract void setUniteTraitementAvant(UniteTraitementAvant paramUniteTraitementAvant);
  
  public abstract UniteTraitement getUniteTraitement();
  
  public abstract UniteTraitementAvant getUniteTraitementAvant();
}

/* Location:
 * Qualified Name:     PoursuiteSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */