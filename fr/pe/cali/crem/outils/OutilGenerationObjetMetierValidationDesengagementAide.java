package fr.pe.cali.crem.outils;

import fr.pe.cali.crem.dom.ObjetMetierCrem;
import fr.pe.cali.crem.dom.impl.DonneesFonctionnellesDesengagementAide;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.pivot.Aides;
import fr.unedic.cali.dom.pivot.DemandePivot;
import fr.unedic.util.services.ContexteService;

public class OutilGenerationObjetMetierValidationDesengagementAide
  extends OutilGenerationObjetMetierDesengagementAide
{
  private static OutilGenerationObjetMetierValidationDesengagementAide instance;
  
  public static synchronized OutilGenerationObjetMetierValidationDesengagementAide getInstance()
  {
    if (instance == null) {
      instance = new OutilGenerationObjetMetierValidationDesengagementAide();
    }
    return instance;
  }
  
  protected void alimenterDonneesDemandePourCREMSpecifiques(ObjetMetierCrem objetMetier, DemandeSpec demande)
  {
    objetMetier.setIdentifiant(genererIdObjetMetier(demande));
    objetMetier.setType("Desengagement_Aide");
    objetMetier.setCodeEvenementMetier("validationDesengagement");
  }
  
  protected void alimenterDonneesFonctionnelles(ObjetMetierCrem objetMetier, ContexteService contexteService, DemandeSpec demande)
    throws ApplicativeException
  {
    DonneesFonctionnellesDesengagementAide donnees = new DonneesFonctionnellesDesengagementAide();
    
    donnees.setCodePE(contexteService.getAssedicAllocataire());
    donnees.setRsin(contexteService.getRsin());
    donnees.setCxalap(String.valueOf(contexteService.getCxala()));
    donnees.setCodeAntenneDE(contexteService.getCodeAntenne());
    donnees.setIdentifiantObjetMetier(genererIdObjetMetier(demande));
    donnees.setReferenceExterne(demande.getFormulaire().getReferenceExterne());
    donnees.setIdentifiantTechniqueDemande(demande.getFormulaire().getIdentifiant());
    donnees.setContexteMobilite(demande.getDemandePivot().getAides().getSituationMobilite());
    donnees.setDateDepotDemande(String.valueOf(demande.getFormulaire().getDateDepot()));
    donnees.setTypeAide(demande.getEvenementReferenceExamen().getTypeExamen());
    
    objetMetier.setDonneesFonctionnelles(donnees);
  }
}

/* Location:
 * Qualified Name:     OutilGenerationObjetMetierValidationDesengagementAide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */