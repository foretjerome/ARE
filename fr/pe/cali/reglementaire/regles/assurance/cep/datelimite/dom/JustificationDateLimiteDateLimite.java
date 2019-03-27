package fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.dom;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import java.math.BigDecimal;

public class JustificationDateLimiteDateLimite
{
  private Damj datePointDepart;
  private DureeCalendaire dureeUtilisee;
  private BigDecimal dureeImputeeSuiteArce;
  private String contexteDateLimite;
  
  public Damj getDatePointDepart()
  {
    return datePointDepart;
  }
  
  public void setDatePointDepart(Damj datePointDepart)
  {
    this.datePointDepart = datePointDepart;
  }
  
  public DureeCalendaire getDureeUtilisee()
  {
    return dureeUtilisee;
  }
  
  public void setDureeUtilisee(DureeCalendaire dureeUtilisee)
  {
    this.dureeUtilisee = dureeUtilisee;
  }
  
  public BigDecimal getDureeImputeeSuiteArce()
  {
    return dureeImputeeSuiteArce;
  }
  
  public void setDureeImputeeSuiteArce(BigDecimal dureeImputeeSuiteArce)
  {
    this.dureeImputeeSuiteArce = dureeImputeeSuiteArce;
  }
  
  public String getContexteDateLimite()
  {
    return contexteDateLimite;
  }
  
  public void setContexteDateLimite(String contexteDateLimite)
  {
    this.contexteDateLimite = contexteDateLimite;
  }
}

/* Location:
 * Qualified Name:     JustificationDateLimiteDateLimite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */