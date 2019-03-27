package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.parcours.ResultatExecutionCalculSpec;
import fr.unedic.util.temps.Damj;

public class OutilReliquat
{
  public static Damj recupererDJIParEpuisement(DemandeSpec p_demande, AttributionSpec p_attribution, boolean p_verifierEpuisementHPec)
  {
    try
    {
      Damj djiRetour = null;
      
      p_attribution.setDemandeSuivantePourTraitementReliquat(p_demande);
      
      Damj djiParEpuisement = AppelCalculParLiquidation.executerCalculDeterminationEtatDroit(p_attribution, null, true).recupererDJIParEpuisement(p_attribution);
      Damj dateEtude;
      if ((djiParEpuisement != null) || (!p_verifierEpuisementHPec))
      {
        djiRetour = djiParEpuisement;
      }
      else
      {
        Damj dji = AppelCalculParLiquidation.executerCalculDeterminationEtatDroit(p_attribution, null, true).getDernierJourIndemnisable();
        if (dji != null)
        {
          ObjetChronoPeriodePriseEnCharge periodePEC = OutillagePEC.getPeriodePECIndemnisableContenant(p_attribution.getDemandeur(), dji.lendemain());
          if (periodePEC == null) {
            dateEtude = OutillagePEC.getPremierJourPECNonAnnuleesApresDate(p_attribution.getDemandeur(), dji.lendemain());
          }
        }
      }
      return AppelCalculParLiquidation.executerCalculDeterminationEtatDroit(p_attribution, dateEtude, true, true).recupererDJIParEpuisement(p_attribution);
    }
    catch (ApplicativeException ex) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     OutilReliquat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */