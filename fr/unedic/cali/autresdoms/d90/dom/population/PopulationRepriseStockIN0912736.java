package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0912736
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0912736 Courriers KCDH ASP";
  private static final int PRIORITE = 755;
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "SELECT DISTINCT enquete.CXASS, enquete.CXALAF, MIN(DESIQ) FROM P1201A_ENQUETENCP enquete inner join P1201N_DISPOSITIF dispositif  ON enquete.CXASS = dispositif.CXASS  AND enquete.CXALAF = dispositif.CXALAF WHERE CST2Q IN (34, 35) AND DFCSP2 <> DESIQ AND enquete.CXASS = ?  AND enquete.CXALAF >= ?  AND enquete.CXALAF <= ? GROUP BY enquete.CXASS, enquete.CXALAF WITH UR;";
  
  public PopulationRepriseStockIN0912736()
  {
    setId("IN0912736 Courriers KCDH ASP".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0912736 Courriers KCDH ASP");
    setConsequenceFinanciereRecalcul(" ");
    setMaxCodeConsequenceSelection(" ");
  }
  
  public Long getCxalaf(ResultSet rs)
    throws SQLException
  {
    return Long.valueOf(rs.getLong(2));
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return Damj.dateVersDamj(rs.getDate(3));
  }
  
  public String getRequete()
  {
    return "SELECT DISTINCT enquete.CXASS, enquete.CXALAF, MIN(DESIQ) FROM P1201A_ENQUETENCP enquete inner join P1201N_DISPOSITIF dispositif  ON enquete.CXASS = dispositif.CXASS  AND enquete.CXALAF = dispositif.CXALAF WHERE CST2Q IN (34, 35) AND DFCSP2 <> DESIQ AND enquete.CXASS = ?  AND enquete.CXALAF >= ?  AND enquete.CXALAF <= ? GROUP BY enquete.CXASS, enquete.CXALAF WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockIN0912736
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */