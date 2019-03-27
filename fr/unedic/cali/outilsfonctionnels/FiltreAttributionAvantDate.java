package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreAttributionAvantDate
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  private Damj m_datePivot;
  
  public FiltreAttributionAvantDate(Damj p_date)
  {
    m_datePivot = p_date;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    List listDossierExamen = ((DemandeSpec)p_temporel).getListeDossiersExamen();
    try
    {
      if ((listDossierExamen != null) && (!listDossierExamen.isEmpty()) && ((listDossierExamen.get(0) instanceof AttributionSpec)))
      {
        AttributionSpec attributionCourante = (AttributionSpec)listDossierExamen.get(0);
        if (m_datePivot.estApres(attributionCourante.getDateAttribution())) {
          return true;
        }
      }
    }
    catch (ClassCastException e)
    {
      return false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreAttributionAvantDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */