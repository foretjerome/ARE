package fr.unedic.cali.dom.conteneurs;

import fr.unedic.cali.autresdoms.cohab.dom.spec.PeriodePensionInvaliditeChaineeSpec;
import fr.unedic.cali.calcul.dom.periode.PeriodeAvantageVieillesse;
import fr.unedic.cali.dom.FormuleMontantSpec;
import fr.unedic.cali.dom.SalaireJournalierSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DonneesCalculMontant
{
  private BigDecimal coefficientSaisonnier = null;
  private BigDecimal coefficientTempsPartiel = null;
  private BigDecimal coefficientAvantageVieillesse = new BigDecimal("0");
  private BigDecimal tauxAvantageVieillesse = new BigDecimal("0");
  private BigDecimal montantAvantageVieillesse = new BigDecimal("0");
  private BigDecimal montantPensionInvaliditeADeduire = new BigDecimal("0");
  private SalaireJournalierSpec salaireJournalier = null;
  private BigDecimal coefficientSanctionReduction = null;
  private Boolean avecPrecompteCRC = null;
  private Collection<PeriodePensionInvaliditeChaineeSpec> listePensionInvalidite = null;
  private Boolean estProduitGerantPensionInvalidite = null;
  private boolean contexteFormation = false;
  private boolean priseEnCompteAvantageVieillesse = true;
  private boolean priseEnComptePensionInvalidite = true;
  private FormuleMontantSpec formuleMontant = null;
  private ProduitSpec produit = null;
  private int typeCaractereSaisonnierRetenu;
  private boolean isConditionCaractereSaisonnierParRythme = false;
  private PeriodeAvantageVieillesse periodeAvantageVieillesse = null;
  private Damj dateEffetAV = null;
  private Reglement reglementMontantRetenu = null;
  private boolean expatrieApresConvention17 = false;
  
  public Boolean getAvecPrecompteCRC()
  {
    return avecPrecompteCRC;
  }
  
  public void setAvecPrecompteCRC(Boolean avecPrecompteCRC)
  {
    this.avecPrecompteCRC = avecPrecompteCRC;
  }
  
  public BigDecimal getCoefficientAvantageVieillesse()
  {
    return coefficientAvantageVieillesse;
  }
  
  public void setCoefficientAvantageVieillesse(BigDecimal coefficientAvantageVieillesse)
  {
    this.coefficientAvantageVieillesse = coefficientAvantageVieillesse;
  }
  
  public BigDecimal getCoefficientSaisonnier()
  {
    return coefficientSaisonnier;
  }
  
  public void setCoefficientSaisonnier(BigDecimal coefficientSaisonnier)
  {
    this.coefficientSaisonnier = coefficientSaisonnier;
  }
  
  public BigDecimal getCoefficientSanctionReduction()
  {
    return coefficientSanctionReduction;
  }
  
  public void setCoefficientSanctionReduction(BigDecimal coefficientSanctionReduction)
  {
    this.coefficientSanctionReduction = coefficientSanctionReduction;
  }
  
  public BigDecimal getCoefficientTempsPartiel()
  {
    return coefficientTempsPartiel;
  }
  
  public void setCoefficientTempsPartiel(BigDecimal coefficientTempsPartiel)
  {
    this.coefficientTempsPartiel = coefficientTempsPartiel;
  }
  
  public Boolean getEstProduitGerantPensionInvalidite()
  {
    return estProduitGerantPensionInvalidite;
  }
  
  public void setEstProduitGerantPensionInvalidite(Boolean estProduitGerantPensionInvalidite)
  {
    this.estProduitGerantPensionInvalidite = estProduitGerantPensionInvalidite;
  }
  
  public Collection<PeriodePensionInvaliditeChaineeSpec> getListePensionInvalidite()
  {
    return listePensionInvalidite;
  }
  
  public void setListePensionInvalidite(Collection<PeriodePensionInvaliditeChaineeSpec> listePensionInvalidite)
  {
    this.listePensionInvalidite = listePensionInvalidite;
  }
  
  public BigDecimal getMontantAvantageVieillesse()
  {
    return montantAvantageVieillesse;
  }
  
  public void setMontantAvantageVieillesse(BigDecimal montantAvantageVieillesse)
  {
    this.montantAvantageVieillesse = montantAvantageVieillesse;
  }
  
  public BigDecimal getMontantPensionInvaliditeADeduire()
  {
    return montantPensionInvaliditeADeduire;
  }
  
  public void setMontantPensionInvaliditeADeduire(BigDecimal montantPensionInvaliditeADeduire)
  {
    this.montantPensionInvaliditeADeduire = montantPensionInvaliditeADeduire;
  }
  
  public SalaireJournalierSpec getSalaireJournalier()
  {
    return salaireJournalier;
  }
  
  public void setSalaireJournalier(SalaireJournalierSpec salaireJournalier)
  {
    this.salaireJournalier = salaireJournalier;
  }
  
  public BigDecimal getTauxAvantageVieillesse()
  {
    return tauxAvantageVieillesse;
  }
  
  public void setTauxAvantageVieillesse(BigDecimal tauxAvantageVieillesse)
  {
    this.tauxAvantageVieillesse = tauxAvantageVieillesse;
  }
  
  public boolean isContexteFormation()
  {
    return contexteFormation;
  }
  
  public void setContexteFormation(boolean contexteFormation)
  {
    this.contexteFormation = contexteFormation;
  }
  
  public boolean isPriseEnCompteAvantageVieillesse()
  {
    return priseEnCompteAvantageVieillesse;
  }
  
  public void setPriseEnCompteAvantageVieillesse(boolean priseEnCompteAvantageVieillesse)
  {
    this.priseEnCompteAvantageVieillesse = priseEnCompteAvantageVieillesse;
  }
  
  public boolean isPriseEnComptePensionInvalidite()
  {
    return priseEnComptePensionInvalidite;
  }
  
  public void setPriseEnComptePensionInvalidite(boolean priseEnComptePensionInvalidite)
  {
    this.priseEnComptePensionInvalidite = priseEnComptePensionInvalidite;
  }
  
  public FormuleMontantSpec getFormuleMontant()
  {
    return formuleMontant;
  }
  
  public void setFormuleMontant(FormuleMontantSpec formuleMontant)
  {
    this.formuleMontant = formuleMontant;
  }
  
  public ProduitSpec getProduit()
  {
    return produit;
  }
  
  public void setProduit(ProduitSpec produit)
  {
    this.produit = produit;
  }
  
  public Damj getDateEffetAV()
  {
    return dateEffetAV;
  }
  
  public void setDateEffetAV(Damj dateEffetAV)
  {
    this.dateEffetAV = dateEffetAV;
  }
  
  public boolean isConditionCaractereSaisonnierParRythme()
  {
    return isConditionCaractereSaisonnierParRythme;
  }
  
  public void setConditionCaractereSaisonnierParRythme(boolean isConditionCaractereSaisonnierParRythme)
  {
    this.isConditionCaractereSaisonnierParRythme = isConditionCaractereSaisonnierParRythme;
  }
  
  public PeriodeAvantageVieillesse getPeriodeAvantageVieillesse()
  {
    return periodeAvantageVieillesse;
  }
  
  public void setPeriodeAvantageVieillesse(PeriodeAvantageVieillesse periodeAvantageVieillesse)
  {
    this.periodeAvantageVieillesse = periodeAvantageVieillesse;
  }
  
  public int getTypeCaractereSaisonnierRetenu()
  {
    return typeCaractereSaisonnierRetenu;
  }
  
  public void setTypeCaractereSaisonnierRetenu(int typeCaractereSaisonnierRetenu)
  {
    this.typeCaractereSaisonnierRetenu = typeCaractereSaisonnierRetenu;
  }
  
  public Reglement getReglementMontantRetenu()
  {
    return reglementMontantRetenu;
  }
  
  public void setReglementMontantRetenu(Reglement reglementMontantRetenu)
  {
    this.reglementMontantRetenu = reglementMontantRetenu;
  }
  
  public DonneesCalculMontant copie()
  {
    DonneesCalculMontant copie = new DonneesCalculMontant();
    
    copie.setAvecPrecompteCRC(getAvecPrecompteCRC());
    copie.setCoefficientAvantageVieillesse(getCoefficientAvantageVieillesse());
    copie.setCoefficientSaisonnier(getCoefficientSaisonnier());
    copie.setCoefficientSanctionReduction(getCoefficientSanctionReduction());
    copie.setCoefficientTempsPartiel(getCoefficientTempsPartiel());
    copie.setConditionCaractereSaisonnierParRythme(isConditionCaractereSaisonnierParRythme());
    copie.setContexteFormation(isContexteFormation());
    copie.setDateEffetAV(getDateEffetAV());
    copie.setEstProduitGerantPensionInvalidite(getEstProduitGerantPensionInvalidite());
    copie.setFormuleMontant(getFormuleMontant());
    copie.setMontantAvantageVieillesse(getMontantAvantageVieillesse());
    copie.setMontantPensionInvaliditeADeduire(getMontantPensionInvaliditeADeduire());
    if (getPeriodeAvantageVieillesse() != null) {
      copie.setPeriodeAvantageVieillesse((PeriodeAvantageVieillesse)getPeriodeAvantageVieillesse().copie());
    }
    copie.setPriseEnCompteAvantageVieillesse(isPriseEnCompteAvantageVieillesse());
    copie.setPriseEnComptePensionInvalidite(isPriseEnComptePensionInvalidite());
    copie.setProduit(getProduit());
    copie.setSalaireJournalier(getSalaireJournalier());
    copie.setTauxAvantageVieillesse(getTauxAvantageVieillesse());
    copie.setTypeCaractereSaisonnierRetenu(getTypeCaractereSaisonnierRetenu());
    copie.setReglementMontantRetenu(getReglementMontantRetenu());
    copie.setListePensionInvalidite(new ArrayList());
    if ((getListePensionInvalidite() != null) && (!getListePensionInvalidite().isEmpty()))
    {
      Iterator<PeriodePensionInvaliditeChaineeSpec> it = getListePensionInvalidite().iterator();
      while (it.hasNext()) {
        copie.getListePensionInvalidite().add((PeriodePensionInvaliditeChaineeSpec)((PeriodePensionInvaliditeChaineeSpec)it.next()).copie());
      }
    }
    setExpatrieApresConvention17(isExpatrieApresConvention17());
    return copie;
  }
  
  public boolean isExpatrieApresConvention17()
  {
    return expatrieApresConvention17;
  }
  
  public void setExpatrieApresConvention17(boolean expatrieApresConvention17)
  {
    this.expatrieApresConvention17 = expatrieApresConvention17;
  }
}

/* Location:
 * Qualified Name:     DonneesCalculMontant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */