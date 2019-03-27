package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN946916
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0927415 - reprise fin de droit ASP";
  private static final int PRIORITE = 760;
  private static final String REQUETE = "SELECT DISTINCT finDroit.cxalaf, finDroit.DATE_HERITEE_ERE FROM P1210R_01DEMANDE finDroit INNER JOIN P1210B_01DOSSAFF dosaf ON finDroit.CXASS = dosaf.CXASS AND finDroit.CXALAF = dosaf.CXALAF AND finDroit.DOSS_AFF_REP_ID = dosaf.DOSS_AFFECT_ID INNER JOIN P1210R_01DEMANDE reprise ON reprise.CXASS = dosaf.CXASS AND reprise.CXALAF = dosaf.CXALAF INNER JOIN P1210B_01DOSSAFF dosafReprise ON reprise.CXASS = dosafReprise.CXASS AND reprise.CXALAF = dosafReprise.CXALAF AND reprise.DOSS_AFF_REP_ID = dosafReprise.DOSS_AFFECT_ID WHERE dosafReprise.DOSEX_ID IS NOT NULL AND dosafReprise.DOSEX_ID <> 0 AND dosaf.DOSEX_ID IS NOT NULL AND dosaf.DOSEX_ID <> 0 AND finDroit.TYPE_CLASS_ERE = '0989' AND reprise.TYPE_CLASS_ERE = '0988' AND dosafReprise.PDT_FORCE IN ('050', '051') AND finDroit.DATE_HERITEE_ERE IS NOT NULL AND reprise.DATE_HERITEE_ERE < finDroit.DATE_HERITEE_ERE AND finDroit.CXASS = ? AND finDroit.CXALAF >= ? AND finDroit.CXALAF <= ? GROUP BY finDroit.CXALAF, finDroit.DATE_HERITEE_ERE with ur;";
  private static final int CODE_ASSEDIC_1 = 1;
  private static final int ID_INF_1 = 2;
  private static final int ID_SUP_1 = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  
  public PopulationRepriseStockIN946916()
  {
    setId("IN0927415 - reprise fin de droit ASP".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0927415 - reprise fin de droit ASP");
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
    return "SELECT DISTINCT finDroit.cxalaf, finDroit.DATE_HERITEE_ERE FROM P1210R_01DEMANDE finDroit INNER JOIN P1210B_01DOSSAFF dosaf ON finDroit.CXASS = dosaf.CXASS AND finDroit.CXALAF = dosaf.CXALAF AND finDroit.DOSS_AFF_REP_ID = dosaf.DOSS_AFFECT_ID INNER JOIN P1210R_01DEMANDE reprise ON reprise.CXASS = dosaf.CXASS AND reprise.CXALAF = dosaf.CXALAF INNER JOIN P1210B_01DOSSAFF dosafReprise ON reprise.CXASS = dosafReprise.CXASS AND reprise.CXALAF = dosafReprise.CXALAF AND reprise.DOSS_AFF_REP_ID = dosafReprise.DOSS_AFFECT_ID WHERE dosafReprise.DOSEX_ID IS NOT NULL AND dosafReprise.DOSEX_ID <> 0 AND dosaf.DOSEX_ID IS NOT NULL AND dosaf.DOSEX_ID <> 0 AND finDroit.TYPE_CLASS_ERE = '0989' AND reprise.TYPE_CLASS_ERE = '0988' AND dosafReprise.PDT_FORCE IN ('050', '051') AND finDroit.DATE_HERITEE_ERE IS NOT NULL AND reprise.DATE_HERITEE_ERE < finDroit.DATE_HERITEE_ERE AND finDroit.CXASS = ? AND finDroit.CXALAF >= ? AND finDroit.CXALAF <= ? GROUP BY finDroit.CXALAF, finDroit.DATE_HERITEE_ERE with ur;";
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
 * Qualified Name:     PopulationRepriseStockIN946916
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */