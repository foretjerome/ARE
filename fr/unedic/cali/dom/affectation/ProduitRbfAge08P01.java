package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitRbfAge08P01
  extends ProduitRbfAbstrait
{
  private static final long serialVersionUID = -1831348951895225014L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.rbf.age08.p01.ProduitDelegue";
  private static final String LIB_COURT = "AGEPI";
  private static final String LIB_LONG = "Aide à la garde d'enfants pour parent isolé";
  private static final Damj DEBUT = new Damj(2014, 1, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitRbfAge08P01 s_instanceUnique = null;
  
  public static ProduitRbfAge08P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfAge08P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfAge08P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitRbfAge08P01()
  {
    setLibelleCourt("AGEPI");
    setLibelleLong("Aide à la garde d'enfants pour parent isolé");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.rbf.age08.p01.ProduitDelegue"));
    setCode(57);
    setNomUnique("RBF_AGE08_01");
  }
  
  public int getTypePaiement()
  {
    return 1;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return getCode() == p_produit.getCode();
  }
}

/* Location:
 * Qualified Name:     ProduitRbfAge08P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */