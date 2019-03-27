package fr.pe.cali.crem.outils;

import fr.pe.cali.crem.dom.ObjetMetierCrem;
import fr.pe.cali.crem.dom.impl.DonneesFonctionnellesDesengagementAide;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.BilanFinancierAidesMobilite;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.pivot.Aides;
import fr.unedic.cali.dom.pivot.DemandePivot;
import fr.unedic.cali.outilsfonctionnels.OutilDesengagementAide;
import fr.unedic.util.services.ContexteService;

public class OutilGenerationObjetMetierDesengagementAide
  extends OutilGenerationObjetMetier
{
  private static OutilGenerationObjetMetierDesengagementAide instance;
  
  public static synchronized OutilGenerationObjetMetierDesengagementAide getInstance()
  {
    if (instance == null) {
      instance = new OutilGenerationObjetMetierDesengagementAide();
    }
    return instance;
  }
  
  protected boolean verifierDemandeEligible(DemandeSpec demande)
  {
    return true;
  }
  
  protected boolean estEligibleSuppression(DemandeSpec demande)
  {
    return false;
  }
  
  protected void alimenterDonneesDemandePourCREMSpecifiques(ObjetMetierCrem objetMetier, DemandeSpec demande)
  {
    objetMetier.setIdentifiant(genererIdObjetMetier(demande));
    objetMetier.setType("Desengagement_Aide");
    objetMetier.setCodeEvenementMetier("creationDesengagement");
  }
  
  protected void alimenterMetaDonneesSpecifiques(ObjetMetierCrem objetMetier, DemandeSpec demande) {}
  
  protected void alimenterDonneesFonctionnelles(ObjetMetierCrem objetMetier, ContexteService contexteService, DemandeSpec demande)
    throws ApplicativeException
  {
    DonneesFonctionnellesDesengagementAide donnees = new DonneesFonctionnellesDesengagementAide();
    BilanFinancierAidesMobilite bilanFinancierAidesMobilite = OutilDesengagementAide.getInstance().getResultBilanFinancierAidesMobilite(demande.getDemandeur(), demande.getFormulaire().getReferenceExterne());
    
    donnees.setCodePE(contexteService.getAssedicAllocataire());
    donnees.setRsin(contexteService.getRsin());
    donnees.setCxalap(String.valueOf(contexteService.getCxala()));
    donnees.setCodeAntenneDE(contexteService.getCodeAntenne());
    donnees.setIdentifiantObjetMetier(genererIdObjetMetier(demande));
    donnees.setReferenceExterne(demande.getFormulaire().getReferenceExterne());
    donnees.setIdentifiantTechniqueDemande(demande.getIdentifiant());
    donnees.setTypeAide(bilanFinancierAidesMobilite.getAttribution().getTypeExamen());
    donnees.setContexteMobilite(demande.getDemandePivot().getAides().getSituationMobilite());
    donnees.setDateDepotDemande(String.valueOf(demande.getFormulaire().getDateDepot()));
    donnees.setMontantDesengageable(String.valueOf(bilanFinancierAidesMobilite.getMontantADesengager()));
    donnees.setMontantTotalEngage(String.valueOf(bilanFinancierAidesMobilite.getMontantEngage()));
    donnees.setMontantTotalPaye(String.valueOf(bilanFinancierAidesMobilite.getMontantPaye()));
    
    objetMetier.setDonneesFonctionnelles(donnees);
  }
  
  protected ObjetMetierCrem recupererAncienCremDansCache(String cremId, CacheCrem cacheCrem)
  {
    return null;
  }
  
  protected String genererIdObjetMetier(DemandeSpec demande)
  {
    String refExterne = demande.getFormulaire().getReferenceExterne();
    String cxala = demande.getDemandeur().getNumeroAllocataire();
    return cxala + refExterne;
  }
}

/* Location:
 * Qualified Name:     OutilGenerationObjetMetierDesengagementAide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */