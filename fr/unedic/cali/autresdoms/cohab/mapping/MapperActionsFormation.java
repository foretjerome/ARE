package fr.unedic.cali.autresdoms.cohab.mapping;

import fr.unedic.util.Quantite;
import fr.unedic.util.UniteAffiliation;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class MapperActionsFormation
{
  public static Collection mapper(Collection collectionActionsFormationCojac)
  {
    Collection listeCali = new ArrayList();
    if (collectionActionsFormationCojac != null)
    {
      Iterator iter = collectionActionsFormationCojac.iterator();
      while (iter.hasNext())
      {
        fr.unedic.cali.autresdoms.ga.dom.ActionFormation action = mapperUneActionFormation((fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.ActionFormation)iter.next());
        listeCali.add(action);
      }
    }
    return listeCali;
  }
  
  public static fr.unedic.cali.autresdoms.ga.dom.ActionFormation mapperUneActionFormation(fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.ActionFormation actionFormationCojac)
  {
    fr.unedic.cali.autresdoms.ga.dom.ActionFormation actionFormationCali = new fr.unedic.cali.autresdoms.ga.dom.ActionFormation();
    if (actionFormationCojac.getAffDerogatoire().equals("O")) {
      actionFormationCali.setAffDerogatoire("O");
    } else if (actionFormationCojac.getAffDerogatoire().equals("N")) {
      actionFormationCali.setAffDerogatoire("N");
    } else {
      actionFormationCali.setAffDerogatoire("X");
    }
    actionFormationCali.setDateDebut(actionFormationCojac.getDateDebut());
    actionFormationCali.setDateFin(actionFormationCojac.getDateFin());
    actionFormationCali.setIdentifiant(Integer.valueOf(actionFormationCojac.getIdentifiantActionFormation()).toString());
    
    actionFormationCali.setLibelleLieu(actionFormationCojac.getLibelleLieu());
    actionFormationCali.setNomOrganismeFormation(actionFormationCojac.getLibelleOrganisme());
    actionFormationCali.setNumeroConvention(actionFormationCojac.getNumeroConvention());
    
    actionFormationCali.setQuantiteHoraireHebdo(new Quantite(actionFormationCojac.getQuantiteHoraireHebdo().getValeur(), UniteAffiliation.HEURE_TRAVAIL));
    
    actionFormationCali.setDureeTotale(new Quantite(actionFormationCojac.getQuantiteHoraireTotal().getValeur(), UniteAffiliation.HEURE_TRAVAIL));
    
    actionFormationCali.setTypePlanFormation(actionFormationCojac.getTypePlanFormation());
    
    actionFormationCali.setStatut(actionFormationCojac.getEtat());
    
    String typeConvention = actionFormationCojac.getTypeConvention();
    if (typeConvention.equals("C")) {
      actionFormationCali.setTypeConvention(3);
    } else if (typeConvention.equals("P")) {
      actionFormationCali.setTypeConvention(1);
    } else if (typeConvention.equals("X")) {
      actionFormationCali.setTypeConvention(6);
    } else if (typeConvention.equals("N")) {
      actionFormationCali.setTypeConvention(5);
    } else if (typeConvention.equals("A")) {
      actionFormationCali.setTypeConvention(4);
    } else if (typeConvention.equals("H")) {
      actionFormationCali.setTypeConvention(2);
    }
    Chronologie chronoPeriodesFormation = actionFormationCojac.getCollectionPeriodesFormation();
    if (chronoPeriodesFormation != null)
    {
      Damj dateFinActionFormation = Damj.NUIT_DES_TEMPS;
      chronoPeriodesFormation.iterer();
      while (chronoPeriodesFormation.encoreSuivant())
      {
        fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation periodeFormation = mapperUnePeriodeFormation((fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.PeriodeFormation)chronoPeriodesFormation.elementSuivant(), actionFormationCojac.getTypeMesureEmploi());
        actionFormationCali.ajouterPeriodeFormation(periodeFormation);
        if ((periodeFormation != null) && (periodeFormation.getDateFin() != null) && (periodeFormation.getDateFin().estApres(dateFinActionFormation)) && (periodeFormation.getDateFin().estContenueDans(actionFormationCali.getPeriode()))) {
          dateFinActionFormation = periodeFormation.getDateFin();
        }
      }
      if (dateFinActionFormation.estContenueDans(actionFormationCali.getPeriode())) {
        actionFormationCali.setDateFin(dateFinActionFormation);
      }
    }
    actionFormationCali.setDatePrescription(actionFormationCojac.getDatePrescription());
    return actionFormationCali;
  }
  
  private static fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation mapperUnePeriodeFormation(fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.PeriodeFormation periodeFormation, String typeMesureEmploi)
  {
    fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation periodeFormationCali = new fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation();
    periodeFormationCali.setDateDebut(periodeFormation.getDateDebut());
    periodeFormationCali.setDateFin(periodeFormation.getDateFin());
    if ((periodeFormation.getPeriodeEffective() != null) && (periodeFormation.getPeriodeEffective().getDebut() != null)) {
      periodeFormationCali.setPeriodeEffective(periodeFormation.getPeriodeEffective());
    }
    periodeFormationCali.setIdentifiant(Integer.valueOf(periodeFormation.getNumeroPeriodeFormation()).toString());
    
    periodeFormationCali.setTypeMesurePourEmploi(typeMesureEmploi);
    return periodeFormationCali;
  }
  
  public static String mapperTypeConventionVersCojac(int typeConventionCali)
  {
    String typeConventionCojac = null;
    if (typeConventionCali == 3) {
      typeConventionCojac = "C";
    } else if (typeConventionCali == 1) {
      typeConventionCojac = "P";
    } else if (typeConventionCali == 6) {
      typeConventionCojac = "X";
    } else if (typeConventionCali == 5) {
      typeConventionCojac = "N";
    } else if (typeConventionCali == 4) {
      typeConventionCojac = "A";
    } else if (typeConventionCali == 2) {
      typeConventionCojac = "H";
    }
    return typeConventionCojac;
  }
}

/* Location:
 * Qualified Name:     MapperActionsFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */