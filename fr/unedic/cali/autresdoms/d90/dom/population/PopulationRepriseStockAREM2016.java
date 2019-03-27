package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockAREM2016
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "16SI2 Population AREM";
  private static final Damj DATE_REEXECUTION = new Damj(2016, 5, 1);
  private static final int PRIORITE = 760;
  private static final String REQUETE = " SELECT DISTINCT CXASS, CXALAF  FROM p1200z_pbjcncp  where cprod = 'ASU_MAY17_02'  and DFPJB > '2016-5-1'  and cxass = ?  and cxalaf >= ?  and cxalaf <= ?  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 2;
  
  public PopulationRepriseStockAREM2016()
  {
    setId("16SI2 Population AREM".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("16SI2 Population AREM");
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
    return " SELECT DISTINCT CXASS, CXALAF  FROM p1200z_pbjcncp  where cprod = 'ASU_MAY17_02'  and DFPJB > '2016-5-1'  and cxass = ?  and cxalaf >= ?  and cxalaf <= ?  WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockAREM2016
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */