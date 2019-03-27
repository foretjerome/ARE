package fr.unedic.cali.utilitaire.filtres.composites;

import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourNumeroGamme;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreReexamenSurDemande;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreValideeSurDecision;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionRbf
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private boolean m_filtrerDecisionValidee;
  
  public FiltreAttributionRbf(boolean p_estDecisionSansReexamen)
  {
    m_filtrerDecisionValidee = p_estDecisionSansReexamen;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean resultat = false;
    FiltreET filtreAttribution = new FiltreET();
    filtreAttribution.ajouterFiltre(new FiltreAttributionSurDecisions());
    filtreAttribution.ajouterFiltre(new FiltreDemandePourNumeroGamme(3));
    if (m_filtrerDecisionValidee)
    {
      filtreAttribution.ajouterFiltre(new FiltreNegation(new FiltreReexamenSurDemande()));
      filtreAttribution.ajouterFiltre(new FiltreValideeSurDecision());
    }
    if (filtreAttribution.accepter(p_temporel)) {
      resultat = true;
    }
    return resultat;
  }
  
  public int getTypeElementManipule()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     FiltreAttributionRbf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */