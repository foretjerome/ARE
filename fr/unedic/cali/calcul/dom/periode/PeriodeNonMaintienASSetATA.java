package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeNonMaintienASSetATA
  extends PeriodeSanction
{
  private static final long serialVersionUID = 3345581386424002096L;
  
  protected PeriodeNonMaintienASSetATA() {}
  
  public PeriodeNonMaintienASSetATA(Damj p_debut, Damj p_fin, String p_codeSanction)
  {
    super(p_debut, p_fin, p_codeSanction);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeNonMaintienASSetATA copie = new PeriodeNonMaintienASSetATA();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeNonMaintienASSetATA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */