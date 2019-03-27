package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public final class ProduitAsuSpe02P01
  extends ProduitAsuSpectacleAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String LIB_COURT = "ARE2004 SPE";
  private static final String LIB_LONG = "Produit ARE 2004 Spectacle";
  private static final Damj DEBUT = new Damj(2003, 1, 1);
  private static final Damj FIN = new Damj(2007, 3, 31);
  private static ProduitAsuSpe02P01 instanceUnique = null;
  
  public static ProduitAsuSpe02P01 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSpe02P01();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSpe02P01();
    }
    return instanceUnique;
  }
  
  private ProduitAsuSpe02P01()
  {
    setLibelleCourt("ARE2004 SPE");
    setLibelleLong("Produit ARE 2004 Spectacle");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(null);
    
    setCode(3);
    setNomUnique("ASU_SPE02_01");
    
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
 * Qualified Name:     ProduitAsuSpe02P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */