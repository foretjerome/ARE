package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.pbjc.dom.EnquetePbjcNcp;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ParcoursEnquetesNcpListerParIndividu
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Début Parcours ParcoursEnquetesListerParIndividu ********\n");
    }
    ResultatEnquetesNcpListerParIndividu resultatEnquetesNcpListerParIndividu = new ResultatEnquetesNcpListerParIndividu();
    
    resultatEnquetesNcpListerParIndividu.setListeEnquetesNcp(new ArrayList());
    Collection collectionEnquetes = DomManager.getListEnquetesPbjcNcp(Damj.NUIT_DES_TEMPS);
    Iterator collectionEnquetesIterator = collectionEnquetes.iterator();
    while (collectionEnquetesIterator.hasNext())
    {
      EnquetePbjcNcp enquetePbjcNcp = (EnquetePbjcNcp)collectionEnquetesIterator.next();
      resultatEnquetesNcpListerParIndividu.getListeEnquetesNcp().add(enquetePbjcNcp);
    }
    resultatEnquetesNcpListerParIndividu.setEtat(0);
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin Parcours ParcoursEnquetesListerParIndividu ********\n");
    }
    return resultatEnquetesNcpListerParIndividu;
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
 * Qualified Name:     ParcoursEnquetesNcpListerParIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */