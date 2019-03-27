package fr.unedic.cali.utilitaire.filtres.composites;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutilDemande;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourNumeroGamme;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreReexamenSurDemande;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreValideeSurDecision;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation;
import fr.unedic.cali.utilitaire.filtres.metiers.FiltreDecisionDeMemeTypeSurDecisionPourDemande;
import fr.unedic.cali.utilitaire.filtres.metiers.FiltreDecisionPourCompetence;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionStandardAssurance
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final int COMPETENCE_NON_RENSEIGNEE = 0;
  private static final int COMPETENCE_ASSEDIC = 1;
  private DemandeSpec m_demande;
  private boolean m_filtrerCompetenceAdministrativeRac;
  private boolean m_filtrerDecisionValidee;
  private boolean m_filtrerDemandesNecessitantFinDeDroit;
  private boolean m_filtrerParType;
  
  public FiltreAttributionStandardAssurance(boolean p_estCompetenceAdministrativeRac, boolean p_estDecisionSansReexamen, boolean p_enleverDemandesNecessitantFinDeDroit, boolean p_filtrerParType, DemandeSpec p_demande)
  {
    m_demande = p_demande;
    m_filtrerCompetenceAdministrativeRac = p_estCompetenceAdministrativeRac;
    m_filtrerDecisionValidee = p_estDecisionSansReexamen;
    m_filtrerDemandesNecessitantFinDeDroit = p_enleverDemandesNecessitantFinDeDroit;
    m_filtrerParType = p_filtrerParType;
    if (((m_filtrerDemandesNecessitantFinDeDroit) || (m_filtrerParType)) && (p_demande == null)) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "demande" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean resultat = false;
    FiltreET filtreAttribution = new FiltreET();
    filtreAttribution.ajouterFiltre(new FiltreAttributionSurDecisions());
    filtreAttribution.ajouterFiltre(new FiltreDemandePourNumeroGamme(1));
    if (m_filtrerCompetenceAdministrativeRac) {
      filtreAttribution.ajouterFiltre(new FiltreDecisionPourCompetence(1, 0));
    }
    if (m_filtrerDemandesNecessitantFinDeDroit) {
      filtreAttribution.ajouterFiltre(OutilDemande.getFiltreAttributionAsuParType(m_demande));
    }
    if (m_filtrerParType) {
      filtreAttribution.ajouterFiltre(new FiltreDecisionDeMemeTypeSurDecisionPourDemande(m_demande));
    }
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
 * Qualified Name:     FiltreAttributionStandardAssurance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */