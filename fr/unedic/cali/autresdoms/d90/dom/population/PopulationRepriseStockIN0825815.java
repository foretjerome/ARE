package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0825815
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "876313 - Decheance sur Revision Hors PEC";
  private static final int PRIORITE = 760;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final String REQUETE = "SELECT DEC.CXALAF, MIN(DEC.DIEXA) FROM P1299C_DECISION DEC LEFT OUTER JOIN P1200Z_PBJCNCP PBJC ON DEC.CXASS = PBJC.CXASS AND DEC.CXALAF = PBJC.CXALAF AND DEC.DIEXA >= PBJC.DDPJB AND DEC.DIEXA <= PBJC.DFPJB WHERE (PBJC.CXNUM IS NULL OR PBJC.CXNUM = 0) AND DEC.CDEXA1 = '82' AND (DEC.CRCLA IS NULL OR DEC.CRCLA = '') AND DEC.CDTDC <> 0 AND DEC.CXASS = ? AND DEC.CXALAF >= ? AND DEC.CXALAF <= ? GROUP BY DEC.CXALAF WITH UR;";
  
  public PopulationRepriseStockIN0825815()
  {
    setId("876313 - Decheance sur Revision Hors PEC".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("876313 - Decheance sur Revision Hors PEC");
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
    return "SELECT DEC.CXALAF, MIN(DEC.DIEXA) FROM P1299C_DECISION DEC LEFT OUTER JOIN P1200Z_PBJCNCP PBJC ON DEC.CXASS = PBJC.CXASS AND DEC.CXALAF = PBJC.CXALAF AND DEC.DIEXA >= PBJC.DDPJB AND DEC.DIEXA <= PBJC.DFPJB WHERE (PBJC.CXNUM IS NULL OR PBJC.CXNUM = 0) AND DEC.CDEXA1 = '82' AND (DEC.CRCLA IS NULL OR DEC.CRCLA = '') AND DEC.CDTDC <> 0 AND DEC.CXASS = ? AND DEC.CXALAF >= ? AND DEC.CXALAF <= ? GROUP BY DEC.CXALAF WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockIN0825815
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */