package fr.unedic.cali.dom.pnds;

import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;

public class PeriodeNonDeclareeSanction
{
  private PeriodeGaecSpec m_periodeActivite;
  private ChronologiePeriodes m_chronoPeriodePNDS;
  
  public static PeriodeNonDeclareeSanction creerInstance()
  {
    return new PeriodeNonDeclareeSanction();
  }
  
  public static PeriodeNonDeclareeSanction creerInstance(ChronologiePeriodes p_chronologiePeriode)
  {
    return new PeriodeNonDeclareeSanction(p_chronologiePeriode);
  }
  
  private PeriodeNonDeclareeSanction()
  {
    m_chronoPeriodePNDS = new ChronologiePeriodes();
  }
  
  private PeriodeNonDeclareeSanction(ChronologiePeriodes p_chronologiePeriode)
  {
    m_chronoPeriodePNDS = p_chronologiePeriode;
  }
  
  public ChronologiePeriodes getChronoPeriodePNDS()
  {
    return m_chronoPeriodePNDS;
  }
  
  public void ajouterPeriodePNDS(Temporel p_periode)
  {
    getChronoPeriodePNDS().ajouter(p_periode);
  }
  
  public void ajouterChronologiePeriode(ChronologiePeriodes p_chronologie)
  {
    getChronoPeriodePNDS().ajouter(p_chronologie);
  }
  
  public PeriodeGaecSpec getPeriodeActivite()
  {
    return m_periodeActivite;
  }
  
  public void setPeriodeActivite(PeriodeGaecSpec p_periodeActivite)
  {
    m_periodeActivite = p_periodeActivite;
  }
  
  public Damj getDateDebut()
  {
    if ((getChronoPeriodePNDS() != null) && (!getChronoPeriodePNDS().estVide()))
    {
      getChronoPeriodePNDS().iterer();
      return getChronoPeriodePNDS().premierElement().getDateDebut();
    }
    return null;
  }
  
  public Damj getDateFin()
  {
    if ((getChronoPeriodePNDS() != null) && (!getChronoPeriodePNDS().estVide()))
    {
      getChronoPeriodePNDS().iterer();
      return getChronoPeriodePNDS().dernierElement().getDateFin();
    }
    return null;
  }
  
  public void fusionnerChevauchementPeriode()
  {
    if ((m_chronoPeriodePNDS != null) && (!m_chronoPeriodePNDS.estVide())) {
      m_chronoPeriodePNDS = m_chronoPeriodePNDS.fusionnerChevauchementPeriodes();
    }
  }
  
  public String toString()
  {
    String message = "PNDS pour l'activité " + m_periodeActivite;
    message = message + " Périodes déterminées : {";
    
    getChronoPeriodePNDS().iterer();
    while (getChronoPeriodePNDS().encoreSuivant())
    {
      Temporel periode = getChronoPeriodePNDS().elementSuivant();
      message = message + periode;
    }
    message = message + "}";
    
    return message;
  }
}

/* Location:
 * Qualified Name:     PeriodeNonDeclareeSanction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */