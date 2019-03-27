package fr.unedic.cali.parcours;

import fr.pe.cali.parametrestechniques.dom.ParametreTechnique;
import fr.pe.cali.parametrestechniques.persistance.OutilChargementParametresTechniques;
import fr.unedic.util.temps.Damj;
import java.util.List;

public abstract class DomCaliOptimise
  implements DomCali
{
  private Damj dateExecutionDifferee;
  private boolean majDossierAllocataire = false;
  private boolean executionDiffereeTraitee = false;
  private boolean besoinAlimentationReception = true;
  private boolean sauvegarderCrem = false;
  private List<ParametreTechnique> listeParametresTechniques = null;
  
  public synchronized List<ParametreTechnique> recupererListeParametresTechniques(String codePE)
  {
    if (listeParametresTechniques == null) {
      listeParametresTechniques = OutilChargementParametresTechniques.getInstance().chargerParametresTechnique(codePE);
    }
    return listeParametresTechniques;
  }
  
  public Damj getDateExecutionDifferee()
  {
    return dateExecutionDifferee;
  }
  
  public void setDateExecutionDifferee(Damj dateExecutionDifferee)
  {
    this.dateExecutionDifferee = dateExecutionDifferee;
  }
  
  public boolean isMajDossierAllocataire()
  {
    return majDossierAllocataire;
  }
  
  public void setMajDossierAllocataire(boolean majDossierAllocataire)
  {
    this.majDossierAllocataire = majDossierAllocataire;
  }
  
  public boolean isExecutionDiffereeTraitee()
  {
    return executionDiffereeTraitee;
  }
  
  public void setExecutionDiffereeTraitee(boolean executionDiffereeTraitee)
  {
    this.executionDiffereeTraitee = executionDiffereeTraitee;
  }
  
  public boolean isBesoinAlimentationReception()
  {
    return besoinAlimentationReception;
  }
  
  public void setBesoinAlimentationReception(boolean besoinAlimentationReception)
  {
    this.besoinAlimentationReception = besoinAlimentationReception;
  }
  
  public boolean isSauvegarderCrem()
  {
    return sauvegarderCrem;
  }
  
  public void setSauvegarderCrem(boolean sauvegarderCrem)
  {
    this.sauvegarderCrem = sauvegarderCrem;
  }
}

/* Location:
 * Qualified Name:     DomCaliOptimise
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */