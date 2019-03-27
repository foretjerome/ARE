package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;

public class ValidationAnnexe8Convention2016
  implements ValidationReglementSpec
{
  private static String codePostalMonaco = "98000";
  private static ArrayList<String> listeIdccGenerique = new ArrayList();
  
  static
  {
    listeIdccGenerique.add("9999");
    listeIdccGenerique.add("0000");
    listeIdccGenerique.add("5100");
    listeIdccGenerique.add("5501");
  }
  
  public boolean validerPeriode(PeriodeActiviteSalarie periode)
  {
    return recupererValidationAnnexe8NafOuIDCC(periode).validerPeriode(periode);
  }
  
  protected ValidationReglementSpec recupererValidationAnnexe8NafOuIDCC(PeriodeActiviteSalarie periode)
  {
    Damj dateConnaissanceInfo = periode.getDateConnaissanceInfo();
    ValidationReglementSpec validationRetour;
    ValidationReglementSpec validationRetour;
    if (estPeriodeEligibleQualificationIdcc(dateConnaissanceInfo, periode.getDateDebut(), estCodePostalMonaco(periode.getEntreprise().getCodePostalEntreprise()), estIDCCGeneriqueDansPeriodeTransitoire(periode.getContratTravail().getIdccEmployeur(), dateConnaissanceInfo))) {
      validationRetour = new ValidationAnnexe8Convention2016AvecIDCC();
    } else {
      validationRetour = new ValidationAnnexe8Convention2016AvecNaf();
    }
    return validationRetour;
  }
  
  protected boolean estCodePostalMonaco(String codePostal)
  {
    return (codePostal != null) && (codePostalMonaco.equals(codePostal));
  }
  
  protected boolean estIDCCGeneriqueDansPeriodeTransitoire(String idcc, Damj dateConnaissanceInfo)
  {
    Damj dateDebutPeriodeTransitoire = null;
    try
    {
      dateDebutPeriodeTransitoire = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de prise en compte IDCC à la place des NAF : date connaissance info");
    }
    catch (CoucheLogiqueException e) {}
    Damj dateFinPeriodeTransitoire = null;
    try
    {
      dateFinPeriodeTransitoire = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de fin periode transitoire prise en compte idcc generique");
    }
    catch (CoucheLogiqueException e) {}
    Periode periodeTransitoire = new Periode(dateDebutPeriodeTransitoire, dateFinPeriodeTransitoire);
    return (idcc != null) && (listeIdccGenerique.contains(idcc)) && (periodeTransitoire.contient(dateConnaissanceInfo));
  }
  
  protected boolean estPeriodeEligibleQualificationIdcc(Damj dateConnaissanceInfo, Damj dateDebutContrat, boolean estCodePostalMonaco, boolean estIdccGeneriqueDansPeriodeTransitoire)
  {
    Damj datePriseEnCompteIdccConnaissanceInfo = null;
    try
    {
      datePriseEnCompteIdccConnaissanceInfo = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de prise en compte IDCC à la place des NAF : date connaissance info");
    }
    catch (CoucheLogiqueException e)
    {
      new ApplicativeRuntimeException(e.getCode(), e.getOrigine());
    }
    Damj datePriseEnCompteIdccDebutContrat = null;
    try
    {
      datePriseEnCompteIdccDebutContrat = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de prise en compte IDCC à la place des NAF : date debut contrat");
    }
    catch (CoucheLogiqueException e)
    {
      new ApplicativeRuntimeException(e.getCode(), e.getOrigine());
    }
    boolean dateConnaissanceInfoApresDateApplication = (dateConnaissanceInfo != null) && (datePriseEnCompteIdccConnaissanceInfo.estAvantOuCoincideAvec(dateConnaissanceInfo));
    return (dateConnaissanceInfoApresDateApplication) && (datePriseEnCompteIdccDebutContrat.estAvantOuCoincideAvec(dateDebutContrat)) && (!estCodePostalMonaco) && (!estIdccGeneriqueDansPeriodeTransitoire);
  }
}

/* Location:
 * Qualified Name:     ValidationAnnexe8Convention2016
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */