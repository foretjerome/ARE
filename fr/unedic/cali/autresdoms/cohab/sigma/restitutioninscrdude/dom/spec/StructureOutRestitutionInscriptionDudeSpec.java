package fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.spec;

import fr.unedic.util.temps.Damj;

public abstract interface StructureOutRestitutionInscriptionDudeSpec
{
  public abstract Damj getDatePreInscription();
  
  public abstract String getTypePEC();
  
  public abstract String getSousTypePEC();
  
  public abstract void setDatePreInscription(Damj paramDamj);
  
  public abstract void setTypePEC(String paramString);
  
  public abstract void setSousTypePEC(String paramString);
}

/* Location:
 * Qualified Name:     StructureOutRestitutionInscriptionDudeSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */