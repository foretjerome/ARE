package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionPourRsod
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private String m_rsod;
  
  public FiltreAttributionPourRsod(String p_rsod)
  {
    if ((p_rsod == null) || ("".equals(p_rsod))) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "rsod" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    m_rsod = p_rsod;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    FiltreAttributionSurDecisions filtrePrerequis = new FiltreAttributionSurDecisions();
    if (filtrePrerequis.accepter(p_temporel))
    {
      String rsod = ((AttributionSpec)p_temporel).getRsod();
      if ((rsod != null) && (m_rsod.equals(rsod))) {
        return true;
      }
    }
    return false;
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreAttributionPourRsod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */