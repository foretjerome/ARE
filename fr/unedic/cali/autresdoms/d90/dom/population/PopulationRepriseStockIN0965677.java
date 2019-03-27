package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0965677
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0965677 - decalage PANS";
  private static final Damj DATE_REEXECUTION = new Damj(2014, 10, 1);
  private static final int PRIORITE = 755;
  private static final int COLONNE_CXALAF = 1;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "select DISTINCT p.cxalaf from p1110c_periode_act p join p1113d_revenu r on p.cxass = r.cxass and p.cxalaf = r.cxalaf and p.revenu_id = r.revenu_id where p.cxass = ? AND p.CXALAF >= ?  AND p.CXALAF <= ? and p.type_periode = '00018' and r.date_paie >= '2017-10-01' WITH UR;";
  
  public PopulationRepriseStockIN0965677()
  {
    setId("IN0965677 - decalage PANS".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0965677 - decalage PANS");
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
    return "select DISTINCT p.cxalaf from p1110c_periode_act p join p1113d_revenu r on p.cxass = r.cxass and p.cxalaf = r.cxalaf and p.revenu_id = r.revenu_id where p.cxass = ? AND p.CXALAF >= ?  AND p.CXALAF <= ? and p.type_periode = '00018' and r.date_paie >= '2017-10-01' WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockIN0965677
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */