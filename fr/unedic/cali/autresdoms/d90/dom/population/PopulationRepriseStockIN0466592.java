package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0466592
  extends PopulationAbstraite
{
  private static final String POPULATION = "IN0466592 - Coef TP clause sauvegarde";
  private static final int COLONNE_DATE = 2;
  private static final int COLONNE_CXALAF = 1;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = " select distinct attrib.cxalaf, min(attrib.DEATN)  from P1210R_01DEMANDE demande   inner join P1299A_demande demandeP   on demande.cxass = demandeP.cxass   and demande.cxalaf = demandeP.cxalaf  and demande.dde_pivot_id = demandeP.cxnum   inner join P1299B_ATTRIB attrib   on attrib.cxass = demandeP.cxass   and attrib.cxalaf = demandeP.cxalaf   and attrib.cxnum = demandeP.cxnuma  inner join P1299C_DECISION decision  on decision.cxass = demandeP.cxass   and decision.cxalaf = demandeP.cxalaf   and decision.cxnum = demandeP.cxnumb  inner join p1110c_periode_act periode  on periode.cxass = demande.cxass  and periode.cxalaf = demande.cxalaf  inner join p1110g_origine origine   on origine.cxass = periode.cxass   and origine.cxalaf = periode.cxalaf   and origine.fk_per_activite_id = periode.per_activite_id  where attrib.CPROR = 'ASU_CSA06_05'  and demande.COEF_TMP_PARTL_DFR is null  and attrib.TXPAS < 1  and periode.type_periode = '00009'  and origine.code in ('004', '005', '071', '038')  and periode.periode_f > decision.DDRAG  and periode.periode_f < decision.DFRAG  and attrib.cxass = ?  and attrib.cxalaf >= ?  and attrib.cxalaf <= ?  group by attrib.cxalaf  with ur;";
  
  public PopulationRepriseStockIN0466592()
  {
    super("IN0466592 - Coef TP clause sauvegarde");
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
    return " select distinct attrib.cxalaf, min(attrib.DEATN)  from P1210R_01DEMANDE demande   inner join P1299A_demande demandeP   on demande.cxass = demandeP.cxass   and demande.cxalaf = demandeP.cxalaf  and demande.dde_pivot_id = demandeP.cxnum   inner join P1299B_ATTRIB attrib   on attrib.cxass = demandeP.cxass   and attrib.cxalaf = demandeP.cxalaf   and attrib.cxnum = demandeP.cxnuma  inner join P1299C_DECISION decision  on decision.cxass = demandeP.cxass   and decision.cxalaf = demandeP.cxalaf   and decision.cxnum = demandeP.cxnumb  inner join p1110c_periode_act periode  on periode.cxass = demande.cxass  and periode.cxalaf = demande.cxalaf  inner join p1110g_origine origine   on origine.cxass = periode.cxass   and origine.cxalaf = periode.cxalaf   and origine.fk_per_activite_id = periode.per_activite_id  where attrib.CPROR = 'ASU_CSA06_05'  and demande.COEF_TMP_PARTL_DFR is null  and attrib.TXPAS < 1  and periode.type_periode = '00009'  and origine.code in ('004', '005', '071', '038')  and periode.periode_f > decision.DDRAG  and periode.periode_f < decision.DFRAG  and attrib.cxass = ?  and attrib.cxalaf >= ?  and attrib.cxalaf <= ?  group by attrib.cxalaf  with ur;";
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
 * Qualified Name:     PopulationRepriseStockIN0466592
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */