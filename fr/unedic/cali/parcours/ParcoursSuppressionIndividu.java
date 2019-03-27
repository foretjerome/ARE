package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.outilsfonctionnels.AppelCalcul;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;

public class ParcoursSuppressionIndividu
  extends ParcoursServiceAbstrait
{
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {
    IndividuSpec individuCourant = getIndividu(p_contexte);
    if (individuCourant == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "Individu absent du contexte");
    }
  }
  
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    if (Log.isTraceActive(ParcoursSuppressionIndividu.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, ParcoursSuppressionIndividu.class, "demarrer", "\t******** Début Parcours SuppressionIndividu ********\n");
    }
    IndividuSpec individuCourant = getIndividu(p_contexte);
    
    Resultat resultat = new Resultat(0);
    if (individuCourant.estDejaCree()) {
      resultat.setEtat(1);
    }
    individuCourant.setContexteExecution(1);
    
    AppelCalcul.nettoyerCalcul(individuCourant, new ChronologieDebuts().mapperVersCollection(), null, Damj.NUIT_DES_TEMPS, 1, true);
    
    IndividuPbjcNcp individuPbjcNcp = individuCourant.getIndividuPbjcNcp();
    if (individuPbjcNcp != null) {
      DomManager.supprimerAbsolument(individuPbjcNcp);
    }
    individuCourant.setChronoDemandes(new ChronologieDebuts());
    
    individuCourant.supprimer();
    
    individuCourant.setContexteExecution(0);
    if (Log.isTraceActive(ParcoursSuppressionIndividu.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, ParcoursSuppressionIndividu.class, "demarrer", "\n\t******** Fin Parcours SuppressionIndividu ********\n");
    }
    return resultat;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    if (p_individu.getDonneesChargementGaec().getAgregatGaec().isOptimisationPasDeChargementGaec()) {
      return 0;
    }
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    if (p_individu != null) {
      p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
    }
  }
  
  protected void controlerPostTraitementAvecOuSansForcage(Individu p_individu)
    throws AccesDonneesGaecException
  {}
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
}

/* Location:
 * Qualified Name:     ParcoursSuppressionIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */