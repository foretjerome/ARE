package fr.unedic.cali.calcul.outilsfonctionnels.dom;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.avant.ExecutionAvantImpossibleException;
import fr.unedic.cali.calcul.FacadeCalculProduitPeriodiqueSpec;
import fr.unedic.cali.calcul.OutillageCalculADate;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoNonPeriodeHomogene;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeInterProduits;
import fr.unedic.cali.calcul.outilsfonctionnels.OutilGestionPoursuite;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitRbfSpec;
import fr.unedic.cali.dom.affectation.ProduitSolSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.AppelAvant;
import fr.unedic.cali.outilsfonctionnels.OutilDemande;
import fr.unedic.cali.parcours.ResultatAvant;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ContexteUT
{
  private Periode m_periodeUT = null;
  private List m_listeOrdonneeCandidats = null;
  private List m_listeAttributions = null;
  private Map m_mapCalendriers = null;
  
  public ContexteUT(Map p_mapCalendriers, List p_listeAttributions)
  {
    m_mapCalendriers = p_mapCalendriers;
    m_listeAttributions = p_listeAttributions;
  }
  
  public ContexteUT.ElementContexteUT getElementContexteUT(AttributionSpec p_attribution)
    throws CoucheLogiqueException
  {
    if (!m_mapCalendriers.containsKey(p_attribution)) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_ATTIBUTION_INCONNUE_DANS_CONTEXTE_UT", "Attribution inconnue dans le contexte de l'UT", null);
    }
    if (getPeriodeUT() == null) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_CALCUL_CONTEXTE_UT_SANS_PERIODE_D_UT", "Contexte de l'UT sans période", null);
    }
    return new ContexteUT.ElementContexteUT(this, p_attribution, (CalendrierExecutionCalculSpec)m_mapCalendriers.get(p_attribution), getPeriodeUT());
  }
  
  public List getListeOrdonneeCandidats()
  {
    return m_listeOrdonneeCandidats;
  }
  
  public void setListeOrdonneeCandidats(List p_listeOrdonneeCandidats)
  {
    m_listeOrdonneeCandidats = p_listeOrdonneeCandidats;
  }
  
  public List getListeAttributions()
  {
    return m_listeAttributions;
  }
  
  public Map getMapCalendriers()
  {
    return m_mapCalendriers;
  }
  
  public Periode getPeriodeUT()
  {
    return m_periodeUT;
  }
  
  public void setPeriodeUT(Periode p_periode)
  {
    m_periodeUT = p_periode;
  }
  
  private Collection getPeriodesInterProduitsSurUTPourProduit(AttributionSpec p_attribution, String p_nomProduit, int p_typeDateDebutPeriodeInterProduits)
    throws CoucheLogiqueException
  {
    Iterator iterateur = null;
    AttributionSpec attribution = null;
    ContexteUT.ElementContexteUT elementContexteUT = null;
    ObjetChronoPeriodeInterProduits objetChronoPeriodeInterProduits = null;
    List listePeriodesInterProduit = new ArrayList();
    
    iterateur = getListeAttributions().iterator();
    while (iterateur.hasNext())
    {
      attribution = (AttributionSpec)iterateur.next();
      if ((attribution.getProduit().getNomUnique().equals(p_nomProduit)) && (attribution != p_attribution))
      {
        elementContexteUT = getElementContexteUT(attribution);
        objetChronoPeriodeInterProduits = ContexteUT.ElementContexteUT.access$100(elementContexteUT, p_typeDateDebutPeriodeInterProduits);
        if (objetChronoPeriodeInterProduits != null) {
          listePeriodesInterProduit.add(objetChronoPeriodeInterProduits);
        }
      }
    }
    return listePeriodesInterProduit;
  }
  
  public Collection getPeriodesInterProduitsSurUTIndemnisationRfpe(AttributionSpec p_attribution)
    throws CoucheLogiqueException
  {
    return getPeriodesInterProduitsSurUTIndemnisation(p_attribution, "FOR_RFP04_01", 7);
  }
  
  public Collection getPeriodesInterProduitsSurUTIndemnisationProduit(AttributionSpec attribution, String produit, int typeProduitIndemnisation)
    throws CoucheLogiqueException
  {
    return getPeriodesInterProduitsSurUTIndemnisation(attribution, produit, typeProduitIndemnisation);
  }
  
  public Collection getPeriodesInterProduitsSurUTIndemnisation(AttributionSpec pattribution, String produit, int typeProduitIndemnisation)
    throws CoucheLogiqueException
  {
    Iterator iterateur = null;
    AttributionSpec attribution = null;
    ContexteUT.ElementContexteUT elementContexteUT = null;
    
    List listePeriodesInterProduit = new ArrayList();
    
    iterateur = getListeOrdonneeCandidats().iterator();
    while (iterateur.hasNext())
    {
      attribution = (AttributionSpec)iterateur.next();
      if ((attribution.getProduitExecution().getNomUnique().equals(produit)) && (attribution != pattribution))
      {
        elementContexteUT = getElementContexteUT(attribution);
        listePeriodesInterProduit.addAll(ContexteUT.ElementContexteUT.access$200(elementContexteUT, typeProduitIndemnisation));
      }
    }
    return listePeriodesInterProduit;
  }
  
  private Collection getPeriodesInterProduitsSurUTPourGamme(AttributionSpec p_attribution, String p_gamme, int p_typeDateDebutPeriodeInterProduits)
    throws CoucheLogiqueException
  {
    Iterator iterateur = null;
    AttributionSpec attribution = null;
    Temporel objetPeriode = null;
    ContexteUT.ElementContexteUT elementContexteUT = null;
    ObjetChronoPeriodeInterProduits objetChronoPeriodeInterProduits = null;
    List listePeriodesInterProduit = new ArrayList();
    
    iterateur = getListeAttributions().iterator();
    while (iterateur.hasNext())
    {
      attribution = (AttributionSpec)iterateur.next();
      if ((attribution.getGamme().getNomUnique().equals(p_gamme)) && (attribution != p_attribution))
      {
        elementContexteUT = getElementContexteUT(attribution);
        objetChronoPeriodeInterProduits = ContexteUT.ElementContexteUT.access$100(elementContexteUT, p_typeDateDebutPeriodeInterProduits);
        if (objetChronoPeriodeInterProduits != null) {
          listePeriodesInterProduit.add(objetChronoPeriodeInterProduits);
        }
      }
    }
    if (p_attribution != null) {
      if (p_attribution.getDemandeur().getListeAttributionsASUCompetenceFinanciere() != null)
      {
        iterateur = p_attribution.getDemandeur().getListeAttributionsASUCompetenceFinanciere().iterator();
        while (iterateur.hasNext())
        {
          objetPeriode = (Temporel)iterateur.next();
          if ((objetPeriode instanceof AttributionSpec))
          {
            attribution = (AttributionSpec)objetPeriode;
            if ((attribution.getGamme().getNomUnique().equals(p_gamme)) && (attribution != p_attribution) && (!OutilDemande.estUneDemandeFinDroit(attribution.getDemande())))
            {
              Damj dateDepart = OutilGestionPoursuite.getInstance().recupererDateAttributionOuPjpSiPoursuite(attribution);
              objetChronoPeriodeInterProduits = new ObjetChronoPeriodeInterProduits(dateDepart, dateDepart, p_typeDateDebutPeriodeInterProduits, attribution);
              if (objetChronoPeriodeInterProduits != null) {
                listePeriodesInterProduit.add(objetChronoPeriodeInterProduits);
              }
            }
          }
        }
      }
    }
    return listePeriodesInterProduit;
  }
  
  public Collection getPeriodesInterProduitsSurUTDateDepartAttributionPourProduit(AttributionSpec p_attribution, String p_nomProduit)
    throws CoucheLogiqueException
  {
    return getPeriodesInterProduitsSurUTPourProduit(p_attribution, p_nomProduit, 1);
  }
  
  public Collection getPeriodesInterProduitsSurUTDateDepartPjiPourProduit(AttributionSpec p_attribution, String p_nomProduit)
    throws CoucheLogiqueException
  {
    return getPeriodesInterProduitsSurUTPourProduit(p_attribution, p_nomProduit, 2);
  }
  
  public Collection getPeriodesInterProduitsSurUTDateDepartPjiPourGamme(AttributionSpec p_attribution, String p_gamme)
    throws CoucheLogiqueException
  {
    return getPeriodesInterProduitsSurUTPourGamme(p_attribution, p_gamme, 2);
  }
  
  public Collection getSommesSurUTPourProduit(AttributionSpec p_attribution, String p_nomProduit)
    throws CoucheLogiqueException
  {
    AttributionSpec attribution = null;
    ContexteUT.ElementContexteUT elementContexteUT = null;
    Iterator iterateurAttributions = null;
    Iterator iterateurSommes = null;
    Somme somme = null;
    List listePeriodesInterProduit = new ArrayList();
    
    iterateurAttributions = getListeAttributions().iterator();
    while (iterateurAttributions.hasNext())
    {
      attribution = (AttributionSpec)iterateurAttributions.next();
      if ((attribution.getProduit().getNomUnique().equals(p_nomProduit)) && (attribution != p_attribution))
      {
        elementContexteUT = getElementContexteUT(attribution);
        if (elementContexteUT.getCollectionSommes() != null)
        {
          iterateurSommes = elementContexteUT.getCollectionSommes().iterator();
          while (iterateurSommes.hasNext())
          {
            somme = (Somme)iterateurSommes.next();
            ObjetChronoPeriodeInterProduits periodeSomme = new ObjetChronoPeriodeInterProduits(somme.getDateDebut(), somme.getDateFin(), 3, attribution);
            
            periodeSomme.setSomme(somme);
            
            listePeriodesInterProduit.add(periodeSomme);
          }
        }
      }
    }
    return listePeriodesInterProduit;
  }
  
  public Collection getPeriodesInterProduitsSurUTDateDepartAttributionPourGamme(AttributionSpec p_attribution, String p_gamme)
    throws CoucheLogiqueException
  {
    return getPeriodesInterProduitsSurUTPourGamme(p_attribution, p_gamme, 1);
  }
  
  public Collection getSommesSurUTPourGamme(AttributionSpec p_attribution, String p_gamme)
    throws CoucheLogiqueException
  {
    AttributionSpec attribution = null;
    ContexteUT.ElementContexteUT elementContexteUT = null;
    Iterator iterateurAttributions = null;
    Iterator iterateurSommes = null;
    Somme somme = null;
    List listePeriodesInterProduit = new ArrayList();
    
    iterateurAttributions = getListeAttributions().iterator();
    while (iterateurAttributions.hasNext())
    {
      attribution = (AttributionSpec)iterateurAttributions.next();
      if ((attribution.getGamme().getNomUnique().equals(p_gamme)) && (attribution != p_attribution))
      {
        elementContexteUT = getElementContexteUT(attribution);
        if (elementContexteUT.getCollectionSommes() != null)
        {
          iterateurSommes = elementContexteUT.getCollectionSommes().iterator();
          while (iterateurSommes.hasNext())
          {
            somme = (Somme)iterateurSommes.next();
            ObjetChronoPeriodeInterProduits periodeSomme = new ObjetChronoPeriodeInterProduits(somme.getDateDebut(), somme.getDateFin(), 3, attribution);
            
            periodeSomme.setSomme(somme);
            
            listePeriodesInterProduit.add(periodeSomme);
          }
        }
      }
    }
    return listePeriodesInterProduit;
  }
  
  public Collection getPeriodesInterProduitsPeriodesLieuSurUTPourGammeRBF(AttributionSpec p_attribution)
    throws CoucheLogiqueException
  {
    AttributionSpec attribution = null;
    Iterator iterateurAttributions = null;
    List listePeriodesInterProduit = new ArrayList();
    ChronologiePeriodes periodesHomogenesEtNonHomogenes = new ChronologiePeriodes();
    boolean periodesNonTrouvees = false;
    
    iterateurAttributions = getListeAttributions().iterator();
    while ((iterateurAttributions.hasNext()) && (periodesNonTrouvees))
    {
      attribution = (AttributionSpec)iterateurAttributions.next();
      if ((attribution.getGamme().getNomUnique().equals("RBF")) && (attribution != p_attribution))
      {
        periodesHomogenesEtNonHomogenes.ajouter(((ProduitRbfSpec)attribution.getProduit()).retournerListePeriodesHomogenes(attribution));
        
        OutillageCalculADate.boucheLesTrous(periodesHomogenesEtNonHomogenes, ObjetChronoNonPeriodeHomogene.class, Damj.NUIT_DES_TEMPS, Damj.FIN_DES_TEMPS);
        listePeriodesInterProduit.addAll(periodesHomogenesEtNonHomogenes.mapperVersCollection());
        periodesNonTrouvees = false;
      }
    }
    return listePeriodesInterProduit;
  }
  
  public Collection getPeriodesInterProduitsSurUTLendemainDjiPourProduit(AttributionSpec p_attribution, String p_nomProduit)
    throws CoucheLogiqueException
  {
    List listePeriodesInterProduit = null;
    Iterator iterateurAttributions = null;
    AttributionSpec attribution = null;
    ContexteUT.ElementContexteUT elementContexteUT = null;
    
    listePeriodesInterProduit = new ArrayList();
    
    iterateurAttributions = getListeAttributions().iterator();
    while (iterateurAttributions.hasNext())
    {
      attribution = (AttributionSpec)iterateurAttributions.next();
      if ((attribution.getProduit().getNomUnique().equals(p_nomProduit)) && (p_attribution != attribution))
      {
        elementContexteUT = getElementContexteUT(attribution);
        if ((elementContexteUT.isFinDeProduit()) || ((elementContexteUT.getDateFinProduit() != null) && (elementContexteUT.getDateFinProduit().estVeilleDe(m_periodeUT.getDebut())))) {
          listePeriodesInterProduit.add(new ObjetChronoPeriodeInterProduits(elementContexteUT.getDateFinProduit().lendemain(), elementContexteUT.getDateFinProduit().lendemain(), 5, attribution));
        }
      }
    }
    return listePeriodesInterProduit;
  }
  
  public Collection getPeriodesInterProduitsSurUTLendemainDjiPourGamme(AttributionSpec p_attribution, String p_gamme)
    throws CoucheLogiqueException
  {
    List listePeriodesInterProduit = null;
    Iterator iterateurAttributions = null;
    AttributionSpec attribution = null;
    ContexteUT.ElementContexteUT elementContexteUT = null;
    
    listePeriodesInterProduit = new ArrayList();
    
    iterateurAttributions = getListeAttributions().iterator();
    while (iterateurAttributions.hasNext())
    {
      attribution = (AttributionSpec)iterateurAttributions.next();
      if ((attribution.getGamme().getNomUnique().equals(p_gamme)) && (p_attribution != attribution))
      {
        elementContexteUT = getElementContexteUT(attribution);
        if ((elementContexteUT.isFinDeProduit()) || ((elementContexteUT.getDateFinProduit() != null) && (elementContexteUT.getDateFinProduit().estVeilleDe(m_periodeUT.getDebut())))) {
          listePeriodesInterProduit.add(new ObjetChronoPeriodeInterProduits(elementContexteUT.getDateFinProduit().lendemain(), elementContexteUT.getDateFinProduit().lendemain(), 5, attribution));
        } else if (attribution.getPjiEffectif() == null) {
          try
          {
            ResultatAvant resultatAvant = AppelAvant.executerAvant(attribution, null);
            
            listePeriodesInterProduit.add(new ObjetChronoPeriodeInterProduits(resultatAvant.getDernierJourAvant().lendemain(), resultatAvant.getDernierJourAvant().lendemain(), 5, attribution));
          }
          catch (ApplicativeException e) {}catch (ExecutionAvantImpossibleException e) {}
        }
      }
    }
    return listePeriodesInterProduit;
  }
  
  public Collection getPeriodesInterProduitsSurUTDjiPourProduit(AttributionSpec p_attribution, String p_nomProduit)
    throws CoucheLogiqueException
  {
    List listePeriodesInterProduit = null;
    Iterator iterateurAttributions = null;
    AttributionSpec attribution = null;
    ContexteUT.ElementContexteUT elementContexteUT = null;
    
    listePeriodesInterProduit = new ArrayList();
    
    iterateurAttributions = getListeAttributions().iterator();
    while (iterateurAttributions.hasNext())
    {
      attribution = (AttributionSpec)iterateurAttributions.next();
      if ((attribution.getProduit().getNomUnique().equals(p_nomProduit)) && (p_attribution != attribution))
      {
        elementContexteUT = getElementContexteUT(attribution);
        if (elementContexteUT.isFinDeProduit()) {
          listePeriodesInterProduit.add(new ObjetChronoPeriodeInterProduits(elementContexteUT.getDateFinProduit(), elementContexteUT.getDateFinProduit().lendemain(), 4, attribution));
        }
      }
    }
    return listePeriodesInterProduit;
  }
  
  public Collection getPeriodesInterProduitsSurUTDjiPourGamme(AttributionSpec p_attribution, String p_gamme)
    throws CoucheLogiqueException
  {
    List listePeriodesInterProduit = null;
    Iterator iterateurAttributions = null;
    AttributionSpec attribution = null;
    ContexteUT.ElementContexteUT elementContexteUT = null;
    
    listePeriodesInterProduit = new ArrayList();
    
    iterateurAttributions = getListeAttributions().iterator();
    while (iterateurAttributions.hasNext())
    {
      attribution = (AttributionSpec)iterateurAttributions.next();
      if ((attribution.getGamme().getNomUnique().equals(p_gamme)) && (p_attribution != attribution))
      {
        elementContexteUT = getElementContexteUT(attribution);
        if (elementContexteUT.isFinDeProduit()) {
          listePeriodesInterProduit.add(new ObjetChronoPeriodeInterProduits(elementContexteUT.getDateFinProduit(), elementContexteUT.getDateFinProduit(), 4, attribution));
        }
      }
    }
    return listePeriodesInterProduit;
  }
  
  public boolean isTravailSurUt(AttributionSpec p_attribution, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit)
    throws CoucheLogiqueException
  {
    boolean retour = false;
    
    AttributionSpec attributionPrecedente = p_facadeCalculProduit.rechercherAttributionPrecedenteSurLUT(p_attribution);
    if ((attributionPrecedente != null) && (getListeOrdonneeCandidats().contains(attributionPrecedente)))
    {
      ContexteUT.ElementContexteUT elementContexteUT = getElementContexteUT(attributionPrecedente);
      if (elementContexteUT.getCumulMoisAREnFinUT() > elementContexteUT.getCumulMoisAREnDebutUT()) {
        retour = true;
      }
    }
    return retour;
  }
  
  public boolean existeAERenFinASU(Damj p_dateFinARE)
    throws CoucheLogiqueException
  {
    boolean aerEnCours = false;
    Damj djiTheoriqueAER = Damj.NUIT_DES_TEMPS;
    
    Collection listeAttribution = getListeOrdonneeCandidats();
    Iterator it = listeAttribution.iterator();
    while (it.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)it.next();
      if ((attribution.getProduit().getNomUnique().equals("SOL_AER05_01")) || (attribution.getProduit().getNomUnique().equals("SOL_AER05_02")) || (attribution.getProduit().getNomUnique().equals("SOL_AER05_03")))
      {
        Damj djiAER = ((ProduitSolSpec)attribution.getProduit()).getDjiTheoriqueAER(attribution);
        if (djiAER.estApresOuCoincideAvec(djiTheoriqueAER)) {
          djiTheoriqueAER = djiAER;
        }
      }
    }
    if (p_dateFinARE.estAvantOuCoincideAvec(djiTheoriqueAER)) {
      aerEnCours = true;
    }
    return aerEnCours;
  }
}

/* Location:
 * Qualified Name:     ContexteUT
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */