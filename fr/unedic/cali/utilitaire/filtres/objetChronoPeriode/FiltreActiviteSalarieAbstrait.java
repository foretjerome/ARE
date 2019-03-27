package fr.unedic.cali.utilitaire.filtres.objetChronoPeriode;

import fr.unedic.util.temps.Temporel;
import java.util.Collection;

public abstract class FiltreActiviteSalarieAbstrait
  extends FiltreObjetChronoPeriodeAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public FiltreActiviteSalarieAbstrait(Collection<String> p_listeContexteUtilisationPeriodeGlobale)
  {
    super(p_listeContexteUtilisationPeriodeGlobale);
  }
  
  public FiltreActiviteSalarieAbstrait(String p_contexteUtilisationPeriodeGlobale)
  {
    super(p_contexteUtilisationPeriodeGlobale);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    boolean retour = false;
    renseignerDonneesActivite(p_temporel, m_listeContexteUtilisationPeriodeGlobale);
    if (m_estActiviteSalariee) {
      retour = super.accepter(p_temporel);
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */