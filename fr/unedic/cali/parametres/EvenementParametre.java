package fr.unedic.cali.parametres;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebut;
import java.math.BigDecimal;

public class EvenementParametre
  extends ObjetChronoEvenementDebut
{
  private static final long serialVersionUID = -84305937843800820L;
  private BigDecimal m_smicMensuelBase35h = null;
  private boolean m_nouveauSmicMensuelBase35h = false;
  private BigDecimal m_smicJournalierBase35h = null;
  private boolean m_nouveauSmicJournalierBase35h = false;
  private BigDecimal m_smigJournalierMayotteBase39h = null;
  private boolean m_nouveauSmigJournalierMayotteBase39h = false;
  private BigDecimal m_plafondJournalierSecuriteSociale = null;
  private boolean m_nouveauPlafondJournalierSecuriteSociale = false;
  private BigDecimal m_plafondMensuelSecuriteSociale = null;
  private boolean m_nouveauPlafondMensuelSecuriteSociale = false;
  
  public EvenementParametre(Damj p_dateEvenement)
  {
    super(p_dateEvenement);
  }
  
  public void repercuter(EvenementParametre p_evtSource)
  {
    boolean memeDateEffet = getDateEffet().equals(p_evtSource.getDateEffet());
    if (m_smicMensuelBase35h == null)
    {
      m_smicMensuelBase35h = p_evtSource.getSmicMensuelBase35h();
      if (memeDateEffet) {
        m_nouveauSmicMensuelBase35h = p_evtSource.estNouveauSmicMensuelBase35h();
      }
    }
    else
    {
      m_nouveauSmicMensuelBase35h = true;
    }
    if (m_smicJournalierBase35h == null)
    {
      m_smicJournalierBase35h = p_evtSource.getSmicJournalierBase35h();
      if (memeDateEffet) {
        m_nouveauSmicJournalierBase35h = p_evtSource.estNouveauSmicJournalierBase35h();
      }
    }
    else
    {
      m_nouveauSmicJournalierBase35h = true;
    }
    if (m_smigJournalierMayotteBase39h == null)
    {
      m_smigJournalierMayotteBase39h = p_evtSource.getSmigJournalierMayotteBase39h();
      if (memeDateEffet) {
        m_nouveauSmigJournalierMayotteBase39h = p_evtSource.estNouveauSmigJournalierMayotteBase39h();
      }
    }
    else
    {
      m_nouveauSmigJournalierMayotteBase39h = true;
    }
    if (m_plafondJournalierSecuriteSociale == null)
    {
      m_plafondJournalierSecuriteSociale = p_evtSource.getPlafondJournalierSecuriteSociale();
      if (memeDateEffet) {
        m_nouveauPlafondJournalierSecuriteSociale = p_evtSource.estNouveauPlafondJournalierSecuriteSociale();
      }
    }
    else
    {
      m_nouveauPlafondJournalierSecuriteSociale = true;
    }
    if (m_plafondMensuelSecuriteSociale == null)
    {
      m_plafondMensuelSecuriteSociale = p_evtSource.getPlafondMensuelSecuriteSociale();
      if (memeDateEffet) {
        m_nouveauPlafondMensuelSecuriteSociale = p_evtSource.estNouveauPlafondMensuelSecuriteSociale();
      }
    }
    else
    {
      m_nouveauPlafondMensuelSecuriteSociale = true;
    }
  }
  
  public boolean estNouveauSmicMensuelBase35h()
  {
    return m_nouveauSmicMensuelBase35h;
  }
  
  public void setNouveauSmicMensuelBase35h(boolean p_nouveauSmicMensuelBase35h)
  {
    m_nouveauSmicMensuelBase35h = p_nouveauSmicMensuelBase35h;
  }
  
  public BigDecimal getSmicMensuelBase35h()
  {
    return m_smicMensuelBase35h;
  }
  
  public void setSmicMensuelBase35h(BigDecimal p_smicMensuelBase35h)
  {
    m_smicMensuelBase35h = p_smicMensuelBase35h;
  }
  
  public boolean estNouveauSmicJournalierBase35h()
  {
    return m_nouveauSmicJournalierBase35h;
  }
  
  public boolean estNouveauSmigJournalierMayotteBase39h()
  {
    return m_nouveauSmigJournalierMayotteBase39h;
  }
  
  public void setNouveauSmicJournalierBase35h(boolean p_nouveauSmicJournalierBase35h)
  {
    m_nouveauSmicJournalierBase35h = p_nouveauSmicJournalierBase35h;
  }
  
  public void setNouveauSmigJournalierMayotteBase39h(boolean p_nouveauSmicJournalierBase39h)
  {
    m_nouveauSmigJournalierMayotteBase39h = p_nouveauSmicJournalierBase39h;
  }
  
  public BigDecimal getSmicJournalierBase35h()
  {
    return m_smicJournalierBase35h;
  }
  
  public BigDecimal getSmigJournalierMayotteBase39h()
  {
    return m_smigJournalierMayotteBase39h;
  }
  
  public void setSmicJournalierBase35h(BigDecimal p_smicJournalierBase35h)
  {
    m_smicJournalierBase35h = p_smicJournalierBase35h;
  }
  
  public void setSmigJournalierMayotteBase39h(BigDecimal p_smicJournalierMayotteBase39h)
  {
    m_smigJournalierMayotteBase39h = p_smicJournalierMayotteBase39h;
  }
  
  public boolean estNouveauPlafondJournalierSecuriteSociale()
  {
    return m_nouveauPlafondJournalierSecuriteSociale;
  }
  
  public void setNouveauPlafondJournalierSecuriteSociale(boolean p_nouveauPlafondJournalierSecuriteSociale)
  {
    m_nouveauPlafondJournalierSecuriteSociale = p_nouveauPlafondJournalierSecuriteSociale;
  }
  
  public BigDecimal getPlafondJournalierSecuriteSociale()
  {
    return m_plafondJournalierSecuriteSociale;
  }
  
  public void setPlafondJournalierSecuriteSociale(BigDecimal p_plafondJournalierSecuriteSociale)
  {
    m_plafondJournalierSecuriteSociale = p_plafondJournalierSecuriteSociale;
  }
  
  public boolean estNouveauPlafondMensuelSecuriteSociale()
  {
    return m_nouveauPlafondMensuelSecuriteSociale;
  }
  
  public void setNouveauPlafondMensuelSecuriteSociale(boolean p_nouveauPlafondMensuelSecuriteSociale)
  {
    m_nouveauPlafondMensuelSecuriteSociale = p_nouveauPlafondMensuelSecuriteSociale;
  }
  
  public BigDecimal getPlafondMensuelSecuriteSociale()
  {
    return m_plafondMensuelSecuriteSociale;
  }
  
  public void setPlafondMensuelSecuriteSociale(BigDecimal p_plafondMensuelSecuriteSociale)
  {
    m_plafondMensuelSecuriteSociale = p_plafondMensuelSecuriteSociale;
  }
}

/* Location:
 * Qualified Name:     EvenementParametre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */