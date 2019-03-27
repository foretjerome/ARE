package fr.unedic.cali.autresdoms.dmc.dom.aides.web;

import fr.unedic.util.temps.Damj;

public class PeriodeAideMobilite
{
  private Long idPeriode;
  private Long idDemande;
  private Damj dateDebutPeriode;
  private Damj dateFinPeriode;
  private Boolean topTerritoireFrancais;
  private Long distanceAR;
  private Boolean topDureeTrajet;
  private Integer nombreDeplacementAR;
  private Integer nombreRepas;
  private Integer nombreHebergement;
  private String commune;
  
  public Long getIdPeriode()
  {
    return idPeriode;
  }
  
  public void setIdPeriode(Long idPeriode)
  {
    this.idPeriode = idPeriode;
  }
  
  public Long getIdDemande()
  {
    return idDemande;
  }
  
  public void setIdDemande(Long idDemande)
  {
    this.idDemande = idDemande;
  }
  
  public Damj getDateDebutPeriode()
  {
    return dateDebutPeriode;
  }
  
  public void setDateDebutPeriode(Damj dateDebutPeriode)
  {
    this.dateDebutPeriode = dateDebutPeriode;
  }
  
  public Damj getDateFinPeriode()
  {
    return dateFinPeriode;
  }
  
  public void setDateFinPeriode(Damj dateFinPeriode)
  {
    this.dateFinPeriode = dateFinPeriode;
  }
  
  public Boolean getTopTerritoireFrancais()
  {
    return topTerritoireFrancais;
  }
  
  public void setTopTerritoireFrancais(Boolean topTerritoireFrancais)
  {
    this.topTerritoireFrancais = topTerritoireFrancais;
  }
  
  public Long getDistanceAR()
  {
    return distanceAR;
  }
  
  public void setDistanceAR(Long distanceAR)
  {
    this.distanceAR = distanceAR;
  }
  
  public Boolean getTopDureeTrajet()
  {
    return topDureeTrajet;
  }
  
  public void setTopDureeTrajet(Boolean topDureeTrajet)
  {
    this.topDureeTrajet = topDureeTrajet;
  }
  
  public Integer getNombreDeplacementAR()
  {
    return nombreDeplacementAR;
  }
  
  public void setNombreDeplacementAR(Integer nombreDeplacementAR)
  {
    this.nombreDeplacementAR = nombreDeplacementAR;
  }
  
  public Integer getNombreRepas()
  {
    return nombreRepas;
  }
  
  public void setNombreRepas(Integer nombreRepas)
  {
    this.nombreRepas = nombreRepas;
  }
  
  public Integer getNombreHebergement()
  {
    return nombreHebergement;
  }
  
  public void setNombreHebergement(Integer nombreHebergement)
  {
    this.nombreHebergement = nombreHebergement;
  }
  
  public String getCommune()
  {
    return commune;
  }
  
  public void setCommune(String commune)
  {
    this.commune = commune;
  }
}

/* Location:
 * Qualified Name:     PeriodeAideMobilite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */