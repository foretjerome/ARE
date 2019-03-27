package fr.unedic.d90.service.rac.commun.d90;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.adaptateur.ServiceSignature;
import fr.unedic.archi.logique.deploiement.DomaineImpl;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireEvenementAsynchrone;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireEvtDesengAide;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireIndividu;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireODF;
import fr.unedic.d90.donnees.d90.service.vls.ResultatEcrireEvenementAsynchrone;
import fr.unedic.d90.donnees.d90.service.vls.ResultatEcrireEvtDesengAide;
import fr.unedic.d90.donnees.d90.service.vls.ResultatEcrireIndividu;
import fr.unedic.d90.donnees.d90.service.vls.ResultatEcrireODFOut;

public class DomaineD90ServiceSyncImpl
  extends DomaineImpl
  implements DomaineD90ServiceSync
{
  private static final ServiceSignature ECRIREEVTDESENGAIDE_METHODSIGNATURE = createServiceSignature("ecrireEvtDesengAide", ResultatEcrireEvtDesengAide.class, CriteresEcrireEvtDesengAide.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new EcrireEvtDesengAideConvertisseurImpl(), createContexteService("D90", "ecrireEvtDesengAide", "", "", "LectureEcriture", "", "", ""), true, false);
  private static final ServiceSignature ECRIREINDIVIDU_METHODSIGNATURE = createServiceSignature("ecrireIndividu", ResultatEcrireIndividu.class, CriteresEcrireIndividu.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new EcrireIndividuConvertisseurImpl(), createContexteService("D90", "ecrireIndividu", "", "", "LectureEcriture", "", "", ""), true, false);
  private static final ServiceSignature ECRIREODF_METHODSIGNATURE = createServiceSignature("ecrireODF", ResultatEcrireODFOut.class, CriteresEcrireODF.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new EcrireODFConvertisseurImpl(), createContexteService("D90", "ecrireODF", "", "", "LectureEcriture", "", "", ""), true, false);
  private static final ServiceSignature ECRIREEVENEMENTASYNCHRONE_METHODSIGNATURE = createServiceSignature("ecrireEvenementAsynchrone", ResultatEcrireEvenementAsynchrone.class, CriteresEcrireEvenementAsynchrone.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new EcrireEvenementAsynchroneConvertisseurImpl(), createContexteService("D90", "ecrireEvenementAsynchrone", "", "", "LectureEcriture", "", "", ""), true, false);
  
  public DomaineD90ServiceSyncImpl()
  {
    super("fr.unedic.d90.service.rac.commun.d90", "D90", new ServiceSignature[] { ECRIREODF_METHODSIGNATURE, ECRIREEVENEMENTASYNCHRONE_METHODSIGNATURE, ECRIREINDIVIDU_METHODSIGNATURE, ECRIREEVTDESENGAIDE_METHODSIGNATURE });
  }
  
  public ResultatEcrireODFOut ecrireODF(CriteresEcrireODF pIn)
    throws ApplicativeException, TechniqueException
  {
    return (ResultatEcrireODFOut)demanderService(ECRIREODF_METHODSIGNATURE, pIn);
  }
  
  public ResultatEcrireIndividu ecrireIndividu(CriteresEcrireIndividu pIn)
    throws ApplicativeException, TechniqueException
  {
    return (ResultatEcrireIndividu)demanderService(ECRIREINDIVIDU_METHODSIGNATURE, pIn);
  }
  
  public ResultatEcrireEvenementAsynchrone ecrireEvenementAsynchrone(CriteresEcrireEvenementAsynchrone pIn)
    throws ApplicativeException, TechniqueException
  {
    return (ResultatEcrireEvenementAsynchrone)demanderService(ECRIREEVENEMENTASYNCHRONE_METHODSIGNATURE, pIn);
  }
  
  public ResultatEcrireEvtDesengAide ecrireEvtDesengAide(CriteresEcrireEvtDesengAide pIn)
    throws ApplicativeException, TechniqueException
  {
    return (ResultatEcrireEvtDesengAide)demanderService(ECRIREEVTDESENGAIDE_METHODSIGNATURE, pIn);
  }
}

/* Location:
 * Qualified Name:     DomaineD90ServiceSyncImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */