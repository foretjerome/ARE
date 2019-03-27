package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockINC0034234
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "INC0034234 - retraite SOL PTS";
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "select DISTINCT A.cxalaf, A.DESIQ from P1201A_ENQUETENCP A inner join P1201A_ENQUETENCP B on A.cxass = B.cxass and A.cxalaf = B.cxalaf where A.CST2Q IN (1, 2, 3) and B.CST2Q IN (1, 2, 3) and A.CST2Q = B.CST2Q and A.CPROD = 'SOL_CGE01_01' and B.CPROD = 'SOL_AER05_04' and A.CXASS = ? AND A.CXALAF >= ?  AND A.CXALAF <= ? with ur;";
  
  public PopulationRepriseStockINC0034234()
  {
    super("INC0034234 - retraite SOL PTS");
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
    return "select DISTINCT A.cxalaf, A.DESIQ from P1201A_ENQUETENCP A inner join P1201A_ENQUETENCP B on A.cxass = B.cxass and A.cxalaf = B.cxalaf where A.CST2Q IN (1, 2, 3) and B.CST2Q IN (1, 2, 3) and A.CST2Q = B.CST2Q and A.CPROD = 'SOL_CGE01_01' and B.CPROD = 'SOL_AER05_04' and A.CXASS = ? AND A.CXALAF >= ?  AND A.CXALAF <= ? with ur;";
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
 * Qualified Name:     PopulationRepriseStockINC0034234
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */