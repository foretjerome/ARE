package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0901531
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "15SI4 Persistance allongement CSP";
  private static final Damj DATE_REEXECUTION = new Damj(2014, 10, 1);
  private static final int PRIORITE = 760;
  private static final String REQUETE = " SELECT DISTINCT CXASS, CXALAF, MIN(DDCSP)  FROM P1201N_DISPOSITIF  WHERE DFCSP2 < DATE ('2016-02-29')  AND DAYS(DFCSP2) - DAYS(DDCSP) > 364  and cxass = ?  and cxalaf >= ?  and cxalaf <= ?  GROUP BY CXASS, CXALAF  UNION  SELECT DISTINCT CXASS, CXALAF, MIN(DDCSP)  FROM P1201N_DISPOSITIF  WHERE DFCSP2 > DATE ('2016-02-28')  AND DAYS(DFCSP2) - DAYS(DDCSP) > 365  and cxass = ?  and cxalaf >= ?  and cxalaf <= ?  GROUP BY CXASS, CXALAF  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int CODE_ASSEDIC2 = 4;
  private static final int ID_INF2 = 5;
  private static final int ID_SUP2 = 6;
  private static final int COLONNE_CXALAF = 2;
  
  public PopulationRepriseStockIN0901531()
  {
    setId("15SI4 Persistance allongement CSP".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("15SI4 Persistance allongement CSP");
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
    return DATE_REEXECUTION;
  }
  
  public String getRequete()
  {
    return " SELECT DISTINCT CXASS, CXALAF, MIN(DDCSP)  FROM P1201N_DISPOSITIF  WHERE DFCSP2 < DATE ('2016-02-29')  AND DAYS(DFCSP2) - DAYS(DDCSP) > 364  and cxass = ?  and cxalaf >= ?  and cxalaf <= ?  GROUP BY CXASS, CXALAF  UNION  SELECT DISTINCT CXASS, CXALAF, MIN(DDCSP)  FROM P1201N_DISPOSITIF  WHERE DFCSP2 > DATE ('2016-02-28')  AND DAYS(DFCSP2) - DAYS(DDCSP) > 365  and cxass = ?  and cxalaf >= ?  and cxalaf <= ?  GROUP BY CXASS, CXALAF  WITH UR; ";
  }
  
  public void preparerStatement(PreparedStatement statement, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
    throws SQLException
  {
    statement.setString(1, codeAssedic);
    statement.setString(2, idInf);
    statement.setString(3, idSup);
    statement.setString(4, codeAssedic);
    statement.setString(5, idInf);
    statement.setString(6, idSup);
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockIN0901531
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */