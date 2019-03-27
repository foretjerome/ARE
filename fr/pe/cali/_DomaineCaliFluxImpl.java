package fr.pe.cali;

import fr.pe.cali.logique.donnees.vls.CREM_IN;
import fr.pe.cali.logique.donnees.vls.FluxCaliIn;
import fr.pe.cali.logique.donnees.vls.FluxSillageIn;
import fr.pe.cali.logique.donnees.vls.Notification;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.adaptateur.FluxSignature;
import fr.unedic.archi.logique.adaptateur.ServiceSignature;
import fr.unedic.archi.logique.adaptateur.entete.EnteteApplicative;
import fr.unedic.archi.logique.adaptateur.sindbad.EnteteApplicativeFrameworkImpl;
import fr.unedic.archi.logique.deploiement.DomaineFluxImpl;
import fr.unedic.archi.logique.exception.ApplicativeException;

public class _DomaineCaliFluxImpl
  extends DomaineFluxImpl
  implements DomaineCaliFlux
{
  public _DomaineCaliFluxImpl()
  {
    super("fr.pe.cali", "Cali", new ServiceSignature[0], new FluxSignature[] { J12CRE_METHODSIGNATURE, A12INTEGRATION_METHODSIGNATURE, A12INVFRAUD_METHODSIGNATURE, NOTIFEPC_METHODSIGNATURE });
  }
  
  private static final FluxSignature A12INTEGRATION_METHODSIGNATURE = createFluxSignature("A12INTEGRATION", FluxCaliIn.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new A12INTEGRATIONConvertisseurImpl(), createContexteFluxDeclaration("Cali", "A12INTEGRATION", "", "", "", "", "", ""));
  private static final FluxSignature J12CRE_METHODSIGNATURE = createFluxSignature("J12CRE", CREM_IN.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new J12CREConvertisseurImpl(), createContexteFluxDeclaration("Cali", "J12CRE", "", "", "", "", "", ""));
  private static final FluxSignature NOTIFEPC_METHODSIGNATURE = createFluxSignature("NOTIFEPC", Notification.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new NOTIFEPCConvertisseurImpl(), createContexteFluxDeclaration("Cali", "NOTIFEPC", "", "", "", "", "", ""));
  private static final FluxSignature A12INVFRAUD_METHODSIGNATURE = createFluxSignature("A12INVFRAUD", FluxSillageIn.class, new Class[] { ApplicativeException.class, TechniqueException.class }, new A12INVFRAUDConvertisseurImpl(), createContexteFluxDeclaration("Cali", "A12INVFRAUD", "", "", "", "", "", ""));
  
  public void NOTIFEPC(Notification p_in)
    throws ApplicativeException, TechniqueException
  {
    EnteteApplicative ea = new EnteteApplicativeFrameworkImpl("Cali", "");
    demanderFlux(ea, NOTIFEPC_METHODSIGNATURE, getUtilisateur(), getCodeAssedic(), p_in);
  }
  
  public void A12INVFRAUD(FluxSillageIn p_in)
    throws ApplicativeException, TechniqueException
  {
    EnteteApplicative ea = new EnteteApplicativeFrameworkImpl("Cali", "");
    demanderFlux(ea, A12INVFRAUD_METHODSIGNATURE, getUtilisateur(), getCodeAssedic(), p_in);
  }
  
  public void J12CRE(CREM_IN p_in)
    throws ApplicativeException, TechniqueException
  {
    EnteteApplicative ea = new EnteteApplicativeFrameworkImpl("Cali", "");
    demanderFlux(ea, J12CRE_METHODSIGNATURE, getUtilisateur(), getCodeAssedic(), p_in);
  }
  
  public void A12INTEGRATION(FluxCaliIn p_in)
    throws ApplicativeException, TechniqueException
  {
    EnteteApplicative ea = new EnteteApplicativeFrameworkImpl("Cali", "");
    demanderFlux(ea, A12INTEGRATION_METHODSIGNATURE, getUtilisateur(), getCodeAssedic(), p_in);
  }
}

/* Location:
 * Qualified Name:     _DomaineCaliFluxImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */