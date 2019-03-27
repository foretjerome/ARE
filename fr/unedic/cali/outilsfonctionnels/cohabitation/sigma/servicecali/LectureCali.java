package fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.servicecali;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.Demande;
import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.DemandeV1;
import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeV1Spec;
import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.StructureOutDemandeV1Spec;
import fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom.StructureOutDecisionSuivi;
import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.BlocageActu;
import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec.StructureOutBlocageActuSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.Individu;
import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.StructureOutIndividuV1;
import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.TrimestreRetraite;
import fr.unedic.cali.autresdoms.cohab.sigma.listeperiodeaah.dom.StructureOutListePeriodeAAH;
import fr.unedic.cali.autresdoms.cohab.sigma.listeressource.dom.StructureOutListeRessourcesV1;
import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.PeriodePriseEnCharge;
import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.PeriodePriseEnChargeOut;
import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.StructureOutPecV1;
import fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.ResultatServiceCaliV1;
import fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.StructureInCaliV1;
import fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.StructureOutCaliV1;
import fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.spec.CriteresCaliSpec;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteServiceSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LectureCali
{
  public static final String SITUATION_EMPLOI_ARCE = "CEN";
  public static final String CONTEXTE_EESSI_NON_RENSEIGNE = "0";
  public static final String CONTEXTE_EESSI_MAINTIEN_INDEMNISATION_FRANCE = "1";
  public static final String CONTEXTE_EESSI_MAINTIEN_INDEMNISATION_EUROPE = "2";
  public static final String CONTEXTE_EESSI_DOUBLE_INSCRIPTION_FRANCE = "3";
  public static final String CONTEXTE_PEC_NON_INDEMNISABLE_MAYOTTE = "m";
  
  public ResultatServiceCaliV1 lireCali(CriteresCaliSpec p_criteres)
    throws ApplicativeException, TechniqueException
  {
    long startTime = System.currentTimeMillis();
    
    controlerCriteres(p_criteres);
    
    StructureInCaliV1 structureInCaliV1 = new StructureInCaliV1();
    structureInCaliV1.setIdentifiantIndividu(p_criteres.getContexteService().getRsin());
    structureInCaliV1.setCodeAssedic(p_criteres.getContexteService().getAssedicAllocataire());
    structureInCaliV1.setContexteService(p_criteres.getContexteService());
    
    structureInCaliV1.setDateDebutEvtActualisation(p_criteres.getDateDebutEvtActualisation());
    structureInCaliV1.setDateFinEvtActualisation(p_criteres.getDateFinEvtActualisation());
    
    structureInCaliV1.setDateRechercheFormation(p_criteres.getDateRechercheFormation());
    structureInCaliV1.setIdentifiantActionFormation(p_criteres.getIdentifiantActionFormation());
    
    structureInCaliV1.setIdentifiantDemande(p_criteres.getIdentifiantDemande());
    structureInCaliV1.setTypeSegment(p_criteres.getTypeSegmentV1());
    
    StructureOutCaliV1 structureOutCaliV1 = getOutilFonctionnel().lireCali(structureInCaliV1);
    
    long endTime = System.currentTimeMillis();
    if (Log.isTraceActive(LectureCali.class, Niveau.INFO)) {
      Log.ecritTrace(Niveau.INFO, LectureCali.class, "invoqueService", "Temps d'execution du service " + LectureCali.class.getName() + " = " + (endTime - startTime) + " ms");
    }
    ResultatServiceCaliV1 resultat = new ResultatServiceCaliV1();
    
    resultat.setListePeriodesPecV1(formaterResultatPec(structureOutCaliV1.getStructureOutPec().getListePeriodesPec()));
    resultat.setListePeriodesPecV2(formaterResultatPec(structureOutCaliV1.getStructureOutPec().getListePeriodesPecFusionnees()));
    
    resultat.setBlocageActu(formaterResultatBlocageActu(structureOutCaliV1.getStructureOutEvtActualisation()));
    
    resultat.setIndividu(formaterResultatIndividu(structureOutCaliV1.getStructureIndividuV1(), p_criteres));
    
    resultat.setListeDecisions(structureOutCaliV1.getStructureOutDetectionSuivi().getListeDecisionsSuivi());
    
    resultat.setPension(structureOutCaliV1.getStructureOutPension());
    
    resultat.setListeDemandesDAL(formaterResultatDemande(structureOutCaliV1.getStructureOutDemandeDAL()));
    resultat.setListeDemandesRNV(formaterResultatDemande(structureOutCaliV1.getStructureOutDemandeRNV()));
    
    resultat.setListeRessourcesV1(structureOutCaliV1.getStructureOutListeRessourcesV1().getListeRessourcesV1());
    
    resultat.setListePeriodeAAH(structureOutCaliV1.getStructureOutListePeriodeAAH().getListePeriodeAAH());
    
    return resultat;
  }
  
  private void controlerCriteres(CriteresCaliSpec p_criteres)
    throws ContexteException
  {
    if (p_criteres.getNumeroAllocataire() == null) {
      throw new ContexteException("PR_COJAC_L_CONTEXTE_CXALA", "Contexte incomplet : Absence du Numéro Allocataire");
    }
  }
  
  private Collection formaterResultatPec(Collection p_listePecV1)
    throws ContexteException, CoucheLogiqueException
  {
    Collection listePec = new ArrayList();
    for (Iterator iter = p_listePecV1.iterator(); iter.hasNext();)
    {
      PeriodePriseEnChargeOut pecV1Courante = (PeriodePriseEnChargeOut)iter.next();
      PeriodePriseEnCharge pecV2 = new PeriodePriseEnCharge();
      formatePeriodePriseEnCharge(pecV2, pecV1Courante);
      
      setDemandeurEmploi(pecV1Courante, pecV2);
      
      listePec.add(pecV2);
    }
    return listePec;
  }
  
  private BlocageActu formaterResultatBlocageActu(StructureOutBlocageActuSpec p_structureOut)
  {
    BlocageActu blocageActu = new BlocageActu();
    
    blocageActu.setDateEvtBloquant(p_structureOut.getDateEvtBloquant());
    
    blocageActu.setLibelleEvtBloquant(p_structureOut.getLibelleMotifEvtBloquant());
    
    blocageActu.setPeriodesNonPayables(p_structureOut.getPeriodesNonPayables());
    
    blocageActu.setPeriodesAbsenceRetourUL961(p_structureOut.getPeriodesAbsenceRetourUL961());
    
    blocageActu.setPeriodesPresenceRetourUL961(p_structureOut.getPeriodesPresenceRetourUL961());
    
    blocageActu.setDonneesMoisMandates(p_structureOut.getDonneesMoisMandates());
    
    blocageActu.setPeriodesAbsenceRetourAMS(p_structureOut.getPeriodesAbsenceRetourAMS());
    
    return blocageActu;
  }
  
  private Individu formaterResultatIndividu(StructureOutIndividuV1 p_structureOutIndividuV1, CriteresCaliSpec p_criteres)
    throws ContexteException
  {
    Individu individu = new Individu();
    
    individu.setNumeroAllocataire(p_criteres.getNumeroAllocataire());
    individu.setNom(p_structureOutIndividuV1.getNom());
    individu.setNomMarital(p_structureOutIndividuV1.getNomMarital());
    individu.setPrenom(p_structureOutIndividuV1.getPrenom());
    individu.setDateNaissance(p_structureOutIndividuV1.getDateNaissance());
    individu.setDateDeces(p_structureOutIndividuV1.getDateDeces());
    individu.setDateLiquidationRetraite(p_structureOutIndividuV1.getDateLiquidationRetraite());
    individu.setDateRetraiteAnticipe(p_structureOutIndividuV1.getDateRetraiteAnticipe());
    individu.setMotifRetraiteAnticipe(p_structureOutIndividuV1.getMotifRetraiteAnticipe());
    
    TrimestreRetraite trimestreRetraite = new TrimestreRetraite();
    trimestreRetraite.setDateEvenement(p_structureOutIndividuV1.getDateAcquisitionTrimestres());
    trimestreRetraite.setDateValeurTrimestre(p_structureOutIndividuV1.getDateAcquisitionTrimestres());
    trimestreRetraite.setNombreTrimestre(p_structureOutIndividuV1.getNombreTrimestre());
    trimestreRetraite.setDateCentTrimestres(p_structureOutIndividuV1.getDateCentTrimestres());
    
    individu.setTrimestreRetraite(trimestreRetraite);
    
    individu.setBeneficiaireSapa(p_structureOutIndividuV1.isBeneficiaireSapa());
    individu.setBeneficiaireRsa(p_structureOutIndividuV1.isBeneficiaireRsa());
    individu.setAcompteNonSolde(p_structureOutIndividuV1.isAcompteNonSolde());
    individu.setExclusionIndividuelle(p_structureOutIndividuV1.isExclusionIndividuelle());
    individu.setEtatCivil(p_structureOutIndividuV1.getEtatCivil());
    individu.setDernierJourAtteste(p_structureOutIndividuV1.getDernierJourAtteste());
    individu.setDatePeremptionTitreSejour(p_structureOutIndividuV1.getDatePeremptionTitreSejour());
    individu.setDateLimiteIndemnisation(p_structureOutIndividuV1.getDateLimiteIndemnisation());
    
    individu.setCodeAntenne(p_structureOutIndividuV1.getCodeAntenne());
    individu.setReferenceExterne(p_structureOutIndividuV1.getReferenceExterne());
    
    individu.setIndividuMigre(p_structureOutIndividuV1.isIndividuMigre());
    individu.setEtatMigration(p_structureOutIndividuV1.getEtatMigration());
    
    individu.setRsodDernierAdmission(p_structureOutIndividuV1.getRsodDernierAdmission());
    individu.setCodeEtatTransfert(p_structureOutIndividuV1.getCodeEtatTransfert());
    
    individu.setDateDeCalculAuPlusTot(p_structureOutIndividuV1.getDateCalculAuPlusTot());
    
    individu.setDjams(p_structureOutIndividuV1.getDjams());
    
    individu.setEstAlerteAD(p_structureOutIndividuV1.estAlerteAD());
    
    return individu;
  }
  
  private Collection formaterResultatDemande(StructureOutDemandeV1Spec p_listeDemandesV1)
    throws ContexteException
  {
    Collection listeDemandes = new ArrayList();
    for (Iterator iter = p_listeDemandesV1.getListeDemandes().iterator(); iter.hasNext();)
    {
      DemandeV1 demandeV1 = (DemandeV1)iter.next();
      DemandeSpec demandeV2 = formateDemandeV1EnV2(demandeV1);
      listeDemandes.add(demandeV2);
    }
    return listeDemandes;
  }
  
  private DemandeSpec formateDemandeV1EnV2(DemandeV1Spec p_demandeV1)
  {
    DemandeSpec demandeV2 = new Demande();
    
    demandeV2.setGamme(p_demandeV1.getGamme());
    demandeV2.setLigne(p_demandeV1.getLigne());
    demandeV2.setProduit(p_demandeV1.getProduit());
    demandeV2.setTypeExamen(p_demandeV1.getTypeExamen());
    demandeV2.setDateDepot(p_demandeV1.getDateDepot());
    demandeV2.setDateDemande(p_demandeV1.getDateDemande());
    demandeV2.setIdentifiantPec(p_demandeV1.getIdentifiantPec());
    demandeV2.setIdentifiantDemande(p_demandeV1.getReferenceExterne());
    demandeV2.setEtatLiquidable(p_demandeV1.getEtatLiquidable());
    demandeV2.setPresenceAE(p_demandeV1.getPresenceAE());
    demandeV2.setIdentifiantFormation(p_demandeV1.getIdentifiantFormation());
    demandeV2.setReferenceRejetDV(p_demandeV1.getReferenceRejetDV());
    
    demandeV2.setRefusFNE(p_demandeV1.getRefusFNE());
    demandeV2.setPropositionCrpCtp(p_demandeV1.getPropositionCrpCtp());
    demandeV2.setDroitCongeReclassement(p_demandeV1.isDroitCongeReclassement());
    
    demandeV2.setNumeroSuivi(p_demandeV1.getNumeroSuivi());
    
    demandeV2.setEstEnvoiDalEffectue(p_demandeV1.estEnvoiDalEffectue());
    
    demandeV2.setEstDemandeMandatee(p_demandeV1.estDemandeMandatee());
    demandeV2.setIdentifiantTiersBeneficiaire(p_demandeV1.getIdentifiantTiersBeneficiaire());
    demandeV2.setIdentifiantTiersDemandeur(p_demandeV1.getIdentifiantTiersDemandeur());
    
    demandeV2.setDeploiementDalInstruction(p_demandeV1.getDeploiementDalInstruction());
    return demandeV2;
  }
  
  private void setDemandeurEmploi(PeriodePriseEnChargeOut p_pecV1, PeriodePriseEnCharge p_pecV2)
  {
    boolean demandeurEmploi = false;
    if ("m".equals(p_pecV1.getContextePECNonIndemnisable())) {
      demandeurEmploi = false;
    } else if ((p_pecV1.getContexteEESSI().equals("2")) || (p_pecV1.getContexteEESSI().equals("3"))) {
      demandeurEmploi = false;
    } else if (((p_pecV1.getTypePec().equals("1")) && (p_pecV1.getSousTypePec().equals("1"))) || ((p_pecV1.getTypePec().equals("1")) && (p_pecV1.getSousTypePec().equals("2"))) || ((p_pecV1.getTypePec().equals("1")) && (p_pecV1.getSousTypePec().equals("3"))) || ((p_pecV1.getTypePec().equals("2")) && (p_pecV1.getSousTypePec().equals("1"))) || ((p_pecV1.getTypePec().equals("2")) && (p_pecV1.getSousTypePec().equals("2"))) || ((p_pecV1.getTypePec().equals("2")) && (p_pecV1.getSousTypePec().equals("5"))) || ((p_pecV1.getTypePec().equals("1")) && (p_pecV1.getSousTypePec().equals("7")) && ((!p_pecV1.getSituationEmploi().equals("CEN")) || (!p_pecV1.getCodeAuTitre().equals("3"))))) {
      demandeurEmploi = true;
    } else if (((p_pecV1.getTypePec().equals("1")) && (p_pecV1.getSousTypePec().equals("4"))) || ((p_pecV1.getTypePec().equals("1")) && (p_pecV1.getSousTypePec().equals("5"))) || ((p_pecV1.getTypePec().equals("1")) && (p_pecV1.getSousTypePec().equals("9"))) || ((p_pecV1.getTypePec().equals("2")) && (p_pecV1.getSousTypePec().equals("4"))) || (p_pecV1.getTypePec().equals("3")) || (p_pecV1.getTypePec().equals("6")) || ((p_pecV1.getTypePec().equals("1")) && (p_pecV1.getSousTypePec().equals("7")) && (p_pecV1.getCodeAuTitre().equals("3")) && (p_pecV1.getSituationEmploi().equals("CEN")))) {
      demandeurEmploi = false;
    } else if (p_pecV1.getTypePec().equals("4")) {
      demandeurEmploi = true;
    } else if (((p_pecV1.getTypePec().equals("1")) && (p_pecV1.getSousTypePec().equals("6"))) || ((p_pecV1.getTypePec().equals("1")) && (p_pecV1.getSousTypePec().equals("8"))) || ((p_pecV1.getTypePec().equals("2")) && (p_pecV1.getSousTypePec().equals("6")))) {
      demandeurEmploi = false;
    }
    p_pecV2.setDemandeurEmploi(demandeurEmploi);
  }
  
  private void formatePeriodePriseEnCharge(PeriodePriseEnCharge p_pecV2, PeriodePriseEnChargeOut p_pecV1Courante)
  {
    p_pecV2.setCategorie(p_pecV1Courante.getCategorie());
    p_pecV2.setCes(p_pecV1Courante.isCes());
    p_pecV2.setDateDebut(p_pecV1Courante.getDateDebut());
    p_pecV2.setDateFin(p_pecV1Courante.getDateFin());
    p_pecV2.setDispense(p_pecV1Courante.isDispense());
    p_pecV2.setIdentifiantPec(p_pecV1Courante.getIdentifiantPec());
    p_pecV2.setMotifAnnulation(p_pecV1Courante.getMotifAnnulation());
    p_pecV2.setDateDispense(p_pecV1Courante.getDateDispense());
    p_pecV2.setAleIndividu(p_pecV1Courante.getAleIndividu());
    p_pecV2.setSituationEmploi(p_pecV1Courante.getSituationEmploi());
    p_pecV2.setTypePec(p_pecV1Courante.getTypePec());
    p_pecV2.setSousTypePec(p_pecV1Courante.getSousTypePec());
    
    p_pecV2.setCodeAuTitre(p_pecV1Courante.getCodeAuTitre());
    p_pecV2.setContextePECNonIndemnisable(p_pecV1Courante.getContextePECNonIndemnisable());
    p_pecV2.setContexteEESSI(p_pecV1Courante.getContexteEESSI());
    p_pecV2.setCodePays(p_pecV1Courante.getCodePays());
    
    p_pecV2.setActualisable(p_pecV1Courante.isActualisable());
    p_pecV2.setNumeroAffiliation(p_pecV1Courante.getNumeroAffiliation());
    p_pecV2.setNumeroSiren(p_pecV1Courante.getNumeroSiren());
    p_pecV2.setIdentifiantBne(p_pecV1Courante.getIdentifiantBne());
  }
  
  public AppelV1Cali getOutilFonctionnel()
  {
    return new AppelV1Cali();
  }
}

/* Location:
 * Qualified Name:     LectureCali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */