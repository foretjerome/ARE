package fr.unedic.cali.calcul;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.cali.calcul.dom.periode.PeriodeDisponibilite;
import fr.unedic.cali.calcul.outilsfonctionnels.filtres.FiltrePeriodeTravailCalculPAEC;
import fr.unedic.cali.calcul.pbjc.dom.DroitPbjcNcp;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.cali.fabriques.FabriqueStrategieQuantiteAffiliationHeureAvecCachet;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePansMensuelEtSupra;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieQuantiteAffiliationHeureAvecCachetSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.ObjetChronoPeriode;
import java.util.Iterator;
import java.util.List;

public abstract class FacadeCalculProduitPeriodiqueAbstraite
  implements FacadeCalculProduitPeriodiqueSpec
{
  public void convertionCachets(ChronologiePeriodes periodes)
  {
    if ((periodes != null) && (!periodes.estVide()))
    {
      Chronologie chronoPeriodesPAEC = periodes.copier(new FiltrePeriodeTravailCalculPAEC());
      if ((chronoPeriodesPAEC != null) && (!chronoPeriodesPAEC.estVide()))
      {
        chronoPeriodesPAEC.iterer();
        while (chronoPeriodesPAEC.encoreSuivant())
        {
          PeriodeActiviteEmploiCalcul periodeActivite = (PeriodeActiviteEmploiCalcul)chronoPeriodesPAEC.elementSuivant();
          if ((periodeActivite.getQuantiteAffiliationCachets() != null) && (periodeActivite.getCachets() != null))
          {
            periodeActivite.setNombreHeures(periodeActivite.getNombreHeuresDeCompletude());
            
            CritereStrategie strategieHeureCachets = new CritereStrategie();
            strategieHeureCachets.setDatePivot(periodeActivite.getDateDebut());
            StrategieQuantiteAffiliationHeureAvecCachetSpec strategieHeureAvecCachet = (StrategieQuantiteAffiliationHeureAvecCachetSpec)FabriqueStrategieQuantiteAffiliationHeureAvecCachet.getInstance().getStrategie(strategieHeureCachets);
            
            strategieHeureAvecCachet.determinerQuantiteAffiliationHeureAvecCachet(periodeActivite, periodeActivite.getQuantiteAffiliationCachets());
          }
        }
      }
    }
  }
  
  public void alimenterDonneesSpectacle(AttributionSpec attribution, CalendrierExecutionCalculSpec calendrierExecutionCalcul, DroitPbjcNcp droitPbjcNcp) {}
  
  public void annulerReliquatPlafoneeSpecSuiteARCE(AttributionSpec pattribution) {}
  
  public Quantite determinerQteContexteFormation(AttributionSpec attribution, Quantite quantiteAImputer, String contexteIndemnisation, QuantiteDroitSpec quantiteDroitAImputer, List<QuantiteDroitSpec> listeQuantiteDroit)
    throws CoucheLogiqueException
  {
    return quantiteAImputer;
  }
  
  public boolean estAspDcSuperieurUnAn(AttributionSpec pattribution)
  {
    return false;
  }
  
  public FiltreTemporel ajouterFiltrePeriodeSurUT()
  {
    return new FiltrePansMensuelEtSupra();
  }
  
  public QuantiteDroitSpec determinerDureeProlongationprioritaire(AttributionSpec attribution, List<QuantiteDroitSpec> listeQuantiteDroitActives, Quantite quantiteAImputer)
  {
    return null;
  }
  
  public void enrichirPeriodeDisponibilite(AttributionSpec attribution, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes periodesGAEC = OutillagePeriodes.recupererPeriodesGAEC(individu, attribution.getDateAttribution(), null);
    
    periodesGAEC.iterer();
    while (periodesGAEC.encoreSuivant())
    {
      ObjetChronoPeriode periode = (ObjetChronoPeriode)periodesGAEC.elementSuivant();
      if ((periode instanceof PeriodeDisponibilite))
      {
        ActiviteSalarie ae = (ActiviteSalarie)rechercherPeriodePasseProfessionnel(individu, ((PeriodeDisponibilite)periode).getIdContratTravail());
        if ((ae != null) && (ae.estUneFct()) && (ae.estAtteste()))
        {
          ((PeriodeDisponibilite)periode).setEstFctPresente(true);
          ((PeriodeDisponibilite)periode).setDateFCT(ae.getDateFin());
        }
        ((PeriodeDisponibilite)periode).setEstPeriodeEnCours(attribution.getDateAttribution().estApres(((PeriodeDisponibilite)periode).getDateDebutRenouvellement()));
      }
    }
  }
  
  public PeriodeGaecSpec rechercherPeriodePasseProfessionnel(IndividuSpec individu, String identifiantPeriode)
  {
    Iterator iter;
    if (identifiantPeriode != null)
    {
      ChronologiePeriodes chronoPasseProfessionnelCourante = individu.getChronoPeriodePasseProfessionnel();
      if ((chronoPasseProfessionnelCourante != null) && (!chronoPasseProfessionnelCourante.estVide())) {
        for (iter = chronoPasseProfessionnelCourante.iterer(); iter.hasNext();)
        {
          PeriodeGaecSpec periodePasseProfessionnelRecherchee = (PeriodeGaecSpec)iter.next();
          if (periodePasseProfessionnelRecherchee.getIdentifiant().contains(identifiantPeriode)) {
            return periodePasseProfessionnelRecherchee;
          }
        }
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     FacadeCalculProduitPeriodiqueAbstraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */