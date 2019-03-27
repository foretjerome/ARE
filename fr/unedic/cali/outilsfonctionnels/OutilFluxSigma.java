package fr.unedic.cali.outilsfonctionnels;

import fr.pe.cali.ManagerFluxCali;
import fr.pe.cali.logique.donnees.vls.FluxCaliIn;
import fr.pe.cali.logique.donnees.vls.FluxCali_In;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.pbjc.dom.DispositifNcp;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.Prescription;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.dom.affectation.GammeRbf;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.echange.Decision;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OutilFluxSigma
  extends OutilFlux
{
  public static final Integer ETAT_REEXAMEN = Integer.valueOf(1);
  public static final Integer ETAT_CLASSEE = Integer.valueOf(2);
  public static final Integer ETAT_DECISIONNEE_VALIDEE = Integer.valueOf(3);
  public static final Integer ETAT_NON_DECISIONNEE = Integer.valueOf(4);
  public static final Integer ETAT_CLASSEE_PRESCRIPTION_VALIDE = Integer.valueOf(5);
  public static final Integer ETAT_CLASSEE_PRESCRIPTION_NON_OPPOSABLE = Integer.valueOf(6);
  public static final Integer ETAT_CLASSEE_SP = Integer.valueOf(7);
  
  public static void notifierSigma(IndividuSpec individu, Collection demandesModifiees, boolean forcerEmissionSurNotification)
    throws ApplicativeException
  {
    boolean notificationLiquidation = !demandesModifiees.isEmpty();
    if (notificationLiquidation)
    {
      Iterator iterDemandesModifiees = demandesModifiees.iterator();
      ArrayList listeRsodAttributionFrontaliere = new ArrayList();
      while (iterDemandesModifiees.hasNext())
      {
        DemandeSpec demandeModifiee = (DemandeSpec)iterDemandesModifiees.next();
        
        alimenterBasesSurDemandeModifiee(demandeModifiee);
        if (GammeAsu.getInstance().notifierAttributionPourEESSI(demandeModifiee))
        {
          String rsod = ((AttributionSpec)demandeModifiee.getDossierAffectation().getDossierExamen()).getRsod();
          listeRsodAttributionFrontaliere.add(rsod);
        }
      }
      if (!listeRsodAttributionFrontaliere.isEmpty()) {
        creerTraceTrackerPourOdf(individu, listeRsodAttributionFrontaliere);
      }
    }
    boolean notificationCalcul = estCalculEffectue(individu);
    if (notificationCalcul) {
      alimenterBasesSurReexecution(individu);
    }
    if (individu.estDispositifAllonge()) {
      alimenterBasesSurAllongement(individu);
    }
    if ((!notificationCalcul) && (forcerEmissionSurNotification) && (!notificationLiquidation)) {
      declencherTCIS(individu);
    }
  }
  
  private static void creerTraceTrackerPourOdf(IndividuSpec individu, List listeRsodAttributionFrontaliere)
    throws CoucheLogiqueException
  {
    TraceTrackerEnModeEmission trace = creerTraceTracker(individu, "ODF", "D90", "ODF");
    individu.ajouterTraceTrackerEnModeEmission(trace);
    trace.setListeRsodAttributionFrontaliere(listeRsodAttributionFrontaliere);
  }
  
  public static void notifierSigmaPourDecisionAutomatique(DemandeSpec demande)
    throws ApplicativeException
  {
    IndividuSpec individu = demande.getDemandeur();
    
    ContexteService contexteService = individu.getContexteService();
    
    TraceTrackerEnModeEmission trace = alimenterBaseTrackerEmission(contexteService, "CID", "A12INT");
    
    individu.ajouterTraceTrackerEnModeEmission(trace);
    
    alimenterBaseEchange(demande, trace.getIdTracker());
    
    boolean notificationCalcul = estCalculEffectue(individu);
    if (notificationCalcul) {
      alimenterBasesSurReexecution(individu);
    }
    if (individu.estDispositifAllonge()) {
      alimenterBasesSurAllongement(individu);
    }
  }
  
  public static void notifierSigmaPourCreationDemandeExamenFilEau(IndividuSpec individu, Damj dateFctTraitee, String typeDal)
    throws ApplicativeException
  {
    ContexteService contexteService = individu.getContexteService();
    
    TraceTrackerEnModeEmission trace = alimenterBaseTrackerEmission(contexteService, "CID", "A12INT");
    
    individu.ajouterTraceTrackerEnModeEmission(trace);
    
    AlimenterBaseEchanges.alimenterDonneesCreationDALExamenFilEau(typeDal, dateFctTraitee, trace.getIdTracker());
  }
  
  public static void notifierSigmaPourCreationAttenteExamenFilEau(IndividuSpec individu, Damj dateFctTraitee, String typeAttente)
    throws ApplicativeException
  {
    ContexteService contexteService = individu.getContexteService();
    
    TraceTrackerEnModeEmission trace = alimenterBaseTrackerEmission(contexteService, "CID", "A12INT");
    
    individu.ajouterTraceTrackerEnModeEmission(trace);
    
    AlimenterBaseEchanges.alimenterDonneesCreationAttenteExamenFilEau(typeAttente, dateFctTraitee, trace.getIdTracker());
  }
  
  private static void alimenterBasesSurDemandeModifiee(DemandeSpec demande)
    throws ApplicativeException
  {
    String destinataire = "CID";
    
    IndividuSpec individu = demande.getDemandeur();
    
    ContexteService contexteService = individu.getContexteService();
    
    alimenterBasePivot(demande);
    if ((demande.getGamme() instanceof GammeRbf)) {
      destinataire = "RBF";
    }
    TraceTrackerEnModeEmission trace = alimenterBaseTrackerEmission(contexteService, destinataire, "A12INT");
    
    individu.ajouterTraceTrackerEnModeEmission(trace);
    
    alimenterBaseEchange(demande, trace.getIdTracker());
  }
  
  private static void alimenterBasesSurReexecution(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    ContexteService contexteService = individu.getContexteService();
    
    TraceTrackerEnModeEmission trace = alimenterBaseTrackerEmission(contexteService, "CAL", "A12INT");
    
    individu.ajouterTraceTrackerEnModeEmission(trace);
  }
  
  private static void alimenterBasesSurAllongement(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    ContexteService contexteService = individu.getContexteService();
    
    TraceTrackerEnModeEmission trace = alimenterBaseTrackerEmission(contexteService, "IPC", "A12INT");
    for (DispositifNcp dispositif : individu.getCollectionDispositifNcp()) {
      if (dispositif.isEstModifie()) {
        dispositif.setIdTracker(trace.getIdTracker());
      }
    }
    individu.ajouterTraceTrackerEnModeEmission(trace);
  }
  
  public static void emettreFlux(ContexteService contexteService)
  {
    if ((contexteService != null) && (contexteService.getContexteEmission() != null) && (contexteService.getContexteEmission().equals("TP")))
    {
      ManagerFluxCali managerFlux = new ManagerFluxCali();
      
      FluxCaliIn in = FluxCaliIn.getInstance();
      in.setFluxCali_In(FluxCali_In.getInstance());
      
      in.getFluxCali_In().setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsCaliFlux(contexteService));
      try
      {
        OutilTrace.ecrireTrace(Niveau.INFO, new Object[] { "\t Emission du flux Cali - A12INTEGRATION \n", "\t Id Tracker : ", contexteService.getIdCourantTracker(), "\n", "\t Date et heure de création du flux : ", contexteService.getDateHeureCreation(), "\n", "\t Emetteur : ", contexteService.getSrcCodeDomaine(), "\n", "\t Destinataire : ", contexteService.getDstCodeDomaine() });
        
        managerFlux.emettreFluxA12INTEGRATION(in);
      }
      catch (ApplicativeException ex1)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_CALI", "Problème lors de l'appel de service de CALI vers CALI", ex1);
      }
      catch (TechniqueException ex1)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_CALI", "Problème lors de l'appel de service de CALI vers CALI", ex1);
      }
    }
  }
  
  private static void alimenterBaseEchange(DemandeSpec demande, String idTracker)
    throws ApplicativeException
  {
    Decision demandeBaseEchange = AlimenterBaseEchanges.alimenterDonneesHorsGamme(demande, idTracker);
    
    DomManager.persisterEnProfondeur(demandeBaseEchange);
    
    OutilTrace.ecrireTrace(Niveau.INFO, new Object[] { "Alimentation de la base Echange : \t Id Tracker : ", idTracker, "\n", "\t Type de demande : ", demande.getGamme().getNomUnique(), "\n", "\t Identifiant de la demande : ", demande.getIdentifiant() });
  }
  
  private static void alimenterBasePivot(DemandeSpec demande)
    throws ApplicativeException, CoucheLogiqueException
  {
    AlimentationBasePivot.enregistrerBasePivot(demande);
    
    OutilTrace.ecrireTrace(Niveau.INFO, new Object[] { "Alimentation de la base Pivot : \t Type de demande : ", demande.getGamme().getNomUnique(), "\n", "\t Identifiant de la demande : ", demande.getIdentifiant() });
  }
  
  public static Integer getEtatDemande(DemandeSpec demande)
  {
    if (demande.estEnReExamen()) {
      return ETAT_REEXAMEN;
    }
    if (demande.getClassementAdministratif() != null) {
      return getEtatDemandeClassee(demande);
    }
    if (demande.estDecisionnee()) {
      return ETAT_DECISIONNEE_VALIDEE;
    }
    return ETAT_NON_DECISIONNEE;
  }
  
  private static Integer getEtatDemandeClassee(DemandeSpec demande)
  {
    Integer etatDemande = ETAT_CLASSEE;
    if ("PS".equalsIgnoreCase(demande.getClassementAdministratif().getTypeClassement())) {
      etatDemande = ((Prescription)demande.getClassementAdministratif()).isValidite() ? ETAT_CLASSEE_PRESCRIPTION_VALIDE : ETAT_CLASSEE_PRESCRIPTION_NON_OPPOSABLE;
    } else if ("SP".equalsIgnoreCase(demande.getClassementAdministratif().getTypeClassement())) {
      etatDemande = ETAT_CLASSEE_SP;
    }
    return etatDemande;
  }
  
  public static Map sauvegarderEtatDemandes(IndividuSpec individu)
  {
    Map resultat = new HashMap();
    
    List listeDemandes = individu.getChronoDemandes().mapperVersListe();
    Iterator iterDemandes = listeDemandes.iterator();
    while (iterDemandes.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterDemandes.next();
      resultat.put(demande.getIdentifiant(), getEtatDemande(demande));
    }
    return resultat;
  }
  
  public static Collection recupererDemandesImpacteesNonNeutralisees(Map etatsAvant, IndividuSpec individu, Damj dateEvenement)
  {
    Collection demandesImpactees = new ArrayList();
    
    List listeDemandes = individu.getChronoDemandes().mapperVersListe();
    Collections.sort(listeDemandes, new ComparateurSurDateDeclenchementEtPrioriteDemande());
    
    Iterator iterDemandes = listeDemandes.iterator();
    while (iterDemandes.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterDemandes.next();
      
      Integer etatApres = getEtatDemande(demande);
      Integer etatAvant = (Integer)etatsAvant.get(demande.getIdentifiant());
      if ((dateEvenement != null) && (demande.getDateRecherche().estApresOuCoincideAvec(dateEvenement)))
      {
        if ((demande.estReexaminable()) && (estUneDemandeANotifier(demande, etatAvant, etatApres))) {
          demandesImpactees.add(demande);
        }
      }
      else
      {
        if ((etatAvant != null) && (!etatAvant.equals(etatApres))) {
          demandesImpactees.add(demande);
        }
        if ((etatAvant == null) && (demande.getClassementAdministratif() != null)) {
          demandesImpactees.add(demande);
        }
      }
    }
    return demandesImpactees;
  }
  
  private static boolean estUneDemandeANotifier(DemandeSpec demande, Integer etatAvant, Integer etatApres)
  {
    boolean retour = true;
    if ((ETAT_NON_DECISIONNEE.equals(etatAvant)) && (ETAT_NON_DECISIONNEE.equals(etatApres)) && (!"ASU_07".equals(demande.getEvenementReferenceExamen().getTypeExamen()))) {
      retour = false;
    }
    if ((ETAT_REEXAMEN.equals(etatAvant)) && (ETAT_REEXAMEN.equals(etatApres))) {
      retour = false;
    }
    if ((ETAT_CLASSEE.equals(etatAvant)) && (ETAT_CLASSEE.equals(etatApres))) {
      retour = false;
    }
    if ((ETAT_CLASSEE_SP.equals(etatAvant)) && (ETAT_CLASSEE_SP.equals(etatApres))) {
      retour = false;
    }
    return retour;
  }
  
  public static Collection recupererDemandesModifiees(Map etatsAvant, IndividuSpec individu)
  {
    Collection demandesModifiees = new ArrayList();
    
    List listeDemandes = individu.getChronoDemandes().mapperVersListe();
    Collections.sort(listeDemandes, new ComparateurSurDateDeclenchementEtPrioriteDemande());
    
    Iterator iterDemandes = listeDemandes.iterator();
    while (iterDemandes.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterDemandes.next();
      
      Integer etatApres = getEtatDemande(demande);
      Integer etatAvant = (Integer)etatsAvant.get(demande.getIdentifiant());
      if ((etatAvant != null) && (!etatAvant.equals(etatApres))) {
        demandesModifiees.add(demande);
      }
      if ((etatAvant == null) && (demande.getClassementAdministratif() != null)) {
        demandesModifiees.add(demande);
      }
    }
    return demandesModifiees;
  }
  
  public static boolean estCalculEffectue(IndividuSpec individu)
  {
    List listeDemandes = individu.getChronoDemandes().mapperVersListe();
    Collections.sort(listeDemandes, new ComparateurSurDateDeclenchementEtPrioriteDemande());
    
    Iterator iterDemandes = listeDemandes.iterator();
    boolean demandeModifieeTrouvee = false;
    while ((iterDemandes.hasNext()) && (!demandeModifieeTrouvee))
    {
      DemandeSpec demande = (DemandeSpec)iterDemandes.next();
      if (demande.estReexecutee()) {
        demandeModifieeTrouvee = true;
      }
    }
    return demandeModifieeTrouvee;
  }
  
  private static void declencherTCIS(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    TraceTrackerEnModeEmission trace = new TraceTrackerEnModeEmission(null, null, "A12INT", individu.getContexteService(), null, null, null, null);
    
    individu.ajouterTraceTrackerEnModeEmission(trace);
  }
}

/* Location:
 * Qualified Name:     OutilFluxSigma
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */