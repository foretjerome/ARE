package fr.unedic.cali.occasionnel;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.occasionnel.DomEnregistrerNationalOccasionnel;
import fr.unedic.cali.outilsfonctionnels.EcrireBaseVisu;
import fr.unedic.cali.parcours.AccesDonneesGaecException;
import fr.unedic.cali.parcours.ParcoursServiceAbstrait;
import fr.unedic.cali.parcours.occasionnel.ResultatEnregistrerNationalOccasionnel;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;

public class ParcoursEnregistrerNationalOccasionnel
  extends ParcoursServiceAbstrait
{
  protected void initialiserContexteParcour(Contexte p_contexte) {}
  
  protected Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatEnregistrerNationalOccasionnel resultat = new ResultatEnregistrerNationalOccasionnel();
    resultat.setEtat(1);
    
    DomEnregistrerNationalOccasionnel dom = (DomEnregistrerNationalOccasionnel)p_contexte.getDonnees();
    try
    {
      EcrireBaseVisu.ecrireConsignes(dom.getConsigne1(), dom.getConsigne2(), dom.getConsigne3(), dom.getCodePopulation());
    }
    catch (TechniqueException e)
    {
      throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE", "Erreur inconnue dans l'exécution de l'application", e);
    }
    resultat.setEtat(0);
    resultat.setDomEnregistrerNationalOccasionnel(dom);
    return resultat;
  }
  
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {
    if (null == p_contexte) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE_ABSENT");
    }
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande) {}
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {}
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     ParcoursEnregistrerNationalOccasionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */