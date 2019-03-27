package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.pbjc.dom.AideNcp;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.ChronologiePeriodes;
import java.util.ArrayList;
import java.util.Iterator;

public class ParcoursAidesNcpListerParIndividu
  extends ParcoursServiceAbstrait
{
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
  
  protected Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Début Parcours ParcoursAidesListerParIndividu ********\n");
    }
    ResultatAidesNcpListerParIndividu resultat = new ResultatAidesNcpListerParIndividu();
    
    resultat.setListeAidesNcp(new ArrayList());
    ChronologiePeriodes chronologieAides = DomManager.getChronologieAideNcp();
    Iterator collectionAidesIterator = chronologieAides.iterer();
    while (collectionAidesIterator.hasNext())
    {
      AideNcp aideNcp = (AideNcp)collectionAidesIterator.next();
      resultat.getListeAidesNcp().add(aideNcp);
    }
    resultat.setEtat(0);
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin Parcours ParcoursAidesListerParIndividu ********\n");
    }
    return resultat;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     ParcoursAidesNcpListerParIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */