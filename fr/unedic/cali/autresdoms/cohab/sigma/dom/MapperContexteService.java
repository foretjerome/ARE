package fr.unedic.cali.autresdoms.cohab.sigma.dom;

import fr.unedic.logique.donnees.dr1.service.vls.YI20;
import fr.unedic.logique.donnees.dr1.service.vls.YI21;
import fr.unedic.logique.donnees.dr1.service.vls.YI22;
import fr.unedic.logique.donnees.dr1.service.vls.YI23;
import fr.unedic.logique.donnees.dr1.service.vls.YI24;
import fr.unedic.logique.donnees.dr1.service.vls.YI25;
import fr.unedic.logique.donnees.dr1.service.vls.YI26;
import fr.unedic.logique.donnees.dr1.service.vls.YI28;
import fr.unedic.logique.donnees.dr1.service.vls.YI29;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.ContexteServiceSpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class MapperContexteService
{
  public static final String FORMAT_HEURE_V1 = "HH.mm.ss.SSS";
  public static final String FORMAT_DATE_V1 = "yyyy-MM-dd-";
  public static final String FORMAT_HEURE_V2 = "HH:mm:ss.SSS";
  public static final String FORMAT_DATE_V2 = "yyyy-MM-dd-";
  
  public static ContexteServiceSpec copieContexteService(ContexteService p_contexte)
  {
    return (ContexteServiceSpec)p_contexte.copie();
  }
  
  public static ContexteServiceSpec formate(YI20 p_YI20)
  {
    ContexteService cs = new ContexteService();
    if (p_YI20 != null)
    {
      cs.setDateTraitement(p_YI20.getYI28_Entete_Applicative___Dates().getDCEVM_Date_Traitement());
      if (p_YI20.getYI29_Entete_Applicative___Lien_even_Batch().getDCEVT_Date_creation_evenement_TS() != null)
      {
        SimpleDateFormat formatDateHeure = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSS");
        try
        {
          cs.setDateHeureCreation(formatDateHeure.parse(p_YI20.getYI29_Entete_Applicative___Lien_even_Batch().getDCEVT_Date_creation_evenement_TS()));
        }
        catch (ParseException e)
        {
          cs.setDateHeureCreation(null);
        }
      }
      else
      {
        cs.setDateHeureCreation(null);
      }
      cs.setIdFlux(p_YI20.getYI29_Entete_Applicative___Lien_even_Batch().getCXEVT_Clef_Primaire_Table_Evt_D90());
      
      cs.setSrcCodeAssedic(p_YI20.getYI22_Entete_Applicative___Emetteur().getCSASEM_Code_de_l_Assedic_emettrice());
      cs.setContexteEmission(p_YI20.getYI22_Entete_Applicative___Emetteur().getCDCEM_Contexte_emission());
      cs.setSrcCodeApplication(p_YI20.getYI22_Entete_Applicative___Emetteur().getCXAEM_Code_Application_Emetrice());
      cs.setSrcCodeDomaine(p_YI20.getYI22_Entete_Applicative___Emetteur().getCDDOM_Code_Dommaine_Emetteur());
      cs.setSrcCodeProcessus(p_YI20.getYI22_Entete_Applicative___Emetteur().getCDPRS_Code_Processus());
      cs.setSrcCodeTransaction(p_YI20.getYI22_Entete_Applicative___Emetteur().getCDTRE_Code_Transaction_Emettrice());
      cs.setSrcCodeProgramme(p_YI20.getYI22_Entete_Applicative___Emetteur().getCDPRE_Code_Programme_Emetteur());
      cs.setSrcCodeAgent(p_YI20.getYI22_Entete_Applicative___Emetteur().getCDAGE_Code_Agent());
      
      cs.setIdCourantTracker(p_YI20.getYI21_Entete_Applicative___Tracker().getCXTRA_Code_de_l_identifiant_Tracker());
      cs.setIdOrigineTracker(p_YI20.getYI21_Entete_Applicative___Tracker().getCXTRAO_Code_identifiant_Tracker_Origine());
      if (p_YI20.getYI21_Entete_Applicative___Tracker().getCXTRAP_Code_identifiant_Tracker_PrEcEdent() != null) {
        cs.setIdPrecedentTracker(p_YI20.getYI21_Entete_Applicative___Tracker().getCXTRAP_Code_identifiant_Tracker_PrEcEdent());
      } else {
        cs.setIdPrecedentTracker("");
      }
      cs.setCodeFlux(p_YI20.getYI21_Entete_Applicative___Tracker().getCXFLUB_Identifiant_Flux_du_GDF());
      
      cs.setDstCodeAssedic(p_YI20.getYI23_Entete_Applicative___Destinataire().getCSASRE_Code_de_l_Assedic_receptrice());
      cs.setDstCodeApplication(p_YI20.getYI23_Entete_Applicative___Destinataire().getCDAPN_Code_Application());
      cs.setDstCodeDomaine(p_YI20.getYI23_Entete_Applicative___Destinataire().getCDDOD_Code_Domaine());
      cs.setCodeActivite(p_YI20.getYI23_Entete_Applicative___Destinataire().getCDCAV_Code_Activite());
      
      cs.setEnvtNature(p_YI20.getYI24_Entete_Applicative___Env__Exploit_().getCSNEN_Nature_d_environnement());
      cs.setEnvtBase(p_YI20.getYI24_Entete_Applicative___Env__Exploit_().getCDJBA_Jeu_de_Base());
      cs.setEnvtServeur(p_YI20.getYI24_Entete_Applicative___Env__Exploit_().getCNSRP_Serveur_Physique());
      
      cs.setAdresseIP(p_YI20.getYI25_Entete_Applicative___Env__Travail().getCDADI_Adresse_IP());
      
      cs.setTypeEntite(p_YI20.getYI26_Entete_Applicative___Entite().getCDETY_Type_Entite());
      cs.setCxala(p_YI20.getYI26_Entete_Applicative___Entite().getCXALAT_IDENTIFIANT_NATIONAL_INTERNE());
      cs.setRsin(p_YI20.getYI26_Entete_Applicative___Entite().getCCIND_CODE_INDIVIDU());
      cs.setIdEntiteAutre(p_YI20.getYI26_Entete_Applicative___Entite().getCDIDA_Code_Autre_Identifiant());
      cs.setCodeAntenne(p_YI20.getYI26_Entete_Applicative___Entite().getCSANK_Code_Antenne());
    }
    return cs;
  }
  
  public static YI20 formate(ContexteServiceSpec p_contexte)
  {
    YI20 yi20 = YI20.getInstance();
    SimpleDateFormat formatDateHeure = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSS");
    yi20.setNewYI29_Entete_Applicative___Lien_even_Batch();
    yi20.getYI29_Entete_Applicative___Lien_even_Batch().setDCEVT_Date_creation_evenement_TS(formatDateHeure.format(p_contexte.getDateHeureCreation()));
    yi20.getYI29_Entete_Applicative___Lien_even_Batch().setCXEVT_Clef_Primaire_Table_Evt_D90(p_contexte.getIdFlux());
    yi20.setNewYI22_Entete_Applicative___Emetteur();
    yi20.getYI22_Entete_Applicative___Emetteur().setCDCEM_Contexte_emission(p_contexte.getContexteEmission());
    yi20.getYI22_Entete_Applicative___Emetteur().setCSASEM_Code_de_l_Assedic_emettrice(p_contexte.getSrcCodeAssedic());
    yi20.getYI22_Entete_Applicative___Emetteur().setCXAEM_Code_Application_Emetrice(p_contexte.getSrcCodeApplication());
    yi20.getYI22_Entete_Applicative___Emetteur().setCDDOM_Code_Dommaine_Emetteur(p_contexte.getSrcCodeDomaine());
    yi20.getYI22_Entete_Applicative___Emetteur().setCDPRS_Code_Processus(p_contexte.getSrcCodeProcessus());
    yi20.getYI22_Entete_Applicative___Emetteur().setCDTRE_Code_Transaction_Emettrice(p_contexte.getSrcCodeTransaction());
    yi20.getYI22_Entete_Applicative___Emetteur().setCDPRE_Code_Programme_Emetteur(p_contexte.getSrcCodeProgramme());
    yi20.getYI22_Entete_Applicative___Emetteur().setCDAGE_Code_Agent(p_contexte.getSrcCodeAgent());
    yi20.setNewYI23_Entete_Applicative___Destinataire();
    yi20.getYI23_Entete_Applicative___Destinataire().setCDAPN_Code_Application(p_contexte.getDstCodeApplication());
    yi20.getYI23_Entete_Applicative___Destinataire().setCDDOD_Code_Domaine(p_contexte.getDstCodeDomaine());
    yi20.getYI23_Entete_Applicative___Destinataire().setCDCAV_Code_Activite(p_contexte.getCodeActivite());
    yi20.setNewYI21_Entete_Applicative___Tracker();
    yi20.getYI21_Entete_Applicative___Tracker().setCXTRA_Code_de_l_identifiant_Tracker(p_contexte.getIdCourantTracker());
    yi20.getYI21_Entete_Applicative___Tracker().setCXTRAO_Code_identifiant_Tracker_Origine(p_contexte.getIdOrigineTracker());
    yi20.getYI21_Entete_Applicative___Tracker().setCXTRAP_Code_identifiant_Tracker_PrEcEdent(p_contexte.getIdPrecedentTracker());
    
    yi20.getYI21_Entete_Applicative___Tracker().setCXFLUB_Identifiant_Flux_du_GDF("SYNCHR");
    yi20.setNewYI28_Entete_Applicative___Dates();
    yi20.getYI28_Entete_Applicative___Dates().setDCEVM_Date_Traitement(p_contexte.getDateTraitement());
    yi20.setNewYI24_Entete_Applicative___Env__Exploit_();
    yi20.getYI24_Entete_Applicative___Env__Exploit_().setCSNEN_Nature_d_environnement(p_contexte.getEnvtNature());
    yi20.getYI24_Entete_Applicative___Env__Exploit_().setCDJBA_Jeu_de_Base(p_contexte.getEnvtBase());
    yi20.getYI24_Entete_Applicative___Env__Exploit_().setCNSRP_Serveur_Physique(p_contexte.getEnvtServeur());
    yi20.setNewYI25_Entete_Applicative___Env__Travail();
    yi20.getYI25_Entete_Applicative___Env__Travail().setCDADI_Adresse_IP(p_contexte.getAdresseIP());
    yi20.setNewYI26_Entete_Applicative___Entite();
    yi20.getYI26_Entete_Applicative___Entite().setCDETY_Type_Entite(p_contexte.getTypeEntite());
    yi20.getYI26_Entete_Applicative___Entite().setCXALAT_IDENTIFIANT_NATIONAL_INTERNE(p_contexte.getCxala());
    yi20.getYI26_Entete_Applicative___Entite().setCCIND_CODE_INDIVIDU(p_contexte.getRsin());
    yi20.getYI26_Entete_Applicative___Entite().setCDIDA_Code_Autre_Identifiant(p_contexte.getIdEntiteAutre());
    yi20.getYI26_Entete_Applicative___Entite().setCSANK_Code_Antenne(p_contexte.getCodeAntenne());
    
    return yi20;
  }
}

/* Location:
 * Qualified Name:     MapperContexteService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */