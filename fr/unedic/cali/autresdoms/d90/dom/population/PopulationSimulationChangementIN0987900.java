package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ContexteParcoursSimulationChangementIN0987900;
import fr.unedic.cali.parcours.ContexteParcoursSimulationChangementSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PopulationSimulationChangementIN0987900
  extends PopulationSimulationChangementAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0987900 - Ar Mayotte";
  private static final int PRIORITE = 755;
  private static final int COLONNE_CXALAF = 2;
  private static final Damj DATE_REEXECUTION = new Damj(2014, 10, 1);
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "SELECT DISTINCT CXASS, CXALAF FROM P1200Z_PBJCNCP WHERE CPROD LIKE 'ASU_MAY%' AND CSNPI = 'CT' AND DFPJB >= '2014-10-01' AND CXASS = ?  AND CXALAF >= ?  AND CXALAF <= ? WITH UR;";
  
  public PopulationSimulationChangementIN0987900()
  {
    setId("IN0987900 - Ar Mayotte".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0987900 - Ar Mayotte");
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
    return "SELECT DISTINCT CXASS, CXALAF FROM P1200Z_PBJCNCP WHERE CPROD LIKE 'ASU_MAY%' AND CSNPI = 'CT' AND DFPJB >= '2014-10-01' AND CXASS = ?  AND CXALAF >= ?  AND CXALAF <= ? WITH UR;";
  }
  
  public void preparerStatement(PreparedStatement statement, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
    throws SQLException
  {
    statement.setString(1, codeAssedic);
    statement.setString(2, idInf);
    statement.setString(3, idSup);
  }
  
  public List<ContexteParcoursSimulationChangementSpec> getListeContextesSimulation()
  {
    List<ContexteParcoursSimulationChangementSpec> listeContexte = new ArrayList();
    listeContexte.add(new ContexteParcoursSimulationChangementIN0987900());
    return listeContexte;
  }
}

/* Location:
 * Qualified Name:     PopulationSimulationChangementIN0987900
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */