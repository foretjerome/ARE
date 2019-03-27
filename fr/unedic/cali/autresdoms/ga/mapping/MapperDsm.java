package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.ga.dom.DeclareAbsenceAuPointage;
import fr.unedic.cali.autresdoms.ga.dom.DeclareCongesNonPayes;
import fr.unedic.cali.autresdoms.ga.dom.DeclareMaladie;
import fr.unedic.cali.autresdoms.ga.dom.DeclareSuspensionContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.DeclareTravail;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeDeclare;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Actualisation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ChampsPeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeOrigineInformation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.OrigineInformation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.UniteDuree;
import java.math.BigDecimal;

class MapperDsm
{
  public static PeriodeDeclare mapper(PeriodeActivite p_periodeActiviteGa)
  {
    PeriodeDeclare periodeDeclare = new PeriodeDeclare(new Periode(p_periodeActiviteGa.getChampsPeriodeActivite().getDateDebut(), p_periodeActiviteGa.getChampsPeriodeActivite().getDateFin() != null ? p_periodeActiviteGa.getChampsPeriodeActivite().getDateFin() : Damj.FIN_DES_TEMPS));
    
    periodeDeclare.setIdentifiant(p_periodeActiviteGa.getChampsPeriodeActivite().getIdPeriodeActivite());
    if (p_periodeActiviteGa.getChampsPeriodeActivite().getTypePeriode().equals("11"))
    {
      periodeDeclare = mapperDsmTravail(p_periodeActiviteGa);
    }
    else if (p_periodeActiviteGa.getChampsPeriodeActivite().getTypePeriode().equals("12"))
    {
      periodeDeclare.setTypePeriodeDeclare(2);
    }
    else if (p_periodeActiviteGa.getChampsPeriodeActivite().getTypePeriode().equals("13"))
    {
      String origineInformation = mapperOriginesInfo(p_periodeActiviteGa.getChampsPeriodeActivite().getListeOrigineInformation());
      if ((origineInformation != null) && (origineInformation.equalsIgnoreCase(Integer.valueOf(70).toString()))) {
        periodeDeclare = mapperDsmAbsenceAuPointage(p_periodeActiviteGa);
      } else {
        periodeDeclare = mapperDsmMaladie(p_periodeActiviteGa);
      }
    }
    else if (p_periodeActiviteGa.getChampsPeriodeActivite().getTypePeriode().equals("20"))
    {
      periodeDeclare = mapperDeclareSuspensionContratTravail(p_periodeActiviteGa);
    }
    else if (p_periodeActiviteGa.getChampsPeriodeActivite().getTypePeriode().equals("21"))
    {
      periodeDeclare = mapperDeclareCongesNonPayes(p_periodeActiviteGa);
    }
    return periodeDeclare;
  }
  
  private static DeclareMaladie mapperDsmMaladie(PeriodeActivite p_periodeActivite)
  {
    DeclareMaladie dsmMaladie = new DeclareMaladie(new Periode(p_periodeActivite.getChampsPeriodeActivite().getDateDebut(), p_periodeActivite.getChampsPeriodeActivite().getDateFin() != null ? p_periodeActivite.getChampsPeriodeActivite().getDateFin() : Damj.FIN_DES_TEMPS));
    
    dsmMaladie.setIdentifiant(p_periodeActivite.getChampsPeriodeActivite().getIdPeriodeActivite());
    
    dsmMaladie.setTypePeriodeDeclare(1);
    return dsmMaladie;
  }
  
  private static DeclareAbsenceAuPointage mapperDsmAbsenceAuPointage(PeriodeActivite p_periodeActivite)
  {
    DeclareAbsenceAuPointage dsmAbsenceAuPointage = new DeclareAbsenceAuPointage(new Periode(p_periodeActivite.getChampsPeriodeActivite().getDateDebut(), p_periodeActivite.getChampsPeriodeActivite().getDateFin() != null ? p_periodeActivite.getChampsPeriodeActivite().getDateFin() : Damj.FIN_DES_TEMPS));
    
    dsmAbsenceAuPointage.setIdentifiant(p_periodeActivite.getChampsPeriodeActivite().getIdPeriodeActivite());
    
    dsmAbsenceAuPointage.setTypePeriodeDeclare(3);
    return dsmAbsenceAuPointage;
  }
  
  private static DeclareTravail mapperDsmTravail(PeriodeActivite p_periodeActivite)
  {
    DeclareTravail dsmTravail = null;
    Actualisation actualisation = p_periodeActivite.getActualisation();
    boolean estJustifieGaec = actualisation.getForcageDNJ().intValue() == 2;
    
    dsmTravail = new DeclareTravail(new Periode(p_periodeActivite.getChampsPeriodeActivite().getDateDebut(), p_periodeActivite.getChampsPeriodeActivite().getDateFin() != null ? p_periodeActivite.getChampsPeriodeActivite().getDateFin() : Damj.FIN_DES_TEMPS));
    
    dsmTravail.setEmployeur(actualisation.getLibelleEmployeur());
    
    dsmTravail.setIdentifiant(p_periodeActivite.getChampsPeriodeActivite().getIdPeriodeActivite());
    
    dsmTravail.setOrigineInfo(mapperOriginesInfo(p_periodeActivite.getChampsPeriodeActivite().getListeOrigineInformation()));
    
    dsmTravail.setStatutDSMTravail(actualisation.getStatutDSMTravail().intValue());
    if (estJustifieGaec)
    {
      dsmTravail.setEstJustifie(true);
      
      dsmTravail.setEstJustifieGaec(true);
    }
    else if ((dsmTravail.getStatutDSMTravail() == 1) || (dsmTravail.getStatutDSMTravail() == 3))
    {
      dsmTravail.setEstJustifie(false);
      
      dsmTravail.setEstJustifieGaec(false);
    }
    else
    {
      dsmTravail.setEstJustifie(true);
      
      dsmTravail.setEstJustifieGaec(true);
    }
    if (actualisation.getMontant() != null) {
      dsmTravail.setMontant(new QuantiteEuro(actualisation.getMontant()));
    } else {
      dsmTravail.setMontant(new QuantiteEuro(new BigDecimal("0")));
    }
    if (actualisation.getQuantite() != null) {
      dsmTravail.setQuantite(new Quantite(actualisation.getQuantite(), UniteDuree.HEURE));
    } else {
      dsmTravail.setQuantite(new Quantite(new BigDecimal("0"), UniteDuree.HEURE));
    }
    if (actualisation.getCachets() != null) {
      dsmTravail.setCachets(actualisation.getCachets());
    } else {
      dsmTravail.setCachets(new BigDecimal("0"));
    }
    return dsmTravail;
  }
  
  private static String mapperOriginesInfo(ListeOrigineInformation p_listeOrginesInfoGa)
  {
    String origineInformation = null;
    if (p_listeOrginesInfoGa != null)
    {
      BigDecimal origineInfo = p_listeOrginesInfoGa.getListeOrigineInformation(0).getCodeOrigineInformation();
      if (origineInfo != null) {
        origineInformation = origineInfo.toString();
      }
    }
    return origineInformation;
  }
  
  private static DeclareSuspensionContratTravail mapperDeclareSuspensionContratTravail(PeriodeActivite p_periodeActivite)
  {
    DeclareSuspensionContratTravail declareSuspensionContratTravail = new DeclareSuspensionContratTravail(new Periode(p_periodeActivite.getChampsPeriodeActivite().getDateDebut(), p_periodeActivite.getChampsPeriodeActivite().getDateFin() != null ? p_periodeActivite.getChampsPeriodeActivite().getDateFin() : Damj.FIN_DES_TEMPS));
    
    declareSuspensionContratTravail.setIdentifiant(p_periodeActivite.getChampsPeriodeActivite().getIdPeriodeActivite());
    
    declareSuspensionContratTravail.setTypePeriodeDeclare(4);
    declareSuspensionContratTravail.setOrigineInfo(mapperOriginesInfo(p_periodeActivite.getChampsPeriodeActivite().getListeOrigineInformation()));
    return declareSuspensionContratTravail;
  }
  
  private static DeclareCongesNonPayes mapperDeclareCongesNonPayes(PeriodeActivite p_periodeActivite)
  {
    DeclareCongesNonPayes declareCongesNonPayes = new DeclareCongesNonPayes(new Periode(p_periodeActivite.getChampsPeriodeActivite().getDateDebut(), p_periodeActivite.getChampsPeriodeActivite().getDateFin() != null ? p_periodeActivite.getChampsPeriodeActivite().getDateFin() : Damj.FIN_DES_TEMPS));
    
    declareCongesNonPayes.setIdentifiant(p_periodeActivite.getChampsPeriodeActivite().getIdPeriodeActivite());
    
    declareCongesNonPayes.setTypePeriodeDeclare(5);
    declareCongesNonPayes.setOrigineInfo(mapperOriginesInfo(p_periodeActivite.getChampsPeriodeActivite().getListeOrigineInformation()));
    return declareCongesNonPayes;
  }
}

/* Location:
 * Qualified Name:     MapperDsm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */