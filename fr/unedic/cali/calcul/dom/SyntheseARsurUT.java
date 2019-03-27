package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import java.math.BigDecimal;

public class SyntheseARsurUT
  implements ObjetMetierSpec
{
  private static final long serialVersionUID = -6863395168384444721L;
  public static final int REPRISE_MEME_EMPLOYEUR_NON_PRESENTE = 0;
  public static final int REPRISE_MEME_EMPLOYEUR = 1;
  public static final int PAS_REPRISE_MEME_EMPLOYEUR = 2;
  private Quantite m_seuilRemunerationAR = null;
  private Quantite m_seuilRemunerationARAvecActConservee = null;
  private Quantite m_quantiteDecalageForcee = null;
  private Quantite m_totalGainUtilisePourDecalage = null;
  private Quantite m_totalHeureUtilisePourDecalage = null;
  private Quantite m_totalGainActiviteReduiteJustifie = null;
  private Quantite m_totalNbHeureActiviteReduiteJustifie = null;
  private Quantite m_totalGainActiviteReprise = null;
  private Quantite m_totalNbHeureActiviteReprise = null;
  private Quantite m_cumulJourDeTravail = null;
  private Quantite m_cumulNbHeuresTotalesSurUt = null;
  private Quantite m_cumulGainPNDS = null;
  private int m_repriseMemeEmployeur;
  private int m_commissionParitaire;
  private BigDecimal m_coefJourMajoure = null;
  private boolean m_montantReduit = false;
  private Quantite m_totalGainICCPConserves = null;
  private Quantite m_totalGainICCPRepris = null;
  private BigDecimal m_racAns = null;
  private int m_cumulActivite = 0;
  private String m_nomReglement = null;
  private transient boolean m_blocageAtteinteSeuil = false;
  private transient BigDecimal m_seuilVariationRemunerationAdr = null;
  private transient boolean m_blocageVariationRemuneration = false;
  private transient BigDecimal m_seuilPlafondAdr = null;
  private transient Quantite m_totalGainsDeclaresAdrAutres = null;
  private transient Quantite m_totalGainsJustifiesAdr = null;
  private transient Quantite m_totalGainsJustifiesAdrAutres = null;
  private transient Quantite m_decalageDureeUT = null;
  private String estForfaitPans;
  private BigDecimal montantPANS;
  
  public BigDecimal getCoefJourMajoure()
  {
    return m_coefJourMajoure;
  }
  
  public void setCoefJourMajoure(BigDecimal p_coefJourMajoure)
  {
    m_coefJourMajoure = p_coefJourMajoure;
  }
  
  public Quantite getSeuilRemunerationAR()
  {
    return m_seuilRemunerationAR;
  }
  
  public void setSeuilRemunerationAR(Quantite p_seuil)
  {
    m_seuilRemunerationAR = p_seuil;
  }
  
  public Quantite getSeuilRemunerationARAvecActConservee()
  {
    return m_seuilRemunerationARAvecActConservee;
  }
  
  public void setSeuilRemunerationARAvecActConservee(Quantite p_seuilRemunerationARAvecActConservee)
  {
    m_seuilRemunerationARAvecActConservee = p_seuilRemunerationARAvecActConservee;
  }
  
  public Quantite getQuantiteDecalageForcee()
  {
    return m_quantiteDecalageForcee;
  }
  
  public void setQuantiteDecalageForcee(Quantite p_quantiteDecalageForcee)
  {
    m_quantiteDecalageForcee = p_quantiteDecalageForcee;
  }
  
  public Quantite getTotalGainUtilisePourDecalage()
  {
    return m_totalGainUtilisePourDecalage;
  }
  
  public void setTotalGainUtilisePourDecalage(Quantite p_totalGainUtilisePourDecalage)
  {
    m_totalGainUtilisePourDecalage = p_totalGainUtilisePourDecalage;
  }
  
  public Quantite getTotalHeureUtilisePourDecalage()
  {
    return m_totalHeureUtilisePourDecalage;
  }
  
  public void setTotalHeureUtilisePourDecalage(Quantite p_totalHeureUtilisePourDecalage)
  {
    m_totalHeureUtilisePourDecalage = p_totalHeureUtilisePourDecalage;
  }
  
  public int getRepriseMemeEmployeur()
  {
    return m_repriseMemeEmployeur;
  }
  
  public void setRepriseMemeEmployeur(int p_repriseMemeEmployeur)
  {
    m_repriseMemeEmployeur = p_repriseMemeEmployeur;
  }
  
  public int getCommissionParitaire()
  {
    return m_commissionParitaire;
  }
  
  public void setCommissionParitaire(int p_commissionParitaire)
  {
    m_commissionParitaire = p_commissionParitaire;
  }
  
  public Quantite getTotalGainActiviteReduiteJustifie()
  {
    return m_totalGainActiviteReduiteJustifie;
  }
  
  public void setTotalGainActiviteReduiteJustifie(Quantite p_totalGainActiviteReduiteJustifie)
  {
    m_totalGainActiviteReduiteJustifie = p_totalGainActiviteReduiteJustifie;
  }
  
  public Quantite getTotalNbHeureActiviteReduiteJustifie()
  {
    return m_totalNbHeureActiviteReduiteJustifie;
  }
  
  public void setTotalNbHeureActiviteReduiteJustifie(Quantite p_totalNbHeureActiviteReduiteJustifie)
  {
    m_totalNbHeureActiviteReduiteJustifie = p_totalNbHeureActiviteReduiteJustifie;
  }
  
  public Quantite getCumulJourDeTravailAR()
  {
    return m_cumulJourDeTravail;
  }
  
  public void setCumulJourDeTravailAR(Quantite p_cumulJourDeTravail)
  {
    m_cumulJourDeTravail = p_cumulJourDeTravail;
  }
  
  public Quantite getCumulGainPNDS()
  {
    return m_cumulGainPNDS;
  }
  
  public void setCumulGainPNDS(Quantite p_cumulGainPNDS)
  {
    m_cumulGainPNDS = p_cumulGainPNDS;
  }
  
  public ObjetMetierSpec copie()
  {
    SyntheseARsurUT copie = new SyntheseARsurUT();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    SyntheseARsurUT copie = (SyntheseARsurUT)p_copie;
    
    m_seuilRemunerationAR = getSeuilRemunerationAR();
    m_seuilRemunerationARAvecActConservee = getSeuilRemunerationARAvecActConservee();
    m_quantiteDecalageForcee = getQuantiteDecalageForcee();
    m_totalGainUtilisePourDecalage = getTotalGainUtilisePourDecalage();
    m_totalHeureUtilisePourDecalage = getTotalHeureUtilisePourDecalage();
    m_repriseMemeEmployeur = getRepriseMemeEmployeur();
    m_totalGainActiviteReduiteJustifie = getTotalGainActiviteReduiteJustifie();
    m_totalNbHeureActiviteReduiteJustifie = getTotalNbHeureActiviteReduiteJustifie();
    m_cumulJourDeTravail = getCumulJourDeTravailAR();
    m_cumulGainPNDS = getCumulGainPNDS();
    m_coefJourMajoure = getCoefJourMajoure();
  }
  
  public boolean estMontantReduit()
  {
    return m_montantReduit;
  }
  
  public void setMontantReduit(boolean p_montantReduit)
  {
    m_montantReduit = p_montantReduit;
  }
  
  public Quantite getCumulNbHeuresTotalesSurUt()
  {
    return m_cumulNbHeuresTotalesSurUt;
  }
  
  public void setCumulNbHeuresTotalesSurUt(Quantite p_cumulNbHeuresTotalesSurUt)
  {
    m_cumulNbHeuresTotalesSurUt = p_cumulNbHeuresTotalesSurUt;
  }
  
  public Quantite getTotalGainICCPConserves()
  {
    return m_totalGainICCPConserves;
  }
  
  public void setTotalGainICCPConserves(Quantite p_totalGainICCPConserves)
  {
    m_totalGainICCPConserves = p_totalGainICCPConserves;
  }
  
  public Quantite getTotalGainICCPRepris()
  {
    return m_totalGainICCPRepris;
  }
  
  public void setTotalGainICCPRepris(Quantite p_totalGainICCPRepris)
  {
    m_totalGainICCPRepris = p_totalGainICCPRepris;
  }
  
  public BigDecimal getSeuilPlafondAdr()
  {
    return m_seuilPlafondAdr;
  }
  
  public void setSeuilPlafondAdr(BigDecimal p_seuilPlafondAdr)
  {
    m_seuilPlafondAdr = p_seuilPlafondAdr;
  }
  
  public BigDecimal getSeuilVariationRemunerationAdr()
  {
    return m_seuilVariationRemunerationAdr;
  }
  
  public void setSeuilVariationRemunerationAdr(BigDecimal p_seuilVariationRemunerationAdr)
  {
    m_seuilVariationRemunerationAdr = p_seuilVariationRemunerationAdr;
  }
  
  public boolean isBlocageAtteinteSeuil()
  {
    return m_blocageAtteinteSeuil;
  }
  
  public void setBlocageAtteinteSeuil(boolean p_blocageAtteinteSeuil)
  {
    m_blocageAtteinteSeuil = p_blocageAtteinteSeuil;
  }
  
  public boolean isBlocageVariationRemuneration()
  {
    return m_blocageVariationRemuneration;
  }
  
  public void setBlocageVariationRemuneration(boolean p_blocageVariationRemuneration)
  {
    m_blocageVariationRemuneration = p_blocageVariationRemuneration;
  }
  
  public Quantite getTotalGainsDeclaresAdrAutres()
  {
    return m_totalGainsDeclaresAdrAutres;
  }
  
  public void setTotalGainsDeclaresAdrAutres(Quantite p_totalGainsDeclaresAdrAutres)
  {
    m_totalGainsDeclaresAdrAutres = p_totalGainsDeclaresAdrAutres;
  }
  
  public Quantite getTotalGainsJustifiesAdr()
  {
    return m_totalGainsJustifiesAdr;
  }
  
  public void setTotalGainsJustifiesAdr(Quantite p_totalGainsJustifiesAdr)
  {
    m_totalGainsJustifiesAdr = p_totalGainsJustifiesAdr;
  }
  
  public Quantite getTotalGainsJustifiesAdrAutres()
  {
    return m_totalGainsJustifiesAdrAutres;
  }
  
  public void setTotalGainsJustifiesAdrAutres(Quantite p_totalGainsJustifiesAdrAutres)
  {
    m_totalGainsJustifiesAdrAutres = p_totalGainsJustifiesAdrAutres;
  }
  
  public Quantite getDecalageDureeUT()
  {
    return m_decalageDureeUT;
  }
  
  public void setDecalageDureeUT(Quantite p_decalageDureeUT)
  {
    m_decalageDureeUT = p_decalageDureeUT;
  }
  
  public BigDecimal getRacAns()
  {
    return m_racAns;
  }
  
  public void setRacAns(BigDecimal p_racAns)
  {
    m_racAns = p_racAns;
  }
  
  public int getCumulActivite()
  {
    return m_cumulActivite;
  }
  
  public void setCumulActivite(int p_cumulActivite)
  {
    m_cumulActivite = p_cumulActivite;
  }
  
  public String getNomReglement()
  {
    return m_nomReglement;
  }
  
  public void setNomReglement(String p_nomReglement)
  {
    m_nomReglement = p_nomReglement;
  }
  
  public Quantite getTotalGainActiviteReprise()
  {
    return m_totalGainActiviteReprise;
  }
  
  public void setTotalGainActiviteReprise(Quantite p_totalGainActiviteReprise)
  {
    m_totalGainActiviteReprise = p_totalGainActiviteReprise;
  }
  
  public Quantite getTotalNbHeureActiviteReprise()
  {
    return m_totalNbHeureActiviteReprise;
  }
  
  public void setTotalNbHeureActiviteReprise(Quantite p_totalNbHeureActiviteReprise)
  {
    m_totalNbHeureActiviteReprise = p_totalNbHeureActiviteReprise;
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
 * Qualified Name:     SyntheseARsurUT
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */