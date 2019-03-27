package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.Collection;

public class ResultatServiceLireActionsFormation
  extends Resultat
{
  private Collection m_collectionActionsFormation;
  private String m_numeroAllocataire;
  private boolean m_filtrageSurActionsNonLiees;
  private Collection m_tableIdActionsNonLiees;
  
  public boolean isFiltrageSurActionsNonLiees()
  {
    return m_filtrageSurActionsNonLiees;
  }
  
  public void setFiltrageSurActionsNonLiees(boolean p_filtrageSurActionsNonLiees)
  {
    m_filtrageSurActionsNonLiees = p_filtrageSurActionsNonLiees;
  }
  
  public Collection getCollectiondActionsNonLiees()
  {
    return m_tableIdActionsNonLiees;
  }
  
  public void setCollectionIdActionsNonLiees(Collection p_tableIdActionsNonLiees)
  {
    m_tableIdActionsNonLiees = p_tableIdActionsNonLiees;
  }
  
  public Collection getCollectionActionsFormation()
  {
    return m_collectionActionsFormation;
  }
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public void setCollectionActionsFormation(Collection p_collection)
  {
    m_collectionActionsFormation = p_collection;
  }
  
  public void setNumeroAllocataire(String p_string)
  {
    m_numeroAllocataire = p_string;
  }
}

/* Location:
 * Qualified Name:     ResultatServiceLireActionsFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */