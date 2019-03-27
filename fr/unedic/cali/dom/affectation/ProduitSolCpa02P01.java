package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitSolCpa02P01
  extends ProduitSolAbstrait
{
  private static final long serialVersionUID = 2211313140458128886L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.sol.cpa02.p01.ProduitDelegue";
  private static final String LIB_COURT = "ASS2004";
  private static final String LIB_LONG = "Produit ASS 2004 Catégorie Particulière";
  private static final Damj DEBUT = new Damj(2003, 1, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitSolCpa02P01 s_instanceUnique = null;
  
  public static ProduitSolCpa02P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitSolCpa02P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitSolCpa02P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitSolCpa02P01()
  {
    setLibelleCourt("ASS2004");
    setLibelleLong("Produit ASS 2004 Catégorie Particulière");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.sol.cpa02.p01.ProduitDelegue"));
    
    setCode(10);
    setNomUnique("SOL_CPA02_01");
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
 * Qualified Name:     ProduitSolCpa02P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */