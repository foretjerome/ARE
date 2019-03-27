package fr.unedic.cali.autresdoms.ga.services;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class LA2K
{
  private int annee;
  private int mois;
  private BigDecimal nbHeure;
  private BigDecimal salaireBrut;
  private int codeMemeEmployeur;
  private BigDecimal nbJrDecForce;
  private BigDecimal nbJrTravailCumul;
  private String completude;
  private int sanctionPND;
  private String infoTravailDSM;
  private BigDecimal salaireBrutPND;
  private BigDecimal salaireBrutJustifie;
  private BigDecimal nbHeureJustifie;
  private BigDecimal salaireBrutReprise;
  private BigDecimal nbHeureReprise;
  private BigDecimal nbJrDecCalcul;
  private BigDecimal valResultJustPND;
  private BigDecimal nbJrSanctionPND;
  private int codePopulation;
  private Damj dateDebutExecution;
  private String presenceDnj;
  private String estForfaitPans;
  private BigDecimal montantPANS;
  
  public int getAnnee()
  {
    return annee;
  }
  
  public void setAnnee(int annee)
  {
    this.annee = annee;
  }
  
  public int getMois()
  {
    return mois;
  }
  
  public void setMois(int mois)
  {
    this.mois = mois;
  }
  
  public BigDecimal getNbHeure()
  {
    return nbHeure;
  }
  
  public void setNbHeure(BigDecimal nbHeure)
  {
    this.nbHeure = nbHeure;
  }
  
  public BigDecimal getSalaireBrut()
  {
    return salaireBrut;
  }
  
  public void setSalaireBrut(BigDecimal salaireBrut)
  {
    this.salaireBrut = salaireBrut;
  }
  
  public int getCodeMemeEmployeur()
  {
    return codeMemeEmployeur;
  }
  
  public void setCodeMemeEmployeur(int codeMemeEmployeur)
  {
    this.codeMemeEmployeur = codeMemeEmployeur;
  }
  
  public BigDecimal getNbJrDecForce()
  {
    return nbJrDecForce;
  }
  
  public void setNbJrDecForce(BigDecimal nbJrDecForce)
  {
    this.nbJrDecForce = nbJrDecForce;
  }
  
  public BigDecimal getNbJrTravailCumul()
  {
    return nbJrTravailCumul;
  }
  
  public void setNbJrTravailCumul(BigDecimal nbJrTravailCumul)
  {
    this.nbJrTravailCumul = nbJrTravailCumul;
  }
  
  public String getCompletude()
  {
    return completude;
  }
  
  public void setCompletude(String completude)
  {
    this.completude = completude;
  }
  
  public int getSanctionPND()
  {
    return sanctionPND;
  }
  
  public void setSanctionPND(int sanctionPND)
  {
    this.sanctionPND = sanctionPND;
  }
  
  public String getInfoTravailDSM()
  {
    return infoTravailDSM;
  }
  
  public void setInfoTravailDSM(String infoTravailDSM)
  {
    this.infoTravailDSM = infoTravailDSM;
  }
  
  public BigDecimal getSalaireBrutPND()
  {
    return salaireBrutPND;
  }
  
  public void setSalaireBrutPND(BigDecimal salaireBrutPND)
  {
    this.salaireBrutPND = salaireBrutPND;
  }
  
  public BigDecimal getSalaireBrutJustifie()
  {
    return salaireBrutJustifie;
  }
  
  public void setSalaireBrutJustifie(BigDecimal salaireBrutJustifie)
  {
    this.salaireBrutJustifie = salaireBrutJustifie;
  }
  
  public BigDecimal getNbHeureJustifie()
  {
    return nbHeureJustifie;
  }
  
  public void setNbHeureJustifie(BigDecimal nbHeureJustifie)
  {
    this.nbHeureJustifie = nbHeureJustifie;
  }
  
  public BigDecimal getNbJrDecCalcul()
  {
    return nbJrDecCalcul;
  }
  
  public void setNbJrDecCalcul(BigDecimal nbJrDecCalcul)
  {
    this.nbJrDecCalcul = nbJrDecCalcul;
  }
  
  public BigDecimal getValResultJustPND()
  {
    return valResultJustPND;
  }
  
  public void setValResultJustPND(BigDecimal valResultJustPND)
  {
    this.valResultJustPND = valResultJustPND;
  }
  
  public BigDecimal getNbJrSanctionPND()
  {
    return nbJrSanctionPND;
  }
  
  public void setNbJrSanctionPND(BigDecimal nbJrSanctionPND)
  {
    this.nbJrSanctionPND = nbJrSanctionPND;
  }
  
  public int getCodePopulation()
  {
    return codePopulation;
  }
  
  public void setCodePopulation(int codePopulation)
  {
    this.codePopulation = codePopulation;
  }
  
  public Damj getDateDebutExecution()
  {
    return dateDebutExecution;
  }
  
  public void setDateDebutExecution(Damj dateDebutExecution)
  {
    this.dateDebutExecution = dateDebutExecution;
  }
  
  public LA2K copie()
  {
    LA2K copie = new LA2K();
    copieElements(copie);
    return copie;
  }
  
  public String getPresenceDnj()
  {
    return presenceDnj;
  }
  
  public void setPresenceDnj(String presenceDnj)
  {
    this.presenceDnj = presenceDnj;
  }
  
  private void copieElements(LA2K copie)
  {
    copie.setAnnee(getAnnee());
    copie.setMois(getMois());
    copie.setNbHeure(getNbHeure());
    copie.setSalaireBrut(getSalaireBrut());
    copie.setCodeMemeEmployeur(getCodeMemeEmployeur());
    copie.setNbJrDecForce(getNbJrDecForce());
    copie.setNbJrTravailCumul(getNbJrTravailCumul());
    copie.setCompletude(getCompletude());
    copie.setSanctionPND(getSanctionPND());
    copie.setInfoTravailDSM(getInfoTravailDSM());
    copie.setSalaireBrutPND(getSalaireBrutPND());
    copie.setSalaireBrutJustifie(getSalaireBrutJustifie());
    copie.setNbHeureJustifie(getNbHeureJustifie());
    copie.setNbJrDecCalcul(getNbJrDecCalcul());
    copie.setValResultJustPND(getValResultJustPND());
    copie.setNbJrSanctionPND(getNbJrSanctionPND());
    copie.setCodePopulation(getCodePopulation());
    copie.setDateDebutExecution(getDateDebutExecution());
    copie.setPresenceDnj(getPresenceDnj());
    copie.setSalaireBrutReprise(getSalaireBrutReprise());
    copie.setNbHeureReprise(getNbHeureReprise());
    copie.setMontantPANS(getMontantPANS());
    copie.setEstForfaitPans(getEstForfaitPans());
  }
  
  public BigDecimal getSalaireBrutReprise()
  {
    return salaireBrutReprise;
  }
  
  public void setSalaireBrutReprise(BigDecimal salaireBrutReprise)
  {
    this.salaireBrutReprise = salaireBrutReprise;
  }
  
  public BigDecimal getNbHeureReprise()
  {
    return nbHeureReprise;
  }
  
  public void setNbHeureReprise(BigDecimal nbHeureReprise)
  {
    this.nbHeureReprise = nbHeureReprise;
  }
  
  public void setEstForfaitPans(String estForfaitPans)
  {
    this.estForfaitPans = estForfaitPans;
  }
  
  public String getEstForfaitPans()
  {
    return estForfaitPans;
  }
  
  public void setMontantPANS(BigDecimal montantPANS)
  {
    this.montantPANS = montantPANS;
  }
  
  public BigDecimal getMontantPANS()
  {
    return montantPANS;
  }
}

/* Location:
 * Qualified Name:     LA2K
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */