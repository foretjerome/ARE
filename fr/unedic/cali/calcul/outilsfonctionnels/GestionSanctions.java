package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.autresdoms.cohab.dom.DecisionSuivi;
import fr.unedic.cali.calcul.dom.periode.FinPeriodeSanctionReductionMontant;
import fr.unedic.cali.calcul.dom.periode.PeriodeChevauchementSanction;
import fr.unedic.cali.calcul.dom.periode.PeriodeExclusionDefinitiveDDTE;
import fr.unedic.cali.calcul.dom.periode.PeriodeNonMaintienASSetATA;
import fr.unedic.cali.calcul.dom.periode.PeriodeSanctionReductionMontant;
import fr.unedic.cali.calcul.dom.periode.PeriodeSuspensionDDTEAvecImputation;
import fr.unedic.cali.calcul.dom.periode.PeriodeSuspensionDDTESansImputation;
import fr.unedic.cali.calcul.dom.periode.PeriodeSuspensionTitreConservatoire;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.Periode;
import java.util.Collection;
import java.util.Iterator;

public class GestionSanctions
{
  public static ChronologiePeriodes recupererSanctions(Collection p_decisionsSuivi)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes sanctions = null;
    Iterator iterDecisionsSuivi = null;
    DecisionSuivi decisionSuivi = null;
    String natureDecision = null;
    String natureSuspension = null;
    String rsod = null;
    
    sanctions = new ChronologiePeriodes();
    if (p_decisionsSuivi != null)
    {
      iterDecisionsSuivi = p_decisionsSuivi.iterator();
      while (iterDecisionsSuivi.hasNext())
      {
        decisionSuivi = (DecisionSuivi)iterDecisionsSuivi.next();
        
        natureDecision = decisionSuivi.getNatureDecision();
        if ((natureDecision.equals("ED")) || (natureDecision.equals("EX")) || (natureDecision.equals("SD")) || (natureDecision.equals("SE")) || (natureDecision.equals("SF")) || (natureDecision.equals("R1")) || (natureDecision.equals("R2")) || (natureDecision.equals("SC")) || (natureDecision.equals("NM")))
        {
          verifierChevauchementSanction(decisionSuivi, sanctions);
          
          Damj dateFin = controlerDateFin(decisionSuivi.getDateEffet(), decisionSuivi.getDateFin(), decisionSuivi.getDureeDecision());
          if (dateFin != null) {
            if ((natureDecision.equals("ED")) || (natureDecision.equals("EX")))
            {
              rsod = decisionSuivi.getRSOD();
              PeriodeExclusionDefinitiveDDTE periodeExclusion = new PeriodeExclusionDefinitiveDDTE(decisionSuivi.getDateEffet(), dateFin, natureDecision, rsod);
              
              sanctions.ajouter(periodeExclusion);
            }
            else if ((natureDecision.equals("SD")) || (natureDecision.equals("SE")) || (natureDecision.equals("SF")))
            {
              natureSuspension = decisionSuivi.getNatureSuspension();
              if (natureSuspension.equals("1"))
              {
                PeriodeSuspensionDDTEAvecImputation periodeSuspension = new PeriodeSuspensionDDTEAvecImputation(decisionSuivi.getDateEffet(), decisionSuivi.getDateFin(), natureDecision);
                
                periodeSuspension.setPeriodeInitiale(periodeSuspension.getPeriode());
                periodeSuspension.setDureeImputation(controlerDureeImputation(decisionSuivi.getDateEffet(), decisionSuivi.getDateFin(), decisionSuivi.getDureeDecision()));
                
                periodeSuspension.setRSOD(decisionSuivi.getRSOD());
                sanctions.ajouter(periodeSuspension);
              }
              else if (natureSuspension.equals("2"))
              {
                PeriodeSuspensionDDTESansImputation periodeSuspension = new PeriodeSuspensionDDTESansImputation(decisionSuivi.getDateEffet(), dateFin, natureDecision);
                
                periodeSuspension.setPeriodeInitiale(periodeSuspension.getPeriode());
                periodeSuspension.setRSOD(decisionSuivi.getRSOD());
                sanctions.ajouter(periodeSuspension);
              }
            }
            else if ((natureDecision.equals("R1")) || (natureDecision.equals("R2")))
            {
              PeriodeSanctionReductionMontant periodeReduction = new PeriodeSanctionReductionMontant(decisionSuivi.getDateEffet(), dateFin, natureDecision);
              
              periodeReduction.setPeriodeInitiale(periodeReduction.getPeriode());
              FinPeriodeSanctionReductionMontant periodeReductionFin = new FinPeriodeSanctionReductionMontant(dateFin.lendemain());
              periodeReductionFin.setCodeSanction(natureDecision);
              sanctions.ajouter(periodeReduction);
              sanctions.ajouter(periodeReductionFin);
            }
            else if (natureDecision.equals("SC"))
            {
              PeriodeSuspensionTitreConservatoire periode = new PeriodeSuspensionTitreConservatoire(decisionSuivi.getDateEffet(), dateFin, natureDecision);
              
              periode.setPeriodeInitiale(new Periode(decisionSuivi.getDateEffet(), dateFin));
              sanctions.ajouter(periode);
            }
            else if (natureDecision.equals("NM"))
            {
              PeriodeNonMaintienASSetATA periode = new PeriodeNonMaintienASSetATA(decisionSuivi.getDateEffet(), dateFin, natureDecision);
              periode.setRSOD(decisionSuivi.getRSOD());
              sanctions.ajouter(periode);
            }
          }
        }
      }
    }
    return sanctions;
  }
  
  private static Damj controlerDateFin(Damj p_dateDebut, Damj p_dateFin, int p_dureeDecision)
  {
    Damj dateFin = null;
    if (p_dateFin != null) {
      dateFin = p_dateFin;
    } else if (p_dureeDecision != 0) {
      dateFin = p_dateDebut.deplacerVersAvant(new DureeCalendaire(0, 0, p_dureeDecision - 1));
    } else {
      dateFin = Damj.FIN_DES_TEMPS;
    }
    return dateFin;
  }
  
  private static void verifierChevauchementSanction(DecisionSuivi p_decisionSuivi, ChronologiePeriodes p_sanctions)
  {
    if (p_decisionSuivi.getChevauchementSanction())
    {
      PeriodeChevauchementSanction periodeChevauchementSanction = new PeriodeChevauchementSanction(p_decisionSuivi.getDateEffet());
      p_sanctions.ajouter(periodeChevauchementSanction);
    }
  }
  
  private static int controlerDureeImputation(Damj p_dateDebut, Damj p_dateFin, int p_dureeDecision)
  {
    int dureeImputation = 0;
    if (p_dureeDecision != 0) {
      dureeImputation = p_dureeDecision;
    } else if (p_dureeDecision == 0) {
      dureeImputation = p_dateDebut.joursEntre(p_dateFin) + 1;
    }
    return dureeImputation;
  }
}

/* Location:
 * Qualified Name:     GestionSanctions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */