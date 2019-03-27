package fr.unedic.cali.dom.affectation;

import fr.pe.cali.liquidation.outilsfonctionnels.dom.ResultatImputationSuiteArce;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.affectation.spec.IProduitAsuSansDuree;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuSsp07P05
  extends ProduitAsuSpectacleAbstrait
  implements IProduitAsuSansDuree
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.ssp07.p05.ProduitDelegue";
  private static final String LIB_COURT = "APS R17";
  private static final String LIB_LONG = "Allocation de professionnalisation et de solidarité 2017";
  private static ProduitAsuSsp07P05 instanceUnique = null;
  
  private ProduitAsuSsp07P05()
  {
    setLibelleCourt("APS R17");
    setLibelleLong("Allocation de professionnalisation et de solidarité 2017");
    Damj dateDebutProduit = null;
    Damj dateFinProduit = Damj.FIN_DES_TEMPS;
    try
    {
      dateDebutProduit = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de debut des produits APS17 et AFD17");
    }
    catch (CoucheLogiqueException e)
    {
      throw new ApplicativeRuntimeException(e.getCode());
    }
    setPeriodeValidite(new Periode(dateDebutProduit, dateFinProduit));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.ssp07.p05.ProduitDelegue"));
    
    setCode(75);
    setNomUnique("ASU_SSP07_05");
    
    ajouterReglement(Reglement.getInstance("A8", this));
    ajouterReglement(Reglement.getInstance("A10", this));
  }
  
  public static ProduitAsuSsp07P05 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSsp07P05();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSsp07P05();
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
    return true;
  }
  
  public boolean estProduitGerantFranchiseSalaire()
  {
    return true;
  }
  
  public boolean neDoitPasSanctionnerPndsPourCouvertureDv()
  {
    return false;
  }
  
  public boolean estUnProduitSansDuree()
  {
    return true;
  }
  
  public Quantite getDureeRestante(AttributionSpec attribution, Damj dateCalcul)
    throws ApplicativeException
  {
    throw new UnsupportedOperationException("Cette méthode ne doit pas être appelée.");
  }
  
  public ResultatImputationSuiteArce traiterImputationSuiteArce(AttributionSpec attributionPrecedente, Damj dateExamen)
    throws ApplicativeException
  {
    return new ResultatImputationSuiteArce();
  }
}

/* Location:
 * Qualified Name:     ProduitAsuSsp07P05
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */