package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.Collection;

public class ResultatLirePeriodesActivites
  extends Resultat
{
  private Collection m_collectionPeriodesActivites;
  private Collection m_tablePeriodesActivitesLiees;
  
  public Collection getCollectionPeriodesActivites()
  {
    return m_collectionPeriodesActivites;
  }
  
  public void setCollectionPeriodesActivites(Collection p_collectionPeriodesActivites)
  {
    m_collectionPeriodesActivites = p_collectionPeriodesActivites;
  }
  
  public Collection getTablePeriodesActivitesLiees()
  {
    return m_tablePeriodesActivitesLiees;
  }
  
  public void setTablePeriodesActivitesLiees(Collection p_tablePeriodesActivitesLiees)
  {
    m_tablePeriodesActivitesLiees = p_tablePeriodesActivitesLiees;
  }
}

/* Location:
 * Qualified Name:     ResultatLirePeriodesActivites
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */