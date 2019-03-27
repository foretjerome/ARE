package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public final class ProduitAsuSpe02P04
  extends ProduitAsuSpectacleAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.spe02.p04.ProduitDelegue";
  private static final String LIB_COURT = "ARE SPE R14";
  private static final String LIB_LONG = "Produit ARE 2014 Spectacle";
  private static final Damj DEBUT = new Damj(2014, 7, 1);
  private static final Damj FIN = new Damj(2016, 7, 31);
  private static ProduitAsuSpe02P04 instanceUnique = null;
  
  public static ProduitAsuSpe02P04 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSpe02P04();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSpe02P04();
    }
    return instanceUnique;
  }
  
  private ProduitAsuSpe02P04()
  {
    setLibelleCourt("ARE SPE R14");
    setLibelleLong("Produit ARE 2014 Spectacle");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.spe02.p04.ProduitDelegue"));
    
    setCode(64);
    setNomUnique("ASU_SPE02_04");
    
    ajouterReglement(Reglement.getInstance("A8", this));
    ajouterReglement(Reglement.getInstance("A10", this));
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec produit)
  {
    return (getCode() == produit.getCode()) || (ProduitAsuSpe02P03.getInstance().getCode() == produit.getCode());
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
 * Qualified Name:     ProduitAsuSpe02P04
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */