package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class PeriodeNotificationEvenement
  extends Periode
{
  private String m_identifiantPeriodeGaec;
  private String m_typePeriodeGaec;
  private int m_typeEvenementDeclencheur;
  private boolean m_conflitPeriodeGaec;
  
  public PeriodeNotificationEvenement(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
  }
  
  public String getIdentifiantPeriodeGaec()
  {
    return m_identifiantPeriodeGaec;
  }
  
  public int getTypeEvenementDeclencheur()
  {
    return m_typeEvenementDeclencheur;
  }
  
  public String getTypePeriodeGaec()
  {
    return m_typePeriodeGaec;
  }
  
  public void setConflitPeriodeGaec(boolean p_conflitPeriodeGaec)
  {
    m_conflitPeriodeGaec = p_conflitPeriodeGaec;
  }
  
  public void setIdentifiantPeriodeGaec(String p_identifiantPeriodeGaec)
  {
    m_identifiantPeriodeGaec = p_identifiantPeriodeGaec;
  }
  
  public void setTypeEvenementDeclencheur(int p_typeEvenementDeclencheur)
  {
    m_typeEvenementDeclencheur = p_typeEvenementDeclencheur;
  }
  
  public void setTypePeriodeGaec(String p_typePeriodeGaec)
  {
    m_typePeriodeGaec = p_typePeriodeGaec;
  }
  
  public boolean estEnConflit()
  {
    return m_conflitPeriodeGaec;
  }
}

/* Location:
 * Qualified Name:     PeriodeNotificationEvenement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */