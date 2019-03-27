package fr.unedic.cali.utilitaire.filtres.composites;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreOuvertureDroitSurDecision;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.util.temps.Temporel;

public class FiltreOuvertureDroitAssurance
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private DemandeSpec m_demande;
  private boolean m_filtrerCompetenceAdministrativeRac;
  private boolean m_filtrerDecisionValidee;
  private boolean m_filtrerDemandesNecessitantFinDeDroit;
  private boolean m_filtrerParType;
  
  public FiltreOuvertureDroitAssurance(boolean p_estCompetenceAdministrativeRac, boolean p_estDecisionSansReexamen, boolean p_enleverDemandesNecessitantFinDeDroit, boolean p_filtrerParType, DemandeSpec p_demande)
  {
    m_demande = p_demande;
    m_filtrerCompetenceAdministrativeRac = p_estCompetenceAdministrativeRac;
    m_filtrerDecisionValidee = p_estDecisionSansReexamen;
    m_filtrerDemandesNecessitantFinDeDroit = p_enleverDemandesNecessitantFinDeDroit;
    m_filtrerParType = p_filtrerParType;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean resultat = false;
    FiltreET filtreOdValide = new FiltreET();
    filtreOdValide.ajouterFiltre(new FiltreOuvertureDroitSurDecision());
    filtreOdValide.ajouterFiltre(new FiltreAttributionStandardAssurance(m_filtrerCompetenceAdministrativeRac, m_filtrerDecisionValidee, m_filtrerDemandesNecessitantFinDeDroit, m_filtrerParType, m_demande));
    if (filtreOdValide.accepter(p_temporel)) {
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
 * Qualified Name:     FiltreOuvertureDroitAssurance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */