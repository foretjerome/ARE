package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class PeriodePansAvecRevenu
  extends ObjetChronoPeriode
{
  public static int PERIODEDICITEMENSUEL = 1;
  public static int PERIODICITETRIMESTRIELLE = 2;
  private static final long serialVersionUID = -2314607900092218512L;
  private BigDecimal montant;
  private int natureActivite;
  private int natureRemuneration;
  private Damj dateEcheance;
  private int periodicite = PERIODEDICITEMENSUEL;
  
  public int getPeriodicite()
  {
    return periodicite;
  }
  
  public void setPeriodicite(int periodicite)
  {
    this.periodicite = periodicite;
  }
  
  public Damj getDateEcheance()
  {
    return dateEcheance;
  }
  
  public void setDateEcheance(Damj dateEcheance)
  {
    this.dateEcheance = dateEcheance;
  }
  
  public int getNatureRemuneration()
  {
    return natureRemuneration;
  }
  
  public void setNatureRemuneration(int natureRemuneration)
  {
    this.natureRemuneration = natureRemuneration;
  }
  
  public boolean estUneDeclarationMensuel()
  {
    return getPeriodicite() == PERIODEDICITEMENSUEL;
  }
  
  public boolean estUneDeclarationTrimestrielle()
  {
    return getPeriodicite() == PERIODICITETRIMESTRIELLE;
  }
  
  public PeriodePansAvecRevenu(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public PeriodePansAvecRevenu(Periode p_periode)
  {
    super(p_periode);
  }
  
  public PeriodePansAvecRevenu(Damj p_dateDebut, Damj p_dateFin, BigDecimal p_montant, int p_typeRevenu)
  {
    super(p_dateDebut, p_dateFin);
    montant = p_montant;
  }
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
  
  public BigDecimal getMontant()
  {
    return montant;
  }
  
  public void setMontant(BigDecimal p_montant)
  {
    montant = p_montant;
  }
  
  public Periode getPeriode()
  {
    return super.getPeriode();
  }
  
  public int getNatureActivite()
  {
    return natureActivite;
  }
  
  public void setNatureActivite(int p_natureActivite)
  {
    natureActivite = p_natureActivite;
  }
  
  public boolean estUnePeriodeEmploiJustifiableMensuellement()
  {
    return (getNatureRemuneration() == 2) || (getNatureRemuneration() == 5) || ((getNatureRemuneration() == 6) && (estUneDeclarationMensuel()));
  }
}

/* Location:
 * Qualified Name:     PeriodePansAvecRevenu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */