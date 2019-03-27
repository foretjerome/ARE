package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockASP
  extends PopulationAbstraite
{
  private static final String POPULATION = "ALONGEMENT_CSP_PNDS";
  private static final int PRIORITE = 755;
  private static final int COLONNE_DATE = 2;
  private static final int COLONNE_CXALAF = 1;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "select cxalaf, min(DEATN) from P1299B_ATTRIB where ((CPROR in ('ASU_CVA10_02', 'ASU_CVA10_03') and DEATN >= '2015-02-01') OR  (CPROR in ('ASU_CAA14_02', 'ASU_CAA14_03') and DEATN >= '2014-10-01')) AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND '$NCPAS' <> 'RS_CSP_2015SI3' group by cxalaf with ur;";
  
  public PopulationRepriseStockASP()
  {
    setId("ALONGEMENT_CSP_PNDS".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("ALONGEMENT_CSP_PNDS");
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
    return "select cxalaf, min(DEATN) from P1299B_ATTRIB where ((CPROR in ('ASU_CVA10_02', 'ASU_CVA10_03') and DEATN >= '2015-02-01') OR  (CPROR in ('ASU_CAA14_02', 'ASU_CAA14_03') and DEATN >= '2014-10-01')) AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND '$NCPAS' <> 'RS_CSP_2015SI3' group by cxalaf with ur;";
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
 * Qualified Name:     PopulationRepriseStockASP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */