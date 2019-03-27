package fr.unedic.cali.parcours.population;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComportement;
import fr.unedic.cali.outilsfonctionnels.EcrireBaseVisu;
import fr.unedic.cali.parcours.ParcoursCali;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.ResultatVisualisationReexecution;
import fr.unedic.util.services.CoucheLogiqueException;

public abstract class ParcoursPopulationAbstraite
  extends ParcoursCali
  implements ParcoursPopulationSpec
{
  protected void ecrireEnBaseVisu(ResultatVisualisationReexecution p_resultatVisualisationReexecution, ComportementSpec p_comportement)
    throws CoucheLogiqueException
  {
    if (p_comportement.isEcrireEnBaseVisu()) {
      try
      {
        EcrireBaseVisu.ecrireEnBaseVisu(p_resultatVisualisationReexecution);
      }
      catch (TechniqueException e)
      {
        throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE", "Erreur inconnue dans l'exécution de l'application", e);
      }
    }
  }
  
  protected ComportementSpec definirComportement(PopulationSpec p_population)
  {
    ComportementSpec comportement = null;
    if (p_population != null) {
      comportement = p_population.getComportement();
    }
    if (comportement == null) {
      comportement = OutilComportement.getComportementParDefaut();
    }
    return comportement;
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationAbstraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */