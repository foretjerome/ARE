package fr.pe.cali.crem.outils;

import fr.pe.cali.crem.dom.MetaDonneeCrem;
import fr.pe.cali.crem.dom.ObjetMetierCrem;
import fr.pe.cali.crem.dom.impl.DonneesFonctionnellesDecisionLiquidation;
import fr.unedic.cali.autresdoms.d12i.dom.DonneesNPDE;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesSortieNPDESpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.pivot.Attribution;
import fr.unedic.cali.dom.pivot.Decision;
import fr.unedic.cali.dom.pivot.DemandePivot;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;

public class OutilGenerationObjetMetierDecisionLiquidation
  extends OutilGenerationObjetMetier
{
  private static OutilGenerationObjetMetierDecisionLiquidation instance;
  
  public static synchronized OutilGenerationObjetMetierDecisionLiquidation getInstance()
  {
    if (instance == null) {
      instance = new OutilGenerationObjetMetierDecisionLiquidation();
    }
    return instance;
  }
  
  protected boolean verifierDemandeEligible(DemandeSpec demande)
  {
    return (demande.getDemandePivot() != null) && (demande.getDemandePivot().getDecision() != null);
  }
  
  protected boolean estEligibleSuppression(DemandeSpec demande)
  {
    return false;
  }
  
  protected void alimenterDonneesDemandePourCREMSpecifiques(ObjetMetierCrem objetMetier, DemandeSpec demande)
  {
    objetMetier.setIdentifiant(genererIdObjetMetier(demande));
    objetMetier.setType("Decision_Liquidation");
    objetMetier.setCodeEvenementMetier("liquidation");
  }
  
  protected String genererIdObjetMetier(DemandeSpec demande)
  {
    String refExterne = demande.getFormulaire().getReferenceExterne();
    String cxala = demande.getDemandeur().getNumeroAllocataire();
    return cxala + refExterne;
  }
  
  protected void alimenterMetaDonneesSpecifiques(ObjetMetierCrem objetMetier, DemandeSpec demande)
  {
    String valeurMetaDonnee = recupererValeurQuatriemeMetaDonnee(demande);
    objetMetier.setQuatriemeMetaDonnee(new MetaDonneeCrem("RSOD_RSRP", valeurMetaDonnee));
  }
  
  protected String recupererValeurQuatriemeMetaDonnee(DemandeSpec demande)
  {
    String resultat = "";
    if ((demande.getDemandePivot() != null) && (demande.getDemandePivot().getAttribution() != null))
    {
      String rsod = Integer.toString(demande.getDemandePivot().getAttribution().getIdentifiantOuvertureDroit());
      String rsrp = Integer.toString(demande.getDemandePivot().getAttribution().getIdentifiantReprise());
      resultat = bourrage(rsod, 3) + bourrage(rsrp, 3);
    }
    return resultat;
  }
  
  protected void alimenterDonneesFonctionnelles(ObjetMetierCrem objetMetier, ContexteService contexteService, DemandeSpec demande)
  {
    DonneesFonctionnellesDecisionLiquidation donnees = new DonneesFonctionnellesDecisionLiquidation();
    
    Attribution attributionPivot = demande.getDemandePivot().getAttribution();
    Decision decisionPivot = demande.getDemandePivot().getDecision();
    
    donnees.setCxass(contexteService.getAssedicAllocataire());
    donnees.setCxala(String.valueOf(contexteService.getCxala()));
    donnees.setIdentifiantObjetMetier(genererIdObjetMetier(demande));
    donnees.setTypeLiquidation(recupererTypeLiquidation(demande, contexteService));
    
    alimenterDonneesFonctionnellesDecision(donnees, decisionPivot);
    alimenterDonneesFonctionnellesDemande(donnees, demande);
    if (attributionPivot != null) {
      alimenterDonneesFonctionnellesAttribution(donnees, attributionPivot);
    }
    donnees.remplacerDonneesNullesParChainesVides();
    objetMetier.setDonneesFonctionnelles(donnees);
  }
  
  private String formaterDamj(Damj date)
  {
    String value = "";
    if (date != null) {
      value = date.getAnnee() + "-" + bourrage(date.getMois(), 2) + "-" + bourrage(date.getJour(), 2) + " 00:00:00:000";
    }
    return value;
  }
  
  private String bourrage(int nombre, int taille)
  {
    String value = String.valueOf(nombre);
    if (value.length() < taille) {
      value = "0" + value;
    }
    return value;
  }
  
  protected void alimenterDonneesFonctionnellesDecision(DonneesFonctionnellesDecisionLiquidation donnees, Decision decisionPivot)
  {
    donnees.setIdentifiantFonctionnelDemande(decisionPivot.getReferenceExterneDemande());
    donnees.setIdentifiantDemandeCali(decisionPivot.getIdentifiantDemandeCali());
    if (decisionPivot.getDateExamen() != null) {
      donnees.setDateExamen(formaterDamj(decisionPivot.getDateExamen()));
    }
    donnees.setCodeProduit(decisionPivot.getCodeProduit());
    donnees.setClassementAdministratif(decisionPivot.getClassementAdministratif());
    donnees.setNatureDecision(Integer.toString(decisionPivot.getNatureDecision()));
    if (decisionPivot.getDateFctFG() != null) {
      donnees.setDateFaitGenerateur(formaterDamj(decisionPivot.getDateFctFG()));
    }
    donnees.setMotifRejet(String.valueOf(decisionPivot.getMotifRejet()));
    donnees.setDateFctRetenue(formaterDamj(decisionPivot.getDateFctRetenue()));
  }
  
  protected void alimenterDonneesFonctionnellesAttribution(DonneesFonctionnellesDecisionLiquidation donnees, Attribution attributionPivot)
  {
    if (attributionPivot.getDateEffetAttribution() != null) {
      donnees.setDateAttribution(formaterDamj(attributionPivot.getDateEffetAttribution()));
    }
    if (attributionPivot.getDateLimiteIndemnisation() != null) {
      donnees.setDateTheoriqueFinDroit(formaterDamj(attributionPivot.getDateLimiteIndemnisation()));
    } else if (attributionPivot.getDateTheoriqueFinDroit() != null) {
      donnees.setDateTheoriqueFinDroit(formaterDamj(attributionPivot.getDateTheoriqueFinDroit()));
    }
    donnees.setIdentifiantOuvertureDroit(Integer.toString(attributionPivot.getIdentifiantOuvertureDroit()));
    donnees.setIdentifiantReprise(Integer.toString(attributionPivot.getIdentifiantReprise()));
    if (attributionPivot.getPji() != null) {
      donnees.setPremierJourIndemnisableTheorique(formaterDamj(attributionPivot.getPji()));
    }
    if (attributionPivot.getMontantSjrRetenuPlafonne() != null) {
      donnees.setSalaireJournalierReference(String.valueOf(attributionPivot.getMontantSjrRetenuPlafonne()));
    } else if (attributionPivot.getMontantSjrCourantPlafonne() != null) {
      donnees.setSalaireJournalierReference(String.valueOf(attributionPivot.getMontantSjrCourantPlafonne()));
    }
    if (attributionPivot.getMontantSjc() != null) {
      donnees.setSalaireJournalierConserve(String.valueOf(attributionPivot.getMontantSjc()));
    }
    if (attributionPivot.getReglementApplicableRetenu() != null) {
      donnees.setReglementApplicable(attributionPivot.getReglementApplicableRetenu());
    }
    donnees.setCodeMetier(Integer.toString(attributionPivot.getCodeMetier()));
  }
  
  protected void alimenterDonneesFonctionnellesDemande(DonneesFonctionnellesDecisionLiquidation donnees, DemandeSpec demande)
  {
    if (demande.getDonneesNPDE() != null) {
      donnees.setIdOMPere(demande.getDonneesNPDE().getIdentifiantDemandeInstruction());
    }
    donnees.setMotifIneligibilite(demande.getCodeAttente());
    donnees.setEtatDecision(recupererEtatDecision(demande));
    donnees.setNotificationCourrier(recupererNotificationCourrier(demande));
    if (demande.getDateDerniereValidation() != null) {
      donnees.setDateDerniereValidation(formaterDamj(demande.getDateDerniereValidation()));
    }
    if (demande.getDatePremiereValidation() != null) {
      donnees.setDatePremiereValidation(formaterDamj(demande.getDatePremiereValidation()));
    }
  }
  
  protected String recupererNotificationCourrier(DemandeSpec demande)
  {
    String notificationCourrier;
    String notificationCourrier;
    if (demande.estNotifieeCourrier()) {
      notificationCourrier = "O";
    } else {
      notificationCourrier = "N";
    }
    return notificationCourrier;
  }
  
  protected String recupererEtatDecision(DemandeSpec demande)
  {
    String etatDecision;
    String etatDecision;
    if (demande.getClassementAdministratif() != null)
    {
      etatDecision = "4";
    }
    else
    {
      String etatDecision;
      if (demande.estDecisionnee())
      {
        String etatDecision;
        if (demande.estEnReExamen()) {
          etatDecision = "3";
        } else {
          etatDecision = "2";
        }
      }
      else
      {
        etatDecision = "1";
      }
    }
    return etatDecision;
  }
  
  protected String recupererTypeLiquidation(DemandeSpec demande, ContexteService contexteService)
  {
    String typeLiquidation = "3";
    if (estModeBatch(contexteService)) {
      typeLiquidation = "2";
    } else if ((demande.isDecisionAuto()) && (demande.getDonneesSortieNPDE() != null)) {
      if (demande.getDonneesSortieNPDE().getModeTraitementDemande() == "S") {
        typeLiquidation = "1";
      } else if ((demande.getDonneesSortieNPDE().getModeTraitementDemande() == "AG") || (demande.getDonneesSortieNPDE().getModeTraitementDemande() == "A")) {
        typeLiquidation = "2";
      }
    }
    return typeLiquidation;
  }
  
  protected String bourrage(String chaineABourrer, int taille)
  {
    StringBuilder string = new StringBuilder(chaineABourrer);
    while (string.length() < taille) {
      string = string.insert(0, "0");
    }
    return string.toString();
  }
  
  protected ObjetMetierCrem recupererAncienCremDansCache(String cremId, CacheCrem cacheCrem)
  {
    return cacheCrem.recupererCremDecision(cremId);
  }
}

/* Location:
 * Qualified Name:     OutilGenerationObjetMetierDecisionLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */