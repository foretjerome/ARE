package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AppelGaecReduit;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.OutilDeterminationDateDebutExecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.OutilGestionnaireReexecution;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.Dom;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ParcoursDeterminerDateDebutExecution
  extends ParcoursCalculPilotage
{
  public static final String CONTEXTE_EXECUTION_INDIVIDU_PBJC_NCP_BATCH_MANDATEMENT_AUTO = "1";
  public static final String CONTEXTE_EXECUTION_INDIVIDU_PBJC_NCP_BATCH_MANDATEMENT_MANU = "2";
  public static final String CONTEXTE_EXECUTION_INDIVIDU_PBJC_NCP_TP = " ";
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatDeterminerDateDebutExecution retour = null;
    DomDeterminerDateDebutExecution domDateDebut = null;
    Damj dateDebutExecution = null;
    Damj dateDebutExecutionDifferee = null;
    DemandeSpec prochaineDemandeInvalide = null;
    
    retour = new ResultatDeterminerDateDebutExecution();
    
    retour.setEtat(0);
    
    domDateDebut = (DomDeterminerDateDebutExecution)contexte.getDonnees();
    
    dateDebutExecutionDifferee = domDateDebut.getIndividu().getDateExecutionDifferee();
    if (domDateDebut.getDateDebutExecution() == null) {
      domDateDebut.setDateDebutExecution(Damj.NUIT_DES_TEMPS);
    }
    if ((dateDebutExecutionDifferee != null) && (dateDebutExecutionDifferee.estAvant(domDateDebut.getDateDebutExecution()))) {
      domDateDebut.setDateDebutExecution(dateDebutExecutionDifferee);
    }
    List demandesInvalides = OutilGestionnaireReexecution.getInstance().recupererDemandesAReliquider(domDateDebut.getIndividu(), domDateDebut.getDateDebutExecution().getDebutMois(), 100, 100, null, false, false, false);
    
    prochaineDemandeInvalide = OutilGestionnaireReexecution.getInstance().recupererProchaineDemande(demandesInvalides);
    if (prochaineDemandeInvalide != null)
    {
      Damj dateExecutionCali = OutilGestionnaireReexecution.getInstance().getDateExecution(prochaineDemandeInvalide);
      if ((dateExecutionCali != null) && ((dateExecutionCali.estAvant(domDateDebut.getDateDebutExecution())) || (domDateDebut.getDateDebutExecution().coincideAvec(Damj.NUIT_DES_TEMPS)))) {
        domDateDebut.setDateDebutExecution(dateExecutionCali);
      }
    }
    dateDebutExecution = OutilDeterminationDateDebutExecution.getInstance().rechercherDateDebutExecution(domDateDebut.getDateDebutExecution(), domDateDebut.getDateDebutExecution().getDebutMois(), domDateDebut.isExecutionDepuisPersistance(), domDateDebut.getIndividu());
    
    retour.setDateDebutExecution(dateDebutExecution);
    
    return retour;
  }
  
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    Dom dom = null;
    if (contexte == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE_ABSENT", "Le contexte ne doit pas être null", null);
    }
    dom = contexte.getDonnees();
    if (dom == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DOM", "Le Dom ne doit pas être null.", null);
    }
    if (!(dom instanceof DomDeterminerDateDebutExecution)) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Le type de Dom attendu est: DomCalculPilotage", null);
    }
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    if (individu != null)
    {
      Collection<String> typePeriodesGaec = new ArrayList();
      ajouterSiNouveau("999", typePeriodesGaec);
      
      individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(1);
      individu.getDonneesChargementGaec().getAgregatGaec().setTypePeriodesGaec(typePeriodesGaec);
    }
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    AppelGaecReduit gaecReduit = individu.getDonneesChargementGaec().getAppelGaecReduit();
    
    controlerModeAppel(gaecReduit, 1);
    
    controlerTypePeriode(gaecReduit.getTypePeriodes(), "999");
  }
}

/* Location:
 * Qualified Name:     ParcoursDeterminerDateDebutExecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */