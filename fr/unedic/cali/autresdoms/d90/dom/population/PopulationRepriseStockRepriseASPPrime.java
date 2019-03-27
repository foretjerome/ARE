package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockRepriseASPPrime
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "16SI2 reprise ASP suite imputation prime";
  private static final int PRIORITE = 760;
  private static final String REQUETE = " SELECT DISTINCT ASP.CXASS, ASP.CXALAF, min(PRIME.DATE_ATTRIB)   from P1210R_01DEMANDE asp  inner join P1200Q_CONTEXTE ctx  on asp.cxass = ctx.cxass  and asp.cxalaf = ctx.cxalaf  and asp.demande_id = ctx.fk_demande_id  and ctx.type_contexte = 'ASPPOSTPRI'  inner join P1299A_demande dRepriseASP  on asp.cxass = dRepriseASP.cxass  and asp.cxalaf = dRepriseASP.cxalaf  and asp.dde_pivot_id = dRepriseASP.cxnum  inner join P1299C_decision dcRepriseASP  on dcRepriseASP.cxass = dRepriseASP.cxass  and dcRepriseASP.cxalaf = dRepriseASP.cxalaf  and dcRepriseASP.cxnum = dRepriseASP.cxnumb  inner join P1299B_attrib aRepriseASP  on aRepriseASP.cxass = dRepriseASP.cxass  and aRepriseASP.cxalaf = dRepriseASP.cxalaf  and aRepriseASP.cxnum = dRepriseASP.cxnuma  inner join P1275C_070901CEP prime  on prime.cxass = dRepriseASP.cxass  and prime.cxalaf = dRepriseASP.cxalaf  and prime.date_attrib <= aRepriseASP.DEATN  where aRepriseASP.CPROR = 'ASU_CVA10_03'  and dcRepriseASP.CDTDC in (13, 14, 15, 27, 34) and ASP.cxass = ?  and ASP.cxalaf >= ?  and ASP.cxalaf <= ?  group by asp.cxass, asp.cxalaf  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  
  public PopulationRepriseStockRepriseASPPrime()
  {
    setId("16SI2 reprise ASP suite imputation prime".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("16SI2 reprise ASP suite imputation prime");
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
    return " SELECT DISTINCT ASP.CXASS, ASP.CXALAF, min(PRIME.DATE_ATTRIB)   from P1210R_01DEMANDE asp  inner join P1200Q_CONTEXTE ctx  on asp.cxass = ctx.cxass  and asp.cxalaf = ctx.cxalaf  and asp.demande_id = ctx.fk_demande_id  and ctx.type_contexte = 'ASPPOSTPRI'  inner join P1299A_demande dRepriseASP  on asp.cxass = dRepriseASP.cxass  and asp.cxalaf = dRepriseASP.cxalaf  and asp.dde_pivot_id = dRepriseASP.cxnum  inner join P1299C_decision dcRepriseASP  on dcRepriseASP.cxass = dRepriseASP.cxass  and dcRepriseASP.cxalaf = dRepriseASP.cxalaf  and dcRepriseASP.cxnum = dRepriseASP.cxnumb  inner join P1299B_attrib aRepriseASP  on aRepriseASP.cxass = dRepriseASP.cxass  and aRepriseASP.cxalaf = dRepriseASP.cxalaf  and aRepriseASP.cxnum = dRepriseASP.cxnuma  inner join P1275C_070901CEP prime  on prime.cxass = dRepriseASP.cxass  and prime.cxalaf = dRepriseASP.cxalaf  and prime.date_attrib <= aRepriseASP.DEATN  where aRepriseASP.CPROR = 'ASU_CVA10_03'  and dcRepriseASP.CDTDC in (13, 14, 15, 27, 34) and ASP.cxass = ?  and ASP.cxalaf >= ?  and ASP.cxalaf <= ?  group by asp.cxass, asp.cxalaf  WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockRepriseASPPrime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */