package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN835924
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "Reprise de stock SM9 IN0835924";
  private static final int PRIORITE = 760;
  private static final String REQUETE = "select p.cxalaf, MIN(pivot.DIEXA) from P1110C_PERIODE_ACT p inner join P1111E_INTERRUPT i on p.cxass = i.cxass and p.cxalaf = i.cxalaf and p.interruption_id = i.interruption_id inner join ( select d1.cxass, d1.cxalaf, d1.DIEXA, max(d2.DFCTO) as FGD from P1299C_DECISION d1 inner join P1299C_DECISION d2 on d1.cxass = d2.cxass and d1.cxalaf = d2.cxalaf and d1.cxnum <> d2.cxnum where d1.DIEXA >= '2014-10-01' and d1.CDTDC in(3, 13, 14, 15, 27) and d2.CDTDC in(7, 8, 10, 11, 12, 13, 14, 15, 3, 27, 21,  22, 44, 23, 26, 30, 38, 39, 41, 42, 43, 40, 32, 45) and d1.CPROD in('ASU_CGE01_02', 'ASU_CGE01_03', 'ASU_CGE01_04', 'ASU_CSA06_03', 'ASU_CSA06_02') and d1.DIEXA > d2.DFCTO and d1.cxass = ? and d1.cxalaf >= ? and d1.cxalaf <= ? group by d1.cxass, d1.cxalaf, d1.DIEXA ) as pivot on pivot.cxass = p.cxass and pivot.cxalaf = p.cxalaf and pivot.DIEXA > p.periode_f and pivot.FGD < p.periode_f where  i.motif_rupture = '019' and p.cxass = ? and p.cxalaf >= ? and p.cxalaf <= ? group by p.cxalaf with ur;";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int CODE_ASSEDIC_2 = 4;
  private static final int ID_INF_2 = 5;
  private static final int ID_SUP_2 = 6;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE_REPRISE = 2;
  
  public PopulationRepriseStockIN835924()
  {
    setId("Reprise de stock SM9 IN0835924".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("Reprise de stock SM9 IN0835924");
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
    return Damj.dateVersDamj(rs.getDate(2));
  }
  
  public String getRequete()
  {
    return "select p.cxalaf, MIN(pivot.DIEXA) from P1110C_PERIODE_ACT p inner join P1111E_INTERRUPT i on p.cxass = i.cxass and p.cxalaf = i.cxalaf and p.interruption_id = i.interruption_id inner join ( select d1.cxass, d1.cxalaf, d1.DIEXA, max(d2.DFCTO) as FGD from P1299C_DECISION d1 inner join P1299C_DECISION d2 on d1.cxass = d2.cxass and d1.cxalaf = d2.cxalaf and d1.cxnum <> d2.cxnum where d1.DIEXA >= '2014-10-01' and d1.CDTDC in(3, 13, 14, 15, 27) and d2.CDTDC in(7, 8, 10, 11, 12, 13, 14, 15, 3, 27, 21,  22, 44, 23, 26, 30, 38, 39, 41, 42, 43, 40, 32, 45) and d1.CPROD in('ASU_CGE01_02', 'ASU_CGE01_03', 'ASU_CGE01_04', 'ASU_CSA06_03', 'ASU_CSA06_02') and d1.DIEXA > d2.DFCTO and d1.cxass = ? and d1.cxalaf >= ? and d1.cxalaf <= ? group by d1.cxass, d1.cxalaf, d1.DIEXA ) as pivot on pivot.cxass = p.cxass and pivot.cxalaf = p.cxalaf and pivot.DIEXA > p.periode_f and pivot.FGD < p.periode_f where  i.motif_rupture = '019' and p.cxass = ? and p.cxalaf >= ? and p.cxalaf <= ? group by p.cxalaf with ur;";
  }
  
  public void preparerStatement(PreparedStatement statement, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
    throws SQLException
  {
    statement.setString(1, codeAssedic);
    statement.setString(2, idInf);
    statement.setString(3, idSup);
    statement.setString(4, codeAssedic);
    statement.setString(5, idInf);
    statement.setString(6, idSup);
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockIN835924
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */