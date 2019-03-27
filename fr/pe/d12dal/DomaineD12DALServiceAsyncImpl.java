package fr.pe.d12dal;

import fr.pe.d12dal.service.es.completude.CritereAjouterPieceJustificative;
import fr.pe.d12dal.service.es.completude.CritereSynchroniserCouleurDAL;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.adaptateur.ServiceSignature;
import fr.unedic.archi.logique.deploiement.DomaineImpl;
import fr.unedic.archi.logique.exception.ApplicativeException;

public class DomaineD12DALServiceAsyncImpl
  extends DomaineImpl
  implements DomaineD12DALServiceAsync
{
  private static final ServiceSignature AJOUTERPIECEJUSTIFICATIVE_METHODSIGNATURE = createServiceSignature("AjouterPieceJustificative", null, CritereAjouterPieceJustificative.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new AjouterPieceJustificativeConvertisseurImpl(), createContexteService("D12DAL", "AjouterPieceJustificative", "", "", "LectureEcriture", "", "", ""), true, false);
  private static final ServiceSignature SYNCHRONISERCOULEURDAL_METHODSIGNATURE = createServiceSignature("SynchroniserCouleurDAL", null, CritereSynchroniserCouleurDAL.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new SynchroniserCouleurDALConvertisseurImpl(), createContexteService("D12DAL", "SynchroniserCouleurDAL", "", "", "Lecture", "", "", ""), true, false);
  
  public DomaineD12DALServiceAsyncImpl()
  {
    super("fr.pe.d12dal", "D12DAL", new ServiceSignature[] { AJOUTERPIECEJUSTIFICATIVE_METHODSIGNATURE, SYNCHRONISERCOULEURDAL_METHODSIGNATURE });
  }
  
  public void AjouterPieceJustificative(CritereAjouterPieceJustificative pIn)
    throws ApplicativeException, TechniqueException
  {
    demanderServiceAsync(AJOUTERPIECEJUSTIFICATIVE_METHODSIGNATURE, pIn);
  }
  
  public void SynchroniserCouleurDAL(CritereSynchroniserCouleurDAL pIn)
    throws ApplicativeException, TechniqueException
  {
    demanderServiceAsync(SYNCHRONISERCOULEURDAL_METHODSIGNATURE, pIn);
  }
}

/* Location:
 * Qualified Name:     DomaineD12DALServiceAsyncImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */