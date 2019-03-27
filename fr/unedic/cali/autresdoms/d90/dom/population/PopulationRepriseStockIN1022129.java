package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN1022129
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN1022129 - AV ligne ASU";
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "select DISTINCT CXALAF, MIN(DDPJB) from P1200Z_PBJCNCP WHERE QMRAU IS NOT NULL and QMRAU > 0 and (CPROD = 'ASU_CGE01_04' OR CPROD = 'ASU_CGE01_05' OR CPROD = 'ASU_CGE01_06' OR CPROD = 'ASU_CGE01_6b' OR CPROD = 'ASU_MAY17_02' OR CPROD = 'ASU_EXP03_01') and CXASS = ? AND CXALAF >= ?  AND CXALAF <= ? group by CXALAF WITH UR;";
  
  public PopulationRepriseStockIN1022129()
  {
    super("IN1022129 - AV ligne ASU");
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
    return "select DISTINCT CXALAF, MIN(DDPJB) from P1200Z_PBJCNCP WHERE QMRAU IS NOT NULL and QMRAU > 0 and (CPROD = 'ASU_CGE01_04' OR CPROD = 'ASU_CGE01_05' OR CPROD = 'ASU_CGE01_06' OR CPROD = 'ASU_CGE01_6b' OR CPROD = 'ASU_MAY17_02' OR CPROD = 'ASU_EXP03_01') and CXASS = ? AND CXALAF >= ?  AND CXALAF <= ? group by CXALAF WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockIN1022129
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */