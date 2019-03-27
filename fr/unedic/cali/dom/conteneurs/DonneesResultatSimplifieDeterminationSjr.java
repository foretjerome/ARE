package fr.unedic.cali.dom.conteneurs;

import fr.unedic.cali.dom.conteneurs.spec.DonneesResultatSimplifieDeterminationSjrSpec;
import fr.unedic.cali.util.OutilDomToString;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class DonneesResultatSimplifieDeterminationSjr
  extends DonneesResultatDeterminationSjrAbstrait
  implements DonneesResultatSimplifieDeterminationSjrSpec
{
  private Periode m_prip;
  private Integer m_dureePrc;
  private Integer m_nombreJourDeductible;
  private Integer m_nombreJourInappartenance;
  private BigDecimal m_srip;
  private BigDecimal m_sri;
  private BigDecimal m_diviseur;
  private BigDecimal m_nombreJourAbsence;
  private BigDecimal m_nombreHeuresTotal;
  private BigDecimal m_nombreJourTravailEffectif;
  private BigDecimal m_nombreHeuresA4ouA5;
  private BigDecimal m_droitCongesA4ouA5;
  private Chronologie m_chronoActiviteSalarieParticipantSr = new ChronologiePeriodes();
  private boolean m_estSripReduit;
  
  public BigDecimal getDiviseur()
  {
    return m_diviseur;
  }
  
  public void setDiviseur(BigDecimal p_diviseur)
  {
    m_diviseur = p_diviseur;
  }
  
  public BigDecimal getDroitCongesA4ouA5()
  {
    return m_droitCongesA4ouA5;
  }
  
  public void setDroitCongesA4ouA5(BigDecimal p_droitCongesA4ouA5)
  {
    m_droitCongesA4ouA5 = p_droitCongesA4ouA5;
  }
  
  public Integer getDureePrc()
  {
    return m_dureePrc;
  }
  
  public void setDureePrc(Integer p_dureePrc)
  {
    m_dureePrc = p_dureePrc;
  }
  
  public BigDecimal getNombreHeuresA4ouA5()
  {
    return m_nombreHeuresA4ouA5;
  }
  
  public void setNombreHeuresA4ouA5(BigDecimal p_nombreHeuresA4ouA5)
  {
    m_nombreHeuresA4ouA5 = p_nombreHeuresA4ouA5;
  }
  
  public BigDecimal getNombreHeuresTotal()
  {
    return m_nombreHeuresTotal;
  }
  
  public void setNombreHeuresTotal(BigDecimal p_nombreHeuresTotal)
  {
    m_nombreHeuresTotal = p_nombreHeuresTotal;
  }
  
  public BigDecimal getNombreJourAbsence()
  {
    return m_nombreJourAbsence;
  }
  
  public void setNombreJourAbsence(BigDecimal p_nombreJourAbsence)
  {
    m_nombreJourAbsence = p_nombreJourAbsence;
  }
  
  public Integer getNombreJourDeductible()
  {
    return m_nombreJourDeductible;
  }
  
  public void setNombreJourDeductible(Integer p_nombreJourDeductible)
  {
    m_nombreJourDeductible = p_nombreJourDeductible;
  }
  
  public Integer getNombreJourInappartenance()
  {
    return m_nombreJourInappartenance;
  }
  
  public void setNombreJourInappartenance(Integer p_nombreJourInappartenance)
  {
    m_nombreJourInappartenance = p_nombreJourInappartenance;
  }
  
  public BigDecimal getNombreJourTravailEffectif()
  {
    return m_nombreJourTravailEffectif;
  }
  
  public void setNombreJourTravailEffectif(BigDecimal p_nombreJourTravailEffectif)
  {
    m_nombreJourTravailEffectif = p_nombreJourTravailEffectif;
  }
  
  public Periode getPrip()
  {
    return m_prip;
  }
  
  public void setPrip(Periode p_prip)
  {
    m_prip = p_prip;
  }
  
  public BigDecimal getSrip()
  {
    return m_srip;
  }
  
  public void setSrip(BigDecimal p_srip)
  {
    m_srip = p_srip;
  }
  
  public BigDecimal getSri()
  {
    return m_sri;
  }
  
  public void setSri(BigDecimal p_sri)
  {
    m_sri = p_sri;
  }
  
  public Chronologie getChronoActiviteSalarieParticipantSr()
  {
    return m_chronoActiviteSalarieParticipantSr;
  }
  
  public void setChronoActiviteSalarieParticipantSr(Chronologie p_chronoActiviteSalarieParticipantSr)
  {
    m_chronoActiviteSalarieParticipantSr = p_chronoActiviteSalarieParticipantSr;
  }
  
  public boolean estSripReduit()
  {
    return m_estSripReduit;
  }
  
  public void setEstSripReduit(boolean p_estSripReduit)
  {
    m_estSripReduit = p_estSripReduit;
  }
  
  public String toString()
  {
    return OutilDomToString.toString(this);
  }
}

/* Location:
 * Qualified Name:     DonneesResultatSimplifieDeterminationSjr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */