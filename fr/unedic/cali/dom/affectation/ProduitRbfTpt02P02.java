package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitRbfTpt02P02
  extends ProduitRbfAbstrait
{
  private static final long serialVersionUID = 6620259033756991713L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.rbf.tpt02.p02.ProduitDelegue";
  private static final String LIB_COURT = "AFAF-AD 09";
  private static final String LIB_LONG = "Aide au déplacement";
  private static final Damj DEBUT = new Damj(2009, 1, 1);
  private static final Damj FIN = new Damj(2014, 6, 30);
  private static ProduitRbfTpt02P02 s_instanceUnique = null;
  
  public static ProduitRbfTpt02P02 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfTpt02P02();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfTpt02P02();
    }
    return s_instanceUnique;
  }
  
  private ProduitRbfTpt02P02()
  {
    setLibelleCourt("AFAF-AD 09");
    setLibelleLong("Aide au déplacement");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.rbf.tpt02.p02.ProduitDelegue"));
    setCode(25);
    setNomUnique("RBF_TPT02_02");
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
 * Qualified Name:     ProduitRbfTpt02P02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */