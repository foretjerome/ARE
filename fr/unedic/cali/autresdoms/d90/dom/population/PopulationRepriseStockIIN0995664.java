package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIIN0995664
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0995664 prime csp";
  private static final int PRIORITE = 755;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "select distinct d.cxalaf, MIN(d.DDCSP) from P1201N_DISPOSITIF d join P1200Z_PBJCNCP p on d.cxalaf = p.cxalaf and d.cxass = p.cxass where d.cxass = ? and d.CXALAF >= ? and d.CXALAF <= ? and p.CSNPI = 'TO' and ADD_MONTHS(d.DDCSP, 6) BETWEEN p.DDPJB and p.DFPJB group by d.cxalaf WITH UR;";
  
  public PopulationRepriseStockIIN0995664()
  {
    setId("IN0995664 prime csp".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0995664 prime csp");
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
    return "select distinct d.cxalaf, MIN(d.DDCSP) from P1201N_DISPOSITIF d join P1200Z_PBJCNCP p on d.cxalaf = p.cxalaf and d.cxass = p.cxass where d.cxass = ? and d.CXALAF >= ? and d.CXALAF <= ? and p.CSNPI = 'TO' and ADD_MONTHS(d.DDCSP, 6) BETWEEN p.DDPJB and p.DFPJB group by d.cxalaf WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockIIN0995664
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */