package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxFctDnaImpl
  extends FluxFctDna
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxFctDna m_fluxFctDnaInfra;
  
  public _FluxFctDnaImpl()
  {
    m_fluxFctDnaInfra = new _FluxFctDna();
  }
  
  public _FluxFctDnaImpl(_FluxFctDna pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxFctDnaInfra", pValeur);
    
    m_fluxFctDnaInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxFctDnaInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxFctDnaInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxFctDnaInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxFctDnaInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxFctDnaInfra.set_C_ETAT(pCode);
  }
  
  public ListeFluxFctDnaPreavis getListeFluxFctDnaPreavis()
  {
    _ListeFluxFctDnaPreavis infraItem = m_fluxFctDnaInfra.getListeFluxFctDnaPreavis();
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
      m_fluxFctDnaInfra.setListeFluxFctDnaPreavis(null);
    }
    else
    {
      _ListeFluxFctDnaPreavisImpl subImpl = (_ListeFluxFctDnaPreavisImpl)pValeur;
      m_fluxFctDnaInfra.setListeFluxFctDnaPreavis(subImpl.getListeFluxFctDnaPreavisInfra());
    }
  }
  
  public ListeFluxFctDnaPreavis setNewListeFluxFctDnaPreavis()
  {
    _ListeFluxFctDnaPreavisImpl item = new _ListeFluxFctDnaPreavisImpl();
    m_fluxFctDnaInfra.setListeFluxFctDnaPreavis(item.getListeFluxFctDnaPreavisInfra());
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
    _ListeFluxFctDnaIndemnitesVersees infraItem = m_fluxFctDnaInfra.getListeFluxFctDnaIndemnitesVersees();
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
      m_fluxFctDnaInfra.setListeFluxFctDnaIndemnitesVersees(null);
    }
    else
    {
      _ListeFluxFctDnaIndemnitesVerseesImpl subImpl = (_ListeFluxFctDnaIndemnitesVerseesImpl)pValeur;
      m_fluxFctDnaInfra.setListeFluxFctDnaIndemnitesVersees(subImpl.getListeFluxFctDnaIndemnitesVerseesInfra());
    }
  }
  
  public ListeFluxFctDnaIndemnitesVersees setNewListeFluxFctDnaIndemnitesVersees()
  {
    _ListeFluxFctDnaIndemnitesVerseesImpl item = new _ListeFluxFctDnaIndemnitesVerseesImpl();
    m_fluxFctDnaInfra.setListeFluxFctDnaIndemnitesVersees(item.getListeFluxFctDnaIndemnitesVerseesInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeFluxFctDnaIndemnitesVersees setNewListeFluxFctDnaIndemnitesVersees_listeFluxFctDnaIndemnitesVersees()
  {
    return setNewListeFluxFctDnaIndemnitesVersees();
  }
  
  public String getCodeMessage()
  {
    return m_fluxFctDnaInfra.getCodeMessage();
  }
  
  public String getCodeErreurCodeMessage()
  {
    return m_fluxFctDnaInfra.getCodeMessage_C_ERR();
  }
  
  public void setCodeMessage(String pValeur)
  {
    m_fluxFctDnaInfra.setCodeMessage(pValeur);
  }
  
  public void setCodeErreurCodeMessage(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setCodeMessage_C_ERR(pCodeErreur);
  }
  
  public String getCodeAction()
  {
    return m_fluxFctDnaInfra.getCodeAction();
  }
  
  public String getCodeErreurCodeAction()
  {
    return m_fluxFctDnaInfra.getCodeAction_C_ERR();
  }
  
  public void setCodeAction(String pValeur)
  {
    m_fluxFctDnaInfra.setCodeAction(pValeur);
  }
  
  public void setCodeErreurCodeAction(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setCodeAction_C_ERR(pCodeErreur);
  }
  
  public String getSIRET()
  {
    return m_fluxFctDnaInfra.getSIRET();
  }
  
  public String getCodeErreurSIRET()
  {
    return m_fluxFctDnaInfra.getSIRET_C_ERR();
  }
  
  public void setSIRET(String pValeur)
  {
    m_fluxFctDnaInfra.setSIRET(pValeur);
  }
  
  public void setCodeErreurSIRET(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setSIRET_C_ERR(pCodeErreur);
  }
  
  public String getReferenceContrat()
  {
    return m_fluxFctDnaInfra.getReferenceContrat();
  }
  
  public String getCodeErreurReferenceContrat()
  {
    return m_fluxFctDnaInfra.getReferenceContrat_C_ERR();
  }
  
  public void setReferenceContrat(String pValeur)
  {
    m_fluxFctDnaInfra.setReferenceContrat(pValeur);
  }
  
  public void setCodeErreurReferenceContrat(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setReferenceContrat_C_ERR(pCodeErreur);
  }
  
  public String getNatureContrat()
  {
    return m_fluxFctDnaInfra.getNatureContrat();
  }
  
  public String getCodeErreurNatureContrat()
  {
    return m_fluxFctDnaInfra.getNatureContrat_C_ERR();
  }
  
  public void setNatureContrat(String pValeur)
  {
    m_fluxFctDnaInfra.setNatureContrat(pValeur);
  }
  
  public void setCodeErreurNatureContrat(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNatureContrat_C_ERR(pCodeErreur);
  }
  
  public String getMotifRupture()
  {
    return m_fluxFctDnaInfra.getMotifRupture();
  }
  
  public String getCodeErreurMotifRupture()
  {
    return m_fluxFctDnaInfra.getMotifRupture_C_ERR();
  }
  
  public void setMotifRupture(String pValeur)
  {
    m_fluxFctDnaInfra.setMotifRupture(pValeur);
  }
  
  public void setCodeErreurMotifRupture(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setMotifRupture_C_ERR(pCodeErreur);
  }
  
  public String getClauseNonConcurrence()
  {
    return m_fluxFctDnaInfra.getClauseNonConcurrence();
  }
  
  public String getCodeErreurClauseNonConcurrence()
  {
    return m_fluxFctDnaInfra.getClauseNonConcurrence_C_ERR();
  }
  
  public void setClauseNonConcurrence(String pValeur)
  {
    m_fluxFctDnaInfra.setClauseNonConcurrence(pValeur);
  }
  
  public void setCodeErreurClauseNonConcurrence(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setClauseNonConcurrence_C_ERR(pCodeErreur);
  }
  
  public String getRegimeSpecialSS()
  {
    return m_fluxFctDnaInfra.getRegimeSpecialSS();
  }
  
  public String getCodeErreurRegimeSpecialSS()
  {
    return m_fluxFctDnaInfra.getRegimeSpecialSS_C_ERR();
  }
  
  public void setRegimeSpecialSS(String pValeur)
  {
    m_fluxFctDnaInfra.setRegimeSpecialSS(pValeur);
  }
  
  public void setCodeErreurRegimeSpecialSS(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setRegimeSpecialSS_C_ERR(pCodeErreur);
  }
  
  public String getNumeroAffiRegimeSpecialSS()
  {
    return m_fluxFctDnaInfra.getNumeroAffiRegimeSpecialSS();
  }
  
  public String getCodeErreurNumeroAffiRegimeSpecialSS()
  {
    return m_fluxFctDnaInfra.getNumeroAffiRegimeSpecialSS_C_ERR();
  }
  
  public void setNumeroAffiRegimeSpecialSS(String pValeur)
  {
    m_fluxFctDnaInfra.setNumeroAffiRegimeSpecialSS(pValeur);
  }
  
  public void setCodeErreurNumeroAffiRegimeSpecialSS(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNumeroAffiRegimeSpecialSS_C_ERR(pCodeErreur);
  }
  
  public String getLienParente()
  {
    return m_fluxFctDnaInfra.getLienParente();
  }
  
  public String getCodeErreurLienParente()
  {
    return m_fluxFctDnaInfra.getLienParente_C_ERR();
  }
  
  public void setLienParente(String pValeur)
  {
    m_fluxFctDnaInfra.setLienParente(pValeur);
  }
  
  public void setCodeErreurLienParente(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setLienParente_C_ERR(pCodeErreur);
  }
  
  public String getStatutParticulier()
  {
    return m_fluxFctDnaInfra.getStatutParticulier();
  }
  
  public String getCodeErreurStatutParticulier()
  {
    return m_fluxFctDnaInfra.getStatutParticulier_C_ERR();
  }
  
  public void setStatutParticulier(String pValeur)
  {
    m_fluxFctDnaInfra.setStatutParticulier(pValeur);
  }
  
  public void setCodeErreurStatutParticulier(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setStatutParticulier_C_ERR(pCodeErreur);
  }
  
  public String getNiveauQualif()
  {
    return m_fluxFctDnaInfra.getNiveauQualif();
  }
  
  public String getCodeErreurNiveauQualif()
  {
    return m_fluxFctDnaInfra.getNiveauQualif_C_ERR();
  }
  
  public void setNiveauQualif(String pValeur)
  {
    m_fluxFctDnaInfra.setNiveauQualif(pValeur);
  }
  
  public void setCodeErreurNiveauQualif(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNiveauQualif_C_ERR(pCodeErreur);
  }
  
  public String getTopTransaction()
  {
    return m_fluxFctDnaInfra.getTopTransaction();
  }
  
  public String getCodeErreurTopTransaction()
  {
    return m_fluxFctDnaInfra.getTopTransaction_C_ERR();
  }
  
  public void setTopTransaction(String pValeur)
  {
    m_fluxFctDnaInfra.setTopTransaction(pValeur);
  }
  
  public void setCodeErreurTopTransaction(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setTopTransaction_C_ERR(pCodeErreur);
  }
  
  public String getBneIdentifiantBne()
  {
    return m_fluxFctDnaInfra.getBneIdentifiantBne();
  }
  
  public String getCodeErreurBneIdentifiantBne()
  {
    return m_fluxFctDnaInfra.getBneIdentifiantBne_C_ERR();
  }
  
  public void setBneIdentifiantBne(String pValeur)
  {
    m_fluxFctDnaInfra.setBneIdentifiantBne(pValeur);
  }
  
  public void setCodeErreurBneIdentifiantBne(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setBneIdentifiantBne_C_ERR(pCodeErreur);
  }
  
  public String getBneSiret()
  {
    return m_fluxFctDnaInfra.getBneSiret();
  }
  
  public String getCodeErreurBneSiret()
  {
    return m_fluxFctDnaInfra.getBneSiret_C_ERR();
  }
  
  public void setBneSiret(String pValeur)
  {
    m_fluxFctDnaInfra.setBneSiret(pValeur);
  }
  
  public void setCodeErreurBneSiret(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setBneSiret_C_ERR(pCodeErreur);
  }
  
  public String getBneRaisonSociale()
  {
    return m_fluxFctDnaInfra.getBneRaisonSociale();
  }
  
  public String getCodeErreurBneRaisonSociale()
  {
    return m_fluxFctDnaInfra.getBneRaisonSociale_C_ERR();
  }
  
  public void setBneRaisonSociale(String pValeur)
  {
    m_fluxFctDnaInfra.setBneRaisonSociale(pValeur);
  }
  
  public void setCodeErreurBneRaisonSociale(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setBneRaisonSociale_C_ERR(pCodeErreur);
  }
  
  public String getBneCodePostal()
  {
    return m_fluxFctDnaInfra.getBneCodePostal();
  }
  
  public String getCodeErreurBneCodePostal()
  {
    return m_fluxFctDnaInfra.getBneCodePostal_C_ERR();
  }
  
  public void setBneCodePostal(String pValeur)
  {
    m_fluxFctDnaInfra.setBneCodePostal(pValeur);
  }
  
  public void setCodeErreurBneCodePostal(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setBneCodePostal_C_ERR(pCodeErreur);
  }
  
  public String getBneLibelleCommuneCNAVTS()
  {
    return m_fluxFctDnaInfra.getBneLibelleCommuneCNAVTS();
  }
  
  public String getCodeErreurBneLibelleCommuneCNAVTS()
  {
    return m_fluxFctDnaInfra.getBneLibelleCommuneCNAVTS_C_ERR();
  }
  
  public void setBneLibelleCommuneCNAVTS(String pValeur)
  {
    m_fluxFctDnaInfra.setBneLibelleCommuneCNAVTS(pValeur);
  }
  
  public void setCodeErreurBneLibelleCommuneCNAVTS(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setBneLibelleCommuneCNAVTS_C_ERR(pCodeErreur);
  }
  
  public String getBneAssedicAffiliation()
  {
    return m_fluxFctDnaInfra.getBneAssedicAffiliation();
  }
  
  public String getCodeErreurBneAssedicAffiliation()
  {
    return m_fluxFctDnaInfra.getBneAssedicAffiliation_C_ERR();
  }
  
  public void setBneAssedicAffiliation(String pValeur)
  {
    m_fluxFctDnaInfra.setBneAssedicAffiliation(pValeur);
  }
  
  public void setCodeErreurBneAssedicAffiliation(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setBneAssedicAffiliation_C_ERR(pCodeErreur);
  }
  
  public String getBneNumAffiliation()
  {
    return m_fluxFctDnaInfra.getBneNumAffiliation();
  }
  
  public String getCodeErreurBneNumAffiliation()
  {
    return m_fluxFctDnaInfra.getBneNumAffiliation_C_ERR();
  }
  
  public void setBneNumAffiliation(String pValeur)
  {
    m_fluxFctDnaInfra.setBneNumAffiliation(pValeur);
  }
  
  public void setCodeErreurBneNumAffiliation(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setBneNumAffiliation_C_ERR(pCodeErreur);
  }
  
  public String getBneNouveauCodeNAF()
  {
    return m_fluxFctDnaInfra.getBneNouveauCodeNAF();
  }
  
  public String getCodeErreurBneNouveauCodeNAF()
  {
    return m_fluxFctDnaInfra.getBneNouveauCodeNAF_C_ERR();
  }
  
  public void setBneNouveauCodeNAF(String pValeur)
  {
    m_fluxFctDnaInfra.setBneNouveauCodeNAF(pValeur);
  }
  
  public void setCodeErreurBneNouveauCodeNAF(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setBneNouveauCodeNAF_C_ERR(pCodeErreur);
  }
  
  public String getAbonnementProvisoire()
  {
    return m_fluxFctDnaInfra.getAbonnementProvisoire();
  }
  
  public String getCodeErreurAbonnementProvisoire()
  {
    return m_fluxFctDnaInfra.getAbonnementProvisoire_C_ERR();
  }
  
  public void setAbonnementProvisoire(String pValeur)
  {
    m_fluxFctDnaInfra.setAbonnementProvisoire(pValeur);
  }
  
  public void setCodeErreurAbonnementProvisoire(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setAbonnementProvisoire_C_ERR(pCodeErreur);
  }
  
  public String getCodeRegimeCTP()
  {
    return m_fluxFctDnaInfra.getCodeRegimeCTP();
  }
  
  public String getCodeErreurCodeRegimeCTP()
  {
    return m_fluxFctDnaInfra.getCodeRegimeCTP_C_ERR();
  }
  
  public void setCodeRegimeCTP(String pValeur)
  {
    m_fluxFctDnaInfra.setCodeRegimeCTP(pValeur);
  }
  
  public void setCodeErreurCodeRegimeCTP(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setCodeRegimeCTP_C_ERR(pCodeErreur);
  }
  
  public String getNomEmployeur()
  {
    return m_fluxFctDnaInfra.getNomEmployeur();
  }
  
  public String getCodeErreurNomEmployeur()
  {
    return m_fluxFctDnaInfra.getNomEmployeur_C_ERR();
  }
  
  public void setNomEmployeur(String pValeur)
  {
    m_fluxFctDnaInfra.setNomEmployeur(pValeur);
  }
  
  public void setCodeErreurNomEmployeur(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNomEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getPrenomEmployeur()
  {
    return m_fluxFctDnaInfra.getPrenomEmployeur();
  }
  
  public String getCodeErreurPrenomEmployeur()
  {
    return m_fluxFctDnaInfra.getPrenomEmployeur_C_ERR();
  }
  
  public void setPrenomEmployeur(String pValeur)
  {
    m_fluxFctDnaInfra.setPrenomEmployeur(pValeur);
  }
  
  public void setCodeErreurPrenomEmployeur(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setPrenomEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getNumUrssaf()
  {
    return m_fluxFctDnaInfra.getNumUrssaf();
  }
  
  public String getCodeErreurNumUrssaf()
  {
    return m_fluxFctDnaInfra.getNumUrssaf_C_ERR();
  }
  
  public void setNumUrssaf(String pValeur)
  {
    m_fluxFctDnaInfra.setNumUrssaf(pValeur);
  }
  
  public void setCodeErreurNumUrssaf(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNumUrssaf_C_ERR(pCodeErreur);
  }
  
  public String getNumCESU()
  {
    return m_fluxFctDnaInfra.getNumCESU();
  }
  
  public String getCodeErreurNumCESU()
  {
    return m_fluxFctDnaInfra.getNumCESU_C_ERR();
  }
  
  public void setNumCESU(String pValeur)
  {
    m_fluxFctDnaInfra.setNumCESU(pValeur);
  }
  
  public void setCodeErreurNumCESU(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNumCESU_C_ERR(pCodeErreur);
  }
  
  public String getNumPAJEEMPLOI()
  {
    return m_fluxFctDnaInfra.getNumPAJEEMPLOI();
  }
  
  public String getCodeErreurNumPAJEEMPLOI()
  {
    return m_fluxFctDnaInfra.getNumPAJEEMPLOI_C_ERR();
  }
  
  public void setNumPAJEEMPLOI(String pValeur)
  {
    m_fluxFctDnaInfra.setNumPAJEEMPLOI(pValeur);
  }
  
  public void setCodeErreurNumPAJEEMPLOI(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNumPAJEEMPLOI_C_ERR(pCodeErreur);
  }
  
  public String getIdBNIRemplace()
  {
    return m_fluxFctDnaInfra.getIdBNIRemplace();
  }
  
  public String getCodeErreurIdBNIRemplace()
  {
    return m_fluxFctDnaInfra.getIdBNIRemplace_C_ERR();
  }
  
  public void setIdBNIRemplace(String pValeur)
  {
    m_fluxFctDnaInfra.setIdBNIRemplace(pValeur);
  }
  
  public void setCodeErreurIdBNIRemplace(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setIdBNIRemplace_C_ERR(pCodeErreur);
  }
  
  public String getOrigineAE()
  {
    return m_fluxFctDnaInfra.getOrigineAE();
  }
  
  public String getCodeErreurOrigineAE()
  {
    return m_fluxFctDnaInfra.getOrigineAE_C_ERR();
  }
  
  public void setOrigineAE(String pValeur)
  {
    m_fluxFctDnaInfra.setOrigineAE(pValeur);
  }
  
  public void setCodeErreurOrigineAE(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setOrigineAE_C_ERR(pCodeErreur);
  }
  
  public String getIndicChomSsRCT()
  {
    return m_fluxFctDnaInfra.getIndicChomSsRCT();
  }
  
  public String getCodeErreurIndicChomSsRCT()
  {
    return m_fluxFctDnaInfra.getIndicChomSsRCT_C_ERR();
  }
  
  public void setIndicChomSsRCT(String pValeur)
  {
    m_fluxFctDnaInfra.setIndicChomSsRCT(pValeur);
  }
  
  public void setCodeErreurIndicChomSsRCT(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setIndicChomSsRCT_C_ERR(pCodeErreur);
  }
  
  public String getRefusAdhesionFNE()
  {
    return m_fluxFctDnaInfra.getRefusAdhesionFNE();
  }
  
  public String getCodeErreurRefusAdhesionFNE()
  {
    return m_fluxFctDnaInfra.getRefusAdhesionFNE_C_ERR();
  }
  
  public void setRefusAdhesionFNE(String pValeur)
  {
    m_fluxFctDnaInfra.setRefusAdhesionFNE(pValeur);
  }
  
  public void setCodeErreurRefusAdhesionFNE(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setRefusAdhesionFNE_C_ERR(pCodeErreur);
  }
  
  public String getCodeStatutCadre()
  {
    return m_fluxFctDnaInfra.getCodeStatutCadre();
  }
  
  public String getCodeErreurCodeStatutCadre()
  {
    return m_fluxFctDnaInfra.getCodeStatutCadre_C_ERR();
  }
  
  public void setCodeStatutCadre(String pValeur)
  {
    m_fluxFctDnaInfra.setCodeStatutCadre(pValeur);
  }
  
  public void setCodeErreurCodeStatutCadre(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setCodeStatutCadre_C_ERR(pCodeErreur);
  }
  
  public String getCocheAlsaceMoselle()
  {
    return m_fluxFctDnaInfra.getCocheAlsaceMoselle();
  }
  
  public String getCodeErreurCocheAlsaceMoselle()
  {
    return m_fluxFctDnaInfra.getCocheAlsaceMoselle_C_ERR();
  }
  
  public void setCocheAlsaceMoselle(String pValeur)
  {
    m_fluxFctDnaInfra.setCocheAlsaceMoselle(pValeur);
  }
  
  public void setCodeErreurCocheAlsaceMoselle(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setCocheAlsaceMoselle_C_ERR(pCodeErreur);
  }
  
  public String getIndCotisationForfaitReel()
  {
    return m_fluxFctDnaInfra.getIndCotisationForfaitReel();
  }
  
  public String getCodeErreurIndCotisationForfaitReel()
  {
    return m_fluxFctDnaInfra.getIndCotisationForfaitReel_C_ERR();
  }
  
  public void setIndCotisationForfaitReel(String pValeur)
  {
    m_fluxFctDnaInfra.setIndCotisationForfaitReel(pValeur);
  }
  
  public void setCodeErreurIndCotisationForfaitReel(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setIndCotisationForfaitReel_C_ERR(pCodeErreur);
  }
  
  public String getIndBrutNet()
  {
    return m_fluxFctDnaInfra.getIndBrutNet();
  }
  
  public String getCodeErreurIndBrutNet()
  {
    return m_fluxFctDnaInfra.getIndBrutNet_C_ERR();
  }
  
  public void setIndBrutNet(String pValeur)
  {
    m_fluxFctDnaInfra.setIndBrutNet(pValeur);
  }
  
  public void setCodeErreurIndBrutNet(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setIndBrutNet_C_ERR(pCodeErreur);
  }
  
  public String getCodeCaisseCongesPayes()
  {
    return m_fluxFctDnaInfra.getCodeCaisseCongesPayes();
  }
  
  public String getCodeErreurCodeCaisseCongesPayes()
  {
    return m_fluxFctDnaInfra.getCodeCaisseCongesPayes_C_ERR();
  }
  
  public void setCodeCaisseCongesPayes(String pValeur)
  {
    m_fluxFctDnaInfra.setCodeCaisseCongesPayes(pValeur);
  }
  
  public void setCodeErreurCodeCaisseCongesPayes(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setCodeCaisseCongesPayes_C_ERR(pCodeErreur);
  }
  
  public String getNumCaisseCP()
  {
    return m_fluxFctDnaInfra.getNumCaisseCP();
  }
  
  public String getCodeErreurNumCaisseCP()
  {
    return m_fluxFctDnaInfra.getNumCaisseCP_C_ERR();
  }
  
  public void setNumCaisseCP(String pValeur)
  {
    m_fluxFctDnaInfra.setNumCaisseCP(pValeur);
  }
  
  public void setCodeErreurNumCaisseCP(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNumCaisseCP_C_ERR(pCodeErreur);
  }
  
  public String getCodeARRCO()
  {
    return m_fluxFctDnaInfra.getCodeARRCO();
  }
  
  public String getCodeErreurCodeARRCO()
  {
    return m_fluxFctDnaInfra.getCodeARRCO_C_ERR();
  }
  
  public void setCodeARRCO(String pValeur)
  {
    m_fluxFctDnaInfra.setCodeARRCO(pValeur);
  }
  
  public void setCodeErreurCodeARRCO(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setCodeARRCO_C_ERR(pCodeErreur);
  }
  
  public String getNumBneARRCO()
  {
    return m_fluxFctDnaInfra.getNumBneARRCO();
  }
  
  public String getCodeErreurNumBneARRCO()
  {
    return m_fluxFctDnaInfra.getNumBneARRCO_C_ERR();
  }
  
  public void setNumBneARRCO(String pValeur)
  {
    m_fluxFctDnaInfra.setNumBneARRCO(pValeur);
  }
  
  public void setCodeErreurNumBneARRCO(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNumBneARRCO_C_ERR(pCodeErreur);
  }
  
  public String getSigleARRCO()
  {
    return m_fluxFctDnaInfra.getSigleARRCO();
  }
  
  public String getCodeErreurSigleARRCO()
  {
    return m_fluxFctDnaInfra.getSigleARRCO_C_ERR();
  }
  
  public void setSigleARRCO(String pValeur)
  {
    m_fluxFctDnaInfra.setSigleARRCO(pValeur);
  }
  
  public void setCodeErreurSigleARRCO(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setSigleARRCO_C_ERR(pCodeErreur);
  }
  
  public String getRaisonSocialeARRCO()
  {
    return m_fluxFctDnaInfra.getRaisonSocialeARRCO();
  }
  
  public String getCodeErreurRaisonSocialeARRCO()
  {
    return m_fluxFctDnaInfra.getRaisonSocialeARRCO_C_ERR();
  }
  
  public void setRaisonSocialeARRCO(String pValeur)
  {
    m_fluxFctDnaInfra.setRaisonSocialeARRCO(pValeur);
  }
  
  public void setCodeErreurRaisonSocialeARRCO(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setRaisonSocialeARRCO_C_ERR(pCodeErreur);
  }
  
  public String getCodeAGIRC()
  {
    return m_fluxFctDnaInfra.getCodeAGIRC();
  }
  
  public String getCodeErreurCodeAGIRC()
  {
    return m_fluxFctDnaInfra.getCodeAGIRC_C_ERR();
  }
  
  public void setCodeAGIRC(String pValeur)
  {
    m_fluxFctDnaInfra.setCodeAGIRC(pValeur);
  }
  
  public void setCodeErreurCodeAGIRC(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setCodeAGIRC_C_ERR(pCodeErreur);
  }
  
  public String getNumBneAGIRC()
  {
    return m_fluxFctDnaInfra.getNumBneAGIRC();
  }
  
  public String getCodeErreurNumBneAGIRC()
  {
    return m_fluxFctDnaInfra.getNumBneAGIRC_C_ERR();
  }
  
  public void setNumBneAGIRC(String pValeur)
  {
    m_fluxFctDnaInfra.setNumBneAGIRC(pValeur);
  }
  
  public void setCodeErreurNumBneAGIRC(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNumBneAGIRC_C_ERR(pCodeErreur);
  }
  
  public String getSigleAGIRC()
  {
    return m_fluxFctDnaInfra.getSigleAGIRC();
  }
  
  public String getCodeErreurSigleAGIRC()
  {
    return m_fluxFctDnaInfra.getSigleAGIRC_C_ERR();
  }
  
  public void setSigleAGIRC(String pValeur)
  {
    m_fluxFctDnaInfra.setSigleAGIRC(pValeur);
  }
  
  public void setCodeErreurSigleAGIRC(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setSigleAGIRC_C_ERR(pCodeErreur);
  }
  
  public String getRaisonSocialeAGIRC()
  {
    return m_fluxFctDnaInfra.getRaisonSocialeAGIRC();
  }
  
  public String getCodeErreurRaisonSocialeAGIRC()
  {
    return m_fluxFctDnaInfra.getRaisonSocialeAGIRC_C_ERR();
  }
  
  public void setRaisonSocialeAGIRC(String pValeur)
  {
    m_fluxFctDnaInfra.setRaisonSocialeAGIRC(pValeur);
  }
  
  public void setCodeErreurRaisonSocialeAGIRC(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setRaisonSocialeAGIRC_C_ERR(pCodeErreur);
  }
  
  public String getTypeContrat()
  {
    return m_fluxFctDnaInfra.getTypeContrat();
  }
  
  public String getCodeErreurTypeContrat()
  {
    return m_fluxFctDnaInfra.getTypeContrat_C_ERR();
  }
  
  public void setTypeContrat(String pValeur)
  {
    m_fluxFctDnaInfra.setTypeContrat(pValeur);
  }
  
  public void setCodeErreurTypeContrat(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setTypeContrat_C_ERR(pCodeErreur);
  }
  
  public String getCodeRegimeEmployeur()
  {
    return m_fluxFctDnaInfra.getCodeRegimeEmployeur();
  }
  
  public String getCodeErreurCodeRegimeEmployeur()
  {
    return m_fluxFctDnaInfra.getCodeRegimeEmployeur_C_ERR();
  }
  
  public void setCodeRegimeEmployeur(String pValeur)
  {
    m_fluxFctDnaInfra.setCodeRegimeEmployeur(pValeur);
  }
  
  public void setCodeErreurCodeRegimeEmployeur(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setCodeRegimeEmployeur_C_ERR(pCodeErreur);
  }
  
  public String getNumConventionGestion()
  {
    return m_fluxFctDnaInfra.getNumConventionGestion();
  }
  
  public String getCodeErreurNumConventionGestion()
  {
    return m_fluxFctDnaInfra.getNumConventionGestion_C_ERR();
  }
  
  public void setNumConventionGestion(String pValeur)
  {
    m_fluxFctDnaInfra.setNumConventionGestion(pValeur);
  }
  
  public void setCodeErreurNumConventionGestion(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNumConventionGestion_C_ERR(pCodeErreur);
  }
  
  public String getNomFamille()
  {
    return m_fluxFctDnaInfra.getNomFamille();
  }
  
  public String getCodeErreurNomFamille()
  {
    return m_fluxFctDnaInfra.getNomFamille_C_ERR();
  }
  
  public void setNomFamille(String pValeur)
  {
    m_fluxFctDnaInfra.setNomFamille(pValeur);
  }
  
  public void setCodeErreurNomFamille(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNomFamille_C_ERR(pCodeErreur);
  }
  
  public String getPrenom()
  {
    return m_fluxFctDnaInfra.getPrenom();
  }
  
  public String getCodeErreurPrenom()
  {
    return m_fluxFctDnaInfra.getPrenom_C_ERR();
  }
  
  public void setPrenom(String pValeur)
  {
    m_fluxFctDnaInfra.setPrenom(pValeur);
  }
  
  public void setCodeErreurPrenom(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setPrenom_C_ERR(pCodeErreur);
  }
  
  public String getIndicMontantIndemnite()
  {
    return m_fluxFctDnaInfra.getIndicMontantIndemnite();
  }
  
  public String getCodeErreurIndicMontantIndemnite()
  {
    return m_fluxFctDnaInfra.getIndicMontantIndemnite_C_ERR();
  }
  
  public void setIndicMontantIndemnite(String pValeur)
  {
    m_fluxFctDnaInfra.setIndicMontantIndemnite(pValeur);
  }
  
  public void setCodeErreurIndicMontantIndemnite(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setIndicMontantIndemnite_C_ERR(pCodeErreur);
  }
  
  public String getIndicSalaireHoraire()
  {
    return m_fluxFctDnaInfra.getIndicSalaireHoraire();
  }
  
  public String getCodeErreurIndicSalaireHoraire()
  {
    return m_fluxFctDnaInfra.getIndicSalaireHoraire_C_ERR();
  }
  
  public void setIndicSalaireHoraire(String pValeur)
  {
    m_fluxFctDnaInfra.setIndicSalaireHoraire(pValeur);
  }
  
  public void setCodeErreurIndicSalaireHoraire(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setIndicSalaireHoraire_C_ERR(pCodeErreur);
  }
  
  public String getFillerUn()
  {
    return m_fluxFctDnaInfra.getFillerUn();
  }
  
  public String getCodeErreurFillerUn()
  {
    return m_fluxFctDnaInfra.getFillerUn_C_ERR();
  }
  
  public void setFillerUn(String pValeur)
  {
    m_fluxFctDnaInfra.setFillerUn(pValeur);
  }
  
  public void setCodeErreurFillerUn(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setFillerUn_C_ERR(pCodeErreur);
  }
  
  public String getFillerDeux()
  {
    return m_fluxFctDnaInfra.getFillerDeux();
  }
  
  public String getCodeErreurFillerDeux()
  {
    return m_fluxFctDnaInfra.getFillerDeux_C_ERR();
  }
  
  public void setFillerDeux(String pValeur)
  {
    m_fluxFctDnaInfra.setFillerDeux(pValeur);
  }
  
  public void setCodeErreurFillerDeux(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setFillerDeux_C_ERR(pCodeErreur);
  }
  
  public String getEmployAutoAssur()
  {
    return m_fluxFctDnaInfra.getEmployAutoAssur();
  }
  
  public String getCodeErreurEmployAutoAssur()
  {
    return m_fluxFctDnaInfra.getEmployAutoAssur_C_ERR();
  }
  
  public void setEmployAutoAssur(String pValeur)
  {
    m_fluxFctDnaInfra.setEmployAutoAssur(pValeur);
  }
  
  public void setCodeErreurEmployAutoAssur(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setEmployAutoAssur_C_ERR(pCodeErreur);
  }
  
  public String getNumCG()
  {
    return m_fluxFctDnaInfra.getNumCG();
  }
  
  public String getCodeErreurNumCG()
  {
    return m_fluxFctDnaInfra.getNumCG_C_ERR();
  }
  
  public void setNumCG(String pValeur)
  {
    m_fluxFctDnaInfra.setNumCG(pValeur);
  }
  
  public void setCodeErreurNumCG(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNumCG_C_ERR(pCodeErreur);
  }
  
  public String getEtabFinanc()
  {
    return m_fluxFctDnaInfra.getEtabFinanc();
  }
  
  public String getCodeErreurEtabFinanc()
  {
    return m_fluxFctDnaInfra.getEtabFinanc_C_ERR();
  }
  
  public void setEtabFinanc(String pValeur)
  {
    m_fluxFctDnaInfra.setEtabFinanc(pValeur);
  }
  
  public void setCodeErreurEtabFinanc(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setEtabFinanc_C_ERR(pCodeErreur);
  }
  
  public String getNumInterne()
  {
    return m_fluxFctDnaInfra.getNumInterne();
  }
  
  public String getCodeErreurNumInterne()
  {
    return m_fluxFctDnaInfra.getNumInterne_C_ERR();
  }
  
  public void setNumInterne(String pValeur)
  {
    m_fluxFctDnaInfra.setNumInterne(pValeur);
  }
  
  public void setCodeErreurNumInterne(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNumInterne_C_ERR(pCodeErreur);
  }
  
  public String getCodeAffect()
  {
    return m_fluxFctDnaInfra.getCodeAffect();
  }
  
  public String getCodeErreurCodeAffect()
  {
    return m_fluxFctDnaInfra.getCodeAffect_C_ERR();
  }
  
  public void setCodeAffect(String pValeur)
  {
    m_fluxFctDnaInfra.setCodeAffect(pValeur);
  }
  
  public void setCodeErreurCodeAffect(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setCodeAffect_C_ERR(pCodeErreur);
  }
  
  public String getStatutSalarie()
  {
    return m_fluxFctDnaInfra.getStatutSalarie();
  }
  
  public String getCodeErreurStatutSalarie()
  {
    return m_fluxFctDnaInfra.getStatutSalarie_C_ERR();
  }
  
  public void setStatutSalarie(String pValeur)
  {
    m_fluxFctDnaInfra.setStatutSalarie(pValeur);
  }
  
  public void setCodeErreurStatutSalarie(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setStatutSalarie_C_ERR(pCodeErreur);
  }
  
  public String getCodeStatutjuridique()
  {
    return m_fluxFctDnaInfra.getCodeStatutjuridique();
  }
  
  public String getCodeErreurCodeStatutjuridique()
  {
    return m_fluxFctDnaInfra.getCodeStatutjuridique_C_ERR();
  }
  
  public void setCodeStatutjuridique(String pValeur)
  {
    m_fluxFctDnaInfra.setCodeStatutjuridique(pValeur);
  }
  
  public void setCodeErreurCodeStatutjuridique(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setCodeStatutjuridique_C_ERR(pCodeErreur);
  }
  
  public String getNomLogiciel()
  {
    return m_fluxFctDnaInfra.getNomLogiciel();
  }
  
  public String getCodeErreurNomLogiciel()
  {
    return m_fluxFctDnaInfra.getNomLogiciel_C_ERR();
  }
  
  public void setNomLogiciel(String pValeur)
  {
    m_fluxFctDnaInfra.setNomLogiciel(pValeur);
  }
  
  public void setCodeErreurNomLogiciel(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNomLogiciel_C_ERR(pCodeErreur);
  }
  
  public String getVersionLogiciel()
  {
    return m_fluxFctDnaInfra.getVersionLogiciel();
  }
  
  public String getCodeErreurVersionLogiciel()
  {
    return m_fluxFctDnaInfra.getVersionLogiciel_C_ERR();
  }
  
  public void setVersionLogiciel(String pValeur)
  {
    m_fluxFctDnaInfra.setVersionLogiciel(pValeur);
  }
  
  public void setCodeErreurVersionLogiciel(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setVersionLogiciel_C_ERR(pCodeErreur);
  }
  
  public String getCategorieJuridiqueEntreprise()
  {
    return m_fluxFctDnaInfra.getCategorieJuridiqueEntreprise();
  }
  
  public String getCodeErreurCategorieJuridiqueEntreprise()
  {
    return m_fluxFctDnaInfra.getCategorieJuridiqueEntreprise_C_ERR();
  }
  
  public void setCategorieJuridiqueEntreprise(String pValeur)
  {
    m_fluxFctDnaInfra.setCategorieJuridiqueEntreprise(pValeur);
  }
  
  public void setCodeErreurCategorieJuridiqueEntreprise(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setCategorieJuridiqueEntreprise_C_ERR(pCodeErreur);
  }
  
  public String getCodeRegimeEntreprise()
  {
    return m_fluxFctDnaInfra.getCodeRegimeEntreprise();
  }
  
  public String getCodeErreurCodeRegimeEntreprise()
  {
    return m_fluxFctDnaInfra.getCodeRegimeEntreprise_C_ERR();
  }
  
  public void setCodeRegimeEntreprise(String pValeur)
  {
    m_fluxFctDnaInfra.setCodeRegimeEntreprise(pValeur);
  }
  
  public void setCodeErreurCodeRegimeEntreprise(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setCodeRegimeEntreprise_C_ERR(pCodeErreur);
  }
  
  public String getNatureEntreprise()
  {
    return m_fluxFctDnaInfra.getNatureEntreprise();
  }
  
  public String getCodeErreurNatureEntreprise()
  {
    return m_fluxFctDnaInfra.getNatureEntreprise_C_ERR();
  }
  
  public void setNatureEntreprise(String pValeur)
  {
    m_fluxFctDnaInfra.setNatureEntreprise(pValeur);
  }
  
  public void setCodeErreurNatureEntreprise(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNatureEntreprise_C_ERR(pCodeErreur);
  }
  
  public String getNumGusoEntreprise()
  {
    return m_fluxFctDnaInfra.getNumGusoEntreprise();
  }
  
  public String getCodeErreurNumGusoEntreprise()
  {
    return m_fluxFctDnaInfra.getNumGusoEntreprise_C_ERR();
  }
  
  public void setNumGusoEntreprise(String pValeur)
  {
    m_fluxFctDnaInfra.setNumGusoEntreprise(pValeur);
  }
  
  public void setCodeErreurNumGusoEntreprise(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNumGusoEntreprise_C_ERR(pCodeErreur);
  }
  
  public String getNumMSAEntreprise()
  {
    return m_fluxFctDnaInfra.getNumMSAEntreprise();
  }
  
  public String getCodeErreurNumMSAEntreprise()
  {
    return m_fluxFctDnaInfra.getNumMSAEntreprise_C_ERR();
  }
  
  public void setNumMSAEntreprise(String pValeur)
  {
    m_fluxFctDnaInfra.setNumMSAEntreprise(pValeur);
  }
  
  public void setCodeErreurNumMSAEntreprise(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNumMSAEntreprise_C_ERR(pCodeErreur);
  }
  
  public String getEntreprisePublique()
  {
    return m_fluxFctDnaInfra.getEntreprisePublique();
  }
  
  public String getCodeErreurEntreprisePublique()
  {
    return m_fluxFctDnaInfra.getEntreprisePublique_C_ERR();
  }
  
  public void setEntreprisePublique(String pValeur)
  {
    m_fluxFctDnaInfra.setEntreprisePublique(pValeur);
  }
  
  public void setCodeErreurEntreprisePublique(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setEntreprisePublique_C_ERR(pCodeErreur);
  }
  
  public String getTrancheEffectifEntreprise()
  {
    return m_fluxFctDnaInfra.getTrancheEffectifEntreprise();
  }
  
  public String getCodeErreurTrancheEffectifEntreprise()
  {
    return m_fluxFctDnaInfra.getTrancheEffectifEntreprise_C_ERR();
  }
  
  public void setTrancheEffectifEntreprise(String pValeur)
  {
    m_fluxFctDnaInfra.setTrancheEffectifEntreprise(pValeur);
  }
  
  public void setCodeErreurTrancheEffectifEntreprise(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setTrancheEffectifEntreprise_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutContrat()
  {
    return m_fluxFctDnaInfra.getDateDebutContrat();
  }
  
  public String getCodeErreurDateDebutContrat()
  {
    return m_fluxFctDnaInfra.getDateDebutContrat_C_ERR();
  }
  
  public void setDateDebutContrat(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateDebutContrat(pValeur);
  }
  
  public void setCodeErreurDateDebutContrat(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateDebutContrat_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinContrat()
  {
    return m_fluxFctDnaInfra.getDateFinContrat();
  }
  
  public String getCodeErreurDateFinContrat()
  {
    return m_fluxFctDnaInfra.getDateFinContrat_C_ERR();
  }
  
  public void setDateFinContrat(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateFinContrat(pValeur);
  }
  
  public void setCodeErreurDateFinContrat(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateFinContrat_C_ERR(pCodeErreur);
  }
  
  public Damj getDateNotifRupture()
  {
    return m_fluxFctDnaInfra.getDateNotifRupture();
  }
  
  public String getCodeErreurDateNotifRupture()
  {
    return m_fluxFctDnaInfra.getDateNotifRupture_C_ERR();
  }
  
  public void setDateNotifRupture(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateNotifRupture(pValeur);
  }
  
  public void setCodeErreurDateNotifRupture(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateNotifRupture_C_ERR(pCodeErreur);
  }
  
  public Damj getDateProcedureLicenciement()
  {
    return m_fluxFctDnaInfra.getDateProcedureLicenciement();
  }
  
  public String getCodeErreurDateProcedureLicenciement()
  {
    return m_fluxFctDnaInfra.getDateProcedureLicenciement_C_ERR();
  }
  
  public void setDateProcedureLicenciement(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateProcedureLicenciement(pValeur);
  }
  
  public void setCodeErreurDateProcedureLicenciement(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateProcedureLicenciement_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDJTP()
  {
    return m_fluxFctDnaInfra.getDateDJTP();
  }
  
  public String getCodeErreurDateDJTP()
  {
    return m_fluxFctDnaInfra.getDateDJTP_C_ERR();
  }
  
  public void setDateDJTP(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateDJTP(pValeur);
  }
  
  public void setCodeErreurDateDJTP(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateDJTP_C_ERR(pCodeErreur);
  }
  
  public Damj getDateInitialeFinContrat()
  {
    return m_fluxFctDnaInfra.getDateInitialeFinContrat();
  }
  
  public String getCodeErreurDateInitialeFinContrat()
  {
    return m_fluxFctDnaInfra.getDateInitialeFinContrat_C_ERR();
  }
  
  public void setDateInitialeFinContrat(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateInitialeFinContrat(pValeur);
  }
  
  public void setCodeErreurDateInitialeFinContrat(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateInitialeFinContrat_C_ERR(pCodeErreur);
  }
  
  public Damj getDateConnaissanceAE()
  {
    return m_fluxFctDnaInfra.getDateConnaissanceAE();
  }
  
  public String getCodeErreurDateConnaissanceAE()
  {
    return m_fluxFctDnaInfra.getDateConnaissanceAE_C_ERR();
  }
  
  public void setDateConnaissanceAE(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateConnaissanceAE(pValeur);
  }
  
  public void setCodeErreurDateConnaissanceAE(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateConnaissanceAE_C_ERR(pCodeErreur);
  }
  
  public Damj getDateReprise()
  {
    return m_fluxFctDnaInfra.getDateReprise();
  }
  
  public String getCodeErreurDateReprise()
  {
    return m_fluxFctDnaInfra.getDateReprise_C_ERR();
  }
  
  public void setDateReprise(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateReprise(pValeur);
  }
  
  public void setCodeErreurDateReprise(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateReprise_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutIndemCP()
  {
    return m_fluxFctDnaInfra.getDateDebutIndemCP();
  }
  
  public String getCodeErreurDateDebutIndemCP()
  {
    return m_fluxFctDnaInfra.getDateDebutIndemCP_C_ERR();
  }
  
  public void setDateDebutIndemCP(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateDebutIndemCP(pValeur);
  }
  
  public void setCodeErreurDateDebutIndemCP(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateDebutIndemCP_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinIndemCP()
  {
    return m_fluxFctDnaInfra.getDateFinIndemCP();
  }
  
  public String getCodeErreurDateFinIndemCP()
  {
    return m_fluxFctDnaInfra.getDateFinIndemCP_C_ERR();
  }
  
  public void setDateFinIndemCP(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateFinIndemCP(pValeur);
  }
  
  public void setCodeErreurDateFinIndemCP(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateFinIndemCP_C_ERR(pCodeErreur);
  }
  
  public Damj getDateEffetCTP()
  {
    return m_fluxFctDnaInfra.getDateEffetCTP();
  }
  
  public String getCodeErreurDateEffetCTP()
  {
    return m_fluxFctDnaInfra.getDateEffetCTP_C_ERR();
  }
  
  public void setDateEffetCTP(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateEffetCTP(pValeur);
  }
  
  public void setCodeErreurDateEffetCTP(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateEffetCTP_C_ERR(pCodeErreur);
  }
  
  public Damj getDateAdhesion()
  {
    return m_fluxFctDnaInfra.getDateAdhesion();
  }
  
  public String getCodeErreurDateAdhesion()
  {
    return m_fluxFctDnaInfra.getDateAdhesion_C_ERR();
  }
  
  public void setDateAdhesion(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateAdhesion(pValeur);
  }
  
  public void setCodeErreurDateAdhesion(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateAdhesion_C_ERR(pCodeErreur);
  }
  
  public Damj getDateCessationActiviteEntreprise()
  {
    return m_fluxFctDnaInfra.getDateCessationActiviteEntreprise();
  }
  
  public String getCodeErreurDateCessationActiviteEntreprise()
  {
    return m_fluxFctDnaInfra.getDateCessationActiviteEntreprise_C_ERR();
  }
  
  public void setDateCessationActiviteEntreprise(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateCessationActiviteEntreprise(pValeur);
  }
  
  public void setCodeErreurDateCessationActiviteEntreprise(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateCessationActiviteEntreprise_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutPeriodeAffiliationEntreprise()
  {
    return m_fluxFctDnaInfra.getDateDebutPeriodeAffiliationEntreprise();
  }
  
  public String getCodeErreurDateDebutPeriodeAffiliationEntreprise()
  {
    return m_fluxFctDnaInfra.getDateDebutPeriodeAffiliationEntreprise_C_ERR();
  }
  
  public void setDateDebutPeriodeAffiliationEntreprise(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateDebutPeriodeAffiliationEntreprise(pValeur);
  }
  
  public void setCodeErreurDateDebutPeriodeAffiliationEntreprise(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateDebutPeriodeAffiliationEntreprise_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinPeriodeAffiliationEntreprise()
  {
    return m_fluxFctDnaInfra.getDateFinPeriodeAffiliationEntreprise();
  }
  
  public String getCodeErreurDateFinPeriodeAffiliationEntreprise()
  {
    return m_fluxFctDnaInfra.getDateFinPeriodeAffiliationEntreprise_C_ERR();
  }
  
  public void setDateFinPeriodeAffiliationEntreprise(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateFinPeriodeAffiliationEntreprise(pValeur);
  }
  
  public void setCodeErreurDateFinPeriodeAffiliationEntreprise(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateFinPeriodeAffiliationEntreprise_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutEffetConGes()
  {
    return m_fluxFctDnaInfra.getDateDebutEffetConGes();
  }
  
  public String getCodeErreurDateDebutEffetConGes()
  {
    return m_fluxFctDnaInfra.getDateDebutEffetConGes_C_ERR();
  }
  
  public void setDateDebutEffetConGes(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateDebutEffetConGes(pValeur);
  }
  
  public void setCodeErreurDateDebutEffetConGes(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateDebutEffetConGes_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinEffetConGes()
  {
    return m_fluxFctDnaInfra.getDateFinEffetConGes();
  }
  
  public String getCodeErreurDateFinEffetConGes()
  {
    return m_fluxFctDnaInfra.getDateFinEffetConGes_C_ERR();
  }
  
  public void setDateFinEffetConGes(Damj pValeur)
  {
    m_fluxFctDnaInfra.setDateFinEffetConGes(pValeur);
  }
  
  public void setCodeErreurDateFinEffetConGes(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setDateFinEffetConGes_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNumeroVersion()
  {
    return m_fluxFctDnaInfra.getNumeroVersion();
  }
  
  public String getCodeErreurNumeroVersion()
  {
    return m_fluxFctDnaInfra.getNumeroVersion_C_ERR();
  }
  
  public void setNumeroVersion(BigDecimal pValeur)
  {
    m_fluxFctDnaInfra.setNumeroVersion(pValeur);
  }
  
  public void setCodeErreurNumeroVersion(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNumeroVersion_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdTechContratDna()
  {
    return m_fluxFctDnaInfra.getIdTechContratDna();
  }
  
  public String getCodeErreurIdTechContratDna()
  {
    return m_fluxFctDnaInfra.getIdTechContratDna_C_ERR();
  }
  
  public void setIdTechContratDna(BigDecimal pValeur)
  {
    m_fluxFctDnaInfra.setIdTechContratDna(pValeur);
  }
  
  public void setCodeErreurIdTechContratDna(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setIdTechContratDna_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbCongesPayesRestant()
  {
    return m_fluxFctDnaInfra.getNbCongesPayesRestant();
  }
  
  public String getCodeErreurNbCongesPayesRestant()
  {
    return m_fluxFctDnaInfra.getNbCongesPayesRestant_C_ERR();
  }
  
  public void setNbCongesPayesRestant(BigDecimal pValeur)
  {
    m_fluxFctDnaInfra.setNbCongesPayesRestant(pValeur);
  }
  
  public void setCodeErreurNbCongesPayesRestant(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNbCongesPayesRestant_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantIndemnitePreavis()
  {
    return m_fluxFctDnaInfra.getMontantIndemnitePreavis();
  }
  
  public String getCodeErreurMontantIndemnitePreavis()
  {
    return m_fluxFctDnaInfra.getMontantIndemnitePreavis_C_ERR();
  }
  
  public void setMontantIndemnitePreavis(BigDecimal pValeur)
  {
    m_fluxFctDnaInfra.setMontantIndemnitePreavis(pValeur);
  }
  
  public void setCodeErreurMontantIndemnitePreavis(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setMontantIndemnitePreavis_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbHeuresDIF()
  {
    return m_fluxFctDnaInfra.getNbHeuresDIF();
  }
  
  public String getCodeErreurNbHeuresDIF()
  {
    return m_fluxFctDnaInfra.getNbHeuresDIF_C_ERR();
  }
  
  public void setNbHeuresDIF(BigDecimal pValeur)
  {
    m_fluxFctDnaInfra.setNbHeuresDIF(pValeur);
  }
  
  public void setCodeErreurNbHeuresDIF(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNbHeuresDIF_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSalaireHoraireNetSalarie()
  {
    return m_fluxFctDnaInfra.getSalaireHoraireNetSalarie();
  }
  
  public String getCodeErreurSalaireHoraireNetSalarie()
  {
    return m_fluxFctDnaInfra.getSalaireHoraireNetSalarie_C_ERR();
  }
  
  public void setSalaireHoraireNetSalarie(BigDecimal pValeur)
  {
    m_fluxFctDnaInfra.setSalaireHoraireNetSalarie(pValeur);
  }
  
  public void setCodeErreurSalaireHoraireNetSalarie(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setSalaireHoraireNetSalarie_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdTechContratRemplace()
  {
    return m_fluxFctDnaInfra.getIdTechContratRemplace();
  }
  
  public String getCodeErreurIdTechContratRemplace()
  {
    return m_fluxFctDnaInfra.getIdTechContratRemplace_C_ERR();
  }
  
  public void setIdTechContratRemplace(BigDecimal pValeur)
  {
    m_fluxFctDnaInfra.setIdTechContratRemplace(pValeur);
  }
  
  public void setCodeErreurIdTechContratRemplace(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setIdTechContratRemplace_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbPAS()
  {
    return m_fluxFctDnaInfra.getNbPAS();
  }
  
  public String getCodeErreurNbPAS()
  {
    return m_fluxFctDnaInfra.getNbPAS_C_ERR();
  }
  
  public void setNbPAS(BigDecimal pValeur)
  {
    m_fluxFctDnaInfra.setNbPAS(pValeur);
  }
  
  public void setCodeErreurNbPAS(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNbPAS_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbSalariesEntreprise()
  {
    return m_fluxFctDnaInfra.getNbSalariesEntreprise();
  }
  
  public String getCodeErreurNbSalariesEntreprise()
  {
    return m_fluxFctDnaInfra.getNbSalariesEntreprise_C_ERR();
  }
  
  public void setNbSalariesEntreprise(BigDecimal pValeur)
  {
    m_fluxFctDnaInfra.setNbSalariesEntreprise(pValeur);
  }
  
  public void setCodeErreurNbSalariesEntreprise(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNbSalariesEntreprise_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbMoisPreavis()
  {
    return m_fluxFctDnaInfra.getNbMoisPreavis();
  }
  
  public String getCodeErreurNbMoisPreavis()
  {
    return m_fluxFctDnaInfra.getNbMoisPreavis_C_ERR();
  }
  
  public void setNbMoisPreavis(BigDecimal pValeur)
  {
    m_fluxFctDnaInfra.setNbMoisPreavis(pValeur);
  }
  
  public void setCodeErreurNbMoisPreavis(String pCodeErreur)
  {
    m_fluxFctDnaInfra.setNbMoisPreavis_C_ERR(pCodeErreur);
  }
  
  public _FluxFctDna getFluxFctDnaInfra()
  {
    return m_fluxFctDnaInfra;
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
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxFctDnaImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */