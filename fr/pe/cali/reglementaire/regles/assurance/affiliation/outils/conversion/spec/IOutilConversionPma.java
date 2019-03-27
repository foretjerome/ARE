package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.conversion.spec;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeMesureActivite;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.List;

public abstract interface IOutilConversionPma
{
  public abstract List<Damj> convertirEnJoursTravailles(PeriodeMesureActivite paramPeriodeMesureActivite, Periode paramPeriode);
}

/* Location:
 * Qualified Name:     IOutilConversionPma
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */