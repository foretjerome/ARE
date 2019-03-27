package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.FormuleMontantSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;

public abstract interface FacadeLiquidationProduitPrrSpec
  extends FacadeLiquidationProduitSpec
{
  public abstract Resultat traiterObjectifAdmission(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract AttributionSpec creerAttribution();
  
  public abstract FormuleMontantSpec getFormuleMontant(String paramString);
}

/* Location:
 * Qualified Name:     FacadeLiquidationProduitPrrSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */