package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0857223
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0857223 - susp DA pendant AB";
  private static final Damj DATE_REEXECUTION = new Damj(2014, 10, 1);
  private static final int PRIORITE = 760;
  private static final String REQUETE = " SELECT DISTINCT CXASS, CXALAF  FROM P1200Z_PBJCNCP  WHERE CSNPK = 9  AND CSNPI = 'AB' AND DDPJB >= '2014-10-01'  AND CPROD LIKE 'ASU_CG%'  AND (CSCPK1 = 'AF' OR CSCPK2 = 'AF' OR CSCPK3 = 'AF'  OR CSCPK4 = 'AF' OR CSCPK5 = 'AF' OR CSCPK6 = 'AF'  OR CSCPK7 = 'AF' OR CSCPK8 = 'AF' OR CSCPK9 = 'AF'  OR CSCPK0 = 'AF')  AND TSP < TO_DATE('2015-05-21 18:00:00', 'YYYY-MM-DD HH24:MI:SS')  and cxass = ?  and cxalaf >= ?  and cxalaf <= ?  group by cxass, cxalaf  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 2;
  
  public PopulationRepriseStockIN0857223()
  {
    setId("IN0857223 - susp DA pendant AB".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0857223 - susp DA pendant AB");
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
    return " SELECT DISTINCT CXASS, CXALAF  FROM P1200Z_PBJCNCP  WHERE CSNPK = 9  AND CSNPI = 'AB' AND DDPJB >= '2014-10-01'  AND CPROD LIKE 'ASU_CG%'  AND (CSCPK1 = 'AF' OR CSCPK2 = 'AF' OR CSCPK3 = 'AF'  OR CSCPK4 = 'AF' OR CSCPK5 = 'AF' OR CSCPK6 = 'AF'  OR CSCPK7 = 'AF' OR CSCPK8 = 'AF' OR CSCPK9 = 'AF'  OR CSCPK0 = 'AF')  AND TSP < TO_DATE('2015-05-21 18:00:00', 'YYYY-MM-DD HH24:MI:SS')  and cxass = ?  and cxalaf >= ?  and cxalaf <= ?  group by cxass, cxalaf  WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockIN0857223
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */