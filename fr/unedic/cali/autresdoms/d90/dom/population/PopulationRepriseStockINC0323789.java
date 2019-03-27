package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockINC0323789
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "INC0323789 - suspensif avant";
  private static final String REQUETE = "select DISTINCT CA.CXALAF, MIN(PBJC.DDPJB) from P1201L_CALEXEAVANT CA join P1200Z_PBJCNCP PBJC on ca.cxass = PBJC.cxass and ca.cxalaf = PBJC.cxalaf where PBJC.CSNPI = 'MA' and PBJC.DDPJB >= CA.PREMIER_JOUR and PBJC.DDPJB <= LAST_DAY(CA.DERNIER_JOUR) and PBJC.DDPJB >= '2014-10-01' AND CA.CXASS = ? AND CA.CXALAF >= ? AND CA.CXALAF <= ? group by CA.CXALAF WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  
  public PopulationRepriseStockINC0323789()
  {
    super("INC0323789 - suspensif avant");
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
    return "select DISTINCT CA.CXALAF, MIN(PBJC.DDPJB) from P1201L_CALEXEAVANT CA join P1200Z_PBJCNCP PBJC on ca.cxass = PBJC.cxass and ca.cxalaf = PBJC.cxalaf where PBJC.CSNPI = 'MA' and PBJC.DDPJB >= CA.PREMIER_JOUR and PBJC.DDPJB <= LAST_DAY(CA.DERNIER_JOUR) and PBJC.DDPJB >= '2014-10-01' AND CA.CXASS = ? AND CA.CXALAF >= ? AND CA.CXALAF <= ? group by CA.CXALAF WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockINC0323789
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */