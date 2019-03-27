package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.cali.util.OutilDomToString;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.List;

public class PeriodeEvenementPersonnelIndemnisable
  extends PeriodeEvenementPersonnel
{
  protected List m_listePeriodeIndemnisation;
  private boolean m_maladieGrave;
  
  public PeriodeEvenementPersonnelIndemnisable()
  {
    initInstance();
  }
  
  public PeriodeEvenementPersonnelIndemnisable(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public PeriodeEvenementPersonnelIndemnisable(Periode p_periode)
  {
    super(p_periode);
  }
  
  public List getListePeriodeIndemnisation()
  {
    return m_listePeriodeIndemnisation;
  }
  
  public void ajouter(Indemnisation p_indemnisation)
  {
    m_listePeriodeIndemnisation.add(p_indemnisation);
  }
  
  protected void initInstance()
  {
    m_listePeriodeIndemnisation = new ArrayList();
  }
  
  public String toString()
  {
    return OutilDomToString.toString(this);
  }
  
  public boolean isMaladieGrave()
  {
    return m_maladieGrave;
  }
  
  public void setMaladieGrave(boolean p_maladieGrave)
  {
    m_maladieGrave = p_maladieGrave;
  }
}

/* Location:
 * Qualified Name:     PeriodeEvenementPersonnelIndemnisable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */