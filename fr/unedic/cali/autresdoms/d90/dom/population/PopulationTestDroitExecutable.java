package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursControleAlimentationDroitExecutable;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationTestDroitExecutable
  extends PopulationAbstraite
{
  public static final String IDENTIFIANT_POPULATION = "test droit executable";
  private static final int PRIORITE = 755;
  private static final int COLONNE_CXALAF = 1;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "select CXALAF from P12A0C_01DOSEX where TYPE_CLASS in ('0754', '0762', '0759', '0761', '0861', '0915', '0999')  AND CXASS = ?  AND CXALAF >= ?  AND CXALAF <= ?  AND '$NCP_LINCP' <> 'droit executable'  WITH UR;";
  
  public PopulationTestDroitExecutable()
  {
    setId("test droit executable".hashCode());
    setNumeroDSMS("SO");
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("test droit executable");
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
    return DATE_LIMITE_NON_REEXECUTION;
  }
  
  public String getRequete()
  {
    return "select CXALAF from P12A0C_01DOSEX where TYPE_CLASS in ('0754', '0762', '0759', '0761', '0861', '0915', '0999')  AND CXASS = ?  AND CXALAF >= ?  AND CXALAF <= ?  AND '$NCP_LINCP' <> 'droit executable'  WITH UR;";
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
    return new ParcoursControleAlimentationDroitExecutable();
  }
}

/* Location:
 * Qualified Name:     PopulationTestDroitExecutable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */