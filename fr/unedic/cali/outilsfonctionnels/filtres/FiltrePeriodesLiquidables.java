package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodesLiquidables
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltrePeriodesLiquidables() {}
  
  public FiltrePeriodesLiquidables(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(TravailSpec.class)) && (super.getFiltreValorise(((TravailSpec)p_temporel).estParticipantLiquidation()));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodesLiquidables
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */