package fr.pe.cali.reglementaire.regles.assurance.affiliation.dom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"periodeXml", "quantiteRetenue", "totalJoursTravailles", "nombreJoursEmploi", "sanctionne", "listeElements"})
@JsonPropertyOrder({"periodeXml", "quantiteRetenue", "totalJoursTravailles", "nombreJoursEmploi", "sanctionne", "listeElements"})
@JsonIgnoreProperties({"semaineCivile", "estSanctionne"})
public class SemaineCivile
{
  @JsonIgnoreProperties
  private Periode periode;
  private int quantiteRetenue;
  private int totalJoursTravailles;
  private int nombreJoursEmploi;
  @JsonIgnoreProperties
  private boolean estSanctionne;
  @JsonIgnoreProperties
  private Map<String, Map<Integer, ElementSemaineCivile>> elementsSemaineCivile;
  private List<ElementSemaineCivile> cacheListeElements = null;
  
  public SemaineCivile()
  {
    elementsSemaineCivile = new HashMap();
  }
  
  public SemaineCivile(Damj dateDebut, Damj dateFin)
  {
    periode = new Periode(dateDebut, dateFin);
    elementsSemaineCivile = new HashMap();
  }
  
  @XmlTransient
  @JsonIgnoreProperties
  public Periode getSemaineCivile()
  {
    return periode;
  }
  
  public void setSemaineCivile(Periode semaineCivile)
  {
    periode = semaineCivile;
  }
  
  @XmlElement(name="qteAffi")
  @JsonProperty("qteAffi")
  public int getQuantiteRetenue()
  {
    return quantiteRetenue;
  }
  
  public void setQuantiteRetenue(int quantiteRetenue)
  {
    this.quantiteRetenue = quantiteRetenue;
  }
  
  @XmlElement(name="nbJT")
  @JsonProperty("nbJT")
  public int getTotalJoursTravailles()
  {
    return totalJoursTravailles;
  }
  
  public void setTotalJoursTravailles(int totalJoursTravailles)
  {
    this.totalJoursTravailles = totalJoursTravailles;
  }
  
  @XmlElement(name="nbJE")
  @JsonProperty("nbJE")
  public int getNombreJoursEmploi()
  {
    return nombreJoursEmploi;
  }
  
  public void setNombreJoursEmploi(int nombreJoursEmploi)
  {
    this.nombreJoursEmploi = nombreJoursEmploi;
  }
  
  @XmlTransient
  @JsonIgnoreProperties
  public boolean isEstSanctionne()
  {
    return estSanctionne;
  }
  
  public void setEstSanctionne(boolean estSanctionne)
  {
    this.estSanctionne = estSanctionne;
  }
  
  public void ajouterJoursTravailles(String identifiant, String raisonSociale, Damj dateDebutContrat, Damj dateFinContrat, String reglement, int nature, Damj jourTravaille)
  {
    ElementSemaineCivile contrat = recupererElementSemaineCivile(identifiant, raisonSociale, dateDebutContrat, dateFinContrat, reglement, nature);
    contrat.getJoursTravailles().add(jourTravaille);
  }
  
  private ElementSemaineCivile recupererElementSemaineCivile(String identifiant, String raisonSociale, Damj dateDebutContrat, Damj dateFinContrat, String reglement, int nature)
  {
    Map<Integer, ElementSemaineCivile> elementContrat = (Map)elementsSemaineCivile.get(identifiant);
    if (elementContrat == null)
    {
      elementContrat = new HashMap();
      elementsSemaineCivile.put(identifiant, elementContrat);
    }
    ElementSemaineCivile contrat = (ElementSemaineCivile)elementContrat.get(Integer.valueOf(nature));
    if (contrat == null)
    {
      contrat = new ElementSemaineCivile(identifiant, dateDebutContrat, dateFinContrat, raisonSociale);
      contrat.setNomReglement(reglement);
      contrat.setNature(nature);
      elementContrat.put(Integer.valueOf(nature), contrat);
    }
    return contrat;
  }
  
  public void ajouterJoursSanctionnes(String identifiant, String raisonSociale, Damj dateDebutContrat, Damj dateFinContrat, String reglement, int nature, Damj jourSanctionne)
  {
    ElementSemaineCivile contrat = recupererElementSemaineCivile(identifiant, raisonSociale, dateDebutContrat, dateFinContrat, reglement, nature);
    contrat.getListePnds().add(jourSanctionne);
    contrat.setEstSanctionne(true);
  }
  
  @XmlElement(name="activite")
  @JsonProperty("activite")
  public List<ElementSemaineCivile> getListeElements()
  {
    if (cacheListeElements == null)
    {
      cacheListeElements = new ArrayList();
      for (Map<Integer, ElementSemaineCivile> mapInterne : elementsSemaineCivile.values()) {
        cacheListeElements.addAll(mapInterne.values());
      }
      Collections.sort(cacheListeElements, new ComparateurElementSemaineCivile());
    }
    return cacheListeElements;
  }
  
  public boolean estJourEmploi(Damj jourRecherche)
  {
    boolean estJourEmploi = false;
    for (ElementSemaineCivile elementSemaineCivile : getListeElements()) {
      if ((elementSemaineCivile.getPeriodeContrat().contient(jourRecherche)) && (!elementSemaineCivile.getListePnds().contains(jourRecherche)))
      {
        estJourEmploi = true;
        break;
      }
    }
    return estJourEmploi;
  }
  
  public boolean estJourChevauchantActivite(Damj jourRecherche)
  {
    boolean estJourEmploi = false;
    for (ElementSemaineCivile elementSemaineCivile : getListeElements()) {
      if (elementSemaineCivile.getPeriodeContrat().contient(jourRecherche))
      {
        estJourEmploi = true;
        break;
      }
    }
    return estJourEmploi;
  }
  
  public SemaineCivile copie()
  {
    SemaineCivile copie = new SemaineCivile();
    copie.setEstSanctionne(isEstSanctionne());
    copie.setNombreJoursEmploi(getNombreJoursEmploi());
    copie.setQuantiteRetenue(getQuantiteRetenue());
    copie.setSemaineCivile((Periode)getSemaineCivile().copie());
    copie.setTotalJoursTravailles(getTotalJoursTravailles());
    for (Iterator i$ = getListeElements().iterator(); i$.hasNext();)
    {
      elementCourant = (ElementSemaineCivile)i$.next();
      for (Damj jourTravaille : elementCourant.getJoursTravailles()) {
        copie.ajouterJoursTravailles(elementCourant.getIdentifiantContrat(), elementCourant.getRaisonSociale(), elementCourant.getPeriodeContrat().getDebut(), elementCourant.getPeriodeContrat().getFin(), elementCourant.getNomReglement(), elementCourant.getNature(), jourTravaille);
      }
    }
    ElementSemaineCivile elementCourant;
    return copie;
  }
  
  @XmlElement(name="periode")
  @JsonProperty("periode")
  public String getPeriodeXml()
  {
    return getSemaineCivile().getDebut() + " - " + getSemaineCivile().getFin();
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
}

/* Location:
 * Qualified Name:     SemaineCivile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */