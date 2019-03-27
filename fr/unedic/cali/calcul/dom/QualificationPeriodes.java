package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.ChronologiePeriodes;
import java.util.ArrayList;
import java.util.List;

public class QualificationPeriodes
  implements ObjetMetierSpec
{
  public static final int TYPE_NON_QUALIFIE = 0;
  public static final int TYPE_INTERRUPTIVE_DEFINITIVE = 1;
  public static final int TYPE_INTERRUPTIVE = 2;
  public static final int TYPE_SEGMENTANTE = 3;
  public static final int TYPE_GELANTE = 4;
  public static final int TYPE_DECALANTE = 5;
  public static final int TYPE_SUSPENSIVE = 6;
  public static final int TYPE_ALERTANTE = 7;
  private static List typesListe = new ArrayList();
  private transient ChronologiePeriodes periodesNonQualifiees;
  private transient ChronologiePeriodes periodesInterruptivesDefinitives;
  private transient ChronologiePeriodes periodesInterruptives;
  private transient ChronologiePeriodes periodesSegmentantes;
  private transient ChronologiePeriodes periodesGelantes;
  private transient ChronologiePeriodes periodesDecalantes;
  private transient ChronologiePeriodes periodesSuspensives;
  private transient ChronologiePeriodes periodesSuspensivesDecoupesParSegmentants;
  private transient ChronologiePeriodes periodesAlertantes;
  
  static
  {
    typesListe.add(Integer.valueOf(1));
    typesListe.add(Integer.valueOf(2));
    typesListe.add(Integer.valueOf(3));
    typesListe.add(Integer.valueOf(4));
    typesListe.add(Integer.valueOf(5));
    typesListe.add(Integer.valueOf(6));
    typesListe.add(Integer.valueOf(7));
  }
  
  public QualificationPeriodes()
  {
    periodesNonQualifiees = null;
    periodesInterruptivesDefinitives = null;
    periodesInterruptives = null;
    periodesSegmentantes = null;
    periodesGelantes = null;
    periodesDecalantes = null;
    periodesSuspensives = null;
    periodesSuspensivesDecoupesParSegmentants = null;
    periodesAlertantes = null;
  }
  
  public ChronologiePeriodes getPeriodesParTypologie(int type)
  {
    ChronologiePeriodes result = null;
    switch (type)
    {
    case 5: 
      result = getPeriodesDecalantes();
      break;
    case 4: 
      result = getPeriodesGelantes();
      break;
    case 2: 
      result = getPeriodesInterruptives();
      break;
    case 1: 
      result = getPeriodesInterruptivesDefinitives();
      break;
    case 0: 
      result = getPeriodesNonQualifiees();
      break;
    case 3: 
      result = getPeriodesSegmentantes();
      break;
    case 6: 
      result = getPeriodesSuspensives();
      break;
    case 7: 
      result = getPeriodesAlertantes();
    }
    return result;
  }
  
  public static List getTypesList()
  {
    return typesListe;
  }
  
  public ChronologiePeriodes getPeriodesNonQualifiees()
  {
    if (periodesNonQualifiees == null) {
      periodesNonQualifiees = new ChronologiePeriodes();
    }
    return periodesNonQualifiees;
  }
  
  public ChronologiePeriodes getPeriodesDecalantes()
  {
    if (periodesDecalantes == null) {
      periodesDecalantes = new ChronologiePeriodes();
    }
    return periodesDecalantes;
  }
  
  public ChronologiePeriodes getPeriodesGelantes()
  {
    if (periodesGelantes == null) {
      periodesGelantes = new ChronologiePeriodes();
    }
    return periodesGelantes;
  }
  
  public ChronologiePeriodes getPeriodesInterruptives()
  {
    if (periodesInterruptives == null) {
      periodesInterruptives = new ChronologiePeriodes();
    }
    return periodesInterruptives;
  }
  
  public ChronologiePeriodes getPeriodesInterruptivesDefinitives()
  {
    if (periodesInterruptivesDefinitives == null) {
      periodesInterruptivesDefinitives = new ChronologiePeriodes();
    }
    return periodesInterruptivesDefinitives;
  }
  
  public ChronologiePeriodes getPeriodesSegmentantes()
  {
    if (periodesSegmentantes == null) {
      periodesSegmentantes = new ChronologiePeriodes();
    }
    return periodesSegmentantes;
  }
  
  public ChronologiePeriodes getPeriodesSuspensives()
  {
    if (periodesSuspensives == null) {
      periodesSuspensives = new ChronologiePeriodes();
    }
    return periodesSuspensives;
  }
  
  public ChronologiePeriodes getPeriodesSuspensivesDecoupesParSegmentants()
  {
    if (periodesSuspensivesDecoupesParSegmentants == null) {
      periodesSuspensivesDecoupesParSegmentants = new ChronologiePeriodes();
    }
    return periodesSuspensivesDecoupesParSegmentants;
  }
  
  public ChronologiePeriodes getPeriodesAlertantes()
  {
    if (periodesAlertantes == null) {
      periodesAlertantes = new ChronologiePeriodes();
    }
    return periodesAlertantes;
  }
  
  public void setPeriodesNonQualifiees(ChronologiePeriodes periodesNonQualifiees)
  {
    this.periodesNonQualifiees = periodesNonQualifiees;
  }
  
  public void setPeriodesGelantes(ChronologiePeriodes periodesGelantes)
  {
    this.periodesGelantes = periodesGelantes;
  }
  
  public void setPeriodesInterruptives(ChronologiePeriodes periodesInterruptives)
  {
    this.periodesInterruptives = periodesInterruptives;
  }
  
  public void setPeriodesInterruptivesDefinitives(ChronologiePeriodes periodesInterruptivesDefinitives)
  {
    this.periodesInterruptivesDefinitives = periodesInterruptivesDefinitives;
  }
  
  public void setPeriodesAlertantes(ChronologiePeriodes periodesAlertantes)
  {
    this.periodesAlertantes = periodesAlertantes;
  }
  
  public void setPeriodesDecalantes(ChronologiePeriodes periodesDecalantes)
  {
    this.periodesDecalantes = periodesDecalantes;
  }
  
  public void setPeriodesSuspensives(ChronologiePeriodes periodesSuspensives)
  {
    this.periodesSuspensives = periodesSuspensives;
  }
  
  public void setPeriodesSegmentantes(ChronologiePeriodes periodesSegmentantes)
  {
    this.periodesSegmentantes = periodesSegmentantes;
  }
  
  public void setPeriodesSuspensivesDecoupesParSegmentants(ChronologiePeriodes periodesSuspensivesDecoupesParSegmentants)
  {
    this.periodesSuspensivesDecoupesParSegmentants = periodesSuspensivesDecoupesParSegmentants;
  }
  
  public void setPeriodesParTypologie(int periodeType, ChronologiePeriodes chronologie)
  {
    switch (periodeType)
    {
    case 5: 
      setPeriodesDecalantes(chronologie);
      break;
    case 4: 
      setPeriodesGelantes(chronologie);
      break;
    case 2: 
      setPeriodesInterruptives(chronologie);
      break;
    case 1: 
      setPeriodesInterruptivesDefinitives(chronologie);
      break;
    case 3: 
      setPeriodesSegmentantes(chronologie);
      break;
    case 6: 
      setPeriodesSuspensives(chronologie);
      break;
    case 7: 
      setPeriodesAlertantes(chronologie);
    }
  }
  
  public void ajouterPeriodesNonQualifiees(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesNonQualifiees().ajouter(periode);
    }
  }
  
  public void ajouterPeriodesDecalantes(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesDecalantes().ajouter(periode);
    }
  }
  
  public void ajouterPeriodesGelantes(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesGelantes().ajouter(periode);
    }
  }
  
  public void ajouterPeriodesInterruptives(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesInterruptives().ajouter(periode);
    }
  }
  
  public void ajouterPeriodesInterruptivesDefinitives(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesInterruptivesDefinitives().ajouter(periode);
    }
  }
  
  public void ajouterPeriodesSegmentantes(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesSegmentantes().ajouter(periode);
    }
  }
  
  public void ajouterPeriodesSuspensives(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesSuspensives().ajouter(periode);
    }
  }
  
  public void ajouterPeriodesSuspensivesDecoupesParSegmentants(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesSuspensivesDecoupesParSegmentants().ajouter(periode);
    }
  }
  
  public void ajouterPeriodesAlertantes(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesAlertantes().ajouter(periode);
    }
  }
  
  public void ajouterChronologieSuspensivesDecoupesParSegmentants(ChronologiePeriodes chronoPeriode)
  {
    ChronologiePeriodes chronologieExistante = getPeriodesSuspensivesDecoupesParSegmentants();
    if (chronoPeriode != null)
    {
      chronoPeriode.iterer();
      while (chronoPeriode.encoreSuivant())
      {
        ObjetChronoPeriodeCalcul periode = (ObjetChronoPeriodeCalcul)chronoPeriode.elementSuivant();
        if (!chronologieExistante.contientElement(periode)) {
          ajouterPeriodesSuspensivesDecoupesParSegmentants(periode);
        }
      }
    }
  }
  
  public void supprimerPeriodesNonQualifiees(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesNonQualifiees().supprimer(periode);
    }
  }
  
  public void supprimerPeriodesDecalantes(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesDecalantes().supprimer(periode);
    }
  }
  
  public void supprimerPeriodesGelantes(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesGelantes().supprimer(periode);
    }
  }
  
  public void supprimerPeriodesInterruptives(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesInterruptives().supprimer(periode);
    }
  }
  
  public void supprimerPeriodesInterruptivesDefinitives(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesInterruptivesDefinitives().supprimer(periode);
    }
  }
  
  public void supprimerPeriodesSegmentantes(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesSegmentantes().supprimer(periode);
    }
  }
  
  public void supprimerPeriodesSuspensives(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesSuspensives().supprimer(periode);
    }
  }
  
  public void supprimerPeriodesSuspensivesDecoupesParSegmentants(ObjetChronoPeriodeCalcul periode)
  {
    if (periode != null) {
      getPeriodesSuspensivesDecoupesParSegmentants().supprimer(periode);
    }
  }
  
  public String toString()
  {
    StringBuffer string = new StringBuffer("Qualification Periodes\n");
    if (!getPeriodesNonQualifiees().estVide()) {
      string.append("Periodes Non Qualifiées : " + periodesNonQualifiees + "\n");
    }
    if (!getPeriodesInterruptivesDefinitives().estVide()) {
      string.append("Periodes Interruptives Definitives : " + getPeriodesInterruptivesDefinitives() + "\n");
    }
    if (!getPeriodesInterruptives().estVide()) {
      string.append("Periodes Interruptives : " + getPeriodesInterruptives() + "\n");
    }
    if (!getPeriodesSegmentantes().estVide()) {
      string.append("Periodes Segmentantes : " + getPeriodesSegmentantes() + "\n");
    }
    if (!getPeriodesGelantes().estVide()) {
      string.append("Periodes Gelantes : " + getPeriodesGelantes() + "\n");
    }
    if (!getPeriodesDecalantes().estVide()) {
      string.append("Periodes Decalantes : " + getPeriodesDecalantes() + "\n");
    }
    if (!getPeriodesSuspensives().estVide()) {
      string.append("Periodes Suspensives : " + getPeriodesSuspensives() + "\n");
    }
    return string.toString();
  }
  
  public ObjetMetierSpec copie()
  {
    QualificationPeriodes copie = new QualificationPeriodes();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    QualificationPeriodes copie = (QualificationPeriodes)pcopie;
    if (getPeriodesNonQualifiees() != null) {
      periodesNonQualifiees = ((ChronologiePeriodes)getPeriodesNonQualifiees().copie());
    }
    if (getPeriodesInterruptivesDefinitives() != null) {
      periodesInterruptivesDefinitives = ((ChronologiePeriodes)getPeriodesInterruptivesDefinitives().copie());
    }
    if (getPeriodesInterruptives() != null) {
      periodesInterruptives = ((ChronologiePeriodes)getPeriodesInterruptives().copie());
    }
    if (getPeriodesSegmentantes() != null) {
      periodesSegmentantes = ((ChronologiePeriodes)getPeriodesSegmentantes().copie());
    }
    if (getPeriodesGelantes() != null) {
      periodesGelantes = ((ChronologiePeriodes)getPeriodesGelantes().copie());
    }
    if (getPeriodesDecalantes() != null) {
      periodesDecalantes = ((ChronologiePeriodes)getPeriodesDecalantes().copie());
    }
    if (getPeriodesSuspensives() != null) {
      periodesSuspensives = ((ChronologiePeriodes)getPeriodesSuspensives().copie());
    }
    if (getPeriodesSuspensivesDecoupesParSegmentants() != null) {
      periodesSuspensivesDecoupesParSegmentants = ((ChronologiePeriodes)getPeriodesSuspensivesDecoupesParSegmentants().copie());
    }
  }
}

/* Location:
 * Qualified Name:     QualificationPeriodes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */