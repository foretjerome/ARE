package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodesQualifiables
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltrePeriodesQualifiables() {}
  
  public FiltrePeriodesQualifiables(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return super.getFiltreValorise((p_temporel.estType(ActiviteSalarie.class)) && (((ActiviteSalarie)p_temporel).estQualifiable()));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodesQualifiables
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */