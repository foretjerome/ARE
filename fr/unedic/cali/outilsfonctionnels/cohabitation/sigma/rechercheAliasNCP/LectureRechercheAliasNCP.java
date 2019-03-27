package fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.rechercheAliasNCP;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.AllocataireNcp;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.StructureInRechercheAliasNCP;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.AllocataireNcpSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.CriteresIndividuNCPSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.StructureInRechercheAliasNCPSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.StructureOutRechercheAliasNCPReferentSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.rechercheAliasNCP.dom.spec.StructureOutRechercheAliasNCPSpec;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.ContexteSpec;

public class LectureRechercheAliasNCP
{
  private void controlerCriteres(CriteresIndividuNCPSpec criteresIndividu)
    throws ContexteException
  {
    if ((criteresIndividu.getNumeroAllocataire() == null) && (criteresIndividu.getAliasNcp() == null) && (criteresIndividu.getIdentifiantSigma() == null)) {
      throw new ContexteException("PR_COJAC_L_AUCUN_IDENTIFIANT", "Aucun identifiant n'est mentionné");
    }
    if (((criteresIndividu.getCodeAssedic() != null) && (criteresIndividu.getIdentifiantSigma() == null)) || ((criteresIndividu.getCodeAssedic() == null) && (criteresIndividu.getIdentifiantSigma() != null))) {
      throw new ContexteException("PR_COJAC_L_CXASS_CXIN_INDISOCIABLES", "Le code Assedic et l'identifiant Sigma doivent être renseignés simultanément ou pas du tout");
    }
    if ((criteresIndividu.getNumeroAllocataire() != null) && (criteresIndividu.getAliasNcp() != null)) {
      throw new ContexteException("PR_COJAC_L_CXALA_CXALAK_ENSEMBLE", "Les identifiants BNI et NCP ne peuvent être renseignés simultanément");
    }
    String codeAssedic = criteresIndividu.getCodeAssedic();
    if (codeAssedic != null)
    {
      if (codeAssedic.length() == 0) {
        codeAssedic = null;
      } else if (codeAssedic.length() == 1) {
        codeAssedic = "00" + codeAssedic;
      } else if (codeAssedic.length() == 2) {
        codeAssedic = "0" + codeAssedic;
      }
      criteresIndividu.setCodeAssedic(codeAssedic);
    }
  }
  
  public AllocataireNcpSpec lireIndividu(CriteresIndividuNCPSpec criteresIndividuNcp)
    throws ApplicativeException, TechniqueException
  {
    AllocataireNcpSpec individu = null;
    
    long startTime = System.currentTimeMillis();
    
    ContexteSpec contexteLocalCourant = new ContexteLocal();
    try
    {
      controlerCriteres(criteresIndividuNcp);
      
      StructureInRechercheAliasNCPSpec structureInIndividu = new StructureInRechercheAliasNCP();
      
      structureInIndividu.setNumeroAllocataire(criteresIndividuNcp.getNumeroAllocataire());
      structureInIndividu.setCodeAliasNCP(criteresIndividuNcp.getAliasNcp());
      structureInIndividu.setCodeAssedic(criteresIndividuNcp.getCodeAssedic());
      structureInIndividu.setIdentifiantSigma(criteresIndividuNcp.getIdentifiantSigma());
      
      StructureOutRechercheAliasNCPSpec structureOutIndividu = getOutilFonctionnel().lireIndividuNCP(structureInIndividu);
      if (structureOutIndividu != null) {
        individu = formaterResultatBni(structureOutIndividu);
      }
    }
    finally
    {
      contexteLocalCourant.close();
    }
    long endTime = System.currentTimeMillis();
    if (Log.isTraceActive(LectureRechercheAliasNCP.class, Niveau.INFO)) {
      Log.ecritTrace(Niveau.INFO, LectureRechercheAliasNCP.class, "invoqueService", "Temps d'execution du service " + LectureRechercheAliasNCP.class.getName() + " = " + (endTime - startTime) + " ms");
    }
    return individu;
  }
  
  public AppelRechercheAliasNCP getOutilFonctionnel()
  {
    return new AppelRechercheAliasNCP();
  }
  
  public AllocataireNcpSpec lireIndividuReferent(CriteresIndividuNCPSpec p_criteresIndividuNcp)
    throws ApplicativeException, TechniqueException
  {
    AllocataireNcpSpec individu = null;
    
    long startTime = System.currentTimeMillis();
    
    ContexteSpec contexteLocalCourant = new ContexteLocal();
    try
    {
      controlerCriteresPourServiceLireIndividuNCPReferent(p_criteresIndividuNcp);
      
      StructureInRechercheAliasNCPSpec structureInIndividu = new StructureInRechercheAliasNCP();
      
      structureInIndividu.setNumeroAllocataire(p_criteresIndividuNcp.getNumeroAllocataire());
      structureInIndividu.setCodeAliasNCP(p_criteresIndividuNcp.getAliasNcp());
      structureInIndividu.setCodeAssedic(p_criteresIndividuNcp.getCodeAssedic());
      structureInIndividu.setIdentifiantSigma(p_criteresIndividuNcp.getIdentifiantSigma());
      
      StructureOutRechercheAliasNCPReferentSpec structureOutIndividu = getOutilFonctionnel().lireIndividuNCPReferent(structureInIndividu);
      if (structureOutIndividu != null) {
        individu = formaterResultatBni(structureOutIndividu);
      }
    }
    finally
    {
      contexteLocalCourant.close();
    }
    long endTime = System.currentTimeMillis();
    if (Log.isTraceActive(LectureRechercheAliasNCP.class, Niveau.INFO)) {
      Log.ecritTrace(Niveau.INFO, LectureRechercheAliasNCP.class, "invoqueService", "Temps d'execution du service " + LectureRechercheAliasNCP.class.getName() + " = " + (endTime - startTime) + " ms");
    }
    return individu;
  }
  
  private AllocataireNcpSpec formaterResultatBni(StructureOutRechercheAliasNCPReferentSpec structureOutIndividu)
    throws ContexteException
  {
    AllocataireNcpSpec individu = new AllocataireNcp();
    individu.setAliasNcp(structureOutIndividu.getCodeAliasNCP());
    individu.setCodeAssedic(structureOutIndividu.getCodeAssedic());
    individu.setIdentifiantSigma(structureOutIndividu.getIdentifiantSigma());
    individu.setNumeroAllocataire(structureOutIndividu.getNumeroAllocataire());
    individu.setTopReferent(structureOutIndividu.getTopReferent());
    individu.setCodeAntenne(structureOutIndividu.getCodeAntenne());
    individu.setIdentifiantDNA(structureOutIndividu.getIdentifiantDNA());
    return individu;
  }
  
  private AllocataireNcpSpec formaterResultatBni(StructureOutRechercheAliasNCPSpec structureOutIndividu)
    throws ContexteException
  {
    AllocataireNcpSpec individu = new AllocataireNcp();
    individu.setAliasNcp(structureOutIndividu.getCodeAliasNCP());
    individu.setCodeAssedic(structureOutIndividu.getCodeAssedic());
    individu.setIdentifiantSigma(structureOutIndividu.getIdentifiantSigma());
    individu.setNumeroAllocataire(structureOutIndividu.getNumeroAllocataire());
    return individu;
  }
  
  private void controlerCriteresPourServiceLireIndividuNCPReferent(CriteresIndividuNCPSpec criteresIndividu)
    throws ContexteException
  {
    if (criteresIndividu.getAliasNcp() == null) {
      throw new ContexteException("PR_COJAC_L_CONTEXTE_ALIAS_NCP", "Contexte incomplet : Absence de l'Alias NCP");
    }
    if (criteresIndividu.getCodeAssedic() == null) {
      throw new ContexteException("PR_COJAC_L_CONTEXTE_CXASS", "Contexte incomplet : Absence du Code Assedic");
    }
    String codeAssedic = criteresIndividu.getCodeAssedic();
    if (codeAssedic != null)
    {
      if (codeAssedic.length() == 0) {
        codeAssedic = null;
      } else if (codeAssedic.length() == 1) {
        codeAssedic = "00" + codeAssedic;
      } else if (codeAssedic.length() == 2) {
        codeAssedic = "0" + codeAssedic;
      }
      criteresIndividu.setCodeAssedic(codeAssedic);
    }
  }
}

/* Location:
 * Qualified Name:     LectureRechercheAliasNCP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */