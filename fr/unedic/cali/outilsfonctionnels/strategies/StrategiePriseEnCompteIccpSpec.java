package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.autresdoms.ga.dom.Salaire;
import fr.unedic.cali.autresdoms.ga.dom.TravailSalarie;
import java.math.BigDecimal;

public abstract interface StrategiePriseEnCompteIccpSpec
  extends StrategieEvolutionReglementaireSpec
{
  public abstract BigDecimal determinerMontantIccpALaFct(TravailSalarie paramTravailSalarie, Salaire paramSalaire);
  
  public abstract boolean paecACreerSurFctSiAbsenceSalaire();
}

/* Location:
 * Qualified Name:     StrategiePriseEnCompteIccpSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */