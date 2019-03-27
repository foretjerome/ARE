package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandeDateAttributionContenueDansPeriode
  implements FiltreTemporel
{
  private Periode m_periode;
  
  public FiltreDemandeDateAttributionContenueDansPeriode(Periode p_periode)
  {
    m_periode = p_periode;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      DemandeSpec demande = (DemandeSpec)p_temporel;
      return m_periode.contient(demande.getDossierAffectation().getDossierExamen().getDateAttribution());
    }
    catch (RuntimeException ex) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandeDateAttributionContenueDansPeriode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */