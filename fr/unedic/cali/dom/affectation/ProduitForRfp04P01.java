package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitForRfp04P01
  extends ProduitForAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.form.rfp04.p01.ProduitDelegue";
  private static final String LIB_COURT = "RFP 2009";
  private static final String LIB_LONG = "Produit RFP 2009";
  private static final Damj DEBUT = new Damj(2009, 1, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitForRfp04P01 s_instanceUnique = null;
  
  public static ProduitForRfp04P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitForRfp04P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitForRfp04P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitForRfp04P01()
  {
    setCode(34);
    setNomUnique("FOR_RFP04_01");
    setLibelleCourt("RFP 2009");
    setLibelleLong("Produit RFP 2009");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.form.rfp04.p01.ProduitDelegue"));
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
 * Qualified Name:     ProduitForRfp04P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */