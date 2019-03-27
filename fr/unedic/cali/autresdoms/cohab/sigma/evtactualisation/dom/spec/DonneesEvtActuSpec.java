package fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec;

public abstract interface DonneesEvtActuSpec
{
  public static final String TOP_MANDATEMENT_NON_MANDATE = " ";
  public static final String TOP_MANDATEMENT_MANDATE_PROVISOIRE = "P";
  public static final String TOP_MANDATEMENT_MANDATE_DEFINITIF = "D";
  
  public abstract String getTopMandatement();
  
  public abstract void setTopMandatement(String paramString);
  
  public abstract String getTopCoherenceTravailA8A10();
  
  public abstract void setTopCoherenceTravailA8A10(String paramString);
  
  public abstract int getAnnee();
  
  public abstract void setAnnee(int paramInt);
  
  public abstract int getMois();
  
  public abstract void setMois(int paramInt);
}

/* Location:
 * Qualified Name:     DonneesEvtActuSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */