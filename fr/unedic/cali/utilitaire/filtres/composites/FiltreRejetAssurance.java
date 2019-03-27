package fr.unedic.cali.utilitaire.filtres.composites;

import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourNumeroGamme;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreReexamenSurDemande;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreRejetSurDecisions;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreValideeSurDecision;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation;
import fr.unedic.util.temps.Temporel;

public class FiltreRejetAssurance
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private boolean m_filtrerDecisionValidee;
  
  public FiltreRejetAssurance(boolean p_estDecisionSansReexamen)
  {
    m_filtrerDecisionValidee = p_estDecisionSansReexamen;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    FiltreET filtreRejetAssurance = new FiltreET();
    filtreRejetAssurance.ajouterFiltre(new FiltreRejetSurDecisions());
    filtreRejetAssurance.ajouterFiltre(new FiltreDemandePourNumeroGamme(1));
    if (m_filtrerDecisionValidee)
    {
      filtreRejetAssurance.ajouterFiltre(new FiltreNegation(new FiltreReexamenSurDemande()));
      filtreRejetAssurance.ajouterFiltre(new FiltreValideeSurDecision());
    }
    if (filtreRejetAssurance.accepter(p_temporel)) {
      return true;
    }
    return false;
  }
  
  public int getTypeElementManipule()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     FiltreRejetAssurance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */