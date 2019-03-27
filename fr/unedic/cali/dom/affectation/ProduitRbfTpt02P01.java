package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitRbfTpt02P01
  extends ProduitRbfAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.rbf.tpt02.p01.ProduitDelegue";
  private static final String LIB_COURT = "FRAIS TPT";
  private static final String LIB_LONG = "Remboursement des frais de transport";
  private static final Damj DEBUT = new Damj(2003, 1, 1);
  private static final Damj FIN = new Damj(2008, 12, 31);
  private static ProduitRbfTpt02P01 s_instanceUnique = null;
  
  public static ProduitRbfTpt02P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfTpt02P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfTpt02P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitRbfTpt02P01()
  {
    setLibelleCourt("FRAIS TPT");
    setLibelleLong("Remboursement des frais de transport");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.rbf.tpt02.p01.ProduitDelegue"));
    setCode(5);
    setNomUnique("RBF_TPT02_01");
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
 * Qualified Name:     ProduitRbfTpt02P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */