package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuCge01P6B
  extends ProduitAsuAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.cge01.p6b.ProduitDelegue";
  private static final String LIB_COURT = "ARE2014 CGE";
  private static final String LIB_LONG = "Produit ARE 2014 Cas général";
  private static final Damj DEBUT = new Damj(2014, 7, 1);
  private static final Damj FIN = new Damj(2014, 9, 30);
  private static ProduitAsuCge01P6B s_instanceUnique = null;
  
  public static ProduitAsuCge01P6B getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCge01P6B();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCge01P6B();
    }
    return s_instanceUnique;
  }
  
  protected ProduitAsuCge01P6B()
  {
    setLibelleCourt("ARE2014 CGE");
    setLibelleLong("Produit ARE 2014 Cas général");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.cge01.p6b.ProduitDelegue"));
    
    setCode(62);
    setNomUnique("ASU_CGE01_6B");
    
    ajouterReglement(Reglement.getInstance("RG", this));
    ajouterReglement(Reglement.getInstance("OP", this));
    ajouterReglement(Reglement.getInstance("A1", this));
    ajouterReglement(Reglement.getInstance("A2a", this));
    ajouterReglement(Reglement.getInstance("A2b", this));
    ajouterReglement(Reglement.getInstance("A3", this));
    ajouterReglement(Reglement.getInstance("A4", this));
    ajouterReglement(Reglement.getInstance("A5", this));
    ajouterReglement(Reglement.getInstance("A9A", this));
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
 * Qualified Name:     ProduitAsuCge01P6B
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */