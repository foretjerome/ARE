package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxPasDnaImpl
  extends FluxPasDna
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxPasDna m_fluxPasDnaInfra;
  
  public _FluxPasDnaImpl()
  {
    m_fluxPasDnaInfra = new _FluxPasDna();
  }
  
  public _FluxPasDnaImpl(_FluxPasDna pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxPasDnaInfra", pValeur);
    
    m_fluxPasDnaInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxPasDnaInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxPasDnaInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxPasDnaInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxPasDnaInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxPasDnaInfra.set_C_ETAT(pCode);
  }
  
  public ListeFluxPasDnaQuantiteTravail getListeFluxPasDnaQuantiteTravail()
  {
    _ListeFluxPasDnaQuantiteTravail infraItem = m_fluxPasDnaInfra.getListeFluxPasDnaQuantiteTravail();
    _ListeFluxPasDnaQuantiteTravailImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeFluxPasDnaQuantiteTravailImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeFluxPasDnaQuantiteTravail(ListeFluxPasDnaQuantiteTravail pValeur)
  {
    if (pValeur == null)
    {
      m_fluxPasDnaInfra.setListeFluxPasDnaQuantiteTravail(null);
    }
    else
    {
      _ListeFluxPasDnaQuantiteTravailImpl subImpl = (_ListeFluxPasDnaQuantiteTravailImpl)pValeur;
      m_fluxPasDnaInfra.setListeFluxPasDnaQuantiteTravail(subImpl.getListeFluxPasDnaQuantiteTravailInfra());
    }
  }
  
  public ListeFluxPasDnaQuantiteTravail setNewListeFluxPasDnaQuantiteTravail()
  {
    _ListeFluxPasDnaQuantiteTravailImpl item = new _ListeFluxPasDnaQuantiteTravailImpl();
    m_fluxPasDnaInfra.setListeFluxPasDnaQuantiteTravail(item.getListeFluxPasDnaQuantiteTravailInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeFluxPasDnaQuantiteTravail setNewListeFluxPasDnaQuantiteTravail_listeFluxPasDnaQuantiteTravail()
  {
    return setNewListeFluxPasDnaQuantiteTravail();
  }
  
  public ListeFluxPasDnaPeriodesPrime getListeFluxPasDnaPeriodesPrime()
  {
    _ListeFluxPasDnaPeriodesPrime infraItem = m_fluxPasDnaInfra.getListeFluxPasDnaPeriodesPrime();
    _ListeFluxPasDnaPeriodesPrimeImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeFluxPasDnaPeriodesPrimeImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeFluxPasDnaPeriodesPrime(ListeFluxPasDnaPeriodesPrime pValeur)
  {
    if (pValeur == null)
    {
      m_fluxPasDnaInfra.setListeFluxPasDnaPeriodesPrime(null);
    }
    else
    {
      _ListeFluxPasDnaPeriodesPrimeImpl subImpl = (_ListeFluxPasDnaPeriodesPrimeImpl)pValeur;
      m_fluxPasDnaInfra.setListeFluxPasDnaPeriodesPrime(subImpl.getListeFluxPasDnaPeriodesPrimeInfra());
    }
  }
  
  public ListeFluxPasDnaPeriodesPrime setNewListeFluxPasDnaPeriodesPrime()
  {
    _ListeFluxPasDnaPeriodesPrimeImpl item = new _ListeFluxPasDnaPeriodesPrimeImpl();
    m_fluxPasDnaInfra.setListeFluxPasDnaPeriodesPrime(item.getListeFluxPasDnaPeriodesPrimeInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeFluxPasDnaPeriodesPrime setNewListeFluxPasDnaPeriodesPrime_listeFluxPasDnaPeriodesPrime()
  {
    return setNewListeFluxPasDnaPeriodesPrime();
  }
  
  public String getCodeMessage()
  {
    return m_fluxPasDnaInfra.getCodeMessage();
  }
  
  public String getCodeErreurCodeMessage()
  {
    return m_fluxPasDnaInfra.getCodeMessage_C_ERR();
  }
  
  public void setCodeMessage(String pValeur)
  {
    m_fluxPasDnaInfra.setCodeMessage(pValeur);
  }
  
  public void setCodeErreurCodeMessage(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setCodeMessage_C_ERR(pCodeErreur);
  }
  
  public String getReferenceContrat()
  {
    return m_fluxPasDnaInfra.getReferenceContrat();
  }
  
  public String getCodeErreurReferenceContrat()
  {
    return m_fluxPasDnaInfra.getReferenceContrat_C_ERR();
  }
  
  public void setReferenceContrat(String pValeur)
  {
    m_fluxPasDnaInfra.setReferenceContrat(pValeur);
  }
  
  public void setCodeErreurReferenceContrat(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setReferenceContrat_C_ERR(pCodeErreur);
  }
  
  public String getUniteAbsence()
  {
    return m_fluxPasDnaInfra.getUniteAbsence();
  }
  
  public String getCodeErreurUniteAbsence()
  {
    return m_fluxPasDnaInfra.getUniteAbsence_C_ERR();
  }
  
  public void setUniteAbsence(String pValeur)
  {
    m_fluxPasDnaInfra.setUniteAbsence(pValeur);
  }
  
  public void setCodeErreurUniteAbsence(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setUniteAbsence_C_ERR(pCodeErreur);
  }
  
  public String getPeriodiciteHoraireTravail()
  {
    return m_fluxPasDnaInfra.getPeriodiciteHoraireTravail();
  }
  
  public String getCodeErreurPeriodiciteHoraireTravail()
  {
    return m_fluxPasDnaInfra.getPeriodiciteHoraireTravail_C_ERR();
  }
  
  public void setPeriodiciteHoraireTravail(String pValeur)
  {
    m_fluxPasDnaInfra.setPeriodiciteHoraireTravail(pValeur);
  }
  
  public void setCodeErreurPeriodiciteHoraireTravail(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setPeriodiciteHoraireTravail_C_ERR(pCodeErreur);
  }
  
  public String getCategorieEmploiParticulier()
  {
    return m_fluxPasDnaInfra.getCategorieEmploiParticulier();
  }
  
  public String getCodeErreurCategorieEmploiParticulier()
  {
    return m_fluxPasDnaInfra.getCategorieEmploiParticulier_C_ERR();
  }
  
  public void setCategorieEmploiParticulier(String pValeur)
  {
    m_fluxPasDnaInfra.setCategorieEmploiParticulier(pValeur);
  }
  
  public void setCodeErreurCategorieEmploiParticulier(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setCategorieEmploiParticulier_C_ERR(pCodeErreur);
  }
  
  public String getCodeMetierPCS()
  {
    return m_fluxPasDnaInfra.getCodeMetierPCS();
  }
  
  public String getCodeErreurCodeMetierPCS()
  {
    return m_fluxPasDnaInfra.getCodeMetierPCS_C_ERR();
  }
  
  public void setCodeMetierPCS(String pValeur)
  {
    m_fluxPasDnaInfra.setCodeMetierPCS(pValeur);
  }
  
  public void setCodeErreurCodeMetierPCS(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setCodeMetierPCS_C_ERR(pCodeErreur);
  }
  
  public String getAbonnementProvisoire()
  {
    return m_fluxPasDnaInfra.getAbonnementProvisoire();
  }
  
  public String getCodeErreurAbonnementProvisoire()
  {
    return m_fluxPasDnaInfra.getAbonnementProvisoire_C_ERR();
  }
  
  public void setAbonnementProvisoire(String pValeur)
  {
    m_fluxPasDnaInfra.setAbonnementProvisoire(pValeur);
  }
  
  public void setCodeErreurAbonnementProvisoire(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setAbonnementProvisoire_C_ERR(pCodeErreur);
  }
  
  public String getUniteIntensite()
  {
    return m_fluxPasDnaInfra.getUniteIntensite();
  }
  
  public String getCodeErreurUniteIntensite()
  {
    return m_fluxPasDnaInfra.getUniteIntensite_C_ERR();
  }
  
  public void setUniteIntensite(String pValeur)
  {
    m_fluxPasDnaInfra.setUniteIntensite(pValeur);
  }
  
  public void setCodeErreurUniteIntensite(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setUniteIntensite_C_ERR(pCodeErreur);
  }
  
  public String getNomFamille()
  {
    return m_fluxPasDnaInfra.getNomFamille();
  }
  
  public String getCodeErreurNomFamille()
  {
    return m_fluxPasDnaInfra.getNomFamille_C_ERR();
  }
  
  public void setNomFamille(String pValeur)
  {
    m_fluxPasDnaInfra.setNomFamille(pValeur);
  }
  
  public void setCodeErreurNomFamille(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setNomFamille_C_ERR(pCodeErreur);
  }
  
  public String getPrenom()
  {
    return m_fluxPasDnaInfra.getPrenom();
  }
  
  public String getCodeErreurPrenom()
  {
    return m_fluxPasDnaInfra.getPrenom_C_ERR();
  }
  
  public void setPrenom(String pValeur)
  {
    m_fluxPasDnaInfra.setPrenom(pValeur);
  }
  
  public void setCodeErreurPrenom(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setPrenom_C_ERR(pCodeErreur);
  }
  
  public String getIndicSalaireBrut()
  {
    return m_fluxPasDnaInfra.getIndicSalaireBrut();
  }
  
  public String getCodeErreurIndicSalaireBrut()
  {
    return m_fluxPasDnaInfra.getIndicSalaireBrut_C_ERR();
  }
  
  public void setIndicSalaireBrut(String pValeur)
  {
    m_fluxPasDnaInfra.setIndicSalaireBrut(pValeur);
  }
  
  public void setCodeErreurIndicSalaireBrut(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setIndicSalaireBrut_C_ERR(pCodeErreur);
  }
  
  public String getIndicPrecompte()
  {
    return m_fluxPasDnaInfra.getIndicPrecompte();
  }
  
  public String getCodeErreurIndicPrecompte()
  {
    return m_fluxPasDnaInfra.getIndicPrecompte_C_ERR();
  }
  
  public void setIndicPrecompte(String pValeur)
  {
    m_fluxPasDnaInfra.setIndicPrecompte(pValeur);
  }
  
  public void setCodeErreurIndicPrecompte(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setIndicPrecompte_C_ERR(pCodeErreur);
  }
  
  public String getFillerUn()
  {
    return m_fluxPasDnaInfra.getFillerUn();
  }
  
  public String getCodeErreurFillerUn()
  {
    return m_fluxPasDnaInfra.getFillerUn_C_ERR();
  }
  
  public void setFillerUn(String pValeur)
  {
    m_fluxPasDnaInfra.setFillerUn(pValeur);
  }
  
  public void setCodeErreurFillerUn(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setFillerUn_C_ERR(pCodeErreur);
  }
  
  public String getFillerDeux()
  {
    return m_fluxPasDnaInfra.getFillerDeux();
  }
  
  public String getCodeErreurFillerDeux()
  {
    return m_fluxPasDnaInfra.getFillerDeux_C_ERR();
  }
  
  public void setFillerDeux(String pValeur)
  {
    m_fluxPasDnaInfra.setFillerDeux(pValeur);
  }
  
  public void setCodeErreurFillerDeux(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setFillerDeux_C_ERR(pCodeErreur);
  }
  
  public String getFonctionPublique()
  {
    return m_fluxPasDnaInfra.getFonctionPublique();
  }
  
  public String getCodeErreurFonctionPublique()
  {
    return m_fluxPasDnaInfra.getFonctionPublique_C_ERR();
  }
  
  public void setFonctionPublique(String pValeur)
  {
    m_fluxPasDnaInfra.setFonctionPublique(pValeur);
  }
  
  public void setCodeErreurFonctionPublique(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setFonctionPublique_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutPeriode()
  {
    return m_fluxPasDnaInfra.getDateDebutPeriode();
  }
  
  public String getCodeErreurDateDebutPeriode()
  {
    return m_fluxPasDnaInfra.getDateDebutPeriode_C_ERR();
  }
  
  public void setDateDebutPeriode(Damj pValeur)
  {
    m_fluxPasDnaInfra.setDateDebutPeriode(pValeur);
  }
  
  public void setCodeErreurDateDebutPeriode(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setDateDebutPeriode_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinPeriode()
  {
    return m_fluxPasDnaInfra.getDateFinPeriode();
  }
  
  public String getCodeErreurDateFinPeriode()
  {
    return m_fluxPasDnaInfra.getDateFinPeriode_C_ERR();
  }
  
  public void setDateFinPeriode(Damj pValeur)
  {
    m_fluxPasDnaInfra.setDateFinPeriode(pValeur);
  }
  
  public void setCodeErreurDateFinPeriode(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setDateFinPeriode_C_ERR(pCodeErreur);
  }
  
  public Damj getDateVersementSalaire()
  {
    return m_fluxPasDnaInfra.getDateVersementSalaire();
  }
  
  public String getCodeErreurDateVersementSalaire()
  {
    return m_fluxPasDnaInfra.getDateVersementSalaire_C_ERR();
  }
  
  public void setDateVersementSalaire(Damj pValeur)
  {
    m_fluxPasDnaInfra.setDateVersementSalaire(pValeur);
  }
  
  public void setCodeErreurDateVersementSalaire(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setDateVersementSalaire_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNumeroVersion()
  {
    return m_fluxPasDnaInfra.getNumeroVersion();
  }
  
  public String getCodeErreurNumeroVersion()
  {
    return m_fluxPasDnaInfra.getNumeroVersion_C_ERR();
  }
  
  public void setNumeroVersion(BigDecimal pValeur)
  {
    m_fluxPasDnaInfra.setNumeroVersion(pValeur);
  }
  
  public void setCodeErreurNumeroVersion(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setNumeroVersion_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSalaireBrutAbattu()
  {
    return m_fluxPasDnaInfra.getSalaireBrutAbattu();
  }
  
  public String getCodeErreurSalaireBrutAbattu()
  {
    return m_fluxPasDnaInfra.getSalaireBrutAbattu_C_ERR();
  }
  
  public void setSalaireBrutAbattu(BigDecimal pValeur)
  {
    m_fluxPasDnaInfra.setSalaireBrutAbattu(pValeur);
  }
  
  public void setCodeErreurSalaireBrutAbattu(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setSalaireBrutAbattu_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantPrecompteAC()
  {
    return m_fluxPasDnaInfra.getMontantPrecompteAC();
  }
  
  public String getCodeErreurMontantPrecompteAC()
  {
    return m_fluxPasDnaInfra.getMontantPrecompteAC_C_ERR();
  }
  
  public void setMontantPrecompteAC(BigDecimal pValeur)
  {
    m_fluxPasDnaInfra.setMontantPrecompteAC(pValeur);
  }
  
  public void setCodeErreurMontantPrecompteAC(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setMontantPrecompteAC_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getQuantiteAbsence()
  {
    return m_fluxPasDnaInfra.getQuantiteAbsence();
  }
  
  public String getCodeErreurQuantiteAbsence()
  {
    return m_fluxPasDnaInfra.getQuantiteAbsence_C_ERR();
  }
  
  public void setQuantiteAbsence(BigDecimal pValeur)
  {
    m_fluxPasDnaInfra.setQuantiteAbsence(pValeur);
  }
  
  public void setCodeErreurQuantiteAbsence(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setQuantiteAbsence_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getHoraireSalarie()
  {
    return m_fluxPasDnaInfra.getHoraireSalarie();
  }
  
  public String getCodeErreurHoraireSalarie()
  {
    return m_fluxPasDnaInfra.getHoraireSalarie_C_ERR();
  }
  
  public void setHoraireSalarie(BigDecimal pValeur)
  {
    m_fluxPasDnaInfra.setHoraireSalarie(pValeur);
  }
  
  public void setCodeErreurHoraireSalarie(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setHoraireSalarie_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getHoraireEntreprise()
  {
    return m_fluxPasDnaInfra.getHoraireEntreprise();
  }
  
  public String getCodeErreurHoraireEntreprise()
  {
    return m_fluxPasDnaInfra.getHoraireEntreprise_C_ERR();
  }
  
  public void setHoraireEntreprise(BigDecimal pValeur)
  {
    m_fluxPasDnaInfra.setHoraireEntreprise(pValeur);
  }
  
  public void setCodeErreurHoraireEntreprise(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setHoraireEntreprise_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdTechPasDna()
  {
    return m_fluxPasDnaInfra.getIdTechPasDna();
  }
  
  public String getCodeErreurIdTechPasDna()
  {
    return m_fluxPasDnaInfra.getIdTechPasDna_C_ERR();
  }
  
  public void setIdTechPasDna(BigDecimal pValeur)
  {
    m_fluxPasDnaInfra.setIdTechPasDna(pValeur);
  }
  
  public void setCodeErreurIdTechPasDna(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setIdTechPasDna_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdTechContratDna()
  {
    return m_fluxPasDnaInfra.getIdTechContratDna();
  }
  
  public String getCodeErreurIdTechContratDna()
  {
    return m_fluxPasDnaInfra.getIdTechContratDna_C_ERR();
  }
  
  public void setIdTechContratDna(BigDecimal pValeur)
  {
    m_fluxPasDnaInfra.setIdTechContratDna(pValeur);
  }
  
  public void setCodeErreurIdTechContratDna(String pCodeErreur)
  {
    m_fluxPasDnaInfra.setIdTechContratDna_C_ERR(pCodeErreur);
  }
  
  public _FluxPasDna getFluxPasDnaInfra()
  {
    return m_fluxPasDnaInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objListeFluxPasDnaQuantiteTravail = getListeFluxPasDnaQuantiteTravail();
    if ((objListeFluxPasDnaQuantiteTravail != null) && 
      (getListeFluxPasDnaQuantiteTravail().isEnErreur())) {
      return true;
    }
    Object objListeFluxPasDnaPeriodesPrime = getListeFluxPasDnaPeriodesPrime();
    if ((objListeFluxPasDnaPeriodesPrime != null) && 
      (getListeFluxPasDnaPeriodesPrime().isEnErreur())) {
      return true;
    }
    if ((getCodeErreurCodeMessage() != null) && 
      ("".equals(getCodeErreurCodeMessage()))) {
      return true;
    }
    if ((getCodeErreurReferenceContrat() != null) && 
      ("".equals(getCodeErreurReferenceContrat()))) {
      return true;
    }
    if ((getCodeErreurUniteAbsence() != null) && 
      ("".equals(getCodeErreurUniteAbsence()))) {
      return true;
    }
    if ((getCodeErreurPeriodiciteHoraireTravail() != null) && 
      ("".equals(getCodeErreurPeriodiciteHoraireTravail()))) {
      return true;
    }
    if ((getCodeErreurCategorieEmploiParticulier() != null) && 
      ("".equals(getCodeErreurCategorieEmploiParticulier()))) {
      return true;
    }
    if ((getCodeErreurCodeMetierPCS() != null) && 
      ("".equals(getCodeErreurCodeMetierPCS()))) {
      return true;
    }
    if ((getCodeErreurAbonnementProvisoire() != null) && 
      ("".equals(getCodeErreurAbonnementProvisoire()))) {
      return true;
    }
    if ((getCodeErreurUniteIntensite() != null) && 
      ("".equals(getCodeErreurUniteIntensite()))) {
      return true;
    }
    if ((getCodeErreurNomFamille() != null) && 
      ("".equals(getCodeErreurNomFamille()))) {
      return true;
    }
    if ((getCodeErreurPrenom() != null) && 
      ("".equals(getCodeErreurPrenom()))) {
      return true;
    }
    if ((getCodeErreurIndicSalaireBrut() != null) && 
      ("".equals(getCodeErreurIndicSalaireBrut()))) {
      return true;
    }
    if ((getCodeErreurIndicPrecompte() != null) && 
      ("".equals(getCodeErreurIndicPrecompte()))) {
      return true;
    }
    if ((getCodeErreurFillerUn() != null) && 
      ("".equals(getCodeErreurFillerUn()))) {
      return true;
    }
    if ((getCodeErreurFillerDeux() != null) && 
      ("".equals(getCodeErreurFillerDeux()))) {
      return true;
    }
    if ((getCodeErreurFonctionPublique() != null) && 
      ("".equals(getCodeErreurFonctionPublique()))) {
      return true;
    }
    if ((getCodeErreurDateDebutPeriode() != null) && 
      ("".equals(getCodeErreurDateDebutPeriode()))) {
      return true;
    }
    if ((getCodeErreurDateFinPeriode() != null) && 
      ("".equals(getCodeErreurDateFinPeriode()))) {
      return true;
    }
    if ((getCodeErreurDateVersementSalaire() != null) && 
      ("".equals(getCodeErreurDateVersementSalaire()))) {
      return true;
    }
    if ((getCodeErreurNumeroVersion() != null) && 
      ("".equals(getCodeErreurNumeroVersion()))) {
      return true;
    }
    if ((getCodeErreurSalaireBrutAbattu() != null) && 
      ("".equals(getCodeErreurSalaireBrutAbattu()))) {
      return true;
    }
    if ((getCodeErreurMontantPrecompteAC() != null) && 
      ("".equals(getCodeErreurMontantPrecompteAC()))) {
      return true;
    }
    if ((getCodeErreurQuantiteAbsence() != null) && 
      ("".equals(getCodeErreurQuantiteAbsence()))) {
      return true;
    }
    if ((getCodeErreurHoraireSalarie() != null) && 
      ("".equals(getCodeErreurHoraireSalarie()))) {
      return true;
    }
    if ((getCodeErreurHoraireEntreprise() != null) && 
      ("".equals(getCodeErreurHoraireEntreprise()))) {
      return true;
    }
    if ((getCodeErreurIdTechPasDna() != null) && 
      ("".equals(getCodeErreurIdTechPasDna()))) {
      return true;
    }
    if ((getCodeErreurIdTechContratDna() != null) && 
      ("".equals(getCodeErreurIdTechContratDna()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxPasDnaImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */