package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public final class ProduitAsuFds12P02
  extends ProduitAsuSpectacleAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.fds12.p02.ProduitDelegue";
  private static final String LIB_COURT = "AFD 09";
  private static final String LIB_LONG = "Allocation de Fin de Droit 2009";
  private static final Damj DEBUT = new Damj(2009, 1, 1);
  private static ProduitAsuFds12P02 instanceUnique = null;
  
  public ProduitAsuFds12P02()
  {
    setLibelleCourt("AFD 09");
    setLibelleLong("Allocation de Fin de Droit 2009");
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
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.fds12.p02.ProduitDelegue"));
    
    setCode(29);
    setNomUnique("ASU_FDS12_02");
    
    ajouterReglement(Reglement.getInstance("A8", this));
    ajouterReglement(Reglement.getInstance("A10", this));
  }
  
  public static ProduitAsuFds12P02 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuFds12P02();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuFds12P02();
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
 * Qualified Name:     ProduitAsuFds12P02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */