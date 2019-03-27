package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnChargeSansFiltre;
import fr.unedic.cali.calcul.dom.EvenementParametre;
import fr.unedic.cali.calcul.dom.periode.PeriodeForfaitCA;
import fr.unedic.cali.calcul.dom.periode.PeriodeForfaitCIRMA;
import fr.unedic.cali.calcul.parametres.ParametresIndemnisation;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class StrategieEntreeCACIRMAApresMEP
  implements StrategiePECCACIRMAetCUISpec
{
  private static final BigDecimal FORFAIT = new BigDecimal("80");
  
  public int mapperTypeContratParticulier(int p_typeContratParticulier)
  {
    int retourType = 0;
    switch (p_typeContratParticulier)
    {
    case 21: 
      retourType = 211;
      break;
    case 22: 
      retourType = 221;
      break;
    default: 
      retourType = p_typeContratParticulier;
    }
    return retourType;
  }
  
  public void ajouterEvenementCA(ChronologiePeriodes p_evenementsRetour, ObjetChronoPeriodePriseEnChargeSansFiltre p_periodePriseEnCharge, Periode p_periodeUT, Damj p_dateDJA)
  {
    if (p_periodeUT.chevauche(new Periode(p_periodePriseEnCharge.getDateDebut(), p_periodePriseEnCharge.getDateFin())))
    {
      boolean proratiserEnDebutUT = false;
      boolean proratiserEnFinUT = false;
      
      Damj dateLimiteCreationForfait = determinerDateFinCreationPeriodeForfait(p_periodePriseEnCharge.getDateDebut(), p_periodePriseEnCharge.getDateFin(), p_dateDJA);
      if (p_periodeUT.getFin().estAvantOuCoincideAvec(dateLimiteCreationForfait.getFinMois()))
      {
        PeriodeForfaitCA periodeForfait = new PeriodeForfaitCA();
        if (p_periodePriseEnCharge.getDateDebut().estContenueDans(p_periodeUT)) {
          proratiserEnDebutUT = true;
        }
        if (dateLimiteCreationForfait.estContenueDans(p_periodeUT)) {
          proratiserEnFinUT = true;
        }
        if (proratiserEnDebutUT) {
          periodeForfait.setDateDebut(p_periodePriseEnCharge.getDateDebut());
        } else {
          periodeForfait.setDateDebut(p_periodeUT.getDebut());
        }
        if (proratiserEnFinUT) {
          periodeForfait.setDateFin(dateLimiteCreationForfait);
        } else {
          periodeForfait.setDateFin(p_periodeUT.getFin());
        }
        periodeForfait.setGain(calculerGains(p_periodeUT.getDebut(), periodeForfait.getDuree(), p_periodeUT.getDuree()));
        periodeForfait.setNombreHeures(calculerNombreHeures(periodeForfait.getDuree(), p_periodeUT.getDuree()));
        p_evenementsRetour.ajouter(periodeForfait);
      }
    }
  }
  
  public void ajouterEvenementCIRMA(ChronologiePeriodes p_evenementsRetour, ObjetChronoPeriodePriseEnChargeSansFiltre p_periodePriseEnCharge, Periode p_periodeUT, Damj p_dateDJA)
  {
    if (p_periodeUT.chevauche(new Periode(p_periodePriseEnCharge.getDateDebut(), p_periodePriseEnCharge.getDateFin())))
    {
      boolean proratiserEnDebutUT = false;
      boolean proratiserEnFinUT = false;
      Damj dateLimiteCreationForfait = determinerDateFinCreationPeriodeForfait(p_periodePriseEnCharge.getDateDebut(), p_periodePriseEnCharge.getDateFin(), p_dateDJA);
      if (p_periodeUT.getFin().estAvantOuCoincideAvec(dateLimiteCreationForfait.getFinMois()))
      {
        PeriodeForfaitCIRMA periodeForfait = new PeriodeForfaitCIRMA();
        if (p_periodePriseEnCharge.getDateDebut().estContenueDans(p_periodeUT)) {
          proratiserEnDebutUT = true;
        }
        if (dateLimiteCreationForfait.estContenueDans(p_periodeUT)) {
          proratiserEnFinUT = true;
        }
        if (proratiserEnDebutUT) {
          periodeForfait.setDateDebut(p_periodePriseEnCharge.getDateDebut());
        } else {
          periodeForfait.setDateDebut(p_periodeUT.getDebut());
        }
        if (proratiserEnFinUT) {
          periodeForfait.setDateFin(dateLimiteCreationForfait);
        } else {
          periodeForfait.setDateFin(p_periodeUT.getFin());
        }
        periodeForfait.setGain(calculerGains(p_periodeUT.getDebut(), periodeForfait.getDuree(), p_periodeUT.getDuree()));
        periodeForfait.setNombreHeures(calculerNombreHeures(periodeForfait.getDuree(), p_periodeUT.getDuree()));
        p_evenementsRetour.ajouter(periodeForfait);
      }
    }
  }
  
  private Damj determinerDateFinCreationPeriodeForfait(Damj p_dateDebutPEC, Damj p_dateFinPEC, Damj p_dateDJA)
  {
    Damj dateLimiteCreationForfait = null;
    if ((p_dateFinPEC == null) || (Damj.FIN_DES_TEMPS.coincideAvec(p_dateFinPEC.lendemain())))
    {
      if (p_dateDJA != null) {
        dateLimiteCreationForfait = p_dateDJA.deplacerVersAvant(new DureeCalendaire(1, 0, 0));
      } else {
        dateLimiteCreationForfait = p_dateDebutPEC.deplacerVersAvant(new DureeCalendaire(1, 0, 0));
      }
    }
    else {
      dateLimiteCreationForfait = p_dateFinPEC;
    }
    return dateLimiteCreationForfait;
  }
  
  private BigDecimal calculerGains(Damj p_dateCalcul, int p_dureePeriode, int p_dureePeriodeUT)
  {
    BigDecimal smicHoraire = ParametresIndemnisation.getParametresIndemnisation().getElementActif(p_dateCalcul).getSmicHoraire();
    BigDecimal gain = FORFAIT.multiply(smicHoraire);
    if (p_dureePeriode != p_dureePeriodeUT) {
      gain = gain.multiply(new BigDecimal(p_dureePeriode)).divide(new BigDecimal(p_dureePeriodeUT), 2, 6);
    }
    return gain.setScale(2, 6);
  }
  
  private BigDecimal calculerNombreHeures(int p_dureePeriode, int p_dureePeriodeUT)
  {
    BigDecimal nombreHeures = FORFAIT;
    if (p_dureePeriode != p_dureePeriodeUT) {
      nombreHeures = nombreHeures.multiply(new BigDecimal(p_dureePeriode)).divide(new BigDecimal(p_dureePeriodeUT), 2, 6);
    }
    return nombreHeures.setScale(2, 6);
  }
  
  public boolean estActiviteChevauchantPecTypeParticulierPourNeutralisationPFM(ObjetChronoPeriodePriseEnChargeSansFiltre p_periodePriseEnChargeSansFiltre)
  {
    return false;
  }
  
  public void ajouterAnomalieM09(ObjetChronoPeriodePriseEnChargeSansFiltre p_periodePriseEnChargeSansFiltre, Damj p_dateFinUT, IndividuSpec p_individu)
    throws CoucheLogiqueException
  {}
}

/* Location:
 * Qualified Name:     StrategieEntreeCACIRMAApresMEP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */