package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchDefautMandatementAutoFiancementASP;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockPrimeASPFinancement
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "16SI1 Pop Financement Prime ASP";
  private static final int PRIORITE = 760;
  private static final String REQUETE = "  select distinct cxass, cxalaf, min(DEODN) as dateRexecution  from p1200Y_primencp   where CPROD = 'INR_PAR09_01' AND CDSPR = 'ET'  and cxass = ?  and cxalaf >= ?  and cxalaf <= ?  group by cxass, cxalaf  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  
  public PopulationRepriseStockPrimeASPFinancement()
  {
    setComportement(new ComportementBatchDefautMandatementAutoFiancementASP());
    setId("16SI1 Pop Financement Prime ASP".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("16SI1 Pop Financement Prime ASP");
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
    return "  select distinct cxass, cxalaf, min(DEODN) as dateRexecution  from p1200Y_primencp   where CPROD = 'INR_PAR09_01' AND CDSPR = 'ET'  and cxass = ?  and cxalaf >= ?  and cxalaf <= ?  group by cxass, cxalaf  WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockPrimeASPFinancement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */