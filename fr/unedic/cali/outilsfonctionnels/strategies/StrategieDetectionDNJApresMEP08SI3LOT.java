package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.autresdoms.ga.dom.DeclareTravail;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.periode.DsmTravail;
import java.util.Collection;

public class StrategieDetectionDNJApresMEP08SI3LOT
  implements StrategieDetectionDNJSpec
{
  public void determinerStatutPeriodeDeclaree(DeclareTravail p_dsmCourante)
  {
    if ((p_dsmCourante.getOrigineInfo().equals(Integer.toString(61))) || (p_dsmCourante.getOrigineInfo().equals(Integer.toString(69))))
    {
      if ((p_dsmCourante.getStatutDSMTravail() == 1) || (p_dsmCourante.getStatutDSMTravail() == 3)) {
        p_dsmCourante.setEstJustifie(false);
      }
    }
    else if ((p_dsmCourante.getOrigineInfo().equals(Integer.toString(62))) && (p_dsmCourante.getStatutDSMTravail() != 1)) {
      p_dsmCourante.setEstJustifie(true);
    } else {
      p_dsmCourante.setEstJustifie(false);
    }
  }
  
  public void enrichirListeDNJ(DsmTravail p_dsmCourant, UniteTraitement p_ut, Collection p_listePeriodeDNJ)
  {
    if ((p_dsmCourant.getStatutDSMTravail() == 1) || (p_dsmCourant.getStatutDSMTravail() == 3)) {
      if ((p_dsmCourant.getOrigineInfo().equals(Integer.toString(61))) || (p_dsmCourant.getOrigineInfo().equals(Integer.toString(69)))) {
        p_listePeriodeDNJ.add(p_dsmCourant);
      } else if ((p_ut.getStatut() != 3) && ((!p_dsmCourant.getOrigineInfo().equals(Integer.toString(62))) || (p_dsmCourant.getStatutDSMTravail() != 3))) {
        p_listePeriodeDNJ.add(p_dsmCourant);
      }
    }
  }
}

/* Location:
 * Qualified Name:     StrategieDetectionDNJApresMEP08SI3LOT
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */