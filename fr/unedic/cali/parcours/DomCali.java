package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Dom;

public abstract interface DomCali
  extends Dom
{
  public abstract IndividuSpec getIndividu();
  
  public abstract void setIndividu(IndividuSpec paramIndividuSpec);
  
  public abstract ContexteService getContexteService();
  
  public abstract void setContexteService(ContexteService paramContexteService);
  
  public abstract boolean isMajDossierAllocataire();
  
  public abstract void setMajDossierAllocataire(boolean paramBoolean);
  
  public abstract boolean isSauvegarderCrem();
  
  public abstract void setSauvegarderCrem(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     DomCali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */