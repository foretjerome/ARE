package fr.pe.cali.client;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.commun.proprietes.PropertiesContext;
import fr.unedic.archi.commun.proprietes.PropertiesException;
import fr.unedic.archi.logique.CodesErreurs;
import fr.unedic.archi.logique.client.ClientSynchronePourDomaine;
import fr.unedic.archi.logique.client.configuration.ConfigurationBouchon;
import fr.unedic.archi.logique.client.configuration.ConfigurationClient;
import fr.unedic.archi.logique.client.configuration.ConfigurationLDAP;
import fr.unedic.archi.logique.client.configuration.ConfigurationLog;
import fr.unedic.archi.logique.client.configuration.ConfigurationXMLJava;
import fr.unedic.archi.logique.client.contexte.ContexteApplicatifServicePourDomaine;
import fr.unedic.archi.logique.client.contexte.ContexteTechniqueServicePourDomaine;
import fr.unedic.archi.logique.client.contexte.EvenementInfoApplicatif;
import fr.unedic.archi.logique.client.contexte.EvenementInfoFonctionnel;
import fr.unedic.archi.logique.client.contexte.EvenementInfoIdentification;
import fr.unedic.archi.logique.client.contexte.EvenementInfoTechnique;
import fr.unedic.archi.logique.client.contexte.FctEvenement;
import fr.unedic.archi.logique.client.contexte.FctJustificatif;
import fr.unedic.archi.logique.client.contexte.FctOrigine;
import fr.unedic.archi.logique.client.contexte.IdentificationAuteur;
import fr.unedic.archi.logique.client.contexte.IdentificationDossier;
import fr.unedic.archi.logique.client.contexte.Service;
import fr.unedic.archi.logique.client.contexte.TypeService;
import fr.unedic.archi.logique.contexte.ContexteApplicatif;
import fr.unedic.archi.logique.contexte.ContexteDeploiement;
import fr.unedic.archi.logique.contexte.ContexteTechnique;
import fr.unedic.archi.logique.contexte.fournisseur.ContexteFournisseur;
import fr.unedic.archi.logique.contexte.fournisseur._ContexteFournisseur;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.logique.donnees.dr1.service.vls.ZIAI10YI89;
import fr.unedic.logique.donnees.dr1.service.vls.ZIEI10YI70;
import fr.unedic.logique.donnees.dr1.service.vls.ZIZI01YI80;
import fr.unedic.logique.donnees.dr1.service.vls.ZOAI10YI89;
import fr.unedic.logique.donnees.dr1.service.vls.ZOEI10YI70;
import fr.unedic.logique.donnees.dr1.service.vls.ZOZI01YI80;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

public abstract class AbstractManagerAppelsServicesDR1
{
  public static final String UTILISATEUR_INDEFINI = "UTILISATEUR_INDEFINI";
  public static final String BALISE_LOGGING = "logging";
  public static final String BALISE_LOGGING_CONFIG_FILE = "xml-configFile";
  private static final int LDAP_NB_TENTATIVES = 3;
  private static final int LDAP_DELAI_EXPIRATION = 10000;
  public static final String BALISE_ANNUAIRE = "annuaire";
  public static final String BALISE_OBJET_VALIDATION = "objet-validation";
  public static final String BALISE_RACINE = "racine";
  public static final String BALISE_TAILLEPOOL = "taille-pool";
  public static final String BALISE_URL = "url";
  public static final String BALISE_URL_PRINCIPALE = "url-principal";
  public static final String BALISE_URL_SECONDAIRE = "url-secondaire";
  
  public ZOAI10YI89 FAI10O_AIDES_ENVELOPPES(ZIAI10YI89 pIn)
    throws ApplicativeException, TechniqueException
  {
    return (ZOAI10YI89)appelGeneriqueSynchrone("Cali", "DR1", "LJAVA", "CICS", "PFAI10O", TypeService.LECTURE, pIn, ZOAI10YI89.getInstance().getClass());
  }
  
  public ZOEI10YI70 FEI10O_SERVICE_SYNCHRONE_CALI(ZIEI10YI70 pIn)
    throws ApplicativeException, TechniqueException
  {
    return (ZOEI10YI70)appelGeneriqueSynchrone("Cali", "DR1", "LJAVA", "CICS", "PFEI10O", TypeService.LECTURE, pIn, ZOEI10YI70.getInstance().getClass());
  }
  
  public ZOZI01YI80 FZI01P_Service_facade_tracker(ZIZI01YI80 pIn)
    throws ApplicativeException, TechniqueException
  {
    return (ZOZI01YI80)appelGeneriqueSynchrone("Cali", "DR1", "LJAVA", "CICS", "PFZI01P", TypeService.LECTURE, pIn, ZOZI01YI80.getInstance().getClass());
  }
  
  protected Object appelGeneriqueSynchrone(String pDomaineAppelant, String pDomaineCible, String pIdImplementationAppelant, String pIdImplementationCible, String pServiceName, TypeService pTypeService, Object pDonnees, Class<?> pClassesDonneesOut)
    throws ApplicativeException, TechniqueException
  {
    ConfigurationClient configurationClient = getConfigurationClientSynchrone();
    ContexteTechniqueServicePourDomaine contexteTechnique = getContexteTechnique();
    ContexteApplicatifServicePourDomaine contexteApplicatif = getContexteApplicatifSynchrone(pDomaineAppelant, pDomaineCible, pIdImplementationAppelant, pIdImplementationCible, getConfigurationUtilisateur(), pServiceName, pTypeService);
    fr.unedic.archi.logique.client.contexte.ContexteEvenement contexteEvenement = getContexteEvenement(pDomaineCible, pServiceName);
    ClientSynchronePourDomaine client = getClientSynchrone();
    return client.appelerService(configurationClient, contexteTechnique, contexteApplicatif, contexteEvenement, pDonnees, pClassesDonneesOut);
  }
  
  protected ConfigurationLDAP getConfigurationLDAP()
    throws TechniqueException
  {
    PropertiesContext contextAnnuaire = _ContexteFournisseur.getContexteDeploiement().getProperties().getUniqueSubContext("annuaire");
    String annuairePrincipal = contextAnnuaire.getUniqueSubContext("url-principal").getValue();
    String annuaireSecondaire = contextAnnuaire.getUniqueSubContext("url-secondaire").getValue();
    if (annuairePrincipal == null)
    {
      String annuaireUnique = contextAnnuaire.getUniqueSubContext("url").getValue();
      ExceptionUtil.assertInternalNotNull("annuaireUnique", annuaireUnique);
      annuairePrincipal = annuaireUnique;
      annuaireSecondaire = annuaireUnique;
    }
    else
    {
      annuaireSecondaire = contextAnnuaire.getUniqueSubContext("url-secondaire").getValue();
    }
    String objetValidation = contextAnnuaire.getUniqueSubContext("objet-validation").getValue();
    if (objetValidation == null)
    {
      TechniqueException techniqueException = CodesErreurs.newERR_ANNUAIRE_0022_OBJET_VALIDATION_PRESENCE_FRONTAL_DN_OBLIGATOIRE();
      throw techniqueException;
    }
    String taillePoolLu = contextAnnuaire.getUniqueSubContext("taille-pool").getValue();
    int taillePool;
    int taillePool;
    if (taillePoolLu == null) {
      taillePool = 10;
    } else {
      try
      {
        taillePool = Integer.parseInt(taillePoolLu);
      }
      catch (NumberFormatException nfe)
      {
        taillePool = 10;
      }
    }
    String ldapRacine = contextAnnuaire.getUniqueSubContext("racine").getValue();
    if (ldapRacine == null) {
      ldapRacine = "o=aae.pole-emploi.intra";
    }
    return new ConfigurationLDAP(annuairePrincipal, annuaireSecondaire, 10000, 3, objetValidation, ldapRacine, taillePool);
  }
  
  protected fr.unedic.archi.logique.client.contexte.Utilisateur getConfigurationUtilisateur()
    throws TechniqueException
  {
    fr.unedic.archi.logique.contexte.Utilisateur user = ContexteFournisseur.getContexteApplicatif().getUtilisateur();
    String identifiant = ContexteFournisseur.getContexteApplicatif().getUtilisateur().getIdentifiant();
    if (identifiant == null) {
      identifiant = "UTILISATEUR_INDEFINI";
    }
    return new fr.unedic.archi.logique.client.contexte.Utilisateur(identifiant, user.getCodeTerritoire(), user.getNiveauCompetence(), user.getIdracf(), user.getIdentifiantContrix());
  }
  
  protected ConfigurationLog getConfigurationLog()
    throws PropertiesException, TechniqueException
  {
    Log log = null;
    PropertiesContext logCtx = _ContexteFournisseur.getContexteDeploiement().getProperties().getUniqueSubContext("logging");
    if (logCtx != null) {
      log = new Log4JLogger(logCtx.getAttribute("xml-configFile"));
    }
    ConfigurationLog configLog = new ConfigurationLog(null, log);
    return configLog;
  }
  
  protected abstract ConfigurationBouchon getConfigurationBouchon()
    throws TechniqueException;
  
  protected ConfigurationXMLJava getConfigurationXMLJava()
    throws TechniqueException
  {
    ConfigurationXMLJava configurationXMLJava = new ConfigurationXMLJava(null);
    return configurationXMLJava;
  }
  
  protected ConfigurationXMLJava getConfigurationXMLJava(String p_codePage)
    throws TechniqueException
  {
    ConfigurationXMLJava configurationXMLJava = new ConfigurationXMLJava(null, p_codePage);
    return configurationXMLJava;
  }
  
  protected ConfigurationClient getConfigurationClientSynchrone()
    throws TechniqueException
  {
    ConfigurationBouchon configurationBouchon = getConfigurationBouchon();
    ConfigurationLDAP configurationLDAP = getConfigurationLDAP();
    ConfigurationLog configurationLog = getConfigurationLog();
    ConfigurationXMLJava configurationXMLJava = getConfigurationXMLJava();
    ConfigurationClient configurationClient = new ConfigurationClient(configurationBouchon, configurationLDAP, configurationLog, configurationXMLJava);
    return configurationClient;
  }
  
  protected ContexteApplicatifServicePourDomaine getContexteApplicatifSynchrone(String pDomaineAppelant, String pDomaineCible, String pIdImplementationAppelant, String pIdImplementationCible, fr.unedic.archi.logique.client.contexte.Utilisateur pConfigurationUtilisateur, String pServiceName, TypeService pTypeService)
    throws TechniqueException
  {
    Service pService = new Service(pServiceName, pTypeService);
    ContexteApplicatifServicePourDomaine contexteApplicatif = new ContexteApplicatifServicePourDomaine(pDomaineAppelant, pDomaineCible, pIdImplementationAppelant, pIdImplementationCible, pService, pConfigurationUtilisateur);
    return contexteApplicatif;
  }
  
  protected ContexteTechniqueServicePourDomaine getContexteTechnique()
    throws TechniqueException
  {
    ContexteTechniqueServicePourDomaine contexteTechnique = new ContexteTechniqueServicePourDomaine(_ContexteFournisseur.getContexteTechnique().getEnvironnement(), _ContexteFournisseur.getContexteTechnique().getIdImplementation(), null);
    
    contexteTechnique.setNonMarquageTransactionPourAnnulation(_ContexteFournisseur.getContexteTechnique().getNePasFaireDeRollbackSurUneException());
    return contexteTechnique;
  }
  
  protected fr.unedic.archi.logique.client.contexte.ContexteEvenement getContexteEvenement(String pDomaineCible, String pServiceName)
    throws TechniqueException
  {
    EvenementInfoTechnique infoTech = new EvenementInfoTechnique(_ContexteFournisseur.getContexteEvenement().getIdentifiantCorrelation(), _ContexteFournisseur.getContexteEvenement().getModeSollicitation());
    
    EvenementInfoApplicatif infoApp = new EvenementInfoApplicatif(_ContexteFournisseur.getContexteEvenement().getApplicationEmettrice(), _ContexteFournisseur.getContexteEvenement().getProcessusEmetteur(), _ContexteFournisseur.getContexteEvenement().getFonctionEmettrice(), pDomaineCible, pServiceName, _ContexteFournisseur.getContexteEvenement().getDateTraitement());
    
    IdentificationAuteur auteur = new IdentificationAuteur(_ContexteFournisseur.getContexteEvenement().getUidAuteur(), _ContexteFournisseur.getContexteEvenement().getModeAuthAuteur(), _ContexteFournisseur.getContexteEvenement().getTypeAuteur(), _ContexteFournisseur.getContexteEvenement().getUidOrgAuteur(), _ContexteFournisseur.getContexteEvenement().getOrgaGestionnaire(), _ContexteFournisseur.getContexteEvenement().getCodeOrgAuteur(), _ContexteFournisseur.getContexteEvenement().getNumeroDepartement());
    
    IdentificationDossier dossier = new IdentificationDossier(_ContexteFournisseur.getContexteEvenement().getIdDossier(), _ContexteFournisseur.getContexteEvenement().getLibelleDossier(), _ContexteFournisseur.getContexteEvenement().getTypeDossier(), _ContexteFournisseur.getContexteEvenement().getOrgaGestionnaire());
    
    EvenementInfoIdentification infoIdent = new EvenementInfoIdentification(auteur, dossier);
    
    FctOrigine origine = new FctOrigine(_ContexteFournisseur.getContexteEvenement().getModeEvenement(), _ContexteFournisseur.getContexteEvenement().getFournisseurInfo(), _ContexteFournisseur.getContexteEvenement().getOrigineInformation());
    
    FctJustificatif just = new FctJustificatif(_ContexteFournisseur.getContexteEvenement().getTypeJustificatif(), _ContexteFournisseur.getContexteEvenement().getDateRecepJustificatif());
    
    FctEvenement evt = new FctEvenement(_ContexteFournisseur.getContexteEvenement().getTypeEvenement(), _ContexteFournisseur.getContexteEvenement().getLibelleEvenement());
    
    EvenementInfoFonctionnel infoFct = new EvenementInfoFonctionnel(evt, just, origine);
    
    fr.unedic.archi.logique.client.contexte.ContexteEvenement contexteEvenement = new fr.unedic.archi.logique.client.contexte.ContexteEvenement(infoApp, infoFct, infoIdent, infoTech);
    
    return contexteEvenement;
  }
  
  protected ClientSynchronePourDomaine getClientSynchrone()
  {
    ClientSynchronePourDomaine client = ClientSynchronePourDomaine.getInstance();
    return client;
  }
}

/* Location:
 * Qualified Name:     AbstractManagerAppelsServicesDR1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */