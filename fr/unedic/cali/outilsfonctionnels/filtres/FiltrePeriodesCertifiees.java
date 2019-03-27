package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.spec.CertifieSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodesCertifiees
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltrePeriodesCertifiees() {}
  
  public FiltrePeriodesCertifiees(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return super.getFiltreValorise(p_temporel.estType(CertifieSpec.class));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodesCertifiees
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */