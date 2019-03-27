package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.util.temps.Damj;

public class ProduitPrrPlf03P01
  extends ProduitAriAbstrait
  implements ProduitAriSpec
{
  private static final long serialVersionUID = 1L;
  private static ProduitPrrPlf03P01 s_instanceUnique = null;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.prr.plf03.p01.ProduitDelegue";
  private static final String LIB_COURT = "AS-FNE Fractionné";
  private static final String LIB_LONG = "Allocation AS-FNE Fractionné";
  
  public static ProduitPrrPlf03P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitPrrPlf03P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitPrrPlf03P01();
    }
    return s_instanceUnique;
  }
  
  protected ProduitPrrPlf03P01()
  {
    setLibelleCourt("AS-FNE Fractionné");
    setLibelleLong("Allocation AS-FNE Fractionné");
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.prr.plf03.p01.ProduitDelegue"));
    setCode(46);
    setNomUnique("PRR_PLF03_01");
    
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_CALCULE", this));
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("STATUT_UT_FORCE", this));
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return getCode() == p_produit.getCode();
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estActif(Damj p_date)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitPrrPlf03P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */