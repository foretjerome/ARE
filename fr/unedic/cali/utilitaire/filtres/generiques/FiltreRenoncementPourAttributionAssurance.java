package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.AttributionAssuranceSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionAssurance;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Temporel;

public class FiltreRenoncementPourAttributionAssurance
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private DemandeSpec m_demande;
  private boolean m_filtrerCompetenceAdministrativeRac;
  private boolean m_filtrerDecisionValidee;
  private boolean m_filtrerDemandesNecessitantFinDeDroit;
  private boolean m_filtrerParType;
  
  public FiltreRenoncementPourAttributionAssurance(boolean p_estCompetenceAdministrativeRac, boolean p_estDecisionSansReexamen, boolean p_enleverDemandesNecessitantFinDeDroit, boolean p_filtrerParType, DemandeSpec p_demande)
  {
    m_demande = p_demande;
    m_filtrerCompetenceAdministrativeRac = p_estCompetenceAdministrativeRac;
    m_filtrerDecisionValidee = p_estDecisionSansReexamen;
    m_filtrerDemandesNecessitantFinDeDroit = p_enleverDemandesNecessitantFinDeDroit;
    m_filtrerParType = p_filtrerParType;
    if (((m_filtrerDemandesNecessitantFinDeDroit) || (m_filtrerParType)) && (p_demande == null))
    {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "demande" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "demande" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean retour = false;
    FiltreAttributionAssurance filtreAttributionAssurance = new FiltreAttributionAssurance(m_filtrerCompetenceAdministrativeRac, m_filtrerDecisionValidee, m_filtrerDemandesNecessitantFinDeDroit, m_filtrerParType, m_demande);
    if ((filtreAttributionAssurance.accepter(p_temporel)) && (((AttributionAssuranceSpec)p_temporel).estTopeeRenoncement())) {
      retour = true;
    }
    return retour;
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreRenoncementPourAttributionAssurance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */