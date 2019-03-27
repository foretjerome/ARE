package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.avant.ExecutionAvantImpossibleException;
import fr.unedic.cali.avant.FacadeAvantProduitFactory;
import fr.unedic.cali.avant.FacadeAvantProduitSpec;
import fr.unedic.cali.calcul.dom.CalendrierExecutionAvantSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitRbfSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.persistance.util.ContextePersistance;
import fr.unedic.cali.migration.outilsfonctionnels.OutilsMigration;
import fr.unedic.cali.parcours.DomAvantPilotage;
import fr.unedic.cali.parcours.ParcoursAvantPilotageDeterminationEtatDroit;
import fr.unedic.cali.parcours.ParcoursAvantPilotageElementsIndemnisation;
import fr.unedic.cali.parcours.ResultatAvant;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AppelAvant
{
  public static List<ResultatAvant> executerAvant(List p_listeAttributions, Damj p_dateEtude)
    throws ApplicativeException
  {
    List<ResultatAvant> resultatsAvant = new ArrayList();
    AttributionSpec attribution = null;
    
    List listeAttribution = filtrerListeAttributionsAides(p_listeAttributions);
    
    Collections.sort(listeAttribution, new ComparateurSurDateAttribution());
    
    Iterator it = listeAttribution.iterator();
    while (it.hasNext())
    {
      attribution = (AttributionSpec)it.next();
      
      ResultatAvant resultatAvantPilotage = null;
      try
      {
        resultatAvantPilotage = executerAvant(attribution, null);
        resultatAvantPilotage.setAttribution(attribution);
        resultatsAvant.add(resultatAvantPilotage);
        attribution.setPjiEffectif(resultatAvantPilotage.getPji());
      }
      catch (ExecutionAvantImpossibleException e)
      {
        attribution.setPjiEffectif(null);
      }
    }
    return resultatsAvant;
  }
  
  public static void executerAvantPourJunit(List p_listeAttributions, Damj p_dateEtude)
    throws ApplicativeException
  {
    AttributionSpec attribution = null;
    
    List listeAttribution = filtrerListeAttributionsAides(p_listeAttributions);
    
    Collections.sort(listeAttribution, new ComparateurSurDateAttribution());
    
    Iterator it = listeAttribution.iterator();
    while (it.hasNext())
    {
      attribution = (AttributionSpec)it.next();
      
      ResultatAvant resultatAvantPilotage = null;
      try
      {
        resultatAvantPilotage = executerAvantJunit(attribution, true, null, true);
        attribution.setPjiEffectif(resultatAvantPilotage.getPji());
      }
      catch (ExecutionAvantImpossibleException e)
      {
        attribution.setPjiEffectif(null);
      }
    }
  }
  
  public static List<ResultatAvant> executerAvant(List p_listeAttributions)
    throws ApplicativeException
  {
    return executerAvant(p_listeAttributions, Damj.NUIT_DES_TEMPS);
  }
  
  public static ResultatAvant executerAvant(AttributionSpec p_attribution, Damj p_dateEtude)
    throws ApplicativeException, ExecutionAvantImpossibleException
  {
    return executerAvant(p_attribution, true, p_dateEtude);
  }
  
  private static ResultatAvant executerAvantJunit(AttributionSpec p_attribution, boolean p_avecPriseEnCompteEvenement, Damj p_dateEtude, boolean p_estPersistant)
    throws ApplicativeException, ExecutionAvantImpossibleException
  {
    DomAvantPilotage domAvantPilotage = null;
    Contexte contexteCalcul = null;
    Parcours parcoursAvant = null;
    ResultatAvant resultat = null;
    
    domAvantPilotage = new DomAvantPilotage(p_attribution);
    domAvantPilotage.setIndividu(p_attribution.getDemandeur());
    domAvantPilotage.setDateArretExecution(p_dateEtude);
    domAvantPilotage.setAvecPriseEnCompteEvenement(p_avecPriseEnCompteEvenement);
    domAvantPilotage.setExecutionPersistante(p_estPersistant);
    contexteCalcul = new Contexte();
    contexteCalcul.setDonnees(domAvantPilotage);
    
    parcoursAvant = new ParcoursAvantPilotageElementsIndemnisation();
    resultat = (ResultatAvant)parcoursAvant.effectuerParcours(contexteCalcul);
    
    return resultat;
  }
  
  private static ResultatAvant executerAvant(AttributionSpec p_attribution, boolean p_avecPriseEnCompteEvenement, Damj p_dateEtude)
    throws ApplicativeException
  {
    DomAvantPilotage domAvantPilotage = null;
    Contexte contexteCalcul = null;
    Parcours parcoursAvant = null;
    ResultatAvant resultat = null;
    
    domAvantPilotage = new DomAvantPilotage(p_attribution);
    domAvantPilotage.setIndividu(p_attribution.getDemandeur());
    domAvantPilotage.setDateArretExecution(p_dateEtude);
    domAvantPilotage.setAvecPriseEnCompteEvenement(p_avecPriseEnCompteEvenement);
    domAvantPilotage.setExecutionPersistante(ContextePersistance.isPersistant());
    contexteCalcul = new Contexte();
    contexteCalcul.setDonnees(domAvantPilotage);
    
    parcoursAvant = new ParcoursAvantPilotageElementsIndemnisation();
    resultat = (ResultatAvant)parcoursAvant.effectuerParcours(contexteCalcul);
    
    return resultat;
  }
  
  public static ResultatAvant executerAvant(IndividuSpec p_individu, Damj p_dateAttribution, ProduitSpec p_produit, Collection p_delaisReport, Collection p_carences)
    throws ApplicativeException, ExecutionAvantImpossibleException
  {
    DomAvantPilotage domAvantPilotage = null;
    Contexte contexteCalcul = null;
    ResultatAvant resultat = null;
    
    domAvantPilotage = new DomAvantPilotage(null);
    domAvantPilotage.setIndividu(p_individu);
    domAvantPilotage.setDateAttribution(p_dateAttribution);
    domAvantPilotage.setProduit(p_produit);
    domAvantPilotage.setDelaisReport(p_delaisReport);
    domAvantPilotage.setCarences(p_carences);
    contexteCalcul = new Contexte();
    contexteCalcul.setDonnees(domAvantPilotage);
    
    Parcours parcoursAvant = new ParcoursAvantPilotageDeterminationEtatDroit();
    resultat = (ResultatAvant)parcoursAvant.effectuerParcours(contexteCalcul);
    if (resultat.getEtat() == 1) {
      throw new ExecutionAvantImpossibleException(resultat.getMessageErreur());
    }
    return resultat;
  }
  
  public static ResultatAvant executerCalculDeterminationEtatAvant(AttributionSpec p_attributionAEtudier, boolean p_avecPriseEnCompteEvenement, Damj p_dateEtude)
    throws ApplicativeException
  {
    ResultatAvant resultat = null;
    if ((p_attributionAEtudier != null) && (p_attributionAEtudier.getCalendrierExecutionAvant() != null) && (p_attributionAEtudier.getCalendrierExecutionAvant().getDernierJourAvant() != null) && ((p_dateEtude == null) || (p_dateEtude.estApresOuCoincideAvec(p_attributionAEtudier.getCalendrierExecutionAvant().getDernierJourAvant())))) {
      resultat = executerCalculDeterminationEtatDroitAuDernierJourAvant(p_attributionAEtudier);
    } else {
      resultat = appelParcoursDeterminationEtatDroitAvant(p_attributionAEtudier, p_avecPriseEnCompteEvenement, p_dateEtude);
    }
    return resultat;
  }
  
  public static ResultatAvant executerCalculDeterminationEtatAvantSansDate(AttributionSpec p_attributionAEtudier)
    throws ApplicativeException
  {
    return appelParcoursDeterminationEtatDroitAvant(p_attributionAEtudier, true, null);
  }
  
  protected static ResultatAvant executerCalculDeterminationEtatDroitAuDernierJourAvant(AttributionSpec p_attributionAEtudier)
    throws CoucheLogiqueException
  {
    FacadeAvantProduitSpec facadeAvantCalculProduit = null;
    if (p_attributionAEtudier.getCalendrierExecutionAvant() != null)
    {
      facadeAvantCalculProduit = recuperationFacadesCalcul(p_attributionAEtudier.getProduitExecution());
      if (facadeAvantCalculProduit != null) {
        return facadeAvantCalculProduit.postTraitementResultatDeterminationEtatAvant(p_attributionAEtudier);
      }
    }
    return null;
  }
  
  public static ResultatAvant appelParcoursDeterminationEtatDroitAvant(AttributionSpec p_attributionAEtudier, boolean p_avecPriseEnCompteEvenement, Damj p_dateEtude)
    throws ApplicativeException
  {
    ResultatAvant resultat = null;
    DomAvantPilotage domAvant = new DomAvantPilotage(p_attributionAEtudier);
    if ((p_attributionAEtudier != null) && (p_attributionAEtudier.getCalendrierExecutionAvant() != null)) {
      if ((p_attributionAEtudier.estNeutralise()) && (p_dateEtude.estAvant(p_attributionAEtudier.getCalendrierExecutionAvant().getDernierJourAvant()))) {
        if (OutilsMigration.estFigee(p_attributionAEtudier.getDemande())) {
          GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_DETERMINATION_ETAT_DROIT_IMP_FIGEE", new Object[] { p_dateEtude, p_attributionAEtudier.getDateAttribution() });
        } else {
          GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_DETERMINATION_ETAT_DROIT_IMP_NEUTRA", new Object[] { p_dateEtude, p_attributionAEtudier.getDateAttribution() });
        }
      }
    }
    if (p_attributionAEtudier != null)
    {
      domAvant.setIndividu(p_attributionAEtudier.getDemandeur());
      domAvant.setDateArretExecution(p_dateEtude);
      domAvant.setAvecPriseEnCompteEvenement(p_avecPriseEnCompteEvenement);
      
      Contexte contexteCalcul = new Contexte();
      contexteCalcul.setDonnees(domAvant);
      
      Parcours parcours = new ParcoursAvantPilotageDeterminationEtatDroit();
      resultat = (ResultatAvant)parcours.effectuerParcours(contexteCalcul);
    }
    return resultat;
  }
  
  private static FacadeAvantProduitSpec recuperationFacadesCalcul(ProduitSpec p_produit)
    throws CoucheLogiqueException
  {
    FacadeAvantProduitSpec facadeAvantCalculProduit = null;
    try
    {
      return FacadeAvantProduitFactory.getInstance().getInstanceFacadeAvantProduit(p_produit);
    }
    catch (CoucheLogiqueException e) {}
    return null;
  }
  
  private static List filtrerListeAttributionsAides(List p_listeAttributions)
  {
    List listeAttrib = new ArrayList();
    Iterator it = p_listeAttributions.iterator();
    while (it.hasNext())
    {
      AttributionSpec attributionSpec = (AttributionSpec)it.next();
      if (attributionSpec.getProduitExecution().getNom().equals("RBF_MOB07_01"))
      {
        ProduitRbfSpec produit = (ProduitRbfSpec)attributionSpec.getProduitExecution();
        listeAttrib.addAll(produit.recupererListeAttributionsExecutables(attributionSpec));
      }
      else
      {
        listeAttrib.add(attributionSpec);
      }
    }
    return listeAttrib;
  }
}

/* Location:
 * Qualified Name:     AppelAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */