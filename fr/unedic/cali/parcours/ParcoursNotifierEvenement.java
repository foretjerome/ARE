package fr.unedic.cali.parcours;

import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.AlimenterBaseTracker;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.outilsfonctionnels.GestionIndicateurs;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ParcoursNotifierEvenement
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    DomNotificationEvenement dom = recupererDom(contexte);
    IndividuSpec individu = recupererIndividu(contexte);
    
    ResultatNotifierEvenement resultatNotifierEvenement = new ResultatNotifierEvenement();
    
    Map etatsDemandeAvant = recupererEtatDemandeAvant(individu);
    
    alimenterTracker(contexte);
    
    Damj dateDebut = recupererDateEvenement(contexte, dom);
    
    EvenementReexamen evtReexamen = null;
    Collection demandesImpactees;
    if (dateDebut.estAvant(Damj.FIN_DES_TEMPS))
    {
      evtReexamen = new EvenementReexamen(dateDebut, "5");
      ResultatGestionnaireReexecutionSpec resultatReexecution = reexecution(dom, evtReexamen);
      Collection demandesImpactees = resultatReexecution.getDemandesReliquidees();
      
      OutilAjoutCremDalLiquidation outilAjoutCrem = initialisationOutilAjouCREM();
      outilAjoutCrem.ajouterCREMDemandesReexecutes(demandesImpactees, individu);
    }
    else
    {
      Damj dateEvenement = ((DomNotificationEvenement)contexte.getDonnees()).getDateEvenement();
      demandesImpactees = OutilFluxSigma.recupererDemandesImpacteesNonNeutralisees(etatsDemandeAvant, individu, dateEvenement);
    }
    notifierSigma(demandesImpactees, etatsDemandeAvant, individu, resultatNotifierEvenement);
    return resultatNotifierEvenement;
  }
  
  protected DomNotificationEvenement recupererDom(Contexte contexte)
  {
    return (DomNotificationEvenement)contexte.getDonnees();
  }
  
  protected IndividuSpec recupererIndividu(Contexte contexte)
  {
    return getIndividu(contexte);
  }
  
  protected void alimenterTracker(Contexte contexte)
  {
    if ((((DomNotificationEvenement)contexte.getDonnees()).getContexteService() == null) || (((DomNotificationEvenement)contexte.getDonnees()).getContexteService().getContexteEmission() == null) || (((DomNotificationEvenement)contexte.getDonnees()).getContexteService().getContexteEmission().equals("TP"))) {
      AlimenterBaseTracker.alimenterDonneesEnModeReception(((DomNotificationEvenement)contexte.getDonnees()).getContexteService());
    }
  }
  
  protected Damj recupererDateEvenement(Contexte contexte, DomNotificationEvenement dom)
  {
    Damj dateDebut = Damj.FIN_DES_TEMPS;
    if (((DomNotificationEvenement)contexte.getDonnees()).getDateEvenement() != null)
    {
      dateDebut = ((DomNotificationEvenement)contexte.getDonnees()).getDateEvenement();
    }
    else
    {
      List listePeriodes = dom.getListePeriodesGaec();
      Iterator iterator = listePeriodes.iterator();
      while (iterator.hasNext())
      {
        Periode periode = (Periode)iterator.next();
        if (periode.getDebut().estAvant(dateDebut)) {
          dateDebut = periode.getDebut();
        }
      }
    }
    return dateDebut;
  }
  
  protected Map recupererEtatDemandeAvant(IndividuSpec individu)
  {
    return OutilFluxSigma.sauvegarderEtatDemandes(individu);
  }
  
  protected ResultatGestionnaireReexecutionSpec reexecution(DomNotificationEvenement dom, EvenementReexamen evtReexamen)
    throws ApplicativeException
  {
    return FabriqueGestionnaireReexecution.getGestionnaire().executer(dom.getIndividu(), evtReexamen);
  }
  
  protected void notifierSigma(Collection demandesImpactees, Map etatsDemandeAvant, IndividuSpec individu, ResultatNotifierEvenement resultatNotifierEvenement)
    throws ApplicativeException
  {
    OutilFluxSigma.notifierSigma(individu, demandesImpactees, true);
    
    Collection demandesModifiees = OutilFluxSigma.recupererDemandesModifiees(etatsDemandeAvant, individu);
    
    resultatNotifierEvenement.setIndicateursGeneriques(GestionIndicateurs.creerIndicateurs(individu, demandesModifiees));
  }
  
  protected OutilAjoutCremDalLiquidation initialisationOutilAjouCREM()
  {
    return OutilAjoutCremDalLiquidation.getInstance();
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
 * Qualified Name:     ParcoursNotifierEvenement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */