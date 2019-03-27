package fr.unedic.cali.parcours;

import fr.unedic.util.temps.ChronologiePeriodes;

public class ResultatServicePrestation
  extends ResultatServiceDemande
{
  private static final long serialVersionUID = 1L;
  private ChronologiePeriodes m_chronoPeriodeExpatrie = null;
  private ChronologiePeriodes m_chronoPensionsInvalidite = null;
  
  public ChronologiePeriodes getChronoPeriodeExpatrie()
  {
    return m_chronoPeriodeExpatrie;
  }
  
  public void setChronoPeriodeExpatrie(ChronologiePeriodes p_chronoPeriodeExpatrie)
  {
    m_chronoPeriodeExpatrie = p_chronoPeriodeExpatrie;
  }
  
  public ChronologiePeriodes getChronoPensionsInvalidite()
  {
    return m_chronoPensionsInvalidite;
  }
  
  public void setChronoPensionsInvalidite(ChronologiePeriodes p_chronoPensionsInvalidite)
  {
    m_chronoPensionsInvalidite = p_chronoPensionsInvalidite;
  }
}

/* Location:
 * Qualified Name:     ResultatServicePrestation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */