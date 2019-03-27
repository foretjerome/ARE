package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitRbfHbt01P01
  extends ProduitRbfAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.rbf.hbt01.p01.ProduitDelegue";
  private static final String LIB_COURT = "FRAIS HBT";
  private static final String LIB_LONG = "Remboursement des frais d'hébergement";
  private static final Damj DEBUT = new Damj(2003, 1, 1);
  private static final Damj FIN = new Damj(2008, 12, 31);
  private static ProduitRbfHbt01P01 s_instanceUnique = null;
  
  public static ProduitRbfHbt01P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfHbt01P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfHbt01P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitRbfHbt01P01()
  {
    setLibelleCourt("FRAIS HBT");
    setLibelleLong("Remboursement des frais d'hébergement");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.rbf.hbt01.p01.ProduitDelegue"));
    setCode(4);
    setNomUnique("RBF_HBT01_01");
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
 * Qualified Name:     ProduitRbfHbt01P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */