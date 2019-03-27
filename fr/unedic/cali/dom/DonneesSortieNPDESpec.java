package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;

public abstract interface DonneesSortieNPDESpec
  extends ObjetPersistantSpec
{
  public abstract void setModeTraitementDemande(String paramString);
  
  public abstract String getModeTraitementDemande();
  
  public abstract void setMotifEchecTraitempent(String paramString);
  
  public abstract String getMotifEchecTraitempent();
  
  public abstract void setDateTraitementDemande(Damj paramDamj);
  
  public abstract Damj getDateTraitementDemande();
}

/* Location:
 * Qualified Name:     DonneesSortieNPDESpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */