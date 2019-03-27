package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.cali.dom.affectation.spec.ProduitAsuClauseSauvegardeSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuCsa06P01
  extends ProduitAsuAbstrait
  implements ProduitAsuClauseSauvegardeSpec
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.csa06.p01.ProduitDelegue";
  private static final String LIB_COURT = "C SAUVEGARDE";
  private static final String LIB_LONG = "Produit clause de sauvegarde";
  private static final Damj DEBUT = new Damj(2003, 1, 1);
  private static final Damj FIN = new Damj(2006, 1, 17);
  private static ProduitAsuCsa06P01 s_instanceUnique = null;
  
  public static ProduitAsuCsa06P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCsa06P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCsa06P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitAsuCsa06P01()
  {
    setLibelleCourt("C SAUVEGARDE");
    setLibelleLong("Produit clause de sauvegarde");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.csa06.p01.ProduitDelegue"));
    
    setCode(8);
    setNomUnique("ASU_CSA06_01");
    
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
    
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_CALCULE", this));
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_SANCTION_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_SANCTION_CALCULE", this));
    ajouterElementForcable(ElementForcable.getInstance("STATUT_UT_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("NEUTRALISE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("TYPE_NEUTRALISATION_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("REPRISE_MEME_EMPLOYEUR_CALCULE", this));
    ajouterElementForcable(ElementForcable.getInstance("REPRISE_MEME_EMPLOYEUR_FORCE", this));
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
    return false;
  }
  
  public ProduitAsuSpec getProduitLigneCasGeneralAssocie()
  {
    return ProduitAsuCge01P02.getInstance();
  }
  
  public boolean neDoitPasSanctionnerPndsPourCouvertureDv()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuCsa06P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */