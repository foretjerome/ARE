package fr.unedic.cali.autresdoms.cohab.dom.spec;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.util.QuantiteEuro;

public abstract interface PeriodeSousPensionInvaliditeChaineeSpec
  extends ObjetChronoPeriodeCalcul
{
  public abstract String getCodeNature();
  
  public abstract void setCodeNature(String paramString);
  
  public abstract QuantiteEuro getMontant();
  
  public abstract void setMontant(QuantiteEuro paramQuantiteEuro);
  
  public abstract String getEtat();
  
  public abstract void setEtat(String paramString);
}

/* Location:
 * Qualified Name:     PeriodeSousPensionInvaliditeChaineeSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */