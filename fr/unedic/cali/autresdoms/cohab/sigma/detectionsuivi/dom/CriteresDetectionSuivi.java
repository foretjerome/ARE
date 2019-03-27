package fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom.spec.CriteresDetectionSuiviSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.dom.StructureIn;

public class CriteresDetectionSuivi
  extends StructureIn
  implements CriteresDetectionSuiviSpec
{
  private String m_numeroAllocataire;
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public void setNumeroAllocataire(String p_numeroAllocataire)
  {
    m_numeroAllocataire = p_numeroAllocataire;
  }
}

/* Location:
 * Qualified Name:     CriteresDetectionSuivi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */