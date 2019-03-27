package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.AttributionAssuranceSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.OdAssuranceSpec;
import fr.unedic.cali.dom.OdSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionStandardAssurance;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Temporel;

public class FiltreAttributionAssurancesPourOD
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = -6461058277667157602L;
  private AttributionSpec m_attribution = null;
  
  public FiltreAttributionAssurancesPourOD(OdSpec p_attribution)
  {
    if (!(p_attribution instanceof OdAssuranceSpec)) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_OBJET_TYPE_ATTENDUE", new Object[] { "od assurance" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    m_attribution = p_attribution;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean accepter = false;
    FiltreET filtreET = new FiltreET();
    filtreET.ajouterFiltre(new FiltreAttributionStandardAssurance(false, false, false, false, null));
    filtreET.ajouterFiltre(new FiltreDecisionPourProduit(m_attribution.getProduit().getCode()));
    if (filtreET.accepter(p_temporel))
    {
      AttributionAssuranceSpec attribution = (AttributionAssuranceSpec)p_temporel;
      accepter = m_attribution.equals(attribution.getOuvertureDroit());
    }
    return accepter;
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreAttributionAssurancesPourOD
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */