package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.PeriodeActiviteSalarieCaliSpec;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeActiviteSalarieeMemeReglement
  implements FiltreTemporel
{
  private static final long serialVersionUID = 4235316449098688155L;
  private String m_nomReglement = null;
  
  public FiltrePeriodeActiviteSalarieeMemeReglement(String p_nomReglement)
  {
    m_nomReglement = p_nomReglement;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(PeriodeActiviteSalarieCaliSpec.class))
    {
      Reglement reglementCourant = ((PeriodeActiviteSalarieCaliSpec)p_temporel).getReglement();
      if (m_nomReglement != null) {
        return reglementCourant.estNomReglementIdentique(m_nomReglement);
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeActiviteSalarieeMemeReglement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */