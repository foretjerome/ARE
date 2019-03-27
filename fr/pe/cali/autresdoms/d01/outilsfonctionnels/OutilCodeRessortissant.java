package fr.pe.cali.autresdoms.d01.outilsfonctionnels;

import fr.pe.cali.client.ManagerAppelsServicesD01;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.ConteneurCodeRessortissant;
import fr.unedic.cali.dom.ConteneurResultatCodeRessortissant;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.cali.outilsfonctionnels.strategies.ContexteExecutionJunit;
import fr.unedic.logique.donnees.rac.commun.dra.d01.zu.ML49;
import fr.unedic.logique.donnees.rac.commun.dra.d01.zu.ML50;
import fr.unedic.logique.donnees.rac.commun.dra.d01.zu.ZI01KIML49;
import fr.unedic.logique.donnees.rac.commun.dra.d01.zu.ZO01KIML50;
import fr.unedic.util.services.OutilFonctionnel;
import java.math.BigDecimal;

public class OutilCodeRessortissant
  implements OutilFonctionnel
{
  private static OutilCodeRessortissant instance;
  
  public static OutilCodeRessortissant getInstance()
  {
    if (instance == null) {
      instance = new OutilCodeRessortissant();
    }
    return instance;
  }
  
  private ZI01KIML49 alimenterVlsEntreeService(BigDecimal identifiant, String codeTraitement)
  {
    ZI01KIML49 donneesIn = ZI01KIML49.getInstance();
    ML49 caliRessortissant = ML49.getInstance();
    donneesIn.setML49__in_SA01KI_CALI_RESSORTISSANTS(caliRessortissant);
    caliRessortissant.setCXALA_IDENTIFIANT_NATIONAL_ALADIN(identifiant);
    caliRessortissant.setCITRT_CODE_TRAITEMENT(codeTraitement);
    return donneesIn;
  }
  
  private ZO01KIML50 appelerServiceCodeRessortissant(ZI01KIML49 vlsEntree)
  {
    ZO01KIML50 sortie = null;
    ManagerAppelsServicesD01 managerService = new ManagerAppelsServicesD01();
    try
    {
      sortie = managerService.SA01KI_Service_CALI___ressortissants(vlsEntree);
    }
    catch (Exception e)
    {
      OutilTrace.ecrireTrace(Niveau.ERROR, new String[] { "Exception levée lors de l'appel de D01 / Code Ressortissant" }, e);
    }
    return sortie;
  }
  
  public ConteneurResultatCodeRessortissant trouverInfosRessortissant(ConteneurCodeRessortissant conteneur)
  {
    BigDecimal identifiant = new BigDecimal(conteneur.getIdentifiantNational());
    String codeTraitement = conteneur.getCodeTraitement();
    
    ConteneurResultatCodeRessortissant conteneurResultat = null;
    if (!ContexteExecutionJunit.isActif())
    {
      ZI01KIML49 vlsEntree = alimenterVlsEntreeService(identifiant, codeTraitement);
      ZO01KIML50 vlsSortie = appelerServiceCodeRessortissant(vlsEntree);
      if (vlsSortie != null) {
        conteneurResultat = new ConteneurResultatCodeRessortissant(vlsSortie.getML50__out_SA01KI_CALI_RESSORTISSANTS().getCDRSO_CODE_RESSORTISSANT(), vlsSortie.getML50__out_SA01KI_CALI_RESSORTISSANTS().getDVENAA_DATE_VERIFICATION_DE_LA_NATIONALITE(), vlsSortie.getML50__out_SA01KI_CALI_RESSORTISSANTS().getCDERJ_CODE_ERREUR());
      }
    }
    return conteneurResultat;
  }
}

/* Location:
 * Qualified Name:     OutilCodeRessortissant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */