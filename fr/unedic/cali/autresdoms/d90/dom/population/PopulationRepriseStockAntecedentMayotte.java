package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockAntecedentMayotte
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "2016D002DD01 Antecedent Mayotte";
  private static final int PRIORITE = 760;
  private static final String REQUETE = " SELECT ant.CXALAF, MIN(dmd.DATE_HERITEE_ERE)  FROM P1210R_01DEMANDE dmd  JOIN P1210A_01ANTECEDEN ant  ON ant.CXASS = dmd.CXASS  AND ant.CXALAF = dmd.CXALAF  AND ant.ANTECEDENT_ID = dmd.ANTECEDENT_ID  JOIN P1210B_01DOSSAFF dosaff  ON dosaff.CXASS = dmd.CXASS  AND dosaff.CXALAF = dmd.CXALAF  AND dosaff.DOSS_AFFECT_ID = dmd.DOSS_AFF_ADM_ID  JOIN P12A0C_01DOSEX dosex  ON dosex.CXASS = dosaff.CXASS  AND dosex.CXALAF = dosaff.CXALAF  AND dosex.DOSS_EXAM_ID = dosaff.DOSEX_ID  WHERE ant.CONTEXTE_DEMANDE = '8'  AND dmd.DATE_HERITEE_ERE >= '2014-07-01'  AND dosex.NATURE_DECISION = '38'  AND ant.CXASS = ?  AND ant.CXALAF >= ?  AND ant.CXALAF <= ?  AND dmd.MOTIF_REEX_PRI_DMD IS NULL  GROUP BY ant.CXALAF  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  
  public PopulationRepriseStockAntecedentMayotte()
  {
    setId("2016D002DD01 Antecedent Mayotte".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("2016D002DD01 Antecedent Mayotte");
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
    return " SELECT ant.CXALAF, MIN(dmd.DATE_HERITEE_ERE)  FROM P1210R_01DEMANDE dmd  JOIN P1210A_01ANTECEDEN ant  ON ant.CXASS = dmd.CXASS  AND ant.CXALAF = dmd.CXALAF  AND ant.ANTECEDENT_ID = dmd.ANTECEDENT_ID  JOIN P1210B_01DOSSAFF dosaff  ON dosaff.CXASS = dmd.CXASS  AND dosaff.CXALAF = dmd.CXALAF  AND dosaff.DOSS_AFFECT_ID = dmd.DOSS_AFF_ADM_ID  JOIN P12A0C_01DOSEX dosex  ON dosex.CXASS = dosaff.CXASS  AND dosex.CXALAF = dosaff.CXALAF  AND dosex.DOSS_EXAM_ID = dosaff.DOSEX_ID  WHERE ant.CONTEXTE_DEMANDE = '8'  AND dmd.DATE_HERITEE_ERE >= '2014-07-01'  AND dosex.NATURE_DECISION = '38'  AND ant.CXASS = ?  AND ant.CXALAF >= ?  AND ant.CXALAF <= ?  AND dmd.MOTIF_REEX_PRI_DMD IS NULL  GROUP BY ant.CXALAF  WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockAntecedentMayotte
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */