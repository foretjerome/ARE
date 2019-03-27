package fr.unedic.cali.autresdoms.cohab.sigma.formation.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.StructureIn;
import fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.spec.StructureInFormationV1Spec;
import fr.unedic.util.temps.Damj;

public class StructureInFormationV1
  extends StructureIn
  implements StructureInFormationV1Spec
{
  private Damj m_dateRecherche;
  private int m_identifiantFormation;
  
  public Damj getDateRecherche()
  {
    return m_dateRecherche;
  }
  
  public void setDateRecherche(Damj p_dateRecherche)
  {
    m_dateRecherche = p_dateRecherche;
  }
  
  public int getIdentifiantActionFormation()
  {
    return m_identifiantFormation;
  }
  
  public void setIdentifiantActionFormation(int p_identifiant)
  {
    m_identifiantFormation = p_identifiant;
  }
}

/* Location:
 * Qualified Name:     StructureInFormationV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */