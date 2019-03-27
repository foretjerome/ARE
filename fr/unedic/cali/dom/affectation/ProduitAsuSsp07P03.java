package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public final class ProduitAsuSsp07P03
  extends ProduitAsuSpectacleAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.ssp07.p03.ProduitDelegue";
  private static final String LIB_COURT = "APS R07";
  private static final String LIB_LONG = "Allocation de professionnalisation et de solidarité 2007";
  private static final Damj DEBUT = new Damj(2007, 4, 1);
  private static final Damj FIN = new Damj(2014, 6, 30);
  private static ProduitAsuSsp07P03 instanceUnique = null;
  
  public static ProduitAsuSsp07P03 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSsp07P03();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSsp07P03();
    }
    return instanceUnique;
  }
  
  public ProduitAsuSsp07P03()
  {
    setLibelleCourt("APS R07");
    setLibelleLong("Allocation de professionnalisation et de solidarité 2007");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.ssp07.p03.ProduitDelegue"));
    
    setCode(27);
    setNomUnique("ASU_SSP07_03");
    
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
 * Qualified Name:     ProduitAsuSsp07P03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */