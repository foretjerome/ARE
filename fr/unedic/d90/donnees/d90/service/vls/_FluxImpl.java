package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxImpl
  extends Flux
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _Flux m_fluxInfra;
  
  public _FluxImpl()
  {
    m_fluxInfra = new _Flux();
  }
  
  public _FluxImpl(_Flux pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxInfra", pValeur);
    
    m_fluxInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxInfra.set_C_ETAT(pCode);
  }
  
  public FluxCAF getFluxCAF()
  {
    _FluxCAF infraItem = m_fluxInfra.getFluxCAF();
    _FluxCAFImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxCAFImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxCAF(FluxCAF pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxCAF(null);
    }
    else
    {
      _FluxCAFImpl subImpl = (_FluxCAFImpl)pValeur;
      m_fluxInfra.setFluxCAF(subImpl.getFluxCAFInfra());
    }
  }
  
  public FluxCAF setNewFluxCAF()
  {
    _FluxCAFImpl item = new _FluxCAFImpl();
    m_fluxInfra.setFluxCAF(item.getFluxCAFInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxCAF setNewFluxCAF_fluxCAF()
  {
    return setNewFluxCAF();
  }
  
  public FluxETT getFluxETT()
  {
    _FluxETT infraItem = m_fluxInfra.getFluxETT();
    _FluxETTImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxETTImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxETT(FluxETT pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxETT(null);
    }
    else
    {
      _FluxETTImpl subImpl = (_FluxETTImpl)pValeur;
      m_fluxInfra.setFluxETT(subImpl.getFluxETTInfra());
    }
  }
  
  public FluxETT setNewFluxETT()
  {
    _FluxETTImpl item = new _FluxETTImpl();
    m_fluxInfra.setFluxETT(item.getFluxETTInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxETT setNewFluxETT_fluxETT()
  {
    return setNewFluxETT();
  }
  
  public FluxCSS getFluxCSS()
  {
    _FluxCSS infraItem = m_fluxInfra.getFluxCSS();
    _FluxCSSImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxCSSImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxCSS(FluxCSS pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxCSS(null);
    }
    else
    {
      _FluxCSSImpl subImpl = (_FluxCSSImpl)pValeur;
      m_fluxInfra.setFluxCSS(subImpl.getFluxCSSInfra());
    }
  }
  
  public FluxCSS setNewFluxCSS()
  {
    _FluxCSSImpl item = new _FluxCSSImpl();
    m_fluxInfra.setFluxCSS(item.getFluxCSSInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxCSS setNewFluxCSS_fluxCSS()
  {
    return setNewFluxCSS();
  }
  
  public FluxDSM getFluxDSM()
  {
    _FluxDSM infraItem = m_fluxInfra.getFluxDSM();
    _FluxDSMImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxDSMImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxDSM(FluxDSM pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxDSM(null);
    }
    else
    {
      _FluxDSMImpl subImpl = (_FluxDSMImpl)pValeur;
      m_fluxInfra.setFluxDSM(subImpl.getFluxDSMInfra());
    }
  }
  
  public FluxDSM setNewFluxDSM()
  {
    _FluxDSMImpl item = new _FluxDSMImpl();
    m_fluxInfra.setFluxDSM(item.getFluxDSMInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxDSM setNewFluxDSM_fluxDSM()
  {
    return setNewFluxDSM();
  }
  
  public FluxGUSO getFluxGUSO()
  {
    _FluxGUSO infraItem = m_fluxInfra.getFluxGUSO();
    _FluxGUSOImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxGUSOImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxGUSO(FluxGUSO pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxGUSO(null);
    }
    else
    {
      _FluxGUSOImpl subImpl = (_FluxGUSOImpl)pValeur;
      m_fluxInfra.setFluxGUSO(subImpl.getFluxGUSOInfra());
    }
  }
  
  public FluxGUSO setNewFluxGUSO()
  {
    _FluxGUSOImpl item = new _FluxGUSOImpl();
    m_fluxInfra.setFluxGUSO(item.getFluxGUSOInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxGUSO setNewFluxGUSO_fluxGUSO()
  {
    return setNewFluxGUSO();
  }
  
  public FluxCPAM getFluxCPAM()
  {
    _FluxCPAM infraItem = m_fluxInfra.getFluxCPAM();
    _FluxCPAMImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxCPAMImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxCPAM(FluxCPAM pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxCPAM(null);
    }
    else
    {
      _FluxCPAMImpl subImpl = (_FluxCPAMImpl)pValeur;
      m_fluxInfra.setFluxCPAM(subImpl.getFluxCPAMInfra());
    }
  }
  
  public FluxCPAM setNewFluxCPAM()
  {
    _FluxCPAMImpl item = new _FluxCPAMImpl();
    m_fluxInfra.setFluxCPAM(item.getFluxCPAMInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxCPAM setNewFluxCPAM_fluxCPAM()
  {
    return setNewFluxCPAM();
  }
  
  public FluxAEM getFluxAEM()
  {
    _FluxAEM infraItem = m_fluxInfra.getFluxAEM();
    _FluxAEMImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxAEMImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxAEM(FluxAEM pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxAEM(null);
    }
    else
    {
      _FluxAEMImpl subImpl = (_FluxAEMImpl)pValeur;
      m_fluxInfra.setFluxAEM(subImpl.getFluxAEMInfra());
    }
  }
  
  public FluxAEM setNewFluxAEM()
  {
    _FluxAEMImpl item = new _FluxAEMImpl();
    m_fluxInfra.setFluxAEM(item.getFluxAEMInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxAEM setNewFluxAEM_fluxAEM()
  {
    return setNewFluxAEM();
  }
  
  public FluxBS getFluxBS()
  {
    _FluxBS infraItem = m_fluxInfra.getFluxBS();
    _FluxBSImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxBSImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxBS(FluxBS pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxBS(null);
    }
    else
    {
      _FluxBSImpl subImpl = (_FluxBSImpl)pValeur;
      m_fluxInfra.setFluxBS(subImpl.getFluxBSInfra());
    }
  }
  
  public FluxBS setNewFluxBS()
  {
    _FluxBSImpl item = new _FluxBSImpl();
    m_fluxInfra.setFluxBS(item.getFluxBSInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxBS setNewFluxBS_fluxBS()
  {
    return setNewFluxBS();
  }
  
  public FluxPasDna getFluxPasDna()
  {
    _FluxPasDna infraItem = m_fluxInfra.getFluxPasDna();
    _FluxPasDnaImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxPasDnaImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxPasDna(FluxPasDna pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxPasDna(null);
    }
    else
    {
      _FluxPasDnaImpl subImpl = (_FluxPasDnaImpl)pValeur;
      m_fluxInfra.setFluxPasDna(subImpl.getFluxPasDnaInfra());
    }
  }
  
  public FluxPasDna setNewFluxPasDna()
  {
    _FluxPasDnaImpl item = new _FluxPasDnaImpl();
    m_fluxInfra.setFluxPasDna(item.getFluxPasDnaInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxPasDna setNewFluxPasDna_fluxPasDna()
  {
    return setNewFluxPasDna();
  }
  
  public FluxFctDna getFluxFctDna()
  {
    _FluxFctDna infraItem = m_fluxInfra.getFluxFctDna();
    _FluxFctDnaImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxFctDnaImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxFctDna(FluxFctDna pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxFctDna(null);
    }
    else
    {
      _FluxFctDnaImpl subImpl = (_FluxFctDnaImpl)pValeur;
      m_fluxInfra.setFluxFctDna(subImpl.getFluxFctDnaInfra());
    }
  }
  
  public FluxFctDna setNewFluxFctDna()
  {
    _FluxFctDnaImpl item = new _FluxFctDnaImpl();
    m_fluxInfra.setFluxFctDna(item.getFluxFctDnaInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxFctDna setNewFluxFctDna_fluxFctDna()
  {
    return setNewFluxFctDna();
  }
  
  public FluxCali getFluxCali()
  {
    _FluxCali infraItem = m_fluxInfra.getFluxCali();
    _FluxCaliImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxCaliImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxCali(FluxCali pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxCali(null);
    }
    else
    {
      _FluxCaliImpl subImpl = (_FluxCaliImpl)pValeur;
      m_fluxInfra.setFluxCali(subImpl.getFluxCaliInfra());
    }
  }
  
  public FluxCali setNewFluxCali()
  {
    _FluxCaliImpl item = new _FluxCaliImpl();
    m_fluxInfra.setFluxCali(item.getFluxCaliInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxCali setNewFluxCali_fluxCali()
  {
    return setNewFluxCali();
  }
  
  public FluxMSA getFluxMSA()
  {
    _FluxMSA infraItem = m_fluxInfra.getFluxMSA();
    _FluxMSAImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxMSAImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxMSA(FluxMSA pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxMSA(null);
    }
    else
    {
      _FluxMSAImpl subImpl = (_FluxMSAImpl)pValeur;
      m_fluxInfra.setFluxMSA(subImpl.getFluxMSAInfra());
    }
  }
  
  public FluxMSA setNewFluxMSA()
  {
    _FluxMSAImpl item = new _FluxMSAImpl();
    m_fluxInfra.setFluxMSA(item.getFluxMSAInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxMSA setNewFluxMSA_fluxMSA()
  {
    return setNewFluxMSA();
  }
  
  public FluxDMM getFluxDMM()
  {
    _FluxDMM infraItem = m_fluxInfra.getFluxDMM();
    _FluxDMMImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxDMMImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxDMM(FluxDMM pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxDMM(null);
    }
    else
    {
      _FluxDMMImpl subImpl = (_FluxDMMImpl)pValeur;
      m_fluxInfra.setFluxDMM(subImpl.getFluxDMMInfra());
    }
  }
  
  public FluxDMM setNewFluxDMM()
  {
    _FluxDMMImpl item = new _FluxDMMImpl();
    m_fluxInfra.setFluxDMM(item.getFluxDMMInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxDMM setNewFluxDMM_fluxDMM()
  {
    return setNewFluxDMM();
  }
  
  public FluxAE getFluxAE()
  {
    _FluxAE infraItem = m_fluxInfra.getFluxAE();
    _FluxAEImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxAEImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxAE(FluxAE pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxAE(null);
    }
    else
    {
      _FluxAEImpl subImpl = (_FluxAEImpl)pValeur;
      m_fluxInfra.setFluxAE(subImpl.getFluxAEInfra());
    }
  }
  
  public FluxAE setNewFluxAE()
  {
    _FluxAEImpl item = new _FluxAEImpl();
    m_fluxInfra.setFluxAE(item.getFluxAEInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxAE setNewFluxAE_fluxAE()
  {
    return setNewFluxAE();
  }
  
  public String getMotifAnomalie()
  {
    return m_fluxInfra.getMotifAnomalie();
  }
  
  public String getCodeErreurMotifAnomalie()
  {
    return m_fluxInfra.getMotifAnomalie_C_ERR();
  }
  
  public void setMotifAnomalie(String pValeur)
  {
    m_fluxInfra.setMotifAnomalie(pValeur);
  }
  
  public void setCodeErreurMotifAnomalie(String pCodeErreur)
  {
    m_fluxInfra.setMotifAnomalie_C_ERR(pCodeErreur);
  }
  
  public String getCommentaire()
  {
    return m_fluxInfra.getCommentaire();
  }
  
  public String getCodeErreurCommentaire()
  {
    return m_fluxInfra.getCommentaire_C_ERR();
  }
  
  public void setCommentaire(String pValeur)
  {
    m_fluxInfra.setCommentaire(pValeur);
  }
  
  public void setCodeErreurCommentaire(String pCodeErreur)
  {
    m_fluxInfra.setCommentaire_C_ERR(pCodeErreur);
  }
  
  public String getTypeFlux()
  {
    return m_fluxInfra.getTypeFlux();
  }
  
  public String getCodeErreurTypeFlux()
  {
    return m_fluxInfra.getTypeFlux_C_ERR();
  }
  
  public void setTypeFlux(String pValeur)
  {
    m_fluxInfra.setTypeFlux(pValeur);
  }
  
  public void setCodeErreurTypeFlux(String pCodeErreur)
  {
    m_fluxInfra.setTypeFlux_C_ERR(pCodeErreur);
  }
  
  public String getIdFlux()
  {
    return m_fluxInfra.getIdFlux();
  }
  
  public String getCodeErreurIdFlux()
  {
    return m_fluxInfra.getIdFlux_C_ERR();
  }
  
  public void setIdFlux(String pValeur)
  {
    m_fluxInfra.setIdFlux(pValeur);
  }
  
  public void setCodeErreurIdFlux(String pCodeErreur)
  {
    m_fluxInfra.setIdFlux_C_ERR(pCodeErreur);
  }
  
  public String getVersion()
  {
    return m_fluxInfra.getVersion();
  }
  
  public String getCodeErreurVersion()
  {
    return m_fluxInfra.getVersion_C_ERR();
  }
  
  public void setVersion(String pValeur)
  {
    m_fluxInfra.setVersion(pValeur);
  }
  
  public void setCodeErreurVersion(String pCodeErreur)
  {
    m_fluxInfra.setVersion_C_ERR(pCodeErreur);
  }
  
  public String getIdTechPas()
  {
    return m_fluxInfra.getIdTechPas();
  }
  
  public String getCodeErreurIdTechPas()
  {
    return m_fluxInfra.getIdTechPas_C_ERR();
  }
  
  public void setIdTechPas(String pValeur)
  {
    m_fluxInfra.setIdTechPas(pValeur);
  }
  
  public void setCodeErreurIdTechPas(String pCodeErreur)
  {
    m_fluxInfra.setIdTechPas_C_ERR(pCodeErreur);
  }
  
  public String getNumeroContrat()
  {
    return m_fluxInfra.getNumeroContrat();
  }
  
  public String getCodeErreurNumeroContrat()
  {
    return m_fluxInfra.getNumeroContrat_C_ERR();
  }
  
  public void setNumeroContrat(String pValeur)
  {
    m_fluxInfra.setNumeroContrat(pValeur);
  }
  
  public void setCodeErreurNumeroContrat(String pCodeErreur)
  {
    m_fluxInfra.setNumeroContrat_C_ERR(pCodeErreur);
  }
  
  public Damj getDateTraitement()
  {
    return m_fluxInfra.getDateTraitement();
  }
  
  public String getCodeErreurDateTraitement()
  {
    return m_fluxInfra.getDateTraitement_C_ERR();
  }
  
  public void setDateTraitement(Damj pValeur)
  {
    m_fluxInfra.setDateTraitement(pValeur);
  }
  
  public void setCodeErreurDateTraitement(String pCodeErreur)
  {
    m_fluxInfra.setDateTraitement_C_ERR(pCodeErreur);
  }
  
  public Damj getDateVisa()
  {
    return m_fluxInfra.getDateVisa();
  }
  
  public String getCodeErreurDateVisa()
  {
    return m_fluxInfra.getDateVisa_C_ERR();
  }
  
  public void setDateVisa(Damj pValeur)
  {
    m_fluxInfra.setDateVisa(pValeur);
  }
  
  public void setCodeErreurDateVisa(String pCodeErreur)
  {
    m_fluxInfra.setDateVisa_C_ERR(pCodeErreur);
  }
  
  public Damj getDateConnaissanceInfo()
  {
    return m_fluxInfra.getDateConnaissanceInfo();
  }
  
  public String getCodeErreurDateConnaissanceInfo()
  {
    return m_fluxInfra.getDateConnaissanceInfo_C_ERR();
  }
  
  public void setDateConnaissanceInfo(Damj pValeur)
  {
    m_fluxInfra.setDateConnaissanceInfo(pValeur);
  }
  
  public void setCodeErreurDateConnaissanceInfo(String pCodeErreur)
  {
    m_fluxInfra.setDateConnaissanceInfo_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIndicateurOrigine()
  {
    return m_fluxInfra.getIndicateurOrigine();
  }
  
  public String getCodeErreurIndicateurOrigine()
  {
    return m_fluxInfra.getIndicateurOrigine_C_ERR();
  }
  
  public void setIndicateurOrigine(BigDecimal pValeur)
  {
    m_fluxInfra.setIndicateurOrigine(pValeur);
  }
  
  public void setCodeErreurIndicateurOrigine(String pCodeErreur)
  {
    m_fluxInfra.setIndicateurOrigine_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdPeriodeActivite()
  {
    return m_fluxInfra.getIdPeriodeActivite();
  }
  
  public String getCodeErreurIdPeriodeActivite()
  {
    return m_fluxInfra.getIdPeriodeActivite_C_ERR();
  }
  
  public void setIdPeriodeActivite(BigDecimal pValeur)
  {
    m_fluxInfra.setIdPeriodeActivite(pValeur);
  }
  
  public void setCodeErreurIdPeriodeActivite(String pCodeErreur)
  {
    m_fluxInfra.setIdPeriodeActivite_C_ERR(pCodeErreur);
  }
  
  public FluxDSN getFluxDSN()
  {
    _FluxDSN infraItem = m_fluxInfra.getFluxDSN();
    _FluxDSNImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxDSNImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxDSN(FluxDSN pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxDSN(null);
    }
    else
    {
      _FluxDSNImpl subImpl = (_FluxDSNImpl)pValeur;
      m_fluxInfra.setFluxDSN(subImpl.getFluxDSNInfra());
    }
  }
  
  public FluxDSN setNewFluxDSN()
  {
    _FluxDSNImpl item = new _FluxDSNImpl();
    m_fluxInfra.setFluxDSN(item.getFluxDSNInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxDSN setNewFluxDSN_fluxDSN()
  {
    return setNewFluxDSN();
  }
  
  public FluxCtPasDsn getFluxCtPasDsn()
  {
    _FluxCtPasDsn infraItem = m_fluxInfra.getFluxCtPasDsn();
    _FluxCtPasDsnImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxCtPasDsnImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxCtPasDsn(FluxCtPasDsn pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxCtPasDsn(null);
    }
    else
    {
      _FluxCtPasDsnImpl subImpl = (_FluxCtPasDsnImpl)pValeur;
      m_fluxInfra.setFluxCtPasDsn(subImpl.getFluxCtPasDsnInfra());
    }
  }
  
  public FluxCtPasDsn setNewFluxCtPasDsn()
  {
    _FluxCtPasDsnImpl item = new _FluxCtPasDsnImpl();
    m_fluxInfra.setFluxCtPasDsn(item.getFluxCtPasDsnInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxCtPasDsn setNewFluxCtPasDsn_fluxCtPasDsn()
  {
    return setNewFluxCtPasDsn();
  }
  
  public FluxPrimeIndemDsn getFluxPrimeIndemDsn()
  {
    _FluxPrimeIndemDsn infraItem = m_fluxInfra.getFluxPrimeIndemDsn();
    _FluxPrimeIndemDsnImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxPrimeIndemDsnImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxPrimeIndemDsn(FluxPrimeIndemDsn pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxPrimeIndemDsn(null);
    }
    else
    {
      _FluxPrimeIndemDsnImpl subImpl = (_FluxPrimeIndemDsnImpl)pValeur;
      m_fluxInfra.setFluxPrimeIndemDsn(subImpl.getFluxPrimeIndemDsnInfra());
    }
  }
  
  public FluxPrimeIndemDsn setNewFluxPrimeIndemDsn()
  {
    _FluxPrimeIndemDsnImpl item = new _FluxPrimeIndemDsnImpl();
    m_fluxInfra.setFluxPrimeIndemDsn(item.getFluxPrimeIndemDsnInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxPrimeIndemDsn setNewFluxPrimeIndemDsn_fluxPrimeIndemDsn()
  {
    return setNewFluxPrimeIndemDsn();
  }
  
  public FluxAbsenceFormation getFluxAbsenceFormation()
  {
    _FluxAbsenceFormation infraItem = m_fluxInfra.getFluxAbsenceFormation();
    _FluxAbsenceFormationImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxAbsenceFormationImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxAbsenceFormation(FluxAbsenceFormation pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxAbsenceFormation(null);
    }
    else
    {
      _FluxAbsenceFormationImpl subImpl = (_FluxAbsenceFormationImpl)pValeur;
      m_fluxInfra.setFluxAbsenceFormation(subImpl.getFluxAbsenceFormationInfra());
    }
  }
  
  public FluxAbsenceFormation setNewFluxAbsenceFormation()
  {
    _FluxAbsenceFormationImpl item = new _FluxAbsenceFormationImpl();
    m_fluxInfra.setFluxAbsenceFormation(item.getFluxAbsenceFormationInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxAbsenceFormation setNewFluxAbsenceFormation_fluxAbsenceFormation()
  {
    return setNewFluxAbsenceFormation();
  }
  
  public FluxPeriodeAbsenceFormation getFluxPeriodeAbsenceFormation()
  {
    _FluxPeriodeAbsenceFormation infraItem = m_fluxInfra.getFluxPeriodeAbsenceFormation();
    _FluxPeriodeAbsenceFormationImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxPeriodeAbsenceFormationImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxPeriodeAbsenceFormation(FluxPeriodeAbsenceFormation pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxPeriodeAbsenceFormation(null);
    }
    else
    {
      _FluxPeriodeAbsenceFormationImpl subImpl = (_FluxPeriodeAbsenceFormationImpl)pValeur;
      m_fluxInfra.setFluxPeriodeAbsenceFormation(subImpl.getFluxPeriodeAbsenceFormationInfra());
    }
  }
  
  public FluxPeriodeAbsenceFormation setNewFluxPeriodeAbsenceFormation()
  {
    _FluxPeriodeAbsenceFormationImpl item = new _FluxPeriodeAbsenceFormationImpl();
    m_fluxInfra.setFluxPeriodeAbsenceFormation(item.getFluxPeriodeAbsenceFormationInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxPeriodeAbsenceFormation setNewFluxPeriodeAbsenceFormation_fluxPeriodeAbsenceFormation()
  {
    return setNewFluxPeriodeAbsenceFormation();
  }
  
  public FluxCaliDeseng getFluxCaliDeseng()
  {
    _FluxCaliDeseng infraItem = m_fluxInfra.getFluxCaliDeseng();
    _FluxCaliDesengImpl resultat = null;
    if (infraItem != null) {
      resultat = new _FluxCaliDesengImpl(infraItem);
    }
    return resultat;
  }
  
  public void setFluxCaliDeseng(FluxCaliDeseng pValeur)
  {
    if (pValeur == null)
    {
      m_fluxInfra.setFluxCaliDeseng(null);
    }
    else
    {
      _FluxCaliDesengImpl subImpl = (_FluxCaliDesengImpl)pValeur;
      m_fluxInfra.setFluxCaliDeseng(subImpl.getFluxCaliDesengInfra());
    }
  }
  
  public FluxCaliDeseng setNewFluxCaliDeseng()
  {
    _FluxCaliDesengImpl item = new _FluxCaliDesengImpl();
    m_fluxInfra.setFluxCaliDeseng(item.getFluxCaliDesengInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public FluxCaliDeseng setNewFluxCaliDeseng_fluxCaliDeseng()
  {
    return setNewFluxCaliDeseng();
  }
  
  public _Flux getFluxInfra()
  {
    return m_fluxInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objFlux_fluxCAF = getFluxCAF();
    if ((objFlux_fluxCAF != null) && 
      (getFluxCAF().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxETT = getFluxETT();
    if ((objFlux_fluxETT != null) && 
      (getFluxETT().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxCSS = getFluxCSS();
    if ((objFlux_fluxCSS != null) && 
      (getFluxCSS().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxDSM = getFluxDSM();
    if ((objFlux_fluxDSM != null) && 
      (getFluxDSM().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxGUSO = getFluxGUSO();
    if ((objFlux_fluxGUSO != null) && 
      (getFluxGUSO().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxCPAM = getFluxCPAM();
    if ((objFlux_fluxCPAM != null) && 
      (getFluxCPAM().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxAEM = getFluxAEM();
    if ((objFlux_fluxAEM != null) && 
      (getFluxAEM().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxBS = getFluxBS();
    if ((objFlux_fluxBS != null) && 
      (getFluxBS().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxPasDna = getFluxPasDna();
    if ((objFlux_fluxPasDna != null) && 
      (getFluxPasDna().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxFctDna = getFluxFctDna();
    if ((objFlux_fluxFctDna != null) && 
      (getFluxFctDna().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxCali = getFluxCali();
    if ((objFlux_fluxCali != null) && 
      (getFluxCali().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxMSA = getFluxMSA();
    if ((objFlux_fluxMSA != null) && 
      (getFluxMSA().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxDMM = getFluxDMM();
    if ((objFlux_fluxDMM != null) && 
      (getFluxDMM().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxAE = getFluxAE();
    if ((objFlux_fluxAE != null) && 
      (getFluxAE().isEnErreur())) {
      return true;
    }
    if ((getCodeErreurMotifAnomalie() != null) && 
      ("".equals(getCodeErreurMotifAnomalie()))) {
      return true;
    }
    if ((getCodeErreurCommentaire() != null) && 
      ("".equals(getCodeErreurCommentaire()))) {
      return true;
    }
    if ((getCodeErreurTypeFlux() != null) && 
      ("".equals(getCodeErreurTypeFlux()))) {
      return true;
    }
    if ((getCodeErreurIdFlux() != null) && 
      ("".equals(getCodeErreurIdFlux()))) {
      return true;
    }
    if ((getCodeErreurVersion() != null) && 
      ("".equals(getCodeErreurVersion()))) {
      return true;
    }
    if ((getCodeErreurIdTechPas() != null) && 
      ("".equals(getCodeErreurIdTechPas()))) {
      return true;
    }
    if ((getCodeErreurNumeroContrat() != null) && 
      ("".equals(getCodeErreurNumeroContrat()))) {
      return true;
    }
    if ((getCodeErreurDateTraitement() != null) && 
      ("".equals(getCodeErreurDateTraitement()))) {
      return true;
    }
    if ((getCodeErreurDateVisa() != null) && 
      ("".equals(getCodeErreurDateVisa()))) {
      return true;
    }
    if ((getCodeErreurDateConnaissanceInfo() != null) && 
      ("".equals(getCodeErreurDateConnaissanceInfo()))) {
      return true;
    }
    if ((getCodeErreurIndicateurOrigine() != null) && 
      ("".equals(getCodeErreurIndicateurOrigine()))) {
      return true;
    }
    if ((getCodeErreurIdPeriodeActivite() != null) && 
      ("".equals(getCodeErreurIdPeriodeActivite()))) {
      return true;
    }
    Object objFlux_fluxDSN = getFluxDSN();
    if ((objFlux_fluxDSN != null) && 
      (getFluxDSN().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxCtPasDsn = getFluxCtPasDsn();
    if ((objFlux_fluxCtPasDsn != null) && 
      (getFluxCtPasDsn().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxPrimeIndemDsn = getFluxPrimeIndemDsn();
    if ((objFlux_fluxPrimeIndemDsn != null) && 
      (getFluxPrimeIndemDsn().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxAbsenceFormation = getFluxAbsenceFormation();
    if ((objFlux_fluxAbsenceFormation != null) && 
      (getFluxAbsenceFormation().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxPeriodeAbsenceFormation = getFluxPeriodeAbsenceFormation();
    if ((objFlux_fluxPeriodeAbsenceFormation != null) && 
      (getFluxPeriodeAbsenceFormation().isEnErreur())) {
      return true;
    }
    Object objFlux_fluxCaliDeseng = getFluxCaliDeseng();
    if ((objFlux_fluxCaliDeseng != null) && 
      (getFluxCaliDeseng().isEnErreur())) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */