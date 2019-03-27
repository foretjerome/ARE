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

public class PopulationRepriseStockParametresRsaAta
  extends PopulationAbstraite
{
  private static final String IDENTIFIANT_POPULATION = "Parametres ATA Septembre 2017";
  private static final int PRIORITE = 760;
  private static final Damj DATE_REEXECUTION = new Damj(2017, 9, 1);
  private static final int COLONNE_CXALAF = 1;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "select distinct cxalaf from P1299C_DECISION where CPROD = 'SOL_ATA06_01'  and DATE(DEODN) > DATE('2017-08-31') and CMRJN IN (131,132,133) and CXASS = ? and CXALAF >= ? AND CXALAF <= ? WITH UR;";
  
  public PopulationRepriseStockParametresRsaAta()
  {
    setComportement(new ComportementBatchDefautMandatementAuto());
    setId("Parametres ATA Septembre 2017".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("Parametres ATA Septembre 2017");
    setNumeroDSMS("");
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
    return DATE_REEXECUTION;
  }
  
  public String getRequete()
  {
    return "select distinct cxalaf from P1299C_DECISION where CPROD = 'SOL_ATA06_01'  and DATE(DEODN) > DATE('2017-08-31') and CMRJN IN (131,132,133) and CXASS = ? and CXALAF >= ? AND CXALAF <= ? WITH UR;";
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
 * Qualified Name:     PopulationRepriseStockParametresRsaAta
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */