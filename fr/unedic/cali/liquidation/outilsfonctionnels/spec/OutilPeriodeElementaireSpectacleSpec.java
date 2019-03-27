package fr.unedic.cali.liquidation.outilsfonctionnels.spec;

import fr.unedic.cali.dom.spec.PeriodeElementaireAffiliationSpec;
import fr.unedic.util.Convertisseur;
import fr.unedic.util.Quantite;

public abstract interface OutilPeriodeElementaireSpectacleSpec
{
  public abstract Quantite calculerQuantiteAppartenanceARetenir(PeriodeElementaireAffiliationSpec paramPeriodeElementaireAffiliationSpec, Convertisseur paramConvertisseur);
}

/* Location:
 * Qualified Name:     OutilPeriodeElementaireSpectacleSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */