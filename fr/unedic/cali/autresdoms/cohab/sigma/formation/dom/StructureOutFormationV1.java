package fr.unedic.cali.autresdoms.cohab.sigma.formation.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.spec.ActionFormationSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.spec.StructureOutFormationV1Spec;
import java.util.ArrayList;
import java.util.Collection;

public class StructureOutFormationV1
  implements StructureOutFormationV1Spec
{
  private Collection m_listeActionFormation = new ArrayList();
  
  public void ajouterActionFormation(ActionFormationSpec p_actionFormation)
  {
    if (m_listeActionFormation == null) {
      m_listeActionFormation = new ArrayList();
    }
    m_listeActionFormation.add(p_actionFormation);
  }
  
  public Collection getListeActionFormation()
  {
    return m_listeActionFormation;
  }
  
  public String toString()
  {
    return getListeActionFormation().toString();
  }
}

/* Location:
 * Qualified Name:     StructureOutFormationV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */