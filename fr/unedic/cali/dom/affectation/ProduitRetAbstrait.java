package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DemandeSpec;

public class ProduitRetAbstrait
  extends ProduitAbstrait
  implements ProduitRetSpec
{
  private static final long serialVersionUID = 1L;
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return false;
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public String determinerPeriodeGaecAChargerSurLectureDecision(DemandeSpec p_demandeDecisionne)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     ProduitRetAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */