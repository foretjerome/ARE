package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import java.math.BigDecimal;

public abstract interface FacadeLiquidationProduitInrPar09P01Spec
{
  public abstract BigDecimal recupererMontantAsp(DemandeSpec paramDemandeSpec)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     FacadeLiquidationProduitInrPar09P01Spec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */