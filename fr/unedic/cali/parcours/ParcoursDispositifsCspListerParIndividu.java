package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.pbjc.dom.DispositifNcp;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.outilsfonctionnels.ComparateurSurdateDebutDispositif;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ParcoursDispositifsCspListerParIndividu
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Début Parcours ParcoursDroitsNcpListerParIndividu ********\n");
    }
    ResultatDispositifsCspListerParIndividu resultatDispositifsCspListerParIndividu = new ResultatDispositifsCspListerParIndividu();
    
    resultatDispositifsCspListerParIndividu.setListeDispositifsCsp(new ArrayList());
    
    Collection<DispositifNcp> collectionDispositifs = DomManager.getCollectionDispositifNcp();
    Iterator<DispositifNcp> collectionDispositifsIterator = collectionDispositifs.iterator();
    while (collectionDispositifsIterator.hasNext())
    {
      DispositifNcp dispositifNcp = (DispositifNcp)collectionDispositifsIterator.next();
      resultatDispositifsCspListerParIndividu.getListeDispositifsNcp().add(dispositifNcp);
    }
    Collections.sort(resultatDispositifsCspListerParIndividu.getListeDispositifsNcp(), new ComparateurSurdateDebutDispositif());
    
    resultatDispositifsCspListerParIndividu.setEtat(0);
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin Parcours ParcoursDroitsNcpListerParIndividu ********\n");
    }
    return resultatDispositifsCspListerParIndividu;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 0;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
}

/* Location:
 * Qualified Name:     ParcoursDispositifsCspListerParIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */