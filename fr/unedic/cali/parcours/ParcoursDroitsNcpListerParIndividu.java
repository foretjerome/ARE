package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.pbjc.dom.DroitPbjcNcp;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.outilsfonctionnels.ComparateurRSODQDroitNcp;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class ParcoursDroitsNcpListerParIndividu
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Début Parcours ParcoursDroitsNcpListerParIndividu ********\n");
    }
    ResultatDroitsNcpListerParIndividu resultatDroitsNcpListerParIndividu = new ResultatDroitsNcpListerParIndividu();
    
    resultatDroitsNcpListerParIndividu.setListeDroitsNcp(new ArrayList());
    
    Collection collectionDroits = DomManager.getListDroitsPbjcNcp();
    Iterator collectionDroitsIterator = collectionDroits.iterator();
    while (collectionDroitsIterator.hasNext())
    {
      DroitPbjcNcp droitPbjcNcp = (DroitPbjcNcp)collectionDroitsIterator.next();
      resultatDroitsNcpListerParIndividu.getListeDroitsNcp().add(droitPbjcNcp);
    }
    Collections.sort(resultatDroitsNcpListerParIndividu.getListeDroitsNcp(), new ComparateurRSODQDroitNcp());
    
    resultatDroitsNcpListerParIndividu.setEtat(0);
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin Parcours ParcoursDroitsNcpListerParIndividu ********\n");
    }
    return resultatDroitsNcpListerParIndividu;
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
 * Qualified Name:     ParcoursDroitsNcpListerParIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */