package fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.enveloppe;

import fr.pe.cali.client.ManagerAppelsServicesDR1;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.sigma.CodesErreurs;
import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.EnveloppeAides;
import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.StructureInEnveloppe;
import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.StructureOutEnveloppe;
import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.spec.EnveloppeAidesSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.spec.StructureOutEnveloppeSpec;
import fr.unedic.logique.donnees.dr1.service.vls.YI89_IN;
import fr.unedic.logique.donnees.dr1.service.vls.YI89_OUT;
import fr.unedic.logique.donnees.dr1.service.vls.ZIAI10YI89;
import fr.unedic.logique.donnees.dr1.service.vls.ZOAI10YI89;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class AppelV1Enveloppe
{
  public StructureOutEnveloppeSpec lireEnveloppe(StructureInEnveloppe structureInEnveloppe)
    throws ApplicativeException, TechniqueException
  {
    StructureOutEnveloppeSpec structureOut;
    try
    {
      ZIAI10YI89 dr1In = initialiseDr1In(structureInEnveloppe);
      
      ZOAI10YI89 dr1Out = appelService(dr1In);
      
      EnveloppeAidesSpec enveloppeAides = new EnveloppeAides();
      String topEngagementAide = dr1Out.getYI89_OUT_Z__COMMUNICATION_FAI10O().getFFEAI_TOP_ENGAGEMENT_AIDE();
      enveloppeAides.setEngagementPossible("O".equalsIgnoreCase(topEngagementAide));
      
      String motifImpossibliteEngagement = dr1Out.getYI89_OUT_Z__COMMUNICATION_FAI10O().getCSIEA_MOTIF_IMPOSSIBILITE_ENGAGEMENT_AIDE();
      
      enveloppeAides.setMontantDisponibleInsuffisant("M60D".equalsIgnoreCase(motifImpossibliteEngagement));
      
      enveloppeAides.setMotifImpossibiliteEngagement(motifImpossibliteEngagement);
      structureOut = new StructureOutEnveloppe();
      structureOut.setEnveloppeAides(enveloppeAides);
    }
    catch (ApplicativeException ae)
    {
      throw CodesErreurs.getErreurServiceV1(ae, "FAI10O", structureInEnveloppe.getCodeAssedic() + " " + structureInEnveloppe.getIdentifiantIndividu());
    }
    return structureOut;
  }
  
  private ZIAI10YI89 initialiseDr1In(StructureInEnveloppe structureInEnveloppe)
  {
    ZIAI10YI89 dr1In = ZIAI10YI89.getInstance();
    dr1In.setNewYI89_IN_Z__COMMUNICATION_FAI10O();
    
    dr1In.getYI89_IN_Z__COMMUNICATION_FAI10O().setCSAS_CODE_UNEDIC_DE_L_ASSEDIC(new BigDecimal(structureInEnveloppe.getCodeAssedic()));
    
    dr1In.getYI89_IN_Z__COMMUNICATION_FAI10O().setRSIN_IDENTIFIANT_DE_L_INDIVIDU(structureInEnveloppe.getIdentifiantIndividu());
    
    dr1In.getYI89_IN_Z__COMMUNICATION_FAI10O().setQMENVA_MONTANT_AVANT_MAJ_ENVELOPPE_AIDE(structureInEnveloppe.getMontantEngagerAvant());
    
    dr1In.getYI89_IN_Z__COMMUNICATION_FAI10O().setQMENVP_MONTANT_APRES_MAJ_ENVELOPPE_AIDE(structureInEnveloppe.getMontantEngagerApres());
    
    dr1In.getYI89_IN_Z__COMMUNICATION_FAI10O().setCSTAS_TYPE_AIDE_STATISTIQUE(structureInEnveloppe.getTypeConventionFormation());
    
    dr1In.getYI89_IN_Z__COMMUNICATION_FAI10O().setRSF3_IDENTIFIANT_DU_PLAN_DE_FORMATION(new BigDecimal(structureInEnveloppe.getIdentifiantActionFormation()));
    
    dr1In.getYI89_IN_Z__COMMUNICATION_FAI10O().setCNDCL1_NATURE_DECISION_LIQUIDATION(new BigDecimal(structureInEnveloppe.getNatureDecision()));
    
    dr1In.getYI89_IN_Z__COMMUNICATION_FAI10O().setCRCLA_Classement_administratif(structureInEnveloppe.getClassementAdministratif());
    
    dr1In.getYI89_IN_Z__COMMUNICATION_FAI10O().setDIAIDG_DATE_ENREGISTREMENT_AIDE_DB2(new Damj());
    
    dr1In.getYI89_IN_Z__COMMUNICATION_FAI10O().setCSSAV1_STATUT_AVANT(new BigDecimal(structureInEnveloppe.getStatutAvant()));
    
    dr1In.getYI89_IN_Z__COMMUNICATION_FAI10O().setCSSAP1_STATUT_APRES(new BigDecimal(structureInEnveloppe.getStatutApres()));
    
    dr1In.getYI89_IN_Z__COMMUNICATION_FAI10O().setNSSAAA_SIECLE_ANNEE_AV_MODIF__ANNEE_AFFECTA(new BigDecimal(structureInEnveloppe.getExerciceAvant()));
    
    dr1In.getYI89_IN_Z__COMMUNICATION_FAI10O().setNSSAAP_SIECLE_ANNEE_AP_MODIF__ANNEE_AFFECTA(new BigDecimal(structureInEnveloppe.getExerciceApres()));
    
    dr1In.getYI89_IN_Z__COMMUNICATION_FAI10O().setCDOAP_ORIGINE_FONCTIONNELLE_DE_L_APPEL(structureInEnveloppe.getOrigineFonctionnelle());
    
    return dr1In;
  }
  
  public ZOAI10YI89 appelService(ZIAI10YI89 donneesIn)
    throws TechniqueException, ApplicativeException
  {
    ManagerAppelsServicesDR1 managerService = new ManagerAppelsServicesDR1();
    return managerService.FAI10O_AIDES_ENVELOPPES(donneesIn);
  }
}

/* Location:
 * Qualified Name:     AppelV1Enveloppe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */