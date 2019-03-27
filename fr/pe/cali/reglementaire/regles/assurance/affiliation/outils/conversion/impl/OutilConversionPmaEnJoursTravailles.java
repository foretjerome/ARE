package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.conversion.impl;

import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.conversion.spec.IOutilConversionPma;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeMesureActivite;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.List;

public class OutilConversionPmaEnJoursTravailles
{
  private static OutilConversionPmaEnJoursTravailles instance = null;
  
  public static OutilConversionPmaEnJoursTravailles getInstance()
  {
    if (instance == null) {
      instance = new OutilConversionPmaEnJoursTravailles();
    }
    return instance;
  }
  
  public List<Damj> convertirPma(PeriodeMesureActivite pma, Periode periodeRecherche)
  {
    IOutilConversionPma outilConversion = FabriqueOutilConversion.getInstance().recupererOutilConversion(pma.getPeriodeActiviteSalarie().getReglement().getNomReglement());
    return outilConversion.convertirEnJoursTravailles(pma, periodeRecherche);
  }
}

/* Location:
 * Qualified Name:     OutilConversionPmaEnJoursTravailles
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */