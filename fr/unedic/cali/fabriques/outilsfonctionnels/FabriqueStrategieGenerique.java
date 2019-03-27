package fr.unedic.cali.fabriques.outilsfonctionnels;

import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.fabriques.outilsfonctionnels.spec.ElementStrategieSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class FabriqueStrategieGenerique
{
  private Collection<ElementStrategieSpec> listeElementStrategie;
  
  private FabriqueStrategieGenerique()
  {
    listeElementStrategie = new ArrayList();
  }
  
  public static FabriqueStrategieGenerique getInstance()
  {
    return new FabriqueStrategieGenerique();
  }
  
  public StrategieSpec getStrategie(Damj dateAppel)
    throws CoucheLogiqueException
  {
    StrategieSpec strategieARetourner = null;
    
    verifierDateAppel(dateAppel);
    if (listeElementStrategie != null)
    {
      Iterator<ElementStrategieSpec> it = listeElementStrategie.iterator();
      while ((it.hasNext()) && (strategieARetourner == null))
      {
        ElementStrategieSpec elementStrategie = (ElementStrategieSpec)it.next();
        if (elementStrategie.estEligible(dateAppel)) {
          strategieARetourner = elementStrategie.recupererStrategie(dateAppel);
        }
      }
    }
    if (strategieARetourner == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("ERR_FABRIQUE_GENERIQUE_AUCUNE_STRATEGIE");
    }
    OutilTrace.ecrireTrace(Niveau.DEBUG, new Object[] { "UTILISATION STRATEGIE <=> date appel : " + dateAppel + " classe : " + strategieARetourner.getClass().getName() });
    
    return strategieARetourner;
  }
  
  public static StrategieSpec choisirStrategie(Damj dateAppel, String dateApplication, StrategieSpec strategieAvant, StrategieSpec strategieApres)
    throws CoucheLogiqueException
  {
    FabriqueStrategieGenerique fabrique = getInstance();
    fabrique.inscrireStrategieDate(dateApplication, strategieAvant, strategieApres);
    return fabrique.getStrategie(dateAppel);
  }
  
  private void inscrireStrategieDate(String dateApplication, StrategieSpec strategieAvant, StrategieSpec strategieApres)
  {
    listeElementStrategie = new ArrayList();
    ElementStrategieDate elementStrategie = new ElementStrategieDate(dateApplication, strategieAvant, strategieApres);
    listeElementStrategie.add(elementStrategie);
  }
  
  public void inscrireStrategiePeriode(String dateDebutApplication, String dateFinApplication, StrategieSpec strategie)
    throws CoucheLogiqueException
  {
    ElementStrategiePeriode elementStrategie = new ElementStrategiePeriode(dateDebutApplication, dateFinApplication, strategie);
    verifierCoherencePeriode(elementStrategie);
    listeElementStrategie.add(elementStrategie);
  }
  
  private void verifierDateAppel(Damj dateAppel)
    throws CoucheLogiqueException
  {
    if (dateAppel == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("ERR_FABRIQUE_GENERIQUE_DATE_APPEL_NULLE");
    }
  }
  
  private void verifierCoherencePeriode(ElementStrategiePeriode nouveauElement)
    throws CoucheLogiqueException
  {
    Iterator<ElementStrategieSpec> it = listeElementStrategie.iterator();
    while (it.hasNext())
    {
      ElementStrategieSpec elementCourant = (ElementStrategieSpec)it.next();
      if (((elementCourant instanceof ElementStrategiePeriode)) && (((ElementStrategiePeriode)elementCourant).estChevauchantAutrePeriode(nouveauElement))) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("ERR_FABRIQUE_GENERIQUE_ERREUR_INSCRIPTION");
      }
    }
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieGenerique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */