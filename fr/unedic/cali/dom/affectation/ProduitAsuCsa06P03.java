package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.affectation.spec.ProduitAsuClauseSauvegardeSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuCsa06P03
  extends ProduitAsuAbstrait
  implements ProduitAsuClauseSauvegardeSpec
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.csa06.p03.ProduitDelegue";
  private static final String LIB_COURT = "C SAUVEGARDE";
  private static final String LIB_LONG = "Produit clause de sauvegarde";
  private static final int ANNEE_2009 = 2009;
  private static final int JUILLET = 4;
  private static final int JOUR_DEBUT = 1;
  private static final Damj DEBUT = new Damj(2009, 4, 1);
  private static final Damj FIN = new Damj(2011, 5, 31);
  private static ProduitAsuCsa06P03 s_instanceUnique = null;
  
  public static ProduitAsuCsa06P03 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCsa06P03();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCsa06P03();
    }
    return s_instanceUnique;
  }
  
  private ProduitAsuCsa06P03()
  {
    setLibelleCourt("C SAUVEGARDE");
    setLibelleLong("Produit clause de sauvegarde");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.csa06.p03.ProduitDelegue"));
    
    setCode(32);
    setNomUnique("ASU_CSA06_03");
    
    ajouterReglement(Reglement.getInstance("RG", this));
    ajouterReglement(Reglement.getInstance("A1", this));
    ajouterReglement(Reglement.getInstance("A2a", this));
    ajouterReglement(Reglement.getInstance("A2b", this));
    ajouterReglement(Reglement.getInstance("A3", this));
    ajouterReglement(Reglement.getInstance("A4", this));
    ajouterReglement(Reglement.getInstance("A5", this));
    ajouterReglement(Reglement.getInstance("A9A", this));
    ajouterReglement(Reglement.getInstance("A9B", this));
    ajouterReglement(Reglement.getInstance("RGP", this));
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return (getCode() == p_produit.getCode()) || (getProduitLigneCasGeneralAssocie().getCode() == p_produit.getCode());
  }
  
  public boolean estUnProduitRevisable()
  {
    return true;
  }
  
  public ProduitAsuSpec getProduitLigneCasGeneralAssocie()
  {
    return ProduitAsuCge01P04.getInstance();
  }
  
  public boolean neDoitPasSanctionnerPndsPourCouvertureDv()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuCsa06P03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */