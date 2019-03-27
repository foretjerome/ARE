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
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.ElementComparaisonReexamen;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresTraitementPopulation;
import fr.unedic.cali.occasionnel.outilsfonctionnels.ResultatTraitementPopulation;
import fr.unedic.cali.outilsfonctionnels.AppelLiquidation;
import fr.unedic.cali.outilsfonctionnels.AppelServicesCojac;
import fr.unedic.cali.outilsfonctionnels.GestionIndicateurs;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.cali.parcours.ResultatReexecutionCali;
import fr.unedic.cali.parcours.ResultatVisualisationReexecution;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ParcoursControleAlimentationDroitExecutable
  extends ParcoursPopulationAbstraite
{
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatReexecutionCali resultat = new ResultatReexecutionCali();
    IndividuSpec individu = getIndividu(p_contexte);
    
    Chronologie demandesAsu = getIndividu(p_contexte).getChronoDemandeAssurance();
    demandesAsu.iterer();
    ArrayList listeDemandesModifiees = new ArrayList();
    
    Individu individuPourBaseVisu = new Individu();
    
    Chronologie assurances11 = OutilRecherche.rechercherDemandesSuivantes(individu.getChronoDemandesNonTriees(), Damj.NUIT_DES_TEMPS, GammeAsu.getInstance().retournerFiltreAttributionGammeAsuProduit());
    
    assurances11.iterer();
    while ((assurances11 != null) && (assurances11.encoreSuivant()))
    {
      DemandeSpec demande = (DemandeSpec)assurances11.elementSuivant();
      if ((demande.estDecisionnee()) && (!demande.estEnReExamen()))
      {
        CriteresTraitementPopulation criteres = new CriteresTraitementPopulation();
        criteres.setIndividu(getIndividu(p_contexte));
        criteres.setNomPopulation("test droit executable");
        ArrayList parametres = new ArrayList();
        parametres.add(demande);
        criteres.setParametres(parametres);
        ApplicativeRuntimeException exception = null;
        ResultatTraitementPopulation resultatTraitementPopulation = null;
        try
        {
          resultatTraitementPopulation = GammeAsu.getInstance().effectuerTraitementOccasionnel(criteres);
        }
        catch (ApplicativeRuntimeException e)
        {
          exception = e;
        }
        listeDemandesModifiees.addAll(resultatTraitementPopulation.getObjetsTraites());
        alimenterIndividuBaseVisu(p_contexte, demande, individuPourBaseVisu, exception, resultatTraitementPopulation.getElementsComparaisons());
      }
    }
    if ((individuPourBaseVisu.getListeDemandes() != null) && (!individuPourBaseVisu.getListeDemandes().isEmpty()))
    {
      ResultatVisualisationReexecution resultatPourBaseVisu = new ResultatVisualisationReexecution();
      resultatPourBaseVisu.setIndividu(individuPourBaseVisu);
      resultatPourBaseVisu.setRedressementSpec(getDom(p_contexte).getRedressement());
      
      ecrireEnBaseVisu(resultatPourBaseVisu, getComportement(p_contexte));
    }
    resultat.setEtat(0);
    resultat.setFailure(false);
    resultat.setIndicateursGeneriques(GestionIndicateurs.creerIndicateurs(getIndividu(p_contexte), null));
    return resultat;
  }
  
  private void alimenterIndividuBaseVisu(Contexte p_contexte, DemandeSpec p_demande, Individu p_individu, ApplicativeRuntimeException p_exception, ArrayList p_elementsComparaisons)
    throws CoucheLogiqueException
  {
    p_individu.setRsin(getDom(p_contexte).getContexteService().getRsin());
    p_individu.setCxala(getDom(p_contexte).getContexteService().getCxala().toString());
    p_individu.setCxass(getDom(p_contexte).getRedressement().getCodeAssedic());
    p_individu.setModeCreation("R");
    p_individu.setPopulation(getDom(p_contexte).getPopulation());
    p_individu.setDateReexecution(PopulationSpec.DATE_LIMITE_NON_REEXECUTION);
    CriteresTrancheDeVie critere = new CriteresTrancheDeVie();
    critere.setCodeAssedic(p_individu.getCxass());
    critere.setIdentifiantNCP(p_individu.getCxala());
    try
    {
      p_individu.setAntenne(AppelServicesCojac.lectureTrancheDeVie(critere).getCodeAntenne());
    }
    catch (TechniqueException tE)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GDP", "Problème lors de l'appel de service de CALI vers GDP", tE);
    }
    Demande demandeVisu = new Demande();
    String etatReexamen = "V";
    if (p_exception == null)
    {
      demandeVisu.setElementsComparaisonReexamen(new ArrayList());
      if (p_elementsComparaisons != null)
      {
        Iterator iterateurListeElementsComparaison = p_elementsComparaisons.iterator();
        while (iterateurListeElementsComparaison.hasNext())
        {
          ElementComparaisonReexamen elementsComparaison = (ElementComparaisonReexamen)iterateurListeElementsComparaison.next();
          ajouterElementComparaisonSurDemande(demandeVisu, elementsComparaison);
          etatReexamen = "R";
        }
      }
    }
    else
    {
      ajouterElementComparaisonException(demandeVisu, p_exception);
    }
    demandeVisu.setEtatReexamen(etatReexamen);
    AppelLiquidation.alimenterDemandeVisu(demandeVisu, p_demande, getComportement(p_contexte));
    p_individu.ajouterDemande(demandeVisu);
  }
  
  private static void ajouterElementComparaisonException(Demande p_demandeVisu, ApplicativeRuntimeException p_exception)
  {
    String valeurApres = null;
    String libelle = null;
    if ((p_exception.getLibelle() != null) && (p_exception.getLibelle().length() <= 100)) {
      valeurApres = p_exception.getLibelle();
    } else {
      valeurApres = p_exception.getCode();
    }
    if ((p_exception.getCode() != null) && (p_exception.getCode().length() <= 50)) {
      libelle = p_exception.getCode();
    } else if (p_exception.getCode() != null) {
      libelle = p_exception.getCode().substring(p_exception.getCode().length() - 50 + 1);
    } else {
      libelle = "Exception couche logique sur demande";
    }
    ElementComparaisonReexamen elementComparaison = new ElementComparaisonReexamen(libelle, null, valeurApres);
    
    ajouterElementComparaisonSurDemande(p_demandeVisu, elementComparaison);
  }
  
  private static void ajouterElementComparaisonSurDemande(Demande p_demandeVisu, ElementComparaisonReexamen p_elementComparaison)
  {
    List elementComparaisonReexamen = p_demandeVisu.getElementsComparaisonReexamen();
    if (null == elementComparaisonReexamen)
    {
      elementComparaisonReexamen = new ArrayList();
      p_demandeVisu.setElementsComparaisonReexamen(elementComparaisonReexamen);
    }
    elementComparaisonReexamen.add(p_elementComparaison);
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
 * Qualified Name:     ParcoursControleAlimentationDroitExecutable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */