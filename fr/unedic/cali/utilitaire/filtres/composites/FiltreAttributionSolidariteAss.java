package fr.unedic.cali.utilitaire.filtres.composites;

import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourTypeProduit;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionSolidariteAss
  extends FiltreCaliAbstrait
{
  private boolean m_filtrerDecisionValidee;
  private static final long serialVersionUID = 1L;
  
  public FiltreAttributionSolidariteAss(boolean p_estDecisionSansReexamen)
  {
    m_filtrerDecisionValidee = p_estDecisionSansReexamen;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    FiltreET filtreAttributionAss = new FiltreET();
    filtreAttributionAss.ajouterFiltre(new FiltreAttributionSolidarite(m_filtrerDecisionValidee));
    filtreAttributionAss.ajouterFiltre(new FiltreDecisionPourTypeProduit(3));
    if (filtreAttributionAss.accepter(p_temporel)) {
      return true;
    }
    return false;
  }
  
  public int getTypeElementManipule()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     FiltreAttributionSolidariteAss
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */