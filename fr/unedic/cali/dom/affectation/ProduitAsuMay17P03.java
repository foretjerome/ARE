package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.OutilReliquat;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuMay17P03
  extends ProduitAriAbstrait
  implements ProduitAriSpec, ProduitAvecEpuisementSpec
{
  private static final long serialVersionUID = 1L;
  private static ProduitAsuMay17P03 instanceUnique = null;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.may17.p03.ProduitDelegue";
  private static final String LIB_COURT = "AREM 2016";
  private static final String LIB_LONG = "Allocation de Retour à l'Emploi Mayotte 2016";
  private static final Damj DEBUT = new Damj(2016, 5, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  
  public static ProduitAsuMay17P03 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuMay17P03();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuMay17P03();
    }
    return instanceUnique;
  }
  
  protected ProduitAsuMay17P03()
  {
    setLibelleCourt("AREM 2016");
    setLibelleLong("Allocation de Retour à l'Emploi Mayotte 2016");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.may17.p03.ProduitDelegue"));
    setCode(70);
    setNomUnique("ASU_MAY17_03");
    
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_CALCULE", this));
    ajouterElementForcable(ElementForcable.getInstance("STATUT_UT_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("IGNORER_AE_DV", this));
    ajouterElementForcable(ElementForcable.getInstance("DEBLOCAGE_LEVER_BLOCAGE_MANDATEMENT", this));
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec produit)
  {
    return getCode() == produit.getCode();
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estActif(Damj date)
  {
    return false;
  }
  
  public Damj recupererDJIParEpuisement(DemandeSpec demande, AttributionSpec attribution, boolean verifierEpuisementHPec)
  {
    return OutilReliquat.recupererDJIParEpuisement(demande, attribution, verifierEpuisementHPec);
  }
}

/* Location:
 * Qualified Name:     ProduitAsuMay17P03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */