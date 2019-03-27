package fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.servicecali;

import fr.pe.cali.client.ManagerAppelsServicesDR1;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.DemandeV1;
import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.StructureOutDemandeV1;
import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeV1Spec;
import fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom.DecisionSuivi;
import fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom.StructureOutDecisionSuivi;
import fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom.spec.DecisionSuiviSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.dom.MapperContexteService;
import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.DonneesEvtActu;
import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.StructureOutBlocageActu;
import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec.DonneesEvtActuSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec.StructureOutBlocageActuSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.StructureOutIndividuV1;
import fr.unedic.cali.autresdoms.cohab.sigma.listeperiodeaah.dom.StructureOutListePeriodeAAH;
import fr.unedic.cali.autresdoms.cohab.sigma.listeressource.dom.Ressource;
import fr.unedic.cali.autresdoms.cohab.sigma.listeressource.dom.StructureOutListeRessourcesV1;
import fr.unedic.cali.autresdoms.cohab.sigma.listeressource.dom.spec.RessourceSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.outilsfonctionnels.FormateValeurSigma;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.AvantageVieillesse;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.Pension;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.PensionInvalidite;
import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.PeriodePriseEnChargeOut;
import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.StructureOutPecV1;
import fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.StructureInCaliV1;
import fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.StructureOutCaliV1;
import fr.unedic.cali.dom.PeriodeDroitAAH;
import fr.unedic.logique.donnees.dr1.service.vls.YI54;
import fr.unedic.logique.donnees.dr1.service.vls.YI55;
import fr.unedic.logique.donnees.dr1.service.vls.YI57;
import fr.unedic.logique.donnees.dr1.service.vls.YI59;
import fr.unedic.logique.donnees.dr1.service.vls.YI5I;
import fr.unedic.logique.donnees.dr1.service.vls.YI5L;
import fr.unedic.logique.donnees.dr1.service.vls.YI5N;
import fr.unedic.logique.donnees.dr1.service.vls.YI5T;
import fr.unedic.logique.donnees.dr1.service.vls.YI5U;
import fr.unedic.logique.donnees.dr1.service.vls.YI5V;
import fr.unedic.logique.donnees.dr1.service.vls.YI5W;
import fr.unedic.logique.donnees.dr1.service.vls.YI5X;
import fr.unedic.logique.donnees.dr1.service.vls.YI5Y;
import fr.unedic.logique.donnees.dr1.service.vls.YI67;
import fr.unedic.logique.donnees.dr1.service.vls.YI70_IN;
import fr.unedic.logique.donnees.dr1.service.vls.YI70_OUT;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI54;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI54ET;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI55;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI55ET;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI57;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI57ET;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI59;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI59ET;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5I;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5IET;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5L;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5LET;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5U;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5UET;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5V;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5VET;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5W;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5WET;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5X;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5XET;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5Y;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5YET;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5Z;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI5ZET;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI67;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI67ET;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI70;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI54;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI54ET;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI54IT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI54LT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI55;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI55ET;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI55IT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI55LT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI57;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI57ET;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI57IT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI57LT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI59;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI59ET;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI59IT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI59LT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5I;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5IET;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5IIT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5ILT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5L;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5LET;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5LIT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5LLT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5N;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5NIT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5NLT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5T;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5TET;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5TIT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5TLT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5U;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5UET;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5UIT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5ULT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5V;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5VET;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5VIT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5VLT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5W;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5WET;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5WIT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5WLT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5X;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5XET;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5XIT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5XLT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5Y;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5YET;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5YIT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5YLT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5Z;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI5ZET;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI67;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI67ET;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI67IT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI67LT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI70;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;

public class AppelV1Cali
{
  public StructureOutCaliV1 lireCali(StructureInCaliV1 p_criteresCali)
    throws ApplicativeException, TechniqueException
  {
    String identifiantIndividu = p_criteresCali.getIdentifiantIndividu();
    String codeAssedic = p_criteresCali.getCodeAssedic();
    
    StructureOutCaliV1 structureOutCali = new StructureOutCaliV1();
    
    StructureOutPecV1 structureOutPec = structureOutCali.getStructureOutPec();
    StructureOutBlocageActu structureOutEvtActualisation = structureOutCali.getStructureOutEvtActualisation();
    StructureOutIndividuV1 structureOutIndividu = structureOutCali.getStructureIndividuV1();
    StructureOutDecisionSuivi structureOutDetectionSuivi = structureOutCali.getStructureOutDetectionSuivi();
    Pension structureOutPension = structureOutCali.getStructureOutPension();
    StructureOutDemandeV1 structureOutDemandeDAL = structureOutCali.getStructureOutDemandeDAL();
    StructureOutDemandeV1 structureOutDemandeRNV = structureOutCali.getStructureOutDemandeRNV();
    StructureOutListeRessourcesV1 structureOutListeRessourcesV1 = structureOutCali.getStructureOutListeRessourcesV1();
    StructureOutListePeriodeAAH structureOutListePeriodeAAH = structureOutCali.getStructureOutListePeriodeAAH();
    
    ZOEI10YI70 dr1Out = ZOEI10YI70.getInstance();
    try
    {
      ZIEI10YI70 dr1In = ZIEI10YI70.getInstance();
      
      YI70_IN zoneComIn = dr1In.setNewYI70_IN_Z__COMMUNICATION_FEI10O();
      zoneComIn.setCSAS_CODE_UNEDIC_DE_L_ASSEDIC(new BigDecimal(codeAssedic));
      zoneComIn.setRSIN_IDENTIFIANT_DE_L_INDIVIDU(identifiantIndividu);
      zoneComIn.setYI20_Entete_Applicative(MapperContexteService.formate(p_criteresCali.getContexteService()));
      
      boolean isPremierAppel = true;
      boolean isListeIncomplete = true;
      int compteur = 1;
      int nombreMaximumReentrance = 20;
      while ((isPremierAppel) || (isListeIncomplete))
      {
        if (compteur >= nombreMaximumReentrance) {
          throw new CoucheLogiqueException("PR_COJAC_L_APPLIC_SERVICE_V1_REENTRANCE", "Nombre maximum d'appel en réentrance atteint: " + compteur);
        }
        if (isPremierAppel) {
          premiereInitialisation(zoneComIn);
        } else {
          reentranceInitialisation(zoneComIn, dr1Out);
        }
        dr1Out = appelServiceDr1(dr1In);
        
        YI70_OUT zoneComOut = dr1Out.getYI70_OUT_Z__COMMUNICATION_FEI10O();
        if (isPremierAppel)
        {
          formaterResultatIndividu(zoneComOut, structureOutIndividu);
          
          structureOutEvtActualisation.setDateEvtBloquant(zoneComOut.getDEBPA2_EFFET_BLOCAGE_PAIEMENT_ALLOCATAIRE());
          structureOutEvtActualisation.setMotifEvtBloquant(zoneComOut.getCSBPA_NATURE_BLOCAGE_PAIEMENT_ALLOCATAIRE());
        }
        formaterResultatPecV1(zoneComOut, structureOutPec);
        formaterResultatPecFusioneesV1(zoneComOut, structureOutPec);
        
        formaterResultatAbsencePointage(zoneComOut, structureOutEvtActualisation);
        formaterResultatAbsenceUL961(zoneComOut, structureOutEvtActualisation);
        formaterResultatPresenceUL961(zoneComOut, structureOutEvtActualisation);
        formaterResultatMoisMandates(zoneComOut, structureOutEvtActualisation);
        formaterResultatAbsenceRetourAMS(zoneComOut, structureOutEvtActualisation);
        
        formaterResultatDetectionSuivi(zoneComOut, structureOutDetectionSuivi);
        
        formaterResultatPension(zoneComOut, structureOutPension);
        
        formaterResultatDemandeDAL(zoneComOut, structureOutDemandeDAL);
        formaterResultatDemandeRNV(zoneComOut, structureOutDemandeRNV);
        
        formaterResultatRessourcesV1(zoneComOut, structureOutListeRessourcesV1);
        
        formaterResultatPeriodeAAH(zoneComOut, structureOutListePeriodeAAH);
        
        isPremierAppel = false;
        isListeIncomplete = verificationIndicateurFinDeListeAZero(zoneComOut);
        if ((!isListeIncomplete) && (compteur > 1)) {
          Log.ecritTrace(Niveau.ERROR, AppelV1Cali.class, "demarrer", "\t\t ***** Détection du besoin de réentrance lors de l'appel du service cali FEI10O : numero allocataire = " + identifiantIndividu + " et codeAssedic = " + codeAssedic + " ; nombre d'appel = " + compteur + "\n");
        }
        compteur++;
      }
    }
    catch (ContexteException ce)
    {
      throw new CoucheLogiqueException("PR_COJAC_L_APPLIC_SERVICE_V1", "Erreur lors du traitement du service V1 FEI10O", ce);
    }
    catch (CoucheLogiqueException cle)
    {
      throw new CoucheLogiqueException("PR_COJAC_L_APPLIC_SERVICE_V1_REENTRANCE", "Nombre maximum d'appel en réentrance atteint", cle);
    }
    catch (ApplicativeException ae)
    {
      throw new CoucheLogiqueException("PR_COJAC_L_APPLIC_SERVICE_V1", "Erreur lors du traitement du service V1 FEI10O", ae);
    }
    return structureOutCali;
  }
  
  private void premiereInitialisation(YI70_IN p_zoneComIn)
  {
    String space = " ";
    BigDecimal valeurClePremierAppel = new BigDecimal(0);
    
    initialiseResultatPecV1(p_zoneComIn, space, valeurClePremierAppel);
    
    initialiseAbsenceActu(p_zoneComIn, space, valeurClePremierAppel, valeurClePremierAppel);
    initialiseAbsenceUL961(p_zoneComIn, space, valeurClePremierAppel, valeurClePremierAppel);
    initialiseAbsenceRetourAMS(p_zoneComIn, space, valeurClePremierAppel, valeurClePremierAppel);
    initialiseMaintien(p_zoneComIn, space, valeurClePremierAppel, valeurClePremierAppel);
    initialiseMoisMandates(p_zoneComIn, space, valeurClePremierAppel, valeurClePremierAppel);
    
    initialiseResultatDetectionSuivi(p_zoneComIn, space, valeurClePremierAppel, valeurClePremierAppel);
    
    initialisePensionInvalidite(p_zoneComIn, space, space);
    initialisePensionVieillesse(p_zoneComIn, space, space);
    
    initialiseDemandeDAL(p_zoneComIn, space, valeurClePremierAppel);
    initialiseDemandeRNV(p_zoneComIn, space, valeurClePremierAppel);
    
    initialiseResultatRessourcesV1(p_zoneComIn, space, valeurClePremierAppel, valeurClePremierAppel);
  }
  
  private void reentranceInitialisation(YI70_IN p_zoneComIn, ZOEI10YI70 p_dr1Out)
  {
    YI70_OUT yi70out = p_dr1Out.getYI70_OUT_Z__COMMUNICATION_FEI10O();
    BigDecimal cleDSAASS = yi70out.getDSAASS_SIECLE_ANNEE_D_IMPUTATION();
    BigDecimal cleDSMA = yi70out.getDSMA_MOIS_D_IMPUTATION();
    
    initialiseResultatPecV1(p_zoneComIn, yi70out.getZOEI10YI55_COMPLT_Z__COM__YI85().getZOEI10YI55ET().getFIN_LISTE_Indicateur_de_fin_de_liste(), yi70out.getRSPECS_IDENT__SUIVANT_LISTE_PRISE_EN_CHARGE());
    
    initialiseAbsenceActu(p_zoneComIn, yi70out.getZOEI10YI59_COMPLT_ZONE_COM_().getZOEI10YI59ET().getFIN_LISTE_Indicateur_de_fin_de_liste(), cleDSAASS, cleDSMA);
    
    initialiseAbsenceUL961(p_zoneComIn, yi70out.getZOEI10YI5W_COMPLT_ZONE_COM__YI79__UL961_().getZOEI10YI5WET().getFIN_LISTE_Indicateur_de_fin_de_liste(), cleDSAASS, cleDSMA);
    
    initialiseAbsenceRetourAMS(p_zoneComIn, yi70out.getZOEI10YI5X_COMPLT_ZONE_COM__YI79__MANDATEMENT_().getZOEI10YI5XET().getFIN_LISTE_Indicateur_de_fin_de_liste(), cleDSAASS, cleDSMA);
    
    initialiseMaintien(p_zoneComIn, yi70out.getZOEI10YI5Y_COMPLT_ZONE_COM__YI79__ADR_2009_().getZOEI10YI5YET().getFIN_LISTE_Indicateur_de_fin_de_liste(), cleDSAASS, cleDSMA);
    
    initialiseMoisMandates(p_zoneComIn, yi70out.getZOEI10YI5Z_COMPLT_ZONE_COM__YI79__EESSI_().getZOEI10YI5ZET().getFIN_LISTE_Indicateur_de_fin_de_liste(), cleDSAASS, cleDSMA);
    
    initialiseResultatDetectionSuivi(p_zoneComIn, yi70out.getZOEI10YI54_COMPLT_Z__COM__YI73().getZOEI10YI54ET().getFIN_LISTE_Indicateur_de_fin_de_liste(), yi70out.getRSODK_IDENTIFIANT_DE_L_OUVERTURE_DE_DROIT(), yi70out.getNSDEC7_DERNIER_NUMERO_DE_DECISION_SUIVI());
    
    initialisePensionInvalidite(p_zoneComIn, yi70out.getZOEI10YI5I_COMPLT_Z__COM__YI75__pensions_().getZOEI10YI5IET().getFIN_LISTE_Indicateur_de_fin_de_liste(), yi70out.getKRENTP_IDENTIFIANT_BANALISE_PERIODE());
    
    initialisePensionVieillesse(p_zoneComIn, yi70out.getZOEI10YI5V_COMPLT_Z__COM__YI75__Av__Vieillesse_().getZOEI10YI5VET().getFIN_LISTE_Indicateur_de_fin_de_liste(), yi70out.getKRENTR_IDENT__BANALISE_REENTRANCERANCE());
    
    initialiseDemandeDAL(p_zoneComIn, yi70out.getZOEI10YI57_COMPLT_Z__COM__YI77().getZOEI10YI57ET().getFIN_LISTE_Indicateur_de_fin_de_liste(), yi70out.getRSIA_IDENTIF__DEMANDE_ALLOCATION_EDITEE());
    
    initialiseDemandeRNV(p_zoneComIn, yi70out.getZOEI10YI67_COMPLT_Z__COM__YI74().getZOEI10YI67ET().getFIN_LISTE_Indicateur_de_fin_de_liste(), yi70out.getRSEQ_NUMERO_DOSSIER_DE_SUIVI());
    
    initialiseResultatRessourcesV1(p_zoneComIn, yi70out.getZOEI10YI5L_COPIE_YI5K_POUR_YI70().getZOEI10YI5LET().getFIN_LISTE_Indicateur_de_fin_de_liste(), yi70out.getNSARS_ANNEE_DE_PERCEPTION_DES_RESSOURCES(), yi70out.getNSRRS_MOIS_DE_PERCEPTION_DES_RESSOURCES());
  }
  
  private boolean verificationIndicateurFinDeListeAZero(YI70_OUT p_yi70Out)
  {
    return (p_yi70Out.getZOEI10YI54_COMPLT_Z__COM__YI73().getZOEI10YI54ET().getFIN_LISTE_Indicateur_de_fin_de_liste().equals("0")) || (p_yi70Out.getZOEI10YI55_COMPLT_Z__COM__YI85().getZOEI10YI55ET().getFIN_LISTE_Indicateur_de_fin_de_liste().equals("0")) || (p_yi70Out.getZOEI10YI57_COMPLT_Z__COM__YI77().getZOEI10YI57ET().getFIN_LISTE_Indicateur_de_fin_de_liste().equals("0")) || (p_yi70Out.getZOEI10YI67_COMPLT_Z__COM__YI74().getZOEI10YI67ET().getFIN_LISTE_Indicateur_de_fin_de_liste().equals("0")) || (p_yi70Out.getZOEI10YI5I_COMPLT_Z__COM__YI75__pensions_().getZOEI10YI5IET().getFIN_LISTE_Indicateur_de_fin_de_liste().equals("0")) || (p_yi70Out.getZOEI10YI5L_COPIE_YI5K_POUR_YI70().getZOEI10YI5LET().getFIN_LISTE_Indicateur_de_fin_de_liste().equals("0")) || (p_yi70Out.getZOEI10YI5V_COMPLT_Z__COM__YI75__Av__Vieillesse_().getZOEI10YI5VET().getFIN_LISTE_Indicateur_de_fin_de_liste().equals("0")) || (p_yi70Out.getZOEI10YI5W_COMPLT_ZONE_COM__YI79__UL961_().getZOEI10YI5WET().getFIN_LISTE_Indicateur_de_fin_de_liste().equals("0")) || (p_yi70Out.getZOEI10YI5X_COMPLT_ZONE_COM__YI79__MANDATEMENT_().getZOEI10YI5XET().getFIN_LISTE_Indicateur_de_fin_de_liste().equals("0")) || (p_yi70Out.getZOEI10YI5Y_COMPLT_ZONE_COM__YI79__ADR_2009_().getZOEI10YI5YET().getFIN_LISTE_Indicateur_de_fin_de_liste().equals("0")) || (p_yi70Out.getZOEI10YI5Z_COMPLT_ZONE_COM__YI79__EESSI_().getZOEI10YI5ZET().getFIN_LISTE_Indicateur_de_fin_de_liste().equals("0"));
  }
  
  private void initialiseResultatPecV1(YI70_IN p_zoneComIn, String p_indicateur, BigDecimal p_identifiantCle)
  {
    p_zoneComIn.setNewZIEI10YI55_COMPLT_Z__COM__YI85();
    p_zoneComIn.getZIEI10YI55_COMPLT_Z__COM__YI85().setNewZIEI10YI55ET();
    p_zoneComIn.getZIEI10YI55_COMPLT_Z__COM__YI85().getZIEI10YI55ET().setFIN_LISTE_Indicateur_de_fin_de_liste(p_indicateur);
    p_zoneComIn.setRSPECS_IDENT__SUIVANT_LISTE_PRISE_EN_CHARGE(p_identifiantCle);
  }
  
  private void initialiseResultatPecFusionneesV1(YI70_IN p_zoneComIn, String p_indicateur, BigDecimal p_identifiantCle)
  {
    p_zoneComIn.setNewZIEI10YI5U_COMPLT_Z__COM__YI85__PEC_FUSIONNEES_();
    p_zoneComIn.getZIEI10YI5U_COMPLT_Z__COM__YI85__PEC_FUSIONNEES_().setNewZIEI10YI5UET();
    p_zoneComIn.getZIEI10YI5U_COMPLT_Z__COM__YI85__PEC_FUSIONNEES_().getZIEI10YI5UET().setFIN_LISTE_Indicateur_de_fin_de_liste(p_indicateur);
    p_zoneComIn.setRSPECS_IDENT__SUIVANT_LISTE_PRISE_EN_CHARGE(p_identifiantCle);
  }
  
  private void initialiseAbsenceActu(YI70_IN p_zoneComIn, String p_indicateur, BigDecimal p_identifiantCleDSAASS, BigDecimal p_identifiantCleDSMA)
  {
    p_zoneComIn.setNewZIEI10YI59_COMPLT_ZONE_COM_();
    p_zoneComIn.getZIEI10YI59_COMPLT_ZONE_COM_().setNewZIEI10YI59ET();
    p_zoneComIn.getZIEI10YI59_COMPLT_ZONE_COM_().getZIEI10YI59ET().setFIN_LISTE_Indicateur_de_fin_de_liste(p_indicateur);
    p_zoneComIn.setDSAASS_SIECLE_ANNEE_D_IMPUTATION(p_identifiantCleDSAASS);
    p_zoneComIn.setDSMA_MOIS_D_IMPUTATION(p_identifiantCleDSMA);
  }
  
  private void initialiseAbsenceUL961(YI70_IN p_zoneComIn, String p_indicateur, BigDecimal p_identifiantCleDSAASS, BigDecimal p_identifiantCleDSMA)
  {
    p_zoneComIn.setNewZIEI10YI5W_COMPLT_ZONE_COM__YI79__UL961_();
    p_zoneComIn.getZIEI10YI5W_COMPLT_ZONE_COM__YI79__UL961_().setNewZIEI10YI5WET();
    p_zoneComIn.getZIEI10YI5W_COMPLT_ZONE_COM__YI79__UL961_().getZIEI10YI5WET().setFIN_LISTE_Indicateur_de_fin_de_liste(p_indicateur);
    p_zoneComIn.setDSAASS_SIECLE_ANNEE_D_IMPUTATION(p_identifiantCleDSAASS);
    p_zoneComIn.setDSMA_MOIS_D_IMPUTATION(p_identifiantCleDSMA);
  }
  
  private void initialiseMoisMandates(YI70_IN p_zoneComIn, String p_indicateur, BigDecimal p_identifiantCleDSAASS, BigDecimal p_identifiantCleDSMA)
  {
    p_zoneComIn.setNewZIEI10YI5X_COMPLT_ZONE_COM__YI79__MANDATEMENT_();
    p_zoneComIn.getZIEI10YI5X_COMPLT_ZONE_COM__YI79__MANDATEMENT_().setNewZIEI10YI5XET();
    p_zoneComIn.getZIEI10YI5X_COMPLT_ZONE_COM__YI79__MANDATEMENT_().getZIEI10YI5XET().setFIN_LISTE_Indicateur_de_fin_de_liste(p_indicateur);
    p_zoneComIn.setDSAASS_SIECLE_ANNEE_D_IMPUTATION(p_identifiantCleDSAASS);
    p_zoneComIn.setDSMA_MOIS_D_IMPUTATION(p_identifiantCleDSMA);
  }
  
  private void initialiseAbsenceRetourAMS(YI70_IN p_zoneComIn, String p_indicateur, BigDecimal p_identifiantCleDSAASS, BigDecimal p_identifiantCleDSMA)
  {
    p_zoneComIn.setNewZIEI10YI5Y_COMPLT_ZONE_COM__YI79__ADR_2009_();
    p_zoneComIn.getZIEI10YI5Y_COMPLT_ZONE_COM__YI79__ADR_2009_().setNewZIEI10YI5YET();
    p_zoneComIn.getZIEI10YI5Y_COMPLT_ZONE_COM__YI79__ADR_2009_().getZIEI10YI5YET().setFIN_LISTE_Indicateur_de_fin_de_liste(p_indicateur);
    p_zoneComIn.setDSAASS_SIECLE_ANNEE_D_IMPUTATION(p_identifiantCleDSAASS);
    p_zoneComIn.setDSMA_MOIS_D_IMPUTATION(p_identifiantCleDSMA);
  }
  
  private void initialiseMaintien(YI70_IN p_zoneComIn, String p_indicateur, BigDecimal p_identifiantCleDSAASS, BigDecimal p_identifiantCleDSMA)
  {
    p_zoneComIn.setNewZIEI10YI5Z_COMPLT_ZONE_COM__YI79__EESSI_();
    p_zoneComIn.getZIEI10YI5Z_COMPLT_ZONE_COM__YI79__EESSI_().setNewZIEI10YI5ZET();
    p_zoneComIn.getZIEI10YI5Z_COMPLT_ZONE_COM__YI79__EESSI_().getZIEI10YI5ZET().setFIN_LISTE_Indicateur_de_fin_de_liste(p_indicateur);
    p_zoneComIn.setDSAASS_SIECLE_ANNEE_D_IMPUTATION(p_identifiantCleDSAASS);
    p_zoneComIn.setDSMA_MOIS_D_IMPUTATION(p_identifiantCleDSMA);
  }
  
  private void initialiseResultatDetectionSuivi(YI70_IN zoneComIn, String indicateur, BigDecimal identifiantCle, BigDecimal numDecisionSuivi)
  {
    zoneComIn.setNewZIEI10YI54_COMPLT_Z__COM__YI73();
    zoneComIn.getZIEI10YI54_COMPLT_Z__COM__YI73().setNewZIEI10YI54ET();
    zoneComIn.getZIEI10YI54_COMPLT_Z__COM__YI73().getZIEI10YI54ET().setFIN_LISTE_Indicateur_de_fin_de_liste(indicateur);
    zoneComIn.setRSODK_IDENTIFIANT_DE_L_OUVERTURE_DE_DROIT(identifiantCle);
    zoneComIn.setNSDEC7_DERNIER_NUMERO_DE_DECISION_SUIVI(numDecisionSuivi);
  }
  
  private void initialisePensionInvalidite(YI70_IN p_zoneComIn, String p_indicateur, String p_identifiantCle)
  {
    p_zoneComIn.setNewZIEI10YI5I_COMPLT_Z__COM__YI75__pensions_();
    p_zoneComIn.getZIEI10YI5I_COMPLT_Z__COM__YI75__pensions_().setNewZIEI10YI5IET();
    p_zoneComIn.getZIEI10YI5I_COMPLT_Z__COM__YI75__pensions_().getZIEI10YI5IET().setFIN_LISTE_Indicateur_de_fin_de_liste(p_indicateur);
    p_zoneComIn.setKRENTP_IDENTIFIANT_BANALISE_PERIODE(p_identifiantCle);
  }
  
  private void initialisePensionVieillesse(YI70_IN p_zoneComIn, String p_indicateur, String p_identifiantCle)
  {
    p_zoneComIn.setNewZIEI10YI5V_COMPLT_Z__COM__YI75__Av__Vieillesse_();
    p_zoneComIn.getZIEI10YI5V_COMPLT_Z__COM__YI75__Av__Vieillesse_().setNewZIEI10YI5VET();
    p_zoneComIn.getZIEI10YI5V_COMPLT_Z__COM__YI75__Av__Vieillesse_().getZIEI10YI5VET().setFIN_LISTE_Indicateur_de_fin_de_liste(p_indicateur);
    p_zoneComIn.setKRENTR_IDENT__BANALISE_REENTRANCERANCE(p_identifiantCle);
  }
  
  private void initialiseDemandeDAL(YI70_IN p_zoneComIn, String p_indicateur, BigDecimal p_identifiantCle)
  {
    p_zoneComIn.setNewZIEI10YI57_COMPLT_Z__COM__YI77();
    p_zoneComIn.getZIEI10YI57_COMPLT_Z__COM__YI77().setNewZIEI10YI57ET();
    p_zoneComIn.getZIEI10YI57_COMPLT_Z__COM__YI77().getZIEI10YI57ET().setFIN_LISTE_Indicateur_de_fin_de_liste(p_indicateur);
    p_zoneComIn.setRSIA_IDENTIF__DEMANDE_ALLOCATION_EDITEE(p_identifiantCle);
  }
  
  private void initialiseDemandeRNV(YI70_IN p_zoneComIn, String p_indicateur, BigDecimal p_identifiantCle)
  {
    p_zoneComIn.setNewZIEI10YI67_COMPLT_Z__COM__YI74();
    p_zoneComIn.getZIEI10YI67_COMPLT_Z__COM__YI74().setNewZIEI10YI67ET();
    p_zoneComIn.getZIEI10YI67_COMPLT_Z__COM__YI74().getZIEI10YI67ET().setFIN_LISTE_Indicateur_de_fin_de_liste(p_indicateur);
    p_zoneComIn.setRSEQ_NUMERO_DOSSIER_DE_SUIVI(p_identifiantCle);
  }
  
  private void initialiseResultatRessourcesV1(YI70_IN p_zoneComIn, String p_indicateur, BigDecimal p_identifiantCleAnnee, BigDecimal p_identifiantCleMois)
  {
    p_zoneComIn.setNewZIEI10YI5L_COPIE_YI5K_POUR_YI70();
    p_zoneComIn.getZIEI10YI5L_COPIE_YI5K_POUR_YI70().setNewZIEI10YI5LET();
    p_zoneComIn.getZIEI10YI5L_COPIE_YI5K_POUR_YI70().getZIEI10YI5LET().setFIN_LISTE_Indicateur_de_fin_de_liste(p_indicateur);
    p_zoneComIn.setNSARS_ANNEE_DE_PERCEPTION_DES_RESSOURCES(p_identifiantCleAnnee);
    p_zoneComIn.setNSRRS_MOIS_DE_PERCEPTION_DES_RESSOURCES(p_identifiantCleMois);
  }
  
  private void formaterResultatPecV1(YI70_OUT p_zoneComeOut, StructureOutPecV1 p_structureOutPec)
  {
    ZOEI10YI55LT listePeriodesPec = ZOEI10YI55LT.getInstance();
    ZOEI10YI55LT listePeriodesPecCourante = p_zoneComeOut.getZOEI10YI55_COMPLT_Z__COM__YI85().getZOEI10YI55LT();
    
    int nbrPeriodes = FormateValeurSigma.formateBigDecimal(p_zoneComeOut.getZOEI10YI55_COMPLT_Z__COM__YI85().getZOEI10YI55ET().getNB_OCC_VAL_Nombre_occurences_d_une_liste()).intValue();
    for (int i = 0; i < nbrPeriodes; i++) {
      listePeriodesPec.addZOEI10YI55IT(listePeriodesPecCourante.getZOEI10YI55LT(i));
    }
    int endIndexNumeroSiren = 9;
    for (int j = 0; j < nbrPeriodes; j++)
    {
      YI55 periode = listePeriodesPecCourante.getZOEI10YI55LT(j).getYI55_COMPLT_Z__COM__YI85();
      BigDecimal periodeID = FormateValeurSigma.formateBigDecimal(periode.getRSPEC_IDENTIFIANT_DE_LA_PRISE_EN_CHARGE());
      Damj dateInscription;
      try
      {
        dateInscription = periode.getDSINDB_DATE_INSCRIPTION_PEC__format_db2_();
      }
      catch (IllegalArgumentException e)
      {
        dateInscription = null;
      }
      Damj dateAnnulation;
      try
      {
        dateAnnulation = periode.getDSANDB_DATE_ANNULATION_Pec__format_db2_();
      }
      catch (IllegalArgumentException e)
      {
        dateAnnulation = null;
      }
      String motif = FormateValeurSigma.formateString(periode.getCSMAN_MOTIF_D_ANNULATION_PRISE_EN_CHARGE());
      String categorie = FormateValeurSigma.formateString(periode.getCSCAT_CODE_CATEGORIE());
      String typePec = FormateValeurSigma.formateString(periode.getCSTPC_TYPE_DE_PRISE_EN_CHARGE()).trim();
      String sousTypePec = FormateValeurSigma.formateString(periode.getCSSPH_SOUS_TYPE_DE_PRISE_EN_CHARGE()).trim();
      String codeALE = FormateValeurSigma.formateString(periode.getRSALF_ALE_DE_L_INDIVIDU_DANS_PJC());
      String situationEmploi = FormateValeurSigma.formateString(periode.getCSEMP_SITUATION_AU_REGARD_DE_L_EMPLOI());
      String codeAuTitre = FormateValeurSigma.formateString(periode.getCSCDT_CODE_AU_TITRE_DE());
      String contexteEESSI = FormateValeurSigma.formateString(periode.getCCEES_Contexte_rEglement_europEen());
      String codePays = FormateValeurSigma.formateString(periode.getCSPEE_CODE_PAYS_DE_l_UNION_EUROPENNE());
      String contextePecNonIndemnisable = FormateValeurSigma.formateString(periode.getCCNIN_Code_Contexte_PEC_non_indemnisable());
      String numeroAffiliation = FormateValeurSigma.formateString(periode.getISAFE_NUMERO_AFFILIATION_EMPLOYEUR()).trim();
      String numeroSiren = FormateValeurSigma.formateString(periode.getCDSIR_CODE_SIREN()).trim();
      String identifiantBne = FormateValeurSigma.formateString(periode.getCXALAB_IDENTIFIANT_NATIONAL_INTERNE()).trim();
      
      PeriodePriseEnChargeOut pec = new PeriodePriseEnChargeOut();
      
      pec.setDateDebut(dateInscription);
      if (dateAnnulation == null) {
        pec.setDateFin(Damj.FIN_DES_TEMPS);
      } else {
        pec.setDateFin(dateAnnulation);
      }
      pec.setMotifAnnulation(motif);
      pec.setCategorie(categorie);
      pec.setIdentifiantPec(periodeID.intValue());
      pec.setAleIndividu(codeALE);
      if (typePec.equals("4")) {
        pec.setDispense(true);
      } else if ((typePec.equalsIgnoreCase("2")) && (sousTypePec.equalsIgnoreCase("5"))) {
        pec.setCes(true);
      }
      pec.setTypePec(typePec);
      pec.setSousTypePec(sousTypePec);
      
      String pecActualisable = FormateValeurSigma.formateString(periode.getCSPTD_TYPE_DE_PEREMPTION());
      if (pecActualisable.equals("A")) {
        pec.setActualisable(false);
      } else {
        pec.setActualisable(true);
      }
      pec.setSituationEmploi(situationEmploi);
      pec.setCodeAuTitre(codeAuTitre);
      
      pec.setContexteEESSI(contexteEESSI);
      pec.setCodePays(codePays);
      pec.setContextePECNonIndemnisable(contextePecNonIndemnisable);
      
      pec.setNumeroAffiliation(numeroAffiliation);
      if ((numeroSiren != null) && (StringUtils.isNotEmpty(numeroSiren))) {
        pec.setNumeroSiren(numeroSiren.substring(0, 9));
      }
      pec.setIdentifiantBne(identifiantBne);
      
      p_structureOutPec.ajouterPec(pec);
    }
  }
  
  private void formaterResultatPecFusioneesV1(YI70_OUT p_zoneComeOut, StructureOutPecV1 p_structureOutPec)
  {
    ZOEI10YI5ULT listePeriodesPec = ZOEI10YI5ULT.getInstance();
    ZOEI10YI5ULT listePeriodesPecFusionneesCourante = p_zoneComeOut.getZOEI10YI5U_COMPLT_Z__COM__YI85__PEC_FUSIONNEES_().getZOEI10YI5ULT();
    
    int nbrPeriodes = FormateValeurSigma.formateBigDecimal(p_zoneComeOut.getZOEI10YI5U_COMPLT_Z__COM__YI85__PEC_FUSIONNEES_().getZOEI10YI5UET().getNB_OCC_VAL_Nombre_occurences_d_une_liste()).intValue();
    for (int i = 0; i < nbrPeriodes; i++) {
      listePeriodesPec.addZOEI10YI5UIT(listePeriodesPecFusionneesCourante.getZOEI10YI5ULT(i));
    }
    for (int j = 0; j < nbrPeriodes; j++)
    {
      YI5U periode = listePeriodesPecFusionneesCourante.getZOEI10YI5ULT(j).getYI5U_COMPLT_Z__COM__YI85__PEC_FUSIONNEES_();
      BigDecimal periodeID = FormateValeurSigma.formateBigDecimal(periode.getRSPECU_IDENTIFIANT_DE_LA_PEC_FUSIONNEE());
      Damj dateInscription;
      try
      {
        dateInscription = periode.getDSINDF_DATE_INSCRIPTION_PEC_FUSIONNEE__DB2_();
      }
      catch (IllegalArgumentException e)
      {
        dateInscription = null;
      }
      Damj dateAnnulation;
      try
      {
        dateAnnulation = periode.getDSANDF_DATE_ANNULATION_PEC_FUSIONNE__DB2_();
      }
      catch (IllegalArgumentException e)
      {
        dateAnnulation = null;
      }
      String motif = FormateValeurSigma.formateString(periode.getCSMANF_MOTIF_D_ANNULATION_PEC_FUSIONNEE());
      String categorie = FormateValeurSigma.formateString(periode.getCSCATU_CODE_CATEGORIE_PEC_FUSIONNEE());
      String typePec = FormateValeurSigma.formateString(periode.getCSTPCF_TYPE_DE_PEC_FUSIONNEE()).trim();
      String sousTypePec = FormateValeurSigma.formateString(periode.getCSSPHF_SOUS_TYPE_DE_PEC_FUSIONNEE()).trim();
      String codeALE = FormateValeurSigma.formateString(periode.getRSALFF_ALE_DU_DE_DANS_PJC__PEC_FUSIONNEE_());
      String situationEmploi = FormateValeurSigma.formateString(periode.getCSEMPU_SITU_REGARD_EMPLOI__PEC_FUSIONNEE_());
      String codeAuTitre = FormateValeurSigma.formateString(periode.getCSCDTF_CODE_AU_TITRE_DE__PEC_FUSIONNEE_());
      String contexteEESSI = FormateValeurSigma.formateString(periode.getCCEESF_Contexte_rEglmnt_EUR__PEC_FUSIONNEE_());
      String codePays = FormateValeurSigma.formateString(periode.getCSPEEF_CODE_PAYS_DE_l_UE__PEC_FUSIONNEE_());
      String contextePecNonIndemnisable = FormateValeurSigma.formateString(periode.getCCNINF_Code_Contexte_PEC_FUSIONNEE_non_inde());
      Damj dateDispense = periode.getDEDIRF_DATE_ENTREE_DISPENSE__PEC_FUSIONNEE_();
      
      PeriodePriseEnChargeOut pec = new PeriodePriseEnChargeOut();
      
      pec.setDateDebut(dateInscription);
      if (dateAnnulation == null) {
        pec.setDateFin(Damj.FIN_DES_TEMPS);
      } else {
        pec.setDateFin(dateAnnulation);
      }
      pec.setMotifAnnulation(motif);
      pec.setCategorie(categorie);
      pec.setIdentifiantPec(periodeID.intValue());
      pec.setAleIndividu(codeALE);
      if (typePec.equals("4")) {
        pec.setDispense(true);
      } else if ((typePec.equalsIgnoreCase("2")) && (sousTypePec.equalsIgnoreCase("5"))) {
        pec.setCes(true);
      }
      pec.setDateDispense(dateDispense);
      pec.setTypePec(typePec);
      pec.setSousTypePec(sousTypePec);
      
      pec.setSituationEmploi(situationEmploi);
      pec.setCodeAuTitre(codeAuTitre);
      
      pec.setContexteEESSI(contexteEESSI);
      pec.setCodePays(codePays);
      pec.setContextePECNonIndemnisable(contextePecNonIndemnisable);
      
      p_structureOutPec.ajouterPecFusionnees(pec);
    }
  }
  
  private void formaterResultatAbsencePointage(YI70_OUT p_zoneComeOut, StructureOutBlocageActu p_structureOut)
    throws ContexteException
  {
    int occurences = FormateValeurSigma.formateBigDecimal(p_zoneComeOut.getZOEI10YI59_COMPLT_ZONE_COM_().getZOEI10YI59ET().getNB_OCC_VAL_Nombre_occurences_d_une_liste()).intValue();
    for (int j = 0; j < occurences; j++)
    {
      YI59 element = p_zoneComeOut.getZOEI10YI59_COMPLT_ZONE_COM_().getZOEI10YI59LT().getZOEI10YI59LT(j).getYI59_COMPLT_ZONE_COM_();
      BigDecimal annee = FormateValeurSigma.formateBigDecimal(element.getDSAAS1_SIECLE_ANNEE_D_IMPUTATION_ACT_RED());
      BigDecimal mois = FormateValeurSigma.formateBigDecimal(element.getDSMA2_MOIS_D_IMPUTATION_ACT_RED());
      if ((annee != null) && (annee.intValue() != 0) && (mois != null) && (mois.intValue() != 0))
      {
        Damj dateDebut = new Damj(annee.intValue(), mois.intValue(), 1);
        p_structureOut.getPeriodesNonPayables().add(new Periode(dateDebut, dateDebut.getFinMois()));
      }
    }
  }
  
  private void formaterResultatPresenceUL961(YI70_OUT p_zoneComOut, StructureOutBlocageActu p_structureOut)
    throws ContexteException
  {
    int occurences = FormateValeurSigma.formateBigDecimal(p_zoneComOut.getZOEI10YI5T_COMPL_ZONE_COM_YI79__PRESENCE_UL961_().getZOEI10YI5TET().getNB_OCC_VAL_Nombre_occurences_d_une_liste()).intValue();
    for (int j = 0; j < occurences; j++)
    {
      YI5T element = p_zoneComOut.getZOEI10YI5T_COMPL_ZONE_COM_YI79__PRESENCE_UL961_().getZOEI10YI5TLT().getZOEI10YI5TLT(j).getYI5T_COMPL_ZONE_COM_YI79__PRESENCE_UL961_();
      
      BigDecimal annee = FormateValeurSigma.formateBigDecimal(element.getDSAAS7_ANNEE_PRESENCE_RETOUR_UL961());
      BigDecimal mois = FormateValeurSigma.formateBigDecimal(element.getDSMA7_MOIS_PRESENCE_RETOUR_UL961());
      if ((annee != null) && (annee.intValue() != 0) && (mois != null) && (mois.intValue() != 0))
      {
        Damj dateDebut = new Damj(annee.intValue(), mois.intValue(), 1);
        p_structureOut.getPeriodesPresenceRetourUL961().add(new Periode(dateDebut, dateDebut.getFinMois()));
      }
    }
  }
  
  private void formaterResultatAbsenceUL961(YI70_OUT p_zoneComOut, StructureOutBlocageActu p_structureOut)
    throws ContexteException
  {
    int occurences = FormateValeurSigma.formateBigDecimal(p_zoneComOut.getZOEI10YI5W_COMPLT_ZONE_COM__YI79__UL961_().getZOEI10YI5WET().getNB_OCC_VAL_Nombre_occurences_d_une_liste()).intValue();
    for (int j = 0; j < occurences; j++)
    {
      YI5W element = p_zoneComOut.getZOEI10YI5W_COMPLT_ZONE_COM__YI79__UL961_().getZOEI10YI5WLT().getZOEI10YI5WLT(j).getYI5W_COMPLT_ZONE_COM__YI79__UL961_();
      
      BigDecimal annee = FormateValeurSigma.formateBigDecimal(element.getDSAAS3_SIECLE_ANNEE_D_IMPUTATION_UL961());
      BigDecimal mois = FormateValeurSigma.formateBigDecimal(element.getDSMA3_MOIS_D_IMPUTATION_UL961());
      if ((annee != null) && (annee.intValue() != 0) && (mois != null) && (mois.intValue() != 0))
      {
        Damj dateDebut = new Damj(annee.intValue(), mois.intValue(), 1);
        p_structureOut.getPeriodesAbsenceRetourUL961().add(new Periode(dateDebut, dateDebut.getFinMois()));
      }
    }
  }
  
  private void formaterResultatMoisMandates(YI70_OUT p_zoneComeOut, StructureOutBlocageActu p_structureOut)
    throws ContexteException
  {
    int occurences = FormateValeurSigma.formateBigDecimal(p_zoneComeOut.getZOEI10YI5X_COMPLT_ZONE_COM__YI79__MANDATEMENT_().getZOEI10YI5XET().getNB_OCC_VAL_Nombre_occurences_d_une_liste()).intValue();
    for (int j = 0; j < occurences; j++)
    {
      YI5X element = p_zoneComeOut.getZOEI10YI5X_COMPLT_ZONE_COM__YI79__MANDATEMENT_().getZOEI10YI5XLT().getZOEI10YI5XLT(j).getYI5X_COMPLT_ZONE_COM__YI79__MANDATEMENT_();
      
      int annee = FormateValeurSigma.formateBigDecimal(element.getDSAAS4_SIECLE_ANNEE_D_IMPUTATION_MANDATEMEN()).intValue();
      int mois = FormateValeurSigma.formateBigDecimal(element.getDSMA4_MOIS_D_IMPUTATION_MANDATEMENT()).intValue();
      String topMandatement = formateTopMandatement(element.getFSMPP_IND__PAIEMENT_PROVISOIRE_SUR_LE_MOIS());
      String topCoherenceTravailA8A10 = element.getFFCOH_TOP_COHERENCE_TRAVAIL_A8_A10();
      DonneesEvtActuSpec donneesMoisMandates = new DonneesEvtActu(annee, mois, topMandatement, topCoherenceTravailA8A10);
      p_structureOut.getDonneesMoisMandates().add(donneesMoisMandates);
    }
  }
  
  private StructureOutBlocageActuSpec formaterResultatAbsenceRetourAMS(YI70_OUT p_dr1Out, StructureOutBlocageActuSpec p_structureOut)
    throws ContexteException
  {
    int occurences = FormateValeurSigma.formateBigDecimal(p_dr1Out.getZOEI10YI5Y_COMPLT_ZONE_COM__YI79__ADR_2009_().getZOEI10YI5YET().getNB_OCC_VAL_Nombre_occurences_d_une_liste()).intValue();
    for (int j = 0; j < occurences; j++)
    {
      YI5Y element = p_dr1Out.getZOEI10YI5Y_COMPLT_ZONE_COM__YI79__ADR_2009_().getZOEI10YI5YLT().getZOEI10YI5YLT(j).getYI5Y_COMPLT_ZONE_COM__YI79__ADR_2009_();
      
      int annee = FormateValeurSigma.formateBigDecimal(element.getDSAAS5_SIECLE_ANNEE_RETOUR_AMS()).intValue();
      
      int mois = FormateValeurSigma.formateBigDecimal(element.getDSMA5_MOIS_RETOUR_AMS()).intValue();
      
      Damj dateDebut = new Damj(annee, mois, 1);
      p_structureOut.getPeriodesAbsenceRetourAMS().add(new Periode(dateDebut, dateDebut.getFinMois()));
    }
    return p_structureOut;
  }
  
  private String formateTopMandatement(String p_topMandatement)
  {
    String retValue = " ";
    if (("O".equalsIgnoreCase(p_topMandatement)) || ("R".equalsIgnoreCase(p_topMandatement))) {
      retValue = "P";
    } else if ("N".equalsIgnoreCase(p_topMandatement)) {
      retValue = "D";
    }
    return retValue;
  }
  
  private void formaterResultatIndividu(YI70_OUT p_zoneComOut, StructureOutIndividuV1 p_structOut)
  {
    String nom = FormateValeurSigma.formateString(p_zoneComOut.getLNIND1_NOM_PATRONYMIQUE());
    String marital = FormateValeurSigma.formateString(p_zoneComOut.getLNIND2_NOM_MARITAL());
    String prenom = FormateValeurSigma.formateString(p_zoneComOut.getLNPIN2_PRENOM_DE_L_INDIVIDU());
    String rsod = FormateValeurSigma.formateBigDecimalToString(p_zoneComOut.getRSOD8_REF_DERNIERE_OD_CREE());
    Damj dateNaissance = p_zoneComOut.getDDINDE_DATE_DE_NAISSANCE();
    
    Damj dateDeces = p_zoneComOut.getDEDAO7_DATE_DE_DECES_DE_L_ALLOCATAIRE();
    Damj dateLiquidationRetraite = p_zoneComOut.getDDREIG_DATE_LIQUIDATION_RETRAITE_DB2();
    Damj dateRetraiteAnticipe = p_zoneComOut.getDREANG_DATE_DE_RETRAITE_ANTICIPEE();
    String motifRetraiteAnticipe = p_zoneComOut.getCDREA_MOTIF_DE_LA_RETRAITE_ANTICIPEE();
    Damj dateAcquisitionTrimestres = p_zoneComOut.getDERRG_DATE_D_ACQUISITION_TRIMESTRES();
    Damj dateLimiteIndemnisation = p_zoneComOut.getDFLIMG_DATE_LIMITE_D_INDEMNISATION_DB2();
    
    Damj dateCentTrimestres = p_zoneComOut.getDERR3G_DATE_EFFET_DES_100_TRIMESTRES__DB2_();
    
    BigDecimal nombreTrimestres = FormateValeurSigma.formateBigDecimal(p_zoneComOut.getPSTRR_NOMBRE_DE_TRIMESTRES_VALIDES_CNAV());
    
    String etatCivil = FormateValeurSigma.formateString(p_zoneComOut.getCSCIV_TITRE_DE_CIVILITE()).trim();
    
    String stringIndividuMigre = FormateValeurSigma.formateString(p_zoneComOut.getFBMIG_INDICATEUR_DE_LIQUIDE_DANS_NCP()).trim();
    boolean boolIndividuMigre;
    boolean boolIndividuMigre;
    if ((stringIndividuMigre.equalsIgnoreCase("M")) || (stringIndividuMigre.equalsIgnoreCase("P")) || (stringIndividuMigre.equalsIgnoreCase("V"))) {
      boolIndividuMigre = true;
    } else {
      boolIndividuMigre = false;
    }
    String stringAcompteSolde = FormateValeurSigma.formateString(p_zoneComOut.getFFACS_TOP_ACOMPTE_SOLDE()).trim();
    
    boolean boolAcompteNonSolde = !stringAcompteSolde.equalsIgnoreCase("O");
    
    String stringBeneficiaireSapa = FormateValeurSigma.formateString(p_zoneComOut.getFFSAPA_TOP_BENEFICIAIRE_SA_PA()).trim();
    boolean boolBeneficiaireSapa;
    boolean boolBeneficiaireSapa;
    if (stringBeneficiaireSapa.equalsIgnoreCase("O")) {
      boolBeneficiaireSapa = true;
    } else {
      boolBeneficiaireSapa = false;
    }
    String stringBeneficiaireRSA = FormateValeurSigma.formateString(p_zoneComOut.getFIRSA1_TOP_BENEFICIAIRE_RSA()).trim();
    boolean boolBeneficiaireRSA;
    boolean boolBeneficiaireRSA;
    if (stringBeneficiaireRSA.equalsIgnoreCase("O")) {
      boolBeneficiaireRSA = true;
    } else {
      boolBeneficiaireRSA = false;
    }
    String stringExclusionIndividuelle = FormateValeurSigma.formateString(p_zoneComOut.getFSEPP_IND__EXCLUSION_PAIEMENT_PROVISOIRE()).trim();
    boolean boolExclusionIndividuelle;
    boolean boolExclusionIndividuelle;
    if ((stringExclusionIndividuelle.equalsIgnoreCase("O")) || (stringExclusionIndividuelle.equalsIgnoreCase("R")) || (stringExclusionIndividuelle.equalsIgnoreCase("S"))) {
      boolExclusionIndividuelle = true;
    } else {
      boolExclusionIndividuelle = false;
    }
    Damj dernierJourAtteste = p_zoneComOut.getDFATTG_DATE_DERNIER_JOUR_ACTUALISE_GREG();
    
    Damj dateDeCalculAuPlusTot = p_zoneComOut.getDDORKC_DATE_DE_CALCUL_AU_PLUS_TOT_NCP();
    
    String codeAntenne = FormateValeurSigma.formateString(p_zoneComOut.getCSANA_ANTENNE_DE_L_INDIVIDU().trim());
    
    BigDecimal codeEtat = FormateValeurSigma.formateBigDecimal(p_zoneComOut.getCSETF1_CODE_ETAT_TRANSFERT());
    
    Damj datePeremptionTitreSejour = p_zoneComOut.getDFSEJB_DATE_PEREMPTION_TITRE_SEJOUR();
    
    p_structOut.setNom(nom);
    p_structOut.setNomMarital(marital);
    p_structOut.setPrenom(prenom);
    p_structOut.setDateNaissance(dateNaissance);
    p_structOut.setDateDeces(dateDeces);
    p_structOut.setDateLiquidationRetraite(dateLiquidationRetraite);
    p_structOut.setDateRetraiteAnticipe(dateRetraiteAnticipe);
    p_structOut.setMotifRetraiteAnticipe(motifRetraiteAnticipe);
    p_structOut.setNombreTrimestre(nombreTrimestres.intValue());
    p_structOut.setDateAcquisitionTrimestres(dateAcquisitionTrimestres);
    p_structOut.setEtatCivil(etatCivil);
    p_structOut.setBeneficiaireSapa(boolBeneficiaireSapa);
    p_structOut.setBeneficiaireRsa(boolBeneficiaireRSA);
    p_structOut.setAcompteNonSolde(boolAcompteNonSolde);
    p_structOut.setExclusionIndividuelle(boolExclusionIndividuelle);
    p_structOut.setIndividuMigre(boolIndividuMigre);
    p_structOut.setDernierJourAtteste(dernierJourAtteste);
    p_structOut.setEtatMigration(stringIndividuMigre);
    p_structOut.setDateCentTrimestres(dateCentTrimestres);
    p_structOut.setDateLimiteIndemnisation(dateLimiteIndemnisation);
    p_structOut.setCodeAntenne(codeAntenne);
    p_structOut.setRsodDernierAdmission(rsod);
    p_structOut.setCodeEtatTransfert(codeEtat.intValue());
    p_structOut.setDateCalculAuPlusTot(dateDeCalculAuPlusTot);
    
    p_structOut.setDatePeremptionTitreSejour(datePeremptionTitreSejour);
    
    p_structOut.setReferenceExterne(FormateValeurSigma.formateString(p_zoneComOut.getREFEXT_REFERENCE_EXTERNE_DE_LA_DEMANDE()).trim());
    
    p_structOut.setDjams(dernierJourAtteste);
    
    p_structOut.setEstAlerteAD(FormateValeurSigma.formateString(p_zoneComOut.getFSALAD_Indicateur_alerte_AD()).equals("O"));
  }
  
  private void formaterResultatDetectionSuivi(YI70_OUT p_zoneComOut, StructureOutDecisionSuivi p_structureOut)
    throws ContexteException
  {
    ZOEI10YI54LT listeDecisions = ZOEI10YI54LT.getInstance();
    
    ZOEI10YI54LT listeDecisionsCourante = p_zoneComOut.getZOEI10YI54_COMPLT_Z__COM__YI73().getZOEI10YI54LT();
    int nbrDecisions = FormateValeurSigma.formateBigDecimal(p_zoneComOut.getZOEI10YI54_COMPLT_Z__COM__YI73().getZOEI10YI54ET().getNB_OCC_VAL_Nombre_occurences_d_une_liste()).intValue();
    for (int i = 0; i < nbrDecisions; i++) {
      listeDecisions.addZOEI10YI54IT(listeDecisionsCourante.getZOEI10YI54LT(i));
    }
    int nbrTotalDecisions = listeDecisions.getNbZOEI10YI54LT();
    for (int j = 0; j < nbrTotalDecisions; j++)
    {
      YI54 decision = listeDecisions.getZOEI10YI54LT(j).getYI54_COMPLT_Z__COM__YI73();
      
      String natureDecision = FormateValeurSigma.formateString(decision.getCSND7_NATURE_DE_DECISION_DE_SUIVI());
      String natureSuspension = FormateValeurSigma.formateString(decision.getCSISU1_NATURE_DE_LA_SUSPENSION());
      String idDroit = FormateValeurSigma.formateBigDecimal(decision.getRSOD_IDENTIFIANT_DE_L_OUVERTURE_DE_DROIT()).toString();
      Damj dateEffet;
      try
      {
        dateEffet = decision.getDEDO2_DATE_D_EFFET_DE_LA_DECISION_DE_SUIVI();
      }
      catch (IllegalArgumentException e)
      {
        dateEffet = null;
      }
      Damj dateFin;
      try
      {
        dateFin = decision.getDFDO2_DATE_DE_FIN__DE_LA_DECISION_DE_SUIVI();
      }
      catch (IllegalArgumentException e)
      {
        dateFin = null;
      }
      BigDecimal dureeDecision = FormateValeurSigma.formateBigDecimal(decision.getPJJPR1_NOMBRE_DE_JOURS_DE_LA_DECISION());
      BigDecimal rangProlongation = FormateValeurSigma.formateBigDecimal(decision.getNSOPR1_RANG_DE_LA_PROLONGATION());
      
      boolean chevauchementSanction = false;
      String chevauchementSanctionSigma = FormateValeurSigma.formateString(decision.getFSCHEV_INDICATEUR_DE_CHEVAUCHEMENT_LE1O());
      if (chevauchementSanctionSigma.equals("C")) {
        chevauchementSanction = true;
      }
      DecisionSuiviSpec decisionSuivi = new DecisionSuivi();
      
      decisionSuivi.setDateEffet(dateEffet);
      decisionSuivi.setDateFin(dateFin);
      decisionSuivi.setDureeDecision(dureeDecision.intValue());
      decisionSuivi.setIdentifiantOuvertureDroit(idDroit);
      decisionSuivi.setNatureDecision(natureDecision);
      decisionSuivi.setNatureSuspension(natureSuspension);
      decisionSuivi.setRangProlongation(rangProlongation.intValue());
      decisionSuivi.setChevauchementSanction(chevauchementSanction);
      
      p_structureOut.ajouterDecision(decisionSuivi);
    }
  }
  
  private void formaterResultatPension(YI70_OUT p_zoneComOut, Pension p_structureOut)
  {
    int nbOccurencesPensionInv = 0;
    nbOccurencesPensionInv = FormateValeurSigma.formateBigDecimal(p_zoneComOut.getZOEI10YI5I_COMPLT_Z__COM__YI75__pensions_().getZOEI10YI5IET().getNB_OCC_VAL_Nombre_occurences_d_une_liste()).intValue();
    
    int nbOccurencesAvVieillesse = 0;
    nbOccurencesAvVieillesse = FormateValeurSigma.formateBigDecimal(p_zoneComOut.getZOEI10YI5V_COMPLT_Z__COM__YI75__Av__Vieillesse_().getZOEI10YI5VET().getNB_OCC_VAL_Nombre_occurences_d_une_liste()).intValue();
    
    String naturePeriodePensionInvEnCours = null;
    Damj dateDebutPeriodePensionInvEnCours = null;
    PensionInvalidite pensionInv = null;
    for (int i = 0; i < nbOccurencesPensionInv; i++)
    {
      YI5I element = p_zoneComOut.getZOEI10YI5I_COMPLT_Z__COM__YI75__pensions_().getZOEI10YI5ILT().getZOEI10YI5ILT(i).getYI5I_COMPLT_Z__COM__YI75__pensions_();
      
      pensionInv = new PensionInvalidite();
      try
      {
        naturePeriodePensionInvEnCours = FormateValeurSigma.formateString(element.getCSNLC_NATURE_PERIODE_LIQUIDATION());
        pensionInv.setCodeNature(FormateValeurSigma.formateString(element.getCSNLC_NATURE_PERIODE_LIQUIDATION()));
      }
      catch (IllegalArgumentException e)
      {
        naturePeriodePensionInvEnCours = null;
        pensionInv.setCodeNature(null);
      }
      try
      {
        dateDebutPeriodePensionInvEnCours = element.getDDPE1G_DATE_DEBUT_PERIODE_DB2();
        pensionInv.setDateDebut(element.getDDPE1G_DATE_DEBUT_PERIODE_DB2());
      }
      catch (IllegalArgumentException e)
      {
        dateDebutPeriodePensionInvEnCours = null;
        pensionInv.setDateDebut(null);
      }
      try
      {
        pensionInv.setDateFin(element.getDFPE1G_Date_Fin_de_PEriode_grEgorien());
      }
      catch (IllegalArgumentException e)
      {
        pensionInv.setDateFin(null);
      }
      try
      {
        pensionInv.setLibelleNature(FormateValeurSigma.formateString(element.getLSLPE_LIBELLE_NATURE_PERIODE()));
      }
      catch (IllegalArgumentException e1)
      {
        pensionInv.setLibelleNature(null);
      }
      try
      {
        pensionInv.setOrganismeFinanceur(FormateValeurSigma.formateString(element.getLNFIN_LIBELLE_ORGANISME_FINANCEUR_PI()));
      }
      catch (IllegalArgumentException e)
      {
        pensionInv.setOrganismeFinanceur(null);
      }
      try
      {
        pensionInv.setEtat(FormateValeurSigma.formateString(element.getCSEPI_INDICATEUR_ETAT_PI()));
      }
      catch (IllegalArgumentException e)
      {
        pensionInv.setEtat(null);
      }
      try
      {
        if (element.getQMPIB_MONTANT_DE_LA_PENSION_D_INVALIDITE() == null) {
          pensionInv.setQuantiteEuro(null);
        } else {
          pensionInv.setQuantiteEuro(new QuantiteEuro(element.getQMPIB_MONTANT_DE_LA_PENSION_D_INVALIDITE()));
        }
      }
      catch (IllegalArgumentException e2)
      {
        pensionInv.setQuantiteEuro(null);
      }
      p_structureOut.ajouterPensionInvalidite(pensionInv);
    }
    AvantageVieillesse avVieillesse = null;
    for (int i = 0; i < nbOccurencesAvVieillesse; i++)
    {
      YI5V element = p_zoneComOut.getZOEI10YI5V_COMPLT_Z__COM__YI75__Av__Vieillesse_().getZOEI10YI5VLT().getZOEI10YI5VLT(i).getYI5V_COMPLT_Z__COM__YI75__Av__Vieillesse_();
      
      avVieillesse = new AvantageVieillesse();
      try
      {
        avVieillesse.setCodeNature(FormateValeurSigma.formateString(element.getCSQAV_QUALIFICATION_AVANTAGE_VIEILLESSE()));
      }
      catch (IllegalArgumentException e)
      {
        avVieillesse.setCodeNature(null);
      }
      try
      {
        avVieillesse.setDateDebut(element.getDEVAVG_DATE_D_EFFET_AVTG_VIEILLESSE__DB2_());
      }
      catch (IllegalArgumentException e)
      {
        avVieillesse.setDateDebut(null);
      }
      try
      {
        avVieillesse.setDateFin(element.getDFAVG_DATE_FIN_AVANTAGE_VIEILLESSE_db2_());
      }
      catch (IllegalArgumentException e)
      {
        avVieillesse.setDateFin(null);
      }
      try
      {
        avVieillesse.setMontant(element.getQMAV_MONTANT_DE_L_AVANTAGE_VIEILLESSE());
      }
      catch (IllegalArgumentException e1)
      {
        avVieillesse.setMontant(null);
      }
      p_structureOut.ajouterAvantageVieillesse(avVieillesse);
    }
  }
  
  private void formaterResultatDemandeDAL(YI70_OUT p_zoneComOut, StructureOutDemandeV1 p_structureOut)
  {
    ZOEI10YI57 zoneDonneesDemandeDALOut = p_zoneComOut.getZOEI10YI57_COMPLT_Z__COM__YI77();
    
    ZOEI10YI57LT listeDemandesDAL = ZOEI10YI57LT.getInstance();
    
    int nbrDemandes = FormateValeurSigma.formateBigDecimal(zoneDonneesDemandeDALOut.getZOEI10YI57ET().getNB_OCC_VAL_Nombre_occurences_d_une_liste()).intValue();
    for (int i = 0; i < nbrDemandes; i++)
    {
      listeDemandesDAL.addZOEI10YI57IT(zoneDonneesDemandeDALOut.getZOEI10YI57LT().getZOEI10YI57LT(i));
      YI57 demande = listeDemandesDAL.getZOEI10YI57LT(i).getYI57_COMPLT_Z__COM__YI77();
      
      DemandeV1Spec demandeV1 = null;
      demandeV1 = formateDemandeDAL(demandeV1, demande);
      
      p_structureOut.ajouterDemande(demandeV1);
    }
  }
  
  private void formaterResultatDemandeRNV(YI70_OUT p_zoneComOut, StructureOutDemandeV1 p_structureOut)
  {
    ZOEI10YI67 zoneDonneesDemandeRNVOut = p_zoneComOut.getZOEI10YI67_COMPLT_Z__COM__YI74();
    
    ZOEI10YI67LT listeDemandesRNV = ZOEI10YI67LT.getInstance();
    
    int nbrDemandes = FormateValeurSigma.formateBigDecimal(zoneDonneesDemandeRNVOut.getZOEI10YI67ET().getNB_OCC_VAL_Nombre_occurences_d_une_liste()).intValue();
    for (int i = 0; i < nbrDemandes; i++)
    {
      listeDemandesRNV.addZOEI10YI67IT(zoneDonneesDemandeRNVOut.getZOEI10YI67LT().getZOEI10YI67LT(i));
      YI67 demande = listeDemandesRNV.getZOEI10YI67LT(i).getYI67_COMPLT_Z__COM__YI74();
      
      DemandeV1Spec demandeV1 = null;
      demandeV1 = formateDemandeRNV(demandeV1, demande);
      
      p_structureOut.ajouterDemande(demandeV1);
    }
  }
  
  private DemandeV1Spec formateDemandeDAL(DemandeV1Spec p_source, YI57 p_demande)
  {
    if (p_source == null) {
      p_source = new DemandeV1();
    }
    p_source.setGamme(FormateValeurSigma.formateString(p_demande.getCDGAM_GAMME_DE_PRODUIT_NCP()));
    p_source.setLigne(FormateValeurSigma.formateString(p_demande.getCDLIS_LIGNE_DE_PRODUIT_NCP()));
    p_source.setProduit(FormateValeurSigma.formateString(p_demande.getCPROD_CODE_PRODUIT()));
    p_source.setTypeExamen(FormateValeurSigma.formateString(p_demande.getCDEXA1_TYPE_D_EXAMEN()));
    try
    {
      p_source.setDateDepot(p_demande.getDEPOTG_DATE_DE_DEPOT_DE_LA_DAL_DB2());
    }
    catch (IllegalArgumentException e)
    {
      p_source.setDateDepot(null);
    }
    try
    {
      p_source.setDateDemande(p_demande.getDSEXAG_DATE_EXAMEN_CONDITIONS_O_D__DB2());
    }
    catch (IllegalArgumentException e)
    {
      p_source.setDateDemande(null);
    }
    try
    {
      p_source.setIdentifiantPec(FormateValeurSigma.formateBigDecimal(p_demande.getRSPEC2_IDENTIFIANT_DERNIERE_P_E_C_()).intValue());
    }
    catch (NumberFormatException e)
    {
      p_source.setIdentifiantPec(0);
    }
    try
    {
      p_source.setIdentifiantFormation(FormateValeurSigma.formateBigDecimal(p_demande.getRSF33_IDENTIFIANT_DU_PLAN_DE_FORMATION()).intValue());
    }
    catch (NumberFormatException e)
    {
      p_source.setIdentifiantFormation(0);
    }
    try
    {
      p_source.setReferenceRejetDV(FormateValeurSigma.formateBigDecimal(p_demande.getRSIA2_REFERENCE_DEMANDE_ALLOCATION_SUIVIE()).intValue());
    }
    catch (NumberFormatException e)
    {
      p_source.setReferenceRejetDV(0);
    }
    p_source.setReferenceExterne(FormateValeurSigma.formateString(p_demande.getREFEX_REFERENCE_EXTERNE_DE_LA_DEMANDE()));
    p_source.setEtatLiquidable(FormateValeurSigma.formateString(p_demande.getCDDAL_CODE_ETAT_DEMANDE_LIQUIDABLE()));
    p_source.setPresenceAE(FormateValeurSigma.formateString(p_demande.getFSPAE_INDICATEUR_PRESENCE_ATTEST_EMPLOYEUR()));
    
    p_source.setRefusFNE(FormateValeurSigma.formateString(p_demande.getFSFNE_REFUS_D_ADHESION_A_CONVENTION_FNE()));
    p_source.setPropositionCrpCtp(FormateValeurSigma.formateStringNonVide(p_demande.getFSANT_PROPOSITION_PARE_ANTICIPE(), "N"));
    
    p_source.setDroitCongeReclassement(FormateValeurSigma.formateString(p_demande.getFSCRS_DE_CONCERNE_PAR_CONGE_RECLASSEMENT()).equals("O"));
    try
    {
      p_source.setNumeroSuivi(FormateValeurSigma.formateString(p_demande.getRSEQ22_NUMERO_DOSSIER_DE_SUIVI().toString()));
    }
    catch (Exception e)
    {
      p_source.setNumeroSuivi("");
    }
    p_source.setEstEnvoiDalEffectue(FormateValeurSigma.formateString(p_demande.getFSDAL_ENVOI_DAL_EFFECTUE()).equals("O"));
    
    p_source.setDeploiementDalInstruction(FormateValeurSigma.formateString(p_demande.getFSLCD_TOP_LIEN_COMPLETUDE_DAL()));
    return p_source;
  }
  
  private DemandeV1Spec formateDemandeRNV(DemandeV1Spec p_source, YI67 p_demande)
  {
    if (p_source == null) {
      p_source = new DemandeV1();
    }
    p_source.setGamme(FormateValeurSigma.formateString(p_demande.getCDGAM2_GAMME_DE_PRODUIT_NCP()));
    p_source.setLigne(FormateValeurSigma.formateString(p_demande.getCDLIS2_LIGNE_DE_PRODUIT_NCP()));
    p_source.setProduit(FormateValeurSigma.formateString(p_demande.getCPROD2_CODE_PRODUIT()));
    p_source.setTypeExamen(FormateValeurSigma.formateString(p_demande.getCDEXA2_TYPE_D_EXAMEN()));
    try
    {
      p_source.setDateDepot(p_demande.getDEPOT2_DATE_DE_DEPOT_DE_LA_DAL_DB2());
    }
    catch (IllegalArgumentException e)
    {
      p_source.setDateDepot(null);
    }
    try
    {
      p_source.setDateDemande(p_demande.getDSEXA2_DATE_EXAMEN_CONDITIONS_O_D__DB2());
    }
    catch (IllegalArgumentException e)
    {
      p_source.setDateDemande(null);
    }
    try
    {
      p_source.setIdentifiantPec(FormateValeurSigma.formateBigDecimal(p_demande.getRSPEC9_IDENTIFIANT_DERNIERE_P_E_C_()).intValue());
    }
    catch (NumberFormatException e)
    {
      p_source.setIdentifiantPec(0);
    }
    try
    {
      p_source.setIdentifiantFormation(FormateValeurSigma.formateBigDecimal(p_demande.getRSF32_IDENTIFIANT_DU_PLAN_DE_FORMATION()).intValue());
    }
    catch (NumberFormatException e)
    {
      p_source.setIdentifiantFormation(0);
    }
    p_source.setReferenceExterne(FormateValeurSigma.formateString(p_demande.getREFEX2_REFERENCE_EXTERNE_DE_LA_DEMANDE()));
    p_source.setEtatLiquidable(FormateValeurSigma.formateString(p_demande.getCDDAL2_CODE_ETAT_DEMANDE_LIQUIDABLE()));
    p_source.setPresenceAE(FormateValeurSigma.formateString(p_demande.getFSPAE2_INDICATEUR_PRESENCE_ATTEST_EMPLOYEUR()));
    
    p_source.setRefusFNE(FormateValeurSigma.formateString(p_demande.getFSFNE2_REFUS_D_ADHESION_A_CONVENTION_FNE()));
    p_source.setPropositionCrpCtp(FormateValeurSigma.formateStringNonVide(p_demande.getFSANT2_PROPOSITION_PARE_ANTICIPE(), "N"));
    
    p_source.setDroitCongeReclassement(FormateValeurSigma.formateString(p_demande.getFSCRS2_DE_CONCERNE_PAR_CONGE_RECLASSEMENT()).equals("O"));
    try
    {
      p_source.setNumeroSuivi(FormateValeurSigma.formateString(p_demande.getRSEQ23_NUMERO_DOSSIER_DE_SUIVI_RENOUV_().toString()));
    }
    catch (Exception e)
    {
      p_source.setNumeroSuivi("");
    }
    p_source.setEstDemandeMandatee(FormateValeurSigma.formateStringToBoolean(p_demande.getFFMAN2_TOP_MANDATEMENT_DEMANDE_EFFECTUE()));
    
    p_source.setIdentifiantTiersDemandeur(FormateValeurSigma.formateString(p_demande.getRSTICE_TIERS_DEMANDEUR()));
    p_source.setIdentifiantTiersBeneficiaire(FormateValeurSigma.formateString(p_demande.getRSTICQ_TIERS_CONCERNE_PAR_LA_DEMANDE()));
    
    return p_source;
  }
  
  private void formaterResultatRessourcesV1(YI70_OUT p_zoneComOut, StructureOutListeRessourcesV1 p_structureOut)
    throws ContexteException
  {
    ZOEI10YI5LLT listeRessources = ZOEI10YI5LLT.getInstance();
    
    ZOEI10YI5LLT listeRessourcesCourante = p_zoneComOut.getZOEI10YI5L_COPIE_YI5K_POUR_YI70().getZOEI10YI5LLT();
    int nbrRessources = FormateValeurSigma.formateBigDecimal(p_zoneComOut.getZOEI10YI5L_COPIE_YI5K_POUR_YI70().getZOEI10YI5LET().getNB_OCC_VAL_Nombre_occurences_d_une_liste()).intValue();
    for (int i = 0; i < nbrRessources; i++) {
      listeRessources.addZOEI10YI5LIT(listeRessourcesCourante.getZOEI10YI5LLT(i));
    }
    int nbrTotalRessources = listeRessources.getNbZOEI10YI5LLT();
    for (int j = 0; j < nbrTotalRessources; j++)
    {
      YI5L ressourceV1 = listeRessources.getZOEI10YI5LLT(j).getYI5L_COPIE_YI5K_POUR_YI70();
      
      String referenceExterne = FormateValeurSigma.formateString(ressourceV1.getREFEX1_REFERENCE_EXTERNE_DE_LA_DEMANDE());
      String codeCertification = FormateValeurSigma.formateString(ressourceV1.getCSCTF_CODE_DE_CERTIFICATION_PERIODE());
      String codeSituationFamiliale = FormateValeurSigma.formateString(ressourceV1.getCSMSF4_SITUATION_FAMILIALE());
      String origine = FormateValeurSigma.formateString(ressourceV1.getCSOREC_ORIGINE_DES_RESSOURCES());
      Damj dateEffet;
      try
      {
        dateEffet = ressourceV1.getDERES1_DATE_D_EFFET_DE_LA_RESSOURCE_DB2();
      }
      catch (IllegalArgumentException e)
      {
        dateEffet = null;
      }
      Damj dateReference = new Damj(FormateValeurSigma.formateBigDecimal(ressourceV1.getNSARSA_ANNEE_DE_PERCEPTION_DES_RESSOURCES()).intValue(), FormateValeurSigma.formateBigDecimal(ressourceV1.getNSRRSA_MOIS_DE_PERCEPTION_DES_RESSOURCES()).intValue(), 1);
      
      int rang = FormateValeurSigma.formateBigDecimal(ressourceV1.getNSOPRL_SAUVEGARDE_RANG_DUREES_ARI_DJC_()).intValue();
      
      QuantiteEuro montant = new QuantiteEuro(FormateValeurSigma.formateBigDecimal(ressourceV1.getQMRS4_MONTANT_RESSOURCE_MENSUEL()));
      QuantiteEuro ressourcesAllocataire = new QuantiteEuro(FormateValeurSigma.formateBigDecimal(ressourceV1.getQMRSF_RESSOURCES_ALLOCATAIRE_AER_ANNUELLES()));
      
      QuantiteEuro ressourcesConjoint = new QuantiteEuro(FormateValeurSigma.formateBigDecimal(ressourceV1.getQMRSG_RESSOURCES_CONJOINT_AER_ANNUELLES()));
      
      int nombreEnfant = FormateValeurSigma.formateBigDecimal(ressourceV1.getQSDSF2_NB_D_ENFANTS_A_L_EXAMEN_RESSOURCES()).intValue();
      
      RessourceSpec ressource = new Ressource();
      
      ressource.setReferenceExterne(referenceExterne);
      ressource.setCodeCertification(codeCertification);
      ressource.setCodeSituationFamiliale(codeSituationFamiliale);
      ressource.setOrigine(origine);
      ressource.setDateEffet(dateEffet);
      ressource.setDateReference(dateReference);
      ressource.setRang(rang);
      ressource.setMontant(montant);
      ressource.setRessourcesAllocataire(ressourcesAllocataire);
      ressource.setRessourcesConjoint(ressourcesConjoint);
      ressource.setNombreEnfant(nombreEnfant);
      
      p_structureOut.ajouterRessource(ressource);
    }
  }
  
  private void formaterResultatPeriodeAAH(YI70_OUT zoneComOut, StructureOutListePeriodeAAH structureListePeriodeAAH)
  {
    ZOEI10YI5NLT listePeriodesAAH = ZOEI10YI5NLT.getInstance();
    if (zoneComOut.getZOEI10YI5N_COMPLT_Z__COM__YI5M().getZOEI10YI5NLT() != null)
    {
      ZOEI10YI5NLT listePeriodeAAHCourante = zoneComOut.getZOEI10YI5N_COMPLT_Z__COM__YI5M().getZOEI10YI5NLT();
      
      int nbrRessources = zoneComOut.getZOEI10YI5N_COMPLT_Z__COM__YI5M().getZOEI10YI5NLT().getNbListZOEI10YI5NIT();
      for (int i = 0; i < nbrRessources; i++) {
        listePeriodesAAH.addZOEI10YI5NIT(listePeriodeAAHCourante.getZOEI10YI5NLT(i));
      }
      int nbrTotalRessources = listePeriodesAAH.getNbZOEI10YI5NLT();
      for (int j = 0; j < nbrTotalRessources; j++)
      {
        YI5N periodeAAH = listePeriodesAAH.getZOEI10YI5NLT(j).getYI5N_COMPLT_Z__COM__YI5M();
        
        String typedebut = FormateValeurSigma.formateString(periodeAAH.getCKAAHD_CODE_EVENEMENT_de_type_ouverture());
        String typefin = FormateValeurSigma.formateString(periodeAAH.getCKAAHF_CODE_EVENEMENT_de_type_fermeture());
        Damj datedebut = periodeAAH.getDDAAHG_DATE_DE_DEBUT_DE_PERIODE_AAH();
        Damj datefin;
        Damj datefin;
        if ((periodeAAH.getDFAAHG_DATE_DE_FIN_DE_PERIODE_AAH().estApresOuCoincideAvec(Damj.FIN_DES_TEMPS)) || (periodeAAH.getDFAAHG_DATE_DE_FIN_DE_PERIODE_AAH() == null)) {
          datefin = Damj.FIN_DES_TEMPS;
        } else {
          datefin = periodeAAH.getDFAAHG_DATE_DE_FIN_DE_PERIODE_AAH();
        }
        Periode periode1 = new Periode(datedebut, datefin);
        
        PeriodeDroitAAH periodeDroitAAH = new PeriodeDroitAAH(periode1, typedebut, typefin);
        
        structureListePeriodeAAH.ajouterPeriodeAAH(periodeDroitAAH);
      }
    }
    else
    {
      Periode periode1 = new Periode(Damj.FIN_DES_TEMPS, Damj.FIN_DES_TEMPS);
      
      PeriodeDroitAAH periodeDroitAAH = new PeriodeDroitAAH(periode1, "", "");
      structureListePeriodeAAH.ajouterPeriodeAAH(periodeDroitAAH);
    }
  }
  
  public ZOEI10YI70 appelServiceDr1(ZIEI10YI70 donneesIn)
    throws TechniqueException, ApplicativeException
  {
    ManagerAppelsServicesDR1 managerService = new ManagerAppelsServicesDR1();
    return managerService.FEI10O_SERVICE_SYNCHRONE_CALI(donneesIn);
  }
}

/* Location:
 * Qualified Name:     AppelV1Cali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */