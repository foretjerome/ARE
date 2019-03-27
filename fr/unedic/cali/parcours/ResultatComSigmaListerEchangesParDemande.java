package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.Map;

public class ResultatComSigmaListerEchangesParDemande
  extends Resultat
{
  private Map m_mapEchanges;
  
  public Map getListeEchanges()
  {
    return m_mapEchanges;
  }
  
  public void setListeEchanges(Map p_listeEchanges)
  {
    m_mapEchanges = p_listeEchanges;
  }
}

/* Location:
 * Qualified Name:     ResultatComSigmaListerEchangesParDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */