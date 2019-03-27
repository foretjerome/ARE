package fr.unedic.cali.dom;

import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.util.temps.Damj;

public class ConteneurAccesDecorReglementaire
{
  private Damj dateRecherche = null;
  private DemandeSpec demande = null;
  private Damj dateFinContrat = null;
  private Damj dateEngagementProcedureLicenciement = null;
  private Damj dateRuptureContrat = null;
  private boolean derogation = false;
  private boolean estSituationParticuliereAre2001 = false;
  private boolean besoinCriteresQualif = false;
  private TravailSpec dernierSinistre = null;
  private int codeMotifRupture = 0;
  
  public Damj getDateRecherche()
  {
    return dateRecherche;
  }
  
  public void setDateRecherche(Damj dateRecherche)
  {
    this.dateRecherche = dateRecherche;
  }
  
  public DemandeSpec getDemande()
  {
    return demande;
  }
  
  public void setDemande(DemandeSpec demande)
  {
    this.demande = demande;
  }
  
  public Damj getDateEngagementProcedureLicenciement()
  {
    return dateEngagementProcedureLicenciement;
  }
  
  public void setDateEngagementProcedureLicenciement(Damj dateEngagementProcedureLicenciement)
  {
    this.dateEngagementProcedureLicenciement = dateEngagementProcedureLicenciement;
  }
  
  public Damj getDateFinContrat()
  {
    return dateFinContrat;
  }
  
  public void setDateFinContrat(Damj dateFinContrat)
  {
    this.dateFinContrat = dateFinContrat;
  }
  
  public Damj getDateRuptureContrat()
  {
    return dateRuptureContrat;
  }
  
  public void setDateRuptureContrat(Damj dateRuptureContrat)
  {
    this.dateRuptureContrat = dateRuptureContrat;
  }
  
  public boolean isDerogation()
  {
    return derogation;
  }
  
  public void setDerogation(boolean derogation)
  {
    this.derogation = derogation;
  }
  
  public boolean isEstSituationParticuliereAre2001()
  {
    return estSituationParticuliereAre2001;
  }
  
  public void setEstSituationParticuliereAre2001(boolean estSituationParticuliereAre2001)
  {
    this.estSituationParticuliereAre2001 = estSituationParticuliereAre2001;
  }
  
  public boolean isBesoinCritereQualif()
  {
    return besoinCriteresQualif;
  }
  
  public void setBesoinCritereQualif(boolean besoinCriteresQualif)
  {
    this.besoinCriteresQualif = besoinCriteresQualif;
  }
  
  public TravailSpec getDernierSinistre()
  {
    return dernierSinistre;
  }
  
  public void setDernierSinistre(TravailSpec dernierSinistre)
  {
    this.dernierSinistre = dernierSinistre;
  }
  
  public int getCodeMotifRupture()
  {
    return codeMotifRupture;
  }
  
  public void setCodeMotifRupture(int codeMotifRupture)
  {
    this.codeMotifRupture = codeMotifRupture;
  }
}

/* Location:
 * Qualified Name:     ConteneurAccesDecorReglementaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */