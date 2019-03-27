package fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.enveloppe;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.StructureInEnveloppe;
import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.spec.CriteresEnveloppeSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.spec.EnveloppeAidesSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.spec.StructureOutEnveloppeSpec;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.ContexteServiceSpec;
import fr.unedic.util.services.ContexteSpec;
import org.apache.commons.lang.StringUtils;

public class LectureEnveloppe
{
  private static final int TAILLE_NUMERO_CONVENTION_FORMATION = 3;
  private static final int ANNEE_MINIMUM_EXERCICE = 1900;
  
  public EnveloppeAidesSpec lireEnveloppeAides(CriteresEnveloppeSpec criteres)
    throws ApplicativeException, TechniqueException
  {
    StructureOutEnveloppeSpec structureOut = null;
    
    long startTime = System.currentTimeMillis();
    
    ContexteSpec contexteLocalCourant = new ContexteLocal();
    try
    {
      controlerCriteres(criteres);
      
      StructureInEnveloppe structureIn = new StructureInEnveloppe();
      
      structureIn.setIdentifiantIndividu(criteres.getContexteService().getRsin());
      structureIn.setCodeAssedic(criteres.getContexteService().getAssedicAllocataire());
      
      structureIn.setMontantEngagerAvant(criteres.getMontantEngagerAvant());
      structureIn.setMontantEngagerApres(criteres.getMontantEngagerApres());
      structureIn.setExerciceAvant(criteres.getExerciceAvant());
      structureIn.setExerciceApres(criteres.getExerciceApres());
      structureIn.setTypeConventionFormation(formateTypeAideStatistique(criteres.getNumeroConventionFormation()));
      structureIn.setIdentifiantActionFormation(criteres.getIdentifiantActionFormation());
      structureIn.setNatureDecision(criteres.getNatureDecision());
      structureIn.setClassementAdministratif(criteres.getClassementAdministratif());
      structureIn.setStatutAvant(criteres.getStatutAvant());
      structureIn.setStatutApres(criteres.getStatutApres());
      structureIn.setOrigineFonctionnelle(criteres.getOrigineFonctionnelle());
      
      structureOut = getOutilFonctionnel().lireEnveloppe(structureIn);
    }
    finally
    {
      contexteLocalCourant.close();
    }
    long endTime = System.currentTimeMillis();
    if (Log.isTraceActive(LectureEnveloppe.class, Niveau.INFO)) {
      Log.ecritTrace(Niveau.INFO, LectureEnveloppe.class, "invoqueService", "Temps d'execution du service " + LectureEnveloppe.class.getName() + " = " + (endTime - startTime) + " ms");
    }
    return structureOut.getEnveloppeAides();
  }
  
  public AppelV1Enveloppe getOutilFonctionnel()
  {
    return new AppelV1Enveloppe();
  }
  
  private void controlerCriteres(CriteresEnveloppeSpec p_criteres)
    throws ContexteException
  {
    if ((p_criteres.getNumeroAllocataire() == null) || (p_criteres.getNumeroAllocataire().length() < 1)) {
      throw new ContexteException("PR_COJAC_L_CONTEXTE_CXALA", "Contexte incomplet : Absence du Numéro Allocataire");
    }
    if (p_criteres.getIdentifiantActionFormation() < 1) {
      throw new ContexteException("PR_COJAC_L_CONTEXTE_ID_FORMATION", "Contexte incomplet : Absence de l'identifiant de Formation " + p_criteres.getIdentifiantActionFormation());
    }
    if (p_criteres.getExerciceApres() < 1900) {
      throw new ContexteException("PR_COJAC_L_CONTEXTE_EXERCICE_APRES", "Contexte en erreur : Exercie après manquant ou < 1900");
    }
    if ((p_criteres.getNatureDecision() >= 1) && (p_criteres.getClassementAdministratif() != null)) {
      throw new ContexteException("PR_COJAC_L_CONTEXTE_CONFLIT_NATURE_CLASSEMENT", "Contexte en erreur : Nature de decision de liquidation et Classement administratif ne peuvent pas être renseignés simultanément.");
    }
    if ((p_criteres.getNumeroConventionFormation() != null) && (p_criteres.getNumeroConventionFormation().length() < 3)) {
      throw new ContexteException("PR_COJAC_L_CONTEXTE_NUMERO_DE_CONVENTION", "Contexte en erreur : Numéro de convention non conforme");
    }
  }
  
  private String formateTypeAideStatistique(String p_numeroConvention)
  {
    char retour = 'H';
    
    String numero = null;
    char typeConvention;
    char typeConvention;
    if (StringUtils.isBlank(p_numeroConvention))
    {
      numero = "41";
      typeConvention = 'H';
    }
    else
    {
      numero = p_numeroConvention.substring(0, 2);
      typeConvention = p_numeroConvention.charAt(2);
    }
    if (numero.equals("41")) {
      switch (typeConvention)
      {
      case 'A': 
        retour = 'P';
        break;
      case 'P': 
        retour = 'I';
        break;
      case 'C': 
        retour = 'C';
        break;
      case 'H': 
        retour = 'J';
      }
    } else if (numero.equals("40")) {
      switch (typeConvention)
      {
      case 'A': 
        retour = 'P';
        break;
      case 'P': 
        retour = 'I';
        break;
      case 'C': 
        retour = 'C';
        break;
      case 'H': 
        retour = 'H';
      }
    }
    return String.valueOf(retour);
  }
}

/* Location:
 * Qualified Name:     LectureEnveloppe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */