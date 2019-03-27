package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationNeutralisationIndusForcageDecalage;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockNeutralisationIndus
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "Neutralisation indus suite IN1020177";
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "select d.cxass, d.cxalaf, min(annee || mois) from p1297k_deltamt d inner join p1297a_individu i on d.cxass = i.cxass and d.cxalaf = i.cxalaf and d.code_population = i.code_population and d.fk_fonct_rapp_id = i.fk_fonct_rapp_id where d.tsp > TO_DATE('2016-05-27 18:00:00', 'YYYY-MM-DD HH24:MI:SS') and d.code_population = 1142011421 and montant_avant <> montant_apres and delta_mt_brut < 0 and d.cxass = ? AND d.CXALAF >= ?  AND d.CXALAF <= ? group by d.cxass, d.cxalaf with ur;";
  
  public PopulationRepriseStockNeutralisationIndus()
  {
    setId("Neutralisation indus suite IN1020177".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("Neutralisation indus suite IN1020177");
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
    String dateString = rs.getString(3);
    String year = dateString.substring(0, 4);
    String mois = dateString.substring(4, dateString.length());
    
    int nombreJourMois = Damj.getNbJoursMois(Integer.valueOf(mois).intValue(), Integer.valueOf(year).intValue());
    
    Damj res = new Damj(Integer.valueOf(year).intValue(), Integer.valueOf(mois).intValue(), nombreJourMois);
    
    return res;
  }
  
  public String getRequete()
  {
    return "select d.cxass, d.cxalaf, min(annee || mois) from p1297k_deltamt d inner join p1297a_individu i on d.cxass = i.cxass and d.cxalaf = i.cxalaf and d.code_population = i.code_population and d.fk_fonct_rapp_id = i.fk_fonct_rapp_id where d.tsp > TO_DATE('2016-05-27 18:00:00', 'YYYY-MM-DD HH24:MI:SS') and d.code_population = 1142011421 and montant_avant <> montant_apres and delta_mt_brut < 0 and d.cxass = ? AND d.CXALAF >= ?  AND d.CXALAF <= ? group by d.cxass, d.cxalaf with ur;";
  }
  
  public void preparerStatement(PreparedStatement statement, String assedic, String inf, String sup, ContexteService service)
    throws SQLException
  {
    statement.setString(1, assedic);
    statement.setString(2, inf);
    statement.setString(3, sup);
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationNeutralisationIndusForcageDecalage();
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockNeutralisationIndus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */