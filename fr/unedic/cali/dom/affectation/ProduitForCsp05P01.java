package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitForCsp05P01
  extends ProduitAriAbstrait
  implements ProduitAriSpec
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.form.csp05.p01.ProduitDelegue";
  private static final String LIB_COURT = "PRIME_CSP";
  private static final String LIB_LONG = "Prime CSP expérimental";
  private static final Damj DEBUT = new Damj(2013, 8, 11);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitForCsp05P01 s_instanceUnique = null;
  
  public static ProduitForCsp05P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitForCsp05P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitForCsp05P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitForCsp05P01()
  {
    setCode(59);
    setNomUnique("FOR_CSP05_01");
    setLibelleCourt("PRIME_CSP");
    setLibelleLong("Prime CSP expérimental");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.form.csp05.p01.ProduitDelegue"));
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
 * Qualified Name:     ProduitForCsp05P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */