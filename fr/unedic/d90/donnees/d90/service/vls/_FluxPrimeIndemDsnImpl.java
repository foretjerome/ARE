package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxPrimeIndemDsnImpl
  extends FluxPrimeIndemDsn
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxPrimeIndemDsn m_fluxPrimeIndemDsnInfra;
  
  public _FluxPrimeIndemDsnImpl()
  {
    m_fluxPrimeIndemDsnInfra = new _FluxPrimeIndemDsn();
  }
  
  public _FluxPrimeIndemDsnImpl(_FluxPrimeIndemDsn pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxPrimeIndemDsnInfra", pValeur);
    
    m_fluxPrimeIndemDsnInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxPrimeIndemDsnInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxPrimeIndemDsnInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxPrimeIndemDsnInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxPrimeIndemDsnInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxPrimeIndemDsnInfra.set_C_ETAT(pCode);
  }
  
  public String getTypeEnreg()
  {
    return m_fluxPrimeIndemDsnInfra.getTypeEnreg();
  }
  
  public String getCodeErreurTypeEnreg()
  {
    return m_fluxPrimeIndemDsnInfra.getTypeEnreg_C_ERR();
  }
  
  public void setTypeEnreg(String pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setTypeEnreg(pValeur);
  }
  
  public void setCodeErreurTypeEnreg(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setTypeEnreg_C_ERR(pCodeErreur);
  }
  
  public String getNumNIRCertifie()
  {
    return m_fluxPrimeIndemDsnInfra.getNumNIRCertifie();
  }
  
  public String getCodeErreurNumNIRCertifie()
  {
    return m_fluxPrimeIndemDsnInfra.getNumNIRCertifie_C_ERR();
  }
  
  public void setNumNIRCertifie(String pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setNumNIRCertifie(pValeur);
  }
  
  public void setCodeErreurNumNIRCertifie(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setNumNIRCertifie_C_ERR(pCodeErreur);
  }
  
  public String getNomDeclare()
  {
    return m_fluxPrimeIndemDsnInfra.getNomDeclare();
  }
  
  public String getCodeErreurNomDeclare()
  {
    return m_fluxPrimeIndemDsnInfra.getNomDeclare_C_ERR();
  }
  
  public void setNomDeclare(String pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setNomDeclare(pValeur);
  }
  
  public void setCodeErreurNomDeclare(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setNomDeclare_C_ERR(pCodeErreur);
  }
  
  public String getPrenomDeclare()
  {
    return m_fluxPrimeIndemDsnInfra.getPrenomDeclare();
  }
  
  public String getCodeErreurPrenomDeclare()
  {
    return m_fluxPrimeIndemDsnInfra.getPrenomDeclare_C_ERR();
  }
  
  public void setPrenomDeclare(String pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setPrenomDeclare(pValeur);
  }
  
  public void setCodeErreurPrenomDeclare(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setPrenomDeclare_C_ERR(pCodeErreur);
  }
  
  public Damj getDateNaissance()
  {
    return m_fluxPrimeIndemDsnInfra.getDateNaissance();
  }
  
  public String getCodeErreurDateNaissance()
  {
    return m_fluxPrimeIndemDsnInfra.getDateNaissance_C_ERR();
  }
  
  public void setDateNaissance(Damj pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setDateNaissance(pValeur);
  }
  
  public void setCodeErreurDateNaissance(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setDateNaissance_C_ERR(pCodeErreur);
  }
  
  public String getContexteEmission()
  {
    return m_fluxPrimeIndemDsnInfra.getContexteEmission();
  }
  
  public String getCodeErreurContexteEmission()
  {
    return m_fluxPrimeIndemDsnInfra.getContexteEmission_C_ERR();
  }
  
  public void setContexteEmission(String pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setContexteEmission(pValeur);
  }
  
  public void setCodeErreurContexteEmission(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setContexteEmission_C_ERR(pCodeErreur);
  }
  
  public String getCodeMessage()
  {
    return m_fluxPrimeIndemDsnInfra.getCodeMessage();
  }
  
  public String getCodeErreurCodeMessage()
  {
    return m_fluxPrimeIndemDsnInfra.getCodeMessage_C_ERR();
  }
  
  public void setCodeMessage(String pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setCodeMessage(pValeur);
  }
  
  public void setCodeErreurCodeMessage(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setCodeMessage_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNumeroVersion()
  {
    return m_fluxPrimeIndemDsnInfra.getNumeroVersion();
  }
  
  public String getCodeErreurNumeroVersion()
  {
    return m_fluxPrimeIndemDsnInfra.getNumeroVersion_C_ERR();
  }
  
  public void setNumeroVersion(BigDecimal pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setNumeroVersion(pValeur);
  }
  
  public void setCodeErreurNumeroVersion(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setNumeroVersion_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNumeroSousVersion()
  {
    return m_fluxPrimeIndemDsnInfra.getNumeroSousVersion();
  }
  
  public String getCodeErreurNumeroSousVersion()
  {
    return m_fluxPrimeIndemDsnInfra.getNumeroSousVersion_C_ERR();
  }
  
  public void setNumeroSousVersion(BigDecimal pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setNumeroSousVersion(pValeur);
  }
  
  public void setCodeErreurNumeroSousVersion(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setNumeroSousVersion_C_ERR(pCodeErreur);
  }
  
  public String getCodeAction()
  {
    return m_fluxPrimeIndemDsnInfra.getCodeAction();
  }
  
  public String getCodeErreurCodeAction()
  {
    return m_fluxPrimeIndemDsnInfra.getCodeAction_C_ERR();
  }
  
  public void setCodeAction(String pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setCodeAction(pValeur);
  }
  
  public void setCodeErreurCodeAction(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setCodeAction_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdTechnique()
  {
    return m_fluxPrimeIndemDsnInfra.getIdTechnique();
  }
  
  public String getCodeErreurIdTechnique()
  {
    return m_fluxPrimeIndemDsnInfra.getIdTechnique_C_ERR();
  }
  
  public void setIdTechnique(BigDecimal pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setIdTechnique(pValeur);
  }
  
  public void setCodeErreurIdTechnique(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setIdTechnique_C_ERR(pCodeErreur);
  }
  
  public String getNumeroRCI()
  {
    return m_fluxPrimeIndemDsnInfra.getNumeroRCI();
  }
  
  public String getCodeErreurNumeroRCI()
  {
    return m_fluxPrimeIndemDsnInfra.getNumeroRCI_C_ERR();
  }
  
  public void setNumeroRCI(String pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setNumeroRCI(pValeur);
  }
  
  public void setCodeErreurNumeroRCI(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setNumeroRCI_C_ERR(pCodeErreur);
  }
  
  public String getCxass()
  {
    return m_fluxPrimeIndemDsnInfra.getCxass();
  }
  
  public String getCodeErreurCxass()
  {
    return m_fluxPrimeIndemDsnInfra.getCxass_C_ERR();
  }
  
  public void setCxass(String pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setCxass(pValeur);
  }
  
  public void setCodeErreurCxass(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setCxass_C_ERR(pCodeErreur);
  }
  
  public String getRsin()
  {
    return m_fluxPrimeIndemDsnInfra.getRsin();
  }
  
  public String getCodeErreurRsin()
  {
    return m_fluxPrimeIndemDsnInfra.getRsin_C_ERR();
  }
  
  public void setRsin(String pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setRsin(pValeur);
  }
  
  public void setCodeErreurRsin(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setRsin_C_ERR(pCodeErreur);
  }
  
  public ListeFluxPrimeIndemVerseesDsn getListeFluxPrimeIndemVerseesDsn()
  {
    _ListeFluxPrimeIndemVerseesDsn infraItem = m_fluxPrimeIndemDsnInfra.getListeFluxPrimeIndemVerseesDsn();
    _ListeFluxPrimeIndemVerseesDsnImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeFluxPrimeIndemVerseesDsnImpl(infraItem);
    }
    return resultat;
  }
  
  /**
   * @deprecated
   */
  public ListeFluxPrimeIndemVerseesDsn getListeFluxPrimIndemVerseesDsn()
  {
    return getListeFluxPrimeIndemVerseesDsn();
  }
  
  public void setListeFluxPrimeIndemVerseesDsn(ListeFluxPrimeIndemVerseesDsn pValeur)
  {
    if (pValeur == null)
    {
      m_fluxPrimeIndemDsnInfra.setListeFluxPrimeIndemVerseesDsn(null);
    }
    else
    {
      _ListeFluxPrimeIndemVerseesDsnImpl subImpl = (_ListeFluxPrimeIndemVerseesDsnImpl)pValeur;
      m_fluxPrimeIndemDsnInfra.setListeFluxPrimeIndemVerseesDsn(subImpl.getListeFluxPrimeIndemVerseesDsnInfra());
    }
  }
  
  /**
   * @deprecated
   */
  public void setListeFluxPrimIndemVerseesDsn(ListeFluxPrimeIndemVerseesDsn pValeur)
  {
    setListeFluxPrimeIndemVerseesDsn(pValeur);
  }
  
  public ListeFluxPrimeIndemVerseesDsn setNewListeFluxPrimeIndemVerseesDsn()
  {
    _ListeFluxPrimeIndemVerseesDsnImpl item = new _ListeFluxPrimeIndemVerseesDsnImpl();
    m_fluxPrimeIndemDsnInfra.setListeFluxPrimeIndemVerseesDsn(item.getListeFluxPrimeIndemVerseesDsnInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeFluxPrimeIndemVerseesDsn setNewListeFluxPrimeIndemVerseesDsn_listeFluxPrimIndemVerseesDsn()
  {
    return setNewListeFluxPrimeIndemVerseesDsn();
  }
  
  /**
   * @deprecated
   */
  public ListeFluxPrimeIndemVerseesDsn setNewListeFluxPrimIndemVerseesDsn()
  {
    return setNewListeFluxPrimeIndemVerseesDsn();
  }
  
  public String getIdFlux()
  {
    return m_fluxPrimeIndemDsnInfra.getIdFlux();
  }
  
  public String getCodeErreurIdFlux()
  {
    return m_fluxPrimeIndemDsnInfra.getIdFlux_C_ERR();
  }
  
  public void setIdFlux(String pValeur)
  {
    m_fluxPrimeIndemDsnInfra.setIdFlux(pValeur);
  }
  
  public void setCodeErreurIdFlux(String pCodeErreur)
  {
    m_fluxPrimeIndemDsnInfra.setIdFlux_C_ERR(pCodeErreur);
  }
  
  public _FluxPrimeIndemDsn getFluxPrimeIndemDsnInfra()
  {
    return m_fluxPrimeIndemDsnInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurTypeEnreg() != null) && 
      ("".equals(getCodeErreurTypeEnreg()))) {
      return true;
    }
    if ((getCodeErreurNumNIRCertifie() != null) && 
      ("".equals(getCodeErreurNumNIRCertifie()))) {
      return true;
    }
    if ((getCodeErreurNomDeclare() != null) && 
      ("".equals(getCodeErreurNomDeclare()))) {
      return true;
    }
    if ((getCodeErreurPrenomDeclare() != null) && 
      ("".equals(getCodeErreurPrenomDeclare()))) {
      return true;
    }
    if ((getCodeErreurDateNaissance() != null) && 
      ("".equals(getCodeErreurDateNaissance()))) {
      return true;
    }
    if ((getCodeErreurContexteEmission() != null) && 
      ("".equals(getCodeErreurContexteEmission()))) {
      return true;
    }
    if ((getCodeErreurCodeMessage() != null) && 
      ("".equals(getCodeErreurCodeMessage()))) {
      return true;
    }
    if ((getCodeErreurNumeroVersion() != null) && 
      ("".equals(getCodeErreurNumeroVersion()))) {
      return true;
    }
    if ((getCodeErreurNumeroSousVersion() != null) && 
      ("".equals(getCodeErreurNumeroSousVersion()))) {
      return true;
    }
    if ((getCodeErreurCodeAction() != null) && 
      ("".equals(getCodeErreurCodeAction()))) {
      return true;
    }
    if ((getCodeErreurIdTechnique() != null) && 
      ("".equals(getCodeErreurIdTechnique()))) {
      return true;
    }
    if ((getCodeErreurNumeroRCI() != null) && 
      ("".equals(getCodeErreurNumeroRCI()))) {
      return true;
    }
    if ((getCodeErreurCxass() != null) && 
      ("".equals(getCodeErreurCxass()))) {
      return true;
    }
    if ((getCodeErreurRsin() != null) && 
      ("".equals(getCodeErreurRsin()))) {
      return true;
    }
    Object objListeFluxPrimeIndemVerseesDsn = getListeFluxPrimeIndemVerseesDsn();
    if ((objListeFluxPrimeIndemVerseesDsn != null) && 
      (getListeFluxPrimeIndemVerseesDsn().isEnErreur())) {
      return true;
    }
    if ((getCodeErreurIdFlux() != null) && 
      ("".equals(getCodeErreurIdFlux()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxPrimeIndemDsnImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */