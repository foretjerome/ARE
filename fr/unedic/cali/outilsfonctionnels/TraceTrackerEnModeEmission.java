package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.services.Abonnement;
import fr.unedic.util.services.ContexteServiceSpec;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;

public class TraceTrackerEnModeEmission
{
  private String idTracker;
  private String codeDestinataire;
  private String codeFlux;
  private ContexteServiceSpec contexteService;
  private Damj dateDebut;
  private Collection listeActiviteReduite;
  private Abonnement abonnement;
  private String casUtilisationEcrireEvementAsynchrone;
  private Collection listeRsodAttributionFrontaliere;
  private String codeTransaction;
  private String referenceExterne;
  private String idPeriodeGaec;
  private String codeAttente;
  private Damj dateEvenementDesengagementAide;
  private String casUtilisationEvenementDesengagementAide;
  
  public TraceTrackerEnModeEmission() {}
  
  public String getCodeTransaction()
  {
    return codeTransaction;
  }
  
  public void setCodeTransaction(String pCodeTransaction)
  {
    codeTransaction = pCodeTransaction;
  }
  
  public TraceTrackerEnModeEmission(String pIdTracker, String pCodeDestinataire, String pCodeFlux, ContexteServiceSpec pContexteService, Damj pDateDebut, Collection pListeActiviteReduite, Abonnement pAbonnement, String pCasUtilisationEcrireEvementAsynchrone)
  {
    idTracker = pIdTracker;
    codeDestinataire = pCodeDestinataire;
    codeFlux = pCodeFlux;
    contexteService = pContexteService;
    dateDebut = pDateDebut;
    listeActiviteReduite = pListeActiviteReduite;
    casUtilisationEcrireEvementAsynchrone = pCasUtilisationEcrireEvementAsynchrone;
    abonnement = pAbonnement;
  }
  
  public boolean equals(Object pTraceTrackerEnModeEmission)
  {
    boolean retour = false;
    if ((pTraceTrackerEnModeEmission instanceof TraceTrackerEnModeEmission))
    {
      TraceTrackerEnModeEmission traceTrackerEnModeEmission = (TraceTrackerEnModeEmission)pTraceTrackerEnModeEmission;
      if (getIdTracker().equalsIgnoreCase(traceTrackerEnModeEmission.getIdTracker())) {
        retour = true;
      }
    }
    return retour;
  }
  
  public String getCodeDestinataire()
  {
    return codeDestinataire;
  }
  
  public void setCodeDestinataire(String pCodeDestinataire)
  {
    codeDestinataire = pCodeDestinataire;
  }
  
  public Damj getDateDebut()
  {
    return dateDebut;
  }
  
  public void setDateDebut(Damj pDateDebut)
  {
    dateDebut = pDateDebut;
  }
  
  public String getIdTracker()
  {
    return idTracker;
  }
  
  public void setIdTracker(String pIdTracker)
  {
    idTracker = pIdTracker;
  }
  
  public String getCodeFlux()
  {
    return codeFlux;
  }
  
  public void setCodeFlux(String pCodeFlux)
  {
    codeFlux = pCodeFlux;
  }
  
  public ContexteServiceSpec getContexteService()
  {
    return contexteService;
  }
  
  public void setContexteService(ContexteServiceSpec pContexteService)
  {
    contexteService = pContexteService;
  }
  
  public Collection getListeActiviteReduite()
  {
    if (listeActiviteReduite == null) {
      listeActiviteReduite = new ArrayList();
    }
    return listeActiviteReduite;
  }
  
  public void setListeActiviteReduite(Collection pListeActiviteReduite)
  {
    listeActiviteReduite = pListeActiviteReduite;
  }
  
  public Abonnement getAbonnement()
  {
    return abonnement;
  }
  
  public void setAbonnement(Abonnement pAbonnement)
  {
    abonnement = pAbonnement;
  }
  
  public String getCasUtilisationEcrireEvementAsynchrone()
  {
    return casUtilisationEcrireEvementAsynchrone;
  }
  
  public void setCasUtilisationEcrireEvementAsynchrone(String pCasUtilisationEcrireEvementAsynchrone)
  {
    casUtilisationEcrireEvementAsynchrone = pCasUtilisationEcrireEvementAsynchrone;
  }
  
  public Collection getListeRsodAttributionFrontaliere()
  {
    return listeRsodAttributionFrontaliere;
  }
  
  public void setListeRsodAttributionFrontaliere(Collection pListeRsodAttributionFrontaliere)
  {
    listeRsodAttributionFrontaliere = pListeRsodAttributionFrontaliere;
  }
  
  public String getReferenceExterne()
  {
    return referenceExterne;
  }
  
  public void setReferenceExterne(String referenceExterne)
  {
    this.referenceExterne = referenceExterne;
  }
  
  public String getIdPeriodeGaec()
  {
    return idPeriodeGaec;
  }
  
  public void setIdPeriodeGaec(String idPeriodeGaec)
  {
    this.idPeriodeGaec = idPeriodeGaec;
  }
  
  public String getCodeAttente()
  {
    return codeAttente;
  }
  
  public void setCodeAttente(String codeAttente)
  {
    this.codeAttente = codeAttente;
  }
  
  public Damj getDateEvenementDesengagementAide()
  {
    return dateEvenementDesengagementAide;
  }
  
  public void setDateEvenementDesengagementAide(Damj dateEvenementDesengagementAide)
  {
    this.dateEvenementDesengagementAide = dateEvenementDesengagementAide;
  }
  
  public String getCasUtilisationEvenementDesengagementAide()
  {
    return casUtilisationEvenementDesengagementAide;
  }
  
  public void setCasUtilisationEvenementDesengagementAide(String casUtilisationEvenementDesengagementAide)
  {
    this.casUtilisationEvenementDesengagementAide = casUtilisationEvenementDesengagementAide;
  }
}

/* Location:
 * Qualified Name:     TraceTrackerEnModeEmission
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */