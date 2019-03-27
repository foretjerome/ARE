package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.services.Resultat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResultatPilotage
  extends Resultat
{
  private List m_resultatsDetailles = null;
  private ResultatVisualisationCalcul m_resultatVisualisationCalcul = null;
  
  public final List getResultatsDetailles()
  {
    return m_resultatsDetailles;
  }
  
  public final void setResultatsDetailles(List p_resultatsDetailles)
  {
    m_resultatsDetailles = p_resultatsDetailles;
  }
  
  public final ResultatDetailleProduit getResultatDetaille(AttributionSpec p_attribution)
  {
    ResultatDetailleProduit retour = null;
    ResultatDetailleProduit resultatDetailleProduit = null;
    Iterator iter = null;
    if ((p_attribution != null) && (getResultatsDetailles() != null))
    {
      iter = getResultatsDetailles().iterator();
      while ((iter.hasNext()) && (retour == null))
      {
        resultatDetailleProduit = (ResultatDetailleProduit)iter.next();
        if ((resultatDetailleProduit != null) && (resultatDetailleProduit.getAttribution() != null) && (p_attribution == resultatDetailleProduit.getAttribution())) {
          retour = resultatDetailleProduit;
        }
      }
    }
    return retour;
  }
  
  public final void ajouteResultatDetaille(ResultatDetailleProduit p_resultat)
  {
    List resultatsDetaillesList = getResultatsDetailles();
    if (resultatsDetaillesList == null)
    {
      resultatsDetaillesList = new ArrayList();
      setResultatsDetailles(resultatsDetaillesList);
    }
    resultatsDetaillesList.add(p_resultat);
  }
  
  public ResultatVisualisationCalcul getResultatVisualisationCalcul()
  {
    return m_resultatVisualisationCalcul;
  }
  
  public void setResultatVisualisationCalcul(ResultatVisualisationCalcul p_resultatVisualisationCalcul)
  {
    m_resultatVisualisationCalcul = p_resultatVisualisationCalcul;
  }
}

/* Location:
 * Qualified Name:     ResultatPilotage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */