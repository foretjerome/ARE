package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationAbonnementGAEC;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockSM9IN1001500
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0998891 - primo NPDE non abonné a GAEC";
  private static final int PRIORITE = 760;
  private static final String REQUETE = "  select i.cxalaf from P1299C_DECISION deci, P1299A_DEMANDE demP, P1210R_01DEMANDE dem, P1200A_individu i WHERE dem.cxass=i.cxass and dem.cxalaf=i.CXALAF and dem.cxass=demP.cxass and dem.cxalaf=demP.CXALAF and demP.CXNUM=dem.DDE_PIVOT_ID and deci.cxass=demP.cxass and deci.cxalaf=demP.CXALAF and dem.MODE_TRAITE_DEMAND='A' and deci.CDTDC is not null and deci.CDTDC <> 0 and i.est_abonne_gaec = 0 and i.CXASS = ? AND i.CXALAF >= ? AND i.CXALAF <= ? group by i.cxalaf; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  
  public PopulationRepriseStockSM9IN1001500()
  {
    setId("IN0998891 - primo NPDE non abonné a GAEC".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0998891 - primo NPDE non abonné a GAEC");
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
    return PopulationSpec.DATE_LIMITE_NON_REEXECUTION;
  }
  
  public String getRequete()
  {
    return "  select i.cxalaf from P1299C_DECISION deci, P1299A_DEMANDE demP, P1210R_01DEMANDE dem, P1200A_individu i WHERE dem.cxass=i.cxass and dem.cxalaf=i.CXALAF and dem.cxass=demP.cxass and dem.cxalaf=demP.CXALAF and demP.CXNUM=dem.DDE_PIVOT_ID and deci.cxass=demP.cxass and deci.cxalaf=demP.CXALAF and dem.MODE_TRAITE_DEMAND='A' and deci.CDTDC is not null and deci.CDTDC <> 0 and i.est_abonne_gaec = 0 and i.CXASS = ? AND i.CXALAF >= ? AND i.CXALAF <= ? group by i.cxalaf; ";
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
    return new ParcoursPopulationAbonnementGAEC();
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockSM9IN1001500
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */