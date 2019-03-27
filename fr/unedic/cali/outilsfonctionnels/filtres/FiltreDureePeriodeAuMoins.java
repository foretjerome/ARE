package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;

public class FiltreDureePeriodeAuMoins
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  private static final Periode TEMPS = new Periode(Damj.NUIT_DES_TEMPS, Damj.FIN_DES_TEMPS);
  private int joursMini;
  
  public FiltreDureePeriodeAuMoins(int joursMiniAttendus)
  {
    joursMini = joursMiniAttendus;
  }
  
  public boolean accepter(Temporel temporel)
  {
    boolean periodeAccepte = false;
    if (temporel != null)
    {
      Periode periode = new Periode(temporel.getDateDebut(), temporel.getDateFin());
      periodeAccepte = periode.inter(TEMPS) >= joursMini;
    }
    return periodeAccepte;
  }
}

/* Location:
 * Qualified Name:     FiltreDureePeriodeAuMoins
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */