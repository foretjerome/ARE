package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSimulationChangementSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursReexecutionPopulationSimulationChangement;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class PopulationSimulationChangementAbstraite
  extends PopulationAbstraite
  implements PopulationSimulationChangementSpec
{
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
  
  public void chargerIndividu(Individu individu)
    throws ApplicativeException, TechniqueException
  {
    individu.chargerIndividuCohab();
    individu.chargerIndividuCali();
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursReexecutionPopulationSimulationChangement();
  }
  
  public boolean isEstAffichableIhmVisu()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     PopulationSimulationChangementAbstraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */