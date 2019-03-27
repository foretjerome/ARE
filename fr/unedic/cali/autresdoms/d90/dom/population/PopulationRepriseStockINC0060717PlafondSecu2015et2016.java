package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchDefautMandatementAuto;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockINC0060717PlafondSecu2015et2016
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "ASP plafond secu 2015";
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "select distinct cxass, cxalaf, min(DDPJB) as date  from p1200z_pbjcncp  where cprod = 'ASU_CVA10_03' and QMJSK1 >= 225.12 and DFPJB > '2015-01-01' and CXASS = ? and CXALAF >= ? AND CXALAF <= ? group by cxass, cxalaf WITH UR;";
  
  public PopulationRepriseStockINC0060717PlafondSecu2015et2016()
  {
    super("ASP plafond secu 2015");
    setComportement(new ComportementBatchDefautMandatementAuto());
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
    return "select distinct cxass, cxalaf, min(DDPJB) as date  from p1200z_pbjcncp  where cprod = 'ASU_CVA10_03' and QMJSK1 >= 225.12 and DFPJB > '2015-01-01' and CXASS = ? and CXALAF >= ? AND CXALAF <= ? group by cxass, cxalaf WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockINC0060717PlafondSecu2015et2016
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */