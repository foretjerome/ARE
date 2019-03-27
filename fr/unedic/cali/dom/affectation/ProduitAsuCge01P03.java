package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuCge01P03
  extends ProduitAsuAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.cge01.p03.ProduitDelegue";
  private static final String LIB_COURT = "ARE2006 CGE";
  private static final String LIB_LONG = "Produit ARE 2006 Cas général";
  private static final int ANNEE_2006 = 2006;
  private static final int JANVIER = 1;
  private static final int JOUR_DEBUT = 18;
  private static final Damj DEBUT = new Damj(2006, 1, 18);
  private static final int ANNEE_2009 = 2009;
  private static final int MARS = 3;
  private static final int DERNIER_JOUR = 31;
  private static final Damj FIN = new Damj(2009, 3, 31);
  private static ProduitAsuCge01P03 s_instanceUnique = null;
  
  public static ProduitAsuCge01P03 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCge01P03();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCge01P03();
    }
    return s_instanceUnique;
  }
  
  protected ProduitAsuCge01P03()
  {
    setLibelleCourt("ARE2006 CGE");
    setLibelleLong("Produit ARE 2006 Cas général");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.cge01.p03.ProduitDelegue"));
    
    setCode(13);
    setNomUnique("ASU_CGE01_03");
    
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
    return true;
  }
  
  public boolean neDoitPasSanctionnerPndsPourCouvertureDv()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuCge01P03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */