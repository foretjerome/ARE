package fr.unedic.cali.utilitaire.filtres.objetChronoPeriode;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.Collection;

public class FiltreObjetChronoPeriodeChevaucheDate
  extends FiltreObjetChronoPeriodeAbstrait
{
  private static final long serialVersionUID = 1L;
  private Damj m_dateChevauchement = null;
  
  public FiltreObjetChronoPeriodeChevaucheDate(Damj p_dateChevauchement, Collection<String> p_listeContexteUtilisationPeriodeGlobale)
  {
    super(p_listeContexteUtilisationPeriodeGlobale);
    m_dateChevauchement = p_dateChevauchement;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    Periode periode = null;
    if ((estActiviteSalarie(p_temporel)) && (m_estContexteUtilisationPeriodeGlobale)) {
      periode = new Periode(m_dateDebutPeriodeGlobale, m_dateFinPeriodeGlobale);
    } else {
      periode = new Periode(p_temporel.getDateDebut(), p_temporel.getDateFin());
    }
    return periode.contient(m_dateChevauchement);
  }
}

/* Location:
 * Qualified Name:     FiltreObjetChronoPeriodeChevaucheDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */