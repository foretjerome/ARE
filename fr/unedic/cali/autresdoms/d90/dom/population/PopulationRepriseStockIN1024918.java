package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockIN1024918
  extends PopulationAbstraite
{
  private static final String LIBELLE_POPULATION = "IN1024918 - Mauvaise fct sur demande expresse";
  private static final String REQUETE = "SELECT demande.CXALAF, MIN(demande.DATE_HERITEE_ERE) FROM P1210R_01DEMANDE demande JOIN P1210B_01DOSSAFF dossaff ON dossaff.CXASS = demande.CXASS AND dossaff.CXALAF = demande.CXALAF AND dossaff.DDE_ASSURANCE_ID = demande.DEMANDE_ID JOIN P1110C_PERIODE_ACT derSinistre ON derSinistre.CXASS = dossaff.CXASS AND derSinistre.CXALAF = dossaff.CXALAF JOIN P1299A_DEMANDE demPiv ON demPiv.CXASS = demande.CXASS AND demPiv.CXALAF = demande.CXALAF AND demPiv.CXNUM = demande.DDE_PIVOT_ID JOIN P1299B_ATTRIB attrib ON attrib.CXASS = demPiv.CXASS AND attrib.CXALAF = demPiv.CXALAF AND attrib.CXNUM = demPiv.CXNUMA WHERE demande.TYPE_CLASS_ERE = '0389' AND demande.DROIT_OPTION_DFR ='1' AND demande.DATE_DEPOT_FRM >= '2011-08-01' AND demande.DATE_HERITEE_ERE > derSinistre.PERIODE_F AND attrib.DFCTO < derSinistre.PERIODE_F AND demande.CXASS = ? AND demande.CXALAF >= ? AND demande.CXALAF <= ? GROUP BY demande.CXALAF WITH UR; ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  
  public PopulationRepriseStockIN1024918()
  {
    super("IN1024918 - Mauvaise fct sur demande expresse");
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
    return "SELECT demande.CXALAF, MIN(demande.DATE_HERITEE_ERE) FROM P1210R_01DEMANDE demande JOIN P1210B_01DOSSAFF dossaff ON dossaff.CXASS = demande.CXASS AND dossaff.CXALAF = demande.CXALAF AND dossaff.DDE_ASSURANCE_ID = demande.DEMANDE_ID JOIN P1110C_PERIODE_ACT derSinistre ON derSinistre.CXASS = dossaff.CXASS AND derSinistre.CXALAF = dossaff.CXALAF JOIN P1299A_DEMANDE demPiv ON demPiv.CXASS = demande.CXASS AND demPiv.CXALAF = demande.CXALAF AND demPiv.CXNUM = demande.DDE_PIVOT_ID JOIN P1299B_ATTRIB attrib ON attrib.CXASS = demPiv.CXASS AND attrib.CXALAF = demPiv.CXALAF AND attrib.CXNUM = demPiv.CXNUMA WHERE demande.TYPE_CLASS_ERE = '0389' AND demande.DROIT_OPTION_DFR ='1' AND demande.DATE_DEPOT_FRM >= '2011-08-01' AND demande.DATE_HERITEE_ERE > derSinistre.PERIODE_F AND attrib.DFCTO < derSinistre.PERIODE_F AND demande.CXASS = ? AND demande.CXALAF >= ? AND demande.CXALAF <= ? GROUP BY demande.CXALAF WITH UR; ";
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
 * Qualified Name:     PopulationRepriseStockIN1024918
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */