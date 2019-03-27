package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.util.temps.Damj;

public class ProduitAsuEur05P01
  extends ProduitAriAbstrait
  implements ProduitAriSpec
{
  private static final long serialVersionUID = 1L;
  private static ProduitAsuEur05P01 s_instanceUnique = null;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.eur05.p01.ProduitDelegue";
  private static final String LIB_COURT = "AUE";
  private static final String LIB_LONG = "Allocation Union Européenne";
  
  public static ProduitAsuEur05P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuEur05P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuEur05P01();
    }
    return s_instanceUnique;
  }
  
  public ProduitAsuEur05P01()
  {
    setLibelleCourt("AUE");
    setLibelleLong("Allocation Union Européenne");
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.eur05.p01.ProduitDelegue"));
    setCode(42);
    setNomUnique("ASU_EUR05_01");
    
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_CALCULE", this));
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("STATUT_UT_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("NEUTRALISE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("TYPE_NEUTRALISATION_FORCE", this));
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return getCode() == p_produit.getCode();
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estActif(Damj p_date)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuEur05P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */