package fr.unedic.cali.dom;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;

public class DonneesEntreeDeterminationListePra
{
  private DemandeSpec demande;
  private ActiviteSalarie activiteSalarie;
  private boolean forcerReglementRecharge;
  private boolean utiliserParametreAffiRechargement;
  private DureeCalendaire ageIndividu;
  private Damj dateBornePRA;
  private int ordreTriListe;
  private Damj dateFgd;
  
  public DemandeSpec getDemande()
  {
    return demande;
  }
  
  public void setDemande(DemandeSpec demande)
  {
    this.demande = demande;
  }
  
  public ActiviteSalarie getActiviteSalarie()
  {
    return activiteSalarie;
  }
  
  public void setActiviteSalarie(ActiviteSalarie activiteSalarie)
  {
    this.activiteSalarie = activiteSalarie;
  }
  
  public DureeCalendaire getAgeIndividu()
  {
    return ageIndividu;
  }
  
  public void setAgeIndividu(DureeCalendaire ageIndividu)
  {
    this.ageIndividu = ageIndividu;
  }
  
  public Damj getDateBornePRA()
  {
    return dateBornePRA;
  }
  
  public void setDateBornePRA(Damj dateBornePRA)
  {
    this.dateBornePRA = dateBornePRA;
  }
  
  public int getOrdreTriListe()
  {
    return ordreTriListe;
  }
  
  public void setOrdreTriListe(int ordreTriListe)
  {
    this.ordreTriListe = ordreTriListe;
  }
  
  public boolean isForcerReglementRecharge()
  {
    return forcerReglementRecharge;
  }
  
  public void setForcerReglementRecharge(boolean forcerReglementRecharge)
  {
    this.forcerReglementRecharge = forcerReglementRecharge;
  }
  
  public boolean isUtiliserParametreAffiRechargement()
  {
    return utiliserParametreAffiRechargement;
  }
  
  public void setUtiliserParametreAffiRechargement(boolean utiliserParametreAffiRechargement)
  {
    this.utiliserParametreAffiRechargement = utiliserParametreAffiRechargement;
  }
  
  public Damj getDateFgd()
  {
    return dateFgd;
  }
  
  public void setDateFgd(Damj date)
  {
    dateFgd = date;
  }
}

/* Location:
 * Qualified Name:     DonneesEntreeDeterminationListePra
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */