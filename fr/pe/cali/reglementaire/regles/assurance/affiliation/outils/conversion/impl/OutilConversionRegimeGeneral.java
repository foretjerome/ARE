package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.conversion.impl;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeMesureActivite;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.List;

class OutilConversionRegimeGeneral
  extends OutilConversionPma
{
  public List<Damj> convertirEnJoursTravailles(PeriodeMesureActivite pma, Periode periodeRecherche)
  {
    List<Damj> joursTravailles = new ArrayList();
    if (pma.chevauche(periodeRecherche))
    {
      Periode periodeIntersection = determinerPeriodeIntersection(pma.getPeriode(), periodeRecherche);
      ChronologiePeriodes suspensions = recupererPeriodeSuspension(pma);
      if (suspensions.estVide()) {
        joursTravailles.addAll(repartirJoursTravaillesContratPlein(periodeIntersection));
      } else {
        joursTravailles.addAll(repartirJoursTravaillesContratPeinSansSuspension(periodeIntersection, suspensions));
      }
    }
    return joursTravailles;
  }
}

/* Location:
 * Qualified Name:     OutilConversionRegimeGeneral
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */