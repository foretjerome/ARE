package fr.unedic.cali.dom;

import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class ResultatSimulationAffiliation
  extends Resultat
{
  private static final long serialVersionUID = 3566848481079954551L;
  private IndividuSpec individu;
  private Damj dateFgd;
  private ProduitSpec produit;
  private String produitPropose;
  private Damj datePraDebut;
  private Damj datePraFin;
  private String reglementApplicable;
  private String categorieEmploi;
  private BigDecimal calculaffi;
  private String uniteCalculaffi;
  private BigDecimal cachetGroupe;
  private BigDecimal cachetIsole;
  private BigDecimal assimilation;
  private String uniteAssimilation;
  private int allongementPra;
  private BigDecimal heuresRequises;
  private ObjetMetierSpec justifAffi;
  private DemandeSpec demande;
  private String uniteAffiSecondaire;
  private BigDecimal quantiteAffiSecondaire;
  
  public IndividuSpec getIndividu()
  {
    return individu;
  }
  
  public void setIndividu(IndividuSpec individu)
  {
    this.individu = individu;
  }
  
  public Damj getDateFgd()
  {
    return dateFgd;
  }
  
  public void setDateFgd(Damj date)
  {
    dateFgd = date;
  }
  
  public ProduitSpec getProduit()
  {
    return produit;
  }
  
  public void setProduit(ProduitSpec pProduit)
  {
    produit = pProduit;
  }
  
  public String getProduitPropose()
  {
    return produitPropose;
  }
  
  public void setProduitPropose(String pProduit)
  {
    produitPropose = pProduit;
  }
  
  public Damj getDatePraDebut()
  {
    return datePraDebut;
  }
  
  public void setDatePraDebut(Damj date)
  {
    datePraDebut = date;
  }
  
  public Damj getDatePraFin()
  {
    return datePraFin;
  }
  
  public void setDatePraFin(Damj date)
  {
    datePraFin = date;
  }
  
  public String getReglementApplicable()
  {
    return reglementApplicable;
  }
  
  public void setreglementApplicable(String string)
  {
    reglementApplicable = string;
  }
  
  public String getcatEmploi()
  {
    return categorieEmploi;
  }
  
  public void setcatEmploi(String string)
  {
    categorieEmploi = string;
  }
  
  public BigDecimal getAffiCalcule()
  {
    return calculaffi;
  }
  
  public void setAffiCalcule(BigDecimal bigDecimal)
  {
    calculaffi = bigDecimal;
  }
  
  public String getUniteAffiCalcule()
  {
    return uniteCalculaffi;
  }
  
  public void setUniteAffiCalcule(String string)
  {
    uniteCalculaffi = string;
  }
  
  public BigDecimal getCachetGroupe()
  {
    return cachetGroupe;
  }
  
  public void setCachetGroupe(BigDecimal bigDecimal)
  {
    cachetGroupe = bigDecimal;
  }
  
  public BigDecimal getCachetIsole()
  {
    return cachetIsole;
  }
  
  public void setCachetIsole(BigDecimal bigDecimal)
  {
    cachetIsole = bigDecimal;
  }
  
  public BigDecimal getAssimilation()
  {
    return assimilation;
  }
  
  public void setAssimilation(BigDecimal bigDecimal)
  {
    assimilation = bigDecimal;
  }
  
  public int getAllongementPra()
  {
    return allongementPra;
  }
  
  public void setAllongementPra(int allongementPra)
  {
    this.allongementPra = allongementPra;
  }
  
  public BigDecimal getHeuresRequises()
  {
    return heuresRequises;
  }
  
  public void setHeuresRequises(BigDecimal bigDecimal)
  {
    heuresRequises = bigDecimal;
  }
  
  public ObjetMetierSpec getJustifAffi()
  {
    return justifAffi;
  }
  
  public void setJustifAffi(ObjetMetierSpec justificationAffiliation)
  {
    justifAffi = justificationAffiliation;
  }
  
  public DemandeSpec getDemande()
  {
    return demande;
  }
  
  public void setDemande(DemandeSpec demande)
  {
    this.demande = demande;
  }
  
  public String getUniteAffiSecondaire()
  {
    return uniteAffiSecondaire;
  }
  
  public void setUniteAffiSecondaire(String uniteAffiSecondaire)
  {
    this.uniteAffiSecondaire = uniteAffiSecondaire;
  }
  
  public BigDecimal getQuantiteAffiSecondaire()
  {
    return quantiteAffiSecondaire;
  }
  
  public void setQuantiteAffiSecondaire(BigDecimal quantiteAffiSecondaire)
  {
    this.quantiteAffiSecondaire = quantiteAffiSecondaire;
  }
  
  public String getUniteAssimilation()
  {
    return uniteAssimilation;
  }
  
  public void setUniteAssimilation(String uniteAssimilation)
  {
    this.uniteAssimilation = uniteAssimilation;
  }
}

/* Location:
 * Qualified Name:     ResultatSimulationAffiliation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */