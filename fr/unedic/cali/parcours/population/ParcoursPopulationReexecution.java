package fr.unedic.cali.parcours.population;

import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.CriteresTrancheDeVie;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.InfoTrancheDeVieSpec;
import fr.unedic.cali.autresdoms.d90.dom.Individu;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.liquidation.outilsfonctionnels.OutilComparaisonBasePivot;
import fr.unedic.cali.outilsfonctionnels.AppelServicesCojac;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.outilsfonctionnels.GestionIndicateurs;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.ResultatReexecutionCali;
import fr.unedic.cali.parcours.ResultatVisualisationReexecution;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

public class ParcoursPopulationReexecution
  extends ParcoursPopulationAbstraite
  implements ParcoursPopulationSpec
{
  private String codeMiseEnReexamen;
  
  public ParcoursPopulationReexecution()
  {
    codeMiseEnReexamen = "12";
  }
  
  public ParcoursPopulationReexecution(String codeMiseEnReexamen)
  {
    this.codeMiseEnReexamen = codeMiseEnReexamen;
  }
  
  public Resultat demarrer(Contexte contexte)
    throws ApplicativeException
  {
    ResultatVisualisationReexecution resultatVisualisation = new ResultatVisualisationReexecution();
    
    ResultatReexecutionCali resultatReexecutionCali = new ResultatReexecutionCali();
    DomTraitementOccasionnel domReexecutionCali = (DomTraitementOccasionnel)contexte.getDonnees();
    
    resultatVisualisation.setRedressementSpec(domReexecutionCali.getRedressement());
    
    IndividuSpec individu = domReexecutionCali.getIndividu();
    Damj dateReexecution = domReexecutionCali.getDate();
    PopulationSpec population = domReexecutionCali.getPopulation();
    ComportementSpec comportement = definirComportement(population);
    
    Map etatsDemandeAvant = OutilFluxSigma.sauvegarderEtatDemandes(individu);
    if (dateReexecution == null) {
      dateReexecution = Damj.NUIT_DES_TEMPS;
    }
    EvenementReexamen evtReexamen = new EvenementReexamen(dateReexecution, codeMiseEnReexamen);
    
    ResultatGestionnaireReexecutionSpec resultatReexecution = FabriqueGestionnaireReexecution.getGestionnaire().executer(individu, evtReexamen, comportement);
    
    alimenterResultatVisualisation(resultatVisualisation, resultatReexecution, domReexecutionCali, comportement, resultatReexecution.getDateReexecution());
    
    OutilAjoutCremDalLiquidation.getInstance().ajouterCREMDemandesReexecutes(resultatReexecution.getDemandesReliquidees(), individu);
    
    Collection demandesImpactees = resultatReexecution.getDemandesReliquidees();
    
    Map copieDemandesImpactees = OutilComparaisonBasePivot.getCopieDemandesPivots(demandesImpactees);
    
    boolean appelTCIS = false;
    if ("D11".equals(individu.getDomaineSrcFlux())) {
      appelTCIS = true;
    }
    OutilFluxSigma.notifierSigma(individu, demandesImpactees, appelTCIS);
    
    Collection demandesModifiees = OutilFluxSigma.recupererDemandesModifiees(etatsDemandeAvant, individu);
    if (comportement.isComparerBasesPivotsEchanges()) {
      OutilComparaisonBasePivot.comparerDemandes(copieDemandesImpactees, demandesImpactees, resultatVisualisation);
    }
    resultatReexecutionCali.setEtat(0);
    resultatReexecutionCali.setFailure(false);
    resultatReexecutionCali.setIndicateursGeneriques(GestionIndicateurs.creerIndicateurs(individu, demandesModifiees));
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin Parcours ParcoursReexecutionCali ********\n");
    }
    ecrireEnBaseVisu(resultatVisualisation, comportement);
    
    resultatReexecutionCali.setIndividuVisu(resultatVisualisation.getIndividu());
    return resultatReexecutionCali;
  }
  
  private void alimenterResultatVisualisation(ResultatVisualisationReexecution resultatVisualisation, ResultatGestionnaireReexecutionSpec resultatReexecution, DomTraitementOccasionnel domReexecutionCali, ComportementSpec comportement, Damj dateReexecution)
    throws CoucheLogiqueException
  {
    if (comportement.isEcrireEnBaseVisu())
    {
      resultatVisualisation.setIndividu(resultatReexecution.getIndividuVisu());
      Individu individu = resultatVisualisation.getIndividu();
      if (individu != null)
      {
        individu.setRsin(domReexecutionCali.getContexteService().getRsin());
        individu.setCxala(domReexecutionCali.getContexteService().getCxala().toString());
        individu.setCxass(domReexecutionCali.getRedressement().getCodeAssedic());
        individu.setModeCreation("R");
        individu.setPopulation(domReexecutionCali.getPopulation());
        individu.setDateReexecution(dateReexecution);
        
        CriteresTrancheDeVie critere = new CriteresTrancheDeVie();
        critere.setCodeAssedic(individu.getCxass());
        critere.setIdentifiantNCP(individu.getCxala());
        try
        {
          individu.setAntenne(AppelServicesCojac.lectureTrancheDeVie(critere).getCodeAntenne());
        }
        catch (TechniqueException tE)
        {
          throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GDP", "Problème lors de l'appel de service de CALI vers GDP", tE);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationReexecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */