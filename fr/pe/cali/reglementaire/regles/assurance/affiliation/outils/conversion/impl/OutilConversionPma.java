package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.conversion.impl;

import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.conversion.spec.IOutilConversionPma;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeMesureActivite;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreIncident;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.List;

abstract class OutilConversionPma
  implements IOutilConversionPma
{
  protected Periode determinerPeriodeIntersection(Periode periodePma, Periode periodeRecherche)
  {
    Periode intersection = null;
    if (periodePma.chevauche(periodeRecherche))
    {
      Damj debut = Damj.max(periodePma.getDebut(), periodeRecherche.getDebut());
      Damj fin = Damj.min(periodePma.getFin(), periodeRecherche.getFin());
      intersection = new Periode(debut, fin);
    }
    return intersection;
  }
  
  protected boolean isPeriodeContratCreuse(int nombreJoursTravailles, Periode periodePma)
  {
    return nombreJoursTravailles < periodePma.getDuree();
  }
  
  protected List<Damj> repartirJoursTravaillesContratPlein(Periode periodePma)
  {
    List<Damj> joursTravailles = new ArrayList();
    Damj dateCourante = periodePma.getDebut();
    while (dateCourante.estAvantOuCoincideAvec(periodePma.getFin()))
    {
      joursTravailles.add(dateCourante);
      dateCourante = dateCourante.lendemain();
    }
    return joursTravailles;
  }
  
  protected List<Damj> repartirJours(PeriodeMesureActivite pma, Periode periodeRecherche, int nombreJoursTravailles)
  {
    List<Damj> joursTravailles = new ArrayList();
    if (nombreJoursTravailles > 0)
    {
      Periode intersection = determinerPeriodeIntersection(pma.getPeriode(), periodeRecherche);
      if (isPeriodeContratCreuse(nombreJoursTravailles, intersection)) {
        joursTravailles = OutilRepartitionJourTravaille.getInstance().repartirJour(intersection, nombreJoursTravailles);
      } else {
        joursTravailles = repartirJoursTravaillesContratPlein(intersection);
      }
    }
    return joursTravailles;
  }
  
  protected List<Damj> repartirJoursTravaillesContratPeinSansSuspension(Periode periodePma, ChronologiePeriodes suspensions)
  {
    List<Damj> joursTravailles = new ArrayList();
    Damj dateCourante = periodePma.getDebut();
    while (dateCourante.estAvantOuCoincideAvec(periodePma.getFin()))
    {
      Periode jourRecherche = new Periode(dateCourante, dateCourante);
      if (jourRecherche.inter(suspensions) == 0) {
        joursTravailles.add(dateCourante);
      }
      dateCourante = dateCourante.lendemain();
    }
    return joursTravailles;
  }
  
  protected ChronologiePeriodes recupererPeriodeSuspension(PeriodeMesureActivite pma)
  {
    return (ChronologiePeriodes)pma.getPeriodeActiviteSalarie().getListePeriodesIncident().copier(new FiltreIncident());
  }
}

/* Location:
 * Qualified Name:     OutilConversionPma
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */