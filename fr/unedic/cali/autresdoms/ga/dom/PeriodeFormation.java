package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;

public class PeriodeFormation
  extends Formation
{
  private int m_origineRemuneration;
  private ArrayList m_listeOriginesInformation;
  private Periode m_periodeEffective;
  private String m_typeMesurePourEmploi;
  private String intitule;
  
  public PeriodeFormation() {}
  
  public PeriodeFormation(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public PeriodeFormation(Periode p_periode)
  {
    super(p_periode);
  }
  
  public int getOrigineRemuneration()
  {
    return m_origineRemuneration;
  }
  
  public void setOrigineRemuneration(int p_origineRemuneration)
  {
    m_origineRemuneration = p_origineRemuneration;
  }
  
  public ArrayList getListeOriginesInformation()
  {
    return m_listeOriginesInformation != null ? m_listeOriginesInformation : new ArrayList();
  }
  
  public void setListeOriginesInformation(ArrayList p_listeOriginesInformation)
  {
    m_listeOriginesInformation = p_listeOriginesInformation;
  }
  
  public Periode getPeriodePrevisionnnelle()
  {
    return getPeriode();
  }
  
  public void setPeriodePrevisionnnelle(Periode p_periode)
  {
    setPeriode(p_periode);
  }
  
  public Periode getPeriodeEffective()
  {
    return m_periodeEffective;
  }
  
  public void setPeriodeEffective(Periode p_periode)
  {
    m_periodeEffective = p_periode;
  }
  
  public String getTypeMesurePourEmploi()
  {
    return m_typeMesurePourEmploi;
  }
  
  public void setTypeMesurePourEmploi(String p_typeMesurePourEmploi)
  {
    m_typeMesurePourEmploi = p_typeMesurePourEmploi;
  }
  
  public String getIntitule()
  {
    return intitule;
  }
  
  public void setIntitule(String intitule)
  {
    this.intitule = intitule;
  }
}

/* Location:
 * Qualified Name:     PeriodeFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */