package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.CompteurIndexPASContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.cali.calcul.dom.periode.PeriodeActiviteEmploiCalcul;
import fr.unedic.cali.calcul.dom.periode.PeriodePrime;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import org.apache.commons.lang.StringUtils;

public class FiltreObjetChronoPeriodeCalculTransientSurMemeContratGAEC
  implements FiltreTemporel
{
  private static final long serialVersionUID = -6902017670408263447L;
  private String m_prefixe;
  
  public FiltreObjetChronoPeriodeCalculTransientSurMemeContratGAEC(TravailSpec p_periodeActivite)
  {
    m_prefixe = CompteurIndexPASContratTravail.recupererPrefixeIdentifiant(p_periodeActivite.getIdentifiant());
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(PeriodeActiviteEmploiCalcul.class))
    {
      PeriodeActiviteEmploiCalcul periodeAEC = (PeriodeActiviteEmploiCalcul)p_temporel;
      String prefixe = CompteurIndexPASContratTravail.recupererPrefixeIdentifiant(periodeAEC.getIdentifiant());
      return StringUtils.equals(m_prefixe, prefixe);
    }
    if (p_temporel.estType(PeriodePrime.class))
    {
      PeriodePrime periodePrime = (PeriodePrime)p_temporel;
      String prefixe = CompteurIndexPASContratTravail.recupererPrefixeIdentifiant(periodePrime.getIdentifiant());
      return StringUtils.equals(m_prefixe, prefixe);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreObjetChronoPeriodeCalculTransientSurMemeContratGAEC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */