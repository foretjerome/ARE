package fr.unedic.cali.outilsfonctionnels;

import fr.pe.cali.client.ManagerAppelsServicesD10;
import fr.pe.d10.service.cg.es.Affectation;
import fr.pe.d10.service.cg.es.ConvGestion;
import fr.pe.d10.service.cg.es.CriteresLireConventionGestion;
import fr.pe.d10.service.cg.es.EtablissementFinanceur;
import fr.pe.d10.service.cg.es.ListeAffectation;
import fr.pe.d10.service.cg.es.ListePrestOptionnelles;
import fr.pe.d10.service.cg.es.OptionsReglementaires;
import fr.pe.d10.service.cg.es.PrestationsOptionnelles;
import fr.pe.d10.service.cg.es.RetourLireConventionGestion;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.ConteneurConventionGestion;
import fr.unedic.cali.dom.ConventionGestion;
import fr.unedic.cali.dom.spec.ConventionGestionSpec;
import fr.unedic.cali.utilitaire.outils.OutilBouchon;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OutilConventionGestion
  implements OutilFonctionnel
{
  private static OutilConventionGestion s_instance;
  private static Map<String, ConventionGestion> mapConventionGestion = new HashMap();
  private static final Damj DATE_CONVENTION_GESTION = new Damj(2011, 10, 1);
  
  public static OutilConventionGestion getInstance()
  {
    if (s_instance == null)
    {
      s_instance = new OutilConventionGestion();
      initInstance();
    }
    return s_instance;
  }
  
  private static void initInstance()
  {
    mapConventionGestion.put("1110DEFMIL146005", new ConventionGestion("1110DEFMIL", "146005", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel militaire", false));
    
    mapConventionGestion.put("1110DEFMIL178011", new ConventionGestion("1110DEFMIL", "178011", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel militaire", false));
    
    mapConventionGestion.put("1110DEFMIL178021", new ConventionGestion("1110DEFMIL", "178021", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel militaire", false));
    
    mapConventionGestion.put("1110DEFMIL178031", new ConventionGestion("1110DEFMIL", "178031", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel militaire", false));
    
    mapConventionGestion.put("1110DEFMIL178064", new ConventionGestion("1110DEFMIL", "178064", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel militaire", false));
    
    mapConventionGestion.put("1110DEFCI1146005", new ConventionGestion("1110DEFCI1", "146005", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel civil restructuré", false));
    
    mapConventionGestion.put("1110DEFCI1178011", new ConventionGestion("1110DEFCI1", "178011", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel civil restructuré", false));
    
    mapConventionGestion.put("1110DEFCI1178021", new ConventionGestion("1110DEFCI1", "178021", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel civil restructuré", false));
    
    mapConventionGestion.put("1110DEFCI1178031", new ConventionGestion("1110DEFCI1", "178031", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel civil restructuré", false));
    
    mapConventionGestion.put("1110DEFCI1178064", new ConventionGestion("1110DEFCI1", "178064", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel civil restructuré", false));
    
    mapConventionGestion.put("1110DEFCI1178068", new ConventionGestion("1110DEFCI1", "178068", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel civil restructuré", false));
    
    mapConventionGestion.put("1110DEFCI1212077", new ConventionGestion("1110DEFCI1", "212077", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel civil restructuré", false));
    
    mapConventionGestion.put("1110DEFCI2146005", new ConventionGestion("1110DEFCI2", "146005", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel civil non restructuré", false));
    
    mapConventionGestion.put("1110DEFCI2178011", new ConventionGestion("1110DEFCI2", "178011", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel civil non restructuré", false));
    
    mapConventionGestion.put("1110DEFCI2178021", new ConventionGestion("1110DEFCI2", "178021", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel civil non restructuré", false));
    
    mapConventionGestion.put("1110DEFCI2178031", new ConventionGestion("1110DEFCI2", "178031", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel civil non restructuré", false));
    
    mapConventionGestion.put("1110DEFCI2178064", new ConventionGestion("1110DEFCI2", "178064", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel civil non restructuré", false));
    
    mapConventionGestion.put("1110DEFCI2178068", new ConventionGestion("1110DEFCI2", "178068", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel civil non restructuré", false));
    
    mapConventionGestion.put("1110DEFCI2212077", new ConventionGestion("1110DEFCI2", "212077", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "Ministère de la Défense - Personnel civil non restructuré", false));
    
    mapConventionGestion.put("0123456789123456", new ConventionGestion("0123456789", "123456", true, true, true, true, true, "2", false, DATE_CONVENTION_GESTION, null, "Test - test", false));
    
    mapConventionGestion.put("1401EPEIRC000000", new ConventionGestion("1401EPEIRC", "000000", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "PE sans prélèvement PCRC", false));
    
    mapConventionGestion.put("1401EPEAAR000000", new ConventionGestion("1401EPEAAR", "000000", true, true, false, false, false, "2", false, DATE_CONVENTION_GESTION, null, "PE avec prélèvement PCRC", false));
  }
  
  public Collection<?> getListeConventionGestion()
  {
    return mapConventionGestion.values();
  }
  
  public ConventionGestionSpec trouverConventionGestion(ConteneurConventionGestion conteneurConventionGestion)
    throws CoucheLogiqueException
  {
    String numeroConventionGestion = conteneurConventionGestion.getNumeroConventionGestion();
    String codeAffectation = conteneurConventionGestion.getCodeAffectation();
    String donneePourBouchon = conteneurConventionGestion.getDonneePourBouchon();
    Damj dateAppel = conteneurConventionGestion.getDateAppel();
    
    ConventionGestionSpec conventionGestion = null;
    if (OutilBouchon.appliqueComportement(donneePourBouchon, "CG_ancienOF"))
    {
      String cle = numeroConventionGestion;
      if (codeAffectation != null) {
        cle = cle + codeAffectation.toUpperCase();
      }
      Object objet = mapConventionGestion.get(cle);
      conventionGestion = (ConventionGestionSpec)objet;
    }
    else
    {
      ManagerAppelsServicesD10 domaineCaro = null;
      RetourLireConventionGestion retourLireConventionGestion;
      try
      {
        domaineCaro = new ManagerAppelsServicesD10();
        
        CriteresLireConventionGestion criteresLireConventionGestion = CriteresLireConventionGestion.getInstance();
        TracesBouchon.ecrireTrace("utiliser la ligne en commentaire");
        
        criteresLireConventionGestion.setCasUtilisation(new BigDecimal("2"));
        criteresLireConventionGestion.setDateRecherche(dateAppel);
        criteresLireConventionGestion.setNumeroCG(numeroConventionGestion);
        
        retourLireConventionGestion = domaineCaro.lireConventionGestion(criteresLireConventionGestion);
        if (retourLireConventionGestion.getConventionGestion() == null) {
          GestionnaireErreur.getInstance().genererCoucheLogiqueException("PR_CALI_OBJET_NON_TROUVEE", new Object[] { "le code" + numeroConventionGestion + " de l'établissement financeur" });
        }
      }
      catch (ApplicativeException e)
      {
        OutilTrace.ecrireTrace(Niveau.ERROR, new String[] { "Exception levée lors de l'appel de CARO" }, e);
        throw new ApplicativeRuntimeException(e.getCode(), e.getMessage(), e);
      }
      catch (TechniqueException ex)
      {
        OutilTrace.ecrireTrace(Niveau.ERROR, new String[] { "Exception levée lors de l'appel de CARO" }, ex);
        throw new ApplicativeRuntimeException(ex.getCode(), ex.getMessage(), ex);
      }
      if (codeAffectation == null) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_N_CALI_CONVENTION_GESTION_INEXISTANTE");
      }
      conventionGestion = alimenterRetourService(retourLireConventionGestion, codeAffectation);
    }
    return conventionGestion;
  }
  
  private ConventionGestion alimenterRetourService(RetourLireConventionGestion retourLireConventionGestion, String codeAffectation)
  {
    EtablissementFinanceur etablissementFinanceur = retourLireConventionGestion.getConventionGestion().getEtablissementFinanceur();
    
    OptionsReglementaires optionsReglementaires = etablissementFinanceur.getOptionsReglementairesEF();
    String numeroConventionGestion = retourLireConventionGestion.getConventionGestion().getNumeroCG() + etablissementFinanceur.getCode();
    ListeAffectation listeAffectation = etablissementFinanceur.getListeAffectation();
    boolean estCodeAffectationTrouve = false;
    boolean estAideArce = false;
    boolean estAideAdr = false;
    boolean estAideCongeNonPaye = false;
    boolean estAideFinDroit = false;
    boolean estAideAllocationDeces = false;
    if (listeAffectation != null) {
      for (int i = 0; i < listeAffectation.getNbListeAffectation(); i++)
      {
        Affectation affectation = listeAffectation.getListeAffectation(i);
        if (codeAffectation.equals(affectation.getCode())) {
          estCodeAffectationTrouve = true;
        }
      }
    }
    if (!estCodeAffectationTrouve) {
      return null;
    }
    Boolean estCrc = new Boolean(etablissementFinanceur.getOptionsReglementairesEF().getCrc().booleanValue());
    Damj dateDebutValidite = etablissementFinanceur.getDateDebutValidite();
    Damj dateFinValidite = etablissementFinanceur.getDateFinValidite();
    String libelleEtablissementFinanceur = etablissementFinanceur.getLibelle();
    ListePrestOptionnelles listePrestationOptionnelles = optionsReglementaires.getListePrestOptionnelles();
    boolean idExterneObligatoire = etablissementFinanceur.getIdExterneObligatoire().booleanValue();
    if (listePrestationOptionnelles != null) {
      for (int i = 0; i < listePrestationOptionnelles.getNbListePrestOptionnelles(); i++)
      {
        PrestationsOptionnelles prestationsOptionnelles = listePrestationOptionnelles.getListePrestOptionnelles(i);
        String code = prestationsOptionnelles.getCode();
        TracesBouchon.ecrireTrace("utiliser PrestationsOptionnellesEnumeration.E_O01.getValeur() lorsque le bug framework sera résolu");
        if ("O01".equals(code)) {
          estAideArce = prestationsOptionnelles.getValeur().booleanValue();
        } else if ("O02".equals(code)) {
          estAideAdr = prestationsOptionnelles.getValeur().booleanValue();
        } else if ("O03".equals(code)) {
          estAideCongeNonPaye = prestationsOptionnelles.getValeur().booleanValue();
        } else if ("O04".equals(code)) {
          estAideFinDroit = prestationsOptionnelles.getValeur().booleanValue();
        } else if ("O05".equals(code)) {
          estAideAllocationDeces = prestationsOptionnelles.getValeur().booleanValue();
        }
      }
    }
    return new ConventionGestion(numeroConventionGestion, codeAffectation, estAideArce, estAideAdr, estAideCongeNonPaye, estAideFinDroit, estAideAllocationDeces, "2", estCrc.equals(Boolean.TRUE), dateDebutValidite, dateFinValidite, libelleEtablissementFinanceur, idExterneObligatoire);
  }
  
  public static boolean estTypeConventionGestionEtSignataireUnedic(String numeroConventionGestion, boolean estSignataireUnedic, ConventionGestionSpec conventionGestion)
  {
    boolean retour = true;
    if ((conventionGestion == null) || (!numeroConventionGestion.equals(conventionGestion.getNumeroConventionGestion())) || (conventionGestion.getSignataire() == null) || (conventionGestion.getSignataire().equals("1") != estSignataireUnedic)) {
      retour = false;
    }
    return retour;
  }
  
  public static boolean estConventionGestionFraisReel(ConventionGestionSpec conventionGestion)
  {
    return (conventionGestion != null) && (conventionGestion.getSignataire() != null) && (conventionGestion.getSignataire().equals("2"));
  }
  
  public String recupererNumeroConvention(ConventionGestionSpec conventionGestion)
  {
    String numeroConvention = null;
    if (conventionGestion != null) {
      numeroConvention = conventionGestion.getNumeroConventionGestion();
    }
    return numeroConvention;
  }
  
  public static String recupererSignataire(ConventionGestionSpec conventionGestion)
  {
    String signataire = null;
    if (conventionGestion != null) {
      signataire = conventionGestion.getSignataire();
    }
    return signataire;
  }
  
  public static boolean estConventionSansAide(ConventionGestionSpec conventionGestion)
  {
    boolean retour = false;
    if (conventionGestion != null)
    {
      String applicationAides = conventionGestion.getApplicationAides();
      retour = "01".equals(applicationAides);
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     OutilConventionGestion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */