package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStock1031693
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN1031693 - Rejets DV";
  private static final String REQUETE = "select ipr.cxalaf, min(ipr.diexa) from p1299c_decision ipr inner join p1299c_decision rejet on ipr.cxass = rejet.cxass and ipr.cxalaf = rejet.cxalaf and ipr.diexa >= rejet.diexa and ipr.cxnum <> rejet.cxnum and rejet.cmrjn IN (91, 92) where ipr.CDTDC <> 0 and ipr.CDEXA1 = 'Y' and rejet.diexa =  (select max(diexa) from p1299c_decision where cxass = ipr.cxass and cxalaf = ipr.cxalaf and diexa <= ipr.diexa and cxnum <> ipr.cxnum and cmrjn IN (91, 92)) and ( (rejet.diexa < '2014-10-01' and date(rejet.tsp) >= '2014-10-01') or (rejet.CDEXA1 = '83')) and ipr.CXASS = ? AND ipr.CXALAF >= ? AND ipr.CXALAF <= ? GROUP BY ipr.CXALAF WITH UR;";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE_REEXECUTION = 2;
  
  public PopulationRepriseStock1031693()
  {
    super("IN1031693 - Rejets DV");
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
    return "select ipr.cxalaf, min(ipr.diexa) from p1299c_decision ipr inner join p1299c_decision rejet on ipr.cxass = rejet.cxass and ipr.cxalaf = rejet.cxalaf and ipr.diexa >= rejet.diexa and ipr.cxnum <> rejet.cxnum and rejet.cmrjn IN (91, 92) where ipr.CDTDC <> 0 and ipr.CDEXA1 = 'Y' and rejet.diexa =  (select max(diexa) from p1299c_decision where cxass = ipr.cxass and cxalaf = ipr.cxalaf and diexa <= ipr.diexa and cxnum <> ipr.cxnum and cmrjn IN (91, 92)) and ( (rejet.diexa < '2014-10-01' and date(rejet.tsp) >= '2014-10-01') or (rejet.CDEXA1 = '83')) and ipr.CXASS = ? AND ipr.CXALAF >= ? AND ipr.CXALAF <= ? GROUP BY ipr.CXALAF WITH UR;";
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
 * Qualified Name:     PopulationRepriseStock1031693
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */