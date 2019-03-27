package fr.unedic.cali.parcours.population;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.services.AppelServicesGaec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;

public class ParcoursPopulationAbonnementGAEC
  extends ParcoursPopulationAbstraite
{
  public Resultat demarrer(Contexte contexte)
    throws ApplicativeException
  {
    effectuerPreTraitement(contexte);
    
    return lancerReexecution(contexte);
  }
  
  private void effectuerPreTraitement(Contexte contexte)
    throws ApplicativeException
  {
    AppelServicesGaec.enregistrerAbonnementGaec(contexte);
  }
  
  private Resultat lancerReexecution(Contexte contexte)
    throws ApplicativeException
  {
    ParcoursPopulationReexecution parcoursReexecution = new ParcoursPopulationReexecution();
    return parcoursReexecution.demarrer(contexte);
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationAbonnementGAEC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */