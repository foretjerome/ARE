package fr.unedic.cali.utilitaire.filtres.objetChronoPeriode;

import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.Collection;

public class FiltreActiviteSalarieChevauchePeriode
  extends FiltreActiviteSalarieAbstrait
{
  private static final long serialVersionUID = 1L;
  private Periode m_periodeChevauchement = null;
  
  public FiltreActiviteSalarieChevauchePeriode(Periode p_periode, Collection<String> p_listeContexteUtilisationPeriodeGlobale)
  {
    super(p_listeContexteUtilisationPeriodeGlobale);
    m_periodeChevauchement = p_periode;
  }
  
  public FiltreActiviteSalarieChevauchePeriode(Periode p_periode, String p_contexteUtilisationPeriodeGlobale)
  {
    super(p_contexteUtilisationPeriodeGlobale);
    m_periodeChevauchement = p_periode;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean retour = false;
    if (m_estContexteUtilisationPeriodeGlobale) {
      retour = m_periodeChevauchement.chevauche(new Periode(m_dateDebutPeriodeGlobale, m_dateFinPeriodeGlobale));
    } else {
      retour = m_periodeChevauchement.chevauche(new Periode(p_temporel.getDateDebut(), p_temporel.getDateFin()));
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalarieChevauchePeriode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */