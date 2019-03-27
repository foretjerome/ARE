package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitRbfRtn03P02
  extends ProduitRbfAbstrait
{
  private static final long serialVersionUID = 2078925607542757600L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.rbf.rtn03.p02.ProduitDelegue";
  private static final String LIB_COURT = "AFAF-FR 09";
  private static final String LIB_LONG = "Aide aux frais de restauration";
  private static final Damj DEBUT = new Damj(2009, 1, 1);
  private static final Damj FIN = new Damj(2014, 6, 30);
  private static ProduitRbfRtn03P02 s_instanceUnique = null;
  
  public static ProduitRbfRtn03P02 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfRtn03P02();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfRtn03P02();
    }
    return s_instanceUnique;
  }
  
  private ProduitRbfRtn03P02()
  {
    setLibelleCourt("AFAF-FR 09");
    setLibelleLong("Aide aux frais de restauration");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.rbf.rtn03.p02.ProduitDelegue"));
    setCode(26);
    setNomUnique("RBF_RTN03_02");
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
 * Qualified Name:     ProduitRbfRtn03P02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */