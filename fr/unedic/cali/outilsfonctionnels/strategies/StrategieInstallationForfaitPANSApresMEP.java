package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeAvecRevenu;
import fr.unedic.cali.calcul.OutillageCalculADate;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoRemplissage;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreObjetChronoPeriodeCalculRemplissage;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListePeriodeEmploiPANS;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PANS;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PANSPeriodique;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeEmploiPANS;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.ObjetChronoPeriodeConcrete;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;

public class StrategieInstallationForfaitPANSApresMEP
  implements StrategieInstallationForfaitPANSSpec
{
  private static final int DECEMBRE = 12;
  private static final int DERNIER_JOUR_DECEMBRE = 31;
  private static final int JANVIER = 1;
  private static final int PREMIER_JOUR_JANVIER = 1;
  
  public Damj getDateFinGenerationForfaitPans(Damj dateDebut, Damj fin, Damj dernierJourAtteste)
  {
    Damj dateFin = fin;
    if (dateFin.coincideAvec(Damj.FIN_DES_TEMPS)) {
      if (dernierJourAtteste != null) {
        dateFin = dernierJourAtteste.deplacerVersAvant(new DureeCalendaire(2));
      } else {
        dateFin = dateDebut.deplacerVersAvant(new DureeCalendaire(2));
      }
    }
    return dateFin;
  }
  
  public ChronologiePeriodes recupererPeriodesSansRevenu(PeriodeActivite periodeActivite, PeriodeActiviteNonSalariePeriodique periodeActiviteNonSalariePeriodique, Damj dernierJourAtteste)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoPeriodesSansRevenu = new ChronologiePeriodes();
    ChronologiePeriodes chronoPeriodesSansRevenuRetour = new ChronologiePeriodes();
    ChronologiePeriodes chronoPeriodesAvecRevenuEtRemplie = new ChronologiePeriodes();
    ChronologiePeriodes chronoPeriodesSansRevenuNonFormate = new ChronologiePeriodes();
    
    ChronologiePeriodes chronoRevenu = new ChronologiePeriodes();
    Iterator it = periodeActiviteNonSalariePeriodique.getCollectionPeriodeAvecRevenu().iterator();
    while (it.hasNext())
    {
      PeriodeAvecRevenu revenuPans = (PeriodeAvecRevenu)it.next();
      ObjetChronoPeriodeConcrete periode = new ObjetChronoPeriodeConcrete(revenuPans.getDateDebut(), revenuPans.getDateFin());
      chronoRevenu.ajouter(periode);
    }
    boucheLesTrousAvecPeriodesEmploi(periodeActivite, chronoPeriodesAvecRevenuEtRemplie, periodeActiviteNonSalariePeriodique, chronoRevenu, dernierJourAtteste);
    
    ListePeriodeEmploiPANS listPeriodeEmploiPans = periodeActivite.getPANS().getPANSPeriodique().getListePeriodeEmploiPANS();
    
    chronoPeriodesSansRevenuNonFormate = (ChronologiePeriodes)chronoPeriodesAvecRevenuEtRemplie.copier(new FiltreObjetChronoPeriodeCalculRemplissage());
    
    Iterator ite = chronoPeriodesSansRevenuNonFormate.iterer();
    while (ite.hasNext())
    {
      ObjetChronoRemplissage periodeSansRevenuNonFormate = (ObjetChronoRemplissage)ite.next();
      if (periodeSansRevenuNonFormate.getDateDebut().getAnnee() != periodeSansRevenuNonFormate.getDateFin().getAnnee())
      {
        while (periodeSansRevenuNonFormate.getDateDebut().getAnnee() != periodeSansRevenuNonFormate.getDateFin().getAnnee()) {
          if (periodeSansRevenuNonFormate.getDateDebut().getAnnee() != periodeSansRevenuNonFormate.getDateFin().getAnnee())
          {
            chronoPeriodesSansRevenu.ajouter(new ObjetChronoRemplissage(0, periodeSansRevenuNonFormate.getDateDebut(), new Damj(periodeSansRevenuNonFormate.getDateDebut().getAnnee(), 12, 31)));
            periodeSansRevenuNonFormate = new ObjetChronoRemplissage(0, new Damj(periodeSansRevenuNonFormate.getDateDebut().getAnnee() + 1, 1, 1), periodeSansRevenuNonFormate.getDateFin());
          }
          else
          {
            chronoPeriodesSansRevenu.ajouter(periodeSansRevenuNonFormate);
          }
        }
        chronoPeriodesSansRevenu.ajouter(periodeSansRevenuNonFormate);
        ite.remove();
      }
      else
      {
        chronoPeriodesSansRevenu.ajouter(periodeSansRevenuNonFormate);
      }
    }
    chronoPeriodesSansRevenu.iterer();
    while (chronoPeriodesSansRevenu.encoreSuivant())
    {
      BigDecimal revenuSurAnnee = null;
      PeriodeAvecRevenu revenuPans = null;
      boolean estAAjouter = true;
      ObjetChronoRemplissage periodeSansRevenu = (ObjetChronoRemplissage)chronoPeriodesSansRevenu.elementSuivant();
      revenuSurAnnee = recupererMontantTotal(periodeActiviteNonSalariePeriodique, new Periode(periodeSansRevenu.getDateDebut(), periodeSansRevenu.getDateFin()));
      it = periodeActiviteNonSalariePeriodique.getCollectionPeriodeAvecRevenu().iterator();
      while (it.hasNext())
      {
        revenuPans = (PeriodeAvecRevenu)it.next();
        if (periodeSansRevenu.getDateDebut().getAnnee() == revenuPans.getDateDebut().getAnnee()) {
          estAAjouter = false;
        }
      }
      if ((estAAjouter) && (((periodeSansRevenu.getDateDebut().getMois() == 1) && (periodeSansRevenu.getDateDebut().getJour() == 1) && (periodeSansRevenu.getDateFin().getMois() == 12) && (periodeSansRevenu.getDateFin().getJour() == 31)) || ((revenuSurAnnee != null) && (revenuSurAnnee.compareTo(BigDecimal.ZERO) == 0))))
      {
        PeriodeAvecRevenu periodeAvecRevenu = new PeriodeAvecRevenu(periodeSansRevenu.getDateDebut(), periodeSansRevenu.getDateFin());
        periodeAvecRevenu.setTypeRevenu(1);
        for (int i = 0; i < listPeriodeEmploiPans.getNbListePeriodeEmploiPANS(); i++)
        {
          PeriodeEmploiPANS periodeEmploiCourant = listPeriodeEmploiPans.getListePeriodeEmploiPANS(i);
          if ((periodeAvecRevenu.getPeriode().chevauche(new Periode(periodeEmploiCourant.getDateDebut(), periodeEmploiCourant.getDateFin()))) && (periodeEmploiCourant.getEmploi() != null)) {
            periodeAvecRevenu.setNatureActivite(Integer.valueOf(periodeEmploiCourant.getEmploi()).intValue());
          }
        }
        chronoPeriodesSansRevenuRetour.ajouter(periodeAvecRevenu);
      }
    }
    return chronoPeriodesSansRevenuRetour;
  }
  
  private static BigDecimal recupererMontantTotal(PeriodeActiviteNonSalariePeriodique pans, Periode periodeReference)
  {
    BigDecimal cumulRemuneration = BigDecimal.ZERO;
    Collection collectionRevenuAnnualise = pans.getCollectionPeriodeAvecRevenu();
    Iterator it = collectionRevenuAnnualise.iterator();
    while (it.hasNext())
    {
      PeriodeAvecRevenu periodeAvecRevenu = (PeriodeAvecRevenu)it.next();
      if (periodeAvecRevenu.getDateDebut().getAnnee() == periodeReference.getDebut().getAnnee()) {
        cumulRemuneration = cumulRemuneration.add(periodeAvecRevenu.getMontant());
      }
    }
    return cumulRemuneration;
  }
  
  private void boucheLesTrousAvecPeriodesEmploi(PeriodeActivite periodeActivite, ChronologiePeriodes chronoPeriodesAvecRevenuEtRemplie, PeriodeActiviteNonSalariePeriodique periodeActiviteNonSalariePeriodique, ChronologiePeriodes chronoRevenu, Damj dernierJourAtteste)
    throws CoucheLogiqueException
  {
    ListePeriodeEmploiPANS listPeriodeEmploiPans = periodeActivite.getPANS().getPANSPeriodique().getListePeriodeEmploiPANS();
    for (int i = 0; i < listPeriodeEmploiPans.getNbListePeriodeEmploiPANS(); i++)
    {
      PeriodeEmploiPANS periodeEmploiCourant = listPeriodeEmploiPans.getListePeriodeEmploiPANS(i);
      
      chronoPeriodesAvecRevenuEtRemplie.ajouter(OutillageCalculADate.boucheLesTrous(chronoRevenu, ObjetChronoRemplissage.class, periodeEmploiCourant.getDateDebut(), Damj.min(periodeEmploiCourant.getDateFin(), getDateFinGenerationForfaitPans(periodeActiviteNonSalariePeriodique.getDateDebut(), periodeActiviteNonSalariePeriodique.getDateFin(), dernierJourAtteste.veille()))));
    }
  }
}

/* Location:
 * Qualified Name:     StrategieInstallationForfaitPANSApresMEP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */