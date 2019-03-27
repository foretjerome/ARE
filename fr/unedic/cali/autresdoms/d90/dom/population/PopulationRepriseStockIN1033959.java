package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN1033959
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN1033959 - AR PEC novation";
  private static final int PRIORITE = 755;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "select DISTINCT recharg.cxalaf, MIN(recharg.diexa) from p1299c_decision recharg inner join p1299c_decision novation on recharg.cxass = novation.cxass and recharg.cxalaf = novation.cxalaf and month(recharg.diexa) = month(novation.diexa) and year(recharg.diexa) = year(novation.diexa) and recharg.diexa < novation.diexa where recharg.CDEXA1 = '83' and recharg.CDTDC is not null and recharg.CDTDC <> 0 and novation.CDTDC IN (47,48) and recharg.CXASS = ? AND recharg.CXALAF >= ?  AND recharg.CXALAF <= ? group by recharg.cxalaf WITH UR;";
  
  public PopulationRepriseStockIN1033959()
  {
    setId("IN1033959 - AR PEC novation".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN1033959 - AR PEC novation");
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
    return "select DISTINCT recharg.cxalaf, MIN(recharg.diexa) from p1299c_decision recharg inner join p1299c_decision novation on recharg.cxass = novation.cxass and recharg.cxalaf = novation.cxalaf and month(recharg.diexa) = month(novation.diexa) and year(recharg.diexa) = year(novation.diexa) and recharg.diexa < novation.diexa where recharg.CDEXA1 = '83' and recharg.CDTDC is not null and recharg.CDTDC <> 0 and novation.CDTDC IN (47,48) and recharg.CXASS = ? AND recharg.CXALAF >= ?  AND recharg.CXALAF <= ? group by recharg.cxalaf WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockIN1033959
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */