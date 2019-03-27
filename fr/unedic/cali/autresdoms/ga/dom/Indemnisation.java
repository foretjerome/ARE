package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class Indemnisation
  extends Periode
{
  private static final long serialVersionUID = -4722050972169426811L;
  private BigDecimal montantIndemnisation;
  private boolean estIndemnise;
  
  public Indemnisation(Periode periode)
  {
    super(periode.getDebut(), periode.getFin());
  }
  
  public Indemnisation(Damj debut, Damj fin)
  {
    super(debut, fin);
  }
  
  public BigDecimal getMontantIndemnisation()
  {
    return montantIndemnisation;
  }
  
  public void setMontantIndemnisation(BigDecimal montant)
  {
    montantIndemnisation = montant;
  }
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
  
  public void copieElements(ObjetMetierSpec copie) {}
  
  public boolean isEstIndemnise()
  {
    return estIndemnise;
  }
  
  public void setEstIndemnise(boolean estIndemnise)
  {
    this.estIndemnise = estIndemnise;
  }
}

/* Location:
 * Qualified Name:     Indemnisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */