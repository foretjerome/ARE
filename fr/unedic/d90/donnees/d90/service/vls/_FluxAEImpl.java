package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxAEImpl
  extends FluxAE
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxAE m_fluxAEInfra;
  
  public _FluxAEImpl()
  {
    m_fluxAEInfra = new _FluxAE();
  }
  
  public _FluxAEImpl(_FluxAE pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxAEInfra", pValeur);
    
    m_fluxAEInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxAEInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxAEInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxAEInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxAEInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxAEInfra.set_C_ETAT(pCode);
  }
  
  public ListeFluxFctDnaPreavis getListeFluxFctDnaPreavis()
  {
    _ListeFluxFctDnaPreavis infraItem = m_fluxAEInfra.getListeFluxFctDnaPreavis();
    _ListeFluxFctDnaPreavisImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeFluxFctDnaPreavisImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeFluxFctDnaPreavis(ListeFluxFctDnaPreavis pValeur)
  {
    if (pValeur == null)
    {
      m_fluxAEInfra.setListeFluxFctDnaPreavis(null);
    }
    else
    {
      _ListeFluxFctDnaPreavisImpl subImpl = (_ListeFluxFctDnaPreavisImpl)pValeur;
      m_fluxAEInfra.setListeFluxFctDnaPreavis(subImpl.getListeFluxFctDnaPreavisInfra());
    }
  }
  
  public ListeFluxFctDnaPreavis setNewListeFluxFctDnaPreavis()
  {
    _ListeFluxFctDnaPreavisImpl item = new _ListeFluxFctDnaPreavisImpl();
    m_fluxAEInfra.setListeFluxFctDnaPreavis(item.getListeFluxFctDnaPreavisInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeFluxFctDnaPreavis setNewListeFluxFctDnaPreavis_listeFluxFctDnaPreavis()
  {
    return setNewListeFluxFctDnaPreavis();
  }
  
  public ListeFluxFctDnaIndemnitesVersees getListeFluxFctDnaIndemnitesVersees()
  {
    _ListeFluxFctDnaIndemnitesVersees infraItem = m_fluxAEInfra.getListeFluxFctDnaIndemnitesVersees();
    _ListeFluxFctDnaIndemnitesVerseesImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeFluxFctDnaIndemnitesVerseesImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeFluxFctDnaIndemnitesVersees(ListeFluxFctDnaIndemnitesVersees pValeur)
  {
    if (pValeur == null)
    {
      m_fluxAEInfra.setListeFluxFctDnaIndemnitesVersees(null);
    }
    else
    {
      _ListeFluxFctDnaIndemnitesVerseesImpl subImpl = (_ListeFluxFctDnaIndemnitesVerseesImpl)pValeur;
      m_fluxAEInfra.setListeFluxFctDnaIndemnitesVersees(subImpl.getListeFluxFctDnaIndemnitesVerseesInfra());
    }
  }
  
  public ListeFluxFctDnaIndemnitesVersees setNewListeFluxFctDnaIndemnitesVersees()
  {
    _ListeFluxFctDnaIndemnitesVerseesImpl item = new _ListeFluxFctDnaIndemnitesVerseesImpl();
    m_fluxAEInfra.setListeFluxFctDnaIndemnitesVersees(item.getListeFluxFctDnaIndemnitesVerseesInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeFluxFctDnaIndemnitesVersees setNewListeFluxFctDnaIndemnitesVersees_listeFluxFctDnaIndemnitesVersees()
  {
    return setNewListeFluxFctDnaIndemnitesVersees();
  }
  
  public ListeFluxPasDna getListeFluxPasDna()
  {
    _ListeFluxPasDna infraItem = m_fluxAEInfra.getListeFluxPasDna();
    _ListeFluxPasDnaImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeFluxPasDnaImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeFluxPasDna(ListeFluxPasDna pValeur)
  {
    if (pValeur == null)
    {
      m_fluxAEInfra.setListeFluxPasDna(null);
    }
    else
    {
      _ListeFluxPasDnaImpl subImpl = (_ListeFluxPasDnaImpl)pValeur;
      m_fluxAEInfra.setListeFluxPasDna(subImpl.getListeFluxPasDnaInfra());
    }
  }
  
  public ListeFluxPasDna setNewListeFluxPasDna()
  {
    _ListeFluxPasDnaImpl item = new _ListeFluxPasDnaImpl();
    m_fluxAEInfra.setListeFluxPasDna(item.getListeFluxPasDnaInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeFluxPasDna setNewListeFluxPasDna_listeFluxPasDna()
  {
    return setNewListeFluxPasDna();
  }
  
  public String getCodeMessage()
  {
    return m_fluxAEInfra.getCodeMessage();
  }
  
  public String getCodeErreurCodeMessage()
  {
    return m_fluxAEInfra.getCodeMessage_C_ERR();
  }
  
  public void setCodeMessage(String pValeur)
  {
    m_fluxAEInfra.setCodeMessage(pValeur);
  }
  
  public void setCodeErreurCodeMessage(String pCodeErreur)
  {
    m_fluxAEInfra.setCodeMessage_C_ERR(pCodeErreur);
  }
  
  public String getCodeAction()
  {
    return m_fluxAEInfra.getCodeAction();
  }
  
  public String getCodeErreurCodeAction()
  {
    return m_fluxAEInfra.getCodeAction_C_ERR();
  }
  
  public void setCodeAction(String pValeur)
  {
    m_fluxAEInfra.setCodeAction(pValeur);
  }
  
  public void setCodeErreurCodeAction(String pCodeErreur)
  {
    m_fluxAEInfra.setCodeAction_C_ERR(pCodeErreur);
  }
  
  public String getSIRET()
  {
    return m_fluxAEInfra.getSIRET();
  }
  
  public String getCodeErreurSIRET()
  {
    return m_fluxAEInfra.getSIRET_C_ERR();
  }
  
  public void setSIRET(String pValeur)
  {
    m_fluxAEInfra.setSIRET(pValeur);
  }
  
  public void setCodeErreurSIRET(String pCodeErreur)
  {
    m_fluxAEInfra.setSIRET_C_ERR(pCodeErreur);
  }
  
  public String getReferenceContrat()
  {
    return m_fluxAEInfra.getReferenceContrat();
  }
  
  public String getCodeErreurReferenceContrat()
  {
    return m_fluxAEInfra.getReferenceContrat_C_ERR();
  }
  
  public void setReferenceContrat(String pValeur)
  {
    m_fluxAEInfra.setReferenceContrat(pValeur);
  }
  
  public void setCodeErreurReferenceContrat(String pCodeErreur)
  {
    m_fluxAEInfra.setReferenceContrat_C_ERR(pCodeErreur);
  }
  
  public String getNatureContrat()
  {
    return m_fluxAEInfra.getNatureContrat();
  }
  
  public String getCodeErreurNatureContrat()
  {
    return m_fluxAEInfra.getNatureContrat_C_ERR();
  }
  
  public void setNatureContrat(String pValeur)
  {
    m_fluxAEInfra.setNatureContrat(pValeur);
  }
  
  public void setCodeErreurNatureContrat(String pCodeErreur)
  {
    m_fluxAEInfra.setNatureContrat_C_ERR(pCodeErreur);
  }
  
  public String getMotifRupture()
  {
    return m_fluxAEInfra.getMotifRupture();
  }
  
  public String getCodeErreurMotifRupture()
  {
    return m_fluxAEInfra.getMotifRupture_C_ERR();
  }
  
  public void setMotifRupture(String pValeur)
  {
    m_fluxAEInfra.setMotifRupture(pValeur);
  }
  
  public void setCodeErreurMotifRupture(String pCodeErreur)
  {
    m_fluxAEInfra.setMotifRupture_C_ERR(pCodeErreur);
  }
  
  public String getClauseNonConcurrence()
  {
    return m_fluxAEInfra.getClauseNonConcurrence();
  }
  
  public String getCodeErreurClauseNonConcurrence()
  {
    return m_fluxAEInfra.getClauseNonConcurrence_C_ERR();
  }
  
  public void setClauseNonConcurrence(String pValeur)
  {
    m_fluxAEInfra.setClauseNonConcurrence(pValeur);
  }
  
  public void setCodeErreurClauseNonConcurrence(String pCodeErreur)
  {
    m_fluxAEInfra.setClauseNonConcurrence_C_ERR(pCodeErreur);
  }
  
  public String getRegimeSpecialSS()
  {
    return m_fluxAEInfra.getRegimeSpecialSS();
  }
  
  public String getCodeErreurRegimeSpecialSS()
  {
    return m_fluxAEInfra.getRegimeSpecialSS_C_ERR();
  }
  
  public void setRegimeSpecialSS(String pValeur)
  {
    m_fluxAEInfra.setRegimeSpecialSS(pValeur);
  }
  
  public void setCodeErreurRegimeSpecialSS(String pCodeErreur)
  {
    m_fluxAEInfra.setRegimeSpecialSS_C_ERR(pCodeErreur);
  }
  
  public String getNumeroAffiRegimeSpecialSS()
  {
    return m_fluxAEInfra.getNumeroAffiRegimeSpecialSS();
  }
  
  public String getCodeErreurNumeroAffiRegimeSpecialSS()
  {
    return m_fluxAEInfra.getNumeroAffiRegimeSpecialSS_C_ERR();
  }
  
  public void setNumeroAffiRegimeSpecialSS(String pValeur)
  {
    m_fluxAEInfra.setNumeroAffiRegimeSpecialSS(pValeur);
  }
  
  public void setCodeErreurNumeroAffiRegimeSpecialSS(String pCodeErreur)
  {
    m_fluxAEInfra.setNumeroAffiRegimeSpecialSS_C_ERR(pCodeErreur);
  }
  
  public String getLienParente()
  {
    return m_fluxAEInfra.getLienParente();
  }
  
  public String getCodeErreurLienParente()
  {
    return m_fluxAEInfra.getLienParente_C_ERR();
  }
  
  public void setLienParente(String pValeur)
  {
    m_fluxAEInfra.setLienParente(pValeur);
  }
  
  public void setCodeErreurLienParente(String pCodeErreur)
  {
    m_fluxAEInfra.setLienParente_C_ERR(pCodeErreur);
  }
  
  public String getStatutParticulier()
  {
    return m_fluxAEInfra.getStatutParticulier();
  }
  
  public String getCodeErreurStatutParticulier()
  {
    return m_fluxAEInfra.getStatutParticulier_C_ERR();
  }
  
  public void setStatutParticulier(String pValeur)
  {
    m_fluxAEInfra.setStatutParticulier(pValeur);
  }
  
  public void setCodeErreurStatutParticulier(String pCodeErreur)
  {
    m_fluxAEInfra.setStatutParticulier_C_ERR(pCodeErreur);
  }
  
  public String getNiveauQualif()
  {
    return m_fluxAEInfra.getNiveauQualif();
  }
  
  public String getCodeErreurNiveauQualif()
  {
    return m_fluxAEInfra.getNiveauQualif_C_ERR();
  }
  
  public void setNiveauQualif(String pValeur)
  {
    m_fluxAEInfra.setNiveauQualif(pValeur);
  }
  
  public void setCodeErreurNiveauQualif(String pCodeErreur)
  {
    m_fluxAEInfra.setNiveauQualif_C_ERR(pCodeErreur);
  }
  
  public String getTopTransaction()
  {
    return m_fluxAEInfra.getTopTransaction();
  }
  
  public String getCodeErreurTopTransaction()
  {
    return m_fluxAEInfra.getTopTransaction_C_ERR();
  }
  
  public void setTopTransaction(String pValeur)
  {
    m_fluxAEInfra.setTopTransaction(pValeur);
  }
  
  public void setCodeErreurTopTransaction(String pCodeErreur)
  {
    m_fluxAEInfra.setTopTransaction_C_ERR(pCodeErreur);
  }
  
  public String getBneIdentifiantBne()
  {
    return m_fluxAEInfra.getBneIdentifiantBne();
  }
  
  public String getCodeErreurBneIdentifiantBne()
  {
    return m_fluxAEInfra.getBneIdentifiantBne_C_ERR();
  }
  
  public void setBneIdentifiantBne(String pValeur)
  {
    m_fluxAEInfra.setBneIdentifiantBne(pValeur);
  }
  
  public void setCodeErreurBneIdentifiantBne(String pCodeErreur)
  {
    m_fluxAEInfra.setBneIdentifiantBne_C_ERR(pCodeErreur);
  }
  
  public String getBneSiret()
  {
    return m_fluxAEInfra.getBneSiret();
  }
  
  public String getCodeErreurBneSiret()
  {
    return m_fluxAEInfra.getBneSiret_C_ERR();
  }
  
  public void setBneSiret(String pValeur)
  {
    m_fluxAEInfra.setBneSiret(pValeur);
  }
  
  public void setCodeErreurBneSiret(String pCodeErreur)
  {
    m_fluxAEInfra.setBneSiret_C_ERR(pCodeErreur);
  }
  
  public String getBneRaisonSociale()
  {
    return m_fluxAEInfra.getBneRaisonSociale();
  }
  
  public String getCodeErreurBneRaisonSociale()
  {
    return m_fluxAEInfra.getBneRaisonSociale_C_ERR();
  }
  
  public void setBneRaisonSociale(String pValeur)
  {
    m_fluxAEInfra.setBneRaisonSociale(pValeur);
  }
  
  public void setCodeErreurBneRaisonSociale(String pCodeErreur)
  {
    m_fluxAEInfra.setBneRaisonSociale_C_ERR(pCodeErreur);
  }
  
  public String getBneCodePostal()
  {
    return m_fluxAEInfra.getBneCodePostal();
  }
  
  public String getCodeErreurBneCodePostal()
  {
    return m_fluxAEInfra.getBneCodePostal_C_ERR();
  }
  
  public void setBneCodePostal(String pValeur)
  {
    m_fluxAEInfra.setBneCodePostal(pValeur);
  }
  
  public void setCodeErreurBneCodePostal(String pCodeErreur)
  {
    m_fluxAEInfra.setBneCodePostal_C_ERR(pCodeErreur);
  }
  
  public String getBneLibelleCommuneCNAVTS()
  {
    return m_fluxAEInfra.getBneLibelleCommuneCNAVTS();
  }
  
  public String getCodeErreurBneLibelleCommuneCNAVTS()
  {
    return m_fluxAEInfra.getBneLibelleCommuneCNAVTS_C_ERR();
  }
  
  public void setBneLibelleCommuneCNAVTS(String pValeur)
  {
    m_fluxAEInfra.setBneLibelleCommuneCNAVTS(pValeur);
  }
  
  public void setCodeErreurBneLibelleCommuneCNAVTS(String pCodeErreur)
  {
    m_fluxAEInfra.setBneLibelleCommuneCNAVTS_C_ERR(pCodeErreur);
  }
  
  public String getBneAssedicAffiliation()
  {
    return m_fluxAEInfra.getBneAssedicAffiliation();
  }
  
  public String getCodeErreurBneAssedicAffiliation()
  {
    return m_fluxAEInfra.getBneAssedicAffiliation_C_ERR();
  }
  
  public void setBneAssedicAffiliation(String pValeur)
  {
    m_fluxAEInfra.setBneAssedicAffiliation(pValeur);
  }
  
  public void setCodeErreurBneAssedicAffiliation(String pCodeErreur)
  {
    m_fluxAEInfra.setBneAssedicAffiliation_C_ERR(pCodeErreur);
  }
  
  public String getBneNumAffiliation()
  {
    return m_fluxAEInfra.getBneNumAffiliation();
  }
  
  public String getCodeErreurBneNumAffiliation()
  {
    return m_fluxAEInfra.getBneNumAffiliation_C_ERR();
  }
  
  public void setBneNumAffiliation(String pValeur)
  {
    m_fluxAEInfra.setBneNumAffiliation(pValeur);
  }
  
  public void setCodeErreurBneNumAffiliation(String pCodeErreur)
  {
    m_fluxAEInfra.setBneNumAffiliation_C_ERR(pCodeErreur);
  }
  
  public String getBneNouveauCodeNAF()
  {
    return m_fluxAEInfra.getBneNouveauCodeNAF();
  }
  
  public String getCodeErreurBneNouveauCodeNAF()
  {
    return m_fluxAEInfra.getBneNouveauCodeNAF_C_ERR();
  }
  
  public void setBneNouveauCodeNAF(String pValeur)
  {
    m_fluxAEInfra.setBneNouveauCodeNAF(pValeur);
  }
  
  public void setCodeErreurBneNouveauCodeNAF(String pCodeErreur)
  {
    m_fluxAEInfra.setBneNouveauCodeNAF_C_ERR(pCodeErreur);
  }
  
  public String getAbonnementProvisoire()
  {
    return m_fluxAEInfra.getAbonnementProvisoire();
  }
  
  public String getCodeErreurAbonnementProvisoire()
  {
    return m_fluxAEInfra.getAbonnementProvisoire_C_ERR();
  }
  
  public void setAbonnementProvisoire(String pValeur)
  {
    m_fluxAEInfra.setAbonnementProvisoire(pValeur);
  }
  
  public void setCodeErreurAbonnementProvisoire(String pCodeErreur)
  {
    m_fluxAEInfra.setAbonnementProvisoire_C_ERR(pCodeErreur);
  }
  
  public String getCodeRegimeCTP()
  {
    return m_fluxAEInfra.getCodeRegimeCTP();
  }
  
  public String getCodeErreurCodeRegimeCTP()
  {
    return m_fluxAEInfra.getCodeRegimeCTP_C_ERR();
  }
  
  public void setCodeRegimeCTP(String pValeur)
  {
    m_fluxAEInfra.setCodeRegimeCTP(pValeur);
  }
  
  public void setCodeErreurCodeRegimeCTP(String pCodeErreur)
  {
    m_fluxAEInfra.setCodeRegimeCTP_C_ERR(pCodeErreur);
  }
  
  public String getNomEmployeur()
  {
    return m_fluxAEInfra.getNomEmployeur();
  }
  
  public String getCodeErreurNomEmployeur()
  {
    return m_fluxAEInfra.getNomEmployeur_C_ERR();
  }
  
  public void setNomEmployeur(String pValeur)
  {
    m_fluxAEInfra.setNomEmployeur(pValeur);
  }
  
  public void setCodeErreurNomEmployeur(String pCodeErreur)
  {
    m_fluxAEInfra.setNomEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getPrenomEmployeur()
  {
    return m_fluxAEInfra.getPrenomEmployeur();
  }
  
  public String getCodeErreurPrenomEmployeur()
  {
    return m_fluxAEInfra.getPrenomEmployeur_C_ERR();
  }
  
  public void setPrenomEmployeur(String pValeur)
  {
    m_fluxAEInfra.setPrenomEmployeur(pValeur);
  }
  
  public void setCodeErreurPrenomEmployeur(String pCodeErreur)
  {
    m_fluxAEInfra.setPrenomEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getNumUrssaf()
  {
    return m_fluxAEInfra.getNumUrssaf();
  }
  
  public String getCodeErreurNumUrssaf()
  {
    return m_fluxAEInfra.getNumUrssaf_C_ERR();
  }
  
  public void setNumUrssaf(String pValeur)
  {
    m_fluxAEInfra.setNumUrssaf(pValeur);
  }
  
  public void setCodeErreurNumUrssaf(String pCodeErreur)
  {
    m_fluxAEInfra.setNumUrssaf_C_ERR(pCodeErreur);
  }
  
  public String getNumCESU()
  {
    return m_fluxAEInfra.getNumCESU();
  }
  
  public String getCodeErreurNumCESU()
  {
    return m_fluxAEInfra.getNumCESU_C_ERR();
  }
  
  public void setNumCESU(String pValeur)
  {
    m_fluxAEInfra.setNumCESU(pValeur);
  }
  
  public void setCodeErreurNumCESU(String pCodeErreur)
  {
    m_fluxAEInfra.setNumCESU_C_ERR(pCodeErreur);
  }
  
  public String getNumPAJEEMPLOI()
  {
    return m_fluxAEInfra.getNumPAJEEMPLOI();
  }
  
  public String getCodeErreurNumPAJEEMPLOI()
  {
    return m_fluxAEInfra.getNumPAJEEMPLOI_C_ERR();
  }
  
  public void setNumPAJEEMPLOI(String pValeur)
  {
    m_fluxAEInfra.setNumPAJEEMPLOI(pValeur);
  }
  
  public void setCodeErreurNumPAJEEMPLOI(String pCodeErreur)
  {
    m_fluxAEInfra.setNumPAJEEMPLOI_C_ERR(pCodeErreur);
  }
  
  public String getIdBNIRemplace()
  {
    return m_fluxAEInfra.getIdBNIRemplace();
  }
  
  public String getCodeErreurIdBNIRemplace()
  {
    return m_fluxAEInfra.getIdBNIRemplace_C_ERR();
  }
  
  public void setIdBNIRemplace(String pValeur)
  {
    m_fluxAEInfra.setIdBNIRemplace(pValeur);
  }
  
  public void setCodeErreurIdBNIRemplace(String pCodeErreur)
  {
    m_fluxAEInfra.setIdBNIRemplace_C_ERR(pCodeErreur);
  }
  
  public String getOrigineAE()
  {
    return m_fluxAEInfra.getOrigineAE();
  }
  
  public String getCodeErreurOrigineAE()
  {
    return m_fluxAEInfra.getOrigineAE_C_ERR();
  }
  
  public void setOrigineAE(String pValeur)
  {
    m_fluxAEInfra.setOrigineAE(pValeur);
  }
  
  public void setCodeErreurOrigineAE(String pCodeErreur)
  {
    m_fluxAEInfra.setOrigineAE_C_ERR(pCodeErreur);
  }
  
  public String getIndicChomSsRCT()
  {
    return m_fluxAEInfra.getIndicChomSsRCT();
  }
  
  public String getCodeErreurIndicChomSsRCT()
  {
    return m_fluxAEInfra.getIndicChomSsRCT_C_ERR();
  }
  
  public void setIndicChomSsRCT(String pValeur)
  {
    m_fluxAEInfra.setIndicChomSsRCT(pValeur);
  }
  
  public void setCodeErreurIndicChomSsRCT(String pCodeErreur)
  {
    m_fluxAEInfra.setIndicChomSsRCT_C_ERR(pCodeErreur);
  }
  
  public String getRefusAdhesionFNE()
  {
    return m_fluxAEInfra.getRefusAdhesionFNE();
  }
  
  public String getCodeErreurRefusAdhesionFNE()
  {
    return m_fluxAEInfra.getRefusAdhesionFNE_C_ERR();
  }
  
  public void setRefusAdhesionFNE(String pValeur)
  {
    m_fluxAEInfra.setRefusAdhesionFNE(pValeur);
  }
  
  public void setCodeErreurRefusAdhesionFNE(String pCodeErreur)
  {
    m_fluxAEInfra.setRefusAdhesionFNE_C_ERR(pCodeErreur);
  }
  
  public String getCodeStatutCadre()
  {
    return m_fluxAEInfra.getCodeStatutCadre();
  }
  
  public String getCodeErreurCodeStatutCadre()
  {
    return m_fluxAEInfra.getCodeStatutCadre_C_ERR();
  }
  
  public void setCodeStatutCadre(String pValeur)
  {
    m_fluxAEInfra.setCodeStatutCadre(pValeur);
  }
  
  public void setCodeErreurCodeStatutCadre(String pCodeErreur)
  {
    m_fluxAEInfra.setCodeStatutCadre_C_ERR(pCodeErreur);
  }
  
  public String getCocheAlsaceMoselle()
  {
    return m_fluxAEInfra.getCocheAlsaceMoselle();
  }
  
  public String getCodeErreurCocheAlsaceMoselle()
  {
    return m_fluxAEInfra.getCocheAlsaceMoselle_C_ERR();
  }
  
  public void setCocheAlsaceMoselle(String pValeur)
  {
    m_fluxAEInfra.setCocheAlsaceMoselle(pValeur);
  }
  
  public void setCodeErreurCocheAlsaceMoselle(String pCodeErreur)
  {
    m_fluxAEInfra.setCocheAlsaceMoselle_C_ERR(pCodeErreur);
  }
  
  public String getIndCotisationForfaitReel()
  {
    return m_fluxAEInfra.getIndCotisationForfaitReel();
  }
  
  public String getCodeErreurIndCotisationForfaitReel()
  {
    return m_fluxAEInfra.getIndCotisationForfaitReel_C_ERR();
  }
  
  public void setIndCotisationForfaitReel(String pValeur)
  {
    m_fluxAEInfra.setIndCotisationForfaitReel(pValeur);
  }
  
  public void setCodeErreurIndCotisationForfaitReel(String pCodeErreur)
  {
    m_fluxAEInfra.setIndCotisationForfaitReel_C_ERR(pCodeErreur);
  }
  
  public String getIndBrutNet()
  {
    return m_fluxAEInfra.getIndBrutNet();
  }
  
  public String getCodeErreurIndBrutNet()
  {
    return m_fluxAEInfra.getIndBrutNet_C_ERR();
  }
  
  public void setIndBrutNet(String pValeur)
  {
    m_fluxAEInfra.setIndBrutNet(pValeur);
  }
  
  public void setCodeErreurIndBrutNet(String pCodeErreur)
  {
    m_fluxAEInfra.setIndBrutNet_C_ERR(pCodeErreur);
  }
  
  public String getCodeCaisseCongesPayes()
  {
    return m_fluxAEInfra.getCodeCaisseCongesPayes();
  }
  
  public String getCodeErreurCodeCaisseCongesPayes()
  {
    return m_fluxAEInfra.getCodeCaisseCongesPayes_C_ERR();
  }
  
  public void setCodeCaisseCongesPayes(String pValeur)
  {
    m_fluxAEInfra.setCodeCaisseCongesPayes(pValeur);
  }
  
  public void setCodeErreurCodeCaisseCongesPayes(String pCodeErreur)
  {
    m_fluxAEInfra.setCodeCaisseCongesPayes_C_ERR(pCodeErreur);
  }
  
  public String getNumCaisseCP()
  {
    return m_fluxAEInfra.getNumCaisseCP();
  }
  
  public String getCodeErreurNumCaisseCP()
  {
    return m_fluxAEInfra.getNumCaisseCP_C_ERR();
  }
  
  public void setNumCaisseCP(String pValeur)
  {
    m_fluxAEInfra.setNumCaisseCP(pValeur);
  }
  
  public void setCodeErreurNumCaisseCP(String pCodeErreur)
  {
    m_fluxAEInfra.setNumCaisseCP_C_ERR(pCodeErreur);
  }
  
  public String getCodeARRCO()
  {
    return m_fluxAEInfra.getCodeARRCO();
  }
  
  public String getCodeErreurCodeARRCO()
  {
    return m_fluxAEInfra.getCodeARRCO_C_ERR();
  }
  
  public void setCodeARRCO(String pValeur)
  {
    m_fluxAEInfra.setCodeARRCO(pValeur);
  }
  
  public void setCodeErreurCodeARRCO(String pCodeErreur)
  {
    m_fluxAEInfra.setCodeARRCO_C_ERR(pCodeErreur);
  }
  
  public String getNumBneARRCO()
  {
    return m_fluxAEInfra.getNumBneARRCO();
  }
  
  public String getCodeErreurNumBneARRCO()
  {
    return m_fluxAEInfra.getNumBneARRCO_C_ERR();
  }
  
  public void setNumBneARRCO(String pValeur)
  {
    m_fluxAEInfra.setNumBneARRCO(pValeur);
  }
  
  public void setCodeErreurNumBneARRCO(String pCodeErreur)
  {
    m_fluxAEInfra.setNumBneARRCO_C_ERR(pCodeErreur);
  }
  
  public String getSigleARRCO()
  {
    return m_fluxAEInfra.getSigleARRCO();
  }
  
  public String getCodeErreurSigleARRCO()
  {
    return m_fluxAEInfra.getSigleARRCO_C_ERR();
  }
  
  public void setSigleARRCO(String pValeur)
  {
    m_fluxAEInfra.setSigleARRCO(pValeur);
  }
  
  public void setCodeErreurSigleARRCO(String pCodeErreur)
  {
    m_fluxAEInfra.setSigleARRCO_C_ERR(pCodeErreur);
  }
  
  public String getRaisonSocialeARRCO()
  {
    return m_fluxAEInfra.getRaisonSocialeARRCO();
  }
  
  public String getCodeErreurRaisonSocialeARRCO()
  {
    return m_fluxAEInfra.getRaisonSocialeARRCO_C_ERR();
  }
  
  public void setRaisonSocialeARRCO(String pValeur)
  {
    m_fluxAEInfra.setRaisonSocialeARRCO(pValeur);
  }
  
  public void setCodeErreurRaisonSocialeARRCO(String pCodeErreur)
  {
    m_fluxAEInfra.setRaisonSocialeARRCO_C_ERR(pCodeErreur);
  }
  
  public String getCodeAGIRC()
  {
    return m_fluxAEInfra.getCodeAGIRC();
  }
  
  public String getCodeErreurCodeAGIRC()
  {
    return m_fluxAEInfra.getCodeAGIRC_C_ERR();
  }
  
  public void setCodeAGIRC(String pValeur)
  {
    m_fluxAEInfra.setCodeAGIRC(pValeur);
  }
  
  public void setCodeErreurCodeAGIRC(String pCodeErreur)
  {
    m_fluxAEInfra.setCodeAGIRC_C_ERR(pCodeErreur);
  }
  
  public String getNumBneAGIRC()
  {
    return m_fluxAEInfra.getNumBneAGIRC();
  }
  
  public String getCodeErreurNumBneAGIRC()
  {
    return m_fluxAEInfra.getNumBneAGIRC_C_ERR();
  }
  
  public void setNumBneAGIRC(String pValeur)
  {
    m_fluxAEInfra.setNumBneAGIRC(pValeur);
  }
  
  public void setCodeErreurNumBneAGIRC(String pCodeErreur)
  {
    m_fluxAEInfra.setNumBneAGIRC_C_ERR(pCodeErreur);
  }
  
  public String getSigleAGIRC()
  {
    return m_fluxAEInfra.getSigleAGIRC();
  }
  
  public String getCodeErreurSigleAGIRC()
  {
    return m_fluxAEInfra.getSigleAGIRC_C_ERR();
  }
  
  public void setSigleAGIRC(String pValeur)
  {
    m_fluxAEInfra.setSigleAGIRC(pValeur);
  }
  
  public void setCodeErreurSigleAGIRC(String pCodeErreur)
  {
    m_fluxAEInfra.setSigleAGIRC_C_ERR(pCodeErreur);
  }
  
  public String getRaisonSocialeAGIRC()
  {
    return m_fluxAEInfra.getRaisonSocialeAGIRC();
  }
  
  public String getCodeErreurRaisonSocialeAGIRC()
  {
    return m_fluxAEInfra.getRaisonSocialeAGIRC_C_ERR();
  }
  
  public void setRaisonSocialeAGIRC(String pValeur)
  {
    m_fluxAEInfra.setRaisonSocialeAGIRC(pValeur);
  }
  
  public void setCodeErreurRaisonSocialeAGIRC(String pCodeErreur)
  {
    m_fluxAEInfra.setRaisonSocialeAGIRC_C_ERR(pCodeErreur);
  }
  
  public String getTypeContrat()
  {
    return m_fluxAEInfra.getTypeContrat();
  }
  
  public String getCodeErreurTypeContrat()
  {
    return m_fluxAEInfra.getTypeContrat_C_ERR();
  }
  
  public void setTypeContrat(String pValeur)
  {
    m_fluxAEInfra.setTypeContrat(pValeur);
  }
  
  public void setCodeErreurTypeContrat(String pCodeErreur)
  {
    m_fluxAEInfra.setTypeContrat_C_ERR(pCodeErreur);
  }
  
  public String getCodeRegimeEmployeur()
  {
    return m_fluxAEInfra.getCodeRegimeEmployeur();
  }
  
  public String getCodeErreurCodeRegimeEmployeur()
  {
    return m_fluxAEInfra.getCodeRegimeEmployeur_C_ERR();
  }
  
  public void setCodeRegimeEmployeur(String pValeur)
  {
    m_fluxAEInfra.setCodeRegimeEmployeur(pValeur);
  }
  
  public void setCodeErreurCodeRegimeEmployeur(String pCodeErreur)
  {
    m_fluxAEInfra.setCodeRegimeEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getNumConventionGestion()
  {
    return m_fluxAEInfra.getNumConventionGestion();
  }
  
  public String getCodeErreurNumConventionGestion()
  {
    return m_fluxAEInfra.getNumConventionGestion_C_ERR();
  }
  
  public void setNumConventionGestion(String pValeur)
  {
    m_fluxAEInfra.setNumConventionGestion(pValeur);
  }
  
  public void setCodeErreurNumConventionGestion(String pCodeErreur)
  {
    m_fluxAEInfra.setNumConventionGestion_C_ERR(pCodeErreur);
  }
  
  public String getNomFamille()
  {
    return m_fluxAEInfra.getNomFamille();
  }
  
  public String getCodeErreurNomFamille()
  {
    return m_fluxAEInfra.getNomFamille_C_ERR();
  }
  
  public void setNomFamille(String pValeur)
  {
    m_fluxAEInfra.setNomFamille(pValeur);
  }
  
  public void setCodeErreurNomFamille(String pCodeErreur)
  {
    m_fluxAEInfra.setNomFamille_C_ERR(pCodeErreur);
  }
  
  public String getPrenom()
  {
    return m_fluxAEInfra.getPrenom();
  }
  
  public String getCodeErreurPrenom()
  {
    return m_fluxAEInfra.getPrenom_C_ERR();
  }
  
  public void setPrenom(String pValeur)
  {
    m_fluxAEInfra.setPrenom(pValeur);
  }
  
  public void setCodeErreurPrenom(String pCodeErreur)
  {
    m_fluxAEInfra.setPrenom_C_ERR(pCodeErreur);
  }
  
  public String getIndicMontantIndemnite()
  {
    return m_fluxAEInfra.getIndicMontantIndemnite();
  }
  
  public String getCodeErreurIndicMontantIndemnite()
  {
    return m_fluxAEInfra.getIndicMontantIndemnite_C_ERR();
  }
  
  public void setIndicMontantIndemnite(String pValeur)
  {
    m_fluxAEInfra.setIndicMontantIndemnite(pValeur);
  }
  
  public void setCodeErreurIndicMontantIndemnite(String pCodeErreur)
  {
    m_fluxAEInfra.setIndicMontantIndemnite_C_ERR(pCodeErreur);
  }
  
  public String getIndicSalaireHoraire()
  {
    return m_fluxAEInfra.getIndicSalaireHoraire();
  }
  
  public String getCodeErreurIndicSalaireHoraire()
  {
    return m_fluxAEInfra.getIndicSalaireHoraire_C_ERR();
  }
  
  public void setIndicSalaireHoraire(String pValeur)
  {
    m_fluxAEInfra.setIndicSalaireHoraire(pValeur);
  }
  
  public void setCodeErreurIndicSalaireHoraire(String pCodeErreur)
  {
    m_fluxAEInfra.setIndicSalaireHoraire_C_ERR(pCodeErreur);
  }
  
  public String getFillerUn()
  {
    return m_fluxAEInfra.getFillerUn();
  }
  
  public String getCodeErreurFillerUn()
  {
    return m_fluxAEInfra.getFillerUn_C_ERR();
  }
  
  public void setFillerUn(String pValeur)
  {
    m_fluxAEInfra.setFillerUn(pValeur);
  }
  
  public void setCodeErreurFillerUn(String pCodeErreur)
  {
    m_fluxAEInfra.setFillerUn_C_ERR(pCodeErreur);
  }
  
  public String getFillerDeux()
  {
    return m_fluxAEInfra.getFillerDeux();
  }
  
  public String getCodeErreurFillerDeux()
  {
    return m_fluxAEInfra.getFillerDeux_C_ERR();
  }
  
  public void setFillerDeux(String pValeur)
  {
    m_fluxAEInfra.setFillerDeux(pValeur);
  }
  
  public void setCodeErreurFillerDeux(String pCodeErreur)
  {
    m_fluxAEInfra.setFillerDeux_C_ERR(pCodeErreur);
  }
  
  public String getEmployAutoAssur()
  {
    return m_fluxAEInfra.getEmployAutoAssur();
  }
  
  public String getCodeErreurEmployAutoAssur()
  {
    return m_fluxAEInfra.getEmployAutoAssur_C_ERR();
  }
  
  public void setEmployAutoAssur(String pValeur)
  {
    m_fluxAEInfra.setEmployAutoAssur(pValeur);
  }
  
  public void setCodeErreurEmployAutoAssur(String pCodeErreur)
  {
    m_fluxAEInfra.setEmployAutoAssur_C_ERR(pCodeErreur);
  }
  
  public String getNumCG()
  {
    return m_fluxAEInfra.getNumCG();
  }
  
  public String getCodeErreurNumCG()
  {
    return m_fluxAEInfra.getNumCG_C_ERR();
  }
  
  public void setNumCG(String pValeur)
  {
    m_fluxAEInfra.setNumCG(pValeur);
  }
  
  public void setCodeErreurNumCG(String pCodeErreur)
  {
    m_fluxAEInfra.setNumCG_C_ERR(pCodeErreur);
  }
  
  public String getEtabFinanc()
  {
    return m_fluxAEInfra.getEtabFinanc();
  }
  
  public String getCodeErreurEtabFinanc()
  {
    return m_fluxAEInfra.getEtabFinanc_C_ERR();
  }
  
  public void setEtabFinanc(String pValeur)
  {
    m_fluxAEInfra.setEtabFinanc(pValeur);
  }
  
  public void setCodeErreurEtabFinanc(String pCodeErreur)
  {
    m_fluxAEInfra.setEtabFinanc_C_ERR(pCodeErreur);
  }
  
  public String getNumInterne()
  {
    return m_fluxAEInfra.getNumInterne();
  }
  
  public String getCodeErreurNumInterne()
  {
    return m_fluxAEInfra.getNumInterne_C_ERR();
  }
  
  public void setNumInterne(String pValeur)
  {
    m_fluxAEInfra.setNumInterne(pValeur);
  }
  
  public void setCodeErreurNumInterne(String pCodeErreur)
  {
    m_fluxAEInfra.setNumInterne_C_ERR(pCodeErreur);
  }
  
  public String getCodeAffect()
  {
    return m_fluxAEInfra.getCodeAffect();
  }
  
  public String getCodeErreurCodeAffect()
  {
    return m_fluxAEInfra.getCodeAffect_C_ERR();
  }
  
  public void setCodeAffect(String pValeur)
  {
    m_fluxAEInfra.setCodeAffect(pValeur);
  }
  
  public void setCodeErreurCodeAffect(String pCodeErreur)
  {
    m_fluxAEInfra.setCodeAffect_C_ERR(pCodeErreur);
  }
  
  public String getStatutSalarie()
  {
    return m_fluxAEInfra.getStatutSalarie();
  }
  
  public String getCodeErreurStatutSalarie()
  {
    return m_fluxAEInfra.getStatutSalarie_C_ERR();
  }
  
  public void setStatutSalarie(String pValeur)
  {
    m_fluxAEInfra.setStatutSalarie(pValeur);
  }
  
  public void setCodeErreurStatutSalarie(String pCodeErreur)
  {
    m_fluxAEInfra.setStatutSalarie_C_ERR(pCodeErreur);
  }
  
  public String getCodeStatutjuridique()
  {
    return m_fluxAEInfra.getCodeStatutjuridique();
  }
  
  public String getCodeErreurCodeStatutjuridique()
  {
    return m_fluxAEInfra.getCodeStatutjuridique_C_ERR();
  }
  
  public void setCodeStatutjuridique(String pValeur)
  {
    m_fluxAEInfra.setCodeStatutjuridique(pValeur);
  }
  
  public void setCodeErreurCodeStatutjuridique(String pCodeErreur)
  {
    m_fluxAEInfra.setCodeStatutjuridique_C_ERR(pCodeErreur);
  }
  
  public String getNomLogiciel()
  {
    return m_fluxAEInfra.getNomLogiciel();
  }
  
  public String getCodeErreurNomLogiciel()
  {
    return m_fluxAEInfra.getNomLogiciel_C_ERR();
  }
  
  public void setNomLogiciel(String pValeur)
  {
    m_fluxAEInfra.setNomLogiciel(pValeur);
  }
  
  public void setCodeErreurNomLogiciel(String pCodeErreur)
  {
    m_fluxAEInfra.setNomLogiciel_C_ERR(pCodeErreur);
  }
  
  public String getVersionLogiciel()
  {
    return m_fluxAEInfra.getVersionLogiciel();
  }
  
  public String getCodeErreurVersionLogiciel()
  {
    return m_fluxAEInfra.getVersionLogiciel_C_ERR();
  }
  
  public void setVersionLogiciel(String pValeur)
  {
    m_fluxAEInfra.setVersionLogiciel(pValeur);
  }
  
  public void setCodeErreurVersionLogiciel(String pCodeErreur)
  {
    m_fluxAEInfra.setVersionLogiciel_C_ERR(pCodeErreur);
  }
  
  public String getCategorieJuridiqueEntreprise()
  {
    return m_fluxAEInfra.getCategorieJuridiqueEntreprise();
  }
  
  public String getCodeErreurCategorieJuridiqueEntreprise()
  {
    return m_fluxAEInfra.getCategorieJuridiqueEntreprise_C_ERR();
  }
  
  public void setCategorieJuridiqueEntreprise(String pValeur)
  {
    m_fluxAEInfra.setCategorieJuridiqueEntreprise(pValeur);
  }
  
  public void setCodeErreurCategorieJuridiqueEntreprise(String pCodeErreur)
  {
    m_fluxAEInfra.setCategorieJuridiqueEntreprise_C_ERR(pCodeErreur);
  }
  
  public String getCodeRegimeEntreprise()
  {
    return m_fluxAEInfra.getCodeRegimeEntreprise();
  }
  
  public String getCodeErreurCodeRegimeEntreprise()
  {
    return m_fluxAEInfra.getCodeRegimeEntreprise_C_ERR();
  }
  
  public void setCodeRegimeEntreprise(String pValeur)
  {
    m_fluxAEInfra.setCodeRegimeEntreprise(pValeur);
  }
  
  public void setCodeErreurCodeRegimeEntreprise(String pCodeErreur)
  {
    m_fluxAEInfra.setCodeRegimeEntreprise_C_ERR(pCodeErreur);
  }
  
  public String getNatureEntreprise()
  {
    return m_fluxAEInfra.getNatureEntreprise();
  }
  
  public String getCodeErreurNatureEntreprise()
  {
    return m_fluxAEInfra.getNatureEntreprise_C_ERR();
  }
  
  public void setNatureEntreprise(String pValeur)
  {
    m_fluxAEInfra.setNatureEntreprise(pValeur);
  }
  
  public void setCodeErreurNatureEntreprise(String pCodeErreur)
  {
    m_fluxAEInfra.setNatureEntreprise_C_ERR(pCodeErreur);
  }
  
  public String getNumGusoEntreprise()
  {
    return m_fluxAEInfra.getNumGusoEntreprise();
  }
  
  public String getCodeErreurNumGusoEntreprise()
  {
    return m_fluxAEInfra.getNumGusoEntreprise_C_ERR();
  }
  
  public void setNumGusoEntreprise(String pValeur)
  {
    m_fluxAEInfra.setNumGusoEntreprise(pValeur);
  }
  
  public void setCodeErreurNumGusoEntreprise(String pCodeErreur)
  {
    m_fluxAEInfra.setNumGusoEntreprise_C_ERR(pCodeErreur);
  }
  
  public String getNumMSAEntreprise()
  {
    return m_fluxAEInfra.getNumMSAEntreprise();
  }
  
  public String getCodeErreurNumMSAEntreprise()
  {
    return m_fluxAEInfra.getNumMSAEntreprise_C_ERR();
  }
  
  public void setNumMSAEntreprise(String pValeur)
  {
    m_fluxAEInfra.setNumMSAEntreprise(pValeur);
  }
  
  public void setCodeErreurNumMSAEntreprise(String pCodeErreur)
  {
    m_fluxAEInfra.setNumMSAEntreprise_C_ERR(pCodeErreur);
  }
  
  public String getEntreprisePublique()
  {
    return m_fluxAEInfra.getEntreprisePublique();
  }
  
  public String getCodeErreurEntreprisePublique()
  {
    return m_fluxAEInfra.getEntreprisePublique_C_ERR();
  }
  
  public void setEntreprisePublique(String pValeur)
  {
    m_fluxAEInfra.setEntreprisePublique(pValeur);
  }
  
  public void setCodeErreurEntreprisePublique(String pCodeErreur)
  {
    m_fluxAEInfra.setEntreprisePublique_C_ERR(pCodeErreur);
  }
  
  public String getTrancheEffectifEntreprise()
  {
    return m_fluxAEInfra.getTrancheEffectifEntreprise();
  }
  
  public String getCodeErreurTrancheEffectifEntreprise()
  {
    return m_fluxAEInfra.getTrancheEffectifEntreprise_C_ERR();
  }
  
  public void setTrancheEffectifEntreprise(String pValeur)
  {
    m_fluxAEInfra.setTrancheEffectifEntreprise(pValeur);
  }
  
  public void setCodeErreurTrancheEffectifEntreprise(String pCodeErreur)
  {
    m_fluxAEInfra.setTrancheEffectifEntreprise_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutContrat()
  {
    return m_fluxAEInfra.getDateDebutContrat();
  }
  
  public String getCodeErreurDateDebutContrat()
  {
    return m_fluxAEInfra.getDateDebutContrat_C_ERR();
  }
  
  public void setDateDebutContrat(Damj pValeur)
  {
    m_fluxAEInfra.setDateDebutContrat(pValeur);
  }
  
  public void setCodeErreurDateDebutContrat(String pCodeErreur)
  {
    m_fluxAEInfra.setDateDebutContrat_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinContrat()
  {
    return m_fluxAEInfra.getDateFinContrat();
  }
  
  public String getCodeErreurDateFinContrat()
  {
    return m_fluxAEInfra.getDateFinContrat_C_ERR();
  }
  
  public void setDateFinContrat(Damj pValeur)
  {
    m_fluxAEInfra.setDateFinContrat(pValeur);
  }
  
  public void setCodeErreurDateFinContrat(String pCodeErreur)
  {
    m_fluxAEInfra.setDateFinContrat_C_ERR(pCodeErreur);
  }
  
  public Damj getDateNotifRupture()
  {
    return m_fluxAEInfra.getDateNotifRupture();
  }
  
  public String getCodeErreurDateNotifRupture()
  {
    return m_fluxAEInfra.getDateNotifRupture_C_ERR();
  }
  
  public void setDateNotifRupture(Damj pValeur)
  {
    m_fluxAEInfra.setDateNotifRupture(pValeur);
  }
  
  public void setCodeErreurDateNotifRupture(String pCodeErreur)
  {
    m_fluxAEInfra.setDateNotifRupture_C_ERR(pCodeErreur);
  }
  
  public Damj getDateProcedureLicenciement()
  {
    return m_fluxAEInfra.getDateProcedureLicenciement();
  }
  
  public String getCodeErreurDateProcedureLicenciement()
  {
    return m_fluxAEInfra.getDateProcedureLicenciement_C_ERR();
  }
  
  public void setDateProcedureLicenciement(Damj pValeur)
  {
    m_fluxAEInfra.setDateProcedureLicenciement(pValeur);
  }
  
  public void setCodeErreurDateProcedureLicenciement(String pCodeErreur)
  {
    m_fluxAEInfra.setDateProcedureLicenciement_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDJTP()
  {
    return m_fluxAEInfra.getDateDJTP();
  }
  
  public String getCodeErreurDateDJTP()
  {
    return m_fluxAEInfra.getDateDJTP_C_ERR();
  }
  
  public void setDateDJTP(Damj pValeur)
  {
    m_fluxAEInfra.setDateDJTP(pValeur);
  }
  
  public void setCodeErreurDateDJTP(String pCodeErreur)
  {
    m_fluxAEInfra.setDateDJTP_C_ERR(pCodeErreur);
  }
  
  public Damj getDateInitialeFinContrat()
  {
    return m_fluxAEInfra.getDateInitialeFinContrat();
  }
  
  public String getCodeErreurDateInitialeFinContrat()
  {
    return m_fluxAEInfra.getDateInitialeFinContrat_C_ERR();
  }
  
  public void setDateInitialeFinContrat(Damj pValeur)
  {
    m_fluxAEInfra.setDateInitialeFinContrat(pValeur);
  }
  
  public void setCodeErreurDateInitialeFinContrat(String pCodeErreur)
  {
    m_fluxAEInfra.setDateInitialeFinContrat_C_ERR(pCodeErreur);
  }
  
  public Damj getDateConnaissanceAE()
  {
    return m_fluxAEInfra.getDateConnaissanceAE();
  }
  
  public String getCodeErreurDateConnaissanceAE()
  {
    return m_fluxAEInfra.getDateConnaissanceAE_C_ERR();
  }
  
  public void setDateConnaissanceAE(Damj pValeur)
  {
    m_fluxAEInfra.setDateConnaissanceAE(pValeur);
  }
  
  public void setCodeErreurDateConnaissanceAE(String pCodeErreur)
  {
    m_fluxAEInfra.setDateConnaissanceAE_C_ERR(pCodeErreur);
  }
  
  public Damj getDateReprise()
  {
    return m_fluxAEInfra.getDateReprise();
  }
  
  public String getCodeErreurDateReprise()
  {
    return m_fluxAEInfra.getDateReprise_C_ERR();
  }
  
  public void setDateReprise(Damj pValeur)
  {
    m_fluxAEInfra.setDateReprise(pValeur);
  }
  
  public void setCodeErreurDateReprise(String pCodeErreur)
  {
    m_fluxAEInfra.setDateReprise_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutIndemCP()
  {
    return m_fluxAEInfra.getDateDebutIndemCP();
  }
  
  public String getCodeErreurDateDebutIndemCP()
  {
    return m_fluxAEInfra.getDateDebutIndemCP_C_ERR();
  }
  
  public void setDateDebutIndemCP(Damj pValeur)
  {
    m_fluxAEInfra.setDateDebutIndemCP(pValeur);
  }
  
  public void setCodeErreurDateDebutIndemCP(String pCodeErreur)
  {
    m_fluxAEInfra.setDateDebutIndemCP_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinIndemCP()
  {
    return m_fluxAEInfra.getDateFinIndemCP();
  }
  
  public String getCodeErreurDateFinIndemCP()
  {
    return m_fluxAEInfra.getDateFinIndemCP_C_ERR();
  }
  
  public void setDateFinIndemCP(Damj pValeur)
  {
    m_fluxAEInfra.setDateFinIndemCP(pValeur);
  }
  
  public void setCodeErreurDateFinIndemCP(String pCodeErreur)
  {
    m_fluxAEInfra.setDateFinIndemCP_C_ERR(pCodeErreur);
  }
  
  public Damj getDateEffetCTP()
  {
    return m_fluxAEInfra.getDateEffetCTP();
  }
  
  public String getCodeErreurDateEffetCTP()
  {
    return m_fluxAEInfra.getDateEffetCTP_C_ERR();
  }
  
  public void setDateEffetCTP(Damj pValeur)
  {
    m_fluxAEInfra.setDateEffetCTP(pValeur);
  }
  
  public void setCodeErreurDateEffetCTP(String pCodeErreur)
  {
    m_fluxAEInfra.setDateEffetCTP_C_ERR(pCodeErreur);
  }
  
  public Damj getDateAdhesion()
  {
    return m_fluxAEInfra.getDateAdhesion();
  }
  
  public String getCodeErreurDateAdhesion()
  {
    return m_fluxAEInfra.getDateAdhesion_C_ERR();
  }
  
  public void setDateAdhesion(Damj pValeur)
  {
    m_fluxAEInfra.setDateAdhesion(pValeur);
  }
  
  public void setCodeErreurDateAdhesion(String pCodeErreur)
  {
    m_fluxAEInfra.setDateAdhesion_C_ERR(pCodeErreur);
  }
  
  public Damj getDateCessationActiviteEntreprise()
  {
    return m_fluxAEInfra.getDateCessationActiviteEntreprise();
  }
  
  public String getCodeErreurDateCessationActiviteEntreprise()
  {
    return m_fluxAEInfra.getDateCessationActiviteEntreprise_C_ERR();
  }
  
  public void setDateCessationActiviteEntreprise(Damj pValeur)
  {
    m_fluxAEInfra.setDateCessationActiviteEntreprise(pValeur);
  }
  
  public void setCodeErreurDateCessationActiviteEntreprise(String pCodeErreur)
  {
    m_fluxAEInfra.setDateCessationActiviteEntreprise_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutPeriodeAffiliationEntreprise()
  {
    return m_fluxAEInfra.getDateDebutPeriodeAffiliationEntreprise();
  }
  
  public String getCodeErreurDateDebutPeriodeAffiliationEntreprise()
  {
    return m_fluxAEInfra.getDateDebutPeriodeAffiliationEntreprise_C_ERR();
  }
  
  public void setDateDebutPeriodeAffiliationEntreprise(Damj pValeur)
  {
    m_fluxAEInfra.setDateDebutPeriodeAffiliationEntreprise(pValeur);
  }
  
  public void setCodeErreurDateDebutPeriodeAffiliationEntreprise(String pCodeErreur)
  {
    m_fluxAEInfra.setDateDebutPeriodeAffiliationEntreprise_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinPeriodeAffiliationEntreprise()
  {
    return m_fluxAEInfra.getDateFinPeriodeAffiliationEntreprise();
  }
  
  public String getCodeErreurDateFinPeriodeAffiliationEntreprise()
  {
    return m_fluxAEInfra.getDateFinPeriodeAffiliationEntreprise_C_ERR();
  }
  
  public void setDateFinPeriodeAffiliationEntreprise(Damj pValeur)
  {
    m_fluxAEInfra.setDateFinPeriodeAffiliationEntreprise(pValeur);
  }
  
  public void setCodeErreurDateFinPeriodeAffiliationEntreprise(String pCodeErreur)
  {
    m_fluxAEInfra.setDateFinPeriodeAffiliationEntreprise_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutEffetConGes()
  {
    return m_fluxAEInfra.getDateDebutEffetConGes();
  }
  
  public String getCodeErreurDateDebutEffetConGes()
  {
    return m_fluxAEInfra.getDateDebutEffetConGes_C_ERR();
  }
  
  public void setDateDebutEffetConGes(Damj pValeur)
  {
    m_fluxAEInfra.setDateDebutEffetConGes(pValeur);
  }
  
  public void setCodeErreurDateDebutEffetConGes(String pCodeErreur)
  {
    m_fluxAEInfra.setDateDebutEffetConGes_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinEffetConGes()
  {
    return m_fluxAEInfra.getDateFinEffetConGes();
  }
  
  public String getCodeErreurDateFinEffetConGes()
  {
    return m_fluxAEInfra.getDateFinEffetConGes_C_ERR();
  }
  
  public void setDateFinEffetConGes(Damj pValeur)
  {
    m_fluxAEInfra.setDateFinEffetConGes(pValeur);
  }
  
  public void setCodeErreurDateFinEffetConGes(String pCodeErreur)
  {
    m_fluxAEInfra.setDateFinEffetConGes_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNumeroVersion()
  {
    return m_fluxAEInfra.getNumeroVersion();
  }
  
  public String getCodeErreurNumeroVersion()
  {
    return m_fluxAEInfra.getNumeroVersion_C_ERR();
  }
  
  public void setNumeroVersion(BigDecimal pValeur)
  {
    m_fluxAEInfra.setNumeroVersion(pValeur);
  }
  
  public void setCodeErreurNumeroVersion(String pCodeErreur)
  {
    m_fluxAEInfra.setNumeroVersion_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdTechContratDna()
  {
    return m_fluxAEInfra.getIdTechContratDna();
  }
  
  public String getCodeErreurIdTechContratDna()
  {
    return m_fluxAEInfra.getIdTechContratDna_C_ERR();
  }
  
  public void setIdTechContratDna(BigDecimal pValeur)
  {
    m_fluxAEInfra.setIdTechContratDna(pValeur);
  }
  
  public void setCodeErreurIdTechContratDna(String pCodeErreur)
  {
    m_fluxAEInfra.setIdTechContratDna_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbCongesPayesRestant()
  {
    return m_fluxAEInfra.getNbCongesPayesRestant();
  }
  
  public String getCodeErreurNbCongesPayesRestant()
  {
    return m_fluxAEInfra.getNbCongesPayesRestant_C_ERR();
  }
  
  public void setNbCongesPayesRestant(BigDecimal pValeur)
  {
    m_fluxAEInfra.setNbCongesPayesRestant(pValeur);
  }
  
  public void setCodeErreurNbCongesPayesRestant(String pCodeErreur)
  {
    m_fluxAEInfra.setNbCongesPayesRestant_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantIndemnitePreavis()
  {
    return m_fluxAEInfra.getMontantIndemnitePreavis();
  }
  
  public String getCodeErreurMontantIndemnitePreavis()
  {
    return m_fluxAEInfra.getMontantIndemnitePreavis_C_ERR();
  }
  
  public void setMontantIndemnitePreavis(BigDecimal pValeur)
  {
    m_fluxAEInfra.setMontantIndemnitePreavis(pValeur);
  }
  
  public void setCodeErreurMontantIndemnitePreavis(String pCodeErreur)
  {
    m_fluxAEInfra.setMontantIndemnitePreavis_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbHeuresDIF()
  {
    return m_fluxAEInfra.getNbHeuresDIF();
  }
  
  public String getCodeErreurNbHeuresDIF()
  {
    return m_fluxAEInfra.getNbHeuresDIF_C_ERR();
  }
  
  public void setNbHeuresDIF(BigDecimal pValeur)
  {
    m_fluxAEInfra.setNbHeuresDIF(pValeur);
  }
  
  public void setCodeErreurNbHeuresDIF(String pCodeErreur)
  {
    m_fluxAEInfra.setNbHeuresDIF_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSalaireHoraireNetSalarie()
  {
    return m_fluxAEInfra.getSalaireHoraireNetSalarie();
  }
  
  public String getCodeErreurSalaireHoraireNetSalarie()
  {
    return m_fluxAEInfra.getSalaireHoraireNetSalarie_C_ERR();
  }
  
  public void setSalaireHoraireNetSalarie(BigDecimal pValeur)
  {
    m_fluxAEInfra.setSalaireHoraireNetSalarie(pValeur);
  }
  
  public void setCodeErreurSalaireHoraireNetSalarie(String pCodeErreur)
  {
    m_fluxAEInfra.setSalaireHoraireNetSalarie_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdTechContratRemplace()
  {
    return m_fluxAEInfra.getIdTechContratRemplace();
  }
  
  public String getCodeErreurIdTechContratRemplace()
  {
    return m_fluxAEInfra.getIdTechContratRemplace_C_ERR();
  }
  
  public void setIdTechContratRemplace(BigDecimal pValeur)
  {
    m_fluxAEInfra.setIdTechContratRemplace(pValeur);
  }
  
  public void setCodeErreurIdTechContratRemplace(String pCodeErreur)
  {
    m_fluxAEInfra.setIdTechContratRemplace_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbPAS()
  {
    return m_fluxAEInfra.getNbPAS();
  }
  
  public String getCodeErreurNbPAS()
  {
    return m_fluxAEInfra.getNbPAS_C_ERR();
  }
  
  public void setNbPAS(BigDecimal pValeur)
  {
    m_fluxAEInfra.setNbPAS(pValeur);
  }
  
  public void setCodeErreurNbPAS(String pCodeErreur)
  {
    m_fluxAEInfra.setNbPAS_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbSalariesEntreprise()
  {
    return m_fluxAEInfra.getNbSalariesEntreprise();
  }
  
  public String getCodeErreurNbSalariesEntreprise()
  {
    return m_fluxAEInfra.getNbSalariesEntreprise_C_ERR();
  }
  
  public void setNbSalariesEntreprise(BigDecimal pValeur)
  {
    m_fluxAEInfra.setNbSalariesEntreprise(pValeur);
  }
  
  public void setCodeErreurNbSalariesEntreprise(String pCodeErreur)
  {
    m_fluxAEInfra.setNbSalariesEntreprise_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbMoisPreavis()
  {
    return m_fluxAEInfra.getNbMoisPreavis();
  }
  
  public String getCodeErreurNbMoisPreavis()
  {
    return m_fluxAEInfra.getNbMoisPreavis_C_ERR();
  }
  
  public void setNbMoisPreavis(BigDecimal pValeur)
  {
    m_fluxAEInfra.setNbMoisPreavis(pValeur);
  }
  
  public void setCodeErreurNbMoisPreavis(String pCodeErreur)
  {
    m_fluxAEInfra.setNbMoisPreavis_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutPeriodeInactivite()
  {
    return m_fluxAEInfra.getDateDebutPeriodeInactivite();
  }
  
  public String getCodeErreurDateDebutPeriodeInactivite()
  {
    return m_fluxAEInfra.getDateDebutPeriodeInactivite_C_ERR();
  }
  
  public void setDateDebutPeriodeInactivite(Damj pValeur)
  {
    m_fluxAEInfra.setDateDebutPeriodeInactivite(pValeur);
  }
  
  public void setCodeErreurDateDebutPeriodeInactivite(String pCodeErreur)
  {
    m_fluxAEInfra.setDateDebutPeriodeInactivite_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinPeriodeInactivite()
  {
    return m_fluxAEInfra.getDateFinPeriodeInactivite();
  }
  
  public String getCodeErreurDateFinPeriodeInactivite()
  {
    return m_fluxAEInfra.getDateFinPeriodeInactivite_C_ERR();
  }
  
  public void setDateFinPeriodeInactivite(Damj pValeur)
  {
    m_fluxAEInfra.setDateFinPeriodeInactivite(pValeur);
  }
  
  public void setCodeErreurDateFinPeriodeInactivite(String pCodeErreur)
  {
    m_fluxAEInfra.setDateFinPeriodeInactivite_C_ERR(pCodeErreur);
  }
  
  public String getMotifPeriodeInactivite()
  {
    return m_fluxAEInfra.getMotifPeriodeInactivite();
  }
  
  public String getCodeErreurMotifPeriodeInactivite()
  {
    return m_fluxAEInfra.getMotifPeriodeInactivite_C_ERR();
  }
  
  public void setMotifPeriodeInactivite(String pValeur)
  {
    m_fluxAEInfra.setMotifPeriodeInactivite(pValeur);
  }
  
  public void setCodeErreurMotifPeriodeInactivite(String pCodeErreur)
  {
    m_fluxAEInfra.setMotifPeriodeInactivite_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutAGS()
  {
    return m_fluxAEInfra.getDateDebutAGS();
  }
  
  public String getCodeErreurDateDebutAGS()
  {
    return m_fluxAEInfra.getDateDebutAGS_C_ERR();
  }
  
  public void setDateDebutAGS(Damj pValeur)
  {
    m_fluxAEInfra.setDateDebutAGS(pValeur);
  }
  
  public void setCodeErreurDateDebutAGS(String pCodeErreur)
  {
    m_fluxAEInfra.setDateDebutAGS_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinAGS()
  {
    return m_fluxAEInfra.getDateFinAGS();
  }
  
  public String getCodeErreurDateFinAGS()
  {
    return m_fluxAEInfra.getDateFinAGS_C_ERR();
  }
  
  public void setDateFinAGS(Damj pValeur)
  {
    m_fluxAEInfra.setDateFinAGS(pValeur);
  }
  
  public void setCodeErreurDateFinAGS(String pCodeErreur)
  {
    m_fluxAEInfra.setDateFinAGS_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutAdhesionRevocable()
  {
    return m_fluxAEInfra.getDateDebutAdhesionRevocable();
  }
  
  public String getCodeErreurDateDebutAdhesionRevocable()
  {
    return m_fluxAEInfra.getDateDebutAdhesionRevocable_C_ERR();
  }
  
  public void setDateDebutAdhesionRevocable(Damj pValeur)
  {
    m_fluxAEInfra.setDateDebutAdhesionRevocable(pValeur);
  }
  
  public void setCodeErreurDateDebutAdhesionRevocable(String pCodeErreur)
  {
    m_fluxAEInfra.setDateDebutAdhesionRevocable_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinAdhesionRevocable()
  {
    return m_fluxAEInfra.getDateFinAdhesionRevocable();
  }
  
  public String getCodeErreurDateFinAdhesionRevocable()
  {
    return m_fluxAEInfra.getDateFinAdhesionRevocable_C_ERR();
  }
  
  public void setDateFinAdhesionRevocable(Damj pValeur)
  {
    m_fluxAEInfra.setDateFinAdhesionRevocable(pValeur);
  }
  
  public void setCodeErreurDateFinAdhesionRevocable(String pCodeErreur)
  {
    m_fluxAEInfra.setDateFinAdhesionRevocable_C_ERR(pCodeErreur);
  }
  
  public String getIdentiteDeclaree()
  {
    return m_fluxAEInfra.getIdentiteDeclaree();
  }
  
  public String getCodeErreurIdentiteDeclaree()
  {
    return m_fluxAEInfra.getIdentiteDeclaree_C_ERR();
  }
  
  public void setIdentiteDeclaree(String pValeur)
  {
    m_fluxAEInfra.setIdentiteDeclaree(pValeur);
  }
  
  public void setCodeErreurIdentiteDeclaree(String pCodeErreur)
  {
    m_fluxAEInfra.setIdentiteDeclaree_C_ERR(pCodeErreur);
  }
  
  public String getDoute()
  {
    return m_fluxAEInfra.getDoute();
  }
  
  public String getCodeErreurDoute()
  {
    return m_fluxAEInfra.getDoute_C_ERR();
  }
  
  public void setDoute(String pValeur)
  {
    m_fluxAEInfra.setDoute(pValeur);
  }
  
  public void setCodeErreurDoute(String pCodeErreur)
  {
    m_fluxAEInfra.setDoute_C_ERR(pCodeErreur);
  }
  
  public String getIdDocumentNumerique()
  {
    return m_fluxAEInfra.getIdDocumentNumerique();
  }
  
  public String getCodeErreurIdDocumentNumerique()
  {
    return m_fluxAEInfra.getIdDocumentNumerique_C_ERR();
  }
  
  public void setIdDocumentNumerique(String pValeur)
  {
    m_fluxAEInfra.setIdDocumentNumerique(pValeur);
  }
  
  public void setCodeErreurIdDocumentNumerique(String pCodeErreur)
  {
    m_fluxAEInfra.setIdDocumentNumerique_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getAncienneteMois()
  {
    return m_fluxAEInfra.getAncienneteMois();
  }
  
  public String getCodeErreurAncienneteMois()
  {
    return m_fluxAEInfra.getAncienneteMois_C_ERR();
  }
  
  public void setAncienneteMois(BigDecimal pValeur)
  {
    m_fluxAEInfra.setAncienneteMois(pValeur);
  }
  
  public void setCodeErreurAncienneteMois(String pCodeErreur)
  {
    m_fluxAEInfra.setAncienneteMois_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getAncienneteAnnee()
  {
    return m_fluxAEInfra.getAncienneteAnnee();
  }
  
  public String getCodeErreurAncienneteAnnee()
  {
    return m_fluxAEInfra.getAncienneteAnnee_C_ERR();
  }
  
  public void setAncienneteAnnee(BigDecimal pValeur)
  {
    m_fluxAEInfra.setAncienneteAnnee(pValeur);
  }
  
  public void setCodeErreurAncienneteAnnee(String pCodeErreur)
  {
    m_fluxAEInfra.setAncienneteAnnee_C_ERR(pCodeErreur);
  }
  
  public String getMotifRecours()
  {
    return m_fluxAEInfra.getMotifRecours();
  }
  
  public String getCodeErreurMotifRecours()
  {
    return m_fluxAEInfra.getMotifRecours_C_ERR();
  }
  
  public void setMotifRecours(String pValeur)
  {
    m_fluxAEInfra.setMotifRecours(pValeur);
  }
  
  public void setCodeErreurMotifRecours(String pCodeErreur)
  {
    m_fluxAEInfra.setMotifRecours_C_ERR(pCodeErreur);
  }
  
  public _FluxAE getFluxAEInfra()
  {
    return m_fluxAEInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objListeFluxFctDnaPreavis = getListeFluxFctDnaPreavis();
    if ((objListeFluxFctDnaPreavis != null) && 
      (getListeFluxFctDnaPreavis().isEnErreur())) {
      return true;
    }
    Object objListeFluxFctDnaIndemnitesVersees = getListeFluxFctDnaIndemnitesVersees();
    if ((objListeFluxFctDnaIndemnitesVersees != null) && 
      (getListeFluxFctDnaIndemnitesVersees().isEnErreur())) {
      return true;
    }
    Object objListeFluxPasDna = getListeFluxPasDna();
    if ((objListeFluxPasDna != null) && 
      (getListeFluxPasDna().isEnErreur())) {
      return true;
    }
    if ((getCodeErreurCodeMessage() != null) && 
      ("".equals(getCodeErreurCodeMessage()))) {
      return true;
    }
    if ((getCodeErreurCodeAction() != null) && 
      ("".equals(getCodeErreurCodeAction()))) {
      return true;
    }
    if ((getCodeErreurSIRET() != null) && 
      ("".equals(getCodeErreurSIRET()))) {
      return true;
    }
    if ((getCodeErreurReferenceContrat() != null) && 
      ("".equals(getCodeErreurReferenceContrat()))) {
      return true;
    }
    if ((getCodeErreurNatureContrat() != null) && 
      ("".equals(getCodeErreurNatureContrat()))) {
      return true;
    }
    if ((getCodeErreurMotifRupture() != null) && 
      ("".equals(getCodeErreurMotifRupture()))) {
      return true;
    }
    if ((getCodeErreurClauseNonConcurrence() != null) && 
      ("".equals(getCodeErreurClauseNonConcurrence()))) {
      return true;
    }
    if ((getCodeErreurRegimeSpecialSS() != null) && 
      ("".equals(getCodeErreurRegimeSpecialSS()))) {
      return true;
    }
    if ((getCodeErreurNumeroAffiRegimeSpecialSS() != null) && 
      ("".equals(getCodeErreurNumeroAffiRegimeSpecialSS()))) {
      return true;
    }
    if ((getCodeErreurLienParente() != null) && 
      ("".equals(getCodeErreurLienParente()))) {
      return true;
    }
    if ((getCodeErreurStatutParticulier() != null) && 
      ("".equals(getCodeErreurStatutParticulier()))) {
      return true;
    }
    if ((getCodeErreurNiveauQualif() != null) && 
      ("".equals(getCodeErreurNiveauQualif()))) {
      return true;
    }
    if ((getCodeErreurTopTransaction() != null) && 
      ("".equals(getCodeErreurTopTransaction()))) {
      return true;
    }
    if ((getCodeErreurBneIdentifiantBne() != null) && 
      ("".equals(getCodeErreurBneIdentifiantBne()))) {
      return true;
    }
    if ((getCodeErreurBneSiret() != null) && 
      ("".equals(getCodeErreurBneSiret()))) {
      return true;
    }
    if ((getCodeErreurBneRaisonSociale() != null) && 
      ("".equals(getCodeErreurBneRaisonSociale()))) {
      return true;
    }
    if ((getCodeErreurBneCodePostal() != null) && 
      ("".equals(getCodeErreurBneCodePostal()))) {
      return true;
    }
    if ((getCodeErreurBneLibelleCommuneCNAVTS() != null) && 
      ("".equals(getCodeErreurBneLibelleCommuneCNAVTS()))) {
      return true;
    }
    if ((getCodeErreurBneAssedicAffiliation() != null) && 
      ("".equals(getCodeErreurBneAssedicAffiliation()))) {
      return true;
    }
    if ((getCodeErreurBneNumAffiliation() != null) && 
      ("".equals(getCodeErreurBneNumAffiliation()))) {
      return true;
    }
    if ((getCodeErreurBneNouveauCodeNAF() != null) && 
      ("".equals(getCodeErreurBneNouveauCodeNAF()))) {
      return true;
    }
    if ((getCodeErreurAbonnementProvisoire() != null) && 
      ("".equals(getCodeErreurAbonnementProvisoire()))) {
      return true;
    }
    if ((getCodeErreurCodeRegimeCTP() != null) && 
      ("".equals(getCodeErreurCodeRegimeCTP()))) {
      return true;
    }
    if ((getCodeErreurNomEmployeur() != null) && 
      ("".equals(getCodeErreurNomEmployeur()))) {
      return true;
    }
    if ((getCodeErreurPrenomEmployeur() != null) && 
      ("".equals(getCodeErreurPrenomEmployeur()))) {
      return true;
    }
    if ((getCodeErreurNumUrssaf() != null) && 
      ("".equals(getCodeErreurNumUrssaf()))) {
      return true;
    }
    if ((getCodeErreurNumCESU() != null) && 
      ("".equals(getCodeErreurNumCESU()))) {
      return true;
    }
    if ((getCodeErreurNumPAJEEMPLOI() != null) && 
      ("".equals(getCodeErreurNumPAJEEMPLOI()))) {
      return true;
    }
    if ((getCodeErreurIdBNIRemplace() != null) && 
      ("".equals(getCodeErreurIdBNIRemplace()))) {
      return true;
    }
    if ((getCodeErreurOrigineAE() != null) && 
      ("".equals(getCodeErreurOrigineAE()))) {
      return true;
    }
    if ((getCodeErreurIndicChomSsRCT() != null) && 
      ("".equals(getCodeErreurIndicChomSsRCT()))) {
      return true;
    }
    if ((getCodeErreurRefusAdhesionFNE() != null) && 
      ("".equals(getCodeErreurRefusAdhesionFNE()))) {
      return true;
    }
    if ((getCodeErreurCodeStatutCadre() != null) && 
      ("".equals(getCodeErreurCodeStatutCadre()))) {
      return true;
    }
    if ((getCodeErreurCocheAlsaceMoselle() != null) && 
      ("".equals(getCodeErreurCocheAlsaceMoselle()))) {
      return true;
    }
    if ((getCodeErreurIndCotisationForfaitReel() != null) && 
      ("".equals(getCodeErreurIndCotisationForfaitReel()))) {
      return true;
    }
    if ((getCodeErreurIndBrutNet() != null) && 
      ("".equals(getCodeErreurIndBrutNet()))) {
      return true;
    }
    if ((getCodeErreurCodeCaisseCongesPayes() != null) && 
      ("".equals(getCodeErreurCodeCaisseCongesPayes()))) {
      return true;
    }
    if ((getCodeErreurNumCaisseCP() != null) && 
      ("".equals(getCodeErreurNumCaisseCP()))) {
      return true;
    }
    if ((getCodeErreurCodeARRCO() != null) && 
      ("".equals(getCodeErreurCodeARRCO()))) {
      return true;
    }
    if ((getCodeErreurNumBneARRCO() != null) && 
      ("".equals(getCodeErreurNumBneARRCO()))) {
      return true;
    }
    if ((getCodeErreurSigleARRCO() != null) && 
      ("".equals(getCodeErreurSigleARRCO()))) {
      return true;
    }
    if ((getCodeErreurRaisonSocialeARRCO() != null) && 
      ("".equals(getCodeErreurRaisonSocialeARRCO()))) {
      return true;
    }
    if ((getCodeErreurCodeAGIRC() != null) && 
      ("".equals(getCodeErreurCodeAGIRC()))) {
      return true;
    }
    if ((getCodeErreurNumBneAGIRC() != null) && 
      ("".equals(getCodeErreurNumBneAGIRC()))) {
      return true;
    }
    if ((getCodeErreurSigleAGIRC() != null) && 
      ("".equals(getCodeErreurSigleAGIRC()))) {
      return true;
    }
    if ((getCodeErreurRaisonSocialeAGIRC() != null) && 
      ("".equals(getCodeErreurRaisonSocialeAGIRC()))) {
      return true;
    }
    if ((getCodeErreurTypeContrat() != null) && 
      ("".equals(getCodeErreurTypeContrat()))) {
      return true;
    }
    if ((getCodeErreurCodeRegimeEmployeur() != null) && 
      ("".equals(getCodeErreurCodeRegimeEmployeur()))) {
      return true;
    }
    if ((getCodeErreurNumConventionGestion() != null) && 
      ("".equals(getCodeErreurNumConventionGestion()))) {
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
    if ((getCodeErreurIndicMontantIndemnite() != null) && 
      ("".equals(getCodeErreurIndicMontantIndemnite()))) {
      return true;
    }
    if ((getCodeErreurIndicSalaireHoraire() != null) && 
      ("".equals(getCodeErreurIndicSalaireHoraire()))) {
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
    if ((getCodeErreurEmployAutoAssur() != null) && 
      ("".equals(getCodeErreurEmployAutoAssur()))) {
      return true;
    }
    if ((getCodeErreurNumCG() != null) && 
      ("".equals(getCodeErreurNumCG()))) {
      return true;
    }
    if ((getCodeErreurEtabFinanc() != null) && 
      ("".equals(getCodeErreurEtabFinanc()))) {
      return true;
    }
    if ((getCodeErreurNumInterne() != null) && 
      ("".equals(getCodeErreurNumInterne()))) {
      return true;
    }
    if ((getCodeErreurCodeAffect() != null) && 
      ("".equals(getCodeErreurCodeAffect()))) {
      return true;
    }
    if ((getCodeErreurStatutSalarie() != null) && 
      ("".equals(getCodeErreurStatutSalarie()))) {
      return true;
    }
    if ((getCodeErreurCodeStatutjuridique() != null) && 
      ("".equals(getCodeErreurCodeStatutjuridique()))) {
      return true;
    }
    if ((getCodeErreurNomLogiciel() != null) && 
      ("".equals(getCodeErreurNomLogiciel()))) {
      return true;
    }
    if ((getCodeErreurVersionLogiciel() != null) && 
      ("".equals(getCodeErreurVersionLogiciel()))) {
      return true;
    }
    if ((getCodeErreurCategorieJuridiqueEntreprise() != null) && 
      ("".equals(getCodeErreurCategorieJuridiqueEntreprise()))) {
      return true;
    }
    if ((getCodeErreurCodeRegimeEntreprise() != null) && 
      ("".equals(getCodeErreurCodeRegimeEntreprise()))) {
      return true;
    }
    if ((getCodeErreurNatureEntreprise() != null) && 
      ("".equals(getCodeErreurNatureEntreprise()))) {
      return true;
    }
    if ((getCodeErreurNumGusoEntreprise() != null) && 
      ("".equals(getCodeErreurNumGusoEntreprise()))) {
      return true;
    }
    if ((getCodeErreurNumMSAEntreprise() != null) && 
      ("".equals(getCodeErreurNumMSAEntreprise()))) {
      return true;
    }
    if ((getCodeErreurEntreprisePublique() != null) && 
      ("".equals(getCodeErreurEntreprisePublique()))) {
      return true;
    }
    if ((getCodeErreurTrancheEffectifEntreprise() != null) && 
      ("".equals(getCodeErreurTrancheEffectifEntreprise()))) {
      return true;
    }
    if ((getCodeErreurDateDebutContrat() != null) && 
      ("".equals(getCodeErreurDateDebutContrat()))) {
      return true;
    }
    if ((getCodeErreurDateFinContrat() != null) && 
      ("".equals(getCodeErreurDateFinContrat()))) {
      return true;
    }
    if ((getCodeErreurDateNotifRupture() != null) && 
      ("".equals(getCodeErreurDateNotifRupture()))) {
      return true;
    }
    if ((getCodeErreurDateProcedureLicenciement() != null) && 
      ("".equals(getCodeErreurDateProcedureLicenciement()))) {
      return true;
    }
    if ((getCodeErreurDateDJTP() != null) && 
      ("".equals(getCodeErreurDateDJTP()))) {
      return true;
    }
    if ((getCodeErreurDateInitialeFinContrat() != null) && 
      ("".equals(getCodeErreurDateInitialeFinContrat()))) {
      return true;
    }
    if ((getCodeErreurDateConnaissanceAE() != null) && 
      ("".equals(getCodeErreurDateConnaissanceAE()))) {
      return true;
    }
    if ((getCodeErreurDateReprise() != null) && 
      ("".equals(getCodeErreurDateReprise()))) {
      return true;
    }
    if ((getCodeErreurDateDebutIndemCP() != null) && 
      ("".equals(getCodeErreurDateDebutIndemCP()))) {
      return true;
    }
    if ((getCodeErreurDateFinIndemCP() != null) && 
      ("".equals(getCodeErreurDateFinIndemCP()))) {
      return true;
    }
    if ((getCodeErreurDateEffetCTP() != null) && 
      ("".equals(getCodeErreurDateEffetCTP()))) {
      return true;
    }
    if ((getCodeErreurDateAdhesion() != null) && 
      ("".equals(getCodeErreurDateAdhesion()))) {
      return true;
    }
    if ((getCodeErreurDateCessationActiviteEntreprise() != null) && 
      ("".equals(getCodeErreurDateCessationActiviteEntreprise()))) {
      return true;
    }
    if ((getCodeErreurDateDebutPeriodeAffiliationEntreprise() != null) && 
      ("".equals(getCodeErreurDateDebutPeriodeAffiliationEntreprise()))) {
      return true;
    }
    if ((getCodeErreurDateFinPeriodeAffiliationEntreprise() != null) && 
      ("".equals(getCodeErreurDateFinPeriodeAffiliationEntreprise()))) {
      return true;
    }
    if ((getCodeErreurDateDebutEffetConGes() != null) && 
      ("".equals(getCodeErreurDateDebutEffetConGes()))) {
      return true;
    }
    if ((getCodeErreurDateFinEffetConGes() != null) && 
      ("".equals(getCodeErreurDateFinEffetConGes()))) {
      return true;
    }
    if ((getCodeErreurNumeroVersion() != null) && 
      ("".equals(getCodeErreurNumeroVersion()))) {
      return true;
    }
    if ((getCodeErreurIdTechContratDna() != null) && 
      ("".equals(getCodeErreurIdTechContratDna()))) {
      return true;
    }
    if ((getCodeErreurNbCongesPayesRestant() != null) && 
      ("".equals(getCodeErreurNbCongesPayesRestant()))) {
      return true;
    }
    if ((getCodeErreurMontantIndemnitePreavis() != null) && 
      ("".equals(getCodeErreurMontantIndemnitePreavis()))) {
      return true;
    }
    if ((getCodeErreurNbHeuresDIF() != null) && 
      ("".equals(getCodeErreurNbHeuresDIF()))) {
      return true;
    }
    if ((getCodeErreurSalaireHoraireNetSalarie() != null) && 
      ("".equals(getCodeErreurSalaireHoraireNetSalarie()))) {
      return true;
    }
    if ((getCodeErreurIdTechContratRemplace() != null) && 
      ("".equals(getCodeErreurIdTechContratRemplace()))) {
      return true;
    }
    if ((getCodeErreurNbPAS() != null) && 
      ("".equals(getCodeErreurNbPAS()))) {
      return true;
    }
    if ((getCodeErreurNbSalariesEntreprise() != null) && 
      ("".equals(getCodeErreurNbSalariesEntreprise()))) {
      return true;
    }
    if ((getCodeErreurNbMoisPreavis() != null) && 
      ("".equals(getCodeErreurNbMoisPreavis()))) {
      return true;
    }
    if ((getCodeErreurDateDebutPeriodeInactivite() != null) && 
      ("".equals(getCodeErreurDateDebutPeriodeInactivite()))) {
      return true;
    }
    if ((getCodeErreurDateFinPeriodeInactivite() != null) && 
      ("".equals(getCodeErreurDateFinPeriodeInactivite()))) {
      return true;
    }
    if ((getCodeErreurMotifPeriodeInactivite() != null) && 
      ("".equals(getCodeErreurMotifPeriodeInactivite()))) {
      return true;
    }
    if ((getCodeErreurDateDebutAGS() != null) && 
      ("".equals(getCodeErreurDateDebutAGS()))) {
      return true;
    }
    if ((getCodeErreurDateFinAGS() != null) && 
      ("".equals(getCodeErreurDateFinAGS()))) {
      return true;
    }
    if ((getCodeErreurDateDebutAdhesionRevocable() != null) && 
      ("".equals(getCodeErreurDateDebutAdhesionRevocable()))) {
      return true;
    }
    if ((getCodeErreurDateFinAdhesionRevocable() != null) && 
      ("".equals(getCodeErreurDateFinAdhesionRevocable()))) {
      return true;
    }
    if ((getCodeErreurIdentiteDeclaree() != null) && 
      ("".equals(getCodeErreurIdentiteDeclaree()))) {
      return true;
    }
    if ((getCodeErreurDoute() != null) && 
      ("".equals(getCodeErreurDoute()))) {
      return true;
    }
    if ((getCodeErreurIdDocumentNumerique() != null) && 
      ("".equals(getCodeErreurIdDocumentNumerique()))) {
      return true;
    }
    if ((getCodeErreurAncienneteMois() != null) && 
      ("".equals(getCodeErreurAncienneteMois()))) {
      return true;
    }
    if ((getCodeErreurAncienneteAnnee() != null) && 
      ("".equals(getCodeErreurAncienneteAnnee()))) {
      return true;
    }
    if ((getCodeErreurMotifRecours() != null) && 
      ("".equals(getCodeErreurMotifRecours()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxAEImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */