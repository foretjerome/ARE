package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.cre.CRModificationDonnee;
import fr.unedic.archi.logique.cre.CompteRenduEvtHandler;
import fr.unedic.archi.logique.cre.TypeModification;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.outilsfonctionnels.ArrayListCREM;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Resultat;
import java.util.Hashtable;

public class ParcoursCREMIndividu
  extends ParcoursCali
{
  CRModificationDonnee m_crmDemandeur = null;
  CRModificationDonnee m_crmEnteteDemandeur = null;
  
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {}
  
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    OutilTrace.tracerDebutParcours();
    
    ArrayListCREM listeComparaisonlisteDonneesImposees = null;
    Hashtable listeDonneesAvant = ((DomDonneesIndividu)p_contexte.getDonnees()).getDonneesIndividuAvant();
    Hashtable listeDonneesApres = ((DomDonneesIndividu)p_contexte.getDonnees()).getDonneesIndividuApres();
    if ((listeDonneesAvant != null) && (listeDonneesApres != null)) {
      try
      {
        listeComparaisonlisteDonneesImposees = new ArrayListCREM(listeDonneesAvant, listeDonneesApres);
        if ((listeComparaisonlisteDonneesImposees.hasModification()) && (!listeComparaisonlisteDonneesImposees.getTypeModificationPrincipale().equals(TypeModification.CREATION))) {
          listeComparaisonlisteDonneesImposees.genererFilsCREM(getEnteteDonnees(p_contexte, listeComparaisonlisteDonneesImposees.getTypeModificationPrincipale()));
        }
      }
      catch (fr.unedic.archi.commun.exception.TechniqueException exception)
      {
        throw new fr.unedic.util.services.TechniqueException("HG_PR_CALI_L_INIT_COMPTE_RENDU", "Impossible d'initialiser le compte-rendu de suivi des modifications de l'individu", exception);
      }
    }
    OutilTrace.tracerFinParcours();
    
    ResultatCREMEnregistrer resultatCREMEnregistrer = new ResultatCREMEnregistrer();
    resultatCREMEnregistrer.setListeComparaisonCREMDonneesImposees(listeComparaisonlisteDonneesImposees);
    
    resultatCREMEnregistrer.setCREM(m_crmDemandeur);
    resultatCREMEnregistrer.setEtat(0);
    
    return resultatCREMEnregistrer;
  }
  
  private CRModificationDonnee getEnteteDonnees(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    if (m_crmEnteteDemandeur == null) {
      m_crmEnteteDemandeur = creerEnteteDonnees(p_contexte, p_typeModification);
    }
    return m_crmEnteteDemandeur;
  }
  
  private CRModificationDonnee creerEnteteDonnees(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    CRModificationDonnee crmDemande = null;
    CRModificationDonnee crmDonneesImposees = null;
    
    crmDemande = getEnteteDemandeur(p_contexte, TypeModification.MODIFICATION);
    
    crmDonneesImposees = crmDemande.creerSousElement("Demandeur d Emploi", p_typeModification, "Demandeur d Emploi");
    
    return crmDonneesImposees;
  }
  
  private CRModificationDonnee getEnteteDemandeur(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    if (m_crmEnteteDemandeur == null) {
      m_crmEnteteDemandeur = creerEnteteDemandeur(p_contexte, p_typeModification);
    }
    return m_crmEnteteDemandeur;
  }
  
  private CRModificationDonnee creerEnteteDemandeur(Contexte p_contexte, TypeModification p_typeModification)
    throws fr.unedic.archi.commun.exception.TechniqueException
  {
    CRModificationDonnee crmDemande = null;
    
    String codeAssedicRSinCXala = getContexteService(p_contexte).getIdEntite() + getContexteService(p_contexte).getCxala();
    
    m_crmDemandeur = CompteRenduEvtHandler.creerCRModificationDonnee("Demandeur d Emploi", p_typeModification, codeAssedicRSinCXala);
    
    crmDemande = m_crmDemandeur.creerSousElement("Demandeur d Emploi", TypeModification.MODIFICATION, "Donnees de l individu");
    
    return crmDemande;
  }
}

/* Location:
 * Qualified Name:     ParcoursCREMIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */