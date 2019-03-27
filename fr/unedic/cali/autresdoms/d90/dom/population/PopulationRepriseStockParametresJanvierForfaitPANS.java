package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchDefautMandatementAuto;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockParametresJanvierForfaitPANS
  extends PopulationAbstraite
{
  private static final String LIBELLE = "Parametres Forfait Pans Janvier 2018";
  private static final int IDENTIFIANT_POPULATION = "Parametres Forfait Pans Janvier 2018".hashCode();
  private static final int PRIORITE = 760;
  private static final Damj DATE_REEXECUTION = new Damj(2018, 1, 1);
  private static final String REQUETE = "select distinct a.cxalaf from P1110C_PERIODE_ACT a  inner join P1200z_pbjcncp b on a.cxass = b.cxass and a.cxalaf = b.cxalaf  where TYPE_PERIODE = '00017'  and PERIODE_F > '2017-12-31' and DFPJB  > '2017-12-31' and DFPJB between PERIODE_D and PERIODE_F and CPROD not like 'ASU%' and a.CXASS = ? and a.CXALAF >= ? AND a.CXALAF <= ?; ";
  private static final int COLONNE_CXALAF = 1;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  
  public PopulationRepriseStockParametresJanvierForfaitPANS()
  {
    setComportement(new ComportementBatchDefautMandatementAuto());
    setId(IDENTIFIANT_POPULATION);
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("Parametres Forfait Pans Janvier 2018");
    setNumeroDSMS("INC0427995");
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
    return DATE_REEXECUTION;
  }
  
  public String getRequete()
  {
    return "select distinct a.cxalaf from P1110C_PERIODE_ACT a  inner join P1200z_pbjcncp b on a.cxass = b.cxass and a.cxalaf = b.cxalaf  where TYPE_PERIODE = '00017'  and PERIODE_F > '2017-12-31' and DFPJB  > '2017-12-31' and DFPJB between PERIODE_D and PERIODE_F and CPROD not like 'ASU%' and a.CXASS = ? and a.CXALAF >= ? AND a.CXALAF <= ?; ";
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
 * Qualified Name:     PopulationRepriseStockParametresJanvierForfaitPANS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */