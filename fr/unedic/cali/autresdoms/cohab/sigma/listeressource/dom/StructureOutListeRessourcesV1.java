package fr.unedic.cali.autresdoms.cohab.sigma.listeressource.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.listeressource.dom.spec.RessourceSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.listeressource.dom.spec.StructureOutListeRessourcesV1Spec;
import java.util.ArrayList;
import java.util.Collection;

public class StructureOutListeRessourcesV1
  implements StructureOutListeRessourcesV1Spec
{
  private Collection m_listeRessourcesV1 = new ArrayList();
  
  public Collection getListeRessourcesV1()
  {
    return m_listeRessourcesV1;
  }
  
  public void ajouterRessource(RessourceSpec p_ressource)
  {
    if (m_listeRessourcesV1 == null) {
      m_listeRessourcesV1 = new ArrayList();
    }
    m_listeRessourcesV1.add(p_ressource);
  }
}

/* Location:
 * Qualified Name:     StructureOutListeRessourcesV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */