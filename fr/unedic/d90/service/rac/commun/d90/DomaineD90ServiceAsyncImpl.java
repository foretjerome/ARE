package fr.unedic.d90.service.rac.commun.d90;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.adaptateur.ServiceSignature;
import fr.unedic.archi.logique.deploiement.DomaineImpl;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireEvenementAsynchrone;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireEvtDesengAide;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireODF;

public class DomaineD90ServiceAsyncImpl
  extends DomaineImpl
  implements DomaineD90ServiceAsync
{
  private static final ServiceSignature ECRIREEVTDESENGAIDE_METHODSIGNATURE = createServiceSignature("ecrireEvtDesengAide", null, CriteresEcrireEvtDesengAide.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new EcrireEvtDesengAideConvertisseurImpl(), createContexteService("D90", "ecrireEvtDesengAide", "", "", "LectureEcriture", "", "", ""), true, false);
  private static final ServiceSignature ECRIREEVENEMENTASYNCHRONE_METHODSIGNATURE = createServiceSignature("ecrireEvenementAsynchrone", null, CriteresEcrireEvenementAsynchrone.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new EcrireEvenementAsynchroneConvertisseurImpl(), createContexteService("D90", "ecrireEvenementAsynchrone", "", "", "LectureEcriture", "", "", ""), true, false);
  private static final ServiceSignature ECRIREODF_METHODSIGNATURE = createServiceSignature("ecrireODF", null, CriteresEcrireODF.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new EcrireODFConvertisseurImpl(), createContexteService("D90", "ecrireODF", "", "", "LectureEcriture", "", "", ""), true, false);
  
  public DomaineD90ServiceAsyncImpl()
  {
    super("fr.unedic.d90.service.rac.commun.d90", "D90", new ServiceSignature[] { ECRIREODF_METHODSIGNATURE, ECRIREEVENEMENTASYNCHRONE_METHODSIGNATURE, ECRIREEVTDESENGAIDE_METHODSIGNATURE });
  }
  
  public void ecrireODF(CriteresEcrireODF pIn)
    throws ApplicativeException, TechniqueException
  {
    demanderServiceAsync(ECRIREODF_METHODSIGNATURE, pIn);
  }
  
  public void ecrireEvenementAsynchrone(CriteresEcrireEvenementAsynchrone pIn)
    throws ApplicativeException, TechniqueException
  {
    demanderServiceAsync(ECRIREEVENEMENTASYNCHRONE_METHODSIGNATURE, pIn);
  }
  
  public void ecrireEvtDesengAide(CriteresEcrireEvtDesengAide pIn)
    throws ApplicativeException, TechniqueException
  {
    demanderServiceAsync(ECRIREEVTDESENGAIDE_METHODSIGNATURE, pIn);
  }
}

/* Location:
 * Qualified Name:     DomaineD90ServiceAsyncImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */