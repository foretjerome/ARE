package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.autresdoms.d90.dom.DeltaMontantMensuel;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSimulationChangementSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilPopulation;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilVisualisation;
import fr.unedic.cali.dom.ComparateurDecisionSpec;
import fr.unedic.cali.dom.occasionnel.DomLireDemandesListe;
import fr.unedic.cali.dom.occasionnel.DomLireEltCompListe;
import fr.unedic.cali.dom.occasionnel.DomLireEltCompare;
import fr.unedic.cali.dom.occasionnel.DomLireIndividusListe;
import fr.unedic.cali.dom.occasionnel.DomLirePopulationsListe;
import fr.unedic.cali.dom.occasionnel.DomLireRapportListe;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LireBaseVisu
  extends BaseVisu
{
  public static final String VRAI = "1";
  public static final String FAUX = "0";
  public static final String SEUIL_POSITIF_500 = "500";
  public static final String SEUIL_POSITIF_100 = "100";
  public static final String SEUIL_NEGATIF_500 = "-500";
  public static final String SEUIL_NEGATIF_100 = "-100";
  private static final String CODE_ANTENNE_INCONNU = "SO";
  private static Map s_mapElementsCompares = null;
  private static final String IDENTIFIANT_SIGMA = "identifiantSigma";
  private static final String IDENTIFIANT_BNI = "identifiantBNI";
  private static final String DELTA_MONTANT_INDEMNISE = "deltaMontantIndemnise";
  private static final String DEMANDES_EN_REEXAMEN = "demandesEnReexamen";
  private static final String CODE_ANTENNE = "codeAntenne";
  private static final String TRI_DECROISSANT = "triDecroissant";
  private static final String EN_COURS_TRAITEMENT = "enCoursTraitement";
  private static final String EN_ATTENTE_TRAITEMENT = "enAttenteTraitement";
  public static final String CLE_INDIVIDUS_COMPTEUR = "compteurPopulation";
  public static final String CLE_INDIVIDUS_LISTE = "listeIndividus";
  private static final String AT1 = "90AT1";
  public static final int TAILLE_MAX_MESSAGE = 100;
  
  public static List chargerRapportsDE(String p_cxass, String p_rsin, String p_antenne, String p_cxala, boolean p_estSimulationChangement)
    throws TechniqueException, CoucheLogiqueException
  {
    List resultat = new ArrayList();
    
    StringBuffer requete = new StringBuffer();
    
    requete.append("SELECT ");
    requete.append(" RAPPORT.FONCT_RAPP_ID, RAPPORT.NOM_CHAINE, RAPPORT.MODE_OCCAS, ");
    requete.append("RAPPORT.DATE_PASSAGE, POP.LIB_POPULATION, POP.CODE_POPULATION ");
    requete.append("FROM P1297B_RAPPORT RAPPORT ");
    requete.append("INNER JOIN P1297E_POPULATION POP ");
    requete.append("ON RAPPORT.CXASS = POP.CXASS ");
    requete.append("AND RAPPORT.FONCT_RAPP_ID = POP.FK_FONCT_RAPP_ID ");
    if ((p_rsin != null) || (p_cxala != null))
    {
      requete.append("INNER JOIN P1297A_INDIVIDU IND ");
      requete.append("ON POP.CXASS = IND.CXASS ");
      requete.append("AND POP.FK_FONCT_RAPP_ID = IND.FK_FONCT_RAPP_ID ");
      requete.append("AND POP.CODE_POPULATION = IND.CODE_POPULATION ");
    }
    else if (p_antenne != null)
    {
      requete.append("INNER JOIN P1297H_STATS_ANTEN STAT ");
      requete.append("ON POP.CXASS = STAT.CXASS ");
      requete.append("AND POP.FK_FONCT_RAPP_ID = STAT.FK_FONCT_RAPP_ID ");
      requete.append("AND POP.CODE_POPULATION = STAT.CODE_POPULATION ");
    }
    requete.append("WHERE '$NCPVisuOccasLireRappCrit' <> 'ReqVisuOccas' ");
    if ((p_cxass != null) && ((p_rsin != null) || (p_antenne != null) || (p_cxala != null)))
    {
      requete.append("AND RAPPORT.CXASS = ? ");
      if (p_rsin != null) {
        requete.append("AND IND.RSIN = ? ");
      } else if (p_cxala != null) {
        requete.append("AND IND.CXALAF = ? ");
      } else if (p_antenne != null) {
        requete.append("AND STAT.COD_ANT = ? ");
      }
    }
    else if (p_cxass != null)
    {
      requete.append("AND RAPPORT.CXASS = ? ");
    }
    requete.append("ORDER BY RAPPORT.DATE_PASSAGE DESC, POP.LIB_POPULATION, RAPPORT.NOM_CHAINE ");
    requete.append("WITH UR;");
    
    Connection connection = getConnection(null);
    PreparedStatement statement = null;
    try
    {
      int idxCxass = 1;
      int idxRsin = 2;
      
      int indexFonctRappId = 1;
      int indexNomChaine = 2;
      int indexModeOccas = 3;
      int indexDatePassage = 4;
      int indexLibPopulation = 5;
      int indexCodePopulation = 6;
      
      statement = connection.prepareStatement(requete.toString());
      if ((p_cxass != null) && ((p_rsin != null) || (p_antenne != null) || (p_cxala != null)))
      {
        statement.setString(1, p_cxass);
        if (p_rsin != null) {
          statement.setString(2, p_rsin);
        } else if (p_cxala != null) {
          statement.setString(2, p_cxala);
        } else if (p_antenne != null) {
          statement.setString(2, p_antenne);
        }
      }
      else if (p_cxass != null)
      {
        statement.setString(1, p_cxass);
      }
      ResultSet set = statement.executeQuery();
      
      Damj datePassage = null;
      String nomChaine = null;
      boolean setIsOpen = true;
      DomLireRapportListe listElt = null;
      List listeLibPopulation = null;
      List listeCodePopulation = null;
      List listeIdRapport = null;
      boolean existeAuMoinsUnePopulation = false;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          if ((nomChaine == null) || (!nomChaine.equals(set.getString(indexNomChaine))) || (datePassage == null) || (!datePassage.coincideAvec(Damj.dateVersDamj(set.getDate(indexDatePassage)))))
          {
            if ((listElt != null) && ((existeAuMoinsUnePopulation) || (listElt.isAffichableSimuChangement())))
            {
              listElt.setListeRapport(listeIdRapport);
              listElt.setCodePopulation(listeCodePopulation);
              listElt.setLibPopulation(listeLibPopulation);
              Iterator ite = resultat.iterator();
              boolean trouve = false;
              while ((ite.hasNext()) && (!trouve))
              {
                DomLireRapportListe rapp = (DomLireRapportListe)ite.next();
                if ((((String)rapp.getLibPopulation().get(0)).compareTo((String)listElt.getLibPopulation().get(0)) == 0) && (rapp.getNomChaine().trim().equals("90AT1"))) {
                  if (rapp.getDatePassage().estAvant(listElt.getDatePassage()))
                  {
                    listElt.getListeRapport().addAll(rapp.getListeRapport());
                    ite.remove();
                  }
                  else
                  {
                    rapp.getListeRapport().addAll(listElt.getListeRapport());
                    trouve = true;
                  }
                }
              }
              if (!trouve) {
                resultat.add(listElt);
              }
            }
            listElt = new DomLireRapportListe();
            listeLibPopulation = new ArrayList();
            listeCodePopulation = new ArrayList();
            listeIdRapport = new ArrayList();
            existeAuMoinsUnePopulation = false;
          }
          listElt.setNomChaine(set.getString(indexNomChaine));
          listElt.setModeOccas(set.getString(indexModeOccas));
          
          PopulationSpec pop = OutilPopulation.getPopulationParHashCode(new BigDecimal(set.getString(indexCodePopulation).trim()).intValue());
          if ((!p_estSimulationChangement) && ((pop == null) || (pop.isEstAffichableIhmVisu())) && (!listeLibPopulation.contains(set.getString(indexLibPopulation))))
          {
            listeLibPopulation.add(set.getString(indexLibPopulation));
            listeCodePopulation.add(set.getString(indexCodePopulation));
            existeAuMoinsUnePopulation = true;
          }
          else if ((p_estSimulationChangement) && ((pop instanceof PopulationSimulationChangementSpec)))
          {
            listeLibPopulation.add(set.getString(indexLibPopulation));
            listeCodePopulation.add(set.getString(indexCodePopulation));
            listElt.setAffichableSimuChangement(true);
          }
          listElt.setFonctRappId(set.getBigDecimal(indexFonctRappId));
          listElt.setDatePassage(Damj.dateVersDamj(set.getDate(indexDatePassage)));
          listeIdRapport.add(set.getBigDecimal(indexFonctRappId));
          
          datePassage = Damj.dateVersDamj(set.getDate(indexDatePassage));
          nomChaine = set.getString(indexNomChaine);
        }
      }
      if ((listElt != null) && ((existeAuMoinsUnePopulation) || (listElt.isAffichableSimuChangement())))
      {
        listElt.setListeRapport(listeIdRapport);
        listElt.setCodePopulation(listeCodePopulation);
        listElt.setLibPopulation(listeLibPopulation);
        resultat.add(listElt);
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeConnexionStatement(connection, statement);
    }
    return resultat;
  }
  
  public static List chargerPopulations(String p_cxass, List p_listeIdRapport, String p_codePopulation, boolean p_estDsi)
    throws CoucheLogiqueException, TechniqueException
  {
    List resultat = new ArrayList();
    
    Connection connection = getConnection(null);
    PreparedStatement statement = null;
    String requete = null;
    
    String paramIdRapport = "(";
    for (int i = 0; i < p_listeIdRapport.size(); i++) {
      paramIdRapport = paramIdRapport + p_listeIdRapport.get(i).toString() + ", ";
    }
    paramIdRapport = paramIdRapport.substring(0, paramIdRapport.length() - 2);
    paramIdRapport = paramIdRapport + ") ";
    try
    {
      int idxCxassOuNomChaine = 1;
      int idxCodePopulation = 2;
      
      requete = getRequeteChargerPopulation(p_estDsi);
      requete = requete.replaceFirst("paramListeRapport", paramIdRapport);
      
      statement = connection.prepareStatement(requete);
      statement.setString(1, p_cxass);
      statement.setString(2, p_codePopulation);
      ResultSet set = statement.executeQuery();
      
      resultat = executerChargementPopulation(set, connection, statement, p_cxass, p_codePopulation);
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeConnexionStatement(connection, statement);
    }
    return resultat;
  }
  
  public static List chargerPopulations(List p_listeIdRapport, String p_codePopulation)
    throws CoucheLogiqueException, TechniqueException
  {
    List resultat = new ArrayList();
    
    String paramIdRapport = "(";
    for (int i = 0; i < p_listeIdRapport.size(); i++) {
      paramIdRapport = paramIdRapport + p_listeIdRapport.get(i).toString() + ", ";
    }
    paramIdRapport = paramIdRapport.substring(0, paramIdRapport.length() - 2);
    paramIdRapport = paramIdRapport + ") ";
    
    Connection connection = getConnection(null);
    PreparedStatement statement = null;
    String requete = null;
    try
    {
      int idxCodePopulation = 1;
      requete = getRequeteChargerPopulation(true);
      
      requete = requete.replaceFirst("paramListeRapport", paramIdRapport);
      
      statement = connection.prepareStatement(requete);
      statement.setString(1, p_codePopulation);
      ResultSet set = statement.executeQuery();
      
      resultat = executerChargementPopulation(set, connection, statement, null, p_codePopulation);
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeConnexionStatement(connection, statement);
    }
    return resultat;
  }
  
  private static List executerChargementPopulation(ResultSet p_resultatSet, Connection p_connection, PreparedStatement p_statement, String p_cxass, String p_codePopulation)
    throws CoucheLogiqueException, TechniqueException
  {
    List resultat = new ArrayList();
    try
    {
      int indexReexamDecMig = 1;
      int indexReexecDecMig = 2;
      int indexTypeMandatement = 3;
      int indexAppliPremDec = 4;
      int indexCxass = 5;
      
      int indicateurVariable = 5;
      if ((p_cxass == null) || (p_cxass.equals(""))) {
        indicateurVariable = 6;
      }
      int indexFonctRappId = indicateurVariable;
      int indexCodeAntenne = indicateurVariable + 1;
      int indexDeltaMtNeg = indicateurVariable + 2;
      int indexDeltaMtPos = indicateurVariable + 3;
      int indexDeReexam = indicateurVariable + 4;
      int indexDeReexec = indicateurVariable + 5;
      int indexDeTraites = indicateurVariable + 6;
      int indexDeltaMtTranche1 = indicateurVariable + 7;
      int indexDeltaMtTranche2 = indicateurVariable + 8;
      int indexDeltaMtTranche3 = indicateurVariable + 9;
      int indexDeltaMtTranche4 = indicateurVariable + 10;
      int indexDeltaMtTranche5 = indicateurVariable + 11;
      int indexDeltaMtTranche6 = indicateurVariable + 12;
      int indexDeltaMtTranche7 = indicateurVariable + 13;
      int indexDeltaMtTranche8 = indicateurVariable + 14;
      int indexSommeDeltaMtNeg = indicateurVariable + 15;
      int indexSommeDeltaMtPos = indicateurVariable + 16;
      int indexLibPopulation = indicateurVariable + 17;
      int indexDatePassage = indicateurVariable + 18;
      int indexConsigne1 = indicateurVariable + 19;
      int indexConsigne2 = indicateurVariable + 20;
      int indexConsigne3 = indicateurVariable + 21;
      int indexDateTraitement = indicateurVariable + 22;
      
      int indexDeltaMtCadt = 0;
      int indexDeltaMtCrc = 1;
      int indexDeltaMtFinan = 2;
      
      Damj datePassage = null;
      Damj dateTraitement = null;
      boolean setIsOpen = true;
      DomLirePopulationsListe listEltPop = null;
      while (setIsOpen)
      {
        setIsOpen = p_resultatSet.next();
        if (setIsOpen)
        {
          listEltPop = new DomLirePopulationsListe();
          datePassage = Damj.dateVersDamj(p_resultatSet.getDate(indexDatePassage));
          listEltPop.setDatePassage(datePassage);
          listEltPop.setLibPopulation(p_resultatSet.getString(indexLibPopulation));
          listEltPop.setCodePopulation(p_codePopulation);
          if ((p_cxass != null) && (!p_cxass.equals(""))) {
            listEltPop.setCxass(p_cxass);
          } else {
            listEltPop.setCxass(p_resultatSet.getString(5));
          }
          listEltPop.setFonctRappId(p_resultatSet.getBigDecimal(indexFonctRappId));
          listEltPop.setReexamDecMig(p_resultatSet.getString(1));
          listEltPop.setReexecDecMig(evaluerBooleanValue(p_resultatSet.getString(2)));
          listEltPop.setTypeMandatement(p_resultatSet.getString(3));
          listEltPop.setAppliPremDec(evaluerBooleanValue(p_resultatSet.getString(4)));
          List listeEltCompare = chargerEltCompare(listEltPop.getCxass(), listEltPop.getFonctRappId(), p_codePopulation, p_connection);
          listEltPop.setListeEltCompare(listeEltCompare);
          listEltPop.setCodeAntenne(p_resultatSet.getString(indexCodeAntenne));
          listEltPop.setDeltaMontantBrutNegatif(p_resultatSet.getBigDecimal(indexDeltaMtNeg));
          listEltPop.setDeltaMontantBrutPositif(p_resultatSet.getBigDecimal(indexDeltaMtPos));
          listEltPop.setNbReexamen(p_resultatSet.getBigDecimal(indexDeReexam));
          listEltPop.setNbReexecutes(p_resultatSet.getBigDecimal(indexDeReexec));
          listEltPop.setNbDeTraites(p_resultatSet.getBigDecimal(indexDeTraites));
          BigDecimal nbDeEcartes = listEltPop.getNbDeTraites();
          if (nbDeEcartes != null)
          {
            if (listEltPop.getNbReexamen() != null) {
              nbDeEcartes = nbDeEcartes.subtract(listEltPop.getNbReexamen());
            }
            if (listEltPop.getNbReexecutes() != null) {
              nbDeEcartes = nbDeEcartes.subtract(listEltPop.getNbReexecutes());
            }
          }
          else
          {
            nbDeEcartes = BigDecimal.ZERO;
          }
          listEltPop.setNbDeEcartes(nbDeEcartes);
          listEltPop.setNbDeltaMtTranche1(p_resultatSet.getBigDecimal(indexDeltaMtTranche1));
          listEltPop.setNbDeltaMtTranche2(p_resultatSet.getBigDecimal(indexDeltaMtTranche2));
          listEltPop.setNbDeltaMtTranche3(p_resultatSet.getBigDecimal(indexDeltaMtTranche3));
          listEltPop.setNbDeltaMtTranche4(p_resultatSet.getBigDecimal(indexDeltaMtTranche4));
          listEltPop.setNbDeltaMtTranche5(p_resultatSet.getBigDecimal(indexDeltaMtTranche5));
          listEltPop.setNbDeltaMtTranche6(p_resultatSet.getBigDecimal(indexDeltaMtTranche6));
          listEltPop.setNbDeltaMtTranche7(p_resultatSet.getBigDecimal(indexDeltaMtTranche7));
          listEltPop.setNbDeltaMtTranche8(p_resultatSet.getBigDecimal(indexDeltaMtTranche8));
          listEltPop.setSommeDeltaMtNeg(p_resultatSet.getBigDecimal(indexSommeDeltaMtNeg));
          listEltPop.setSommeDeltaMtPos(p_resultatSet.getBigDecimal(indexSommeDeltaMtPos));
          
          List listeNbDeltasMontantsPop = chargerDeltasMontantsPopulation(listEltPop.getCxass(), listEltPop.getCodeAntenne(), p_codePopulation, listEltPop.getFonctRappId(), p_connection);
          
          listEltPop.setDeltaMontantBrutCadt((BigDecimal)listeNbDeltasMontantsPop.get(0));
          listEltPop.setDeltaMontantBrutCrc((BigDecimal)listeNbDeltasMontantsPop.get(1));
          listEltPop.setDeltaMontantBrutFinancement((BigDecimal)listeNbDeltasMontantsPop.get(2));
          listEltPop.setConsigne1(p_resultatSet.getString(indexConsigne1));
          listEltPop.setConsigne2(p_resultatSet.getString(indexConsigne2));
          listEltPop.setConsigne3(p_resultatSet.getString(indexConsigne3));
          dateTraitement = Damj.dateVersDamj(p_resultatSet.getDate(indexDateTraitement));
          listEltPop.setDateTraitement(dateTraitement);
          
          listEltPop.setDateTraitement(dateTraitement);
          
          resultat.add(listEltPop);
        }
      }
      videMapElementsCompares();
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(p_statement);
    }
    return resultat;
  }
  
  private static List chargerEltCompare(String p_cxass, BigDecimal p_fonctRappId, String p_codePopulation, Connection p_connection)
    throws CoucheLogiqueException, TechniqueException
  {
    List resultat = new ArrayList();
    Map mapElementsCompares = getMapElementsCompares();
    if ((mapElementsCompares.get(p_codePopulation + p_cxass + p_fonctRappId.toString()) != null) && (!((List)mapElementsCompares.get(p_codePopulation + p_cxass + p_fonctRappId.toString())).isEmpty()))
    {
      resultat = (List)mapElementsCompares.get(p_codePopulation + p_cxass + p_fonctRappId.toString());
    }
    else
    {
      String requete = "SELECT NUM_ELEMENT FROM P1297C_ELT_EXCLU WHERE '$NCPVisuOccasEltExcl' <> 'ReqVisuOccas' AND CXASS = ? AND FK_FONCT_RAPP_ID = ? AND CODE_POPULATION = ? WITH UR;";
      
      PreparedStatement statement = null;
      try
      {
        int idxCxass = 1;
        int idxFonctRappId = 2;
        int idxCodePopulation = 3;
        int indexNumElement = 1;
        statement = p_connection.prepareStatement(requete);
        statement.setString(1, p_cxass);
        statement.setBigDecimal(2, p_fonctRappId);
        statement.setString(3, p_codePopulation);
        ResultSet set = statement.executeQuery();
        boolean setIsOpen = true;
        
        List listeEltExclus = new ArrayList();
        List listeEltCompare = new ArrayList();
        while (setIsOpen)
        {
          setIsOpen = set.next();
          if (setIsOpen) {
            listeEltExclus.add(set.getBigDecimal(1));
          }
        }
        Field[] listeAttributs = Class.forName(ComparateurDecisionSpec.class.getName()).getDeclaredFields();
        int taille = listeAttributs.length;
        String valeurChamp = null;
        for (int j = 0; j < taille; j++)
        {
          boolean estExclu = false;
          Field attribut = listeAttributs[j];
          
          Iterator iterateur = listeEltExclus.iterator();
          while ((iterateur.hasNext()) && (!estExclu))
          {
            String libelle = OutilVisualisation.getLibelleElement(((BigDecimal)iterateur.next()).intValue());
            if (attribut.getName().startsWith("LIB_"))
            {
              valeurChamp = attribut.get(ComparateurDecisionSpec.class).toString();
              if (valeurChamp.equals(libelle)) {
                estExclu = true;
              }
            }
            else if (!attribut.getName().startsWith("ERR_"))
            {
              estExclu = true;
            }
          }
          if ((!estExclu) && (attribut != null)) {
            listeEltCompare.add(new BigDecimal(attribut.get(ComparateurDecisionSpec.class).toString().hashCode()));
          }
        }
        for (int i = 0; i < listeEltCompare.size(); i++)
        {
          DomLireEltCompare listElt = new DomLireEltCompare();
          listElt.setNumElement((BigDecimal)listeEltCompare.get(i));
          resultat.add(listElt);
        }
        ajouteElementsCompares(p_codePopulation + p_cxass + p_fonctRappId.toString(), resultat);
      }
      catch (SQLException e)
      {
        traiterExceptionSQL(e);
      }
      catch (ClassNotFoundException ex)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_OCCASL_INSC_COMPORTEMENT_LIQ", "Erreur produit lors de la récupération des élements de comparaison à exclure pour le comportement occasionnel liquidation", ex);
      }
      catch (IllegalAccessException ex)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_OCCASL_INSC_COMPORTEMENT_LIQ", "Erreur produit lors de la récupération des élements de comparaison à exclure pour le comportement occasionnel liquidation", ex);
      }
      finally
      {
        closeStatement(statement);
      }
    }
    return resultat;
  }
  
  public static Map chargerIndividus(String p_cxass, BigDecimal p_fonctRappId, String p_codePopulation, String p_rsin, boolean p_chargerEltComp, boolean p_estFiltreDeDeltaMontantIndemnise, boolean p_estFiltreDeDeltaMontantFinancement, boolean p_estFiltreDeDeltaMontantCadt, boolean p_estFiltreDeDeltaMontantCrc, boolean p_estFiltreDeReexamen, String p_antenne, int p_indexDepart, int p_tailleIndividus, BigDecimal p_demandeId, String p_champATrier, String p_sensTri, List p_paramIdRapport)
    throws CoucheLogiqueException, TechniqueException
  {
    return chargerIndividus(p_cxass, p_fonctRappId, p_codePopulation, p_rsin, p_chargerEltComp, p_estFiltreDeDeltaMontantIndemnise, p_estFiltreDeDeltaMontantFinancement, p_estFiltreDeDeltaMontantCadt, p_estFiltreDeDeltaMontantCrc, p_estFiltreDeReexamen, p_antenne, p_indexDepart, p_tailleIndividus, null, p_demandeId, p_champATrier, p_sensTri, p_paramIdRapport);
  }
  
  private static Map chargerIndividus(String p_cxass, BigDecimal p_fonctRappId, String p_codePopulation, String p_rsin, boolean p_chargerEltComp, boolean p_estFiltreDeDeltaMontantIndemnise, boolean p_estFiltreDeDeltaMontantFinancement, boolean p_estFiltreDeDeltaMontantCadt, boolean p_estFiltreDeDeltaMontantCrc, boolean p_estFiltreDeReexamen, String p_antenne, int p_indexDepart, int p_tailleIndividus, String p_modeTransaction, BigDecimal p_demandeId, String p_champATrier, String p_sensTri, List p_listeIdRapport)
    throws CoucheLogiqueException, TechniqueException
  {
    Map resultat = new HashMap();
    List listeIndividus = new ArrayList();
    if (p_antenne == null)
    {
      if ((p_cxass == null) || (p_cxass.equals(""))) {
        throw new CoucheLogiqueException("ERR_OCCAS_PARAM_NULL", "Le paramètre p_cxass ne peut être null ou vide");
      }
      if (p_fonctRappId == null) {
        throw new CoucheLogiqueException("ERR_OCCAS_PARAM_NULL", "Le paramètre p_fonctRappId ne peut être null ou vide");
      }
      if ((p_codePopulation == null) || (p_codePopulation.equals(""))) {
        throw new CoucheLogiqueException("ERR_OCCAS_PARAM_NULL", "Le paramètre p_codePopulation ne peut être null ou vide");
      }
    }
    else if (p_antenne.equals(""))
    {
      throw new CoucheLogiqueException("ERR_OCCAS_PARAM_NULL", "Le paramètre p_antenne ne peut être null ou vide");
    }
    String paramIdRapport = null;
    if (p_listeIdRapport != null)
    {
      paramIdRapport = "(";
      for (int i = 0; i < p_listeIdRapport.size(); i++) {
        paramIdRapport = paramIdRapport + p_listeIdRapport.get(i).toString() + ", ";
      }
      paramIdRapport = paramIdRapport.substring(0, paramIdRapport.length() - 2);
      paramIdRapport = paramIdRapport + ") ";
    }
    else
    {
      paramIdRapport = "(";
      paramIdRapport = paramIdRapport + p_fonctRappId.toString();
      paramIdRapport = paramIdRapport + ") ";
    }
    String requete = getRequeteChargementIndividu(p_rsin, p_estFiltreDeDeltaMontantIndemnise, p_estFiltreDeDeltaMontantFinancement, p_estFiltreDeDeltaMontantCadt, p_estFiltreDeDeltaMontantCrc, p_estFiltreDeReexamen, p_antenne, p_champATrier, p_sensTri, paramIdRapport);
    
    Connection connection = getConnection(p_modeTransaction);
    PreparedStatement statement = null;
    try
    {
      int idxCxassOuAntenne = 1;
      int idxCxassEtAntenne = 2;
      int idxCodePop = 2;
      int idxCodePopulation = 3;
      int idxRsin = 3;
      
      int indexCxalaf = 1;
      int indexRsin = 2;
      int indexModeCreation = 3;
      int indexDeltaMtIndemnise = 4;
      int indexDateReexecution = 5;
      int indexCodeAntenne = 6;
      int indexEtatReexam = 7;
      int indexDeltaMtCadt = 8;
      int indexDeltaMtCrc = 9;
      int indexDeltaMtFinan = 10;
      int datePassage = 11;
      int indexFonctRappId = 12;
      int indexCommentaire = 13;
      int indexEtat = 14;
      
      statement = connection.prepareStatement(requete);
      if (p_antenne != null)
      {
        statement.setString(2, p_antenne);
        statement.setString(1, p_cxass);
        statement.setString(3, p_codePopulation);
      }
      else
      {
        statement.setString(1, p_cxass);
        statement.setString(2, p_codePopulation);
      }
      if (p_rsin != null) {
        statement.setString(3, p_rsin);
      }
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      DomLireIndividusListe listElt = null;
      BigDecimal cxalaf = null;
      List listeDemandes = new ArrayList();
      int compteur = 0;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          compteur++;
          if ((compteur >= p_indexDepart) && (compteur <= p_tailleIndividus))
          {
            if ((cxalaf == null) || (cxalaf.compareTo(set.getBigDecimal(1)) != 0))
            {
              listElt = new DomLireIndividusListe();
              listElt.setNbDemandes(BigDecimal.ZERO);
              listElt.setCxass(p_cxass);
              listElt.setFonctRappId(set.getBigDecimal(12));
              listElt.setCodePopulation(p_codePopulation);
              listElt.setCxalaf(set.getBigDecimal(1));
              listElt.setRsin(set.getString(2));
              listElt.setModeCreation(set.getString(3));
              listElt.setDeltaMtIndemnise(set.getBigDecimal(4));
              listElt.setDeltaMtFinancement(set.getBigDecimal(10));
              listElt.setDeltaMtCadt(set.getBigDecimal(8));
              listElt.setDeltaMtCrc(set.getBigDecimal(9));
              listElt.setDateReexamen(Damj.dateVersDamj(set.getDate(5)));
              listElt.setDatePassage(Damj.dateVersDamj(set.getDate(11)));
              listElt.setCommentaire(set.getString(13));
              listElt.setEtat(set.getInt(14));
              if ((set.getString(6) != null) && (!set.getString(6).equals(""))) {
                listElt.setAntenne(set.getString(6));
              } else {
                listElt.setAntenne("SO");
              }
              listeDemandes = new ArrayList();
              listeIndividus.add(listElt);
            }
            if (isDEReexamen(set.getString(7))) {
              listElt.setNbDemandes(BigDecimal.ONE);
            }
            if ((p_rsin != null) && (!p_rsin.equals(""))) {
              if (p_demandeId != null) {
                listeDemandes.addAll(chargerDemandes(p_cxass, p_fonctRappId, p_codePopulation, set.getBigDecimal(1), p_demandeId, p_chargerEltComp, connection));
              } else {
                listeDemandes.addAll(chargerDemandes(p_cxass, p_fonctRappId, p_codePopulation, set.getBigDecimal(1), null, p_chargerEltComp, connection));
              }
            }
            listElt.setListeDemandes(listeDemandes);
            cxalaf = set.getBigDecimal(1);
          }
        }
      }
      resultat.put("compteurPopulation", Integer.valueOf(compteur));
      resultat.put("listeIndividus", listeIndividus);
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeConnexionStatement(connection, statement);
    }
    return resultat;
  }
  
  public static List chargerIndividus(String p_cxass, BigDecimal p_fonctRappId, String p_codePopulation, String p_rsin, boolean p_chargerEltComp, boolean p_estFiltreDeDeltaMontantIndemnise, boolean p_estFiltreDeDeltaMontantFinancement, boolean p_estFiltreDeDeltaMontantCadt, boolean p_estFiltreDeDeltaMontantCrc, boolean p_estFiltreDeReexamen, String p_antenne, int p_indexDepart, int p_tailleIndividus, String p_modeTransaction)
    throws CoucheLogiqueException, TechniqueException
  {
    Map mapChargementIndividus = chargerIndividus(p_cxass, p_fonctRappId, p_codePopulation, p_rsin, p_chargerEltComp, p_estFiltreDeDeltaMontantIndemnise, p_estFiltreDeDeltaMontantFinancement, p_estFiltreDeDeltaMontantCadt, p_estFiltreDeDeltaMontantCrc, p_estFiltreDeReexamen, p_antenne, p_indexDepart, p_tailleIndividus, p_modeTransaction, null, null, null, new ArrayList());
    
    return (List)mapChargementIndividus.get("listeIndividus");
  }
  
  private static final String getRequeteChargementIndividu(String p_rsin, boolean p_estFiltreDeDeltaMontantIndemnise, boolean p_estFiltreDeDeltaMontantFinancement, boolean p_estFiltreDeDeltaMontantCadt, boolean p_estFiltreDeDeltaMontantCrc, boolean p_estFiltreDeReexamen, String p_antenne, String p_champATrier, String p_sensTri, String p_paramIdRapport)
  {
    String requete = "SELECT IND.CXALAF, IND.RSIN, IND.MODE_CREATION, IND.DELTA_MT_BRUT, IND.DATE_REEXECUTION, IND.COD_ANT, IND.ETAT_INDIVIDU, IND.DELTA_MT_CADT, IND.DELTA_MT_CRC, IND.DELTA_MT_FINAN, RAP.DATE_PASSAGE, IND.FK_FONCT_RAPP_ID, IND.COMMENTAIRE, IND.ETAT FROM  P1297A_INDIVIDU IND INNER JOIN P1297B_RAPPORT RAP ON IND.CXASS = RAP.CXASS  AND IND.FK_FONCT_RAPP_ID = RAP.FONCT_RAPP_ID WHERE '$NCPVisuOccasLireInd' <> 'ReqVisuOccas'  AND IND.ETAT_INDIVIDU <> '1' ";
    if (p_antenne == null) {
      requete = requete + "AND IND.CXASS = ? AND IND.FK_FONCT_RAPP_ID IN " + p_paramIdRapport + " AND IND.CODE_POPULATION = ? ";
    } else if (p_paramIdRapport != null) {
      requete = requete + "AND IND.CXASS = ? AND IND.COD_ANT = ?  AND IND.CODE_POPULATION = ? AND IND.FK_FONCT_RAPP_ID IN " + p_paramIdRapport;
    } else {
      requete = requete + "AND IND.CXASS = ? AND IND.COD_ANT = ? AND IND.CODE_POPULATION = ? ";
    }
    boolean estFiltreEnCoursTraitement = false;
    boolean estFiltreEnAttenteTraitement = false;
    
    String cleFiltreReexamen = "filtreReexamen";
    String cleFiltreDeltaMontantIndemnisee = "deltaMontantIndemnise";
    String cleFiltreDeltaMontantFinancement = "deltaMontantFinancement";
    String cleFiltreDeltaMontantCadt = "deltaMontantCadt";
    String cleFiltreDeltaMontantCrc = "deltaMontantCrc";
    String cleFiltreEnCoursTraitement = "filtreEnCoursTraitement";
    String cleFiltreEnAttenteTraitement = "filtreEnAttenteTraitement";
    if ((p_champATrier != null) && (p_champATrier.split(";").length == 2))
    {
      estFiltreEnCoursTraitement = true;
      estFiltreEnAttenteTraitement = true;
    }
    else if ((p_champATrier != null) && ("enCoursTraitement".equalsIgnoreCase(p_champATrier.split(";")[0])))
    {
      estFiltreEnCoursTraitement = true;
    }
    else if ((p_champATrier != null) && ("enAttenteTraitement".equalsIgnoreCase(p_champATrier.split(";")[0])))
    {
      estFiltreEnAttenteTraitement = true;
    }
    Map filtresActifs = new HashMap();
    filtresActifs.put(cleFiltreReexamen, Boolean.valueOf(p_estFiltreDeReexamen));
    filtresActifs.put(cleFiltreDeltaMontantIndemnisee, Boolean.valueOf(p_estFiltreDeDeltaMontantIndemnise));
    filtresActifs.put(cleFiltreDeltaMontantFinancement, Boolean.valueOf(p_estFiltreDeDeltaMontantFinancement));
    filtresActifs.put(cleFiltreDeltaMontantCadt, Boolean.valueOf(p_estFiltreDeDeltaMontantCadt));
    filtresActifs.put(cleFiltreDeltaMontantCrc, Boolean.valueOf(p_estFiltreDeDeltaMontantCrc));
    filtresActifs.put(cleFiltreEnCoursTraitement, Boolean.valueOf(estFiltreEnCoursTraitement));
    filtresActifs.put(cleFiltreEnAttenteTraitement, Boolean.valueOf(estFiltreEnAttenteTraitement));
    
    String filtreSurReexamen = "(IND.ETAT_INDIVIDU = 'R') ";
    String filtreSurDeltaMontantIndemnise = "(IND.DELTA_MT_BRUT <> 0 AND IND.DELTA_MT_BRUT IS NOT NULL) ";
    String filtreSurDeltaMontantFinancement = "(IND.DELTA_MT_FINAN <> 0 AND IND.DELTA_MT_FINAN IS NOT NULL) ";
    String filtreSurDeltaMontantCadt = "(IND.DELTA_MT_CADT <> 0 AND IND.DELTA_MT_CADT IS NOT NULL) ";
    String filtreSurDeltaMontantCrc = "(IND.DELTA_MT_CRC <> 0 AND IND.DELTA_MT_CRC IS NOT NULL) ";
    
    String filtreSurEncoursTraitement = "(IND.ETAT = 1) ";
    String filtreSurEnAttenteTraitement = "(IND.ETAT = 0 OR IND.ETAT IS NULL) ";
    
    Map filtresContenus = new HashMap();
    filtresContenus.put(cleFiltreReexamen, filtreSurReexamen);
    filtresContenus.put(cleFiltreDeltaMontantIndemnisee, filtreSurDeltaMontantIndemnise);
    filtresContenus.put(cleFiltreDeltaMontantFinancement, filtreSurDeltaMontantFinancement);
    filtresContenus.put(cleFiltreDeltaMontantCadt, filtreSurDeltaMontantCadt);
    filtresContenus.put(cleFiltreDeltaMontantCrc, filtreSurDeltaMontantCrc);
    filtresContenus.put(cleFiltreEnCoursTraitement, filtreSurEncoursTraitement);
    filtresContenus.put(cleFiltreEnAttenteTraitement, filtreSurEnAttenteTraitement);
    
    StringBuffer filtreRequete = new StringBuffer();
    Iterator iterateurListeCles = filtresActifs.keySet().iterator();
    while (iterateurListeCles.hasNext())
    {
      String filtreAEtudier = (String)iterateurListeCles.next();
      Boolean priseEnCompteFiltre = (Boolean)filtresActifs.get(filtreAEtudier);
      if (priseEnCompteFiltre.booleanValue())
      {
        if (!filtreRequete.toString().equals("")) {
          filtreRequete = filtreRequete.append(" OR ");
        }
        filtreRequete = filtreRequete.append(filtresContenus.get(filtreAEtudier));
      }
    }
    if (!filtreRequete.toString().equals("")) {
      requete = requete + " AND ( " + filtreRequete.toString() + ") ";
    }
    if (p_rsin != null) {
      requete = requete + "AND IND.RSIN = ? ";
    }
    if ("codeAntenne".equals(p_champATrier)) {
      requete = requete + "ORDER BY IND.COD_ANT ";
    } else if ("identifiantSigma".equals(p_champATrier)) {
      requete = requete + "ORDER BY IND.RSIN ";
    } else if ("identifiantBNI".equals(p_champATrier)) {
      requete = requete + "ORDER BY IND.CXALAF ";
    } else if ("deltaMontantIndemnise".equals(p_champATrier)) {
      requete = requete + "ORDER BY IND.DELTA_MT_BRUT ";
    } else if ("demandesEnReexamen".equals(p_champATrier)) {
      requete = requete + "ORDER BY IND.ETAT_INDIVIDU ";
    } else {
      requete = requete + "ORDER BY IND.DELTA_MT_BRUT ";
    }
    if ("triDecroissant".equals(p_sensTri)) {
      requete = requete + "DESC ";
    }
    requete = requete + "WITH UR;";
    return requete;
  }
  
  public static List chargerDemandes(String p_cxass, BigDecimal p_fonctRappId, String p_codePopulation, BigDecimal p_cxalaf, BigDecimal p_demandeId, boolean p_chargerEltComp, Connection p_connection)
    throws CoucheLogiqueException, TechniqueException
  {
    List listeDemandes = new ArrayList();
    DomLireDemandesListe listElt = null;
    
    StringBuffer requete = new StringBuffer();
    requete.append("SELECT DEMANDE_ID,EST_IMPACTE,ETAT_REEXAM,EST_REEXECUTE,DATE_ATTRIB,CODE_PRODUIT,TYPE_DECIS,TYPE_DEMANDE,DELTA_PJI,DELTA_DJI,EST_MIGREE,EST_NEUTRALISEE,EST_FIGEE,TSP ");
    requete.append("FROM P1297F_DEMANDE ");
    requete.append("WHERE '$NCPVisuOccasLireDem' <> 'ReqVisuOccas' ");
    requete.append("AND CXASS = ? ");
    requete.append("AND FK_FONCT_RAPP_ID = ? ");
    requete.append("AND CODE_POPULATION = ? ");
    requete.append("AND CXALAF = ? ");
    if (p_demandeId != null) {
      requete.append("AND DEMANDE_ID = ? ");
    }
    requete.append("ORDER BY DATE_ATTRIB DESC ");
    requete.append("WITH UR;");
    
    PreparedStatement statement = null;
    try
    {
      int idxCxass = 1;
      int idxFonctRappId = 2;
      int idxCodePopulation = 3;
      int idxCxalaf = 4;
      int idxDemande = 5;
      
      int indexDemandeId = 1;
      int indexEstImpacte = 2;
      int indexEtatReexamen = 3;
      int indexEstReexecute = 4;
      int indexDateAttrib = 5;
      int indexCodeProduit = 6;
      int indexTypeDecis = 7;
      int indexTypeDemande = 8;
      int indexDeltaPji = 9;
      int indexDeltaDji = 10;
      
      int indexEstMigree = 11;
      int indexEstNeutralisee = 12;
      int indexEstFigee = 13;
      
      statement = p_connection.prepareStatement(requete.toString());
      statement.setString(1, p_cxass);
      statement.setBigDecimal(2, p_fonctRappId);
      statement.setString(3, p_codePopulation);
      statement.setBigDecimal(4, p_cxalaf);
      if (p_demandeId != null) {
        statement.setBigDecimal(5, p_demandeId);
      }
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          listElt = new DomLireDemandesListe();
          
          listElt.setCxass(p_cxass);
          listElt.setFonctRappId(p_fonctRappId);
          listElt.setCodePopulation(p_codePopulation);
          listElt.setCxalaf(p_cxalaf);
          listElt.setDemandeId(set.getBigDecimal(1));
          
          String etatReexamen = set.getString(3);
          listElt.setEstDecis(true);
          if ("O".equalsIgnoreCase(etatReexamen)) {
            listElt.setEstDecis(false);
          }
          listElt.setEtatReexamen(etatReexamen);
          listElt.setEstImpacte(evaluerBooleanValue(set.getString(2)));
          listElt.setEstReexecute(evaluerBooleanValue(set.getString(4)));
          listElt.setEstMigree(evaluerBooleanValue(set.getString(11)));
          listElt.setEstNeutralisee(evaluerBooleanValue(set.getString(12)));
          listElt.setEstFigee(evaluerBooleanValue(set.getString(13)));
          
          listElt.setDateAttrib(Damj.dateVersDamj(set.getDate(5)));
          listElt.setCodeProduit(set.getBigDecimal(6));
          listElt.setTypeDecis(set.getString(7));
          listElt.setTypeDemande(set.getString(8));
          listElt.setDeltaPji(set.getBigDecimal(9));
          listElt.setDeltaDji(set.getBigDecimal(10));
          
          List listeEltComp = new ArrayList();
          if ((p_chargerEltComp) || (p_demandeId != null)) {
            listeEltComp = chargerEltComp(p_cxass, p_fonctRappId, p_codePopulation, p_cxalaf, set.getBigDecimal(1), p_connection);
          }
          listElt.setListeEltComp(listeEltComp);
          listeDemandes.add(listElt);
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
    return listeDemandes;
  }
  
  public static List chargerEltComp(String p_cxass, BigDecimal p_fonctRappId, String p_codePopulation, BigDecimal p_cxalaf, BigDecimal p_demandeId, Connection p_connection)
    throws CoucheLogiqueException, TechniqueException
  {
    List resultat = new ArrayList();
    
    StringBuffer requete = new StringBuffer();
    requete.append("SELECT NUM_ELEMENT, VALEUR_AVANT, VALEUR_APRES, LIB_ELEMENT ");
    requete.append("FROM P1297D_ELT_COMP ");
    requete.append("WHERE CXASS = ? ");
    requete.append("AND FK_FONCT_RAPP_ID = ? ");
    requete.append("AND CODE_POPULATION = ? ");
    requete.append("AND CXALAF = ? ");
    requete.append("AND FK_DEMANDE_ID = ? ");
    requete.append("WITH UR;");
    
    PreparedStatement statement = null;
    try
    {
      int idxCxass = 1;
      int idxFonctRappId = 2;
      int idxCodePopulation = 3;
      int idxCxalaf = 4;
      int idxDemandeId = 5;
      
      int indexNumElement = 1;
      int indexLibElement = 4;
      int indexValeurAvant = 2;
      int indexValeurApres = 3;
      
      statement = p_connection.prepareStatement(requete.toString());
      statement.setString(1, p_cxass);
      statement.setBigDecimal(2, p_fonctRappId);
      statement.setString(3, p_codePopulation);
      statement.setBigDecimal(4, p_cxalaf);
      statement.setBigDecimal(5, p_demandeId);
      
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          DomLireEltCompListe listElt = new DomLireEltCompListe();
          listElt.setNumElement(set.getBigDecimal(1));
          listElt.setValeurAvant(set.getString(2));
          listElt.setValeurApres(set.getString(3));
          listElt.setLibElement(set.getString(4));
          resultat.add(listElt);
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
    return resultat;
  }
  
  public static List chargerEltReex(List p_listeIdRapport, String p_codePopulation)
    throws CoucheLogiqueException, TechniqueException
  {
    List resultat = new ArrayList();
    
    String paramIdRapport = "(";
    for (int i = 0; i < p_listeIdRapport.size(); i++) {
      paramIdRapport = paramIdRapport + p_listeIdRapport.get(i).toString() + ", ";
    }
    paramIdRapport = paramIdRapport.substring(0, paramIdRapport.length() - 2);
    paramIdRapport = paramIdRapport + ") ";
    
    StringBuffer requete = new StringBuffer();
    requete.append("SELECT count(distinct ELTCOMP.CXALAF), ELTCOMP.LIB_ELEMENT");
    requete.append(" FROM P1297D_ELT_COMP ELTCOMP ");
    requete.append(" INNER JOIN P1297F_DEMANDE DEM ");
    requete.append(" ON ELTCOMP.CXASS= DEM.CXASS ");
    requete.append(" AND ELTCOMP.CXALAF = DEM.CXALAF ");
    requete.append(" AND ELTCOMP.FK_DEMANDE_ID = DEM.DEMANDE_ID ");
    requete.append(" WHERE '$NCPVisuOccasEltReex' <> 'ReqVisuOccas' ");
    requete.append(" AND ELTCOMP.FK_FONCT_RAPP_ID in " + paramIdRapport);
    requete.append(" AND ELTCOMP.CODE_POPULATION = ? ");
    requete.append(" AND DEM.ETAT_REEXAM = 'R' ");
    requete.append(" group by ELTCOMP.LIB_ELEMENT ");
    requete.append(" WITH UR;");
    
    Connection connection = getConnection(null);
    PreparedStatement statement = null;
    try
    {
      int idxCodePopulation = 1;
      
      int indexNbCxalaf = 1;
      int indexLibElement = 2;
      
      statement = connection.prepareStatement(requete.toString());
      statement.setString(1, p_codePopulation);
      
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          DomLireEltCompListe listElt = new DomLireEltCompListe();
          listElt.setNombreDE(set.getBigDecimal(1));
          listElt.setLibElement(set.getString(2));
          resultat.add(listElt);
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeConnexionStatement(connection, statement);
    }
    return resultat;
  }
  
  public static List chargerEltReexAvecLibElement(List rapportsId, String codePopulation, String libElement)
    throws CoucheLogiqueException, TechniqueException
  {
    List resultat = new ArrayList();
    String paramIdRapport = "(";
    for (int i = 0; i < rapportsId.size(); i++) {
      paramIdRapport = paramIdRapport + rapportsId.get(i).toString() + ", ";
    }
    paramIdRapport = paramIdRapport.substring(0, paramIdRapport.length() - 2);
    paramIdRapport = paramIdRapport + ") ";
    
    StringBuffer requete = new StringBuffer();
    requete.append("SELECT ELTCOMP.CXASS, ELTCOMP.CXALAF, ELTCOMP.VALEUR_AVANT, ELTCOMP.VALEUR_APRES, IND.RSIN ");
    requete.append(" FROM P1297D_ELT_COMP ELTCOMP ");
    requete.append(" INNER JOIN P1297F_DEMANDE DEM ");
    requete.append(" ON ELTCOMP.CXASS = DEM.CXASS ");
    requete.append(" AND ELTCOMP.CXALAF = DEM.CXALAF ");
    requete.append(" AND ELTCOMP.FK_DEMANDE_ID = DEM.DEMANDE_ID ");
    requete.append(" INNER JOIN P1297A_INDIVIDU IND ON ELTCOMP.CXASS = IND.CXASS ");
    requete.append(" AND ELTCOMP.CXALAF = IND.CXALAF ");
    requete.append(" AND ELTCOMP.CODE_POPULATION = IND.CODE_POPULATION ");
    requete.append(" AND ELTCOMP.FK_FONCT_RAPP_ID = IND.FK_FONCT_RAPP_ID");
    requete.append(" WHERE '$NCPVisuOccasEltReex' <> 'ReqVisuOccas' ");
    requete.append(" AND ELTCOMP.FK_FONCT_RAPP_ID in " + paramIdRapport);
    requete.append(" AND ELTCOMP.CODE_POPULATION = ? ");
    requete.append(" AND ELTCOMP.LIB_ELEMENT = ? ");
    requete.append(" AND DEM.ETAT_REEXAM = 'R' ");
    requete.append(" WITH UR;");
    
    Connection connection = getConnection(null);
    PreparedStatement statement = null;
    try
    {
      int idxCodePopulation = 1;
      int idxNumElement = 2;
      
      int indexCxass = 1;
      int indexCxalaf = 2;
      int indexValeurAvant = 3;
      int indexValeurApres = 4;
      int indexRsin = 5;
      
      statement = connection.prepareStatement(requete.toString());
      statement.setString(1, codePopulation);
      statement.setString(2, libElement);
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          DomLireEltCompListe listElt = new DomLireEltCompListe();
          listElt.setCxass(set.getString(1));
          listElt.setCxalaf(set.getBigDecimal(2));
          listElt.setLibElement(libElement);
          String valeurAvant = GestionnaireErreur.getInstance().getLibelleErreur(set.getString(3));
          String valeurApres = GestionnaireErreur.getInstance().getLibelleErreur(set.getString(4));
          if (valeurApres == null) {
            listElt.setValeurApres(set.getString(4));
          } else if (valeurApres.length() >= 100) {
            listElt.setValeurApres(valeurApres.substring(0, 99));
          } else {
            listElt.setValeurApres(valeurApres);
          }
          if (valeurAvant == null) {
            listElt.setValeurAvant(set.getString(3));
          } else if (valeurAvant.length() >= 100) {
            listElt.setValeurAvant(valeurAvant.substring(0, 99));
          } else {
            listElt.setValeurAvant(valeurAvant);
          }
          listElt.setRsin(set.getString(5));
          resultat.add(listElt);
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeConnexionStatement(connection, statement);
    }
    return resultat;
  }
  
  private static boolean isDEReexamen(String etatReexamen)
  {
    boolean retour = false;
    if (etatReexamen.equals("R")) {
      retour = true;
    }
    return retour;
  }
  
  private static boolean evaluerBooleanValue(String valeur)
  {
    if ("1".equalsIgnoreCase(valeur)) {
      return true;
    }
    return false;
  }
  
  private static Map getMapElementsCompares()
  {
    if (s_mapElementsCompares == null) {
      s_mapElementsCompares = new HashMap();
    }
    return s_mapElementsCompares;
  }
  
  private static void ajouteElementsCompares(String cle, Object valeur)
  {
    s_mapElementsCompares.put(cle, valeur);
  }
  
  private static void videMapElementsCompares()
  {
    s_mapElementsCompares = null;
  }
  
  private static String getRequeteChargerPopulation(boolean estDSI)
  {
    String requete = "SELECT POP.REEXAM_DEC_MIG,  POP.REEXEC_DEC_MIG,  POP.TYPE_MANDATEMENT,  POP.APPLI_PREM_DEC, ";
    if (estDSI) {
      requete = requete + " STAT.CXASS, ";
    }
    requete = requete + " STAT.FK_FONCT_RAPP_ID,  STAT.COD_ANT,  STAT.NB_DE_DELTA_MT_NEG,  STAT.NB_DE_DELTA_MT_POS,  STAT.NB_DE_REEXAMEN,  STAT.NB_DE_REEXECUTES,  STAT.NB_DE_TRAITES,  STAT.NB_DELTA_MT_TRAN_1,  STAT.NB_DELTA_MT_TRAN_2,  STAT.NB_DELTA_MT_TRAN_3,  STAT.NB_DELTA_MT_TRAN_4,  STAT.NB_DELTA_MT_TRAN_5,  STAT.NB_DELTA_MT_TRAN_6,  STAT.NB_DELTA_MT_TRAN_7,  STAT.NB_DELTA_MT_TRAN_8,  STAT.SOMME_DELTA_MT_NEG,  STAT.SOMME_DELTA_MT_POS,  POP.LIB_POPULATION,  RAP.DATE_PASSAGE,  POP.CONSIGNE_1,  POP.CONSIGNE_2,  POP.CONSIGNE_3,  POP.DATE_TRAITEMENT FROM P1297E_POPULATION POP INNER JOIN P1297H_STATS_ANTEN STAT ON POP.CXASS = STAT.CXASS AND POP.FK_FONCT_RAPP_ID = STAT.FK_FONCT_RAPP_ID AND POP.CODE_POPULATION = STAT.CODE_POPULATION INNER JOIN P1297B_RAPPORT RAP ON POP.CXASS = RAP.CXASS AND POP.FK_FONCT_RAPP_ID = RAP.FONCT_RAPP_ID WHERE '$NCPVisuOccasDetRapp' <> 'ReqVisuOccas' ";
    if (!estDSI) {
      requete = requete + "AND POP.CXASS = ? ";
    }
    requete = requete + " AND POP.FK_FONCT_RAPP_ID IN paramListeRapport  AND POP.CODE_POPULATION = ?  ORDER BY POP.LIB_POPULATION,  POP.CXASS WITH UR";
    
    return requete;
  }
  
  public static String[] getSaisieDescriptifPopulation(int idPopulation)
    throws TechniqueException
  {
    String[] retour = new String[3];
    String requete = "SELECT distinct CONSIGNE_1, CONSIGNE_2, CONSIGNE_3 FROM P1297E_POPULATION WHERE CODE_POPULATION = ? AND (consigne_1 is not null or consigne_2 is not null or consigne_3 is not null) WITH UR;";
    
    PreparedStatement statement = null;
    Connection connection = getConnection(null);
    try
    {
      int indexIdPopulation = 1;
      
      int indexConsigne1 = 1;
      int indexConsigne2 = 2;
      int indexConsigne3 = 3;
      
      statement = connection.prepareStatement(requete);
      statement.setInt(1, idPopulation);
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          retour[0] = set.getString(1);
          retour[1] = set.getString(2);
          retour[2] = set.getString(3);
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeConnexionStatement(connection, statement);
    }
    return retour;
  }
  
  public static List getCodePopulationDepuisIndividu(BigDecimal p_idRapport, String p_poleEmploi)
    throws TechniqueException, CoucheLogiqueException
  {
    List retour = new ArrayList();
    
    String requete = "SELECT distinct CODE_POPULATION FROM P1297A_INDIVIDU WHERE CXASS = ?  AND FK_FONCT_RAPP_ID = ? AND '2 - $NCPVisuOccasCodePop' <> 'ReqVisuOccas' WITH UR;";
    
    PreparedStatement statement = null;
    Connection connection = getConnection(null);
    try
    {
      int indexPoleEmploi = 1;
      int indexRapport = 2;
      int indexCodePopulation = 1;
      
      statement = connection.prepareStatement(requete);
      statement.setString(1, p_poleEmploi);
      statement.setBigDecimal(2, p_idRapport);
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen) {
          retour.add(OutilPopulation.getPopulationParHashCode(new BigDecimal(set.getString(1).trim()).intValue()));
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeConnexionStatement(connection, statement);
    }
    return retour;
  }
  
  public static String chargerRapportId(String p_nomChaine, String p_cxass, String p_datePassage)
    throws TechniqueException, CoucheLogiqueException
  {
    String requete = "SELECT FONCT_RAPP_ID FROM P1297B_RAPPORT WHERE NOM_CHAINE = ?  AND CXASS = ?  AND DATE_PASSAGE <= ?  GROUP BY DATE_PASSAGE,FONCT_RAPP_ID  ORDER BY DATE_PASSAGE DESC, FONCT_RAPP_ID DESC  WITH UR;";
    
    PreparedStatement statement = null;
    Connection connection = getConnection(null);
    String retour = null;
    try
    {
      int indexCodeChaine = 1;
      int indexCxass = 2;
      int indexDatePassage = 3;
      
      int indexRapport = 1;
      
      statement = connection.prepareStatement(requete);
      statement.setString(1, p_nomChaine);
      statement.setString(2, p_cxass);
      statement.setString(3, p_datePassage);
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      while ((setIsOpen) && (retour == null))
      {
        setIsOpen = set.next();
        if (setIsOpen) {
          retour = set.getString(1);
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeConnexionStatement(connection, statement);
    }
    return retour;
  }
  
  public static List chargerDeltasMontantsMensuels(String p_cxass, BigDecimal p_cxalaf, BigDecimal p_fonctRappId, String p_codePopulation)
    throws TechniqueException, CoucheLogiqueException
  {
    String requete = "SELECT MOIS,ANNEE,MONTANT_AVANT,MONTANT_APRES FROM P1297K_DELTAMT WHERE CXASS = ?  AND CXALAF = ?  AND FK_FONCT_RAPP_ID = ?  AND CODE_POPULATION = ?  ORDER BY ANNEE,MOIS  WITH UR;";
    
    PreparedStatement statement = null;
    Connection connection = getConnection(null);
    List listeDeltasMontants = new ArrayList();
    try
    {
      int idxCxass = 1;
      int idxCxalaf = 2;
      int idxFkFonctRappId = 3;
      int idxCodePopulation = 4;
      
      int idxMois = 1;
      int idxAnnee = 2;
      int idxMontantAvant = 3;
      int idxMontantApres = 4;
      
      statement = connection.prepareStatement(requete);
      statement.setString(1, p_cxass);
      statement.setBigDecimal(2, p_cxalaf);
      statement.setBigDecimal(3, p_fonctRappId);
      statement.setString(4, p_codePopulation);
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          DeltaMontantMensuel deltaMontant = new DeltaMontantMensuel();
          deltaMontant.setMois(set.getInt(1));
          deltaMontant.setAnnee(set.getInt(2));
          deltaMontant.setMontantIndemniseAvant(set.getBigDecimal(3));
          deltaMontant.setMontantIndemniseApres(set.getBigDecimal(4));
          listeDeltasMontants.add(deltaMontant);
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeConnexionStatement(connection, statement);
    }
    return listeDeltasMontants;
  }
  
  public static List chargerDeltasMontantsPopulation(String p_cxass, String p_antenne, String p_codePopulation, BigDecimal p_fonctRappId, Connection p_connection)
    throws TechniqueException, CoucheLogiqueException
  {
    StringBuffer requete = new StringBuffer();
    requete.append("SELECT SUM(CASE WHEN delta_mt_cadt <> 0 THEN 1 ELSE 0 END) AS nbDeltaCadt,");
    requete.append(" SUM(CASE WHEN delta_mt_crc <> 0 THEN 1 ELSE 0 END) AS nbDeltaCrc,");
    requete.append(" SUM(CASE WHEN delta_mt_finan <> 0 THEN 1 ELSE 0 END) AS nbDeltaFinan");
    requete.append(" FROM ");
    requete.append("P1297A_INDIVIDU");
    requete.append(" WHERE ETAT_INDIVIDU <> '");
    requete.append("1");
    requete.append("' ");
    requete.append("AND CXASS = '");
    requete.append(p_cxass);
    requete.append("' AND FK_FONCT_RAPP_ID = ");
    requete.append(p_fonctRappId);
    requete.append(" AND CODE_POPULATION = '");
    requete.append(p_codePopulation);
    requete.append("' AND COD_ANT = '");
    requete.append(p_antenne);
    requete.append("' WITH UR;");
    
    PreparedStatement statement = null;
    
    List resultat = new ArrayList();
    try
    {
      int indexNbDeltaCadt = 1;
      int indexNbDeltaCrc = 2;
      int indexNbDeltaFinan = 3;
      
      statement = p_connection.prepareStatement(requete.toString());
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          resultat.add(set.getBigDecimal(1));
          resultat.add(set.getBigDecimal(2));
          resultat.add(set.getBigDecimal(3));
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
    return resultat;
  }
  
  public static List chargerRapports(String p_cxass, String p_codeAntenne, boolean p_estSimulationChangement, boolean p_chargementComplet)
    throws TechniqueException, CoucheLogiqueException
  {
    List resultat = new ArrayList();
    
    String requete = "SELECT distinct A.NOM_CHAINE, A.MODE_OCCAS, B.LIB_POPULATION, B.CODE_POPULATION, A.DATE_PASSAGE DATE_P, A.FONCT_RAPP_ID, B.DATE_TRAITEMENT FROM P1297B_RAPPORT A INNER JOIN P1297E_POPULATION B ON A.CXASS = B.CXASS AND A.FONCT_RAPP_ID = B.FK_FONCT_RAPP_ID WHERE '$NCPVisuOccasLireRappRed' <> 'ReqVisuOccas'";
    if (p_cxass != null)
    {
      requete = requete + "AND A.CXASS = ? ";
      if (p_codeAntenne != null) {
        requete = "SELECT distinct A.NOM_CHAINE, A.MODE_OCCAS, B.LIB_POPULATION, B.CODE_POPULATION, A.DATE_PASSAGE DATE_P, A.FONCT_RAPP_ID, B.DATE_TRAITEMENT FROM P1297B_RAPPORT A INNER JOIN P1297E_POPULATION B ON A.CXASS = B.CXASS AND A.FONCT_RAPP_ID = B.FK_FONCT_RAPP_ID INNER JOIN P1297H_STATS_ANTEN STAT ON B.CXASS = STAT.CXASS AND B.FK_FONCT_RAPP_ID = STAT.FK_FONCT_RAPP_ID AND B.CODE_POPULATION = STAT.CODE_POPULATION WHERE '$NCPVisuOccasLireRappRed' <> 'ReqVisuOccas'AND A.CXASS = ? AND STAT.COD_ANT = ? ";
      }
    }
    if (!p_chargementComplet) {
      requete = requete + "AND A.NOM_CHAINE = '90AT1' ";
    }
    requete = requete + "ORDER BY DATE_P DESC, B.LIB_POPULATION, A.NOM_CHAINE WITH UR;";
    
    Connection connection = getConnection(null);
    PreparedStatement statement = null;
    try
    {
      int idxCxass = 1;
      int idxCodeAnt = 2;
      
      int indexNomChaine = 1;
      int indexModeOccas = 2;
      int indexLibPopulation = 3;
      int indexCodePopulation = 4;
      int indexDatePassage = 5;
      int indexFonctRappId = 6;
      int indexDateTraitement = 7;
      
      int indexnbDateTraitementNulle = 1;
      
      statement = connection.prepareStatement(requete);
      if (p_cxass != null)
      {
        statement.setString(1, p_cxass);
        if (p_codeAntenne != null) {
          statement.setString(2, p_codeAntenne);
        }
      }
      ResultSet set = statement.executeQuery();
      
      boolean setIsOpen = true;
      DomLireRapportListe listElt = null;
      
      Damj datePassage = null;
      Damj dateTraitement = null;
      String nomChaine = null;
      
      boolean chargementCompletVueNat = false;
      if ((p_cxass == null) && (p_chargementComplet)) {
        chargementCompletVueNat = true;
      }
      int nbDateTraitementNulle = -1;
      
      String requeteVerificationDateTraitementNulle = "SELECT COUNT(*) FROM P1297B_RAPPORT A INNER JOIN P1297E_POPULATION B ON A.CXASS = B.CXASS AND A.FONCT_RAPP_ID = B.FK_FONCT_RAPP_ID WHERE '$NCPVisuOccasLireRappRed' <> 'ReqVisuOccas' AND DATE_TRAITEMENT IS NULL ";
      if (p_cxass != null)
      {
        requeteVerificationDateTraitementNulle = requeteVerificationDateTraitementNulle + "AND A.CXASS = ? ";
        if (p_codeAntenne != null) {
          requeteVerificationDateTraitementNulle = "SELECT COUNT(*) FROM P1297B_RAPPORT A INNER JOIN P1297E_POPULATION B ON A.CXASS = B.CXASS AND A.FONCT_RAPP_ID = B.FK_FONCT_RAPP_ID INNER JOIN P1297H_STATS_ANTEN C ON A.CXASS = C.CXASS AND A.FONCT_RAPP_ID = C.FK_FONCT_RAPP_ID WHERE '$NCPVisuOccasLireRappRed' <> 'ReqVisuOccas' AND C.DATE_TRAITEMENT IS NULL AND A.CXASS = ? AND C.COD_ANT = ? ";
        }
      }
      if (!p_chargementComplet) {
        requeteVerificationDateTraitementNulle = requeteVerificationDateTraitementNulle + "AND A.NOM_CHAINE = '90AT1' ";
      }
      requeteVerificationDateTraitementNulle = requeteVerificationDateTraitementNulle + "WITH UR;";
      
      PreparedStatement statementVerifDateTraitementNulle = null;
      try
      {
        statementVerifDateTraitementNulle = connection.prepareStatement(requeteVerificationDateTraitementNulle);
        if (p_cxass != null)
        {
          statementVerifDateTraitementNulle.setString(1, p_cxass);
          if (p_codeAntenne != null) {
            statementVerifDateTraitementNulle.setString(2, p_codeAntenne);
          }
        }
        ResultSet setVerifDateTraitementNulle = statementVerifDateTraitementNulle.executeQuery();
        boolean setVerificationDateTraitementNulleIsOpen = setVerifDateTraitementNulle.next();
        if (setVerificationDateTraitementNulleIsOpen) {
          nbDateTraitementNulle = setVerifDateTraitementNulle.getInt(1);
        }
      }
      catch (SQLException e)
      {
        traiterExceptionSQL(e);
      }
      finally
      {
        closeStatement(statementVerifDateTraitementNulle);
      }
      Damj dateTraitementARecuperer = Damj.NUIT_DES_TEMPS;
      while (setIsOpen)
      {
        setIsOpen = set.next();
        if (setIsOpen)
        {
          nomChaine = set.getString(1);
          datePassage = Damj.dateVersDamj(set.getDate(5));
          dateTraitement = Damj.dateVersDamj(set.getDate(7));
          
          listElt = new DomLireRapportListe();
          if (nbDateTraitementNulle == 0)
          {
            if ((dateTraitement != null) && (dateTraitementARecuperer != null))
            {
              if (dateTraitement.estApres(dateTraitementARecuperer)) {
                dateTraitementARecuperer = dateTraitement;
              }
              listElt.setDateTraitement(dateTraitementARecuperer);
            }
          }
          else {
            listElt.setDateTraitement(dateTraitement);
          }
          listElt.setNomChaine(nomChaine);
          listElt.setDatePassage(datePassage);
          listElt.setModeOccas(set.getString(2));
          listElt.setListeRapport(new ArrayList());
          listElt.getListeRapport().add(set.getBigDecimal(6));
          ArrayList population = new ArrayList();
          population.add(set.getString(3));
          listElt.setLibPopulation(population);
          ArrayList codePopulation = new ArrayList();
          codePopulation.add(set.getString(4));
          listElt.setCodePopulation(codePopulation);
          listElt.setFonctRappId(set.getBigDecimal(6));
          
          PopulationSpec pop = OutilPopulation.getPopulationParHashCode(new BigDecimal(set.getString(4).trim()).intValue());
          if ((pop == null) || (pop.isEstAffichableIhmVisu())) {
            listElt.setAffichableIhmVisu(true);
          } else if ((pop instanceof PopulationSimulationChangementSpec)) {
            listElt.setAffichableSimuChangement(true);
          }
          if (((!p_estSimulationChangement) && (listElt.isAffichableIhmVisu())) || ((p_estSimulationChangement) && (listElt.isAffichableSimuChangement())))
          {
            Iterator ite = resultat.iterator();
            boolean trouve = false;
            if ((!p_estSimulationChangement) && ((listElt.getNomChaine().trim().equals("90AT1")) || (chargementCompletVueNat))) {}
            while ((ite.hasNext()) && (!trouve))
            {
              DomLireRapportListe rapp = (DomLireRapportListe)ite.next();
              if ((((String)rapp.getLibPopulation().get(0)).compareTo((String)listElt.getLibPopulation().get(0)) == 0) && ((rapp.getNomChaine().trim().equals("90AT1")) || (chargementCompletVueNat))) {
                if ((chargementCompletVueNat) && (!rapp.getNomChaine().trim().equals("90AT1")))
                {
                  if ((rapp.getDatePassage().coincideAvec(listElt.getDatePassage())) && (rapp.getNomChaine().trim().equals(listElt.getNomChaine().trim())))
                  {
                    listElt.getListeRapport().addAll(rapp.getListeRapport());
                    ite.remove();
                  }
                }
                else if (rapp.getDatePassage().estAvant(listElt.getDatePassage()))
                {
                  listElt.getListeRapport().addAll(rapp.getListeRapport());
                  ite.remove();
                }
                else if (rapp.getNomChaine().trim().equals(listElt.getNomChaine().trim()))
                {
                  rapp.getListeRapport().addAll(listElt.getListeRapport());
                  trouve = true;
                }
              }
              continue;
              if (p_estSimulationChangement) {
                while ((ite.hasNext()) && (!trouve))
                {
                  DomLireRapportListe rapp = (DomLireRapportListe)ite.next();
                  if ((((String)rapp.getLibPopulation().get(0)).compareTo((String)listElt.getLibPopulation().get(0)) == 0) && ((rapp.getNomChaine().trim().equals("90AT1")) || (chargementCompletVueNat))) {
                    if ((chargementCompletVueNat) && (!rapp.getNomChaine().trim().equals("90AT1")))
                    {
                      if ((rapp.getDatePassage().coincideAvec(listElt.getDatePassage())) && (rapp.getNomChaine().trim().equals(listElt.getNomChaine().trim())))
                      {
                        listElt.getListeRapport().addAll(rapp.getListeRapport());
                        ite.remove();
                      }
                    }
                    else if (rapp.getDatePassage().estAvant(listElt.getDatePassage()))
                    {
                      listElt.getListeRapport().addAll(rapp.getListeRapport());
                      ite.remove();
                    }
                    else if (rapp.getNomChaine().trim().equals(listElt.getNomChaine().trim()))
                    {
                      rapp.getListeRapport().addAll(listElt.getListeRapport());
                      trouve = true;
                    }
                  }
                }
              }
            }
            if (!trouve) {
              resultat.add(listElt);
            }
          }
        }
      }
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeConnexionStatement(connection, statement);
    }
    return resultat;
  }
}

/* Location:
 * Qualified Name:     LireBaseVisu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */