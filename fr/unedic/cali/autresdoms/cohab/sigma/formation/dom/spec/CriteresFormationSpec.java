package fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.spec;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec.CriteresSpec;
import fr.unedic.util.temps.Damj;

public abstract interface CriteresFormationSpec
  extends CriteresSpec
{
  public abstract int getIdentifiantActionFormation();
  
  public abstract String getNumeroAllocataire();
  
  public abstract void setIdentifiantActionFormation(int paramInt);
  
  public abstract void setNumeroAllocataire(String paramString);
  
  public abstract Damj getDateRecherche();
  
  public abstract void setDateRecherche(Damj paramDamj);
}

/* Location:
 * Qualified Name:     CriteresFormationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */