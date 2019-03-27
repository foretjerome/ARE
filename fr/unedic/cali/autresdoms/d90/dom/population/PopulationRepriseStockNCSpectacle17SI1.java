package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationRepriseStockNCSpectacle17SI1;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockNCSpectacle17SI1
  extends PopulationAbstraite
{
  public static final String LIBELLE_POPULATION = "2016D045DD01 Mesures cibles A810";
  private static final String REQUETE = " SELECT distinct CXASS, CXALAF, min(DIEXA)    FROM P1299C_DECISION    WHERE CPROD = 'ASU_SPE02_05'   AND DIEXA >= '2016-08-1'  AND CXASS = ?  AND CXALAF >= ?  AND CXALAF <= ?   group by CXASS, CXALAF   UNION   SELECT CXASS, CXALAF, min(DFPJB)   from p1200z_PBJCNCP   where cprod = 'ASU_SPE02_04'   and DFPJB >= '2017-03-01'   AND CXASS = ?   AND CXALAF >= ?   AND CXALAF <= ?   group by CXASS, CXALAF  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int CODE_ASSEDIC2 = 4;
  private static final int ID_INF2 = 5;
  private static final int ID_SUP2 = 6;
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  
  public PopulationRepriseStockNCSpectacle17SI1()
  {
    super("2016D045DD01 Mesures cibles A810");
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    ParcoursPopulationRepriseStockNCSpectacle17SI1 parcours = new ParcoursPopulationRepriseStockNCSpectacle17SI1();
    parcours.setNomPopulation("2016D045DD01 Mesures cibles A810");
    return parcours;
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return Damj.dateVersDamj(rs.getDate(3));
  }
  
  public String getRequete()
  {
    return " SELECT distinct CXASS, CXALAF, min(DIEXA)    FROM P1299C_DECISION    WHERE CPROD = 'ASU_SPE02_05'   AND DIEXA >= '2016-08-1'  AND CXASS = ?  AND CXALAF >= ?  AND CXALAF <= ?   group by CXASS, CXALAF   UNION   SELECT CXASS, CXALAF, min(DFPJB)   from p1200z_PBJCNCP   where cprod = 'ASU_SPE02_04'   and DFPJB >= '2017-03-01'   AND CXASS = ?   AND CXALAF >= ?   AND CXALAF <= ?   group by CXASS, CXALAF  WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockNCSpectacle17SI1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */