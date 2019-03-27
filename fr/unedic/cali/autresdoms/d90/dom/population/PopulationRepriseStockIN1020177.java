package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN1020177
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN1020177 - decalage statut";
  private static final int PRIORITE = 755;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "select DISTINCT cxalaf, MIN(DDPJB) from p1200z_pbjcncp where dfpjb >= '2014-10-01' and csnpk = '9' and psden > 0 and csnpk = '9' and TSP < TO_DATE('2016-04-21 23:59:00', 'YYYY-MM-DD HH24:MI:SS') and cxass = ? AND CXALAF >= ?  AND CXALAF <= ? group by cxalaf WITH UR;";
  
  public PopulationRepriseStockIN1020177()
  {
    setId("IN1020177 - decalage statut".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN1020177 - decalage statut");
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
    return Damj.dateVersDamj(rs.getDate(2));
  }
  
  public String getRequete()
  {
    return "select DISTINCT cxalaf, MIN(DDPJB) from p1200z_pbjcncp where dfpjb >= '2014-10-01' and csnpk = '9' and psden > 0 and csnpk = '9' and TSP < TO_DATE('2016-04-21 23:59:00', 'YYYY-MM-DD HH24:MI:SS') and cxass = ? AND CXALAF >= ?  AND CXALAF <= ? group by cxalaf WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockIN1020177
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */