package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0950061
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "16SI1 Population differe ICCP";
  private static final int PRIORITE = 760;
  private static final String REQUETE = " SELECT DISTINCT PBJC.CXASS, PBJC.CXALAF, MIN(PBJC.DDPJB)  from (  select cep.cxass as CXASS,  cep.cxalaf as CXALAF,  cep.DATE_ATTRIB_CTDAT as DATE_ATTRIBUTION,  cep.NB_JRS_ICCP_CTDL as ICCP  from P12A0C_01DOSEX dosex  inner join P12A0N_01CEP_ADM cep  on cep.cxass = dosex.cxass  and cep.cxalaf = dosex.cxalaf  and cep.cep_id = dosex.cepa_id  where dosex.nature_decision in ('45','44', '26', '12', '11', '10')  union  select cep.cxass as CXASS,  cep.cxalaf as CXALAF,  cep.DATE_ATTRIB_CTDAT as DATE_ATTRIBUTION,  cep.NB_JRS_ICCP_CTDL as ICCP  from P12A0C_01DOSEX dosex  inner join P12A0P_01CEP_REP cep  on cep.cxass = dosex.cxass  and cep.cxalaf = dosex.cxalaf  and cep.cep_id = dosex.cepr_id  where dosex.nature_decision in ('49', '13', '14', '15', '27')  union  select cep.cxass as CXASS,  cep.cxalaf as CXALAF,  cep.DATE_ATTRIB_CTDAT as DATE_ATTRIBUTION,  cep.NB_JRS_ICCP_CTDL as ICCP  from P12A0C_01DOSEX dosex  inner join P12A0Q_01CEP_REV cep  on cep.cxass = dosex.cxass  and cep.cxalaf = dosex.cxalaf  and cep.cep_id = dosex.CEPREV_ID  where dosex.nature_decision in ('30')  ) as T inner join P1200Z_PBJCNCP PBJC  on PBJC.cxass = T.cxass  and PBJC.cxalaf = T.cxalaf  where DATE_ATTRIBUTION >= '2014-10-01'  and DATE_ATTRIBUTION > PBJC.DFPJB  and ICCP > 0  and pbjc.CSNPK = 9  and pbjc.PSDEN > 0  and PBJC.cxass = ?  and PBJC.cxalaf >= ?  and PBJC.cxalaf <= ?  group by PBJC.CXASS, PBJC.CXALAF  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  
  public PopulationRepriseStockIN0950061()
  {
    setId("16SI1 Population differe ICCP".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("16SI1 Population differe ICCP");
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
    return " SELECT DISTINCT PBJC.CXASS, PBJC.CXALAF, MIN(PBJC.DDPJB)  from (  select cep.cxass as CXASS,  cep.cxalaf as CXALAF,  cep.DATE_ATTRIB_CTDAT as DATE_ATTRIBUTION,  cep.NB_JRS_ICCP_CTDL as ICCP  from P12A0C_01DOSEX dosex  inner join P12A0N_01CEP_ADM cep  on cep.cxass = dosex.cxass  and cep.cxalaf = dosex.cxalaf  and cep.cep_id = dosex.cepa_id  where dosex.nature_decision in ('45','44', '26', '12', '11', '10')  union  select cep.cxass as CXASS,  cep.cxalaf as CXALAF,  cep.DATE_ATTRIB_CTDAT as DATE_ATTRIBUTION,  cep.NB_JRS_ICCP_CTDL as ICCP  from P12A0C_01DOSEX dosex  inner join P12A0P_01CEP_REP cep  on cep.cxass = dosex.cxass  and cep.cxalaf = dosex.cxalaf  and cep.cep_id = dosex.cepr_id  where dosex.nature_decision in ('49', '13', '14', '15', '27')  union  select cep.cxass as CXASS,  cep.cxalaf as CXALAF,  cep.DATE_ATTRIB_CTDAT as DATE_ATTRIBUTION,  cep.NB_JRS_ICCP_CTDL as ICCP  from P12A0C_01DOSEX dosex  inner join P12A0Q_01CEP_REV cep  on cep.cxass = dosex.cxass  and cep.cxalaf = dosex.cxalaf  and cep.cep_id = dosex.CEPREV_ID  where dosex.nature_decision in ('30')  ) as T inner join P1200Z_PBJCNCP PBJC  on PBJC.cxass = T.cxass  and PBJC.cxalaf = T.cxalaf  where DATE_ATTRIBUTION >= '2014-10-01'  and DATE_ATTRIBUTION > PBJC.DFPJB  and ICCP > 0  and pbjc.CSNPK = 9  and pbjc.PSDEN > 0  and PBJC.cxass = ?  and PBJC.cxalaf >= ?  and PBJC.cxalaf <= ?  group by PBJC.CXASS, PBJC.CXALAF  WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockIN0950061
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */