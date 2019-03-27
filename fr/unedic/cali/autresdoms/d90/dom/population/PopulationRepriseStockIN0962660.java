package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0962660
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0962660 Rang Enquete DV Fil Eau";
  private static final int PRIORITE = 760;
  private static final String REQUETE = "select distinct CXASS, CXALAF, MIN(DESIQ) from P1201A_ENQUETENCP where CST2Q = 37 AND NSRAQ >= 1 AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? GROUP BY CXASS, CXALAF WITH UR;";
  private static final int CODE_ASSEDIC_1 = 1;
  private static final int ID_INF_1 = 2;
  private static final int ID_SUP_1 = 3;
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  
  public PopulationRepriseStockIN0962660()
  {
    setId("IN0962660 Rang Enquete DV Fil Eau".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0962660 Rang Enquete DV Fil Eau");
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
    return "select distinct CXASS, CXALAF, MIN(DESIQ) from P1201A_ENQUETENCP where CST2Q = 37 AND NSRAQ >= 1 AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? GROUP BY CXASS, CXALAF WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockIN0962660
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */