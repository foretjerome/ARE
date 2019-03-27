package fr.unedic.cali.autresdoms.cohab.sigma.pension.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Criteres;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec.CriteresPensionSpec;

public class CriteresPension
  extends Criteres
  implements CriteresPensionSpec
{
  String m_numeroAllocataire = "";
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public void setNumeroAllocataire(String p_numeroAllocataire)
  {
    m_numeroAllocataire = p_numeroAllocataire;
  }
  
  public String toString()
  {
    return "CriteresPension [" + getNumeroAllocataire() + "]";
  }
}

/* Location:
 * Qualified Name:     CriteresPension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */