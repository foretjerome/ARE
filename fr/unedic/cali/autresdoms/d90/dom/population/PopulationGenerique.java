package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class PopulationGenerique
  extends PopulationAbstraite
{
  private static int idPopulationGenerique = 1;
  private ParcoursPopulationSpec parcoursPopulation;
  private boolean estAffichableIhmVisu;
  
  public static int getProchainIdentifiantPopulationGenerique()
  {
    return idPopulationGenerique++;
  }
  
  public static PopulationGenerique creerPopulationGenerique(String libellePopulation, int priorite, ComportementSpec comportement, boolean estAffichableIhmVisu)
  {
    return new PopulationGenerique(libellePopulation.hashCode(), libellePopulation, priorite, comportement, estAffichableIhmVisu);
  }
  
  private PopulationGenerique(int identifiant, String libelle, int priorite, ComportementSpec comportement, boolean isAffichableIhmVisu)
  {
    setComportement(comportement);
    setId(identifiant);
    setLibelle(libelle);
    setPriorite(priorite);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setNumeroDSMS(" ");
    setConsequenceFinanciereRecalcul(" ");
    setMaxCodeConsequenceSelection(" ");
    parcoursPopulation = null;
    estAffichableIhmVisu = isAffichableIhmVisu;
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    if (parcoursPopulation == null) {
      parcoursPopulation = new ParcoursPopulationReexecution("1");
    }
    return parcoursPopulation;
  }
  
  public void setParcoursPopulation(ParcoursPopulationSpec parcours)
  {
    parcoursPopulation = parcours;
  }
  
  public Long getCxalaf(ResultSet rs)
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
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return null;
  }
  
  public boolean isEstAffichableIhmVisu()
  {
    return estAffichableIhmVisu;
  }
}

/* Location:
 * Qualified Name:     PopulationGenerique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */