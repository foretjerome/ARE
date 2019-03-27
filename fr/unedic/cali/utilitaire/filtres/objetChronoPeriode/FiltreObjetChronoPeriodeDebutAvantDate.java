package fr.unedic.cali.utilitaire.filtres.objetChronoPeriode;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;
import java.util.Collection;

public class FiltreObjetChronoPeriodeDebutAvantDate
  extends FiltreObjetChronoPeriodeAbstrait
{
  private static final long serialVersionUID = 1L;
  private Damj m_dateSeuil = null;
  
  public FiltreObjetChronoPeriodeDebutAvantDate(Damj p_dateSeuil, Collection<String> p_listeContexteUtilisationPeriodeGlobale)
  {
    super(p_listeContexteUtilisationPeriodeGlobale);
    m_dateSeuil = p_dateSeuil;
  }
  
  public FiltreObjetChronoPeriodeDebutAvantDate(Damj p_dateSeuil, String p_contexteUtilisationPeriodeGlobale)
  {
    super(p_contexteUtilisationPeriodeGlobale);
    m_dateSeuil = p_dateSeuil;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean retour = false;
    if ((estActiviteSalarie(p_temporel)) && (m_estContexteUtilisationPeriodeGlobale)) {
      retour = m_dateDebutPeriodeGlobale.estAvant(m_dateSeuil);
    } else {
      retour = p_temporel.getDateDebut().estAvant(m_dateSeuil);
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     FiltreObjetChronoPeriodeDebutAvantDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */