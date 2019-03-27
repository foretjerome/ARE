package fr.unedic.cali.parcours;

import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import java.util.Collection;

public class ParcoursMettreEnReexamenDemande
  extends ParcoursServiceAbstrait
{
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    if (getIndividu(contexte) == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "L'allocataire demandeur est obligatoire");
    }
    if (getIdDemande(contexte) == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_ID_DEMANDE", "L'identifiant de la demande est obligatoire");
    }
    DemandeSpec demande = getIndividu(contexte).rechercherDemande(getIdDemande(contexte));
    if (demande.estNeutraliseeLiquidation()) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_ID_DEMANDE", "Ce service n'est pas possible pour des demandes neutralisées");
    }
  }
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatServiceDemande resultatParcours = new ResultatServiceDemande();
    
    resultatParcours.setEtat(1);
    
    IndividuSpec individu = recupererIndividu(contexte);
    
    DemandeSpec demande = recupererDemandeMiseEnReexamen(contexte, individu);
    
    ResultatGestionnaireReexecutionSpec resultatReexecution = reexecution(demande);
    
    OutilAjoutCremDalLiquidation outilAjoutCrem = initialisationOutilAjouCREM();
    outilAjoutCrem.ajouterCREMDemandesReexecutes(resultatReexecution.getDemandesReliquidees(), individu);
    
    notifierSigma(demande, resultatReexecution, individu);
    
    resultatParcours.setDemande(demande);
    resultatParcours.setEtat(0);
    
    return resultatParcours;
  }
  
  protected IndividuSpec recupererIndividu(Contexte contexte)
  {
    IndividuSpec individu = getIndividu(contexte);
    
    OutilFluxSigma.sauvegarderEtatDemandes(getIndividu(contexte));
    return individu;
  }
  
  protected DemandeSpec recupererDemandeMiseEnReexamen(Contexte contexte, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    String identifiantDemande = getIdDemande(contexte);
    DemandeSpec demande = individu.rechercherDemande(identifiantDemande);
    
    demande.ajouterMotifReexamen("1");
    
    demande.getGamme().mettreEnReexamen(demande);
    return demande;
  }
  
  protected ResultatGestionnaireReexecutionSpec reexecution(DemandeSpec demande)
    throws ApplicativeException
  {
    return FabriqueGestionnaireReexecution.getGestionnaire().executerSurReexamenManuel(demande);
  }
  
  protected void notifierSigma(DemandeSpec demande, ResultatGestionnaireReexecutionSpec resultatReexecution, IndividuSpec individu)
    throws ApplicativeException
  {
    resultatReexecution.getDemandesReliquidees().add(demande);
    
    OutilFluxSigma.notifierSigma(individu, resultatReexecution.getDemandesReliquidees(), false);
  }
  
  protected OutilAjoutCremDalLiquidation initialisationOutilAjouCREM()
  {
    return OutilAjoutCremDalLiquidation.getInstance();
  }
  
  private String getIdDemande(Contexte contexte)
  {
    return ((DomLiquidationDemande)contexte.getDonnees()).getIdDemande();
  }
  
  public void verifierContexte(DemandeSpec demande)
    throws ApplicativeException
  {
    if (demande != null) {
      demande.getEvenementReferenceExamen().verifierContexte(demande);
    }
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    if (individu != null) {
      individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
    }
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
}

/* Location:
 * Qualified Name:     ParcoursMettreEnReexamenDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */