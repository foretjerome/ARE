package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.CompteurIndexPASContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import org.apache.commons.lang.StringUtils;

public class FiltreActiviteSalarieSurMemeContratGAEC
  implements FiltreTemporel
{
  private String m_prefixe;
  
  public FiltreActiviteSalarieSurMemeContratGAEC(TravailSpec p_periodeActivite)
  {
    m_prefixe = CompteurIndexPASContratTravail.recupererPrefixeIdentifiant(p_periodeActivite.getIdentifiant());
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(ActiviteSalarie.class))
    {
      ActiviteSalarie activiteSalarie = (ActiviteSalarie)p_temporel;
      String prefixe = CompteurIndexPASContratTravail.recupererPrefixeIdentifiant(activiteSalarie.getIdentifiant());
      return StringUtils.equals(m_prefixe, prefixe);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieSurMemeContratGAEC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */