package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionAssurancePourProduit
  extends FiltreAttribution
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  private ProduitSpec m_produit;
  
  public FiltreAttributionAssurancePourProduit(ProduitSpec p_produit)
  {
    m_produit = p_produit;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(DemandeSpec.class))
    {
      DemandeSpec demande = (DemandeSpec)p_temporel;
      return (super.accepter(demande)) && (m_produit.equals(demande.getDossierAffectation().getProduit()));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreAttributionAssurancePourProduit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */