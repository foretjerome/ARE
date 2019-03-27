package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockINC0097085
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "INC0097085 - ASP ARE 1-2ans";
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "SELECT DISTINCT CXALAF, MIN(DDPJB) FROM P1200Z_PBJCNCP WHERE CPROD IN ('ASU_CVA10_03', 'ASU_CVA10_02') AND CDSPR IN ('02', 'M2') and CXASS = ? AND CXALAF >= ?  AND CXALAF <= ? group by CXALAF WITH UR;";
  
  public PopulationRepriseStockINC0097085()
  {
    super("INC0097085 - ASP ARE 1-2ans");
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
    return "SELECT DISTINCT CXALAF, MIN(DDPJB) FROM P1200Z_PBJCNCP WHERE CPROD IN ('ASU_CVA10_03', 'ASU_CVA10_02') AND CDSPR IN ('02', 'M2') and CXASS = ? AND CXALAF >= ?  AND CXALAF <= ? group by CXALAF WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockINC0097085
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */