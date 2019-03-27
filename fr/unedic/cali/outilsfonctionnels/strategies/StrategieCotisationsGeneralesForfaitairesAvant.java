package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.calcul.dom.periode.ActionFormation;
import java.math.BigDecimal;

public class StrategieCotisationsGeneralesForfaitairesAvant
  implements StrategieCotisationsGeneralesForfaitairesSpec
{
  public BigDecimal determinerNombreJourFormation(ActionFormation p_actionFormation)
  {
    BigDecimal nbJour = null;
    nbJour = new BigDecimal(p_actionFormation.getDuree());
    
    return nbJour;
  }
}

/* Location:
 * Qualified Name:     StrategieCotisationsGeneralesForfaitairesAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */