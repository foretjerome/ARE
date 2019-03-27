package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0867627
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0867627 - Od assurance MEP 15SI2";
  private static final int PRIORITE = 760;
  private static final String REQUETE = "select demande.CXASS, demande.CXALAF, MIN(decisionPivot.DIEXA)  from P1210R_01DEMANDE demande INNER JOIN P1299A_DEMANDE ddePivot ON demande.CXASS = ddePivot.CXASS AND demande.CXALAF = ddePivot.CXALAF AND demande.DDE_PIVOT_ID = ddePivot.CXNUM INNER JOIN P1299C_DECISION decisionPivot ON decisionPivot.CXASS = ddePivot.CXASS AND decisionPivot.CXALAF = ddePivot.CXALAF AND decisionPivot.CXNUM = ddePivot.CXNUMB where DERN_VALID_DMD > '2015-06-21' AND DERN_VALID_DMD < '2015-07-03' AND decisionPivot.CDTDC IN (10, 11, 12, 26, 45, 40, 32, 44) AND decisionPivot.CPROD LIKE 'ASU_%' AND demande.CXASS = ? AND demande.CXALAF >= ? AND demande.CXALAF <= ? GROUP BY demande.CXASS, demande.CXALAF; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  
  public PopulationRepriseStockIN0867627()
  {
    setId("IN0867627 - Od assurance MEP 15SI2".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0867627 - Od assurance MEP 15SI2");
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
    return Damj.dateVersDamj(rs.getDate(3));
  }
  
  public String getRequete()
  {
    return "select demande.CXASS, demande.CXALAF, MIN(decisionPivot.DIEXA)  from P1210R_01DEMANDE demande INNER JOIN P1299A_DEMANDE ddePivot ON demande.CXASS = ddePivot.CXASS AND demande.CXALAF = ddePivot.CXALAF AND demande.DDE_PIVOT_ID = ddePivot.CXNUM INNER JOIN P1299C_DECISION decisionPivot ON decisionPivot.CXASS = ddePivot.CXASS AND decisionPivot.CXALAF = ddePivot.CXALAF AND decisionPivot.CXNUM = ddePivot.CXNUMB where DERN_VALID_DMD > '2015-06-21' AND DERN_VALID_DMD < '2015-07-03' AND decisionPivot.CDTDC IN (10, 11, 12, 26, 45, 40, 32, 44) AND decisionPivot.CPROD LIKE 'ASU_%' AND demande.CXASS = ? AND demande.CXALAF >= ? AND demande.CXALAF <= ? GROUP BY demande.CXASS, demande.CXALAF; ";
  }
  
  public void preparerStatement(PreparedStatement statement, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
    throws SQLException
  {
    statement.setString(1, codeAssedic);
    statement.setString(2, idInf);
    statement.setString(3, idSup);
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockIN0867627
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */