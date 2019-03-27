package fr.unedic.cali.dom.affectation.spec;

import fr.pe.cali.liquidation.outilsfonctionnels.dom.ResultatImputationSuiteArce;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;

public abstract interface IProduitAsuSansDuree
{
  public abstract Quantite getDureeRestante(AttributionSpec paramAttributionSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public abstract ResultatImputationSuiteArce traiterImputationSuiteArce(AttributionSpec paramAttributionSpec, Damj paramDamj)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     IProduitAsuSansDuree
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */