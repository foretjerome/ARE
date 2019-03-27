package fr.pe.cali.client;

import fr.pe.cali.logique.donnees.vls.CREM_IN;
import fr.pe.cali.logique.donnees.vls.FluxCaliIn;
import fr.pe.cali.logique.donnees.vls.FluxSillageIn;
import fr.pe.cali.logique.donnees.vls.Notification;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.commun.proprietes.PropertiesContext;
import fr.unedic.archi.logique.CodesErreurs;
import fr.unedic.archi.logique.client.ClientAsynchronePourDomaine;
import fr.unedic.archi.logique.client.configuration.ConfigurationChaineAsynchrone;
import fr.unedic.archi.logique.client.configuration.ConfigurationClientAsynchrone;
import fr.unedic.archi.logique.client.configuration.ConfigurationLDAP;
import fr.unedic.archi.logique.client.configuration.ConfigurationLog;
import fr.unedic.archi.logique.client.configuration.ConfigurationXMLJava;
import fr.unedic.archi.logique.client.contexte.ContexteApplicatifFluxPourDomaine;
import fr.unedic.archi.logique.client.contexte.ContexteTechniqueFlux;
import fr.unedic.archi.logique.client.contexte.EvenementInfoApplicatif;
import fr.unedic.archi.logique.client.contexte.EvenementInfoFonctionnel;
import fr.unedic.archi.logique.client.contexte.EvenementInfoIdentification;
import fr.unedic.archi.logique.client.contexte.EvenementInfoTechnique;
import fr.unedic.archi.logique.client.contexte.FctEvenement;
import fr.unedic.archi.logique.client.contexte.FctJustificatif;
import fr.unedic.archi.logique.client.contexte.FctOrigine;
import fr.unedic.archi.logique.client.contexte.IdentificationAuteur;
import fr.unedic.archi.logique.client.contexte.IdentificationDossier;
import fr.unedic.archi.logique.contexte.ContexteApplicatif;
import fr.unedic.archi.logique.contexte.ContexteDeploiement;
import fr.unedic.archi.logique.contexte.ContexteTechnique;
import fr.unedic.archi.logique.contexte.fournisseur.ContexteFournisseur;
import fr.unedic.archi.logique.contexte.fournisseur._ContexteFournisseur;
import fr.unedic.archi.logique.exception.ApplicativeException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

public abstract class AbstractManagerFluxCaliGen
{
  public static final String BALISE_ANNUAIRE = "annuaire";
  public static final String BALISE_TAILLEPOOL = "taille-pool";
  public static final String BALISE_URL = "url";
  public static final String BALISE_URL_PRINCIPALE = "url-principal";
  public static final String BALISE_URL_SECONDAIRE = "url-secondaire";
  public static final String BALISE_OBJET_VALIDATION = "objet-validation";
  public static final String BALISE_RACINE = "racine";
  private static final String BALISE_LOGGING = "logging";
  private static final String BALISE_LOGGING_CONFIG_FILE = "xml-configFile";
  private static final int LDAP_NB_TENTATIVES = 3;
  private static final int LDAP_DELAI_EXPIRATION = 10000;
  
  public void emettreFluxA12INTEGRATION(FluxCaliIn pFlux)
    throws ApplicativeException, TechniqueException
  {
    appelGenerique(pFlux, "Cali", "LJAVA", "A12INTEGRATION");
  }
  
  public void emettreFluxJ12CRE(CREM_IN pFlux)
    throws ApplicativeException, TechniqueException
  {
    appelGenerique(pFlux, "Cali", "LJAVA", "J12CRE");
  }
  
  public void emettreFluxNOTIFEPC(Notification pFlux)
    throws ApplicativeException, TechniqueException
  {
    appelGenerique(pFlux, "Cali", "LJAVA", "NOTIFEPC");
  }
  
  public void emettreFluxA12INVFRAUD(FluxSillageIn pFlux)
    throws ApplicativeException, TechniqueException
  {
    appelGenerique(pFlux, "Cali", "LJAVA", "A12INVFRAUD");
  }
  
  public void appelGenerique(Object pDonnees, String pDomaine, String pIdImplementation, String pNomFlux)
    throws ApplicativeException, TechniqueException
  {
    appelGenerique(pDonnees, pDomaine, ContexteFournisseur.getContexteApplicatif().getService(), pIdImplementation, pNomFlux);
  }
  
  public void appelGenerique(Object pDonnees, String pDomaine, String pServiceEmetteur, String pIdImplementation, String pNomFlux)
    throws ApplicativeException, TechniqueException
  {
    ConfigurationClientAsynchrone configClient = getConfigurationClientAsynchrone();
    ContexteTechniqueFlux contexteTechnique = getContexteTechniqueFlux();
    ContexteApplicatifFluxPourDomaine contexteApplicatif = getContexteApplicatifFlux(pDomaine, pServiceEmetteur, pIdImplementation, pNomFlux);
    fr.unedic.archi.logique.client.contexte.ContexteEvenement contexteEvenement = getContexteEvenement(pDomaine);
    ClientAsynchronePourDomaine client = getClientAsynchronePourDomaine();
    client.envoyerFlux(configClient, contexteTechnique, contexteApplicatif, contexteEvenement, pDonnees);
  }
  
  protected ClientAsynchronePourDomaine getClientAsynchronePourDomaine()
  {
    ClientAsynchronePourDomaine client = ClientAsynchronePourDomaine.getInstance();
    return client;
  }
  
  protected ConfigurationClientAsynchrone getConfigurationClientAsynchrone()
    throws TechniqueException
  {
    ConfigurationXMLJava configXMLJava = new ConfigurationXMLJava(null);
    ConfigurationChaineAsynchrone confASync = new ConfigurationChaineAsynchrone(getConfigurationLDAP(), _ContexteFournisseur.getContexteTechnique().getEnvironnement(), _ContexteFournisseur.getContexteTechnique().getJeuDonnees());
    ConfigurationLog configLog = getConfigurationLog();
    ConfigurationClientAsynchrone configClient = new ConfigurationClientAsynchrone(confASync, configLog, configXMLJava);
    return configClient;
  }
  
  protected ContexteTechniqueFlux getContexteTechniqueFlux()
    throws TechniqueException
  {
    ContexteTechniqueFlux contexteTechnique = new ContexteTechniqueFlux(_ContexteFournisseur.getContexteTechnique().getEnvironnement(), _ContexteFournisseur.getContexteTechnique().getJeuDonnees(), null, null);
    return contexteTechnique;
  }
  
  protected ContexteApplicatifFluxPourDomaine getContexteApplicatifFlux(String pDomaine, String pServiceEmetteur, String pIdImplementation, String pNomFlux)
    throws TechniqueException
  {
    fr.unedic.archi.logique.client.contexte.Utilisateur utilisateurClient = getUtilisateur();
    ContexteApplicatifFluxPourDomaine contexteApplicatif = new ContexteApplicatifFluxPourDomaine(pDomaine, pServiceEmetteur, pIdImplementation, pNomFlux, utilisateurClient);
    return contexteApplicatif;
  }
  
  @Deprecated
  protected ContexteApplicatifFluxPourDomaine getContexteApplicatifFlux(String pDomaine, String pIdImplementation, String pNomFlux)
    throws TechniqueException
  {
    fr.unedic.archi.logique.client.contexte.Utilisateur utilisateurClient = getUtilisateur();
    ContexteApplicatifFluxPourDomaine contexteApplicatif = new ContexteApplicatifFluxPourDomaine(pDomaine, pIdImplementation, pNomFlux, utilisateurClient);
    return contexteApplicatif;
  }
  
  protected fr.unedic.archi.logique.client.contexte.Utilisateur getUtilisateur()
    throws TechniqueException
  {
    fr.unedic.archi.logique.contexte.Utilisateur utilisateurDomaine = ContexteFournisseur.getContexteApplicatif().getUtilisateur();
    fr.unedic.archi.logique.client.contexte.Utilisateur utilisateurClient = new fr.unedic.archi.logique.client.contexte.Utilisateur(utilisateurDomaine.getIdentifiant(), utilisateurDomaine.getCodeTerritoire(), utilisateurDomaine.getNiveauCompetence(), utilisateurDomaine.getIdracf(), utilisateurDomaine.getIdentifiantContrix());
    return utilisateurClient;
  }
  
  protected fr.unedic.archi.logique.client.contexte.ContexteEvenement getContexteEvenement(String pDomaine)
    throws TechniqueException
  {
    EvenementInfoTechnique infoTech = new EvenementInfoTechnique(_ContexteFournisseur.getContexteEvenement().getIdentifiantCorrelation(), _ContexteFournisseur.getContexteEvenement().getModeSollicitation());
    
    EvenementInfoApplicatif infoApp = new EvenementInfoApplicatif(_ContexteFournisseur.getContexteEvenement().getApplicationEmettrice(), _ContexteFournisseur.getContexteEvenement().getProcessusEmetteur(), _ContexteFournisseur.getContexteEvenement().getFonctionEmettrice(), pDomaine, ContexteFournisseur.getContexteApplicatif().getService(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    
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
  
  protected ConfigurationLog getConfigurationLog()
    throws TechniqueException
  {
    Log log = null;
    PropertiesContext logCtx = _ContexteFournisseur.getContexteDeploiement().getProperties().getUniqueSubContext("logging");
    if (logCtx != null) {
      log = new Log4JLogger(logCtx.getAttribute("xml-configFile"));
    }
    ConfigurationLog configLog = new ConfigurationLog(null, log);
    return configLog;
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
}

/* Location:
 * Qualified Name:     AbstractManagerFluxCaliGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */