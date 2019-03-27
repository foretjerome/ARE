package fr.unedic.cali.parcours;

import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.temps.Damj;

public class ResultatDetailleProduit
  extends ResultatCalcul
{
  private transient AttributionSpec m_attribution = null;
  
  public final void setAttribution(AttributionSpec p_attribution)
  {
    m_attribution = p_attribution;
  }
  
  public final AttributionSpec getAttribution()
  {
    return m_attribution;
  }
  
  public Damj getPremierJourIndemnisable()
  {
    return getCalendrierExecutionCalcul().getPremierJourIndemnisable();
  }
  
  public Damj getDernierJourIndemnisable()
  {
    return getCalendrierExecutionCalcul().getDernierJourIndemnisable();
  }
}

/* Location:
 * Qualified Name:     ResultatDetailleProduit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */