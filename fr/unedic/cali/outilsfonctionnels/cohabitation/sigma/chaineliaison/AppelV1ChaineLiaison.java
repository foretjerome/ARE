package fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.chaineliaison;

import fr.pe.cali.client.ManagerAppelsServicesDR1;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.sigma.CodesErreurs;
import fr.unedic.cali.autresdoms.cohab.sigma.chaineliaison.dom.ResultatChaineLiaison;
import fr.unedic.cali.autresdoms.cohab.sigma.chaineliaison.dom.spec.CriteresChaineLiaisonSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.chaineliaison.dom.spec.ResultatChaineLiaisonSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.dom.MapperContexteService;
import fr.unedic.logique.donnees.dr1.service.vls.YI80_IN;
import fr.unedic.logique.donnees.dr1.service.vls.YI80_OUT;
import fr.unedic.logique.donnees.dr1.service.vls.YI82;
import fr.unedic.logique.donnees.dr1.service.vls.YI83;
import fr.unedic.logique.donnees.dr1.service.vls.ZIZI01YI80;
import fr.unedic.logique.donnees.dr1.service.vls.ZOZI01YI80;
import fr.unedic.logique.donnees.dr1.service.vls.ZOZI01YI82;
import fr.unedic.logique.donnees.dr1.service.vls.ZOZI01YI82IT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOZI01YI82LT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOZI01YI83;
import fr.unedic.logique.donnees.dr1.service.vls.ZOZI01YI83IT;
import fr.unedic.logique.donnees.dr1.service.vls.ZOZI01YI83LT;
import fr.unedic.util.services.ContexteServiceSpec;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppelV1ChaineLiaison
{
  private static final String[] DOMAINES_V1 = { "DPS", "PCH" };
  private static final String[] DOMAINES_V2 = { "D11", "D12" };
  
  public ResultatChaineLiaisonSpec lireChaineLiaison(CriteresChaineLiaisonSpec criteres)
    throws ApplicativeException, TechniqueException
  {
    String identifiantIndividu = criteres.getIdentifiantIndividu();
    if (identifiantIndividu != null) {
      identifiantIndividu = identifiantIndividu.toUpperCase();
    }
    String codeAssedic = criteres.getCodeAssedic();
    Date dateEvenement = criteres.getDateEvenement();
    BigDecimal cxala = criteres.getContexteService().getCxala();
    
    ResultatChaineLiaisonSpec retour = new ResultatChaineLiaison();
    
    ZOZI01YI80 dr1Out = null;
    try
    {
      ZIZI01YI80 dr1In = ZIZI01YI80.getInstance();
      
      YI80_IN zoneComIn = dr1In.setNewYI80_IN_Z__COMMUNICATION_FZI01P();
      
      zoneComIn.setYI20_Entete_Applicative(MapperContexteService.formate(criteres.getContexteService()));
      
      zoneComIn.setCSAS_CODE_UNEDIC_DE_L_ASSEDIC(new BigDecimal(codeAssedic));
      zoneComIn.setRSIN_IDENTIFIANT_DE_L_INDIVIDU(identifiantIndividu);
      zoneComIn.setCXALA_IDENTIFIANT_NATIONAL_INTERNE(cxala);
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      if (dateEvenement != null) {
        zoneComIn.setDCEVT2_Date_creation_evenement_TS(sdf.format(dateEvenement));
      }
      zoneComIn.setFFFNT_INDICATEUR_DE_FLUX_NON_TRAITE("O");
      
      dr1Out = appelService(dr1In);
      
      retour.setFluxV1V2Correct(true);
      retour.setFluxV2V2Correct(true);
      retour.setFluxV2V1Correct(true);
      
      YI80_OUT yi80 = dr1Out.getYI80_OUT_Z__COMMUNICATION_FZI01P();
      ZOZI01YI82LT listeDonneesTcis = yi80.getZOZI01YI82_DONNEES_TRACKER_A_TRAITER_TCIS().getZOZI01YI82LT();
      ZOZI01YI83LT listeDonneesNonTcis = yi80.getZOZI01YI83_DONNEES_TRACKER_A_TRAITER_NON_TCIS().getZOZI01YI83LT();
      if ((listeDonneesTcis != null) && (listeDonneesTcis.getNbZOZI01YI82LT() != 0)) {
        traitementDonneesTcis(listeDonneesTcis, retour);
      }
      if ((listeDonneesNonTcis != null) && (listeDonneesNonTcis.getNbZOZI01YI83LT() != 0)) {
        traitementDonneesNonTcis(listeDonneesNonTcis, retour);
      }
      dr1Out.getYI80_OUT_Z__COMMUNICATION_FZI01P();
    }
    catch (ApplicativeException ae)
    {
      throw CodesErreurs.getErreurServiceV1(ae, "FZIO01P");
    }
    return retour;
  }
  
  public ZOZI01YI80 appelService(ZIZI01YI80 donneesIn)
    throws TechniqueException, ApplicativeException
  {
    ManagerAppelsServicesDR1 managerService = new ManagerAppelsServicesDR1();
    return managerService.FZI01P_Service_facade_tracker(donneesIn);
  }
  
  private void traitementDonneesTcis(ZOZI01YI82LT liste, ResultatChaineLiaisonSpec resultat)
  {
    for (int i = 0; i < liste.getNbZOZI01YI82LT(); i++)
    {
      String emetteur = liste.getZOZI01YI82LT(i).getYI82_DONNEES_TRACKER_A_TRAITER_TCIS().getCDDOM3_Code_Dommaine_Emetteur();
      String destinataire = liste.getZOZI01YI82LT(i).getYI82_DONNEES_TRACKER_A_TRAITER_TCIS().getCDDOD3_Code_Domaine();
      traitementDonnee(emetteur, destinataire, resultat);
    }
  }
  
  private void traitementDonneesNonTcis(ZOZI01YI83LT liste, ResultatChaineLiaisonSpec resultat)
  {
    for (int i = 0; i < liste.getNbZOZI01YI83LT(); i++)
    {
      String emetteur = liste.getZOZI01YI83LT(i).getYI83_DONNEES_TRACKER_A_TRAITER_NON_TCIS().getCDDOM2_Code_Dommaine_Emetteur();
      String destinataire = liste.getZOZI01YI83LT(i).getYI83_DONNEES_TRACKER_A_TRAITER_NON_TCIS().getCDDOD2_Code_Domaine();
      traitementDonnee(emetteur, destinataire, resultat);
    }
  }
  
  private void traitementDonnee(String emetteur, String destinataire, ResultatChaineLiaisonSpec resultat)
  {
    boolean emtV1 = isDomaineV1(emetteur);
    boolean emtV2 = isDomaineV2(emetteur);
    boolean dstV1 = isDomaineV1(destinataire);
    boolean dstV2 = isDomaineV2(destinataire);
    if ((emtV1) && (dstV2)) {
      resultat.setFluxV1V2Correct(false);
    }
    if ((emtV2) && (dstV1)) {
      resultat.setFluxV2V1Correct(false);
    }
    if ((emtV2) && (dstV2)) {
      resultat.setFluxV2V2Correct(false);
    }
  }
  
  private boolean isDomaineV1(String domaine)
  {
    for (int i = 0; i < DOMAINES_V1.length; i++) {
      if (DOMAINES_V1[i].equals(domaine)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isDomaineV2(String domaine)
  {
    for (int i = 0; i < DOMAINES_V2.length; i++) {
      if (DOMAINES_V2[i].equals(domaine)) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     AppelV1ChaineLiaison
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */