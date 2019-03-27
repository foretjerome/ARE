package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.autresdoms.d90.dom.DeltaMontantMensuel;
import fr.unedic.cali.autresdoms.d90.dom.Demande;
import fr.unedic.cali.autresdoms.d90.dom.EcartBasePivotEchange;
import fr.unedic.cali.autresdoms.d90.dom.ElementDroitAExclure;
import fr.unedic.cali.autresdoms.d90.dom.Individu;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilVisualisation;
import fr.unedic.cali.autresdoms.d90.parcours.ResultatFinaliserRapportOccasionnel;
import fr.unedic.cali.dom.ElementComparaisonReexamen;
import fr.unedic.cali.dom.occasionnel.DomEcritureStat;
import fr.unedic.cali.dom.occasionnel.DomLirePopulationsListe;
import fr.unedic.cali.dom.occasionnel.DomStatsAntenne;
import fr.unedic.cali.occasionnel.CoupleCodeAntenneRapportId;
import fr.unedic.cali.parcours.ResultatVisualisationReexecution;
import fr.unedic.cali.parcours.ResultatVisualisationSelection;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurElementsAExclure;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;
import fr.unedic.util.persistance.dao.DBUtil;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EcrireBaseVisu
  extends BaseVisu
{
  public static final String VRAI = "1";
  public static final String FAUX = "0";
  public static final int TAILLE_MAX_VALEUR_APRES = 100;
  public static final int TAILLE_MAX_LIBELLE = 50;
  
  public static void finaliserRapportBaseVisu(ResultatFinaliserRapportOccasionnel p_resultatInitialisationRapport)
    throws TechniqueException, CoucheLogiqueException
  {
    if (p_resultatInitialisationRapport != null)
    {
      Connection connection = getConnection(p_resultatInitialisationRapport.getModeRedressement());
      
      int idxCxass = 1;
      int idxFonctRapportID = 2;
      int idxLibRapport = 3;
      int idxNomChaine = 4;
      int idxModeOccas = 5;
      int idxDatePassage = 6;
      int idxNumPassage = 7;
      int idxTSP = 8;
      
      String requete = "INSERT INTO P1297B_RAPPORT (CXASS,FONCT_RAPP_ID,LIB_RAPPORT,NOM_CHAINE,MODE_OCCAS,DATE_PASSAGE,NUM_PASSAGE,TSP) VALUES (?,?,?,?,?,?,?,?)";
      
      PreparedStatement statement = null;
      try
      {
        statement = connection.prepareStatement(requete);
        statement.setString(1, p_resultatInitialisationRapport.getCodeAssedic());
        statement.setBigDecimal(2, new BigDecimal(p_resultatInitialisationRapport.getIdentifiantRedressement()));
        statement.setString(3, p_resultatInitialisationRapport.getNomOccasionnel());
        statement.setString(4, p_resultatInitialisationRapport.getNomChaine());
        statement.setString(5, OutilVisualisation.getCodeModeOccasionnel(p_resultatInitialisationRapport.getModeRedressement()));
        statement.setDate(6, DBUtil.dateVersSqlDate(Damj.damjVersDate(p_resultatInitialisationRapport.getRedressement().getDatePassage())));
        statement.setInt(7, p_resultatInitialisationRapport.getNumeroPassage().intValue());
        statement.setTimestamp(8, DBUtil.dateVersSqlTimestamp(new java.util.Date()));
        statement.execute();
        
        ecrirePopulations(p_resultatInitialisationRapport.getRedressement(), connection);
      }
      catch (SQLException e)
      {
        if (e.getErrorCode() == 64733) {
          GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_DOUBLON_FINALISER_RAPPORT_OCCASIONNEL", e);
        } else {
          throw new TechniqueException("ERR_SQL", e.getMessage(), e);
        }
      }
      finally
      {
        closeConnexionStatement(connection, statement);
      }
    }
  }
  
  public static void ecrireEnBaseVisu(ResultatVisualisationSelection p_resultatVisuSelection)
    throws TechniqueException
  {
    if (p_resultatVisuSelection != null)
    {
      Connection connection = null;
      try
      {
        List listeIndividu = p_resultatVisuSelection.getListeIndividusSelectionnes();
        if ((listeIndividu != null) && (!listeIndividu.isEmpty()))
        {
          connection = getConnection(p_resultatVisuSelection.getRedressementSpec().getModeRedressement());
          Iterator iterIndividus = listeIndividu.iterator();
          while (iterIndividus.hasNext())
          {
            Individu individu = (Individu)iterIndividus.next();
            ecrireIndividu(individu, p_resultatVisuSelection.getRedressementSpec(), connection);
          }
        }
      }
      catch (TechniqueException ex)
      {
        throw ex;
      }
      finally
      {
        if (connection != null) {
          closeConnexion(connection);
        }
      }
    }
  }
  
  public static void ecrireEnBaseVisu(ResultatVisualisationReexecution p_resultatVisuReexecution)
    throws TechniqueException
  {
    if (p_resultatVisuReexecution != null)
    {
      Connection connection = getConnection(p_resultatVisuReexecution.getRedressementSpec().getModeRedressement());
      try
      {
        ecrireIndividu(p_resultatVisuReexecution.getIndividu(), p_resultatVisuReexecution.getRedressementSpec(), connection);
      }
      catch (TechniqueException ex)
      {
        throw ex;
      }
      finally
      {
        closeConnexion(connection);
      }
    }
  }
  
  private static void ecrireIndividu(Individu p_individu, RedressementSpec p_redressement, Connection p_connection)
    throws TechniqueException
  {
    if ((p_individu != null) && (p_redressement != null))
    {
      int idxCxass = 1;
      int idxFkFonctRapportID = 2;
      int idxCodePopulation = 3;
      int idxCxalaf = 4;
      int idxRsin = 5;
      int idxModeCreation = 6;
      int idxDeltaMntIndemnise = 7;
      int idxTSP = 8;
      int idxDateReexecution = 9;
      int idxCodeAntenne = 10;
      int idxEtatIndividu = 11;
      int idxDeltaMontantTranche = 12;
      int idxDeltaMntCadt = 13;
      int idxDeltaMntCrc = 14;
      int idxDeltaMntFinan = 15;
      int idxEtatTraitement = 16;
      
      String requete = "INSERT INTO P1297A_INDIVIDU (CXASS,FK_FONCT_RAPP_ID,CODE_POPULATION,CXALAF,RSIN,MODE_CREATION,DELTA_MT_BRUT,TSP,DATE_REEXECUTION, COD_ANT, ETAT_INDIVIDU, DELTA_MT_TRANCHE, DELTA_MT_CADT, DELTA_MT_CRC, DELTA_MT_FINAN, ETAT) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
      PreparedStatement statement = null;
      try
      {
        statement = p_connection.prepareStatement(requete);
        statement.setString(1, p_redressement.getCodeAssedic());
        statement.setBigDecimal(2, new BigDecimal(p_redressement.getIdentifiantRapport()));
        statement.setString(3, String.valueOf(p_individu.getPopulation().getId()));
        statement.setBigDecimal(4, new BigDecimal(p_individu.getCxala()));
        statement.setString(5, p_individu.getRsin());
        statement.setString(6, p_individu.getModeCreation());
        statement.setBigDecimal(7, p_individu.getDeltaMontantBrut());
        statement.setTimestamp(8, DBUtil.dateVersSqlTimestamp(new java.util.Date()));
        statement.setString(10, p_individu.getAntenne());
        if (p_individu.getEtatIndividu() == null) {
          statement.setString(11, "0");
        } else {
          statement.setString(11, p_individu.getEtatIndividu());
        }
        if (p_individu.getDateReexecution() == null) {
          statement.setDate(9, null);
        } else {
          statement.setDate(9, new java.sql.Date(Damj.damjVersCalendar(p_individu.getDateReexecution()).getTimeInMillis()));
        }
        statement.setString(12, OutilVisualisation.getTrancheDeltaMontant(p_individu.getDeltaMontantBrut()));
        
        Collection listeDeltasMontantsMensuels = p_individu.getListeDeltasMontantsMensuels();
        BigDecimal deltaMtCadt = new BigDecimal("0");
        BigDecimal deltaMtCrc = new BigDecimal("0");
        BigDecimal deltaMtFinan = new BigDecimal("0");
        if (listeDeltasMontantsMensuels != null)
        {
          Iterator iterDeltaMontant = listeDeltasMontantsMensuels.iterator();
          while (iterDeltaMontant.hasNext())
          {
            DeltaMontantMensuel deltaMontant = (DeltaMontantMensuel)iterDeltaMontant.next();
            deltaMtCadt = deltaMtCadt.add(deltaMontant.getDeltaMontantCadt());
            deltaMtCrc = deltaMtCrc.add(deltaMontant.getDeltaMontantCrc());
            deltaMtFinan = deltaMtFinan.add(deltaMontant.getDeltaMontantFinancement());
          }
        }
        statement.setBigDecimal(13, deltaMtCadt);
        statement.setBigDecimal(14, deltaMtCrc);
        statement.setBigDecimal(15, deltaMtFinan);
        if (p_individu.getEtatTraitement() == null) {
          statement.setInt(16, 0);
        } else {
          statement.setInt(16, p_individu.getEtatTraitement().intValue());
        }
        statement.execute();
        
        Collection listeDemandes = p_individu.getListeDemandes();
        if (listeDemandes != null)
        {
          Iterator iterDemande = listeDemandes.iterator();
          while (iterDemande.hasNext())
          {
            Demande demande = (Demande)iterDemande.next();
            
            ecrireDemande(demande, p_individu, p_redressement, p_connection);
            
            ecrireEcartsBasesDemande(p_individu, demande, p_redressement, p_connection);
          }
        }
        ecrireEcartsBasesIndividu(p_individu, p_redressement, p_connection);
        if (listeDeltasMontantsMensuels != null)
        {
          Iterator iterDeltaMontant = listeDeltasMontantsMensuels.iterator();
          while (iterDeltaMontant.hasNext())
          {
            DeltaMontantMensuel deltaMontant = (DeltaMontantMensuel)iterDeltaMontant.next();
            ecrireDeltaMontantMensuel(deltaMontant, p_individu, p_redressement, p_connection);
          }
        }
      }
      catch (SQLException e)
      {
        traiterExceptionSQL(e);
      }
      finally
      {
        closeStatement(statement);
      }
    }
  }
  
  private static void ecrireDemande(Demande p_demande, Individu p_individu, RedressementSpec p_redressement, Connection p_connection)
    throws TechniqueException
  {
    if ((p_demande != null) && (p_individu != null) && (p_redressement != null))
    {
      int idxCxass = 1;
      int idxFkFonctRapportID = 2;
      int idxCodePopulation = 3;
      int idxCxalaf = 4;
      int idxDemandeId = 5;
      int idxEstDecis = 6;
      int idxEstImpacte = 7;
      int idxEtatReex = 8;
      int idxEstReexcute = 9;
      int idxDateAttrib = 10;
      int idxCodeProduit = 11;
      int idxTypeDecision = 12;
      int idxTypeDemande = 13;
      int idxDeltaPJI = 14;
      int idxDeltaDJI = 15;
      int idxEstMigree = 16;
      int idxEstNeutralisee = 17;
      int idxEstFigee = 18;
      int idxTSP = 19;
      
      String requete = "INSERT INTO P1297F_DEMANDE (CXASS,FK_FONCT_RAPP_ID,CODE_POPULATION,CXALAF,DEMANDE_ID,EST_DECIS,EST_IMPACTE,ETAT_REEXAM,EST_REEXECUTE,DATE_ATTRIB,CODE_PRODUIT,TYPE_DECIS,TYPE_DEMANDE,DELTA_PJI,DELTA_DJI,EST_MIGREE,EST_NEUTRALISEE,EST_FIGEE,TSP) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
      PreparedStatement statement = null;
      try
      {
        statement = p_connection.prepareStatement(requete);
        statement.setString(1, p_redressement.getCodeAssedic());
        statement.setBigDecimal(2, new BigDecimal(p_redressement.getIdentifiantRapport()));
        statement.setString(3, String.valueOf(p_individu.getPopulation().getId()));
        statement.setBigDecimal(4, new BigDecimal(p_individu.getCxala()));
        statement.setString(5, p_demande.getIdDemande());
        statement.setString(6, evaluerBooleanValue(p_demande.isEstdecisionnee()));
        statement.setString(7, evaluerBooleanValue(p_demande.isEstImpacte()));
        statement.setString(8, p_demande.getEtatReexamen());
        statement.setString(9, evaluerBooleanValue(p_demande.isEstReexecutee()));
        if (p_demande.getDateAttribution() != null) {
          statement.setDate(10, new java.sql.Date(Damj.damjVersCalendar(p_demande.getDateAttribution()).getTimeInMillis()));
        } else {
          statement.setDate(10, null);
        }
        statement.setInt(11, p_demande.getCodeProduit());
        statement.setString(12, String.valueOf(p_demande.getTypeDecision()));
        statement.setString(13, p_demande.getTypeDemande());
        statement.setBigDecimal(14, p_demande.getDeltaPJI());
        statement.setBigDecimal(15, p_demande.getDeltaDJI());
        statement.setString(16, evaluerBooleanValue(p_demande.estMigree()));
        statement.setString(17, evaluerBooleanValue(p_demande.estNeutralisee()));
        statement.setString(18, evaluerBooleanValue(p_demande.estFigee()));
        statement.setTimestamp(19, DBUtil.dateVersSqlTimestamp(new java.util.Date()));
        statement.execute();
        
        List listeEltsComparaison = p_demande.getElementsComparaisonReexamen();
        if (listeEltsComparaison != null)
        {
          Iterator iterEltsComparaison = listeEltsComparaison.iterator();
          while (iterEltsComparaison.hasNext())
          {
            ElementComparaisonReexamen eltComparaison = (ElementComparaisonReexamen)iterEltsComparaison.next();
            
            ecrireElemComparaison(eltComparaison, p_demande, p_individu, p_redressement, p_connection);
          }
        }
      }
      catch (SQLException e)
      {
        traiterExceptionSQL(e);
      }
      finally
      {
        closeStatement(statement);
      }
    }
  }
  
  private static void ecrirePopulations(RedressementSpec p_redressement, Connection p_connection)
    throws TechniqueException
  {
    if (p_redressement != null)
    {
      List listePopulation = p_redressement.getListePopulation();
      if (listePopulation != null)
      {
        Iterator iterPopulation = listePopulation.iterator();
        while (iterPopulation.hasNext())
        {
          PopulationSpec population = (PopulationSpec)iterPopulation.next();
          ecrirePopulation(p_redressement, population, p_connection);
          ecrireStatistiques(p_redressement, population, p_connection);
        }
      }
    }
  }
  
  private static void ecrirePopulation(RedressementSpec p_redressement, PopulationSpec p_population, Connection p_connection)
    throws TechniqueException
  {
    PreparedStatement statement = null;
    try
    {
      int idxCxass = 1;
      int idxFkFonctRapportID = 2;
      int idxCodePopulation = 3;
      int idxReexDecMig = 4;
      int idxReexecDecMig = 5;
      int idxTypeMandatement = 6;
      int idxAppliPremDec = 7;
      int idxLibPop = 8;
      int idxTSP = 9;
      
      int idxConsigne1 = 10;
      int idxConsigne2 = 11;
      int idxConsigne3 = 12;
      
      String[] consignesPopulation = new String[3];
      consignesPopulation = LireBaseVisu.getSaisieDescriptifPopulation(p_population.getId());
      
      String requete = "INSERT INTO P1297E_POPULATION (CXASS,FK_FONCT_RAPP_ID,CODE_POPULATION,REEXAM_DEC_MIG,REEXEC_DEC_MIG,TYPE_MANDATEMENT,APPLI_PREM_DEC,LIB_POPULATION,TSP,CONSIGNE_1,CONSIGNE_2,CONSIGNE_3) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      
      statement = p_connection.prepareStatement(requete);
      statement.setString(1, p_redressement.getCodeAssedic());
      statement.setBigDecimal(2, new BigDecimal(p_redressement.getIdentifiantRapport()));
      statement.setString(3, String.valueOf(p_population.getId()));
      statement.setString(4, p_population.getComportement().getRexamenDecisionMigrees());
      statement.setString(5, evaluerBooleanValue(p_population.getComportement().isReexucutionDecisionMigrees()));
      statement.setString(6, p_population.getComportement().getTypeMandatement());
      statement.setString(7, evaluerBooleanValue(p_population.getComportement().isApplicationSurPremiereDecision()));
      statement.setString(8, p_population.getLibelle());
      statement.setTimestamp(9, DBUtil.dateVersSqlTimestamp(new java.util.Date()));
      
      statement.setString(10, consignesPopulation[0]);
      statement.setString(11, consignesPopulation[1]);
      statement.setString(12, consignesPopulation[2]);
      
      statement.execute();
      
      ecrireElemExclu(p_population, p_redressement, p_connection);
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statement);
    }
  }
  
  private static void ecrireElemExclu(PopulationSpec p_population, RedressementSpec p_redressement, Connection p_connection)
    throws TechniqueException
  {
    if ((p_population != null) && (p_redressement != null))
    {
      int idxCxass = 1;
      int idxFkFonctRapportID = 2;
      int idxCodePopulation = 3;
      int idxCodeGamme = 4;
      int idxCodeProduit = 5;
      int idxNumElement = 6;
      int idxTSP = 7;
      
      String requete = "INSERT INTO P1297C_ELT_EXCLU (CXASS,FK_FONCT_RAPP_ID,CODE_POPULATION,CODE_GAMME,CODE_PRODUIT,NUM_ELEMENT,TSP) VALUES (?,?,?,?,?,?,?)";
      
      List listeElementsAExclure = recupererElementsDroitAExclure(p_population.getComportement().getDecideur());
      if ((p_population.getComportement() != null) && (listeElementsAExclure != null))
      {
        List listeElemAExclure = listeElementsAExclure;
        Iterator iterElemAExclure = listeElemAExclure.iterator();
        while (iterElemAExclure.hasNext())
        {
          PreparedStatement statement = null;
          ElementDroitAExclure elemAExclure = (ElementDroitAExclure)iterElemAExclure.next();
          try
          {
            statement = p_connection.prepareStatement(requete);
            statement.setString(1, p_redressement.getCodeAssedic());
            statement.setBigDecimal(2, new BigDecimal(p_redressement.getIdentifiantRapport()));
            statement.setString(3, String.valueOf(p_population.getId()));
            statement.setInt(4, OutilVisualisation.getCodeGamme(elemAExclure.getLibelleGamme()));
            statement.setInt(5, elemAExclure.getCodeProduit());
            statement.setInt(6, OutilVisualisation.getCodeElementDroitAExclure(elemAExclure.getLibelleElementAExclure()));
            statement.setTimestamp(7, DBUtil.dateVersSqlTimestamp(new java.util.Date()));
            
            statement.execute();
          }
          catch (SQLException e)
          {
            traiterExceptionSQL(e);
          }
          finally
          {
            closeStatement(statement);
          }
        }
      }
    }
  }
  
  private static List recupererElementsDroitAExclure(DecideurDecisionSpec p_decideur)
  {
    if ((p_decideur instanceof DecideurElementsAExclure))
    {
      DecideurElementsAExclure decideur = (DecideurElementsAExclure)p_decideur;
      return decideur.getElementsDroitAExclure();
    }
    List listeDecideurs = p_decideur.getListeDecideursAppliques();
    if (listeDecideurs != null)
    {
      Iterator it = listeDecideurs.iterator();
      while (it.hasNext())
      {
        DecideurDecisionSpec decideur = (DecideurDecisionSpec)it.next();
        List resultat = recupererElementsDroitAExclure(decideur);
        if (resultat != null) {
          return resultat;
        }
      }
    }
    return null;
  }
  
  private static void ecrireElemComparaison(ElementComparaisonReexamen p_eltComparaison, Demande p_demande, Individu p_individu, RedressementSpec p_redressement, Connection p_connection)
    throws TechniqueException
  {
    if ((p_eltComparaison != null) && (p_demande != null) && (p_individu != null) && (p_redressement != null))
    {
      int idxCxass = 1;
      int idxFkFonctRapportID = 2;
      int idxCodePopulation = 3;
      int idxCxalaf = 4;
      int idxFkDemandeId = 5;
      int idxNumElement = 6;
      int idxValeurAvant = 7;
      int idxValeurApres = 8;
      int idxTSP = 9;
      int idxLibElement = 10;
      
      String requete = "INSERT INTO P1297D_ELT_COMP (CXASS,FK_FONCT_RAPP_ID,CODE_POPULATION,CXALAF,FK_DEMANDE_ID,NUM_ELEMENT,VALEUR_AVANT,VALEUR_APRES,TSP,LIB_ELEMENT) VALUES (?,?,?,?,?,?,?,?,?,?)";
      
      PreparedStatement statement = null;
      try
      {
        statement = p_connection.prepareStatement(requete);
        statement.setString(1, p_redressement.getCodeAssedic());
        statement.setBigDecimal(2, new BigDecimal(p_redressement.getIdentifiantRapport()));
        statement.setString(3, String.valueOf(p_individu.getPopulation().getId()));
        statement.setBigDecimal(4, new BigDecimal(p_individu.getCxala()));
        statement.setBigDecimal(5, new BigDecimal(p_demande.getIdDemande()));
        statement.setInt(6, OutilVisualisation.getCodeElementDroitAExclure(p_eltComparaison.getLibelleElement()));
        statement.setString(7, ConvertisseurElementComparaisonReexamen.convertirElement(p_eltComparaison.getValeurAvantReexamen()));
        
        statement.setString(8, ConvertisseurElementComparaisonReexamen.convertirElement(p_eltComparaison.getValeurApresReexamen()));
        
        statement.setTimestamp(9, DBUtil.dateVersSqlTimestamp(new java.util.Date()));
        statement.setString(10, p_eltComparaison.getLibelleElement());
        
        statement.execute();
      }
      catch (SQLException e)
      {
        traiterExceptionSQL(e);
      }
      finally
      {
        closeStatement(statement);
      }
    }
  }
  
  private static String evaluerBooleanValue(boolean p_valeur)
  {
    if (p_valeur) {
      return "1";
    }
    return "0";
  }
  
  public static void nettoyerIndividuRapport(ResultatVisualisationReexecution p_resultatVisuReexecution, Connection p_connection)
    throws TechniqueException
  {
    if ((p_resultatVisuReexecution != null) && (p_resultatVisuReexecution.getRedressementSpec() != null) && (p_resultatVisuReexecution.getIndividu() != null))
    {
      RedressementSpec redressement = p_resultatVisuReexecution.getRedressementSpec();
      Individu individu = p_resultatVisuReexecution.getIndividu();
      
      PreparedStatement statement = null;
      try
      {
        nettoyerDemandes(redressement, individu, p_connection);
        
        int idxCxass = 1;
        int idxCxalaf = 2;
        int idxCodePopulation = 3;
        int idxFkFonctRapportID = 4;
        
        String requete = "DELETE FROM P1297A_INDIVIDU WHERE CXASS = ? AND CXALAF = ? AND CODE_POPULATION = ? AND FK_FONCT_RAPP_ID = ?";
        
        statement = p_connection.prepareStatement(requete);
        statement.setString(1, redressement.getCodeAssedic());
        statement.setBigDecimal(2, new BigDecimal(individu.getCxala()));
        statement.setString(3, String.valueOf(individu.getPopulation().getId()));
        statement.setBigDecimal(4, new BigDecimal(redressement.getIdentifiantRapport()));
        statement.execute();
      }
      catch (SQLException e)
      {
        traiterExceptionSQL(e);
      }
      finally
      {
        closeStatement(statement);
      }
    }
  }
  
  private static void nettoyerDemandes(RedressementSpec p_redressement, Individu p_individu, Connection p_connection)
    throws TechniqueException
  {
    PreparedStatement statement = null;
    try
    {
      Collection listeDemandes = p_individu.getListeDemandes();
      if (listeDemandes != null)
      {
        Iterator iterDemande = listeDemandes.iterator();
        while (iterDemande.hasNext())
        {
          Demande demande = (Demande)iterDemande.next();
          
          nettoyerElementsComparaison(p_redressement, p_individu, demande, p_connection);
          
          int idxCxass = 1;
          int idxCxalaf = 2;
          int idxCodePopulation = 3;
          int idxFkFonctRapportID = 4;
          int idxDemandeId = 5;
          
          String requete = "DELETE FROM P1297F_DEMANDE WHERE CXASS = ? AND CXALAF = ? AND CODE_POPULATION = ? AND FK_FONCT_RAPP_ID = ? AND DEMANDE_ID = ?";
          
          statement = p_connection.prepareStatement(requete);
          statement.setString(1, p_redressement.getCodeAssedic());
          statement.setBigDecimal(2, new BigDecimal(p_individu.getCxala()));
          statement.setString(3, String.valueOf(p_individu.getPopulation().getId()));
          statement.setBigDecimal(4, new BigDecimal(p_redressement.getIdentifiantRapport()));
          statement.setString(5, demande.getIdDemande());
          statement.execute();
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statement);
    }
  }
  
  private static void nettoyerElementsComparaison(RedressementSpec p_redressement, Individu p_individu, Demande p_demande, Connection p_connection)
    throws TechniqueException
  {
    PreparedStatement statement = null;
    try
    {
      List listeEltsComparaison = p_demande.getElementsComparaisonReexamen();
      if (listeEltsComparaison != null)
      {
        Iterator iterEltsComparaison = listeEltsComparaison.iterator();
        while (iterEltsComparaison.hasNext())
        {
          ElementComparaisonReexamen eltComparaison = (ElementComparaisonReexamen)iterEltsComparaison.next();
          int idxCxass = 1;
          int idxCxalaf = 2;
          int idxCodePopulation = 3;
          int idxFkFonctRapportID = 4;
          int idxFkDemandeId = 5;
          int idxNumElement = 6;
          
          String requete = "DELETE FROM P1297D_ELT_COMP WHERE CXASS = ? AND CXALAF = ? AND CODE_POPULATION = ? AND FK_FONCT_RAPP_ID = ? AND FK_DEMANDE_ID = ? AND NUM_ELEMENT = ?";
          
          statement = p_connection.prepareStatement(requete);
          statement.setString(1, p_redressement.getCodeAssedic());
          statement.setBigDecimal(2, new BigDecimal(p_individu.getCxala()));
          statement.setString(3, String.valueOf(p_individu.getPopulation().getId()));
          statement.setBigDecimal(4, new BigDecimal(p_redressement.getIdentifiantRapport()));
          statement.setString(5, p_demande.getIdDemande());
          statement.setInt(6, OutilVisualisation.getCodeElementDroitAExclure(eltComparaison.getLibelleElement()));
          statement.execute();
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statement);
    }
  }
  
  private static void ecrireStatistiques(RedressementSpec p_redressement, PopulationSpec p_population, Connection p_connection)
    throws TechniqueException
  {
    Map mapDomStatsAntenne = new HashMap();
    
    recuperationTrancheDeltaMontant(mapDomStatsAntenne, p_redressement, p_population, p_connection);
    recuperationDeltaMontantPositifs(mapDomStatsAntenne, p_redressement, p_population, p_connection);
    recuperationDeltaMontantNegatifs(mapDomStatsAntenne, p_redressement, p_population, p_connection);
    recuperationDeReexecutes(mapDomStatsAntenne, p_redressement, p_population, p_connection);
    recuperationDeEnReexamen(mapDomStatsAntenne, p_redressement, p_population, p_connection);
    recuperationDeEcartes(mapDomStatsAntenne, p_redressement, p_population, p_connection);
    
    Iterator iterateur = mapDomStatsAntenne.keySet().iterator();
    DomEcritureStat ecrireStatPe = new DomEcritureStat();
    while (iterateur.hasNext())
    {
      DomStatsAntenne dom = (DomStatsAntenne)mapDomStatsAntenne.get(iterateur.next());
      ecrireStatsAntenne(dom, p_connection, ecrireStatPe);
    }
    if (ecrireStatPe.isEcrireStatPE()) {
      ecrireDateTraitementPourPopulationRapport(ecrireStatPe.getCodePopulation(), ecrireStatPe.getCodePoleEmploi(), ecrireStatPe.getRapportId(), new Damj());
    }
  }
  
  private static void recuperationTrancheDeltaMontant(Map p_mapDomStatsAntenne, RedressementSpec p_redressement, PopulationSpec p_population, Connection p_connection)
    throws TechniqueException
  {
    PreparedStatement statement = null;
    String codePoleEmploi = p_redressement.getCodeAssedic();
    String idRapport = p_redressement.getIdentifiantRapport();
    String codePopulation = String.valueOf(p_population.getId());
    try
    {
      int idxPoleEmploi = 1;
      int idxFkFonctRapportID = 2;
      int idxCodePopulation = 3;
      
      String requete = "select count(distinct cxalaf), DELTA_MT_TRANCHE, COD_ANT  from P1297A_INDIVIDU where cxass = ?  and fk_fonct_rapp_id = ?  and code_population = ?  and '$NCPOccasDeltaMtParTranche' <> 'ReqVisuOccas'  group by DELTA_MT_TRANCHE, COD_ANT  order by COD_ANT,DELTA_MT_TRANCHE asc  with ur;";
      
      statement = p_connection.prepareStatement(requete);
      statement.setString(1, codePoleEmploi);
      statement.setBigDecimal(2, new BigDecimal(idRapport));
      statement.setString(3, codePopulation);
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      int idxNbDeParTranche = 1;
      int idxTranche = 2;
      int idxAntenne = 3;
      String cle = null;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if ((setIsOpen) && 
          (set.getString(2) != null) && (!set.getString(2).trim().equals("")))
        {
          cle = codePoleEmploi + idRapport + codePopulation + set.getString(3);
          DomStatsAntenne domStatsAntenne = (DomStatsAntenne)p_mapDomStatsAntenne.get(cle);
          if (domStatsAntenne == null)
          {
            domStatsAntenne = new DomStatsAntenne();
            domStatsAntenne.setCodePoleEmploi(codePoleEmploi);
            domStatsAntenne.setCodePopulation(codePopulation);
            domStatsAntenne.setIdRapport(new BigDecimal(idRapport));
            domStatsAntenne.setCodeAntenne(set.getString(3));
          }
          if (set.getString(2).trim().equals("1")) {
            domStatsAntenne.setNbDeltaMontantTranche1(set.getBigDecimal(1));
          } else if (set.getString(2).trim().equals("2")) {
            domStatsAntenne.setNbDeltaMontantTranche2(set.getBigDecimal(1));
          } else if (set.getString(2).trim().equals("3")) {
            domStatsAntenne.setNbDeltaMontantTranche3(set.getBigDecimal(1));
          } else if (set.getString(2).trim().equals("4")) {
            domStatsAntenne.setNbDeltaMontantTranche4(set.getBigDecimal(1));
          } else if (set.getString(2).trim().equals("5")) {
            domStatsAntenne.setNbDeltaMontantTranche5(set.getBigDecimal(1));
          } else if (set.getString(2).trim().equals("6")) {
            domStatsAntenne.setNbDeltaMontantTranche6(set.getBigDecimal(1));
          } else if (set.getString(2).trim().equals("7")) {
            domStatsAntenne.setNbDeltaMontantTranche7(set.getBigDecimal(1));
          } else if (set.getString(2).trim().equals("8")) {
            domStatsAntenne.setNbDeltaMontantTranche8(set.getBigDecimal(1));
          }
          p_mapDomStatsAntenne.put(cle, domStatsAntenne);
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statement);
    }
  }
  
  private static void recuperationDeltaMontantPositifs(Map p_mapDomStatsAntenne, RedressementSpec p_redressement, PopulationSpec p_population, Connection p_connection)
    throws TechniqueException
  {
    PreparedStatement statement = null;
    String codePoleEmploi = p_redressement.getCodeAssedic();
    String idRapport = p_redressement.getIdentifiantRapport();
    String codePopulation = String.valueOf(p_population.getId());
    try
    {
      int idxPoleEmploi = 1;
      int idxFkFonctRapportID = 2;
      int idxCodePopulation = 3;
      
      String requete = "select count(DELTA_MT_BRUT), sum(DELTA_MT_BRUT), COD_ANT  from P1297A_INDIVIDU where cxass = ?  and fk_fonct_rapp_id = ?  and code_population = ?  and DELTA_MT_BRUT > 0  and '$NCPOccasDeltaMtPos' <> 'ReqVisuOccas' group by COD_ANT  order by COD_ANT  with ur;";
      
      statement = p_connection.prepareStatement(requete);
      statement.setString(1, codePoleEmploi);
      statement.setBigDecimal(2, new BigDecimal(idRapport));
      statement.setString(3, codePopulation);
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      int idxNbDeltaMontant = 1;
      int idxSommeDeltaMontant = 2;
      int idxAntenne = 3;
      String cle = null;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          cle = codePoleEmploi + idRapport + codePopulation + set.getString(3);
          DomStatsAntenne domStatsAntenne = (DomStatsAntenne)p_mapDomStatsAntenne.get(cle);
          if (domStatsAntenne == null)
          {
            domStatsAntenne = new DomStatsAntenne();
            domStatsAntenne.setCodePoleEmploi(codePoleEmploi);
            domStatsAntenne.setCodePopulation(codePopulation);
            domStatsAntenne.setIdRapport(new BigDecimal(idRapport));
            domStatsAntenne.setCodeAntenne(set.getString(3));
          }
          domStatsAntenne.setNbDeltaMtPos(set.getBigDecimal(1));
          domStatsAntenne.setSommeDeltaMtPos(set.getBigDecimal(2));
          p_mapDomStatsAntenne.put(cle, domStatsAntenne);
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statement);
    }
  }
  
  private static void recuperationDeltaMontantNegatifs(Map p_mapDomStatsAntenne, RedressementSpec p_redressement, PopulationSpec p_population, Connection p_connection)
    throws TechniqueException
  {
    PreparedStatement statement = null;
    String codePoleEmploi = p_redressement.getCodeAssedic();
    String idRapport = p_redressement.getIdentifiantRapport();
    String codePopulation = String.valueOf(p_population.getId());
    try
    {
      int idxPoleEmploi = 1;
      int idxFkFonctRapportID = 2;
      int idxCodePopulation = 3;
      
      String requete = "select count(DELTA_MT_BRUT), sum(DELTA_MT_BRUT), COD_ANT  from P1297A_INDIVIDU where cxass = ?  and fk_fonct_rapp_id = ?  and code_population = ?  and DELTA_MT_BRUT < 0  and '$NCPOccasDeltaMtNeg' <> 'ReqVisuOccas' group by COD_ANT  order by COD_ANT  with ur;";
      
      statement = p_connection.prepareStatement(requete);
      statement.setString(1, codePoleEmploi);
      statement.setBigDecimal(2, new BigDecimal(idRapport));
      statement.setString(3, codePopulation);
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      int idxNbDeltaMontant = 1;
      int idxSommeDeltaMontant = 2;
      int idxAntenne = 3;
      String cle = null;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          cle = codePoleEmploi + idRapport + codePopulation + set.getString(3);
          DomStatsAntenne domStatsAntenne = (DomStatsAntenne)p_mapDomStatsAntenne.get(cle);
          if (domStatsAntenne == null)
          {
            domStatsAntenne = new DomStatsAntenne();
            domStatsAntenne.setCodePoleEmploi(codePoleEmploi);
            domStatsAntenne.setCodePopulation(codePopulation);
            domStatsAntenne.setIdRapport(new BigDecimal(idRapport));
            domStatsAntenne.setCodeAntenne(set.getString(3));
          }
          domStatsAntenne.setNbDeltaMtNeg(set.getBigDecimal(1));
          domStatsAntenne.setSommeDeltaMtNeg(set.getBigDecimal(2));
          p_mapDomStatsAntenne.put(cle, domStatsAntenne);
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statement);
    }
  }
  
  private static void recuperationDeReexecutes(Map p_mapDomStatsAntenne, RedressementSpec p_redressement, PopulationSpec p_population, Connection p_connection)
    throws TechniqueException
  {
    PreparedStatement statement = null;
    String codePoleEmploi = p_redressement.getCodeAssedic();
    String idRapport = p_redressement.getIdentifiantRapport();
    String codePopulation = String.valueOf(p_population.getId());
    try
    {
      int idxPoleEmploi = 1;
      int idxFkFonctRapportID = 2;
      int idxCodePopulation = 3;
      
      String requete = "select count(distinct cxalaf), COD_ANT  from P1297A_INDIVIDU where cxass = ?  and fk_fonct_rapp_id = ?  and code_population = ?  and ETAT_INDIVIDU = '0'  and '$NCPOccasDeltaMtNeg' <> 'ReqVisuOccas' group by COD_ANT  order by COD_ANT  with ur;";
      
      statement = p_connection.prepareStatement(requete);
      statement.setString(1, codePoleEmploi);
      statement.setBigDecimal(2, new BigDecimal(idRapport));
      statement.setString(3, codePopulation);
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      int idxNbDe = 1;
      int idxAntenne = 2;
      String cle = null;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          cle = codePoleEmploi + idRapport + codePopulation + set.getString(2);
          DomStatsAntenne domStatsAntenne = (DomStatsAntenne)p_mapDomStatsAntenne.get(cle);
          if (domStatsAntenne == null)
          {
            domStatsAntenne = new DomStatsAntenne();
            domStatsAntenne.setCodePoleEmploi(codePoleEmploi);
            domStatsAntenne.setCodePopulation(codePopulation);
            domStatsAntenne.setIdRapport(new BigDecimal(idRapport));
            domStatsAntenne.setCodeAntenne(set.getString(2));
          }
          domStatsAntenne.setNbDeReexecute(set.getBigDecimal(1));
          if (domStatsAntenne.getNbDeTraite() != null) {
            domStatsAntenne.setNbDeTraite(domStatsAntenne.getNbDeTraite().add(set.getBigDecimal(1)));
          } else {
            domStatsAntenne.setNbDeTraite(set.getBigDecimal(1));
          }
          p_mapDomStatsAntenne.put(cle, domStatsAntenne);
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statement);
    }
  }
  
  private static void recuperationDeEnReexamen(Map p_mapDomStatsAntenne, RedressementSpec p_redressement, PopulationSpec p_population, Connection p_connection)
    throws TechniqueException
  {
    PreparedStatement statement = null;
    String codePoleEmploi = p_redressement.getCodeAssedic();
    String idRapport = p_redressement.getIdentifiantRapport();
    String codePopulation = String.valueOf(p_population.getId());
    try
    {
      int idxPoleEmploi = 1;
      int idxFkFonctRapportID = 2;
      int idxCodePopulation = 3;
      
      String requete = "select count(distinct cxalaf), COD_ANT  from P1297A_INDIVIDU where cxass = ?  and fk_fonct_rapp_id = ?  and code_population = ?  and ETAT_INDIVIDU = 'R'  and '$NCPOccasDeltaMtNeg' <> 'ReqVisuOccas' group by COD_ANT  order by COD_ANT  with ur;";
      
      statement = p_connection.prepareStatement(requete);
      statement.setString(1, codePoleEmploi);
      statement.setBigDecimal(2, new BigDecimal(idRapport));
      statement.setString(3, codePopulation);
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      int idxNbDe = 1;
      int idxAntenne = 2;
      String cle = null;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          cle = codePoleEmploi + idRapport + codePopulation + set.getString(2);
          DomStatsAntenne domStatsAntenne = (DomStatsAntenne)p_mapDomStatsAntenne.get(cle);
          if (domStatsAntenne == null)
          {
            domStatsAntenne = new DomStatsAntenne();
            domStatsAntenne.setCodePoleEmploi(codePoleEmploi);
            domStatsAntenne.setCodePopulation(codePopulation);
            domStatsAntenne.setIdRapport(new BigDecimal(idRapport));
            domStatsAntenne.setCodeAntenne(set.getString(2));
          }
          domStatsAntenne.setNbDeReexamen(set.getBigDecimal(1));
          if (domStatsAntenne.getNbDeTraite() != null) {
            domStatsAntenne.setNbDeTraite(domStatsAntenne.getNbDeTraite().add(set.getBigDecimal(1)));
          } else {
            domStatsAntenne.setNbDeTraite(set.getBigDecimal(1));
          }
          p_mapDomStatsAntenne.put(cle, domStatsAntenne);
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statement);
    }
  }
  
  private static void recuperationDeEcartes(Map p_mapDomStatsAntenne, RedressementSpec p_redressement, PopulationSpec p_population, Connection p_connection)
    throws TechniqueException
  {
    PreparedStatement statement = null;
    String codePoleEmploi = p_redressement.getCodeAssedic();
    String idRapport = p_redressement.getIdentifiantRapport();
    String codePopulation = String.valueOf(p_population.getId());
    try
    {
      int idxPoleEmploi = 1;
      int idxFkFonctRapportID = 2;
      int idxCodePopulation = 3;
      
      String requete = "select count(distinct cxalaf), COD_ANT  from P1297A_INDIVIDU where cxass = ?  and fk_fonct_rapp_id = ?  and code_population = ?  and ETAT_INDIVIDU = '1'  and '$NCPOccasDeltaMtNeg' <> 'ReqVisuOccas' group by COD_ANT  order by COD_ANT  with ur;";
      
      statement = p_connection.prepareStatement(requete);
      statement.setString(1, codePoleEmploi);
      statement.setBigDecimal(2, new BigDecimal(idRapport));
      statement.setString(3, codePopulation);
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      int idxNbDe = 1;
      int idxAntenne = 2;
      String cle = null;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          cle = codePoleEmploi + idRapport + codePopulation + set.getString(2);
          DomStatsAntenne domStatsAntenne = (DomStatsAntenne)p_mapDomStatsAntenne.get(cle);
          if (domStatsAntenne == null)
          {
            domStatsAntenne = new DomStatsAntenne();
            domStatsAntenne.setCodePoleEmploi(codePoleEmploi);
            domStatsAntenne.setCodePopulation(codePopulation);
            domStatsAntenne.setIdRapport(new BigDecimal(idRapport));
            domStatsAntenne.setCodeAntenne(set.getString(2));
          }
          if (domStatsAntenne.getNbDeTraite() != null) {
            domStatsAntenne.setNbDeTraite(domStatsAntenne.getNbDeTraite().add(set.getBigDecimal(1)));
          } else {
            domStatsAntenne.setNbDeTraite(set.getBigDecimal(1));
          }
          p_mapDomStatsAntenne.put(cle, domStatsAntenne);
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statement);
    }
  }
  
  private static void ecrireStatsAntenne(DomStatsAntenne p_domStatsAntenne, Connection p_connection, DomEcritureStat p_domEcritureStat)
    throws TechniqueException
  {
    PreparedStatement statement = null;
    try
    {
      int idxPoleEmploi = 1;
      int idxFkFonctRapportID = 2;
      int idxCodeAntenne = 3;
      int idxCodePopulation = 4;
      int idxNbDeDeltaMtNeg = 5;
      int idxNbDeDeltaMtPos = 6;
      int idxNbDeReexamen = 7;
      int idxNbDeReexecutes = 8;
      int idxNbDeTraites = 9;
      int idxNbDeltaMtTranche1 = 10;
      int idxNbDeltaMtTranche2 = 11;
      int idxNbDeltaMtTranche3 = 12;
      int idxNbDeltaMtTranche4 = 13;
      int idxNbDeltaMtTranche5 = 14;
      int idxNbDeltaMtTranche6 = 15;
      int idxNbDeltaMtTranche7 = 16;
      int idxNbDeltaMtTranche8 = 17;
      int idxSommeDeltaMtNeg = 18;
      int idxSommeDeltaMtPos = 19;
      int idxTSP = 20;
      int idxDateTraitment = 21;
      
      java.util.Date date = null;
      if (((p_domStatsAntenne.getNbDeReexamen() == null) || (p_domStatsAntenne.getNbDeReexamen().intValue() == 0)) && ((p_domStatsAntenne.getNbDeltaMtNeg() == null) || (p_domStatsAntenne.getNbDeltaMtNeg().intValue() == 0)) && ((p_domStatsAntenne.getNbDeltaMtPos() == null) || (p_domStatsAntenne.getNbDeltaMtPos().intValue() == 0)))
      {
        date = new java.util.Date();
        if ((p_domEcritureStat.isEcrireStatPE()) && (p_domEcritureStat.getCodePopulation() == null))
        {
          p_domEcritureStat.setCodePoleEmploi(p_domStatsAntenne.getCodePoleEmploi());
          p_domEcritureStat.setCodePopulation(p_domStatsAntenne.getCodePopulation());
          p_domEcritureStat.setRapportId(p_domStatsAntenne.getIdRapport());
          p_domEcritureStat.setEcrireStatPE(true);
        }
      }
      else
      {
        p_domEcritureStat.setEcrireStatPE(false);
      }
      String requete = " insert into P1297H_STATS_ANTEN (CXASS, FK_FONCT_RAPP_ID, COD_ANT,  CODE_POPULATION, NB_DE_DELTA_MT_NEG,  NB_DE_DELTA_MT_POS, NB_DE_REEXAMEN,  NB_DE_REEXECUTES, NB_DE_TRAITES,  NB_DELTA_MT_TRAN_1, NB_DELTA_MT_TRAN_2,  NB_DELTA_MT_TRAN_3, NB_DELTA_MT_TRAN_4,  NB_DELTA_MT_TRAN_5, NB_DELTA_MT_TRAN_6,  NB_DELTA_MT_TRAN_7, NB_DELTA_MT_TRAN_8,  SOMME_DELTA_MT_NEG, SOMME_DELTA_MT_POS, TSP, DATE_TRAITEMENT)  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
      statement = p_connection.prepareStatement(requete);
      statement.setString(1, p_domStatsAntenne.getCodePoleEmploi());
      statement.setBigDecimal(2, p_domStatsAntenne.getIdRapport());
      statement.setString(3, p_domStatsAntenne.getCodeAntenne());
      statement.setString(4, p_domStatsAntenne.getCodePopulation());
      statement.setBigDecimal(5, p_domStatsAntenne.getNbDeltaMtNeg());
      statement.setBigDecimal(6, p_domStatsAntenne.getNbDeltaMtPos());
      statement.setBigDecimal(7, p_domStatsAntenne.getNbDeReexamen());
      statement.setBigDecimal(8, p_domStatsAntenne.getNbDeReexecute());
      statement.setBigDecimal(9, p_domStatsAntenne.getNbDeTraite());
      statement.setBigDecimal(10, p_domStatsAntenne.getNbDeltaMontantTranche1());
      statement.setBigDecimal(11, p_domStatsAntenne.getNbDeltaMontantTranche2());
      statement.setBigDecimal(12, p_domStatsAntenne.getNbDeltaMontantTranche3());
      statement.setBigDecimal(13, p_domStatsAntenne.getNbDeltaMontantTranche4());
      statement.setBigDecimal(14, p_domStatsAntenne.getNbDeltaMontantTranche5());
      statement.setBigDecimal(15, p_domStatsAntenne.getNbDeltaMontantTranche6());
      statement.setBigDecimal(16, p_domStatsAntenne.getNbDeltaMontantTranche7());
      statement.setBigDecimal(17, p_domStatsAntenne.getNbDeltaMontantTranche8());
      statement.setBigDecimal(18, p_domStatsAntenne.getSommeDeltaMtNeg());
      statement.setBigDecimal(19, p_domStatsAntenne.getSommeDeltaMtPos());
      statement.setTimestamp(20, DBUtil.dateVersSqlTimestamp(new java.util.Date()));
      statement.setDate(21, DBUtil.dateVersSqlDate(date));
      statement.execute();
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statement);
    }
  }
  
  private static void ecrireEcartsBasesDemande(Individu p_individu, Demande p_demande, RedressementSpec p_redressement, Connection p_connection)
    throws TechniqueException
  {
    Collection listeEcartsBases = p_demande.getListeEcartsBases();
    ecrireEcartsBases(listeEcartsBases, p_individu, p_redressement, p_connection, p_demande.getIdDemande());
  }
  
  private static void ecrireEcartsBasesIndividu(Individu p_individu, RedressementSpec p_redressement, Connection p_connection)
    throws TechniqueException
  {
    Collection listeEcartsBases = p_individu.getListeEcartsBases();
    ecrireEcartsBases(listeEcartsBases, p_individu, p_redressement, p_connection, null);
  }
  
  private static void ecrireEcartsBases(Collection p_listeEcartsBases, Individu p_individu, RedressementSpec p_redressement, Connection p_connection, String p_idDemande)
    throws TechniqueException
  {
    if (p_listeEcartsBases != null)
    {
      Iterator iterEcartBase = p_listeEcartsBases.iterator();
      while (iterEcartBase.hasNext())
      {
        EcartBasePivotEchange ecartBase = (EcartBasePivotEchange)iterEcartBase.next();
        ecrireEcartBase(ecartBase, p_individu, p_redressement, p_connection, p_idDemande);
      }
    }
  }
  
  private static void ecrireEcartBase(EcartBasePivotEchange p_ecartBase, Individu p_individu, RedressementSpec p_redressement, Connection p_connection, String p_idDemande)
    throws TechniqueException
  {
    PreparedStatement statement = null;
    try
    {
      int idxPoleEmploi = 1;
      int idxCxalaf = 2;
      int idxFkFonctRapportID = 3;
      int idxCodePopulation = 4;
      int idxTypeEcartBase = 5;
      int idxCleTechEcartBase = 6;
      int idxCleFonctEcartBase = 7;
      int idxIdDemandeVisu = 8;
      int idxTypeDifference = 9;
      int idxNomAttribut = 10;
      int idxValeurAvant = 11;
      int idxValeurApres = 12;
      int idxTSPValeurAvant = 13;
      int idxTSP = 14;
      
      String requete = " INSERT INTO P1297J_ECARTBASE (CXASS,CXALAF,FK_FONCT_RAPP_ID,CODE_POPULATION,TYPE_EBPE,CLE_TECH_EBPE,CLE_FONCT_EBPE,ID_DEMANDE_VISU,TYPE_DIFFERENCE,NOM_ATTRIBUT,VALEUR_AVANT,VALEUR_APRES,TSP_VALEUR_AVANT,TSP) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
      statement = p_connection.prepareStatement(requete);
      statement.setString(1, p_individu.getCxass());
      statement.setBigDecimal(2, new BigDecimal(p_individu.getCxala()));
      statement.setBigDecimal(3, new BigDecimal(p_redressement.getIdentifiantRapport()));
      statement.setString(4, String.valueOf(p_individu.getPopulation().getId()));
      String typeElement = p_ecartBase.getType();
      statement.setString(5, typeElement);
      statement.setString(6, p_ecartBase.getCleTechnique());
      statement.setString(7, p_ecartBase.getCleFonctionnelle());
      statement.setString(8, p_idDemande);
      statement.setString(9, p_ecartBase.getTypeDifference());
      statement.setString(10, p_ecartBase.getNomAttributCompare());
      statement.setString(11, p_ecartBase.getValeurAvant());
      statement.setString(12, p_ecartBase.getValeurApres());
      statement.setTimestamp(13, DBUtil.dateVersSqlTimestamp(p_ecartBase.getTimestampValeurAvant()));
      statement.setTimestamp(14, DBUtil.dateVersSqlTimestamp(new java.util.Date()));
      statement.execute();
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statement);
    }
  }
  
  private static void ecrireDeltaMontantMensuel(DeltaMontantMensuel p_deltaMontant, Individu p_individu, RedressementSpec p_redressement, Connection p_connection)
    throws TechniqueException
  {
    PreparedStatement statement = null;
    try
    {
      int idxPoleEmploi = 1;
      int idxCxalaf = 2;
      int idxFkFonctRapportID = 3;
      int idxCodePopulation = 4;
      int idxMois = 5;
      int idxAnnee = 6;
      int idxMontantAvant = 7;
      int idxMontantApres = 8;
      int idxTSP = 9;
      
      String requete = " INSERT INTO P1297K_DELTAMT (CXASS,CXALAF,FK_FONCT_RAPP_ID,CODE_POPULATION,MOIS,ANNEE,MONTANT_AVANT,MONTANT_APRES,TSP) VALUES (?,?,?,?,?,?,?,?,?)";
      
      statement = p_connection.prepareStatement(requete);
      statement.setString(1, p_individu.getCxass());
      statement.setBigDecimal(2, new BigDecimal(p_individu.getCxala()));
      statement.setBigDecimal(3, new BigDecimal(p_redressement.getIdentifiantRapport()));
      statement.setString(4, String.valueOf(p_individu.getPopulation().getId()));
      statement.setInt(5, p_deltaMontant.getMois());
      statement.setInt(6, p_deltaMontant.getAnnee());
      statement.setBigDecimal(7, p_deltaMontant.getMontantIndemniseAvant());
      statement.setBigDecimal(8, p_deltaMontant.getMontantIndemniseApres());
      statement.setTimestamp(9, DBUtil.dateVersSqlTimestamp(new java.util.Date()));
      statement.execute();
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statement);
    }
  }
  
  public static void alimenterDateTraitementAntenneRegion(HashMap<CoupleCodeAntenneRapportId, Boolean> p_hashMapCodeAntenne, HashMap<Integer, Boolean> hashMapRapportId, String p_codePopulation, String p_cxass, Damj p_dateTraitement)
    throws TechniqueException
  {
    Set<CoupleCodeAntenneRapportId> set = p_hashMapCodeAntenne.keySet();
    Iterator<CoupleCodeAntenneRapportId> keysIteration = set.iterator();
    while (keysIteration.hasNext())
    {
      CoupleCodeAntenneRapportId cle = (CoupleCodeAntenneRapportId)keysIteration.next();
      String codeAntenne = cle.getCodeAntenne();
      int rapportId = cle.getRapportId();
      
      Boolean estTraite = (Boolean)p_hashMapCodeAntenne.get(cle);
      
      Damj dateTraitementAntenne = null;
      if (estTraite.booleanValue()) {
        dateTraitementAntenne = p_dateTraitement;
      }
      ecrireDateTraitementAntenne(dateTraitementAntenne, p_codePopulation, p_cxass, new BigDecimal(rapportId), codeAntenne);
    }
    if (hashMapRapportId != null)
    {
      Iterator iterateur = hashMapRapportId.keySet().iterator();
      while (iterateur.hasNext())
      {
        int cle = Integer.parseInt(iterateur.next().toString());
        Damj dateTraitementPE = null;
        try
        {
          if (((Boolean)hashMapRapportId.get(Integer.valueOf(cle))).booleanValue()) {
            dateTraitementPE = p_dateTraitement;
          }
          List pop = LireBaseVisu.chargerPopulations(p_cxass, new EcrireBaseVisu.1(cle), p_codePopulation, false);
          if (pop.size() > 0)
          {
            Damj dateTraitement = ((DomLirePopulationsListe)pop.get(0)).getDateTraitement();
            if ((dateTraitement != null) && (dateTraitementPE != null)) {
              dateTraitementPE = dateTraitement;
            }
          }
          ecrireDateTraitementPourPopulationRapport(p_codePopulation, p_cxass, new BigDecimal(cle), dateTraitementPE);
        }
        catch (Exception e)
        {
          throw new TechniqueException(e.getMessage(), e.toString());
        }
      }
    }
  }
  
  public static void alimentationCommentaireEtatIndividu(BigDecimal p_cxalaf, String p_commentaire, int p_etat, String p_codePopulation, String p_cxass, BigDecimal p_rapportId)
    throws TechniqueException
  {
    Connection connection = getConnection(null);
    PreparedStatement statementMajIndividu = null;
    
    int idxCommentaire = 1;
    int idxEtat = 2;
    int idxCxalaf = 3;
    int idxCxass = 4;
    int idxCodePopulation = 5;
    int idxRapportId = 6;
    try
    {
      String requeteMajIndividus = " UPDATE P1297A_INDIVIDU SET COMMENTAIRE = ?, ETAT = ? WHERE CXALAF = ? AND CXASS  = ? AND CODE_POPULATION = ? AND FK_FONCT_RAPP_ID = ? ";
      
      statementMajIndividu = connection.prepareStatement(requeteMajIndividus);
      statementMajIndividu.setString(1, p_commentaire);
      statementMajIndividu.setInt(2, p_etat);
      statementMajIndividu.setBigDecimal(3, p_cxalaf);
      statementMajIndividu.setString(4, p_cxass);
      statementMajIndividu.setString(5, p_codePopulation);
      statementMajIndividu.setBigDecimal(6, p_rapportId);
      statementMajIndividu.execute();
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statementMajIndividu);
    }
  }
  
  public static void ecrireDateTraitementPourPopulationRapport(String p_codePopulation, String p_cxass, BigDecimal p_rapportId, Damj p_dateTraitement)
    throws TechniqueException
  {
    Connection connection = getConnection(null);
    PreparedStatement statementMajPopulation = null;
    
    int idxDateTraitementMajPopulation = 1;
    int idxCxassMajPopulation = 2;
    int idxCodePopulationMajPopulation = 3;
    int idxRapportIdMajPopulation = 4;
    try
    {
      String requeteMajPopulation = " UPDATE P1297E_POPULATION SET DATE_TRAITEMENT = ? WHERE CXASS = ? AND CODE_POPULATION = ? AND FK_FONCT_RAPP_ID = ?";
      
      statementMajPopulation = connection.prepareStatement(requeteMajPopulation);
      if (null != p_dateTraitement) {
        statementMajPopulation.setDate(1, DBUtil.dateVersSqlDate(Damj.damjVersDate(p_dateTraitement)));
      } else {
        statementMajPopulation.setDate(1, null);
      }
      statementMajPopulation.setString(2, p_cxass);
      statementMajPopulation.setString(3, p_codePopulation);
      statementMajPopulation.setBigDecimal(4, p_rapportId);
      statementMajPopulation.execute();
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statementMajPopulation);
    }
  }
  
  public static void ecrireDateTraitementAntenne(Damj p_dateTraitement, String p_codePopulation, String p_cxass, BigDecimal p_rapportId, String p_antenne)
    throws TechniqueException
  {
    int estTraitePe = 0;
    PreparedStatement statementMajAntenneEtatNT = null;
    Connection connection = getConnection(null);
    
    int idxEstTraitePEStatsAntenNT = 1;
    int idxDateTraitementMajStatsAntenNT = 2;
    int idxCodeAntMajStatsAntenNT = 3;
    int idxCxassMajStatsAntenNT = 4;
    int idxCodePopulationMajStatsAntenNT = 5;
    int idxRapportIdMajStatsAntenNT = 6;
    try
    {
      String requeteMajAntenneEtatNT = " UPDATE P1297H_STATS_ANTEN SET EST_TRAITE_PE = ?, DATE_TRAITEMENT = ? WHERE COD_ANT = ? AND CXASS  = ? AND CODE_POPULATION = ? AND FK_FONCT_RAPP_ID = ? ";
      
      statementMajAntenneEtatNT = connection.prepareStatement(requeteMajAntenneEtatNT);
      if (null != p_dateTraitement) {
        statementMajAntenneEtatNT.setDate(2, DBUtil.dateVersSqlDate(Damj.damjVersDate(p_dateTraitement)));
      } else {
        statementMajAntenneEtatNT.setDate(2, null);
      }
      statementMajAntenneEtatNT.setInt(1, 0);
      statementMajAntenneEtatNT.setString(3, p_antenne);
      statementMajAntenneEtatNT.setString(4, p_cxass);
      statementMajAntenneEtatNT.setString(5, p_codePopulation);
      statementMajAntenneEtatNT.setBigDecimal(6, p_rapportId);
      statementMajAntenneEtatNT.execute();
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statementMajAntenneEtatNT);
    }
  }
  
  public static void ecrireConsignes(String p_consigne1, String p_consigne2, String p_consigne3, String p_codePopulation)
    throws TechniqueException
  {
    Connection connection = getConnection(null);
    PreparedStatement statement = null;
    try
    {
      int idxConsigne1 = 1;
      int idxConsigne2 = 2;
      int idxConsigne3 = 3;
      int idxCodePopulation = 4;
      
      String requete = " UPDATE P1297E_POPULATION SET CONSIGNE_1 = ?, CONSIGNE_2 = ?, CONSIGNE_3 = ? WHERE CODE_POPULATION = ? ";
      
      statement = connection.prepareStatement(requete);
      
      statement.setString(1, p_consigne1);
      statement.setString(2, p_consigne2);
      statement.setString(3, p_consigne3);
      statement.setString(4, p_codePopulation);
      statement.execute();
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statement);
    }
  }
}

/* Location:
 * Qualified Name:     EcrireBaseVisu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */