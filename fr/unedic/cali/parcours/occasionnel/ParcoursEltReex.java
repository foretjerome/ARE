package fr.unedic.cali.parcours.occasionnel;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.occasionnel.DomLireEltReex;
import fr.unedic.cali.outilsfonctionnels.LireBaseVisu;
import fr.unedic.cali.parcours.AccesDonneesGaecException;
import fr.unedic.cali.parcours.ParcoursServiceAbstrait;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;

public class ParcoursEltReex
  extends ParcoursServiceAbstrait
{
  protected void initialiserContexteParcour(Contexte contexte) {}
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatEltReex resultat = new ResultatEltReex();
    resultat.setEtat(1);
    
    DomLireEltReex dom = (DomLireEltReex)contexte.getDonnees();
    try
    {
      if ((dom.getLibElement() != null) && (!dom.getLibElement().equals(""))) {
        dom.setListeEltExclu(LireBaseVisu.chargerEltReexAvecLibElement(dom.getListeIdRapport(), dom.getCodePopulation(), dom.getLibElement()));
      } else {
        dom.setListeEltExclu(LireBaseVisu.chargerEltReex(dom.getListeIdRapport(), dom.getCodePopulation()));
      }
    }
    catch (TechniqueException e)
    {
      throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE", "Erreur inconnue dans l'exécution de l'application", e);
    }
    resultat.setEtat(0);
    resultat.setDomLireEltReex(dom);
    return resultat;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 0;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
}

/* Location:
 * Qualified Name:     ParcoursEltReex
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */