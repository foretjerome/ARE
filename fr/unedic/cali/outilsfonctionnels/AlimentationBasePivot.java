package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.NaturesDecisions;
import fr.unedic.cali.dom.RejetSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.pivot.AidesNcp;
import fr.unedic.cali.dom.pivot.Attribution;
import fr.unedic.cali.dom.pivot.Decision;
import fr.unedic.cali.dom.pivot.DemandePivot;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;

public class AlimentationBasePivot
{
  public static final int TAILLE_ID_LIDO = 17;
  
  public static void enregistrerBasePivot(DemandeSpec demande)
    throws ApplicativeException, CoucheLogiqueException
  {
    if (demande.getEvenementReferenceExamen().mettreEnBasePivot()) {
      if (demande.estEnReExamen())
      {
        if (demande.getDemandePivot() != null)
        {
          if (demande.getDemandePivot().getAttribution() != null) {
            demande.getDemandePivot().getAttribution().setCodeValidationComplementaire(determineEnRexamen(demande));
          }
          if (demande.getDemandePivot().getDecision() != null) {
            demande.getDemandePivot().getDecision().setCodeReexamen(determineEnRexamen(demande));
          }
        }
      }
      else
      {
        demande.getGamme().enregistrerBasePivot(demande);
        if ((demande.getDemandePivot() != null) && (demande.getDemandePivot().getDecision() != null))
        {
          Decision decisionPivot = demande.getDemandePivot().getDecision();
          if ((NaturesDecisions.estdeTypeRejet(decisionPivot.getNatureDecision())) && (decisionPivot.getMotifRejet() == 0)) {
            throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_CALI_TECH_REJET_PIVOT_INCOHERENT", "Notification d'un rejet en base pivot sans motif de rejet.");
          }
        }
      }
    }
    if (demande.getEvenementReferenceExamen().mettreEnBasePivotAideNcp()) {
      if (demande.estEnReExamen())
      {
        if ((demande.getDemandePivot() != null) && (demande.getDemandePivot().getAidesNcp() != null)) {
          demande.getDemandePivot().getAidesNcp().setLibelleBanalise4(determineValideeEtOuReexamen(demande));
        }
      }
      else {
        demande.getGamme().enregistrerBasePivotAides(demande);
      }
    }
  }
  
  public static void alimenterDonneesHorsGamme(DemandeSpec demandeCali, DemandePivot demandePivot)
    throws CoucheLogiqueException
  {
    Attribution attribution = demandePivot.getAttribution();
    if (attribution != null) {
      renseignerAttribution(attribution, demandeCali);
    }
    renseignerDecision(demandePivot.getDecision(), demandeCali);
  }
  
  private static void renseignerAttribution(Attribution attribution, DemandeSpec demandeCali)
  {
    attribution.setIdentifiantDemandeCali(demandeCali.getIdentifiant());
  }
  
  private static void renseignerDecision(Decision decision, DemandeSpec demandeCali)
  {
    decision.setIdentifiantDemandeCali(demandeCali.getIdentifiant());
    if (!estClassementValide(demandeCali)) {
      decision.setTopLiquidationEnEtat(demandeCali.estLiquideeEnEtat() ? "1" : "0");
    }
  }
  
  public static int determinerCodeRejet(DemandeSpec demandeCali)
  {
    int motifRejet = 0;
    if ((demandeCali.getCodeMotifEchecPourSigma() != null) && (demandeCali.getCodeMotifEchecPourSigma() != "")) {
      motifRejet = Integer.valueOf(demandeCali.getCodeMotifEchecPourSigma()).intValue();
    }
    if ((demandeCali.estEnReExamen()) || ((demandeCali.getDossierAffectation().getDossierExamen() != null) && ((demandeCali.getDossierAffectation().getDossierExamen() instanceof RejetSpec)) && (motifRejet == 0))) {
      if (demandeCali.getCodeMotifEchecPourSigmaSauvegarde() != null) {
        motifRejet = Integer.valueOf(demandeCali.getCodeMotifEchecPourSigmaSauvegarde()).intValue();
      }
    }
    return motifRejet;
  }
  
  public static void renseignerCodeRejet(DemandeSpec demandeCali, Decision decision)
  {
    decision.setMotifRejet(determinerCodeRejet(demandeCali));
  }
  
  public static void sauvegarderCodeMotifRejet(DemandeSpec demandeCali)
  {
    if ((demandeCali.getDemandePivot() != null) && (demandeCali.getDemandePivot().getDecision() != null)) {
      demandeCali.setCodeMotifEchecPourSigmaSauvegarde(Integer.valueOf(demandeCali.getDemandePivot().getDecision().getMotifRejet()).toString());
    }
  }
  
  public static String determineValidee(DemandeSpec demande)
  {
    String code = "";
    if (demande.estClasseeOuDecisionneeValidee()) {
      code = "V";
    } else {
      code = "E";
    }
    return code;
  }
  
  public static String determineEnRexamen(DemandeSpec demande)
  {
    String code = "";
    if (demande.estEnReExamen()) {
      code = "R";
    }
    return code;
  }
  
  public static String determineTypeExamen(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    EvenementReferenceExamenSpec ere = demande.getEvenementReferenceExamen();
    if (ere == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_ERR_EVEN_REF_EXAMEN_NON_REFERENCE");
    }
    return ConstructionCSOIA.getCSOIADepuisTypeExamen(ere.getTypeExamen());
  }
  
  public static String determineClassementAdministratif(DemandeSpec demande)
  {
    String cl = null;
    if (demande.getClassementAdministratif() != null)
    {
      ClassementAdministratif classementAdministratif = demande.getClassementAdministratif();
      if (classementAdministratif.estClassementValide()) {
        cl = classementAdministratif.getTypeClassement();
      }
    }
    return cl;
  }
  
  public static void calculIdentifiants(Attribution attributionPivot, AttributionSpec attributionCali, int rsod)
  {
    attributionPivot.setIdentifiantOuvertureDroit(rsod);
    if (attributionCali.getRsrp() != null)
    {
      Integer rsrp = Integer.valueOf(attributionCali.getRsrp());
      attributionPivot.setIdentifiantReprise(rsrp.intValue());
    }
    attributionPivot.setIdentifiantOuvertureDroitAttributionPrecedente(AlgorithmesIdentifiantSigma.determineRsodAttributionPrecedente(attributionCali.getDemande()));
  }
  
  public static int determineNatureDecision(DossierExamenSpec dossier)
  {
    int nature = 0;
    nature = ((DecisionSpec)dossier).getNatureDecision();
    if (dossier.getDemande().getGamme().estDecisionRenoncement(dossier.getDemande())) {
      nature = 98;
    }
    return nature;
  }
  
  public static boolean estClassementValide(DemandeSpec demande)
  {
    if (demande.getClassementAdministratif() != null) {
      return demande.getClassementAdministratif().estClassementValide();
    }
    return false;
  }
  
  public static String determineNomProduit(DemandeSpec demande)
  {
    String code = "";
    if ((demande.getDossierAffectation() != null) && (demande.getDossierAffectation().getProduit() != null) && (demande.getDossierAffectation().getProduit().getNom() != null)) {
      code = demande.getDossierAffectation().getProduit().getNom();
    }
    return code;
  }
  
  public static String determineNomPourPivotUniteAffiliation(String punite)
  {
    String unite = "";
    if ((punite != null) && (!punite.equals(""))) {
      if ((punite.equals("heure de travail")) || (punite.equals("heure")))
      {
        unite = "H";
      }
      else if ((punite.equals("jour d'affiliation")) || (punite.equals("jour")))
      {
        unite = "J";
      }
      else if (punite.equals("embarquement administratif"))
      {
        unite = "E";
      }
      else if (punite.equals("vacation"))
      {
        unite = "V";
      }
      else
      {
        if (Log.isTraceActive(AlimentationBasePivot.class, Niveau.DEBUG)) {
          Log.ecritTrace(Niveau.DEBUG, AlimentationBasePivot.class, "determineNomPourPivotUniteAffiliation", "unité durée affiliation non mappée, unité reçue : " + unite.getClass().getName());
        }
        throw new UnsupportedOperationException("AlimentationBase pivot - Unité non mappée : " + unite);
      }
    }
    return unite;
  }
  
  private static void renseignerAideNcp(AidesNcp aideNcp, DemandeSpec demande)
  {
    if (aideNcp != null)
    {
      renseignerAideNcpDemande(aideNcp, demande);
      if ((demande.getDossierAffectation() != null) && (demande.getDossierAffectation().getDossierExamen() != null))
      {
        DossierExamenSpec dossierExamen = demande.getDossierAffectation().getDossierExamen();
        
        DecisionSpec decisionCali = null;
        if ((dossierExamen instanceof DecisionSpec)) {
          decisionCali = (DecisionSpec)dossierExamen;
        }
        if (decisionCali != null) {
          aideNcp.setLibelleBanalise3(Integer.toString(decisionCali.getNatureDecision()));
        }
        AttributionSpec attributionCali = null;
        if ((dossierExamen instanceof AttributionSpec)) {
          attributionCali = (AttributionSpec)dossierExamen;
        }
        if (attributionCali != null) {
          aideNcp.setDateBanalisee2(attributionCali.getDateAttribution());
        }
        if ((dossierExamen.getDossierAffecte() != null) && (dossierExamen.getDossierAffecte().getProduit() != null)) {
          aideNcp.setLibelleBanalise2(dossierExamen.getDossierAffecte().getProduit().getNom());
        }
      }
    }
  }
  
  protected static String determineValideeEtOuReexamen(DemandeSpec demande)
  {
    String code = "";
    if (demande.estClasseeOuDecisionneeValidee()) {
      code = "V";
    }
    if (demande.estEnReExamen()) {
      code = code + "R";
    }
    return code;
  }
  
  protected static void renseignerAideNcpDemande(AidesNcp aideNcp, DemandeSpec demande)
  {
    if (aideNcp != null)
    {
      aideNcp.setIdentifiantBanalise1(demande.getFormulaire().getReferenceExterne());
      
      aideNcp.setDateBanalisee1(demande.getDateRecherche());
      
      aideNcp.setDateBanalisee3(demande.getDatePremiereValidation());
      
      aideNcp.setDateBanalisee4(demande.getDateDerniereValidation());
      
      String etatDecision = determineValideeEtOuReexamen(demande);
      aideNcp.setLibelleBanalise4(etatDecision);
      if (demande.getClassementAdministratif() != null) {
        aideNcp.setLibelleBanalise1(demande.getClassementAdministratif().getTypeClassement());
      }
    }
  }
  
  public static void alimenterDonneesAidesHorsGamme(DemandeSpec demandeCali, DemandePivot demandePivot)
    throws CoucheLogiqueException
  {
    AidesNcp aideNcp = demandePivot.getAidesNcp();
    if (aideNcp != null) {
      renseignerAideNcp(aideNcp, demandeCali);
    }
  }
}

/* Location:
 * Qualified Name:     AlimentationBasePivot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */