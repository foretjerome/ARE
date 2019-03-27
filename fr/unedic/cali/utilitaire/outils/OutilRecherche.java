package fr.unedic.cali.utilitaire.outils;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.utilitaire.comparateurs.ComparateurDecisionCroissante;
import fr.unedic.cali.utilitaire.comparateurs.ComparateurDemandeCroissante;
import fr.unedic.cali.utilitaire.convertisseur.ConvertisseurDemandeDecision;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionsPrecedentesSurDecisions;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionsSuivantesSurDecisions;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandesPrecedentesSurDemandes;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandesSuivantesSurDemandes;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Temporel;
import java.util.Comparator;

public final class OutilRecherche
{
  public static DemandeSpec rechercherDemandePrecedente(Chronologie demandesDecisions, Object pointDepartRecherche, FiltreCaliSpec filtreCali)
  {
    DemandeSpec demandeRetour = null;
    Chronologie demandesDecisionsNettoyees = nettoyerChronologie(demandesDecisions, pointDepartRecherche);
    Chronologie demandes = ConvertisseurDemandeDecision.convertirDecisionsEnDemandes(demandesDecisionsNettoyees);
    if (filtreCali != null) {
      filtreCali.initialiserCache();
    }
    FiltreCaliSpec filtreDemandePrecedentes = creerFiltreDemandesPrecedentes(pointDepartRecherche, filtreCali);
    Chronologie demandesPrecedentes = rechercherElements(demandes, filtreDemandePrecedentes, new ComparateurDemandeCroissante());
    if ((demandesPrecedentes != null) && (!demandesPrecedentes.estVide())) {
      demandeRetour = (DemandeSpec)demandesPrecedentes.dernierElement();
    }
    return demandeRetour;
  }
  
  public static Chronologie rechercherDemandesPrecedentes(Chronologie demandesDecisions, Object pointDepartRecherche, FiltreCaliSpec filtreCali)
  {
    Chronologie demandesDecisionsNettoyees = nettoyerChronologie(demandesDecisions, pointDepartRecherche);
    if (filtreCali != null) {
      filtreCali.initialiserCache();
    }
    FiltreCaliSpec filtreDemandesPrecedentes = creerFiltreDemandesPrecedentes(pointDepartRecherche, filtreCali);
    Chronologie demandes = ConvertisseurDemandeDecision.convertirDecisionsEnDemandes(demandesDecisionsNettoyees);
    return rechercherElements(demandes, filtreDemandesPrecedentes, null);
  }
  
  public static DemandeSpec rechercherDemandeSuivante(Chronologie demandesDecisions, Object pointDepartRecherche, FiltreCaliSpec filtreCali)
  {
    DemandeSpec demandeRetour = null;
    Chronologie demandesDecisionsNettoyees = nettoyerChronologie(demandesDecisions, pointDepartRecherche);
    if (filtreCali != null) {
      filtreCali.initialiserCache();
    }
    FiltreCaliSpec filtreDemandesSuivantes = creerFiltreDemandesSuivantes(pointDepartRecherche, filtreCali);
    Chronologie demandes = ConvertisseurDemandeDecision.convertirDecisionsEnDemandes(demandesDecisionsNettoyees);
    Chronologie demandePrecedentes = rechercherElements(demandes, filtreDemandesSuivantes, new ComparateurDemandeCroissante());
    if ((demandePrecedentes != null) && (!demandePrecedentes.estVide())) {
      demandeRetour = (DemandeSpec)demandePrecedentes.premierElement();
    }
    return demandeRetour;
  }
  
  public static Chronologie rechercherDemandesSuivantes(Chronologie demandesDecisions, Object pointDepartRecherche, FiltreCaliSpec filtreCali)
  {
    Chronologie demandesDecisionsNettoyees = nettoyerChronologie(demandesDecisions, pointDepartRecherche);
    if (filtreCali != null) {
      filtreCali.initialiserCache();
    }
    FiltreCaliSpec filtreDemandesSuivantes = creerFiltreDemandesSuivantes(pointDepartRecherche, filtreCali);
    Chronologie demandes = ConvertisseurDemandeDecision.convertirDecisionsEnDemandes(demandesDecisionsNettoyees);
    return rechercherElements(demandes, filtreDemandesSuivantes, null);
  }
  
  public static DecisionSpec rechercherDecisionPrecedente(Chronologie demandesDecisions, Object pointDepartRecherche, FiltreCaliSpec filtreCali)
  {
    DecisionSpec decisionRetour = null;
    Chronologie demandesDecisionsNettoyees = nettoyerChronologie(demandesDecisions, pointDepartRecherche);
    Chronologie decisions = ConvertisseurDemandeDecision.convertirDemandesEnDecisions(demandesDecisionsNettoyees);
    if (filtreCali != null) {
      filtreCali.initialiserCache();
    }
    FiltreCaliSpec filtreDecisionsPrecedentes = creerFiltreDecisionsPrecedentes(pointDepartRecherche, filtreCali);
    Chronologie decisionsPrecedentes = rechercherElements(decisions, filtreDecisionsPrecedentes, new ComparateurDecisionCroissante());
    if ((decisionsPrecedentes != null) && (!decisionsPrecedentes.estVide())) {
      decisionRetour = (DecisionSpec)decisionsPrecedentes.dernierElement();
    }
    return decisionRetour;
  }
  
  public static Chronologie rechercherDecisionsPrecedentes(Chronologie demandesDecisions, Object pointDepartRecherche, FiltreCaliSpec filtreCali)
  {
    Chronologie demandesDecisionsNettoyees = nettoyerChronologie(demandesDecisions, pointDepartRecherche);
    Chronologie decisions = ConvertisseurDemandeDecision.convertirDemandesEnDecisions(demandesDecisionsNettoyees);
    if (filtreCali != null) {
      filtreCali.initialiserCache();
    }
    FiltreCaliSpec filtreDecisionsPrecedentes = creerFiltreDecisionsPrecedentes(pointDepartRecherche, filtreCali);
    return rechercherElements(decisions, filtreDecisionsPrecedentes, null);
  }
  
  public static DecisionSpec rechercherDecisionSuivante(Chronologie demandesDecisions, Object pointDepartRecherche, FiltreCaliSpec filtreCali)
  {
    DecisionSpec decisionRetour = null;
    Chronologie demandesDecisionsNettoyees = nettoyerChronologie(demandesDecisions, pointDepartRecherche);
    Chronologie decisions = ConvertisseurDemandeDecision.convertirDemandesEnDecisions(demandesDecisionsNettoyees);
    if (filtreCali != null) {
      filtreCali.initialiserCache();
    }
    FiltreCaliSpec filtreDecisionsSuivantes = creerFiltreDecisionsSuivantes(pointDepartRecherche, filtreCali);
    Chronologie decisionsSuivantes = rechercherElements(decisions, filtreDecisionsSuivantes, new ComparateurDecisionCroissante());
    if ((decisionsSuivantes != null) && (!decisionsSuivantes.estVide())) {
      decisionRetour = (DecisionSpec)decisionsSuivantes.premierElement();
    }
    return decisionRetour;
  }
  
  public static Chronologie rechercherDecisionsSuivantes(Chronologie demandesDecisions, Object pointDepartRecherche, FiltreCaliSpec filtreCali)
  {
    Chronologie demandesDecisionsNettoyees = nettoyerChronologie(demandesDecisions, pointDepartRecherche);
    Chronologie decisions = ConvertisseurDemandeDecision.convertirDemandesEnDecisions(demandesDecisionsNettoyees);
    if (filtreCali != null) {
      filtreCali.initialiserCache();
    }
    FiltreCaliSpec filtreDecisionsSuivantes = creerFiltreDecisionsSuivantes(pointDepartRecherche, filtreCali);
    Chronologie decisionsSuivantes = rechercherElements(decisions, filtreDecisionsSuivantes, null);
    return decisionsSuivantes;
  }
  
  private static FiltreCaliSpec creerFiltreDemandesPrecedentes(Object pointDepartRecherche, FiltreCaliSpec filtreCali)
  {
    FiltreET filtreCaliEt = new FiltreET();
    if (filtreCali != null) {
      filtreCaliEt.ajouterFiltre(filtreCali);
    }
    filtreCaliEt.ajouterFiltre(new FiltreDemandesPrecedentesSurDemandes(pointDepartRecherche));
    
    return filtreCaliEt;
  }
  
  private static FiltreCaliSpec creerFiltreDemandesSuivantes(Object pointDepartRecherche, FiltreCaliSpec filtreCali)
  {
    FiltreET filtreET = new FiltreET();
    if (filtreCali != null) {
      filtreET.ajouterFiltre(filtreCali);
    }
    filtreET.ajouterFiltre(new FiltreDemandesSuivantesSurDemandes(pointDepartRecherche));
    return filtreET;
  }
  
  private static FiltreCaliSpec creerFiltreDecisionsPrecedentes(Object pointDepartRecherche, FiltreCaliSpec filtreCali)
  {
    FiltreET filtreCaliEt = new FiltreET();
    if (filtreCali != null) {
      filtreCaliEt.ajouterFiltre(filtreCali);
    }
    filtreCaliEt.ajouterFiltre(new FiltreDecisionsPrecedentesSurDecisions(pointDepartRecherche));
    
    return filtreCaliEt;
  }
  
  private static FiltreCaliSpec creerFiltreDecisionsSuivantes(Object pointDepartRecherche, FiltreCaliSpec filtreCali)
  {
    FiltreET filtreET = new FiltreET();
    if (filtreCali != null) {
      filtreET.ajouterFiltre(filtreCali);
    }
    filtreET.ajouterFiltre(new FiltreDecisionsSuivantesSurDecisions(pointDepartRecherche));
    
    return filtreET;
  }
  
  private static Chronologie rechercherElements(Chronologie chronologie, FiltreCaliSpec filtreCali, Comparator comparateur)
  {
    Chronologie chronologieResultat = null;
    if (chronologie != null)
    {
      if (filtreCali != null) {
        chronologieResultat = chronologie.copier(filtreCali);
      }
      if (comparateur != null) {
        chronologieResultat.setComparateur(comparateur);
      }
    }
    return chronologieResultat;
  }
  
  private static Chronologie nettoyerChronologie(Chronologie demandesDecisions, Object pointDepartRecherche)
  {
    Chronologie demandesDecisionsCopiees = demandesDecisions.copier();
    if ((demandesDecisionsCopiees != null) && (!demandesDecisionsCopiees.estVide()) && (pointDepartRecherche != null))
    {
      Temporel premierElement = demandesDecisionsCopiees.premierElement();
      if ((pointDepartRecherche instanceof DecisionSpec)) {
        nettoyerDecisionSpec(pointDepartRecherche, demandesDecisionsCopiees, premierElement);
      } else if ((pointDepartRecherche instanceof DemandeSpec)) {
        nettoyerDemandeSpec(pointDepartRecherche, demandesDecisionsCopiees, premierElement);
      }
    }
    return demandesDecisionsCopiees;
  }
  
  private static void nettoyerDemandeSpec(Object pointDepartRecherche, Chronologie demandesDecisionsCopiees, Temporel premierElement)
  {
    if ((premierElement instanceof DemandeSpec))
    {
      demandesDecisionsCopiees.supprimer((DemandeSpec)pointDepartRecherche);
    }
    else if ((premierElement instanceof DecisionSpec))
    {
      Chronologie decisionsASupprimer = ConvertisseurDemandeDecision.convertirDemandeEnDecisions((DemandeSpec)pointDepartRecherche);
      if ((decisionsASupprimer != null) && (!decisionsASupprimer.estVide()))
      {
        decisionsASupprimer.iterer();
        while (decisionsASupprimer.encoreSuivant())
        {
          DecisionSpec decisionASupprimer = (DecisionSpec)decisionsASupprimer.elementSuivant();
          demandesDecisionsCopiees.supprimer(decisionASupprimer);
        }
      }
    }
  }
  
  private static void nettoyerDecisionSpec(Object pointDepartRecherche, Chronologie demandesDecisionsCopiees, Temporel premierElement)
  {
    if ((premierElement instanceof DemandeSpec))
    {
      DemandeSpec demandeASupprimer = ConvertisseurDemandeDecision.convertirDecisionEnDemande((DecisionSpec)pointDepartRecherche);
      
      demandesDecisionsCopiees.supprimer(demandeASupprimer);
    }
    else if ((premierElement instanceof DecisionSpec))
    {
      demandesDecisionsCopiees.supprimer((DecisionSpec)pointDepartRecherche);
    }
  }
}

/* Location:
 * Qualified Name:     OutilRecherche
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */