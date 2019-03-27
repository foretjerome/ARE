package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.cre.CRModificationDonnee;
import fr.unedic.archi.logique.cre.CompteRenduEvtHandler;
import fr.unedic.archi.logique.cre.TypeModification;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.outilsfonctionnels.ArrayListCREM;
import fr.unedic.cali.outilsfonctionnels.CREMHorsGamme;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.Hashtable;

public class ParcoursCREMEnregistrer
  extends ParcoursCali
{
  CRModificationDonnee m_crmDemandeur = null;
  CRModificationDonnee m_crmEnteteDemande = null;
  CRModificationDonnee m_crmEnteteDecision = null;
  CRModificationDonnee m_crmEnteteDonneesImposees = null;
  
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {
    DemandeSpec demandeCourante = getDemandeCourante(p_contexte);
    if (demandeCourante == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Une demande est obligatoire pour ce produit.");
    }
  }
  
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    if (Log.isTraceActive(ParcoursCREMEnregistrer.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, ParcoursCREMLiquidation.class, "demarrer", "\n\t\t******** Début ParcoursCREMLiquidation ********\n");
    }
    DemandeSpec demandeAvantReexamen = getDemandeAvantReexamen(p_contexte);
    DemandeSpec demandeCourante = getDemandeCourante(p_contexte);
    
    GammeSpec gamme = null;
    
    gamme = demandeCourante.getGamme();
    
    ArrayListCREM listeComparaisonlisteDonneesImposees = null;
    
    Hashtable listeDonneesImposeesAvantReexamen = null;
    if (demandeAvantReexamen != null) {
      listeDonneesImposeesAvantReexamen = demandeAvantReexamen.getGamme().recupererDonneesImposees(demandeAvantReexamen);
    } else {
      listeDonneesImposeesAvantReexamen = gamme.getElementsDonneesImposeesVides();
    }
    Hashtable listeDonneesImposeesCourante = null;
    listeDonneesImposeesCourante = demandeCourante.getGamme().recupererDonneesImposees(demandeCourante);
    if ((listeDonneesImposeesAvantReexamen != null) && (listeDonneesImposeesCourante != null)) {
      try
      {
        listeComparaisonlisteDonneesImposees = new ArrayListCREM(listeDonneesImposeesAvantReexamen, listeDonneesImposeesCourante);
        if (listeComparaisonlisteDonneesImposees.hasModification()) {
          listeComparaisonlisteDonneesImposees.genererFilsCREM(getEnteteDonneesImposees(p_contexte, listeComparaisonlisteDonneesImposees.getTypeModificationPrincipale()));
        }
      }
      catch (fr.unedic.archi.commun.exception.TechniqueException exception)
      {
        throw new fr.unedic.util.services.TechniqueException("HG_PR_CALI_L_INIT_COMPTE_RENDU", "Impossible d'initialiser le compte-rendu de suivi des modifications de l'individu", exception);
      }
    }
    ArrayListCREM listeComparaisonDecision = null;
    if (demandeCourante.getClassementAdministratif() != null)
    {
      Hashtable listeDecisionAvantReexamen = null;
      if (demandeAvantReexamen != null) {
        listeDecisionAvantReexamen = demandeAvantReexamen.getGamme().recupererElementsDecision(demandeAvantReexamen);
      } else {
        listeDecisionAvantReexamen = gamme.getElementsDecisionVides();
      }
      Hashtable listeDecisionCourante = null;
      listeDecisionCourante = demandeCourante.getGamme().recupererElementsDecision(demandeCourante);
      if ((listeDecisionAvantReexamen != null) && (listeDecisionCourante != null)) {
        try
        {
          listeComparaisonDecision = new ArrayListCREM(listeDecisionAvantReexamen, listeDecisionCourante);
          if ((listeComparaisonDecision.hasModification()) && (!listeComparaisonDecision.getTypeModificationPrincipale().equals(TypeModification.CREATION))) {
            listeComparaisonDecision.genererFilsCREM(getEnteteDecision(p_contexte, listeComparaisonDecision.getTypeModificationPrincipale()));
          }
        }
        catch (fr.unedic.archi.commun.exception.TechniqueException exception)
        {
          throw new fr.unedic.util.services.TechniqueException("HG_PR_CALI_L_INIT_COMPTE_RENDU", "Impossible d'initialiser le compte-rendu de suivi des modifications de l'individu", exception);
        }
      }
    }
    if (Log.isTraceActive(ParcoursCREMLiquidation.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, ParcoursCREMLiquidation.class, "demarrer", "\n\t\t******** Fin ParcoursCREMLiquidation ********\n");
    }
    ResultatCREMEnregistrer resultatCREMEnregistrer = new ResultatCREMEnregistrer();
    resultatCREMEnregistrer.setListeComparaisonCREMDonneesImposees(listeComparaisonlisteDonneesImposees);
    resultatCREMEnregistrer.setListeComparaisonCREMDecision(listeComparaisonDecision);
    
    resultatCREMEnregistrer.setCREM(m_crmDemandeur);
    resultatCREMEnregistrer.setEtat(0);
    
    return resultatCREMEnregistrer;
  }
  
  private CRModificationDonnee getEnteteDemande(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    if (m_crmEnteteDemande == null) {
      m_crmEnteteDemande = creerEnteteDemande(p_contexte, p_typeModification);
    }
    return m_crmEnteteDemande;
  }
  
  private CRModificationDonnee getEnteteDonneesImposees(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    if (m_crmEnteteDonneesImposees == null) {
      m_crmEnteteDonneesImposees = creerEnteteDonneesImposees(p_contexte, p_typeModification);
    }
    return m_crmEnteteDonneesImposees;
  }
  
  private CRModificationDonnee getEnteteDecision(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    if (m_crmEnteteDecision == null) {
      m_crmEnteteDecision = creerEnteteDecision(p_contexte, p_typeModification);
    }
    return m_crmEnteteDecision;
  }
  
  private CRModificationDonnee creerEnteteDonneesImposees(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    CRModificationDonnee crmDemande = null;
    CRModificationDonnee crmDonneesImposees = null;
    
    crmDemande = getEnteteDemande(p_contexte, TypeModification.MODIFICATION);
    
    crmDonneesImposees = crmDemande.creerSousElement("Donnees imposees", p_typeModification, "Donnees imposees");
    
    return crmDonneesImposees;
  }
  
  private CRModificationDonnee creerEnteteDemande(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    CRModificationDonnee crmDemande = null;
    
    String codeAssedicRSinCXala = getContexteService(p_contexte).getIdEntite() + getContexteService(p_contexte).getCxala();
    
    m_crmDemandeur = CompteRenduEvtHandler.creerCRModificationDonnee("Demandeur d Emploi", p_typeModification, codeAssedicRSinCXala);
    
    DemandeSpec demandeCourante = getDemandeCourante(p_contexte);
    
    crmDemande = m_crmDemandeur.creerSousElement("Demande", TypeModification.MODIFICATION, "Demande " + demandeCourante.getGamme().getNomUnique() + " du " + demandeCourante.getDateDeclenchementExamen());
    
    return crmDemande;
  }
  
  private CRModificationDonnee creerEnteteDecision(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    CRModificationDonnee crmDemande = null;
    CRModificationDonnee crmDecision = null;
    String libelleDateDecision = new String("");
    
    crmDemande = getEnteteDemande(p_contexte, TypeModification.MODIFICATION);
    
    DemandeSpec demandeCourante = getDemandeCourante(p_contexte);
    
    Damj dateDecision = CREMHorsGamme.getDateDecision(demandeCourante);
    if (dateDecision != null) {
      libelleDateDecision = new String(" du ") + dateDecision.toString();
    }
    crmDecision = crmDemande.creerSousElement("Decision", p_typeModification, "Decision" + libelleDateDecision);
    
    return crmDecision;
  }
  
  private DemandeSpec getDemandeAvantReexamen(Contexte p_contexte)
  {
    DomLiquidationDemande domCourant = (DomLiquidationDemande)p_contexte.getDonnees();
    
    return domCourant.getDemandeAvantReexamen();
  }
  
  private DemandeSpec getDemandeCourante(Contexte p_contexte)
  {
    DomLiquidationDemande domCourant = (DomLiquidationDemande)p_contexte.getDonnees();
    
    return domCourant.getDemandeSpec();
  }
}

/* Location:
 * Qualified Name:     ParcoursCREMEnregistrer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */