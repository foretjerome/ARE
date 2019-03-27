package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN1000355
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN1000355 - decalage MUE";
  private static final int PRIORITE = 755;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "select DISTINCT D.CXALAF, MIN(CA.PREMIER_JOUR) from P1200L_DROITNCP D JOIN P1201L_CALEXEAVANT CA on D.CXASS = CA.CXASS and D.cxalaf = CA.cxalaf where D.cxass = ? AND D.CXALAF >= ?  AND D.CXALAF <= ? and D.DEMAEG BETWEEN CA.PREMIER_JOUR and CA.DERNIER_JOUR AND CA.PREMIER_JOUR > DATE('2014-10-01') group by D.cxalaf WITH UR;";
  
  public PopulationRepriseStockIN1000355()
  {
    setId("IN1000355 - decalage MUE".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN1000355 - decalage MUE");
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
    return "select DISTINCT D.CXALAF, MIN(CA.PREMIER_JOUR) from P1200L_DROITNCP D JOIN P1201L_CALEXEAVANT CA on D.CXASS = CA.CXASS and D.cxalaf = CA.cxalaf where D.cxass = ? AND D.CXALAF >= ?  AND D.CXALAF <= ? and D.DEMAEG BETWEEN CA.PREMIER_JOUR and CA.DERNIER_JOUR AND CA.PREMIER_JOUR > DATE('2014-10-01') group by D.cxalaf WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockIN1000355
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */