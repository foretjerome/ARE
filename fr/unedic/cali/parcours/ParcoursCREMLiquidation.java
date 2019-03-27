package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.cre.CRModificationDonnee;
import fr.unedic.archi.logique.cre.CompteRenduEvtHandler;
import fr.unedic.archi.logique.cre.TypeModification;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.ArrayListCREM;
import fr.unedic.cali.outilsfonctionnels.CREMHorsGamme;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.Hashtable;

public class ParcoursCREMLiquidation
  extends ParcoursCali
{
  CRModificationDonnee m_crmDemandeur = null;
  CRModificationDonnee m_crmEnteteDemande = null;
  CRModificationDonnee m_crmEnteteDecision = null;
  CRModificationDonnee m_crmEnteteConstitutant = null;
  
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {
    DemandeSpec demandeCourante = getDemandeCourante(p_contexte);
    if (demandeCourante == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Une demande est obligatoire pour ce produit.");
    }
  }
  
  private boolean alimenterCREM(DemandeSpec p_demandeAvantReexamen, DemandeSpec p_demandeCourante)
  {
    boolean alimenterCrem = true;
    try
    {
      if (p_demandeAvantReexamen != null) {
        if ((p_demandeAvantReexamen.getDossierAffectation() != null) && (p_demandeCourante.getDossierAffectation() != null))
        {
          if ((p_demandeAvantReexamen.getDossierAffectation().getDossierExamen() != null) && (p_demandeCourante.getDossierAffectation().getDossierExamen() != null))
          {
            DossierExamenSpec dossierExamenAvant = p_demandeAvantReexamen.getDossierAffectation().getDossierExamen();
            DossierExamenSpec dossierExamenApres = p_demandeCourante.getDossierAffectation().getDossierExamen();
            alimenterCrem = (dossierExamenAvant.getDossierAffecte().getProduit().getCode() == dossierExamenApres.getDossierAffecte().getProduit().getCode()) && (dossierExamenAvant.getClass().equals(dossierExamenApres.getClass()));
          }
          else
          {
            alimenterCrem = false;
          }
        }
        else {
          alimenterCrem = false;
        }
      }
    }
    catch (UnsupportedOperationException ex)
    {
      alimenterCrem = false;
    }
    return alimenterCrem;
  }
  
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    OutilTrace.tracerDebutParcours();
    
    ResultatCREMLiquidation resultatCREMLiquidation = new ResultatCREMLiquidation();
    DemandeSpec demandeAvantReexamen = getDemandeAvantReexamen(p_contexte);
    DemandeSpec demandeCourante = getDemandeCourante(p_contexte);
    if (alimenterCREM(demandeAvantReexamen, demandeCourante))
    {
      GammeSpec gamme = null;
      gamme = demandeCourante.getGamme();
      
      Hashtable listeDecisionAvantReexamen = null;
      if (demandeAvantReexamen != null) {
        listeDecisionAvantReexamen = demandeAvantReexamen.getGamme().recupererElementsDecision(demandeAvantReexamen);
      } else {
        listeDecisionAvantReexamen = gamme.getElementsDecisionVides();
      }
      Hashtable listeDecisionCourante = null;
      listeDecisionCourante = demandeCourante.getGamme().recupererElementsDecision(demandeCourante);
      
      ArrayListCREM listeComparaisonDecision = new ArrayListCREM(listeDecisionAvantReexamen, listeDecisionCourante);
      try
      {
        if ((listeComparaisonDecision.hasModification()) && (!listeComparaisonDecision.getTypeModificationPrincipale().equals(TypeModification.CREATION))) {
          listeComparaisonDecision.genererFilsCREM(getEnteteDecision(p_contexte, listeComparaisonDecision.getTypeModificationPrincipale()));
        }
      }
      catch (fr.unedic.archi.commun.exception.TechniqueException exception)
      {
        throw new fr.unedic.util.services.TechniqueException("HG_PR_CALI_L_INIT_COMPTE_RENDU", "Impossible d'initialiser le compte-rendu de suivi des modifications de l'individu", exception);
      }
      Hashtable listeConstituantsAvantReexamen = gamme.getElementsConstituantVides();
      if (demandeAvantReexamen != null) {
        try
        {
          DossierAffectationSpec dossierAffectation = demandeAvantReexamen.getDossierAffectation();
          if (dossierAffectation != null) {
            listeConstituantsAvantReexamen = dossierAffectation.getProduit().recupererElementsConstituant(dossierAffectation.getDossierExamen());
          }
        }
        catch (UnsupportedOperationException ex)
        {
          listeConstituantsAvantReexamen = gamme.getElementsConstituantVides();
        }
      }
      Hashtable listeConstituantsCourante = gamme.getElementsConstituantVides();
      try
      {
        DossierAffectationSpec dossierAffectation = demandeCourante.getDossierAffectation();
        if (dossierAffectation != null) {
          listeConstituantsCourante = dossierAffectation.getProduit().recupererElementsConstituant(dossierAffectation.getDossierExamen());
        }
      }
      catch (UnsupportedOperationException ex)
      {
        listeConstituantsAvantReexamen = gamme.getElementsConstituantVides();
      }
      ArrayListCREM listeComparaisonConstituant = new ArrayListCREM(listeConstituantsAvantReexamen, listeConstituantsCourante);
      try
      {
        if ((listeComparaisonConstituant.hasModification()) && (!listeComparaisonDecision.getTypeModificationPrincipale().equals(TypeModification.CREATION))) {
          listeComparaisonConstituant.genererFilsCREM(getEnteteConstituant(p_contexte, listeComparaisonConstituant.getTypeModificationPrincipale()));
        }
      }
      catch (fr.unedic.archi.commun.exception.TechniqueException exception)
      {
        throw new fr.unedic.util.services.TechniqueException("HG_PR_CALI_L_INIT_COMPTE_RENDU", "Impossible d'initialiser le compte-rendu de suivi des modifications de l'individu", exception);
      }
      OutilTrace.ecrireTrace(Niveau.DEBUG, new Object[] { "listeComparaisonDecision : ", listeComparaisonDecision });
      OutilTrace.ecrireTrace(Niveau.DEBUG, new Object[] { "listeComparaisonConstituant : ", listeComparaisonConstituant });
      
      resultatCREMLiquidation.setListeComparaisonCREMDecision(listeComparaisonDecision);
      resultatCREMLiquidation.setListeComparaisonCREMConstituant(listeComparaisonConstituant);
      resultatCREMLiquidation.setCREM(m_crmDemandeur);
      resultatCREMLiquidation.setEtat(0);
    }
    else
    {
      OutilTrace.ecrireTrace(Niveau.DEBUG, new Object[] { "Pas de CREM dans ce cas, produits différents ou cas de maintien ou cas de RBF" });
    }
    OutilTrace.tracerFinParcours();
    return resultatCREMLiquidation;
  }
  
  private CRModificationDonnee getEnteteConstituant(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    if (m_crmEnteteConstitutant == null) {
      m_crmEnteteConstitutant = creerEnteteConstituant(p_contexte, p_typeModification);
    }
    return m_crmEnteteConstitutant;
  }
  
  private CRModificationDonnee getEnteteDecision(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    if (m_crmEnteteDecision == null) {
      m_crmEnteteDecision = creerEnteteDecision(p_contexte, p_typeModification);
    }
    return m_crmEnteteDecision;
  }
  
  private CRModificationDonnee getEnteteDemande(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    if (m_crmEnteteDemande == null) {
      m_crmEnteteDemande = creerEnteteDemande(p_contexte, p_typeModification);
    }
    return m_crmEnteteDemande;
  }
  
  private CRModificationDonnee creerEnteteDemande(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    CRModificationDonnee crmDemande = null;
    
    String codeAssedicRSinCXala = getContexteService(p_contexte).getIdEntite() + getContexteService(p_contexte).getCxala();
    
    m_crmDemandeur = CompteRenduEvtHandler.creerCRModificationDonnee("Demandeur d Emploi", TypeModification.MODIFICATION, codeAssedicRSinCXala);
    
    DemandeSpec demandeCourante = getDemandeCourante(p_contexte);
    
    crmDemande = m_crmDemandeur.creerSousElement("Demande", p_typeModification, "Demande " + demandeCourante.getGamme().getNomUnique() + " du " + demandeCourante.getDateDeclenchementExamen());
    
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
  
  private CRModificationDonnee creerEnteteConstituant(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    CRModificationDonnee crmDecision = null;
    CRModificationDonnee crmConstituant = null;
    
    crmDecision = getEnteteDecision(p_contexte, TypeModification.MODIFICATION);
    
    crmConstituant = crmDecision.creerSousElement("Constituant", p_typeModification, "Constituant");
    
    return crmConstituant;
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
 * Qualified Name:     ParcoursCREMLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */