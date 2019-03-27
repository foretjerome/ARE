package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import java.util.Iterator;

public abstract class QualificationAbstraite
{
  public static final int DUREE_PERIODE_INTER_STAGE_FORMATION = 15;
  public static final Damj DATE_PIVOT_DEBUT_SUSPENSION_AIS_SOL = new Damj(2009, 1, 1);
  public static final Damj DATE_PIVOT_FIN_SUSPENSION_AIS_SOL = new Damj(2009, 6, 19);
  
  public QualificationPeriodes qualificationPeriodes(ChronologiePeriodes chronologiePeriodes, AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    QualificationPeriodes qualificationPeriodes = new QualificationPeriodes();
    
    Iterator iterator = chronologiePeriodes.iterer();
    while (iterator.hasNext())
    {
      ObjetChronoPeriodeCalcul periode = (ObjetChronoPeriodeCalcul)iterator.next();
      boolean resultat = qualifierUnePeriodeInterruptivesDefinitives(periode, qualificationPeriodes, attribution);
      resultat = (qualifierUnePeriodeInterruptives(periode, qualificationPeriodes, attribution)) || (resultat);
      resultat = (qualifierUnePeriodeSuspensives(periode, qualificationPeriodes, attribution)) || (resultat);
      resultat = (qualifierUnePeriodeSegmentante(periode, qualificationPeriodes, attribution)) || (resultat);
      resultat = (qualifierUnePeriodeDecalante(periode, qualificationPeriodes, attribution)) || (resultat);
      resultat = (qualifierUnePeriodeGelante(periode, qualificationPeriodes, attribution)) || (resultat);
      resultat = (qualifierUnePeriodeAlertante(periode, qualificationPeriodes, attribution)) || (resultat);
      if ((!resultat) && (estTypeAPrendreEnCompte(periode))) {
        qualificationPeriodes.ajouterPeriodesNonQualifiees(periode);
      }
    }
    return qualificationPeriodes;
  }
  
  public QualificationPeriodes qualificationPeriodesPourAvant(ChronologiePeriodes chronologiePeriodes, AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    QualificationPeriodes qualificationPeriodes = new QualificationPeriodes();
    
    Iterator iterator = chronologiePeriodes.iterer();
    while (iterator.hasNext())
    {
      ObjetChronoPeriodeCalcul periode = (ObjetChronoPeriodeCalcul)iterator.next();
      boolean resultat = qualifierUnePeriodeInterruptivesDefinitives(periode, qualificationPeriodes, attribution);
      resultat = (qualifierUnePeriodeSuspensives(periode, qualificationPeriodes, attribution)) || (resultat);
      resultat = (qualifierUnePeriodeDecalantePourAvant(periode, qualificationPeriodes, attribution)) || (resultat);
      resultat = (qualifierUnePeriodeInterruptives(periode, qualificationPeriodes, attribution)) || (resultat);
      resultat = (qualifierUnePeriodeAlertante(periode, qualificationPeriodes, attribution)) || (resultat);
      if ((!resultat) && (estTypeAPrendreEnCompte(periode))) {
        qualificationPeriodes.ajouterPeriodesNonQualifiees(periode);
      }
    }
    return qualificationPeriodes;
  }
  
  protected abstract boolean qualifierUnePeriodeInterruptivesDefinitives(ObjetChronoPeriodeCalcul paramObjetChronoPeriodeCalcul, QualificationPeriodes paramQualificationPeriodes, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  protected abstract boolean qualifierUnePeriodeSuspensives(ObjetChronoPeriodeCalcul paramObjetChronoPeriodeCalcul, QualificationPeriodes paramQualificationPeriodes, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  protected abstract boolean qualifierUnePeriodeSegmentante(ObjetChronoPeriodeCalcul paramObjetChronoPeriodeCalcul, QualificationPeriodes paramQualificationPeriodes, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  protected abstract boolean qualifierUnePeriodeDecalante(ObjetChronoPeriodeCalcul paramObjetChronoPeriodeCalcul, QualificationPeriodes paramQualificationPeriodes, AttributionSpec paramAttributionSpec);
  
  protected boolean qualifierUnePeriodeDecalantePourAvant(ObjetChronoPeriodeCalcul periode, QualificationPeriodes qualificationPeriodes, AttributionSpec attribution)
  {
    return false;
  }
  
  protected abstract boolean qualifierUnePeriodeGelante(ObjetChronoPeriodeCalcul paramObjetChronoPeriodeCalcul, QualificationPeriodes paramQualificationPeriodes, AttributionSpec paramAttributionSpec);
  
  protected abstract boolean qualifierUnePeriodeInterruptives(ObjetChronoPeriodeCalcul paramObjetChronoPeriodeCalcul, QualificationPeriodes paramQualificationPeriodes, AttributionSpec paramAttributionSpec);
  
  protected abstract boolean qualifierUnePeriodeAlertante(ObjetChronoPeriodeCalcul paramObjetChronoPeriodeCalcul, QualificationPeriodes paramQualificationPeriodes, AttributionSpec paramAttributionSpec);
  
  protected abstract boolean estTypeAPrendreEnCompte(ObjetChronoPeriode paramObjetChronoPeriode);
  
  protected boolean estTypeAPrendreEnCompte(ObjetChronoPeriodeCalcul periode)
  {
    return estTypeAPrendreEnCompte((ObjetChronoPeriode)periode);
  }
}

/* Location:
 * Qualified Name:     QualificationAbstraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */