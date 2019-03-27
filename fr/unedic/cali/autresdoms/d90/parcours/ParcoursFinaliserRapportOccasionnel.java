package fr.unedic.cali.autresdoms.d90.parcours;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.autresdoms.d90.dom.DomFinaliserRapportOccasionnel;
import fr.unedic.cali.outilsfonctionnels.EcrireBaseVisu;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.services.Resultat;

public class ParcoursFinaliserRapportOccasionnel
  extends Parcours
{
  public Resultat demarrer(Contexte p_contexte)
    throws CoucheLogiqueException
  {
    DomFinaliserRapportOccasionnel dom = (DomFinaliserRapportOccasionnel)p_contexte.getDonnees();
    
    ResultatFinaliserRapportOccasionnel resultatFinaliserRapport = new ResultatFinaliserRapportOccasionnel();
    alimenterResultatFinaliserRapport(resultatFinaliserRapport, dom);
    try
    {
      EcrireBaseVisu.finaliserRapportBaseVisu(resultatFinaliserRapport);
      resultatFinaliserRapport.setEtat(0);
    }
    catch (TechniqueException ex)
    {
      throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE", "Erreur inconnue dans l'exécution de l'application", ex);
    }
    return resultatFinaliserRapport;
  }
  
  private void alimenterResultatFinaliserRapport(ResultatFinaliserRapportOccasionnel p_resultatFinaliserRapport, DomFinaliserRapportOccasionnel p_dom)
  {
    p_resultatFinaliserRapport.setCodeAssedic(p_dom.getCodeAssedic());
    p_resultatFinaliserRapport.setIdentifiantRedressement(p_dom.getIdentifiantRedressement());
    p_resultatFinaliserRapport.setModeRedressement(p_dom.getModeRedressement());
    p_resultatFinaliserRapport.setNomChaine(p_dom.getNomChaine());
    p_resultatFinaliserRapport.setNomOccasionnel(p_dom.getNomOccasionnel());
    p_resultatFinaliserRapport.setNumeroPassage(p_dom.getNumeroPassage());
    p_resultatFinaliserRapport.setRedressement(p_dom.getRedressement());
  }
  
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {
    if (p_contexte == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE_ABSENT", "Le contexte ne doit pas être null", null);
    }
    DomFinaliserRapportOccasionnel dom = (DomFinaliserRapportOccasionnel)p_contexte.getDonnees();
    if (dom == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DOM", "Le Dom ne doit pas être null.", null);
    }
    if (dom.getCodeAssedic() == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Le numero pôle emploi ne doit pas être null.", null);
    }
    if (dom.getIdentifiantRedressement() == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "L'identifiant de redressement ne doit pas être null.", null);
    }
    if (dom.getNomChaine() == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Le nomde chaîne ne doit pas être null.", null);
    }
  }
}

/* Location:
 * Qualified Name:     ParcoursFinaliserRapportOccasionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */