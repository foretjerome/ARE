package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitSolAer05P03
  extends ProduitSolAbstrait
{
  private static final long serialVersionUID = 2211313140458128886L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.sol.aer05.p03.ProduitDelegue";
  private static final String LIB_COURT = "ATS 2013";
  private static final String LIB_LONG = "Allocation transitoire de solidarité 2013";
  private static final Damj DEBUT = new Damj(2013, 3, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitSolAer05P03 s_instanceUnique = null;
  
  public static ProduitSolAer05P03 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitSolAer05P03();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitSolAer05P03();
    }
    return s_instanceUnique;
  }
  
  private ProduitSolAer05P03()
  {
    setLibelleCourt("ATS 2013");
    setLibelleLong("Allocation transitoire de solidarité 2013");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.sol.aer05.p03.ProduitDelegue"));
    
    setCode(55);
    setNomUnique("SOL_AER05_03");
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
 * Qualified Name:     ProduitSolAer05P03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */