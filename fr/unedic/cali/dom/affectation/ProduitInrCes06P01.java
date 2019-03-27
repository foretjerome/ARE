package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitInrCes06P01
  extends ProduitInrAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.inr.ces06.p01.ProduitDelegue";
  private static final String LIB_COURT = "ACCRE ASS 2004";
  private static final String LIB_LONG = "Produit ACCRE ASS 2004";
  private static final Damj DEBUT = new Damj(2003, 1, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitInrCes06P01 s_instanceUnique = null;
  
  public static ProduitInrCes06P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitInrCes06P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitInrCes06P01();
    }
    return s_instanceUnique;
  }
  
  protected ProduitInrCes06P01()
  {
    setLibelleCourt("ACCRE ASS 2004");
    setLibelleLong("Produit ACCRE ASS 2004");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.inr.ces06.p01.ProduitDelegue"));
    setCode(16);
    setNomUnique("INR_CES06_01");
    
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
 * Qualified Name:     ProduitInrCes06P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */