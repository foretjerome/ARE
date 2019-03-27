package fr.unedic.cali.autresdoms.ga.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.DeclareTravail;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeDeclare;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionDNJ;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodeActiviteAutreQuePeriodeDsm;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodeDsm;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodesJustifiees;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;

public class FiltragePourDeterminationDNJ
{
  public static Chronologie filtrer(Chronologie p_chronoAEtudier, IndividuSpec p_individu)
  {
    Chronologie chronoPeriodesIndividuARetourner = new ChronologiePeriodes();
    Chronologie chronoDsmTravailAEtudier = new ChronologiePeriodes();
    Chronologie chronoDsmRetenusCalcul = new ChronologiePeriodes();
    
    Chronologie chronoAutreQueDsm = p_chronoAEtudier.copier(new FiltrePeriodeActiviteAutreQuePeriodeDsm());
    chronoPeriodesIndividuARetourner.ajouter(chronoAutreQueDsm);
    
    Chronologie chronoDsm = p_chronoAEtudier.copier(new FiltrePeriodeDsm());
    
    chronoDsm.iterer();
    while (chronoDsm.encoreSuivant())
    {
      PeriodeDeclare dsm = (PeriodeDeclare)chronoDsm.elementSuivant();
      if (((dsm instanceof DeclareTravail)) && (!((DeclareTravail)dsm).estJustifieGaec())) {
        chronoDsmTravailAEtudier.ajouter(dsm);
      }
    }
    GestionDNJ.determineEtatPeriodesDSM(p_individu, (ChronologiePeriodes)chronoDsmTravailAEtudier);
    
    chronoDsmRetenusCalcul = chronoDsmTravailAEtudier.copier(new FiltrePeriodesJustifiees(false));
    
    chronoDsmRetenusCalcul.iterer();
    while (chronoDsmRetenusCalcul.encoreSuivant()) {
      chronoPeriodesIndividuARetourner.ajouter(chronoDsmRetenusCalcul.elementSuivant());
    }
    return chronoPeriodesIndividuARetourner;
  }
}

/* Location:
 * Qualified Name:     FiltragePourDeterminationDNJ
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */