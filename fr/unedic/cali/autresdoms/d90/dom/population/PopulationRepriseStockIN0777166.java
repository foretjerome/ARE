package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0777166
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0777166 - Decalage en double pendant et avant";
  private static final int PRIORITE = 760;
  private static final Damj DATE_REEXECUTION = new Damj(2014, 9, 1);
  private static final String REQUETE = "SELECT distinct P1.cxass, P1.cxalaf FROM P1200Z_PBJCNCP P1 INNER JOIN P1200Z_PBJCNCP P2 on P1.CXALAF = P2.CXALAF AND P1.CXASS = P2.CXASS WHERE (MONTH(p1.DDPJB) = MONTH(p2.DDPJB) AND YEAR(p1.DDPJB) = YEAR(p2.DDPJB) AND p1.DDPJB >= '2014-10-01') AND p1.DDPJB <> p2.DDPJB AND p1.CSNPK IN (3,7,9) AND p2.CSNPK = 1 AND p2.CSNPI = 'CT' AND P1.cxass = ? AND P1.cxalaf >= ? AND P1.cxalaf <= ? with ur; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 2;
  
  public PopulationRepriseStockIN0777166()
  {
    setId("IN0777166 - Decalage en double pendant et avant".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0777166 - Decalage en double pendant et avant");
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
    return "SELECT distinct P1.cxass, P1.cxalaf FROM P1200Z_PBJCNCP P1 INNER JOIN P1200Z_PBJCNCP P2 on P1.CXALAF = P2.CXALAF AND P1.CXASS = P2.CXASS WHERE (MONTH(p1.DDPJB) = MONTH(p2.DDPJB) AND YEAR(p1.DDPJB) = YEAR(p2.DDPJB) AND p1.DDPJB >= '2014-10-01') AND p1.DDPJB <> p2.DDPJB AND p1.CSNPK IN (3,7,9) AND p2.CSNPK = 1 AND p2.CSNPI = 'CT' AND P1.cxass = ? AND P1.cxalaf >= ? AND P1.cxalaf <= ? with ur; ";
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
 * Qualified Name:     PopulationRepriseStockIN0777166
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */