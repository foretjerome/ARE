package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN1035173
  extends PopulationAbstraite
{
  private static final String POPULATION = "IN895426 - reprise suite arce a tort";
  private static final int COLONNE_DATE = 2;
  private static final int COLONNE_CXALAF = 1;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = " select demande.cxalaf, min(decision.diexa)  from P1270L_07DOSSEXAM dosex  inner join P1270J_07DOSSAFF dosaf  on dosaf.cxass = dosex.cxass  and dosaf.cxalaf = dosex.cxalaf  and dosaf.dosexpc_id = dosex.dossexam_id  inner join P1270F_07DEMANDE demande  on demande.cxass = dosaf.cxass  and demande.cxalaf = dosaf.cxalaf  and demande.demande_id = dosaf.dde_inr_id  inner join P1110C_PERIODE_ACT periode  on periode.cxass = demande.cxass  and periode.cxalaf = demande.cxalaf  and periode.per_activite_id = demande.id_activite_liee  inner join P1299C_DECISION decision  on decision.cxass = demande.cxass  and decision.cxalaf = demande.cxalaf  and decision.diexa >= periode.periode_d  and decision.diexa <= periode.periode_f  where decision.diexa >= '2014-10-01'  and decision.cprod like 'ASU%'  and decision.CDTDC not in (10, 11, 12, 26)  and demande.cxass = ?  and demande.cxalaf >= ?  and demande.cxalaf <= ?  group by demande.cxalaf  with ur;";
  
  public PopulationRepriseStockIN1035173()
  {
    super("IN895426 - reprise suite arce a tort");
  }
  
  public Long getCxalaf(ResultSet resultSet)
    throws SQLException
  {
    return Long.valueOf(resultSet.getLong(1));
  }
  
  public Damj getDateReexecution(ResultSet resultSet, Individu individu)
    throws SQLException
  {
    return new Damj(Damj.dateVersDamj(resultSet.getDate(2)));
  }
  
  public String getRequete()
  {
    return " select demande.cxalaf, min(decision.diexa)  from P1270L_07DOSSEXAM dosex  inner join P1270J_07DOSSAFF dosaf  on dosaf.cxass = dosex.cxass  and dosaf.cxalaf = dosex.cxalaf  and dosaf.dosexpc_id = dosex.dossexam_id  inner join P1270F_07DEMANDE demande  on demande.cxass = dosaf.cxass  and demande.cxalaf = dosaf.cxalaf  and demande.demande_id = dosaf.dde_inr_id  inner join P1110C_PERIODE_ACT periode  on periode.cxass = demande.cxass  and periode.cxalaf = demande.cxalaf  and periode.per_activite_id = demande.id_activite_liee  inner join P1299C_DECISION decision  on decision.cxass = demande.cxass  and decision.cxalaf = demande.cxalaf  and decision.diexa >= periode.periode_d  and decision.diexa <= periode.periode_f  where decision.diexa >= '2014-10-01'  and decision.cprod like 'ASU%'  and decision.CDTDC not in (10, 11, 12, 26)  and demande.cxass = ?  and demande.cxalaf >= ?  and demande.cxalaf <= ?  group by demande.cxalaf  with ur;";
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
 * Qualified Name:     PopulationRepriseStockIN1035173
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */