package fr.unedic.cali.autresdoms.cohab.parcours;

import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.CodeReexamen;
import fr.unedic.cali.autresdoms.cohab.outilsfonctionnels.CreationDemande;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.outilsfonctionnels.AlimenterBaseTracker;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.cali.parcours.DomCreationDemandePrestation;
import fr.unedic.cali.parcours.ParcoursCali;
import fr.unedic.cali.parcours.ParcoursServiceAbstrait;
import fr.unedic.cali.parcours.ResultatCreationDemandePrestation;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class ParcoursReceptionFluxV1Demandes
  extends ParcoursServiceAbstrait
{
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    if (getIndividu(contexte) == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "Allocataire absent du contexte, impossible de receptionner le flux", null);
    }
  }
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ContexteService contexteService = DomReceptionFluxV1.getContexteService(contexte);
    String codeReexamen = CodeReexamen.determineCodeReexamen(contexteService);
    
    IndividuSpec individu = getIndividu(contexte);
    
    AlimenterBaseTracker.alimenterDonneesEnModeReception(contexteService);
    
    Map etatsDemandeAvant = OutilFluxSigma.sauvegarderEtatDemandes(getIndividu(contexte));
    
    Collection listeNouveauxFormulairesNcp = traiterFlux(contexte);
    if ((!codeReexamen.equals("0")) && (listeNouveauxFormulairesNcp != null) && (!listeNouveauxFormulairesNcp.isEmpty()))
    {
      Collection listeNouvellesDemandesNcp = recupererOutilCreationFormulaire().creerNouvellesDemandesNcp(individu, contexteService, listeNouveauxFormulairesNcp, true);
      
      Collection<DemandeSpec> demandesAvecAttentesOuPrescrite = new ArrayList();
      
      Iterator iterDemandes = listeNouvellesDemandesNcp.iterator();
      
      DemandeSpec demandePlusAncienne = null;
      while (iterDemandes.hasNext())
      {
        DemandeSpec nouvelleDemande = (DemandeSpec)iterDemandes.next();
        
        etatsDemandeAvant.put(nouvelleDemande, OutilFluxSigma.getEtatDemande(nouvelleDemande));
        if ((demandePlusAncienne == null) || (demandePlusAncienne.getDateRecherche().estApres(nouvelleDemande.getDateRecherche()))) {
          demandePlusAncienne = nouvelleDemande;
        }
        if ((nouvelleDemande.getCodeAttente() != null) || (estDemandePrescrite(nouvelleDemande))) {
          demandesAvecAttentesOuPrescrite.add(nouvelleDemande);
        }
      }
      IndividuPbjcNcp individuPbjcNcpPersistant = individu.getIndividuPbjcNcp();
      if (individuPbjcNcpPersistant == null) {
        individu.setIndividuPbjcNcp(new IndividuPbjcNcp());
      }
      boolean uneSeuleDemandeDecisionnee = false;
      if (listeNouvellesDemandesNcp.size() == 1)
      {
        iterDemandes = listeNouvellesDemandesNcp.iterator();
        DemandeSpec demande = (DemandeSpec)iterDemandes.next();
        uneSeuleDemandeDecisionnee = demande.estDecisionnee();
      }
      reexecuterDossierAutomatique(demandePlusAncienne, codeReexamen, uneSeuleDemandeDecisionnee, demandesAvecAttentesOuPrescrite, individu, contexte);
    }
    return new Resultat();
  }
  
  protected CreationDemande recupererOutilCreationFormulaire()
  {
    return CreationDemande.getInstance();
  }
  
  private boolean estDemandePrescrite(DemandeSpec demande)
  {
    ClassementAdministratif classement = demande.getClassementAdministratif();
    return (classement != null) && ("PS".equals(classement.getTypeClassement()));
  }
  
  protected ResultatGestionnaireReexecutionSpec reexecution(DemandeSpec demande, String codeReexamen, boolean uneSeuleDemandeDecisionnee)
    throws ApplicativeException
  {
    EvenementReexamen evtReexamen = new EvenementReexamen(getDateReexamen(demande), codeReexamen);
    ResultatGestionnaireReexecutionSpec resultatReexecution;
    ResultatGestionnaireReexecutionSpec resultatReexecution;
    if (!uneSeuleDemandeDecisionnee) {
      resultatReexecution = FabriqueGestionnaireReexecution.getGestionnaire().executerSurInstallationDemande(demande, evtReexamen);
    } else {
      resultatReexecution = FabriqueGestionnaireReexecution.getGestionnaire().executerSurValidation(demande);
    }
    return resultatReexecution;
  }
  
  protected void notifierSigma(IndividuSpec individu, Collection<DemandeSpec> demandesNotifiees)
    throws ApplicativeException
  {
    OutilFluxSigma.notifierSigma(individu, demandesNotifiees, false);
  }
  
  protected OutilAjoutCremDalLiquidation initialisationOutilAjouCREM()
  {
    return OutilAjoutCremDalLiquidation.getInstance();
  }
  
  protected void reexecuterDossierAutomatique(DemandeSpec demande, String codeReexamen, boolean uneSeuleDemandeDecisionnee, Collection<DemandeSpec> demandesAvecAttentes, IndividuSpec individu, Contexte contexte)
    throws ApplicativeException
  {
    ResultatGestionnaireReexecutionSpec resultatReexecution = reexecution(demande, codeReexamen, uneSeuleDemandeDecisionnee);
    
    boolean estDemandeDecisionneOuPrescrite = estDemandeDecisionneeOuPrescrite(demande);
    boolean estDemandeNonContenueDansListe = (demande != null) && (!resultatReexecution.getDemandesReliquidees().contains(demande));
    if ((estDemandeNonContenueDansListe) && (estDemandeDecisionneOuPrescrite)) {
      resultatReexecution.getDemandesReliquidees().add(demande);
    }
    OutilAjoutCremDalLiquidation outil = initialisationOutilAjouCREM();
    outil.ajouterCREMDemandesReexecutes(resultatReexecution.getDemandesReliquidees(), individu);
    
    Collection<DemandeSpec> demandesNotifiees = resultatReexecution.getDemandesReliquidees();
    
    ajouterDemandesAvecAttente(demandesAvecAttentes, demandesNotifiees);
    if ((demande != null) && (!demandesNotifiees.contains(demande))) {
      demandesNotifiees.add(demande);
    }
    notifierSigma(individu, demandesNotifiees);
  }
  
  private void ajouterDemandesAvecAttente(Collection<DemandeSpec> demandesAvecAttentes, Collection<DemandeSpec> demandesNotifiees)
  {
    for (DemandeSpec demandeSpec : demandesAvecAttentes) {
      if (!demandesNotifiees.contains(demandeSpec)) {
        demandesNotifiees.add(demandeSpec);
      }
    }
  }
  
  private boolean estDemandeDecisionneeOuPrescrite(DemandeSpec demande)
  {
    boolean demandeDecisionneeOuPrescrite = false;
    if ((demande.estDecisionnee()) || ((demande.getClassementAdministratif() != null) && (demande.getClassementAdministratif().getTypeClassement().equals("PS")))) {
      demandeDecisionneeOuPrescrite = true;
    }
    return demandeDecisionneeOuPrescrite;
  }
  
  protected abstract Damj getDateReexamen(DemandeSpec paramDemandeSpec);
  
  protected abstract Collection traiterFlux(Contexte paramContexte)
    throws ApplicativeException;
  
  protected DomReceptionFluxV1 getDom(Contexte contexte)
  {
    return (DomReceptionFluxV1)contexte.getDonnees();
  }
  
  protected Collection creerNouvellesDemandesNcp(Contexte pContexte, Collection listeNouveauxFormulaires)
    throws ApplicativeException
  {
    Collection listeNouvellesDemandes = new ArrayList();
    if (listeNouveauxFormulaires != null)
    {
      Iterator iterFormulaires = listeNouveauxFormulaires.iterator();
      while (iterFormulaires.hasNext())
      {
        FormulaireSpec nouveauFormulaire = (FormulaireSpec)iterFormulaires.next();
        
        Contexte contexteParcours = new Contexte();
        DomCreationDemandePrestation dom = new DomCreationDemandePrestation();
        dom.setFormulaire(nouveauFormulaire);
        dom.setIndividu(getDom(pContexte).getIndividu());
        dom.setContexteService(getDom(pContexte).getContexteService());
        contexteParcours.setDonnees(dom);
        
        ParcoursCali parcours = nouveauFormulaire.getGamme().getParcoursCreationDemande();
        
        ResultatCreationDemandePrestation resultat = (ResultatCreationDemandePrestation)parcours.effectuerParcours(contexteParcours);
        
        listeNouvellesDemandes.add(resultat.getDemande());
      }
    }
    return listeNouvellesDemandes;
  }
}

/* Location:
 * Qualified Name:     ParcoursReceptionFluxV1Demandes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */