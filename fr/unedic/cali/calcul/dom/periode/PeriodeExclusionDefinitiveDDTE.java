package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeExclusionDefinitiveDDTE
  extends PeriodeSanction
{
  protected PeriodeExclusionDefinitiveDDTE() {}
  
  public PeriodeExclusionDefinitiveDDTE(Damj p_debut, Damj p_fin, String p_codeSanction, String p_rsod)
  {
    super(p_debut, p_fin, p_codeSanction, p_rsod);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeExclusionDefinitiveDDTE copie = new PeriodeExclusionDefinitiveDDTE();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PeriodeExclusionDefinitiveDDTE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */