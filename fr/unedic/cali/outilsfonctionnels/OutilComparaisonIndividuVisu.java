package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.autresdoms.d90.dom.Demande;
import fr.unedic.cali.autresdoms.d90.dom.Individu;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilPopulation;
import fr.unedic.cali.dom.ElementComparaisonReexamen;
import fr.unedic.cali.dom.occasionnel.DomLireDemandesListe;
import fr.unedic.cali.dom.occasionnel.DomLireEltCompListe;
import fr.unedic.cali.dom.occasionnel.DomLireIndividusListe;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.cali.parcours.ResultatVisualisationReexecution;
import fr.unedic.cali.parcours.population.ResultatComparaison;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.StringUtils;

public class OutilComparaisonIndividuVisu
{
  private static ArrayList s_listeElementsComparaisonCritiques = new ArrayList();
  
  static
  {
    s_listeElementsComparaisonCritiques.add("Libellé Décision");
    s_listeElementsComparaisonCritiques.add("Produit Proposé");
  }
  
  public static ResultatComparaison comparerReexecution(DomLireIndividusListe p_individuAvant, Individu p_individuApres)
    throws TechniqueException, CoucheLogiqueException
  {
    ResultatComparaison resultatComparaison = new ResultatComparaison();
    
    List demandes = p_individuAvant.getListeDemandes();
    Connection connection = LireBaseVisu.getConnection(null);
    try
    {
      if (demandes != null)
      {
        Iterator itDemandes = demandes.iterator();
        while ((itDemandes.hasNext()) && (!resultatComparaison.isDemandeEnReexamen()))
        {
          boolean alimenterDemandeVisu = false;
          DomLireDemandesListe demandeAvant = (DomLireDemandesListe)itDemandes.next();
          Demande demandeApres = p_individuApres.getDemande(demandeAvant.getDemandeId().toString());
          if ("R".equals(demandeAvant.getEtatReexamen()))
          {
            resultatComparaison.setDemandeEnReexamenAvant(true);
            alimenterDemandeVisu = true;
          }
          if ("R".equals(demandeApres.getEtatReexamen()))
          {
            resultatComparaison.setDemandeEnReexamenApres(true);
            alimenterDemandeVisu = true;
          }
          if ((resultatComparaison.isDemandeEnReexamen()) || (!resultatComparaison.isDemandeDifferente()))
          {
            List listeEltCompAvant = LireBaseVisu.chargerEltComp(demandeAvant.getCxass(), demandeAvant.getFonctRappId(), demandeAvant.getCodePopulation(), demandeAvant.getCxalaf(), demandeAvant.getDemandeId(), connection);
            
            HashMap mapAvant = transformerListeAvantEnHashMap(listeEltCompAvant);
            HashMap mapApres = transformerListeApresEnHashMap(demandeApres.getElementsComparaisonReexamen());
            
            HashMap mapDifferences = comparerElementComparaisonAvant(mapAvant, mapApres);
            comparerElementComparaisonApres(mapAvant, mapApres, mapDifferences);
            if (!mapDifferences.isEmpty())
            {
              resultatComparaison.setDemandeDifferente(true);
              resultatComparaison.setElementsComparaisonDifferents(mapDifferences);
              alimenterDemandeVisu = true;
            }
          }
          if (alimenterDemandeVisu)
          {
            Demande demandeVisuPop3 = alimenterDemandeVisu(demandeApres, resultatComparaison.getElementsComparaisonDifferents());
            resultatComparaison.setDemandeVisu(demandeVisuPop3);
          }
          if (((demandeAvant.getDeltaDji() == null) && (demandeApres.getDeltaDJI() != null)) || ((demandeApres.getDeltaDJI() == null) && (demandeAvant.getDeltaDji() != null)) || ((demandeAvant.getDeltaDji() != null) && (demandeApres.getDeltaDJI() != null) && (demandeAvant.getDeltaDji().compareTo(demandeApres.getDeltaDJI()) != 0))) {
            resultatComparaison.setDjiDifferent(true);
          }
          if (((demandeAvant.getDeltaPji() == null) && (demandeApres.getDeltaPJI() != null)) || ((demandeApres.getDeltaPJI() == null) && (demandeAvant.getDeltaPji() != null)) || ((demandeAvant.getDeltaPji() != null) && (demandeApres.getDeltaPJI() != null) && (demandeAvant.getDeltaPji().compareTo(demandeApres.getDeltaPJI()) != 0))) {
            resultatComparaison.setPjiDifferent(true);
          }
        }
      }
      if (((p_individuAvant.getDeltaMtIndemnise() == null) && (p_individuApres.getDeltaMontantBrut() != null)) || ((p_individuApres.getDeltaMontantBrut() == null) && (p_individuAvant.getDeltaMtIndemnise() != null)) || ((p_individuAvant.getDeltaMtIndemnise() != null) && (p_individuApres.getDeltaMontantBrut() != null) && (p_individuAvant.getDeltaMtIndemnise().compareTo(p_individuApres.getDeltaMontantBrut()) != 0))) {
        resultatComparaison.setDeltaMontantDifferent(true);
      }
    }
    finally
    {
      LireBaseVisu.closeConnexion(connection);
    }
    return resultatComparaison;
  }
  
  private static Demande alimenterDemandeVisu(Demande p_demande, HashMap p_elementsComparaison)
  {
    Demande demandeVisu = new Demande();
    demandeVisu.setCodeProduit(p_demande.getCodeProduit());
    demandeVisu.setDateAttribution(p_demande.getDateAttribution());
    demandeVisu.setDeltaDJI(p_demande.getDeltaDJI());
    demandeVisu.setDeltaPJI(p_demande.getDeltaPJI());
    demandeVisu.setDjiApres(p_demande.getDjiApres());
    demandeVisu.setDjiAvant(p_demande.getDjiAvant());
    demandeVisu.setEstdecisionnee(p_demande.isEstdecisionnee());
    demandeVisu.setEstFigee(p_demande.estFigee());
    demandeVisu.setEstImpacte(p_demande.isEstImpacte());
    demandeVisu.setEstMigree(p_demande.estMigree());
    demandeVisu.setEstNeutralisee(p_demande.estNeutralisee());
    demandeVisu.setEstReexecutee(p_demande.isEstReexecutee());
    demandeVisu.setEtatReexamen(p_demande.getEtatReexamen());
    demandeVisu.setIdDemande(p_demande.getIdDemande());
    demandeVisu.setPjiApres(p_demande.getPjiApres());
    demandeVisu.setPjiAvant(p_demande.getPjiAvant());
    demandeVisu.setTypeDecision(p_demande.getTypeDecision());
    demandeVisu.setTypeDemande(p_demande.getTypeDemande());
    
    Iterator it = p_elementsComparaison.keySet().iterator();
    ArrayList listeElementsComparaison = new ArrayList();
    while (it.hasNext()) {
      listeElementsComparaison.add(p_elementsComparaison.get(it.next()));
    }
    demandeVisu.setElementsComparaisonReexamen(listeElementsComparaison);
    
    return demandeVisu;
  }
  
  private static HashMap transformerListeApresEnHashMap(List p_liste)
  {
    HashMap map = new HashMap();
    if (p_liste != null)
    {
      Iterator itListe = p_liste.iterator();
      while (itListe.hasNext())
      {
        ElementComparaisonReexamen element = (ElementComparaisonReexamen)itListe.next();
        DomLireEltCompListe domElement = new DomLireEltCompListe();
        domElement.setLibElement(element.getLibelleElement());
        domElement.setValeurAvant(ConvertisseurElementComparaisonReexamen.convertirElement(element.getValeurAvantReexamen()));
        domElement.setValeurApres(ConvertisseurElementComparaisonReexamen.convertirElement(element.getValeurApresReexamen()));
        map.put(domElement.getLibElement().trim(), domElement);
      }
    }
    return map;
  }
  
  private static HashMap transformerListeAvantEnHashMap(List p_liste)
  {
    HashMap map = new HashMap();
    if (p_liste != null)
    {
      Iterator itListe = p_liste.iterator();
      while (itListe.hasNext())
      {
        DomLireEltCompListe domElement = (DomLireEltCompListe)itListe.next();
        map.put(domElement.getLibElement().trim(), domElement);
      }
    }
    return map;
  }
  
  private static HashMap comparerElementComparaisonAvant(HashMap p_mapAvant, HashMap p_mapApres)
  {
    HashMap differences = new HashMap();
    Iterator itMap = p_mapAvant.keySet().iterator();
    while (itMap.hasNext())
    {
      String cleElement = (String)itMap.next();
      DomLireEltCompListe elementAvant = (DomLireEltCompListe)p_mapAvant.get(cleElement);
      DomLireEltCompListe elementApres = (DomLireEltCompListe)p_mapApres.get(cleElement);
      if (comparerElementComparaison(elementApres, elementAvant)) {
        ajouterElementDifferent(cleElement, elementAvant, elementApres, differences);
      }
    }
    return differences;
  }
  
  private static void comparerElementComparaisonApres(HashMap p_mapAvant, HashMap p_mapApres, HashMap p_elementsDifferents)
  {
    Iterator itMap = p_mapApres.keySet().iterator();
    while (itMap.hasNext())
    {
      String cleElement = (String)itMap.next();
      DomLireEltCompListe elementAvant = (DomLireEltCompListe)p_mapAvant.get(cleElement);
      DomLireEltCompListe elementApres = (DomLireEltCompListe)p_mapApres.get(cleElement);
      if (comparerElementComparaison(elementAvant, elementApres)) {
        ajouterElementDifferent(cleElement, elementAvant, elementApres, p_elementsDifferents);
      }
    }
  }
  
  private static boolean comparerElementComparaison(DomLireEltCompListe p_element1, DomLireEltCompListe p_element2)
  {
    boolean estDifferent = false;
    if (p_element1 == null) {
      estDifferent = true;
    } else if ((!StringUtils.equals(p_element1.getValeurAvant().trim(), p_element2.getValeurAvant().trim())) || (!StringUtils.equals(p_element1.getValeurApres().trim(), p_element2.getValeurApres().trim()))) {
      estDifferent = true;
    }
    return estDifferent;
  }
  
  private static void ajouterElementDifferent(String p_cleElement, DomLireEltCompListe p_elementAvant, DomLireEltCompListe p_elementApres, HashMap p_elementsDifferents)
  {
    ElementComparaisonReexamen element = new ElementComparaisonReexamen();
    element.setLibelleElement(p_cleElement);
    if (p_elementAvant != null) {
      element.setValeurAvantReexamen(p_elementAvant.getValeurApres());
    } else {
      element.setValeurAvantReexamen("SANS OBJET");
    }
    if (p_elementApres != null) {
      element.setValeurApresReexamen(p_elementApres.getValeurApres());
    } else {
      element.setValeurApresReexamen("SANS OBJET");
    }
    if (p_elementsDifferents.get(p_cleElement) == null) {
      p_elementsDifferents.put(p_cleElement, element);
    }
  }
  
  private static boolean existeElementCritique(HashMap p_elementsComparaison)
  {
    boolean existeElementCritique = false;
    Iterator itElement = p_elementsComparaison.keySet().iterator();
    while (itElement.hasNext()) {
      if (s_listeElementsComparaisonCritiques.contains(itElement.next())) {
        existeElementCritique = true;
      }
    }
    return existeElementCritique;
  }
  
  public static void inscrireIndividuDansPopulationDefinitive(Contexte p_contexte, Individu p_individuVisuComparaison, Individu p_individuApresReexecution, String p_etatIndividu, String p_codePopulation)
    throws CoucheLogiqueException
  {
    ResultatVisualisationReexecution resultat = new ResultatVisualisationReexecution();
    DomTraitementOccasionnel donnees = (DomTraitementOccasionnel)p_contexte.getDonnees();
    resultat.setRedressementSpec(donnees.getRedressement());
    
    p_individuVisuComparaison.setPopulation(OutilPopulation.getPopulation(p_codePopulation));
    p_individuVisuComparaison.setCxala(donnees.getContexteService().getCxala().toString());
    p_individuVisuComparaison.setRsin(donnees.getContexteService().getRsin());
    p_individuVisuComparaison.setEtatIndividu(p_etatIndividu);
    p_individuVisuComparaison.setDateReexecution(donnees.getDate());
    p_individuVisuComparaison.setModeCreation("R");
    if (p_individuApresReexecution != null)
    {
      p_individuVisuComparaison.setAntenne(p_individuApresReexecution.getAntenne());
      p_individuVisuComparaison.setDeltaMontantBrut(p_individuApresReexecution.getDeltaMontantBrut());
    }
    else
    {
      p_individuVisuComparaison.setAntenne("");
      p_individuVisuComparaison.setDeltaMontantBrut(new BigDecimal(0));
    }
    resultat.setIndividu(p_individuVisuComparaison);
    try
    {
      EcrireBaseVisu.ecrireEnBaseVisu(resultat);
    }
    catch (TechniqueException e)
    {
      throw new CoucheLogiqueException("HG_PR_CALI_L_ERR_GENERIQUE", "Erreur inconnue dans l'exécution de l'application", e);
    }
  }
  
  public static String determinerEtatIndividu(ResultatComparaison p_resultatComparaison)
  {
    String etatIndividu = null;
    if (p_resultatComparaison.isDemandeEnReexamen())
    {
      if ((p_resultatComparaison.isDemandeEnReexamenAvant()) && (!p_resultatComparaison.isDemandeEnReexamenApres())) {
        etatIndividu = "S";
      } else if ((!p_resultatComparaison.isDemandeEnReexamenAvant()) && (p_resultatComparaison.isDemandeEnReexamenApres())) {
        etatIndividu = "T";
      } else {
        etatIndividu = "R";
      }
    }
    else if (p_resultatComparaison.isDemandeDifferente())
    {
      if (existeElementCritique(p_resultatComparaison.getElementsComparaisonDifferents())) {
        etatIndividu = "O";
      } else {
        etatIndividu = "N";
      }
    }
    else if (p_resultatComparaison.isPjiDifferent()) {
      etatIndividu = "P";
    } else if (p_resultatComparaison.isDjiDifferent()) {
      etatIndividu = "D";
    } else if (p_resultatComparaison.isDeltaMontantDifferent()) {
      etatIndividu = "Q";
    } else {
      etatIndividu = "M";
    }
    return etatIndividu;
  }
}

/* Location:
 * Qualified Name:     OutilComparaisonIndividuVisu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */