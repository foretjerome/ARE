package fr.unedic.cali.calcul.outilsfonctionnels.dom;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.LigneSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import java.util.Comparator;

class UniteTraitementMultiProduits$AttributionComparator
  implements Comparator
{
  private UniteTraitementMultiProduits$AttributionComparator(UniteTraitementMultiProduits paramUniteTraitementMultiProduits) {}
  
  public int compare(Object p_arg0, Object p_arg1)
  {
    AttributionSpec attr0 = (AttributionSpec)p_arg0;
    AttributionSpec attr1 = (AttributionSpec)p_arg1;
    if (p_arg0 == p_arg1) {
      return 0;
    }
    if ("ASU".equals(attr0.getProduit().getLigne().getGamme().getNomUnique())) {
      return 1;
    }
    if ("ASU".equals(attr1.getProduit().getLigne().getGamme().getNomUnique())) {
      return -1;
    }
    if ("SOL".equals(attr0.getProduit().getLigne().getGamme().getNomUnique())) {
      return 1;
    }
    if ("SOL".equals(attr1.getProduit().getLigne().getGamme().getNomUnique())) {
      return -1;
    }
    if ("FOR".equals(attr0.getProduit().getLigne().getGamme().getNomUnique())) {
      return 1;
    }
    if ("FOR".equals(attr1.getProduit().getLigne().getGamme().getNomUnique())) {
      return -1;
    }
    if ("RBF_HBT01_01".equals(attr0.getProduit().getNomUnique())) {
      return 1;
    }
    if ("RBF_HBT01_01".equals(attr1.getProduit().getNomUnique())) {
      return -1;
    }
    if ("RBF_RTN03_01".equals(attr0.getProduit().getNomUnique())) {
      return 1;
    }
    if ("RBF_RTN03_01".equals(attr1.getProduit().getNomUnique())) {
      return -1;
    }
    if ("RBF_TPT02_01".equals(attr0.getProduit().getNomUnique())) {
      return 1;
    }
    if ("RBF_TPT02_01".equals(attr1.getProduit().getNomUnique())) {
      return -1;
    }
    return 1;
  }
}

/* Location:
 * Qualified Name:     UniteTraitementMultiProduits.AttributionComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */