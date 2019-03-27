package fr.unedic.cali.utilitaire.decideur.logiques;

import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.ElementComparaisonReexamen;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DecideurDecisionUnanimite
  implements DecideurDecisionSpec
{
  private List m_listeDecideurs;
  
  public DecideurDecisionUnanimite()
  {
    m_listeDecideurs = new ArrayList();
  }
  
  public void ajouterDecideur(DecideurDecisionSpec decideur)
  {
    m_listeDecideurs.add(decideur);
  }
  
  public boolean decisionsIdentiques(DemandeSpec demandeAvant, DemandeSpec demandeApres, List listeElementsComparaisonDecision, ComportementSpec comportement)
  {
    Iterator it = m_listeDecideurs.iterator();
    while (it.hasNext())
    {
      DecideurDecisionSpec decideur = (DecideurDecisionSpec)it.next();
      if (!decideur.decisionsIdentiques(demandeAvant, demandeApres, listeElementsComparaisonDecision, comportement)) {
        return false;
      }
    }
    return true;
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
        resultat = resultat + "ET ";
      }
      resultat = resultat + decideur.getLibelle();
      
      compteur++;
    }
    resultat = resultat + ")";
    return resultat;
  }
  
  public boolean ignorerElementComparaison(DemandeSpec demandeAvant, DemandeSpec demandeApres, ElementComparaisonReexamen elementComparaison)
  {
    throw new UnsupportedOperationException("méthode à ne pas utiliser pour ce decideur");
  }
}

/* Location:
 * Qualified Name:     DecideurDecisionUnanimite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */