package fr.unedic.cali.dom.pivot;

import fr.unedic.cali.autresdoms.d90.dom.EcartBasePivotEchange;
import fr.unedic.cali.autresdoms.d90.dom.spec.ElementBasePivotEchangeComparableSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComparaison;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pivot.gen.AttributionGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import xcalia.lido.api.LiDOHelper;

public class Attribution
  extends AttributionGen
  implements ObjetPersistantSpec, ElementBasePivotEchangeComparableSpec
{
  private static final long serialVersionUID = -2569916418571162567L;
  public static final String VALIDE = "V";
  public static final String ENREGISTRE_NON_VALIDE = "E";
  public static final Map<String, String> LIB_CODE_VALIDATION = new HashMap();
  public static final String A_REEXAMINER = "R";
  public static final String PAS_DE_REEXAMEN = "";
  public static final Map<String, String> LIB_CODE_REEXAMEN;
  public static final String REGIME_PARTICULIER_SANS = "";
  public static final String REGIME_PARTICULIER_CA = "A";
  public static final String REGIME_PARTICULIER_CAE = "E";
  public static final Map<String, String> LIB_REGIME_PARTICULIER;
  public static final String CHOM_SAISONNIER_SSOBJET = " ";
  public static final String CHOM_SAISONNIER_RYTHME_ACT = "1";
  public static final String CHOM_SAISONNIER_NATURE_ACT = "2";
  public static final Map<String, String> LIB_CHOM_SAISONNIER;
  protected transient Date tspElementPourEcartsBase = null;
  public static final String OD_EXPORTATION_CEE = "O";
  public static final String COMPL_REG_SS_ALSACE_MOSELLE = "A";
  public static final String ORIGINE_FORCE = "A";
  public static final String ORIGINE_AUTOMATIQUE = " ";
  public static final Map<String, String> LIB_ORIGINE;
  public static final String OUI = "O";
  public static final String NON = "N";
  public static final Map<String, String> LIB_OUI_NON;
  public static final String ORIGINE_DECISION_ASSEDIC = "AS";
  public static final String ORIGINE_DECISION_AUTRE_ASSEDIC = "AA";
  public static final String ORIGINE_DECISION_DDTE = "DT";
  public static final String ORIGINE_DECISION_DELEGATAIRE = "DL";
  public static final String ORIGINE_DECISION_MIGRATION = "MI";
  public static final String ORIGINE_DECISION_REPRISE_AUTOMATIQUE = "AU";
  public static final String ORIGINE_DECISION_COM_PARITAIRE = "IPR";
  public static final Map<String, String> LIB_ORIGINE_DECISION;
  public static final String UNITE_CALENDAIRE = "C";
  public static final String UNITE_OUVRABLE = "O";
  public static final String UNITE_OUVRE = "T";
  public static final Map<String, String> LIB_UNITE;
  public static final int REGIME_SS_REGIME_GENERAL = 0;
  public static final int REGIME_SS_REGIME_AGRICOLE = 1;
  public static final int REGIME_SS_REGIME_DES_MINES = 5;
  public static final int REGIME_SS_REGIME_DE_LA_MARINE_MARCHANDE = 6;
  public static final int REGIME_SS_REGIME_DES_CLERCS_DE_NOTAIRE = 2;
  public static final int REGIME_SS_REGIME_DE_LA_COMPAGNIE_DES_EAUX = 3;
  public static final int REGIME_SS_REGIME_DU_PORT_AUTONOME_DE_BORDEAUX = 7;
  public static final int REGIME_SS_REGIME_DES_FRANCAIS_DE_L_ETRANGER = 4;
  public static final Map<Integer, String> LIB_REGIME_SS;
  public static final String CODE_QUALIFICATION_MANOEUVRE = "01";
  public static final String CODE_QUALIFICATION_OUVRIER_SPECIALISE = "02";
  public static final String CODE_QUALIFICATION_OUVRIER_QUALIFIE_OU_PROFESSIONNEL = "03";
  public static final String CODE_QUALIFICATION_EMPLOYE_NON_QUALIFIE = "04";
  public static final String CODE_QUALIFICATION_EMPLOYE_QUALIFIE = "05";
  public static final String CODE_QUALIFICATION_AGENT_DE_MAITRISE_OU_CONTREMAITRE = "06";
  public static final String CODE_QUALIFICATION_TECHNICIEN_OU_DESSINATEUR = "07";
  public static final String CODE_QUALIFICATION_CADRE_TECHNIQUE = "08";
  public static final String CODE_QUALIFICATION_CADRE_ADMINISTRATIF = "09";
  public static final String CODE_QUALIFICATION_NON_PRECISE = "10";
  public static final Map<String, String> LIB_CODE_QUALIFICATION;
  public static final int CONTEXTE_EXAMEN_AER_REMPLACEMENT = 1;
  public static final int CONTEXTE_EXAMEN_AER_COMPLEMENT = 2;
  public static final Map<Integer, String> LIB_CONTEXTE_EXAMEN_AER;
  public static final int RESULTAT_PAS_DE_NOUVELLE_READMISSION = 0;
  public static final int RESULTAT_READMISSION_DE_L_ANCIEN_DROIT_CAPITAL_ET_MONTANT = 1;
  public static final int RESULTAT_DROIT_COURANT_RETENU_CAPITAL_ET_MONTANT = 2;
  public static final int RESULTAT_READMISSION_AVEC_CAPITAL_DE_L_OD_COURANTE_ET_MONTANT_DU_DROIT_PRECEDENT = 3;
  public static final int RESULTAT_READMISSION_AVEC_CAPITAL_DE_L_OD_PRECEDENTE_ET_MONTANT_DU_DROIT_COURANT = 4;
  public static final Map<Integer, String> LIB_RESULTAT_READMISSION;
  public static final String SITUATION_PARTICULIERE_AUCUNE = "";
  public static final String SITUATION_PARTICULIERE_MIGRATION_ARE_2001 = "1";
  public static final String SITUATION_PARTICULIERE_ATTRIBUTION_PREVISIONNELLE = "2";
  public static final String SITUATION_PARTICULIERE_ATTRIBUTION_NON_EXECUTABLE = "4";
  public static final String SITUATION_PARTICULIERE_NON_PROPOSITION_CRP = "5";
  public static final String SITUATION_PARTICULIERE_NON_PROPOSITION_CTP06 = "6";
  public static final String SITUATION_PARTICULIERE_NON_PROPOSITION_CTP09 = "7";
  public static final String SITUATION_PARTICULIERE_NON_PROPOSITION_CSP = "8";
  public static final String SITUATION_PARTICULIERE_PROPOSITION_CSP_VOLONTAIRE = "9";
  public static final String SITUATION_PARTICULIERE_NON_PROPOSITION_PAP = "A";
  public static final Map<String, String> LIB_SITUATION_PARTICULIERE;
  
  static
  {
    LIB_CODE_VALIDATION.put("V", "VALIDE");
    LIB_CODE_VALIDATION.put("E", "ENREGISTRE NON VALIDE");
    
    LIB_CODE_REEXAMEN = new HashMap();
    
    LIB_CODE_REEXAMEN.put("R", "A REEXAMINER");
    LIB_CODE_REEXAMEN.put("", "PAS DE REEXAMEN");
    
    LIB_REGIME_PARTICULIER = new HashMap();
    
    LIB_REGIME_PARTICULIER.put("", "SANS");
    LIB_REGIME_PARTICULIER.put("A", "CA");
    LIB_REGIME_PARTICULIER.put("E", "CAE");
    
    LIB_CHOM_SAISONNIER = new HashMap();
    
    LIB_CHOM_SAISONNIER.put(" ", "SANS OBJET");
    LIB_CHOM_SAISONNIER.put("1", "RYTHME ACT");
    LIB_CHOM_SAISONNIER.put("2", "NATURE ACT");
    
    LIB_ORIGINE = new HashMap();
    
    LIB_ORIGINE.put("A", "FORCE");
    LIB_ORIGINE.put(" ", "AUTOMATIQUE");
    
    LIB_OUI_NON = new HashMap();
    
    LIB_OUI_NON.put("O", "OUI");
    LIB_OUI_NON.put("N", "NON");
    
    LIB_ORIGINE_DECISION = new HashMap();
    
    LIB_ORIGINE_DECISION.put("AS", "POLE EMPLOI");
    LIB_ORIGINE_DECISION.put("AA", "AUTRE POLE EMPLOI");
    LIB_ORIGINE_DECISION.put("DT", "DDTE");
    LIB_ORIGINE_DECISION.put("DL", "DELEGATAIRE");
    LIB_ORIGINE_DECISION.put("MI", "MIGRATION");
    LIB_ORIGINE_DECISION.put("AU", "REPRISE AUTOMATIQUE");
    LIB_ORIGINE_DECISION.put("IPR", "COM PARITAIRE");
    
    LIB_UNITE = new HashMap();
    
    LIB_UNITE.put("C", "CALENDAIRE");
    LIB_UNITE.put("O", "OUVRABLE");
    LIB_UNITE.put("T", "OUVRE");
    
    LIB_REGIME_SS = new HashMap();
    
    LIB_REGIME_SS.put(Integer.valueOf(0), "REGIME GENERAL");
    LIB_REGIME_SS.put(Integer.valueOf(1), "REGIME AGRICOLE");
    LIB_REGIME_SS.put(Integer.valueOf(5), "REGIME DES MINES");
    LIB_REGIME_SS.put(Integer.valueOf(6), "REGIME DE LA MARINE MARCHANDE");
    LIB_REGIME_SS.put(Integer.valueOf(2), "REGIME DES CLERCS DE NOTAIRE");
    LIB_REGIME_SS.put(Integer.valueOf(3), "REGIME DE LA COMPAGNIE DES EAUX");
    LIB_REGIME_SS.put(Integer.valueOf(7), "REGIME DU PORT AUTONOME DE BORDEAUX");
    LIB_REGIME_SS.put(Integer.valueOf(4), "REGIME DES FRANCAIS DE L'ETRANGER");
    
    LIB_CODE_QUALIFICATION = new HashMap();
    
    LIB_CODE_QUALIFICATION.put("01", "MANOEUVRE");
    LIB_CODE_QUALIFICATION.put("02", "OUVRIER SPECIALISE");
    LIB_CODE_QUALIFICATION.put("03", "OUVRIER QUALIFIE OU PROFESSIONNEL");
    LIB_CODE_QUALIFICATION.put("04", "EMPLOYE NON QUALIFIE");
    LIB_CODE_QUALIFICATION.put("05", "EMPLOYE QUALIFIE");
    LIB_CODE_QUALIFICATION.put("06", "AGENT DE MAITRISE OU CONTREMAITRE");
    LIB_CODE_QUALIFICATION.put("07", "TECHNICIEN OU DESSINATEUR");
    LIB_CODE_QUALIFICATION.put("08", "CADRE TECHNIQUE");
    LIB_CODE_QUALIFICATION.put("09", "CADRE ADMINISTRATIF");
    LIB_CODE_QUALIFICATION.put("10", "NON PRECISE");
    
    LIB_CONTEXTE_EXAMEN_AER = new HashMap();
    
    LIB_CONTEXTE_EXAMEN_AER.put(Integer.valueOf(1), "AER REMPLACEMENT");
    LIB_CONTEXTE_EXAMEN_AER.put(Integer.valueOf(2), "AER COMPLEMENT");
    
    LIB_RESULTAT_READMISSION = new HashMap();
    
    LIB_RESULTAT_READMISSION.put(Integer.valueOf(0), "PAS DE NOUVELLE READMISSION");
    
    LIB_RESULTAT_READMISSION.put(Integer.valueOf(1), "READMISSION DE L'ANCIEN DROIT CAPITAL ET MONTANT");
    
    LIB_RESULTAT_READMISSION.put(Integer.valueOf(2), "DROIT COURANT RETENU CAPITAL ET MONTANT");
    
    LIB_RESULTAT_READMISSION.put(Integer.valueOf(3), "READMISSION AVEC CAPITAL DE L'OD COURANTE ET MONTANT DU DROIT PRECEDENT");
    
    LIB_RESULTAT_READMISSION.put(Integer.valueOf(4), "READMISSION AVEC CAPITAL DE L'OD PRECEDENTE ET MONTANT DU DROIT COURANT");
    
    LIB_SITUATION_PARTICULIERE = new HashMap();
    
    LIB_SITUATION_PARTICULIERE.put("", "AUCUNE");
    LIB_SITUATION_PARTICULIERE.put("1", "MIGRATION ARE 2001");
    LIB_SITUATION_PARTICULIERE.put("2", "ATTRIBUTION PREVISIONNELLE");
    LIB_SITUATION_PARTICULIERE.put("5", "NON PROPOSITION CRP");
    LIB_SITUATION_PARTICULIERE.put("6", "NON PROPOSITION CTP06");
    LIB_SITUATION_PARTICULIERE.put("7", "NON PROPOSITION CTP09");
    LIB_SITUATION_PARTICULIERE.put("8", "NON PROPOSITION CSP");
    LIB_SITUATION_PARTICULIERE.put("9", "NON PROPOSITION CSP VOLONTAIRE");
    LIB_SITUATION_PARTICULIERE.put("A", "NON PROPOSITION PAP");
  }
  
  public Attribution(DomPCSpec pc)
  {
    super(pc);
  }
  
  public void initInstance()
  {
    Attribution attVide = new Attribution();
    attVide.copieElements(this);
  }
  
  public void marquerGraphePersistant()
  {
    DomManager.persisterEnProfondeur(super.getCollectionPeriodeAffiliation());
  }
  
  public void clearCollectionPeriodeAffiliation()
  {
    for (Iterator iter = getCollectionPeriodeAffiliation().iterator(); iter.hasNext();)
    {
      PeriodeAffiliation element = (PeriodeAffiliation)iter.next();
      DomManager.supprimer(element);
    }
    super.clearCollectionPeriodeAffiliation();
  }
  
  public void remplacerCollectionPeriodeAffiliation(Collection collectionACopier)
  {
    for (Iterator iter = getCollectionPeriodeAffiliation().iterator(); iter.hasNext();)
    {
      PeriodeAffiliation element = (PeriodeAffiliation)iter.next();
      DomManager.supprimer(element);
    }
    super.remplacerCollectionPeriodeAffiliation(collectionACopier);
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public ObjetMetierSpec copie()
  {
    Attribution copie = new Attribution();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    Attribution copie = (Attribution)pcopie;
    
    copie.setCapitalDroitPrecedentSp(getCapitalDroitPrecedentSp());
    copie.setCapitalOdCourante(getCapitalOdCourante());
    copie.setCapitalOdPrecedente(getCapitalOdPrecedente());
    copie.setCodeMetier(getCodeMetier());
    copie.setCodeMetierDroitCourant(getCodeMetierDroitCourant());
    copie.setCodeProduit(getCodeProduit());
    copie.setCodeProduitDroitCourant(getCodeProduitDroitCourant());
    copie.setCodeQualification(getCodeQualification());
    copie.setCodeQualificationDroitCourant(getCodeQualificationDroitCourant());
    copie.setCodeStatutIndividu(getCodeStatutIndividu());
    copie.setCodeValidation(getCodeValidation());
    copie.setCodeValidationComplementaire(getCodeValidationComplementaire());
    copie.setCoeffSaisonnierCalcSjrCourant(getCoeffSaisonnierCalcSjrCourant());
    copie.setCoeffSaisonnierForceSjrCourant(getCoeffSaisonnierForceSjrCourant());
    copie.setCoeffTempsPartielSjrCourant(getCoeffTempsPartielSjrCourant());
    copie.setComplementSs(getComplementSs());
    copie.setDateDebutDiffere(getDateDebutDiffere());
    copie.setDateDebutIccp(getDateDebutIccp());
    copie.setDateDebutIslr(getDateDebutIslr());
    copie.setDateDebutPrcDroitCourant(getDateDebutPrcDroitCourant());
    copie.setDateDerniereFctDansDelaiForclusion(getDateDerniereFctDansDelaiForclusion());
    copie.setDateEffetAttribution(getDateEffetAttribution());
    copie.setDateEffetSjc(getDateEffetSjc());
    copie.setDateFinDelaiDecheance(getDateFinDelaiDecheance());
    copie.setDateFinDiffere(getDateFinDiffere());
    copie.setDateFinIccp(getDateFinIccp());
    copie.setDateFinIslr(getDateFinIslr());
    copie.setDateFinPrcDroitCourant(getDateFinPrcDroitCourant());
    copie.setDateTheoriqueFinDroit(getDateTheoriqueFinDroit());
    copie.setDjtp(getDjtp());
    copie.setDureeTheoriqueDroitCourant(getDureeTheoriqueDroitCourant());
    copie.setDureeTheoriqueDroitRetenu(getDureeTheoriqueDroitRetenu());
    copie.setFctRetenueOD(getFctRetenueOD());
    copie.setFinPrcSjrRetenu(getFinPrcSjrRetenu());
    copie.setReferenceExterneDemande(getReferenceExterneDemande());
    copie.setIdentifiantOuvertureDroit(getIdentifiantOuvertureDroit());
    copie.setIdentifiantReprise(getIdentifiantReprise());
    copie.setMontantIslr(getMontantIslr());
    copie.setMontantSalaireReferenceSjrCourant(getMontantSalaireReferenceSjrCourant());
    copie.setMontantSjc(getMontantSjc());
    copie.setMontantSjrCourantCalculePlafonne(getMontantSjrCourantCalculePlafonne());
    copie.setMontantSjrCourantNonPlafonne(getMontantSjrCourantNonPlafonne());
    copie.setMontantSjrCourantPlafonne(getMontantSjrCourantPlafonne());
    copie.setMontantSjrRetenuPlafonne(getMontantSjrRetenuPlafonne());
    copie.setMotifDerniereFctDansDelaiForclusion(getMotifDerniereFctDansDelaiForclusion());
    copie.setMotifFctRetenueOD(getMotifFctRetenueOD());
    copie.setNbHeuresTravailleesA8A10SjrCourant(getNbHeuresTravailleesA8A10SjrCourant());
    copie.setNbJoursDiffere(getNbJoursDiffere());
    copie.setNbJoursDiviseurSjrCourant(getNbJoursDiviseurSjrCourant());
    copie.setNbJoursIccp(getNbJoursIccp());
    copie.setNbJoursIslr(getNbJoursIslr());
    copie.setNbJoursNonConsoDelaiDechance(getNbJoursNonConsoDelaiDechance());
    copie.setOrigineDecision(getOrigineDecision());
    copie.setPji(getPji());
    copie.setPlus100trimestres(getPlus100trimestres());
    copie.setPrcSjrForces(getPrcSjrForces());
    copie.setReferenceReglementaireAffiliationDroitCourant(getReferenceReglementaireAffiliationDroitCourant());
    copie.setReferenceReglementaireAffiliationDroitRetenu(getReferenceReglementaireAffiliationDroitRetenu());
    copie.setRegimeSs(getRegimeSs());
    copie.setReglementApplicableCourant(getReglementApplicableCourant());
    copie.setReglementApplicableRetenu(getReglementApplicableRetenu());
    copie.setTypeChomageSaisonnier(getTypeChomageSaisonnier());
    copie.setUniteDureeDiffere(getUniteDureeDiffere());
    copie.setUniteDureeIccp(getUniteDureeIccp());
    copie.setUniteDureeIslr(getUniteDureeIslr());
    copie.setTypeAerDroitCourant(getTypeAerDroitCourant());
    copie.setTypeAerDroitRetenu(getTypeAerDroitRetenu());
    copie.setMontantInitialCapitalMax(getMontantInitialCapitalMax());
    copie.setRegimeParticulier(getRegimeParticulier());
    copie.setMontantCarenceIccp(getMontantCarenceIccp());
    
    copie.setNombreHeureTravailleEtendu(getNombreHeureTravailleEtendu());
    copie.setRangAllongementPRA(getRangAllongementPRA());
    copie.setCodeActiviteHorsFrance(getCodeActiviteHorsFrance());
    copie.setCodePaysActivite(getCodePaysActivite());
    copie.setRangAttributionAFDFiliereFNA(getRangAttributionAFDFiliereFNA());
    
    copie.setIdentifiantDemandeCali(getIdentifiantDemandeCali());
    copie.setIdentifiantOuvertureDroitAttributionPrecedente(getIdentifiantOuvertureDroitAttributionPrecedente());
    copie.setReferenceExterneDemande(getReferenceExterneDemande());
    copie.setIdGaecPeriodeFg(getIdGaecPeriodeFg());
    copie.setIdGaecPeriodeRa(getIdGaecPeriodeRa());
    copie.setFlagReadmission(getFlagReadmission());
    copie.setNbJoursActiviteCourrierASS(getNbJoursActiviteCourrierASS());
    copie.setCodeSousProduitCourant(getCodeSousProduitCourant());
    copie.setCodeSousProduitRetenu(getCodeSousProduitRetenu());
    copie.setTypeFinancement(getTypeFinancement());
    
    copie.setNbMoisRemboursesCoordEuropeenne(getNbMoisRemboursesCoordEuropeenne());
    
    copie.setNumeroConvention(getNumeroConvention());
    copie.setCodeAffectationConvention(getCodeAffectationConvention());
    
    copie.setSituationParticuliereDroitCourant(getSituationParticuliereDroitCourant());
    copie.setSituationParticuliereDroitRetenu(getSituationParticuliereDroitRetenu());
    copie.setIdExterneEmployeurSp(getIdExterneEmployeurSp());
    
    copie.setMontantSalaireReferenceA10FNA(getMontantSalaireReferenceA10FNA());
    
    copie.setMontantAllocationJournaliereBrut(getMontantAllocationJournaliereBrut());
    if (getTspElementPourEcartsBases() != null)
    {
      copie.setTspElementPourEcartsBases(getTspElementPourEcartsBases());
    }
    else
    {
      Date dateTimestampAvant = (Date)LiDOHelper.getSyntheticValue(getPC(), "{version}");
      if (dateTimestampAvant != null) {
        copie.setTspElementPourEcartsBases(dateTimestampAvant);
      }
    }
    copie.setFctEmployeurCompetent(getFctEmployeurCompetent());
    copie.setDateLimiteIndemnisation(getDateLimiteIndemnisation());
    copie.setAuMoinsUneActiviteConservee(getAuMoinsUneActiviteConservee());
    copie.setEstDroitOption(getEstDroitOption());
    copie.setEstDroitApprenti(getEstDroitApprenti());
    copie.setNbJourEcretementPlafDuree(getNbJourEcretementPlafDuree());
    copie.setEstDroitInterimaire(getEstDroitInterimaire());
  }
  
  public Collection<String> getListeMethodesAExclurePourComparaison()
  {
    Collection<String> listeMethodesAExclure = new ArrayList();
    listeMethodesAExclure.add("getIdentifiantReprise");
    listeMethodesAExclure.add("getIdentifiantOuvertureDroit");
    listeMethodesAExclure.add("getIdentifiantOuvertureDroitAttributionPrecedente");
    return listeMethodesAExclure;
  }
  
  public Map<String, Object> recupererParametresEcartsBases()
  {
    Map<String, Object> parametresEcartsBases = new HashMap();
    parametresEcartsBases.put("attributType", "Attribution Pivot");
    parametresEcartsBases.put("cleTechnique", getIdentifiant());
    parametresEcartsBases.put("cleFonctionnelle", getCleFonctionnelle());
    parametresEcartsBases.put("timestampAvant", getTspElementPourEcartsBases());
    return parametresEcartsBases;
  }
  
  private String getCleFonctionnelle()
  {
    StringBuilder buffer = new StringBuilder();
    buffer.append(getIdentifiantOuvertureDroit());
    buffer.append("-");
    buffer.append(getIdentifiantReprise());
    return buffer.toString();
  }
  
  public boolean estComparableAvec(ElementBasePivotEchangeComparableSpec pelementAComparer)
  {
    Attribution elementAComparer = (Attribution)pelementAComparer;
    return getIdentifiant().equals(elementAComparer.getIdentifiant());
  }
  
  public Collection<EcartBasePivotEchange> comparer(ElementBasePivotEchangeComparableSpec elementAComparer)
    throws CoucheLogiqueException
  {
    return OutilComparaison.comparer(this, elementAComparer);
  }
  
  public Date getTspElementPourEcartsBases()
  {
    return tspElementPourEcartsBase;
  }
  
  public void setTspElementPourEcartsBases(Date tspElementPourEcartBase)
  {
    tspElementPourEcartsBase = tspElementPourEcartBase;
  }
  
  public Attribution() {}
}

/* Location:
 * Qualified Name:     Attribution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */