package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.util.temps.Damj;

public class ProduitAsuDdm16P01
  extends ProduitAriAbstrait
  implements ProduitAriSpec
{
  private static final long serialVersionUID = 8590511619577985164L;
  private static ProduitAsuDdm16P01 s_instanceUnique = null;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.ddm16.p01.ProduitDelegue";
  private static final String LIB_COURT = "AAT Charbon";
  private static final String LIB_LONG = "Allocation d'attente charbonnage";
  
  public static ProduitAsuDdm16P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuDdm16P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuDdm16P01();
    }
    return s_instanceUnique;
  }
  
  protected ProduitAsuDdm16P01()
  {
    setLibelleCourt("AAT Charbon");
    setLibelleLong("Allocation d'attente charbonnage");
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.ddm16.p01.ProduitDelegue"));
    setCode(43);
    setNomUnique("ASU_DDM16_01");
    
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_CALCULE", this));
    ajouterElementForcable(ElementForcable.getInstance("STATUT_UT_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_FORCE", this));
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
 * Qualified Name:     ProduitAsuDdm16P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */