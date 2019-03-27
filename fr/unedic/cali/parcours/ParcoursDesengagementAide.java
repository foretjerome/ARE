package fr.unedic.cali.parcours;

import fr.pe.cali.crem.dom.ObjetMetierCrem;
import fr.pe.cali.crem.outils.OutilGenerationObjetMetierDesengagementAide;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.BilanFinancierAidesMobilite;
import fr.unedic.cali.dom.DomDesengagementAide;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.OutilDesengagementAide;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.Resultat;
import java.util.List;

public class ParcoursDesengagementAide
  extends ParcoursServiceAbstrait
{
  protected Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    Resultat resultat = new Resultat();
    DomDesengagementAide dom = (DomDesengagementAide)contexte.getDonnees();
    
    BilanFinancierAidesMobilite bilanFinancierAidesMobilite = OutilDesengagementAide.getInstance().getResultBilanFinancierAidesMobilite(dom.getIndividu(), dom.getReferenceExterne());
    if (bilanFinancierAidesMobilite.estDesengagementPossible())
    {
      ObjetMetierCrem crem = OutilGenerationObjetMetierDesengagementAide.getInstance().genererObjetMetier(bilanFinancierAidesMobilite.getAttribution().getDemande(), dom.getIndividu().getContexteService());
      
      dom.getIndividu().getListeCrem().add(crem);
      
      OutilDesengagementAide.getInstance().forcerDesengagementSurDemandeAideMob(bilanFinancierAidesMobilite);
    }
    resultat.setEtat(0);
    return resultat;
  }
  
  protected void preAlimenterAgregatGaec(Individu individu, String idDemande) {}
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 0;
  }
  
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    DomDesengagementAide dom = (DomDesengagementAide)contexte.getDonnees();
    
    IndividuSpec individuCourant = getIndividu(contexte);
    if (individuCourant == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "Individu absent du contexte");
    }
    if (dom.getReferenceExterne() == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Reference externe absente ");
    }
  }
}

/* Location:
 * Qualified Name:     ParcoursDesengagementAide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */