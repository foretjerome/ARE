package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeSuspensionDDTEAvecImputation
  extends PeriodeSanction
{
  private int m_dureeImputation;
  
  protected PeriodeSuspensionDDTEAvecImputation() {}
  
  public PeriodeSuspensionDDTEAvecImputation(Damj p_debut, Damj p_fin, String p_codeSanction)
  {
    super(p_debut, p_fin, p_codeSanction);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeSuspensionDDTEAvecImputation copie = new PeriodeSuspensionDDTEAvecImputation();
    copieElements(copie);
    return copie;
  }
  
  public int getDureeImputation()
  {
    return m_dureeImputation;
  }
  
  public void setDureeImputation(int p_dureeImputation)
  {
    m_dureeImputation = p_dureeImputation;
  }
}

/* Location:
 * Qualified Name:     PeriodeSuspensionDDTEAvecImputation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */