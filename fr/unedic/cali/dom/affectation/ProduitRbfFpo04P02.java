package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitRbfFpo04P02
  extends ProduitRbfAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.rbf.fpo04.p02.ProduitDelegue";
  private static final String LIB_COURT = "FPO";
  private static final String LIB_LONG = "Frais pédagogique";
  private static final Damj DEBUT = new Damj(2009, 1, 1);
  private static final Damj FIN = new Damj(2014, 6, 30);
  private static ProduitRbfFpo04P02 s_instanceUnique = null;
  
  public static ProduitRbfFpo04P02 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfFpo04P02();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfFpo04P02();
    }
    return s_instanceUnique;
  }
  
  private ProduitRbfFpo04P02()
  {
    setLibelleCourt("FPO");
    setLibelleLong("Frais pédagogique");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.rbf.fpo04.p02.ProduitDelegue"));
    setCode(35);
    setNomUnique("RBF_FPO04_02");
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
 * Qualified Name:     ProduitRbfFpo04P02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */