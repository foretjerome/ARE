package fr.unedic.cali.dom;

import java.util.List;

public abstract interface ConditionsAttributionSpec
  extends ObjetPersistantSpec
{
  public abstract boolean estSatisfait();
  
  public abstract List getListeConditionsAttribution();
  
  public abstract List getListeConditionsSatisfaites();
  
  public abstract List getListeConditionsNonSatisfaites();
  
  public abstract List getListeCodeMotifEchec();
}

/* Location:
 * Qualified Name:     ConditionsAttributionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */