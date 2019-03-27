package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;

public class FiltreChevauchePeriodesSurDemandes
  implements FiltreTemporel
{
  private Periode m_periodeChevauchement;
  
  public FiltreChevauchePeriodesSurDemandes(Periode p_periode)
  {
    m_periodeChevauchement = p_periode;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    DemandeSpec demande = (DemandeSpec)p_temporel;
    AttributionSpec attribution = (AttributionSpec)demande.getDossierAffectation().getDossierExamen();
    
    Damj pji = attribution.getPji();
    Damj dji = Damj.FIN_DES_TEMPS;
    if (attribution.getCalendrierExecutionCalcul() != null) {
      dji = attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable();
    }
    if ((p_temporel instanceof DemandeSpec)) {
      return m_periodeChevauchement.chevauche(new Periode(pji, dji));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreChevauchePeriodesSurDemandes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */