package fr.unedic.cali.utilitaire.filtres.objetChronoPeriode;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;
import java.util.Collection;

public class FiltreActiviteSalarieFinAvantDate
  extends FiltreActiviteSalarieAbstrait
{
  private static final long serialVersionUID = 1L;
  private Damj m_dateSeuil = null;
  private boolean m_appliquerSurPeriodeGlobale = false;
  
  public FiltreActiviteSalarieFinAvantDate(Damj p_dateSeuil, Collection<String> p_listeContexteUtilisationPeriodeGlobale)
  {
    super(p_listeContexteUtilisationPeriodeGlobale);
    m_dateSeuil = p_dateSeuil;
  }
  
  public FiltreActiviteSalarieFinAvantDate(Damj p_dateSeuil)
  {
    super("");
    m_dateSeuil = p_dateSeuil;
  }
  
  public FiltreActiviteSalarieFinAvantDate(Damj p_dateSeuil, String p_contexteUtilisationPeriodeGlobale)
  {
    super(p_contexteUtilisationPeriodeGlobale);
    m_dateSeuil = p_dateSeuil;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean retour = false;
    if (m_estContexteUtilisationPeriodeGlobale) {
      retour = m_dateFinPeriodeGlobale.estAvant(m_dateSeuil);
    } else {
      retour = p_temporel.getDateFin().estAvant(m_dateSeuil);
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieFinAvantDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */