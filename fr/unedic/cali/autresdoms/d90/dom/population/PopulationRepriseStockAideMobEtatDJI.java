package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockAideMobEtatDJI
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "2015D068D Persistance montants aide";
  private static final int PRIORITE = 760;
  private static final String REQUETE = " select distinct cxass, cxalaf, min(ddiam) as date_rexec  from P1201M_AIDES  WHERE cxass = ?  and cxalaf >= ?  and cxalaf <= ?  GROUP BY CXASS, CXALAF  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  
  public PopulationRepriseStockAideMobEtatDJI()
  {
    setId("2015D068D Persistance montants aide".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("2015D068D Persistance montants aide");
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
    return new Damj(Damj.dateVersDamj(rs.getDate(3)));
  }
  
  public String getRequete()
  {
    return " select distinct cxass, cxalaf, min(ddiam) as date_rexec  from P1201M_AIDES  WHERE cxass = ?  and cxalaf >= ?  and cxalaf <= ?  GROUP BY CXASS, CXALAF  WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockAideMobEtatDJI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */