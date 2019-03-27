package fr.unedic.cali.dom.echange;

import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.echange.gen.DecisionGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class Decision
  extends DecisionGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = 2823358195097738858L;
  private static final int LIBELLE_EMPLOYEUR = 27;
  
  public Decision()
  {
    initInstance();
  }
  
  public Decision(DomPCSpec pc)
  {
    super(pc);
  }
  
  public ObjetMetierSpec copie()
  {
    Decision copie = new Decision();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec pCopie)
  {
    Decision copie = (Decision)pCopie;
    
    copie.setIdentifiantEvenement(getIdentifiantEvenement());
    copie.setEtatDemande(getEtatDemande());
    copie.setCodeSegment(getCodeSegment());
    copie.setReferenceExterneDemande(getReferenceExterneDemande());
    copie.setGamme(getGamme());
    if ((getLigne() != null) || (!"".equals(getLigne()))) {
      copie.setLigne(getLigne());
    } else {
      copie.setLigne(null);
    }
    if ((getProduit() != null) || (!"".equals(getLigne()))) {
      copie.setProduit(getProduit());
    } else {
      copie.setProduit(null);
    }
    copie.setTypeEchecExamen(getTypeEchecExamen());
    copie.setMotifEchec(getMotifEchec());
    if ((getClassementAdministratif() != null) || (!"".equals(getClassementAdministratif()))) {
      copie.setClassementAdministratif(getClassementAdministratif());
    } else {
      copie.setClassementAdministratif(null);
    }
    copie.setMotifReexamenPrincipal(getMotifReexamenPrincipal());
    copie.setIdentifiantOd(getIdentifiantOd());
    copie.setIdentifiantReprise(getIdentifiantReprise());
    copie.setNatureDecision(getNatureDecision());
    copie.setOrigineDecision(getOrigineDecision());
    copie.setTopContribSupplementaire(getTopContribSupplementaire());
    copie.setTopContribSpecifique(getTopContribSpecifique());
    copie.setTopEchecDemandeExpresseEnCoursIndemnisation(getTopEchecDemandeExpresseEnCoursIndemnisation());
    copie.setTopRejetASUCpaASS(getTopRejetASUCpaASS());
    copie.setTopRejetASUReliquatASS(getTopRejetASUReliquatASS());
    copie.setTopDroitOptionAss(getTopDroitOptionAss());
    copie.setTopIndividuStable(getTopIndividuStable());
    copie.setIdentifiantActionFormation(getIdentifiantActionFormation());
    copie.setExerciceApres(getExerciceApres());
    copie.setExerciceAvant(getExerciceAvant());
    copie.setFraisFpoAvant(getFraisFpoAvant());
    copie.setFraisFthrAvant(getFraisFthrAvant());
    copie.setFraisFpoApres(getFraisFpoApres());
    copie.setFraisFthrApres(getFraisFthrApres());
    copie.setStatutApres(getStatutApres());
    copie.setStatutAvant(getStatutAvant());
    copie.setIndicateurNotificationCourrier(getIndicateurNotificationCourrier());
    copie.setMontantAllocationJournalierBrutCourrier(getMontantAllocationJournalierBrutCourrier());
    copie.setMontantAllocationJournalierNetCourrier(getMontantAllocationJournalierNetCourrier());
    copie.setDureeTheoriqueDroitServiCourrier(getDureeTheoriqueDroitServiCourrier());
    copie.setDureeRenouvellementAreCourrier(getDureeRenouvellementAreCourrier());
    copie.setMontantPensionInvaliditeAreCourrier(getMontantPensionInvaliditeAreCourrier());
    copie.setMontantArePourAerComplementCourrier(getMontantArePourAerComplementCourrier());
    copie.setMontantCrcCourrier(getMontantCrcCourrier());
    copie.setMontantForfaitaireMensuelRpsCourrier(getMontantForfaitaireMensuelRpsCourrier());
    copie.setCompetenceAdministrative(getCompetenceAdministrative());
    copie.setLibelleEmployeur(getLibelleEmployeur());
    copie.setTopAffDerogatoire(getTopAffDerogatoire());
    copie.setMotifRejet(getMotifRejet());
    copie.setMontantSJC(getMontantSJC());
    copie.setMontantSJCMax(getMontantSJCMax());
    copie.setMontantAllocation(getMontantAllocation());
    copie.setMontantAllocationUn(getMontantAllocationUn());
    copie.setMontantAllocationDeux(getMontantAllocationDeux());
    copie.setTopCaisseInconnue(getTopCaisseInconnue());
    copie.setDureeImputationAideSurDroit(getDureeImputationAideSurDroit());
    copie.setTypeAide(getTypeAide());
    copie.setInvestigationFraude(isInvestigationFraude());
    copie.setCodeSousProduit(getCodeSousProduit());
    copie.setDateBanalisee(getDateBanalisee());
    copie.setMontantSJRSuiteRevision(getMontantSJRSuiteRevision());
    copie.setAuMoinsUneActiviteConservee(getAuMoinsUneActiviteConservee());
    copie.setCodeTypeAction(getCodeTypeAction());
    copie.setCreationDALSuiteRejet(getCreationDALSuiteRejet());
    copie.setCodeTypeAttente(getCodeTypeAttente());
    copie.setDateFCT(getDateFCT());
    copie.setTypeExamenCreationDemande(getTypeExamenCreationDemande());
    copie.setContributionNonPropositionCTP(getContributionNonPropositionCTP());
    copie.setEstContribDif(getEstContribDif());
    copie.setEstContribPreavis(getEstContribPreavis());
    copie.setMontantPreavisCR(getMontantPreavisCR());
    copie.setMontantFormationD(getMontantFormationD());
    copie.setTopAppelContributions(getTopAppelContributions());
    copie.setPlafondMensuelRessourcesAss(getPlafondMensuelRessourcesAss());
    copie.setNbEmploisSalariesRetenus(getNbEmploisSalariesRetenus());
    copie.setMontantBrutTranche2(getMontantBrutTranche2());
    copie.setMontantCrcTranche2(getMontantCrcTranche2());
    copie.setDureeTranche2(getDureeTranche2());
    copie.setMontantBrutTranche3(getMontantBrutTranche3());
    copie.setMontantCrcTranche3(getMontantCrcTranche3());
    copie.setDureeTranche3(getDureeTranche3());
    copie.setNombreEnfantsTotal(getNombreEnfantsTotal());
    copie.setNumeroConventionGestion(getNumeroConventionGestion());
    copie.setCodeAffectation(getCodeAffectation());
    copie.setTypeBonApres(getTypeBonApres());
    copie.setTypeBonAvant(getTypeBonAvant());
    copie.setTypeBonAvantDerogatoire(getTypeBonAvantDerogatoire());
    copie.setTypebonApresDerogatoire(getTypebonApresDerogatoire());
    copie.setMontantBonApres(getMontantBonApres());
    copie.setMontantBonApresDerogatoire(getMontantBonApresDerogatoire());
    copie.setMontantBonAvant(getMontantBonAvant());
    copie.setMontantBonAvantDerogatoire(getMontantBonAvantDerogatoire());
    copie.setObjectifLiquidation(getObjectifLiquidation());
    copie.setDateDepartDelai121j(super.getDateDepartDelai121j());
    copie.setIndicateurPremiereDemandePostPrime(getIndicateurPremiereDemandePostPrime());
    copie.setIndicateurDiminutionMontantCSP(getIndicateurDiminutionMontantCSP());
    copie.setIndicateurAllongementDureeCSP(getIndicateurAllongementDureeCSP());
    copie.setTopDemandeASSSuiteDecheance(getTopDemandeASSSuiteDecheance());
    copie.setAttenteBlocageLiquidationAutoRepriseAss(getAttenteBlocageLiquidationAutoRepriseAss());
    copie.setAttenteNationaliteAValider(getAttenteNationaliteAValider());
    copie.setTopDetectionClauseRattrapage(getTopDetectionClauseRattrapage());
    copie.setTopSpectacle2016avantMepSI4(getTopSpectacle2016avantMepSI4());
    copie.setTopAreSpectacleEnCoursClauseRattrapage(getTopAreSpectacleEnCoursClauseRattrapage());
    copie.setNombreJoursFranchiseCP(getNombreJoursFranchiseCP());
    copie.setBaseCalculFranchiseCP(getBaseCalculFranchiseCP());
    copie.setFranchiseCpMensuelle(getFranchiseCpMensuelle());
    copie.setNombreJoursFranchiseSalaire(getNombreJoursFranchiseSalaire());
    copie.setBaseCalculFranchiseSalaire(getBaseCalculFranchiseSalaire());
    copie.setFranchiseSalaireMensuelle(getFranchiseSalaireMensuelle());
    copie.setAttenteIncoherenceSalaireNPDE(getAttenteIncoherenceSalaireNPDE());
    copie.setIdentifiantPeriodeIncoherenceSalaireNPDE(getIdentifiantPeriodeIncoherenceSalaireNPDE());
    copie.setEstPresencePNDS(getEstPresencePNDS());
    copie.setPresenceDerniersSalaires(isPresenceDerniersSalaires());
    copie.setNombreMoisPreavis(getNombreMoisPreavis());
    copie.setCodeSousProduitRejet(getCodeSousProduitRejet());
    copie.setIdentifiantPeriodeIncoherenceRessortissant(getIdentifiantPeriodeIncoherenceRessortissant());
    copie.setDureeAllongementArefPossible(getDureeAllongementArefPossible());
    copie.setDureeAllongementArefRealisee(getDureeAllongementArefRealisee());
    copie.setCoefficientReducteurSJR(getCoefficientReducteurSJR());
    copie.setPlancherCoefReducteur(getPlancherCoefReducteur());
    copie.setTopPresenceDiffereARCE(getTopPresenceDiffereARCE());
    copie.setDiviseurIslr(getDiviseurIslr());
    copie.setNaturePeriodeSuspensive(getNaturePeriodeSuspensive());
    copie.setDateFinPeriodeSuspensive(getDateFinPeriodeSuspensive());
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant() {}
  
  private void initInstance()
  {
    super.setIdentifiantEvenement("");
    super.setEtatDemande(0);
    super.setCodeSegment("");
    super.setReferenceExterneDemande("");
    super.setGamme("");
    
    super.setTypeEchecExamen(0);
    super.setMotifEchec(0);
    
    super.setMotifReexamenPrincipal(0);
    
    super.setIdentifiantOd(0);
    
    super.setIdentifiantReprise(0);
    
    super.setNatureDecision(0);
    super.setOrigineDecision(0);
    
    super.setTopEchecDemandeExpresseEnCoursIndemnisation(0);
    super.setTopRejetASUReliquatASS(0);
    super.setTopRejetASUCpaASS(0);
    super.setTopContribSupplementaire(0);
    super.setTopContribSpecifique(0);
    super.setTopDroitOptionAss(0);
    super.setTopIndividuStable(0);
    super.setTopAffDerogatoire(0);
    super.setTopCaisseInconnue(0);
    
    super.setIndicateurNotificationCourrier(0);
    super.setMontantAllocationJournalierBrutCourrier(ConstantesBaseEchange.DEFAULT_BIGDECIMAL);
    super.setMontantAllocationJournalierNetCourrier(ConstantesBaseEchange.DEFAULT_BIGDECIMAL);
    super.setDureeTheoriqueDroitServiCourrier(0);
    super.setDureeRenouvellementAreCourrier(0);
    super.setMontantPensionInvaliditeAreCourrier(ConstantesBaseEchange.DEFAULT_BIGDECIMAL);
    super.setMontantArePourAerComplementCourrier(ConstantesBaseEchange.DEFAULT_BIGDECIMAL);
    super.setMontantCrcCourrier(ConstantesBaseEchange.DEFAULT_BIGDECIMAL);
    super.setMontantSJC(ConstantesBaseEchange.DEFAULT_BIGDECIMAL);
    super.setMontantSJCMax(ConstantesBaseEchange.DEFAULT_BIGDECIMAL);
    
    super.setIdentifiantActionFormation(0);
    super.setFraisFpoAvant(ConstantesBaseEchange.DEFAULT_BIGDECIMAL);
    super.setFraisFthrAvant(ConstantesBaseEchange.DEFAULT_BIGDECIMAL);
    super.setExerciceAvant(0);
    super.setExerciceApres(0);
    super.setStatutAvant(0);
    super.setStatutApres(0);
    super.setFraisFpoApres(ConstantesBaseEchange.DEFAULT_BIGDECIMAL);
    super.setFraisFthrApres(ConstantesBaseEchange.DEFAULT_BIGDECIMAL);
    
    super.setMontantAllocation(ConstantesBaseEchange.DEFAULT_BIGDECIMAL);
    super.setMontantAllocationUn(ConstantesBaseEchange.DEFAULT_BIGDECIMAL);
    super.setMontantAllocationDeux(ConstantesBaseEchange.DEFAULT_BIGDECIMAL);
    super.setDureeImputationAideSurDroit(0);
    super.setTypeAide("");
    super.setObjectifLiquidation(0);
  }
  
  public void setLibelleEmployeur(String libelleEmployeur)
  {
    if ((libelleEmployeur != null) && (libelleEmployeur.length() > 27)) {
      super.setLibelleEmployeur(libelleEmployeur.substring(0, 27));
    } else {
      super.setLibelleEmployeur(libelleEmployeur);
    }
  }
}

/* Location:
 * Qualified Name:     Decision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */