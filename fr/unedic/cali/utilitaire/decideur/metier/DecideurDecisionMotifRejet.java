package fr.unedic.cali.utilitaire.decideur.metier;

import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.ElementComparaisonReexamen;
import fr.unedic.cali.dom.ElementDroitSpec;
import fr.unedic.cali.dom.NaturesDecisions;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;
import java.util.Iterator;
import java.util.List;

public class DecideurDecisionMotifRejet
  implements DecideurDecisionSpec
{
  int m_motifAvant;
  int m_motifApres;
  public static final int VALEUR_MOTIF_ACCEPTE = -1;
  
  public DecideurDecisionMotifRejet(int p_motifAvant, int p_motifApres)
  {
    m_motifAvant = p_motifAvant;
    m_motifApres = p_motifApres;
  }
  
  public boolean decisionsIdentiques(DemandeSpec demandeAvant, DemandeSpec demandeApres, List listeElementsComparaisonDecision, ComportementSpec comportement)
  {
    boolean retour = ignorerElementComparaison(demandeAvant, demandeApres, null);
    if (retour) {
      comportement.setUtilise(true);
    }
    return retour;
  }
  
  private boolean decisionsIdentiques(DecisionSpec decisionAvant, DecisionSpec decisionApres)
  {
    if ((NaturesDecisions.estdeTypeRejet(decisionAvant.getNatureDecision())) && (NaturesDecisions.estdeTypeRejet(decisionApres.getNatureDecision())))
    {
      boolean presenceMotifAvant = false;
      Iterator it = decisionAvant.getListConditionsAttribution().iterator();
      while ((it.hasNext()) && (!presenceMotifAvant))
      {
        ElementDroitSpec elementDroitAvant = (ElementDroitSpec)it.next();
        if (elementDroitAvant != null) {
          presenceMotifAvant = (elementDroitAvant.getCodeMotifEchec() == m_motifAvant) || (m_motifAvant == -1);
        }
      }
      if (presenceMotifAvant)
      {
        boolean presenceMotifApres = false;
        it = decisionApres.getListConditionsAttribution().iterator();
        while ((it.hasNext()) && (!presenceMotifApres))
        {
          ElementDroitSpec elementDroitApres = (ElementDroitSpec)it.next();
          if (elementDroitApres != null) {
            presenceMotifApres = (elementDroitApres.getCodeMotifEchec() == m_motifApres) || (m_motifApres == -1);
          }
        }
        if ((presenceMotifAvant) && (presenceMotifApres)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public String getLibelle()
  {
    return "La décisions sont identiques si on passe d'un rejet " + m_motifAvant + " à un rejet " + m_motifApres;
  }
  
  public List getListeDecideursAppliques()
  {
    return null;
  }
  
  public boolean ignorerElementComparaison(DemandeSpec demandeAvant, DemandeSpec demandeApres, ElementComparaisonReexamen elementComparaison)
  {
    List listeDecisionAvant = demandeAvant.getListeDossiersExamen();
    List listeDecisionApres = demandeApres.getListeDossiersExamen();
    DecisionSpec decisionAvant = null;
    DecisionSpec decisionApres = null;
    boolean retour = false;
    for (int i = 0; i < listeDecisionAvant.size(); i++)
    {
      decisionAvant = (DecisionSpec)listeDecisionAvant.get(i);
      if (listeDecisionApres.get(i) != null) {
        decisionApres = (DecisionSpec)listeDecisionApres.get(i);
      } else {
        return false;
      }
      retour = decisionsIdentiques(decisionAvant, decisionApres);
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     DecideurDecisionMotifRejet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */