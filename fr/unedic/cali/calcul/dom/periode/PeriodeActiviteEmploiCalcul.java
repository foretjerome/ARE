package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PeriodeActiviteEmploiCalcul
  extends PeriodeTravailJustifiee
{
  private static final long serialVersionUID = -3347471222296839885L;
  public static final int ACTIVITE_CONSERVEE = 1;
  public static final int ACTIVITE_REPRISE = 2;
  private BigDecimal iccp;
  private String identifiantEmployeur;
  private int categorieEmploiParticulier;
  private int typeContratParticulier;
  private List<?> listeInformationOrigine;
  private int informationOrigine;
  private int typeActivite;
  private Damj dateDebutActiviteConservee;
  private BigDecimal cachets;
  private boolean forfait = false;
  private Quantite quantiteAbsences;
  private Quantite quantiteAffiliationCachets;
  private boolean periodeChevauchantLaFCT = false;
  
  protected PeriodeActiviteEmploiCalcul()
  {
    iccp = BigDecimal.ZERO;
  }
  
  public PeriodeActiviteEmploiCalcul(Damj dateDebut, Damj dateFin)
  {
    super(dateDebut, dateFin);
    iccp = BigDecimal.ZERO;
  }
  
  public BigDecimal getGainHorsIccp()
  {
    BigDecimal gain;
    BigDecimal gain;
    if ((getGain() != null) && (getIccp() != null)) {
      gain = getGain().subtract(getIccp());
    } else {
      gain = getGain();
    }
    return gain;
  }
  
  public BigDecimal getIccp()
  {
    return iccp;
  }
  
  public void setIccp(BigDecimal iccp)
  {
    this.iccp = iccp;
  }
  
  public String getIdentifiantEmployeur()
  {
    return identifiantEmployeur;
  }
  
  public void setIdentifiantEmployeur(String identifiantEmployeur)
  {
    this.identifiantEmployeur = identifiantEmployeur;
  }
  
  public int getCategorieEmploiParticulier()
  {
    return categorieEmploiParticulier;
  }
  
  public void setCategorieEmploiParticulier(int categorieEmploiParticulier)
  {
    this.categorieEmploiParticulier = categorieEmploiParticulier;
  }
  
  public int getTypeContratParticulier()
  {
    return typeContratParticulier;
  }
  
  public void setTypeContratParticulier(int typeContratParticulier)
  {
    this.typeContratParticulier = typeContratParticulier;
  }
  
  public boolean estForfait()
  {
    return forfait;
  }
  
  public void setForfait(boolean forfait)
  {
    this.forfait = forfait;
  }
  
  public List<?> getListeInformationOrigine()
  {
    if (listeInformationOrigine == null) {
      listeInformationOrigine = new ArrayList();
    }
    return listeInformationOrigine;
  }
  
  public void setListeInformationOrigine(List<?> listeInformationOrigine)
  {
    this.listeInformationOrigine = listeInformationOrigine;
  }
  
  public int getTypeActivite()
  {
    return typeActivite;
  }
  
  public void setTypeActivite(int typeActivite)
  {
    this.typeActivite = typeActivite;
  }
  
  public Damj getDateDebutActiviteConservee()
  {
    return dateDebutActiviteConservee;
  }
  
  public void setDateDebutActiviteConservee(Damj dateDebutActiviteConservee)
  {
    this.dateDebutActiviteConservee = dateDebutActiviteConservee;
  }
  
  public BigDecimal getCachets()
  {
    return cachets;
  }
  
  public void setCachets(BigDecimal cachets)
  {
    this.cachets = cachets;
  }
  
  public int getInformationOrigine()
  {
    return informationOrigine;
  }
  
  public void setInformationOrigine(int informationOrigine)
  {
    this.informationOrigine = informationOrigine;
  }
  
  public Quantite getQuantiteAbsences()
  {
    return quantiteAbsences;
  }
  
  public void setQuantiteAbsences(Quantite quantiteAbsences)
  {
    this.quantiteAbsences = quantiteAbsences;
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeActiviteEmploiCalcul copie = new PeriodeActiviteEmploiCalcul();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec copieObject)
  {
    PeriodeActiviteEmploiCalcul copie = (PeriodeActiviteEmploiCalcul)copieObject;
    super.copieElements(copie);
    
    forfait = estForfait();
    
    iccp = getIccp();
    identifiantEmployeur = getIdentifiantEmployeur();
    categorieEmploiParticulier = getCategorieEmploiParticulier();
    typeContratParticulier = getTypeContratParticulier();
    listeInformationOrigine = getListeInformationOrigine();
    typeActivite = getTypeActivite();
    cachets = getCachets();
    informationOrigine = getInformationOrigine();
    quantiteAbsences = getQuantiteAbsences();
    quantiteAffiliationCachets = getQuantiteAffiliationCachets();
  }
  
  public boolean isPeriodeChevauchantLaFCT()
  {
    return periodeChevauchantLaFCT;
  }
  
  public void setPeriodeChevauchantLaFCT(boolean periodeChevauchantLaFCT)
  {
    this.periodeChevauchantLaFCT = periodeChevauchantLaFCT;
  }
  
  public Quantite getQuantiteAffiliationCachets()
  {
    return quantiteAffiliationCachets;
  }
  
  public void setQuantiteAffiliationCachets(Quantite quantiteAffiliationCachets)
  {
    this.quantiteAffiliationCachets = quantiteAffiliationCachets;
  }
}

/* Location:
 * Qualified Name:     PeriodeActiviteEmploiCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */