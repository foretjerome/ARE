package fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.spec;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;

public abstract interface PeriodePriseEnChargeSpec
  extends Temporel
{
  public abstract Damj getDateDebut();
  
  public abstract Damj getDateFin();
  
  public abstract String getMotifAnnulation();
  
  public abstract void setMotifAnnulation(String paramString);
  
  public abstract String getCategorie();
  
  public abstract void setCategorie(String paramString);
  
  public abstract int getIdentifiantPec();
  
  public abstract void setIdentifiantPec(int paramInt);
  
  public abstract boolean isDispense();
  
  public abstract void setDispense(boolean paramBoolean);
  
  public abstract boolean isCes();
  
  public abstract void setCes(boolean paramBoolean);
  
  public abstract boolean isActualisable();
  
  public abstract void setActualisable(boolean paramBoolean);
  
  public abstract String getAleIndividu();
  
  public abstract void setAleIndividu(String paramString);
  
  public abstract Damj getDateDispense();
  
  public abstract void setDateDispense(Damj paramDamj);
  
  public abstract String getSousTypePec();
  
  public abstract void setSousTypePec(String paramString);
  
  public abstract String getTypePec();
  
  public abstract void setTypePec(String paramString);
  
  public abstract String getSituationEmploi();
  
  public abstract void setSituationEmploi(String paramString);
  
  public abstract String getCodeAuTitre();
  
  public abstract void setCodeAuTitre(String paramString);
  
  public abstract boolean getDemandeurEmploi();
  
  public abstract void setDemandeurEmploi(boolean paramBoolean);
  
  public abstract boolean getActualise();
  
  public abstract void setActualise(boolean paramBoolean);
  
  public abstract String getCodePays();
  
  public abstract void setCodePays(String paramString);
  
  public abstract void setContexteEESSI(String paramString);
  
  public abstract String getContexteEESSI();
  
  public abstract String getContextePECNonIndemnisable();
  
  public abstract void setContextePECNonIndemnisable(String paramString);
  
  public abstract String getNumeroAffiliation();
  
  public abstract void setNumeroAffiliation(String paramString);
  
  public abstract String getNumeroSiren();
  
  public abstract void setNumeroSiren(String paramString);
  
  public abstract String getIdentifiantBne();
  
  public abstract void setIdentifiantBne(String paramString);
}

/* Location:
 * Qualified Name:     PeriodePriseEnChargeSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */