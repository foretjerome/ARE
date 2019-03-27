package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuCge01P02
  extends ProduitAsuAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final int ANNEE_2003 = 2003;
  private static final int JANVIER = 1;
  private static final int PREMIER = 1;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.cge01.p02.ProduitDelegue";
  private static final String LIB_COURT = "ARE2003 CGE";
  private static final String LIB_LONG = "Produit ARE 2003 Cas général";
  private static final Damj DEBUT = new Damj(2003, 1, 1);
  private static final Damj FIN = new Damj(2006, 1, 17);
  private static ProduitAsuCge01P02 s_instanceUnique = null;
  
  public static ProduitAsuCge01P02 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCge01P02();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCge01P02();
    }
    return s_instanceUnique;
  }
  
  protected ProduitAsuCge01P02()
  {
    setLibelleCourt("ARE2003 CGE");
    setLibelleLong("Produit ARE 2003 Cas général");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.cge01.p02.ProduitDelegue"));
    
    setCode(1);
    setNomUnique("ASU_CGE01_02");
    
    ajouterReglement(Reglement.getInstance("RG", this));
    ajouterReglement(Reglement.getInstance("OP", this));
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
    return getCode() == p_produit.getCode();
  }
  
  public boolean estUnProduitRevisable()
  {
    return false;
  }
  
  public boolean neDoitPasSanctionnerPndsPourCouvertureDv()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuCge01P02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */