package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;

public class PeriodeAvecRevenu
  extends ObjetChronoPeriode
{
  private static final long serialVersionUID = -2314607900092218512L;
  private int m_typeRevenu;
  private BigDecimal m_montant;
  private int m_natureActivite;
  
  public PeriodeAvecRevenu(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public PeriodeAvecRevenu(Periode p_periode)
  {
    super(p_periode);
  }
  
  public PeriodeAvecRevenu(Damj p_dateDebut, Damj p_dateFin, BigDecimal p_montant, int p_typeRevenu)
  {
    super(p_dateDebut, p_dateFin);
    m_montant = p_montant;
    m_typeRevenu = p_typeRevenu;
  }
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
  
  public BigDecimal getMontant()
  {
    return m_montant;
  }
  
  public void setMontant(BigDecimal p_montant)
  {
    m_montant = p_montant;
  }
  
  public int getTypeRevenu()
  {
    return m_typeRevenu;
  }
  
  public void setTypeRevenu(int p_typeRevenu)
  {
    m_typeRevenu = p_typeRevenu;
  }
  
  public BigDecimal getNbMois()
  {
    BigDecimal nombreMois = new BigDecimal("0");
    ArrayList listePeriodesMoisCivils = getPeriode().decouperEnMoisCivils();
    for (int boucle = 0; boucle < listePeriodesMoisCivils.size(); boucle++)
    {
      Periode periodeMoisCivilCourant = (Periode)listePeriodesMoisCivils.get(boucle);
      if ((!periodeMoisCivilCourant.getDebut().estLeDebutDuMois()) || (!periodeMoisCivilCourant.getFin().estLaFinDuMois()))
      {
        BigDecimal joursActivite = new BigDecimal(periodeMoisCivilCourant.getDuree());
        BigDecimal joursMois = new BigDecimal(Damj.getNbJoursMois(periodeMoisCivilCourant.getDebut().getMois(), periodeMoisCivilCourant.getDebut().getAnnee()));
        
        nombreMois = nombreMois.add(joursActivite.divide(joursMois, 2, 4));
      }
      else
      {
        nombreMois = nombreMois.add(new BigDecimal(1));
      }
    }
    return nombreMois.max(new BigDecimal(1));
  }
  
  public Periode getPeriode()
  {
    return super.getPeriode();
  }
  
  public int getNatureActivite()
  {
    return m_natureActivite;
  }
  
  public void setNatureActivite(int p_natureActivite)
  {
    m_natureActivite = p_natureActivite;
  }
}

/* Location:
 * Qualified Name:     PeriodeAvecRevenu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */