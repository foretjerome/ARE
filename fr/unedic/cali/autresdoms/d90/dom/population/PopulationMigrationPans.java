package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationMigrationPans;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationMigrationPans
  extends PopulationAbstraite
{
  private static final int PRIORITE = 755;
  
  public PopulationMigrationPans()
  {
    setId("11SI1_GAEC_MIGRATION_PANS_2".hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("11SI1_GAEC_MIGRATION_PANS_2");
    setNumeroDSMS("0045995");
    setConsequenceFinanciereRecalcul(" ");
    setMaxCodeConsequenceSelection(" ");
  }
  
  public Long getCxalaf(ResultSet rs)
    throws SQLException
  {
    return null;
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return null;
  }
  
  public String getRequete()
  {
    return null;
  }
  
  public void preparerStatement(PreparedStatement statement, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
    throws SQLException
  {}
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationMigrationPans();
  }
  
  public boolean isEstAffichableIhmVisu()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     PopulationMigrationPans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */