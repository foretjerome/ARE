package fr.unedic.cali.autresdoms.ga.dom.spec;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Periode;
import java.util.Hashtable;

public abstract interface AppartenanceSpec
  extends ObjetMetierSpec
{
  public static final int NATURE_APPARTENANCE_INDETERMINEE = -1;
  public static final int NATURE_AFFILIATION = 0;
  public static final int NATURE_ASSIMILATION = 1;
  
  public abstract boolean produitAppartenance();
  
  public abstract int getNatureAppartenance();
  
  public abstract Hashtable getListeQuantitesAppartenance();
  
  public abstract boolean isDerogationPlafondMensuel();
  
  public abstract Periode getPeriode();
  
  public abstract boolean estSanctionne();
}

/* Location:
 * Qualified Name:     AppartenanceSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */