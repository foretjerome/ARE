package fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.StructureIn;
import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.spec.StructureInPecV1Spec;
import fr.unedic.util.temps.Damj;

public class StructureInPecV1
  extends StructureIn
  implements StructureInPecV1Spec
{
  private int m_identifiantPriseEnCharge;
  private Damj m_dateDeRecherche;
  
  public Damj getDateRecherche()
  {
    return m_dateDeRecherche;
  }
  
  public int getIdentifiantPriseEnCharge()
  {
    return m_identifiantPriseEnCharge;
  }
  
  public void setDateRecherche(Damj p_dateRecherche)
  {
    m_dateDeRecherche = p_dateRecherche;
  }
  
  public void setIdentifiantPriseEnCharge(int p_identifiantPriseEnCharge)
  {
    m_identifiantPriseEnCharge = p_identifiantPriseEnCharge;
  }
}

/* Location:
 * Qualified Name:     StructureInPecV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */