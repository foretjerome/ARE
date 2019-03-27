package fr.unedic.cali.utilitaire.decideur.logiques;

import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.ElementComparaisonReexamen;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DecideurDecisionVeto
  implements DecideurDecisionSpec
{
  private List m_listeDecideurs;
  
  public DecideurDecisionVeto()
  {
    m_listeDecideurs = new ArrayList();
  }
  
  public void ajouterDecideur(DecideurDecisionSpec decideur)
  {
    m_listeDecideurs.add(decideur);
  }
  
  public boolean decisionsIdentiques(DemandeSpec demandeAvant, DemandeSpec demandeApres, List listeElementsComparaisonDecision, ComportementSpec comportement)
  {
    boolean decisionsIdentiques = true;
    Iterator itDecideur = null;
    boolean ignorerElement = false;
    if ((listeElementsComparaisonDecision != null) && (!listeElementsComparaisonDecision.isEmpty()))
    {
      Iterator itElementComparaison = listeElementsComparaisonDecision.iterator();
      while ((itElementComparaison.hasNext()) && (decisionsIdentiques))
      {
        ElementComparaisonReexamen elementComparaison = (ElementComparaisonReexamen)itElementComparaison.next();
        ignorerElement = false;
        itDecideur = m_listeDecideurs.iterator();
        while ((itDecideur.hasNext()) && (!ignorerElement))
        {
          DecideurDecisionSpec decideur = (DecideurDecisionSpec)itDecideur.next();
          if (decideur.ignorerElementComparaison(demandeAvant, demandeApres, elementComparaison)) {
            ignorerElement = true;
          }
        }
        if (!ignorerElement) {
          decisionsIdentiques = false;
        }
      }
      if ((ignorerElement) && (decisionsIdentiques)) {
        comportement.setUtilise(true);
      }
    }
    return decisionsIdentiques;
  }
  
  public List getListeDecideursAppliques()
  {
    return m_listeDecideurs;
  }
  
  public String getLibelle()
  {
    String resultat = "\n(Décisions égales si :";
    
    Iterator it = m_listeDecideurs.iterator();
    int compteur = 0;
    while (it.hasNext())
    {
      DecideurDecisionSpec decideur = (DecideurDecisionSpec)it.next();
      
      resultat = resultat + "\n - ";
      if (compteur > 0) {
        resultat = resultat + "OU ";
      }
      resultat = resultat + decideur.getLibelle();
      
      compteur++;
    }
    resultat = resultat + ")";
    return resultat;
  }
  
  public boolean ignorerElementComparaison(DemandeSpec demandeAvant, DemandeSpec demandeApres, ElementComparaisonReexamen elementComparaison)
  {
    throw new UnsupportedOperationException("méthode à ne pas appeler");
  }
}

/* Location:
 * Qualified Name:     DecideurDecisionVeto
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */