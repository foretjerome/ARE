package fr.unedic.cali.dom;

import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.calcul.outilsfonctionnels.OutilGestionPoursuite;
import fr.unedic.cali.outilsfonctionnels.OutillagePEC;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;

public class MaintienEuropeen
{
  private static final int DUREE_CALENDAIRE_MOIS = 3;
  private transient DureeCalendaire m_duree;
  private transient Damj m_departPeriode;
  
  public MaintienEuropeen(Damj p_dateDepart, DureeCalendaire p_duree)
  {
    m_departPeriode = p_dateDepart;
    m_duree = p_duree;
  }
  
  public DureeCalendaire getDuree()
  {
    return m_duree;
  }
  
  public void setDuree(DureeCalendaire p_duree)
  {
    m_duree = p_duree;
  }
  
  public Damj getDepartPeriode()
  {
    return m_departPeriode;
  }
  
  public void setDepartPeriode(Damj p_departPeriode)
  {
    m_departPeriode = p_departPeriode;
  }
  
  private static Damj calculDepartMaintienEuropeen(AttributionSpec p_attribution)
  {
    Damj dateDerniereCiSuivantDroitPrecedentePecAutreEtatMembre = null;
    
    IndividuSpec demandeur = p_attribution.getDemandeur();
    if (p_attribution != null)
    {
      Damj dateReference = OutilGestionPoursuite.getInstance().recupererDateAttributionOuPjpSiPoursuite(p_attribution);
      
      ObjetChronoPeriodePriseEnCharge periodePecAttribution = OutillagePEC.getPeriodePECIndemnisableContenant(demandeur, dateReference);
      if (periodePecAttribution != null) {
        dateDerniereCiSuivantDroitPrecedentePecAutreEtatMembre = periodePecAttribution.getDateFin().lendemain();
      }
      if (dateDerniereCiSuivantDroitPrecedentePecAutreEtatMembre != null) {
        if (!OutillagePEC.estPecSuivanteAutreEtatMembreCoordination(demandeur, dateDerniereCiSuivantDroitPrecedentePecAutreEtatMembre)) {
          dateDerniereCiSuivantDroitPrecedentePecAutreEtatMembre = null;
        }
      }
    }
    return dateDerniereCiSuivantDroitPrecedentePecAutreEtatMembre;
  }
  
  public static MaintienEuropeen getInstanceMaintienEuropeen(AttributionSpec p_attribution)
  {
    DureeCalendaire dureeMaintien = new DureeCalendaire(0, 3);
    Damj dateDepartMaintien = calculDepartMaintienEuropeen(p_attribution);
    
    MaintienEuropeen retourMaintien = null;
    if (dateDepartMaintien != null) {
      retourMaintien = new MaintienEuropeen(dateDepartMaintien, dureeMaintien);
    }
    return retourMaintien;
  }
}

/* Location:
 * Qualified Name:     MaintienEuropeen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */