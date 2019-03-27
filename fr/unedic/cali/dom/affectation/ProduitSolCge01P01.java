package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitSolCge01P01
  extends ProduitSolAbstrait
{
  private static final long serialVersionUID = 2211313140458128886L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.sol.cge01.p01.ProduitDelegue";
  private static final String LIB_COURT = "ASS2004";
  private static final String LIB_LONG = "Produit ASS 2004 Cas général";
  private static final Damj DEBUT = new Damj(2004, 1, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitSolCge01P01 s_instanceUnique = null;
  
  public static ProduitSolCge01P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitSolCge01P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitSolCge01P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitSolCge01P01()
  {
    setLibelleCourt("ASS2004");
    setLibelleLong("Produit ASS 2004 Cas général");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.sol.cge01.p01.ProduitDelegue"));
    
    setCode(9);
    setNomUnique("SOL_CGE01_01");
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
 * Qualified Name:     ProduitSolCge01P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */