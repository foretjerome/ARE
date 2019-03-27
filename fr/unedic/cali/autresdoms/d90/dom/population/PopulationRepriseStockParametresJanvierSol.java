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

public class PopulationRepriseStockParametresJanvierSol
  extends PopulationAbstraite
{
  private static final String IDENTIFIANT_POPULATION = "Parametres Solidarite Avril 2017";
  private static final int PRIORITE = 760;
  private static final Damj DATE_REEXECUTION = new Damj(2017, 4, 1);
  private static final String REQUETE = "select distinct cxalaf from P1299C_DECISION where (CPROD like 'SOL%'  OR CPROD = 'INR_CES06_01') and DATE(DEODN) > DATE('2017-03-31') and CXASS = ? and CXALAF >= ? AND CXALAF <= ? UNION SELECT distinct pbjc.CXALAF FROM P1200Z_PBJCNCP pbjc WHERE pbjc.CXASS = ? AND (pbjc.CPROD like 'SOL%' OR pbjc.CPROD = 'INR_CES06_01' OR CPROD1 = 'SOL_AER05_01' OR CPROD1 = 'SOL_AER05_02' OR CPROD1 = 'SOL_AER05_03' OR CPROD1 = 'SOL_AER05_04' OR CPROD2 = 'SOL_AER05_01' OR CPROD2 = 'SOL_AER05_02' OR CPROD2 = 'SOL_AER05_03' OR CPROD2 = 'SOL_AER05_04' OR CPROD3 = 'SOL_AER05_01' OR CPROD3 = 'SOL_AER05_02' OR CPROD3 = 'SOL_AER05_03' OR CPROD3 = 'SOL_AER05_04' OR CPROD4 = 'SOL_AER05_01' OR CPROD4 = 'SOL_AER05_02' OR CPROD4 = 'SOL_AER05_03' OR CPROD4 = 'SOL_AER05_04' OR CPROD5 = 'SOL_AER05_01' OR CPROD5 = 'SOL_AER05_02' OR CPROD5 = 'SOL_AER05_03' OR CPROD5 = 'SOL_AER05_04' OR CPROD6 = 'SOL_AER05_01' OR CPROD6 = 'SOL_AER05_02' OR CPROD6 = 'SOL_AER05_03' OR CPROD6 = 'SOL_AER05_04' OR CPROD7 = 'SOL_AER05_01' OR CPROD7 = 'SOL_AER05_02' OR CPROD7 = 'SOL_AER05_03' OR CPROD7 = 'SOL_AER05_04') AND pbjc.CXALAF >= ? AND pbjc.CXALAF <= ? AND pbjc.DFPJB > '2017-03-31' WITH UR;";
  private static final int COLONNE_CXALAF = 1;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int CODE_ASSEDIC_UNION = 4;
  private static final int ID_INF_UNION = 5;
  private static final int ID_SUP_UNION = 6;
  
  public PopulationRepriseStockParametresJanvierSol()
  {
    setComportement(new ComportementBatchDefautMandatementAuto());
    setId("Parametres Solidarite Avril 2017".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("Parametres Solidarite Avril 2017");
    setNumeroDSMS("IN1010245");
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
    return "select distinct cxalaf from P1299C_DECISION where (CPROD like 'SOL%'  OR CPROD = 'INR_CES06_01') and DATE(DEODN) > DATE('2017-03-31') and CXASS = ? and CXALAF >= ? AND CXALAF <= ? UNION SELECT distinct pbjc.CXALAF FROM P1200Z_PBJCNCP pbjc WHERE pbjc.CXASS = ? AND (pbjc.CPROD like 'SOL%' OR pbjc.CPROD = 'INR_CES06_01' OR CPROD1 = 'SOL_AER05_01' OR CPROD1 = 'SOL_AER05_02' OR CPROD1 = 'SOL_AER05_03' OR CPROD1 = 'SOL_AER05_04' OR CPROD2 = 'SOL_AER05_01' OR CPROD2 = 'SOL_AER05_02' OR CPROD2 = 'SOL_AER05_03' OR CPROD2 = 'SOL_AER05_04' OR CPROD3 = 'SOL_AER05_01' OR CPROD3 = 'SOL_AER05_02' OR CPROD3 = 'SOL_AER05_03' OR CPROD3 = 'SOL_AER05_04' OR CPROD4 = 'SOL_AER05_01' OR CPROD4 = 'SOL_AER05_02' OR CPROD4 = 'SOL_AER05_03' OR CPROD4 = 'SOL_AER05_04' OR CPROD5 = 'SOL_AER05_01' OR CPROD5 = 'SOL_AER05_02' OR CPROD5 = 'SOL_AER05_03' OR CPROD5 = 'SOL_AER05_04' OR CPROD6 = 'SOL_AER05_01' OR CPROD6 = 'SOL_AER05_02' OR CPROD6 = 'SOL_AER05_03' OR CPROD6 = 'SOL_AER05_04' OR CPROD7 = 'SOL_AER05_01' OR CPROD7 = 'SOL_AER05_02' OR CPROD7 = 'SOL_AER05_03' OR CPROD7 = 'SOL_AER05_04') AND pbjc.CXALAF >= ? AND pbjc.CXALAF <= ? AND pbjc.DFPJB > '2017-03-31' WITH UR;";
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
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockParametresJanvierSol
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */