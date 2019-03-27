package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.affectation.spec.ProduitAsuClauseSauvegardeSpec;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuCsa06P05
  extends ProduitAsuAbstrait
  implements ProduitAsuClauseSauvegardeSpec
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.csa06.p05.ProduitDelegue";
  private static final String LIB_COURT = "C SAUVEGARDE";
  private static final String LIB_LONG = "Produit clause de sauvegarde";
  private static final Damj DEBUT = new Damj(2014, 10, 1);
  private static ProduitAsuCsa06P05 instanceUnique = null;
  
  private ProduitAsuCsa06P05()
  {
    setLibelleCourt("C SAUVEGARDE");
    setLibelleLong("Produit clause de sauvegarde");
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
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.csa06.p05.ProduitDelegue"));
    
    setCode(61);
    setNomUnique("ASU_CSA06_05");
    
    ajouterReglement(Reglement.getInstance("RG", this));
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
  
  public static ProduitAsuCsa06P05 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuCsa06P05();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuCsa06P05();
    }
    return instanceUnique;
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec produit)
  {
    return (getCode() == produit.getCode()) || (getProduitLigneCasGeneralAssocie().getCode() == produit.getCode());
  }
  
  public boolean estUnProduitRevisable()
  {
    return true;
  }
  
  public ProduitAsuSpec getProduitLigneCasGeneralAssocie()
  {
    return ProduitAsuCge01P06.getInstance();
  }
  
  public boolean neDoitPasSanctionnerPndsPourCouvertureDv()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuCsa06P05
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */