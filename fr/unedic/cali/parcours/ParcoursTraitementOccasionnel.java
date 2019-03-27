package fr.unedic.cali.parcours;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.d90.dom.InfoReexecution;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Indicateur;
import fr.unedic.cali.dom.IndicateursGeneriques;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.EcrireBaseVisu;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParcoursTraitementOccasionnel
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    Resultat resultat = null;
    boolean estTraite = false;
    OutilTrace.tracerDebutParcours(Niveau.DEBUG);
    
    DomTraitementOccasionnel domTraitementOccasionnel = (DomTraitementOccasionnel)p_contexte.getDonnees();
    PopulationSpec population = domTraitementOccasionnel.getPopulation();
    
    InfoReexecution infoReexecution = population.estUnIndividuReexecutable(domTraitementOccasionnel.getIndividu(), domTraitementOccasionnel.getDate());
    if (infoReexecution.isExecutable())
    {
      if (infoReexecution.getDateExecution() != null) {
        domTraitementOccasionnel.setDate(infoReexecution.getDateExecution());
      }
      ParcoursPopulationSpec parcoursPopulation = population.getParcours();
      if (parcoursPopulation != null)
      {
        parcoursPopulation.controlerContexte(p_contexte);
        
        resultat = parcoursPopulation.demarrer(p_contexte);
        estTraite = true;
      }
      else
      {
        OutilTrace.ecrireTrace(Niveau.DEBUG, new Object[] { "\t\t Aucun parcours n'est déterminé pour la population ", population.getLibelle() });
        
        throw new CoucheLogiqueException("HG_Pas de parcours pour cette population", "Pas de parcours pour cette population", null);
      }
    }
    else
    {
      OutilTrace.ecrireTrace(Niveau.DEBUG, new Object[] { "\t\t Individu ", domTraitementOccasionnel.getIndividu().getIndividuId().getId(), " non validé par la population ", population.getLibelle() });
      
      fr.unedic.cali.autresdoms.d90.dom.Individu individuExclu = new fr.unedic.cali.autresdoms.d90.dom.Individu();
      individuExclu.setCxala(domTraitementOccasionnel.getIndividu().getIndividuId().getId());
      individuExclu.setDateReexecution(domTraitementOccasionnel.getDate());
      individuExclu.setEtatIndividu("1");
      individuExclu.setPopulation(population);
      individuExclu.setRsin("");
      individuExclu.setModeCreation("");
      individuExclu.setAntenne("");
      individuExclu.setDeltaMontantBrut(new BigDecimal(0));
      List listeIndividus = new ArrayList();
      listeIndividus.add(individuExclu);
      ResultatVisualisationSelection resultatVisualisation = new ResultatVisualisationSelection();
      resultatVisualisation.setListeIndividusSelectionnes(listeIndividus);
      resultatVisualisation.setRedressementSpec(domTraitementOccasionnel.getRedressement());
      try
      {
        EcrireBaseVisu.ecrireEnBaseVisu(resultatVisualisation);
      }
      catch (TechniqueException e)
      {
        throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE", "Erreur inconnue dans l'exécution de l'application", e);
      }
    }
    return gestionIndicateurDE(resultat, estTraite);
  }
  
  protected Resultat gestionIndicateurDE(Resultat p_resultat, boolean p_estTraite)
  {
    ResultatReexecutionCali resultatReexecutionCali = null;
    if (p_estTraite)
    {
      resultatReexecutionCali = (ResultatReexecutionCali)p_resultat;
      if (resultatReexecutionCali.getIndicateursGeneriques() != null)
      {
        resultatReexecutionCali.getIndicateursGeneriques().incrementeIndicateur("D12_DE_TRAITE");
        resultatReexecutionCali.getIndicateursGeneriques().getIndicateur("D12_DE_NON_TRAITE");
      }
      p_resultat = resultatReexecutionCali;
    }
    else
    {
      resultatReexecutionCali = new ResultatReexecutionCali();
      IndicateursGeneriques listeIndicateurs = new IndicateursGeneriques();
      listeIndicateurs.getIndicateur("D12_DE_NON_TRAITE").incremente();
      listeIndicateurs.getIndicateur("D12_DE_TRAITE");
      resultatReexecutionCali.setIndicateursGeneriques(listeIndicateurs);
      p_resultat = resultatReexecutionCali;
      p_resultat.setEtat(1);
    }
    return p_resultat;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(fr.unedic.cali.dom.Individu p_individu)
  {
    if (p_individu.getDonneesChargementGaec().getAgregatGaec().isOptimisationPasDeChargementGaec()) {
      return 0;
    }
    return 2;
  }
  
  protected void alimenterAgregatGaec(fr.unedic.cali.dom.Individu p_individu, String p_idDemande)
  {
    if (p_individu != null) {
      p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
    }
  }
  
  protected void controlerPostTraitement(fr.unedic.cali.dom.Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
}

/* Location:
 * Qualified Name:     ParcoursTraitementOccasionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */