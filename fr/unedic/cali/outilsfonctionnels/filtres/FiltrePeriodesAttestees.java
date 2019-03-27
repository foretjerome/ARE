package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.spec.CertifieSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodesAttestees
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltrePeriodesAttestees() {}
  
  public FiltrePeriodesAttestees(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(CertifieSpec.class)) && (super.getFiltreValorise(((CertifieSpec)p_temporel).estAtteste()));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodesAttestees
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */