package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class DeclareTravail
  extends PeriodeDeclare
  implements TravailSpec
{
  private static final long serialVersionUID = 1L;
  private Quantite m_quantite;
  private QuantiteEuro m_montant;
  private String m_employeur;
  private boolean m_enConflit;
  private transient String m_origineInfo;
  private BigDecimal m_cachets;
  protected boolean m_estJustifieGaec;
  private transient int m_statutDSMTravail;
  
  public DeclareTravail(Periode p_periode)
  {
    super(p_periode);
  }
  
  public DeclareTravail(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public String getEmployeur()
  {
    return m_employeur;
  }
  
  public QuantiteEuro getMontant()
  {
    return m_montant;
  }
  
  public Quantite getQuantite()
  {
    return m_quantite;
  }
  
  public void setEmployeur(String p_string)
  {
    m_employeur = p_string;
  }
  
  public void setMontant(QuantiteEuro p_euro)
  {
    m_montant = p_euro;
  }
  
  public void setQuantite(Quantite p_quantite)
  {
    m_quantite = p_quantite;
  }
  
  public boolean estEnConflit()
  {
    return m_enConflit;
  }
  
  public void setEnConflit(boolean p_enConflit)
  {
    m_enConflit = p_enConflit;
  }
  
  public boolean estParticipantLiquidation()
  {
    return true;
  }
  
  public int getTypePeriode()
  {
    return 30;
  }
  
  public void setOrigineInfo(String p_origineInfo)
  {
    m_origineInfo = p_origineInfo;
  }
  
  public String getOrigineInfo()
  {
    return m_origineInfo;
  }
  
  public Entreprise getEntreprise()
  {
    return null;
  }
  
  public int getStatutDSMTravail()
  {
    return m_statutDSMTravail;
  }
  
  public void setStatutDSMTravail(int p_statutDSMTravail)
  {
    m_statutDSMTravail = p_statutDSMTravail;
  }
  
  public BigDecimal getCachets()
  {
    return m_cachets;
  }
  
  public void setCachets(BigDecimal p_cachets)
  {
    m_cachets = p_cachets;
  }
  
  public int getPrioriteStatut()
  {
    return 4;
  }
  
  public boolean estJustifieGaec()
  {
    return m_estJustifieGaec;
  }
  
  public void setEstJustifieGaec(boolean p_estJustifieGaec)
  {
    m_estJustifieGaec = p_estJustifieGaec;
  }
}

/* Location:
 * Qualified Name:     DeclareTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */