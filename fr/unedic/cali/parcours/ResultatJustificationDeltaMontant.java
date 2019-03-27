package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.Collection;

public class ResultatJustificationDeltaMontant
  extends Resultat
{
  private static final long serialVersionUID = 1L;
  private Collection m_listeDeltasMontantsMensuels;
  
  public Collection getListeDeltasMontantsMensuels()
  {
    return m_listeDeltasMontantsMensuels;
  }
  
  public void setListeDeltasMontantsMensuels(Collection p_listeDeltasMontantsMensuels)
  {
    m_listeDeltasMontantsMensuels = p_listeDeltasMontantsMensuels;
  }
}

/* Location:
 * Qualified Name:     ResultatJustificationDeltaMontant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */