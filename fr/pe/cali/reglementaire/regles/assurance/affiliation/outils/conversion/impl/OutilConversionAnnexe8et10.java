package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.conversion.impl;

import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl.OutilQuantiteAffiliation;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeMesureActivite;
import fr.unedic.cali.autresdoms.ga.dom.Salaire;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.Unite;
import fr.unedic.util.UniteAffiliation;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class OutilConversionAnnexe8et10
  extends OutilConversionPma
{
  public List<Damj> convertirEnJoursTravailles(PeriodeMesureActivite pma, Periode periodeRecherche)
  {
    List<Damj> joursTravailles = new ArrayList();
    if (pma.chevauche(periodeRecherche))
    {
      Quantite nombreJoursSurSalaire = recupererNombreJoursTravaillesSurSalaire(pma);
      int nombreJoursTravailles;
      int nombreJoursTravailles;
      if (OutilQuantiteAffiliation.getInstance().isQuantiteValide(nombreJoursSurSalaire)) {
        nombreJoursTravailles = determinerNombreJoursTravailles(nombreJoursSurSalaire, periodeRecherche, pma.getPeriode());
      } else {
        nombreJoursTravailles = determinerNombreJoursTravaillesDepuisHeure(pma, periodeRecherche);
      }
      joursTravailles.addAll(repartirJours(pma, periodeRecherche, nombreJoursTravailles));
    }
    return joursTravailles;
  }
  
  protected Quantite recupererNombreJoursTravaillesSurSalaire(PeriodeMesureActivite pma)
  {
    ActiviteSalarie activiteSalarie = pma.getPeriodeActiviteSalarie();
    Chronologie salaires = activiteSalarie.getListeSalaires();
    salaires.iterer();
    Salaire salaireARetourner = null;
    while ((salaires.encoreSuivant()) && (salaireARetourner == null))
    {
      Salaire salaireCourant = (Salaire)salaires.elementSuivant();
      if (salaireCourant.getPeriode().coincideAvec(pma.getPeriode())) {
        salaireARetourner = salaireCourant;
      }
    }
    Quantite quantiteARetourner = null;
    if ((salaireARetourner != null) && (salaireARetourner.getNombreJoursTravailles() != null)) {
      quantiteARetourner = new QuantiteJour(salaireARetourner.getNombreJoursTravailles());
    }
    return quantiteARetourner;
  }
  
  protected int determinerNombreJoursTravailles(Quantite joursTravailles, Periode periodeRecherche, Periode periodePma)
  {
    int nombreJourTravailles;
    int nombreJourTravailles;
    if (periodeRecherche.contient(periodePma))
    {
      nombreJourTravailles = joursTravailles.getValeurEntiere();
    }
    else
    {
      Quantite quantiteProratise = OutilQuantiteAffiliation.getInstance().proratiserQuantite(joursTravailles, periodePma.getDuree(), periodePma.inter(periodeRecherche));
      nombreJourTravailles = quantiteProratise.getValeur().setScale(0, 0).intValue();
    }
    return nombreJourTravailles;
  }
  
  protected int determinerNombreJoursTravaillesDepuisHeure(PeriodeMesureActivite pma, Periode periodeRecherche)
  {
    int nombreJoursTravailles = 0;
    Quantite heures = pma.getQuantiteAffiliation(Unite.get("heure de travail"));
    if (OutilQuantiteAffiliation.getInstance().isQuantiteValide(heures))
    {
      nombreJoursTravailles = OutilQuantiteAffiliation.getInstance().convertirEnJoursTravailles(heures, ConstantesCoefficientConversionAffiliation.COEFFICIENT_CONVERSION_HEURE, periodeRecherche, pma.getPeriode());
    }
    else
    {
      Quantite cachets = recupererQuantiteCachets(pma);
      if (OutilQuantiteAffiliation.getInstance().isQuantiteValide(cachets))
      {
        heures = new Quantite(cachets.getValeur().multiply(ConstantesCoefficientConversionAffiliation.COEFFICIENT_CONVERSION_CACHET_HEURE), UniteAffiliation.HEURE_TRAVAIL);
        nombreJoursTravailles = OutilQuantiteAffiliation.getInstance().convertirEnJoursTravailles(heures, ConstantesCoefficientConversionAffiliation.COEFFICIENT_CONVERSION_HEURE, periodeRecherche, pma.getPeriode());
      }
    }
    return nombreJoursTravailles;
  }
  
  protected Quantite recupererQuantiteCachets(PeriodeMesureActivite pma)
  {
    Quantite cachets = pma.getQuantiteAffiliation(Unite.get("cachet groupe"));
    if (!OutilQuantiteAffiliation.getInstance().isQuantiteValide(cachets)) {
      cachets = pma.getQuantiteAffiliation(Unite.get("cachet isole"));
    }
    return cachets;
  }
}

/* Location:
 * Qualified Name:     OutilConversionAnnexe8et10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */