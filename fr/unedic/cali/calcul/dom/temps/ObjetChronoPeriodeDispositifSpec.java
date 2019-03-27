package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.util.temps.Damj;

public abstract interface ObjetChronoPeriodeDispositifSpec
  extends ObjetPersistantSpec
{
  public static final String TYPE_DISPOSITIF_2004 = "1";
  public static final String TYPE_DISPOSITIF_2006 = "2";
  public static final String TYPE_DISPOSITIF_2017 = "3";
  
  public abstract String getTypeDispositif();
  
  public abstract Damj getDateDebut();
  
  public abstract Damj getDateFin();
  
  public abstract void setDateDebut(Damj paramDamj);
  
  public abstract void setDateFin(Damj paramDamj);
  
  public abstract void setTypeDispositif(String paramString);
  
  public abstract ObjetChronoPeriodeCalculCREM getObjetChronoPeriode();
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeDispositifSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */