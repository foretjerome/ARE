package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.dom.DecisionSuivi;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.ResultatTraitementReliquatSpec;
import fr.unedic.cali.parcours.ResultatExecutionCalculSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.lang.StringUtils;

public abstract class OutilTraitementReliquat
  implements OutilFonctionnel
{
  protected static final BigDecimal ZERO = new BigDecimal("0");
  
  protected abstract Quantite traiterImputation(DemandeSpec paramDemandeSpec, DecisionSpec paramDecisionSpec, ResultatExecutionCalculSpec paramResultatExecutionCalculSpec, ResultatTraitementReliquatSpec paramResultatTraitementReliquatSpec, Damj paramDamj)
    throws CoucheLogiqueException, ApplicativeException;
  
  protected abstract Damj traiterDecheance(DemandeSpec paramDemandeSpec, DecisionSpec paramDecisionSpec, Damj paramDamj)
    throws CoucheLogiqueException;
  
  protected abstract Damj traiterExtinction(DemandeSpec paramDemandeSpec, DecisionSpec paramDecisionSpec, ResultatExecutionCalculSpec paramResultatExecutionCalculSpec, Damj paramDamj)
    throws CoucheLogiqueException;
  
  protected boolean estAntecedentEpuise(DemandeSpec p_demande, DecisionSpec p_decisionPrecedente, ResultatExecutionCalculSpec p_resultatExecutionCalcul, ResultatTraitementReliquatSpec p_resultatTraitementReliquat, Damj p_dateEtude)
    throws CoucheLogiqueException, ApplicativeException
  {
    Quantite qteReliquatApresImputation = traiterImputation(p_demande, p_decisionPrecedente, p_resultatExecutionCalcul, p_resultatTraitementReliquat, p_dateEtude);
    
    boolean droitEpuise = qteReliquatApresImputation.getValeur().compareTo(new BigDecimal("1")) < 0;
    if (droitEpuise) {
      alimenterResultatEpuise(p_resultatTraitementReliquat, p_resultatExecutionCalcul);
    }
    return droitEpuise;
  }
  
  protected boolean estAntecedentDechu(DemandeSpec p_demande, ResultatTraitementReliquatSpec p_resultatTraitementReliquat, DecisionSpec p_decisionPrecedente, Damj p_dateEtude)
    throws CoucheLogiqueException
  {
    Damj dateDecheance = traiterDecheance(p_demande, p_decisionPrecedente, p_dateEtude);
    if (dateDecheance != null) {
      alimenterResultatDechu(p_resultatTraitementReliquat, p_demande, dateDecheance);
    }
    return dateDecheance != null;
  }
  
  protected void estAntecedentEteint(DemandeSpec p_demande, DecisionSpec p_decisionPrecedente, ResultatTraitementReliquatSpec p_resultatTraitementReliquat, ResultatExecutionCalculSpec p_resultatExecutionCalcul, Damj p_dateEtude)
    throws CoucheLogiqueException
  {
    Damj dateExtinction = traiterExtinction(p_demande, p_decisionPrecedente, p_resultatExecutionCalcul, p_dateEtude);
    if (dateExtinction != null) {
      alimenterResultatEteint(p_resultatTraitementReliquat, dateExtinction);
    }
  }
  
  protected abstract void alimenterResultatEpuise(ResultatTraitementReliquatSpec paramResultatTraitementReliquatSpec, ResultatExecutionCalculSpec paramResultatExecutionCalculSpec);
  
  protected abstract void alimenterResultatDechu(ResultatTraitementReliquatSpec paramResultatTraitementReliquatSpec, DemandeSpec paramDemandeSpec, Damj paramDamj)
    throws CoucheLogiqueException;
  
  protected abstract void alimenterResultatEteint(ResultatTraitementReliquatSpec paramResultatTraitementReliquatSpec, Damj paramDamj);
  
  protected static Collection getListeSanctionsPourDE(IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    return p_individu.getDecisionsSuivi();
  }
  
  protected static Periode determinerPeriodeHorsPEC(ResultatExecutionCalculSpec p_resultatExecutionCalcul, Damj p_dateEtude)
  {
    Damj lendemainDji = null;
    if (p_resultatExecutionCalcul.getEtatResultatAvant() == 0)
    {
      if ((!p_resultatExecutionCalcul.isResultatPendantNul()) && (p_resultatExecutionCalcul.getEtatResultatPendant() == 0)) {
        lendemainDji = p_resultatExecutionCalcul.getDernierJourIndemnisable().lendemain();
      } else {
        lendemainDji = p_resultatExecutionCalcul.getPremierJourAvant();
      }
    }
    else if (p_resultatExecutionCalcul.getEtatResultatAvant() == 1) {
      lendemainDji = p_resultatExecutionCalcul.getAttributionEtudiee().getDateAttribution();
    } else if (p_resultatExecutionCalcul.getEtatResultatAvant() == 9) {
      lendemainDji = p_resultatExecutionCalcul.getPremierJourAvant();
    }
    if ((lendemainDji != null) && (p_dateEtude.estApres(lendemainDji))) {
      return new Periode(lendemainDji, p_dateEtude);
    }
    return null;
  }
  
  protected static boolean estSuppressionTemporaireRevenuRemplacement(DecisionSuivi p_decisionSuivi)
  {
    return (p_decisionSuivi.getNatureDecision().equals("SD")) || (p_decisionSuivi.getNatureDecision().equals("SE"));
  }
  
  protected static boolean estUneSuspensionPourAttribution(DecisionSuivi p_decisionSuivi, AttributionSpec p_attribution)
  {
    return StringUtils.equals(p_attribution.getRsod(), p_decisionSuivi.getRSOD());
  }
  
  protected Damj determinerExtinctionPourExclusionDefinitiveRevenuDeRemplacement(DemandeSpec p_demande, ResultatExecutionCalculSpec p_resultatExecutionCalcul, Damj p_dateEtude)
    throws CoucheLogiqueException
  {
    Damj dateExtinction = null;
    boolean extinction = false;
    
    Periode periodePriseEnCompteSanction = determinerPeriodeHorsPEC(p_resultatExecutionCalcul, p_dateEtude);
    
    Collection listeSanctions = getListeSanctionsPourDE(p_demande.getDemandeur());
    if ((periodePriseEnCompteSanction != null) && (listeSanctions != null) && (listeSanctions.size() > 0))
    {
      Iterator iterateurListeSanctions = listeSanctions.iterator();
      while ((iterateurListeSanctions.hasNext()) && (!extinction))
      {
        DecisionSuivi decisionSuivi = (DecisionSuivi)iterateurListeSanctions.next();
        Damj dateEffetSanction = decisionSuivi.getDateEffet();
        if ((estSanctionExtinctionDefinitive(decisionSuivi, p_demande)) && (dateEffetSanction.estContenueDans(periodePriseEnCompteSanction)) && (estUneSuspensionPourAttribution(decisionSuivi, p_resultatExecutionCalcul.getAttributionEtudiee())))
        {
          extinction = true;
          dateExtinction = dateEffetSanction;
        }
      }
    }
    return dateExtinction;
  }
  
  protected boolean estSanctionExtinctionDefinitive(DecisionSuivi p_decisionSuivi, DemandeSpec p_demande)
  {
    return (p_decisionSuivi.getNatureDecision().equals("EX")) || (p_decisionSuivi.getNatureDecision().equals("ED"));
  }
}

/* Location:
 * Qualified Name:     OutilTraitementReliquat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */