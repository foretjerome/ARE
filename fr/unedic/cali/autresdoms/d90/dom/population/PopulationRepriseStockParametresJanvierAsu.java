package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchDefautMandatementAuto;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockParametresJanvierAsu
  extends PopulationAbstraite
{
  private static final String LIBELLE = "Parametres Assurance Janvier 2018";
  private static final int IDENTIFIANT_POPULATION = "Parametres Assurance Janvier 2018".hashCode();
  private static final int PRIORITE = 760;
  private static final Damj DATE_REEXECUTION = new Damj(2018, 1, 1);
  private static final String REQUETE = "select distinct cxass, cxalaf from P1299C_DECISION where CPROD like 'ASU%' and DATE(DEODN) > DATE('2017-12-31') AND DATE(DEODN) < DATE('2018-01-26') AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? union( SELECT distinct CXASS, CXALAF FROM P1200Z_PBJCNCP where CPROD = 'ASU_CVA10_03' AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND DFPJB > '2017-12-31'  AND (QMJSK1 >= 228  OR QMJSK2 >= 228  OR QMJSK3 >= 228  OR QMJSK4 >= 228  OR QMJSK5 >= 228  OR QMJSK6 >= 228  OR QMJSK7 >= 228) AND TSP < TO_DATE('2018-01-26 22:00:00', 'YYYY-MM-DD HH24:MI:SS')) union( SELECT distinct CXASS, CXALAF FROM P1200Z_PBJCNCP  where CPROD IN ('ASU_SPE02_03','ASU_SSP07_03','ASU_SPE02_04','ASU_SSP07_04','ASU_FDS12_01','ASU_SPE02_06', 'ASU_SSP07_05', 'ASU_FDS12_03','ASU_SPE02_05','ASU_FDS12_02') AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND DFPJB > '2017-12-31'  AND (QMRSQ >= 423  OR QMJSK1 >= 145  OR QMJSK2 >= 145  OR QMJSK3 >= 145  OR QMJSK4 >= 145  OR QMJSK5 >= 145  OR QMJSK6 >= 145  OR QMJSK7 >= 145) AND TSP < TO_DATE('2018-01-26 22:00:00', 'YYYY-MM-DD HH24:MI:SS')) union( SELECT distinct CXASS, CXALAF FROM P1200Z_PBJCNCP  where CPROD IN ('ASU_SPE02_04','ASU_SPE02_05','ASU_SSP07_04',  'ASU_SPE02_06', 'ASU_SSP07_05') AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND DFPJB > '2017-12-31' AND CSNPI = 'CT') union( select distinct CXASS, CXALAF  from P1200Z_PBJCNCP where CPROD = 'ASU_MAY17_02' AND DFPJB > '2017-12-31' AND QMRSQ >= 43.26 AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ?) Union(  SELECT distinct CXASS, CXALAF FROM P1200Z_PBJCNCP where (CPROD like 'ASU%' or CPROD = 'INR_ADR03_02')  AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND DFPJB > '2017-12-31' AND (QMRSQ >= 423 OR QMPCA >= 423) AND TSP < TO_DATE('2018-01-26 22:00:00', 'YYYY-MM-DD HH24:MI:SS')) ";
  private static final int COLONNE_CXALAF = 2;
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
  private static final int CODE_ASSEDIC_5 = 13;
  private static final int ID_INF_5 = 14;
  private static final int ID_SUP_5 = 15;
  private static final int CODE_ASSEDIC_6 = 16;
  private static final int ID_INF_6 = 17;
  private static final int ID_SUP_6 = 18;
  
  public PopulationRepriseStockParametresJanvierAsu()
  {
    setComportement(new ComportementBatchDefautMandatementAuto());
    setId(IDENTIFIANT_POPULATION);
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("Parametres Assurance Janvier 2018");
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
    return "select distinct cxass, cxalaf from P1299C_DECISION where CPROD like 'ASU%' and DATE(DEODN) > DATE('2017-12-31') AND DATE(DEODN) < DATE('2018-01-26') AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? union( SELECT distinct CXASS, CXALAF FROM P1200Z_PBJCNCP where CPROD = 'ASU_CVA10_03' AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND DFPJB > '2017-12-31'  AND (QMJSK1 >= 228  OR QMJSK2 >= 228  OR QMJSK3 >= 228  OR QMJSK4 >= 228  OR QMJSK5 >= 228  OR QMJSK6 >= 228  OR QMJSK7 >= 228) AND TSP < TO_DATE('2018-01-26 22:00:00', 'YYYY-MM-DD HH24:MI:SS')) union( SELECT distinct CXASS, CXALAF FROM P1200Z_PBJCNCP  where CPROD IN ('ASU_SPE02_03','ASU_SSP07_03','ASU_SPE02_04','ASU_SSP07_04','ASU_FDS12_01','ASU_SPE02_06', 'ASU_SSP07_05', 'ASU_FDS12_03','ASU_SPE02_05','ASU_FDS12_02') AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND DFPJB > '2017-12-31'  AND (QMRSQ >= 423  OR QMJSK1 >= 145  OR QMJSK2 >= 145  OR QMJSK3 >= 145  OR QMJSK4 >= 145  OR QMJSK5 >= 145  OR QMJSK6 >= 145  OR QMJSK7 >= 145) AND TSP < TO_DATE('2018-01-26 22:00:00', 'YYYY-MM-DD HH24:MI:SS')) union( SELECT distinct CXASS, CXALAF FROM P1200Z_PBJCNCP  where CPROD IN ('ASU_SPE02_04','ASU_SPE02_05','ASU_SSP07_04',  'ASU_SPE02_06', 'ASU_SSP07_05') AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND DFPJB > '2017-12-31' AND CSNPI = 'CT') union( select distinct CXASS, CXALAF  from P1200Z_PBJCNCP where CPROD = 'ASU_MAY17_02' AND DFPJB > '2017-12-31' AND QMRSQ >= 43.26 AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ?) Union(  SELECT distinct CXASS, CXALAF FROM P1200Z_PBJCNCP where (CPROD like 'ASU%' or CPROD = 'INR_ADR03_02')  AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND DFPJB > '2017-12-31' AND (QMRSQ >= 423 OR QMPCA >= 423) AND TSP < TO_DATE('2018-01-26 22:00:00', 'YYYY-MM-DD HH24:MI:SS')) ";
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
    statement.setString(13, codeAssedic);
    statement.setString(14, idInf);
    statement.setString(15, idSup);
    statement.setString(16, codeAssedic);
    statement.setString(17, idInf);
    statement.setString(18, idSup);
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockParametresJanvierAsu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */