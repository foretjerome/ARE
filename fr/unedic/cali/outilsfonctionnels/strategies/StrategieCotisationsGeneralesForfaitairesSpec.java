package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.calcul.dom.periode.ActionFormation;
import java.math.BigDecimal;

public abstract interface StrategieCotisationsGeneralesForfaitairesSpec
  extends StrategieEvolutionReglementaireSpec
{
  public abstract BigDecimal determinerNombreJourFormation(ActionFormation paramActionFormation);
}

/* Location:
 * Qualified Name:     StrategieCotisationsGeneralesForfaitairesSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */