package fr.unedic.cali.parcours.occasionnel;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.occasionnel.DomLireIndividus;
import fr.unedic.cali.outilsfonctionnels.LireBaseVisu;
import fr.unedic.cali.parcours.AccesDonneesGaecException;
import fr.unedic.cali.parcours.ParcoursServiceAbstrait;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ParcoursChargerIndividus
  extends ParcoursServiceAbstrait
{
  protected void initialiserContexteParcour(Contexte p_contexte) {}
  
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatChargerIndividus resultat = new ResultatChargerIndividus();
    resultat.setEtat(1);
    
    DomLireIndividus dom = (DomLireIndividus)p_contexte.getDonnees();
    
    int indexDepart = dom.getIndexDebutListeIndividus() != null ? dom.getIndexDebutListeIndividus().intValue() : 1;
    if (indexDepart == 0) {
      indexDepart = 1;
    }
    int maxIndividus = 0;
    if (dom.getNbIndividusRecuperes() != null) {
      maxIndividus = dom.getNbIndividusRecuperes().intValue();
    }
    try
    {
      BigDecimal idDemande = dom.getDemandeId();
      Map retourChargementIndividus = LireBaseVisu.chargerIndividus(dom.getCxass(), dom.getFonctRappId(), dom.getCodePopulation(), dom.getRsin(), dom.isRecupEltComp(), dom.isEstFiltreDeDeltaMontantIndemnise(), dom.isEstFiltreDeDeltaMontantFinancement(), dom.isEstFiltreDeDeltaMontantCadt(), dom.isEstFiltreDeDeltaMontantCrc(), dom.isEstFiltreDeReexamen(), dom.getAntenne(), indexDepart, maxIndividus, idDemande, dom.getChampATrier(), dom.getSensTri(), dom.getListeIDRapport());
      
      dom.setListeIndividus((List)retourChargementIndividus.get("listeIndividus"));
      int compteurTotalIndividus = ((Integer)retourChargementIndividus.get("compteurPopulation")).intValue();
      dom.setNbIndividusTotalSelectionnes(new BigDecimal(compteurTotalIndividus));
    }
    catch (TechniqueException e)
    {
      throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE", "Erreur inconnue dans l'exécution de l'application", e);
    }
    resultat.setEtat(0);
    resultat.setDomLireIndividus(dom);
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
 * Qualified Name:     ParcoursChargerIndividus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */