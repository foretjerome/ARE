package fr.unedic.cali.parcours.population;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.CriteresTrancheDeVie;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.InfoTrancheDeVieSpec;
import fr.unedic.cali.autresdoms.d90.dom.Demande;
import fr.unedic.cali.autresdoms.d90.dom.Individu;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.RejetSpec;
import fr.unedic.cali.outilsfonctionnels.AppelLiquidation;
import fr.unedic.cali.outilsfonctionnels.AppelServicesCojac;
import fr.unedic.cali.outilsfonctionnels.GestionIndicateurs;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.cali.parcours.ResultatReexecutionCali;
import fr.unedic.cali.parcours.ResultatVisualisationReexecution;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ParcoursPopulationLiquidationSimplifiee
  extends ParcoursPopulationAbstraite
{
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatReexecutionCali resultat = new ResultatReexecutionCali();
    
    Collection demandesRedressees = redresserDemandeSimplifiee(getIndividu(p_contexte));
    OutilFluxSigma.notifierSigma(getIndividu(p_contexte), demandesRedressees, false);
    ResultatVisualisationReexecution resultatVisu = genererBaseVisu(p_contexte, demandesRedressees);
    ecrireEnBaseVisu(resultatVisu, getComportement(p_contexte));
    
    resultat.setEtat(0);
    resultat.setFailure(false);
    resultat.setIndicateursGeneriques(GestionIndicateurs.creerIndicateurs(getIndividu(p_contexte), null));
    return resultat;
  }
  
  private Collection redresserDemandeSimplifiee(IndividuSpec p_individu)
  {
    ArrayList demandesCorrigees = new ArrayList();
    
    Chronologie demandesAsu = p_individu.getChronoDemandeAssurance();
    demandesAsu.iterer();
    while (demandesAsu.encoreSuivant())
    {
      DemandeSpec demande = (DemandeSpec)demandesAsu.elementSuivant();
      if ("C".equals(demande.getModeLiquidation()))
      {
        List dossiersExamen = demande.getListeDossiersExamen();
        if (!dossiersExamen.isEmpty())
        {
          DecisionSpec decision = (DecisionSpec)dossiersExamen.get(0);
          if ((decision.getNatureDecision() == 0) && ((decision instanceof RejetSpec)))
          {
            decision.setNatureDecision(33);
            demande.setCodeMotifEchecPourSigma("41");
            if (demande.estEnReExamen()) {
              demande.setListeMotifsReexamen(null);
            }
            demandesCorrigees.add(demande);
          }
        }
      }
    }
    return demandesCorrigees;
  }
  
  private ResultatVisualisationReexecution genererBaseVisu(Contexte p_contexte, Collection p_demandesRedressees)
    throws CoucheLogiqueException
  {
    ResultatVisualisationReexecution resultat = new ResultatVisualisationReexecution();
    
    resultat.setRedressementSpec(getDom(p_contexte).getRedressement());
    Individu individu = new Individu();
    resultat.setIndividu(individu);
    
    individu.setRsin(getDom(p_contexte).getContexteService().getRsin());
    individu.setCxala(getDom(p_contexte).getContexteService().getCxala().toString());
    individu.setCxass(getDom(p_contexte).getRedressement().getCodeAssedic());
    individu.setModeCreation("R");
    individu.setPopulation(getDom(p_contexte).getPopulation());
    individu.setDateReexecution(PopulationSpec.DATE_LIMITE_NON_REEXECUTION);
    
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
    Iterator it = p_demandesRedressees.iterator();
    while (it.hasNext())
    {
      DemandeSpec demandeCourante = (DemandeSpec)it.next();
      Demande demandeVisu = new Demande();
      demandeVisu.setElementsComparaisonReexamen(new ArrayList());
      demandeVisu.setEtatReexamen("V");
      AppelLiquidation.alimenterDemandeVisu(demandeVisu, demandeCourante, getComportement(p_contexte));
      resultat.getIndividu().ajouterDemande(demandeVisu);
    }
    return resultat;
  }
  
  private ComportementSpec getComportement(Contexte p_contexte)
  {
    return getDom(p_contexte).getPopulation().getComportement();
  }
  
  private DomTraitementOccasionnel getDom(Contexte p_contexte)
  {
    return (DomTraitementOccasionnel)p_contexte.getDonnees();
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationLiquidationSimplifiee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */