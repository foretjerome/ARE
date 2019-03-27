package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.calcul.FacadeCalculProduitFactory;
import fr.unedic.cali.calcul.FacadeCalculProduitSpec;
import fr.unedic.cali.calcul.dom.ConstituantsCalculActiviteReduiteSpec;
import fr.unedic.cali.calcul.dom.SyntheseARsurUT;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.UniteTraitementForcee;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.outilsfonctionnels.Anomalie;
import fr.unedic.cali.outilsfonctionnels.GestionAnomalies;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;

public final class GestionForcage
{
  public static final int FORCAGE_INEXISTANT = 0;
  public static final int FORCAGE_DECALAGE = 1;
  public static final int FORCAGE_STATUT = 2;
  public static final int FORCAGE_DECALAGE_PNDS = 3;
  public static final int FORCAGE_DECALAGE_ET_STATUT = 4;
  public static final int FORCAGE_MONTANT_NET_ACTIVITE_REPRISE = 5;
  
  public static boolean appliquerForcageStatutEtCreditDecalage(DemandeSpec demande, UniteTraitement ut)
    throws CoucheLogiqueException
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    if ((utForcee != null) && (utForcee.isStatutForce()) && (utForcee.isCreditDecalageForce())) {
      return (appliquerForcageCreditDecalage(demande, ut)) && (appliquerForcageStatut(demande, ut));
    }
    return false;
  }
  
  public static boolean appliquerForcageStatut(DemandeSpec demande, UniteTraitement ut)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    if ((utForcee != null) && (utForcee.isStatutForce()))
    {
      ut.setStatut(utForcee.getStatut());
      if (utForcee.isCreditDecalageForce()) {
        ut.setTypeForcage(4);
      } else {
        ut.setTypeForcage(2);
      }
      return true;
    }
    return false;
  }
  
  public static boolean appliquerForcageCreditDecalage(DemandeSpec demande, UniteTraitement ut)
    throws CoucheLogiqueException
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    if ((utForcee != null) && (utForcee.isCreditDecalageForce())) {
      if ((ut.getCreditDecalagePNDS() != null) && (utForcee.getCreditDecalage().compareTo(ut.getCreditDecalagePNDS()) < 0))
      {
        GestionAnomalies.ajouteAnomalie(new Anomalie("I03", ut.getDateDebut(), ""), demande.getDemandeur());
      }
      else
      {
        ut.setCreditDecalage(utForcee.getCreditDecalage());
        if (utForcee.isStatutForce()) {
          ut.setTypeForcage(4);
        } else {
          ut.setTypeForcage(1);
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean appliquerForcageCreditDecalageNouvelleConventionAre14(DemandeSpec demande, UniteTraitement ut, FacadeCalculProduitSpec faceCalculProduit, AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    if (faceCalculProduit.verifierApplicationForcageSurUT(ut, attribution)) {
      return appliquerForcageCreditDecalage(demande, ut);
    }
    return false;
  }
  
  public static boolean appliquerForcageCreditDecalagePNDS(DemandeSpec demande, UniteTraitement ut)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    if ((utForcee != null) && (utForcee.isCreditDecalagePNDSForce()))
    {
      ut.setCreditDecalagePNDS(utForcee.getCreditDecalagePNDS());
      
      return true;
    }
    return false;
  }
  
  public static boolean appliquerForcageRepriseMemeEmployeur(DemandeSpec demande, UniteTraitement ut)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    if ((utForcee != null) && (utForcee.isRepriseMemeEmployeurForcee()))
    {
      ut.getSyntheseARsurUT().setRepriseMemeEmployeur(utForcee.getRepriseMemeEmployeur());
      return true;
    }
    return false;
  }
  
  public static boolean appliquerForcageEstNeutralise(DemandeSpec demande, UniteTraitement ut)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    if ((utForcee != null) && (utForcee.isEstNeutraliseForcee()))
    {
      if (utForcee.getEstNeutralisee() == 1)
      {
        ut.setNeutralisee(true);
        ut.setCreditDecalage(null);
      }
      else
      {
        ut.setNeutralisee(false);
      }
      return true;
    }
    return false;
  }
  
  public static boolean appliquerForcageEstNeutralisePasss(DemandeSpec demande, UniteTraitement ut)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    return (utForcee != null) && (utForcee.isEstNeutraliseForcee()) && (utForcee.getEstNeutralisee() == 1);
  }
  
  public static boolean appliquerForcageCumulARSurUt(DemandeSpec demande, UniteTraitement ut, ConstituantsCalculActiviteReduiteSpec constituantsCalculActiviteReduite)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    if ((utForcee != null) && (utForcee.isCumulAR()))
    {
      constituantsCalculActiviteReduite.setCumul(utForcee.getCumulARsurUtForce());
      return true;
    }
    return false;
  }
  
  public static boolean appliquerForcageDeblocageVariationRemuneration(DemandeSpec demande, UniteTraitement ut)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    if ((utForcee != null) && (utForcee.isDeblocageVariationRemuneration())) {
      return true;
    }
    return false;
  }
  
  public static boolean appliquerForcagePoursuiteIndemnisationMayotte(DemandeSpec demande, UniteTraitement ut)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    if ((utForcee != null) && (utForcee.isEstIgnorerAEDV())) {
      return true;
    }
    return false;
  }
  
  public static boolean appliquerForcageRejetndemnisationMayotte(DemandeSpec demande, UniteTraitement ut)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    if ((utForcee != null) && (utForcee.isEstLeverBlocageDV())) {
      return true;
    }
    return false;
  }
  
  public static boolean appliquerForcageDeblocageSeuil(DemandeSpec demande, UniteTraitement ut)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    if ((utForcee != null) && (utForcee.isDeblocageSeuil())) {
      return true;
    }
    return false;
  }
  
  public static boolean appliquerForcagePasss(DemandeSpec demande, UniteTraitement ut)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    return (utForcee != null) && (utForcee.isPasssDesactive());
  }
  
  public static boolean appliquerForcageTypeNeutralisation(DemandeSpec demande, UniteTraitement ut)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    if ((utForcee != null) && (utForcee.isTypeNeutralisationForce()))
    {
      ut.setTypeNeutralisation(utForcee.getTypeNeutralisation());
      return true;
    }
    return false;
  }
  
  public static boolean appliquerForcageTypeNeutralisationPASSS(DemandeSpec demande, UniteTraitement ut)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    if ((utForcee != null) && (utForcee.isTypeNeutralisationForce()) && (utForcee.getTypeNeutralisation() == 12)) {
      return true;
    }
    return false;
  }
  
  public static boolean appliquerMontantNetActiviteReprise(DemandeSpec demande, UniteTraitement ut)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, ut.getDateDebut(), ut.getDateFin(), false);
    if ((utForcee != null) && (utForcee.isMontantNetActiviteReprise()))
    {
      ut.setTypeForcage(5);
      ut.setMontantNetRevenusActiviteReprise(utForcee.getMontantNetRevenusActiviteReprise());
      return true;
    }
    return false;
  }
  
  public static void forcerStatut(DemandeSpec demande, Damj dateDebut, Damj dateFin, int statut)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, true);
    utForcee.setStatut(statut);
  }
  
  public static void forcerCreditDecalage(DemandeSpec demande, Damj dateDebut, Damj dateFin, Quantite creditDecalage)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, true);
    utForcee.setCreditDecalage(creditDecalage);
  }
  
  public static void forcerCreditDecalagePNDS(DemandeSpec demande, Damj dateDebut, Damj dateFin, Quantite creditDecalagePNDS)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, true);
    utForcee.setCreditDecalagePNDS(creditDecalagePNDS);
  }
  
  public static void forcerCommissionParitaire(DemandeSpec demande, Damj dateDebut, Damj dateFin, int commissionParitaire)
  {
    Damj dateCourante = dateDebut;
    while (dateCourante.estAvant(dateFin))
    {
      UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateCourante.getDebutMois(), dateCourante.getFinMois(), true);
      utForcee.setCommissionParitaire(commissionParitaire);
      dateCourante = dateCourante.getDebutMoisSuivant();
    }
  }
  
  public static void forcerRepriseMemeEmployeur(DemandeSpec demande, Damj dateDebut, Damj dateFin, int repriseMemeEmployeur)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, true);
    utForcee.setRepriseMemeEmployeur(repriseMemeEmployeur);
  }
  
  public static void forcerEstNeutralisee(DemandeSpec demande, Damj dateDebut, Damj dateFin, int estNeutralisee)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, true);
    utForcee.setEstNeutralisee(estNeutralisee);
  }
  
  public static void forcerTypeNeutralisation(DemandeSpec demande, Damj dateDebut, Damj dateFin, int typeNeutralisation)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, true);
    utForcee.setTypeNeutralisation(typeNeutralisation);
  }
  
  public static void forcerCumulAR(DemandeSpec demande, Damj dateDebut, Damj dateFin, int cumulAR)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, true);
    utForcee.setCumulARSurUt(cumulAR);
  }
  
  public static void forcerDeblocageSeuil(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, true);
    utForcee.setEstDeblocageSeuil();
  }
  
  public static void forcerDeblocageVariationRemuneration(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, true);
    utForcee.setEstDeblocageVariationRemuneration();
  }
  
  public static void forcerLeverBlocageMandatementAEDV(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, true);
    utForcee.setEstLeverBlocageDV(true);
  }
  
  public static void forcerDeblocagePoursuiteSuiteAEDV(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, true);
    utForcee.setEstIgnorerAEDV(true);
  }
  
  public static void forcerMontantNetRevenusActiviteReprise(DemandeSpec demande, Damj dateDebut, Damj dateFin, BigDecimal montantNetRevenusActiviteReprise)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, true);
    utForcee.setMontantNetRevenusActiviteReprise(montantNetRevenusActiviteReprise);
    utForcee.setIsMontantNetRevenusActiviteReprise(true);
  }
  
  public static void forcerMotifDV(DemandeSpec demande, Damj dateDebut, Damj dateFin, String motifDV)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, true);
    utForcee.setMotif(motifDV);
  }
  
  public static void annulerForcageStatut(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, false);
    if (utForcee != null) {
      utForcee.annulerForcageStatut();
    }
  }
  
  public static void annulerForcageCreditDecalage(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, false);
    if (utForcee != null) {
      utForcee.annulerForcageCreditDecalage();
    }
  }
  
  public static void annulerForcageCreditDecalagePNDS(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, false);
    if (utForcee != null) {
      utForcee.annulerForcageCreditDecalagePNDS();
    }
  }
  
  public static void annulerForcageRepriseMemeEmployeur(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, false);
    if (utForcee != null) {
      utForcee.annulerRepriseMemeEmployeur();
    }
  }
  
  public static void annulerForcageEstNeutralisee(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, false);
    if (utForcee != null) {
      utForcee.annulerEstNeutralisee();
    }
  }
  
  public static void annulerForcageTypeNeutralisation(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, false);
    if (utForcee != null) {
      utForcee.annulerTypeNeutralisation();
    }
  }
  
  public static void annulerCumulAR(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, false);
    if (utForcee != null) {
      utForcee.annulerCumulARSurUt();
    }
  }
  
  public static void annulerForcageIgnorerAEDV(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, false);
    if (utForcee != null) {
      utForcee.annulerEstIgnorerAEDv();
    }
  }
  
  public static void annulerForcageLeverBlocageMandatement(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, false);
    if (utForcee != null) {
      utForcee.annulerEstLeverBlocageAEDV();
    }
  }
  
  public static void annulerForcageDeblocageSeuil(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, false);
    if (utForcee != null) {
      utForcee.annulerEstDeblocageSeuil();
    }
  }
  
  public static void annulerForcageMontantNetActiviteReprise(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, false);
    if (utForcee != null) {
      utForcee.annulerMontantNetActiviteReprise();
    }
  }
  
  public static void annulerForcageDeblocageVariationRemuneration(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, false);
    if (utForcee != null) {
      utForcee.annulerEstDeblocageVariationRemuneration();
    }
  }
  
  public static void checkForcage(DemandeSpec demande, UniteTraitementForcee utForcee, boolean sansAucuneDonneeForcee)
  {
    if ((!utForcee.isUTForcee()) || (sansAucuneDonneeForcee))
    {
      demande.supprimerUniteTraitementForcee(utForcee);
      
      DomManager.supprimer(utForcee);
    }
  }
  
  public static void annulerMotifDV(DemandeSpec demande, Damj dateDebut, Damj dateFin)
  {
    UniteTraitementForcee utForcee = getUniteTraitementForcee(demande, dateDebut, dateFin, false);
    if (utForcee != null) {
      utForcee.annulerEstMotifDV();
    }
  }
  
  public static UniteTraitementForcee getUniteTraitementForcee(DemandeSpec demande, Damj dateDebut, Damj dateFin, boolean creerSiInexistant)
  {
    UniteTraitementForcee ut = null;
    if (demande != null)
    {
      Collection collectionUT = demande.getForcageExecution();
      boolean found = false;
      if ((collectionUT != null) && (!collectionUT.isEmpty()))
      {
        Iterator it = collectionUT.iterator();
        while ((it.hasNext()) && (!found))
        {
          ut = (UniteTraitementForcee)it.next();
          if ((ut.getDateDebut().coincideAvec(dateDebut)) && (ut.getDateFin().coincideAvec(dateFin))) {
            found = true;
          }
        }
      }
      if (!found)
      {
        ut = null;
        if (creerSiInexistant)
        {
          try
          {
            FacadeCalculProduitSpec facadeCalcul = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(demande.getDossierAffectation().getProduit());
            
            ut = facadeCalcul.creerUniteTraitementForcee(dateDebut, dateFin);
          }
          catch (CoucheLogiqueException e) {}
          demande.ajouterForcageExecution(ut);
        }
      }
    }
    return ut;
  }
}

/* Location:
 * Qualified Name:     GestionForcage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */