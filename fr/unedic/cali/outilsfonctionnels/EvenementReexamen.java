package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.util.temps.Damj;

public class EvenementReexamen
{
  private String typeReexamen;
  private Damj dateReexamen;
  private Damj dateNotification;
  private boolean executionSuiteInstallationDemande;
  
  public EvenementReexamen(Damj dateEvenement, String typeReexamen)
  {
    this.typeReexamen = typeReexamen;
    dateReexamen = dateEvenement;
  }
  
  public Damj getDateReexamen()
  {
    return dateReexamen;
  }
  
  public void setDateReexamen(Damj dateReexamen)
  {
    this.dateReexamen = dateReexamen;
  }
  
  public String getTypeReexamen()
  {
    return typeReexamen;
  }
  
  public void setTypeReexamen(String typeReexamen)
  {
    this.typeReexamen = typeReexamen;
  }
  
  public String toString()
  {
    StringBuffer chaine = new StringBuffer();
    chaine.append("Evenement réexamen: \n");
    chaine.append("\t Type evenement : " + getTypeReexamen() + "\n");
    chaine.append("\t Date evenement : " + getDateReexamen() + "\n");
    return chaine.toString();
  }
  
  public Damj getDateNotification()
  {
    return dateNotification;
  }
  
  public void setDateNotification(Damj p_dateNotification)
  {
    dateNotification = p_dateNotification;
  }
  
  public boolean isExecutionSuiteInstallationDemande()
  {
    return executionSuiteInstallationDemande;
  }
  
  public void setExecutionSuiteInstallationDemande(boolean executionSuiteInstallationDemande)
  {
    this.executionSuiteInstallationDemande = executionSuiteInstallationDemande;
  }
}

/* Location:
 * Qualified Name:     EvenementReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */