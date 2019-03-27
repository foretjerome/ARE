package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DossierExamenSpec;

public abstract interface ProduitSecurisationProfessionnelleSpec
{
  public abstract ProduitAsuSpec recupererProduitAreActif(DossierExamenSpec paramDossierExamenSpec);
  
  public abstract boolean estUnProduitGerantAllongementDispositif();
}

/* Location:
 * Qualified Name:     ProduitSecurisationProfessionnelleSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */