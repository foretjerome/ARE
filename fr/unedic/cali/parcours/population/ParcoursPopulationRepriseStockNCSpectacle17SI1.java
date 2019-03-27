package fr.unedic.cali.parcours.population;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresTraitementPopulation;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;

public class ParcoursPopulationRepriseStockNCSpectacle17SI1
  extends ParcoursPopulationAbstraite
{
  private String nomPopulation = null;
  
  public Resultat demarrer(Contexte contexte)
    throws ApplicativeException
  {
    effectuerPreTraitement(contexte);
    return lancerReexecution(contexte);
  }
  
  private void effectuerPreTraitement(Contexte contexte)
    throws ApplicativeException
  {
    CriteresTraitementPopulation criteres = new CriteresTraitementPopulation();
    criteres.setContexte(contexte);
    criteres.setIndividu(getDonnees(contexte).getIndividu());
    criteres.setNomPopulation(nomPopulation);
    GammeAsu.getInstance().effectuerTraitementOccasionnel(criteres);
  }
  
  private Resultat lancerReexecution(Contexte contexte)
    throws ApplicativeException
  {
    ParcoursPopulationReexecution parcoursReexecution = new ParcoursPopulationReexecution();
    return parcoursReexecution.demarrer(contexte);
  }
  
  private DomTraitementOccasionnel getDonnees(Contexte contexte)
  {
    return (DomTraitementOccasionnel)contexte.getDonnees();
  }
  
  public String getNomPopulation()
  {
    return nomPopulation;
  }
  
  public void setNomPopulation(String nomPopulation)
  {
    this.nomPopulation = nomPopulation;
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationRepriseStockNCSpectacle17SI1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */