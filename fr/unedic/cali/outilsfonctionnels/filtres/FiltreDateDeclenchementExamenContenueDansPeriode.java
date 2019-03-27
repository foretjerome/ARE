package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;

public class FiltreDateDeclenchementExamenContenueDansPeriode
  implements FiltreTemporel
{
  private Periode m_periode;
  
  public FiltreDateDeclenchementExamenContenueDansPeriode(Periode p_periode)
  {
    m_periode = p_periode;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    DemandeSpec demande = (DemandeSpec)p_temporel;
    return m_periode.contient(demande.getDateDeclenchementExamen());
  }
}

/* Location:
 * Qualified Name:     FiltreDateDeclenchementExamenContenueDansPeriode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */