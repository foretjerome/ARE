package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchDefautMandatementAuto;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockParametresAvrilA2b
  extends PopulationAbstraite
{
  private static final String IDENTIFIANT_POPULATION = "Reval parametres A2B au 01/04/2017";
  private static final int PRIORITE = 760;
  private static final String REQUETE = "SELECT DISTINCT T.CXASS, T.CXALA FROM P1200A_INDIVIDU P, P0151S T, P0141A U, ((select demande.CXASS, demande.CXALAF from P1210R_01DEMANDE demande INNER JOIN P1299A_DEMANDE demandePivot ON demande.DDE_PIVOT_ID = demandePivot.CXNUM AND demande.CXASS = ? AND demande.CXALAF >= ? AND demande.CXALAF <= ? AND demande.CXASS = demandePivot.CXASS AND demande.CXALAF = demandePivot.CXALAF INNER JOIN P1299C_DECISION decisionPivot ON demandePivot.CXNUMB = decisionPivot.CXNUM AND demandePivot.CXASS = decisionPivot.CXASS AND demandePivot.CXALAF = decisionPivot.CXALAF INNER JOIN P1210B_01DOSSAFF dossierAffectation ON demande.CXASS = dossierAffectation.CXASS AND demande.CXALAF = dossierAffectation.CXALAF AND demande.DOSS_AFF_ADM_ID = dossierAffectation.DOSS_AFFECT_ID INNER JOIN P12A0C_01DOSEX dossierExamen ON dossierAffectation.CXASS = dossierExamen.CXASS AND dossierAffectation.CXALAF = dossierExamen.CXALAF AND dossierAffectation.DOSEX_ID = dossierExamen.DOSS_EXAM_ID INNER JOIN P12A0N_01CEP_ADM constitutionAdmission ON dossierExamen.CEPA_ID = constitutionAdmission.CEP_ID AND dossierExamen.CXASS = constitutionAdmission.CXASS AND dossierExamen.CXALAF = constitutionAdmission.CXALAF where UPPER(constitutionAdmission.REGLEMENT_CTRA) = 'A2B' and DATE(decisionPivot.DEODN) >  DATE('2017-03-31')) UNION (select demande.CXASS, demande.CXALAF from P1210R_01DEMANDE demande INNER JOIN P1299A_DEMANDE demandePivot ON demande.DDE_PIVOT_ID = demandePivot.CXNUM AND demande.CXASS = ? AND demande.CXALAF >= ? AND demande.CXALAF <= ? AND demande.CXASS = demandePivot.CXASS AND demande.CXALAF = demandePivot.CXALAF INNER JOIN P1299C_DECISION decisionPivot ON demandePivot.CXNUMB = decisionPivot.CXNUM AND demandePivot.CXASS = decisionPivot.CXASS AND demandePivot.CXALAF = decisionPivot.CXALAF INNER JOIN P1210B_01DOSSAFF dossierAffectation ON demande.CXASS = dossierAffectation.CXASS AND demande.CXALAF = dossierAffectation.CXALAF AND demande.DOSS_AFF_ADM_ID = dossierAffectation.DOSS_AFFECT_ID INNER JOIN P1216Z_010103DOSEX dossierExamen ON dossierAffectation.CXASS = dossierExamen.CXASS AND dossierAffectation.CXALAF = dossierExamen.CXALAF AND dossierAffectation.DOSEX_ID = dossierExamen.DOSS_EXAM_ID INNER JOIN P1217W_010103CEPA constitutionAdmission ON dossierExamen.CEPA_ID = constitutionAdmission.CEP_ID AND dossierExamen.CXASS = constitutionAdmission.CXASS AND dossierExamen.CXALAF = constitutionAdmission.CXALAF where UPPER(constitutionAdmission.REGLEMENT_CTRA) = 'A2B' and DATE(decisionPivot.DEODN) >  DATE('2017-03-31')) UNION (select distinct cxass, cxalaf from p1200z_pbjcncp where UPPER(CSRDK) = 'A2B' and DFPJB > '2017-03-31' and CXASS = ? AND CXALAF >= ? AND CXALAF <= ?) ) RESULTAT WHERE  T.CXASS=P.CXASS AND T.CXALA = P.CXALAF AND T.CDTIDJ = 'RE' AND U.CXAS3 = P.CXASS AND U.CXALA = P.CXALAF AND U.CINCP = 'M' AND T.CXALA = RESULTAT.CXALAF AND T.CXASS = RESULTAT.CXASS AND T.CXASS = ? AND T.CXALA >= ? AND T.CXALA <= ? WITH UR ";
  private static final int COLONNE_CXALAF = 2;
  private static final Damj DATE_REEXECUTION = new Damj(2017, 4, 1);
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int CODE_ASSEDIC_2 = 4;
  private static final int ID_INF_2 = 5;
  private static final int ID_SUP_2 = 6;
  private static final int CODE_ASSEDIC_3 = 7;
  private static final int ID_INF_3 = 8;
  private static final int ID_SUP_3 = 9;
  private static final int CODE_ASSEDIC_4 = 10;
  private static final int ID_INF_4 = 11;
  private static final int ID_SUP_4 = 12;
  
  public PopulationRepriseStockParametresAvrilA2b()
  {
    setComportement(new ComportementBatchDefautMandatementAuto());
    setId("Reval parametres A2B au 01/04/2017".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("Reval parametres A2B au 01/04/2017");
    setNumeroDSMS("INC0427995");
    setConsequenceFinanciereRecalcul(" ");
    setMaxCodeConsequenceSelection(" ");
  }
  
  public Long getCxalaf(ResultSet rs)
    throws SQLException
  {
    return Long.valueOf(rs.getLong(2));
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return DATE_REEXECUTION;
  }
  
  public String getRequete()
  {
    return "SELECT DISTINCT T.CXASS, T.CXALA FROM P1200A_INDIVIDU P, P0151S T, P0141A U, ((select demande.CXASS, demande.CXALAF from P1210R_01DEMANDE demande INNER JOIN P1299A_DEMANDE demandePivot ON demande.DDE_PIVOT_ID = demandePivot.CXNUM AND demande.CXASS = ? AND demande.CXALAF >= ? AND demande.CXALAF <= ? AND demande.CXASS = demandePivot.CXASS AND demande.CXALAF = demandePivot.CXALAF INNER JOIN P1299C_DECISION decisionPivot ON demandePivot.CXNUMB = decisionPivot.CXNUM AND demandePivot.CXASS = decisionPivot.CXASS AND demandePivot.CXALAF = decisionPivot.CXALAF INNER JOIN P1210B_01DOSSAFF dossierAffectation ON demande.CXASS = dossierAffectation.CXASS AND demande.CXALAF = dossierAffectation.CXALAF AND demande.DOSS_AFF_ADM_ID = dossierAffectation.DOSS_AFFECT_ID INNER JOIN P12A0C_01DOSEX dossierExamen ON dossierAffectation.CXASS = dossierExamen.CXASS AND dossierAffectation.CXALAF = dossierExamen.CXALAF AND dossierAffectation.DOSEX_ID = dossierExamen.DOSS_EXAM_ID INNER JOIN P12A0N_01CEP_ADM constitutionAdmission ON dossierExamen.CEPA_ID = constitutionAdmission.CEP_ID AND dossierExamen.CXASS = constitutionAdmission.CXASS AND dossierExamen.CXALAF = constitutionAdmission.CXALAF where UPPER(constitutionAdmission.REGLEMENT_CTRA) = 'A2B' and DATE(decisionPivot.DEODN) >  DATE('2017-03-31')) UNION (select demande.CXASS, demande.CXALAF from P1210R_01DEMANDE demande INNER JOIN P1299A_DEMANDE demandePivot ON demande.DDE_PIVOT_ID = demandePivot.CXNUM AND demande.CXASS = ? AND demande.CXALAF >= ? AND demande.CXALAF <= ? AND demande.CXASS = demandePivot.CXASS AND demande.CXALAF = demandePivot.CXALAF INNER JOIN P1299C_DECISION decisionPivot ON demandePivot.CXNUMB = decisionPivot.CXNUM AND demandePivot.CXASS = decisionPivot.CXASS AND demandePivot.CXALAF = decisionPivot.CXALAF INNER JOIN P1210B_01DOSSAFF dossierAffectation ON demande.CXASS = dossierAffectation.CXASS AND demande.CXALAF = dossierAffectation.CXALAF AND demande.DOSS_AFF_ADM_ID = dossierAffectation.DOSS_AFFECT_ID INNER JOIN P1216Z_010103DOSEX dossierExamen ON dossierAffectation.CXASS = dossierExamen.CXASS AND dossierAffectation.CXALAF = dossierExamen.CXALAF AND dossierAffectation.DOSEX_ID = dossierExamen.DOSS_EXAM_ID INNER JOIN P1217W_010103CEPA constitutionAdmission ON dossierExamen.CEPA_ID = constitutionAdmission.CEP_ID AND dossierExamen.CXASS = constitutionAdmission.CXASS AND dossierExamen.CXALAF = constitutionAdmission.CXALAF where UPPER(constitutionAdmission.REGLEMENT_CTRA) = 'A2B' and DATE(decisionPivot.DEODN) >  DATE('2017-03-31')) UNION (select distinct cxass, cxalaf from p1200z_pbjcncp where UPPER(CSRDK) = 'A2B' and DFPJB > '2017-03-31' and CXASS = ? AND CXALAF >= ? AND CXALAF <= ?) ) RESULTAT WHERE  T.CXASS=P.CXASS AND T.CXALA = P.CXALAF AND T.CDTIDJ = 'RE' AND U.CXAS3 = P.CXASS AND U.CXALA = P.CXALAF AND U.CINCP = 'M' AND T.CXALA = RESULTAT.CXALAF AND T.CXASS = RESULTAT.CXASS AND T.CXASS = ? AND T.CXALA >= ? AND T.CXALA <= ? WITH UR ";
  }
  
  public void preparerStatement(PreparedStatement statement, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
    throws SQLException
  {
    statement.setString(1, codeAssedic);
    statement.setString(2, idInf);
    statement.setString(3, idSup);
    statement.setString(4, codeAssedic);
    statement.setString(5, idInf);
    statement.setString(6, idSup);
    statement.setString(7, codeAssedic);
    statement.setString(8, idInf);
    statement.setString(9, idSup);
    statement.setString(10, codeAssedic);
    statement.setString(11, idInf);
    statement.setString(12, idSup);
  }
  
  public void chargerIndividu(Individu individu)
    throws ApplicativeException, TechniqueException
  {
    individu.chargerIndividuCohab();
    individu.chargerIndividuCali();
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockParametresAvrilA2b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */