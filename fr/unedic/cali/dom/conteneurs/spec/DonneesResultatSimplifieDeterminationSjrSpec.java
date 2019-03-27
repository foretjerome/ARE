package fr.unedic.cali.dom.conteneurs.spec;

import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public abstract interface DonneesResultatSimplifieDeterminationSjrSpec
  extends DonneesResultatDeterminationSjrSpec
{
  public abstract BigDecimal getDiviseur();
  
  public abstract void setDiviseur(BigDecimal paramBigDecimal);
  
  public abstract BigDecimal getDroitCongesA4ouA5();
  
  public abstract void setDroitCongesA4ouA5(BigDecimal paramBigDecimal);
  
  public abstract Integer getDureePrc();
  
  public abstract void setDureePrc(Integer paramInteger);
  
  public abstract BigDecimal getNombreHeuresA4ouA5();
  
  public abstract void setNombreHeuresA4ouA5(BigDecimal paramBigDecimal);
  
  public abstract BigDecimal getNombreHeuresTotal();
  
  public abstract void setNombreHeuresTotal(BigDecimal paramBigDecimal);
  
  public abstract BigDecimal getNombreJourAbsence();
  
  public abstract void setNombreJourAbsence(BigDecimal paramBigDecimal);
  
  public abstract Integer getNombreJourDeductible();
  
  public abstract void setNombreJourDeductible(Integer paramInteger);
  
  public abstract Integer getNombreJourInappartenance();
  
  public abstract void setNombreJourInappartenance(Integer paramInteger);
  
  public abstract BigDecimal getNombreJourTravailEffectif();
  
  public abstract void setNombreJourTravailEffectif(BigDecimal paramBigDecimal);
  
  public abstract Periode getPrip();
  
  public abstract void setPrip(Periode paramPeriode);
  
  public abstract BigDecimal getSrip();
  
  public abstract void setSrip(BigDecimal paramBigDecimal);
  
  public abstract BigDecimal getSri();
  
  public abstract void setSri(BigDecimal paramBigDecimal);
  
  public abstract Chronologie getChronoActiviteSalarieParticipantSr();
  
  public abstract void setChronoActiviteSalarieParticipantSr(Chronologie paramChronologie);
  
  public abstract boolean estSripReduit();
  
  public abstract void setEstSripReduit(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     DonneesResultatSimplifieDeterminationSjrSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */