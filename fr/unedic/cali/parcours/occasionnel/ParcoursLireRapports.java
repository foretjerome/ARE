package fr.unedic.cali.parcours.occasionnel;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.occasionnel.DomLireRapport;
import fr.unedic.cali.outilsfonctionnels.LireBaseVisu;
import fr.unedic.cali.parcours.AccesDonneesGaecException;
import fr.unedic.cali.parcours.ParcoursServiceAbstrait;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import java.util.ArrayList;
import java.util.List;

public class ParcoursLireRapports
  extends ParcoursServiceAbstrait
{
  protected void initialiserContexteParcour(Contexte p_contexte) {}
  
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatLireRapports resultat = new ResultatLireRapports();
    resultat.setEtat(1);
    
    DomLireRapport dom = (DomLireRapport)p_contexte.getDonnees();
    try
    {
      List listeDesRapports = new ArrayList();
      if (dom.isChargementReduit()) {
        listeDesRapports = LireBaseVisu.chargerRapports(dom.getCxass(), dom.getAntenne(), dom.isEstSimulationChangement(), false);
      } else if (dom.getCxass() == null) {
        listeDesRapports = LireBaseVisu.chargerRapports(null, dom.getAntenne(), dom.isEstSimulationChangement(), true);
      } else if ((dom.getCxass() != null) && (dom.getRsin() != null)) {
        listeDesRapports = LireBaseVisu.chargerRapportsDE(dom.getCxass(), dom.getRsin(), dom.getAntenne(), dom.getCxala(), dom.isEstSimulationChangement());
      } else {
        listeDesRapports = LireBaseVisu.chargerRapports(dom.getCxass(), dom.getAntenne(), dom.isEstSimulationChangement(), true);
      }
      dom.setListeRetour(listeDesRapports);
    }
    catch (TechniqueException e)
    {
      throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE", "Erreur inconnue dans l'exécution de l'application", e);
    }
    resultat.setEtat(0);
    resultat.setDomLireRapport(dom);
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
 * Qualified Name:     ParcoursLireRapports
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */