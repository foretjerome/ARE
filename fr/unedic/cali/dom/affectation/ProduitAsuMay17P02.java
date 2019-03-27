package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.OutilReliquat;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuMay17P02
  extends ProduitAriAbstrait
  implements ProduitAriSpec, ProduitAvecEpuisementSpec
{
  private static final long serialVersionUID = 8590511619577985164L;
  private static ProduitAsuMay17P02 instanceUnique = null;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.may17.p02.ProduitDelegue";
  private static final String LIB_COURT = "AREM 2012";
  private static final String LIB_LONG = "Allocation de Retour à l'Emploi Mayotte 2012";
  private static final Damj DEBUT = new Damj(2013, 1, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  
  public static ProduitAsuMay17P02 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuMay17P02();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuMay17P02();
    }
    return instanceUnique;
  }
  
  protected ProduitAsuMay17P02()
  {
    setLibelleCourt("AREM 2012");
    setLibelleLong("Allocation de Retour à l'Emploi Mayotte 2012");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.may17.p02.ProduitDelegue"));
    setCode(54);
    setNomUnique("ASU_MAY17_02");
    
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_CALCULE", this));
    ajouterElementForcable(ElementForcable.getInstance("STATUT_UT_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("CUMUL_AR_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("NEUTRALISE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("TYPE_NEUTRALISATION_FORCE", this));
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
 * Qualified Name:     ProduitAsuMay17P02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */