package fr.unedic.cali.outilsfonctionnels.reexecution;

import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchReconductionSystematique;
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementVnrBatch;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ClassementAdministratifSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.Prescription;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.outilsfonctionnels.ComparateurSurDateDeclenchementEtPrioriteDemande;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.outilsfonctionnels.MiseEnReexamenDemande;
import fr.unedic.cali.outilsfonctionnels.OutilAsp;
import fr.unedic.cali.outilsfonctionnels.OutilDemande;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreDemandeAttenteDecision;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandeNpde;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourClassement;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandeSuivantesDateAbonnement;
import fr.unedic.cali.utilitaire.filtres.generiques.conteneur.ConteneurFiltredemandeNpde;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreOU;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class OutilGestionnaireReexecution
{
  private static OutilGestionnaireReexecution outilGestionnaireReexecution;
  
  public static synchronized OutilGestionnaireReexecution getInstance()
  {
    if (outilGestionnaireReexecution == null) {
      outilGestionnaireReexecution = new OutilGestionnaireReexecution();
    }
    return outilGestionnaireReexecution;
  }
  
  public List<DemandeSpec> recupererDemandesAReliquider(IndividuSpec individu, Damj date, int prioriteGamme, int prioriteERE, String referenceExterne, boolean prendEnCompteDemandeEnReexamen, boolean rechercheDemandesAReliquiderInitiale, boolean estValidationDecision)
  {
    return recupererDemandesAReliquider(individu.getChronoDemandes().mapperVersListe(), date, prioriteGamme, prioriteERE, referenceExterne, prendEnCompteDemandeEnReexamen, rechercheDemandesAReliquiderInitiale, estValidationDecision);
  }
  
  public List<DemandeSpec> recupererDemandesAReliquider(List<DemandeSpec> demandes, Damj date, int prioriteGamme, int prioriteERE, String referenceExterne, boolean prendEnCompteDemandeEnReexamen, boolean rechercheDemandesAReliquiderInitiale, boolean estValidationDecision)
  {
    List<DemandeSpec> listeDemandes = new ArrayList();
    
    Iterator<DemandeSpec> iterateurDemandes = demandes.iterator();
    while (iterateurDemandes.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterateurDemandes.next();
      if (estDemandeAReliquider(demande, prendEnCompteDemandeEnReexamen, date, rechercheDemandesAReliquiderInitiale, estValidationDecision)) {
        if (estDemandeAReliquderAvecGestionPriorite(demande, rechercheDemandesAReliquiderInitiale, date, prioriteGamme, prioriteERE, referenceExterne, estValidationDecision))
        {
          demande.setValide(true);
        }
        else
        {
          demande.setValide(false);
          listeDemandes.add(demande);
        }
      }
    }
    trierListeDemandesAReliquider(listeDemandes);
    return listeDemandes;
  }
  
  private boolean estDemandeAReliquderAvecGestionPriorite(DemandeSpec demande, boolean rechercheDemandesAReliquiderInitiale, Damj date, int prioriteGamme, int prioriteERE, String referenceExterne, boolean estValidationDecision)
  {
    boolean estDemandeAuMemeJour = (date != null) && (getDateFinAbonnement(demande, rechercheDemandesAReliquiderInitiale, estValidationDecision).coincideAvec(date));
    
    return (estDemandeAuMemeJour) && ((demande.getGamme().getPriorite() > prioriteGamme) || (gerePrioriteSiGammeIdentique(demande, prioriteGamme, prioriteERE)) || (gererPrioriteSiEreIdentique(demande, prioriteGamme, prioriteERE, referenceExterne)));
  }
  
  private boolean gerePrioriteSiGammeIdentique(DemandeSpec demande, int prioriteGamme, int prioriteERE)
  {
    return (demande.getGamme().getPriorite() == prioriteGamme) && (demande.getEvenementReferenceExamen().getPriorite() > prioriteERE);
  }
  
  private boolean gererPrioriteSiEreIdentique(DemandeSpec demande, int prioriteGamme, int prioriteERE, String referenceExterne)
  {
    return (demande.getGamme().getPriorite() == prioriteGamme) && (demande.getEvenementReferenceExamen().getPriorite() == prioriteERE) && (referenceExterne != null) && (demande.getFormulaire().getReferenceExterne().compareTo(referenceExterne) <= 0);
  }
  
  private boolean estDemandeAReliquider(DemandeSpec demande, boolean prendEnCompteDemandeEnReexamen, Damj date, boolean rechercheDemandesAReliquiderInitiale, boolean estValidationDecision)
  {
    boolean estDemandeLiquidable = (demande.estAdmissibleReexecution()) && (demande.estReexaminable());
    boolean estDemandeNonClassee = (demande.getClassementAdministratif() == null) || (((demande.getClassementAdministratif() instanceof Prescription)) && (!((Prescription)demande.getClassementAdministratif()).isValidite()));
    
    boolean estDemandeNonEnReexamen = (!demande.estEnReExamen()) || (prendEnCompteDemandeEnReexamen) || (demande.estLiquideeAutomatiquement());
    
    return (estDemandeLiquidable) && (estDemandeNonClassee) && (estDemandeNonEnReexamen) && (conditionDateFinAbonnementApresOuCoincide(date, rechercheDemandesAReliquiderInitiale, demande, estValidationDecision));
  }
  
  public void trierListeDemandesAReliquider(List<DemandeSpec> listeDemandes)
  {
    Collections.sort(listeDemandes, new ComparateurSurDateDeclenchementEtPrioriteDemande());
  }
  
  public boolean conditionDateFinAbonnementApresOuCoincide(Damj date, boolean rechercheDemandesAReliquiderInitiale, DemandeSpec demande, boolean estValidationDecision)
  {
    return (date == null) || ((getDateFinAbonnement(demande, rechercheDemandesAReliquiderInitiale, estValidationDecision) != null) && (getDateFinAbonnement(demande, rechercheDemandesAReliquiderInitiale, estValidationDecision).estApresOuCoincideAvec(date)));
  }
  
  private Damj getDateFinAbonnement(DemandeSpec demande, boolean rechercheDemandesAReliquiderInitiale, boolean estValidationDecision)
  {
    Damj dateFinAbonnement;
    Damj dateFinAbonnement;
    if (rechercheDemandesAReliquiderInitiale)
    {
      dateFinAbonnement = calculerDateFinAbonnementPourRechercheDemandeIntiale(demande, estValidationDecision);
    }
    else
    {
      Damj dateFinAbonnement;
      if ((estValidationDecision) && (demande.estEnContexteDemande("SORTIECRA")) && (demande.getDateAttribution() != null)) {
        dateFinAbonnement = demande.getDateFinAbonnement();
      } else {
        dateFinAbonnement = demande.getDateFinAbonnement();
      }
    }
    return dateFinAbonnement;
  }
  
  private Damj calculerDateFinAbonnementPourRechercheDemandeIntiale(DemandeSpec demande, boolean estValidationDecision)
  {
    Damj dateFinAbonnement = demande.getDateExamen();
    Damj dateAttribution = demande.getDateAttribution();
    if ((dateAttribution != null) && (dateFinAbonnement != null))
    {
      if ((demande.estEnContexteDemande("SORTIECRA")) && (estValidationDecision)) {
        dateFinAbonnement = dateAttribution;
      } else {
        dateFinAbonnement = Damj.max(dateFinAbonnement, dateAttribution);
      }
    }
    else {
      dateFinAbonnement = demande.getDateDeclenchementExamen();
    }
    return dateFinAbonnement;
  }
  
  public DemandeSpec recupererProchaineDemande(List demandes)
  {
    DemandeSpec resultat = null;
    if ((demandes != null) && (!demandes.isEmpty())) {
      resultat = (DemandeSpec)demandes.get(0);
    }
    return resultat;
  }
  
  public List<AttributionSpec> recupererAttributionsAReexecuter(IndividuSpec individu, Damj date, int prioriteGamme, ComportementSpec comportement, int prioriteERE, String referenceExterne)
  {
    List<AttributionSpec> listeAttributions = new ArrayList();
    if (date != null)
    {
      List<AttributionSpec> attributions = individu.getListeAttributionsExecutablesAvant(date);
      
      Iterator<AttributionSpec> iterator = attributions.iterator();
      while (iterator.hasNext())
      {
        AttributionSpec attribution = (AttributionSpec)iterator.next();
        if (estAttributionAReexecuter(attribution, comportement, date, prioriteGamme, prioriteERE, referenceExterne)) {
          ajouterAttributionAListe(listeAttributions, attribution);
        }
      }
    }
    return listeAttributions;
  }
  
  private void ajouterAttributionAListe(List<AttributionSpec> listeAttributions, AttributionSpec attribution)
  {
    if (attribution.getDemande() != null) {
      listeAttributions.addAll(getListeAttributions(attribution.getDemande()));
    } else {
      listeAttributions.add(attribution);
    }
  }
  
  private boolean estAttributionAReexecuter(AttributionSpec attribution, ComportementSpec comportement, Damj date, int prioriteGamme, int prioriteERE, String referenceExterne)
  {
    if ((attribution != null) && (attribution.estExecutable()) && (reexecuterDemande(attribution, comportement)))
    {
      if (attribution.getDateFinAbonnement().estAvant(date)) {
        return true;
      }
      if (attribution.getDateFinAbonnement().coincideAvec(date)) {
        return estAttributionAReexecuterAvecDateIdentique(attribution, prioriteGamme, prioriteERE, referenceExterne);
      }
    }
    return false;
  }
  
  private boolean estAttributionAReexecuterAvecDateIdentique(AttributionSpec attribution, int prioriteGamme, int prioriteERE, String referenceExterne)
  {
    if (recupererPrioriteGamme(attribution) > prioriteGamme) {
      return true;
    }
    if (recupererPrioriteGamme(attribution) == prioriteGamme) {
      if (attribution.getDemande() != null) {
        estAttributionAReexecuterAvecGammeIdentique(attribution, prioriteERE, referenceExterne);
      } else {
        return true;
      }
    }
    return false;
  }
  
  private boolean estAttributionAReexecuterAvecGammeIdentique(AttributionSpec attribution, int prioriteERE, String referenceExterne)
  {
    if (attribution.getDemande().getEvenementReferenceExamen().getPriorite() > prioriteERE) {
      return true;
    }
    if (attribution.getDemande().getEvenementReferenceExamen().getPriorite() == prioriteERE) {
      return (referenceExterne != null) && (attribution.getDemande().getFormulaire().getReferenceExterne() != null) && (attribution.getDemande().getFormulaire().getReferenceExterne().compareTo(referenceExterne) <= 0);
    }
    return false;
  }
  
  private int recupererPrioriteGamme(AttributionSpec attribution)
  {
    int priorite;
    int priorite;
    if (attribution.getDemande() != null) {
      priorite = attribution.getDemande().getGamme().getPriorite();
    } else {
      priorite = attribution.getGamme().getPriorite();
    }
    return priorite;
  }
  
  public List<DemandeSpec> recupererDemandesANettoyer(IndividuSpec individu, Damj date, int priorite)
  {
    List<DemandeSpec> listeDemandes = new ArrayList();
    
    ChronologieDebuts chronoDemandes = individu.getChronoDemandes();
    Iterator<DemandeSpec> iterateurDemandes = chronoDemandes.iterer();
    while (iterateurDemandes.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterateurDemandes.next();
      if ((estDemandeANettoyer(demande, date)) && (estDemandeANettoyerAvecGestionDemandeAMemeDate(demande, date, priorite))) {
        listeDemandes.add(demande);
      }
    }
    return listeDemandes;
  }
  
  private boolean estDemandeANettoyer(DemandeSpec demande, Damj date)
  {
    boolean estDemandeDecisionNonEnReexeamen = (demande.estDecisionnee()) && (demande.estReexecutable()) && (!demande.estEnReExamen());
    boolean estDemandeNonClassee = (demande.getClassementAdministratif() == null) || (((demande.getClassementAdministratif() instanceof Prescription)) && (!((Prescription)demande.getClassementAdministratif()).isValidite()));
    
    return (estDemandeDecisionNonEnReexeamen) && (estDemandeNonClassee) && ((date == null) || (demande.getDateFinAbonnement().estApresOuCoincideAvec(date)));
  }
  
  private boolean estDemandeANettoyerAvecGestionDemandeAMemeDate(DemandeSpec demande, Damj date, int priorite)
  {
    return (date == null) || (!demande.getDateFinAbonnement().coincideAvec(date)) || (demande.getGamme().getPriorite() <= priorite);
  }
  
  public Damj getDateExecution(DemandeSpec demande)
  {
    return demande.getDateFinAbonnement();
  }
  
  public Collection<AttributionSpec> getListeAttributions(DemandeSpec demande)
  {
    List<AttributionSpec> listeAttributions = new ArrayList();
    
    List<?> decisions = demande.getListeDossiersExamen();
    if (decisions != null)
    {
      Iterator<?> iteratorDecisions = decisions.iterator();
      while (iteratorDecisions.hasNext())
      {
        Object decision = iteratorDecisions.next();
        if (((decision instanceof AttributionSpec)) && (((AttributionSpec)decision).estExecutable()))
        {
          AttributionSpec attribution = (AttributionSpec)decision;
          listeAttributions.add(attribution);
          if (attribution.getAttributionLiees() != null) {
            listeAttributions.addAll(attribution.getAttributionLiees());
          }
        }
      }
    }
    return listeAttributions;
  }
  
  public List<AttributionSpec> getListeAttributions(Collection<DemandeSpec> demandes)
  {
    List<AttributionSpec> listeAttributions = new ArrayList();
    
    Iterator<DemandeSpec> itDemandes = demandes.iterator();
    while (itDemandes.hasNext())
    {
      DemandeSpec demandeCourante = (DemandeSpec)itDemandes.next();
      listeAttributions.addAll(getListeAttributions(demandeCourante));
    }
    return listeAttributions;
  }
  
  public void ajouterAttributionAReexecuter(List<AttributionSpec> attributionsAReexecuter, DemandeSpec demandeAAjouter)
  {
    boolean demandePresente = false;
    Iterator<AttributionSpec> itAttributions = attributionsAReexecuter.iterator();
    while ((itAttributions.hasNext()) && (!demandePresente))
    {
      AttributionSpec attributionCourante = (AttributionSpec)itAttributions.next();
      if ((attributionCourante.getDemande() != null) && (attributionCourante.getDemande().equals(demandeAAjouter))) {
        demandePresente = true;
      }
    }
    if (!demandePresente) {
      attributionsAReexecuter.addAll(getListeAttributions(demandeAAjouter));
    }
  }
  
  public List<AttributionSpec> supprimerAttributionAReexecuter(List<AttributionSpec> attributionsAReexecuter, DemandeSpec demandeASupprimer)
  {
    List<AttributionSpec> nouvellesAttributionsAReexecuter = new ArrayList();
    Iterator<AttributionSpec> itAttributions = attributionsAReexecuter.iterator();
    while (itAttributions.hasNext())
    {
      AttributionSpec attributionCourante = (AttributionSpec)itAttributions.next();
      if ((attributionCourante.getDemande() != null) && (!attributionCourante.getDemande().equals(demandeASupprimer)))
      {
        nouvellesAttributionsAReexecuter.add(attributionCourante);
        if (attributionCourante.getAttributionLiees() != null) {
          nouvellesAttributionsAReexecuter.addAll(attributionCourante.getAttributionLiees());
        }
      }
    }
    return nouvellesAttributionsAReexecuter;
  }
  
  public List<AttributionSpec> miseAJourAttributionsAReexecuter(List<AttributionSpec> attributionsAReexecuter, List<DemandeSpec> demandesAReliquder)
  {
    List<AttributionSpec> nouvellesAttributionsAReexecuter = new ArrayList();
    nouvellesAttributionsAReexecuter.addAll(attributionsAReexecuter);
    Iterator<DemandeSpec> itDemandes = demandesAReliquder.iterator();
    while (itDemandes.hasNext())
    {
      DemandeSpec demandeCourante = (DemandeSpec)itDemandes.next();
      nouvellesAttributionsAReexecuter = supprimerAttributionAReexecuter(nouvellesAttributionsAReexecuter, demandeCourante);
    }
    return nouvellesAttributionsAReexecuter;
  }
  
  public void ajouterDemandesALiquiderSansDoublon(List<DemandeSpec> demandesALiquider, List<DemandeSpec> demandesAAjouter)
  {
    Iterator<DemandeSpec> itDemandes = demandesAAjouter.iterator();
    while (itDemandes.hasNext())
    {
      DemandeSpec demandeCourante = (DemandeSpec)itDemandes.next();
      if (!demandesALiquider.contains(demandeCourante)) {
        demandesALiquider.add(demandeCourante);
      }
    }
  }
  
  private boolean reexecuterDemande(AttributionSpec attribution, ComportementSpec comportement)
  {
    return (!attribution.estMigree()) || ((comportement != null) && (comportement.isReexucutionDecisionMigrees()));
  }
  
  public Damj determinerDateReexecutionInitiale(DomGestionnaireReexecution donnees)
    throws CoucheLogiqueException
  {
    Damj dateEvenementReexamen = donnees.getEvenementReexamen().getDateReexamen();
    Damj dateReexecutionInitiale;
    Damj dateReexecutionInitiale;
    if ((estComportementSpecifiquePourDateDepartReexecution(donnees.getComportement())) || (estAucuneAttributionAvantDateReexecutionSouhaitee(donnees.getIndividu(), dateEvenementReexamen)))
    {
      dateReexecutionInitiale = dateEvenementReexamen.getDebutMois();
    }
    else
    {
      dateReexecutionInitiale = OutilDeterminationDateDebutExecution.getInstance().rechercherDateDebutExecution(dateEvenementReexamen, Damj.FIN_DES_TEMPS, true, donnees.getIndividu());
      
      dateReexecutionInitiale = Damj.min(dateEvenementReexamen, dateReexecutionInitiale);
      if (dateEvenementReexamen.estApresOuCoincideAvec(PopulationSpec.DATE_LIMITE_NON_REEXECUTION)) {
        dateReexecutionInitiale = Damj.max(dateReexecutionInitiale, PopulationSpec.DATE_LIMITE_NON_REEXECUTION);
      }
    }
    return dateReexecutionInitiale;
  }
  
  protected boolean estComportementSpecifiquePourDateDepartReexecution(ComportementSpec comportement)
  {
    return ((comportement instanceof ComportementBatchReconductionSystematique)) || ((comportement instanceof ComportementVnrBatch));
  }
  
  protected boolean estAucuneAttributionAvantDateReexecutionSouhaitee(IndividuSpec individu, Damj dateRexecutionSouhaite)
  {
    FiltreAttributionSurDecisions filtre = new FiltreAttributionSurDecisions(true);
    return OutilRecherche.rechercherDecisionsPrecedentes(individu.getChronoDemandes(), dateRexecutionSouhaite.lendemain(), filtre).estVide();
  }
  
  public void ajouterDemandeFinDroit(DemandeSpec demande, List<DemandeSpec> listeDemandesARevalider)
  {
    if (OutilDemande.estUneDemandeAsp(demande))
    {
      List<DemandeSpec> demandesAAjouter = new ArrayList();
      DemandeSpec demandeFinDroit = OutilAsp.rechercherDemandeFinAspSuivantDemandeAsp(demande);
      if (demandeFinDroit != null) {
        demandesAAjouter.add(demandeFinDroit);
      }
      MiseEnReexamenDemande.miseEnReexamen(demandesAAjouter);
      ajouterDemandesALiquiderSansDoublon(listeDemandesARevalider, demandesAAjouter);
    }
  }
  
  protected void completerListeDemandesAReliquiderInitialeParDemandesNpde(List<DemandeSpec> listedemandes, DomGestionnaireReexecution domGestionnaireReexecution, Chronologie demandes, Damj dateReexecution)
  {
    if ("TD".equals(domGestionnaireReexecution.getContexteEmission()))
    {
      List<DemandeSpec> demandesNpdeAReexecuter = recupererDemandeNpdeAReexecuter(demandes, dateReexecution);
      declasserEtAjouterDateValidationDemandeSansSuite(demandesNpdeAReexecuter);
      listedemandes.addAll(demandesNpdeAReexecuter);
      trierListeDemandesAReliquider(listedemandes);
    }
  }
  
  protected void declasserEtAjouterDateValidationDemandeSansSuite(List<DemandeSpec> listeDemande)
  {
    if (listeDemande != null)
    {
      Iterator<DemandeSpec> itDemande = listeDemande.iterator();
      while (itDemande.hasNext())
      {
        DemandeSpec demandeCourante = (DemandeSpec)itDemande.next();
        ClassementAdministratifSpec classementAdmDdeCourante = demandeCourante.getClassementAdministratif();
        if ((classementAdmDdeCourante != null) && ("SS".equals(classementAdmDdeCourante.getTypeClassement())))
        {
          definirDatePremiereValidation(demandeCourante);
          declasserDemande(demandeCourante);
          demandeCourante.setDecisionAuto(true);
        }
      }
    }
  }
  
  private void toperDecisionAutoSurDemande(List<DemandeSpec> listeDemandes)
  {
    for (DemandeSpec demandeCourante : listeDemandes) {
      demandeCourante.setDecisionAuto(true);
    }
  }
  
  protected List<DemandeSpec> recupererDemandeNpdeAReexecuter(Chronologie demandes, Damj dateReexecution)
  {
    List<DemandeSpec> demandesListe = new ArrayList();
    if (demandes != null)
    {
      FiltreET filtreDdeNpdeApresDateReexecAttDecOuClasseSansSuite = new FiltreET();
      
      ConteneurFiltredemandeNpde conteneurFiltreDemandeNpde = new ConteneurFiltredemandeNpde(true, true);
      filtreDdeNpdeApresDateReexecAttDecOuClasseSansSuite.ajouterFiltre(new FiltreDemandeNpde(conteneurFiltreDemandeNpde));
      
      FiltreOU filtreAttenteDecisionOuSansSuite = new FiltreOU();
      filtreAttenteDecisionOuSansSuite.ajouterFiltre(new FiltreDemandeAttenteDecision());
      filtreAttenteDecisionOuSansSuite.ajouterFiltre(new FiltreDemandePourClassement("SS"));
      
      filtreDdeNpdeApresDateReexecAttDecOuClasseSansSuite.ajouterFiltre(filtreAttenteDecisionOuSansSuite);
      
      filtreDdeNpdeApresDateReexecAttDecOuClasseSansSuite.ajouterFiltre(new FiltreDemandeSuivantesDateAbonnement(dateReexecution, true));
      
      Chronologie demandesFiltrees = demandes.copier(filtreDdeNpdeApresDateReexecAttDecOuClasseSansSuite);
      
      demandesListe = demandesFiltrees.mapperVersListe();
      toperDecisionAutoSurDemande(demandesListe);
    }
    if (demandesListe == null) {
      demandesListe = new ArrayList();
    }
    return demandesListe;
  }
  
  protected void definirDatePremiereValidation(DemandeSpec demandeCourante)
  {
    demandeCourante.setDatePremiereValidation(demandeCourante.getDateRecherche());
  }
  
  protected void declasserDemande(DemandeSpec demande)
  {
    demande.setClassementAdministratif(null);
  }
}

/* Location:
 * Qualified Name:     OutilGestionnaireReexecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */