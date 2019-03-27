package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockUrgentDrv
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0917306 - DRV";
  private static final int PRIORITE = 760;
  private static final Damj DATE_REEXECUTION = new Damj(2015, 7, 1);
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final String REQUETE = "SELECT DISTINCT CXALAF FROM P1201A_ENQUETENCP WHERE CST2Q = '37' AND DESIQ >= '2015-07-01' AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? WITH UR;";
  
  public PopulationRepriseStockUrgentDrv()
  {
    setId("IN0917306 - DRV".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0917306 - DRV");
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
    return DATE_REEXECUTION;
  }
  
  public String getRequete()
  {
    return "SELECT DISTINCT CXALAF FROM P1201A_ENQUETENCP WHERE CST2Q = '37' AND DESIQ >= '2015-07-01' AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockUrgentDrv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */