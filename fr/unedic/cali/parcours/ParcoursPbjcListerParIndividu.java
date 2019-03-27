package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.ChronologiePeriodes;
import java.util.ArrayList;

public class ParcoursPbjcListerParIndividu
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Début Parcours ParcoursPbjcListerParIndividu ********\n");
    }
    ResultatPbjcListerParIndividu resultatPbjcListerParIndividu = new ResultatPbjcListerParIndividu();
    
    IndividuPbjcNcp individuPbjcNcp = DomManager.getIndividuPbjcNcp();
    if (individuPbjcNcp != null)
    {
      resultatPbjcListerParIndividu.setDateDepartRetraiteCalculee(individuPbjcNcp.getDateDepartRetraiteCalculee());
      resultatPbjcListerParIndividu.setDernierJourIndemnisable(individuPbjcNcp.getDernierJourIndemnisable());
      resultatPbjcListerParIndividu.setAnomalieBloquant(individuPbjcNcp.isAnomalieBloquant());
      resultatPbjcListerParIndividu.setCodeAnomalieCalcul(individuPbjcNcp.getCodeAnomalieCalcul());
      resultatPbjcListerParIndividu.setDonneeAnomalieCalcul(individuPbjcNcp.getDonneeAnomalieCalcul());
      
      resultatPbjcListerParIndividu.setListePbjcNcp(new ArrayList());
      ChronologiePeriodes chronologiePeriodes = DomManager.getChronologiePbjcNcp();
      chronologiePeriodes.iterer();
      while (chronologiePeriodes.encoreSuivant())
      {
        PbjcNcp pbjcNcp = (PbjcNcp)chronologiePeriodes.elementSuivant();
        resultatPbjcListerParIndividu.getListePbjcNcp().add(pbjcNcp);
      }
    }
    resultatPbjcListerParIndividu.setEtat(0);
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin Parcours ParcoursPbjcListerParIndividu ********\n");
    }
    return resultatPbjcListerParIndividu;
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
 * Qualified Name:     ParcoursPbjcListerParIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */