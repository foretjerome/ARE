package fr.unedic.cali.autresdoms.cohab.sigma.individu.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Criteres;
import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.spec.CriteresIndividuSpec;

public class CriteresIndividu
  extends Criteres
  implements CriteresIndividuSpec
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
 * Qualified Name:     CriteresIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */