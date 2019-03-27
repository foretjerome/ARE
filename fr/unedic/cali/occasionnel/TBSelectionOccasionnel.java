package fr.unedic.cali.occasionnel;

import fr.pe.cali.client.ManagerAppelsServicesD90;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.IndividuSelection;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationAbstraite;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilPopulation;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilRedressement;
import fr.unedic.cali.outilsfonctionnels.AppelServicesAbstrait;
import fr.unedic.cali.outilsfonctionnels.EcrireBaseVisu;
import fr.unedic.cali.parcours.DomSelectionOccasionnel;
import fr.unedic.cali.parcours.ResultatVisualisationSelection;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireIndividu;
import fr.unedic.d90.donnees.d90.service.vls.ListeIndividus;
import fr.unedic.d90.donnees.d90.service.vls.ListeParametres;
import fr.unedic.d90.donnees.d90.service.vls.Parametre;
import fr.unedic.util.persistance.dao.ConnexionDB;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.ListeIndicateurs;
import fr.unedic.util.services.ResultatService;
import fr.unedic.util.services.batch.ContexteOccasionnel;
import fr.unedic.util.services.batch.IdTraitement;
import fr.unedic.util.services.batch.ListeIdTraitements;
import fr.unedic.util.services.batch.TBOccasionnelAbstrait;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TBSelectionOccasionnel
  extends TBOccasionnelAbstrait
{
  private static final String NOM_TABLE = "";
  
  public TBSelectionOccasionnel()
  {
    super("");
  }
  
  protected ResultatService traiterEnregistrement(ContexteOccasionnel contexte, String id)
    throws TechniqueException
  {
    ResultatService resultatServiceRetourne = new ResultatService();
    
    return resultatServiceRetourne;
  }
  
  protected String getNomColonne(int colonne)
  {
    return "";
  }
  
  public ListeIdTraitements getListeIdTraitements(ContexteOccasionnel contexte)
    throws ApplicativeException, TechniqueException
  {
    String requete = "";
    if ((((DomSelectionOccasionnel)contexte).getPopulation() != null) && (!((DomSelectionOccasionnel)contexte).getPopulation().isEmpty()))
    {
      PopulationAbstraite population = (PopulationAbstraite)((DomSelectionOccasionnel)contexte).getPopulation().get(0);
      requete = population.getRequeteSelectionPlageDe();
    }
    int tailleGroupe = contexte.getTailleGroupe();
    
    ListeIdTraitements listeIds = new ListeIdTraitements();
    int g = tailleGroupe > 0 ? tailleGroupe : 100;
    long idSup = -1L;
    
    Connection connection = ConnexionDB.openConnection(contexte.getNomConnectionFactory());
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try
    {
      pstmt = connection.prepareStatement(requete, 1004, 1007);
      pstmt.setString(1, contexte.getCodeAssedic());
      rs = pstmt.executeQuery();
      while (rs.next())
      {
        long idInf = rs.getLong(1);
        if ((idInf > idSup) && (
          (rs.relative(g - 1)) || (rs.last())))
        {
          idSup = rs.getLong(1);
          IdTraitement id = new IdTraitement(idInf, idSup);
          listeIds.ajouter(id);
        }
      }
    }
    catch (SQLException e)
    {
      throw new TechniqueException("ERR_SQL", e.getMessage(), e);
    }
    finally
    {
      ConnexionDB.closeAll(rs, pstmt, connection);
    }
    return listeIds;
  }
  
  public ResultatService executer(ContexteOccasionnel contexte)
    throws TechniqueException, ApplicativeException
  {
    ResultatService resultatCumul = new ResultatService(0);
    List<?> listeIDs = lireEnregistrements(contexte);
    resultatCumul.setEtat(0);
    ListeIndicateurs listeIndicateurs = new ListeIndicateurs();
    listeIndicateurs.ajouter("D12_GRCA_DE_SELECTIONNES", listeIDs.size());
    resultatCumul.setListeIndicateurs(listeIndicateurs);
    return resultatCumul;
  }
  
  protected List lireEnregistrements(ContexteOccasionnel contexte)
    throws TechniqueException
  {
    List listeIDs = new ArrayList();
    DomSelectionOccasionnel dom = (DomSelectionOccasionnel)contexte;
    
    listeIDs = selection(dom.getRedressement(), dom.getCodeAssedic(), String.valueOf(dom.getIdTraitement().getIdInf()), String.valueOf(dom.getIdTraitement().getIdSup()), dom.getContexteService());
    
    return listeIDs;
  }
  
  public List selection(RedressementSpec redressement, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
    throws TechniqueException
  {
    ResultatVisualisationSelection resultatVisualisation = new ResultatVisualisationSelection();
    resultatVisualisation.setRedressementSpec(redressement);
    
    List<?> listePopulation = redressement.getListePopulation();
    
    List<?> populationRequetable = new ArrayList();
    List<?> populationNonRequetable = new ArrayList();
    List<?> collectionIndividus = new ArrayList();
    
    trierPoplation(listePopulation, populationRequetable, populationNonRequetable);
    
    chargerPopulationsRequetables(populationRequetable, collectionIndividus, codeAssedic, idInf, idSup, contexteService);
    if (!OutilRedressement.estEnModeListe(redressement)) {
      ecrireIndividus(collectionIndividus, resultatVisualisation, redressement, contexteService);
    }
    appelBaseVisu(resultatVisualisation);
    
    return collectionIndividus;
  }
  
  private void appelBaseVisu(ResultatVisualisationSelection resultatVisualisation)
    throws TechniqueException
  {
    EcrireBaseVisu.ecrireEnBaseVisu(resultatVisualisation);
  }
  
  private void ecrireIndividus(List<?> collectionIndividus, ResultatVisualisationSelection resultatVisualisation, RedressementSpec redressement, ContexteService contexteService)
    throws TechniqueException
  {
    Iterator<?> iteratorIndividuSelection = collectionIndividus.iterator();
    Collection<IndividuSelection> collectionIndividuSelectionAEcrire = new ArrayList();
    while (iteratorIndividuSelection.hasNext())
    {
      IndividuSelection individuSelection = (IndividuSelection)iteratorIndividuSelection.next();
      
      ajouterIndividuDansResultatSelection(resultatVisualisation, individuSelection);
      collectionIndividuSelectionAEcrire.add(individuSelection);
    }
    if (!collectionIndividuSelectionAEcrire.isEmpty()) {
      ecrireIndividu(collectionIndividuSelectionAEcrire, redressement, contexteService);
    }
  }
  
  private void trierPoplation(List listePopulation, List populationRequetable, List populationNonRequetable)
  {
    if (listePopulation != null)
    {
      Iterator<?> iteratorPopulation = listePopulation.iterator();
      while (iteratorPopulation.hasNext())
      {
        PopulationAbstraite p = (PopulationAbstraite)iteratorPopulation.next();
        if (p.estRequetable()) {
          populationRequetable.add(p);
        } else {
          populationNonRequetable.add(p);
        }
      }
    }
  }
  
  private void chargerPopulationsRequetables(List populationsRequetable, List collectionIndividus, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
    throws TechniqueException
  {
    ListIterator<?> iteratorPopulationRequetable = populationsRequetable.listIterator();
    while (iteratorPopulationRequetable.hasNext())
    {
      PopulationAbstraite p = (PopulationAbstraite)iteratorPopulationRequetable.next();
      p.getCollectionIndividus((ArrayList)collectionIndividus, codeAssedic, idInf, idSup, contexteService);
    }
  }
  
  private void ajouterIndividuDansResultatSelection(ResultatVisualisationSelection resultatVisualisationSelection, IndividuSelection individuSelection)
  {
    fr.unedic.cali.autresdoms.d90.dom.Individu individuVisu = new fr.unedic.cali.autresdoms.d90.dom.Individu();
    
    individuVisu.setCxala(individuSelection.getIdentifiantBNI().toString());
    individuVisu.setCxass(individuSelection.getCodeAssedic());
    individuVisu.setDeltaMontantBrut(new BigDecimal(0));
    individuVisu.setModeCreation("S");
    individuVisu.setPopulation(definirPopulationPrioritaire(individuSelection.getCollectionPopulations()));
    individuVisu.setRsin(individuSelection.getIdentifiantSigma());
    individuVisu.setDateReexecution(individuSelection.getDateReexecution());
    individuVisu.setAntenne(individuSelection.getCodeAntenne());
    resultatVisualisationSelection.ajouterIndividu(individuVisu);
  }
  
  public void ecrireIndividu(Collection<IndividuSelection> collectionIndividuSelection, RedressementSpec redressement, ContexteService contexteService)
    throws TechniqueException
  {
    try
    {
      ManagerAppelsServicesD90 domaineD90 = new ManagerAppelsServicesD90();
      CriteresEcrireIndividu criteresEcrireIndividu = CriteresEcrireIndividu.getInstance();
      
      criteresEcrireIndividu.setNewListeParametres();
      
      Parametre vlsParametre = criteresEcrireIndividu.getListeParametres().addParametre();
      vlsParametre.setId("ModeFonctionnel");
      vlsParametre.setValeur(redressement.getModeRedressement());
      
      criteresEcrireIndividu.setNewListeIndividus();
      
      Iterator<?> iteratorIndividuSelection = collectionIndividuSelection.iterator();
      while (iteratorIndividuSelection.hasNext())
      {
        IndividuSelection individuSelection = (IndividuSelection)iteratorIndividuSelection.next();
        
        fr.unedic.d90.donnees.d90.service.vls.Individu vlsIndividu = criteresEcrireIndividu.getListeIndividus().addIndividu();
        vlsIndividu.setIdentifiantBNI(individuSelection.getIdentifiantBNI());
        vlsIndividu.setIdentifiantSigma(individuSelection.getIdentifiantSigma());
        
        vlsIndividu.setCodeAntenne(" ");
        
        PopulationSpec populationPrioritaireIndividu = definirPopulationPrioritaire(individuSelection.getCollectionPopulations());
        vlsIndividu.setNomPopulation(populationPrioritaireIndividu.getLibelle());
        
        vlsIndividu.setDateReexecution(individuSelection.getDateReexecution());
        
        Iterator<?> iteratorPopulations = individuSelection.getCollectionPopulations().iterator();
        if (iteratorPopulations.hasNext())
        {
          PopulationAbstraite population = (PopulationAbstraite)iteratorPopulations.next();
          vlsIndividu.setNomPopulation(population.getLibelle());
        }
      }
      criteresEcrireIndividu.setContexteService(AppelServicesAbstrait.contexteServiceDomVersVlsD90(contexteService));
      
      domaineD90.ecrireIndividu(criteresEcrireIndividu);
    }
    catch (ApplicativeException e)
    {
      throw new TechniqueException("HG_PR_CALI_L_APPEL_CALI_D90", "Problème lors de l'appel de service de CALI vers D90", e);
    }
  }
  
  private PopulationSpec definirPopulationPrioritaire(Collection listePopulation)
  {
    return OutilPopulation.definirPopulationPrioritaire(listePopulation);
  }
}

/* Location:
 * Qualified Name:     TBSelectionOccasionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */