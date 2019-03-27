package fr.unedic.cali.autresdoms.cohab.sigma.ressource.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Criteres;
import fr.unedic.cali.autresdoms.cohab.sigma.ressource.dom.spec.CriteresRessourcesSpec;

public class CriteresRessources
  extends Criteres
  implements CriteresRessourcesSpec
{
  private String m_numeroAllocataire;
  private String m_idDAL;
  private String m_typeSegmentV1;
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public void setNumeroAllocataire(String p_numeroAllocataire)
  {
    m_numeroAllocataire = p_numeroAllocataire;
  }
  
  public String getIdentifiantDemande()
  {
    return m_idDAL;
  }
  
  public void setIdentifiantDemande(String p_idDAL)
  {
    m_idDAL = p_idDAL;
  }
  
  public String getTypeSegmentV1()
  {
    return m_typeSegmentV1;
  }
  
  public void setTypeSegment(String p_typeSegmentV1)
  {
    m_typeSegmentV1 = p_typeSegmentV1;
  }
}

/* Location:
 * Qualified Name:     CriteresRessources
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */