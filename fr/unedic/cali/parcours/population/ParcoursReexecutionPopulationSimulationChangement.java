package fr.unedic.cali.parcours.population;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationSimulationChangementAbstraite;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.parcours.ContexteParcoursSimulationChangementAbstrait;
import fr.unedic.cali.parcours.ContexteParcoursSimulationChangementDeterminationStatutUTRg;
import fr.unedic.cali.parcours.ContexteParcoursSimulationChangementIN0987900;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import java.util.Iterator;
import java.util.List;

public class ParcoursReexecutionPopulationSimulationChangement
  extends ParcoursPopulationReexecution
{
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    DomTraitementOccasionnel domReexecutionCali = (DomTraitementOccasionnel)contexte.getDonnees();
    
    IndividuSpec individu = domReexecutionCali.getIndividu();
    if ((individu.getContexteService() != null) && (individu.getContexteService().getCodeActivite() != null) && (!individu.getContexteService().getCodeActivite().equals("GRSC"))) {
      try
      {
        GestionnaireErreur.getInstance().genererException("HG_PR_L_CALI_CODE_ACTIVITE_SIMULATION_CHANGEMENT", 1);
      }
      catch (CoucheLogiqueException e)
      {
        throw new ContexteException(e.getCode(), e.getLibelle());
      }
    }
  }
  
  public void initialiserContexte(Contexte contextes)
    throws ContexteException
  {
    DomTraitementOccasionnel domReexecutionCali = (DomTraitementOccasionnel)contextes.getDonnees();
    PopulationSimulationChangementAbstraite population = (PopulationSimulationChangementAbstraite)domReexecutionCali.getPopulation();
    
    List<?> listeContexte = population.getListeContextesSimulation();
    if ((listeContexte == null) || (listeContexte.size() == 0)) {
      try
      {
        GestionnaireErreur.getInstance().genererException("HG_PR_L_CALI_CONTEXTE_SIMULATION_CHANGEMENT", new Object[] { population.getLibelle() }, 1);
      }
      catch (CoucheLogiqueException e)
      {
        throw new ContexteException(e.getCode(), e.getLibelle());
      }
    }
    Iterator<?> iterateur = listeContexte.iterator();
    while (iterateur.hasNext())
    {
      Object contexte = iterateur.next();
      verificationContexte(population, contexte);
    }
  }
  
  private void verificationContexte(PopulationSimulationChangementAbstraite population, Object contexte)
    throws ContexteException
  {
    if (!(contexte instanceof ContexteParcoursSimulationChangementAbstrait)) {
      try
      {
        GestionnaireErreur.getInstance().genererException("HG_PR_L_CALI_CONTEXTE_SIMULATION_CHANGEMENT", new Object[] { population.getLibelle() }, 1);
      }
      catch (CoucheLogiqueException e)
      {
        throw new ContexteException(e.getCode(), e.getLibelle());
      }
    }
    if ((contexte instanceof ContexteParcoursSimulationChangementIN0987900)) {
      ((ContexteParcoursSimulationChangementIN0987900)ContexteParcoursSimulationChangementIN0987900.getContexte()).setActif(true);
    }
    if ((contexte instanceof ContexteParcoursSimulationChangementDeterminationStatutUTRg)) {
      ((ContexteParcoursSimulationChangementDeterminationStatutUTRg)ContexteParcoursSimulationChangementDeterminationStatutUTRg.getContexte()).setActif(true);
    }
  }
  
  public Resultat demarrer(Contexte contexte)
    throws ApplicativeException
  {
    initialiserContexte(contexte);
    return super.demarrer(contexte);
  }
}

/* Location:
 * Qualified Name:     ParcoursReexecutionPopulationSimulationChangement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */