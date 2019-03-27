package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockINC0266679
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "INC0266679 - suspensif decalage faux";
  private static final String REQUETE = "SELECT P1.CXALAF, min(P1.DDPJB) from P1200Z_PBJCNCP P1 inner join P1200Z_PBJCNCP P2 on P1.cxass = P2.cxass and P1.cxalaf = P2.cxalaf where LAST_DAY(P1.DDPJB) = LAST_DAY(P2.DDPJB) and P1.RSODI = P2.RSODI and P1.RSODT = P2.RSODT and P1.DFPJB = P2.DDPJB - 1 DAYS and ((P2.CSCPK0 IS NOT NULL and P2.CSCPK0 = 'AF') OR (P2.CSCPK1 IS NOT NULL and P2.CSCPK1 = 'AF') OR (P2.CSCPK2 IS NOT NULL and P2.CSCPK2 = 'AF') OR (P2.CSCPK3 IS NOT NULL and P2.CSCPK3 = 'AF') OR (P2.CSCPK4 IS NOT NULL and P2.CSCPK4 = 'AF')) and P1.CPROD != 'ASU_SPE02_05' and P1.CSNPK = 1 and P2.CSNPK = 9 and P1.DDPJB >= '2014-10-01' AND P1.CXASS = ? AND P1.CXALAF >= ? AND P1.CXALAF <= ? GROUP BY P1.CXALAF WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  
  public PopulationRepriseStockINC0266679()
  {
    super("INC0266679 - suspensif decalage faux");
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
    return "SELECT P1.CXALAF, min(P1.DDPJB) from P1200Z_PBJCNCP P1 inner join P1200Z_PBJCNCP P2 on P1.cxass = P2.cxass and P1.cxalaf = P2.cxalaf where LAST_DAY(P1.DDPJB) = LAST_DAY(P2.DDPJB) and P1.RSODI = P2.RSODI and P1.RSODT = P2.RSODT and P1.DFPJB = P2.DDPJB - 1 DAYS and ((P2.CSCPK0 IS NOT NULL and P2.CSCPK0 = 'AF') OR (P2.CSCPK1 IS NOT NULL and P2.CSCPK1 = 'AF') OR (P2.CSCPK2 IS NOT NULL and P2.CSCPK2 = 'AF') OR (P2.CSCPK3 IS NOT NULL and P2.CSCPK3 = 'AF') OR (P2.CSCPK4 IS NOT NULL and P2.CSCPK4 = 'AF')) and P1.CPROD != 'ASU_SPE02_05' and P1.CSNPK = 1 and P2.CSNPK = 9 and P1.DDPJB >= '2014-10-01' AND P1.CXASS = ? AND P1.CXALAF >= ? AND P1.CXALAF <= ? GROUP BY P1.CXALAF WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockINC0266679
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */