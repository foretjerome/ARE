package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN1007781
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN1007781 rfpe mayotte";
  private static final int PRIORITE = 755;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "SELECT distinct CXALAF, MIN(DDPJB) FROM P1200Z_PBJCNCP where cxass = ? and CXALAF >= ? and CXALAF <= ? and CPROD = 'FOR_RFP04_01' AND DFPJB >= '2016-01-01' AND CDPPP1 = 'MA' group by cxalaf WITH UR;";
  
  public PopulationRepriseStockIN1007781()
  {
    setId("IN1007781 rfpe mayotte".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN1007781 rfpe mayotte");
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
    return "SELECT distinct CXALAF, MIN(DDPJB) FROM P1200Z_PBJCNCP where cxass = ? and CXALAF >= ? and CXALAF <= ? and CPROD = 'FOR_RFP04_01' AND DFPJB >= '2016-01-01' AND CDPPP1 = 'MA' group by cxalaf WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockIN1007781
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */