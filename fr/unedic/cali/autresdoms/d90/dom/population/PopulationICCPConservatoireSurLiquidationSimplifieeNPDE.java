package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationICCPConservatoireSurLiquidationSimplifieeNPDE;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationICCPConservatoireSurLiquidationSimplifieeNPDE
  extends PopulationAbstraite
{
  public static final String POPULATION = "IN0943473 - Iccp Conserv. sur Liq. Simplifiee NPDE";
  private static final int PRIORITE = 755;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "SELECT CXALAF, MIN(DATE_HERITEE_ERE) FROM P1210R_01DEMANDE WHERE MODE_TRAITE_DEMAND = 'S' AND Q_J_DIF_ICCP_E_DFR = '1' AND Q_J_DIF_ICCP_V_DFR > 0 AND DATE_HERITEE_ERE is not null AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? GROUP BY CXALAF WITH UR;";
  
  public PopulationICCPConservatoireSurLiquidationSimplifieeNPDE()
  {
    setId("IN0943473 - Iccp Conserv. sur Liq. Simplifiee NPDE".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0943473 - Iccp Conserv. sur Liq. Simplifiee NPDE");
    setConsequenceFinanciereRecalcul(" ");
    setMaxCodeConsequenceSelection(" ");
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    ParcoursPopulationICCPConservatoireSurLiquidationSimplifieeNPDE parcours = new ParcoursPopulationICCPConservatoireSurLiquidationSimplifieeNPDE();
    
    parcours.setNomPopulation("IN0943473 - Iccp Conserv. sur Liq. Simplifiee NPDE");
    return parcours;
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return Damj.dateVersDamj(rs.getDate(2));
  }
  
  public String getRequete()
  {
    return "SELECT CXALAF, MIN(DATE_HERITEE_ERE) FROM P1210R_01DEMANDE WHERE MODE_TRAITE_DEMAND = 'S' AND Q_J_DIF_ICCP_E_DFR = '1' AND Q_J_DIF_ICCP_V_DFR > 0 AND DATE_HERITEE_ERE is not null AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? GROUP BY CXALAF WITH UR;";
  }
  
  public void preparerStatement(PreparedStatement statement, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
    throws SQLException
  {
    statement.setString(1, codeAssedic);
    statement.setString(2, idInf);
    statement.setString(3, idSup);
  }
  
  public Long getCxalaf(ResultSet rs)
    throws SQLException
  {
    return Long.valueOf(rs.getLong(1));
  }
}

/* Location:
 * Qualified Name:     PopulationICCPConservatoireSurLiquidationSimplifieeNPDE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */