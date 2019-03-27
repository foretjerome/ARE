package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN937823
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN0937823 - fin ASP";
  private static final int PRIORITE = 760;
  private static final String REQUETE = "select dmd.cxalaf, min(produit.date_attrib) from p1210r_01demande dmd inner join P1200Q_CONTEXTE ctx on dmd.cxass = ctx.cxass and dmd.cxalaf = ctx.cxalaf and dmd.DEMANDE_ID = ctx.fk_demande_id inner join p1210b_01dossaff dosaf on dmd.cxass = dosaf.cxass and dmd.cxalaf = dosaf.cxalaf and dmd.demande_id = dosaf.dde_assurance_id inner join ( select dosex.cxass, dosex.cxalaf,  dosex.doss_exam_id dosex_id, cep.DATE_ATTRIB_CTDAT date_attrib from p12a0c_01dosex dosex inner join P12A0P_01CEP_REP cep on dosex.cxass = cep.cxass and dosex.cxalaf = cep.cxalaf and dosex.cepr_id = cep.cep_id and cep.DATE_ATTRIB_CTDAT is not null where dosex.cxass = ? and dosex.cxalaf >= ? and dosex.cxalaf <= ? UNION  select dosex.cxass, dosex.cxalaf,  dosex.doss_exam_id dosex_id, cep.DATE_ATTRIB_CTDAT date_attrib from p12a0c_01dosex dosex inner join P12A0N_01CEP_ADM cep on dosex.cxass = cep.cxass and dosex.cxalaf = cep.cxalaf and dosex.cepa_id = cep.cep_id and cep.DATE_ATTRIB_CTDAT is not null where dosex.cxass = ? and dosex.cxalaf >= ? and dosex.cxalaf <= ? UNION select dosex.cxass, dosex.cxalaf,  dosex.doss_exam_id dosex_id, cep.DATE_ATTRIB_CTDAT date_attrib from P1216Z_010103DOSEX dosex inner join P1217W_010103CEPA cep on dosex.cxass = cep.cxass and dosex.cxalaf = cep.cxalaf and dosex.cepa_id = cep.cep_id and cep.DATE_ATTRIB_CTDAT is not null where dosex.cxass = ? and dosex.cxalaf >= ? and dosex.cxalaf <= ? UNION select dosex.cxass, dosex.cxalaf,  dosex.doss_exam_id dosex_id, cep.DATE_ATTRIB_CTDAT date_attrib from P1216Z_010103DOSEX dosex inner join P1217Z_010103CEPR cep on dosex.cxass = cep.cxass and dosex.cxalaf = cep.cxalaf and dosex.cepr_id = cep.cep_id and cep.DATE_ATTRIB_CTDAT is not null where dosex.cxass = ? and dosex.cxalaf >= ? and dosex.cxalaf <= ? UNION select dosex.cxass, dosex.cxalaf,  dosex.doss_exam_id dosex_id, cddat.DATE_ATTRIBUTION date_attrib from P1211Z_010102DOSEX dosex inner join P1211N_010102CEPA cep on dosex.cxass = cep.cxass and dosex.cxalaf = cep.cxalaf and dosex.cepa_id = cep.cep_id inner join P1211Q_010102CTDAT cddat on cep.cxass = cddat.cxass and cep.cxalaf = cddat.cxalaf and cep.CT_DATE_ATT_ID = cddat.CT_DATE_ATT_ID and cddat.DATE_ATTRIBUTION is not null where dosex.cxass = ? and dosex.cxalaf >= ? and dosex.cxalaf <= ? UNION  select dosex.cxass, dosex.cxalaf,  dosex.doss_exam_id dosex_id, cddat.DATE_ATTRIBUTION date_attrib from P1211Z_010102DOSEX dosex inner join P1211P_010102CEPR cep on dosex.cxass = cep.cxass and dosex.cxalaf = cep.cxalaf and dosex.cepr_id = cep.cep_id inner join P1211Q_010102CTDAT cddat on cep.cxass = cddat.cxass and cep.cxalaf = cddat.cxalaf and cddat.CT_DATE_ATT_ID = cddat.CT_DATE_ATT_ID and cddat.DATE_ATTRIBUTION is not null where dosex.cxass = ? and dosex.cxalaf >= ? and dosex.cxalaf <= ? ) as produit on dosaf.cxass = produit.cxass and dosaf.cxalaf = produit.cxalaf and dosaf.dosex_id = produit.dosex_id where produit.date_attrib <> dmd.date_heritee_ere and dmd.cxass = ? and dmd.cxalaf >= ? and dmd.cxalaf <= ? and ctx.TYPE_CONTEXTE IN ('FINASP', 'FINASPVOL', 'FINASPVOLC') group by dmd.cxalaf with ur;";
  private static final int CODE_ASSEDIC_1 = 1;
  private static final int ID_INF_1 = 2;
  private static final int ID_SUP_1 = 3;
  private static final int CODE_ASSEDIC_2 = 4;
  private static final int ID_INF_2 = 5;
  private static final int ID_SUP_2 = 6;
  private static final int CODE_ASSEDIC_3 = 7;
  private static final int ID_INF_3 = 8;
  private static final int ID_SUP_3 = 9;
  private static final int CODE_ASSEDIC_4 = 10;
  private static final int ID_INF_4 = 11;
  private static final int ID_SUP_4 = 12;
  private static final int CODE_ASSEDIC_5 = 13;
  private static final int ID_INF_5 = 14;
  private static final int ID_SUP_5 = 15;
  private static final int CODE_ASSEDIC_6 = 16;
  private static final int ID_INF_6 = 17;
  private static final int ID_SUP_6 = 18;
  private static final int CODE_ASSEDIC_7 = 19;
  private static final int ID_INF_7 = 20;
  private static final int ID_SUP_7 = 21;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  
  public PopulationRepriseStockIN937823()
  {
    setId("IN0937823 - fin ASP".hashCode());
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0937823 - fin ASP");
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
    return "select dmd.cxalaf, min(produit.date_attrib) from p1210r_01demande dmd inner join P1200Q_CONTEXTE ctx on dmd.cxass = ctx.cxass and dmd.cxalaf = ctx.cxalaf and dmd.DEMANDE_ID = ctx.fk_demande_id inner join p1210b_01dossaff dosaf on dmd.cxass = dosaf.cxass and dmd.cxalaf = dosaf.cxalaf and dmd.demande_id = dosaf.dde_assurance_id inner join ( select dosex.cxass, dosex.cxalaf,  dosex.doss_exam_id dosex_id, cep.DATE_ATTRIB_CTDAT date_attrib from p12a0c_01dosex dosex inner join P12A0P_01CEP_REP cep on dosex.cxass = cep.cxass and dosex.cxalaf = cep.cxalaf and dosex.cepr_id = cep.cep_id and cep.DATE_ATTRIB_CTDAT is not null where dosex.cxass = ? and dosex.cxalaf >= ? and dosex.cxalaf <= ? UNION  select dosex.cxass, dosex.cxalaf,  dosex.doss_exam_id dosex_id, cep.DATE_ATTRIB_CTDAT date_attrib from p12a0c_01dosex dosex inner join P12A0N_01CEP_ADM cep on dosex.cxass = cep.cxass and dosex.cxalaf = cep.cxalaf and dosex.cepa_id = cep.cep_id and cep.DATE_ATTRIB_CTDAT is not null where dosex.cxass = ? and dosex.cxalaf >= ? and dosex.cxalaf <= ? UNION select dosex.cxass, dosex.cxalaf,  dosex.doss_exam_id dosex_id, cep.DATE_ATTRIB_CTDAT date_attrib from P1216Z_010103DOSEX dosex inner join P1217W_010103CEPA cep on dosex.cxass = cep.cxass and dosex.cxalaf = cep.cxalaf and dosex.cepa_id = cep.cep_id and cep.DATE_ATTRIB_CTDAT is not null where dosex.cxass = ? and dosex.cxalaf >= ? and dosex.cxalaf <= ? UNION select dosex.cxass, dosex.cxalaf,  dosex.doss_exam_id dosex_id, cep.DATE_ATTRIB_CTDAT date_attrib from P1216Z_010103DOSEX dosex inner join P1217Z_010103CEPR cep on dosex.cxass = cep.cxass and dosex.cxalaf = cep.cxalaf and dosex.cepr_id = cep.cep_id and cep.DATE_ATTRIB_CTDAT is not null where dosex.cxass = ? and dosex.cxalaf >= ? and dosex.cxalaf <= ? UNION select dosex.cxass, dosex.cxalaf,  dosex.doss_exam_id dosex_id, cddat.DATE_ATTRIBUTION date_attrib from P1211Z_010102DOSEX dosex inner join P1211N_010102CEPA cep on dosex.cxass = cep.cxass and dosex.cxalaf = cep.cxalaf and dosex.cepa_id = cep.cep_id inner join P1211Q_010102CTDAT cddat on cep.cxass = cddat.cxass and cep.cxalaf = cddat.cxalaf and cep.CT_DATE_ATT_ID = cddat.CT_DATE_ATT_ID and cddat.DATE_ATTRIBUTION is not null where dosex.cxass = ? and dosex.cxalaf >= ? and dosex.cxalaf <= ? UNION  select dosex.cxass, dosex.cxalaf,  dosex.doss_exam_id dosex_id, cddat.DATE_ATTRIBUTION date_attrib from P1211Z_010102DOSEX dosex inner join P1211P_010102CEPR cep on dosex.cxass = cep.cxass and dosex.cxalaf = cep.cxalaf and dosex.cepr_id = cep.cep_id inner join P1211Q_010102CTDAT cddat on cep.cxass = cddat.cxass and cep.cxalaf = cddat.cxalaf and cddat.CT_DATE_ATT_ID = cddat.CT_DATE_ATT_ID and cddat.DATE_ATTRIBUTION is not null where dosex.cxass = ? and dosex.cxalaf >= ? and dosex.cxalaf <= ? ) as produit on dosaf.cxass = produit.cxass and dosaf.cxalaf = produit.cxalaf and dosaf.dosex_id = produit.dosex_id where produit.date_attrib <> dmd.date_heritee_ere and dmd.cxass = ? and dmd.cxalaf >= ? and dmd.cxalaf <= ? and ctx.TYPE_CONTEXTE IN ('FINASP', 'FINASPVOL', 'FINASPVOLC') group by dmd.cxalaf with ur;";
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
    statement.setString(10, codeAssedic);
    statement.setString(11, idInf);
    statement.setString(12, idSup);
    statement.setString(13, codeAssedic);
    statement.setString(14, idInf);
    statement.setString(15, idSup);
    statement.setString(16, codeAssedic);
    statement.setString(17, idInf);
    statement.setString(18, idSup);
    statement.setString(19, codeAssedic);
    statement.setString(20, idInf);
    statement.setString(21, idSup);
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockIN937823
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */