package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
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
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;

public abstract interface FacadeLiquidationProduitSolSpec
  extends FacadeLiquidationProduitSpec
{
  public abstract Object creerObjectifExamen(int paramInt);
  
  public abstract Resultat constaterContexteExamen(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat traiterReliquat(ResultatExecutionCalculSpec paramResultatExecutionCalculSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public abstract void initialiserDossierExamen(DossierAffectationSpec paramDossierAffectationSpec);
  
  public abstract Resultat determinerOrdreObjectifs(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract boolean determinerLancementObjectifReprise(Contexte paramContexte);
  
  public abstract Resultat verifierConditionRechercheEmploi(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionRechercheEmploiDateAttributionTheorique(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionAptitudePhysique(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionAptitudePhysiqueDateAttributionTheorique(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionAge(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionAgeDateAttributionTheorique(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionActivite(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionCumulAutrePrestation(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract void miseAJourDossierExamen(DossierExamenSpec paramDossierExamenSpec, AttributionSpec paramAttributionSpec);
  
  public abstract Resultat verifierConditionRessources(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionAutreProduit(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionNombreTrimestre(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionFaitGenerateur(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionChomageInvolontaire(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat verifierConditionBeneficiaireAAH(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerDureeMaximale(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerDureeReglementaire(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerDateFinIndemnisation(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerMontantBrut(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerPremierJourIndemnisable(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerDateAttribution(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerDateDebutIndemnisation(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat constituerRessources(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract boolean estAssDemandeExpresse(AttributionSpec paramAttributionSpec);
  
  public abstract Damj getDjiTheoriqueAER(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract ArrayList alimenterDecisionsReexamen(Contexte paramContexte)
    throws CoucheLogiqueException;
  
  public abstract void validerCapaParDefaut(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Quantite recupererReliquat(AttributionSpec paramAttributionSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public abstract Damj recupererDJIParEpuisement(AttributionSpec paramAttributionSpec)
    throws ApplicativeException;
  
  public abstract ResultatExecutionCalculSpec retrouverDeterminationEtatDroit(AttributionSpec paramAttributionSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public abstract void installerPrimes(DemandeSpec paramDemandeSpec);
  
  public abstract int determinerNbJoursActiviteAcquisePourCourrierAss(IndividuSpec paramIndividuSpec, AttributionSpec paramAttributionSpec)
    throws ApplicativeException;
  
  public abstract void verifierDepotTardifEtPrescription(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract FormuleMontantSpec getFormuleMontant(String paramString);
  
  public abstract void controlerContexteDonneesForcees(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract void controlerContexteDonneesForceesPostLiquidation(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Quantite recupererMontantBrutJournalier(AttributionSpec paramAttributionSpec);
  
  public abstract JustificationAppelGaecReduit getDateDebutFenetrageAppelGaec(DemandeSpec paramDemandeSpec);
  
  public abstract void verifierPeriodesPourDeclencherAlertes(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract int recupererNombreTrimestresRequis(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract void alimenterDonneesComplementairesDossierExamen(DossierExamenSpec paramDossierExamenSpec);
  
  public abstract Resultat creerGrapheDemandeAntecedent(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract Resultat verifierConditionValiditeReliquat(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract MontantBaseSpec calculerMontantAUneDate(AttributionSpec paramAttributionSpec, Damj paramDamj)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     FacadeLiquidationProduitSolSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */