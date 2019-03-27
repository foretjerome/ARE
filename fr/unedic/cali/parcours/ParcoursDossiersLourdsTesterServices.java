package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.dossiersLourds.DomDossiersLourdsTesterServices;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;

public class ParcoursDossiersLourdsTesterServices
  extends ParcoursServiceAbstrait
{
  protected void initialiserContexteParcour(Contexte p_contexte) {}
  
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    return demarrerParcours(p_contexte);
  }
  
  protected Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatDossiersLourdsTesterServices resultat = new ResultatDossiersLourdsTesterServices();
    resultat.setEtat(1);
    
    ParcoursServiceAbstrait parcours = (ParcoursServiceAbstrait)((ContexteDossiersLourds)p_contexte).getParcours();
    String libelleErreurAccesDonneesGaec = null;
    try
    {
      parcours.effectuerParcours(p_contexte);
    }
    catch (AccesDonneesGaecException ex)
    {
      libelleErreurAccesDonneesGaec = ex.getMessage();
    }
    catch (ApplicativeException ex)
    {
      throw ex;
    }
    Individu individu = ((ContexteDossiersLourds)p_contexte).getIndividu();
    DomDossiersLourdsTesterServices domRetour = new DomDossiersLourdsTesterServices();
    mapperIndividuSurDomRetour(individu, domRetour);
    mapperErreurAccesGaecSurDomRetour(libelleErreurAccesDonneesGaec, domRetour);
    
    resultat.setEtat(0);
    resultat.setDomDossiersLourdsTesterServices(domRetour);
    
    return resultat;
  }
  
  private void mapperIndividuSurDomRetour(Individu p_individu, DomDossiersLourdsTesterServices p_domRetour)
  {
    p_domRetour.setAgregatGaec(p_individu.getDonneesChargementGaec().getAgregatGaec());
    p_domRetour.setAppelGaecReduit(p_individu.getDonneesChargementGaec().getAppelGaecReduit());
    p_domRetour.setEstDebrayage(p_individu.isForcageAppelGaecTotal());
  }
  
  private void mapperErreurAccesGaecSurDomRetour(String p_libelleErreurAccesDonneesGaec, DomDossiersLourdsTesterServices p_domRetour)
  {
    p_domRetour.setMessageErreur(p_libelleErreurAccesDonneesGaec);
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
 * Qualified Name:     ParcoursDossiersLourdsTesterServices
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */