package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitForAff03P01
  extends ProduitForAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.form.aff03.p01.ProduitDelegue";
  private static final String LIB_COURT = "AFF2001";
  private static final String LIB_LONG = "Produit AFF 2001";
  private static final Damj DEBUT = new Damj(2001, 1, 1);
  private static final Damj FIN = new Damj(2010, 12, 31);
  private static ProduitForAff03P01 s_instanceUnique = null;
  
  public static ProduitForAff03P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitForAff03P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitForAff03P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitForAff03P01()
  {
    setCode(2);
    setNomUnique("FOR_AFF03_01");
    setLibelleCourt("AFF2001");
    setLibelleLong("Produit AFF 2001");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.form.aff03.p01.ProduitDelegue"));
    
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_CALCULE", this));
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("STATUT_UT_FORCE", this));
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return getCode() == p_produit.getCode();
  }
}

/* Location:
 * Qualified Name:     ProduitForAff03P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */