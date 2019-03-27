package fr.unedic.cali.calcul.pbjc.outilsfonctionnels;

import fr.unedic.cali.autresdoms.d90.dom.DeltaMontantMensuel;
import fr.unedic.cali.autresdoms.d90.dom.DeltaProduit;
import fr.unedic.cali.calcul.pbjc.dom.AideNcp;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PrimePbjcNcp;
import fr.unedic.cali.dom.affectation.GammeRbf;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ComparateurMontants
{
  private static final int INSERTION_AVANT = 0;
  private static final int INSERTION_APRES = 1;
  private static final int QUANTITE_PRIME = 1;
  
  public static Collection comparerPBJCs(ChronologiePeriodes p_chronoPBJCsAvant, ChronologiePeriodes p_chronoPBJCsApres, Damj p_dateDebut, Damj p_dateFin)
  {
    Map mapDeltasMontants = effectuerComparaisonPBJCs(p_chronoPBJCsAvant, p_chronoPBJCsApres, p_dateDebut, p_dateFin);
    Map mapTrieeParDate = new TreeMap(mapDeltasMontants);
    return mapTrieeParDate.values();
  }
  
  public static Collection comparerPrimes(Collection p_collectionPrimesAvant, Collection p_collectionPrimesApres, Damj p_dateDebut, Damj p_dateFin)
  {
    Map mapDeltasMontants = effectuerComparaisonPrimes(p_collectionPrimesAvant, p_collectionPrimesApres, p_dateDebut, p_dateFin);
    Map mapTrieeParDate = new TreeMap(mapDeltasMontants);
    return mapTrieeParDate.values();
  }
  
  public static Collection comparerPBJCsPrimesEtAides(ChronologiePeriodes p_chronoPBJCsAvant, ChronologiePeriodes p_chronoPBJCsApres, Collection p_collectionPrimesAvant, Collection p_collectionPrimesApres, ChronologiePeriodes p_collectionAidesAvant, ChronologiePeriodes p_collectionAidesApres, Damj p_dateDebut, Damj p_dateFin)
  {
    Map deltaMontantsSurPBJCs = effectuerComparaisonPBJCs(p_chronoPBJCsAvant, p_chronoPBJCsApres, p_dateDebut, p_dateFin);
    Map deltaMontantsSurPrimes = effectuerComparaisonPrimes(p_collectionPrimesAvant, p_collectionPrimesApres, p_dateDebut, p_dateFin);
    Map deltaMontantsSurAides = effectuerComparaisonAides(p_collectionAidesAvant, p_collectionAidesApres, p_dateDebut, p_dateFin);
    Map deltaMontantsGlobaux = fusionnerMapsDeltasMontants(deltaMontantsSurPBJCs, deltaMontantsSurPrimes, deltaMontantsSurAides);
    Map mapTrieeParDate = new TreeMap(deltaMontantsGlobaux);
    return mapTrieeParDate.values();
  }
  
  private static Map effectuerComparaisonPBJCs(ChronologiePeriodes p_chronoPBJCsAvant, ChronologiePeriodes p_chronoPBJCsApres, Damj p_dateDebut, Damj p_dateFin)
  {
    Map deltasMontantsMensuels = new HashMap();
    PbjcNcp pbjc = null;
    if (p_chronoPBJCsAvant != null)
    {
      p_chronoPBJCsAvant.iterer();
      while (p_chronoPBJCsAvant.encoreSuivant())
      {
        pbjc = (PbjcNcp)p_chronoPBJCsAvant.elementSuivant();
        if ((pbjc.getDateDebutPbjc().estApresOuCoincideAvec(p_dateDebut)) && (pbjc.getDateFinPbjc().estAvantOuCoincideAvec(p_dateFin))) {
          analyserPbjc(deltasMontantsMensuels, pbjc, 0);
        } else if (new Periode(pbjc.getDateDebutPbjc(), pbjc.getDateFinPbjc()).chevauche(new Periode(p_dateDebut, p_dateFin))) {
          analyserPbjc(deltasMontantsMensuels, tronquerPbjc(pbjc, p_dateDebut, p_dateFin), 0);
        }
      }
    }
    if (p_chronoPBJCsApres != null)
    {
      p_chronoPBJCsApres.iterer();
      while (p_chronoPBJCsApres.encoreSuivant())
      {
        pbjc = (PbjcNcp)p_chronoPBJCsApres.elementSuivant();
        if ((pbjc.getDateDebutPbjc().estApresOuCoincideAvec(p_dateDebut)) && (pbjc.getDateFinPbjc().estAvantOuCoincideAvec(p_dateFin))) {
          analyserPbjc(deltasMontantsMensuels, pbjc, 1);
        }
      }
    }
    return deltasMontantsMensuels;
  }
  
  private static Map effectuerComparaisonPrimes(Collection p_collectionPrimesAvant, Collection p_collectionPrimesApres, Damj p_dateDebut, Damj p_dateFin)
  {
    Map deltasMontantMensuels = new HashMap();
    PrimePbjcNcp prime = null;
    
    Iterator iterateurPrimesAvant = p_collectionPrimesAvant.iterator();
    while (iterateurPrimesAvant.hasNext())
    {
      prime = (PrimePbjcNcp)iterateurPrimesAvant.next();
      if (prime.getDateEffet().estContenueDans(new Periode(p_dateDebut, p_dateFin))) {
        analyserPrime(deltasMontantMensuels, prime, 0);
      }
    }
    Iterator iterateurPrimesApres = p_collectionPrimesApres.iterator();
    while (iterateurPrimesApres.hasNext())
    {
      prime = (PrimePbjcNcp)iterateurPrimesApres.next();
      if (prime.getDateEffet().estContenueDans(new Periode(p_dateDebut, p_dateFin))) {
        analyserPrime(deltasMontantMensuels, prime, 1);
      }
    }
    return deltasMontantMensuels;
  }
  
  private static Map effectuerComparaisonAides(ChronologiePeriodes p_chronoAidesAvant, ChronologiePeriodes p_chronoAidesApres, Damj p_dateDebut, Damj p_dateFin)
  {
    Map deltasMontantMensuels = new HashMap();
    AideNcp aide = null;
    if (p_chronoAidesAvant != null)
    {
      p_chronoAidesAvant.iterer();
      while (p_chronoAidesAvant.encoreSuivant())
      {
        aide = (AideNcp)p_chronoAidesAvant.elementSuivant();
        if (aide.getDateDebutAide().estContenueDans(new Periode(p_dateDebut, p_dateFin))) {
          analyserAide(deltasMontantMensuels, aide, 0);
        }
      }
    }
    if (p_chronoAidesApres != null)
    {
      p_chronoAidesApres.iterer();
      while (p_chronoAidesApres.encoreSuivant())
      {
        aide = (AideNcp)p_chronoAidesApres.elementSuivant();
        if (aide.getDateDebutAide().estContenueDans(new Periode(p_dateDebut, p_dateFin))) {
          analyserAide(deltasMontantMensuels, aide, 1);
        }
      }
    }
    return deltasMontantMensuels;
  }
  
  private static void analyserPbjc(Map p_deltasMontantsMensuels, PbjcNcp p_pbjc, int p_topInsertion)
  {
    if (p_pbjc == null) {
      return;
    }
    Collection periodesCouvertesParPbjc = p_pbjc.decouperEnMoisCivils();
    Iterator iterateurSurPeriodes = periodesCouvertesParPbjc.iterator();
    while (iterateurSurPeriodes.hasNext())
    {
      Periode periodeCourante = (Periode)iterateurSurPeriodes.next();
      DeltaMontantMensuel deltaMontantMensuel = recupererDeltaMontant(p_deltasMontantsMensuels, periodeCourante.getDebut());
      calculerMontant(deltaMontantMensuel, tronquerPbjc(p_pbjc, periodeCourante.getDebut(), periodeCourante.getFin()), p_topInsertion);
    }
  }
  
  private static void analyserPrime(Map deltasMontantsMensuels, PrimePbjcNcp prime, int topInsertion)
  {
    if (prime == null) {
      return;
    }
    BigDecimal montantProduit = prime.getMontant();
    DeltaMontantMensuel deltaMontantMensuel = recupererDeltaMontant(deltasMontantsMensuels, prime.getDateEffet());
    mettreAJourDeltaProduitSurDeltaMontant(deltaMontantMensuel, prime.getCodeProduit(), 1, montantProduit, topInsertion);
    if (topInsertion == 0) {
      deltaMontantMensuel.setMontantIndemniseAvant(deltaMontantMensuel.getMontantIndemniseAvant().add(montantProduit));
    } else {
      deltaMontantMensuel.setMontantIndemniseApres(deltaMontantMensuel.getMontantIndemniseApres().add(montantProduit));
    }
  }
  
  private static void analyserAide(Map p_deltasMontantsMensuels, AideNcp p_aide, int p_topInsertion)
  {
    if (p_aide == null) {
      return;
    }
    DeltaMontantMensuel deltaMontantMensuel = recupererDeltaMontant(p_deltasMontantsMensuels, p_aide.getDateDebutAide());
    calculerMontantAide(deltaMontantMensuel, p_aide, p_topInsertion);
  }
  
  private static DeltaMontantMensuel recupererDeltaMontant(Map p_deltasMontantsMensuels, Damj p_dateEffet)
  {
    DeltaMontantMensuel deltaMontantMensuel = null;
    
    DecimalFormat df = new DecimalFormat("00");
    String cleDeltaMontant = String.valueOf(p_dateEffet.getAnnee()) + "-" + df.format(p_dateEffet.getMois());
    if (p_deltasMontantsMensuels.containsKey(cleDeltaMontant))
    {
      deltaMontantMensuel = (DeltaMontantMensuel)p_deltasMontantsMensuels.get(cleDeltaMontant);
    }
    else
    {
      deltaMontantMensuel = new DeltaMontantMensuel();
      deltaMontantMensuel.setMois(p_dateEffet.getMois());
      deltaMontantMensuel.setAnnee(p_dateEffet.getAnnee());
      p_deltasMontantsMensuels.put(cleDeltaMontant, deltaMontantMensuel);
    }
    return deltaMontantMensuel;
  }
  
  private static void calculerMontantAide(DeltaMontantMensuel p_deltaMontantMensuel, AideNcp p_aide, int p_topInsertion)
  {
    BigDecimal montantIndemnise = new BigDecimal("0");
    if ((p_aide.getCodeProduit() != null) && ((p_aide.getCodeProduit().equals("RBF_AGE08_01")) || (p_aide.getCodeProduit().equals("RBF_AIDES_01"))))
    {
      if (p_aide.getMontantTotalAide1() != null)
      {
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, p_aide.getCodeProduit(), p_aide.getNbAidesIndemniseesPeriode1(), p_aide.getMontantTotalAide1(), p_topInsertion);
        
        montantIndemnise = montantIndemnise.add(p_aide.getMontantTotalAide1());
      }
    }
    else
    {
      if (p_aide.getMontantTotalAide1() != null)
      {
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, p_aide.getCodeSousProduit1(), p_aide.getNbAidesIndemniseesPeriode1(), p_aide.getMontantTotalAide1(), p_topInsertion);
        
        montantIndemnise = montantIndemnise.add(p_aide.getMontantTotalAide1());
      }
      if (p_aide.getMontantTotalAide2() != null)
      {
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, p_aide.getCodeSousProduit2(), p_aide.getNbAidesIndemniseesPeriode2(), p_aide.getMontantTotalAide2(), p_topInsertion);
        
        montantIndemnise = montantIndemnise.add(p_aide.getMontantTotalAide2());
      }
      if (p_aide.getMontantTotalAide3() != null)
      {
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, p_aide.getCodeSousProduit3(), p_aide.getNbAidesIndemniseesPeriode3(), p_aide.getMontantTotalAide3(), p_topInsertion);
        
        montantIndemnise = montantIndemnise.add(p_aide.getMontantTotalAide3());
      }
      if (p_aide.getMontantTotalAide4() != null)
      {
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, p_aide.getCodeSousProduit4(), p_aide.getNbAidesIndemniseesPeriode4(), p_aide.getMontantTotalAide4(), p_topInsertion);
        
        montantIndemnise = montantIndemnise.add(p_aide.getMontantTotalAide4());
      }
    }
    if (p_topInsertion == 0) {
      p_deltaMontantMensuel.setMontantIndemniseAvant(p_deltaMontantMensuel.getMontantIndemniseAvant().add(montantIndemnise));
    } else {
      p_deltaMontantMensuel.setMontantIndemniseApres(p_deltaMontantMensuel.getMontantIndemniseApres().add(montantIndemnise));
    }
  }
  
  private static void calculerMontant(DeltaMontantMensuel p_deltaMontantMensuel, PbjcNcp p_pbjc, int p_topInsertion)
  {
    String naturePBJC = p_pbjc.getNaturePBJC() == null ? "" : p_pbjc.getNaturePBJC();
    String etatReglementaireOd = p_pbjc.getEtatReglementaireOd() == null ? "" : p_pbjc.getEtatReglementaireOd();
    
    BigDecimal montantProduitGroupeMontant = null;
    
    BigDecimal montantIndemnise = new BigDecimal("0");
    BigDecimal montantFinancement = new BigDecimal("0");
    BigDecimal montantCadt = new BigDecimal("0");
    BigDecimal montantCrc = new BigDecimal("0");
    if ((naturePBJC.equals("MA")) || (etatReglementaireOd.equals("3")) || (etatReglementaireOd.equals("9")))
    {
      if (GammeRbf.getInstance().getProduit(p_pbjc.getCodeTypeMontant1()) != null)
      {
        String codeProduitGroupeMontant = p_pbjc.getCodeTypeMontant1();
        int quantiteProduitGroupeMontant = p_pbjc.getDuree();
        montantProduitGroupeMontant = p_pbjc.getResultatCalcul1().multiply(BigDecimal.valueOf(quantiteProduitGroupeMontant));
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, codeProduitGroupeMontant, quantiteProduitGroupeMontant, montantProduitGroupeMontant, p_topInsertion);
        montantIndemnise = montantIndemnise.add(montantProduitGroupeMontant);
      }
      if (GammeRbf.getInstance().getProduit(p_pbjc.getCodeTypeMontant2()) != null)
      {
        String codeProduitGroupeMontant = p_pbjc.getCodeTypeMontant2();
        int quantiteProduitGroupeMontant = p_pbjc.getDuree();
        montantProduitGroupeMontant = p_pbjc.getResultatCalcul2().multiply(BigDecimal.valueOf(quantiteProduitGroupeMontant));
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, codeProduitGroupeMontant, quantiteProduitGroupeMontant, montantProduitGroupeMontant, p_topInsertion);
        montantIndemnise = montantIndemnise.add(montantProduitGroupeMontant);
      }
      if (GammeRbf.getInstance().getProduit(p_pbjc.getCodeTypeMontant3()) != null)
      {
        String codeProduitGroupeMontant = p_pbjc.getCodeTypeMontant3();
        int quantiteProduitGroupeMontant = p_pbjc.getDuree();
        montantProduitGroupeMontant = p_pbjc.getResultatCalcul3().multiply(BigDecimal.valueOf(quantiteProduitGroupeMontant));
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, codeProduitGroupeMontant, quantiteProduitGroupeMontant, montantProduitGroupeMontant, p_topInsertion);
        montantIndemnise = montantIndemnise.add(montantProduitGroupeMontant);
      }
      if (GammeRbf.getInstance().getProduit(p_pbjc.getCodeTypeMontant4()) != null)
      {
        String codeProduitGroupeMontant = p_pbjc.getCodeTypeMontant4();
        int quantiteProduitGroupeMontant = p_pbjc.getDuree();
        montantProduitGroupeMontant = p_pbjc.getResultatCalcul4().multiply(BigDecimal.valueOf(quantiteProduitGroupeMontant));
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, codeProduitGroupeMontant, quantiteProduitGroupeMontant, montantProduitGroupeMontant, p_topInsertion);
        montantIndemnise = montantIndemnise.add(montantProduitGroupeMontant);
      }
      if (GammeRbf.getInstance().getProduit(p_pbjc.getCodeTypeMontant5()) != null)
      {
        String codeProduitGroupeMontant = p_pbjc.getCodeTypeMontant5();
        int quantiteProduitGroupeMontant = p_pbjc.getDuree();
        montantProduitGroupeMontant = p_pbjc.getResultatCalcul5().multiply(BigDecimal.valueOf(quantiteProduitGroupeMontant));
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, codeProduitGroupeMontant, quantiteProduitGroupeMontant, montantProduitGroupeMontant, p_topInsertion);
        montantIndemnise = montantIndemnise.add(montantProduitGroupeMontant);
      }
      if (GammeRbf.getInstance().getProduit(p_pbjc.getCodeTypeMontant6()) != null)
      {
        String codeProduitGroupeMontant = p_pbjc.getCodeTypeMontant6();
        int quantiteProduitGroupeMontant = p_pbjc.getDuree();
        montantProduitGroupeMontant = p_pbjc.getResultatCalcul6().multiply(BigDecimal.valueOf(quantiteProduitGroupeMontant));
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, codeProduitGroupeMontant, quantiteProduitGroupeMontant, montantProduitGroupeMontant, p_topInsertion);
        montantIndemnise = montantIndemnise.add(montantProduitGroupeMontant);
      }
      if (GammeRbf.getInstance().getProduit(p_pbjc.getCodeTypeMontant7()) != null)
      {
        String codeProduitGroupeMontant = p_pbjc.getCodeTypeMontant7();
        int quantiteProduitGroupeMontant = p_pbjc.getDuree();
        montantProduitGroupeMontant = p_pbjc.getResultatCalcul7().multiply(BigDecimal.valueOf(quantiteProduitGroupeMontant));
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, codeProduitGroupeMontant, quantiteProduitGroupeMontant, montantProduitGroupeMontant, p_topInsertion);
        montantIndemnise = montantIndemnise.add(montantProduitGroupeMontant);
      }
    }
    else
    {
      if ((p_pbjc.getCodeTypeMontant1() != null) && (p_pbjc.getResultatCalcul1() != null))
      {
        String codeProduitGroupeMontant = p_pbjc.getCodeTypeMontant1();
        int quantiteProduitGroupeMontant = p_pbjc.getNbJoursImputes();
        montantProduitGroupeMontant = p_pbjc.getResultatCalcul1().multiply(BigDecimal.valueOf(quantiteProduitGroupeMontant));
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, codeProduitGroupeMontant, quantiteProduitGroupeMontant, montantProduitGroupeMontant, p_topInsertion);
        if (codeProduitGroupeMontant.equals("PCRC"))
        {
          montantIndemnise = montantIndemnise.subtract(montantProduitGroupeMontant);
          montantCrc = montantCrc.add(montantProduitGroupeMontant);
        }
        else if (codeProduitGroupeMontant.equals("CADT"))
        {
          montantCadt = montantCadt.add(montantProduitGroupeMontant);
        }
        else if (estDeTypeFinancement(p_pbjc.getProduit(), codeProduitGroupeMontant))
        {
          montantFinancement = montantFinancement.add(montantProduitGroupeMontant);
        }
        else
        {
          montantIndemnise = montantIndemnise.add(montantProduitGroupeMontant);
        }
      }
      if ((p_pbjc.getCodeTypeMontant2() != null) && (p_pbjc.getResultatCalcul2() != null))
      {
        String codeProduitGroupeMontant = p_pbjc.getCodeTypeMontant2();
        int quantiteProduitGroupeMontant = p_pbjc.getNbJoursImputes();
        montantProduitGroupeMontant = p_pbjc.getResultatCalcul2().multiply(BigDecimal.valueOf(quantiteProduitGroupeMontant));
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, codeProduitGroupeMontant, quantiteProduitGroupeMontant, montantProduitGroupeMontant, p_topInsertion);
        if (codeProduitGroupeMontant.equals("PCRC"))
        {
          montantIndemnise = montantIndemnise.subtract(montantProduitGroupeMontant);
          montantCrc = montantCrc.add(montantProduitGroupeMontant);
        }
        else if (codeProduitGroupeMontant.equals("CADT"))
        {
          montantCadt = montantCadt.add(montantProduitGroupeMontant);
        }
        else if (estDeTypeFinancement(p_pbjc.getProduit(), codeProduitGroupeMontant))
        {
          montantFinancement = montantFinancement.add(montantProduitGroupeMontant);
        }
        else
        {
          montantIndemnise = montantIndemnise.add(montantProduitGroupeMontant);
        }
      }
      if ((p_pbjc.getCodeTypeMontant3() != null) && (p_pbjc.getResultatCalcul3() != null))
      {
        String codeProduitGroupeMontant = p_pbjc.getCodeTypeMontant3();
        int quantiteProduitGroupeMontant = p_pbjc.getNbJoursImputes();
        montantProduitGroupeMontant = p_pbjc.getResultatCalcul3().multiply(BigDecimal.valueOf(quantiteProduitGroupeMontant));
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, codeProduitGroupeMontant, quantiteProduitGroupeMontant, montantProduitGroupeMontant, p_topInsertion);
        if (codeProduitGroupeMontant.equals("PCRC"))
        {
          montantIndemnise = montantIndemnise.subtract(montantProduitGroupeMontant);
          montantCrc = montantCrc.add(montantProduitGroupeMontant);
        }
        else if (codeProduitGroupeMontant.equals("CADT"))
        {
          montantCadt = montantCadt.add(montantProduitGroupeMontant);
        }
        else if (estDeTypeFinancement(p_pbjc.getProduit(), codeProduitGroupeMontant))
        {
          montantFinancement = montantFinancement.add(montantProduitGroupeMontant);
        }
        else
        {
          montantIndemnise = montantIndemnise.add(montantProduitGroupeMontant);
        }
      }
      if ((p_pbjc.getCodeTypeMontant4() != null) && (p_pbjc.getResultatCalcul4() != null))
      {
        String codeProduitGroupeMontant = p_pbjc.getCodeTypeMontant4();
        int quantiteProduitGroupeMontant = p_pbjc.getNbJoursImputes();
        montantProduitGroupeMontant = p_pbjc.getResultatCalcul4().multiply(BigDecimal.valueOf(quantiteProduitGroupeMontant));
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, codeProduitGroupeMontant, quantiteProduitGroupeMontant, montantProduitGroupeMontant, p_topInsertion);
        if (codeProduitGroupeMontant.equals("PCRC"))
        {
          montantIndemnise = montantIndemnise.subtract(montantProduitGroupeMontant);
          montantCrc = montantCrc.add(montantProduitGroupeMontant);
        }
        else if (codeProduitGroupeMontant.equals("CADT"))
        {
          montantCadt = montantCadt.add(montantProduitGroupeMontant);
        }
        else if (estDeTypeFinancement(p_pbjc.getProduit(), codeProduitGroupeMontant))
        {
          montantFinancement = montantFinancement.add(montantProduitGroupeMontant);
        }
        else
        {
          montantIndemnise = montantIndemnise.add(montantProduitGroupeMontant);
        }
      }
      if ((p_pbjc.getCodeTypeMontant5() != null) && (p_pbjc.getResultatCalcul5() != null))
      {
        String codeProduitGroupeMontant = p_pbjc.getCodeTypeMontant5();
        int quantiteProduitGroupeMontant = p_pbjc.getNbJoursImputes();
        montantProduitGroupeMontant = p_pbjc.getResultatCalcul5().multiply(BigDecimal.valueOf(quantiteProduitGroupeMontant));
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, codeProduitGroupeMontant, quantiteProduitGroupeMontant, montantProduitGroupeMontant, p_topInsertion);
        if (codeProduitGroupeMontant.equals("PCRC"))
        {
          montantIndemnise = montantIndemnise.subtract(montantProduitGroupeMontant);
          montantCrc = montantCrc.add(montantProduitGroupeMontant);
        }
        else if (codeProduitGroupeMontant.equals("CADT"))
        {
          montantCadt = montantCadt.add(montantProduitGroupeMontant);
        }
        else if (estDeTypeFinancement(p_pbjc.getProduit(), codeProduitGroupeMontant))
        {
          montantFinancement = montantFinancement.add(montantProduitGroupeMontant);
        }
        else
        {
          montantIndemnise = montantIndemnise.add(montantProduitGroupeMontant);
        }
      }
      if ((p_pbjc.getCodeTypeMontant6() != null) && (p_pbjc.getResultatCalcul6() != null))
      {
        String codeProduitGroupeMontant = p_pbjc.getCodeTypeMontant6();
        int quantiteProduitGroupeMontant = p_pbjc.getNbJoursImputes();
        montantProduitGroupeMontant = p_pbjc.getResultatCalcul6().multiply(BigDecimal.valueOf(quantiteProduitGroupeMontant));
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, codeProduitGroupeMontant, quantiteProduitGroupeMontant, montantProduitGroupeMontant, p_topInsertion);
        if (codeProduitGroupeMontant.equals("PCRC"))
        {
          montantIndemnise = montantIndemnise.subtract(montantProduitGroupeMontant);
          montantCrc = montantCrc.add(montantProduitGroupeMontant);
        }
        else if (codeProduitGroupeMontant.equals("CADT"))
        {
          montantCadt = montantCadt.add(montantProduitGroupeMontant);
        }
        else if (estDeTypeFinancement(p_pbjc.getProduit(), codeProduitGroupeMontant))
        {
          montantFinancement = montantFinancement.add(montantProduitGroupeMontant);
        }
        else
        {
          montantIndemnise = montantIndemnise.add(montantProduitGroupeMontant);
        }
      }
      if ((p_pbjc.getCodeTypeMontant7() != null) && (p_pbjc.getResultatCalcul7() != null))
      {
        String codeProduitGroupeMontant = p_pbjc.getCodeTypeMontant7();
        int quantiteProduitGroupeMontant = p_pbjc.getNbJoursImputes();
        montantProduitGroupeMontant = p_pbjc.getResultatCalcul7().multiply(BigDecimal.valueOf(quantiteProduitGroupeMontant));
        mettreAJourDeltaProduitSurDeltaMontant(p_deltaMontantMensuel, codeProduitGroupeMontant, quantiteProduitGroupeMontant, montantProduitGroupeMontant, p_topInsertion);
        if (codeProduitGroupeMontant.equals("PCRC"))
        {
          montantIndemnise = montantIndemnise.subtract(montantProduitGroupeMontant);
          montantCrc = montantCrc.add(montantProduitGroupeMontant);
        }
        else if (codeProduitGroupeMontant.equals("CADT"))
        {
          montantCadt = montantCadt.add(montantProduitGroupeMontant);
        }
        else if (estDeTypeFinancement(p_pbjc.getProduit(), codeProduitGroupeMontant))
        {
          montantFinancement = montantFinancement.add(montantProduitGroupeMontant);
        }
        else
        {
          montantIndemnise = montantIndemnise.add(montantProduitGroupeMontant);
        }
      }
    }
    if (p_topInsertion == 0)
    {
      p_deltaMontantMensuel.setMontantIndemniseAvant(p_deltaMontantMensuel.getMontantIndemniseAvant().add(montantIndemnise));
      
      p_deltaMontantMensuel.setDeltaMontantFinancement(p_deltaMontantMensuel.getDeltaMontantFinancement().subtract(montantFinancement));
      
      p_deltaMontantMensuel.setDeltaMontantCadt(p_deltaMontantMensuel.getDeltaMontantCadt().subtract(montantCadt));
      
      p_deltaMontantMensuel.setDeltaMontantCrc(p_deltaMontantMensuel.getDeltaMontantCrc().subtract(montantCrc));
    }
    else
    {
      p_deltaMontantMensuel.setMontantIndemniseApres(p_deltaMontantMensuel.getMontantIndemniseApres().add(montantIndemnise));
      
      p_deltaMontantMensuel.setDeltaMontantFinancement(p_deltaMontantMensuel.getDeltaMontantFinancement().add(montantFinancement));
      
      p_deltaMontantMensuel.setDeltaMontantCadt(p_deltaMontantMensuel.getDeltaMontantCadt().add(montantCadt));
      
      p_deltaMontantMensuel.setDeltaMontantCrc(p_deltaMontantMensuel.getDeltaMontantCrc().add(montantCrc));
    }
  }
  
  private static void mettreAJourDeltaProduitSurDeltaMontant(DeltaMontantMensuel p_deltaMontantMensuel, String p_codeProduit, int p_quantiteIndemniseeProduit, BigDecimal p_montantProduit, int p_topInsertion)
  {
    DeltaProduit deltaProduit = p_deltaMontantMensuel.getDeltaProduit(p_codeProduit);
    if (deltaProduit == null)
    {
      deltaProduit = new DeltaProduit();
      deltaProduit.setCodeProduit(p_codeProduit);
      p_deltaMontantMensuel.ajouterDeltaProduit(deltaProduit);
    }
    if (p_topInsertion == 0)
    {
      deltaProduit.setQuantiteIndemniseeAvant(deltaProduit.getQuantiteIndemniseeAvant() + p_quantiteIndemniseeProduit);
      deltaProduit.setMontantAvant(deltaProduit.getMontantAvant().add(p_montantProduit));
    }
    else
    {
      deltaProduit.setQuantiteIndemniseeApres(deltaProduit.getQuantiteIndemniseeApres() + p_quantiteIndemniseeProduit);
      deltaProduit.setMontantApres(deltaProduit.getMontantApres().add(p_montantProduit));
    }
  }
  
  private static boolean estDeTypeFinancement(String p_codeProduit, String p_codeProduitGroupeMontant)
  {
    if (("ASU_CVA10_02".equals(p_codeProduit)) && 
      (p_codeProduitGroupeMontant != null) && (p_codeProduitGroupeMontant.startsWith("ASU_")) && (!p_codeProduitGroupeMontant.equals("ASU_CVA10_02"))) {
      return true;
    }
    if (("ASU_CVE13_01".equals(p_codeProduit)) && 
      (p_codeProduitGroupeMontant != null) && (p_codeProduitGroupeMontant.startsWith("ASU_")) && (!p_codeProduitGroupeMontant.equals("ASU_CVE13_01"))) {
      return true;
    }
    return false;
  }
  
  private static PbjcNcp tronquerPbjc(PbjcNcp p_pbjc, Damj p_dateDebut, Damj p_dateFin)
  {
    PbjcNcp pbjc = (PbjcNcp)p_pbjc.copie();
    int nbJoursImputes = pbjc.getNbJoursImputes();
    if (pbjc.getDateDebutPbjc().estAvant(p_dateDebut))
    {
      int dureeTronquee = p_dateDebut.joursEntre(pbjc.getDateDebutPbjc());
      pbjc.setDateDebutPbjc(p_dateDebut);
      pbjc.setDateDebut(p_dateDebut);
      pbjc.setNbJoursImputes(nbJoursImputes - dureeTronquee);
    }
    nbJoursImputes = pbjc.getNbJoursImputes();
    if (pbjc.getDateFinPbjc().estApres(p_dateFin))
    {
      int dureeTronquee = pbjc.getDateFinPbjc().joursEntre(p_dateFin);
      pbjc.setDateFinPbjc(p_dateFin);
      pbjc.setDateFin(p_dateFin);
      pbjc.setNbJoursImputes(nbJoursImputes - dureeTronquee);
    }
    return pbjc;
  }
  
  private static Map fusionnerMapsDeltasMontants(Map p_mapPremiere, Map p_mapSeconde, Map p_mapAides)
  {
    Map<Object, Object> mapFinale = new HashMap();
    if (p_mapPremiere != null)
    {
      mapFinale.putAll(p_mapPremiere);
      if (p_mapSeconde != null) {
        fusionneMap(mapFinale, p_mapSeconde);
      }
      if (p_mapAides != null) {
        fusionneMap(mapFinale, p_mapAides);
      }
    }
    else if (p_mapSeconde != null)
    {
      mapFinale.putAll(p_mapSeconde);
      if (p_mapAides != null) {
        fusionneMap(mapFinale, p_mapAides);
      }
    }
    else if (p_mapAides != null)
    {
      mapFinale.putAll(p_mapAides);
    }
    return mapFinale;
  }
  
  private static void fusionneMap(Map<Object, Object> p_mapFinal, Map p_mapATraiter)
  {
    Iterator iterateurSurCles = p_mapATraiter.keySet().iterator();
    while (iterateurSurCles.hasNext())
    {
      Object cle = iterateurSurCles.next();
      DeltaMontantMensuel deltaMontantAAjouter = (DeltaMontantMensuel)p_mapATraiter.get(cle);
      if (p_mapFinal.containsKey(cle))
      {
        DeltaMontantMensuel deltaMontantFinal = (DeltaMontantMensuel)p_mapFinal.get(cle);
        deltaMontantFinal.setMontantIndemniseAvant(deltaMontantFinal.getMontantIndemniseAvant().add(deltaMontantAAjouter.getMontantIndemniseAvant()));
        
        deltaMontantFinal.setMontantIndemniseApres(deltaMontantFinal.getMontantIndemniseApres().add(deltaMontantAAjouter.getMontantIndemniseApres()));
        
        deltaMontantFinal.setDeltaMontantFinancement(deltaMontantFinal.getDeltaMontantFinancement().add(deltaMontantAAjouter.getDeltaMontantFinancement()));
        
        deltaMontantFinal.setDeltaMontantCadt(deltaMontantFinal.getDeltaMontantCadt().add(deltaMontantAAjouter.getDeltaMontantCadt()));
        
        deltaMontantFinal.setDeltaMontantCrc(deltaMontantFinal.getDeltaMontantCrc().add(deltaMontantAAjouter.getDeltaMontantCrc()));
        
        Iterator iterateurDeltaProduitsAAjouter = deltaMontantAAjouter.getDeltasProduits().iterator();
        while (iterateurDeltaProduitsAAjouter.hasNext())
        {
          DeltaProduit deltaProduitAAjouter = (DeltaProduit)iterateurDeltaProduitsAAjouter.next();
          DeltaProduit deltaProduitFinal = deltaMontantFinal.getDeltaProduit(deltaProduitAAjouter.getCodeProduit());
          if (deltaProduitFinal != null)
          {
            deltaProduitFinal.setQuantiteIndemniseeAvant(deltaProduitAAjouter.getQuantiteIndemniseeAvant());
            deltaProduitFinal.setQuantiteIndemniseeApres(deltaProduitAAjouter.getQuantiteIndemniseeApres());
            deltaProduitFinal.setMontantAvant(deltaProduitAAjouter.getMontantAvant());
            deltaProduitFinal.setMontantApres(deltaProduitAAjouter.getMontantApres());
          }
          else
          {
            deltaMontantFinal.ajouterDeltaProduit(deltaProduitAAjouter);
          }
        }
      }
      else
      {
        p_mapFinal.put(cle, deltaMontantAAjouter);
      }
    }
  }
}

/* Location:
 * Qualified Name:     ComparateurMontants
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */