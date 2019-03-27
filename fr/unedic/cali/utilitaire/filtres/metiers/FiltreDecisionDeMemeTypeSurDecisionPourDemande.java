package fr.unedic.cali.utilitaire.filtres.metiers;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenFiltrageDecisionSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Temporel;

public class FiltreDecisionDeMemeTypeSurDecisionPourDemande
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private EvenementReferenceExamenFiltrageDecisionSpec m_ereFiltrageDecisionSpec;
  
  public FiltreDecisionDeMemeTypeSurDecisionPourDemande(DemandeSpec p_demande)
  {
    if (p_demande == null)
    {
      m_ereFiltrageDecisionSpec = null;
    }
    else
    {
      if (!p_demande.getGamme().getNomUnique().equals("ASU")) {
        try
        {
          GestionnaireErreur.getInstance().genererException("PR_CALI_OBJET_TYPE_ATTENDUE", new Object[] { "demande assurance" }, 3);
        }
        catch (CoucheLogiqueException ex) {}
      }
      m_ereFiltrageDecisionSpec = ((EvenementReferenceExamenFiltrageDecisionSpec)p_demande.getEvenementReferenceExamen());
    }
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    if (m_ereFiltrageDecisionSpec == null) {
      return true;
    }
    FiltreCaliSpec filtre = m_ereFiltrageDecisionSpec.getFiltreRechercheDecisionDuMemeType();
    return filtre.accepter(p_temporel);
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreDecisionDeMemeTypeSurDecisionPourDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */