package fr.unedic.cali.outilsfonctionnels;

import fr.pe.d12dal.service.es.completude.ContexteServiceES;
import fr.unedic.util.services.ContexteServiceSpec;
import fr.unedic.util.services.MapperAbstrait;
import fr.unedic.util.services.MapperContexteService;
import fr.unedic.util.temps.Heure;
import java.util.Date;

public abstract class AppelServicesAbstrait
  extends MapperAbstrait
{
  public static fr.pe.cali.logique.donnees.vls.ContexteService contexteServiceDomVersVlsCaliFlux(fr.unedic.util.services.ContexteService contexteServiceDom)
  {
    fr.pe.cali.logique.donnees.vls.ContexteService contexteServiceVls = fr.pe.cali.logique.donnees.vls.ContexteService.getInstance();
    if (contexteServiceDom != null) {
      mapperDomVersVls(contexteServiceDom, contexteServiceVls);
    }
    return contexteServiceVls;
  }
  
  private static void mapperDomVersVls(fr.unedic.util.services.ContexteService contexteServiceDom, fr.pe.cali.logique.donnees.vls.ContexteService contexteServiceVls)
  {
    contexteServiceVls.setIdFlux(contexteServiceDom.getId());
    
    contexteServiceVls.setContexteEmission(contexteServiceDom.getContexteEmission());
    contexteServiceVls.setSrcCodeAssedic(contexteServiceDom.getSrcCodeAssedic());
    contexteServiceVls.setSrcCodeApplication(contexteServiceDom.getSrcCodeApplication());
    contexteServiceVls.setSrcCodeDomaine(contexteServiceDom.getSrcCodeDomaine());
    contexteServiceVls.setSrcCodeProcessus(contexteServiceDom.getSrcCodeProcessus());
    contexteServiceVls.setSrcCodeTransaction(contexteServiceDom.getSrcCodeTransaction());
    contexteServiceVls.setSrcCodeProgramme(contexteServiceDom.getSrcCodeProgramme());
    contexteServiceVls.setSrcCodeAgent(contexteServiceDom.getSrcCodeAgent());
    
    contexteServiceVls.setDstCodeAssedic(contexteServiceDom.getDstCodeAssedic());
    contexteServiceVls.setDstCodeApplication(contexteServiceDom.getDstCodeApplication());
    contexteServiceVls.setDstCodeDomaine(contexteServiceDom.getDstCodeDomaine());
    contexteServiceVls.setCodeActivite(contexteServiceDom.getCodeActivite());
    
    contexteServiceVls.setIdCourantTracker(contexteServiceDom.getIdCourantTracker());
    contexteServiceVls.setIdOrigineTracker(contexteServiceDom.getIdOrigineTracker());
    contexteServiceVls.setIdPrecedentTracker(contexteServiceDom.getIdPrecedentTracker());
    contexteServiceVls.setCodeFlux(contexteServiceDom.getCodeFlux());
    
    contexteServiceVls.setDateCreation(contexteServiceDom.getDateCreation());
    contexteServiceVls.setHeureCreation(contexteServiceDom.getHeureCreation().toString());
    contexteServiceVls.setDateTraitement(contexteServiceDom.getDateTraitement());
    
    contexteServiceVls.setEnvtNature(contexteServiceDom.getEnvtNature());
    contexteServiceVls.setEnvtBase(contexteServiceDom.getEnvtBase());
    contexteServiceVls.setEnvtServeur(contexteServiceDom.getEnvtServeur());
    contexteServiceVls.setAdresseIP(contexteServiceDom.getAdresseIP());
    
    contexteServiceVls.setTypeEntite(contexteServiceDom.getTypeEntite());
    contexteServiceVls.setCxala(contexteServiceDom.getCxala());
    contexteServiceVls.setRsin(contexteServiceDom.getRsin());
    contexteServiceVls.setIdEntiteAutre(contexteServiceDom.getIdEntiteAutre());
    contexteServiceVls.setCodeAntenne(contexteServiceDom.getCodeAntenne());
  }
  
  public static void miseAJourContexteServiceDomPourTracker(ContexteServiceSpec contexteServiceDom, String domaineRecepteur, String codeFlux)
  {
    if (contexteServiceDom != null)
    {
      contexteServiceDom.setDateHeureCreation(new Date(System.currentTimeMillis()));
      
      contexteServiceDom.setSrcCodeDomaine("D12");
      
      contexteServiceDom.setDstCodeDomaine(domaineRecepteur);
      
      contexteServiceDom.setCodeFlux(codeFlux);
    }
  }
  
  public static fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ContexteService contexteServiceDomVersVlsGaec(fr.unedic.util.services.ContexteService contexteServiceDom)
  {
    fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ContexteService contexteServiceVls = fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ContexteService.getInstance();
    if (contexteServiceDom != null) {
      MapperContexteService.domVersVls(contexteServiceDom, contexteServiceVls);
    }
    return contexteServiceVls;
  }
  
  public static fr.unedic.d90.donnees.d90.service.vls.ContexteService contexteServiceDomVersVlsD90(fr.unedic.util.services.ContexteService contexteServiceDom)
  {
    fr.unedic.d90.donnees.d90.service.vls.ContexteService contexteServiceVls = fr.unedic.d90.donnees.d90.service.vls.ContexteService.getInstance();
    if (contexteServiceDom != null) {
      MapperContexteService.domVersVls(contexteServiceDom, contexteServiceVls);
    }
    return contexteServiceVls;
  }
  
  public static ContexteServiceES contexteServiceDomVersVlsD12DAL(fr.unedic.util.services.ContexteService contexteServiceDom)
  {
    ContexteServiceES contexteServiceVls = ContexteServiceES.getInstance();
    if (contexteServiceDom != null) {
      MapperContexteService.domVersVls(contexteServiceDom, contexteServiceVls);
    }
    return contexteServiceVls;
  }
}

/* Location:
 * Qualified Name:     AppelServicesAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */