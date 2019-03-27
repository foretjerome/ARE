package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockDemandeExpresseSpectaclePNDS
  extends PopulationAbstraite
{
  private static final String LIBELLE = "INC0366553 - Demande Expresse Spectacle PNDS";
  private static final String REQUETE = "SELECT CXALAF, MIN(DIEXA)  FROM P1299C_DECISION WHERE CDEXA1 = '8' AND CPROD LIKE 'ASU_SPE%' AND DIEXA > '2017-06-30' AND CMRJN = 0 AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? GROUP BY CXALAF WITH UR;";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  
  public PopulationRepriseStockDemandeExpresseSpectaclePNDS()
  {
    super("INC0366553 - Demande Expresse Spectacle PNDS");
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return Damj.dateVersDamj(rs.getDate(2));
  }
  
  public String getRequete()
  {
    return "SELECT CXALAF, MIN(DIEXA)  FROM P1299C_DECISION WHERE CDEXA1 = '8' AND CPROD LIKE 'ASU_SPE%' AND DIEXA > '2017-06-30' AND CMRJN = 0 AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? GROUP BY CXALAF WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockDemandeExpresseSpectaclePNDS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */