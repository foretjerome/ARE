package fr.unedic.cali.dom.persistance.util;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.persistance.GestionnairePersistance;
import fr.unedic.archi.logique.persistance.Requete;
import fr.unedic.cali.calcul.pbjc.dom.AideNcp;
import fr.unedic.cali.calcul.pbjc.dom.DispositifNcp;
import fr.unedic.cali.calcul.pbjc.dom.DroitPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.EnquetePbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PrimePbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.pc.AideNcpPC;
import fr.unedic.cali.calcul.pbjc.dom.pc.DispositifNcpPC;
import fr.unedic.cali.calcul.pbjc.dom.pc.DroitPbjcNcpPC;
import fr.unedic.cali.calcul.pbjc.dom.pc.EnquetePbjcNcpPC;
import fr.unedic.cali.calcul.pbjc.dom.pc.IndividuPbjcNcpPC;
import fr.unedic.cali.calcul.pbjc.dom.pc.PbjcNcpPC;
import fr.unedic.cali.calcul.pbjc.dom.pc.PrimePbjcNcpPC;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuId;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.cali.dom.IndividuImplPersistant;
import fr.unedic.cali.dom.IndividuPersistant;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.TestProduction;
import fr.unedic.cali.dom.pc.IndividuImplPersistantPC;
import fr.unedic.cali.dom.pc.TestProductionPC;
import fr.unedic.cali.dom.pivot.Decision;
import fr.unedic.cali.dom.pivot.DemandePivot;
import fr.unedic.cali.dom.pivot.pc.DemandePivotPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.jdo.JDOHelper;

public class DomManager
{
  private static final String REQUETE_GET_INDIVIDU = "getIndividu";
  private static final String REQUETE_GET_PBJCNCP = "getPbjcNcp";
  private static final String REQUETE_GET_AIDENCP = "getAideNcp";
  private static final String REQUETE_GET_INDIVIDUPBJCNCP = "getIndividuPbjcNcp";
  private static final String REQUETE_GET_DROITPBJCNCP = "getDroitPbjcNcp";
  private static final String REQUETE_GET_LISTEDROITPBJCNCP = "getListeDroitPbjcNcp";
  private static final String REQUETE_GET_ENQUETEPBJCNCPADATE = "getEnquetePbjcNcpADate";
  private static final String REQUETE_GET_LISTEENQUETEPBJC = "getListeEnquetePbjcNcp";
  private static final String REQUETE_GET_PRIMESPBJCNCP = "getPrimesPbjcNcp";
  private static final String REQUETE_GET_TEST_PRODUCTION = "getTestProduction";
  private static final String REQUETE_GET_ECHANGES_PAR_DEMANDE = "getEchangesParDemande";
  private static final String REQUETE_GET_PRIMESPBJCNCP_PAR_DATES_DEBUT_FIN = "getPrimesPbjcNcpParDatesDebutEtFin";
  private static final String REQUETE_GET_DISPOSITIF = "getDispositifsNCP";
  private static final String REQUETE_GET_DECISION_PIVOT = "getDecisionsPivot";
  public static final String REQUETE_GET_DEMANDE_ASU_REFEX = "getDemandeAsuParRefext";
  public static final String REQUETE_GET_DEMANDE_ARI_ID = "getDemandeAriParId";
  public static final String REQUETE_GET_DEMANDES_PIVOT = "getDemandesPivot";
  
  public static String getIdentifiant(Object objetPersistant)
  {
    if ((objetPersistant instanceof DomGenSpec)) {
      objetPersistant = ((DomGenSpec)objetPersistant).getPC();
    }
    String id = "";
    if (!JDOHelper.isPersistent(objetPersistant))
    {
      id = String.valueOf(objetPersistant.hashCode());
    }
    else
    {
      GestionnairePersistance gestionnaire = null;
      try
      {
        if (JDOHelper.isPersistent(objetPersistant))
        {
          gestionnaire = ContextePersistance.getGestionnairePersistance();
          return gestionnaire.getIdentifiantCourt(objetPersistant);
        }
      }
      catch (TechniqueException e)
      {
        return null;
      }
    }
    return id;
  }
  
  public static String getIdentifiant(DomGenSpec objetMetier)
  {
    return getIdentifiant(objetMetier.getPC());
  }
  
  public static void ajouteReference(DomPCSpec objetParentPC, DomPCSpec referencePC)
  {
    try
    {
      GestionnairePersistance gestionnaire = ContextePersistance.getGestionnairePersistance();
      if (((objetParentPC instanceof IndividuImplPersistantPC)) && (!JDOHelper.isPersistent(objetParentPC))) {
        gestionnaire.rendrePersistant((IndividuImplPersistantPC)objetParentPC);
      }
      if (JDOHelper.isPersistent(objetParentPC)) {
        gestionnaire.rendrePersistant(referencePC);
      }
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : ajouteReference()", e);
    }
  }
  
  public static void persisterObjet(ObjetPersistantSpec objetPersistant)
  {
    if (objetPersistant != null) {
      try
      {
        GestionnairePersistance gestionnaire = ContextePersistance.getGestionnairePersistance();
        if ((objetPersistant instanceof DomGenSpec)) {
          gestionnaire.rendrePersistant(((DomGenSpec)objetPersistant).getPC());
        } else {
          gestionnaire.rendrePersistant(objetPersistant);
        }
      }
      catch (TechniqueException ex)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_PERSISTANCE", "Erreur d'accès aux données" + objetPersistant.getClass() + objetPersistant.getIdentifiant(), ex);
      }
    }
  }
  
  public static void persisterEnProfondeur(ObjetPersistantSpec objetMetierPersistant)
  {
    if ((objetMetierPersistant instanceof DomGenSpec))
    {
      DomGenSpec objetMetierNonPC = (DomGenSpec)objetMetierPersistant;
      DomPCSpec objetPC = objetMetierNonPC.getPC();
      persisterEnProfondeur((ObjetPersistantSpec)objetMetierNonPC, objetPC);
    }
    else
    {
      persisterEnProfondeur(objetMetierPersistant, objetMetierPersistant);
    }
  }
  
  public static void persisterEnProfondeur(ObjetPersistantSpec objetMetierPersistant, Object objetPersistant)
  {
    if (objetMetierPersistant != null) {
      try
      {
        GestionnairePersistance gestionnaire = ContextePersistance.getGestionnairePersistance();
        if (!JDOHelper.isDeleted(objetPersistant))
        {
          gestionnaire.rendrePersistant(objetPersistant);
          objetMetierPersistant.marquerGraphePersistant();
        }
      }
      catch (TechniqueException ex)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_PERSISTANCE", "Erreur d'accès aux données" + objetMetierPersistant.getClass() + objetMetierPersistant.getIdentifiant(), ex);
      }
    }
  }
  
  public static void persisterEnProfondeur(Collection listeObjetsPersistants)
  {
    if ((listeObjetsPersistants != null) && (!listeObjetsPersistants.isEmpty()))
    {
      Iterator iter = listeObjetsPersistants.iterator();
      while (iter.hasNext()) {
        persisterEnProfondeur((ObjetPersistantSpec)iter.next());
      }
    }
  }
  
  public static void persisterEnProfondeur(Chronologie chronoObjetsPersistants)
  {
    if ((chronoObjetsPersistants != null) && (chronoObjetsPersistants.getTaille() > 0))
    {
      Iterator iter = chronoObjetsPersistants.iterer();
      while (iter.hasNext()) {
        persisterEnProfondeur((ObjetPersistantSpec)iter.next());
      }
    }
  }
  
  public static void supprimer(Object objet)
  {
    if ((objet instanceof DomPCSpec)) {
      supprimer((DomPCSpec)objet);
    } else if ((objet instanceof ObjetPersistantSpec)) {
      supprimer((ObjetPersistantSpec)objet, new ContexteSuppressionEnProfondeur());
    }
  }
  
  public static void supprimer(Object objet, ContexteSuppressionEnProfondeur contexteSuppression)
  {
    if ((objet instanceof DomPCSpec)) {
      supprimer((DomPCSpec)objet);
    } else if ((objet instanceof ObjetPersistantSpec)) {
      supprimer((ObjetPersistantSpec)objet, contexteSuppression);
    }
  }
  
  public static void supprimer(DomPCSpec objetPC)
  {
    GestionnairePersistance gestionnaire = null;
    try
    {
      if (JDOHelper.isPersistent(objetPC))
      {
        gestionnaire = ContextePersistance.getGestionnairePersistance();
        gestionnaire.supprimerPersistant(objetPC);
      }
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_SUPPRESSION", "Erreur lors de la suppresion de l'objet : " + objetPC.getClass(), e);
    }
  }
  
  private static void supprimer(ObjetPersistantSpec objetMetierPersistant, ContexteSuppressionEnProfondeur contexteSuppression)
  {
    if ((objetMetierPersistant instanceof DomGenSpec))
    {
      DomGenSpec objetMetierNonPC = (DomGenSpec)objetMetierPersistant;
      DomPCSpec objetPC = objetMetierNonPC.getPC();
      try
      {
        objetMetierNonPC.supprimerEnProfondeur(contexteSuppression);
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_SUPPRESSION", "Erreur suppression en profondeur modele Sumatra DomGen/DomPC" + objetMetierNonPC.getClass(), e);
      }
      supprimer((ObjetPersistantSpec)objetMetierNonPC, objetPC);
    }
    else
    {
      supprimer(objetMetierPersistant, objetMetierPersistant, contexteSuppression);
    }
  }
  
  private static void supprimer(ObjetPersistantSpec objetMetierPersistant, Object objetPersistant)
  {
    GestionnairePersistance gestionnaire = null;
    try
    {
      if (JDOHelper.isPersistent(objetPersistant))
      {
        gestionnaire = ContextePersistance.getGestionnairePersistance();
        gestionnaire.supprimerPersistant(objetPersistant);
      }
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_SUPPRESSION", "Erreur lors de la suppresion de l'objet : " + objetPersistant.getClass() + objetMetierPersistant.getIdentifiant(), e);
    }
  }
  
  public static void supprimerAbsolument(ObjetPersistantSpec objetMetierPersistant)
  {
    if ((objetMetierPersistant instanceof DomGenSpec))
    {
      DomGenSpec objetMetierNonPC = (DomGenSpec)objetMetierPersistant;
      DomPCSpec objetPC = objetMetierNonPC.getPC();
      supprimerAbsolument((ObjetPersistantSpec)objetMetierNonPC, objetPC);
    }
    else
    {
      supprimerAbsolument(objetMetierPersistant, objetMetierPersistant);
    }
  }
  
  private static void supprimerAbsolument(ObjetPersistantSpec objetMetierPersistant, Object objetPersistant)
  {
    supprimer(objetMetierPersistant, new ContexteSuppressionEnProfondeur());
  }
  
  private static void supprimer(ObjetPersistantSpec objetMetierPersistantASupprimer, ObjetPersistantSpec objetPersistantACreer, ContexteSuppressionEnProfondeur contexteSuppression)
  {
    if ((objetMetierPersistantASupprimer instanceof DomGenSpec))
    {
      DomGenSpec objetMetierNonPCASupprimer = (DomGenSpec)objetMetierPersistantASupprimer;
      DomPCSpec objetPCASupprimer = objetMetierNonPCASupprimer.getPC();
      supprimer((ObjetPersistantSpec)objetMetierNonPCASupprimer, objetPCASupprimer, objetPersistantACreer, contexteSuppression);
    }
    else
    {
      supprimer(objetMetierPersistantASupprimer, objetMetierPersistantASupprimer, objetPersistantACreer, contexteSuppression);
    }
  }
  
  public static void supprimer(ObjetPersistantSpec objetMetierPersistantASupprimer, ObjetPersistantSpec objetPersistantACreer)
  {
    supprimer(objetMetierPersistantASupprimer, objetPersistantACreer, new ContexteSuppressionEnProfondeur());
  }
  
  private static void supprimer(ObjetPersistantSpec objetMetierASupprimer, Object objetPersistantASupprimer, ObjetPersistantSpec objetMetierPersistantACreer, ContexteSuppressionEnProfondeur contexteSuppression)
  {
    try
    {
      boolean condition1 = (objetMetierASupprimer != null) && (objetMetierPersistantACreer != null) && (!objetMetierASupprimer.getIdentifiant().equalsIgnoreCase(objetMetierPersistantACreer.getIdentifiant()));
      
      boolean condition2 = (objetMetierPersistantACreer == null) && (objetMetierASupprimer != null);
      if ((condition1) || (condition2))
      {
        if ((objetMetierASupprimer instanceof DomGenSpec)) {
          ((DomGenSpec)objetMetierASupprimer).supprimerEnProfondeur(contexteSuppression);
        }
        supprimer(objetMetierASupprimer, objetPersistantASupprimer);
      }
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_SUPPRESSION", "Erreur lors de la suppresion de l'objet : " + objetMetierASupprimer.getClass() + objetMetierASupprimer.getIdentifiant(), e);
    }
  }
  
  public static void supprimer(Collection collectionASupprimer)
  {
    if (collectionASupprimer != null)
    {
      Iterator iter = collectionASupprimer.iterator();
      while (iter.hasNext()) {
        supprimer((ObjetPersistantSpec)iter.next());
      }
      collectionASupprimer.clear();
    }
  }
  
  public static IndividuIdSpec getIndividuId()
  {
    try
    {
      GestionnairePersistance gestionnaire = ContextePersistance.getGestionnairePersistance();
      return new IndividuId((Long)gestionnaire.getObjetFonctionnel("numalloc"));
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getIndividu()", e);
    }
  }
  
  public static Individu getIndividu()
  {
    IndividuPersistant individuRetourne = null;
    IndividuImplPersistant individuTrouve = null;
    
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      
      requete = gestionnaire.getRequete("getIndividu", IndividuImplPersistant.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      
      Collection ans = (Collection)requete.executer(parameters);
      Iterator i = ans.iterator();
      if (i.hasNext()) {
        individuTrouve = (IndividuImplPersistant)i.next();
      }
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getIndividu()", e);
      }
      if (individuTrouve == null) {
        return individuRetourne;
      }
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getIndividu()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getIndividu()", e);
      }
    }
    if (individuTrouve.getIndividuId().getIndividu() == null)
    {
      individuRetourne = new IndividuPersistant();
      individuRetourne.fabricationIndividu(individuTrouve);
      
      ChronologieDebuts collectionDemandes = individuRetourne.getChronoDemandeAssurance();
      Iterator iterDemande = collectionDemandes.iterer();
      while (iterDemande.hasNext()) {
        ((DemandeSpec)iterDemande.next()).setDemandeur(individuRetourne);
      }
    }
    else
    {
      individuRetourne = (IndividuPersistant)individuTrouve.getIndividuId().getIndividu();
    }
    return individuRetourne;
  }
  
  public static IndividuImplPersistant getIndividuCali()
    throws TechniqueException
  {
    IndividuImplPersistant individuTrouve = null;
    
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    
    gestionnaire = ContextePersistance.getGestionnairePersistance();
    
    requete = gestionnaire.getRequete("getIndividu", IndividuImplPersistantPC.class);
    
    Map parameters = new HashMap();
    String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
    Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
    parameters.put("numassedic", as);
    parameters.put("numalloc", al);
    
    Collection ans = (Collection)requete.executer(parameters);
    Iterator i = ans.iterator();
    if (i.hasNext())
    {
      IndividuImplPersistantPC individuPC = (IndividuImplPersistantPC)i.next();
      individuTrouve = (IndividuImplPersistant)individuPC.createOM();
    }
    return individuTrouve;
  }
  
  public static ChronologiePeriodes getChronologiePbjcNcp()
  {
    chronoPBJCs = new ChronologiePeriodes();
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    
    Damj dateDebutPbjc = null;
    Damj dateFinPbjc = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      
      requete = gestionnaire.getRequete("getPbjcNcp", PbjcNcpPC.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      parameters.put("dateDebut", Damj.NUIT_DES_TEMPS);
      Collection ans = (Collection)requete.executer(parameters);
      
      Iterator iterator = ans.iterator();
      while (iterator.hasNext())
      {
        PbjcNcpPC pbjcPC = (PbjcNcpPC)iterator.next();
        PbjcNcp pbjcNcp = (PbjcNcp)pbjcPC.createOM();
        
        dateDebutPbjc = pbjcNcp.getDateDebutPbjc();
        dateFinPbjc = pbjcNcp.getDateFinPbjc();
        pbjcNcp.setDateDebutTrans(dateDebutPbjc);
        pbjcNcp.setDateFinTrans(dateFinPbjc);
        
        chronoPBJCs.ajouter(pbjcNcp);
      }
      return chronoPBJCs;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getChronologiePbjcNcp()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getChronologiePbjcNcp()", e);
      }
    }
  }
  
  public static ChronologiePeriodes getChronologieAideNcp()
  {
    chronoAIDEs = new ChronologiePeriodes();
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    
    Damj dateDebutAide = null;
    Damj dateFinAide = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      
      requete = gestionnaire.getRequete("getAideNcp", AideNcpPC.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      parameters.put("dateDebut", Damj.NUIT_DES_TEMPS);
      Collection ans = (Collection)requete.executer(parameters);
      
      Iterator iterator = ans.iterator();
      while (iterator.hasNext())
      {
        AideNcpPC aidePC = (AideNcpPC)iterator.next();
        AideNcp aideNcp = (AideNcp)aidePC.createOM();
        
        dateDebutAide = aideNcp.getDateDebutAide();
        dateFinAide = aideNcp.getDateFinAide();
        aideNcp.setDateDebut(dateDebutAide);
        aideNcp.setDateFin(dateFinAide);
        
        chronoAIDEs.ajouter(aideNcp);
      }
      return chronoAIDEs;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getChronologieAideNcp()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getChronologieAideNcp()", e);
      }
    }
  }
  
  public static Collection<DispositifNcp> getCollectionDispositifNcp()
  {
    collDispositifs = new ArrayList();
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      
      requete = gestionnaire.getRequete("getDispositifsNCP", DispositifNcpPC.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      parameters.put("dateDebut", Damj.NUIT_DES_TEMPS);
      Collection ans = (Collection)requete.executer(parameters);
      
      Iterator iterator = ans.iterator();
      while (iterator.hasNext())
      {
        DispositifNcpPC dispositifPbjcNcpPC = (DispositifNcpPC)iterator.next();
        DispositifNcp dispositifPbjcNcp = (DispositifNcp)dispositifPbjcNcpPC.createOM();
        collDispositifs.add(dispositifPbjcNcp);
      }
      return collDispositifs;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getChronologieDispositifNcp()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getChronologieDispositifNcp()", e);
      }
    }
  }
  
  public static Collection<AideNcp> getCollectionAidesNcp(Damj dateDebut)
  {
    collectionAides = new ArrayList();
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      
      requete = gestionnaire.getRequete("getAideNcp", AideNcpPC.class);
      
      Map<String, Object> parameters = new HashMap();
      String as = (String)gestionnaire.getValeurPartitionnement("numassedic");
      Long al = (Long)gestionnaire.getValeurPartitionnement("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      parameters.put("dateDebut", Damj.NUIT_DES_TEMPS);
      Collection ans = (Collection)requete.executer(parameters);
      
      Iterator iterator = ans.iterator();
      while (iterator.hasNext())
      {
        AideNcpPC aideNcpPC = (AideNcpPC)iterator.next();
        AideNcp aideNcp = (AideNcp)aideNcpPC.createOM();
        collectionAides.add(aideNcp);
        
        aideNcp.setDateDebut(aideNcp.getDateDebutAide());
        aideNcp.setDateFin(aideNcp.getDateFinAide());
      }
      return collectionAides;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getCollectionAidesNcp()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getCollectionAidesNcp()", e);
      }
    }
  }
  
  public static ChronologiePeriodes getChronologiePbjcNcpOccasionnel(Damj dateDebut)
  {
    chronoPBJCs = new ChronologiePeriodes();
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    
    Damj dateDebutPbjc = null;
    Damj dateFinPbjc = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      
      requete = gestionnaire.getRequete("getPbjcNcp", PbjcNcpPC.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      parameters.put("dateDebut", dateDebut);
      Collection ans = (Collection)requete.executer(parameters);
      
      Iterator iterator = ans.iterator();
      while (iterator.hasNext())
      {
        PbjcNcpPC pbjcPC = (PbjcNcpPC)iterator.next();
        PbjcNcp pbjcNcp = (PbjcNcp)pbjcPC.createOM();
        
        dateDebutPbjc = pbjcNcp.getDateDebutPbjc();
        dateFinPbjc = pbjcNcp.getDateFinPbjc();
        pbjcNcp.setDateDebutPbjc(dateDebutPbjc);
        pbjcNcp.setDateFinPbjc(dateFinPbjc);
        
        chronoPBJCs.ajouter(pbjcNcp);
      }
      return chronoPBJCs;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getChronologiePbjcNcp()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getChronologiePbjcNcp()", e);
      }
    }
  }
  
  public static IndividuPbjcNcp getIndividuPbjcNcp()
  {
    individuTrouve = null;
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      requete = gestionnaire.getRequete("getIndividuPbjcNcp", IndividuPbjcNcpPC.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      Collection ans = (Collection)requete.executer(parameters);
      
      Iterator i = ans.iterator();
      IndividuPbjcNcpPC individuPbjcNcpPC;
      if (i.hasNext()) {
        individuPbjcNcpPC = (IndividuPbjcNcpPC)i.next();
      }
      return (IndividuPbjcNcp)individuPbjcNcpPC.createOM();
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getIndividuPbjcNcp()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getIndividuPbjcNcp()", e);
      }
    }
  }
  
  public static DroitPbjcNcp getDroitPbjcNcp(int identifiantOuvertureDroit)
  {
    droitTrouve = null;
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      requete = gestionnaire.getRequete("getDroitPbjcNcp", DroitPbjcNcpPC.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      parameters.put("identifiantRSOD", Integer.valueOf(identifiantOuvertureDroit));
      Collection ans = (Collection)requete.executer(parameters);
      
      Iterator i = ans.iterator();
      DroitPbjcNcpPC droitPbjcNcpPC;
      if (i.hasNext()) {
        droitPbjcNcpPC = (DroitPbjcNcpPC)i.next();
      }
      return (DroitPbjcNcp)droitPbjcNcpPC.createOM();
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getDroitPbjcNcp()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getDroitPbjcNcp()", e);
      }
    }
  }
  
  public static List getListDroitsPbjcNcp()
  {
    aRetourner = new ArrayList();
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      requete = gestionnaire.getRequete("getListeDroitPbjcNcp", DroitPbjcNcpPC.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      Collection ans = (Collection)requete.executer(parameters);
      
      Iterator i = ans.iterator();
      while (i.hasNext())
      {
        DroitPbjcNcpPC droitPbjcNcpPC = (DroitPbjcNcpPC)i.next();
        aRetourner.add((DroitPbjcNcp)droitPbjcNcpPC.createOM());
      }
      return aRetourner;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getListeDroitsPbjcNcp()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getListeDroitsPbjcNcp()", e);
      }
    }
  }
  
  public static List getListEnquetesPbjcNcp(Damj date)
  {
    aRetourner = new ArrayList();
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      requete = gestionnaire.getRequete("getEnquetePbjcNcpADate", EnquetePbjcNcpPC.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      parameters.put("dateDebut", date);
      Collection ans = (Collection)requete.executer(parameters);
      
      Iterator i = ans.iterator();
      while (i.hasNext())
      {
        EnquetePbjcNcpPC enquetePbjcNcpPC = (EnquetePbjcNcpPC)i.next();
        aRetourner.add((EnquetePbjcNcp)enquetePbjcNcpPC.createOM());
      }
      return aRetourner;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getListEnquetesPbjcNcp()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getListEnquetesPbjcNcp()", e);
      }
    }
  }
  
  public static List getListeEnquetesPbjcNcp()
  {
    aRetourner = new ArrayList();
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      requete = gestionnaire.getRequete("getListeEnquetePbjcNcp", EnquetePbjcNcpPC.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      Collection ans = (Collection)requete.executer(parameters);
      
      Iterator i = ans.iterator();
      while (i.hasNext())
      {
        EnquetePbjcNcpPC enquetePbjcNcpPC = (EnquetePbjcNcpPC)i.next();
        aRetourner.add((EnquetePbjcNcp)enquetePbjcNcpPC.createOM());
      }
      return aRetourner;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getListEnquetesPbjcNcp()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getListEnquetesPbjcNcp()", e);
      }
    }
  }
  
  public static Collection getCollectionPrimesPbjcNcp(Damj dateDebut)
  {
    collectionPrimes = new ArrayList();
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      
      requete = gestionnaire.getRequete("getPrimesPbjcNcp", PrimePbjcNcpPC.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      parameters.put("dateDebut", dateDebut);
      Collection ans = (Collection)requete.executer(parameters);
      
      Iterator iterator = ans.iterator();
      while (iterator.hasNext())
      {
        PrimePbjcNcpPC primePbjcNcpPC = (PrimePbjcNcpPC)iterator.next();
        PrimePbjcNcp primePbjcNcp = (PrimePbjcNcp)primePbjcNcpPC.createOM();
        collectionPrimes.add(primePbjcNcp);
      }
      return collectionPrimes;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getChronologiePrimesPbjcNcp()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getChronologiePrimesPbjcNcp()", e);
      }
    }
  }
  
  public static Collection getCollectionPrimesPbjcNcp()
  {
    collectionPrimes = new ArrayList();
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      
      requete = gestionnaire.getRequete("getPrimesPbjcNcp", PrimePbjcNcpPC.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      parameters.put("dateDebut", Damj.NUIT_DES_TEMPS);
      Collection ans = (Collection)requete.executer(parameters);
      
      Iterator iterator = ans.iterator();
      while (iterator.hasNext())
      {
        PrimePbjcNcpPC primePbjcNcpPC = (PrimePbjcNcpPC)iterator.next();
        PrimePbjcNcp primePbjcNcp = (PrimePbjcNcp)primePbjcNcpPC.createOM();
        collectionPrimes.add(primePbjcNcp);
      }
      return collectionPrimes;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getChronologiePrimesPbjcNcp()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getChronologiePrimesPbjcNcp()", e);
      }
    }
  }
  
  public static Collection getCollectionPrimesPbjcNcp(Damj dateDebut, Damj dateFin)
  {
    collectionPrimes = new ArrayList();
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      
      requete = gestionnaire.getRequete("getPrimesPbjcNcpParDatesDebutEtFin", PrimePbjcNcpPC.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      parameters.put("dateDebut", dateDebut);
      parameters.put("dateFin", dateFin);
      Collection ans = (Collection)requete.executer(parameters);
      
      Iterator iterator = ans.iterator();
      while (iterator.hasNext())
      {
        PrimePbjcNcpPC primePbjcNcpPC = (PrimePbjcNcpPC)iterator.next();
        PrimePbjcNcp primePbjcNcp = (PrimePbjcNcp)primePbjcNcpPC.createOM();
        collectionPrimes.add(primePbjcNcp);
      }
      return collectionPrimes;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getChronologiePrimesPbjcNcp()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getChronologiePrimesPbjcNcp()", e);
      }
    }
  }
  
  public static TestProduction getTestProduction(Damj date)
  {
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    testProduction = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      requete = gestionnaire.getRequete("getTestProduction", TestProductionPC.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      parameters.put("dateDebut", date);
      Collection ans = (Collection)requete.executer(parameters);
      
      Iterator i = ans.iterator();
      if (i.hasNext())
      {
        TestProductionPC testProductionPC = (TestProductionPC)i.next();
        return testProduction = (TestProduction)testProductionPC.createOM();
      }
      return testProduction;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getTestProduction()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getTestProduction()", e);
      }
    }
  }
  
  public static Map getEchangesParDemande(String refExterne)
  {
    mapTrieeEchanges = new TreeMap();
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      
      requete = gestionnaire.getRequete("getEchangesParDemande", fr.unedic.cali.dom.echange.pc.DecisionPC.class);
      
      Map parameters = new HashMap();
      String as = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long al = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", as);
      parameters.put("numalloc", al);
      parameters.put("referenceExterne", refExterne);
      Collection res = (Collection)requete.executer(parameters);
      
      Iterator iterator = res.iterator();
      while (iterator.hasNext())
      {
        fr.unedic.cali.dom.echange.pc.DecisionPC decisionPC = (fr.unedic.cali.dom.echange.pc.DecisionPC)iterator.next();
        mapTrieeEchanges.put(decisionPC.getIdentifiantEvenement(), decisionPC.createOM());
      }
      return mapTrieeEchanges;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getEchangesParDemande()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getEchangesParDemande()", e);
      }
    }
  }
  
  public static List<Decision> getDecisionsPivot()
  {
    listeDecisionsPivot = new ArrayList();
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      requete = gestionnaire.getRequete("getDecisionsPivot", fr.unedic.cali.dom.pivot.pc.DecisionPC.class);
      
      Map parameters = new HashMap();
      String cxass = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long cxala = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", cxass);
      parameters.put("numalloc", cxala);
      
      Collection res = (Collection)requete.executer(parameters);
      
      Iterator iterator = res.iterator();
      while (iterator.hasNext())
      {
        fr.unedic.cali.dom.pivot.pc.DecisionPC decisionPC = (fr.unedic.cali.dom.pivot.pc.DecisionPC)iterator.next();
        listeDecisionsPivot.add((Decision)decisionPC.createOM());
      }
      return listeDecisionsPivot;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getDecisionsPivot()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getDecisionsPivot()", e);
      }
    }
  }
  
  public static List<DemandePivot> getDemandesPivot()
  {
    listeDecisionsPivot = new ArrayList();
    GestionnairePersistance gestionnaire = null;
    Requete requete = null;
    try
    {
      gestionnaire = ContextePersistance.getGestionnairePersistance();
      requete = gestionnaire.getRequete("getDemandesPivot", DemandePivotPC.class);
      
      Map parameters = new HashMap();
      String cxass = (String)gestionnaire.getObjetFonctionnel("numassedic");
      Long cxala = (Long)gestionnaire.getObjetFonctionnel("numalloc");
      parameters.put("numassedic", cxass);
      parameters.put("numalloc", cxala);
      
      Collection res = (Collection)requete.executer(parameters);
      
      Iterator iterator = res.iterator();
      while (iterator.hasNext())
      {
        DemandePivotPC demandePivotPC = (DemandePivotPC)iterator.next();
        listeDecisionsPivot.add((DemandePivot)demandePivotPC.createOM());
      }
      return listeDecisionsPivot;
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getDemandesPivot()", e);
    }
    finally
    {
      try
      {
        if (requete != null) {
          requete.liberer();
        }
      }
      catch (TechniqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_DOM_MANAGER", "Erreur lors de l'appel du DomManager : getDemandesPivot()", e);
      }
    }
  }
}

/* Location:
 * Qualified Name:     DomManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */