package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;

public class ResultatDonneesIndividu
  extends Resultat
{
  private static final long serialVersionUID = 7444217908443016314L;
  private boolean estAppelGaecTotal;
  private int attributionsAfdFiliereCourte;
  private int attributionsAfdFiliereIntermediaire;
  private int attributionsAfdFiliereLongue;
  private Damj dernierJourIndemnisableAreSpe;
  private String codeTransaction;
  private String domaineSourceFlux;
  private Damj dateExecutionDifferee;
  private boolean estArretReexecution;
  private boolean forcerExecutionDiffere;
  private boolean estDesactivationEfe;
  
  public boolean isEstAppelGaecTotal()
  {
    return estAppelGaecTotal;
  }
  
  public void setEstAppelGaecTotal(boolean pEstAppelGaecTotal)
  {
    estAppelGaecTotal = pEstAppelGaecTotal;
  }
  
  public int getAttributionsAfdFiliereCourte()
  {
    return attributionsAfdFiliereCourte;
  }
  
  public void setAttributionsAfdFiliereCourte(int pAttributionsAfdFiliereCourte)
  {
    attributionsAfdFiliereCourte = pAttributionsAfdFiliereCourte;
  }
  
  public int getAttributionsAfdFiliereIntermediaire()
  {
    return attributionsAfdFiliereIntermediaire;
  }
  
  public void setAttributionsAfdFiliereIntermediaire(int pAttributionsAfdFiliereIntermediaire)
  {
    attributionsAfdFiliereIntermediaire = pAttributionsAfdFiliereIntermediaire;
  }
  
  public int getAttributionsAfdFiliereLongue()
  {
    return attributionsAfdFiliereLongue;
  }
  
  public void setAttributionsAfdFiliereLongue(int pAttributionsAfdFiliereLongue)
  {
    attributionsAfdFiliereLongue = pAttributionsAfdFiliereLongue;
  }
  
  public Damj getDernierJourIndemnisableAreSpe()
  {
    return dernierJourIndemnisableAreSpe;
  }
  
  public void setDernierJourIndemnisableAreSpe(Damj pDernierJourIndemnisableAreSpe)
  {
    dernierJourIndemnisableAreSpe = pDernierJourIndemnisableAreSpe;
  }
  
  public String getCodeTransaction()
  {
    return codeTransaction;
  }
  
  public void setCodeTransaction(String pCodeTransaction)
  {
    codeTransaction = pCodeTransaction;
  }
  
  public String getDomaineSourceFlux()
  {
    return domaineSourceFlux;
  }
  
  public void setDomaineSourceFlux(String pSourceDomaineFlux)
  {
    domaineSourceFlux = pSourceDomaineFlux;
  }
  
  public Damj getDateExecutionDifferee()
  {
    return dateExecutionDifferee;
  }
  
  public void setDateExecutionDifferee(Damj pDateExecutionDifferee)
  {
    dateExecutionDifferee = pDateExecutionDifferee;
  }
  
  public void setEstArretReexecution(boolean estArretReexecution)
  {
    this.estArretReexecution = estArretReexecution;
  }
  
  public boolean isEstArretReexecution()
  {
    return estArretReexecution;
  }
  
  public void setForcerExecutionDiffere(boolean forcerExecutionDiffere)
  {
    this.forcerExecutionDiffere = forcerExecutionDiffere;
  }
  
  public boolean isForcerExecutionDiffere()
  {
    return forcerExecutionDiffere;
  }
  
  public void setEstDesactivationEfe(boolean estDesactivationEfe)
  {
    this.estDesactivationEfe = estDesactivationEfe;
  }
  
  public boolean isEstDesactivationEfe()
  {
    return estDesactivationEfe;
  }
}

/* Location:
 * Qualified Name:     ResultatDonneesIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */