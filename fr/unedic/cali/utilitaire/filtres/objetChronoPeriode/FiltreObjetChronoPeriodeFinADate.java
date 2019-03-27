package fr.unedic.cali.utilitaire.filtres.objetChronoPeriode;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;
import java.util.Collection;

public class FiltreObjetChronoPeriodeFinADate
  extends FiltreObjetChronoPeriodeAbstrait
{
  private static final long serialVersionUID = 1L;
  private Damj m_date = null;
  
  public FiltreObjetChronoPeriodeFinADate(Damj p_date, Collection<String> p_listeContexteUtilisationPeriodeGlobale)
  {
    super(p_listeContexteUtilisationPeriodeGlobale);
    m_date = p_date;
    m_listeContexteUtilisationPeriodeGlobale = p_listeContexteUtilisationPeriodeGlobale;
  }
  
  public FiltreObjetChronoPeriodeFinADate(Damj p_date, String p_contexteUtilisationPeriodeGlobale)
  {
    super(p_contexteUtilisationPeriodeGlobale);
    m_date = p_date;
  }
  
  public FiltreObjetChronoPeriodeFinADate(Damj p_date)
  {
    super("");
    m_date = p_date;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean retour = false;
    if ((estActiviteSalarie(p_temporel)) && (m_estContexteUtilisationPeriodeGlobale)) {
      retour = m_dateFinPeriodeGlobale.coincideAvec(m_date);
    } else {
      retour = p_temporel.getDateFin().coincideAvec(m_date);
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     FiltreObjetChronoPeriodeFinADate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */