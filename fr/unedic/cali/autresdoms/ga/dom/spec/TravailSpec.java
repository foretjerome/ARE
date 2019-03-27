package fr.unedic.cali.autresdoms.ga.dom.spec;

import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.util.temps.Periode;

public abstract interface TravailSpec
  extends ConflitSpec
{
  public static final int PRIORITE_ATTESTE = 1;
  public static final int PRIORITE_QUALIFIE = 2;
  public static final int PRIORITE_NON_QUALIFIE = 3;
  public static final int PRIORITE_DECLARE = 4;
  public static final int PRIORITE_DEFAUT = 100;
  
  public abstract Periode getPeriode();
  
  public abstract int getTypePeriode();
  
  public abstract boolean estParticipantLiquidation();
  
  public abstract String getIdentifiant();
  
  public abstract Entreprise getEntreprise();
  
  public abstract int getPrioriteStatut();
}

/* Location:
 * Qualified Name:     TravailSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */