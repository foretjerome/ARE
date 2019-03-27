package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationRepriseStockContribOuvertureCSP;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationRepriseStockContribOuvertureCSP
  extends PopulationAbstraite
{
  public static final String POPULATION = "SNOW INC0180472 - Appel contribution OD CSP";
  public static final String REQUETE = "select dmd.cxalaf, min(dmd.date_heritee_ere) from p1200q_contexte ctx inner join p1210r_01demande dmd on ctx.cxass = dmd.cxass and ctx.cxalaf = dmd.cxalaf and ctx.fk_demande_id = dmd.demande_id where ctx.type_contexte = 'AREENTRCSP' and dmd.PREM_VALID_DMD >= '2016-12-12' and dmd.PREM_VALID_DMD <= '2016-12-16' and dmd.date_heritee_ere is not null and dmd.cxass = ? and dmd.cxalaf >= ? and dmd.cxalaf <= ? group by dmd.cxalaf with ur;";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_DATE = 2;
  private static final int COLONNE_CXALAF = 1;
  
  public PopulationRepriseStockContribOuvertureCSP()
  {
    super("SNOW INC0180472 - Appel contribution OD CSP");
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    ParcoursPopulationRepriseStockContribOuvertureCSP parcours = new ParcoursPopulationRepriseStockContribOuvertureCSP();
    parcours.setNomPopulation("SNOW INC0180472 - Appel contribution OD CSP");
    return parcours;
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return Damj.dateVersDamj(rs.getDate(2));
  }
  
  public String getRequete()
  {
    return "select dmd.cxalaf, min(dmd.date_heritee_ere) from p1200q_contexte ctx inner join p1210r_01demande dmd on ctx.cxass = dmd.cxass and ctx.cxalaf = dmd.cxalaf and ctx.fk_demande_id = dmd.demande_id where ctx.type_contexte = 'AREENTRCSP' and dmd.PREM_VALID_DMD >= '2016-12-12' and dmd.PREM_VALID_DMD <= '2016-12-16' and dmd.date_heritee_ere is not null and dmd.cxass = ? and dmd.cxalaf >= ? and dmd.cxalaf <= ? group by dmd.cxalaf with ur;";
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
    return Long.valueOf(rs.getLong(1));
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockContribOuvertureCSP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */