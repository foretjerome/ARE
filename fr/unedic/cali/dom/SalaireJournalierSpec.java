package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract interface SalaireJournalierSpec
{
  public abstract Damj getDateDepart();
  
  public abstract BigDecimal getSalaire();
  
  public abstract void setDateDepart(Damj paramDamj);
  
  public abstract void setSalaire(BigDecimal paramBigDecimal);
  
  public abstract boolean estRevalorise();
  
  public abstract void setRevalorise(boolean paramBoolean);
  
  public abstract String getContexteParticulier();
  
  public abstract void setContexteParticulier(String paramString);
}

/* Location:
 * Qualified Name:     SalaireJournalierSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */