package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.services.Resultat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ResultatVisualisationCalcul
  extends Resultat
{
  private static final long serialVersionUID = -6640213064461980018L;
  private BigDecimal m_deltaMontantIndemnise = new BigDecimal("0");
  private List m_resultatsVisualisationDetaillee = new ArrayList();
  private Collection m_listeEcartsBases;
  private Collection m_listeDeltasMontantsMensuels;
  
  public final BigDecimal getDeltaMontantIndemnise()
  {
    return m_deltaMontantIndemnise;
  }
  
  public final void setDeltaMontantIndemnise(BigDecimal p_deltaMontantIndemnise)
  {
    m_deltaMontantIndemnise = p_deltaMontantIndemnise;
  }
  
  public final List getResultatsVisualisationDetaillee()
  {
    return m_resultatsVisualisationDetaillee;
  }
  
  public final void setResultatsVisualisationDetaillee(List p_resultatsVisualisationDetaillee)
  {
    m_resultatsVisualisationDetaillee = p_resultatsVisualisationDetaillee;
  }
  
  public final ResultatVisualisationDetailleeProduit getResultatVisualisationDetaillee(AttributionSpec p_attribution)
  {
    ResultatVisualisationDetailleeProduit retour = null;
    ResultatVisualisationDetailleeProduit resultatVisualisationDetailleeProduit = null;
    Iterator iter = null;
    if ((p_attribution != null) && (getResultatsVisualisationDetaillee() != null))
    {
      iter = getResultatsVisualisationDetaillee().iterator();
      while ((iter.hasNext()) && (retour == null))
      {
        resultatVisualisationDetailleeProduit = (ResultatVisualisationDetailleeProduit)iter.next();
        if ((resultatVisualisationDetailleeProduit != null) && (resultatVisualisationDetailleeProduit.getAttribution() != null) && (p_attribution == resultatVisualisationDetailleeProduit.getAttribution())) {
          retour = resultatVisualisationDetailleeProduit;
        }
      }
    }
    return retour;
  }
  
  public final void ajouterResultatsVisualisationDetailleeProduit(ResultatVisualisationDetailleeProduit p_resultatVisualisationDetailleeProduit)
  {
    m_resultatsVisualisationDetaillee.add(p_resultatVisualisationDetailleeProduit);
  }
  
  public Collection getListeEcartsBases()
  {
    return m_listeEcartsBases;
  }
  
  public void setListeEcartsBases(Collection p_listeEcartsBases)
  {
    m_listeEcartsBases = p_listeEcartsBases;
  }
  
  public Collection getListeDeltasMontantsMensuels()
  {
    return m_listeDeltasMontantsMensuels;
  }
  
  public void setListeDeltasMontantsMensuels(Collection p_listeDeltasMontantsMensuels)
  {
    m_listeDeltasMontantsMensuels = p_listeDeltasMontantsMensuels;
  }
}

/* Location:
 * Qualified Name:     ResultatVisualisationCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */