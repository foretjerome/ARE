package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchMesureCiblesA8A10;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockNCSpectacle
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "2016D037D - Mesures cibles A8A10 ";
  private static final String REQUETE = " SELECT distinct p1.CXASS, p1.CXALAF, p1.CDEXA1, p1.CDTDC  FROM P1299C_DECISION p1  WHERE CPROD = 'ASU_SPE02_05'  AND DIEXA >= '2016-08-1'  AND p1.CXASS = ?  AND p1.CXALAF >= ?  AND p1.CXALAF <= ?  UNION  SELECT p2.CXASS, p2.CXALAF, p2.CDEXA1, p2.CDTDC  FROM P1299C_DECISION p2  WHERE CDEXA1 = '7'  AND DIEXA >= '2016-08-1'  AND p2.CXASS = ?  AND p2.CXALAF >= ?  AND p2.CXALAF <= ?  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int CODE_ASSEDIC2 = 4;
  private static final int ID_INF2 = 5;
  private static final int ID_SUP2 = 6;
  private static final int COLONNE_CXALAF = 2;
  
  public PopulationRepriseStockNCSpectacle()
  {
    super("2016D037D - Mesures cibles A8A10 ");
    setComportement(new ComportementBatchMesureCiblesA8A10());
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return new Damj(2016, 8, 1);
  }
  
  public String getRequete()
  {
    return " SELECT distinct p1.CXASS, p1.CXALAF, p1.CDEXA1, p1.CDTDC  FROM P1299C_DECISION p1  WHERE CPROD = 'ASU_SPE02_05'  AND DIEXA >= '2016-08-1'  AND p1.CXASS = ?  AND p1.CXALAF >= ?  AND p1.CXALAF <= ?  UNION  SELECT p2.CXASS, p2.CXALAF, p2.CDEXA1, p2.CDTDC  FROM P1299C_DECISION p2  WHERE CDEXA1 = '7'  AND DIEXA >= '2016-08-1'  AND p2.CXASS = ?  AND p2.CXALAF >= ?  AND p2.CXALAF <= ?  WITH UR; ";
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
  
  public Long getCxalaf(ResultSet rs)
    throws SQLException
  {
    return Long.valueOf(rs.getLong(2));
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockNCSpectacle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */