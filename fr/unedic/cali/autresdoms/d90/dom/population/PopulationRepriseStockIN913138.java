package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN913138
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0894445 - Reprise reval";
  private static final int PRIORITE = 760;
  private static final String REQUETE = "select cxalaf, min(reprise) from( select reprise.cxalaf, reprise.cxass, reprise.deatn as reprise, max(attrib.deatn) as attrib from P1299B_ATTRIB reprise inner join P1299B_ATTRIB attrib on reprise.cxass = attrib.cxass and reprise.cxalaf = attrib.cxalaf and reprise.cxodn = attrib.cxodn and reprise.rsrpn > attrib.rsrpn where (reprise.PJICP > 0 or reprise.PJISL > 0 ) and reprise.RSRPN > 0 and reprise.CPROR like 'ASU%' and reprise.tsp >= '2015-06-04-00.00.00.000000' and reprise.cxass = ? and reprise.cxalaf >= ? and reprise.cxalaf <= ? group by reprise.cxalaf, reprise.cxass, reprise.deatn having  (reprise.deatn >= '2015-07-01' and max(attrib.deatn) < '2015-07-01') or (reprise.deatn >= '2015-01-01' and max(attrib.deatn) < '2015-01-01') or (reprise.deatn >= '2014-07-01' and max(attrib.deatn) < '2014-07-01') or (reprise.deatn >= '2013-07-01' and max(attrib.deatn) < '2013-07-01') or (reprise.deatn >= '2013-01-01' and max(attrib.deatn) < '2013-01-01') or (reprise.deatn >= '2012-07-01' and max(attrib.deatn) < '2012-07-01') or (reprise.deatn >= '2011-07-01' and max(attrib.deatn) < '2011-07-01') or (reprise.deatn >= '2010-07-01' and max(attrib.deatn) < '2010-07-01') or (reprise.deatn >= '2009-07-01' and max(attrib.deatn) < '2009-07-01') ) as t group by cxalaf with ur;";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE_REPRISE = 2;
  
  public PopulationRepriseStockIN913138()
  {
    setId("IN0894445 - Reprise reval".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0894445 - Reprise reval");
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
    return Damj.dateVersDamj(rs.getDate(2));
  }
  
  public String getRequete()
  {
    return "select cxalaf, min(reprise) from( select reprise.cxalaf, reprise.cxass, reprise.deatn as reprise, max(attrib.deatn) as attrib from P1299B_ATTRIB reprise inner join P1299B_ATTRIB attrib on reprise.cxass = attrib.cxass and reprise.cxalaf = attrib.cxalaf and reprise.cxodn = attrib.cxodn and reprise.rsrpn > attrib.rsrpn where (reprise.PJICP > 0 or reprise.PJISL > 0 ) and reprise.RSRPN > 0 and reprise.CPROR like 'ASU%' and reprise.tsp >= '2015-06-04-00.00.00.000000' and reprise.cxass = ? and reprise.cxalaf >= ? and reprise.cxalaf <= ? group by reprise.cxalaf, reprise.cxass, reprise.deatn having  (reprise.deatn >= '2015-07-01' and max(attrib.deatn) < '2015-07-01') or (reprise.deatn >= '2015-01-01' and max(attrib.deatn) < '2015-01-01') or (reprise.deatn >= '2014-07-01' and max(attrib.deatn) < '2014-07-01') or (reprise.deatn >= '2013-07-01' and max(attrib.deatn) < '2013-07-01') or (reprise.deatn >= '2013-01-01' and max(attrib.deatn) < '2013-01-01') or (reprise.deatn >= '2012-07-01' and max(attrib.deatn) < '2012-07-01') or (reprise.deatn >= '2011-07-01' and max(attrib.deatn) < '2011-07-01') or (reprise.deatn >= '2010-07-01' and max(attrib.deatn) < '2010-07-01') or (reprise.deatn >= '2009-07-01' and max(attrib.deatn) < '2009-07-01') ) as t group by cxalaf with ur;";
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
 * Qualified Name:     PopulationRepriseStockIN913138
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */