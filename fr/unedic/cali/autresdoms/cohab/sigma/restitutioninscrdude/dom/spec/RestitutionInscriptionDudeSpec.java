package fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.spec;

import fr.unedic.util.temps.Damj;

public abstract interface RestitutionInscriptionDudeSpec
{
  public abstract Damj getDatePreInscription();
  
  public abstract void setDatePreInscription(Damj paramDamj);
  
  public abstract String getTypePEC();
  
  public abstract void setTypePEC(String paramString);
  
  public abstract String getSousTypePEC();
  
  public abstract void setSousTypePEC(String paramString);
}

/* Location:
 * Qualified Name:     RestitutionInscriptionDudeSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */