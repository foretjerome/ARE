package fr.unedic.cali.dom.conteneurs;

import fr.unedic.cali.dom.conteneurs.spec.DonneesEntreeComplementairesDeterminationSjrSpec;
import fr.unedic.cali.util.OutilDomToString;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Periode;

public class DonneesEntreeComplementairesDeterminationSjr
  implements DonneesEntreeComplementairesDeterminationSjrSpec
{
  private Periode m_periodePrcInitiale;
  private Periode m_periodePrcBornee;
  private int m_typeBornagePrc;
  private Chronologie m_chronologieActiviteSalariePrc;
  private Chronologie m_chronologieActivitePourInappartenancePrc;
  private Chronologie m_chronologiePeriodeDeductiblePrc;
  
  public Periode getPeriodePrcBornee()
  {
    return m_periodePrcBornee;
  }
  
  public void setPeriodePrcBornee(Periode p_periodePrcBornee)
  {
    m_periodePrcBornee = p_periodePrcBornee;
  }
  
  public Periode getPeriodePrcInitiale()
  {
    return m_periodePrcInitiale;
  }
  
  public void setPeriodePrcInitiale(Periode p_periodePrcInitiale)
  {
    m_periodePrcInitiale = p_periodePrcInitiale;
  }
  
  public int getTypeBornagePrc()
  {
    return m_typeBornagePrc;
  }
  
  public void setTypeBornagePrc(int p_typeBornagePrc)
  {
    m_typeBornagePrc = p_typeBornagePrc;
  }
  
  public Chronologie getChronologieActivitePourInappartenancePrc()
  {
    return m_chronologieActivitePourInappartenancePrc;
  }
  
  public void setChronologieActivitePourInappartenancePrc(Chronologie p_chronologieActivitePourInappartenancePrc)
  {
    m_chronologieActivitePourInappartenancePrc = p_chronologieActivitePourInappartenancePrc;
  }
  
  public Chronologie getChronologieActiviteSalariePrc()
  {
    return m_chronologieActiviteSalariePrc;
  }
  
  public void setChronologieActiviteSalariePrc(Chronologie p_chronologieActiviteSalariePrc)
  {
    m_chronologieActiviteSalariePrc = p_chronologieActiviteSalariePrc;
  }
  
  public Chronologie getChronologiePeriodeDeductiblePrc()
  {
    return m_chronologiePeriodeDeductiblePrc;
  }
  
  public void setChronologiePeriodeDeductiblePrc(Chronologie p_chronologiePeriodeDeductiblePrc)
  {
    m_chronologiePeriodeDeductiblePrc = p_chronologiePeriodeDeductiblePrc;
  }
  
  public DonneesEntreeComplementairesDeterminationSjrSpec copier()
  {
    DonneesEntreeComplementairesDeterminationSjr copie = new DonneesEntreeComplementairesDeterminationSjr();
    if (getChronologieActivitePourInappartenancePrc() != null) {
      copie.setChronologieActivitePourInappartenancePrc(getChronologieActivitePourInappartenancePrc().copier());
    }
    if (getChronologieActiviteSalariePrc() != null) {
      copie.setChronologieActiviteSalariePrc(getChronologieActiviteSalariePrc().copier());
    }
    if (getChronologiePeriodeDeductiblePrc() != null) {
      copie.setChronologiePeriodeDeductiblePrc(getChronologiePeriodeDeductiblePrc().copier());
    }
    if (getPeriodePrcBornee() != null) {
      copie.setPeriodePrcBornee(new Periode(getPeriodePrcBornee().getDebut(), getPeriodePrcBornee().getFin()));
    }
    if (getPeriodePrcInitiale() != null) {
      copie.setPeriodePrcInitiale(new Periode(getPeriodePrcInitiale().getDebut(), getPeriodePrcInitiale().getFin()));
    }
    copie.setTypeBornagePrc(getTypeBornagePrc());
    
    return copie;
  }
  
  public String toString()
  {
    return OutilDomToString.toString(this);
  }
}

/* Location:
 * Qualified Name:     DonneesEntreeComplementairesDeterminationSjr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */