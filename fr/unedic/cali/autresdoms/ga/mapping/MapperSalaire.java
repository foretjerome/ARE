package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeNonDeclaree;
import fr.unedic.cali.autresdoms.ga.dom.TravailSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.ConstantesPeriodeActivite;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ChampsPeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeOrigineInformation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListePND;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeSalaires;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.OrigineInformation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PND;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.Unite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.UniteDuree;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

final class MapperSalaire
{
  static void ajouterSalaire(TravailSalarie pasGaec, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Salaire salairesGaec, PeriodeActivite periodeActiviteGa)
    throws CoucheLogiqueException
  {
    Periode periode = FabriquePeriode.creer(salairesGaec.getDateDeb(), salairesGaec.getDateFin());
    if (periode.chevauche(pasGaec.getPeriode()))
    {
      Periode periodeIncluse = periode.periodeIntersection(pasGaec.getPeriode());
      fr.unedic.cali.autresdoms.ga.dom.Salaire salaireCali = new fr.unedic.cali.autresdoms.ga.dom.Salaire(periodeIncluse);
      ajouter(periodeActiviteGa, salaireCali, periode, salairesGaec, pasGaec);
    }
  }
  
  static void ajouterActiviteSalarie(PeriodeActiviteSalarie pasGaec, ListeSalaires listeSalairesGaec, PeriodeActivite periodeActiviteGa)
    throws CoucheLogiqueException
  {
    if (listeSalairesGaec == null) {
      return;
    }
    int nbElements = listeSalairesGaec.getNbListSalaire();
    for (int i = 0; i < nbElements; i++)
    {
      fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Salaire salaireGaec = listeSalairesGaec.getListeSalaires(i);
      Periode periode = FabriquePeriode.creer(salaireGaec.getDateDeb(), salaireGaec.getDateFin());
      if (periode.chevauche(pasGaec.getPeriode()))
      {
        Periode periodeIncluse = periode.periodeIntersection(pasGaec.getPeriode());
        fr.unedic.cali.autresdoms.ga.dom.Salaire salaireCali = new fr.unedic.cali.autresdoms.ga.dom.Salaire(periodeIncluse);
        salaireCali.setPeriodeActiviteSalarieGaec(pasGaec);
        ajouter(periodeActiviteGa, salaireCali, periode, salaireGaec, pasGaec);
      }
    }
  }
  
  private static Collection<PeriodeNonDeclaree> getCollectionPndSurPeriode(PeriodeActivite periodeActiviteGa, Periode periode)
  {
    ListePND listePND = periodeActiviteGa.getChampsPeriodeActivite().getListePND();
    Collection<PeriodeNonDeclaree> retour = new ArrayList();
    if (listePND != null) {
      for (int i = 0; i < listePND.getNbListPND(); i++)
      {
        PND pndCourante = listePND.getListePND(i);
        if ((pndCourante.getDateDebut().estApresOuCoincideAvec(periode.getDebut())) && (pndCourante.getDateFin().estAvantOuCoincideAvec(periode.getFin()))) {
          retour.add(new PeriodeNonDeclaree(pndCourante.getDateDebut(), pndCourante.getDateFin()));
        }
      }
    }
    return retour;
  }
  
  static void ajouter(PeriodeActivite periodeActiviteGa, fr.unedic.cali.autresdoms.ga.dom.Salaire salaireCali, Periode periodeTotal, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Salaire salaireGaec, TravailSalarie pasGaec)
    throws CoucheLogiqueException
  {
    int dureeTotale = periodeTotal.getDuree();
    Periode periodeIncluse = periodeTotal.periodeIntersection(pasGaec.getPeriode());
    int dureeIncluse = periodeIncluse.getDuree();
    BigDecimal montant = salaireGaec.getMontantSalaireBrut();
    if (montant == null) {
      montant = BigDecimal.ZERO;
    }
    if (salaireGaec.getAvantageNature() != null) {
      montant = montant.add(salaireGaec.getAvantageNature());
    }
    BigDecimal qteAbsence = salaireGaec.getQuantiteAbsence();
    if (dureeIncluse != dureeTotale)
    {
      montant = Mathematiques.proratiser(montant, new BigDecimal(dureeIncluse), new BigDecimal(dureeTotale));
      if (qteAbsence != null) {
        qteAbsence = Mathematiques.proratiser(qteAbsence, new BigDecimal(dureeIncluse), new BigDecimal(dureeTotale));
      }
    }
    salaireCali.setDatePaie(salaireGaec.getDatePaie());
    if (montant != null) {
      salaireCali.setMontantBrutBase(new QuantiteEuro(montant));
    } else {
      salaireCali.setMontantBrutBase(new QuantiteEuro(BigDecimal.ZERO));
    }
    boolean mapperAbattement = estPriseEnCompteAbattement(periodeActiviteGa, salaireGaec);
    if (mapperAbattement) {
      salaireCali.setTauxAbattementFraisProfessionnel(CodeGa.valueOf(salaireGaec.getTauxAbattement()));
    }
    if (salaireGaec.getFraisProfessionnel() != null) {
      salaireCali.setFraisProfessionnels(salaireGaec.getFraisProfessionnel());
    }
    salaireCali.setTauxIccp(CodeGa.valueOf(salaireGaec.getTxIccp()));
    if (salaireGaec.getMontantIccp() != null) {
      salaireCali.setMontantIccp(new QuantiteEuro(salaireGaec.getMontantIccp()));
    }
    salaireCali.setTauxIndemnisationPrecarite(CodeGa.valueOf(salaireGaec.getTxIndemnitePrecarite()));
    if (qteAbsence != null)
    {
      String uniteGaec = salaireGaec.getNatureQuantiteAbsence();
      Quantite qte = new Quantite(qteAbsence, convertirUniteAbsence(uniteGaec));
      salaireCali.setQuantiteAbsence(qte);
    }
    salaireCali.calculerMontantSoumisContribution();
    
    String natureAExclure = salaireGaec.getNatureAExclure();
    salaireCali.setNatureAExclure(natureAExclure);
    salaireCali.setExclus(convertirNatureAExclure(natureAExclure));
    if (salaireGaec.getDateConnaissanceInfo() != null) {
      salaireCali.setDateConnaissanceInfo(salaireGaec.getDateConnaissanceInfo());
    }
    salaireCali.setMontantBrutAutreRemuneration(salaireGaec.getMontantBrutAutreRemuneration());
    salaireCali.setNombreJoursTravailles(salaireGaec.getNbreJoursTravailles());
    
    Periode periodeGaec = FabriquePeriode.creer(salaireGaec.getDateDeb(), salaireGaec.getDateFin());
    salaireCali.setCollectionPND(getCollectionPndSurPeriode(periodeActiviteGa, periodeGaec));
    pasGaec.ajouterSalaire(salaireCali);
  }
  
  protected static boolean estPriseEnCompteAbattement(PeriodeActivite periodeActiviteGa, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Salaire salaireGaec)
    throws CoucheLogiqueException
  {
    boolean mapperAbattement = true;
    if (estAeGUSO(periodeActiviteGa))
    {
      Damj datePivotAbatemment;
      Damj datePivotAbatemment;
      if (salaireGaec.getDatePaie() != null) {
        datePivotAbatemment = salaireGaec.getDatePaie();
      } else {
        datePivotAbatemment = salaireGaec.getDateFin();
      }
      Damj dateApplication = GestionnaireDateApplication.getInstance().recupererDateApplication("Date application prise en compte abattement");
      if (dateApplication.estAvantOuCoincideAvec(datePivotAbatemment)) {
        mapperAbattement = false;
      }
    }
    return mapperAbattement;
  }
  
  private static boolean estAeGUSO(PeriodeActivite periodeGaec)
  {
    boolean estGUSO = false;
    if ((periodeGaec != null) && (periodeGaec.getChampsPeriodeActivite() != null) && (periodeGaec.getChampsPeriodeActivite().getListeOrigineInformation() != null) && (periodeGaec.getChampsPeriodeActivite().getListeOrigineInformation().getNbListOrigineInformation() > 0))
    {
      ListeOrigineInformation listeOrigineInfo = periodeGaec.getChampsPeriodeActivite().getListeOrigineInformation();
      for (int i = 0; i < listeOrigineInfo.getNbListOrigineInformation(); i++)
      {
        BigDecimal code = listeOrigineInfo.getListeOrigineInformation(i).getCodeOrigineInformation();
        if ((code != null) && ((code.intValue() == 5) || (code.intValue() == 6))) {
          estGUSO = true;
        }
      }
    }
    return estGUSO;
  }
  
  private static boolean convertirNatureAExclure(String natureAExclure)
  {
    return (natureAExclure != null) && ((ConstantesPeriodeActivite.AEXCLURE_EXCLU_AUTO.equals(natureAExclure)) || (ConstantesPeriodeActivite.AEXCLURE_EXCLU_MANUEL.equals(natureAExclure)));
  }
  
  private static Unite convertirUniteAbsence(String pUniteGaec)
  {
    Unite uniteCali = null;
    
    int uniteGaec = Integer.parseInt(pUniteGaec);
    if (uniteGaec == 1) {
      uniteCali = UniteDuree.get("jour");
    } else if (uniteGaec == 2) {
      uniteCali = UniteDuree.get("heure");
    } else {
      throw new RuntimeException("Unité d'absence '" + pUniteGaec + "' non gérée");
    }
    return uniteCali;
  }
}

/* Location:
 * Qualified Name:     MapperSalaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */