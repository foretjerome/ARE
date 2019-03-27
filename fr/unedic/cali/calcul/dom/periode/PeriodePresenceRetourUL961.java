package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodePresenceRetourUL961
  extends PeriodeEvenementActualisation
{
  protected PeriodePresenceRetourUL961() {}
  
  public PeriodePresenceRetourUL961(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodePresenceRetourUL961 copie = new PeriodePresenceRetourUL961();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodePresenceRetourUL961
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */