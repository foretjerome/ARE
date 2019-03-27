package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.DeclareTravail;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeDeclare;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.periode.DsmTravail;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.fabriques.FabriqueStrategieDetectionDNJ;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDetectionDNJSpec;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreChevauchePeriode;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GestionDNJ
{
  public static void determineEtatPeriodesDSM(IndividuSpec p_individu, ChronologiePeriodes p_chronologiePeriodeDSM)
  {
    if ((p_chronologiePeriodeDSM != null) && (!p_chronologiePeriodeDSM.estVide()))
    {
      List listeAttribution = p_individu.getListeAttributionsExecutablesAvant(p_chronologiePeriodeDSM.dernierElement().getDateFin());
      
      initialiserJustificationDSM(p_chronologiePeriodeDSM);
      if ((listeAttribution != null) && (!listeAttribution.isEmpty()))
      {
        AttributionSpec attribution = null;
        
        Iterator it = listeAttribution.iterator();
        while (it.hasNext())
        {
          attribution = (AttributionSpec)it.next();
          if (estGestionDnj(attribution))
          {
            CalendrierExecutionCalculSpec calCourant = attribution.getCalendrierExecutionCalcul();
            ChronologiePeriodes chronoPeriodeDsmChevochantAttribution = null;
            if (calCourant != null) {
              if ((calCourant.getPremierJourIndemnisable() != null) && (calCourant.getDernierJourIndemnisable() != null))
              {
                chronoPeriodeDsmChevochantAttribution = (ChronologiePeriodes)p_chronologiePeriodeDSM.copier(new FiltreChevauchePeriode(new Periode(calCourant.getPremierJourIndemnisable(), calCourant.getDernierJourIndemnisable())));
                
                determinerDJEtDNJPendantAttribution(calCourant, chronoPeriodeDsmChevochantAttribution);
              }
            }
          }
        }
      }
    }
  }
  
  private static void setBooleanDnjSurChronologieDSM(ChronologiePeriodes p_chronologiePeriodeDSM, boolean p_estDNJ)
  {
    DeclareTravail dsmCourante = null;
    if ((p_chronologiePeriodeDSM != null) && (!p_chronologiePeriodeDSM.estVide()))
    {
      p_chronologiePeriodeDSM.iterer();
      while (p_chronologiePeriodeDSM.encoreSuivant())
      {
        dsmCourante = (DeclareTravail)p_chronologiePeriodeDSM.elementSuivant();
        dsmCourante.setEstJustifie(!p_estDNJ);
      }
    }
  }
  
  private static void initialiserJustificationDSM(ChronologiePeriodes p_chronologiePeriodeDSM)
  {
    DeclareTravail dsmCourante = null;
    if ((p_chronologiePeriodeDSM != null) && (!p_chronologiePeriodeDSM.estVide()))
    {
      p_chronologiePeriodeDSM.iterer();
      while (p_chronologiePeriodeDSM.encoreSuivant())
      {
        dsmCourante = (DeclareTravail)p_chronologiePeriodeDSM.elementSuivant();
        
        CritereStrategie critereStrategie = new CritereStrategie();
        critereStrategie.setDatePivot(dsmCourante.getDateDebut());
        
        StrategieDetectionDNJSpec strategie = (StrategieDetectionDNJSpec)FabriqueStrategieDetectionDNJ.getInstance().getStrategie(critereStrategie);
        
        strategie.determinerStatutPeriodeDeclaree(dsmCourante);
      }
    }
  }
  
  private static void determinerDJEtDNJPendantAttribution(CalendrierExecutionCalculSpec p_calendrierCourant, ChronologiePeriodes p_chronoPeriodeDsm)
  {
    PeriodeDeclare periodeDeclare = null;
    Collection listeDNJ = null;
    Iterator iteratorDNJ = null;
    DsmTravail periodeDeclareDNJ = null;
    ChronologiePeriodes chronologieAnalyse = null;
    
    p_chronoPeriodeDsm.iterer();
    while (p_chronoPeriodeDsm.encoreSuivant())
    {
      boolean estTrouve = false;
      periodeDeclare = (PeriodeDeclare)p_chronoPeriodeDsm.elementSuivant();
      
      listeDNJ = p_calendrierCourant.getListeDNJ();
      if (!listeDNJ.isEmpty())
      {
        iteratorDNJ = listeDNJ.iterator();
        while (iteratorDNJ.hasNext())
        {
          periodeDeclareDNJ = (DsmTravail)iteratorDNJ.next();
          if ((periodeDeclareDNJ.getDateDebut().coincideAvec(periodeDeclare.getDateDebut())) && (periodeDeclareDNJ.getDateFin().coincideAvec(periodeDeclare.getDateFin()))) {
            estTrouve = true;
          }
        }
      }
      chronologieAnalyse = new ChronologiePeriodes();
      chronologieAnalyse.ajouter(periodeDeclare);
      if (estTrouve) {
        setBooleanDnjSurChronologieDSM(chronologieAnalyse, true);
      } else {
        setBooleanDnjSurChronologieDSM(chronologieAnalyse, false);
      }
    }
  }
  
  private static boolean estGestionDnj(AttributionSpec p_attribution)
  {
    return (p_attribution.getGamme().getNomUnique().equals("ASU")) || (p_attribution.getGamme().getNomUnique().equals("SOL"));
  }
}

/* Location:
 * Qualified Name:     GestionDNJ
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */