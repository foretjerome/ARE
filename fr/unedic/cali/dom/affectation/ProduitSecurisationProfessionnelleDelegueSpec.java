package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DossierExamenSpec;

public abstract interface ProduitSecurisationProfessionnelleDelegueSpec
  extends ProduitAsuDelegueSpec
{
  public abstract ProduitAsuSpec recupererProduitAreActif(DossierExamenSpec paramDossierExamenSpec);
}

/* Location:
 * Qualified Name:     ProduitSecurisationProfessionnelleDelegueSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */