package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN1033563
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN1033563 - decalage PA plafond";
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "select DISTINCT CXALAF, MIN(DDPJB) from P1200Z_PBJCNCP WHERE PSDEN > 0 and (DAYOFMONTH(DDPJB) = 1 AND LAST_DAY(DFPJB) != DFPJB) and DDPJB >= '2014-10-01' and CSNPI = 'CT' and TSP < TO_DATE('2016-07-07 22:00:00', 'YYYY-MM-DD HH24:MI:SS') and CXASS = ? AND CXALAF >= ?  AND CXALAF <= ? group by CXALAF WITH UR;";
  
  public PopulationRepriseStockIN1033563()
  {
    super("IN1033563 - decalage PA plafond");
  }
  
  public Long getCxalaf(ResultSet rs)
    throws SQLException
  {
    return Long.valueOf(rs.getLong(1));
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return Damj.dateVersDamj(rs.getDate(2));
  }
  
  public String getRequete()
  {
    return "select DISTINCT CXALAF, MIN(DDPJB) from P1200Z_PBJCNCP WHERE PSDEN > 0 and (DAYOFMONTH(DDPJB) = 1 AND LAST_DAY(DFPJB) != DFPJB) and DDPJB >= '2014-10-01' and CSNPI = 'CT' and TSP < TO_DATE('2016-07-07 22:00:00', 'YYYY-MM-DD HH24:MI:SS') and CXASS = ? AND CXALAF >= ?  AND CXALAF <= ? group by CXALAF WITH UR;";
  }
  
  public void preparerStatement(PreparedStatement statement, String assedic, String inf, String sup, ContexteService service)
    throws SQLException
  {
    statement.setString(1, assedic);
    statement.setString(2, inf);
    statement.setString(3, sup);
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockIN1033563
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */