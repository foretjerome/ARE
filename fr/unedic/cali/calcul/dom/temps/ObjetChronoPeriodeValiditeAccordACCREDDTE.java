package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ObjetChronoPeriodeValiditeAccordACCREDDTE
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -2383001701673950576L;
  private Periode m_periodeInitialeAccordACCREDDTE;
  
  private ObjetChronoPeriodeValiditeAccordACCREDDTE() {}
  
  public ObjetChronoPeriodeValiditeAccordACCREDDTE(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public Periode getPeriodeInitialeAccordACCREDDTE()
  {
    return m_periodeInitialeAccordACCREDDTE;
  }
  
  public void setPeriodeInitialeAccordACCREDDTE(Periode p_periodeInitialeAccordACCREDDTE)
  {
    m_periodeInitialeAccordACCREDDTE = p_periodeInitialeAccordACCREDDTE;
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeValiditeAccordACCREDDTE copie = new ObjetChronoPeriodeValiditeAccordACCREDDTE();
    copieElements(copie);
    copie.setPeriodeInitialeAccordACCREDDTE(getPeriodeInitialeAccordACCREDDTE());
    return copie;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeValiditeAccordACCREDDTE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */