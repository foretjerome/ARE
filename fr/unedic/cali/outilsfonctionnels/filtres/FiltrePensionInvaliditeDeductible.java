package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.PeriodePensionInvalidite;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePensionInvaliditeDeductible
  implements FiltreTemporel
{
  private static final long serialVersionUID = -6620422907004876848L;
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(PeriodePensionInvalidite.class))
    {
      PeriodePensionInvalidite periodePension = (PeriodePensionInvalidite)p_temporel;
      boolean estDeNatureDeductible = ("INV2".equals(periodePension.getCodeNature())) || ("INV3".equals(periodePension.getCodeNature()));
      
      return estDeNatureDeductible;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltrePensionInvaliditeDeductible
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */