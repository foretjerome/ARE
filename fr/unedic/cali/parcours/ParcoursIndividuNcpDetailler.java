package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import java.text.SimpleDateFormat;
import java.util.Date;
import xcalia.lido.api.LiDOHelper;

public class ParcoursIndividuNcpDetailler
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Début Parcours ParcoursIndividuNcpDetailler ********\n");
    }
    ResultatIndividuNcpDetailler resultatIndividuNcpDetailler = new ResultatIndividuNcpDetailler();
    
    IndividuPbjcNcp individuPbjcNcp = DomManager.getIndividuPbjcNcp();
    if (individuPbjcNcp != null)
    {
      resultatIndividuNcpDetailler.setDateDerniereExecCal(individuPbjcNcp.getDateDerniereExecCal());
      resultatIndividuNcpDetailler.setHeureDerniereExecCal(individuPbjcNcp.getHeureDerniereExecCal());
      resultatIndividuNcpDetailler.setEtatDerniereExecution(individuPbjcNcp.getEtatDerniereExecution());
      resultatIndividuNcpDetailler.setContexteExecution(individuPbjcNcp.getContexteExecution());
      
      resultatIndividuNcpDetailler.setDateDerniereDemCal(individuPbjcNcp.getDateDerniereDemCal());
      resultatIndividuNcpDetailler.setHeureDerniereDemCal(individuPbjcNcp.getHeureDerniereDemCal());
      
      resultatIndividuNcpDetailler.setDernierJourIndemnisable(individuPbjcNcp.getDernierJourIndemnisable());
      
      resultatIndividuNcpDetailler.setDateDepartRetraiteCalculee(individuPbjcNcp.getDateDepartRetraiteCalculee());
      resultatIndividuNcpDetailler.setCodeJustifRetraite(individuPbjcNcp.getCodeJustifRetraite());
      resultatIndividuNcpDetailler.setNombreTrimestreRetraite(individuPbjcNcp.getNombreTrimestreRetraite());
      
      resultatIndividuNcpDetailler.setCodeAnomalieCalcul(individuPbjcNcp.getCodeAnomalieCalcul());
      resultatIndividuNcpDetailler.setDonneeAnomalieCalcul(individuPbjcNcp.getDonneeAnomalieCalcul());
      
      resultatIndividuNcpDetailler.setDateAtteinte3mois(individuPbjcNcp.getDateAtteinteMoisNonPaye());
      resultatIndividuNcpDetailler.setDateDebutIneligibilite(individuPbjcNcp.getDateDebutIneligibiliteAidesMob());
      resultatIndividuNcpDetailler.setDateFinIneligibilite(individuPbjcNcp.getDateFinIneligibiliteAidesMob());
      
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
      resultatIndividuNcpDetailler.setTsp(sdf.format((Date)LiDOHelper.getSyntheticValue(individuPbjcNcp.getPC(), "{version}")));
    }
    resultatIndividuNcpDetailler.setEtat(0);
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin Parcours ParcoursIndividuNcpDetailler ********\n");
    }
    return resultatIndividuNcpDetailler;
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
 * Qualified Name:     ParcoursIndividuNcpDetailler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */