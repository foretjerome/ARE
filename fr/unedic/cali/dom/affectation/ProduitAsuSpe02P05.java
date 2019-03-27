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

public class ProduitAsuSpe02P05
  extends ProduitAsuSpectacleAbstrait
  implements IProduitAsuSansDuree
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.spe02.p05.ProduitDelegue";
  private static final String LIB_COURT = "ARE SPE R16";
  private static final String LIB_LONG = "Produit ARE 2016 Spectacle";
  private static final Damj DEBUT = new Damj(2016, 8, 1);
  private static ProduitAsuSpe02P05 instanceUnique = null;
  
  public ProduitAsuSpe02P05()
  {
    this(true);
  }
  
  protected ProduitAsuSpe02P05(boolean initReglement)
  {
    setLibelleCourt("ARE SPE R16");
    setLibelleLong("Produit ARE 2016 Spectacle");
    
    Damj dateFinProduit = null;
    try
    {
      dateFinProduit = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de fin du produit ARE CGE et CSA 2014");
    }
    catch (CoucheLogiqueException e)
    {
      throw new ApplicativeRuntimeException(e.getCode());
    }
    setPeriodeValidite(new Periode(DEBUT, dateFinProduit));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.spe02.p05.ProduitDelegue"));
    
    setCode(71);
    setNomUnique("ASU_SPE02_05");
    if (initReglement)
    {
      ajouterReglement(Reglement.getInstance("A8", this));
      ajouterReglement(Reglement.getInstance("A10", this));
    }
  }
  
  public static ProduitAsuSpe02P05 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSpe02P05();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSpe02P05();
    }
    return instanceUnique;
  }
  
  public boolean estUnProduitRevisable()
  {
    return false;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec produit)
  {
    return (getCode() == produit.getCode()) || (ProduitAsuSpe02P03.getInstance().getCode() == produit.getCode());
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estProduitGerantFranchiseCP()
  {
    return true;
  }
  
  public boolean estProduitGerantFranchiseSalaire()
  {
    return true;
  }
  
  public boolean estUnProduitSansDuree()
  {
    return true;
  }
  
  public Quantite getDureeRestante(AttributionSpec attribution, Damj dateCalcul)
    throws ApplicativeException
  {
    return ((IProduitAsuSansDuree)getProduitDelegue()).getDureeRestante(attribution, dateCalcul);
  }
  
  public ResultatImputationSuiteArce traiterImputationSuiteArce(AttributionSpec attributionPrecedente, Damj dateExamen)
    throws ApplicativeException
  {
    return ((IProduitAsuSansDuree)getProduitDelegue()).traiterImputationSuiteArce(attributionPrecedente, dateExamen);
  }
  
  public boolean neDoitPasSanctionnerPndsPourCouvertureDv()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuSpe02P05
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */