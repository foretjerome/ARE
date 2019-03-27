package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.RCTDom;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class MapperRctDom
{
  static void mapper(ContratTravail p_contratTravailCali, RCTDom p_rctDomGa)
  {
    p_contratTravailCali.setCodeMotifFin(CodeGa.valueOf(p_rctDomGa.getCodeMotifRupture()));
    p_contratTravailCali.setContexteDemission(CodeGa.valueOf(p_rctDomGa.getContexteDemission()));
    
    p_contratTravailCali.setDateRuptureContratTravail(p_rctDomGa.getDateNotifLicenciement());
    
    p_contratTravailCali.setDateEngagementProcedureLicenciement(p_rctDomGa.getDateEngagementProcedure());
    p_contratTravailCali.setRefusFne(new BigDecimal(p_rctDomGa.getRefusAdhesionFNE()));
    
    fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Preavis preavisGa = p_rctDomGa.getPreavis();
    fr.unedic.cali.autresdoms.ga.dom.Preavis preavisCali = creerPreavis(preavisGa);
    p_contratTravailCali.setPreavis(preavisCali);
  }
  
  private static fr.unedic.cali.autresdoms.ga.dom.Preavis creerPreavis(fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Preavis p_preavisGa)
  {
    boolean preavisSaisie = false;
    if (p_preavisGa == null) {
      return null;
    }
    fr.unedic.cali.autresdoms.ga.dom.Preavis preavisCali = new fr.unedic.cali.autresdoms.ga.dom.Preavis();
    Periode periodeEffectuee = null;Periode periodeNonEffectueePayee = null;Periode periodeNonEffectueeNonPayee = null;
    Damj dateActionPrudhommale = null;Damj dateAccordPreavis = null;Damj dateRefusPreavis = null;
    boolean actionPrudhommale = false;boolean engagementRemboursement = false;
    if (p_preavisGa.getDateDebPreavisEffectue() != null)
    {
      periodeEffectuee = FabriquePeriode.creer(p_preavisGa.getDateDebPreavisEffectue(), p_preavisGa.getDateFinPreavisEffectue());
      preavisSaisie = true;
    }
    if (p_preavisGa.getDateDebPreavisPaye() != null)
    {
      periodeNonEffectueePayee = FabriquePeriode.creer(p_preavisGa.getDateDebPreavisPaye(), p_preavisGa.getDateFinPreavisPaye());
      preavisSaisie = true;
    }
    if (p_preavisGa.getDateDebPreavisNonPaye() != null)
    {
      periodeNonEffectueeNonPayee = FabriquePeriode.creer(p_preavisGa.getDateDebPreavisNonPaye(), p_preavisGa.getDateFinPreavisNonPaye());
      preavisSaisie = true;
    }
    if (p_preavisGa.getDateActionPrudhommale() != null)
    {
      dateActionPrudhommale = p_preavisGa.getDateActionPrudhommale();
      preavisSaisie = true;
    }
    if (p_preavisGa.getDateAccordPreavis() != null)
    {
      dateAccordPreavis = p_preavisGa.getDateAccordPreavis();
      preavisSaisie = true;
    }
    if (p_preavisGa.getDateActionPrudhommale() != null)
    {
      dateRefusPreavis = p_preavisGa.getDateRefusPreavis();
      preavisSaisie = true;
    }
    if (!preavisSaisie) {
      return null;
    }
    actionPrudhommale = BooleanGa.valueOf(p_preavisGa.getActionPrudhommale());
    engagementRemboursement = BooleanGa.valueOf(p_preavisGa.getEngagementRemboursement());
    
    preavisCali.setPeriodeEffectuee(periodeEffectuee);
    preavisCali.setPeriodeNonEffectueePayee(periodeNonEffectueePayee);
    preavisCali.setPeriodeNonEffectueeNonPayee(periodeNonEffectueeNonPayee);
    preavisCali.setActionPrudhommale(actionPrudhommale);
    preavisCali.setEngagementRemboursement(engagementRemboursement);
    preavisCali.setDateActionPrudhommale(dateActionPrudhommale);
    preavisCali.setDateAccordPreavis(dateAccordPreavis);
    preavisCali.setDateRefusPreavis(dateRefusPreavis);
    
    return preavisCali;
  }
}

/* Location:
 * Qualified Name:     MapperRctDom
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */