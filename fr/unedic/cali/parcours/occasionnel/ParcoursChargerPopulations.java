package fr.unedic.cali.parcours.occasionnel;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.occasionnel.DomLirePopulations;
import fr.unedic.cali.outilsfonctionnels.LireBaseVisu;
import fr.unedic.cali.parcours.AccesDonneesGaecException;
import fr.unedic.cali.parcours.ParcoursServiceAbstrait;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import java.util.List;

public class ParcoursChargerPopulations
  extends ParcoursServiceAbstrait
{
  protected void initialiserContexteParcour(Contexte p_contexte) {}
  
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatChargerPopulations resultat = new ResultatChargerPopulations();
    resultat.setEtat(1);
    
    DomLirePopulations dom = (DomLirePopulations)p_contexte.getDonnees();
    try
    {
      List listeDesPopulations = null;
      if (dom.isEstDsi()) {
        listeDesPopulations = LireBaseVisu.chargerPopulations(dom.getListeIdRapport(), dom.getCodePopulation());
      } else {
        listeDesPopulations = LireBaseVisu.chargerPopulations(dom.getCxass(), dom.getListeIdRapport(), dom.getCodePopulation(), dom.isEstDsi());
      }
      dom.setListeRetour(listeDesPopulations);
    }
    catch (TechniqueException e)
    {
      throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE", "Erreur inconnue dans l'exécution de l'application", e);
    }
    resultat.setEtat(0);
    resultat.setDomLirePopulations(dom);
    return resultat;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 0;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
}

/* Location:
 * Qualified Name:     ParcoursChargerPopulations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */