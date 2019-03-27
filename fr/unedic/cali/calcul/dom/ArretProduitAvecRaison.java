package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.dom.QuantiteIndemnisationSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.ObjetChronoPeriodeSpec;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArretProduitAvecRaison
  implements ObjetMetierSpec
{
  private static final long serialVersionUID = 1L;
  public static final int RAISON_PRODUIT_NON_ARRETE = 0;
  public static final int RAISON_EPUISEMENT_QUANTITE_INDEMNISATION = 1;
  public static final int RAISON_EPUISEMENT_QUANTITE_DROIT_NORMALE = 2;
  public static final int RAISON_PERIODE_INTERRUPTIVE_DEFINITIVE = 4;
  private int raison = 0;
  private Collection periodesInterruptivesDefinitives = null;
  private Collection lendemainFinQuantiteIndemnisationArretCalcul = null;
  private Collection lendemainFinQuantiteDroitNormaleArretCalcul = null;
  private boolean produitAEteindre = false;
  
  public ArretProduitAvecRaison()
  {
    periodesInterruptivesDefinitives = new ArrayList();
    lendemainFinQuantiteIndemnisationArretCalcul = new ArrayList();
    lendemainFinQuantiteDroitNormaleArretCalcul = new ArrayList();
  }
  
  public boolean isProduitAArreter()
  {
    return raison != 0;
  }
  
  public Damj recupereLendemainDateArret()
  {
    Damj retour = null;
    if (getLendemainFinQuantiteIndemnisationArretCalcul().size() != 0) {
      retour = ((Temporel)getLendemainFinQuantiteIndemnisationArretCalcul().iterator().next()).getDateDebut();
    } else if (getLendemainFinQuantiteDroitNormaleArretCalcul().size() != 0) {
      retour = ((Temporel)getLendemainFinQuantiteDroitNormaleArretCalcul().iterator().next()).getDateDebut();
    } else if (getPeriodesInterruptivesDefinitives().size() != 0) {
      retour = ((Temporel)getPeriodesInterruptivesDefinitives().iterator().next()).getDateDebut();
    }
    return retour;
  }
  
  private void verifieCoherence(Damj date, Collection collection)
  {
    Iterator iterateur = null;
    Temporel temporel = null;
    
    iterateur = collection.iterator();
    while (iterateur.hasNext())
    {
      temporel = (Temporel)iterateur.next();
      if (date.estAvant(temporel.getDateDebut())) {
        iterateur.remove();
      }
    }
  }
  
  private void verifieRaison()
  {
    if ((isRaisonsContientRaison(1)) && (lendemainFinQuantiteIndemnisationArretCalcul.size() == 0)) {
      raison -= 1;
    }
    if ((isRaisonsContientRaison(2)) && (lendemainFinQuantiteDroitNormaleArretCalcul.size() == 0)) {
      raison -= 2;
    }
    if ((isRaisonsContientRaison(4)) && (periodesInterruptivesDefinitives.size() == 0)) {
      raison -= 4;
    }
  }
  
  public void ajoutePeriodeInterruptiveDefinitive(ObjetChronoPeriode periodeInterruptiveDefinitive)
  {
    raison |= 0x4;
    
    periodesInterruptivesDefinitives.add(periodeInterruptiveDefinitive);
    
    verifieCoherence(periodeInterruptiveDefinitive.getDateDebut(), periodesInterruptivesDefinitives);
    verifieCoherence(periodeInterruptiveDefinitive.getDateDebut(), lendemainFinQuantiteIndemnisationArretCalcul);
    verifieCoherence(periodeInterruptiveDefinitive.getDateDebut(), lendemainFinQuantiteDroitNormaleArretCalcul);
    if (raison == 4) {
      verifieRaison();
    }
  }
  
  public void ajouteLendemainFinQuantiteDroitArretCalcul(EvenementLendemainFinQuantiteDroit finQuantiteDroitArretCalcul)
  {
    if ((finQuantiteDroitArretCalcul.getQuantiteDroit() instanceof QuantiteIndemnisationSpec)) {
      ajouteLendemainFinQuantiteIndemnisationArretCalcul(finQuantiteDroitArretCalcul);
    } else {
      ajouteLendemainFinQuantiteDroitNormaleArretCalcul(finQuantiteDroitArretCalcul);
    }
    verifieCoherence(finQuantiteDroitArretCalcul.getDateDebut(), periodesInterruptivesDefinitives);
    verifieCoherence(finQuantiteDroitArretCalcul.getDateDebut(), lendemainFinQuantiteIndemnisationArretCalcul);
    verifieCoherence(finQuantiteDroitArretCalcul.getDateDebut(), lendemainFinQuantiteDroitNormaleArretCalcul);
    
    verifieRaison();
  }
  
  private void ajouteLendemainFinQuantiteIndemnisationArretCalcul(EvenementLendemainFinQuantiteDroit finQuantiteDroitArretCalcul)
  {
    raison |= 0x1;
    lendemainFinQuantiteIndemnisationArretCalcul.add(finQuantiteDroitArretCalcul);
  }
  
  private void ajouteLendemainFinQuantiteDroitNormaleArretCalcul(EvenementLendemainFinQuantiteDroit finQuantiteDroitArretCalcul)
  {
    raison |= 0x2;
    lendemainFinQuantiteDroitNormaleArretCalcul.add(finQuantiteDroitArretCalcul);
  }
  
  public int getRaisons()
  {
    return raison;
  }
  
  public boolean isRaisonsContientRaison(int raison)
  {
    return (this.raison & raison) == raison;
  }
  
  public Collection recupereTemporelRaisonAuLendemainArret()
  {
    Collection retour = new ArrayList();
    
    retour.addAll(periodesInterruptivesDefinitives);
    retour.addAll(lendemainFinQuantiteIndemnisationArretCalcul);
    retour.addAll(lendemainFinQuantiteDroitNormaleArretCalcul);
    
    return retour;
  }
  
  public Collection getPeriodesInterruptivesDefinitives()
  {
    return periodesInterruptivesDefinitives;
  }
  
  public Collection getLendemainFinQuantiteIndemnisationArretCalcul()
  {
    return lendemainFinQuantiteIndemnisationArretCalcul;
  }
  
  public Collection getLendemainFinQuantiteDroitNormaleArretCalcul()
  {
    return lendemainFinQuantiteDroitNormaleArretCalcul;
  }
  
  public ObjetMetierSpec copie()
  {
    ArretProduitAvecRaison copie = new ArretProduitAvecRaison();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    ArretProduitAvecRaison copie = (ArretProduitAvecRaison)pcopie;
    
    raison = getRaisons();
    produitAEteindre = isProduitAEteindre();
    
    Iterator iterator = getPeriodesInterruptivesDefinitives().iterator();
    periodesInterruptivesDefinitives = new ArrayList();
    while (iterator.hasNext())
    {
      ObjetMetierSpec element = (ObjetMetierSpec)iterator.next();
      if (element != null) {
        periodesInterruptivesDefinitives.add(element.copie());
      }
    }
    iterator = getLendemainFinQuantiteIndemnisationArretCalcul().iterator();
    lendemainFinQuantiteIndemnisationArretCalcul = new ArrayList();
    while (iterator.hasNext())
    {
      ObjetMetierSpec element = (ObjetMetierSpec)iterator.next();
      if (element != null) {
        lendemainFinQuantiteIndemnisationArretCalcul.add(element.copie());
      }
    }
    iterator = getLendemainFinQuantiteDroitNormaleArretCalcul().iterator();
    lendemainFinQuantiteDroitNormaleArretCalcul = new ArrayList();
    while (iterator.hasNext())
    {
      ObjetMetierSpec element = (ObjetMetierSpec)iterator.next();
      if (element != null) {
        lendemainFinQuantiteDroitNormaleArretCalcul.add(element.copie());
      }
    }
  }
  
  public boolean isProduitAEteindre()
  {
    return produitAEteindre;
  }
  
  public void setProduitAEteindre(boolean produitAEteindre)
  {
    this.produitAEteindre = produitAEteindre;
  }
  
  public boolean contientTypePeriodeInterruptive(Class classe)
  {
    Iterator it = periodesInterruptivesDefinitives.iterator();
    while (it.hasNext())
    {
      ObjetChronoPeriodeSpec periode = (ObjetChronoPeriodeSpec)it.next();
      if (periode.estType(classe)) {
        return true;
      }
    }
    return false;
  }
  
  public Damj recupererLendemainDateArretIndemnisation()
  {
    Damj retour = null;
    if (getLendemainFinQuantiteIndemnisationArretCalcul().size() != 0) {
      retour = ((Temporel)getLendemainFinQuantiteIndemnisationArretCalcul().iterator().next()).getDateDebut();
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     ArretProduitAvecRaison
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */