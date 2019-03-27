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

public class PopulationRepriseStockParametresJanvierPrr
  extends PopulationAbstraite
{
  private static final String IDENTIFIANT_POPULATION = "Parametres PreRetraite Janvier 2018";
  private static final int PRIORITE = 760;
  private static final Damj DATE_REEXECUTION = new Damj(2018, 1, 1);
  private static final String REQUETE = "select distinct cxass, cxalaf from p1200z_pbjcncp where CPROD = 'PRR_PRL02_01' and CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND QMRSQ >= 107.47 AND DDPJB >= '2018-01-01' ";
  private static final int COLONNE_CXALAF = 2;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  
  public PopulationRepriseStockParametresJanvierPrr()
  {
    setComportement(new ComportementBatchDefautMandatementAuto());
    setId("Parametres PreRetraite Janvier 2018".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("Parametres PreRetraite Janvier 2018");
    setNumeroDSMS("INC0427995");
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
    return "select distinct cxass, cxalaf from p1200z_pbjcncp where CPROD = 'PRR_PRL02_01' and CXASS = ? AND CXALAF >= ? AND CXALAF <= ? AND QMRSQ >= 107.47 AND DDPJB >= '2018-01-01' ";
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
 * Qualified Name:     PopulationRepriseStockParametresJanvierPrr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */