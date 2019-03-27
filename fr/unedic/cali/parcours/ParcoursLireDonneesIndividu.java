package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;

public class ParcoursLireDonneesIndividu
  extends ParcoursServiceAbstrait
{
  protected Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    DomDonneesIndividu dom = (DomDonneesIndividu)p_contexte.getDonnees();
    IndividuSpec individu = dom.getIndividu();
    
    ResultatDonneesIndividu resultat = new ResultatDonneesIndividu();
    resultat.setEstAppelGaecTotal(individu.isForcageAppelGaecTotal());
    resultat.setAttributionsAfdFiliereCourte(individu.getAttributionsAfdFiliereCourte());
    resultat.setAttributionsAfdFiliereIntermediaire(individu.getAttributionsAfdFiliereIntermediaire());
    resultat.setAttributionsAfdFiliereLongue(individu.getAttributionsAfdFiliereLongue());
    resultat.setDernierJourIndemnisableAreSpe(individu.getDernierJourIndemnisableAreSpe());
    resultat.setEtat(0);
    resultat.setDateExecutionDifferee(individu.getDateExecutionDifferee());
    resultat.setCodeTransaction(individu.getCodeTransaction());
    resultat.setDomaineSourceFlux(individu.getDomaineSrcFlux());
    resultat.setEstArretReexecution(individu.isEstArretReexecution());
    resultat.setEstDesactivationEfe(individu.isEstDesactEFE());
    resultat.setForcerExecutionDiffere(individu.isEstNonExecutionReceptionFlux());
    return resultat;
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
 * Qualified Name:     ParcoursLireDonneesIndividu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */