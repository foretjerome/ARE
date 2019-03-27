package fr.unedic.cali.utilitaire.filtres.objetChronoPeriode;

import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.Collection;

public class FiltreObjetChronoPeriodeChevauchePeriode
  extends FiltreObjetChronoPeriodeAbstrait
{
  private static final long serialVersionUID = 1L;
  private Periode m_periodeChevauchement = null;
  
  public FiltreObjetChronoPeriodeChevauchePeriode(Periode p_periode, Collection<String> p_listeContexteUtilisationPeriodeGlobale)
  {
    super(p_listeContexteUtilisationPeriodeGlobale);
    m_periodeChevauchement = p_periode;
  }
  
  public FiltreObjetChronoPeriodeChevauchePeriode(Periode p_periode, String p_contexteUtilisationPeriodeGlobale)
  {
    super(p_contexteUtilisationPeriodeGlobale);
    m_periodeChevauchement = p_periode;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean retour = false;
    ObjetChronoPeriode periode = (ObjetChronoPeriode)p_temporel;
    if ((estActiviteSalarie(p_temporel)) && (m_estContexteUtilisationPeriodeGlobale)) {
      retour = m_periodeChevauchement.chevauche(new Periode(m_dateDebutPeriodeGlobale, m_dateFinPeriodeGlobale));
    } else {
      retour = periode.chevauche(m_periodeChevauchement);
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     FiltreObjetChronoPeriodeChevauchePeriode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */