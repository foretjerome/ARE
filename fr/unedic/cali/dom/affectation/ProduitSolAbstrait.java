package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.FormuleMontantSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.JustificationAppelGaecReduit;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.parcours.ResultatExecutionCalculSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;

public abstract class ProduitSolAbstrait
  extends ProduitAbstrait
  implements ProduitSolSpec
{
  protected ProduitSolAbstrait()
  {
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_CALCULE", this));
    ajouterElementForcable(ElementForcable.getInstance("DECALAGE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("STATUT_UT_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("NEUTRALISE_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("TYPE_NEUTRALISATION_FORCE", this));
  }
  
  private ProduitSolDelegueSpec getProduitSolDelegue()
  {
    return (ProduitSolDelegueSpec)getProduitDelegue();
  }
  
  public Resultat creerGrapheDemandeAntecedent(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().creerGrapheDemandeAntecedent(demande);
  }
  
  public void initialiserDossierExamen(DossierAffectationSpec dossierAffecte)
  {
    if (getProduitSolDelegue() != null) {
      getProduitSolDelegue().initialiserDossierExamen(dossierAffecte);
    }
  }
  
  public void miseAJourDossierExamen(DossierExamenSpec dossier, AttributionSpec attribution)
  {
    if (getProduitSolDelegue() != null) {
      getProduitSolDelegue().miseAJourDossierExamen(dossier, attribution);
    }
  }
  
  public Object creerObjectifExamen(int sousType)
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().creerObjectifExamen(sousType);
  }
  
  public Resultat constaterContexteExamen(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().constaterContexteExamen(contexte);
  }
  
  public Resultat traiterReliquat(ResultatExecutionCalculSpec resultatExecutionCalcul, Damj dateEtude)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().traiterReliquat(resultatExecutionCalcul, dateEtude);
  }
  
  public Resultat determinerOrdreObjectifs(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().determinerOrdreObjectifs(contexte);
  }
  
  public boolean determinerLancementObjectifReprise(Contexte contexte)
  {
    if (getProduitSolDelegue() == null) {
      return false;
    }
    return getProduitSolDelegue().determinerLancementObjectifReprise(contexte);
  }
  
  public Resultat verifierConditionRechercheEmploi(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionRechercheEmploi(contexte);
  }
  
  public Resultat verifierConditionRechercheEmploiDateAttributionTheorique(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionRechercheEmploiDateAttributionTheorique(contexte);
  }
  
  public Resultat verifierConditionAptitudePhysique(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionAptitudePhysique(contexte);
  }
  
  public Resultat verifierConditionAptitudePhysiqueDateAttributionTheorique(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionAptitudePhysiqueDateAttributionTheorique(contexte);
  }
  
  public Resultat verifierConditionFaitGenerateur(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionFaitGenerateur(contexte);
  }
  
  public Resultat verifierConditionActivite(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionActivite(contexte);
  }
  
  public Resultat verifierConditionAge(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionAge(contexte);
  }
  
  public Resultat verifierConditionAgeDateAttributionTheorique(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionAgeDateAttributionTheorique(contexte);
  }
  
  public Resultat verifierConditionRessources(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionRessources(contexte);
  }
  
  public Resultat verifierConditionAutreProduit(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionAutreProduit(contexte);
  }
  
  public Resultat verifierConditionChomageInvolontaire(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionChomageInvolontaire(contexte);
  }
  
  public Resultat verifierConditionNombreTrimestre(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionNombreTrimestre(contexte);
  }
  
  public Resultat verifierConditionBeneficiaireAAH(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionBeneficiaireAAH(contexte);
  }
  
  public Resultat constituerDureeMaximale(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().constituerDureeMaximale(contexte);
  }
  
  public Resultat constituerDureeReglementaire(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().constituerDureeReglementaire(contexte);
  }
  
  public Resultat constituerMontantBrut(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().constituerMontantBrut(contexte);
  }
  
  public Resultat constituerPremierJourIndemnisable(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().constituerPremierJourIndemnisable(contexte);
  }
  
  public Resultat constituerDateAttribution(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().constituerDateAttribution(contexte);
  }
  
  public Resultat constituerDateDebutIndemnisation(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().constituerDateDebutIndemnisation(contexte);
  }
  
  public Resultat constituerDateFinIndemnisation(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().constituerDateFinIndemnisation(contexte);
  }
  
  public Resultat constituerRessources(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().constituerRessources(contexte);
  }
  
  public boolean estAssDemandeExpresse(AttributionSpec attribution)
  {
    if (getProduitSolDelegue() == null) {
      return false;
    }
    return getProduitSolDelegue().estAssDemandeExpresse(attribution);
  }
  
  public Damj getDjiTheoriqueAER(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().getDjiTheoriqueAER(attribution);
  }
  
  public ArrayList alimenterDecisionsReexamen(Contexte contexte)
    throws CoucheLogiqueException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().alimenterDecisionsReexamen(contexte);
  }
  
  public void validerCapaParDefaut(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() != null) {
      getProduitSolDelegue().validerCapaParDefaut(contexte);
    }
  }
  
  public Quantite recupererReliquat(AttributionSpec attributionSolidarite, Damj dateCalcul)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().recupererReliquat(attributionSolidarite, dateCalcul);
  }
  
  public Damj recupererDJIParEpuisement(AttributionSpec attribution)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().recupererDJIParEpuisement(attribution);
  }
  
  public ResultatExecutionCalculSpec retrouverDeterminationEtatDroit(AttributionSpec attribution, Damj dateEtatDroit)
    throws ApplicativeException
  {
    if (getProduitDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().retrouverDeterminationEtatDroit(attribution, dateEtatDroit);
  }
  
  public void installerPrimes(DemandeSpec demande)
  {
    if (getProduitSolDelegue() != null) {
      getProduitSolDelegue().installerPrimes(demande);
    }
  }
  
  public int determinerNbJoursActiviteAcquisePourCourrierAss(IndividuSpec individu, AttributionSpec attributionAsu)
    throws ApplicativeException
  {
    return getProduitSolDelegue().determinerNbJoursActiviteAcquisePourCourrierAss(individu, attributionAsu);
  }
  
  public void verifierDepotTardifEtPrescription(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() != null) {
      getProduitSolDelegue().verifierDepotTardifEtPrescription(contexte);
    }
  }
  
  public FormuleMontantSpec getFormuleMontant(String code)
  {
    return getProduitSolDelegue().getFormuleMontant(code);
  }
  
  public Quantite recupererMontantBrutJournalier(AttributionSpec attribution)
  {
    return getProduitSolDelegue().recupererMontantBrutJournalier(attribution);
  }
  
  public Resultat verifierConditionCumulAutrePrestation(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionCumulAutrePrestation(contexte);
  }
  
  public void controlerContexteDonneesForceesPostLiquidation(Contexte contexte)
    throws ContexteException, ApplicativeException
  {
    getProduitSolDelegue().controlerContexteDonneesForceesPostLiquidation(contexte);
  }
  
  public void controlerContexteDonneesForcees(Contexte contexte)
    throws ContexteException, ApplicativeException
  {
    getProduitSolDelegue().controlerContexteDonneesForcees(contexte);
  }
  
  public int recupererNombreTrimestresRequis(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    return getProduitSolDelegue().recupererNombreTrimestresRequis(demande);
  }
  
  public void alimenterDonneesComplementairesDossierExamen(DossierExamenSpec dossierExamenDecisionne)
  {
    if (getProduitSolDelegue() != null) {
      getProduitSolDelegue().alimenterDonneesComplementairesDossierExamen(dossierExamenDecisionne);
    }
  }
  
  public String determinerPeriodeGaecAChargerSurLectureDecision(DemandeSpec demandeDecisionne)
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().determinerPeriodeGaecAChargerSurLectureDecision(demandeDecisionne);
  }
  
  public JustificationAppelGaecReduit getDateDebutFenetrageAppelGaec(DemandeSpec demande)
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().getDateDebutFenetrageAppelGaec(demande);
  }
  
  public void verifierPeriodesPourDeclencherAlertes(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() != null) {
      getProduitSolDelegue().verifierPeriodesPourDeclencherAlertes(contexte);
    }
  }
  
  public Resultat verifierConditionValiditeReliquat(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitSolDelegue() == null) {
      return null;
    }
    return getProduitSolDelegue().verifierConditionValiditeReliquat(contexte);
  }
  
  public MontantBaseSpec calculerMontantAUneDate(AttributionSpec attribution, Damj dateCalcul)
    throws ApplicativeException
  {
    return getProduitSolDelegue().calculerMontantAUneDate(attribution, dateCalcul);
  }
}

/* Location:
 * Qualified Name:     ProduitSolAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */