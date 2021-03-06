package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0825668
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "788741 - OD ASP DC avec Act. Conservee";
  private static final int PRIORITE = 760;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final String REQUETE = "SELECT ATTRIB.CXALAF, MIN(ATTRIB.DEATN) FROM P1299B_ATTRIB ATTRIB INNER JOIN P1110C_PERIODE_ACT PERIODE ON ATTRIB.CXASS = PERIODE.CXASS AND ATTRIB.CXALAF = PERIODE.CXALAF WHERE ATTRIB.CPROR = 'ASU_CVA10_02' AND ATTRIB.DFRCS >= PERIODE.PERIODE_D AND ATTRIB.DEATN <= PERIODE.PERIODE_F AND ATTRIB.DEATN >= '2014-10-01' AND ATTRIB.RSRPN = 0 AND ATTRIB.CXASS = ? AND ATTRIB.CXALAF >= ? AND ATTRIB.CXALAF <= ? GROUP BY ATTRIB.CXALAF WITH UR;";
  
  public PopulationRepriseStockIN0825668()
  {
    setId("788741 - OD ASP DC avec Act. Conservee".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("788741 - OD ASP DC avec Act. Conservee");
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
    return "SELECT ATTRIB.CXALAF, MIN(ATTRIB.DEATN) FROM P1299B_ATTRIB ATTRIB INNER JOIN P1110C_PERIODE_ACT PERIODE ON ATTRIB.CXASS = PERIODE.CXASS AND ATTRIB.CXALAF = PERIODE.CXALAF WHERE ATTRIB.CPROR = 'ASU_CVA10_02' AND ATTRIB.DFRCS >= PERIODE.PERIODE_D AND ATTRIB.DEATN <= PERIODE.PERIODE_F AND ATTRIB.DEATN >= '2014-10-01' AND ATTRIB.RSRPN = 0 AND ATTRIB.CXASS = ? AND ATTRIB.CXALAF >= ? AND ATTRIB.CXALAF <= ? GROUP BY ATTRIB.CXALAF WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockIN0825668
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */