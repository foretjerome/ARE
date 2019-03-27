package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;

public class ParcoursLirePEC
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    OutilTrace.tracerDebutParcours();
    
    ResultatLirePEC resultat = new ResultatLirePEC();
    
    resultat.setEtat(1);
    
    DomLirePEC dom = (DomLirePEC)p_contexte.getDonnees();
    
    resultat.setIndividu(dom.getIndividu());
    
    resultat.setEtat(0);
    
    OutilTrace.tracerFinParcours();
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
 * Qualified Name:     ParcoursLirePEC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */