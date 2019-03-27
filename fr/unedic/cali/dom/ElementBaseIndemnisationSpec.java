package fr.unedic.cali.dom;

import fr.unedic.cali.calcul.dom.periode.PeriodeAvantageVieillesse;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import java.math.BigDecimal;

public abstract interface ElementBaseIndemnisationSpec
  extends ObjetMetierSpec
{
  public abstract BigDecimal getSjrInitialForce();
  
  public abstract Damj getDateEntreeEnStage();
  
  public abstract boolean isClauseRattrapage();
  
  public abstract BigDecimal getCoefSaisonnierARE();
  
  public abstract BigDecimal getCoefTPARE();
  
  public abstract PeriodeAvantageVieillesse getPeriodeAvantageVieillesse();
  
  public abstract BigDecimal getMontantPeriodeInvalidite();
  
  public abstract BigDecimal getMontantPensionInvaliditeADeduire();
  
  public abstract DureeCalendaire getAgeFinMoisDateAttribution();
  
  public abstract BigDecimal getMontantPreavis();
  
  public abstract BigDecimal getCoefficientSaisonnier();
  
  public abstract int getTypeCaractereSaisonnierRetenu();
  
  public abstract boolean isConditionCaractereSaisonnierParRythme();
  
  public abstract BigDecimal getCoefficientTempsPartiel();
  
  public abstract SalaireJournalierSpec getSalaireJournalier();
  
  public abstract BigDecimal getMontantAvantageVieillesse();
  
  public abstract BigDecimal getCoefficientSanctionReduction();
  
  public abstract Damj getDateEffetAV();
  
  public abstract BigDecimal getCoefficientAvantageVieillesse();
  
  public abstract Damj getDateMaintienEuropeen();
  
  public abstract void setDateMaintienEuropeen(Damj paramDamj);
  
  public abstract Boolean getEstProduitGerantPensionInvalidite();
}

/* Location:
 * Qualified Name:     ElementBaseIndemnisationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */