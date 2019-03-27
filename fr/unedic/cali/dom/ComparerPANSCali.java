package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;
import java.util.List;

public class ComparerPANSCali
{
  public static final int AVANT = 0;
  public static final int APRES = 1;
  private int m_avantApres;
  private Damj m_dateDebut;
  private Damj m_dateFin;
  private String m_identifiant;
  private List m_listePeriodeAvecRevenu;
  private boolean m_ecart;
  
  public boolean isEcart()
  {
    return m_ecart;
  }
  
  public void setEcart(boolean p_ecart)
  {
    m_ecart = p_ecart;
  }
  
  public String getIdentifiant()
  {
    return m_identifiant;
  }
  
  public void setIdentifiant(String p_identifiant)
  {
    m_identifiant = p_identifiant;
  }
  
  public int getAvantApres()
  {
    return m_avantApres;
  }
  
  public void setAvantApres(int p_avantApres)
  {
    m_avantApres = p_avantApres;
  }
  
  public Damj getDateDebut()
  {
    return m_dateDebut;
  }
  
  public void setDateDebut(Damj p_dateDebut)
  {
    m_dateDebut = p_dateDebut;
  }
  
  public Damj getDateFin()
  {
    return m_dateFin;
  }
  
  public void setDateFin(Damj p_dateFin)
  {
    m_dateFin = p_dateFin;
  }
  
  public List getListePeriodeAvecRevenu()
  {
    return m_listePeriodeAvecRevenu;
  }
  
  public void setListePeriodeAvecRevenu(List p_listePeriodeAvecRevenu)
  {
    m_listePeriodeAvecRevenu = p_listePeriodeAvecRevenu;
  }
}

/* Location:
 * Qualified Name:     ComparerPANSCali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */