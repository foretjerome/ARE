package fr.pe.cali.reglementaire.regles.assurance.affiliation.dom;

import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.List;
import java.util.Map;

public class ResultatCalculAffiliationJoursTravailles
{
  private int nombreJoursAppartenance = 0;
  private int nombreJoursAffiliation = 0;
  private int nombreJoursAssimilation = 0;
  private List<SemaineCivile> justificationSemaineCivile;
  private Map<String, List<Damj>> justificationRepartitionJoursTravailles;
  private Periode periodeRecherche = null;
  private Chronologie activiteParticipantes;
  private boolean topConflits = false;
  private List<PeriodeAssimilee> periodesAssimilees;
  private int plafondAssimilation;
  
  public int getNombreJoursAppartenance()
  {
    return nombreJoursAppartenance;
  }
  
  public void setNombreJoursAppartenance(int nombreJoursAppartenance)
  {
    this.nombreJoursAppartenance = nombreJoursAppartenance;
  }
  
  public int getNombreJoursAffiliation()
  {
    return nombreJoursAffiliation;
  }
  
  public void setNombreJoursAffiliation(int nombreJoursAffiliation)
  {
    this.nombreJoursAffiliation = nombreJoursAffiliation;
  }
  
  public int getNombreJoursAssimilation()
  {
    return nombreJoursAssimilation;
  }
  
  public void setNombreJoursAssimilation(int nombreJoursAssimilation)
  {
    this.nombreJoursAssimilation = nombreJoursAssimilation;
  }
  
  public List<SemaineCivile> getJustificationSemaineCivile()
  {
    return justificationSemaineCivile;
  }
  
  public void setJustificationSemaineCivile(List<SemaineCivile> justificationSemaineCivile)
  {
    this.justificationSemaineCivile = justificationSemaineCivile;
  }
  
  public Map<String, List<Damj>> getJustificationRepartitionJoursTravailles()
  {
    return justificationRepartitionJoursTravailles;
  }
  
  public void setJustificationRepartitionJoursTravailles(Map<String, List<Damj>> justificationRepartitionJoursTravailles)
  {
    this.justificationRepartitionJoursTravailles = justificationRepartitionJoursTravailles;
  }
  
  public Periode getPeriodeRecherche()
  {
    return periodeRecherche;
  }
  
  public void setPeriodeRecherche(Periode periodeRecherche)
  {
    this.periodeRecherche = periodeRecherche;
  }
  
  public boolean isTopConflits()
  {
    return topConflits;
  }
  
  public void setTopConflits(boolean topConflits)
  {
    this.topConflits = topConflits;
  }
  
  public Chronologie getActiviteParticipantes()
  {
    return activiteParticipantes;
  }
  
  public void setActiviteParticipantes(Chronologie activiteParticipantes)
  {
    this.activiteParticipantes = activiteParticipantes;
  }
  
  public List<PeriodeAssimilee> getPeriodesAssimilees()
  {
    return periodesAssimilees;
  }
  
  public void setPeriodesAssimilees(List<PeriodeAssimilee> periodesAssimilees)
  {
    this.periodesAssimilees = periodesAssimilees;
  }
  
  public int getPlafondAssimilation()
  {
    return plafondAssimilation;
  }
  
  public void setPlafondAssimilation(int plafondAssimilation)
  {
    this.plafondAssimilation = plafondAssimilation;
  }
}

/* Location:
 * Qualified Name:     ResultatCalculAffiliationJoursTravailles
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */