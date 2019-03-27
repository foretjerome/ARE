package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChrono60AnsBlocageRetraite
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 4963381813893420474L;
  
  private ObjetChrono60AnsBlocageRetraite() {}
  
  public ObjetChrono60AnsBlocageRetraite(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChrono60AnsBlocageRetraite copie = new ObjetChrono60AnsBlocageRetraite();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChrono60AnsBlocageRetraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */