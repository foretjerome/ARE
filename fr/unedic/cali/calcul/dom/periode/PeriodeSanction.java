package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public abstract class PeriodeSanction
  extends ObjetChronoPeriodeCalculTransient
{
  public String m_codeSanction;
  public Periode m_periodeInitiale;
  public String m_rsod;
  
  protected PeriodeSanction() {}
  
  public PeriodeSanction(Damj p_debut, Damj p_fin, String p_codeSanction)
  {
    super(p_debut, p_fin);
    setCodeSanction(p_codeSanction);
  }
  
  public PeriodeSanction(Damj p_debut, Damj p_fin, String p_codeSanction, String p_rsod)
  {
    super(p_debut, p_fin);
    setCodeSanction(p_codeSanction);
    setRSOD(p_rsod);
  }
  
  public String getCodeSanction()
  {
    return m_codeSanction;
  }
  
  public void setCodeSanction(String p_codeSanction)
  {
    m_codeSanction = p_codeSanction;
  }
  
  public Periode getPeriodeInitiale()
  {
    return m_periodeInitiale;
  }
  
  public void setPeriodeInitiale(Periode p_periodeInitiale)
  {
    m_periodeInitiale = p_periodeInitiale;
  }
  
  public void setRSOD(String p_rsod)
  {
    m_rsod = p_rsod;
  }
  
  public String getRSOD()
  {
    return m_rsod;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeSanction copie = (PeriodeSanction)p_copie;
    
    super.copieElements(p_copie);
    
    m_codeSanction = getCodeSanction();
    m_periodeInitiale = getPeriodeInitiale();
  }
}

/* Location:
 * Qualified Name:     PeriodeSanction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */