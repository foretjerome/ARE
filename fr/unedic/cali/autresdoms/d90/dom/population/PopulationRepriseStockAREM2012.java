package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockAREM2012
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0062977 reprise AREM2012";
  private static final int PRIORITE = 760;
  private static final String REQUETE = " SELECT DISTINCT p.CXASS, p.CXALAF, min(p.DDPJB)  from P1200Z_PBJCNCP p  where p.cprod = 'ASU_MAY17_02'  and p.DDPJB >= '2015-01-01'  and p.CXASS = ?  and p.QMRSQ >= 46.06  and p.cxalaf >= ?  and p.cxalaf <= ?  group by p.cxass, p.cxalaf  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  
  public PopulationRepriseStockAREM2012()
  {
    setId("IN0062977 reprise AREM2012".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0062977 reprise AREM2012");
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
    return " SELECT DISTINCT p.CXASS, p.CXALAF, min(p.DDPJB)  from P1200Z_PBJCNCP p  where p.cprod = 'ASU_MAY17_02'  and p.DDPJB >= '2015-01-01'  and p.CXASS = ?  and p.QMRSQ >= 46.06  and p.cxalaf >= ?  and p.cxalaf <= ?  group by p.cxass, p.cxalaf  WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockAREM2012
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */