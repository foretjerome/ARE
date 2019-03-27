package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public final class ProduitAsuFds12P03
  extends ProduitAsuSpectacleAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.fds12.p03.ProduitDelegue";
  private static final String LIB_COURT = "AFD 17";
  private static final String LIB_LONG = "Allocation de Fin de Droit 2017";
  private static ProduitAsuFds12P03 instanceUnique = null;
  
  public ProduitAsuFds12P03()
  {
    setLibelleCourt("AFD 17");
    setLibelleLong("Allocation de Fin de Droit 2017");
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
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.fds12.p03.ProduitDelegue"));
    
    setCode(76);
    setNomUnique("ASU_FDS12_03");
    
    ajouterReglement(Reglement.getInstance("A8", this));
    ajouterReglement(Reglement.getInstance("A10", this));
  }
  
  public static ProduitAsuFds12P03 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuFds12P03();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuFds12P03();
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
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuFds12P03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */