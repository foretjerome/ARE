package fr.unedic.cali.dom.affectation;

public class ProduitRetAco01P01
  extends ProduitAriAbstrait
  implements ProduitAriSpec
{
  private static final long serialVersionUID = 1L;
  private static ProduitRetAco01P01 s_instanceUnique = null;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.ret.aco01.p01.ProduitDelegue";
  private static final String LIB_COURT = "ACO84";
  private static final String LIB_LONG = "Allocation Complémentaire";
  
  public static ProduitRetAco01P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRetAco01P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRetAco01P01();
    }
    return s_instanceUnique;
  }
  
  protected ProduitRetAco01P01()
  {
    setLibelleCourt("ACO84");
    setLibelleLong("Allocation Complémentaire");
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.ret.aco01.p01.ProduitDelegue"));
    setCode(41);
    setNomUnique("RET_ACO01_01");
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return false;
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     ProduitRetAco01P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */