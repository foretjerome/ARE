package fr.unedic.cali.utilitaire.filtres.metiers;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.RechercherPeriodeIndemnisation;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionEnCoursIndemnisationPourDate
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private Damj m_dateInclue;
  private Periode m_periodeChevauchement;
  
  public FiltreAttributionEnCoursIndemnisationPourDate(Damj p_dateInclue)
  {
    if (p_dateInclue == null) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "date inclue" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    m_dateInclue = p_dateInclue;
  }
  
  public FiltreAttributionEnCoursIndemnisationPourDate(Periode p_periodeChevauchement)
  {
    if (p_periodeChevauchement == null) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "période chevauchement" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    m_periodeChevauchement = p_periodeChevauchement;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean retour = false;
    DecisionSpec decision = (DecisionSpec)p_temporel;
    FiltreAttributionSurDecisions filtreAttribution = new FiltreAttributionSurDecisions();
    if (filtreAttribution.accepter(p_temporel))
    {
      AttributionSpec attribution = (AttributionSpec)decision;
      Periode periode = RechercherPeriodeIndemnisation.getPeriodeIndemnisationPourAttribution(attribution);
      if ((periode != null) && (((m_dateInclue != null) && (m_dateInclue.estContenueDans(periode))) || ((m_periodeChevauchement != null) && (m_periodeChevauchement.chevauche(periode))))) {
        retour = true;
      }
    }
    return retour;
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreAttributionEnCoursIndemnisationPourDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */