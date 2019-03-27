package fr.pe.cali.crem.dom.impl;

import fr.pe.cali.crem.dom.spec.IDonneesFonctionnellesCrem;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="donneesFonctionnelles")
@XmlType(propOrder={"cxass", "cxala", "identifiantObjetMetier", "identifiantFonctionnelDemande", "dateExamen", "codeProduit", "classementAdministratif", "natureDecision", "dateFaitGenerateur", "dateAttribution", "identifiantDemandeCali", "dateTheoriqueFinDroit", "identifiantOuvertureDroit", "identifiantReprise", "premierJourIndemnisableTheorique", "salaireJournalierReference", "salaireJournalierConserve", "reglementApplicable", "codeMetier", "idOMPere", "typeLiquidation", "motifRejet", "dateFctRetenue", "motifIneligibilite", "etatDecision", "notificationCourrier", "datePremiereValidation", "dateDerniereValidation"})
public class DonneesFonctionnellesDecisionLiquidation
  implements IDonneesFonctionnellesCrem
{
  private String cxass;
  private String cxala;
  private String identifiantObjetMetier;
  private String identifiantFonctionnelDemande;
  private String dateExamen;
  private String codeProduit;
  private String classementAdministratif;
  private String natureDecision;
  private String dateFaitGenerateur;
  private String dateAttribution;
  private String identifiantDemandeCali;
  private String dateTheoriqueFinDroit;
  private String identifiantOuvertureDroit;
  private String identifiantReprise;
  private String premierJourIndemnisableTheorique;
  private String salaireJournalierReference;
  private String salaireJournalierConserve;
  private String reglementApplicable;
  private String codeMetier;
  private String idOMPere;
  private String typeLiquidation;
  private String motifRejet;
  private String dateFctRetenue;
  private String motifIneligibilite;
  private String etatDecision;
  private String notificationCourrier;
  private String datePremiereValidation;
  private String dateDerniereValidation;
  
  public String genererXML()
  {
    String donneesFonctionnelles = null;
    try
    {
      JAXBContext context = JAXBContext.newInstance(new Class[] { DonneesFonctionnellesDecisionLiquidation.class });
      Marshaller m = context.createMarshaller();
      
      StringWriter writer = new StringWriter();
      m.marshal(this, writer);
      donneesFonctionnelles = writer.toString();
    }
    catch (JAXBException ex)
    {
      donneesFonctionnelles = "";
    }
    return donneesFonctionnelles;
  }
  
  @XmlElement(name="codePE")
  public String getCxass()
  {
    return cxass;
  }
  
  public void setCxass(String cxass)
  {
    this.cxass = cxass;
  }
  
  @XmlElement(name="cxalap")
  public String getCxala()
  {
    return cxala;
  }
  
  public void setCxala(String cxala)
  {
    this.cxala = cxala;
  }
  
  @XmlElement(name="identifiantObjetMetier")
  public String getIdentifiantObjetMetier()
  {
    return identifiantObjetMetier;
  }
  
  public void setIdentifiantObjetMetier(String identifiantObjetMetier)
  {
    this.identifiantObjetMetier = identifiantObjetMetier;
  }
  
  @XmlElement(name="identifiantFonctionnelDemande")
  public String getIdentifiantFonctionnelDemande()
  {
    return identifiantFonctionnelDemande;
  }
  
  public void setIdentifiantFonctionnelDemande(String identifiantFonctionnelDemande)
  {
    this.identifiantFonctionnelDemande = identifiantFonctionnelDemande;
  }
  
  @XmlElement(name="dateExamen")
  public String getDateExamen()
  {
    return dateExamen;
  }
  
  public void setDateExamen(String dateExamen)
  {
    this.dateExamen = dateExamen;
  }
  
  @XmlElement(name="codeProduit")
  public String getCodeProduit()
  {
    return codeProduit;
  }
  
  public void setCodeProduit(String codeProduit)
  {
    this.codeProduit = codeProduit;
  }
  
  @XmlElement(name="classementAdministratif")
  public String getClassementAdministratif()
  {
    return classementAdministratif;
  }
  
  public void setClassementAdministratif(String classementAdministratif)
  {
    this.classementAdministratif = classementAdministratif;
  }
  
  @XmlElement(name="natureDecision")
  public String getNatureDecision()
  {
    return natureDecision;
  }
  
  public void setNatureDecision(String natureDecision)
  {
    this.natureDecision = natureDecision;
  }
  
  @XmlElement(name="dateFaitGenerateur")
  public String getDateFaitGenerateur()
  {
    return dateFaitGenerateur;
  }
  
  public void setDateFaitGenerateur(String dateFaitGenerateur)
  {
    this.dateFaitGenerateur = dateFaitGenerateur;
  }
  
  @XmlElement(name="dateAttribution")
  public String getDateAttribution()
  {
    return dateAttribution;
  }
  
  public void setDateAttribution(String dateAttribution)
  {
    this.dateAttribution = dateAttribution;
  }
  
  @XmlElement(name="identifiantDemandeCali")
  public String getIdentifiantDemandeCali()
  {
    return identifiantDemandeCali;
  }
  
  public void setIdentifiantDemandeCali(String identifiantDemandeCali)
  {
    this.identifiantDemandeCali = identifiantDemandeCali;
  }
  
  @XmlElement(name="dateTheoriqueFinDroit")
  public String getDateTheoriqueFinDroit()
  {
    return dateTheoriqueFinDroit;
  }
  
  public void setDateTheoriqueFinDroit(String dateTheoriqueFinDroit)
  {
    this.dateTheoriqueFinDroit = dateTheoriqueFinDroit;
  }
  
  @XmlElement(name="identifiantOuvertureDroit")
  public String getIdentifiantOuvertureDroit()
  {
    return identifiantOuvertureDroit;
  }
  
  public void setIdentifiantOuvertureDroit(String identifiantOuvertureDroit)
  {
    this.identifiantOuvertureDroit = identifiantOuvertureDroit;
  }
  
  @XmlElement(name="identifiantReprise")
  public String getIdentifiantReprise()
  {
    return identifiantReprise;
  }
  
  public void setIdentifiantReprise(String identifiantReprise)
  {
    this.identifiantReprise = identifiantReprise;
  }
  
  @XmlElement(name="premierJourIndemnisableTheorique")
  public String getPremierJourIndemnisableTheorique()
  {
    return premierJourIndemnisableTheorique;
  }
  
  public void setPremierJourIndemnisableTheorique(String premierJourIndemnisableTheorique)
  {
    this.premierJourIndemnisableTheorique = premierJourIndemnisableTheorique;
  }
  
  @XmlElement(name="salaireJournalierReference")
  public String getSalaireJournalierReference()
  {
    return salaireJournalierReference;
  }
  
  public void setSalaireJournalierReference(String salaireJournalierReference)
  {
    this.salaireJournalierReference = salaireJournalierReference;
  }
  
  @XmlElement(name="salaireJournalierConserve")
  public String getSalaireJournalierConserve()
  {
    return salaireJournalierConserve;
  }
  
  public void setSalaireJournalierConserve(String salaireJournalierConserve)
  {
    this.salaireJournalierConserve = salaireJournalierConserve;
  }
  
  @XmlElement(name="reglementApplicable")
  public String getReglementApplicable()
  {
    return reglementApplicable;
  }
  
  public void setReglementApplicable(String reglementApplicable)
  {
    this.reglementApplicable = reglementApplicable;
  }
  
  @XmlElement(name="codeMetier")
  public String getCodeMetier()
  {
    return codeMetier;
  }
  
  public void setCodeMetier(String codeMetier)
  {
    this.codeMetier = codeMetier;
  }
  
  @XmlElement(name="idOMPere")
  public String getIdOMPere()
  {
    return idOMPere;
  }
  
  public void setIdOMPere(String idOMPere)
  {
    this.idOMPere = idOMPere;
  }
  
  @XmlElement(name="typeLiquidation")
  public String getTypeLiquidation()
  {
    return typeLiquidation;
  }
  
  public void setTypeLiquidation(String typeLiquidation)
  {
    this.typeLiquidation = typeLiquidation;
  }
  
  @XmlElement(name="motifRejet")
  public String getMotifRejet()
  {
    return motifRejet;
  }
  
  public void setMotifRejet(String motifRejet)
  {
    this.motifRejet = motifRejet;
  }
  
  @XmlElement(name="etatDecision")
  public String getEtatDecision()
  {
    return etatDecision;
  }
  
  public void setEtatDecision(String etatDecision)
  {
    this.etatDecision = etatDecision;
  }
  
  @XmlElement(name="notificationCourrier")
  public String getNotificationCourrier()
  {
    return notificationCourrier;
  }
  
  public void setNotificationCourrier(String notificationCourrier)
  {
    this.notificationCourrier = notificationCourrier;
  }
  
  @XmlElement(name="dateFctRetenue")
  public String getDateFctRetenue()
  {
    return dateFctRetenue;
  }
  
  public void setDateFctRetenue(String dateFctRetenue)
  {
    this.dateFctRetenue = dateFctRetenue;
  }
  
  @XmlElement(name="motifIneligibilite")
  public String getMotifIneligibilite()
  {
    return motifIneligibilite;
  }
  
  public void setMotifIneligibilite(String motifIneligibilite)
  {
    this.motifIneligibilite = motifIneligibilite;
  }
  
  @XmlElement(name="datePremiereValidation")
  public String getDatePremiereValidation()
  {
    return datePremiereValidation;
  }
  
  public void setDatePremiereValidation(String datePremiereValidation)
  {
    this.datePremiereValidation = datePremiereValidation;
  }
  
  @XmlElement(name="dateDerniereValidation")
  public String getDateDerniereValidation()
  {
    return dateDerniereValidation;
  }
  
  public void setDateDerniereValidation(String dateDerniereValidation)
  {
    this.dateDerniereValidation = dateDerniereValidation;
  }
  
  public boolean estIdentique(IDonneesFonctionnellesCrem donneesFonctionnelles)
  {
    boolean resultat;
    boolean resultat;
    if (!(donneesFonctionnelles instanceof DonneesFonctionnellesDecisionLiquidation))
    {
      resultat = false;
    }
    else
    {
      DonneesFonctionnellesDecisionLiquidation donnees = (DonneesFonctionnellesDecisionLiquidation)donneesFonctionnelles;
      boolean estDonneesAttributionIdentiques = verifierDonneesAttribution(donnees);
      boolean estDonneesDecisionIdentiques = verifierDonneesDecision(donnees);
      boolean estDonneesObjetMetierIdentiques = verifierDonneesCommunes(donnees);
      boolean estDonneesDemandeIdentique = verifierDonneesDemande(donnees);
      resultat = (estDonneesAttributionIdentiques) && (estDonneesDecisionIdentiques) && (estDonneesObjetMetierIdentiques) && (estDonneesDemandeIdentique);
    }
    return resultat;
  }
  
  private boolean verifierDonneesCommunes(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    boolean estIdentifiantIndividuIdentique = verifierIdentifiantsIndividu(donnees);
    boolean estIdentifiantObjetMetierIdentique = ((donnees.getIdentifiantObjetMetier() != null) && (donnees.getIdentifiantObjetMetier().equals(identifiantObjetMetier))) || ((donnees.getIdentifiantObjetMetier() == null) && (identifiantObjetMetier == null));
    
    boolean estIdentifiantOMPereIdentique = ((donnees.getIdOMPere() != null) && (donnees.getIdOMPere().equals(idOMPere))) || ((donnees.getIdOMPere() == null) && (idOMPere == null));
    
    return (estIdentifiantIndividuIdentique) && (estIdentifiantObjetMetierIdentique) && (estIdentifiantOMPereIdentique);
  }
  
  private boolean verifierIdentifiantsIndividu(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    boolean estCxassIdentique = ((donnees.getCxass() != null) && (donnees.getCxass().equals(cxass))) || ((donnees.getCxass() == null) && (cxass == null));
    
    boolean estCxalaIdentique = ((donnees.getCxala() != null) && (donnees.getCxala().equals(cxala))) || ((donnees.getCxala() == null) && (cxala == null));
    
    return (estCxassIdentique) && (estCxalaIdentique);
  }
  
  private boolean verifierDonneesDecision(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    boolean estClassementAdministratifIdentique = ((donnees.getClassementAdministratif() != null) && (donnees.getClassementAdministratif().equals(classementAdministratif))) || ((donnees.getClassementAdministratif() == null) && (classementAdministratif == null));
    
    boolean estDecisionIdentique = (estProduitDecisionIdentique(donnees)) && (estClassementAdministratifIdentique);
    
    return (estIdentifiantDecisionIdentique(donnees)) && (estDateDecisionIdentique(donnees)) && (estDecisionIdentique);
  }
  
  private boolean estProduitDecisionIdentique(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    boolean estCodeProduitIdentique = ((donnees.getCodeProduit() != null) && (donnees.getCodeProduit().equals(codeProduit))) || ((donnees.getCodeProduit() == null) && (codeProduit == null));
    
    boolean estNatureDecisionIdentique = ((donnees.getNatureDecision() != null) && (donnees.getNatureDecision().equals(natureDecision))) || ((donnees.getNatureDecision() == null) && (natureDecision == null));
    
    return (estCodeProduitIdentique) && (estNatureDecisionIdentique);
  }
  
  private boolean estDateDecisionIdentique(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    boolean estDateFaitGenerateurIdentique = ((donnees.getDateFaitGenerateur() != null) && (donnees.getDateFaitGenerateur().equals(dateFaitGenerateur))) || ((donnees.getDateFaitGenerateur() == null) && (dateFaitGenerateur == null));
    
    boolean estDateFctRetenueIdentique = ((donnees.getDateFctRetenue() != null) && (donnees.getDateFctRetenue().equals(dateFctRetenue))) || ((donnees.getDateFctRetenue() == null) && (dateFctRetenue == null));
    
    return (estDateExamenIdentique(donnees)) && (estDateFaitGenerateurIdentique) && (estDateFctRetenueIdentique);
  }
  
  private boolean estDateExamenIdentique(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    return ((donnees.getDateExamen() != null) && (donnees.getDateExamen().equals(dateExamen))) || ((donnees.getDateExamen() == null) && (dateExamen == null));
  }
  
  private boolean estDateValidationIdentique(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    boolean estdatePremiereValidationIdentique = ((donnees.getDatePremiereValidation() != null) && (donnees.getDatePremiereValidation().equals(datePremiereValidation))) || ((donnees.getDatePremiereValidation() == null) && (datePremiereValidation == null));
    
    boolean estDateFctRetenueIdentique = ((donnees.getDateDerniereValidation() != null) && (donnees.getDateDerniereValidation().equals(dateDerniereValidation))) || ((donnees.getDateDerniereValidation() == null) && (dateDerniereValidation == null));
    
    return (estdatePremiereValidationIdentique) && (estDateFctRetenueIdentique);
  }
  
  private boolean estIdentifiantDecisionIdentique(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    boolean estIdentifiantFoncDemandeIdentique = ((donnees.getIdentifiantFonctionnelDemande() != null) && (donnees.getIdentifiantFonctionnelDemande().equals(identifiantFonctionnelDemande))) || ((donnees.getIdentifiantFonctionnelDemande() == null) && (identifiantFonctionnelDemande == null));
    
    boolean estIdentifiantDemandeCaliIdentique = ((donnees.getIdentifiantDemandeCali() != null) && (donnees.getIdentifiantDemandeCali().equals(identifiantDemandeCali))) || ((donnees.getIdentifiantDemandeCali() == null) && (identifiantDemandeCali == null));
    
    return (estIdentifiantDemandeCaliIdentique) && (estIdentifiantFoncDemandeIdentique);
  }
  
  private boolean verifierDonneesAttribution(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    return (estDatesAttributionIdentique(donnees)) && (estIdentifiantAttributionIdentique(donnees)) && (estSalaireJournalierIdentique(donnees)) && (estReglementCodeMetierIdentique(donnees));
  }
  
  private boolean estReglementCodeMetierIdentique(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    boolean estReglementIdentique = ((donnees.getReglementApplicable() != null) && (donnees.getReglementApplicable().equals(reglementApplicable))) || ((donnees.getReglementApplicable() == null) && (reglementApplicable == null));
    
    boolean estCodeMetierIdentique = ((donnees.getCodeMetier() != null) && (donnees.getCodeMetier().equals(codeMetier))) || ((donnees.getCodeMetier() == null) && (codeMetier == null));
    
    return (estReglementIdentique) && (estCodeMetierIdentique);
  }
  
  private boolean estSalaireJournalierIdentique(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    boolean estSJRIdentique = ((donnees.getSalaireJournalierReference() != null) && (donnees.getSalaireJournalierReference().equals(salaireJournalierReference))) || ((donnees.getSalaireJournalierReference() == null) && (salaireJournalierReference == null));
    
    boolean estSJCIdentique = ((donnees.getSalaireJournalierConserve() != null) && (donnees.getSalaireJournalierConserve().equals(salaireJournalierConserve))) || ((donnees.getSalaireJournalierConserve() == null) && (salaireJournalierConserve == null));
    
    return (estSJRIdentique) && (estSJCIdentique);
  }
  
  private boolean estIdentifiantAttributionIdentique(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    boolean estRsodIdentique = ((donnees.getIdentifiantOuvertureDroit() != null) && (donnees.getIdentifiantOuvertureDroit().equals(identifiantOuvertureDroit))) || ((donnees.getIdentifiantOuvertureDroit() == null) && (identifiantOuvertureDroit == null));
    
    boolean estRsrpIdentique = ((donnees.getIdentifiantReprise() != null) && (donnees.getIdentifiantReprise().equals(identifiantReprise))) || ((donnees.getIdentifiantReprise() == null) && (identifiantReprise == null));
    
    return (estRsodIdentique) && (estRsrpIdentique);
  }
  
  private boolean estDatesAttributionIdentique(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    boolean estDateAttributionEtPjiIdentique = verifierDateAttributionEtPji(donnees);
    boolean estIdentiqueDateTheoriqueFinDroit = ((donnees.getDateTheoriqueFinDroit() != null) && (donnees.getDateTheoriqueFinDroit().equals(dateTheoriqueFinDroit))) || ((donnees.getDateTheoriqueFinDroit() == null) && (dateTheoriqueFinDroit == null));
    
    return (estDateAttributionEtPjiIdentique) && (estIdentiqueDateTheoriqueFinDroit);
  }
  
  private boolean verifierDateAttributionEtPji(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    boolean estIdentiqueDateAttribution = ((donnees.getDateAttribution() != null) && (donnees.getDateAttribution().equals(dateAttribution))) || ((donnees.getDateAttribution() == null) && (dateAttribution == null));
    
    boolean estPjiIdentique = ((donnees.getPremierJourIndemnisableTheorique() != null) && (donnees.getPremierJourIndemnisableTheorique().equals(premierJourIndemnisableTheorique))) || ((donnees.getPremierJourIndemnisableTheorique() == null) && (premierJourIndemnisableTheorique == null));
    
    return (estIdentiqueDateAttribution) && (estPjiIdentique);
  }
  
  private boolean verifierDonneesDemande(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    boolean estIdentiqueEtatDecision = ((donnees.getEtatDecision() != null) && (donnees.getEtatDecision().equals(etatDecision))) || ((donnees.getEtatDecision() == null) && (etatDecision == null));
    
    boolean estIdentiqueTypeLiquidation = estIdentiqueTypeLiquidation(donnees);
    boolean estIdentiqueNotificationCourrierEtMotifDemande = (estIdentiqueNotificationCourrier(donnees)) && (estMotifDemandeIdentique(donnees));
    
    return (estIdentiqueNotificationCourrierEtMotifDemande) && (estIdentiqueEtatDecision) && (estIdentiqueTypeLiquidation) && (estDateValidationIdentique(donnees));
  }
  
  private boolean estMotifDemandeIdentique(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    boolean estIdentiqueMotifRejet = ((donnees.getMotifRejet() != null) && (donnees.getMotifRejet().equals(motifRejet))) || ((donnees.getMotifRejet() == null) && (motifRejet == null));
    
    boolean estIdentiqueMotifIneligibilite = ((donnees.getMotifIneligibilite() != null) && (donnees.getMotifIneligibilite().equals(motifIneligibilite))) || ((donnees.getMotifIneligibilite() == null) && (motifIneligibilite == null));
    
    return (estIdentiqueMotifRejet) && (estIdentiqueMotifIneligibilite);
  }
  
  private boolean estIdentiqueNotificationCourrier(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    return ((donnees.getNotificationCourrier() != null) && (donnees.getNotificationCourrier().equals(notificationCourrier))) || ((donnees.getNotificationCourrier() == null) && (notificationCourrier == null));
  }
  
  private boolean estIdentiqueTypeLiquidation(DonneesFonctionnellesDecisionLiquidation donnees)
  {
    return ((donnees.getTypeLiquidation() != null) && (donnees.getTypeLiquidation().equals(typeLiquidation))) || ((donnees.getTypeLiquidation() == null) && (typeLiquidation == null));
  }
  
  public void remplacerDonneesNullesParChainesVides()
  {
    cxass = gererNullite(cxass);
    cxala = gererNullite(cxala);
    identifiantObjetMetier = gererNullite(identifiantObjetMetier);
    identifiantFonctionnelDemande = gererNullite(identifiantFonctionnelDemande);
    dateExamen = gererNullite(dateExamen);
    codeProduit = gererNullite(codeProduit);
    classementAdministratif = gererNullite(classementAdministratif);
    natureDecision = gererNullite(natureDecision);
    dateFaitGenerateur = gererNullite(dateFaitGenerateur);
    dateAttribution = gererNullite(dateAttribution);
    identifiantDemandeCali = gererNullite(identifiantDemandeCali);
    dateTheoriqueFinDroit = gererNullite(dateTheoriqueFinDroit);
    identifiantOuvertureDroit = gererNullite(identifiantOuvertureDroit);
    identifiantReprise = gererNullite(identifiantReprise);
    premierJourIndemnisableTheorique = gererNullite(premierJourIndemnisableTheorique);
    salaireJournalierReference = gererNullite(salaireJournalierReference);
    salaireJournalierConserve = gererNullite(salaireJournalierConserve);
    reglementApplicable = gererNullite(reglementApplicable);
    codeMetier = gererNullite(codeMetier);
    idOMPere = gererNullite(idOMPere);
    typeLiquidation = gererNullite(typeLiquidation);
    motifRejet = gererNullite(motifRejet);
    dateFctRetenue = gererNullite(dateFctRetenue);
    motifIneligibilite = gererNullite(motifIneligibilite);
    etatDecision = gererNullite(etatDecision);
    notificationCourrier = gererNullite(notificationCourrier);
    datePremiereValidation = gererNullite(datePremiereValidation);
    dateDerniereValidation = gererNullite(dateDerniereValidation);
  }
  
  private String gererNullite(String chaine)
  {
    if (chaine != null) {
      return chaine;
    }
    return "";
  }
}

/* Location:
 * Qualified Name:     DonneesFonctionnellesDecisionLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */