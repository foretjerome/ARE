package fr.unedic.cali.utilitaire.filtres.composites;

import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourProduit;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionSolidariteAta
  extends FiltreCaliAbstrait
{
  private boolean m_filtrerDecisionValidee;
  private static final long serialVersionUID = 1L;
  
  public FiltreAttributionSolidariteAta(boolean p_estDecisionSansReexamen)
  {
    m_filtrerDecisionValidee = p_estDecisionSansReexamen;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    FiltreET filtreAttributionAta = new FiltreET();
    filtreAttributionAta.ajouterFiltre(new FiltreAttributionSolidarite(m_filtrerDecisionValidee));
    filtreAttributionAta.ajouterFiltre(new FiltreDecisionPourProduit(30));
    if (filtreAttributionAta.accepter(p_temporel)) {
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
 * Qualified Name:     FiltreAttributionSolidariteAta
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */