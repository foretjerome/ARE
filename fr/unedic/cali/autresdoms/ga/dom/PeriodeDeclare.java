package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.cali.autresdoms.ga.dom.spec.DeclareSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class PeriodeDeclare
  extends PeriodeGaec
  implements DeclareSpec
{
  public static final int PERIODE_DECLARE_INDETERMINE = 0;
  public static final int PERIODE_DECLARE_MALADIE = 1;
  public static final int PERIODE_DECLARE_FORMATION = 2;
  public static final int PERIODE_DECLARE_ABSENCE_AU_POINTAGE = 3;
  public static final int PERIODE_DECLARE_SUSPENSION_CONTRAT_TRAVAIL = 4;
  public static final int PERIODE_DECLARE_CONGES_NON_PAYES = 5;
  private boolean m_estJustifie;
  private int m_typePeriodeDeclare;
  
  public PeriodeDeclare(Periode p_periode)
  {
    super(p_periode);
  }
  
  public PeriodeDeclare(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public boolean estJustifie()
  {
    return m_estJustifie;
  }
  
  public void setEstJustifie(boolean p_estJustifie)
  {
    m_estJustifie = p_estJustifie;
  }
  
  public int getTypePeriodeDeclare()
  {
    return m_typePeriodeDeclare;
  }
  
  public void setTypePeriodeDeclare(int p_typePeriodeDeclare)
  {
    m_typePeriodeDeclare = p_typePeriodeDeclare;
  }
}

/* Location:
 * Qualified Name:     PeriodeDeclare
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */