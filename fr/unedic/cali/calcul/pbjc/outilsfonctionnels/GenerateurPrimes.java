package fr.unedic.cali.calcul.pbjc.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPonctuel;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.EvenementPaiementProduitPonctuel;
import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.pbjc.dom.PrimePbjcNcp;
import fr.unedic.cali.calcul.prime.FacadePrimeProduitSpec;
import fr.unedic.cali.calcul.prime.FacadePrimesProduitFactory;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.parcours.ContexteParcoursCalcul;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteMois;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GenerateurPrimes
{
  private static List<String> s_listePrimes = new ArrayList();
  
  static
  {
    s_listePrimes.add("INR_PFM01_01");
    s_listePrimes.add("INR_RCE04_01");
    s_listePrimes.add("INR_PAR09_01");
    s_listePrimes.add("DEC_CGE01_01");
    s_listePrimes.add("FOR_CSP05_01");
    s_listePrimes.add("SOL_AER05_04");
  }
  
  public static Collection creerCollectionPrimes(List p_listeAttributions, Map p_mapCalendrier, Damj p_dateDebutGeneration)
    throws ApplicativeException
  {
    Collection chronoPrimes = new ArrayList();
    Iterator iterator = null;
    
    iterator = p_listeAttributions.iterator();
    while (iterator.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)iterator.next();
      if (p_mapCalendrier.containsKey(attribution))
      {
        CalendrierExecutionCalculSpec calendrierExecutionCalcul = (CalendrierExecutionCalculSpec)p_mapCalendrier.get(attribution);
        if ((calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique)) {
          chronoPrimes.addAll(creerCollectionPrimes(attribution, (CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul, p_dateDebutGeneration));
        } else if ((calendrierExecutionCalcul instanceof CalendrierExecutionCalculPonctuel)) {
          chronoPrimes.addAll(creerCollectionPrimes(attribution, (CalendrierExecutionCalculPonctuel)calendrierExecutionCalcul, p_dateDebutGeneration));
        }
      }
    }
    return chronoPrimes;
  }
  
  private static Collection creerCollectionPrimes(AttributionSpec p_attribution, CalendrierExecutionCalculPeriodique p_calendrier, Damj p_dateDebutGeneration)
    throws ApplicativeException
  {
    Collection collectionARetourner = null;
    ChronologiePeriodes unitesTraitement = null;
    
    collectionARetourner = new ArrayList();
    if (!controlerAttributionProduit(p_attribution)) {
      return collectionARetourner;
    }
    unitesTraitement = (ChronologiePeriodes)p_calendrier.getChronologieUnitesTraitements();
    if (unitesTraitement == null) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_PBJC_UNITES_TRAITEMENT_ABSENTE", "Chronologie des Unités de Traitement vide lors de la création des PBJCs pour le produit", null);
    }
    collectionARetourner.addAll(creerCollectionPrimesPendant(p_attribution, p_calendrier, p_dateDebutGeneration));
    
    return collectionARetourner;
  }
  
  private static Collection creerCollectionPrimesPendant(AttributionSpec p_attribution, CalendrierExecutionCalculPeriodique p_calendrier, Damj p_dateDebutGeneration)
    throws CoucheLogiqueException
  {
    Collection collectionARetourner = new ArrayList();
    ChronologiePeriodes unitesTraitement = null;
    UniteTraitement ut = null;
    
    unitesTraitement = (ChronologiePeriodes)p_calendrier.getChronologieUnitesTraitements();
    
    FacadePrimeProduitSpec facadePrime = creerFacadesPrimeProduit(p_attribution);
    if (facadePrime != null)
    {
      unitesTraitement.iterer();
      while (unitesTraitement.encoreSuivant())
      {
        ut = (UniteTraitement)unitesTraitement.elementSuivant();
        if ((ut.getDateFin().estApresOuCoincideAvec(p_dateDebutGeneration)) && (!ut.getDateDebut().estApres(p_calendrier.getDernierJourIndemnisable())))
        {
          Collection listeDesSommes = null;
          Iterator iterateurDesSommes = null;
          Somme somme = null;
          
          listeDesSommes = ut.getCollectionSommes();
          iterateurDesSommes = listeDesSommes.iterator();
          while (iterateurDesSommes.hasNext())
          {
            somme = (Somme)iterateurDesSommes.next();
            if ((somme.getNbBase().equals(new QuantiteMois("1"))) && (!somme.getMontant().getMontantBrut().getValeur().equals("0")))
            {
              PrimePbjcNcp prime = facadePrime.creerPrimeNcp(ut, somme, p_attribution);
              PrimePbjcNcp primeFiancement = facadePrime.creerPrimeFiancementNcp(ut, somme, p_attribution);
              if (prime != null) {
                collectionARetourner.add(prime);
              }
              if (primeFiancement != null) {
                collectionARetourner.add(primeFiancement);
              }
            }
          }
        }
      }
    }
    return collectionARetourner;
  }
  
  private static boolean controlerAttributionProduit(AttributionSpec p_attribution)
  {
    String codeProduitNcp = null;
    
    codeProduitNcp = p_attribution.getProduit().getNom();
    
    return s_listePrimes.contains(codeProduitNcp);
  }
  
  public static void enregistrerPrimePbjcNcp(Collection p_collectionNewPrimes, Damj p_dateDebutGeneration, IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    Collection collectionOldPrimes = p_individu.getCollectionPrimes();
    
    Collections.sort((List)collectionOldPrimes);
    Collections.sort((List)p_collectionNewPrimes);
    
    Iterator collectionNewPrimesIterator = p_collectionNewPrimes.iterator();
    Iterator collectionOldPrimesIterator = collectionOldPrimes.iterator();
    Iterator ite = collectionOldPrimes.iterator();
    ArrayList oldPrimesASuppr = new ArrayList();
    boolean trouvee = false;
    if (p_individu.getDateDebutGenerationPrimes().coincideAvec(Damj.NUIT_DES_TEMPS)) {
      p_individu.setDateDebutGenerationPrimes(p_dateDebutGeneration);
    } else {
      p_individu.setDateDebutGenerationPrimes(Damj.min(p_individu.getDateDebutGenerationPrimes(), p_dateDebutGeneration));
    }
    PrimePbjcNcp savePbjc;
    while ((collectionOldPrimesIterator.hasNext()) && (!trouvee))
    {
      PrimePbjcNcp oldPrime = (PrimePbjcNcp)collectionOldPrimesIterator.next();
      if (oldPrime.getDateEffet().estApresOuCoincideAvec(p_dateDebutGeneration))
      {
        trouvee = true;
        collectionOldPrimesIterator = ite;
      }
      else
      {
        savePbjc = (PrimePbjcNcp)ite.next();
      }
    }
    if ((!collectionOldPrimes.isEmpty()) && (p_collectionNewPrimes != null) && (!p_collectionNewPrimes.isEmpty()))
    {
      while ((collectionOldPrimesIterator.hasNext()) && (collectionNewPrimesIterator.hasNext()))
      {
        PrimePbjcNcp oldPrimePbjc = (PrimePbjcNcp)collectionOldPrimesIterator.next();
        PrimePbjcNcp newPrimePbjc = (PrimePbjcNcp)collectionNewPrimesIterator.next();
        if (oldPrimePbjc.getDateEffet().estApresOuCoincideAvec(p_dateDebutGeneration.getDebutMois())) {
          newPrimePbjc.copieElements(oldPrimePbjc);
        }
      }
      while (collectionOldPrimesIterator.hasNext())
      {
        PrimePbjcNcp primeASuppr = (PrimePbjcNcp)collectionOldPrimesIterator.next();
        DomManager.supprimer(primeASuppr);
        oldPrimesASuppr.add(primeASuppr);
      }
    }
    while (collectionNewPrimesIterator.hasNext())
    {
      collectionOldPrimes.add((PrimePbjcNcp)collectionNewPrimesIterator.next()); continue;
      if (!collectionOldPrimes.isEmpty())
      {
        collectionOldPrimesIterator = collectionOldPrimes.iterator();
        while (collectionOldPrimesIterator.hasNext())
        {
          PrimePbjcNcp prime = (PrimePbjcNcp)collectionOldPrimesIterator.next();
          if (prime.getDateEffet().estApresOuCoincideAvec(p_dateDebutGeneration.getDebutMois()))
          {
            DomManager.supprimer(prime);
            oldPrimesASuppr.add(prime);
          }
        }
      }
      if ((p_collectionNewPrimes != null) && (!p_collectionNewPrimes.isEmpty()))
      {
        collectionNewPrimesIterator = p_collectionNewPrimes.iterator();
        while (collectionNewPrimesIterator.hasNext()) {
          collectionOldPrimes.add((PrimePbjcNcp)collectionNewPrimesIterator.next());
        }
      }
    }
    if (!oldPrimesASuppr.isEmpty())
    {
      Iterator iteBis = oldPrimesASuppr.iterator();
      while (iteBis.hasNext()) {
        collectionOldPrimes.remove((PrimePbjcNcp)iteBis.next());
      }
    }
  }
  
  public static void nettoyerPrimesPBJCs(Damj p_dateDebutNettoyage, IndividuSpec p_individu)
  {
    if (ContexteParcoursCalcul.estPersistant())
    {
      Collection collectionPrimes = p_individu.getCollectionPrimes();
      if ((collectionPrimes != null) && (!collectionPrimes.isEmpty()))
      {
        ArrayList oldPrimesASuppr = new ArrayList();
        Iterator collectionPrimesIterator = collectionPrimes.iterator();
        while (collectionPrimesIterator.hasNext())
        {
          PrimePbjcNcp primeNcp = (PrimePbjcNcp)collectionPrimesIterator.next();
          if (primeNcp.getDateEffet().estApresOuCoincideAvec(p_dateDebutNettoyage))
          {
            oldPrimesASuppr.add(primeNcp);
            DomManager.supprimer(primeNcp);
          }
        }
        if (!oldPrimesASuppr.isEmpty())
        {
          Iterator ite = oldPrimesASuppr.iterator();
          while (ite.hasNext()) {
            collectionPrimes.remove((PrimePbjcNcp)ite.next());
          }
        }
      }
    }
  }
  
  private static FacadePrimeProduitSpec creerFacadesPrimeProduit(AttributionSpec p_attribution)
    throws CoucheLogiqueException
  {
    return FacadePrimesProduitFactory.getInstance().getInstanceGestionnairePBJCProduit(p_attribution.getProduit());
  }
  
  private static Collection creerCollectionPrimes(AttributionSpec p_attribution, CalendrierExecutionCalculPonctuel p_calendrier, Damj p_dateDebutGeneration)
    throws ApplicativeException
  {
    Collection collectionARetourner = null;
    EvenementPaiementProduitPonctuel evtPPP = null;
    
    collectionARetourner = new ArrayList();
    if (!controlerAttributionProduit(p_attribution)) {
      return collectionARetourner;
    }
    if (p_calendrier.getDernierJourIndemnisable().estAvant(p_dateDebutGeneration)) {
      return collectionARetourner;
    }
    evtPPP = p_calendrier.getEvenementPaiementProduitPonctuel();
    if (evtPPP == null) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_EVT_PRODUIT_PONCTUEL_ABSENTE", "EvenementPaiementProduitPonctuel vide lors de la création des Primes pour le produit", null);
    }
    collectionARetourner.addAll(creerCollectionPrimesPendantPP(p_attribution, p_calendrier));
    
    return collectionARetourner;
  }
  
  private static Collection creerCollectionPrimesPendantPP(AttributionSpec p_attribution, CalendrierExecutionCalculPonctuel p_calendrier)
    throws CoucheLogiqueException
  {
    Collection collectionARetourner = new ArrayList();
    EvenementPaiementProduitPonctuel evtPPP = null;
    
    evtPPP = p_calendrier.getEvenementPaiementProduitPonctuel();
    
    FacadePrimeProduitSpec facadePrime = creerFacadesPrimeProduit(p_attribution);
    if (facadePrime != null)
    {
      PrimePbjcNcp prime = facadePrime.creerPrimeProduitPonctuelNcp(evtPPP, p_attribution);
      if (prime != null) {
        collectionARetourner.add(prime);
      }
    }
    return collectionARetourner;
  }
}

/* Location:
 * Qualified Name:     GenerateurPrimes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */