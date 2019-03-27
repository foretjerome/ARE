package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockINC0067879
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "INC0067879 - decalage statut";
  private static final int PRIORITE = 755;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String REQUETE = "select DISTINCT b.cxalaf, P.PERIODE_D from p1200z_pbjcncp b JOIN P1110C_PERIODE_ACT P on b.cxass = p.cxass and b.cxalaf = p.cxalaf JOIN P1110G_ORIGINE O ON P.CXASS = O.CXASS AND P.CXALAF = O.CXALAF AND P.PER_ACTIVITE_ID = O.FK_PER_ACTIVITE_ID where dfpjb >= '2014-10-01' and csnpk = '9' and b.cxass = ? AND b.CXALAF >= ?  AND b.CXALAF <= ? and (cscpk0 = 'AF' or cscpk1 = 'AF' or cscpk2 = 'AF' or cscpk3 = 'AF' or cscpk4 = 'AF' or cscpk5 = 'AF') and ddpjb between P.PERIODE_D and P.PERIODE_F AND P.TYPE_PERIODE IN ('00011', '00012', '00013', '00014') AND O.CODE IN ('061', '062') and b.TSP < TO_DATE('2016-04-21 23:59:00', 'YYYY-MM-DD HH24:MI:SS') AND (P.MONTANT_V = 0 or P.MONTANT_V is null) group by b.cxalaf, P.PERIODE_D having sum(psden) = 0  with ur;";
  
  public PopulationRepriseStockINC0067879()
  {
    setId("INC0067879 - decalage statut".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("INC0067879 - decalage statut");
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
    return "select DISTINCT b.cxalaf, P.PERIODE_D from p1200z_pbjcncp b JOIN P1110C_PERIODE_ACT P on b.cxass = p.cxass and b.cxalaf = p.cxalaf JOIN P1110G_ORIGINE O ON P.CXASS = O.CXASS AND P.CXALAF = O.CXALAF AND P.PER_ACTIVITE_ID = O.FK_PER_ACTIVITE_ID where dfpjb >= '2014-10-01' and csnpk = '9' and b.cxass = ? AND b.CXALAF >= ?  AND b.CXALAF <= ? and (cscpk0 = 'AF' or cscpk1 = 'AF' or cscpk2 = 'AF' or cscpk3 = 'AF' or cscpk4 = 'AF' or cscpk5 = 'AF') and ddpjb between P.PERIODE_D and P.PERIODE_F AND P.TYPE_PERIODE IN ('00011', '00012', '00013', '00014') AND O.CODE IN ('061', '062') and b.TSP < TO_DATE('2016-04-21 23:59:00', 'YYYY-MM-DD HH24:MI:SS') AND (P.MONTANT_V = 0 or P.MONTANT_V is null) group by b.cxalaf, P.PERIODE_D having sum(psden) = 0  with ur;";
  }
  
  public void preparerStatement(PreparedStatement statement, String assedic, String inf, String sup, ContexteService service)
    throws SQLException
  {
    statement.setString(1, assedic);
    statement.setString(2, inf);
    statement.setString(3, sup);
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockINC0067879
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */