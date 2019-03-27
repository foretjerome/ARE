package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitInrPfm01P01
  extends ProduitInrAbstrait
{
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.inr.pfm01.p01.ProduitDelegue";
  private static final String LIB_COURT = "PFM";
  private static final String LIB_LONG = "Produit PFM";
  private static final Damj DEBUT = new Damj(2003, 1, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitInrPfm01P01 s_instanceUnique = null;
  
  public static ProduitInrPfm01P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitInrPfm01P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitInrPfm01P01();
    }
    return s_instanceUnique;
  }
  
  protected ProduitInrPfm01P01()
  {
    setLibelleCourt("PFM");
    setLibelleLong("Produit PFM");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.inr.pfm01.p01.ProduitDelegue"));
    setCode(17);
    setNomUnique("INR_PFM01_01");
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
 * Qualified Name:     ProduitInrPfm01P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */