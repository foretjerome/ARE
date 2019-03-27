package fr.unedic.cali.autresdoms.ga.dom.spec;

import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;

public abstract interface RemunerationSpec
  extends Temporel
{
  public static final int NATURE_REMUNERATION_SALAIRE = 1;
  public static final int NATURE_REMUNERATION_PRIME_A_PERIODICITE = 2;
  public static final int NATURE_REMUNERATION_PRIME_EXCEPTIONNELLE = 3;
  public static final int NATURE_REMUNERATION_INCONNUE = 4;
  public static final int NATURE_REMUNERATION_REPOS_COMPENSATEUR = 5;
  
  public abstract Damj getDatePaie();
  
  public abstract QuantiteEuro getMontantBrutBase();
  
  public abstract QuantiteEuro getMontantSoumisAContribution();
  
  public abstract BigDecimal getTauxAbattementFraisProfessionnel();
  
  public abstract void setDatePaie(Damj paramDamj);
  
  public abstract void setMontantBrutBase(QuantiteEuro paramQuantiteEuro);
  
  public abstract void setMontantSoumisAContribution(QuantiteEuro paramQuantiteEuro);
  
  public abstract void setTauxAbattementFraisProfessionnel(BigDecimal paramBigDecimal);
}

/* Location:
 * Qualified Name:     RemunerationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */