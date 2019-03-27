package fr.pe.cali.reglementaire.regles.assurance.affiliation.dom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties({"identifiantContrat", "periodeContrat", "joursTravailles", "estSanctionne"})
@JsonPropertyOrder({"affichagePeriodeContrat", "raisonSociale", "nature", "nomReglement", "nombreJoursTravailles", "sanctionne"})
@XmlType(propOrder={"affichagePeriodeContrat", "raisonSociale", "nature", "nomReglement", "nombreJoursTravailles", "sanctionne"})
public class ElementSemaineCivile
{
  private String identifiantContrat;
  private Periode periodeContrat;
  private List<Damj> joursTravailles;
  private String raisonSociale;
  private String nomReglement;
  private int nature;
  boolean estSanctionne;
  private List<Damj> listePnds;
  
  public ElementSemaineCivile()
  {
    joursTravailles = new ArrayList();
    listePnds = new ArrayList();
  }
  
  public ElementSemaineCivile(String identifiantContrat, Damj dateDebutContrat, Damj dateFinContrat, String raisonSociale)
  {
    this.identifiantContrat = identifiantContrat;
    periodeContrat = new Periode(dateDebutContrat, dateFinContrat);
    this.raisonSociale = raisonSociale;
    joursTravailles = new ArrayList();
    listePnds = new ArrayList();
  }
  
  @XmlTransient
  public String getIdentifiantContrat()
  {
    return identifiantContrat;
  }
  
  public void setIdentifiantContrat(String identifiantContrat)
  {
    this.identifiantContrat = identifiantContrat;
  }
  
  @XmlTransient
  public Periode getPeriodeContrat()
  {
    return periodeContrat;
  }
  
  public void setPeriodeContrat(Periode periodeContrat)
  {
    this.periodeContrat = periodeContrat;
  }
  
  @XmlTransient
  public List<Damj> getJoursTravailles()
  {
    return joursTravailles;
  }
  
  public void setJoursTravailles(List<Damj> joursTravailles)
  {
    this.joursTravailles = joursTravailles;
  }
  
  @XmlElement(name="libelle")
  @JsonProperty("libelle")
  public String getRaisonSociale()
  {
    return raisonSociale;
  }
  
  public void setRaisonSociale(String raisonSociale)
  {
    this.raisonSociale = raisonSociale;
  }
  
  @XmlElement(name="reglement")
  @JsonProperty("reglement")
  public String getNomReglement()
  {
    return nomReglement;
  }
  
  public void setNomReglement(String nomReglement)
  {
    this.nomReglement = nomReglement;
  }
  
  public int getNature()
  {
    return nature;
  }
  
  public void setNature(int nature)
  {
    this.nature = nature;
  }
  
  @XmlElement(name="nbJT")
  @JsonProperty("nbJT")
  public int getNombreJoursTravailles()
  {
    return joursTravailles.size();
  }
  
  @XmlTransient
  public boolean isEstSanctionne()
  {
    return estSanctionne;
  }
  
  public void setEstSanctionne(boolean estSanctionne)
  {
    this.estSanctionne = estSanctionne;
  }
  
  @XmlElement(name="periode")
  @JsonProperty("periode")
  public String getAffichagePeriodeContrat()
  {
    return getPeriodeContrat().getDebut() + " - " + getPeriodeContrat().getFin();
  }
  
  @XmlElement(name="pnds")
  @JsonProperty("pnds")
  public String getSanctionne()
  {
    String affichage = "0";
    if (estSanctionne) {
      affichage = "1";
    }
    return affichage;
  }
  
  public List<Damj> getListePnds()
  {
    return listePnds;
  }
  
  public void setListePnds(List<Damj> listePnds)
  {
    this.listePnds = listePnds;
  }
}

/* Location:
 * Qualified Name:     ElementSemaineCivile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */