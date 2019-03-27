package fr.unedic.cali.autresdoms.cohab.parcours;

import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.CodeReexamen;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.AlimenterBaseTracker;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.cali.parcours.AccesDonneesGaecException;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.Collection;
import java.util.Map;

public class ParcoursReceptionFluxAR1E58
  extends ParcoursReceptionFluxV1Demandes
{
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    IndividuSpec individu = recupererIndividu(contexte);
    Damj dateReexecution = recupererDateReexecution(contexte);
    String codeReexamen = recupererCodeReexamen(contexte);
    Resultat resultat = new Resultat();
    
    resultat.setEtat(1);
    
    Collection<DemandeSpec> demandesImpactees = null;
    if (!codeReexamen.equals("0"))
    {
      EvenementReexamen evtReexamen = new EvenementReexamen(dateReexecution, codeReexamen);
      
      ResultatGestionnaireReexecutionSpec resultatReexecution = reexecution(individu, evtReexamen);
      demandesImpactees = resultatReexecution.getDemandesReliquidees();
      
      OutilAjoutCremDalLiquidation outilAjoutCrem = initialisationOutilAjouCREM();
      outilAjoutCrem.ajouterCREMDemandesReexecutes(demandesImpactees, individu);
    }
    else
    {
      Map etatsDemandeAvant = OutilFluxSigma.sauvegarderEtatDemandes(individu);
      demandesImpactees = OutilFluxSigma.recupererDemandesImpacteesNonNeutralisees(etatsDemandeAvant, individu, dateReexecution);
    }
    notifierSigma(individu, demandesImpactees);
    
    resultat.setEtat(0);
    return resultat;
  }
  
  protected IndividuSpec recupererIndividu(Contexte contexte)
  {
    return getIndividu(contexte);
  }
  
  protected String recupererCodeReexamen(Contexte contexte)
  {
    ContexteService contexteService = DomReceptionFluxAR1E58.getContexteService(contexte);
    
    AlimenterBaseTracker.alimenterDonneesEnModeReception(contexteService);
    return CodeReexamen.determineCodeReexamen(contexteService);
  }
  
  protected Damj recupererDateReexecution(Contexte contexte)
    throws ContexteException
  {
    Damj dateReexecution = ((DomReceptionFluxAR1E58)contexte.getDonnees()).getDateReexamen();
    if (dateReexecution == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_DATE_REEXECUTION_MANQUANTE");
    }
    return dateReexecution;
  }
  
  protected ResultatGestionnaireReexecutionSpec reexecution(IndividuSpec individu, EvenementReexamen evtReexamen)
    throws ApplicativeException
  {
    return FabriqueGestionnaireReexecution.getGestionnaire().executer(individu, evtReexamen);
  }
  
  protected void notifierSigma(IndividuSpec individu, Collection<DemandeSpec> demandesImpactees)
    throws ApplicativeException
  {
    OutilFluxSigma.notifierSigma(individu, demandesImpactees, false);
  }
  
  protected Damj getDateReexamen(DemandeSpec demande)
  {
    return null;
  }
  
  protected Collection traiterFlux(Contexte contexte)
    throws CoucheLogiqueException
  {
    return null;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    if (individu.getDonneesChargementGaec().getAgregatGaec().isOptimisationPasDeChargementGaec()) {
      return 0;
    }
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
 * Qualified Name:     ParcoursReceptionFluxAR1E58
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */