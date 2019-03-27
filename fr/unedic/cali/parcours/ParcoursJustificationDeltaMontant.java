package fr.unedic.cali.parcours;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.outilsfonctionnels.LireBaseVisu;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import java.util.Collection;

public class ParcoursJustificationDeltaMontant
  extends ParcoursServiceAbstrait
{
  protected void initialiserContexteParcour(Contexte p_contexte) {}
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
  
  protected Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatJustificationDeltaMontant resultat = new ResultatJustificationDeltaMontant();
    resultat.setEtat(1);
    
    DomJustificationDeltaMontant dom = (DomJustificationDeltaMontant)p_contexte.getDonnees();
    try
    {
      Collection deltasMontantMensuels = LireBaseVisu.chargerDeltasMontantsMensuels(dom.getCxass(), dom.getCxalaf(), dom.getFonctRappId(), dom.getCodePopulation());
      
      resultat.setListeDeltasMontantsMensuels(deltasMontantMensuels);
    }
    catch (TechniqueException e)
    {
      throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE", "Erreur inconnue dans l'exécution de l'application", e);
    }
    resultat.setEtat(0);
    return resultat;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     ParcoursJustificationDeltaMontant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */