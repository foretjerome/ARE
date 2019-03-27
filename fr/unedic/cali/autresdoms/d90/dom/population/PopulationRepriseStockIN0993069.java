package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0993069
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0993069 csp11 areSup14";
  private static final int PRIORITE = 755;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "SELECT DISTINCT CXALAF, MIN(DDPJB) from P1200Z_PBJCNCP where cxass = ? AND CXALAF >= ?  AND CXALAF <= ? and CPROD = 'ASU_CVA10_02' AND (CPROD3 = 'ASU_CGE01_06' OR CPROD4 = 'ASU_CGE01_06' OR CPROD2 = 'ASU_CGE01_06' OR CPROD2 = 'ASU_CGE01_06b' OR CPROD5 = 'ASU_CGE01_06b' OR CPROD6 = 'ASU_CGE01_06b' OR CPROD3 = 'ASU_CGE01_06b' OR CPROD4 = 'ASU_CGE01_06b' OR CPROD5 = 'ASU_CGE01_06' OR CPROD6 = 'ASU_CGE01_06') group by cxalaf WITH UR;";
  
  public PopulationRepriseStockIN0993069()
  {
    setId("IN0993069 csp11 areSup14".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0993069 csp11 areSup14");
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
    return "SELECT DISTINCT CXALAF, MIN(DDPJB) from P1200Z_PBJCNCP where cxass = ? AND CXALAF >= ?  AND CXALAF <= ? and CPROD = 'ASU_CVA10_02' AND (CPROD3 = 'ASU_CGE01_06' OR CPROD4 = 'ASU_CGE01_06' OR CPROD2 = 'ASU_CGE01_06' OR CPROD2 = 'ASU_CGE01_06b' OR CPROD5 = 'ASU_CGE01_06b' OR CPROD6 = 'ASU_CGE01_06b' OR CPROD3 = 'ASU_CGE01_06b' OR CPROD4 = 'ASU_CGE01_06b' OR CPROD5 = 'ASU_CGE01_06' OR CPROD6 = 'ASU_CGE01_06') group by cxalaf WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockIN0993069
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */