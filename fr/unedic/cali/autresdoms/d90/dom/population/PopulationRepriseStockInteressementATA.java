package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockInteressementATA
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "17SI3 - Interessement ATA";
  private static final Damj DATE_REEXECUTION = new Damj(2017, 9, 1);
  private static final int PRIORITE = 760;
  private static final String REQUETE = " SELECT DISTINCT CXASS, CXALAF  FROM P1200Z_PBJCNCP  WHERE CPROD = 'SOL_ATA06_01'  AND DFPJB > '2017-09-01'  and CXASS = ?  and CXALAF >= ?  and CXALAF <= ?  group by cxass, cxalaf  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 2;
  
  public PopulationRepriseStockInteressementATA()
  {
    setId("17SI3 - Interessement ATA".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("17SI3 - Interessement ATA");
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
    return " SELECT DISTINCT CXASS, CXALAF  FROM P1200Z_PBJCNCP  WHERE CPROD = 'SOL_ATA06_01'  AND DFPJB > '2017-09-01'  and CXASS = ?  and CXALAF >= ?  and CXALAF <= ?  group by cxass, cxalaf  WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockInteressementATA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */