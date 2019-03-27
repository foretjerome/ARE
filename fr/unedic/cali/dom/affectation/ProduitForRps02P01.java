package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitForRps02P01
  extends ProduitForAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.form.rps02.p01.ProduitDelegue";
  private static final String LIB_COURT = "RPS";
  private static final String LIB_LONG = "Produit RPS";
  private static final Damj DEBUT = new Damj(1991, 1, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitForRps02P01 s_instanceUnique = null;
  
  public static ProduitForRps02P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitForRps02P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitForRps02P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitForRps02P01()
  {
    setCode(11);
    setNomUnique("FOR_RPS02_01");
    setLibelleCourt("RPS");
    setLibelleLong("Produit RPS");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.form.rps02.p01.ProduitDelegue"));
    
    ajouterElementForcable(ElementForcable.getInstance("STATUT_UT_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("MONTANT_NET_REVENUS_ACTIVITE_REPRISE_FORCE", this));
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
 * Qualified Name:     ProduitForRps02P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */