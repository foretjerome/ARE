package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.NaturesDecisions;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation;
import fr.unedic.util.temps.Temporel;

public class FiltreOuvertureDroitSurDecision
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private boolean m_filtrerDecisionValidee;
  
  public FiltreOuvertureDroitSurDecision()
  {
    m_filtrerDecisionValidee = false;
  }
  
  public FiltreOuvertureDroitSurDecision(boolean p_estDecisionSansReexamen)
  {
    m_filtrerDecisionValidee = p_estDecisionSansReexamen;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    DecisionSpec decision = (DecisionSpec)p_temporel;
    boolean resultat = NaturesDecisions.estdeTypeOd(decision.getNatureDecision());
    if (m_filtrerDecisionValidee)
    {
      FiltreET filtreReexamen = new FiltreET();
      filtreReexamen.ajouterFiltre(new FiltreNegation(new FiltreReexamenSurDemande()));
      filtreReexamen.ajouterFiltre(new FiltreValideeSurDecision());
      if (!filtreReexamen.accepter(p_temporel)) {
        resultat = false;
      }
    }
    return resultat;
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreOuvertureDroitSurDecision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */