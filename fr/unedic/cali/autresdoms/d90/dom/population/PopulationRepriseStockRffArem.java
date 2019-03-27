package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockRffArem
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "16SI2 RFF Mayotte";
  private static final int PRIORITE = 760;
  private static final String REQUETE = " SELECT ERE.CXALAF, MIN(ERE.DATE_HERITEE)  FROM P1202A_ACTIONFORM FORMATION  INNER JOIN P1281A_080301DOSEX DOSEX  ON FORMATION.CXASS = DOSEX.CXASS  AND FORMATION.CXALAF = DOSEX.CXALAF  AND FORMATION.ACTION_FORM_ID = DOSEX.ACTION_FORM_ID  INNER JOIN P1280B_08DOSAF DOSAF  ON DOSEX.CXALAF = DOSAF.CXALAF  AND DOSEX.CXASS = DOSAF.CXASS  AND DOSEX.DOSS_AFFECT_ID = DOSAF.DOSS_AFFECT_ID  INNER JOIN P1280A_08DEMANDE DEMANDE  ON DOSAF.CXALAF = DEMANDE.CXALAF  AND DOSAF.CXASS = DEMANDE.CXASS  AND DOSAF.DOSS_AFFECT_ID = DEMANDE.DOSS_AFFECT_ID  INNER JOIN P1280F_08EVTREFEXA ERE  ON DEMANDE.CXASS = ERE.CXASS  AND DEMANDE.CXALAF = ERE.CXALAF  AND DEMANDE.EVT_REF_EXA_ID = ERE.EVT_REF_EXA_ID  INNER JOIN P1299C_DECISION DEC_PREC  on DEC_PREC.cxass = ere.cxass  and DEC_PREC.cxalaf = ere.cxalaf  and DEC_PREC.diexa < ere.date_heritee  WHERE DOSEX.TYPE_CLASS = '0195' AND FORMATION.DATE_PRESCRIPTION >= '2016-01-01'  and DEC_PREC.DIEXA = (  select max(diexa) from p1299c_decision  where cxass = ere.cxass  and cxalaf = ere.cxalaf  and diexa < ere.date_heritee  )  and DEC_PREC.CPROD = 'ASU_MAY17_02'  and ERE.CXASS = ?  and ERE.CXALAF >= ?  and ERE.CXALAF <= ?  group by ere.cxalaf  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  
  public PopulationRepriseStockRffArem()
  {
    setId("16SI2 RFF Mayotte".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("16SI2 RFF Mayotte");
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
    return new Damj(Damj.dateVersDamj(rs.getDate(2)));
  }
  
  public String getRequete()
  {
    return " SELECT ERE.CXALAF, MIN(ERE.DATE_HERITEE)  FROM P1202A_ACTIONFORM FORMATION  INNER JOIN P1281A_080301DOSEX DOSEX  ON FORMATION.CXASS = DOSEX.CXASS  AND FORMATION.CXALAF = DOSEX.CXALAF  AND FORMATION.ACTION_FORM_ID = DOSEX.ACTION_FORM_ID  INNER JOIN P1280B_08DOSAF DOSAF  ON DOSEX.CXALAF = DOSAF.CXALAF  AND DOSEX.CXASS = DOSAF.CXASS  AND DOSEX.DOSS_AFFECT_ID = DOSAF.DOSS_AFFECT_ID  INNER JOIN P1280A_08DEMANDE DEMANDE  ON DOSAF.CXALAF = DEMANDE.CXALAF  AND DOSAF.CXASS = DEMANDE.CXASS  AND DOSAF.DOSS_AFFECT_ID = DEMANDE.DOSS_AFFECT_ID  INNER JOIN P1280F_08EVTREFEXA ERE  ON DEMANDE.CXASS = ERE.CXASS  AND DEMANDE.CXALAF = ERE.CXALAF  AND DEMANDE.EVT_REF_EXA_ID = ERE.EVT_REF_EXA_ID  INNER JOIN P1299C_DECISION DEC_PREC  on DEC_PREC.cxass = ere.cxass  and DEC_PREC.cxalaf = ere.cxalaf  and DEC_PREC.diexa < ere.date_heritee  WHERE DOSEX.TYPE_CLASS = '0195' AND FORMATION.DATE_PRESCRIPTION >= '2016-01-01'  and DEC_PREC.DIEXA = (  select max(diexa) from p1299c_decision  where cxass = ere.cxass  and cxalaf = ere.cxalaf  and diexa < ere.date_heritee  )  and DEC_PREC.CPROD = 'ASU_MAY17_02'  and ERE.CXASS = ?  and ERE.CXALAF >= ?  and ERE.CXALAF <= ?  group by ere.cxalaf  WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockRffArem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */