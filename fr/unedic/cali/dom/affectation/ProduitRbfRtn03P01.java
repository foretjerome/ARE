package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitRbfRtn03P01
  extends ProduitRbfAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.rbf.rtn03.p01.ProduitDelegue";
  private static final String LIB_COURT = "FRAIS RTN";
  private static final String LIB_LONG = "Remboursement des frais de restauration";
  private static final Damj DEBUT = new Damj(2003, 1, 1);
  private static final Damj FIN = new Damj(2008, 12, 31);
  private static ProduitRbfRtn03P01 s_instanceUnique = null;
  
  public static ProduitRbfRtn03P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfRtn03P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfRtn03P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitRbfRtn03P01()
  {
    setLibelleCourt("FRAIS RTN");
    setLibelleLong("Remboursement des frais de restauration");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.rbf.rtn03.p01.ProduitDelegue"));
    setCode(6);
    setNomUnique("RBF_RTN03_01");
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
 * Qualified Name:     ProduitRbfRtn03P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */