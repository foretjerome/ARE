package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationDateDepartICCPConservatoire;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0890524
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "890524 - Blocage ICCP Conservatoire";
  private static final int PRIORITE = 760;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  private static final String REQUETE = "SELECT dmd.CXASS, dmd.CXALAF, attrib.DEATN FROM P1210R_01DEMANDE dmd INNER JOIN P1299A_DEMANDE pivot ON dmd.CXASS = pivot.CXASS AND dmd.CXALAF = pivot.CXALAF AND dmd.DDE_PIVOT_ID = pivot.CXNUM INNER JOIN P1299B_ATTRIB attrib ON pivot.CXASS = attrib.CXASS AND pivot.CXALAF = attrib.CXALAF AND pivot.CXNUMA = attrib.CXNUM INNER JOIN P1296B_ENTRETIEN entretien ON dmd.CXASS = entretien.CXASS AND dmd.CXALAF = entretien.CXALAF AND dmd.ENTRETIEN_ID = entretien.ENTRETIEN_ID WHERE dmd.Q_J_DIF_ICCP_V_DFR is not null AND dmd.Q_J_DIF_ICCP_V_DFR > 0 AND dmd.Q_J_DIF_ICCP_E_DFR = 1 AND dmd.DT_DEPART_ICCP_DFR is null AND entretien.DATE_FIN_CT > attrib.DEATN AND dmd.CXASS = ? AND dmd.CXALAF >= ? AND dmd.CXALAF <= ? WITH UR;";
  
  public PopulationRepriseStockIN0890524()
  {
    setId("890524 - Blocage ICCP Conservatoire".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("890524 - Blocage ICCP Conservatoire");
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
    return "SELECT dmd.CXASS, dmd.CXALAF, attrib.DEATN FROM P1210R_01DEMANDE dmd INNER JOIN P1299A_DEMANDE pivot ON dmd.CXASS = pivot.CXASS AND dmd.CXALAF = pivot.CXALAF AND dmd.DDE_PIVOT_ID = pivot.CXNUM INNER JOIN P1299B_ATTRIB attrib ON pivot.CXASS = attrib.CXASS AND pivot.CXALAF = attrib.CXALAF AND pivot.CXNUMA = attrib.CXNUM INNER JOIN P1296B_ENTRETIEN entretien ON dmd.CXASS = entretien.CXASS AND dmd.CXALAF = entretien.CXALAF AND dmd.ENTRETIEN_ID = entretien.ENTRETIEN_ID WHERE dmd.Q_J_DIF_ICCP_V_DFR is not null AND dmd.Q_J_DIF_ICCP_V_DFR > 0 AND dmd.Q_J_DIF_ICCP_E_DFR = 1 AND dmd.DT_DEPART_ICCP_DFR is null AND entretien.DATE_FIN_CT > attrib.DEATN AND dmd.CXASS = ? AND dmd.CXALAF >= ? AND dmd.CXALAF <= ? WITH UR;";
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
    return new ParcoursPopulationDateDepartICCPConservatoire();
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockIN0890524
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */