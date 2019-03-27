package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.OdSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreDemandeASSOdAquise
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    if ((p_temporel instanceof DemandeSpec))
    {
      DemandeSpec demande = (DemandeSpec)p_temporel;
      if ((demande.getNumeroGamme() == 1) && 
        (!demande.getListeDossiersExamen().isEmpty()) && 
        (((DemandeSpec)p_temporel).getListeDossiersExamen().get(0) != null) && (((DossierExamenSpec)((DemandeSpec)p_temporel).getListeDossiersExamen().get(0) instanceof OdSpec)))
      {
        Damj dji = ((AttributionSpec)demande.getDossierAffectation().getDossierExamen()).getCalendrierExecutionCalcul().getDernierJourIndemnisable();
        return dji.estApres(new Damj());
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandeASSOdAquise
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */