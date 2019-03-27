package fr.unedic.cali.dom;

import fr.pe.cali.crem.dom.ObjetMetierCrem;
import fr.unedic.cali.autresdoms.cohab.dom.spec.IndividuCohabSpec;
import fr.unedic.cali.autresdoms.d12i.dom.spec.IndividuInstructionSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.IndividuGaSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.outilsfonctionnels.TraceTrackerEnModeEmission;
import fr.unedic.transverse.dom.spec.IndividuTransverseSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Periode;
import java.util.List;

public abstract interface IndividuSpec
  extends IndividuCohabSpec, IndividuGaSpec, IndividuCaliSpec, IndividuTransverseSpec, IndividuInstructionSpec
{
  public abstract PeriodeGaecSpec rechercherPeriodePasseProfessionnel(String paramString);
  
  public abstract void finiTraitement();
  
  public abstract void supprimer();
  
  public abstract boolean estDejaCree();
  
  public abstract void setEstDejaCree(boolean paramBoolean);
  
  public abstract List getListeDemandesSigmaDecisionneesApresOuCoincide(DemandeSpec paramDemandeSpec);
  
  public abstract DecisionSpec getDecisionAvant(DemandeSpec paramDemandeSpec, FiltreTemporel paramFiltreTemporel);
  
  public abstract List getListeAttributionsExecutablesAvant(Damj paramDamj);
  
  public abstract List getListeAttributionsExecutablesAvant(DecisionSpec paramDecisionSpec);
  
  public abstract List getListeAttributionsExecutablesAvant(DemandeSpec paramDemandeSpec);
  
  public abstract List getListeAttributionsASUPendantPeriode(Periode paramPeriode)
    throws CoucheLogiqueException;
  
  public abstract String getNumeroAllocataire();
  
  public abstract ContexteService getContexteService();
  
  public abstract List getListeAttributionsChevauchantPeriode(Periode paramPeriode, Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract List getListeAttributionsExecutables();
  
  public abstract List getListeAttributionsNeutralisees();
  
  public abstract List getListeAttributionsNonFigee();
  
  public abstract void marquerGraphePersistance();
  
  public abstract boolean isInvestigationFraude();
  
  public abstract void setInvestigationFraude(boolean paramBoolean);
  
  public abstract int determinerPopulationIndividu(Damj paramDamj);
  
  public abstract int getContexteExecution();
  
  public abstract void setContexteExecution(int paramInt);
  
  public abstract List<TraceTrackerEnModeEmission> getListeTraceTrackerEnModeEmission();
  
  public abstract void ajouterTraceTrackerEnModeEmission(TraceTrackerEnModeEmission paramTraceTrackerEnModeEmission);
  
  public abstract void retirerTraceTrackerEnModeEmission(TraceTrackerEnModeEmission paramTraceTrackerEnModeEmission);
  
  public abstract List getListeAttributionsASUCompetenceFinanciere();
  
  public abstract List getListeDemandesSP();
  
  public abstract Chronologie getPeriodePensionInvalidite()
    throws CoucheLogiqueException;
  
  public abstract Chronologie getPeriodeCLCA()
    throws CoucheLogiqueException;
  
  public abstract DonneesChargementGaec getDonneesChargementGaec();
  
  public abstract void setDonneesChargementGaec(DonneesChargementGaec paramDonneesChargementGaec);
  
  public abstract boolean isEstAbonneGaec();
  
  public abstract void setEstAbonneGaec(boolean paramBoolean);
  
  public abstract void nettoyerPNDSSurActiviteSalariePourSpectacle();
  
  public abstract boolean estDispositifAllonge();
  
  public abstract List<ObjetMetierCrem> getListeCrem();
}

/* Location:
 * Qualified Name:     IndividuSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */