package fr.unedic.cali.dom;

import fr.unedic.cali.autresdoms.d12i.dom.DonneesNPDE;
import fr.unedic.cali.calcul.dom.UniteTraitementForcee;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.pivot.DemandePivot;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

public abstract interface DemandeSpec
  extends Temporel, ObjetPersistantSpec, Comparable<DemandeSpec>
{
  public static final int HORS_GAMME = 0;
  public static final int GAMME_ASU = 1;
  public static final int GAMME_SOL = 2;
  public static final int GAMME_RBF = 3;
  public static final int GAMME_FOR = 4;
  public static final int GAMME_ASU_PROD_MNT = 5;
  public static final int GAMME_INR = 6;
  public static final int GAMME_ARI = 8;
  public static final int GAMME_PRR = 9;
  public static final int GAMME_DEC = 10;
  public static final int DEMANDE_NON_MIGREE = 0;
  public static final int DEMANDE_MIGREE = 1;
  public static final int DEMANDE_MIGREE_EN_SIMPLIFIEE = 2;
  public static final int PAS_DE_COMPORTEMENT_PARTICULIER = 0;
  public static final int COMPORTEMENT_DEMANDE_NON_LIQUIDABLE = 1;
  public static final String MODE_LIQUIDATION_SIMPLIFEE = "S";
  public static final String MODE_LIQUIDATION_CLASSIQUE = "C";
  public static final String MODE_LIQUIDATION_AUTOMATIQUE = "A";
  public static final String MODE_LIQUIDATION_AUTOMATIQUE_PAR_GESTIONNAIRE_REEXEC = "AG";
  public static final String MODE_LIQUIDATION_STANDARD = null;
  
  public abstract boolean estDecisionnee();
  
  public abstract boolean estAdmissibleReexecution();
  
  public abstract boolean estClasseeOuDecisionneeValidee();
  
  public abstract boolean estEnReExamen();
  
  public abstract void ajouterMotifReexamen(String paramString);
  
  public abstract Collection getListeMotifsReexamen();
  
  public abstract void setListeMotifsReexamen(Collection paramCollection);
  
  public abstract ClassementAdministratif getClassementAdministratif();
  
  public abstract void setClassementAdministratif(ClassementAdministratif paramClassementAdministratif);
  
  public abstract DossierAffectationSpec getDossierAffectation();
  
  public abstract int getNumeroGamme();
  
  public abstract IndividuSpec getDemandeur();
  
  public abstract void setDemandeur(IndividuSpec paramIndividuSpec);
  
  public abstract List<DossierExamenSpec> getListeDossiersExamen();
  
  public abstract void mettreAJourDemande(DemandeSpec paramDemandeSpec);
  
  public abstract Damj getDateDepot();
  
  public abstract Damj getDateExamen();
  
  public abstract FormulaireSpec getFormulaire();
  
  public abstract void setFormulaire(FormulaireSpec paramFormulaireSpec);
  
  public abstract void setEstFormulaireCharge(boolean paramBoolean);
  
  public abstract boolean estFormulaireCharge();
  
  public abstract GammeSpec getGamme();
  
  public abstract boolean estLiquideeAutomatiquement();
  
  public abstract boolean estLiquideeAvecConflits();
  
  public abstract void setLiquideeAvecConflits(boolean paramBoolean);
  
  public abstract DemandePivot getDemandePivot();
  
  public abstract void setDemandePivot(DemandePivot paramDemandePivot);
  
  public abstract Collection getForcageExecution();
  
  public abstract void validerDecision();
  
  public abstract void setMigree(int paramInt);
  
  public abstract int getMigree();
  
  public abstract boolean estMigree();
  
  public abstract boolean estMigreeEnSimplifiee();
  
  public abstract void setEstNeutraliseeLiquidation(boolean paramBoolean);
  
  public abstract boolean estNeutraliseeLiquidation();
  
  public abstract boolean estReexaminable();
  
  public abstract void setEstNeutraliseeCalcul(boolean paramBoolean);
  
  public abstract boolean estNeutraliseeCalcul();
  
  public abstract boolean estReexecutable();
  
  public abstract void setEstDeneutralisable(boolean paramBoolean);
  
  public abstract boolean estDeneutralisable();
  
  public abstract Damj getDateFinAbonnement();
  
  public abstract Damj getDateRecherche();
  
  public abstract Damj getDateFinAppletLiquidation();
  
  public abstract void setValide(boolean paramBoolean);
  
  public abstract boolean estValide();
  
  public abstract void annulerDecisions();
  
  public abstract String getMotifReexamenPrincipal();
  
  public abstract boolean estCategorieParticuliere();
  
  public abstract Damj getDatePremiereValidation();
  
  public abstract void setDatePremiereValidation(Damj paramDamj);
  
  public abstract void setDateDerniereValidation(Damj paramDamj);
  
  public abstract Damj getDateDerniereValidation();
  
  public abstract void setDateDerniereNotification(Damj paramDamj);
  
  public abstract Damj getDateDerniereNotification();
  
  public abstract void definirDateValidation(Damj paramDamj);
  
  public abstract EvenementReferenceExamenSpec getEvenementReferenceExamen();
  
  public abstract void setEvenementReferenceExamen(EvenementReferenceExamenSpec paramEvenementReferenceExamenSpec);
  
  public abstract Damj getDateDeclenchementExamen();
  
  public abstract boolean estLiquideeEnEtat();
  
  public abstract void setLiquideeEnEtat(boolean paramBoolean);
  
  public abstract boolean estNotifieeCourrier();
  
  public abstract void setNotifieeCourrier(boolean paramBoolean);
  
  public abstract void setCodeMotifEchecPourSigma(String paramString);
  
  public abstract String getCodeMotifEchecPourSigma();
  
  public abstract boolean estReexecutee();
  
  public abstract void setReexecutee(boolean paramBoolean);
  
  public abstract String getCodeMotifEchecPourSigmaSauvegarde();
  
  public abstract void setCodeMotifEchecPourSigmaSauvegarde(String paramString);
  
  public abstract void setDemandeLiquidee(boolean paramBoolean);
  
  public abstract boolean estDemandeLiquidee();
  
  public abstract Hashtable getAlertesNonBloquantes();
  
  public abstract void setAlertesNonBloquantes(Hashtable paramHashtable);
  
  public abstract boolean contientDonneesForcees();
  
  public abstract boolean estReexaminableAutomatiquement();
  
  public abstract void ajouterForcageExecution(UniteTraitementForcee paramUniteTraitementForcee);
  
  public abstract boolean estLiquidable();
  
  public abstract void setEstLiquidable(boolean paramBoolean);
  
  public abstract void supprimerUniteTraitementForcee(UniteTraitementForcee paramUniteTraitementForcee);
  
  public abstract String getCommentaire();
  
  public abstract void setCommentaire(String paramString);
  
  public abstract int getComportmentDemandeMigree();
  
  public abstract void setComportmentDemandeMigree(int paramInt);
  
  public abstract Damj getDateAnnulationReexamen();
  
  public abstract void setDateAnnulationReexamen(Damj paramDamj);
  
  public abstract int getRevisionANotifier();
  
  public abstract void setRevisionANotifier(int paramInt);
  
  public abstract String getModeLiquidation();
  
  public abstract void setModeLiquidation(String paramString);
  
  public abstract boolean estUneDemandePrestation();
  
  public abstract void setTopAppelContribution(boolean paramBoolean);
  
  public abstract boolean getTopAppelContribution();
  
  public abstract Chronologie getChronologieDemandesSansCourante();
  
  public abstract Chronologie getChronologieDemandesAssuranceSansCourante();
  
  public abstract Chronologie getChronologieDemandesSolidariteSansCourante();
  
  public abstract boolean estLiquidableOuReexecutable();
  
  public abstract void restaurerDossiersAffectations()
    throws ApplicativeRuntimeException;
  
  public abstract void supprimerDossiersAffectations();
  
  public abstract void verifierCoherenceDossiersAffectations()
    throws ApplicativeRuntimeException;
  
  public abstract Damj getDateAttribution();
  
  public abstract boolean estEnContexteDemande(String paramString);
  
  public abstract boolean estEnContexteDemande(int paramInt);
  
  public abstract String getCodeAttente();
  
  public abstract void setCodeAttente(String paramString);
  
  public abstract boolean leverAlertePopup();
  
  public abstract DonneesNPDE getDonneesNPDE();
  
  public abstract DonneesSortieNPDESpec getDonneesSortieNPDE();
  
  public abstract String getIdentifiantObjetMetier();
  
  public abstract boolean isDemandeNPDE();
  
  public abstract boolean isDecisionAuto();
  
  public abstract void setDecisionAuto(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     DemandeSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */