package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.util.temps.Damj;

public abstract interface DelaiRechercheProduitSpec
  extends ObjetPersistantSpec
{
  public abstract Damj getDebut();
  
  public abstract Damj getFin();
  
  public abstract int getDuree();
}

/* Location:
 * Qualified Name:     DelaiRechercheProduitSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */