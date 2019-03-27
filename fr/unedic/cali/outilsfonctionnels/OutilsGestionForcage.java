package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionForcage;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public final class OutilsGestionForcage
{
  private static ElementForcable getElementForcable(DemandeSpec demande, String nomElementForcable)
  {
    return demande.getDossierAffectation().getProduit().getElementForcable(nomElementForcable);
  }
  
  private static boolean estNonNull(String estNeutralisee, ElementForcable neutralisationForce)
  {
    return (neutralisationForce != null) && (estNeutralisee != null) && (!estNeutralisee.equals(""));
  }
  
  public static boolean gestionForcageCreditDecalage(DemandeSpec demande, Damj dateDebut, Damj dateFin, QuantiteJour creditDecalageForce)
  {
    boolean estDecalageForce = false;
    ElementForcable decalageForce = getElementForcable(demande, "DECALAGE_FORCE");
    if ((decalageForce != null) && (creditDecalageForce != null))
    {
      estDecalageForce = true;
      
      GestionForcage.forcerCreditDecalage(demande, dateDebut, dateFin, creditDecalageForce);
    }
    else
    {
      GestionForcage.annulerForcageCreditDecalage(demande, dateDebut, dateFin);
    }
    return estDecalageForce;
  }
  
  public static boolean gestionForcageCreditDecalagePNDS(DemandeSpec demande, Damj dateDebut, Damj dateFin, QuantiteJour creditDecalagePNDSForce)
  {
    boolean estDecalagePNDSForce = false;
    ElementForcable sanctionForce = getElementForcable(demande, "DECALAGE_SANCTION_FORCE");
    if ((sanctionForce != null) && (creditDecalagePNDSForce != null))
    {
      estDecalagePNDSForce = true;
      
      GestionForcage.forcerCreditDecalagePNDS(demande, dateDebut, dateFin, creditDecalagePNDSForce);
    }
    else
    {
      GestionForcage.annulerForcageCreditDecalagePNDS(demande, dateDebut, dateFin);
    }
    return estDecalagePNDSForce;
  }
  
  public static boolean gestionForcageStatutUT(DemandeSpec demande, Damj dateDebut, Damj dateFin, int statut)
  {
    boolean estStatutForce = false;
    ElementForcable statutUTForce = getElementForcable(demande, "STATUT_UT_FORCE");
    if ((statutUTForce != null) && (statut != 0))
    {
      estStatutForce = true;
      GestionForcage.forcerStatut(demande, dateDebut, dateFin, statut);
    }
    else
    {
      GestionForcage.annulerForcageStatut(demande, dateDebut, dateFin);
    }
    return estStatutForce;
  }
  
  public static boolean gestionForcageCumulAR(DemandeSpec demande, Damj dateDebut, Damj dateFin, String cumul)
  {
    boolean estCumulARForce = false;
    ElementForcable cumulARForce = getElementForcable(demande, "CUMUL_AR_FORCE");
    if (estNonNull(cumul, cumulARForce))
    {
      estCumulARForce = true;
      GestionForcage.forcerCumulAR(demande, dateDebut, dateFin, Integer.parseInt(cumul));
    }
    else
    {
      GestionForcage.annulerCumulAR(demande, dateDebut, dateFin);
    }
    return estCumulARForce;
  }
  
  public static boolean gestionForcageEstNeutralise(DemandeSpec demande, Damj dateDebut, Damj dateFin, String estNeutralisee, String typeNeutralisation)
  {
    boolean estNeutraliseForce = false;
    ElementForcable neutralisationForce = getElementForcable(demande, "NEUTRALISE_FORCE");
    if ((estNonNull(estNeutralisee, neutralisationForce)) && ((demande.estMigree()) || ((typeNeutralisation != null) && (Integer.parseInt(typeNeutralisation) == 12))))
    {
      estNeutraliseForce = true;
      GestionForcage.forcerEstNeutralisee(demande, dateDebut, dateFin, Integer.parseInt(estNeutralisee));
    }
    else
    {
      GestionForcage.annulerForcageEstNeutralisee(demande, dateDebut, dateFin);
    }
    return estNeutraliseForce;
  }
  
  public static boolean gestionForcageTypeNeutralisation(DemandeSpec demande, Damj dateDebut, Damj dateFin, String typeNeutralisation)
  {
    boolean estTypeNeutralisationForce = false;
    ElementForcable typeNeutralisationForce = getElementForcable(demande, "TYPE_NEUTRALISATION_FORCE");
    if ((estNonNull(typeNeutralisation, typeNeutralisationForce)) && ((demande.estMigree()) || (Integer.parseInt(typeNeutralisation) == 12)))
    {
      estTypeNeutralisationForce = true;
      GestionForcage.forcerTypeNeutralisation(demande, dateDebut, dateFin, Integer.parseInt(typeNeutralisation));
    }
    else
    {
      GestionForcage.annulerForcageTypeNeutralisation(demande, dateDebut, dateFin);
    }
    return estTypeNeutralisationForce;
  }
  
  public static boolean gestionForcageRepriseMemeEmployeur(DemandeSpec demande, Damj dateDebut, Damj dateFin, String repriseMemeEmployeur)
  {
    boolean estRepriseMemeEmployeurForcee = false;
    ElementForcable repriseMemeEmployeurForce = getElementForcable(demande, "REPRISE_MEME_EMPLOYEUR_FORCE");
    if (estNonNull(repriseMemeEmployeur, repriseMemeEmployeurForce))
    {
      estRepriseMemeEmployeurForcee = true;
      GestionForcage.forcerRepriseMemeEmployeur(demande, dateDebut, dateFin, Integer.parseInt(repriseMemeEmployeur));
    }
    else
    {
      GestionForcage.annulerForcageRepriseMemeEmployeur(demande, dateDebut, dateFin);
    }
    return estRepriseMemeEmployeurForcee;
  }
  
  public static boolean gestionForcageDeblocageSeuil(DemandeSpec demande, Damj dateDebut, Damj dateFin, String deblocageSeuil)
  {
    boolean estDeblocageSeuil = false;
    ElementForcable deblocageAtteinteSeuilForce = getElementForcable(demande, "DEBLOCAGE_ATTEINTE_SEUIL_FORCE");
    if (estNonNull(deblocageSeuil, deblocageAtteinteSeuilForce))
    {
      estDeblocageSeuil = true;
      GestionForcage.forcerDeblocageSeuil(demande, dateDebut, dateFin);
    }
    else
    {
      GestionForcage.annulerForcageDeblocageSeuil(demande, dateDebut, dateFin);
    }
    return estDeblocageSeuil;
  }
  
  public static boolean gestionForcageDeblocageVariationRemuneration(DemandeSpec demande, Damj dateDebut, Damj dateFin, String deblocageVariationRemuneration)
  {
    boolean estDeblocageVariationRemuneration = false;
    ElementForcable deblocageVariationForce = getElementForcable(demande, "DEBLOCAGE_VARIATION_REMUNERATION_FORCE");
    if (estNonNull(deblocageVariationRemuneration, deblocageVariationForce))
    {
      estDeblocageVariationRemuneration = true;
      GestionForcage.forcerDeblocageVariationRemuneration(demande, dateDebut, dateFin);
    }
    else
    {
      GestionForcage.annulerForcageDeblocageVariationRemuneration(demande, dateDebut, dateFin);
    }
    return estDeblocageVariationRemuneration;
  }
  
  public static boolean gestionForcageLeverBlocageMandatement(DemandeSpec demande, Damj dateDebut, Damj dateFin, String leverBlocageMandatement)
  {
    boolean estLeverBlocageMandatement = false;
    ElementForcable estLeverBlocage = getElementForcable(demande, "DEBLOCAGE_LEVER_BLOCAGE_MANDATEMENT");
    if (estNonNull(leverBlocageMandatement, estLeverBlocage))
    {
      estLeverBlocageMandatement = true;
      GestionForcage.forcerLeverBlocageMandatementAEDV(demande, dateDebut, dateFin);
    }
    else
    {
      GestionForcage.annulerForcageLeverBlocageMandatement(demande, dateDebut, dateFin);
    }
    return estLeverBlocageMandatement;
  }
  
  public static boolean gestionForcageIgnorerAEDV(DemandeSpec demande, Damj dateDebut, Damj dateFin, String ignorerBlocageDV)
  {
    boolean estPoursuiteAEDV = false;
    ElementForcable estDeblocageElementForce = getElementForcable(demande, "IGNORER_AE_DV");
    if (estNonNull(ignorerBlocageDV, estDeblocageElementForce))
    {
      estPoursuiteAEDV = true;
      GestionForcage.forcerDeblocagePoursuiteSuiteAEDV(demande, dateDebut, dateFin);
    }
    else
    {
      GestionForcage.annulerForcageIgnorerAEDV(demande, dateDebut, dateFin);
    }
    return estPoursuiteAEDV;
  }
  
  public static boolean gestionForcageMotifDV(DemandeSpec demande, Damj dateDebut, Damj dateFin, String motifDV)
  {
    boolean estMotifDVRenseigne = false;
    if (motifDV != null)
    {
      estMotifDVRenseigne = true;
      GestionForcage.forcerMotifDV(demande, dateDebut, dateFin, motifDV);
    }
    else
    {
      GestionForcage.annulerMotifDV(demande, dateDebut, dateFin);
    }
    return estMotifDVRenseigne;
  }
  
  public static boolean gestionForcageMontantNetRevenusActiviteReprise(DemandeSpec demande, Damj dateDebut, Damj dateFin, BigDecimal montantNetRevenusActiviteReprise)
  {
    boolean estMontantNetRevenusActiviteReprise = false;
    ElementForcable montantNetRevenusActiviteRepriseForce = getElementForcable(demande, "MONTANT_NET_REVENUS_ACTIVITE_REPRISE_FORCE");
    if ((montantNetRevenusActiviteRepriseForce != null) && (montantNetRevenusActiviteReprise != null))
    {
      estMontantNetRevenusActiviteReprise = true;
      GestionForcage.forcerMontantNetRevenusActiviteReprise(demande, dateDebut, dateFin, montantNetRevenusActiviteReprise);
    }
    else
    {
      GestionForcage.annulerForcageMontantNetActiviteReprise(demande, dateDebut, dateFin);
    }
    return estMontantNetRevenusActiviteReprise;
  }
}

/* Location:
 * Qualified Name:     OutilsGestionForcage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */