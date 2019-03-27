package fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec;

import fr.unedic.util.temps.Damj;
import java.util.Collection;

public abstract interface StructureOutBlocageActuSpec
{
  public abstract Collection getListeBlocagesActu();
  
  public abstract void setListeBlocagesActu(Collection paramCollection);
  
  public abstract Collection getPeriodesNonPayables();
  
  public abstract void setPeriodesNonPayables(Collection paramCollection);
  
  public abstract Collection getPeriodesAbsenceRetourUL961();
  
  public abstract void setPeriodesAbsenceRetourUL961(Collection paramCollection);
  
  public abstract Collection getPeriodesPresenceRetourUL961();
  
  public abstract void setPeriodesPresenceRetourUL961(Collection paramCollection);
  
  public abstract Collection getPeriodesAbsenceRetourAMS();
  
  public abstract void setPeriodesAbsenceRetourAMS(Collection paramCollection);
  
  public abstract Collection getDonneesMoisMandates();
  
  public abstract void setDonneesMoisMandates(Collection paramCollection);
  
  public abstract Damj getDateEvtBloquant();
  
  public abstract void setDateEvtBloquant(Damj paramDamj);
  
  public abstract void setMotifEvtBloquant(String paramString);
  
  public abstract String getLibelleMotifEvtBloquant();
}

/* Location:
 * Qualified Name:     StructureOutBlocageActuSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */