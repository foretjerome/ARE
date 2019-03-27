package fr.unedic.cali.parcours;

import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementTPDefaut;
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementTPRestitutionSimu;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Indicateur;
import fr.unedic.cali.dom.IndicateursGeneriques;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.outilsfonctionnels.GestionIndicateurs;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.Collection;
import java.util.Map;

public class ParcoursReexecutionCali
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatReexecutionCali resultatReexecutionCali = new ResultatReexecutionCali();
    
    DomReexecutionCali domReexecutionCali = (DomReexecutionCali)contexte.getDonnees();
    
    String codeReexamen = recupererCodeExamen(domReexecutionCali);
    
    IndividuSpec individu = domReexecutionCali.getIndividu();
    Damj dateReexecution = domReexecutionCali.getDate();
    ComportementSpec comportement = null;
    if (domReexecutionCali.isRestitutionVisu()) {
      comportement = new ComportementTPRestitutionSimu();
    } else {
      comportement = new ComportementTPDefaut();
    }
    Map etatsDemandeAvant = sigmaEtatDemande(individu);
    if (dateReexecution == null) {
      dateReexecution = Damj.NUIT_DES_TEMPS;
    }
    EvenementReexamen evtReexamen = new EvenementReexamen(dateReexecution, codeReexamen);
    
    ResultatGestionnaireReexecutionSpec resultatReexecution = reexecution(individu, evtReexamen, comportement);
    
    OutilAjoutCremDalLiquidation outilAjoutCrem = initialisationOutilAjouCREM();
    outilAjoutCrem.ajouterCREMDemandesReexecutes(resultatReexecution.getDemandesReliquidees(), individu);
    
    Collection demandesModifiees = notifierSigma(individu, evtReexamen, resultatReexecution, etatsDemandeAvant);
    
    miseAJourResultat(resultatReexecutionCali, resultatReexecution, individu, demandesModifiees);
    
    return gestionIndicateurDE(resultatReexecutionCali, true);
  }
  
  protected ResultatGestionnaireReexecutionSpec reexecution(IndividuSpec individu, EvenementReexamen evtReexamen, ComportementSpec comportement)
    throws ApplicativeException
  {
    return FabriqueGestionnaireReexecution.getGestionnaire().executer(individu, evtReexamen, comportement);
  }
  
  protected Map sigmaEtatDemande(IndividuSpec individu)
  {
    return OutilFluxSigma.sauvegarderEtatDemandes(individu);
  }
  
  protected String recupererCodeExamen(DomReexecutionCali domReexecutionCali)
  {
    String codeReexamen = "1";
    if ((domReexecutionCali.getIndividu().getDateExecutionDifferee() != null) && (domReexecutionCali.getIndividu().getDateExecutionDifferee().equals(domReexecutionCali.getDate())) && (domReexecutionCali.getIndividu().getCodeTransaction() != null)) {
      codeReexamen = domReexecutionCali.getIndividu().getCodeTransaction();
    }
    return codeReexamen;
  }
  
  protected void miseAJourResultat(ResultatReexecutionCali resultatReexecutionCali, ResultatGestionnaireReexecutionSpec resultatReexecution, IndividuSpec individu, Collection demandesModifiees)
  {
    resultatReexecutionCali.setEtat(0);
    resultatReexecutionCali.setFailure(false);
    resultatReexecutionCali.setIndicateursGeneriques(GestionIndicateurs.creerIndicateurs(individu, demandesModifiees));
    resultatReexecutionCali.setIndividuVisu(resultatReexecution.getIndividuVisu());
  }
  
  protected Collection notifierSigma(IndividuSpec individu, EvenementReexamen evtReexamen, ResultatGestionnaireReexecutionSpec resultatReexecution, Map etatsDemandeAvant)
    throws ApplicativeException
  {
    boolean appelTCIS = false;
    if ("D11".equals(individu.getDomaineSrcFlux())) {
      appelTCIS = true;
    }
    OutilFluxSigma.notifierSigma(individu, resultatReexecution.getDemandesReliquidees(), appelTCIS);
    return OutilFluxSigma.recupererDemandesModifiees(etatsDemandeAvant, individu);
  }
  
  protected OutilAjoutCremDalLiquidation initialisationOutilAjouCREM()
  {
    return OutilAjoutCremDalLiquidation.getInstance();
  }
  
  protected Resultat gestionIndicateurDE(Resultat resultat, boolean estTraite)
  {
    ResultatReexecutionCali resultatReexecutionCali = null;
    if (estTraite)
    {
      resultatReexecutionCali = (ResultatReexecutionCali)resultat;
      resultatReexecutionCali.getIndicateursGeneriques().incrementeIndicateur("D12_DE_TRAITE");
      resultatReexecutionCali.getIndicateursGeneriques().getIndicateur("D12_DE_NON_TRAITE");
    }
    else
    {
      resultatReexecutionCali = new ResultatReexecutionCali();
      IndicateursGeneriques listeIndicateurs = new IndicateursGeneriques();
      listeIndicateurs.getIndicateur("D12_DE_NON_TRAITE").incremente();
      listeIndicateurs.getIndicateur("D12_DE_TRAITE");
      resultatReexecutionCali.setIndicateursGeneriques(listeIndicateurs);
      resultatReexecutionCali.setEtat(1);
    }
    return resultatReexecutionCali;
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
 * Qualified Name:     ParcoursReexecutionCali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */