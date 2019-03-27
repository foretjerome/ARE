package fr.unedic.cali.dom.conteneurs.spec;

import java.math.BigDecimal;
import java.util.Hashtable;

public abstract interface DonneesResultatDeterminationSjrSpec
  extends ConteneurDonneesResultatSpec
{
  public abstract Hashtable getListeAlertesNonBloquantes();
  
  public abstract void setListeAlertesNonBloquantes(Hashtable paramHashtable);
  
  public abstract BigDecimal getPlafondSjr();
  
  public abstract void setPlafondSjr(BigDecimal paramBigDecimal);
  
  public abstract BigDecimal getSjri();
  
  public abstract void setSjri(BigDecimal paramBigDecimal);
}

/* Location:
 * Qualified Name:     DonneesResultatDeterminationSjrSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */