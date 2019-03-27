package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class PeriodeIntensite
  extends ObjetChronoPeriode
{
  private static final long serialVersionUID = -3629402287392207042L;
  public static final BigDecimal TRENTE_CINQ_HEURES = new BigDecimal(35);
  public static final int UNITE_HEBDOMADAIRE = 1;
  public static final int UNITE_ANNUEL = 2;
  public static final int UNITE_MENSUEL = 3;
  private int m_uniteHoraire;
  private BigDecimal m_horairesEntreprise;
  private BigDecimal m_horairesSalarie;
  
  public PeriodeIntensite(Periode p_periode)
  {
    super(p_periode.getDebut(), p_periode.getFin());
  }
  
  public int getUniteHoraire()
  {
    return m_uniteHoraire;
  }
  
  public void setUniteHoraire(int p_uniteHoraire)
  {
    m_uniteHoraire = p_uniteHoraire;
  }
  
  public BigDecimal getHorairesEntreprise()
  {
    return m_horairesEntreprise;
  }
  
  public void setHorairesEntreprise(BigDecimal p_horaires)
  {
    m_horairesEntreprise = p_horaires;
  }
  
  public BigDecimal getHorairesSalarie()
  {
    return m_horairesSalarie;
  }
  
  public void setHorairesSalarie(BigDecimal p_horaires)
  {
    m_horairesSalarie = p_horaires;
  }
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     PeriodeIntensite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */