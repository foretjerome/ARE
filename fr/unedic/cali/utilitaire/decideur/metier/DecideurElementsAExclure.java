package fr.unedic.cali.utilitaire.decideur.metier;

import fr.unedic.cali.autresdoms.d90.dom.ElementDroitAExclure;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.ElementComparaisonReexamen;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class DecideurElementsAExclure
  implements DecideurDecisionSpec
{
  private List m_elementsDroitAExclure;
  
  public DecideurElementsAExclure()
  {
    m_elementsDroitAExclure = new ArrayList();
  }
  
  public List getElementsDroitAExclure()
  {
    return m_elementsDroitAExclure;
  }
  
  public void ajouterElementDroitAExclure(ElementDroitAExclure p_elementDroitAExclure)
  {
    if (p_elementDroitAExclure != null) {
      getElementsDroitAExclure().add(p_elementDroitAExclure);
    }
  }
  
  public boolean decisionsIdentiques(DemandeSpec p_demandeAvant, DemandeSpec p_demandeApres, List p_listeElementsComparaisonDecision, ComportementSpec p_comportement)
  {
    if ((p_demandeAvant != null) && (p_demandeApres != null))
    {
      List listeElementsDroitAExclure = null;
      if (p_comportement != null) {
        listeElementsDroitAExclure = getElementsDroitAExclure();
      }
      int codeProduit = definirCodeProduit(p_demandeAvant);
      String libelleGamme = definirLibelleGamme(p_demandeAvant);
      if ((listeElementsDroitAExclure == null) || (listeElementsDroitAExclure.isEmpty())) {
        return (p_listeElementsComparaisonDecision == null) || (p_listeElementsComparaisonDecision.isEmpty());
      }
      boolean demandeIdentiques = true;
      if ((p_listeElementsComparaisonDecision != null) && (!p_listeElementsComparaisonDecision.isEmpty()))
      {
        int nbrElementsComparaisonDecision = p_listeElementsComparaisonDecision.size();
        int i = 0;
        while ((i < nbrElementsComparaisonDecision) && (demandeIdentiques))
        {
          ElementComparaisonReexamen elementComparaisonReexamen = (ElementComparaisonReexamen)p_listeElementsComparaisonDecision.get(i);
          if (!ignorerElementComparaisonDecision(codeProduit, libelleGamme, elementComparaisonReexamen)) {
            demandeIdentiques = false;
          } else {
            p_comportement.setUtilise(true);
          }
          i++;
        }
      }
      return demandeIdentiques;
    }
    return false;
  }
  
  private boolean ignorerElementComparaisonDecision(int p_codeProduit, String p_codeGamme, ElementComparaisonReexamen p_elementComparaisonReexamen)
  {
    List listeElementsDroitAExclure = getElementsDroitAExclure();
    Iterator iteratorElementsDroitAExclure = listeElementsDroitAExclure.iterator();
    boolean ignorerElement = false;
    while ((iteratorElementsDroitAExclure.hasNext()) && (!ignorerElement))
    {
      ElementDroitAExclure elementDroitAExclure = (ElementDroitAExclure)iteratorElementsDroitAExclure.next();
      if (StringUtils.equals(elementDroitAExclure.getLibelleElementAExclure(), p_elementComparaisonReexamen.getLibelleElement())) {
        if (elementDroitAExclure.getCodeProduit() != -1)
        {
          if (elementDroitAExclure.getCodeProduit() == p_codeProduit) {
            ignorerElement = true;
          }
        }
        else if (StringUtils.isNotEmpty(elementDroitAExclure.getLibelleGamme()))
        {
          if (StringUtils.equals(p_codeGamme, elementDroitAExclure.getLibelleGamme())) {
            ignorerElement = true;
          }
        }
        else {
          ignorerElement = true;
        }
      }
    }
    return ignorerElement;
  }
  
  private static int definirCodeProduit(DemandeSpec demande)
  {
    int codeProduit = -1;
    String gamme = definirLibelleGamme(demande);
    if ((demande != null) && (!StringUtils.equals(gamme, "RBF")) && 
      (demande.getDossierAffectation() != null) && (demande.getDossierAffectation().getProduit() != null)) {
      codeProduit = demande.getDossierAffectation().getProduit().getCode();
    }
    return codeProduit;
  }
  
  private static String definirLibelleGamme(DemandeSpec demande)
  {
    String libelleGamme = null;
    if ((demande != null) && (demande.getGamme() != null)) {
      libelleGamme = demande.getGamme().getNomUnique();
    }
    return libelleGamme;
  }
  
  public List getListeDecideursAppliques()
  {
    return null;
  }
  
  public String getLibelle()
  {
    return "Décisions égales s'il n'y a pas de différence sur les décision après avoir exclu une liste d'éléments prédéfinis";
  }
  
  public boolean ignorerElementComparaison(DemandeSpec demandeAvant, DemandeSpec demandeApres, ElementComparaisonReexamen elementComparaison)
  {
    int codeProduit = definirCodeProduit(demandeAvant);
    String libelleGamme = definirLibelleGamme(demandeAvant);
    return ignorerElementComparaisonDecision(codeProduit, libelleGamme, elementComparaison);
  }
}

/* Location:
 * Qualified Name:     DecideurElementsAExclure
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */