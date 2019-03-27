package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.affectation.spec.IProduitInrArce;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class ProduitInrRce04P01
  extends ProduitInrAbstrait
  implements IProduitInrArce
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.inr.rce04.p01.ProduitDelegue";
  private static final String LIB_COURT = "ARCE";
  private static final String LIB_LONG = "Produit ARCE";
  private static final Damj DEBUT = new Damj(2006, 1, 18);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitInrRce04P01 instanceUnique = null;
  
  protected ProduitInrRce04P01()
  {
    setLibelleCourt("ARCE");
    setLibelleLong("Produit ARCE");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.inr.rce04.p01.ProduitDelegue"));
    setCode(18);
    setNomUnique("INR_RCE04_01");
  }
  
  public static ProduitInrRce04P01 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitInrRce04P01();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitInrRce04P01();
    }
    return instanceUnique;
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return getCode() == p_produit.getCode();
  }
  
  public BigDecimal recupererCapitalAttribue(AttributionSpec attribution)
  {
    return ((IProduitInrArce)getProduitDelegue()).recupererCapitalAttribue(attribution);
  }
}

/* Location:
 * Qualified Name:     ProduitInrRce04P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */