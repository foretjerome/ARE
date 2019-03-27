package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.dom.DecisionSuivi;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ParcoursLireDecisionsSuivi
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatLireDecisionsSuivi retour = new ResultatLireDecisionsSuivi();
    
    IndividuSpec individu = getIndividu(p_contexte);
    
    retour.setListeDecisionSuivi(new ArrayList());
    
    Collection collectionDecision = individu.getDecisionsSuivi();
    Iterator collectionDecisionIterator = collectionDecision.iterator();
    while (collectionDecisionIterator.hasNext())
    {
      DecisionSuivi decisionSuivi = (DecisionSuivi)collectionDecisionIterator.next();
      retour.getListeDecisionSuivi().add(decisionSuivi);
    }
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin Parcours ParcoursEnquetesListerParIndividu ********\n");
    }
    return retour;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    if (p_individu != null) {
      p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
    }
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
}

/* Location:
 * Qualified Name:     ParcoursLireDecisionsSuivi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */