package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.util.temps.Periode;

public abstract interface ValidationProduitSpec
  extends ObjetPersistantSpec
{
  public abstract ActiviteSalarie getPeriodeValidationProduit();
  
  public abstract void setPeriodeValidationProduit(ActiviteSalarie paramActiviteSalarie);
  
  public abstract boolean isEstProduitValide();
  
  public abstract Reglement getReglementApplicable();
  
  public abstract Periode getPeriodePra();
}

/* Location:
 * Qualified Name:     ValidationProduitSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */