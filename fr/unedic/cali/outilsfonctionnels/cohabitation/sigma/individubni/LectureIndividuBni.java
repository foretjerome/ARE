package fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.individubni;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom.AllocataireBniSigmaR0;
import fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom.StructureInIndividuBni;
import fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom.spec.AllocataireBniSigmaR0Spec;
import fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom.spec.CriteresIndividuBniSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom.spec.StructureInIndividuBniSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.individubni.dom.spec.StructureOutIndividuBniR0Spec;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.ContexteSpec;

public class LectureIndividuBni
{
  private void controlerCriteres(CriteresIndividuBniSpec criteresIndividu)
    throws ContexteException
  {
    if (criteresIndividu.getNumeroAllocataire() == null) {
      throw new ContexteException("PR_COJAC_L_CONTEXTE_CXALA", "Contexte incomplet : Absence du Numéro Allocataire");
    }
  }
  
  public AllocataireBniSigmaR0Spec lireIndividuBniR0(CriteresIndividuBniSpec criteresIndividuBni)
    throws ApplicativeException, TechniqueException
  {
    AllocataireBniSigmaR0Spec individu = null;
    
    long startTime = System.currentTimeMillis();
    
    ContexteSpec contexteLocalCourant = new ContexteLocal();
    try
    {
      controlerCriteres(criteresIndividuBni);
      
      StructureInIndividuBniSpec structureInIndividuBni = new StructureInIndividuBni();
      structureInIndividuBni.setNumeroAllocataire(criteresIndividuBni.getNumeroAllocataire());
      
      StructureOutIndividuBniR0Spec structureOutIndividuBni = getOutilFonctionnel().lireIndividuBniR0(structureInIndividuBni);
      
      individu = formaterResultatBni(structureOutIndividuBni);
    }
    finally
    {
      contexteLocalCourant.close();
    }
    long endTime = System.currentTimeMillis();
    if (Log.isTraceActive(LectureIndividuBni.class, Niveau.INFO)) {
      Log.ecritTrace(Niveau.INFO, LectureIndividuBni.class, "invoqueService", "Temps d'execution du service " + LectureIndividuBni.class.getName() + " = " + (endTime - startTime) + " ms");
    }
    return (AllocataireBniSigmaR0)individu;
  }
  
  public AppelIndividuBni getOutilFonctionnel()
  {
    return new AppelIndividuBni();
  }
  
  private AllocataireBniSigmaR0Spec formaterResultatBni(StructureOutIndividuBniR0Spec structureOutIndividuBni)
    throws ContexteException
  {
    AllocataireBniSigmaR0Spec individu = new AllocataireBniSigmaR0();
    
    individu.setNumeroAllocataire(structureOutIndividuBni.getNumeroAllocataire());
    individu.setIdentifiantSigma(structureOutIndividuBni.getIdentifiantSigma());
    individu.setCodeAssedic(structureOutIndividuBni.getCodeAssedic());
    
    String codeEtatMigration = structureOutIndividuBni.getCodeEtatMigrationNCP();
    codeEtatMigration = codeEtatMigration == null ? " " : codeEtatMigration.toUpperCase();
    individu.setCodeEtatMigrationNCP(codeEtatMigration);
    
    String origineCertification = structureOutIndividuBni.getOrigineCertification();
    origineCertification = origineCertification == null ? " " : origineCertification.toUpperCase();
    individu.setOrigineCertification(origineCertification);
    
    return individu;
  }
}

/* Location:
 * Qualified Name:     LectureIndividuBni
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */