package fr.unedic.cali.autresdoms.cohab.sigma.ressource.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.StructureIn;
import fr.unedic.cali.autresdoms.cohab.sigma.ressource.dom.spec.StructureInRessourcesV1Spec;

public class StructureInRessourcesV1
  extends StructureIn
  implements StructureInRessourcesV1Spec
{
  private String m_typeSegment;
  private String m_identifiantDemande;
  
  public String getIdentifiantDemande()
  {
    return m_identifiantDemande;
  }
  
  public String getTypeSegment()
  {
    return m_typeSegment;
  }
  
  public void setIdentifiantDemande(String p_identifiantDemande)
  {
    m_identifiantDemande = p_identifiantDemande;
  }
  
  public void setTypeSegment(String p_typeSegment)
  {
    m_typeSegment = p_typeSegment;
  }
}

/* Location:
 * Qualified Name:     StructureInRessourcesV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */