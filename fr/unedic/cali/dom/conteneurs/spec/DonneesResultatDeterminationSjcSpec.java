package fr.unedic.cali.dom.conteneurs.spec;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;

public abstract interface DonneesResultatDeterminationSjcSpec
  extends ConteneurDonneesResultatSpec
{
  public abstract Hashtable getListeAlertesNonBloquantes();
  
  public abstract void setListeAlertesNonBloquantes(Hashtable paramHashtable);
  
  public abstract Hashtable getListeDonneesResultatDeterminationSjr();
  
  public abstract void setListeDonneesResultatDeterminationSjr(Hashtable paramHashtable);
  
  public abstract ArrayList getListeSjrActiviteConservee();
  
  public abstract void setListeSjrActiviteConservee(ArrayList paramArrayList);
  
  public abstract BigDecimal getSjci();
  
  public abstract void setSjci(BigDecimal paramBigDecimal);
}

/* Location:
 * Qualified Name:     DonneesResultatDeterminationSjcSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */