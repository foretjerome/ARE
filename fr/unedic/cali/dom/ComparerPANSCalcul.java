package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class ComparerPANSCalcul
{
  public static final int AVANT = 0;
  public static final int APRES = 1;
  private int m_avantApres;
  private Damj m_dateDebut;
  private Damj m_dateFin;
  private BigDecimal m_gain;
  private String m_identifiant;
  private String m_typeRevenu;
  private BigDecimal m_gainApres;
  private String m_typeRevenuApres;
  private boolean m_ecart;
  
  public boolean isEcart()
  {
    return m_ecart;
  }
  
  public void setEcart(boolean p_ecart)
  {
    m_ecart = p_ecart;
  }
  
  public BigDecimal getGainApres()
  {
    return m_gainApres;
  }
  
  public void setGainApres(BigDecimal p_gainApres)
  {
    m_gainApres = p_gainApres;
  }
  
  public String getTypeRevenuApres()
  {
    return m_typeRevenuApres;
  }
  
  public void setTypeRevenuApres(String p_typeRevenuApres)
  {
    m_typeRevenuApres = p_typeRevenuApres;
  }
  
  public String getTypeRevenu()
  {
    return m_typeRevenu;
  }
  
  public void setTypeRevenu(String p_typeRevenu)
  {
    m_typeRevenu = p_typeRevenu;
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
  
  public BigDecimal getGain()
  {
    return m_gain;
  }
  
  public void setGain(BigDecimal p_gain)
  {
    m_gain = p_gain;
  }
}

/* Location:
 * Qualified Name:     ComparerPANSCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */