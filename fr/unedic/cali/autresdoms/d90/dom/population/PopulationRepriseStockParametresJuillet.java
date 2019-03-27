package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchDefautMandatementAuto;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockParametresJuillet
  extends PopulationAbstraite
{
  private static final String LIBELLE = "POP_PARAMETRES_JUILLET_DE_INSCRIT_17";
  private static final int IDENTIFIANT_POPULATION = "POP_PARAMETRES_JUILLET_DE_INSCRIT_17".hashCode();
  private static final int PRIORITE = 760;
  private static final String REQUETE = " select distinct cxalaf from P1299C_DECISION  where CPROD like 'ASU%'  and DATE(DEODN) >  DATE('2017-06-30') and CXASS= ?  and CXALAF >= ? AND CXALAF <= ? ";
  private static final int COLONNE_CXALAF = 1;
  private static final Damj DATE_REEXECUTION = new Damj(2017, 7, 1);
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  
  public PopulationRepriseStockParametresJuillet()
  {
    setComportement(new ComportementBatchDefautMandatementAuto());
    setId(IDENTIFIANT_POPULATION);
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("POP_PARAMETRES_JUILLET_DE_INSCRIT_17");
    setNumeroDSMS("1506DOR095");
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
    return " select distinct cxalaf from P1299C_DECISION  where CPROD like 'ASU%'  and DATE(DEODN) >  DATE('2017-06-30') and CXASS= ?  and CXALAF >= ? AND CXALAF <= ? ";
  }
  
  public void preparerStatement(PreparedStatement statement, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
    throws SQLException
  {
    statement.setString(1, codeAssedic);
    statement.setString(2, idInf);
    statement.setString(3, idSup);
  }
  
  public void chargerIndividu(Individu individu)
    throws ApplicativeException, TechniqueException
  {
    individu.chargerIndividuCohab();
    individu.chargerIndividuCali();
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockParametresJuillet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */