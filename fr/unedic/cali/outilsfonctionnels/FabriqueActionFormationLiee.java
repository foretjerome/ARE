package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.ActionFormation;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation;
import fr.unedic.cali.dom.ActionFormationLiee;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.ComparateurTemporelsSurDateDebut;
import fr.unedic.util.temps.Periode;

public class FabriqueActionFormationLiee
{
  public static ActionFormationLiee creerActionFormationLiee(ActionFormation p_actionFormation)
  {
    if (p_actionFormation == null) {
      return null;
    }
    ActionFormationLiee actionFormationLiee = new ActionFormationLiee();
    
    alimenterActionFormationLiee(p_actionFormation, actionFormationLiee);
    
    return actionFormationLiee;
  }
  
  public static void alimenterActionFormationLiee(ActionFormation p_actionFormation, ActionFormationLiee p_actionFormationLiee)
  {
    p_actionFormationLiee.setAffDerogatoire(p_actionFormation.getEtatAffDerogatoire());
    p_actionFormationLiee.setDateDebut(p_actionFormation.getDateDebut());
    p_actionFormationLiee.setDateFin(p_actionFormation.getDateFin());
    p_actionFormationLiee.setDatePrescription(p_actionFormation.getDatePrescription());
    p_actionFormationLiee.setIdentifiantConvention(p_actionFormation.getIdentifiantConvention());
    p_actionFormationLiee.setNumeroConvention(p_actionFormation.getNumeroConvention());
    p_actionFormationLiee.setQuantiteHebdomadaire(p_actionFormation.getQuantiteHoraireHebdo());
    p_actionFormationLiee.setStatutFormation(p_actionFormation.getStatut());
    p_actionFormationLiee.setTypeConvention(p_actionFormation.getTypeConvention());
    p_actionFormationLiee.setTypePlanFormation(p_actionFormation.getTypePlanFormation());
    p_actionFormationLiee.setTypePopulationRsa(p_actionFormation.getTypeBeneficiaireRSA());
    
    alimenterDateDebutPeriodeFormation(p_actionFormation, p_actionFormationLiee);
  }
  
  private static void alimenterDateDebutPeriodeFormation(ActionFormation p_actionFormation, ActionFormationLiee p_actionFormationLiee)
  {
    if ((p_actionFormation.getListePeriodeFormation() != null) && (!p_actionFormation.getListePeriodeFormation().estVide()))
    {
      ChronologiePeriodes listePeriodeFormation = p_actionFormation.getListePeriodeFormation();
      
      listePeriodeFormation.setComparateur(new ComparateurTemporelsSurDateDebut());
      
      PeriodeFormation periodeFormation = (PeriodeFormation)listePeriodeFormation.premierElement();
      if (periodeFormation.getPeriodeEffective() != null) {
        p_actionFormationLiee.setDateDebutPeriodeFormation(periodeFormation.getPeriodeEffective().getDebut());
      }
    }
  }
}

/* Location:
 * Qualified Name:     FabriqueActionFormationLiee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */