package fr.pe.cali.reglementaire.regles.assurance.affiliation.dom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties({"getPeriode", "listeJoursRetenues"})
public class PeriodeAssimilee
{
  private Periode periode;
  private String libelle;
  private BigDecimal heuresIntiales;
  private BigDecimal heuresRetenues;
  private int nombreJoursTravailles;
  private List<Damj> listeJoursRetenues;
  
  public Periode getPeriode()
  {
    return periode;
  }
  
  public void setPeriode(Periode periode)
  {
    this.periode = periode;
  }
  
  public String getLibelle()
  {
    return libelle;
  }
  
  public void setLibelle(String libelle)
  {
    this.libelle = libelle;
  }
  
  @JsonProperty("Hinit")
  public BigDecimal getHeuresIntiales()
  {
    return heuresIntiales;
  }
  
  public void setHeuresIntiales(BigDecimal heuresIntiales)
  {
    this.heuresIntiales = heuresIntiales;
  }
  
  @JsonProperty("Hret")
  public BigDecimal getHeuresRetenues()
  {
    return heuresRetenues;
  }
  
  public void setHeuresRetenues(BigDecimal heuresRetenues)
  {
    this.heuresRetenues = heuresRetenues;
  }
  
  @JsonProperty("nbJT")
  public int getNombreJoursTravailles()
  {
    return nombreJoursTravailles;
  }
  
  public void setNombreJoursTravailles(int nombreJoursTravailles)
  {
    this.nombreJoursTravailles = nombreJoursTravailles;
  }
  
  @JsonProperty("periode")
  public String getPeriodeJson()
  {
    return getPeriode().getDebut() + " - " + getPeriode().getFin();
  }
  
  public List<Damj> getListeJoursRetenues()
  {
    return listeJoursRetenues;
  }
  
  public void setListeJoursRetenues(List<Damj> listeJoursRetenues)
  {
    this.listeJoursRetenues = listeJoursRetenues;
  }
}

/* Location:
 * Qualified Name:     PeriodeAssimilee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */