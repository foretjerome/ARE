package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0922314
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0922314 - justif HBT mob";
  private static final int PRIORITE = 760;
  private static final String REQUETE = " SELECT DISTINCT JUSTIF.CXALAF, MIN(AIDE_PIVOT.DDACR) as DATE  FROM P1260M_06MOISCIVIL JUSTIF   INNER JOIN P1260E_06PERLI PERLI  ON JUSTIF.CXASS = PERLI.CXASS AND JUSTIF.CXALAF = PERLI.CXALAF  AND JUSTIF.FK_PERIODE_ID = PERLI.PERIODE_ID  INNER JOIN P1260A_06DEMANDE DEMANDE  ON PERLI.CXASS = DEMANDE.CXASS AND PERLI.CXALAF = DEMANDE.CXALAF  AND PERLI.FK_DDE_RBF_ID = DEMANDE.DEMANDE_ID  INNER JOIN P1299A_DEMANDE DDE_PIVOT   ON DEMANDE.DDE_PIVOT_ID = DDE_PIVOT.CXNUM  AND DEMANDE.CXASS = DDE_PIVOT.CXASS   AND DEMANDE.CXALAF = DDE_PIVOT.CXALAF  INNER JOIN P1299D_AIDESG AIDE_PIVOT  ON DDE_PIVOT.CXNUMC = AIDE_PIVOT.CXNUM  AND DDE_PIVOT.CXASS = AIDE_PIVOT.CXASS  AND DDE_PIVOT.CXALAF = AIDE_PIVOT.CXALAF  WHERE JUSTIF.DATE_DEPOT > ADD_MONTHS(JUSTIF.PERIODE_F, 2)  AND AIDE_PIVOT.CPROD = 'RBF_MOB07_01'  AND AIDE_PIVOT.CDSIM = '01'  AND AIDE_PIVOT.CITAI IN ('J', 'E')  AND JUSTIF.DATE_DEPOT <= ADD_MONTHS(AIDE_PIVOT.DFACR, 2)  and JUSTIF.CXASS = ?  and JUSTIF.CXALAF >= ?  and JUSTIF.CXALAF <= ?  group by JUSTIF.CXALAF  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  
  public PopulationRepriseStockIN0922314()
  {
    setId("IN0922314 - justif HBT mob".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0922314 - justif HBT mob");
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
    return " SELECT DISTINCT JUSTIF.CXALAF, MIN(AIDE_PIVOT.DDACR) as DATE  FROM P1260M_06MOISCIVIL JUSTIF   INNER JOIN P1260E_06PERLI PERLI  ON JUSTIF.CXASS = PERLI.CXASS AND JUSTIF.CXALAF = PERLI.CXALAF  AND JUSTIF.FK_PERIODE_ID = PERLI.PERIODE_ID  INNER JOIN P1260A_06DEMANDE DEMANDE  ON PERLI.CXASS = DEMANDE.CXASS AND PERLI.CXALAF = DEMANDE.CXALAF  AND PERLI.FK_DDE_RBF_ID = DEMANDE.DEMANDE_ID  INNER JOIN P1299A_DEMANDE DDE_PIVOT   ON DEMANDE.DDE_PIVOT_ID = DDE_PIVOT.CXNUM  AND DEMANDE.CXASS = DDE_PIVOT.CXASS   AND DEMANDE.CXALAF = DDE_PIVOT.CXALAF  INNER JOIN P1299D_AIDESG AIDE_PIVOT  ON DDE_PIVOT.CXNUMC = AIDE_PIVOT.CXNUM  AND DDE_PIVOT.CXASS = AIDE_PIVOT.CXASS  AND DDE_PIVOT.CXALAF = AIDE_PIVOT.CXALAF  WHERE JUSTIF.DATE_DEPOT > ADD_MONTHS(JUSTIF.PERIODE_F, 2)  AND AIDE_PIVOT.CPROD = 'RBF_MOB07_01'  AND AIDE_PIVOT.CDSIM = '01'  AND AIDE_PIVOT.CITAI IN ('J', 'E')  AND JUSTIF.DATE_DEPOT <= ADD_MONTHS(AIDE_PIVOT.DFACR, 2)  and JUSTIF.CXASS = ?  and JUSTIF.CXALAF >= ?  and JUSTIF.CXALAF <= ?  group by JUSTIF.CXALAF  WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockIN0922314
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */