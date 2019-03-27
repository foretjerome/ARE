package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DossierExamenSpec;

public abstract class ProduitSecurisationProfessionnelleAbstrait
  extends ProduitAsuAbstrait
  implements ProduitSecurisationProfessionnelleSpec
{
  private ProduitSecurisationProfessionnelleDelegueSpec getProduitAsuDelegue()
  {
    return (ProduitSecurisationProfessionnelleDelegueSpec)getProduitDelegue();
  }
  
  public ProduitAsuSpec recupererProduitAreActif(DossierExamenSpec p_dossierExamen)
  {
    if (getProduitAsuDelegue() == null) {
      return null;
    }
    return getProduitAsuDelegue().recupererProduitAreActif(p_dossierExamen);
  }
}

/* Location:
 * Qualified Name:     ProduitSecurisationProfessionnelleAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */