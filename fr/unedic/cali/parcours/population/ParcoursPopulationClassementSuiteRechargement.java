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
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
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

public class ParcoursPopulationClassementSuiteRechargement
  extends ParcoursPopulationAbstraite
{
  public Resultat demarrer(Contexte contexte)
    throws ApplicativeException
  {
    ResultatReexecutionCali resultat = new ResultatReexecutionCali();
    
    ArrayList<DemandeSpec> listeDemandesRechargements = recupererDemandeRechargementACorriger(getIndividu(contexte));
    OutilFluxSigma.notifierSigma(getIndividu(contexte), listeDemandesRechargements, false);
    ResultatVisualisationReexecution resultatVisu = genererBaseVisu(contexte, listeDemandesRechargements);
    ecrireEnBaseVisu(resultatVisu, getComportement(contexte));
    
    resultat.setEtat(0);
    resultat.setFailure(false);
    resultat.setIndicateursGeneriques(GestionIndicateurs.creerIndicateurs(getIndividu(contexte), null));
    return resultat;
  }
  
  private ArrayList<DemandeSpec> recupererDemandeRechargementACorriger(IndividuSpec individu)
  {
    ArrayList<DemandeSpec> listeDemandesRechargements = new ArrayList();
    Chronologie demandesAsu = individu.getChronoDemandeAssurance();
    demandesAsu.iterer();
    while (demandesAsu.encoreSuivant())
    {
      DemandeSpec demande = (DemandeSpec)demandesAsu.elementSuivant();
      if (estDemandeEligible(demande)) {
        listeDemandesRechargements.add(demande);
      }
    }
    return listeDemandesRechargements;
  }
  
  private boolean estDemandeEligible(DemandeSpec demande)
  {
    return ("ASU_29".equals(demande.getEvenementReferenceExamen().getTypeExamen())) && (demande.getClassementAdministratif() != null) && ("SS".equals(demande.getClassementAdministratif().getTypeClassement())) && (demande.getDemandePivot() == null);
  }
  
  private ResultatVisualisationReexecution genererBaseVisu(Contexte contexte, Collection<DemandeSpec> demandesRedressees)
    throws CoucheLogiqueException
  {
    ResultatVisualisationReexecution resultat = new ResultatVisualisationReexecution();
    
    resultat.setRedressementSpec(getDom(contexte).getRedressement());
    Individu individu = new Individu();
    resultat.setIndividu(individu);
    
    individu.setRsin(getDom(contexte).getContexteService().getRsin());
    individu.setCxala(getDom(contexte).getContexteService().getCxala().toString());
    individu.setCxass(getDom(contexte).getRedressement().getCodeAssedic());
    individu.setModeCreation("R");
    individu.setPopulation(getDom(contexte).getPopulation());
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
    Iterator<DemandeSpec> it = demandesRedressees.iterator();
    while (it.hasNext())
    {
      DemandeSpec demandeCourante = (DemandeSpec)it.next();
      Demande demandeVisu = new Demande();
      demandeVisu.setElementsComparaisonReexamen(new ArrayList());
      demandeVisu.setEtatReexamen("V");
      alimenterDemandeVisu(demandeVisu, demandeCourante, getComportement(contexte));
      resultat.getIndividu().ajouterDemande(demandeVisu);
    }
    return resultat;
  }
  
  private void alimenterDemandeVisu(Demande p_demandeVisu, DemandeSpec p_demande, ComportementSpec p_comportement)
  {
    if ((p_comportement != null) && (p_comportement.isEcrireEnBaseVisu()))
    {
      p_demandeVisu.setIdDemande(p_demande.getIdentifiant());
      p_demandeVisu.setEstdecisionnee(p_demande.estDecisionnee());
      p_demandeVisu.setEstImpacte(true);
      p_demandeVisu.setTypeDemande(p_demande.getEvenementReferenceExamen().getTypeExamen());
      p_demandeVisu.setEstMigree(p_demande.estMigree());
      p_demandeVisu.setEstFigee(p_demande.estNeutraliseeCalcul());
      p_demandeVisu.setEstNeutralisee(p_demande.estNeutraliseeLiquidation());
      p_demandeVisu.setDateAttribution(p_demande.getDateRecherche());
    }
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
 * Qualified Name:     ParcoursPopulationClassementSuiteRechargement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */