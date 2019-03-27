package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class PeriodeTravailTransient
  extends ObjetChronoPeriodeCalculTransient
  implements PeriodeTravail
{
  private transient BigDecimal gain;
  private transient BigDecimal nombreHeures;
  private transient BigDecimal nombreHeuresDeCompletude;
  private transient boolean estMigree;
  private transient String identifiant;
  private transient BigDecimal montantBrutAutreRemuneration;
  
  public BigDecimal getMontantBrutAutreRemuneration()
  {
    return montantBrutAutreRemuneration;
  }
  
  public void setMontantBrutAutreRemuneration(BigDecimal montantBrutAutreRemuneration)
  {
    this.montantBrutAutreRemuneration = montantBrutAutreRemuneration;
  }
  
  protected PeriodeTravailTransient()
  {
    gain = BigDecimal.ZERO;
    nombreHeures = BigDecimal.ZERO;
  }
  
  public PeriodeTravailTransient(Damj dateDebut, Damj dateFin)
  {
    super(dateDebut, dateFin);
    gain = BigDecimal.ZERO;
    nombreHeures = BigDecimal.ZERO;
  }
  
  public BigDecimal getGain()
  {
    return gain;
  }
  
  public void setGain(BigDecimal gain)
  {
    this.gain = gain;
  }
  
  public BigDecimal getNombreHeures()
  {
    return nombreHeures;
  }
  
  public void setNombreHeures(BigDecimal nombreHeures)
  {
    this.nombreHeures = nombreHeures;
  }
  
  public BigDecimal getNombreHeuresDeCompletude()
  {
    return nombreHeuresDeCompletude;
  }
  
  public void setNombreHeuresDeCompletude(BigDecimal nombreHeuresDeCompletude)
  {
    this.nombreHeuresDeCompletude = nombreHeuresDeCompletude;
  }
  
  public boolean estMigree()
  {
    return estMigree;
  }
  
  public void setEstMigree(boolean migree)
  {
    estMigree = migree;
  }
  
  public void copieElements(ObjetMetierSpec copieOM)
  {
    PeriodeTravail copie = (PeriodeTravail)copieOM;
    
    super.copieElements(copie);
    
    copie.setGain(getGain());
    copie.setNombreHeures(getNombreHeures());
    copie.setNombreHeuresDeCompletude(getNombreHeuresDeCompletude());
    copie.setIdentifiant(getIdentifiant());
  }
  
  public String getIdentifiant()
  {
    return identifiant;
  }
  
  public void setIdentifiant(String identifiant)
  {
    this.identifiant = identifiant;
  }
}

/* Location:
 * Qualified Name:     PeriodeTravailTransient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */