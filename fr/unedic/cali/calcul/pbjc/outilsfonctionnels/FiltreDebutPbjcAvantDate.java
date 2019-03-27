package fr.unedic.cali.calcul.pbjc.outilsfonctionnels;

import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.io.Serializable;

public class FiltreDebutPbjcAvantDate
  implements FiltreTemporel, Serializable
{
  private Damj m_dateSeuil;
  
  public FiltreDebutPbjcAvantDate(Damj p_dateSeuil)
  {
    m_dateSeuil = p_dateSeuil;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    Damj dateDebut = ((PbjcNcp)p_temporel).getDateDebutPbjc();
    if (dateDebut != null) {
      return dateDebut.estAvant(m_dateSeuil);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreDebutPbjcAvantDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */