package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;

public abstract class ProduitDecAbstrait
  extends ProduitAbstrait
  implements ProduitDecSpec
{
  private static final long serialVersionUID = 7571389157979345486L;
  
  public void controlerContexteDonneesForcees(Contexte p_contexte)
    throws ContexteException, ApplicativeException
  {
    getProduitDecDelegue().controlerContexteDonneesForcees(p_contexte);
  }
  
  public String determinerPeriodeGaecAChargerSurLectureDecision(DemandeSpec p_demandeDecisionne)
  {
    if (getProduitDecDelegue() == null) {
      return null;
    }
    return getProduitDecDelegue().determinerPeriodeGaecAChargerSurLectureDecision(p_demandeDecisionne);
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return getCode() == p_produit.getCode();
  }
  
  protected ProduitDecDelegueSpec getProduitDecDelegue()
  {
    return (ProduitDecDelegueSpec)getProduitDelegue();
  }
}

/* Location:
 * Qualified Name:     ProduitDecAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */