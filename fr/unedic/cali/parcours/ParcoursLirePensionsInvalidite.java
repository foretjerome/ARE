package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.ChronologiePeriodes;

public class ParcoursLirePensionsInvalidite
  extends ParcoursServiceAbstrait
{
  protected Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatLirePensionsInvalidite retour = new ResultatLirePensionsInvalidite();
    
    IndividuSpec individu = getIndividu(p_contexte);
    
    retour.setListePensionsInvalidite(individu.getChronoPensionsInvaliditeChainees().mapperVersCollection());
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin parcours ParcoursLirePensionsInvalidite ********\n");
    }
    return retour;
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
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     ParcoursLirePensionsInvalidite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */