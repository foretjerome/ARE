package fr.unedic.cali.autresdoms.d12i.services;

import fr.pe.cali.client.ManagerAppelsServicesD12DAL;
import fr.pe.d12dal.dictionnaire.CasUtilisationAjouterPieceJustificativeEnumeration;
import fr.pe.d12dal.service.es.completude.CritereAjouterPieceJustificative;
import fr.pe.d12dal.service.es.completude.CritereSynchroniserCouleurDAL;
import fr.pe.d12dal.service.es.dal.CritereLireDALCALI;
import fr.pe.d12dal.service.es.dal.RetourLireDALCALI;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.AppelServicesAbstrait;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.cali.outilsfonctionnels.TraceTrackerEnModeEmission;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.ContexteService;

public final class AppelServicesInstruction
{
  public static RetourLireDALCALI lireDemandesInstructionNPDE(IndividuSpec individu, String referenceExterne)
  {
    String assedic = getAssedic(individu);
    RetourLireDALCALI retour = null;
    try
    {
      ManagerAppelsServicesD12DAL domaine = new ManagerAppelsServicesD12DAL();
      CritereLireDALCALI critere = CritereLireDALCALI.getInstance();
      critere.setCxalaf(individu.getNumeroAllocataire());
      critere.setCodePE(assedic);
      critere.setRefExterne(referenceExterne);
      
      retour = domaine.lireDALCALI(critere);
    }
    catch (ApplicativeException e)
    {
      OutilTrace.ecrireTrace(Niveau.DEBUG, null, e);
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GAEC", "Problème lors de l'appel de service de CALI vers GAEC", e);
    }
    catch (TechniqueException e)
    {
      OutilTrace.ecrireTrace(Niveau.DEBUG, null, e);
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D12I", "Problème lors de l'appel de service de CALI vers Instruction", e);
    }
    return retour;
  }
  
  private static String getAssedic(IndividuSpec individu)
  {
    ContexteService contexteService = individu.getContexteService();
    return contexteService.getSrcCodeAssedic();
  }
  
  public static void appelAjoutPieceJustificative(IndividuSpec individu, TraceTrackerEnModeEmission trace)
  {
    String assedic = getAssedic(individu);
    ManagerAppelsServicesD12DAL domaine = new ManagerAppelsServicesD12DAL();
    ContexteService contexteServiceIndividu = (ContexteService)trace.getContexteService();
    
    CritereAjouterPieceJustificative critere = CritereAjouterPieceJustificative.getInstance();
    critere.setCxalaf(individu.getNumeroAllocataire());
    critere.setCodePE(assedic);
    critere.setRefExterne(trace.getReferenceExterne());
    critere.setEnumerationCasUtilisation(CasUtilisationAjouterPieceJustificativeEnumeration.E_01);
    critere.setIdPeriodeGAEC(trace.getIdPeriodeGaec());
    critere.setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsD12DAL(contexteServiceIndividu));
    critere.setRsin(contexteServiceIndividu.getRsin());
    try
    {
      if (contexteServiceIndividu.getContexteEmission().equals("TD")) {
        domaine.ajouterPieceJustificative(critere);
      } else {
        domaine.AjouterPieceJustificativeAsync(critere);
      }
    }
    catch (ApplicativeException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D12I", "Problème lors de l'appel de service de CALI vers Instruction", e);
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D12I", "Problème lors de l'appel de service de CALI vers Instruction", e);
    }
  }
  
  public static void appelSynchroniserCouleurDal(IndividuSpec individu, TraceTrackerEnModeEmission trace)
  {
    String assedic = getAssedic(individu);
    ManagerAppelsServicesD12DAL domaine = new ManagerAppelsServicesD12DAL();
    ContexteService contexteServiceIndividu = (ContexteService)trace.getContexteService();
    
    CritereSynchroniserCouleurDAL critere = CritereSynchroniserCouleurDAL.getInstance();
    critere.setCxalaf(individu.getNumeroAllocataire());
    critere.setCodePE(assedic);
    critere.setRefExterne(trace.getReferenceExterne());
    critere.setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsD12DAL(contexteServiceIndividu));
    critere.setTypeAttente(trace.getCodeAttente());
    try
    {
      if (contexteServiceIndividu.getContexteEmission().equals("TD")) {
        domaine.synchroniserCouleurDAL(critere);
      } else {
        domaine.SynchroniserCouleurDALAsync(critere);
      }
    }
    catch (ApplicativeException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D12I", "Problème lors de l'appel de service de CALI vers Instruction", e);
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D12I", "Problème lors de l'appel de service de CALI vers Instruction", e);
    }
  }
}

/* Location:
 * Qualified Name:     AppelServicesInstruction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */