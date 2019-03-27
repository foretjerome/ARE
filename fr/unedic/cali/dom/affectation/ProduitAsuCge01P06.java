package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuCge01P06
  extends ProduitAsuAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.cge01.p06.ProduitDelegue";
  private static final String LIB_COURT = "ARE2014 CGE";
  private static final String LIB_LONG = "Produit ARE 2014 Cas général";
  private static final Damj DEBUT = new Damj(2014, 10, 1);
  private static ProduitAsuCge01P06 instanceUnique = null;
  
  protected ProduitAsuCge01P06()
  {
    setLibelleCourt("ARE2014 CGE");
    setLibelleLong("Produit ARE 2014 Cas général");
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
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.cge01.p06.ProduitDelegue"));
    
    setCode(60);
    setNomUnique("ASU_CGE01_06");
    
    ajouterReglement(Reglement.getInstance("RG", this));
    ajouterReglement(Reglement.getInstance("OP", this));
    ajouterReglement(Reglement.getInstance("A1", this));
    ajouterReglement(Reglement.getInstance("A2a", this));
    ajouterReglement(Reglement.getInstance("A2b", this));
    ajouterReglement(Reglement.getInstance("A3", this));
    ajouterReglement(Reglement.getInstance("A4", this));
    ajouterReglement(Reglement.getInstance("A5", this));
    ajouterReglement(Reglement.getInstance("A9A", this));
    ajouterReglement(Reglement.getInstance("RGP", this));
  }
  
  public static ProduitAsuCge01P06 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuCge01P06();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuCge01P06();
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
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuCge01P06
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */