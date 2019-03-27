package fr.unedic.cali.dom;

import fr.unedic.util.ObjetMetierSpec;

public abstract interface ObjetPersistantSpec
  extends ObjetMetierSpec
{
  public abstract String getIdentifiant();
  
  public abstract void marquerGraphePersistant();
}

/* Location:
 * Qualified Name:     ObjetPersistantSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */