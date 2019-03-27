package fr.unedic.cali.parcours.occasionnel;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.occasionnel.DomLireStatistiques;
import fr.unedic.cali.parcours.AccesDonneesGaecException;
import fr.unedic.cali.parcours.ParcoursServiceAbstrait;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;

public class ParcoursChargerStatistiques
  extends ParcoursServiceAbstrait
{
  protected void initialiserContexteParcour(Contexte p_contexte) {}
  
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatChargerStatistiques resultat = new ResultatChargerStatistiques();
    resultat.setEtat(1);
    
    DomLireStatistiques dom = (DomLireStatistiques)p_contexte.getDonnees();
    
    resultat.setEtat(0);
    resultat.setDomLireStatistiques(dom);
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
 * Qualified Name:     ParcoursChargerStatistiques
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */