package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStock1006275
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN1006275 - admission post revision admission";
  private static final String REQUETE = "SELECT distinct ADM.CXALAF, ADM.DEODN FROM P1299C_DECISION ADM inner join P1299C_DECISION REV on ADM.CXASS = REV.CXASS and ADM.CXALAF = REV.CXALAF AND ADM.DIEXA > REV.DIEXA WHERE ADM.CDTDC in (10,11,12,26) and REV.CDTDC = 45 and exists ( select M.champs_application FROM P1110C_PERIODE_ACT P join P1111A_METIER M on M.cxass = p.cxass and M.cxalaf = p.cxalaf and M.fk_per_activite_id = p.per_activite_id where ADM.DDRAG <= P.periode_f and  ADM.DFRAG <= P.periode_f and P.cxass = ADM.cxass and P.cxalaf = ADM.cxalaf group by M.champs_application having count(*) > 1) and ADM.cxass= ?  AND ADM.CXALAF >= ? AND ADM.CXALAF <= ? WITH UR;";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE_REEXECUTION = 2;
  
  public PopulationRepriseStock1006275()
  {
    super("IN1006275 - admission post revision admission");
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
    return "SELECT distinct ADM.CXALAF, ADM.DEODN FROM P1299C_DECISION ADM inner join P1299C_DECISION REV on ADM.CXASS = REV.CXASS and ADM.CXALAF = REV.CXALAF AND ADM.DIEXA > REV.DIEXA WHERE ADM.CDTDC in (10,11,12,26) and REV.CDTDC = 45 and exists ( select M.champs_application FROM P1110C_PERIODE_ACT P join P1111A_METIER M on M.cxass = p.cxass and M.cxalaf = p.cxalaf and M.fk_per_activite_id = p.per_activite_id where ADM.DDRAG <= P.periode_f and  ADM.DFRAG <= P.periode_f and P.cxass = ADM.cxass and P.cxalaf = ADM.cxalaf group by M.champs_application having count(*) > 1) and ADM.cxass= ?  AND ADM.CXALAF >= ? AND ADM.CXALAF <= ? WITH UR;";
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
 * Qualified Name:     PopulationRepriseStock1006275
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */