package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockINC0067118
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "INC0067118 Double Rechargement";
  private static final String REQUETE = " SELECT DECI1.CXALAF, MIN(DECI1.DIEXA)  FROM P1299C_DECISION DECI1  INNER JOIN P1299C_DECISION DECI2  ON DECI1.CXASS = DECI2.CXASS  AND DECI1.CXALAF = DECI2.CXALAF  AND DECI1.CXNUM <> DECI2.CXNUM  WHERE DECI1.CRCLA IS NULL  AND DECI2.CRCLA IS NULL  AND DECI1.DIEXA = DECI2.DIEXA  AND DECI1.CDEXA1 = '83'  AND DECI2.CDEXA1 = '83'  AND DECI1.CXASS = ?  AND DECI1.CXALAF >= ?  AND DECI1.CXALAF <= ?  GROUP BY DECI1.CXALAF  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  
  public PopulationRepriseStockINC0067118()
  {
    super("INC0067118 Double Rechargement");
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
    return " SELECT DECI1.CXALAF, MIN(DECI1.DIEXA)  FROM P1299C_DECISION DECI1  INNER JOIN P1299C_DECISION DECI2  ON DECI1.CXASS = DECI2.CXASS  AND DECI1.CXALAF = DECI2.CXALAF  AND DECI1.CXNUM <> DECI2.CXNUM  WHERE DECI1.CRCLA IS NULL  AND DECI2.CRCLA IS NULL  AND DECI1.DIEXA = DECI2.DIEXA  AND DECI1.CDEXA1 = '83'  AND DECI2.CDEXA1 = '83'  AND DECI1.CXASS = ?  AND DECI1.CXALAF >= ?  AND DECI1.CXALAF <= ?  GROUP BY DECI1.CXALAF  WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockINC0067118
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */