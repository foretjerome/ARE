package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.util.temps.Damj;

public abstract interface CalendrierExecutionAvantSpec
  extends ObjetPersistantSpec
{
  public abstract Damj getDernierJourAvant();
  
  public abstract Damj getPremierJourAvant();
  
  public abstract EtatAuDernierJourAvant getEtatAuDernierJourAvant();
  
  public abstract void setDernierJourAvant(Damj paramDamj);
  
  public abstract void setPremierJourAvant(Damj paramDamj);
  
  public abstract Damj getDateDrv();
}

/* Location:
 * Qualified Name:     CalendrierExecutionAvantSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */