package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuSsp07P04
  extends ProduitAsuSpectacleAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.ssp07.p04.ProduitDelegue";
  private static final String LIB_COURT = "APS R14";
  private static final String LIB_LONG = "Allocation de professionnalisation et de solidarité 2014";
  private static final Damj DEBUT = new Damj(2014, 7, 1);
  private static ProduitAsuSsp07P04 instanceUnique = null;
  
  private ProduitAsuSsp07P04()
  {
    setLibelleCourt("APS R14");
    setLibelleLong("Allocation de professionnalisation et de solidarité 2014");
    
    Damj dateFinProduit = null;
    try
    {
      dateFinProduit = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de debut des produits APS17 et AFD17").veille();
    }
    catch (CoucheLogiqueException e)
    {
      throw new ApplicativeRuntimeException(e.getCode());
    }
    setPeriodeValidite(new Periode(DEBUT, dateFinProduit));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.ssp07.p04.ProduitDelegue"));
    
    setCode(27);
    setNomUnique("ASU_SSP07_03");
    
    ajouterReglement(Reglement.getInstance("A8", this));
    ajouterReglement(Reglement.getInstance("A10", this));
  }
  
  public static ProduitAsuSsp07P04 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSsp07P04();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSsp07P04();
    }
    return instanceUnique;
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
 * Qualified Name:     ProduitAsuSsp07P04
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */