package fr.unedic.cali.calcul.pbjc.outilsfonctionnels;

import fr.unedic.cali.calcul.pbjc.dom.PrimePbjcNcp;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.io.Serializable;

public class FiltrePrimeAvantDate
  implements FiltreTemporel, Serializable
{
  private Damj m_dateSeuil;
  
  public FiltrePrimeAvantDate(Damj p_dateSeuil)
  {
    m_dateSeuil = p_dateSeuil;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    Damj dateEffet = ((PrimePbjcNcp)p_temporel).getDateEffet();
    if (dateEffet != null) {
      return dateEffet.estAvant(m_dateSeuil);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltrePrimeAvantDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */