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

public class PopulationRepriseStockParametresCgfCadt
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN1010299 - param CADT";
  private static final Damj DATE_REEXECUTION = new Damj(2016, 1, 1);
  private static final int PRIORITE = 760;
  private static final String REQUETE = " select distinct cxass, cxalaf  from P1200Z_PBJCNCP  where DFPJB > DATE('2015-12-31')  and (CPROD = 'CADT' or CPROD1 = 'CADT'  or CPROD2 = 'CADT' or CPROD3 = 'CADT'  or CPROD4 = 'CADT' or CPROD5 = 'CADT'  or CPROD6 = 'CADT' or CPROD7 = 'CADT')  and cxass = ?  and cxalaf >= ?  and cxalaf <= ?  group by cxass, cxalaf  with ur; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 2;
  
  public PopulationRepriseStockParametresCgfCadt()
  {
    setComportement(new ComportementBatchDefautMandatementAuto());
    setId("IN1010299 - param CADT".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN1010299 - param CADT");
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
    return " select distinct cxass, cxalaf  from P1200Z_PBJCNCP  where DFPJB > DATE('2015-12-31')  and (CPROD = 'CADT' or CPROD1 = 'CADT'  or CPROD2 = 'CADT' or CPROD3 = 'CADT'  or CPROD4 = 'CADT' or CPROD5 = 'CADT'  or CPROD6 = 'CADT' or CPROD7 = 'CADT')  and cxass = ?  and cxalaf >= ?  and cxalaf <= ?  group by cxass, cxalaf  with ur; ";
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
 * Qualified Name:     PopulationRepriseStockParametresCgfCadt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */