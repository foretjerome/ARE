package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DomSimulationAffiliation;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.ResultatSimulationAffiliation;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;

public class ParcoursSimulationAffiliation
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    OutilTrace.tracerDebutParcours();
    
    ResultatSimulationAffiliation resultat = new ResultatSimulationAffiliation();
    
    resultat.setEtat(1);
    
    DomSimulationAffiliation dom = (DomSimulationAffiliation)p_contexte.getDonnees();
    
    resultat = (ResultatSimulationAffiliation)GammeAsu.getInstance().executerSimulationAffiliation(dom);
    
    resultat.setIndividu(dom.getIndividu());
    resultat.setDateFgd(dom.getDateFgd());
    
    resultat.setEtat(0);
    
    OutilTrace.tracerFinParcours();
    return resultat;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
}

/* Location:
 * Qualified Name:     ParcoursSimulationAffiliation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */