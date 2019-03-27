package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN0732718
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0732718 IDE suite fin CSP";
  private static final String REQUETE = " SELECT DISTINCT DecPivot.CXASS,  DecPivot.CXALAF, DecPivot.DIEXA  FROM P1299C_DECISION DecPivot  JOIN P1299C_DECISION AspDecPivot  ON DecPivot.cxass = AspDecPivot.cxass  AND DecPivot.cxalaf = AspDecPivot.cxalaf  AND DecPivot.cxnum <> AspDecPivot.cxnum  JOIN P1299A_DEMANDE DemPivot  ON DemPivot.cxass = DecPivot.cxass  AND DemPivot.cxalaf = DecPivot.cxalaf  AND DemPivot.cxnumb = DecPivot.cxnum  JOIN P1210R_01DEMANDE Demande  ON DemPivot.cxass = Demande.cxass  AND DemPivot.cxalaf = Demande.cxalaf  AND DemPivot.cxnum = Demande.dde_pivot_id  WHERE Demande.TYPE_CLASS_ERE = '0392'  AND DecPivot.CDTDC = '48'  AND AspDecPivot.DIEXA = (  SELECT MAX(dec_max.DIEXA)  FROM P1299C_DECISION dec_max  WHERE dec_max.CXALAF = DecPivot.CXALAF  AND dec_max.cxass = DecPivot.cxass  AND dec_max.DIEXA <= DecPivot.DIEXA  AND dec_max.cxnum <> DecPivot.cxnum  AND dec_max.CRCLA IS NULL)  AND ( AspDecPivot.CPROD LIKE 'ASU_CVA10%'   OR AspDecPivot.CPROD LIKE 'ASU_CAA14%' )  AND DecPivot.CXASS = ?  AND DecPivot.CXALAF >= ?  AND DecPivot.CXALAF <= ?  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  
  public PopulationRepriseStockIN0732718()
  {
    super("IN0732718 IDE suite fin CSP");
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return Damj.dateVersDamj(rs.getDate(3));
  }
  
  public String getRequete()
  {
    return " SELECT DISTINCT DecPivot.CXASS,  DecPivot.CXALAF, DecPivot.DIEXA  FROM P1299C_DECISION DecPivot  JOIN P1299C_DECISION AspDecPivot  ON DecPivot.cxass = AspDecPivot.cxass  AND DecPivot.cxalaf = AspDecPivot.cxalaf  AND DecPivot.cxnum <> AspDecPivot.cxnum  JOIN P1299A_DEMANDE DemPivot  ON DemPivot.cxass = DecPivot.cxass  AND DemPivot.cxalaf = DecPivot.cxalaf  AND DemPivot.cxnumb = DecPivot.cxnum  JOIN P1210R_01DEMANDE Demande  ON DemPivot.cxass = Demande.cxass  AND DemPivot.cxalaf = Demande.cxalaf  AND DemPivot.cxnum = Demande.dde_pivot_id  WHERE Demande.TYPE_CLASS_ERE = '0392'  AND DecPivot.CDTDC = '48'  AND AspDecPivot.DIEXA = (  SELECT MAX(dec_max.DIEXA)  FROM P1299C_DECISION dec_max  WHERE dec_max.CXALAF = DecPivot.CXALAF  AND dec_max.cxass = DecPivot.cxass  AND dec_max.DIEXA <= DecPivot.DIEXA  AND dec_max.cxnum <> DecPivot.cxnum  AND dec_max.CRCLA IS NULL)  AND ( AspDecPivot.CPROD LIKE 'ASU_CVA10%'   OR AspDecPivot.CPROD LIKE 'ASU_CAA14%' )  AND DecPivot.CXASS = ?  AND DecPivot.CXALAF >= ?  AND DecPivot.CXALAF <= ?  WITH UR; ";
  }
  
  public void preparerStatement(PreparedStatement statement, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
    throws SQLException
  {
    statement.setString(1, codeAssedic);
    statement.setString(2, idInf);
    statement.setString(3, idSup);
  }
  
  public Long getCxalaf(ResultSet rs)
    throws SQLException
  {
    return Long.valueOf(rs.getLong(2));
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockIN0732718
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */