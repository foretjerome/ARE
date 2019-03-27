package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.EcartBasePivotEchange;
import fr.unedic.cali.autresdoms.d90.dom.spec.ElementBasePivotEchangeComparableSpec;
import fr.unedic.cali.calcul.pbjc.dom.AideNcp;
import fr.unedic.cali.calcul.pbjc.dom.DispositifNcp;
import fr.unedic.cali.calcul.pbjc.dom.DroitPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.EnquetePbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PrimePbjcNcp;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class OutilComparaisonBaseEchange
{
  public static ChronologiePeriodes getPbjcsApresDate(Damj p_date, IndividuSpec p_individu)
  {
    ChronologiePeriodes chronoPbjcs = null;
    chronoPbjcs = p_individu.getChronoPbjcs();
    return copierPBJCs(chronoPbjcs, p_date);
  }
  
  public static Collection getPrimesApresDate(Damj p_date, IndividuSpec p_individu)
  {
    Collection collectionPrimes = p_individu.getCollectionPrimes();
    return copierPrimes(collectionPrimes, p_date);
  }
  
  public static ChronologiePeriodes getAidesApresDate(Damj p_date, IndividuSpec p_individu)
  {
    ChronologiePeriodes chronoAides = p_individu.getChronoAides();
    return copierAides(chronoAides, p_date);
  }
  
  public static Collection getListeEnquetes(IndividuSpec p_individu)
  {
    Collection collectionEnquetes = p_individu.getListEnquetesPbjcNcp();
    return copierEnquete(collectionEnquetes);
  }
  
  public static Collection getListeDroits(IndividuSpec p_individu)
  {
    Collection collectionDroits = p_individu.getListDroitsPbjcsNcp();
    return copierDroits(collectionDroits);
  }
  
  public static IndividuPbjcNcp getIndividu(IndividuSpec p_individu)
  {
    IndividuPbjcNcp individu = p_individu.getIndividuPbjcNcp();
    return individu != null ? (IndividuPbjcNcp)individu.copie() : null;
  }
  
  public static Collection<DispositifNcp> getListeDispositif(IndividuSpec individu)
  {
    Collection<DispositifNcp> collectionDispositif = individu.getCollectionDispositifNcp();
    return copierDispositif(collectionDispositif);
  }
  
  public static Collection comparerElements(Collection p_collectionAvantReexecution, Collection p_collectionApresReexecution)
    throws ApplicativeException
  {
    Collection listeEcartsBases = new ArrayList();
    Iterator iterElementAvant = p_collectionAvantReexecution.iterator();
    Iterator iterElementApres = null;
    ElementBasePivotEchangeComparableSpec elementAvant = null;
    ElementBasePivotEchangeComparableSpec elementApres = null;
    while (iterElementAvant.hasNext())
    {
      elementAvant = (ElementBasePivotEchangeComparableSpec)iterElementAvant.next();
      elementApres = null;
      iterElementApres = p_collectionApresReexecution.iterator();
      boolean correspondanceTrouvee = false;
      while ((!correspondanceTrouvee) && (iterElementApres.hasNext()))
      {
        elementApres = (ElementBasePivotEchangeComparableSpec)iterElementApres.next();
        correspondanceTrouvee = elementAvant.estComparableAvec(elementApres);
      }
      if (correspondanceTrouvee)
      {
        listeEcartsBases.addAll(elementAvant.comparer(elementApres));
        p_collectionApresReexecution.remove(elementApres);
      }
      else
      {
        Map parametresEcartBase = elementAvant.recupererParametresEcartsBases();
        EcartBasePivotEchange ecartBase = new EcartBasePivotEchange(parametresEcartBase, "MANQUANT");
        listeEcartsBases.add(ecartBase);
      }
    }
    iterElementApres = p_collectionApresReexecution.iterator();
    while (iterElementApres.hasNext())
    {
      elementApres = (ElementBasePivotEchangeComparableSpec)iterElementApres.next();
      Map parametresEcartBase = elementApres.recupererParametresEcartsBases();
      EcartBasePivotEchange ecartBase = new EcartBasePivotEchange(parametresEcartBase, "NOUVEAU");
      listeEcartsBases.add(ecartBase);
    }
    return listeEcartsBases;
  }
  
  private static ChronologiePeriodes copierPBJCs(ChronologiePeriodes p_chronoPBJCs, Damj p_date)
  {
    ChronologiePeriodes collectionElements = new ChronologiePeriodes();
    Collection<ObjetMetierSpec> collectionElementsPbjc = new ArrayList();
    PbjcNcp pbjc = null;
    p_chronoPBJCs.iterer();
    while (p_chronoPBJCs.encoreSuivant())
    {
      pbjc = (PbjcNcp)p_chronoPBJCs.elementSuivant();
      if (pbjc.getDateDebutPbjc().estApresOuCoincideAvec(p_date)) {
        collectionElementsPbjc.add(pbjc.copie());
      }
    }
    collectionElements.ajouter(collectionElementsPbjc);
    return collectionElements;
  }
  
  private static ChronologiePeriodes copierAides(ChronologiePeriodes p_chronoAides, Damj p_date)
  {
    ChronologiePeriodes collectionElements = new ChronologiePeriodes();
    Collection<ObjetMetierSpec> collectionElementsPbjc = new ArrayList();
    AideNcp aide = null;
    p_chronoAides.iterer();
    while (p_chronoAides.encoreSuivant())
    {
      aide = (AideNcp)p_chronoAides.elementSuivant();
      if (aide.getDateVersementAide().estApresOuCoincideAvec(p_date)) {
        collectionElementsPbjc.add(aide.copie());
      }
    }
    collectionElements.ajouter(collectionElementsPbjc);
    return collectionElements;
  }
  
  private static Collection copierPrimes(Collection p_objetsACopier, Damj p_date)
  {
    Collection<ObjetMetierSpec> collectionElements = new ArrayList();
    Iterator iterElements = p_objetsACopier.iterator();
    while (iterElements.hasNext())
    {
      PrimePbjcNcp droit = (PrimePbjcNcp)iterElements.next();
      if (droit.getDateEffet().estApresOuCoincideAvec(p_date)) {
        collectionElements.add(droit.copie());
      }
    }
    return collectionElements;
  }
  
  private static Collection copierDroits(Collection p_objetsACopier)
  {
    Collection<ObjetMetierSpec> collectionElements = new ArrayList();
    Iterator iterElements = p_objetsACopier.iterator();
    while (iterElements.hasNext())
    {
      DroitPbjcNcp droit = (DroitPbjcNcp)iterElements.next();
      collectionElements.add(droit.copie());
    }
    return collectionElements;
  }
  
  private static Collection copierEnquete(Collection p_objetsACopier)
  {
    Collection<ObjetMetierSpec> collectionElements = new ArrayList();
    Iterator iterElements = p_objetsACopier.iterator();
    while (iterElements.hasNext())
    {
      EnquetePbjcNcp droit = (EnquetePbjcNcp)iterElements.next();
      collectionElements.add(droit.copie());
    }
    return collectionElements;
  }
  
  private static Collection copierDispositif(Collection objetsACopier)
  {
    Collection<ObjetMetierSpec> collectionElements = new ArrayList();
    Iterator iterElements = objetsACopier.iterator();
    while (iterElements.hasNext())
    {
      DispositifNcp dispositif = (DispositifNcp)iterElements.next();
      collectionElements.add(dispositif.copie());
    }
    return collectionElements;
  }
}

/* Location:
 * Qualified Name:     OutilComparaisonBaseEchange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */