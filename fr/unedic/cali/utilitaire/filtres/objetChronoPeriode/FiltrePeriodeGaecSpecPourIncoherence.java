package fr.unedic.cali.utilitaire.filtres.objetChronoPeriode;

import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeGaecSpecPourIncoherence
  extends FiltreObjetChronoPeriodeAbstrait
{
  private static final long serialVersionUID = 1L;
  private String mIncoherence = new String();
  
  public FiltrePeriodeGaecSpecPourIncoherence(String pIncoherence)
  {
    super("");
    
    mIncoherence = pIncoherence;
    if (mIncoherence == null) {
      mIncoherence = new String();
    }
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    PeriodeGaecSpec periodeGaec = (PeriodeGaecSpec)p_temporel;
    if ((periodeGaec.getIncoherencePeriode() != null) && (periodeGaec.getIncoherencePeriode().equals(mIncoherence))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeGaecSpecPourIncoherence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */