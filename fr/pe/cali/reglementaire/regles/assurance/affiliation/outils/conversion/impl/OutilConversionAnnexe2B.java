package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.conversion.impl;

import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl.OutilQuantiteAffiliation;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeMesureActivite;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.List;

class OutilConversionAnnexe2B
  extends OutilConversionPma
{
  public List<Damj> convertirEnJoursTravailles(PeriodeMesureActivite pma, Periode periodeRecherche)
  {
    List<Damj> joursTravailles = new ArrayList();
    if (pma.chevauche(periodeRecherche))
    {
      Quantite joursEmbarquement = pma.getQuantiteAffiliation(Unite.get("embarquement administratif"));
      if (OutilQuantiteAffiliation.getInstance().isQuantiteValide(joursEmbarquement))
      {
        int nombreJoursTravailles = convertir(joursEmbarquement, periodeRecherche, pma.getPeriode());
        joursTravailles.addAll(repartirJours(pma, periodeRecherche, nombreJoursTravailles));
      }
      else
      {
        Periode periodeIntersection = determinerPeriodeIntersection(pma.getPeriode(), periodeRecherche);
        ChronologiePeriodes suspensions = recupererPeriodeSuspension(pma);
        if (suspensions.estVide()) {
          joursTravailles.addAll(repartirJoursTravaillesContratPlein(periodeIntersection));
        } else {
          joursTravailles.addAll(repartirJoursTravaillesContratPeinSansSuspension(periodeIntersection, suspensions));
        }
      }
    }
    return joursTravailles;
  }
  
  protected int convertir(Quantite joursEmbarquement, Periode periodeRecherche, Periode periodePma)
  {
    return OutilQuantiteAffiliation.getInstance().convertirEnJoursTravailles(joursEmbarquement, ConstantesCoefficientConversionAffiliation.COEFFICIENT_CONVERSION_JOUR_EMBARQUEMENT, periodeRecherche, periodePma);
  }
}

/* Location:
 * Qualified Name:     OutilConversionAnnexe2B
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */