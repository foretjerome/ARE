package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuCve13P01
  extends ProduitAsuAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.cve13.p01.ProduitDelegue";
  private static final String LIB_COURT = "ATP";
  private static final String LIB_LONG = "Allocation de Transition Professionnelle";
  private static final Damj DEBUT = new Damj(2009, 4, 1);
  private static final Damj FIN = new Damj(2011, 8, 31);
  private static ProduitAsuCve13P01 s_instanceUnique = null;
  
  public static ProduitAsuCve13P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCve13P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCve13P01();
    }
    return s_instanceUnique;
  }
  
  public ProduitAsuCve13P01()
  {
    setLibelleCourt("ATP");
    setLibelleLong("Allocation de Transition Professionnelle");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.cve13.p01.ProduitDelegue"));
    setCode(39);
    setNomUnique("ASU_CVE13_01");
    
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
    
    ajouterElementForcable(ElementForcable.getInstance("STATUT_UT_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("NEUTRALISE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("TYPE_NEUTRALISATION_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("MONTANT_NET_REVENUS_ACTIVITE_REPRISE_FORCE", this));
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return getCode() == p_produit.getCode();
  }
  
  public int getTypePaiement()
  {
    return 0;
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
 * Qualified Name:     ProduitAsuCve13P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */