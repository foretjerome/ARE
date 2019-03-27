package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class PopulationRepriseStockAvecUneDateEtRequeteSimpleAbstraite
  extends PopulationAbstraite
{
  private String requete = "";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int COLONNE_CXALAF = 1;
  private static final int COLONNE_DATE = 2;
  
  protected PopulationRepriseStockAvecUneDateEtRequeteSimpleAbstraite(String libelle, String requete)
  {
    super(libelle);
    this.requete = requete;
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
    return requete;
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
 * Qualified Name:     PopulationRepriseStockAvecUneDateEtRequeteSimpleAbstraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */