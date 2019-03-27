package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeSuspensionDDTESansImputation
  extends PeriodeSanction
{
  protected PeriodeSuspensionDDTESansImputation() {}
  
  public PeriodeSuspensionDDTESansImputation(Damj p_debut, Damj p_fin, String p_codeSanction)
  {
    super(p_debut, p_fin, p_codeSanction);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeSuspensionDDTESansImputation copie = new PeriodeSuspensionDDTESansImputation();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeSuspensionDDTESansImputation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */