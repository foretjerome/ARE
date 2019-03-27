package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.calcul.dom.periode.ActionFormation;
import fr.unedic.util.Quantite;
import java.math.BigDecimal;

public class StrategieCotisationsGeneralesForfaitairesApres
  implements StrategieCotisationsGeneralesForfaitairesSpec
{
  public BigDecimal determinerNombreJourFormation(ActionFormation p_actionFormation)
  {
    BigDecimal nbJour = null;
    nbJour = p_actionFormation.getNbJourPeriodeFormation().getValeur();
    
    return nbJour;
  }
}

/* Location:
 * Qualified Name:     StrategieCotisationsGeneralesForfaitairesApres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */