package fr.unedic.cali.autresdoms.cohab.mapping;

import fr.unedic.cali.autresdoms.cohab.dom.DecisionSuivi;
import fr.unedic.cali.autresdoms.cohab.dom.IndividuCohabAbstrait;
import fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom.spec.DecisionSuiviSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MapperDecisionsSuivi
{
  public static void mapper(IndividuCohabAbstrait individu, Collection collectionDecisionsSuiviCojac)
  {
    Collection resultatService = new ArrayList();
    if (collectionDecisionsSuiviCojac != null)
    {
      Iterator iter = collectionDecisionsSuiviCojac.iterator();
      while (iter.hasNext())
      {
        DecisionSuivi decisionSuivi = mapperUneDecisionSuivi((DecisionSuiviSpec)iter.next());
        resultatService.add(decisionSuivi);
      }
    }
    individu.setDecisionsSuivi(resultatService);
  }
  
  public static DecisionSuivi mapperUneDecisionSuivi(DecisionSuiviSpec decisionSuiviSpec)
  {
    DecisionSuivi decisionSuivi = new DecisionSuivi();
    if (decisionSuiviSpec != null)
    {
      decisionSuivi.setDureeDecision(decisionSuiviSpec.getDureeDecision());
      if (decisionSuiviSpec.getNatureDecision() != null) {
        decisionSuivi.setNatureDecision(decisionSuiviSpec.getNatureDecision());
      }
      if (decisionSuiviSpec.getNatureSuspension() != null) {
        decisionSuivi.setNatureSuspension(decisionSuiviSpec.getNatureSuspension());
      }
      if (decisionSuiviSpec.getIdentifiantOuvertureDroit() != null) {
        decisionSuivi.setRSOD(decisionSuiviSpec.getIdentifiantOuvertureDroit());
      }
      if (decisionSuiviSpec.getDateEffet() != null) {
        decisionSuivi.setDateEffet(decisionSuiviSpec.getDateEffet());
      }
      if (decisionSuiviSpec.getDateFin() != null) {
        decisionSuivi.setDateFin(decisionSuiviSpec.getDateFin());
      }
      decisionSuivi.setRangActualisation(decisionSuiviSpec.getRangProlongation());
      decisionSuivi.setChevauchementSanction(decisionSuiviSpec.getChevauchementSanction());
    }
    return decisionSuivi;
  }
}

/* Location:
 * Qualified Name:     MapperDecisionsSuivi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */