package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;

public class PeriodeGaec
  extends ObjetChronoPeriode
  implements PeriodeGaecSpec
{
  private static final long serialVersionUID = 1L;
  public static final int PERIODE_NON_TYPEE = 999;
  public static final int PERIODE_FORMATION_CIF_CDD = 5;
  public static final int PERIODE_ACTIVITE_SALARIEE = 30;
  private Damj m_dateConnaissanceInfo;
  private transient boolean m_estMigree = false;
  protected String m_identifiant;
  private String m_incoherencePeriode = new String();
  
  public PeriodeGaec() {}
  
  public PeriodeGaec(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public PeriodeGaec(Periode p_periode)
  {
    super(p_periode);
  }
  
  public String getIdentifiant()
  {
    return m_identifiant;
  }
  
  public void setIdentifiant(String p_identifiant)
  {
    m_identifiant = p_identifiant;
  }
  
  public ObjetMetierSpec copie()
  {
    return null;
  }
  
  public Damj getDateConnaissanceInfo()
  {
    return m_dateConnaissanceInfo;
  }
  
  public void setDateConnaissanceInfo(Damj p_date)
  {
    m_dateConnaissanceInfo = p_date;
  }
  
  public Periode getPeriode()
  {
    return super.getPeriode();
  }
  
  public boolean estMigree()
  {
    return m_estMigree;
  }
  
  public void setEstMigree(boolean p_estMigree)
  {
    m_estMigree = p_estMigree;
  }
  
  public String getIncoherencePeriode()
  {
    return m_incoherencePeriode;
  }
  
  public void setIncoherencePeriode(String p_incoherencePeriode)
  {
    m_incoherencePeriode = p_incoherencePeriode;
  }
}

/* Location:
 * Qualified Name:     PeriodeGaec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */