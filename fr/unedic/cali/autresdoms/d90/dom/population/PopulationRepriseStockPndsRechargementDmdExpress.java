package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockPndsRechargementDmdExpress
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "PNDS sur Rechargement et Demande Expresse";
  private static final String REQUETE = "select res.DE, min(res.date_reex) FROM ( select dmd.cxalaf DE, dmd.date_heritee_ere date_reex from p1210r_01demande dmd inner join p1210b_01dossaff dosaf on dmd.cxass = dosaf.cxass and dmd.cxalaf = dosaf.cxalaf and dmd.doss_aff_adm_id = dosaf.doss_affect_id inner join p1210k_01vlpdt pdt on dosaf.cxass = pdt.cxass and dosaf.cxalaf = pdt.cxalaf and dosaf.VLPDT_ID = pdt.VAL_PDT_ID inner join P1210X_01JUSTIF_AF justif on pdt.cxass = justif.cxass and pdt.cxalaf = justif.cxalaf and pdt.JUSTIFICATION_ID = justif.JUSTIFICATION_ID inner join P1210U_01PER_ELT perElem on justif.cxass = perElem.cxass and justif.cxalaf = perElem.cxalaf and justif.justification_id = perElem.FK_JUSTIF_ID where perElem.EST_SANCTIONNEE = '1' and dmd.date_heritee_ere is not null and dmd.date_heritee_ere > '2015-10-22' and dmd.cxass = ? and dmd.cxalaf >= ? and dmd.cxalaf <= ? UNION select cxalaf DE, date_heritee_ere date_reex from p1210r_01demande where type_class_ere = '0389' and date_heritee_ere is not null and date_heritee_ere <= '2015-10-22' and PREM_VALID_DMD > '2015-10-22' and cxass = ? and cxalaf >= ? and cxalaf <= ? ) as res group by res.DE with ur;";
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int CODE_ASSEDIC_2 = 4;
  private static final int ID_INF_2 = 5;
  private static final int ID_SUP_2 = 6;
  
  public PopulationRepriseStockPndsRechargementDmdExpress()
  {
    super("PNDS sur Rechargement et Demande Expresse");
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationReexecution();
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return Damj.dateVersDamj(rs.getDate(2));
  }
  
  public String getRequete()
  {
    return "select res.DE, min(res.date_reex) FROM ( select dmd.cxalaf DE, dmd.date_heritee_ere date_reex from p1210r_01demande dmd inner join p1210b_01dossaff dosaf on dmd.cxass = dosaf.cxass and dmd.cxalaf = dosaf.cxalaf and dmd.doss_aff_adm_id = dosaf.doss_affect_id inner join p1210k_01vlpdt pdt on dosaf.cxass = pdt.cxass and dosaf.cxalaf = pdt.cxalaf and dosaf.VLPDT_ID = pdt.VAL_PDT_ID inner join P1210X_01JUSTIF_AF justif on pdt.cxass = justif.cxass and pdt.cxalaf = justif.cxalaf and pdt.JUSTIFICATION_ID = justif.JUSTIFICATION_ID inner join P1210U_01PER_ELT perElem on justif.cxass = perElem.cxass and justif.cxalaf = perElem.cxalaf and justif.justification_id = perElem.FK_JUSTIF_ID where perElem.EST_SANCTIONNEE = '1' and dmd.date_heritee_ere is not null and dmd.date_heritee_ere > '2015-10-22' and dmd.cxass = ? and dmd.cxalaf >= ? and dmd.cxalaf <= ? UNION select cxalaf DE, date_heritee_ere date_reex from p1210r_01demande where type_class_ere = '0389' and date_heritee_ere is not null and date_heritee_ere <= '2015-10-22' and PREM_VALID_DMD > '2015-10-22' and cxass = ? and cxalaf >= ? and cxalaf <= ? ) as res group by res.DE with ur;";
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
  
  public Long getCxalaf(ResultSet rs)
    throws SQLException
  {
    return Long.valueOf(rs.getLong(1));
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockPndsRechargementDmdExpress
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */