package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;

public class PeriodeNonDeclaree
  extends ObjetChronoPeriode
{
  public PeriodeNonDeclaree() {}
  
  public PeriodeNonDeclaree(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     PeriodeNonDeclaree
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */