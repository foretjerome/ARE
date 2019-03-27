package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ClassementAdministratifSpec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.dossiersLourds.DomDossiersLourdsChargerServices;
import fr.unedic.cali.dom.dossiersLourds.DomDossiersLourdsDecisionElt;
import fr.unedic.cali.dom.dossiersLourds.DomDossiersLourdsDemandeElt;
import fr.unedic.cali.outilsfonctionnels.OutilAttribution;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParcoursDossiersLourdsChargerServices
  extends ParcoursServiceAbstrait
{
  protected void initialiserContexteParcour(Contexte p_contexte) {}
  
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    Chronologie demandes = null;
    
    List demandesIndividus = new ArrayList();
    List decisionsIndividus = new ArrayList();
    
    DomDossiersLourdsDemandeElt domDemande = null;
    DomDossiersLourdsDecisionElt domDecision = null;
    
    DomDossiersLourdsChargerServices domDossiersLourdsChargerServices = (DomDossiersLourdsChargerServices)p_contexte.getDonnees();
    IndividuSpec individu = domDossiersLourdsChargerServices.getIndividu();
    demandes = individu.getChronoDemandes();
    
    demandes.iterer();
    int indiceDemandes = 0;
    int indiceDecisionsEtClassements = 0;
    String libelle = null;
    while (demandes.encoreSuivant())
    {
      DemandeSpec demande = (DemandeSpec)demandes.elementSuivant();
      indiceDemandes++;
      
      domDemande = new DomDossiersLourdsDemandeElt();
      domDemande.setIdentifiant(demande.getIdentifiant());
      
      libelle = indiceDemandes + " - Demande " + demande.getGamme().getNomUnique();
      if (demande.getDateDeclenchementExamen() != null) {
        libelle = libelle + " " + demande.getDateDeclenchementExamen();
      }
      libelle = libelle + formaterNumeroSuivi(demande);
      
      domDemande.setDemande(libelle);
      domDemande.setGamme(demande.getGamme().getLibelle());
      domDemande.setReferenceExterne(demande.getFormulaire().getReferenceExterne());
      demandesIndividus.add(domDemande);
      
      List decisionsEtClassements = getListeDecisionsEtClassements(demande);
      if (decisionsEtClassements != null)
      {
        Iterator iterDecisionsEtClassements = decisionsEtClassements.iterator();
        while (iterDecisionsEtClassements.hasNext())
        {
          indiceDecisionsEtClassements++;
          
          Object decisionOuClassement = iterDecisionsEtClassements.next();
          domDecision = new DomDossiersLourdsDecisionElt();
          if ((decisionOuClassement instanceof DecisionSpec))
          {
            DecisionSpec decision = (DecisionSpec)decisionOuClassement;
            
            libelle = indiceDecisionsEtClassements + " - Decision " + demande.getGamme().getNomUnique();
            if (decision.getDateAttribution() != null) {
              libelle = libelle + " " + decision.getDateAttribution();
            }
            libelle = libelle + formaterNumeroSuivi(demande);
            
            DossierAffectationSpec dossierAffecte = decision.getDossierAffecte();
            if (dossierAffecte != null) {
              domDecision.setProduit(dossierAffecte.getProduit().getLibelleLong());
            }
            domDecision.setIdentifiant(decision.getIdentifiant());
          }
          else if ((decisionOuClassement instanceof ClassementAdministratifSpec))
          {
            ClassementAdministratifSpec classement = (ClassementAdministratifSpec)decisionOuClassement;
            
            libelle = indiceDecisionsEtClassements + " - Classement " + demande.getGamme().getNomUnique();
            libelle = libelle + formaterNumeroSuivi(demande);
            
            domDecision.setProduit(null);
            domDecision.setIdentifiant(classement.getIdentifiant());
          }
          domDecision.setDecision(libelle);
          domDecision.setGamme(demande.getGamme().getLibelle());
          domDecision.setReferenceExterne(demande.getFormulaire().getReferenceExterne());
          decisionsIndividus.add(domDecision);
        }
      }
    }
    ResultatDossiersLourdsChargerServices resultat = new ResultatDossiersLourdsChargerServices();
    resultat.setEtat(1);
    
    DomDossiersLourdsChargerServices dom = (DomDossiersLourdsChargerServices)p_contexte.getDonnees();
    
    dom.setListeDemandes(demandesIndividus);
    dom.setListeDecisions(decisionsIndividus);
    
    resultat.setEtat(0);
    resultat.setDomDossiersLourdsChargerServices(dom);
    
    return resultat;
  }
  
  private List getListeDecisionsEtClassements(DemandeSpec p_demande)
  {
    List listeDecisionsEtClassements = new ArrayList();
    
    Iterator iterateurDossiersExamen = null;
    DossierExamenSpec dossierExamenSpec = null;
    if (p_demande.getClassementAdministratif() != null)
    {
      listeDecisionsEtClassements.add(p_demande.getClassementAdministratif());
    }
    else
    {
      iterateurDossiersExamen = p_demande.getListeDossiersExamen().iterator();
      while (iterateurDossiersExamen.hasNext())
      {
        dossierExamenSpec = (DossierExamenSpec)iterateurDossiersExamen.next();
        
        listeDecisionsEtClassements.add(dossierExamenSpec);
        if ((dossierExamenSpec instanceof AttributionSpec)) {
          OutilAttribution.getInstance().traiterAttributionLiee(listeDecisionsEtClassements, dossierExamenSpec);
        }
      }
    }
    return listeDecisionsEtClassements;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
  
  private String formaterNumeroSuivi(DemandeSpec p_demande)
  {
    if ((p_demande.getFormulaire().getNumeroSuivi() != null) && (!p_demande.getFormulaire().getNumeroSuivi().equals(""))) {
      return " (" + p_demande.getFormulaire().getNumeroSuivi() + ")";
    }
    return "";
  }
}

/* Location:
 * Qualified Name:     ParcoursDossiersLourdsChargerServices
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */