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

public class PopulationRepriseStockParametreSmic
  extends PopulationAbstraite
{
  private static final String IDENTIFIANT_POPULATION = "Rs_RevalorisationSmicJanvier2018";
  private static final int PRIORITE = 760;
  private static final Damj DATE_REEXECUTION = new Damj(2018, 1, 1);
  private static final String REQUETE = " SELECT distinct CXALAF  FROM P1200Z_PBJCNCP  where CPROD IN ('ASU_SPE02_03','ASU_SSP07_03','ASU_SPE02_04',  'ASU_SPE02_05','ASU_SSP07_04','ASU_FDS12_01','ASU_FDS12_02',  'ASU_SPE02_06', 'ASU_SSP07_05', 'ASU_FDS12_03')  AND CSNPI = 'CT'  and CXASS = ?  AND CXALAF >= ? AND CXALAF <= ?  and TSP < TO_DATE('2018-01-26 23:59:00', 'YYYY-MM-DD HH24:MI:SS')  AND DFPJB > '2017-12-31'  union(  SELECT distinct CXALAF  FROM P1200Z_PBJCNCP  where  DFPJB > '2017-12-31'  AND CSNPI = 'CT'  and CXASS = ?  AND CXALAF >= ? AND CXALAF <= ?  and TSP < TO_DATE('2018-01-26 23:59:00', 'YYYY-MM-DD HH24:MI:SS')  AND CPROD IN ('SOL_CGE01_01','SOL_ATA06_01','SOL_CPA02_01'  , 'SOL_AER05_01', 'SOL_AER05_02', 'SOL_AER05_03','SOL_SUB09_01') ) ";
  private static final int COLONNE_CXALAF = 1;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int CODE_ASSEDIC_2 = 4;
  private static final int ID_INF_2 = 5;
  private static final int ID_SUP_2 = 6;
  
  public PopulationRepriseStockParametreSmic()
  {
    setComportement(new ComportementBatchDefautMandatementAuto());
    setId("Rs_RevalorisationSmicJanvier2018".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("Rs_RevalorisationSmicJanvier2018");
    setNumeroDSMS("INC0427995");
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
    return " SELECT distinct CXALAF  FROM P1200Z_PBJCNCP  where CPROD IN ('ASU_SPE02_03','ASU_SSP07_03','ASU_SPE02_04',  'ASU_SPE02_05','ASU_SSP07_04','ASU_FDS12_01','ASU_FDS12_02',  'ASU_SPE02_06', 'ASU_SSP07_05', 'ASU_FDS12_03')  AND CSNPI = 'CT'  and CXASS = ?  AND CXALAF >= ? AND CXALAF <= ?  and TSP < TO_DATE('2018-01-26 23:59:00', 'YYYY-MM-DD HH24:MI:SS')  AND DFPJB > '2017-12-31'  union(  SELECT distinct CXALAF  FROM P1200Z_PBJCNCP  where  DFPJB > '2017-12-31'  AND CSNPI = 'CT'  and CXASS = ?  AND CXALAF >= ? AND CXALAF <= ?  and TSP < TO_DATE('2018-01-26 23:59:00', 'YYYY-MM-DD HH24:MI:SS')  AND CPROD IN ('SOL_CGE01_01','SOL_ATA06_01','SOL_CPA02_01'  , 'SOL_AER05_01', 'SOL_AER05_02', 'SOL_AER05_03','SOL_SUB09_01') ) ";
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
 * Qualified Name:     PopulationRepriseStockParametreSmic
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */