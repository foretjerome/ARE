package fr.unedic.cali.autresdoms.cohab.sigma.demande.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeV1Spec;
import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.StructureOutDemandeV1Spec;
import java.util.ArrayList;
import java.util.Collection;

public class StructureOutDemandeV1
  implements StructureOutDemandeV1Spec
{
  private Collection m_listeDemandes;
  
  public StructureOutDemandeV1()
  {
    m_listeDemandes = new ArrayList();
  }
  
  public void ajouterDemande(DemandeV1Spec p_demande)
  {
    m_listeDemandes.add(p_demande);
  }
  
  public Collection getListeDemandes()
  {
    return m_listeDemandes;
  }
}

/* Location:
 * Qualified Name:     StructureOutDemandeV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */