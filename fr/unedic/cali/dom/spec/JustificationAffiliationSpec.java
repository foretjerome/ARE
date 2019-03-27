package fr.unedic.cali.dom.spec;

import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Periode;

public abstract interface JustificationAffiliationSpec
{
  public abstract Periode getPeriodeRechercheAffiliation();
  
  public abstract Quantite getQuantiteAffiliation();
  
  public abstract Quantite getQuantiteAssimilation();
}

/* Location:
 * Qualified Name:     JustificationAffiliationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */