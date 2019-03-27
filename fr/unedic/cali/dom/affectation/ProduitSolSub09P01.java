package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitSolSub09P01
  extends ProduitSolAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.sol.sub09.p01.ProduitDelegue";
  private static final String LIB_COURT = "AEPE";
  private static final String LIB_LONG = "Allocation Exceptionnelle Pour l'Emploi";
  private static final Damj DEBUT = new Damj(2010, 6, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitSolSub09P01 s_instanceUnique = null;
  
  public static ProduitSolSub09P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitSolSub09P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitSolSub09P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitSolSub09P01()
  {
    setLibelleCourt("AEPE");
    setLibelleLong("Allocation Exceptionnelle Pour l'Emploi");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.sol.sub09.p01.ProduitDelegue"));
    
    setCode(40);
    setNomUnique("SOL_SUB09_01");
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
 * Qualified Name:     ProduitSolSub09P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */