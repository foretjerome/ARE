package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuCge01P07
  extends ProduitAsuAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.cge01.p07.ProduitDelegue";
  private static final String LIB_COURT = "ARE2017 CGE";
  private static final String LIB_LONG = "Produit ARE 2017 Cas général";
  private static ProduitAsuCge01P07 instanceUnique = null;
  
  protected ProduitAsuCge01P07()
  {
    setLibelleCourt("ARE2017 CGE");
    setLibelleLong("Produit ARE 2017 Cas général");
    Damj dateDebutProduit = null;
    Damj dateFinProduit = Damj.FIN_DES_TEMPS;
    try
    {
      dateDebutProduit = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de debut du produit ARE CGE et CSA 2017");
    }
    catch (CoucheLogiqueException e)
    {
      throw new ApplicativeRuntimeException(e.getCode());
    }
    setPeriodeValidite(new Periode(dateDebutProduit, dateFinProduit));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.cge01.p07.ProduitDelegue"));
    
    setCode(72);
    setNomUnique("ASU_CGE01_07");
    
    ajouterReglement(Reglement.getInstance("RG", this));
    ajouterReglement(Reglement.getInstance("OP", this));
    ajouterReglement(Reglement.getInstance("A1", this));
    ajouterReglement(Reglement.getInstance("A2a", this));
    ajouterReglement(Reglement.getInstance("A2b", this));
    ajouterReglement(Reglement.getInstance("A3", this));
    ajouterReglement(Reglement.getInstance("A5", this));
    ajouterReglement(Reglement.getInstance("A9A", this));
    ajouterReglement(Reglement.getInstance("RGP", this));
    ajouterReglement(Reglement.getInstance("RG5", this));
  }
  
  public static ProduitAsuCge01P07 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuCge01P07();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuCge01P07();
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
    return true;
  }
  
  public boolean neDoitPasSanctionnerPndsPourCouvertureDv()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuCge01P07
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */