package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.OdAssuranceSpec;
import fr.unedic.cali.dom.OdSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.comparateurs.ComparateurDecisionCroissante;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionStandardAssurance;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;

public class FiltreFinDroitAssurancePourAttributionAssurance
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private OdSpec m_attribution;
  private Chronologie m_chronologieAttributionPourOd;
  
  public FiltreFinDroitAssurancePourAttributionAssurance(OdSpec p_attribution)
  {
    if (!(p_attribution instanceof OdAssuranceSpec)) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_OBJET_TYPE_ATTENDUE", new Object[] { "od assurance" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    m_attribution = p_attribution;
    m_chronologieAttributionPourOd = null;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean accepter = false;
    FiltreAttributionStandardAssurance filtre = new FiltreAttributionStandardAssurance(false, false, false, false, null);
    if (filtre.accepter(p_temporel))
    {
      if (m_chronologieAttributionPourOd == null)
      {
        FiltreET filtreEt = new FiltreET();
        filtreEt.ajouterFiltre(new FiltreAttributionAssurancesPourOD(m_attribution));
        filtreEt.ajouterFiltre(new FiltreNegation(new FiltreReexamenSurDemande()));
        
        m_chronologieAttributionPourOd = OutilRecherche.rechercherDecisionsSuivantes(m_attribution.getDemandeur().getChronoDemandesNonTriees(), m_attribution.getDateExamen().veille(), filtreEt);
        
        m_chronologieAttributionPourOd.setComparateur(new ComparateurDecisionCroissante());
      }
      AttributionSpec derniereAttributionPourOD = (AttributionSpec)m_chronologieAttributionPourOd.dernierElement();
      accepter = derniereAttributionPourOD.equals((AttributionSpec)p_temporel);
    }
    return accepter;
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreFinDroitAssurancePourAttributionAssurance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */