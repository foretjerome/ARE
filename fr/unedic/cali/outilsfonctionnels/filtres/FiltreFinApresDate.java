package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.cali.utilitaire.filtres.objetChronoPeriode.FiltreObjetChronoPeriodeFinApresDate;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.io.Serializable;

public class FiltreFinApresDate
  implements FiltreTemporel, Serializable
{
  private static final long serialVersionUID = 1L;
  private Damj dateSeuil = null;
  
  public FiltreFinApresDate(Damj dateSeuil)
  {
    this.dateSeuil = dateSeuil;
  }
  
  public boolean accepter(Temporel temporel)
  {
    if (temporel.getDateFin() != null)
    {
      FiltreCaliSpec filtre = new FiltreObjetChronoPeriodeFinApresDate(dateSeuil, "MVS");
      return filtre.accepter(temporel);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreFinApresDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */