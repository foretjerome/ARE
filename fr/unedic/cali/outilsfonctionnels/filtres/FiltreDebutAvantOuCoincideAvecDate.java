package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.cali.utilitaire.filtres.objetChronoPeriode.FiltreObjetChronoPeriodeDebutAvantDate;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.io.Serializable;

public class FiltreDebutAvantOuCoincideAvecDate
  implements FiltreTemporel, Serializable
{
  private static final long serialVersionUID = 2388360408068905169L;
  private Damj m_dateSeuil;
  
  public FiltreDebutAvantOuCoincideAvecDate(Damj p_dateSeuil)
  {
    m_dateSeuil = p_dateSeuil;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    Damj dateDebut = p_temporel.getDateDebut();
    if (dateDebut != null)
    {
      FiltreCaliSpec filtre = new FiltreObjetChronoPeriodeDebutAvantDate(m_dateSeuil.lendemain(), "MVS");
      
      return filtre.accepter(p_temporel);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreDebutAvantOuCoincideAvecDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */