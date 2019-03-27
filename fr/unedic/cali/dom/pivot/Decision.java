package fr.unedic.cali.dom.pivot;

import fr.unedic.cali.autresdoms.d90.dom.EcartBasePivotEchange;
import fr.unedic.cali.autresdoms.d90.dom.spec.ElementBasePivotEchangeComparableSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComparaison;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pivot.gen.DecisionGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import xcalia.lido.api.LiDOHelper;

public class Decision
  extends DecisionGen
  implements ObjetPersistantSpec, ElementBasePivotEchangeComparableSpec
{
  private static final long serialVersionUID = 4881221800203553733L;
  public static final int NATURE_DECISION_REPRISE_CONTEXT_SUITE_POSSIBILITE_READ_SAISONN = 99;
  public static final int NATURE_DECISION_RENONCEMENT = 98;
  public static final Map<Integer, String> LIB_NATURE_DECISION = new HashMap();
  protected transient Date tspElementPourEcartsBase = null;
  public static final int MOTIF_REJET_SP_B12 = 12;
  public static final int MOTIF_REJET_SP_B13 = 13;
  public static final int MOTIF_REJET_SP_B14 = 14;
  public static final int MOTIF_REJET_SP_B15 = 15;
  public static final int MOTIF_REJET_SP_B16 = 16;
  public static final int MOTIF_REJET_SP_B17 = 17;
  public static final int MOTIF_REJET_SP_B18 = 18;
  public static final int MOTIF_REJET_SP_B12_PN = 1;
  public static final int MOTIF_REJET_SP_B13_PN = 2;
  public static final int MOTIF_REJET_SP_B14_PN = 3;
  public static final int MOTIF_REJET_SP_B15_PN = 4;
  public static final int MOTIF_REJET_SP_B16_PN = 5;
  public static final int MOTIF_REJET_SP_B17_PN = 9;
  public static final int MOTIF_REJET_SP_B18_PN = 6;
  public static final Map<Integer, String> LIB_MOTIF_REJET;
  public static final String ORIGINE_DECISION_ASSEDIC = "AS";
  public static final String ORIGINE_DECISION_AUTRE_ASSEDIC = "AA";
  public static final String ORIGINE_DECISION_DDTE = "DT";
  public static final String ORIGINE_DECISION_DELEGATAIRE = "DL";
  public static final String ORIGINE_DECISION_MIGRATION = "MI";
  public static final String ORIGINE_DECISION_REPRISE_AUTOMATIQUE = "RA";
  public static final String ORIGINE_DECISION_COM_PARITAIRE = "IPR";
  public static final String ORIGINE_DECISION_REJET_AUTOMATIQUE = "AU";
  public static final String ORIGINE_DECISION_ANTECEDENT_TRANSFERT_IMPOSSIBLE = "AT";
  public static final String ORIGINE_DECISION_ANTECEDENT_ECHEC_MIGRATION = "AM";
  public static final String ORIGINE_DECISION_ANTECEDENT_FIN_DROIT_SP = "AP";
  public static final String ORIGINE_DECISION_ANTECEDENT_MIGRATION_SP_EN_COURS = "AE";
  public static final String ORIGINE_DECISION_ANTECEDENT_MIGRATION_SP_RADIE = "AR";
  public static final Map<String, String> LIB_ORIGINE_DECISION;
  public static final String VALIDE = "V";
  public static final String ENREGISTRE_NON_VALIDE = "E";
  public static final Map<String, String> LIB_CODE_VALIDATION;
  public static final String A_REEXAMINER = "R";
  public static final String PAS_DE_REEXAMEN = "";
  public static final Map<String, String> LIB_CODE_REEXAMEN;
  public static final String DECISION_NOTIFIEE = "O";
  public static final String DECISION_NON_NOTIFIEE = "N";
  public static final String UNITE_HEURE = "H";
  public static final String UNITE_JOUR = "J";
  public static final String UNITE_VACATION = "V";
  public static final String UNITE_J_EMBARQUEMENT = "E";
  public static final Map<String, String> LIB_UNITE;
  public static final String COMPETENCE_ADMINISTRATIVE_UNEDIC = "AC";
  public static final String COMPETENCE_ADMINISTRATIVE_SP = "SP";
  public static final Map<String, String> LIB_COMPETENCE_ADMINISTRATIVE;
  public static final String EN_L_ETAT_OUI = "O";
  public static final String EN_L_ETAT_NON = "N";
  public static final Map<String, String> LIB_EN_L_ETAT;
  public static final int PMC_NON_INDEMNISABLE = 0;
  public static final int PMC_INDEMNISABLE = 1;
  
  static
  {
    LIB_NATURE_DECISION.put(Integer.valueOf(99), "REPRISE CONTEXT SUITE POSSIBILITE READ SAISONN");
    
    LIB_NATURE_DECISION.put(Integer.valueOf(98), "RENONCEMENT");
    
    LIB_MOTIF_REJET = new HashMap();
    
    LIB_MOTIF_REJET.put(Integer.valueOf(12), "SP_B12");
    LIB_MOTIF_REJET.put(Integer.valueOf(13), "SP_B13");
    LIB_MOTIF_REJET.put(Integer.valueOf(14), "SP_B14");
    LIB_MOTIF_REJET.put(Integer.valueOf(15), "SP_B15");
    LIB_MOTIF_REJET.put(Integer.valueOf(16), "SP_B16E");
    LIB_MOTIF_REJET.put(Integer.valueOf(17), "SP_B17");
    LIB_MOTIF_REJET.put(Integer.valueOf(18), "SP_B18");
    LIB_MOTIF_REJET.put(Integer.valueOf(1), "SP_B12_PN");
    LIB_MOTIF_REJET.put(Integer.valueOf(2), "SP_B13_PN");
    LIB_MOTIF_REJET.put(Integer.valueOf(3), "SP_B14_PN");
    LIB_MOTIF_REJET.put(Integer.valueOf(4), "SP_B15_PN");
    LIB_MOTIF_REJET.put(Integer.valueOf(5), "SP_B16_PN");
    LIB_MOTIF_REJET.put(Integer.valueOf(9), "SP_B17_PN");
    LIB_MOTIF_REJET.put(Integer.valueOf(6), "SP_B18_PN");
    
    LIB_ORIGINE_DECISION = new HashMap();
    
    LIB_ORIGINE_DECISION.put("AS", "POLE EMPLOI");
    LIB_ORIGINE_DECISION.put("AA", "AUTRE POLE EMPLOI");
    LIB_ORIGINE_DECISION.put("DT", "DDTE");
    LIB_ORIGINE_DECISION.put("DL", "DELEGATAIRE");
    LIB_ORIGINE_DECISION.put("MI", "MIGRATION");
    LIB_ORIGINE_DECISION.put("RA", "REPRISE AUTOMATIQUE");
    LIB_ORIGINE_DECISION.put("IPR", "COM PARITAIRE");
    LIB_ORIGINE_DECISION.put("AU", "REJET AUTOMATIQUE");
    
    LIB_CODE_VALIDATION = new HashMap();
    
    LIB_CODE_VALIDATION.put("V", "VALIDE");
    LIB_CODE_VALIDATION.put("E", "ENREGISTRE NON VALIDE");
    
    LIB_CODE_REEXAMEN = new HashMap();
    
    LIB_CODE_REEXAMEN.put("R", "A REEXAMINER");
    LIB_CODE_REEXAMEN.put("", "PAS DE REEXAMEN");
    
    LIB_UNITE = new HashMap();
    
    LIB_UNITE.put("H", "HEURE");
    LIB_UNITE.put("J", "JOUR");
    LIB_UNITE.put("V", "VACATION");
    LIB_UNITE.put("E", "J EMBARQUEMENT");
    
    LIB_COMPETENCE_ADMINISTRATIVE = new HashMap();
    
    LIB_COMPETENCE_ADMINISTRATIVE.put("AC", "UNEDIC");
    LIB_COMPETENCE_ADMINISTRATIVE.put("SP", "SECTEUR PUBLIC");
    
    LIB_EN_L_ETAT = new HashMap();
    
    LIB_EN_L_ETAT.put("O", "OUI");
    LIB_EN_L_ETAT.put("N", "NON");
  }
  
  public Decision(DomPCSpec pc)
  {
    super(pc);
  }
  
  public void initInstance()
  {
    Decision decVide = new Decision();
    decVide.copieElements(this);
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public ObjetMetierSpec copie()
  {
    Decision copie = new Decision();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    Decision copie = (Decision)pcopie;
    
    copie.setClassementAdministratif(getClassementAdministratif());
    copie.setCodeProduit(getCodeProduit());
    copie.setCodeReexamen(getCodeReexamen());
    copie.setCodeValidation(getCodeValidation());
    copie.setCompetenceAdministrative(getCompetenceAdministrative());
    copie.setDateEffetDecision(getDateEffetDecision());
    copie.setDateExamen(getDateExamen());
    copie.setDateFctFG(getDateFctFG());
    copie.setDateFctRetenue(getDateFctRetenue());
    copie.setDatePriseDecision(getDatePriseDecision());
    copie.setDateValidationDecision(getDateValidationDecision());
    copie.setReferenceExterneDemande(getReferenceExterneDemande());
    copie.setMotifRejet(getMotifRejet());
    copie.setNatureDecision(getNatureDecision());
    copie.setNbJoursAppartenance(getNbJoursAppartenance());
    copie.setOrigineDecision(getOrigineDecision());
    copie.setTypeExamen(getTypeExamen());
    copie.setUniteAffiliation(getUniteAffiliation());
    copie.setUniteAffiliation2(getUniteAffiliation2());
    copie.setValeurQuantiteAffiliation(getValeurQuantiteAffiliation());
    copie.setValeurQuantiteAffiliation2(getValeurQuantiteAffiliation2());
    copie.setDateFinPmc(getDateFinPmc());
    copie.setTypePmc(getTypePmc());
    copie.setValeurQuantiteAssimilation(getValeurQuantiteAssimilation());
    copie.setCodeSousProduit(getCodeSousProduit());
    copie.setDateDebutPra(getDateDebutPra());
    copie.setDateFinPra(getDateFinPra());
    copie.setValeurQuantiteAffiliationRequise(getValeurQuantiteAffiliationRequise());
    copie.setUniteAffiliationRequise(getUniteAffiliationRequise());
    copie.setValeurQuantiteAffiliationRequise2(getValeurQuantiteAffiliationRequise2());
    copie.setUniteAffiliationRequise2(getUniteAffiliationRequise2());
    copie.setPeriodeTheoriqueRechercheAffiliation(getPeriodeTheoriqueRechercheAffiliation());
    copie.setDateFinDecheance(getDateFinDecheance());
    copie.setIdentifiantDemandeCali(getIdentifiantDemandeCali());
    copie.setSituationParticuliere(getSituationParticuliere());
    copie.setTopLiquidationEnEtat(getTopLiquidationEnEtat());
    copie.setNbHTravailHorsA8A10(getNbHTravailHorsA8A10());
    copie.setNbHFormationProfessionnelleAssimiliees(getNbHFormationProfessionnelleAssimiliees());
    copie.setNbHMaladieAssimilees(getNbHMaladieAssimilees());
    copie.setNbHEnseignementDispenseesAssimilees(getNbHEnseignementDispenseesAssimilees());
    copie.setNbHMaterniteAssimilees(getNbHMaterniteAssimilees());
    copie.setOldTypeExamen(getOldTypeExamen());
    copie.setEtablissementFinanceur(getEtablissementFinanceur());
    copie.setIdExterneEmployeurSp(getIdExterneEmployeurSp());
    copie.setDateDebutEvenement(getDateDebutEvenement());
    copie.setDateFinEvenement(getDateFinEvenement());
    copie.setNbJoursAffiImputes(getNbJoursAffiImputes());
    copie.setModeTraitementDemandeNPDE(getModeTraitementDemandeNPDE());
    copie.setCodeSousProduitRejet(getCodeSousProduitRejet());
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
  }
  
  public Collection getListeMethodesAExclurePourComparaison()
  {
    return new ArrayList();
  }
  
  public Map<String, Object> recupererParametresEcartsBases()
  {
    Map<String, Object> parametresEcartsBases = new HashMap();
    parametresEcartsBases.put("attributType", "Decision Pivot");
    parametresEcartsBases.put("cleTechnique", getIdentifiant());
    parametresEcartsBases.put("cleFonctionnelle", getReferenceExterneDemande());
    parametresEcartsBases.put("timestampAvant", getTspElementPourEcartsBases());
    return parametresEcartsBases;
  }
  
  public boolean estComparableAvec(ElementBasePivotEchangeComparableSpec p_elementAComparer)
  {
    Decision elementAComparer = (Decision)p_elementAComparer;
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
  
  public Decision() {}
  
  public void marquerGraphePersistant() {}
}

/* Location:
 * Qualified Name:     Decision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */