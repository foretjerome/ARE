package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculCREM;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class PeriodeTravailCREM
  extends ObjetChronoPeriodeCalculCREM
  implements PeriodeTravail
{
  private transient BigDecimal gain;
  private transient BigDecimal nombreHeures;
  private transient BigDecimal nombreHeuresDeCompletude;
  private transient BigDecimal cachets;
  private transient boolean estMigree;
  private transient String identifiant;
  
  protected PeriodeTravailCREM()
  {
    gain = BigDecimal.ZERO;
    nombreHeures = BigDecimal.ZERO;
    cachets = BigDecimal.ZERO;
  }
  
  protected PeriodeTravailCREM(DomPCSpec pc)
  {
    super(pc);
    gain = BigDecimal.ZERO;
    nombreHeures = BigDecimal.ZERO;
    cachets = BigDecimal.ZERO;
  }
  
  public PeriodeTravailCREM(Damj dateDebut, Damj dateFin)
  {
    super(dateDebut, dateFin);
    gain = BigDecimal.ZERO;
    nombreHeures = BigDecimal.ZERO;
    cachets = BigDecimal.ZERO;
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
  
  public BigDecimal getCachets()
  {
    return cachets;
  }
  
  public void setCachets(BigDecimal cachets)
  {
    this.cachets = cachets;
  }
  
  public void copieElements(ObjetMetierSpec copieOM)
  {
    PeriodeTravailCREM copie = (PeriodeTravailCREM)copieOM;
    
    super.copieElements(copie);
    
    gain = getGain();
    nombreHeures = getNombreHeures();
    cachets = getCachets();
  }
  
  public boolean estMigree()
  {
    return estMigree;
  }
  
  public void setEstMigree(boolean estMigree)
  {
    this.estMigree = estMigree;
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
 * Qualified Name:     PeriodeTravailCREM
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */