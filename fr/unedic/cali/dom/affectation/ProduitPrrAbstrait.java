package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.FormuleMontantSpec;

public abstract class ProduitPrrAbstrait
  extends ProduitAbstrait
  implements ProduitPrrSpec
{
  private static final long serialVersionUID = 2824204566932251437L;
  
  public String determinerPeriodeGaecAChargerSurLectureDecision(DemandeSpec p_demandeDecisionne)
  {
    if (getProduitPrrDelegue() == null) {
      return null;
    }
    return getProduitPrrDelegue().determinerPeriodeGaecAChargerSurLectureDecision(p_demandeDecisionne);
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return getCode() == p_produit.getCode();
  }
  
  protected ProduitPrrDelegueSpec getProduitPrrDelegue()
  {
    return (ProduitPrrDelegueSpec)getProduitDelegue();
  }
  
  public FormuleMontantSpec getFormuleMontant(String p_code)
  {
    return getProduitPrrDelegue().getFormuleMontant(p_code);
  }
}

/* Location:
 * Qualified Name:     ProduitPrrAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */