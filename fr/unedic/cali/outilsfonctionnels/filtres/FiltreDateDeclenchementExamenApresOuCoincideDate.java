package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDateDeclenchementExamenApresOuCoincideDate
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  private Damj m_dateSeuil;
  
  public FiltreDateDeclenchementExamenApresOuCoincideDate(Damj p_dateSeuil)
  {
    m_dateSeuil = p_dateSeuil;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    Damj dde = ((DemandeSpec)p_temporel).getDateDeclenchementExamen();
    if ((dde != null) && 
      (dde.estApresOuCoincideAvec(m_dateSeuil))) {
      return true;
    }
    return false;
  }
  
  public Damj getDateSeuil()
  {
    return m_dateSeuil;
  }
  
  public void setDateSeuil(Damj p_dateSeuil)
  {
    m_dateSeuil = p_dateSeuil;
  }
}

/* Location:
 * Qualified Name:     FiltreDateDeclenchementExamenApresOuCoincideDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */