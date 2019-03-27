package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public class ResultatLireAttribution
  extends Resultat
{
  private Collection m_listeAttributions = null;
  private Damj m_dateDernierFaitGenerateur = null;
  
  public Collection getListeAttributions()
  {
    return m_listeAttributions;
  }
  
  public void setListeAttributions(Collection p_listeAttributions)
  {
    m_listeAttributions = p_listeAttributions;
  }
  
  public Damj getDateDernierFaitGenerateur()
  {
    return m_dateDernierFaitGenerateur;
  }
  
  public void setDateDernierFaitGenerateur(Damj p_dateDernierFaitGenerateur)
  {
    m_dateDernierFaitGenerateur = p_dateDernierFaitGenerateur;
  }
}

/* Location:
 * Qualified Name:     ResultatLireAttribution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */