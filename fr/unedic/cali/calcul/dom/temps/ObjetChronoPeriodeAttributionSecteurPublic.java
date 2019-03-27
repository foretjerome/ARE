package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoPeriodeAttributionSecteurPublic
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -228867581293211132L;
  private AttributionSpec m_attribution;
  
  private ObjetChronoPeriodeAttributionSecteurPublic() {}
  
  public ObjetChronoPeriodeAttributionSecteurPublic(Damj p_date, AttributionSpec p_attribution)
  {
    super(p_date, p_date);
    setAttribution(p_attribution);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeAttributionSecteurPublic copie = new ObjetChronoPeriodeAttributionSecteurPublic();
    copieElements(copie);
    return copie;
  }
  
  public AttributionSpec getAttribution()
  {
    return m_attribution;
  }
  
  public void setAttribution(AttributionSpec p_attribution)
  {
    m_attribution = p_attribution;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeAttributionSecteurPublic
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */