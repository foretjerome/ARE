package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationAppelsContribCSP;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockContribsNovation
  extends PopulationAbstraite
{
  public static final String POPULATION = "APPELS_CONTRIB_CSP";
  private static final int PRIORITE = 755;
  private static final int COLONNE_DATE = 2;
  private static final int COLONNE_CXALAF = 1;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "SELECT CXALAF, min(DIEXA) FROM P1299C_DECISION WHERE CDTDC  = '47' AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND '$NCPAS' <> 'RS_CONTRIB_CSP' group by cxalaf WITH UR;";
  
  public PopulationRepriseStockContribsNovation()
  {
    setId("APPELS_CONTRIB_CSP".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("APPELS_CONTRIB_CSP");
    setConsequenceFinanciereRecalcul(" ");
    setMaxCodeConsequenceSelection(" ");
  }
  
  public Long getCxalaf(ResultSet resultSet)
    throws SQLException
  {
    return Long.valueOf(resultSet.getLong(1));
  }
  
  public Damj getDateReexecution(ResultSet resultSet, Individu individu)
    throws SQLException
  {
    return new Damj(Damj.dateVersDamj(resultSet.getDate(2)));
  }
  
  public String getRequete()
  {
    return "SELECT CXALAF, min(DIEXA) FROM P1299C_DECISION WHERE CDTDC  = '47' AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND '$NCPAS' <> 'RS_CONTRIB_CSP' group by cxalaf WITH UR;";
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
    ParcoursPopulationAppelsContribCSP parcours = new ParcoursPopulationAppelsContribCSP();
    parcours.setNomPopulation("APPELS_CONTRIB_CSP");
    return parcours;
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockContribsNovation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */