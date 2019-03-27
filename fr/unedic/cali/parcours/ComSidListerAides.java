package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;

public class ComSidListerAides
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Début Parcours ComSigmaListerEchangesParDemande ********\n");
    }
    ResultatComSigmaListerEchangesParDemande resultatComSigmaListerEchangesParDemande = new ResultatComSigmaListerEchangesParDemande();
    
    resultatComSigmaListerEchangesParDemande.setEtat(1);
    
    DomComSigmaListerEchangesParDemande domComSigmaListerEchangesParDemande = (DomComSigmaListerEchangesParDemande)p_contexte.getDonnees();
    resultatComSigmaListerEchangesParDemande.setListeEchanges(DomManager.getEchangesParDemande(domComSigmaListerEchangesParDemande.getReferenceExterneDemande()));
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin Parcours ComSigmaListerEchangesParDemande ********\n");
    }
    resultatComSigmaListerEchangesParDemande.setEtat(0);
    
    return resultatComSigmaListerEchangesParDemande;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 0;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
}

/* Location:
 * Qualified Name:     ComSidListerAides
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */