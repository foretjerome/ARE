package fr.unedic.cali.calcul.outilsfonctionnels.dom;

import java.math.BigDecimal;

public class ResultatActiviteReduite
{
  private BigDecimal nbHeuresPrisesEnCompte = null;
  private BigDecimal gainPrisEnCompte = null;
  private BigDecimal cumulGainJustifie = null;
  private BigDecimal cumulNbHeuresJustifiees = null;
  private BigDecimal cumulGainReprise = null;
  private BigDecimal cumulNbHeuresReprise = null;
  private BigDecimal cumulJourDeTravail = null;
  private BigDecimal cumulNbHeuresTotalesSurUt = new BigDecimal("0");
  private BigDecimal cumulGainPNDS = new BigDecimal("0");
  private boolean repriseMemeEmployeur = false;
  private BigDecimal seuilRemuneration = null;
  private BigDecimal seuilRemunerationAvecActConservee = null;
  private boolean neutralise = false;
  private int typeNeutralisation;
  private BigDecimal decalage = null;
  private BigDecimal decalageDuree = null;
  private BigDecimal decalagePNDS = null;
  private boolean contientUneActiviteCESouCIA = false;
  private BigDecimal coefJourMajore;
  private BigDecimal cumulGainICCPConserves = null;
  private BigDecimal cumulGainICCPRepris = null;
  private BigDecimal racAns = null;
  private boolean depassementPlafond = false;
  private BigDecimal quantiteIndemnise;
  private BigDecimal areRestante;
  private BigDecimal arePlafond;
  private String estForfaitPans;
  private BigDecimal montantPANS;
  
  public BigDecimal getGainPrisEnCompte()
  {
    return gainPrisEnCompte;
  }
  
  public BigDecimal getNbHeuresPrisesEnCompte()
  {
    return nbHeuresPrisesEnCompte;
  }
  
  public void setGainPrisEnCompte(BigDecimal gainPrisEnCompte)
  {
    this.gainPrisEnCompte = gainPrisEnCompte;
  }
  
  public void setNbHeuresPrisesEnCompte(BigDecimal nbHeuresPrisesEnCompte)
  {
    this.nbHeuresPrisesEnCompte = nbHeuresPrisesEnCompte;
  }
  
  public boolean isNeutralise()
  {
    return neutralise;
  }
  
  public void setNeutralise(boolean neutralise)
  {
    this.neutralise = neutralise;
  }
  
  public BigDecimal getSeuilRemuneration()
  {
    return seuilRemuneration;
  }
  
  public void setSeuilRemuneration(BigDecimal remuneration)
  {
    seuilRemuneration = remuneration;
  }
  
  public BigDecimal getSeuilRemunerationAvecActConservee()
  {
    return seuilRemunerationAvecActConservee;
  }
  
  public void setSeuilRemunerationAvecActConservee(BigDecimal seuilRemunerationAvecActConservee)
  {
    this.seuilRemunerationAvecActConservee = seuilRemunerationAvecActConservee;
  }
  
  public int getTypeNeutralisation()
  {
    return typeNeutralisation;
  }
  
  public void setTypeNeutralisation(int typeNeutralisation)
  {
    this.typeNeutralisation = typeNeutralisation;
  }
  
  public BigDecimal getCumulGainJustifie()
  {
    return cumulGainJustifie;
  }
  
  public void setCumulGainJustifie(BigDecimal cumulGainJustifie)
  {
    this.cumulGainJustifie = cumulGainJustifie;
  }
  
  public BigDecimal getCumulNbHeuresJustifiees()
  {
    return cumulNbHeuresJustifiees;
  }
  
  public void setCumulNbHeuresJustifiees(BigDecimal cumulNbHeuresJustifiees)
  {
    this.cumulNbHeuresJustifiees = cumulNbHeuresJustifiees;
  }
  
  public BigDecimal getCumulJourDeTravail()
  {
    return cumulJourDeTravail;
  }
  
  public void setCumulJourDeTravail(BigDecimal cumulJourDeTravail)
  {
    this.cumulJourDeTravail = cumulJourDeTravail;
  }
  
  public BigDecimal getCumulGainPNDS()
  {
    return cumulGainPNDS;
  }
  
  public void setCumulGainPNDS(BigDecimal cumulGainPNDS)
  {
    this.cumulGainPNDS = cumulGainPNDS;
  }
  
  public boolean isRepriseMemeEmployeur()
  {
    return repriseMemeEmployeur;
  }
  
  public void setRepriseMemeEmployeur(boolean repriseMemeEmployeur)
  {
    this.repriseMemeEmployeur = repriseMemeEmployeur;
  }
  
  public BigDecimal getCreditDecalage()
  {
    return decalage;
  }
  
  public void setCreditDecalage(BigDecimal decalage)
  {
    this.decalage = decalage;
  }
  
  public BigDecimal getDecalageDuree()
  {
    return decalageDuree;
  }
  
  public void setDecalageDuree(BigDecimal decalageDuree)
  {
    this.decalageDuree = decalageDuree;
  }
  
  public BigDecimal getCreditDecalagePNDS()
  {
    return decalagePNDS;
  }
  
  public void setCreditDecalagePNDS(BigDecimal decalagePNDS)
  {
    this.decalagePNDS = decalagePNDS;
  }
  
  public boolean isContientUneActiviteCESouCIA()
  {
    return contientUneActiviteCESouCIA;
  }
  
  public void setContientUneActiviteCESouCIA(boolean contientUneActiviteCESouCIA)
  {
    this.contientUneActiviteCESouCIA = contientUneActiviteCESouCIA;
  }
  
  public BigDecimal getCoefJourMajore()
  {
    return coefJourMajore;
  }
  
  public void setCoefJourMajore(BigDecimal coefJourMajore)
  {
    this.coefJourMajore = coefJourMajore;
  }
  
  public BigDecimal getCumulNbHeuresTotalesSurUt()
  {
    return cumulNbHeuresTotalesSurUt;
  }
  
  public void setCumulNbHeuresTotalesSurUt(BigDecimal cumulNbHeuresTotalesSurUt)
  {
    this.cumulNbHeuresTotalesSurUt = cumulNbHeuresTotalesSurUt;
  }
  
  public BigDecimal getCumulGainICCPConserves()
  {
    return cumulGainICCPConserves;
  }
  
  public void setCumulGainICCPConserves(BigDecimal cumulGainICCPConserves)
  {
    this.cumulGainICCPConserves = cumulGainICCPConserves;
  }
  
  public BigDecimal getCumulGainICCPRepris()
  {
    return cumulGainICCPRepris;
  }
  
  public void setCumulGainICCPRepris(BigDecimal cumulGainICCPRepris)
  {
    this.cumulGainICCPRepris = cumulGainICCPRepris;
  }
  
  public BigDecimal getRacAns()
  {
    return racAns;
  }
  
  public void setRacAns(BigDecimal racAns)
  {
    this.racAns = racAns;
  }
  
  public boolean isDepassementPlafond()
  {
    return depassementPlafond;
  }
  
  public void setDepassementPlafond(boolean depassementPlafond)
  {
    this.depassementPlafond = depassementPlafond;
  }
  
  public BigDecimal getQuantiteIndemnise()
  {
    return quantiteIndemnise;
  }
  
  public void setQuantiteIndemnise(BigDecimal quantiteIndemnise)
  {
    this.quantiteIndemnise = quantiteIndemnise;
  }
  
  public BigDecimal getCumulGainReprise()
  {
    return cumulGainReprise;
  }
  
  public void setCumulGainReprise(BigDecimal cumulGainReprise)
  {
    this.cumulGainReprise = cumulGainReprise;
  }
  
  public BigDecimal getCumulNbHeuresReprise()
  {
    return cumulNbHeuresReprise;
  }
  
  public void setCumulNbHeuresReprise(BigDecimal cumulNbHeuresReprise)
  {
    this.cumulNbHeuresReprise = cumulNbHeuresReprise;
  }
  
  public BigDecimal getAreRestante()
  {
    return areRestante;
  }
  
  public void setAreRestante(BigDecimal areRestante)
  {
    this.areRestante = areRestante;
  }
  
  public BigDecimal getArePlafond()
  {
    return arePlafond;
  }
  
  public void setArePlafond(BigDecimal arePlafond)
  {
    this.arePlafond = arePlafond;
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
 * Qualified Name:     ResultatActiviteReduite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */