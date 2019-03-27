package fr.unedic.cali.outilsfonctionnels;

import fr.pe.cali.ManagerFluxCali;
import fr.pe.cali.logique.donnees.vls.FluxSillageIn;
import fr.pe.cali.logique.donnees.vls.FluxSillage_In;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;

public class OutilFluxSillage
{
  public static void declarerDemandeIF(ContexteService p_contexteService, Damj p_dateAttribution, String p_referenceExterne)
  {
    if ((p_contexteService != null) && (p_contexteService.getContexteEmission() != null) && (p_contexteService.getContexteEmission().equals("TP")))
    {
      ManagerFluxCali managerFlux = new ManagerFluxCali();
      
      FluxSillageIn in = FluxSillageIn.getInstance();
      in.setFluxSillage_In(FluxSillage_In.getInstance());
      
      in.getFluxSillage_In().setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsCaliFlux(p_contexteService));
      in.getFluxSillage_In().setDateAttribution(p_dateAttribution);
      in.getFluxSillage_In().setReferenceExterne(p_referenceExterne);
      try
      {
        StringBuffer trace = new StringBuffer();
        
        trace.append("\t Emission du flux Cali - A12INVFRAUD \n");
        trace.append("\t Id Tracker : ");
        trace.append(p_contexteService.getIdCourantTracker());
        trace.append("\n\t Date et heure de création du flux : ");
        trace.append(p_contexteService.getDateHeureCreation());
        trace.append("\n\t Emetteur : ");
        trace.append(p_contexteService.getSrcCodeDomaine());
        trace.append("\n\t Destinataire : ");
        trace.append(p_contexteService.getDstCodeDomaine());
        
        OutilTrace.ecrireTrace(Niveau.INFO, new Object[] { trace });
        
        managerFlux.emettreFluxA12INVFRAUD(in);
      }
      catch (ApplicativeException ex1)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_CALI", "Problème lors de l'appel de service de CALI vers CALI", ex1);
      }
      catch (TechniqueException ex1)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_CALI", "Problème lors de l'appel de service de CALI vers CALI", ex1);
      }
    }
  }
}

/* Location:
 * Qualified Name:     OutilFluxSillage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */