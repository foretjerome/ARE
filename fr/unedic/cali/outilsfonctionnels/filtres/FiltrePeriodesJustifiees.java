package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.spec.DeclareSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodesJustifiees
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltrePeriodesJustifiees() {}
  
  public FiltrePeriodesJustifiees(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(DeclareSpec.class)) && (super.getFiltreValorise(((DeclareSpec)p_temporel).estJustifie()));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodesJustifiees
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */