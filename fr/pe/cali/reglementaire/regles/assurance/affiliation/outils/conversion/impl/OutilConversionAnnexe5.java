package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.conversion.impl;

import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl.OutilQuantiteAffiliation;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeMesureActivite;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.List;

class OutilConversionAnnexe5
  extends OutilConversionPma
{
  public List<Damj> convertirEnJoursTravailles(PeriodeMesureActivite pma, Periode periodeRecherche)
  {
    List<Damj> joursTravailles = new ArrayList();
    if (pma.chevauche(periodeRecherche))
    {
      Quantite heures = pma.getQuantiteAffiliation(Unite.get("heure de travail"));
      if (OutilQuantiteAffiliation.getInstance().isQuantiteValide(heures))
      {
        int nombreJoursTravailles = convertir(heures, periodeRecherche, pma.getPeriode());
        joursTravailles.addAll(repartirJours(pma, periodeRecherche, nombreJoursTravailles));
      }
    }
    return joursTravailles;
  }
  
  protected int convertir(Quantite heures, Periode periodeRecherche, Periode periodePma)
  {
    return OutilQuantiteAffiliation.getInstance().convertirEnJoursTravailles(heures, ConstantesCoefficientConversionAffiliation.COEFFICIENT_CONVERSION_HEURE, periodeRecherche, periodePma);
  }
}

/* Location:
 * Qualified Name:     OutilConversionAnnexe5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */