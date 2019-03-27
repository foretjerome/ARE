package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionPourPeriode
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private Periode m_periode;
  
  public FiltreAttributionPourPeriode(Periode p_periode)
  {
    if (p_periode == null) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "periode" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    m_periode = p_periode;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    FiltreAttributionSurDecisions filtrePrerequis = new FiltreAttributionSurDecisions();
    if (filtrePrerequis.accepter(p_temporel))
    {
      Damj dateAttribution = ((AttributionSpec)p_temporel).getDateAttribution();
      if (dateAttribution.estContenueDans(m_periode)) {
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
 * Qualified Name:     FiltreAttributionPourPeriode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */