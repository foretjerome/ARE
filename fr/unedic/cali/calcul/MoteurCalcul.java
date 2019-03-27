package fr.unedic.cali.calcul;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeArretCalcul;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionPersistance;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionSanctions;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.ContexteUT;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitRbfSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class MoteurCalcul
{
  public static Map executerCalcul(Damj dateDebutExecution, Damj dateArretExecution, List listeAttributions, boolean executionDepuisPersistance, boolean executionVersPersistance)
    throws ApplicativeException
  {
    Map mapFacadesCalculProduit = null;
    ChronologiePeriodes chronologiePeriodesGAEC = null;
    ChronologiePeriodes chronologiePeriodesPEC = null;
    ChronologiePeriodes chronologiePeriodesPECSansFiltre = null;
    ChronologiePeriodes chronologiePeriodesProduits = null;
    ChronologiePeriodes chronologiePeriodesEvtActualisation = null;
    ChronologiePeriodes chronologiePeriodesSanctions = null;
    ChronologiePeriodes chronologiePensionsInvaliditeEtAvantagesVieillesse = null;
    Collection decisionsSuivi = null;
    Map mapCalendriers = null;
    Periode periodeUT = null;
    Damj dateDebutUT = null;
    Damj dateFinUT = null;
    IndividuSpec individu = null;
    ContexteUT contexteUT = null;
    
    individu = ((AttributionSpec)listeAttributions.get(0)).getDemandeur();
    
    List listeAttrib = filtrerListeAttributionsAides(listeAttributions);
    
    mapFacadesCalculProduit = creerFacadesCalculProduit(listeAttrib);
    
    dateDebutUT = dateDebutExecution.getDebutMois();
    dateFinUT = dateDebutExecution.getFinMois();
    
    mapCalendriers = GestionPersistance.creerCalendriers(listeAttrib, mapFacadesCalculProduit, executionDepuisPersistance, executionVersPersistance, dateDebutUT);
    if (encoreUneAttributionVivante(mapCalendriers))
    {
      contexteUT = new ContexteUT(mapCalendriers, listeAttrib);
      if ((dateArretExecution != null) && (dateDebutUT.estApres(dateArretExecution))) {
        throw new CoucheLogiqueException("HG_PR_CALI_L_CALCUL_ARRET_MOTEUR_AVANT_PREMIER_PJI", "HG_PR_CALI_L_CALCUL_ARRET_MOTEUR_AVANT_PREMIER_PJI", null);
      }
      chronologiePeriodesGAEC = OutillagePeriodes.recupererPeriodesGAEC(individu, dateDebutUT, null);
      chronologiePeriodesPEC = OutillagePeriodes.recupererRadiations(individu);
      
      chronologiePeriodesPECSansFiltre = OutillagePeriodes.recupererPecsSansFiltre(individu);
      
      chronologiePeriodesEvtActualisation = OutillagePeriodes.recupererPeriodesEvtActualisation(individu);
      
      chronologiePeriodesProduits = TraitementPeriodes.recupererPeriodesProduits(listeAttrib, mapFacadesCalculProduit);
      
      decisionsSuivi = OutillagePeriodes.recupererDecisionsSuivi(individu);
      
      chronologiePeriodesSanctions = GestionSanctions.recupererSanctions(decisionsSuivi);
      
      chronologiePensionsInvaliditeEtAvantagesVieillesse = OutillagePeriodes.recupererPensionsInvaliditeEtAvantagesVieillesseSansModifierBornes(individu);
      
      ChronologiePeriodes chronologiePensionsInvaliditesChainees = OutillagePeriodes.recupererPensionsInvaliditeChainees(individu);
      
      chronologiePensionsInvaliditeEtAvantagesVieillesse.ajouter(chronologiePensionsInvaliditesChainees);
      if (dateArretExecution != null) {
        chronologiePeriodesProduits.ajouter(new ObjetChronoPeriodeArretCalcul(dateArretExecution));
      }
      controlePjiAttributions(listeAttrib, dateDebutUT, mapFacadesCalculProduit);
      while (encoreUneAttributionVivante(mapCalendriers))
      {
        periodeUT = new Periode(dateDebutUT, dateFinUT);
        dateDebutUT = dateFinUT.getDebutMoisSuivant();
        dateFinUT = dateDebutUT.getFinMois();
        if (Log.isTraceActive(MoteurCalcul.class, Niveau.DEBUG)) {
          Log.ecritTrace(Niveau.DEBUG, MoteurCalcul.class, "executerCalcul", "Calcul: UT [" + periodeUT.getDebut() + " - " + periodeUT.getFin() + "]");
        }
        TraitementUT.executerUT(periodeUT, mapFacadesCalculProduit, mapCalendriers, chronologiePeriodesGAEC, chronologiePeriodesPEC, chronologiePeriodesPECSansFiltre, chronologiePeriodesProduits, chronologiePeriodesEvtActualisation, chronologiePeriodesSanctions, chronologiePensionsInvaliditeEtAvantagesVieillesse, contexteUT);
      }
    }
    return mapCalendriers;
  }
  
  private static Map creerFacadesCalculProduit(List listeAttributions)
    throws CoucheLogiqueException
  {
    Map mapFacadesCalculProduit = null;
    Iterator iterateur = null;
    AttributionSpec attribution = null;
    FacadeCalculProduitSpec facadeCalculProduit = null;
    
    mapFacadesCalculProduit = new HashMap();
    
    iterateur = listeAttributions.iterator();
    while (iterateur.hasNext())
    {
      attribution = (AttributionSpec)iterateur.next();
      try
      {
        facadeCalculProduit = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(attribution.getProduitExecution());
      }
      catch (CoucheLogiqueException e)
      {
        facadeCalculProduit = null;
        iterateur.remove();
      }
      if (facadeCalculProduit != null) {
        mapFacadesCalculProduit.put(attribution, facadeCalculProduit);
      }
    }
    return mapFacadesCalculProduit;
  }
  
  private static boolean encoreUneAttributionVivante(Map mapCalendriers)
  {
    Iterator iterateur = null;
    CalendrierExecutionCalculSpec calendrierExecutionCalcul = null;
    boolean encoreUneAttributionVivante = false;
    
    iterateur = mapCalendriers.values().iterator();
    while ((iterateur.hasNext()) && (!encoreUneAttributionVivante))
    {
      calendrierExecutionCalcul = (CalendrierExecutionCalculSpec)iterateur.next();
      if ((calendrierExecutionCalcul.getEtatAttribution() != 3) && (calendrierExecutionCalcul.getEtatAttribution() != 4) && (calendrierExecutionCalcul.getEtatAttribution() != 5) && (calendrierExecutionCalcul.getEtatAttribution() != 6)) {
        encoreUneAttributionVivante = true;
      }
    }
    return encoreUneAttributionVivante;
  }
  
  private static void controlePjiAttributions(List listeAttributions, Damj dateDebut, Map mapFacadesCalculProduit)
    throws CoucheLogiqueException
  {
    Iterator iterateur = null;
    AttributionSpec attribution = null;
    iterateur = listeAttributions.iterator();
    while (iterateur.hasNext())
    {
      attribution = (AttributionSpec)iterateur.next();
      if ((attribution.getCalendrierExecutionCalcul() == null) || (attribution.getCalendrierExecutionCalcul().getEtatAttribution() == 1)) {
        ((FacadeCalculProduitSpec)mapFacadesCalculProduit.get(attribution)).controlerPjiAttribution(attribution, dateDebut);
      }
    }
  }
  
  private static List filtrerListeAttributionsAides(List listeAttributions)
  {
    List listeAttrib = new ArrayList();
    Iterator it = listeAttributions.iterator();
    while (it.hasNext())
    {
      AttributionSpec attributionSpec = (AttributionSpec)it.next();
      if (attributionSpec.getProduit().getNom().equals("RBF_MOB07_01"))
      {
        ProduitRbfSpec produit = (ProduitRbfSpec)attributionSpec.getProduit();
        listeAttrib.addAll(produit.recupererListeAttributionsExecutables(attributionSpec));
      }
      else
      {
        listeAttrib.add(attributionSpec);
      }
    }
    return listeAttrib;
  }
}

/* Location:
 * Qualified Name:     MoteurCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */