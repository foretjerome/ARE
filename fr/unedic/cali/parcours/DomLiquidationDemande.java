package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.NovationSpec;
import fr.unedic.cali.dom.OdSpec;
import fr.unedic.cali.dom.RepriseSpec;
import fr.unedic.cali.dom.RevisionSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.List;

public class DomLiquidationDemande
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec individu = null;
  private DemandeSpec demande = null;
  private String idDemande = null;
  private DemandeSpec demandeAvantReexmen = null;
  private String idDecor = null;
  private int revisionANotifier;
  private Damj dernierJourIndemnisableDroitAreSpe = null;
  private boolean liquidationManuelleEnTP = false;
  private boolean effectuerControlesEligiliteSurDecisionAuto = false;
  private boolean decisionEnCoursValidation = true;
  private ContexteService contexteService;
  private boolean liquidationAvecDroitOptionReprise;
  private boolean liquidationAvecDroitOptionReadmission;
  private boolean notifierCourrier = false;
  private boolean topAppelContribution = false;
  private boolean liquideEnEtat = false;
  private String codeMotifEchecPourSigma;
  private Damj dateDerniereNotification;
  private String codeGamme;
  private boolean liquidationTP = false;
  private ChronologiePeriodes pensionsInvalidite = null;
  private boolean modeSimulation = false;
  private String refExtDemande = null;
  private int codeService = 0;
  
  public void copie(DomLiquidationDemande src)
  {
    setIndividu(src.getIndividu());
    setDemande((DemandeSpec)src.getDemandeSpec().copie());
    setIdDemande(src.getIdDemande());
    setIdDecor(src.getIdDecor());
  }
  
  public String getIdDemande()
  {
    return idDemande;
  }
  
  public IndividuSpec getIndividu()
  {
    return individu;
  }
  
  public void setIdDemande(String idDemande)
  {
    this.idDemande = idDemande;
  }
  
  public void setIndividu(IndividuSpec individu)
  {
    this.individu = individu;
  }
  
  public DemandeSpec getDemandeSpec()
  {
    return demande;
  }
  
  public void setDemande(DemandeSpec demande)
  {
    this.demande = demande;
  }
  
  public DemandeSpec getDemandeAvantReexamen()
  {
    return demandeAvantReexmen;
  }
  
  public void setDemandeAvantReexamen(DemandeSpec demande)
  {
    demandeAvantReexmen = demande;
  }
  
  public String getIdDecor()
  {
    return idDecor;
  }
  
  public void setIdDecor(String idDecor)
  {
    this.idDecor = idDecor;
  }
  
  public ContexteService getContexteService()
  {
    return contexteService;
  }
  
  public void setContexteService(ContexteService contexteService)
  {
    this.contexteService = contexteService;
  }
  
  public static ContexteService getContexteService(Contexte contexte)
  {
    return ((DomLiquidationDemande)contexte.getDonnees()).getContexteService();
  }
  
  public boolean estDemandeAvantReexamenOdSpec()
  {
    boolean ok = false;
    DemandeSpec demandeAvantReexamen = getDemandeAvantReexamen();
    if ((getDemandeAvantReexamen() != null) && (!demandeAvantReexamen.getListeDossiersExamen().isEmpty())) {
      ok = ((demandeAvantReexamen.getListeDossiersExamen().get(0) instanceof OdSpec)) || ((demandeAvantReexamen.getListeDossiersExamen().get(0) instanceof NovationSpec)) || (((demandeAvantReexamen.getListeDossiersExamen().get(0) instanceof RevisionSpec)) && (((RevisionSpec)demandeAvantReexamen.getListeDossiersExamen().get(0)).getType() == 2));
    }
    return ok;
  }
  
  public boolean estDemandeAvantReexamenRepriseSpec()
  {
    boolean ok = false;
    DemandeSpec demandeAvantReexamen = getDemandeAvantReexamen();
    if ((getDemandeAvantReexamen() != null) && (!demandeAvantReexamen.getListeDossiersExamen().isEmpty())) {
      ok = demandeAvantReexamen.getListeDossiersExamen().get(0) instanceof RepriseSpec;
    }
    return ok;
  }
  
  public String getReferenceExterneAvantReexamen()
  {
    String ref = null;
    DemandeSpec demandeAvantReexamen = getDemandeAvantReexamen();
    if ((!demandeAvantReexamen.getListeDossiersExamen().isEmpty()) && ((demandeAvantReexamen.getListeDossiersExamen().get(0) instanceof AttributionSpec))) {
      ref = ((AttributionSpec)demandeAvantReexamen.getListeDossiersExamen().get(0)).getReferenceExterne();
    }
    return ref;
  }
  
  public boolean isLiquidationAvecDroitOptionReprise()
  {
    return liquidationAvecDroitOptionReprise;
  }
  
  public void setLiquidationAvecDroitOptionReprise(boolean liquidationAvecDroitOptionReprise)
  {
    this.liquidationAvecDroitOptionReprise = liquidationAvecDroitOptionReprise;
  }
  
  public boolean isLiquidationAvecDroitOptionReadmission()
  {
    return liquidationAvecDroitOptionReadmission;
  }
  
  public void setLiquidationAvecDroitOptionReadmission(boolean liquidationAvecDroitOptionReadmission)
  {
    this.liquidationAvecDroitOptionReadmission = liquidationAvecDroitOptionReadmission;
  }
  
  public String getCodeGamme()
  {
    return codeGamme;
  }
  
  public void setCodeGamme(String codeGamme)
  {
    this.codeGamme = codeGamme;
  }
  
  public String getCodeMotifEchecPourSigma()
  {
    return codeMotifEchecPourSigma;
  }
  
  public void setCodeMotifEchecPourSigma(String codeMotifEchecPourSigma)
  {
    this.codeMotifEchecPourSigma = codeMotifEchecPourSigma;
  }
  
  public boolean estLiquideEnEtat()
  {
    return liquideEnEtat;
  }
  
  public void setLiquideEnEtat(boolean liquideEnEtat)
  {
    this.liquideEnEtat = liquideEnEtat;
  }
  
  public boolean estNotifierCourrier()
  {
    return notifierCourrier;
  }
  
  public void setTopAppelContribution(boolean topAppelContribution)
  {
    this.topAppelContribution = topAppelContribution;
  }
  
  public boolean estTopAppelContribution()
  {
    return topAppelContribution;
  }
  
  public void setNotifierCourrier(boolean notifierCourrier)
  {
    this.notifierCourrier = notifierCourrier;
  }
  
  public Damj getDateDerniereNotification()
  {
    return dateDerniereNotification;
  }
  
  public void setDateDerniereNotification(Damj dateDerniereNotification)
  {
    this.dateDerniereNotification = dateDerniereNotification;
  }
  
  public boolean estDecisionEnCoursValidation()
  {
    return decisionEnCoursValidation;
  }
  
  public void setDecisionEnCoursValidation(boolean decisionEnCoursValidation)
  {
    this.decisionEnCoursValidation = decisionEnCoursValidation;
  }
  
  public boolean isLiquidationTP()
  {
    return liquidationTP;
  }
  
  public void setLiquidationTP(boolean liquidationTP)
  {
    this.liquidationTP = liquidationTP;
  }
  
  public int getRevisionANotifier()
  {
    return revisionANotifier;
  }
  
  public void setRevisionANotifier(int revisionANotifier)
  {
    this.revisionANotifier = revisionANotifier;
  }
  
  public Damj getDernierJourIndemnisableDroitAreSpe()
  {
    return dernierJourIndemnisableDroitAreSpe;
  }
  
  public void setDernierJourIndemnisableDroitAreSpe(Damj dernierJourIndemnisableDroitAreSpe)
  {
    this.dernierJourIndemnisableDroitAreSpe = dernierJourIndemnisableDroitAreSpe;
  }
  
  public ChronologiePeriodes getPensionsInvalidite()
  {
    return pensionsInvalidite;
  }
  
  public void setPensionsInvalidite(ChronologiePeriodes pensionsInvalidite)
  {
    this.pensionsInvalidite = pensionsInvalidite;
  }
  
  public boolean isModeSimulation()
  {
    return modeSimulation;
  }
  
  public void setModeSimulation(boolean modeSimulation)
  {
    this.modeSimulation = modeSimulation;
  }
  
  public String getRefExtDemande()
  {
    return refExtDemande;
  }
  
  public void setRefExtDemande(String refExtDemande)
  {
    this.refExtDemande = refExtDemande;
  }
  
  public int getCodeService()
  {
    return codeService;
  }
  
  public void setCodeService(int codeService)
  {
    this.codeService = codeService;
  }
  
  public boolean isLiquidationManuelleEnTP()
  {
    return liquidationManuelleEnTP;
  }
  
  public void setLiquidationManuelleEnTP(boolean liquidationManuelleEnTP)
  {
    this.liquidationManuelleEnTP = liquidationManuelleEnTP;
  }
  
  public boolean isEffectuerControlesEligiliteSurDecisionAuto()
  {
    return effectuerControlesEligiliteSurDecisionAuto;
  }
  
  public void setEffectuerControlesEligiliteSurDecisionAuto(boolean effectuerControlesEligiliteSurDecisionAuto)
  {
    this.effectuerControlesEligiliteSurDecisionAuto = effectuerControlesEligiliteSurDecisionAuto;
  }
}

/* Location:
 * Qualified Name:     DomLiquidationDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */