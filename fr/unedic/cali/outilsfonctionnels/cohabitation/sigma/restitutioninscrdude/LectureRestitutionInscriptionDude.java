package fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.restitutioninscrdude;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.RestitutionInscriptionDude;
import fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.StructureInRestitutionInscriptionDude;
import fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.spec.CriteresRestitutionInscriptionDudeSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.spec.RestitutionInscriptionDudeSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.spec.StructureInRestitutionInscriptionDudeSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.restitutioninscrdude.dom.spec.StructureOutRestitutionInscriptionDudeSpec;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.ContexteSpec;

public class LectureRestitutionInscriptionDude
{
  public RestitutionInscriptionDudeSpec lireRestitutionInscriptionDude(CriteresRestitutionInscriptionDudeSpec criteresRestitutionInscriptionDude)
    throws ApplicativeException, TechniqueException
  {
    RestitutionInscriptionDudeSpec restitutionInscriptionDude = new RestitutionInscriptionDude();
    
    long startTime = System.currentTimeMillis();
    
    ContexteSpec contexteLocalCourant = new ContexteLocal();
    try
    {
      controlerCriteres(criteresRestitutionInscriptionDude);
      
      StructureInRestitutionInscriptionDudeSpec structureInRestitutionInscriptionDude = new StructureInRestitutionInscriptionDude();
      structureInRestitutionInscriptionDude.setNumeroAllocataire(criteresRestitutionInscriptionDude.getNumeroAllocataire());
      structureInRestitutionInscriptionDude.setCodeAssedic(criteresRestitutionInscriptionDude.getCodeAssedic());
      structureInRestitutionInscriptionDude.setIdentifiantSigma(criteresRestitutionInscriptionDude.getIdentifiantSigma());
      
      StructureOutRestitutionInscriptionDudeSpec structureOutRestitutionInscriptionDude = getOutilFonctionnel().lireRestitutionInscriptionDude(structureInRestitutionInscriptionDude);
      
      restitutionInscriptionDude = formaterResultatSA98LD(structureOutRestitutionInscriptionDude);
    }
    finally
    {
      contexteLocalCourant.close();
    }
    long endTime = System.currentTimeMillis();
    if (Log.isTraceActive(LectureRestitutionInscriptionDude.class, Niveau.INFO)) {
      Log.ecritTrace(Niveau.INFO, LectureRestitutionInscriptionDude.class, "invoqueService", "Temps d'execution du service " + LectureRestitutionInscriptionDude.class.getName() + " = " + (endTime - startTime) + " ms");
    }
    return restitutionInscriptionDude;
  }
  
  public AppelV1RestitutionInscriptionDude getOutilFonctionnel()
  {
    return new AppelV1RestitutionInscriptionDude();
  }
  
  private void controlerCriteres(CriteresRestitutionInscriptionDudeSpec criteresRestitutionInscriptionDudeSpec)
    throws ContexteException
  {
    String codeErreur = "";
    String libelleErreur = "";
    if (criteresRestitutionInscriptionDudeSpec.getNumeroAllocataire() == null)
    {
      codeErreur = "PR_COJAC_L_CONTEXTE_CXALA";
      libelleErreur = "Contexte incomplet : Absence du Numéro Allocataire";
    }
    else if (criteresRestitutionInscriptionDudeSpec.getCodeAssedic() == null)
    {
      codeErreur = "PR_COJAC_L_CONTEXTE_CXASS";
      libelleErreur = "Contexte incomplet : Absence du Code Assedic";
    }
    else if (criteresRestitutionInscriptionDudeSpec.getIdentifiantSigma() == null)
    {
      codeErreur = "PR_COJAC_L_CONTEXTE_CXIN";
      libelleErreur = "Contexte incomplet : Absence de l'identifiant SIGMA";
    }
    if ((codeErreur != "") && (libelleErreur != "")) {
      throw new ContexteException("PR_COJAC_L_CONTEXTE_CXALA", "Contexte incomplet : Absence du Numéro Allocataire");
    }
  }
  
  private RestitutionInscriptionDudeSpec formaterResultatSA98LD(StructureOutRestitutionInscriptionDudeSpec structureOutRestitutionInscriptionDude)
  {
    RestitutionInscriptionDudeSpec restitutionInscriptionDude = new RestitutionInscriptionDude();
    
    restitutionInscriptionDude.setDatePreInscription(structureOutRestitutionInscriptionDude.getDatePreInscription());
    restitutionInscriptionDude.setSousTypePEC(structureOutRestitutionInscriptionDude.getSousTypePEC());
    restitutionInscriptionDude.setTypePEC(structureOutRestitutionInscriptionDude.getTypePEC());
    
    return restitutionInscriptionDude;
  }
}

/* Location:
 * Qualified Name:     LectureRestitutionInscriptionDude
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */