package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.databean.Attribute;
import fr.unedic.archi.databean.DataBean;
import fr.unedic.archi.databean.DataBeanImpl;
import fr.unedic.archi.databean.GettersHandler;
import fr.unedic.archi.databean.PropertyInfo;
import fr.unedic.archi.databean.SettersHandler;
import fr.unedic.archi.databean.StringAttribute;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class _FluxPasDna
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private String m__C_ETAT;
  private String m__IDENT;
  private _ListeFluxPasDnaQuantiteTravail m_listeFluxPasDnaQuantiteTravail;
  private String m_listeFluxPasDnaQuantiteTravail_C_ERR;
  private _ListeFluxPasDnaPeriodesPrime m_listeFluxPasDnaPeriodesPrime;
  private String m_listeFluxPasDnaPeriodesPrime_C_ERR;
  private String m_codeMessage;
  private String m_codeMessage_C_ERR;
  private String m_referenceContrat;
  private String m_referenceContrat_C_ERR;
  private String m_uniteAbsence;
  private String m_uniteAbsence_C_ERR;
  private String m_periodiciteHoraireTravail;
  private String m_periodiciteHoraireTravail_C_ERR;
  private String m_categorieEmploiParticulier;
  private String m_categorieEmploiParticulier_C_ERR;
  private String m_codeMetierPCS;
  private String m_codeMetierPCS_C_ERR;
  private String m_abonnementProvisoire;
  private String m_abonnementProvisoire_C_ERR;
  private String m_uniteIntensite;
  private String m_uniteIntensite_C_ERR;
  private String m_nomFamille;
  private String m_nomFamille_C_ERR;
  private String m_prenom;
  private String m_prenom_C_ERR;
  private String m_indicSalaireBrut;
  private String m_indicSalaireBrut_C_ERR;
  private String m_indicPrecompte;
  private String m_indicPrecompte_C_ERR;
  private String m_fillerUn;
  private String m_fillerUn_C_ERR;
  private String m_fillerDeux;
  private String m_fillerDeux_C_ERR;
  private String m_fonctionPublique;
  private String m_fonctionPublique_C_ERR;
  private Damj m_dateDebutPeriode;
  private String m_dateDebutPeriode_C_ERR;
  private Damj m_dateFinPeriode;
  private String m_dateFinPeriode_C_ERR;
  private Damj m_dateVersementSalaire;
  private String m_dateVersementSalaire_C_ERR;
  private BigDecimal m_numeroVersion;
  private String m_numeroVersion_C_ERR;
  private BigDecimal m_salaireBrutAbattu;
  private String m_salaireBrutAbattu_C_ERR;
  private BigDecimal m_montantPrecompteAC;
  private String m_montantPrecompteAC_C_ERR;
  private BigDecimal m_quantiteAbsence;
  private String m_quantiteAbsence_C_ERR;
  private BigDecimal m_horaireSalarie;
  private String m_horaireSalarie_C_ERR;
  private BigDecimal m_horaireEntreprise;
  private String m_horaireEntreprise_C_ERR;
  private BigDecimal m_idTechPasDna;
  private String m_idTechPasDna_C_ERR;
  private BigDecimal m_idTechContratDna;
  private String m_idTechContratDna_C_ERR;
  
  public String get_C_ETAT()
  {
    return m__C_ETAT;
  }
  
  public String get_IDENT()
  {
    return m__IDENT;
  }
  
  public void set_C_ETAT(String pCETAT)
  {
    m__C_ETAT = pCETAT;
  }
  
  public void set_IDENT(String pIDENT)
  {
    m__IDENT = pIDENT;
  }
  
  public _ListeFluxPasDnaQuantiteTravail getListeFluxPasDnaQuantiteTravail()
  {
    return m_listeFluxPasDnaQuantiteTravail;
  }
  
  public String getListeFluxPasDnaQuantiteTravail_C_ERR()
  {
    return m_listeFluxPasDnaQuantiteTravail_C_ERR;
  }
  
  public void setListeFluxPasDnaQuantiteTravail(_ListeFluxPasDnaQuantiteTravail pValeur)
  {
    m_listeFluxPasDnaQuantiteTravail = pValeur;
  }
  
  public void setListeFluxPasDnaQuantiteTravail_C_ERR(String pValeur_C_ERR)
  {
    m_listeFluxPasDnaQuantiteTravail_C_ERR = pValeur_C_ERR;
  }
  
  public _ListeFluxPasDnaPeriodesPrime getListeFluxPasDnaPeriodesPrime()
  {
    return m_listeFluxPasDnaPeriodesPrime;
  }
  
  public String getListeFluxPasDnaPeriodesPrime_C_ERR()
  {
    return m_listeFluxPasDnaPeriodesPrime_C_ERR;
  }
  
  public void setListeFluxPasDnaPeriodesPrime(_ListeFluxPasDnaPeriodesPrime pValeur)
  {
    m_listeFluxPasDnaPeriodesPrime = pValeur;
  }
  
  public void setListeFluxPasDnaPeriodesPrime_C_ERR(String pValeur_C_ERR)
  {
    m_listeFluxPasDnaPeriodesPrime_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeMessage()
  {
    return m_codeMessage;
  }
  
  public String getCodeMessage_C_ERR()
  {
    return m_codeMessage_C_ERR;
  }
  
  public void setCodeMessage(String pValeur)
  {
    m_codeMessage = pValeur;
  }
  
  public void setCodeMessage_C_ERR(String pValeur_C_ERR)
  {
    m_codeMessage_C_ERR = pValeur_C_ERR;
  }
  
  public String getReferenceContrat()
  {
    return m_referenceContrat;
  }
  
  public String getReferenceContrat_C_ERR()
  {
    return m_referenceContrat_C_ERR;
  }
  
  public void setReferenceContrat(String pValeur)
  {
    m_referenceContrat = pValeur;
  }
  
  public void setReferenceContrat_C_ERR(String pValeur_C_ERR)
  {
    m_referenceContrat_C_ERR = pValeur_C_ERR;
  }
  
  public String getUniteAbsence()
  {
    return m_uniteAbsence;
  }
  
  public String getUniteAbsence_C_ERR()
  {
    return m_uniteAbsence_C_ERR;
  }
  
  public void setUniteAbsence(String pValeur)
  {
    m_uniteAbsence = pValeur;
  }
  
  public void setUniteAbsence_C_ERR(String pValeur_C_ERR)
  {
    m_uniteAbsence_C_ERR = pValeur_C_ERR;
  }
  
  public String getPeriodiciteHoraireTravail()
  {
    return m_periodiciteHoraireTravail;
  }
  
  public String getPeriodiciteHoraireTravail_C_ERR()
  {
    return m_periodiciteHoraireTravail_C_ERR;
  }
  
  public void setPeriodiciteHoraireTravail(String pValeur)
  {
    m_periodiciteHoraireTravail = pValeur;
  }
  
  public void setPeriodiciteHoraireTravail_C_ERR(String pValeur_C_ERR)
  {
    m_periodiciteHoraireTravail_C_ERR = pValeur_C_ERR;
  }
  
  public String getCategorieEmploiParticulier()
  {
    return m_categorieEmploiParticulier;
  }
  
  public String getCategorieEmploiParticulier_C_ERR()
  {
    return m_categorieEmploiParticulier_C_ERR;
  }
  
  public void setCategorieEmploiParticulier(String pValeur)
  {
    m_categorieEmploiParticulier = pValeur;
  }
  
  public void setCategorieEmploiParticulier_C_ERR(String pValeur_C_ERR)
  {
    m_categorieEmploiParticulier_C_ERR = pValeur_C_ERR;
  }
  
  public String getCodeMetierPCS()
  {
    return m_codeMetierPCS;
  }
  
  public String getCodeMetierPCS_C_ERR()
  {
    return m_codeMetierPCS_C_ERR;
  }
  
  public void setCodeMetierPCS(String pValeur)
  {
    m_codeMetierPCS = pValeur;
  }
  
  public void setCodeMetierPCS_C_ERR(String pValeur_C_ERR)
  {
    m_codeMetierPCS_C_ERR = pValeur_C_ERR;
  }
  
  public String getAbonnementProvisoire()
  {
    return m_abonnementProvisoire;
  }
  
  public String getAbonnementProvisoire_C_ERR()
  {
    return m_abonnementProvisoire_C_ERR;
  }
  
  public void setAbonnementProvisoire(String pValeur)
  {
    m_abonnementProvisoire = pValeur;
  }
  
  public void setAbonnementProvisoire_C_ERR(String pValeur_C_ERR)
  {
    m_abonnementProvisoire_C_ERR = pValeur_C_ERR;
  }
  
  public String getUniteIntensite()
  {
    return m_uniteIntensite;
  }
  
  public String getUniteIntensite_C_ERR()
  {
    return m_uniteIntensite_C_ERR;
  }
  
  public void setUniteIntensite(String pValeur)
  {
    m_uniteIntensite = pValeur;
  }
  
  public void setUniteIntensite_C_ERR(String pValeur_C_ERR)
  {
    m_uniteIntensite_C_ERR = pValeur_C_ERR;
  }
  
  public String getNomFamille()
  {
    return m_nomFamille;
  }
  
  public String getNomFamille_C_ERR()
  {
    return m_nomFamille_C_ERR;
  }
  
  public void setNomFamille(String pValeur)
  {
    m_nomFamille = pValeur;
  }
  
  public void setNomFamille_C_ERR(String pValeur_C_ERR)
  {
    m_nomFamille_C_ERR = pValeur_C_ERR;
  }
  
  public String getPrenom()
  {
    return m_prenom;
  }
  
  public String getPrenom_C_ERR()
  {
    return m_prenom_C_ERR;
  }
  
  public void setPrenom(String pValeur)
  {
    m_prenom = pValeur;
  }
  
  public void setPrenom_C_ERR(String pValeur_C_ERR)
  {
    m_prenom_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicSalaireBrut()
  {
    return m_indicSalaireBrut;
  }
  
  public String getIndicSalaireBrut_C_ERR()
  {
    return m_indicSalaireBrut_C_ERR;
  }
  
  public void setIndicSalaireBrut(String pValeur)
  {
    m_indicSalaireBrut = pValeur;
  }
  
  public void setIndicSalaireBrut_C_ERR(String pValeur_C_ERR)
  {
    m_indicSalaireBrut_C_ERR = pValeur_C_ERR;
  }
  
  public String getIndicPrecompte()
  {
    return m_indicPrecompte;
  }
  
  public String getIndicPrecompte_C_ERR()
  {
    return m_indicPrecompte_C_ERR;
  }
  
  public void setIndicPrecompte(String pValeur)
  {
    m_indicPrecompte = pValeur;
  }
  
  public void setIndicPrecompte_C_ERR(String pValeur_C_ERR)
  {
    m_indicPrecompte_C_ERR = pValeur_C_ERR;
  }
  
  public String getFillerUn()
  {
    return m_fillerUn;
  }
  
  public String getFillerUn_C_ERR()
  {
    return m_fillerUn_C_ERR;
  }
  
  public void setFillerUn(String pValeur)
  {
    m_fillerUn = pValeur;
  }
  
  public void setFillerUn_C_ERR(String pValeur_C_ERR)
  {
    m_fillerUn_C_ERR = pValeur_C_ERR;
  }
  
  public String getFillerDeux()
  {
    return m_fillerDeux;
  }
  
  public String getFillerDeux_C_ERR()
  {
    return m_fillerDeux_C_ERR;
  }
  
  public void setFillerDeux(String pValeur)
  {
    m_fillerDeux = pValeur;
  }
  
  public void setFillerDeux_C_ERR(String pValeur_C_ERR)
  {
    m_fillerDeux_C_ERR = pValeur_C_ERR;
  }
  
  public String getFonctionPublique()
  {
    return m_fonctionPublique;
  }
  
  public String getFonctionPublique_C_ERR()
  {
    return m_fonctionPublique_C_ERR;
  }
  
  public void setFonctionPublique(String pValeur)
  {
    m_fonctionPublique = pValeur;
  }
  
  public void setFonctionPublique_C_ERR(String pValeur_C_ERR)
  {
    m_fonctionPublique_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateDebutPeriode()
  {
    return m_dateDebutPeriode;
  }
  
  public String getDateDebutPeriode_C_ERR()
  {
    return m_dateDebutPeriode_C_ERR;
  }
  
  public void setDateDebutPeriode(Damj pValeur)
  {
    m_dateDebutPeriode = pValeur;
  }
  
  public void setDateDebutPeriode_C_ERR(String pValeur_C_ERR)
  {
    m_dateDebutPeriode_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateFinPeriode()
  {
    return m_dateFinPeriode;
  }
  
  public String getDateFinPeriode_C_ERR()
  {
    return m_dateFinPeriode_C_ERR;
  }
  
  public void setDateFinPeriode(Damj pValeur)
  {
    m_dateFinPeriode = pValeur;
  }
  
  public void setDateFinPeriode_C_ERR(String pValeur_C_ERR)
  {
    m_dateFinPeriode_C_ERR = pValeur_C_ERR;
  }
  
  public Damj getDateVersementSalaire()
  {
    return m_dateVersementSalaire;
  }
  
  public String getDateVersementSalaire_C_ERR()
  {
    return m_dateVersementSalaire_C_ERR;
  }
  
  public void setDateVersementSalaire(Damj pValeur)
  {
    m_dateVersementSalaire = pValeur;
  }
  
  public void setDateVersementSalaire_C_ERR(String pValeur_C_ERR)
  {
    m_dateVersementSalaire_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getNumeroVersion()
  {
    return m_numeroVersion;
  }
  
  public String getNumeroVersion_C_ERR()
  {
    return m_numeroVersion_C_ERR;
  }
  
  public void setNumeroVersion(BigDecimal pValeur)
  {
    m_numeroVersion = pValeur;
  }
  
  public void setNumeroVersion_C_ERR(String pValeur_C_ERR)
  {
    m_numeroVersion_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getSalaireBrutAbattu()
  {
    return m_salaireBrutAbattu;
  }
  
  public String getSalaireBrutAbattu_C_ERR()
  {
    return m_salaireBrutAbattu_C_ERR;
  }
  
  public void setSalaireBrutAbattu(BigDecimal pValeur)
  {
    m_salaireBrutAbattu = pValeur;
  }
  
  public void setSalaireBrutAbattu_C_ERR(String pValeur_C_ERR)
  {
    m_salaireBrutAbattu_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getMontantPrecompteAC()
  {
    return m_montantPrecompteAC;
  }
  
  public String getMontantPrecompteAC_C_ERR()
  {
    return m_montantPrecompteAC_C_ERR;
  }
  
  public void setMontantPrecompteAC(BigDecimal pValeur)
  {
    m_montantPrecompteAC = pValeur;
  }
  
  public void setMontantPrecompteAC_C_ERR(String pValeur_C_ERR)
  {
    m_montantPrecompteAC_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getQuantiteAbsence()
  {
    return m_quantiteAbsence;
  }
  
  public String getQuantiteAbsence_C_ERR()
  {
    return m_quantiteAbsence_C_ERR;
  }
  
  public void setQuantiteAbsence(BigDecimal pValeur)
  {
    m_quantiteAbsence = pValeur;
  }
  
  public void setQuantiteAbsence_C_ERR(String pValeur_C_ERR)
  {
    m_quantiteAbsence_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getHoraireSalarie()
  {
    return m_horaireSalarie;
  }
  
  public String getHoraireSalarie_C_ERR()
  {
    return m_horaireSalarie_C_ERR;
  }
  
  public void setHoraireSalarie(BigDecimal pValeur)
  {
    m_horaireSalarie = pValeur;
  }
  
  public void setHoraireSalarie_C_ERR(String pValeur_C_ERR)
  {
    m_horaireSalarie_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getHoraireEntreprise()
  {
    return m_horaireEntreprise;
  }
  
  public String getHoraireEntreprise_C_ERR()
  {
    return m_horaireEntreprise_C_ERR;
  }
  
  public void setHoraireEntreprise(BigDecimal pValeur)
  {
    m_horaireEntreprise = pValeur;
  }
  
  public void setHoraireEntreprise_C_ERR(String pValeur_C_ERR)
  {
    m_horaireEntreprise_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getIdTechPasDna()
  {
    return m_idTechPasDna;
  }
  
  public String getIdTechPasDna_C_ERR()
  {
    return m_idTechPasDna_C_ERR;
  }
  
  public void setIdTechPasDna(BigDecimal pValeur)
  {
    m_idTechPasDna = pValeur;
  }
  
  public void setIdTechPasDna_C_ERR(String pValeur_C_ERR)
  {
    m_idTechPasDna_C_ERR = pValeur_C_ERR;
  }
  
  public BigDecimal getIdTechContratDna()
  {
    return m_idTechContratDna;
  }
  
  public String getIdTechContratDna_C_ERR()
  {
    return m_idTechContratDna_C_ERR;
  }
  
  public void setIdTechContratDna(BigDecimal pValeur)
  {
    m_idTechContratDna = pValeur;
  }
  
  public void setIdTechContratDna_C_ERR(String pValeur_C_ERR)
  {
    m_idTechContratDna_C_ERR = pValeur_C_ERR;
  }
  
  public Class _getAttributeType(String pPropertyName, String pAttributeName)
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      return String.class;
    }
    if ("m__IDENT".equals(attrName)) {
      return String.class;
    }
    if ("m_listeFluxPasDnaQuantiteTravail_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_listeFluxPasDnaPeriodesPrime_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeMessage_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_referenceContrat_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_uniteAbsence_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_periodiciteHoraireTravail_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_categorieEmploiParticulier_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_codeMetierPCS_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_abonnementProvisoire_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_uniteIntensite_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_nomFamille_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicSalaireBrut_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_indicPrecompte_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fillerUn_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fillerDeux_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_fonctionPublique_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateDebutPeriode_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateFinPeriode_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_dateVersementSalaire_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_numeroVersion_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_salaireBrutAbattu_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_montantPrecompteAC_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_quantiteAbsence_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_horaireSalarie_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_horaireEntreprise_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idTechPasDna_C_ERR".equals(attrName)) {
      return String.class;
    }
    if ("m_idTechContratDna_C_ERR".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    if ("ListeFluxPasDnaQuantiteTravail".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeFluxPasDnaQuantiteTravail.class, false);
      return info;
    }
    if ("ListeFluxPasDnaPeriodesPrime".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, _ListeFluxPasDnaPeriodesPrime.class, false);
      return info;
    }
    if ("CodeMessage".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("ReferenceContrat".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("UniteAbsence".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("PeriodiciteHoraireTravail".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CategorieEmploiParticulier".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("CodeMetierPCS".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("AbonnementProvisoire".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("UniteIntensite".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("NomFamille".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("Prenom".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicSalaireBrut".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("IndicPrecompte".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("FillerUn".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("FillerDeux".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("FonctionPublique".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, String.class, false);
      return info;
    }
    if ("DateDebutPeriode".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateFinPeriode".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("DateVersementSalaire".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, Damj.class, false);
      return info;
    }
    if ("NumeroVersion".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("SalaireBrutAbattu".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("MontantPrecompteAC".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("QuantiteAbsence".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("HoraireSalarie".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("HoraireEntreprise".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("IdTechPasDna".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    if ("IdTechContratDna".equals(pElementName))
    {
      PropertyInfo info = new PropertyInfo(pElementName, false, false, BigDecimal.class, true);
      return info;
    }
    return null;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    if ("ListeFluxPasDnaQuantiteTravail".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("ListeFluxPasDnaPeriodesPrime".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("CodeMessage".equals(pElementName)) {
      return 3;
    }
    if ("ReferenceContrat".equals(pElementName)) {
      return 20;
    }
    if ("UniteAbsence".equals(pElementName)) {
      return 2;
    }
    if ("PeriodiciteHoraireTravail".equals(pElementName)) {
      return 1;
    }
    if ("CategorieEmploiParticulier".equals(pElementName)) {
      return 2;
    }
    if ("CodeMetierPCS".equals(pElementName)) {
      return 4;
    }
    if ("AbonnementProvisoire".equals(pElementName)) {
      return 1;
    }
    if ("UniteIntensite".equals(pElementName)) {
      return 2;
    }
    if ("NomFamille".equals(pElementName)) {
      return 80;
    }
    if ("Prenom".equals(pElementName)) {
      return 40;
    }
    if ("IndicSalaireBrut".equals(pElementName)) {
      return 1;
    }
    if ("IndicPrecompte".equals(pElementName)) {
      return 1;
    }
    if ("FillerUn".equals(pElementName)) {
      return 703;
    }
    if ("FillerDeux".equals(pElementName)) {
      return 421;
    }
    if ("FonctionPublique".equals(pElementName)) {
      return 5;
    }
    if ("DateDebutPeriode".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateFinPeriode".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("DateVersementSalaire".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("NumeroVersion".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("SalaireBrutAbattu".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("MontantPrecompteAC".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("QuantiteAbsence".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("HoraireSalarie".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("HoraireEntreprise".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("IdTechPasDna".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    if ("IdTechContratDna".equals(pElementName)) {
      return Integer.MAX_VALUE;
    }
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    if ("ListeFluxPasDnaQuantiteTravail".equals(pName)) {
      return m_listeFluxPasDnaQuantiteTravail;
    }
    if ("ListeFluxPasDnaPeriodesPrime".equals(pName)) {
      return m_listeFluxPasDnaPeriodesPrime;
    }
    if ("CodeMessage".equals(pName)) {
      return m_codeMessage;
    }
    if ("ReferenceContrat".equals(pName)) {
      return m_referenceContrat;
    }
    if ("UniteAbsence".equals(pName)) {
      return m_uniteAbsence;
    }
    if ("PeriodiciteHoraireTravail".equals(pName)) {
      return m_periodiciteHoraireTravail;
    }
    if ("CategorieEmploiParticulier".equals(pName)) {
      return m_categorieEmploiParticulier;
    }
    if ("CodeMetierPCS".equals(pName)) {
      return m_codeMetierPCS;
    }
    if ("AbonnementProvisoire".equals(pName)) {
      return m_abonnementProvisoire;
    }
    if ("UniteIntensite".equals(pName)) {
      return m_uniteIntensite;
    }
    if ("NomFamille".equals(pName)) {
      return m_nomFamille;
    }
    if ("Prenom".equals(pName)) {
      return m_prenom;
    }
    if ("IndicSalaireBrut".equals(pName)) {
      return m_indicSalaireBrut;
    }
    if ("IndicPrecompte".equals(pName)) {
      return m_indicPrecompte;
    }
    if ("FillerUn".equals(pName)) {
      return m_fillerUn;
    }
    if ("FillerDeux".equals(pName)) {
      return m_fillerDeux;
    }
    if ("FonctionPublique".equals(pName)) {
      return m_fonctionPublique;
    }
    if ("DateDebutPeriode".equals(pName)) {
      return m_dateDebutPeriode;
    }
    if ("DateFinPeriode".equals(pName)) {
      return m_dateFinPeriode;
    }
    if ("DateVersementSalaire".equals(pName)) {
      return m_dateVersementSalaire;
    }
    if ("NumeroVersion".equals(pName)) {
      return m_numeroVersion;
    }
    if ("SalaireBrutAbattu".equals(pName)) {
      return m_salaireBrutAbattu;
    }
    if ("MontantPrecompteAC".equals(pName)) {
      return m_montantPrecompteAC;
    }
    if ("QuantiteAbsence".equals(pName)) {
      return m_quantiteAbsence;
    }
    if ("HoraireSalarie".equals(pName)) {
      return m_horaireSalarie;
    }
    if ("HoraireEntreprise".equals(pName)) {
      return m_horaireEntreprise;
    }
    if ("IdTechPasDna".equals(pName)) {
      return m_idTechPasDna;
    }
    if ("IdTechContratDna".equals(pName)) {
      return m_idTechContratDna;
    }
    return null;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    liste.add("ListeFluxPasDnaQuantiteTravail");
    liste.add("ListeFluxPasDnaPeriodesPrime");
    liste.add("CodeMessage");
    liste.add("ReferenceContrat");
    liste.add("UniteAbsence");
    liste.add("PeriodiciteHoraireTravail");
    liste.add("CategorieEmploiParticulier");
    liste.add("CodeMetierPCS");
    liste.add("AbonnementProvisoire");
    liste.add("UniteIntensite");
    liste.add("NomFamille");
    liste.add("Prenom");
    liste.add("IndicSalaireBrut");
    liste.add("IndicPrecompte");
    liste.add("FillerUn");
    liste.add("FillerDeux");
    liste.add("FonctionPublique");
    liste.add("DateDebutPeriode");
    liste.add("DateFinPeriode");
    liste.add("DateVersementSalaire");
    liste.add("NumeroVersion");
    liste.add("SalaireBrutAbattu");
    liste.add("MontantPrecompteAC");
    liste.add("QuantiteAbsence");
    liste.add("HoraireSalarie");
    liste.add("HoraireEntreprise");
    liste.add("IdTechPasDna");
    liste.add("IdTechContratDna");
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("ListeFluxPasDnaQuantiteTravail");
    pListe.add("ListeFluxPasDnaPeriodesPrime");
    pListe.add("CodeMessage");
    pListe.add("ReferenceContrat");
    pListe.add("UniteAbsence");
    pListe.add("PeriodiciteHoraireTravail");
    pListe.add("CategorieEmploiParticulier");
    pListe.add("CodeMetierPCS");
    pListe.add("AbonnementProvisoire");
    pListe.add("UniteIntensite");
    pListe.add("NomFamille");
    pListe.add("Prenom");
    pListe.add("IndicSalaireBrut");
    pListe.add("IndicPrecompte");
    pListe.add("FillerUn");
    pListe.add("FillerDeux");
    pListe.add("FonctionPublique");
    pListe.add("DateDebutPeriode");
    pListe.add("DateFinPeriode");
    pListe.add("DateVersementSalaire");
    pListe.add("NumeroVersion");
    pListe.add("SalaireBrutAbattu");
    pListe.add("MontantPrecompteAC");
    pListe.add("QuantiteAbsence");
    pListe.add("HoraireSalarie");
    pListe.add("HoraireEntreprise");
    pListe.add("IdTechPasDna");
    pListe.add("IdTechContratDna");
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("ListeFluxPasDnaQuantiteTravail".equals(pName)) {
      m_listeFluxPasDnaQuantiteTravail = ((_ListeFluxPasDnaQuantiteTravail)pValeur);
    }
    if ("ListeFluxPasDnaPeriodesPrime".equals(pName)) {
      m_listeFluxPasDnaPeriodesPrime = ((_ListeFluxPasDnaPeriodesPrime)pValeur);
    }
    if ("CodeMessage".equals(pName)) {
      m_codeMessage = ((String)pValeur);
    }
    if ("ReferenceContrat".equals(pName)) {
      m_referenceContrat = ((String)pValeur);
    }
    if ("UniteAbsence".equals(pName)) {
      m_uniteAbsence = ((String)pValeur);
    }
    if ("PeriodiciteHoraireTravail".equals(pName)) {
      m_periodiciteHoraireTravail = ((String)pValeur);
    }
    if ("CategorieEmploiParticulier".equals(pName)) {
      m_categorieEmploiParticulier = ((String)pValeur);
    }
    if ("CodeMetierPCS".equals(pName)) {
      m_codeMetierPCS = ((String)pValeur);
    }
    if ("AbonnementProvisoire".equals(pName)) {
      m_abonnementProvisoire = ((String)pValeur);
    }
    if ("UniteIntensite".equals(pName)) {
      m_uniteIntensite = ((String)pValeur);
    }
    if ("NomFamille".equals(pName)) {
      m_nomFamille = ((String)pValeur);
    }
    if ("Prenom".equals(pName)) {
      m_prenom = ((String)pValeur);
    }
    if ("IndicSalaireBrut".equals(pName)) {
      m_indicSalaireBrut = ((String)pValeur);
    }
    if ("IndicPrecompte".equals(pName)) {
      m_indicPrecompte = ((String)pValeur);
    }
    if ("FillerUn".equals(pName)) {
      m_fillerUn = ((String)pValeur);
    }
    if ("FillerDeux".equals(pName)) {
      m_fillerDeux = ((String)pValeur);
    }
    if ("FonctionPublique".equals(pName)) {
      m_fonctionPublique = ((String)pValeur);
    }
    if ("DateDebutPeriode".equals(pName)) {
      m_dateDebutPeriode = ((Damj)pValeur);
    }
    if ("DateFinPeriode".equals(pName)) {
      m_dateFinPeriode = ((Damj)pValeur);
    }
    if ("DateVersementSalaire".equals(pName)) {
      m_dateVersementSalaire = ((Damj)pValeur);
    }
    if ("NumeroVersion".equals(pName)) {
      m_numeroVersion = ((BigDecimal)pValeur);
    }
    if ("SalaireBrutAbattu".equals(pName)) {
      m_salaireBrutAbattu = ((BigDecimal)pValeur);
    }
    if ("MontantPrecompteAC".equals(pName)) {
      m_montantPrecompteAC = ((BigDecimal)pValeur);
    }
    if ("QuantiteAbsence".equals(pName)) {
      m_quantiteAbsence = ((BigDecimal)pValeur);
    }
    if ("HoraireSalarie".equals(pName)) {
      m_horaireSalarie = ((BigDecimal)pValeur);
    }
    if ("HoraireEntreprise".equals(pName)) {
      m_horaireEntreprise = ((BigDecimal)pValeur);
    }
    if ("IdTechPasDna".equals(pName)) {
      m_idTechPasDna = ((BigDecimal)pValeur);
    }
    if ("IdTechContratDna".equals(pName)) {
      m_idTechContratDna = ((BigDecimal)pValeur);
    }
  }
  
  public void _setAttribute(String pPropertyName, String pAttributeName, String pValeur)
    throws Exception
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      m__C_ETAT = pValeur;
    }
    if ("m__IDENT".equals(attrName)) {
      m__IDENT = pValeur;
    }
    if ("m_listeFluxPasDnaQuantiteTravail_C_ERR".equals(attrName)) {
      m_listeFluxPasDnaQuantiteTravail_C_ERR = pValeur;
    }
    if ("m_listeFluxPasDnaPeriodesPrime_C_ERR".equals(attrName)) {
      m_listeFluxPasDnaPeriodesPrime_C_ERR = pValeur;
    }
    if ("m_codeMessage_C_ERR".equals(attrName)) {
      m_codeMessage_C_ERR = pValeur;
    }
    if ("m_referenceContrat_C_ERR".equals(attrName)) {
      m_referenceContrat_C_ERR = pValeur;
    }
    if ("m_uniteAbsence_C_ERR".equals(attrName)) {
      m_uniteAbsence_C_ERR = pValeur;
    }
    if ("m_periodiciteHoraireTravail_C_ERR".equals(attrName)) {
      m_periodiciteHoraireTravail_C_ERR = pValeur;
    }
    if ("m_categorieEmploiParticulier_C_ERR".equals(attrName)) {
      m_categorieEmploiParticulier_C_ERR = pValeur;
    }
    if ("m_codeMetierPCS_C_ERR".equals(attrName)) {
      m_codeMetierPCS_C_ERR = pValeur;
    }
    if ("m_abonnementProvisoire_C_ERR".equals(attrName)) {
      m_abonnementProvisoire_C_ERR = pValeur;
    }
    if ("m_uniteIntensite_C_ERR".equals(attrName)) {
      m_uniteIntensite_C_ERR = pValeur;
    }
    if ("m_nomFamille_C_ERR".equals(attrName)) {
      m_nomFamille_C_ERR = pValeur;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      m_prenom_C_ERR = pValeur;
    }
    if ("m_indicSalaireBrut_C_ERR".equals(attrName)) {
      m_indicSalaireBrut_C_ERR = pValeur;
    }
    if ("m_indicPrecompte_C_ERR".equals(attrName)) {
      m_indicPrecompte_C_ERR = pValeur;
    }
    if ("m_fillerUn_C_ERR".equals(attrName)) {
      m_fillerUn_C_ERR = pValeur;
    }
    if ("m_fillerDeux_C_ERR".equals(attrName)) {
      m_fillerDeux_C_ERR = pValeur;
    }
    if ("m_fonctionPublique_C_ERR".equals(attrName)) {
      m_fonctionPublique_C_ERR = pValeur;
    }
    if ("m_dateDebutPeriode_C_ERR".equals(attrName)) {
      m_dateDebutPeriode_C_ERR = pValeur;
    }
    if ("m_dateFinPeriode_C_ERR".equals(attrName)) {
      m_dateFinPeriode_C_ERR = pValeur;
    }
    if ("m_dateVersementSalaire_C_ERR".equals(attrName)) {
      m_dateVersementSalaire_C_ERR = pValeur;
    }
    if ("m_numeroVersion_C_ERR".equals(attrName)) {
      m_numeroVersion_C_ERR = pValeur;
    }
    if ("m_salaireBrutAbattu_C_ERR".equals(attrName)) {
      m_salaireBrutAbattu_C_ERR = pValeur;
    }
    if ("m_montantPrecompteAC_C_ERR".equals(attrName)) {
      m_montantPrecompteAC_C_ERR = pValeur;
    }
    if ("m_quantiteAbsence_C_ERR".equals(attrName)) {
      m_quantiteAbsence_C_ERR = pValeur;
    }
    if ("m_horaireSalarie_C_ERR".equals(attrName)) {
      m_horaireSalarie_C_ERR = pValeur;
    }
    if ("m_horaireEntreprise_C_ERR".equals(attrName)) {
      m_horaireEntreprise_C_ERR = pValeur;
    }
    if ("m_idTechPasDna_C_ERR".equals(attrName)) {
      m_idTechPasDna_C_ERR = pValeur;
    }
    if ("m_idTechContratDna_C_ERR".equals(attrName)) {
      m_idTechContratDna_C_ERR = pValeur;
    }
  }
  
  public String _getAttribute(String pPropertyName, String pAttributeName)
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      return m__C_ETAT;
    }
    if ("m__IDENT".equals(attrName)) {
      return m__IDENT;
    }
    if ("m_listeFluxPasDnaQuantiteTravail_C_ERR".equals(attrName)) {
      return m_listeFluxPasDnaQuantiteTravail_C_ERR;
    }
    if ("m_listeFluxPasDnaPeriodesPrime_C_ERR".equals(attrName)) {
      return m_listeFluxPasDnaPeriodesPrime_C_ERR;
    }
    if ("m_codeMessage_C_ERR".equals(attrName)) {
      return m_codeMessage_C_ERR;
    }
    if ("m_referenceContrat_C_ERR".equals(attrName)) {
      return m_referenceContrat_C_ERR;
    }
    if ("m_uniteAbsence_C_ERR".equals(attrName)) {
      return m_uniteAbsence_C_ERR;
    }
    if ("m_periodiciteHoraireTravail_C_ERR".equals(attrName)) {
      return m_periodiciteHoraireTravail_C_ERR;
    }
    if ("m_categorieEmploiParticulier_C_ERR".equals(attrName)) {
      return m_categorieEmploiParticulier_C_ERR;
    }
    if ("m_codeMetierPCS_C_ERR".equals(attrName)) {
      return m_codeMetierPCS_C_ERR;
    }
    if ("m_abonnementProvisoire_C_ERR".equals(attrName)) {
      return m_abonnementProvisoire_C_ERR;
    }
    if ("m_uniteIntensite_C_ERR".equals(attrName)) {
      return m_uniteIntensite_C_ERR;
    }
    if ("m_nomFamille_C_ERR".equals(attrName)) {
      return m_nomFamille_C_ERR;
    }
    if ("m_prenom_C_ERR".equals(attrName)) {
      return m_prenom_C_ERR;
    }
    if ("m_indicSalaireBrut_C_ERR".equals(attrName)) {
      return m_indicSalaireBrut_C_ERR;
    }
    if ("m_indicPrecompte_C_ERR".equals(attrName)) {
      return m_indicPrecompte_C_ERR;
    }
    if ("m_fillerUn_C_ERR".equals(attrName)) {
      return m_fillerUn_C_ERR;
    }
    if ("m_fillerDeux_C_ERR".equals(attrName)) {
      return m_fillerDeux_C_ERR;
    }
    if ("m_fonctionPublique_C_ERR".equals(attrName)) {
      return m_fonctionPublique_C_ERR;
    }
    if ("m_dateDebutPeriode_C_ERR".equals(attrName)) {
      return m_dateDebutPeriode_C_ERR;
    }
    if ("m_dateFinPeriode_C_ERR".equals(attrName)) {
      return m_dateFinPeriode_C_ERR;
    }
    if ("m_dateVersementSalaire_C_ERR".equals(attrName)) {
      return m_dateVersementSalaire_C_ERR;
    }
    if ("m_numeroVersion_C_ERR".equals(attrName)) {
      return m_numeroVersion_C_ERR;
    }
    if ("m_salaireBrutAbattu_C_ERR".equals(attrName)) {
      return m_salaireBrutAbattu_C_ERR;
    }
    if ("m_montantPrecompteAC_C_ERR".equals(attrName)) {
      return m_montantPrecompteAC_C_ERR;
    }
    if ("m_quantiteAbsence_C_ERR".equals(attrName)) {
      return m_quantiteAbsence_C_ERR;
    }
    if ("m_horaireSalarie_C_ERR".equals(attrName)) {
      return m_horaireSalarie_C_ERR;
    }
    if ("m_horaireEntreprise_C_ERR".equals(attrName)) {
      return m_horaireEntreprise_C_ERR;
    }
    if ("m_idTechPasDna_C_ERR".equals(attrName)) {
      return m_idTechPasDna_C_ERR;
    }
    if ("m_idTechContratDna_C_ERR".equals(attrName)) {
      return m_idTechContratDna_C_ERR;
    }
    return null;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _FluxPasDna)) {
      return false;
    }
    _FluxPasDna x = (_FluxPasDna)pObjet;
    if (m_listeFluxPasDnaQuantiteTravail == null)
    {
      if (m_listeFluxPasDnaQuantiteTravail != null) {
        return false;
      }
    }
    else
    {
      if (m_listeFluxPasDnaQuantiteTravail == null) {
        return false;
      }
      if (!m_listeFluxPasDnaQuantiteTravail.equals(m_listeFluxPasDnaQuantiteTravail)) {
        return false;
      }
    }
    if (m_listeFluxPasDnaPeriodesPrime == null)
    {
      if (m_listeFluxPasDnaPeriodesPrime != null) {
        return false;
      }
    }
    else
    {
      if (m_listeFluxPasDnaPeriodesPrime == null) {
        return false;
      }
      if (!m_listeFluxPasDnaPeriodesPrime.equals(m_listeFluxPasDnaPeriodesPrime)) {
        return false;
      }
    }
    if (m_codeMessage == null)
    {
      if (m_codeMessage != null) {
        return false;
      }
    }
    else
    {
      if (m_codeMessage == null) {
        return false;
      }
      if (!m_codeMessage.equals(m_codeMessage)) {
        return false;
      }
    }
    if (m_referenceContrat == null)
    {
      if (m_referenceContrat != null) {
        return false;
      }
    }
    else
    {
      if (m_referenceContrat == null) {
        return false;
      }
      if (!m_referenceContrat.equals(m_referenceContrat)) {
        return false;
      }
    }
    if (m_uniteAbsence == null)
    {
      if (m_uniteAbsence != null) {
        return false;
      }
    }
    else
    {
      if (m_uniteAbsence == null) {
        return false;
      }
      if (!m_uniteAbsence.equals(m_uniteAbsence)) {
        return false;
      }
    }
    if (m_periodiciteHoraireTravail == null)
    {
      if (m_periodiciteHoraireTravail != null) {
        return false;
      }
    }
    else
    {
      if (m_periodiciteHoraireTravail == null) {
        return false;
      }
      if (!m_periodiciteHoraireTravail.equals(m_periodiciteHoraireTravail)) {
        return false;
      }
    }
    if (m_categorieEmploiParticulier == null)
    {
      if (m_categorieEmploiParticulier != null) {
        return false;
      }
    }
    else
    {
      if (m_categorieEmploiParticulier == null) {
        return false;
      }
      if (!m_categorieEmploiParticulier.equals(m_categorieEmploiParticulier)) {
        return false;
      }
    }
    if (m_codeMetierPCS == null)
    {
      if (m_codeMetierPCS != null) {
        return false;
      }
    }
    else
    {
      if (m_codeMetierPCS == null) {
        return false;
      }
      if (!m_codeMetierPCS.equals(m_codeMetierPCS)) {
        return false;
      }
    }
    if (m_abonnementProvisoire == null)
    {
      if (m_abonnementProvisoire != null) {
        return false;
      }
    }
    else
    {
      if (m_abonnementProvisoire == null) {
        return false;
      }
      if (!m_abonnementProvisoire.equals(m_abonnementProvisoire)) {
        return false;
      }
    }
    if (m_uniteIntensite == null)
    {
      if (m_uniteIntensite != null) {
        return false;
      }
    }
    else
    {
      if (m_uniteIntensite == null) {
        return false;
      }
      if (!m_uniteIntensite.equals(m_uniteIntensite)) {
        return false;
      }
    }
    if (m_nomFamille == null)
    {
      if (m_nomFamille != null) {
        return false;
      }
    }
    else
    {
      if (m_nomFamille == null) {
        return false;
      }
      if (!m_nomFamille.equals(m_nomFamille)) {
        return false;
      }
    }
    if (m_prenom == null)
    {
      if (m_prenom != null) {
        return false;
      }
    }
    else
    {
      if (m_prenom == null) {
        return false;
      }
      if (!m_prenom.equals(m_prenom)) {
        return false;
      }
    }
    if (m_indicSalaireBrut == null)
    {
      if (m_indicSalaireBrut != null) {
        return false;
      }
    }
    else
    {
      if (m_indicSalaireBrut == null) {
        return false;
      }
      if (!m_indicSalaireBrut.equals(m_indicSalaireBrut)) {
        return false;
      }
    }
    if (m_indicPrecompte == null)
    {
      if (m_indicPrecompte != null) {
        return false;
      }
    }
    else
    {
      if (m_indicPrecompte == null) {
        return false;
      }
      if (!m_indicPrecompte.equals(m_indicPrecompte)) {
        return false;
      }
    }
    if (m_fillerUn == null)
    {
      if (m_fillerUn != null) {
        return false;
      }
    }
    else
    {
      if (m_fillerUn == null) {
        return false;
      }
      if (!m_fillerUn.equals(m_fillerUn)) {
        return false;
      }
    }
    if (m_fillerDeux == null)
    {
      if (m_fillerDeux != null) {
        return false;
      }
    }
    else
    {
      if (m_fillerDeux == null) {
        return false;
      }
      if (!m_fillerDeux.equals(m_fillerDeux)) {
        return false;
      }
    }
    if (m_fonctionPublique == null)
    {
      if (m_fonctionPublique != null) {
        return false;
      }
    }
    else
    {
      if (m_fonctionPublique == null) {
        return false;
      }
      if (!m_fonctionPublique.equals(m_fonctionPublique)) {
        return false;
      }
    }
    if (m_dateDebutPeriode == null)
    {
      if (m_dateDebutPeriode != null) {
        return false;
      }
    }
    else
    {
      if (m_dateDebutPeriode == null) {
        return false;
      }
      if (!m_dateDebutPeriode.equals(m_dateDebutPeriode)) {
        return false;
      }
    }
    if (m_dateFinPeriode == null)
    {
      if (m_dateFinPeriode != null) {
        return false;
      }
    }
    else
    {
      if (m_dateFinPeriode == null) {
        return false;
      }
      if (!m_dateFinPeriode.equals(m_dateFinPeriode)) {
        return false;
      }
    }
    if (m_dateVersementSalaire == null)
    {
      if (m_dateVersementSalaire != null) {
        return false;
      }
    }
    else
    {
      if (m_dateVersementSalaire == null) {
        return false;
      }
      if (!m_dateVersementSalaire.equals(m_dateVersementSalaire)) {
        return false;
      }
    }
    if (m_numeroVersion == null)
    {
      if (m_numeroVersion != null) {
        return false;
      }
    }
    else
    {
      if (m_numeroVersion == null) {
        return false;
      }
      if (!m_numeroVersion.equals(m_numeroVersion)) {
        return false;
      }
    }
    if (m_salaireBrutAbattu == null)
    {
      if (m_salaireBrutAbattu != null) {
        return false;
      }
    }
    else
    {
      if (m_salaireBrutAbattu == null) {
        return false;
      }
      if (!m_salaireBrutAbattu.equals(m_salaireBrutAbattu)) {
        return false;
      }
    }
    if (m_montantPrecompteAC == null)
    {
      if (m_montantPrecompteAC != null) {
        return false;
      }
    }
    else
    {
      if (m_montantPrecompteAC == null) {
        return false;
      }
      if (!m_montantPrecompteAC.equals(m_montantPrecompteAC)) {
        return false;
      }
    }
    if (m_quantiteAbsence == null)
    {
      if (m_quantiteAbsence != null) {
        return false;
      }
    }
    else
    {
      if (m_quantiteAbsence == null) {
        return false;
      }
      if (!m_quantiteAbsence.equals(m_quantiteAbsence)) {
        return false;
      }
    }
    if (m_horaireSalarie == null)
    {
      if (m_horaireSalarie != null) {
        return false;
      }
    }
    else
    {
      if (m_horaireSalarie == null) {
        return false;
      }
      if (!m_horaireSalarie.equals(m_horaireSalarie)) {
        return false;
      }
    }
    if (m_horaireEntreprise == null)
    {
      if (m_horaireEntreprise != null) {
        return false;
      }
    }
    else
    {
      if (m_horaireEntreprise == null) {
        return false;
      }
      if (!m_horaireEntreprise.equals(m_horaireEntreprise)) {
        return false;
      }
    }
    if (m_idTechPasDna == null)
    {
      if (m_idTechPasDna != null) {
        return false;
      }
    }
    else
    {
      if (m_idTechPasDna == null) {
        return false;
      }
      if (!m_idTechPasDna.equals(m_idTechPasDna)) {
        return false;
      }
    }
    if (m_idTechContratDna == null)
    {
      if (m_idTechContratDna != null) {
        return false;
      }
    }
    else
    {
      if (m_idTechContratDna == null) {
        return false;
      }
      if (!m_idTechContratDna.equals(m_idTechContratDna)) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = 0;
    if (m_listeFluxPasDnaQuantiteTravail != null) {
      result += m_listeFluxPasDnaQuantiteTravail.hashCode();
    }
    if (m_listeFluxPasDnaPeriodesPrime != null) {
      result += m_listeFluxPasDnaPeriodesPrime.hashCode();
    }
    if (m_codeMessage != null) {
      result += m_codeMessage.hashCode();
    }
    if (m_referenceContrat != null) {
      result += m_referenceContrat.hashCode();
    }
    if (m_uniteAbsence != null) {
      result += m_uniteAbsence.hashCode();
    }
    if (m_periodiciteHoraireTravail != null) {
      result += m_periodiciteHoraireTravail.hashCode();
    }
    if (m_categorieEmploiParticulier != null) {
      result += m_categorieEmploiParticulier.hashCode();
    }
    if (m_codeMetierPCS != null) {
      result += m_codeMetierPCS.hashCode();
    }
    if (m_abonnementProvisoire != null) {
      result += m_abonnementProvisoire.hashCode();
    }
    if (m_uniteIntensite != null) {
      result += m_uniteIntensite.hashCode();
    }
    if (m_nomFamille != null) {
      result += m_nomFamille.hashCode();
    }
    if (m_prenom != null) {
      result += m_prenom.hashCode();
    }
    if (m_indicSalaireBrut != null) {
      result += m_indicSalaireBrut.hashCode();
    }
    if (m_indicPrecompte != null) {
      result += m_indicPrecompte.hashCode();
    }
    if (m_fillerUn != null) {
      result += m_fillerUn.hashCode();
    }
    if (m_fillerDeux != null) {
      result += m_fillerDeux.hashCode();
    }
    if (m_fonctionPublique != null) {
      result += m_fonctionPublique.hashCode();
    }
    if (m_dateDebutPeriode != null) {
      result += m_dateDebutPeriode.hashCode();
    }
    if (m_dateFinPeriode != null) {
      result += m_dateFinPeriode.hashCode();
    }
    if (m_dateVersementSalaire != null) {
      result += m_dateVersementSalaire.hashCode();
    }
    if (m_numeroVersion != null) {
      result += m_numeroVersion.hashCode();
    }
    if (m_salaireBrutAbattu != null) {
      result += m_salaireBrutAbattu.hashCode();
    }
    if (m_montantPrecompteAC != null) {
      result += m_montantPrecompteAC.hashCode();
    }
    if (m_quantiteAbsence != null) {
      result += m_quantiteAbsence.hashCode();
    }
    if (m_horaireSalarie != null) {
      result += m_horaireSalarie.hashCode();
    }
    if (m_horaireEntreprise != null) {
      result += m_horaireEntreprise.hashCode();
    }
    if (m_idTechPasDna != null) {
      result += m_idTechPasDna.hashCode();
    }
    if (m_idTechContratDna != null) {
      result += m_idTechContratDna.hashCode();
    }
    result *= 17;
    return result;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _FluxPasDna clone_FluxPasDna = new _FluxPasDna();
    clone_FluxPasDna.populateFrom_FluxPasDna(this);
    return clone_FluxPasDna;
  }
  
  public void populateFrom_FluxPasDna(_FluxPasDna pSource)
  {
    setListeFluxPasDnaQuantiteTravail(pSource.getListeFluxPasDnaQuantiteTravail());setListeFluxPasDnaPeriodesPrime(pSource.getListeFluxPasDnaPeriodesPrime());setCodeMessage(pSource.getCodeMessage());setReferenceContrat(pSource.getReferenceContrat());setUniteAbsence(pSource.getUniteAbsence());setPeriodiciteHoraireTravail(pSource.getPeriodiciteHoraireTravail());setCategorieEmploiParticulier(pSource.getCategorieEmploiParticulier());setCodeMetierPCS(pSource.getCodeMetierPCS());setAbonnementProvisoire(pSource.getAbonnementProvisoire());setUniteIntensite(pSource.getUniteIntensite());setNomFamille(pSource.getNomFamille());setPrenom(pSource.getPrenom());setIndicSalaireBrut(pSource.getIndicSalaireBrut());setIndicPrecompte(pSource.getIndicPrecompte());setFillerUn(pSource.getFillerUn());setFillerDeux(pSource.getFillerDeux());setFonctionPublique(pSource.getFonctionPublique());setDateDebutPeriode(pSource.getDateDebutPeriode());setDateFinPeriode(pSource.getDateFinPeriode());setDateVersementSalaire(pSource.getDateVersementSalaire());setNumeroVersion(pSource.getNumeroVersion());setSalaireBrutAbattu(pSource.getSalaireBrutAbattu());setMontantPrecompteAC(pSource.getMontantPrecompteAC());setQuantiteAbsence(pSource.getQuantiteAbsence());setHoraireSalarie(pSource.getHoraireSalarie());setHoraireEntreprise(pSource.getHoraireEntreprise());setIdTechPasDna(pSource.getIdTechPasDna());setIdTechContratDna(pSource.getIdTechContratDna());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_FluxPasDna");
    subToString(s);
    s.append("]");
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", ListeFluxPasDnaQuantiteTravail: ");
    pSource.append(m_listeFluxPasDnaQuantiteTravail);
    pSource.append(", ListeFluxPasDnaPeriodesPrime: ");
    pSource.append(m_listeFluxPasDnaPeriodesPrime);
    pSource.append(", CodeMessage: ");
    pSource.append(m_codeMessage);
    pSource.append(", ReferenceContrat: ");
    pSource.append(m_referenceContrat);
    pSource.append(", UniteAbsence: ");
    pSource.append(m_uniteAbsence);
    pSource.append(", PeriodiciteHoraireTravail: ");
    pSource.append(m_periodiciteHoraireTravail);
    pSource.append(", CategorieEmploiParticulier: ");
    pSource.append(m_categorieEmploiParticulier);
    pSource.append(", CodeMetierPCS: ");
    pSource.append(m_codeMetierPCS);
    pSource.append(", AbonnementProvisoire: ");
    pSource.append(m_abonnementProvisoire);
    pSource.append(", UniteIntensite: ");
    pSource.append(m_uniteIntensite);
    pSource.append(", NomFamille: ");
    pSource.append(m_nomFamille);
    pSource.append(", Prenom: ");
    pSource.append(m_prenom);
    pSource.append(", IndicSalaireBrut: ");
    pSource.append(m_indicSalaireBrut);
    pSource.append(", IndicPrecompte: ");
    pSource.append(m_indicPrecompte);
    pSource.append(", FillerUn: ");
    pSource.append(m_fillerUn);
    pSource.append(", FillerDeux: ");
    pSource.append(m_fillerDeux);
    pSource.append(", FonctionPublique: ");
    pSource.append(m_fonctionPublique);
    pSource.append(", DateDebutPeriode: ");
    pSource.append(m_dateDebutPeriode);
    pSource.append(", DateFinPeriode: ");
    pSource.append(m_dateFinPeriode);
    pSource.append(", DateVersementSalaire: ");
    pSource.append(m_dateVersementSalaire);
    pSource.append(", NumeroVersion: ");
    pSource.append(m_numeroVersion);
    pSource.append(", SalaireBrutAbattu: ");
    pSource.append(m_salaireBrutAbattu);
    pSource.append(", MontantPrecompteAC: ");
    pSource.append(m_montantPrecompteAC);
    pSource.append(", QuantiteAbsence: ");
    pSource.append(m_quantiteAbsence);
    pSource.append(", HoraireSalarie: ");
    pSource.append(m_horaireSalarie);
    pSource.append(", HoraireEntreprise: ");
    pSource.append(m_horaireEntreprise);
    pSource.append(", IdTechPasDna: ");
    pSource.append(m_idTechPasDna);
    pSource.append(", IdTechContratDna: ");
    pSource.append(m_idTechContratDna);
  }
  
  public void goThrough(GettersHandler pHandler)
    throws Exception
  {
    pHandler.startGoThrough(new Attribute[] { new StringAttribute("C_ETAT", get_C_ETAT()), new StringAttribute("IDENT", get_IDENT()) });
    
    subGoThrough(pHandler);
    
    pHandler.endGoThrough();
  }
  
  protected void subGoThrough(GettersHandler pHandler)
    throws Exception
  {
    DataBean ListeFluxPasDnaQuantiteTravail_Value = getListeFluxPasDnaQuantiteTravail();
    GettersHandler ListeFluxPasDnaQuantiteTravail_GettersHandler = pHandler.property("ListeFluxPasDnaQuantiteTravail", ListeFluxPasDnaQuantiteTravail_Value, new Attribute[] { new StringAttribute("C_ERR", getListeFluxPasDnaQuantiteTravail_C_ERR()) });
    if ((ListeFluxPasDnaQuantiteTravail_GettersHandler != null) && (ListeFluxPasDnaQuantiteTravail_Value != null)) {
      ListeFluxPasDnaQuantiteTravail_Value.goThrough(ListeFluxPasDnaQuantiteTravail_GettersHandler);
    }
    DataBean ListeFluxPasDnaPeriodesPrime_Value = getListeFluxPasDnaPeriodesPrime();
    GettersHandler ListeFluxPasDnaPeriodesPrime_GettersHandler = pHandler.property("ListeFluxPasDnaPeriodesPrime", ListeFluxPasDnaPeriodesPrime_Value, new Attribute[] { new StringAttribute("C_ERR", getListeFluxPasDnaPeriodesPrime_C_ERR()) });
    if ((ListeFluxPasDnaPeriodesPrime_GettersHandler != null) && (ListeFluxPasDnaPeriodesPrime_Value != null)) {
      ListeFluxPasDnaPeriodesPrime_Value.goThrough(ListeFluxPasDnaPeriodesPrime_GettersHandler);
    }
    pHandler.property("CodeMessage", getCodeMessage(), new Attribute[] { new StringAttribute("C_ERR", getCodeMessage_C_ERR()) });
    
    pHandler.property("ReferenceContrat", getReferenceContrat(), new Attribute[] { new StringAttribute("C_ERR", getReferenceContrat_C_ERR()) });
    
    pHandler.property("UniteAbsence", getUniteAbsence(), new Attribute[] { new StringAttribute("C_ERR", getUniteAbsence_C_ERR()) });
    
    pHandler.property("PeriodiciteHoraireTravail", getPeriodiciteHoraireTravail(), new Attribute[] { new StringAttribute("C_ERR", getPeriodiciteHoraireTravail_C_ERR()) });
    
    pHandler.property("CategorieEmploiParticulier", getCategorieEmploiParticulier(), new Attribute[] { new StringAttribute("C_ERR", getCategorieEmploiParticulier_C_ERR()) });
    
    pHandler.property("CodeMetierPCS", getCodeMetierPCS(), new Attribute[] { new StringAttribute("C_ERR", getCodeMetierPCS_C_ERR()) });
    
    pHandler.property("AbonnementProvisoire", getAbonnementProvisoire(), new Attribute[] { new StringAttribute("C_ERR", getAbonnementProvisoire_C_ERR()) });
    
    pHandler.property("UniteIntensite", getUniteIntensite(), new Attribute[] { new StringAttribute("C_ERR", getUniteIntensite_C_ERR()) });
    
    pHandler.property("NomFamille", getNomFamille(), new Attribute[] { new StringAttribute("C_ERR", getNomFamille_C_ERR()) });
    
    pHandler.property("Prenom", getPrenom(), new Attribute[] { new StringAttribute("C_ERR", getPrenom_C_ERR()) });
    
    pHandler.property("IndicSalaireBrut", getIndicSalaireBrut(), new Attribute[] { new StringAttribute("C_ERR", getIndicSalaireBrut_C_ERR()) });
    
    pHandler.property("IndicPrecompte", getIndicPrecompte(), new Attribute[] { new StringAttribute("C_ERR", getIndicPrecompte_C_ERR()) });
    
    pHandler.property("FillerUn", getFillerUn(), new Attribute[] { new StringAttribute("C_ERR", getFillerUn_C_ERR()) });
    
    pHandler.property("FillerDeux", getFillerDeux(), new Attribute[] { new StringAttribute("C_ERR", getFillerDeux_C_ERR()) });
    
    pHandler.property("FonctionPublique", getFonctionPublique(), new Attribute[] { new StringAttribute("C_ERR", getFonctionPublique_C_ERR()) });
    
    pHandler.property("DateDebutPeriode", getDateDebutPeriode(), new Attribute[] { new StringAttribute("C_ERR", getDateDebutPeriode_C_ERR()) });
    
    pHandler.property("DateFinPeriode", getDateFinPeriode(), new Attribute[] { new StringAttribute("C_ERR", getDateFinPeriode_C_ERR()) });
    
    pHandler.property("DateVersementSalaire", getDateVersementSalaire(), new Attribute[] { new StringAttribute("C_ERR", getDateVersementSalaire_C_ERR()) });
    
    pHandler.property("NumeroVersion", getNumeroVersion(), new Attribute[] { new StringAttribute("C_ERR", getNumeroVersion_C_ERR()) });
    
    pHandler.property("SalaireBrutAbattu", getSalaireBrutAbattu(), new Attribute[] { new StringAttribute("C_ERR", getSalaireBrutAbattu_C_ERR()) });
    
    pHandler.property("MontantPrecompteAC", getMontantPrecompteAC(), new Attribute[] { new StringAttribute("C_ERR", getMontantPrecompteAC_C_ERR()) });
    
    pHandler.property("QuantiteAbsence", getQuantiteAbsence(), new Attribute[] { new StringAttribute("C_ERR", getQuantiteAbsence_C_ERR()) });
    
    pHandler.property("HoraireSalarie", getHoraireSalarie(), new Attribute[] { new StringAttribute("C_ERR", getHoraireSalarie_C_ERR()) });
    
    pHandler.property("HoraireEntreprise", getHoraireEntreprise(), new Attribute[] { new StringAttribute("C_ERR", getHoraireEntreprise_C_ERR()) });
    
    pHandler.property("IdTechPasDna", getIdTechPasDna(), new Attribute[] { new StringAttribute("C_ERR", getIdTechPasDna_C_ERR()) });
    
    pHandler.property("IdTechContratDna", getIdTechContratDna(), new Attribute[] { new StringAttribute("C_ERR", getIdTechContratDna_C_ERR()) });
  }
  
  public void goThrough(SettersHandler pHandler)
    throws Exception
  {
    pHandler.startGoThrough();
    
    subGoThrough(pHandler);
    
    pHandler.endGoThrough();
  }
  
  protected void subGoThrough(SettersHandler pHandler)
    throws Exception
  {
    set_C_ETAT(pHandler.stringAttribute("C_ETAT"));
    set_IDENT(pHandler.stringAttribute("IDENT"));
    setListeFluxPasDnaQuantiteTravail((_ListeFluxPasDnaQuantiteTravail)pHandler.databeanProperty("ListeFluxPasDnaQuantiteTravail", _ListeFluxPasDnaQuantiteTravail.class));
    setListeFluxPasDnaQuantiteTravail_C_ERR(pHandler.stringAttribute("ListeFluxPasDnaQuantiteTravail", "C_ERR"));
    setListeFluxPasDnaPeriodesPrime((_ListeFluxPasDnaPeriodesPrime)pHandler.databeanProperty("ListeFluxPasDnaPeriodesPrime", _ListeFluxPasDnaPeriodesPrime.class));
    setListeFluxPasDnaPeriodesPrime_C_ERR(pHandler.stringAttribute("ListeFluxPasDnaPeriodesPrime", "C_ERR"));
    setCodeMessage((String)pHandler.objectProperty("CodeMessage", String.class));
    setCodeMessage_C_ERR(pHandler.stringAttribute("CodeMessage", "C_ERR"));
    
    setReferenceContrat((String)pHandler.objectProperty("ReferenceContrat", String.class));
    setReferenceContrat_C_ERR(pHandler.stringAttribute("ReferenceContrat", "C_ERR"));
    
    setUniteAbsence((String)pHandler.objectProperty("UniteAbsence", String.class));
    setUniteAbsence_C_ERR(pHandler.stringAttribute("UniteAbsence", "C_ERR"));
    
    setPeriodiciteHoraireTravail((String)pHandler.objectProperty("PeriodiciteHoraireTravail", String.class));
    setPeriodiciteHoraireTravail_C_ERR(pHandler.stringAttribute("PeriodiciteHoraireTravail", "C_ERR"));
    
    setCategorieEmploiParticulier((String)pHandler.objectProperty("CategorieEmploiParticulier", String.class));
    setCategorieEmploiParticulier_C_ERR(pHandler.stringAttribute("CategorieEmploiParticulier", "C_ERR"));
    
    setCodeMetierPCS((String)pHandler.objectProperty("CodeMetierPCS", String.class));
    setCodeMetierPCS_C_ERR(pHandler.stringAttribute("CodeMetierPCS", "C_ERR"));
    
    setAbonnementProvisoire((String)pHandler.objectProperty("AbonnementProvisoire", String.class));
    setAbonnementProvisoire_C_ERR(pHandler.stringAttribute("AbonnementProvisoire", "C_ERR"));
    
    setUniteIntensite((String)pHandler.objectProperty("UniteIntensite", String.class));
    setUniteIntensite_C_ERR(pHandler.stringAttribute("UniteIntensite", "C_ERR"));
    
    setNomFamille((String)pHandler.objectProperty("NomFamille", String.class));
    setNomFamille_C_ERR(pHandler.stringAttribute("NomFamille", "C_ERR"));
    
    setPrenom((String)pHandler.objectProperty("Prenom", String.class));
    setPrenom_C_ERR(pHandler.stringAttribute("Prenom", "C_ERR"));
    
    setIndicSalaireBrut((String)pHandler.objectProperty("IndicSalaireBrut", String.class));
    setIndicSalaireBrut_C_ERR(pHandler.stringAttribute("IndicSalaireBrut", "C_ERR"));
    
    setIndicPrecompte((String)pHandler.objectProperty("IndicPrecompte", String.class));
    setIndicPrecompte_C_ERR(pHandler.stringAttribute("IndicPrecompte", "C_ERR"));
    
    setFillerUn((String)pHandler.objectProperty("FillerUn", String.class));
    setFillerUn_C_ERR(pHandler.stringAttribute("FillerUn", "C_ERR"));
    
    setFillerDeux((String)pHandler.objectProperty("FillerDeux", String.class));
    setFillerDeux_C_ERR(pHandler.stringAttribute("FillerDeux", "C_ERR"));
    
    setFonctionPublique((String)pHandler.objectProperty("FonctionPublique", String.class));
    setFonctionPublique_C_ERR(pHandler.stringAttribute("FonctionPublique", "C_ERR"));
    
    setDateDebutPeriode((Damj)pHandler.objectProperty("DateDebutPeriode", Damj.class));
    setDateDebutPeriode_C_ERR(pHandler.stringAttribute("DateDebutPeriode", "C_ERR"));
    
    setDateFinPeriode((Damj)pHandler.objectProperty("DateFinPeriode", Damj.class));
    setDateFinPeriode_C_ERR(pHandler.stringAttribute("DateFinPeriode", "C_ERR"));
    
    setDateVersementSalaire((Damj)pHandler.objectProperty("DateVersementSalaire", Damj.class));
    setDateVersementSalaire_C_ERR(pHandler.stringAttribute("DateVersementSalaire", "C_ERR"));
    
    setNumeroVersion((BigDecimal)pHandler.objectProperty("NumeroVersion", BigDecimal.class));
    setNumeroVersion_C_ERR(pHandler.stringAttribute("NumeroVersion", "C_ERR"));
    
    setSalaireBrutAbattu((BigDecimal)pHandler.objectProperty("SalaireBrutAbattu", BigDecimal.class));
    setSalaireBrutAbattu_C_ERR(pHandler.stringAttribute("SalaireBrutAbattu", "C_ERR"));
    
    setMontantPrecompteAC((BigDecimal)pHandler.objectProperty("MontantPrecompteAC", BigDecimal.class));
    setMontantPrecompteAC_C_ERR(pHandler.stringAttribute("MontantPrecompteAC", "C_ERR"));
    
    setQuantiteAbsence((BigDecimal)pHandler.objectProperty("QuantiteAbsence", BigDecimal.class));
    setQuantiteAbsence_C_ERR(pHandler.stringAttribute("QuantiteAbsence", "C_ERR"));
    
    setHoraireSalarie((BigDecimal)pHandler.objectProperty("HoraireSalarie", BigDecimal.class));
    setHoraireSalarie_C_ERR(pHandler.stringAttribute("HoraireSalarie", "C_ERR"));
    
    setHoraireEntreprise((BigDecimal)pHandler.objectProperty("HoraireEntreprise", BigDecimal.class));
    setHoraireEntreprise_C_ERR(pHandler.stringAttribute("HoraireEntreprise", "C_ERR"));
    
    setIdTechPasDna((BigDecimal)pHandler.objectProperty("IdTechPasDna", BigDecimal.class));
    setIdTechPasDna_C_ERR(pHandler.stringAttribute("IdTechPasDna", "C_ERR"));
    
    setIdTechContratDna((BigDecimal)pHandler.objectProperty("IdTechContratDna", BigDecimal.class));
    setIdTechContratDna_C_ERR(pHandler.stringAttribute("IdTechContratDna", "C_ERR"));
  }
  
  public String _getDatabeanName()
  {
    return "FluxPasDna";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("ListeFluxPasDnaQuantiteTravail".equals(pElementName)) {
      return true;
    }
    if ("ListeFluxPasDnaPeriodesPrime".equals(pElementName)) {
      return true;
    }
    if ("CodeMessage".equals(pElementName)) {
      return true;
    }
    if ("ReferenceContrat".equals(pElementName)) {
      return true;
    }
    if ("UniteAbsence".equals(pElementName)) {
      return true;
    }
    if ("PeriodiciteHoraireTravail".equals(pElementName)) {
      return true;
    }
    if ("CategorieEmploiParticulier".equals(pElementName)) {
      return true;
    }
    if ("CodeMetierPCS".equals(pElementName)) {
      return true;
    }
    if ("AbonnementProvisoire".equals(pElementName)) {
      return true;
    }
    if ("UniteIntensite".equals(pElementName)) {
      return true;
    }
    if ("NomFamille".equals(pElementName)) {
      return true;
    }
    if ("Prenom".equals(pElementName)) {
      return true;
    }
    if ("IndicSalaireBrut".equals(pElementName)) {
      return true;
    }
    if ("IndicPrecompte".equals(pElementName)) {
      return true;
    }
    if ("FillerUn".equals(pElementName)) {
      return true;
    }
    if ("FillerDeux".equals(pElementName)) {
      return true;
    }
    if ("FonctionPublique".equals(pElementName)) {
      return true;
    }
    if ("DateDebutPeriode".equals(pElementName)) {
      return true;
    }
    if ("DateFinPeriode".equals(pElementName)) {
      return true;
    }
    if ("DateVersementSalaire".equals(pElementName)) {
      return true;
    }
    if ("NumeroVersion".equals(pElementName)) {
      return true;
    }
    if ("SalaireBrutAbattu".equals(pElementName)) {
      return true;
    }
    if ("MontantPrecompteAC".equals(pElementName)) {
      return true;
    }
    if ("QuantiteAbsence".equals(pElementName)) {
      return true;
    }
    if ("HoraireSalarie".equals(pElementName)) {
      return true;
    }
    if ("HoraireEntreprise".equals(pElementName)) {
      return true;
    }
    if ("IdTechPasDna".equals(pElementName)) {
      return true;
    }
    if ("IdTechContratDna".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxPasDna
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */