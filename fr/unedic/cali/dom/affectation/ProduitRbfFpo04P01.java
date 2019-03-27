package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitRbfFpo04P01
  extends ProduitRbfAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.rbf.fpo04.p01.ProduitDelegue";
  private static final String LIB_COURT = "FPO";
  private static final String LIB_LONG = "Frais pédagogique";
  private static final Damj DEBUT = new Damj(2003, 1, 1);
  private static final Damj FIN = new Damj(2008, 12, 31);
  private static ProduitRbfFpo04P01 s_instanceUnique = null;
  
  public static ProduitRbfFpo04P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfFpo04P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfFpo04P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitRbfFpo04P01()
  {
    setLibelleCourt("FPO");
    setLibelleLong("Frais pédagogique");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.rbf.fpo04.p01.ProduitDelegue"));
    setCode(7);
    setNomUnique("RBF_FPO04_01");
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
 * Qualified Name:     ProduitRbfFpo04P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */