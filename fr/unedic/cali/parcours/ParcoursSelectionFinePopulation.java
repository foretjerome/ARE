package fr.unedic.cali.parcours;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.InfoReexecution;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import fr.unedic.cali.dom.IndicateursGeneriques;
import fr.unedic.cali.outilsfonctionnels.BaseSelectionFine;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;

public class ParcoursSelectionFinePopulation
  extends ParcoursTraitementOccasionnel
{
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    OutilTrace.tracerDebutParcours();
    
    ResultatReexecutionCali resultat = null;
    boolean estTraite = false;
    
    DomSelectionFine domSelectionFine = (DomSelectionFine)p_contexte.getDonnees();
    PopulationSpec population = domSelectionFine.getPopulation();
    if (population != null)
    {
      InfoReexecution info = domSelectionFine.getPopulation().estAReexecuter(p_contexte);
      domSelectionFine.setEstAReexecuter(info.isExecutable());
      if (info.getDateExecution() == null) {
        domSelectionFine.setDateReexecution(domSelectionFine.getDate());
      } else {
        domSelectionFine.setDateReexecution(info.getDateExecution());
      }
      appelBaseSelectionFine(domSelectionFine, domSelectionFine.getRedressement());
    }
    else
    {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_ERR_POPULATION_NON_PRESENTE");
    }
    OutilTrace.tracerFinParcours();
    
    return gestionIndicateurDE(resultat, estTraite, domSelectionFine.isEstAReexecuter());
  }
  
  private void appelBaseSelectionFine(DomCali p_domSelectionFine, RedressementSpec p_redressement)
    throws CoucheLogiqueException
  {
    try
    {
      BaseSelectionFine.ecrireBaseSelectionFine(p_domSelectionFine, p_redressement);
    }
    catch (TechniqueException e)
    {
      throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE", "Erreur inconnue dans l'exécution de l'application", e);
    }
  }
  
  private Resultat gestionIndicateurDE(Resultat p_resultat, boolean p_estTraite, boolean p_estAReexecuter)
  {
    ResultatReexecutionCali resultatReexecutionCali = null;
    Resultat resultat = gestionIndicateurDE(p_resultat, p_estTraite);
    if (p_estAReexecuter)
    {
      resultatReexecutionCali = (ResultatReexecutionCali)resultat;
      resultatReexecutionCali.getIndicateursGeneriques().incrementeIndicateur("D12_DE_A_REEXECUTER");
      resultatReexecutionCali.getIndicateursGeneriques().getIndicateur("D12_DE_A_NE_PAS_REEXECUTER");
      resultat = resultatReexecutionCali;
    }
    else
    {
      resultatReexecutionCali = (ResultatReexecutionCali)resultat;
      resultatReexecutionCali.getIndicateursGeneriques().getIndicateur("D12_DE_A_REEXECUTER");
      resultatReexecutionCali.getIndicateursGeneriques().incrementeIndicateur("D12_DE_A_NE_PAS_REEXECUTER");
      resultat = resultatReexecutionCali;
    }
    return resultat;
  }
}

/* Location:
 * Qualified Name:     ParcoursSelectionFinePopulation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */