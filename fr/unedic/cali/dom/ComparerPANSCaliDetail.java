package fr.unedic.cali.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import java.math.BigDecimal;

public class ComparerPANSCaliDetail
  extends ObjetChronoPeriode
{
  private static final long serialVersionUID = 1L;
  public static final int AVANT = 0;
  public static final int APRES = 1;
  private int m_avantApres;
  private Damj m_dateDebut;
  private Damj m_dateFin;
  private BigDecimal m_montant;
  private String m_identifiant;
  private String m_typeRevenu;
  private BigDecimal m_montantApres;
  private String m_typeRevenuApres;
  private boolean m_ecart;
  
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
  
  public String getIdentifiant()
  {
    return m_identifiant;
  }
  
  public void setIdentifiant(String p_identifiant)
  {
    m_identifiant = p_identifiant;
  }
  
  public BigDecimal getMontant()
  {
    return m_montant;
  }
  
  public void setMontant(BigDecimal p_montant)
  {
    m_montant = p_montant;
  }
  
  public String getTypeRevenu()
  {
    return m_typeRevenu;
  }
  
  public void setTypeRevenu(String p_typeRevenu)
  {
    m_typeRevenu = p_typeRevenu;
  }
  
  public boolean isEcart()
  {
    return m_ecart;
  }
  
  public void setEcart(boolean p_ecart)
  {
    m_ecart = p_ecart;
  }
  
  public BigDecimal getMontantApres()
  {
    return m_montantApres;
  }
  
  public void setMontantApres(BigDecimal p_montantApres)
  {
    m_montantApres = p_montantApres;
  }
  
  public String getTypeRevenuApres()
  {
    return m_typeRevenuApres;
  }
  
  public void setTypeRevenuApres(String p_typeRevenuApres)
  {
    m_typeRevenuApres = p_typeRevenuApres;
  }
  
  public ObjetMetierSpec copie()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     ComparerPANSCaliDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */