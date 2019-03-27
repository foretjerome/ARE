package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitForAff03P03
  extends ProduitForAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.form.aff03.p03.ProduitDelegue";
  private static final String LIB_COURT = "RFF2011";
  private static final String LIB_LONG = "Rémunération de Fin de Formation 2011";
  private static final Damj DEBUT = new Damj(2011, 1, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitForAff03P03 s_instanceUnique = null;
  
  public static ProduitForAff03P03 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitForAff03P03();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitForAff03P03();
    }
    return s_instanceUnique;
  }
  
  private ProduitForAff03P03()
  {
    setCode(47);
    setNomUnique("FOR_AFF03_03");
    setLibelleCourt("RFF2011");
    setLibelleLong("Rémunération de Fin de Formation 2011");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.form.aff03.p03.ProduitDelegue"));
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
 * Qualified Name:     ProduitForAff03P03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */