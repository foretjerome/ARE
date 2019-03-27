package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.cali.utilitaire.filtres.objetChronoPeriode.FiltreObjetChronoPeriodeFinAvantDate;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.io.Serializable;

public class FiltreFinAvantDate
  implements FiltreTemporel, Serializable
{
  private static final long serialVersionUID = 1L;
  private Damj m_dateSeuil = null;
  
  public FiltreFinAvantDate(Damj p_dateSeuil)
  {
    m_dateSeuil = p_dateSeuil;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.getDateFin() != null)
    {
      FiltreCaliSpec filtre = new FiltreObjetChronoPeriodeFinAvantDate(m_dateSeuil, "MVS");
      return filtre.accepter(p_temporel);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreFinAvantDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */