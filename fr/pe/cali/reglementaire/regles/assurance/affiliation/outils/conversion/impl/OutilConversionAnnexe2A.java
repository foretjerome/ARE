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

class OutilConversionAnnexe2A
  extends OutilConversionPma
{
  public List<Damj> convertirEnJoursTravailles(PeriodeMesureActivite pma, Periode periodeRecherche)
  {
    List<Damj> joursTravailles = new ArrayList();
    if (pma.chevauche(periodeRecherche))
    {
      boolean pmaSansQuantite = false;
      Quantite joursEmbarquement = pma.getQuantiteAffiliation(Unite.get("embarquement administratif"));
      int nombreJoursTravailles;
      int nombreJoursTravailles;
      if (OutilQuantiteAffiliation.getInstance().isQuantiteValide(joursEmbarquement))
      {
        nombreJoursTravailles = convertirJoursEmbarquement(joursEmbarquement, periodeRecherche, pma.getPeriode());
      }
      else
      {
        Quantite heures = pma.getQuantiteAffiliation(Unite.get("heure de travail"));
        int nombreJoursTravailles;
        if (OutilQuantiteAffiliation.getInstance().isQuantiteValide(heures))
        {
          nombreJoursTravailles = convertirHeure(heures, periodeRecherche, pma.getPeriode());
        }
        else
        {
          pmaSansQuantite = true;
          
          nombreJoursTravailles = pma.getPeriode().inter(periodeRecherche);
        }
      }
      if (pmaSansQuantite)
      {
        Periode periodeIntersection = determinerPeriodeIntersection(pma.getPeriode(), periodeRecherche);
        ChronologiePeriodes suspensions = recupererPeriodeSuspension(pma);
        if (suspensions.estVide()) {
          joursTravailles.addAll(repartirJoursTravaillesContratPlein(periodeIntersection));
        } else {
          joursTravailles.addAll(repartirJoursTravaillesContratPeinSansSuspension(periodeIntersection, suspensions));
        }
      }
      else
      {
        joursTravailles.addAll(repartirJours(pma, periodeRecherche, nombreJoursTravailles));
      }
    }
    return joursTravailles;
  }
  
  protected int convertirJoursEmbarquement(Quantite joursEmbarquement, Periode periodeRecherche, Periode periodePma)
  {
    return OutilQuantiteAffiliation.getInstance().convertirEnJoursTravailles(joursEmbarquement, ConstantesCoefficientConversionAffiliation.COEFFICIENT_CONVERSION_JOUR_EMBARQUEMENT, periodeRecherche, periodePma);
  }
  
  protected int convertirHeure(Quantite heures, Periode periodeRecherche, Periode periodePma)
  {
    return OutilQuantiteAffiliation.getInstance().convertirEnJoursTravailles(heures, ConstantesCoefficientConversionAffiliation.COEFFICIENT_CONVERSION_HEURE, periodeRecherche, periodePma);
  }
}

/* Location:
 * Qualified Name:     OutilConversionAnnexe2A
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */