package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN1024630
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN1024630 - Jurisprudence DV";
  private static final int PRIORITE = 760;
  private static final String REQUETE = " SELECT DISTINCT dosex.CXASS, dosex.CXALAF, demande.DATE_HERITEE_ERE  FROM P12A0C_01DOSEX dosex  JOIN((    select capa.cxass, capa.cxalaf, capa.capa_id as capid,    (DECIMAL(LEFT(ID_FCT_DV_CDCHT,LOCATE ('-',ID_FCT_DV_CDCHT)-1)))    as id_fct    FROM P12A0D_01CAP_ADM capa    WHERE capa.ID_FCT_DV_CDCHT IS NOT NULL    AND LOCATE ('-',capa.ID_FCT_DV_CDCHT) > 0    AND capa.ID_FCT_DV_CDCHT <> '0'    AND capa.CXASS = ?    AND capa.CXALAF >= ?    AND capa.CXALAF <= ?   ) UNION (    select capr.cxass, capr.cxalaf, capr.capr_id as capid,    (DECIMAL(LEFT(ID_FCT_DV_CDCHT,LOCATE ('-',ID_FCT_DV_CDCHT)-1)))    as id_fct    FROM P12A0E_01CAP_REP capr    WHERE capr.ID_FCT_DV_CDCHT IS NOT NULL    AND LOCATE ('-',capr.ID_FCT_DV_CDCHT) > 0    AND capr.ID_FCT_DV_CDCHT <> '0'   AND capr.CXASS = ?    AND capr.CXALAF >= ?    AND capr.CXALAF <= ?    )   ) AS fct_dv   ON fct_dv.CXASS = dosex.CXASS   AND (fct_dv.CAPID = dosex.CD_ATT_ADM_ID    OR fct_dv.CAPID = dosex.CD_ATT_REP_ID)   AND fct_dv.CXALAF = dosex.CXALAF  JOIN P1110C_PERIODE_ACT periode_dv   ON periode_dv.CXASS = fct_dv.CXASS   AND periode_dv.CXALAF = fct_dv.CXALAF   AND periode_dv.PER_ACTIVITE_ID = fct_dv.id_fct  JOIN P1110C_PERIODE_ACT periodeAct   ON periodeAct.CXASS = periode_dv.CXASS   AND periodeAct.CXALAF = periode_dv.CXALAF  JOIN P1110G_ORIGINE origine   ON periodeAct.PER_ACTIVITE_ID = origine.FK_PER_ACTIVITE_ID   AND periodeAct.CXASS = origine.cxass   AND periodeAct.CXALAF = origine.cxalaf  JOIN P1210R_01DEMANDE demande   ON dosex.cxass = demande.cxass   AND dosex.cxalaf = demande.cxalaf   AND (dosex.DOSS_AFFECT_ID = demande.DOSS_AFF_ADM_ID    OR dosex.DOSS_AFFECT_ID = demande.DOSS_AFF_REP_ID)  WHERE dosex.NATURE_DECISION = '16'   AND origine.CODE IN ('001','002', '004', '005', '006', '009', '010', '071',    '074', '031', '033', '034', '039', '054', '055', '056')   AND periodeAct.PERIODE_F > periode_dv.PERIODE_F   AND periodeAct.PERIODE_F < demande.DATE_HERITEE_ERE   AND periodeAct.PERIODE_D <= periode_dv.PERIODE_F   AND demande.DATE_HERITEE_ERE > '2014-09-30'   AND dosex.cxass = ?   AND dosex.cxalaf >= ?   AND dosex.cxalaf <= ?  GROUP BY dosex.CXASS, dosex.CXALAF, demande.DATE_HERITEE_ERE  WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int CODE_ASSEDIC2 = 4;
  private static final int ID_INF2 = 5;
  private static final int ID_SUP2 = 6;
  private static final int CODE_ASSEDIC3 = 7;
  private static final int ID_INF3 = 8;
  private static final int ID_SUP3 = 9;
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE = 3;
  
  public PopulationRepriseStockIN1024630()
  {
    setId("IN1024630 - Jurisprudence DV".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN1024630 - Jurisprudence DV");
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
    return " SELECT DISTINCT dosex.CXASS, dosex.CXALAF, demande.DATE_HERITEE_ERE  FROM P12A0C_01DOSEX dosex  JOIN((    select capa.cxass, capa.cxalaf, capa.capa_id as capid,    (DECIMAL(LEFT(ID_FCT_DV_CDCHT,LOCATE ('-',ID_FCT_DV_CDCHT)-1)))    as id_fct    FROM P12A0D_01CAP_ADM capa    WHERE capa.ID_FCT_DV_CDCHT IS NOT NULL    AND LOCATE ('-',capa.ID_FCT_DV_CDCHT) > 0    AND capa.ID_FCT_DV_CDCHT <> '0'    AND capa.CXASS = ?    AND capa.CXALAF >= ?    AND capa.CXALAF <= ?   ) UNION (    select capr.cxass, capr.cxalaf, capr.capr_id as capid,    (DECIMAL(LEFT(ID_FCT_DV_CDCHT,LOCATE ('-',ID_FCT_DV_CDCHT)-1)))    as id_fct    FROM P12A0E_01CAP_REP capr    WHERE capr.ID_FCT_DV_CDCHT IS NOT NULL    AND LOCATE ('-',capr.ID_FCT_DV_CDCHT) > 0    AND capr.ID_FCT_DV_CDCHT <> '0'   AND capr.CXASS = ?    AND capr.CXALAF >= ?    AND capr.CXALAF <= ?    )   ) AS fct_dv   ON fct_dv.CXASS = dosex.CXASS   AND (fct_dv.CAPID = dosex.CD_ATT_ADM_ID    OR fct_dv.CAPID = dosex.CD_ATT_REP_ID)   AND fct_dv.CXALAF = dosex.CXALAF  JOIN P1110C_PERIODE_ACT periode_dv   ON periode_dv.CXASS = fct_dv.CXASS   AND periode_dv.CXALAF = fct_dv.CXALAF   AND periode_dv.PER_ACTIVITE_ID = fct_dv.id_fct  JOIN P1110C_PERIODE_ACT periodeAct   ON periodeAct.CXASS = periode_dv.CXASS   AND periodeAct.CXALAF = periode_dv.CXALAF  JOIN P1110G_ORIGINE origine   ON periodeAct.PER_ACTIVITE_ID = origine.FK_PER_ACTIVITE_ID   AND periodeAct.CXASS = origine.cxass   AND periodeAct.CXALAF = origine.cxalaf  JOIN P1210R_01DEMANDE demande   ON dosex.cxass = demande.cxass   AND dosex.cxalaf = demande.cxalaf   AND (dosex.DOSS_AFFECT_ID = demande.DOSS_AFF_ADM_ID    OR dosex.DOSS_AFFECT_ID = demande.DOSS_AFF_REP_ID)  WHERE dosex.NATURE_DECISION = '16'   AND origine.CODE IN ('001','002', '004', '005', '006', '009', '010', '071',    '074', '031', '033', '034', '039', '054', '055', '056')   AND periodeAct.PERIODE_F > periode_dv.PERIODE_F   AND periodeAct.PERIODE_F < demande.DATE_HERITEE_ERE   AND periodeAct.PERIODE_D <= periode_dv.PERIODE_F   AND demande.DATE_HERITEE_ERE > '2014-09-30'   AND dosex.cxass = ?   AND dosex.cxalaf >= ?   AND dosex.cxalaf <= ?  GROUP BY dosex.CXASS, dosex.CXALAF, demande.DATE_HERITEE_ERE  WITH UR; ";
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
    statement.setString(7, codeAssedic);
    statement.setString(8, idInf);
    statement.setString(9, idSup);
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockIN1024630
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */