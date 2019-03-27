package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuSpe02P06
  extends ProduitAsuSpe02P05
{
  private static final long serialVersionUID = 1L;
  private static final String LIB_COURT = "ARE SPE R17";
  private static final String LIB_LONG = "Produit ARE 2017 Spectacle";
  private static ProduitAsuSpe02P06 instanceUnique = null;
  
  public ProduitAsuSpe02P06()
  {
    super(false);
    setLibelleCourt("ARE SPE R17");
    setLibelleLong("Produit ARE 2017 Spectacle");
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
    
    setCode(74);
    setNomUnique("ASU_SPE02_06");
    
    ajouterReglement(Reglement.getInstance("A8", this));
    ajouterReglement(Reglement.getInstance("A10", this));
  }
  
  public static ProduitAsuSpe02P06 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSpe02P06();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuSpe02P06();
    }
    return instanceUnique;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec produit)
  {
    return (getCode() == produit.getCode()) || (super.estIdentiqueAuProduit(produit));
  }
}

/* Location:
 * Qualified Name:     ProduitAsuSpe02P06
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */