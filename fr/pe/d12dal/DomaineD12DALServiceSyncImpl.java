package fr.pe.d12dal;

import fr.pe.d12dal.service.es.completude.CritereAjouterPieceJustificative;
import fr.pe.d12dal.service.es.completude.CritereSynchroniserCouleurDAL;
import fr.pe.d12dal.service.es.completude.RetourAjouterPieceJustificative;
import fr.pe.d12dal.service.es.completude.RetourSynchroniserCouleurDAL;
import fr.pe.d12dal.service.es.dal.CritereLireDALCALI;
import fr.pe.d12dal.service.es.dal.RetourLireDALCALI;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.adaptateur.ServiceSignature;
import fr.unedic.archi.logique.deploiement.DomaineImpl;
import fr.unedic.archi.logique.exception.ApplicativeException;

public class DomaineD12DALServiceSyncImpl
  extends DomaineImpl
  implements DomaineD12DALServiceSync
{
  private static final ServiceSignature AJOUTERPIECEJUSTIFICATIVE_METHODSIGNATURE = createServiceSignature("AjouterPieceJustificative", RetourAjouterPieceJustificative.class, CritereAjouterPieceJustificative.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new AjouterPieceJustificativeConvertisseurImpl(), createContexteService("D12DAL", "AjouterPieceJustificative", "", "", "LectureEcriture", "", "", ""), true, false);
  private static final ServiceSignature LIREDALCALI_METHODSIGNATURE = createServiceSignature("LireDALCALI", RetourLireDALCALI.class, CritereLireDALCALI.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new LireDALCALIConvertisseurImpl(), createContexteService("D12DAL", "LireDALCALI", "", "", "Lecture", "", "", ""), true, false);
  private static final ServiceSignature SYNCHRONISERCOULEURDAL_METHODSIGNATURE = createServiceSignature("SynchroniserCouleurDAL", RetourSynchroniserCouleurDAL.class, CritereSynchroniserCouleurDAL.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new SynchroniserCouleurDALConvertisseurImpl(), createContexteService("D12DAL", "SynchroniserCouleurDAL", "", "", "Lecture", "", "", ""), true, false);
  
  public DomaineD12DALServiceSyncImpl()
  {
    super("fr.pe.d12dal", "D12DAL", new ServiceSignature[] { AJOUTERPIECEJUSTIFICATIVE_METHODSIGNATURE, LIREDALCALI_METHODSIGNATURE, SYNCHRONISERCOULEURDAL_METHODSIGNATURE });
  }
  
  public RetourLireDALCALI LireDALCALI(CritereLireDALCALI pIn)
    throws ApplicativeException, TechniqueException
  {
    return (RetourLireDALCALI)demanderService(LIREDALCALI_METHODSIGNATURE, pIn);
  }
  
  public RetourAjouterPieceJustificative AjouterPieceJustificative(CritereAjouterPieceJustificative pIn)
    throws ApplicativeException, TechniqueException
  {
    return (RetourAjouterPieceJustificative)demanderService(AJOUTERPIECEJUSTIFICATIVE_METHODSIGNATURE, pIn);
  }
  
  public RetourSynchroniserCouleurDAL SynchroniserCouleurDAL(CritereSynchroniserCouleurDAL pIn)
    throws ApplicativeException, TechniqueException
  {
    return (RetourSynchroniserCouleurDAL)demanderService(SYNCHRONISERCOULEURDAL_METHODSIGNATURE, pIn);
  }
}

/* Location:
 * Qualified Name:     DomaineD12DALServiceSyncImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */