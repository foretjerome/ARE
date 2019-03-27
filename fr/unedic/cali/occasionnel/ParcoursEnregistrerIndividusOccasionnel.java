package fr.unedic.cali.occasionnel;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.occasionnel.DomEnregistrerIndividusOccasionnel;
import fr.unedic.cali.dom.occasionnel.IndividuOccasionnel;
import fr.unedic.cali.outilsfonctionnels.EcrireBaseVisu;
import fr.unedic.cali.parcours.AccesDonneesGaecException;
import fr.unedic.cali.parcours.ParcoursServiceAbstrait;
import fr.unedic.cali.parcours.occasionnel.ResultatEnregistrerIndividusOccasionnel;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

public class ParcoursEnregistrerIndividusOccasionnel
  extends ParcoursServiceAbstrait
{
  protected void initialiserContexteParcour(Contexte p_contexte) {}
  
  protected Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatEnregistrerIndividusOccasionnel resultat = new ResultatEnregistrerIndividusOccasionnel();
    resultat.setEtat(1);
    
    DomEnregistrerIndividusOccasionnel dom = (DomEnregistrerIndividusOccasionnel)p_contexte.getDonnees();
    String codePopulation = dom.getCodePopulation();
    if (dom.getListeIndividu() != null)
    {
      ListIterator<IndividuOccasionnel> individus = dom.getListeIndividu().listIterator();
      boolean estUnEtatTraitePE = true;
      HashMap<CoupleCodeAntenneRapportId, Boolean> hashMapCodeAntenne = new HashMap();
      
      HashMap<Integer, Boolean> hashMapRapportId = new HashMap();
      try
      {
        for (IndividuOccasionnel individu : dom.getListeIndividu())
        {
          boolean etat = (individu.getEtat() != 0) && (individu.getEtat() != 1);
          if (hashMapRapportId.containsKey(Integer.valueOf(individu.getRapportId())))
          {
            if (!etat) {
              hashMapRapportId.put(Integer.valueOf(individu.getRapportId()), new Boolean(false));
            }
          }
          else {
            hashMapRapportId.put(Integer.valueOf(individu.getRapportId()), new Boolean(etat));
          }
        }
        if (individus != null)
        {
          while (individus.hasNext())
          {
            IndividuOccasionnel individu = (IndividuOccasionnel)individus.next();
            if ((individu.getEtat() == 0) || (individu.getEtat() == 1)) {
              estUnEtatTraitePE = false;
            }
            CoupleCodeAntenneRapportId cle = new CoupleCodeAntenneRapportId();
            String codeAntenne = individu.getCodeAntenne();
            int rapportId = individu.getRapportId();
            cle.setCodeAntenne(codeAntenne);
            cle.setRapportId(rapportId);
            
            hashMapCodeAntenne.put(cle, Boolean.valueOf(((Boolean)hashMapRapportId.get(Integer.valueOf(rapportId))).booleanValue()));
            
            String commentaire = new String();
            if (individu.getCommentaire() != null) {
              commentaire = individu.getCommentaire();
            }
            EcrireBaseVisu.alimentationCommentaireEtatIndividu(new BigDecimal(individu.getCxala()), commentaire, individu.getEtat(), codePopulation, individu.getCxass(), new BigDecimal(rapportId));
          }
          EcrireBaseVisu.alimenterDateTraitementAntenneRegion(hashMapCodeAntenne, hashMapRapportId, codePopulation, dom.getCxass(), dom.getDateTraitement());
        }
      }
      catch (TechniqueException e)
      {
        throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE", "Erreur inconnue dans l'exécution de l'application", e);
      }
    }
    resultat.setEtat(0);
    resultat.setDomEnregistrerIndividusOccasionnel(dom);
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
 * Qualified Name:     ParcoursEnregistrerIndividusOccasionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */