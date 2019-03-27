package fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.spec;

import fr.unedic.util.temps.Damj;

public abstract interface StructureInPecV1Spec
{
  public abstract String getIdentifiantIndividu();
  
  public abstract void setIdentifiantIndividu(String paramString);
  
  public abstract String getCodeAssedic();
  
  public abstract void setCodeAssedic(String paramString);
  
  public abstract int getIdentifiantPriseEnCharge();
  
  public abstract void setIdentifiantPriseEnCharge(int paramInt);
  
  public abstract Damj getDateRecherche();
  
  public abstract void setDateRecherche(Damj paramDamj);
}

/* Location:
 * Qualified Name:     StructureInPecV1Spec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */