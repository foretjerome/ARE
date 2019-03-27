package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN093454TypeClassMay
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN093454 - RS type class Mayotte";
  private static final int PRIORITE = 755;
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "SELECT U.CXASS, U.CXALAF, U.PERIODE_D FROM P1200P_UT U INNER JOIN P1200Z_PBJCNCP P ON U.CXASS = P.CXASS AND U.CXALAF = P.CXALAF WHERE U.PERIODE_D <= P.DFPJB AND U.PERIODE_F >= P.DDPJB AND U.TYPE_CLASS = 1180 AND P.CPROD = 'ASU_MAY17_02' AND U.CXASS = ?  AND U.CXALAF >= ?  AND U.CXALAF <= ? WITH UR ";
  
  public PopulationRepriseStockIN093454TypeClassMay()
  {
    setId("IN093454 - RS type class Mayotte".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN093454 - RS type class Mayotte");
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
    return "SELECT U.CXASS, U.CXALAF, U.PERIODE_D FROM P1200P_UT U INNER JOIN P1200Z_PBJCNCP P ON U.CXASS = P.CXASS AND U.CXALAF = P.CXALAF WHERE U.PERIODE_D <= P.DFPJB AND U.PERIODE_F >= P.DDPJB AND U.TYPE_CLASS = 1180 AND P.CPROD = 'ASU_MAY17_02' AND U.CXASS = ?  AND U.CXALAF >= ?  AND U.CXALAF <= ? WITH UR ";
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
 * Qualified Name:     PopulationRepriseStockIN093454TypeClassMay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */