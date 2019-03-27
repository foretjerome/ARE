package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import fr.unedic.cali.calcul.pbjc.dom.AideNcp;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PrimePbjcNcp;
import fr.unedic.cali.calcul.pbjc.outilsfonctionnels.ComparateurSurDateDebutPBJC;
import fr.unedic.cali.calcul.pbjc.outilsfonctionnels.FiltreDebutPbjcAvantDate;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.ClassementSansObjet;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.utilitaire.comparateurs.ComparateurNeutre;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourGamme;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreOuvertureDroitSurDecision;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.Strings;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Dom;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import xcalia.lido.api.LiDOHelper;

public class ParcoursListerEtatPrestationsServies
  extends ParcoursServiceAbstrait
  implements ParcoursPopulationSpec
{
  public static final String CODE_ERREUR_REEXAMEN = "R200";
  public static final String CODE_ERREUR_ATTENTE_DECISION = "R201";
  public static final String CODE_ERREUR_ANOMALIE_CALCUL = "R202";
  public static final String INDETERMINE = "INDETERMINE";
  public static final String MOTIF_NON_VERSE = "NON_VERSE";
  public static final String VERSEMENT_UNIQUE = "VERSEMENT_UNIQUE";
  public static final String CODE_MOTIF_REEXAMEN = "NV50";
  public static final String CODE_MOTIF_ATTENTE_DECISION = "NV51";
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
  
  protected Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Début Parcours ParcoursListerEtatPrestationsServies ********\n");
    }
    DomListerEtatPrestationsServies domContexte = preTraitementDom(contexte.getDonnees());
    ResultatListerEtatPrestationsServies resultatListerEtatPrestationsServies = new ResultatListerEtatPrestationsServies();
    
    resultatListerEtatPrestationsServies.setRsin(domContexte.getRsin());
    resultatListerEtatPrestationsServies.setCxala(domContexte.getCxala());
    resultatListerEtatPrestationsServies.setCxass(domContexte.getCxass());
    resultatListerEtatPrestationsServies.setContexteOccasionnel(domContexte.isContexteOccasionnel());
    
    boolean estEnAnomalie = alimenterCodeErreur(resultatListerEtatPrestationsServies, domContexte);
    
    boolean estReexamenOuAttDecision = false;
    if ((resultatListerEtatPrestationsServies.getCodeErreur() != null) && ((resultatListerEtatPrestationsServies.getCodeErreur().equals("R200")) || (resultatListerEtatPrestationsServies.getCodeErreur().equals("R201")))) {
      estReexamenOuAttDecision = true;
    }
    if ((!estEnAnomalie) || (estReexamenOuAttDecision))
    {
      Map mapPrestations = new HashMap();
      
      ChronologiePeriodes chronologiePeriodes = (ChronologiePeriodes)DomManager.getChronologiePbjcNcpOccasionnel(domContexte.getDateDebutRecherche()).copier(new FiltreDebutPbjcAvantDate(domContexte.getDateFinRecherche().lendemain()));
      
      chronologiePeriodes.setComparateur(new ComparateurSurDateDebutPBJC());
      chronologiePeriodes.iterer();
      while (chronologiePeriodes.encoreSuivant())
      {
        PbjcNcp pbjcNcp = (PbjcNcp)chronologiePeriodes.elementSuivant();
        String codeProduit;
        String codeProduit;
        if (pbjcNcp.getProduit() == null) {
          codeProduit = rechercherCodeProduitAPartirRsodRsinRang(pbjcNcp, mapPrestations);
        } else {
          codeProduit = pbjcNcp.getProduit();
        }
        if (resultatListerEtatPrestationsServies.getCodeErreur() != null)
        {
          if (resultatListerEtatPrestationsServies.getCodeErreur().equals("R200")) {
            domContexte.setMotifCloture("NV50");
          } else if (resultatListerEtatPrestationsServies.getCodeErreur().equals("R201")) {
            domContexte.setMotifCloture("NV51");
          }
          resultatListerEtatPrestationsServies.setCodeErreur("");
        }
        if ((codeProduit.equals(pbjcNcp.getCodeTypeMontant1())) || (verifierProduitSupport(codeProduit, pbjcNcp.getCodeTypeMontant1())))
        {
          traitementPrestation(domContexte, pbjcNcp.getCodeTypeMontant1(), mapPrestations, pbjcNcp, pbjcNcp.getBaseDeCalcul1(), false);
        }
        else
        {
          traitementPrestation(domContexte, codeProduit, mapPrestations, pbjcNcp, new BigDecimal(0), false);
          traitementPrestation(domContexte, pbjcNcp.getCodeTypeMontant1(), mapPrestations, pbjcNcp, pbjcNcp.getBaseDeCalcul1(), true);
        }
        traitementPrestation(domContexte, pbjcNcp.getCodeTypeMontant2(), mapPrestations, pbjcNcp, pbjcNcp.getBaseDeCalcul2(), true);
        
        traitementPrestation(domContexte, pbjcNcp.getCodeTypeMontant3(), mapPrestations, pbjcNcp, pbjcNcp.getBaseDeCalcul3(), true);
        
        traitementPrestation(domContexte, pbjcNcp.getCodeTypeMontant4(), mapPrestations, pbjcNcp, pbjcNcp.getBaseDeCalcul4(), true);
        
        traitementPrestation(domContexte, pbjcNcp.getCodeTypeMontant5(), mapPrestations, pbjcNcp, pbjcNcp.getBaseDeCalcul5(), true);
        
        traitementPrestation(domContexte, pbjcNcp.getCodeTypeMontant6(), mapPrestations, pbjcNcp, pbjcNcp.getBaseDeCalcul6(), true);
        
        traitementPrestation(domContexte, pbjcNcp.getCodeTypeMontant7(), mapPrestations, pbjcNcp, pbjcNcp.getBaseDeCalcul7(), true);
      }
      Collection collectionPrimes = DomManager.getCollectionPrimesPbjcNcp(domContexte.getDateDebutRecherche());
      
      Iterator primeIterator = collectionPrimes.iterator();
      while (primeIterator.hasNext())
      {
        PrimePbjcNcp primeNcp = (PrimePbjcNcp)primeIterator.next();
        String codeProduit = primeNcp.getCodeProduit();
        traitementPrime(domContexte, codeProduit, mapPrestations, primeNcp);
      }
      Collection<AideNcp> collectionAides = DomManager.getCollectionAidesNcp(domContexte.getDateDebutRecherche());
      
      Iterator<AideNcp> aideIterator = collectionAides.iterator();
      while (aideIterator.hasNext())
      {
        AideNcp aideNcp = (AideNcp)aideIterator.next();
        String codeProduit = aideNcp.getCodeProduit();
        traitementAide(domContexte, codeProduit, mapPrestations, aideNcp);
      }
      alimentationMapResultat(resultatListerEtatPrestationsServies, mapPrestations);
    }
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin Parcours ParcoursListerEtatPrestationsServies ********\n");
    }
    return resultatListerEtatPrestationsServies;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 0;
  }
  
  private DomListerEtatPrestationsServies preTraitementDom(Dom donnees)
  {
    DomListerEtatPrestationsServies domRetour = new DomListerEtatPrestationsServies();
    if ((donnees instanceof DomListerEtatPrestationsServies))
    {
      domRetour = (DomListerEtatPrestationsServies)donnees;
    }
    else
    {
      DomTraitementOccasionnel domTransitoire = (DomTraitementOccasionnel)donnees;
      domRetour.setCxala(domTransitoire.getContexteService().getCxala().toString());
      domRetour.setRsin(domTransitoire.getContexteService().getRsin());
      domRetour.setCxass(domTransitoire.getRedressement().getCodeAssedic());
      domRetour.setIndividu(domTransitoire.getIndividu());
      domRetour.setDateDebutRecherche(Damj.NUIT_DES_TEMPS);
      domRetour.setDateFinRecherche(domTransitoire.getDate());
      domRetour.setContexteOccasionnel(true);
    }
    return domRetour;
  }
  
  public String rechercherCodeProduitAPartirRsodRsinRang(PbjcNcp pbjcNcp, Map mapPrestations)
  {
    String codeProduit = "INDETERMINE";
    if (mapPrestations.keySet() != null)
    {
      Iterator iterateur = mapPrestations.keySet().iterator();
      while (iterateur.hasNext())
      {
        ParcoursListerEtatPrestationsServies.ConteneurPrestations conteneur = (ParcoursListerEtatPrestationsServies.ConteneurPrestations)mapPrestations.get(iterateur.next());
        if ((pbjcNcp.getRefOdPjcFaitGenerateurOrigine() == conteneur.getDomCourant().getRsod()) && (pbjcNcp.getIdentifiantReprise() == conteneur.getDomCourant().getRsrp()) && (pbjcNcp.getRangProlongation() == conteneur.getDomCourant().getRang())) {
          codeProduit = conteneur.getDomCourant().getCodeProduit();
        }
      }
    }
    return codeProduit;
  }
  
  private void traitementPrestation(DomListerEtatPrestationsServies pdom, String codeProduit, Map mapPrestations, PbjcNcp pbjcNcp, BigDecimal montant, boolean necessiteExclusion)
    throws CoucheLogiqueException
  {
    boolean estNouvellePrestation = true;
    DomListerEtatPrestationsServies dom = null;
    List listePrestation = null;
    if ((codeProduit != null) && (StringUtils.isNotEmpty(codeProduit)) && ((!necessiteExclusion) || (!estCodeProduitAExclure(codeProduit))))
    {
      if (mapPrestations.containsKey(codeProduit))
      {
        ParcoursListerEtatPrestationsServies.ConteneurPrestations conteneur = (ParcoursListerEtatPrestationsServies.ConteneurPrestations)mapPrestations.get(codeProduit);
        dom = conteneur.getDomCourant();
        listePrestation = conteneur.getListePrestations();
        if ((dom.getRsod() == pbjcNcp.getRefOdPjcFaitGenerateurOrigine()) && (dom.getRsrp() == pbjcNcp.getIdentifiantReprise()) && (dom.getRang() == pbjcNcp.getRangProlongation()))
        {
          estNouvellePrestation = false;
          if (pdom.getDateFinRecherche().estAvant(pbjcNcp.getDateFinPbjc())) {
            dom.getPeriode().setFin(pdom.getDateFinRecherche());
          } else {
            dom.getPeriode().setFin(pbjcNcp.getDateFinPbjc());
          }
          alimenterDom(dom, pbjcNcp, montant);
          if (pdom.getMotifCloture() != null) {
            if (pdom.getMotifCloture().equalsIgnoreCase("NV50")) {
              dom.setMotifCloture("NV50");
            } else if (pdom.getMotifCloture().equalsIgnoreCase("NV51")) {
              dom.setMotifCloture("NV51");
            }
          }
          if ("INDETERMINE".equals(dom.getCodeProduit())) {
            dom.setCodeProduit(codeProduit);
          }
        }
      }
      if (estNouvellePrestation)
      {
        if (listePrestation != null)
        {
          gestionDroitSansJustifFin(dom, pbjcNcp);
          listePrestation.add(dom);
        }
        else
        {
          listePrestation = new ArrayList();
        }
        dom = new DomListerEtatPrestationsServies();
        dom.setCodeProduit(codeProduit);
        dom.setRsod(pbjcNcp.getRefOdPjcFaitGenerateurOrigine());
        dom.setRsrp(pbjcNcp.getIdentifiantReprise());
        dom.setRang(pbjcNcp.getRangProlongation());
        dom.setPeriode(new Periode(pbjcNcp.getDateDebutPbjc(), pbjcNcp.getDateFinPbjc()));
        dom.setDateFinRecherche(pdom.getDateFinRecherche());
        dom.setDateDebutRecherche(pdom.getDateDebutRecherche());
        if (pdom.getDateFinRecherche().estAvant(pbjcNcp.getDateFinPbjc())) {
          dom.getPeriode().setFin(pdom.getDateFinRecherche());
        }
        dom.setDateDernierJourCalcule(pdom.getDateDernierJourCalcule());
        dom.setDateDebutEtat(pbjcNcp.getDateDebutPbjc());
        if (pdom.getMotifCloture() != null) {
          if (pdom.getMotifCloture().equalsIgnoreCase("NV50")) {
            dom.setMotifCloture("NV50");
          } else if (pdom.getMotifCloture().equalsIgnoreCase("NV51")) {
            dom.setMotifCloture("NV51");
          }
        }
        Collection liste = pdom.getIndividu().getDemandes();
        ArrayList listeSansSansObjet = new ArrayList();
        Iterator iterateur = liste.iterator();
        while (iterateur.hasNext())
        {
          DemandeSpec demande = (DemandeSpec)iterateur.next();
          if (!(demande.getClassementAdministratif() instanceof ClassementSansObjet)) {
            listeSansSansObjet.add(demande);
          }
        }
        FiltreET filtreCali = new FiltreET();
        filtreCali.ajouterFiltre(new FiltreOuvertureDroitSurDecision(true));
        String gamme = Strings.left(codeProduit, 3);
        filtreCali.ajouterFiltre(new FiltreDecisionPourGamme(gamme));
        Chronologie chrono = new ChronologieDebuts();
        chrono.setComparateur(new ComparateurNeutre());
        chrono.ajouter(listeSansSansObjet);
        AttributionSpec attribution = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(chrono, pbjcNcp.getDateDebutPbjc().lendemain(), filtreCali);
        if (attribution != null) {
          dom.setDateOd(attribution.getDateAttribution());
        }
        alimenterDom(dom, pbjcNcp, montant);
        mapPrestations.put(codeProduit, new ParcoursListerEtatPrestationsServies.ConteneurPrestations(this, listePrestation, dom));
      }
    }
  }
  
  private void traitementAide(DomListerEtatPrestationsServies pdom, String codeProduit, Map mapPrestations, AideNcp aide)
    throws CoucheLogiqueException
  {
    DomListerEtatPrestationsServies dom = null;
    List listePrestation = null;
    if ((codeProduit != null) && (StringUtils.isNotEmpty(codeProduit)))
    {
      dom = new DomListerEtatPrestationsServies();
      dom.setDateFinRecherche(pdom.getDateFinRecherche());
      dom.setDateDebutRecherche(pdom.getDateDebutRecherche());
      dom.setDateDernierJourCalcule(pdom.getDateDernierJourCalcule());
      dom.setCodeProduit(codeProduit);
      dom.setPeriode(new Periode(aide.getDateDebutAide(), aide.getDateFinAide()));
      dom.setDateDebutEtat(aide.getDateEffet());
      dom.setDateOd(aide.getDateEffet());
      dom.setMotif("VERSEMENT_UNIQUE");
      dom.setDateObtention(Damj.dateVersDamj((Date)LiDOHelper.getSyntheticValue(aide.getPC(), "{version}")));
      if (mapPrestations.containsKey(codeProduit))
      {
        ParcoursListerEtatPrestationsServies.ConteneurPrestations conteneur = (ParcoursListerEtatPrestationsServies.ConteneurPrestations)mapPrestations.get(codeProduit);
        listePrestation = conteneur.getListePrestations();
        listePrestation.add(dom);
      }
      else
      {
        listePrestation = new ArrayList();
        ParcoursListerEtatPrestationsServies.ConteneurPrestations conteneur = new ParcoursListerEtatPrestationsServies.ConteneurPrestations(this, listePrestation, dom);
        mapPrestations.put(codeProduit, conteneur);
      }
    }
  }
  
  private void traitementPrime(DomListerEtatPrestationsServies pdom, String codeProduit, Map mapPrestations, PrimePbjcNcp prime)
    throws CoucheLogiqueException
  {
    DomListerEtatPrestationsServies dom = null;
    List listePrestation = null;
    if ((codeProduit != null) && (StringUtils.isNotEmpty(codeProduit)))
    {
      dom = new DomListerEtatPrestationsServies();
      dom.setDateFinRecherche(pdom.getDateFinRecherche());
      dom.setDateDebutRecherche(pdom.getDateDebutRecherche());
      dom.setDateDernierJourCalcule(pdom.getDateDernierJourCalcule());
      dom.setCodeProduit(codeProduit);
      dom.setPeriode(new Periode(prime.getDateEffet(), prime.getDateEffet()));
      dom.setDateDebutEtat(prime.getDateEffet());
      dom.setDateOd(prime.getDateEffet());
      dom.setMotif("VERSEMENT_UNIQUE");
      dom.setDateObtention(Damj.dateVersDamj((Date)LiDOHelper.getSyntheticValue(prime.getPC(), "{version}")));
      if (mapPrestations.containsKey(codeProduit))
      {
        ParcoursListerEtatPrestationsServies.ConteneurPrestations conteneur = (ParcoursListerEtatPrestationsServies.ConteneurPrestations)mapPrestations.get(codeProduit);
        listePrestation = conteneur.getListePrestations();
        listePrestation.add(dom);
      }
      else
      {
        listePrestation = new ArrayList();
        ParcoursListerEtatPrestationsServies.ConteneurPrestations conteneur = new ParcoursListerEtatPrestationsServies.ConteneurPrestations(this, listePrestation, dom);
        mapPrestations.put(codeProduit, conteneur);
      }
    }
  }
  
  private boolean estCodeProduitAExclure(String codeProduit)
  {
    return ("PCRC".equals(codeProduit)) || ("CADT".equals(codeProduit)) || ("ASU_CGE01_04".equals(codeProduit)) || ("ASU_CGE01_05".equals(codeProduit)) || ("RBF_IHE06_01".equals(codeProduit)) || ("RBF_ITR05_01".equals(codeProduit));
  }
  
  private boolean alimenterCodeErreur(ResultatListerEtatPrestationsServies resultatListerEtatPrestationsServies, DomListerEtatPrestationsServies dom)
  {
    Collection chronoDemandes = dom.getIndividu().getDemandes();
    boolean estEnAnomalie = false;
    if (chronoDemandes != null)
    {
      Iterator iterateurCollection = chronoDemandes.iterator();
      while ((iterateurCollection.hasNext()) && (!estEnAnomalie))
      {
        DemandeSpec demande = (DemandeSpec)iterateurCollection.next();
        if (demande.estEnReExamen())
        {
          resultatListerEtatPrestationsServies.setCodeErreur("R200");
          estEnAnomalie = true;
        }
        else if ((!demande.estDecisionnee()) && ((demande.getClassementAdministratif() == null) || (!demande.getClassementAdministratif().getTypeClassement().equals("SO"))))
        {
          resultatListerEtatPrestationsServies.setCodeErreur("R201");
          estEnAnomalie = true;
        }
      }
    }
    IndividuPbjcNcp individuPbjcNcp = dom.getIndividu().getIndividuPbjcNcp();
    if ((individuPbjcNcp != null) && (individuPbjcNcp.isAnomalieBloquant()))
    {
      resultatListerEtatPrestationsServies.setCodeErreur("R202");
      estEnAnomalie = true;
    }
    return estEnAnomalie;
  }
  
  private void alimentationMapResultat(ResultatListerEtatPrestationsServies resultatListerEtatPrestationsServies, Map mapPrestations)
  {
    Map mapResultat = new HashMap();
    if (mapPrestations.keySet() != null)
    {
      String codeProduit = null;
      Iterator iterateur = mapPrestations.keySet().iterator();
      while (iterateur.hasNext())
      {
        codeProduit = (String)iterateur.next();
        ParcoursListerEtatPrestationsServies.ConteneurPrestations conteneur = (ParcoursListerEtatPrestationsServies.ConteneurPrestations)mapPrestations.get(codeProduit);
        if (conteneur.getListePrestations() == null) {
          conteneur.setListePrestations(new ArrayList());
        }
        if (conteneur.getDomCourant() != null) {
          conteneur.getListePrestations().add(conteneur.getDomCourant());
        }
        mapResultat.put(codeProduit, conteneur.getListePrestations());
      }
    }
    resultatListerEtatPrestationsServies.setMapEtatPrestationsServies(mapResultat);
  }
  
  private void alimenterDom(DomListerEtatPrestationsServies dom, PbjcNcp pbjc, BigDecimal montant)
  {
    List listeJustif = creationListeJustif(pbjc);
    boolean conserveJustifs = false;
    if ((montant == null) || ((montant.compareTo(new BigDecimal(0)) == 0) && ((pbjc.getCodeMotifNonPaiement() == null) || (!"43".equals(pbjc.getCodeMotifNonPaiement())))))
    {
      if ((dom.getMotif() == null) || (StringUtils.isEmpty(dom.getMotif())))
      {
        dom.setDateDebutEtat(pbjc.getDateDebutPbjc());
        dom.setMotif("NON_VERSE");
      }
      conserveJustifs = true;
      
      dom.setCodeMotifNonPaiement(pbjc.getCodeMotifNonPaiement());
      dom.setNature(pbjc.getNaturePBJC());
    }
    else if ((dom.getMotif() != null) && (StringUtils.isNotEmpty(dom.getMotif())))
    {
      dom.setDateDebutEtat(pbjc.getDateDebutPbjc());
      dom.setMotif("");
      dom.setCodeMotifNonPaiement("");
      dom.setNature("");
    }
    if ((conserveJustifs) && (dom.getListeJustif() != null)) {
      dom.getListeJustif().addAll(listeJustif);
    } else {
      dom.setListeJustif(listeJustif);
    }
    dom.setDateObtention(Damj.dateVersDamj((Date)LiDOHelper.getSyntheticValue(pbjc.getPC(), "{version}")));
    dom.setCodeRadiation(pbjc.getCodeRadiationLendemainPeriode());
  }
  
  private List creationListeJustif(PbjcNcp pbjc)
  {
    List listeJustif = new ArrayList();
    if ((pbjc.getComplementDeJustification0() != null) && (StringUtils.isNotEmpty(pbjc.getComplementDeJustification0()))) {
      listeJustif.add(pbjc.getComplementDeJustification0());
    }
    if ((pbjc.getComplementDeJustification1() != null) && (StringUtils.isNotEmpty(pbjc.getComplementDeJustification1()))) {
      listeJustif.add(pbjc.getComplementDeJustification1());
    }
    if ((pbjc.getComplementDeJustification2() != null) && (StringUtils.isNotEmpty(pbjc.getComplementDeJustification2()))) {
      listeJustif.add(pbjc.getComplementDeJustification2());
    }
    if ((pbjc.getComplementDeJustification3() != null) && (StringUtils.isNotEmpty(pbjc.getComplementDeJustification3()))) {
      listeJustif.add(pbjc.getComplementDeJustification3());
    }
    if ((pbjc.getComplementDeJustification4() != null) && (StringUtils.isNotEmpty(pbjc.getComplementDeJustification4()))) {
      listeJustif.add(pbjc.getComplementDeJustification4());
    }
    if ((pbjc.getComplementDeJustification5() != null) && (StringUtils.isNotEmpty(pbjc.getComplementDeJustification5()))) {
      listeJustif.add(pbjc.getComplementDeJustification5());
    }
    if ((pbjc.getComplementDeJustification6() != null) && (StringUtils.isNotEmpty(pbjc.getComplementDeJustification6()))) {
      listeJustif.add(pbjc.getComplementDeJustification6());
    }
    if ((pbjc.getComplementDeJustification7() != null) && (StringUtils.isNotEmpty(pbjc.getComplementDeJustification7()))) {
      listeJustif.add(pbjc.getComplementDeJustification7());
    }
    if ((pbjc.getComplementDeJustification8() != null) && (StringUtils.isNotEmpty(pbjc.getComplementDeJustification8()))) {
      listeJustif.add(pbjc.getComplementDeJustification8());
    }
    if ((pbjc.getComplementDeJustification9() != null) && (StringUtils.isNotEmpty(pbjc.getComplementDeJustification9()))) {
      listeJustif.add(pbjc.getComplementDeJustification9());
    }
    return listeJustif;
  }
  
  private void gestionDroitSansJustifFin(DomListerEtatPrestationsServies dom, PbjcNcp pbjcNcp)
  {
    List listeJustif = creationListeJustif(pbjcNcp);
    if (listeJustif.contains("DD")) {
      dom.getListeJustif().add("DD");
    } else if (listeJustif.contains("C2")) {
      dom.getListeJustif().add("C2");
    } else if ((dom.getRsod() == pbjcNcp.getRefOdPjcFaitGenerateurOrigine()) && (dom.getRsrp() == pbjcNcp.getIdentifiantReprise())) {
      dom.getListeJustif().add("DD");
    }
  }
  
  private boolean verifierProduitSupport(String codeProduit, String codeTypeMontant)
  {
    return (codeProduit.equals("INDETERMINE")) && ((codeTypeMontant.equals("RBF_HBT01_02")) || (codeTypeMontant.equals("RBF_RTN03_02")) || (codeTypeMontant.equals("RBF_TPT02_02")) || (codeTypeMontant.equals("RBF_FPO04_02")));
  }
}

/* Location:
 * Qualified Name:     ParcoursListerEtatPrestationsServies
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */