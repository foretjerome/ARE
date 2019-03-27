package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.cali.parcours.ContexteParcoursSimulationChangementARZ;
import fr.unedic.cali.parcours.ContexteParcoursSimulationChangementSpec;
import java.util.ArrayList;
import java.util.List;

public class PopulationSimulationChangementARZ
  extends PopulationSimulationChangementAbstraite
{
  private static final int IDENTIFIANT_POPULATION = "90ARZ_Mandatement_Manu".hashCode();
  private static final int PRIORITE = 755;
  
  public PopulationSimulationChangementARZ()
  {
    setId(IDENTIFIANT_POPULATION);
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("90ARZ_Mandatement_Manu");
    setConsequenceFinanciereRecalcul(" ");
    setMaxCodeConsequenceSelection(" ");
  }
  
  public List<ContexteParcoursSimulationChangementSpec> getListeContextesSimulation()
  {
    List<ContexteParcoursSimulationChangementSpec> listeContexte = new ArrayList();
    listeContexte.add(new ContexteParcoursSimulationChangementARZ());
    return listeContexte;
  }
}

/* Location:
 * Qualified Name:     PopulationSimulationChangementARZ
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */