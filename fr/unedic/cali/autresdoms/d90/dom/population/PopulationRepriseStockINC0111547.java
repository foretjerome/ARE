package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockINC0111547
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "INC0111547 - Demande ASS delai decheance forcee";
  private static final String REQUETE = "SELECT ERE.CXALAF, MIN(ERE.DATE_HERITEE) FROM P1220A_02DEMANDE DEMANDE JOIN P1220E_02DNFOR DF ON DEMANDE.CXASS = DF.CXASS AND DEMANDE.CXALAF = DF.CXALAF AND DEMANDE.DONNEES_FORCEES_ID = DF.DONNEES_FORCEES_ID JOIN P1220F_02EVTREFEXA ERE ON DEMANDE.CXASS = ERE.CXASS AND DEMANDE.CXALAF = ERE.CXALAF AND DEMANDE.EVT_REF_EXA_ID = ERE.EVT_REF_EXA_ID WHERE ERE.TYPE_CLASS IN ('0409', '0408', '0401', '1450', '0403', '0404') AND DF.ALLONGT_DELAI_DECH > 0 AND ERE.CXASS = ? AND ERE.CXALAF >= ? AND ERE.CXALAF <= ? GROUP BY ERE.CXALAF WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  
  public PopulationRepriseStockINC0111547()
  {
    super("INC0111547 - Demande ASS delai decheance forcee");
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
    return "SELECT ERE.CXALAF, MIN(ERE.DATE_HERITEE) FROM P1220A_02DEMANDE DEMANDE JOIN P1220E_02DNFOR DF ON DEMANDE.CXASS = DF.CXASS AND DEMANDE.CXALAF = DF.CXALAF AND DEMANDE.DONNEES_FORCEES_ID = DF.DONNEES_FORCEES_ID JOIN P1220F_02EVTREFEXA ERE ON DEMANDE.CXASS = ERE.CXASS AND DEMANDE.CXALAF = ERE.CXALAF AND DEMANDE.EVT_REF_EXA_ID = ERE.EVT_REF_EXA_ID WHERE ERE.TYPE_CLASS IN ('0409', '0408', '0401', '1450', '0403', '0404') AND DF.ALLONGT_DELAI_DECH > 0 AND ERE.CXASS = ? AND ERE.CXALAF >= ? AND ERE.CXALAF <= ? GROUP BY ERE.CXALAF WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockINC0111547
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */