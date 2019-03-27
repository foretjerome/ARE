package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public final class ProduitAsuSpe02P03
  extends ProduitAsuSpectacleAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.spe02.p03.ProduitDelegue";
  private static final String LIB_COURT = "ARE SPE R07";
  private static final String LIB_LONG = "Produit ARE 2007 Spectacle";
  private static final Damj DEBUT = new Damj(2007, 4, 1);
  private static final Damj FIN = new Damj(2014, 6, 30);
  private static ProduitAsuSpe02P03 instanceUnique = null;
  
  public static ProduitAsuSpe02P03 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSpe02P03();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSpe02P03();
    }
    return instanceUnique;
  }
  
  private ProduitAsuSpe02P03()
  {
    setLibelleCourt("ARE SPE R07");
    setLibelleLong("Produit ARE 2007 Spectacle");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.spe02.p03.ProduitDelegue"));
    
    setCode(20);
    setNomUnique("ASU_SPE02_03");
    
    ajouterReglement(Reglement.getInstance("A8", this));
    ajouterReglement(Reglement.getInstance("A10", this));
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec produit)
  {
    return getCode() == produit.getCode();
  }
  
  public boolean estUnProduitRevisable()
  {
    return false;
  }
  
  public boolean estProduitGerantFranchiseCP()
  {
    return false;
  }
  
  public boolean estProduitGerantFranchiseSalaire()
  {
    return false;
  }
  
  public boolean neDoitPasSanctionnerPndsPourCouvertureDv()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuSpe02P03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */