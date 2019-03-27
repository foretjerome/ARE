package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitRbfAidesBan
  extends ProduitAriAbstrait
  implements ProduitAriSpec
{
  private static final long serialVersionUID = -1831348951895225014L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.rbf.aides.ProduitDelegue";
  private static final String LIB_COURT = "AIDES_BAN";
  private static final String LIB_LONG = "Expérimentation APRE";
  private static final Damj DEBUT = new Damj(2014, 1, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitRbfAidesBan s_instanceUnique = null;
  
  public static ProduitRbfAidesBan getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfAidesBan();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfAidesBan();
    }
    return s_instanceUnique;
  }
  
  private ProduitRbfAidesBan()
  {
    setLibelleCourt("AIDES_BAN");
    setLibelleLong("Expérimentation APRE");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.rbf.aides.ProduitDelegue"));
    setCode(58);
    setNomUnique("RBF_AIDES_01");
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
 * Qualified Name:     ProduitRbfAidesBan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */