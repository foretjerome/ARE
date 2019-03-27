package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComportement;
import fr.unedic.cali.calcul.FacadeCalculProduitFactory;
import fr.unedic.cali.calcul.FacadeCalculProduitPeriodiqueSpec;
import fr.unedic.cali.calcul.FacadeCalculProduitSpec;
import fr.unedic.cali.calcul.OutillagePeriodes;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.ResultatAppelCalcul;
import fr.unedic.cali.dom.RevisionSpec;
import fr.unedic.cali.dom.affectation.ProduitRbfSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.persistance.util.ContextePersistance;
import fr.unedic.cali.migration.outilsfonctionnels.OutilsMigration;
import fr.unedic.cali.parcours.DomCalculNettoyage;
import fr.unedic.cali.parcours.DomCalculPilotage;
import fr.unedic.cali.parcours.ParcoursCalculNettoyage;
import fr.unedic.cali.parcours.ParcoursCalculPilotageDeterminationEtatDroit;
import fr.unedic.cali.parcours.ParcoursCalculPilotageElementsIndemnisation;
import fr.unedic.cali.parcours.ResultatCalcul;
import fr.unedic.cali.parcours.ResultatDeterminationEtatDroitProduit;
import fr.unedic.cali.parcours.ResultatNettoyage;
import fr.unedic.cali.parcours.ResultatPilotage;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AppelCalcul
{
  public static ResultatAppelCalcul effectuerCalcul(IndividuSpec p_individu, List p_listeAttributions, Damj p_dateDebutExecution, Damj p_dateArretExecution, ComportementSpec p_comportement)
    throws ApplicativeException
  {
    ResultatAppelCalcul resultatAppelCalcul = new ResultatAppelCalcul();
    boolean isExecutionTerminee = true;
    DomCalculPilotage domCalcul = null;
    
    domCalcul = new DomCalculPilotage();
    domCalcul.setIndividu(p_individu);
    domCalcul.setDateDebutExecution(p_dateDebutExecution);
    domCalcul.setExecutionPersistante(ContextePersistance.isPersistant());
    domCalcul.setDateArretExecution(p_dateArretExecution);
    domCalcul.setComportement(p_comportement);
    domCalcul.setContexteService(p_individu.getContexteService());
    
    domCalcul.setListeAttributions(filtrerListeAttributionsRevisionHorsPEC(filtrerListeAttributions(p_listeAttributions), domCalcul));
    
    OutillagePeriodes.recupererPeriodesGAEC(p_individu, p_dateDebutExecution, null);
    if (!p_listeAttributions.isEmpty())
    {
      AppelAvant.executerAvant(domCalcul.getListeAttributions(), p_dateDebutExecution);
      if (!p_listeAttributions.isEmpty())
      {
        Contexte contexteCalcul = null;
        Parcours parcoursCalcul = null;
        
        contexteCalcul = new Contexte();
        contexteCalcul.setDonnees(domCalcul);
        
        parcoursCalcul = new ParcoursCalculPilotageElementsIndemnisation();
        
        ResultatPilotage resultatPilotage = (ResultatPilotage)parcoursCalcul.effectuerParcours(contexteCalcul);
        resultatAppelCalcul.setResultatVisualisationCalcul(resultatPilotage.getResultatVisualisationCalcul());
        if (resultatPilotage.getResultatsDetailles() != null)
        {
          Iterator iteratorResultatCalcul = resultatPilotage.getResultatsDetailles().iterator();
          while (iteratorResultatCalcul.hasNext())
          {
            ResultatCalcul resultatCalcul = (ResultatCalcul)iteratorResultatCalcul.next();
            if (resultatCalcul.getCalendrierExecutionCalcul().getEtatAttribution() == 5) {
              isExecutionTerminee = false;
            }
          }
        }
      }
    }
    resultatAppelCalcul.setExecutionTerminee(isExecutionTerminee);
    
    return resultatAppelCalcul;
  }
  
  public static ResultatAppelCalcul effectuerCalcul(IndividuSpec p_individu, List p_listeAttributions, Damj p_dateDebutExecution, Damj p_dateArretExecution)
    throws ApplicativeException
  {
    ComportementSpec comportement = OutilComportement.getComportementParDefaut();
    return effectuerCalcul(p_individu, p_listeAttributions, p_dateDebutExecution, p_dateArretExecution, comportement);
  }
  
  public static boolean nettoyerCalcul(IndividuSpec p_individu, Collection p_listeDemandes, Collection p_attributionsInvalides, Damj p_dateDebutNettoyage, int p_contexteExecution)
    throws ApplicativeException
  {
    return nettoyerCalcul(p_individu, p_listeDemandes, p_attributionsInvalides, p_dateDebutNettoyage, p_contexteExecution, false);
  }
  
  public static boolean nettoyerCalcul(IndividuSpec p_individu, Collection p_listeDemandes, Collection p_attributionsInvalides, Damj p_dateDebutNettoyage, int p_contexteExecution, boolean p_estNettoyageMigration)
    throws ApplicativeException
  {
    boolean isFailure = false;
    if ((!p_listeDemandes.isEmpty()) || (p_estNettoyageMigration))
    {
      Contexte contexteCalcul = null;
      DomCalculNettoyage domCalcul = null;
      Parcours parcoursCalcul = null;
      
      domCalcul = new DomCalculNettoyage();
      domCalcul.setIndividu(p_individu);
      domCalcul.setDateDebutNettoyage(p_dateDebutNettoyage);
      domCalcul.setContexteService(p_individu.getContexteService());
      domCalcul.setContexteExecution(p_contexteExecution);
      
      domCalcul.setListeDemandes(p_listeDemandes);
      domCalcul.setListeAttributionsInvalides(p_attributionsInvalides);
      
      contexteCalcul = new Contexte();
      contexteCalcul.setDonnees(domCalcul);
      
      parcoursCalcul = new ParcoursCalculNettoyage();
      
      ResultatNettoyage resultatNettoyage = (ResultatNettoyage)parcoursCalcul.effectuerParcours(contexteCalcul);
      isFailure = resultatNettoyage.isFailure();
    }
    return isFailure;
  }
  
  private static List<AttributionSpec> filtrerListeAttributions(List<AttributionSpec> listeAttributions)
  {
    AttributionSpec attribution = null;
    
    List<AttributionSpec> listeAttribution = new ArrayList();
    
    Iterator it = listeAttributions.iterator();
    while (it.hasNext())
    {
      attribution = (AttributionSpec)it.next();
      if (!listeAttribution.contains(attribution)) {
        listeAttribution.add(attribution);
      }
    }
    return listeAttribution;
  }
  
  private static List filtrerListeAttributionsRevisionHorsPEC(List p_listeAttributions, DomCalculPilotage p_domCalculPilotage)
  {
    List listeAttributions = new ArrayList();
    
    Iterator it = p_listeAttributions.iterator();
    while (it.hasNext())
    {
      AttributionSpec attributionSpec = (AttributionSpec)it.next();
      if (!(attributionSpec instanceof RevisionSpec))
      {
        if (attributionSpec.getProduit().getNom().equals("RBF_MOB07_01"))
        {
          ProduitRbfSpec produit = (ProduitRbfSpec)attributionSpec.getProduit();
          listeAttributions.addAll(produit.recupererListeAttributionsExecutables(attributionSpec));
          p_domCalculPilotage.setEstAideDecoupe(true);
        }
        else
        {
          listeAttributions.add(attributionSpec);
        }
      }
      else
      {
        ObjetChronoPeriodePriseEnCharge periodePEC = OutillagePeriodes.recupererPeriodePECContenant(attributionSpec.getDemandeur(), attributionSpec.getDateAttribution());
        if ((periodePEC != null) && ((periodePEC.getTypePec() == null) || (periodePEC.getSousType() == null) || ((!periodePEC.estDeTypeAdr()) && (!periodePEC.estDeTypeArce())))) {
          listeAttributions.add(attributionSpec);
        }
      }
    }
    return listeAttributions;
  }
  
  public static ResultatDeterminationEtatDroitProduit executerCalculDeterminationEtatDroit(AttributionSpec p_attributionAEtudier, Damj p_dateEtude)
    throws ApplicativeException
  {
    return executerCalculDeterminationEtatDroit(p_attributionAEtudier, null, null, p_dateEtude);
  }
  
  public static ResultatDeterminationEtatDroitProduit executerCalculDeterminationEtatDroit(AttributionSpec p_attributionAEtudier, DemandeSpec demandePivot, Damj p_dateEtude)
    throws ApplicativeException
  {
    return executerCalculDeterminationEtatDroit(p_attributionAEtudier, null, demandePivot, p_dateEtude);
  }
  
  public static ResultatDeterminationEtatDroitProduit executerCalculDeterminationEtatDroit(AttributionSpec p_attributionAEtudier, AttributionSpec attributionPivot, Damj p_dateEtude)
    throws ApplicativeException
  {
    return executerCalculDeterminationEtatDroit(p_attributionAEtudier, attributionPivot, null, p_dateEtude);
  }
  
  public static ResultatDeterminationEtatDroitProduit executerCalculDeterminationEtatDroit(AttributionSpec p_attributionAEtudier, AttributionSpec attributionPivot, DemandeSpec demandePivot, Damj p_dateEtude)
    throws ApplicativeException
  {
    ResultatDeterminationEtatDroitProduit resultat = null;
    Damj dateEtude = p_dateEtude;
    if (dateEtude == null)
    {
      resultat = executerCalculDeterminationEtatDroitAuDJI(p_attributionAEtudier);
      if (resultat != null) {
        return resultat;
      }
      if (p_attributionAEtudier.getCalendrierExecutionCalcul() != null) {
        dateEtude = p_attributionAEtudier.getCalendrierExecutionCalcul().getDernierJourIndemnisable();
      }
    }
    if ((p_attributionAEtudier != null) && (p_attributionAEtudier.getCalendrierExecutionCalcul() != null) && (dateEtude.estApresOuCoincideAvec(p_attributionAEtudier.getCalendrierExecutionCalcul().getDernierJourIndemnisable())))
    {
      if (p_attributionAEtudier.getCalendrierExecutionCalcul().getEtatAttribution() == 5) {
        resultat = appelParcoursDeterminationEtatDroit(p_attributionAEtudier, attributionPivot, demandePivot, dateEtude);
      } else {
        resultat = executerCalculDeterminationEtatDroitAuDJI(p_attributionAEtudier);
      }
      if (resultat != null) {
        return resultat;
      }
    }
    if (dateEtude != null) {
      return appelParcoursDeterminationEtatDroit(p_attributionAEtudier, attributionPivot, demandePivot, dateEtude);
    }
    return null;
  }
  
  protected static ResultatDeterminationEtatDroitProduit executerCalculDeterminationEtatDroitAuDJI(AttributionSpec p_attributionAEtudier)
    throws ApplicativeException
  {
    FacadeCalculProduitSpec facadeCalculProduit = null;
    if (p_attributionAEtudier.getCalendrierExecutionCalcul() != null)
    {
      if (p_attributionAEtudier.getCalendrierExecutionCalcul().getEtatAttribution() == 5) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CALCUL_APPEL_PAR_LIQ_EXEC_INTERROMPUE");
      }
      if (p_attributionAEtudier.estEnReexamen()) {
        return null;
      }
      facadeCalculProduit = recuperationFacadesCalcul(p_attributionAEtudier);
      if (p_attributionAEtudier.getCalendrierExecutionCalcul().getEtatAuDJI() != null) {
        return (ResultatDeterminationEtatDroitProduit)facadeCalculProduit.postTraitementResultatDeterminationEtatDroit(p_attributionAEtudier, p_attributionAEtudier.getCalendrierExecutionCalcul(), p_attributionAEtudier.getCalendrierExecutionCalcul().getDernierJourIndemnisable());
      }
    }
    return null;
  }
  
  private static ResultatDeterminationEtatDroitProduit appelParcoursDeterminationEtatDroit(AttributionSpec p_attributionAEtudier, AttributionSpec attributionPivot, DemandeSpec demandePivot, Damj p_dateEtude)
    throws ApplicativeException
  {
    ResultatDeterminationEtatDroitProduit resultat = null;
    
    verificationAttributionNeutralise(p_attributionAEtudier, p_dateEtude);
    if (p_attributionAEtudier != null)
    {
      List listeAttributions = recupereAttributionsExecutables(p_attributionAEtudier, attributionPivot, demandePivot, p_dateEtude);
      if (!listeAttributions.isEmpty())
      {
        AppelAvant.executerAvant(listeAttributions, p_dateEtude);
        if ((p_dateEtude.estApresOuCoincideAvec(p_attributionAEtudier.getPji())) && ((p_attributionAEtudier == null) || (listeAttributions.contains(p_attributionAEtudier))))
        {
          DomCalculPilotage domCalcul = new DomCalculPilotage();
          domCalcul.setIndividu(p_attributionAEtudier.getDemandeur());
          domCalcul.setListeAttributions(listeAttributions);
          domCalcul.setAttributionAEtudier(p_attributionAEtudier);
          domCalcul.setDateEtatDroit(p_dateEtude);
          domCalcul.setContexteService(domCalcul.getIndividu().getContexteService());
          
          Contexte contexteCalcul = new Contexte();
          contexteCalcul.setDonnees(domCalcul);
          
          Parcours parcours = new ParcoursCalculPilotageDeterminationEtatDroit();
          ResultatPilotage resultatPilotage = (ResultatPilotage)parcours.effectuerParcours(contexteCalcul);
          
          resultat = (ResultatDeterminationEtatDroitProduit)resultatPilotage.getResultatDetaille(p_attributionAEtudier);
        }
      }
    }
    else
    {
      resultat = new ResultatDeterminationEtatDroitProduit();
      resultat.setEtat(1);
    }
    return resultat;
  }
  
  private static FacadeCalculProduitSpec recuperationFacadesCalcul(AttributionSpec p_attribution)
  {
    FacadeCalculProduitSpec facadeCalculProduit = null;
    try
    {
      facadeCalculProduit = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(p_attribution.getProduitExecution());
    }
    catch (CoucheLogiqueException e)
    {
      facadeCalculProduit = null;
    }
    return facadeCalculProduit;
  }
  
  public static void alimenterGrapheAntecedentCalcul(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    FacadeCalculProduitPeriodiqueSpec facadeCalculProduit = (FacadeCalculProduitPeriodiqueSpec)recuperationFacadesCalcul(attribution);
    facadeCalculProduit.alimenterGrapheAntecedentCalcul(attribution);
  }
  
  private static List recupereAttributionsExecutables(AttributionSpec attributionAEtudier, AttributionSpec attributionPivot, DemandeSpec demandePivot, Damj dateEtude)
  {
    List listeAttributions = null;
    if ((attributionPivot == null) && (demandePivot == null)) {
      listeAttributions = attributionAEtudier.getDemandeur().getListeAttributionsExecutablesAvant(dateEtude);
    } else if (demandePivot == null) {
      listeAttributions = attributionAEtudier.getDemandeur().getListeAttributionsExecutablesAvant(attributionPivot);
    } else if (attributionPivot == null) {
      listeAttributions = attributionAEtudier.getDemandeur().getListeAttributionsExecutablesAvant(demandePivot);
    }
    return listeAttributions;
  }
  
  private static void verificationAttributionNeutralise(AttributionSpec attributionAEtudier, Damj dateEtude)
    throws CoucheLogiqueException
  {
    if ((attributionAEtudier != null) && (attributionAEtudier.getCalendrierExecutionCalcul() != null) && (attributionAEtudier.estNeutralise()) && (dateEtude.estAvant(attributionAEtudier.getCalendrierExecutionCalcul().getDernierJourIndemnisable()))) {
      if (OutilsMigration.estFigee(attributionAEtudier.getDemande())) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_DETERMINATION_ETAT_DROIT_IMP_FIGEE", new Object[] { dateEtude, attributionAEtudier.getDateAttribution() });
      } else {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_DETERMINATION_ETAT_DROIT_IMP_NEUTRA", new Object[] { dateEtude, attributionAEtudier.getDateAttribution() });
      }
    }
  }
  
  public static ResultatDeterminationEtatDroitProduit executerCalculDeterminationMontantAidePaye(AttributionSpec attributionAEtudier, Damj pdateEtude, DemandeSpec demandePivot, AttributionSpec attributionPivot)
    throws ApplicativeException
  {
    ResultatDeterminationEtatDroitProduit resultat = null;
    Damj dateEtude = pdateEtude;
    
    ResultatDeterminationEtatDroitProduit resultatAideMere = new ResultatDeterminationEtatDroitProduit();
    ProduitRbfSpec produit = (ProduitRbfSpec)attributionAEtudier.getProduit();
    List<AttributionSpec> listeAttributions = new ArrayList();
    listeAttributions.addAll(produit.recupererListeAttributionsExecutables(attributionAEtudier));
    BigDecimal montantPayeDerog = BigDecimal.ZERO;
    BigDecimal montantPayeNonDerog = BigDecimal.ZERO;
    
    Iterator<AttributionSpec> ite = listeAttributions.iterator();
    if (!listeAttributions.isEmpty())
    {
      while (ite.hasNext())
      {
        AttributionSpec attributionAide = (AttributionSpec)ite.next();
        if ((attributionAide != null) && (attributionAide.getCalendrierExecutionCalcul() != null))
        {
          if (dateEtude.estApresOuCoincideAvec(attributionAide.getCalendrierExecutionCalcul().getDernierJourIndemnisable()))
          {
            resultat = executerCalculDeterminationEtatDroitAuDJI(attributionAide);
          }
          else
          {
            if (attributionPivot == null) {
              return appelParcoursDeterminationEtatDroit(attributionAEtudier, null, null, dateEtude);
            }
            return appelParcoursDeterminationEtatDroit(attributionAEtudier, null, demandePivot, dateEtude);
          }
          if (resultat != null)
          {
            montantPayeDerog = montantPayeDerog.add(resultat.getMontantIndemDerog().getValeur());
            montantPayeNonDerog = montantPayeNonDerog.add(resultat.getMontantIndemNonDerog().getValeur());
          }
        }
      }
      resultatAideMere.setMontantIndemDerog(new QuantiteEuro(montantPayeDerog));
      resultatAideMere.setMontantIndemNonDerog(new QuantiteEuro(montantPayeNonDerog));
    }
    else
    {
      resultatAideMere = appelParcoursDeterminationEtatDroit(attributionAEtudier, attributionPivot, demandePivot, dateEtude);
    }
    return resultatAideMere;
  }
}

/* Location:
 * Qualified Name:     AppelCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */