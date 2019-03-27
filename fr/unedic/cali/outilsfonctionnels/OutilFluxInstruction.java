package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.CoucheLogiqueException;

public class OutilFluxInstruction
  extends OutilFlux
{
  public static final String NOM_FLUX_D12_PIECE_JUSTIFICATIVE = "D12DPC";
  public static final String NOM_D12_DAL = "D2I";
  public static final String NOM_CODE_ACTIVITE = "CALI";
  public static final String NOM_FLUX_SYNCHRONISATION_COULEUR_DAL = "D12SCD";
  
  public static void creerTraceTrackerPourD12DalAjoutPieceJustificative(IndividuSpec individu, String idPeriodeGaec, String referenceExterne)
    throws CoucheLogiqueException
  {
    TraceTrackerEnModeEmission trace = creerTraceTracker(individu, "D12DPC", "D2I", "CALI");
    individu.ajouterTraceTrackerEnModeEmission(trace);
    trace.setReferenceExterne(referenceExterne);
    trace.setIdPeriodeGaec(idPeriodeGaec);
  }
  
  public static void creerTraceTrackerPourD12DalSynchronisationCouleurDal(IndividuSpec individu, String referenceExterne, String codeAttente)
    throws CoucheLogiqueException
  {
    TraceTrackerEnModeEmission trace = creerTraceTracker(individu, "D12SCD", "D2I", "CALI");
    trace.setReferenceExterne(referenceExterne);
    trace.setCodeAttente(codeAttente);
    individu.ajouterTraceTrackerEnModeEmission(trace);
  }
}

/* Location:
 * Qualified Name:     OutilFluxInstruction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */