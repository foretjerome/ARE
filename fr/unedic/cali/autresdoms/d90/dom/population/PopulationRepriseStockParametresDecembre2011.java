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

public class PopulationRepriseStockParametresDecembre2011
  extends PopulationAbstraite
{
  private static final String IDENTIFIANT_POPULATION = "11SI3CALI_RS_56211_RevalorisationASUJanvier2012";
  private static final int PRIORITE = 760;
  private static final String REQUETE = "SELECT distinct CXALAF FROM P1200Z_PBJCNCP  where CPROD IN ('ASU_SPE02_03','ASU_SSP07_03','ASU_FDS12_01','ASU_FDS12_02') AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND DFPJB > '2011-12-31'  AND (QMRSQ >= 387  OR QMJSK1 >= 133  OR QMJSK2 >= 133  OR QMJSK3 >= 133  OR QMJSK4 >= 133  OR QMJSK5 >= 133  OR QMJSK6 >= 133  OR QMJSK7 >= 133) AND TSP < TO_DATE('2012-01-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS') Union(  SELECT distinct CXALAF FROM P1200Z_PBJCNCP where CPROD IN ('ASU_CGE01_02', 'ASU_CGE01_03', 'ASU_CGE01_04', 'ASU_CSA06_01', 'ASU_CSA06_02', 'ASU_CSR04_02', 'ASU_CSR04_01', 'ASU_CVA10_01', 'ASU_CAA14_01', 'ASU_CVE13_01', 'ASU_DDM16_01', 'INR_ADR03_02', 'ASU_EXP03_01') AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND DFPJB > '2010-12-31' AND (QMRSQ >= 387 OR QMPCA >= 387)AND TSP < TO_DATE('2012-01-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));";
  private static final int COLONNE_CXALAF = 1;
  private static final Damj DATE_REEXECUTION = new Damj(2012, 1, 1);
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int CODE_ASSEDIC_2 = 4;
  private static final int ID_INF_2 = 5;
  private static final int ID_SUP_2 = 6;
  
  public PopulationRepriseStockParametresDecembre2011()
  {
    setComportement(new ComportementBatchDefautMandatementAuto());
    setId("11SI3CALI_RS_56211_RevalorisationASUJanvier2012".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("11SI3CALI_RS_56211_RevalorisationASUJanvier2012");
    setNumeroDSMS("55504");
    setConsequenceFinanciereRecalcul(" ");
    setMaxCodeConsequenceSelection(" ");
  }
  
  public Long getCxalaf(ResultSet rs)
    throws SQLException
  {
    return Long.valueOf(rs.getLong(1));
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return DATE_REEXECUTION;
  }
  
  public String getRequete()
  {
    return "SELECT distinct CXALAF FROM P1200Z_PBJCNCP  where CPROD IN ('ASU_SPE02_03','ASU_SSP07_03','ASU_FDS12_01','ASU_FDS12_02') AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND DFPJB > '2011-12-31'  AND (QMRSQ >= 387  OR QMJSK1 >= 133  OR QMJSK2 >= 133  OR QMJSK3 >= 133  OR QMJSK4 >= 133  OR QMJSK5 >= 133  OR QMJSK6 >= 133  OR QMJSK7 >= 133) AND TSP < TO_DATE('2012-01-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS') Union(  SELECT distinct CXALAF FROM P1200Z_PBJCNCP where CPROD IN ('ASU_CGE01_02', 'ASU_CGE01_03', 'ASU_CGE01_04', 'ASU_CSA06_01', 'ASU_CSA06_02', 'ASU_CSR04_02', 'ASU_CSR04_01', 'ASU_CVA10_01', 'ASU_CAA14_01', 'ASU_CVE13_01', 'ASU_DDM16_01', 'INR_ADR03_02', 'ASU_EXP03_01') AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND DFPJB > '2010-12-31' AND (QMRSQ >= 387 OR QMPCA >= 387)AND TSP < TO_DATE('2012-01-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));";
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
 * Qualified Name:     PopulationRepriseStockParametresDecembre2011
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */