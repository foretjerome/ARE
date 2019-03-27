package fr.pe.d12dal.service.es.dal;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _InfosDalCALIImpl
  extends InfosDalCALI
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _InfosDalCALI m_infosDalCALIInfra;
  
  public _InfosDalCALIImpl()
  {
    m_infosDalCALIInfra = new _InfosDalCALI();
  }
  
  public _InfosDalCALIImpl(_InfosDalCALI pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("InfosDalCALIInfra", pValeur);
    
    m_infosDalCALIInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_infosDalCALIInfra;
  }
  
  public String getIdentifiant()
  {
    return m_infosDalCALIInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_infosDalCALIInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_infosDalCALIInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_infosDalCALIInfra.set_C_ETAT(pCode);
  }
  
  public String getRefusPropositionFNE()
  {
    return m_infosDalCALIInfra.getRefusPropositionFNE();
  }
  
  public String getCodeErreurRefusPropositionFNE()
  {
    return m_infosDalCALIInfra.getRefusPropositionFNE_C_ERR();
  }
  
  public void setRefusPropositionFNE(String pValeur)
  {
    m_infosDalCALIInfra.setRefusPropositionFNE(pValeur);
  }
  
  public void setCodeErreurRefusPropositionFNE(String pCodeErreur)
  {
    m_infosDalCALIInfra.setRefusPropositionFNE_C_ERR(pCodeErreur);
  }
  
  public Boolean getArtisteNonSalarie()
  {
    return m_infosDalCALIInfra.getArtisteNonSalarie();
  }
  
  public String getCodeErreurArtisteNonSalarie()
  {
    return m_infosDalCALIInfra.getArtisteNonSalarie_C_ERR();
  }
  
  public void setArtisteNonSalarie(Boolean pValeur)
  {
    m_infosDalCALIInfra.setArtisteNonSalarie(pValeur);
  }
  
  public void setCodeErreurArtisteNonSalarie(String pCodeErreur)
  {
    m_infosDalCALIInfra.setArtisteNonSalarie_C_ERR(pCodeErreur);
  }
  
  public Boolean getMarinPecheur()
  {
    return m_infosDalCALIInfra.getMarinPecheur();
  }
  
  public String getCodeErreurMarinPecheur()
  {
    return m_infosDalCALIInfra.getMarinPecheur_C_ERR();
  }
  
  public void setMarinPecheur(Boolean pValeur)
  {
    m_infosDalCALIInfra.setMarinPecheur(pValeur);
  }
  
  public void setCodeErreurMarinPecheur(String pCodeErreur)
  {
    m_infosDalCALIInfra.setMarinPecheur_C_ERR(pCodeErreur);
  }
  
  public Boolean getDockerOccasionnel()
  {
    return m_infosDalCALIInfra.getDockerOccasionnel();
  }
  
  public String getCodeErreurDockerOccasionnel()
  {
    return m_infosDalCALIInfra.getDockerOccasionnel_C_ERR();
  }
  
  public void setDockerOccasionnel(Boolean pValeur)
  {
    m_infosDalCALIInfra.setDockerOccasionnel(pValeur);
  }
  
  public void setCodeErreurDockerOccasionnel(String pCodeErreur)
  {
    m_infosDalCALIInfra.setDockerOccasionnel_C_ERR(pCodeErreur);
  }
  
  public Boolean getDetenuLibere()
  {
    return m_infosDalCALIInfra.getDetenuLibere();
  }
  
  public String getCodeErreurDetenuLibere()
  {
    return m_infosDalCALIInfra.getDetenuLibere_C_ERR();
  }
  
  public void setDetenuLibere(Boolean pValeur)
  {
    m_infosDalCALIInfra.setDetenuLibere(pValeur);
  }
  
  public void setCodeErreurDetenuLibere(String pCodeErreur)
  {
    m_infosDalCALIInfra.setDetenuLibere_C_ERR(pCodeErreur);
  }
  
  public Boolean getSalarieExpatrie()
  {
    return m_infosDalCALIInfra.getSalarieExpatrie();
  }
  
  public String getCodeErreurSalarieExpatrie()
  {
    return m_infosDalCALIInfra.getSalarieExpatrie_C_ERR();
  }
  
  public void setSalarieExpatrie(Boolean pValeur)
  {
    m_infosDalCALIInfra.setSalarieExpatrie(pValeur);
  }
  
  public void setCodeErreurSalarieExpatrie(String pCodeErreur)
  {
    m_infosDalCALIInfra.setSalarieExpatrie_C_ERR(pCodeErreur);
  }
  
  public String getStatutDemande()
  {
    return m_infosDalCALIInfra.getStatutDemande();
  }
  
  public String getCodeErreurStatutDemande()
  {
    return m_infosDalCALIInfra.getStatutDemande_C_ERR();
  }
  
  public void setStatutDemande(String pValeur)
  {
    m_infosDalCALIInfra.setStatutDemande(pValeur);
  }
  
  public void setCodeErreurStatutDemande(String pCodeErreur)
  {
    m_infosDalCALIInfra.setStatutDemande_C_ERR(pCodeErreur);
  }
  
  public String getRefExterne()
  {
    return m_infosDalCALIInfra.getRefExterne();
  }
  
  public String getCodeErreurRefExterne()
  {
    return m_infosDalCALIInfra.getRefExterne_C_ERR();
  }
  
  public void setRefExterne(String pValeur)
  {
    m_infosDalCALIInfra.setRefExterne(pValeur);
  }
  
  public void setCodeErreurRefExterne(String pCodeErreur)
  {
    m_infosDalCALIInfra.setRefExterne_C_ERR(pCodeErreur);
  }
  
  public InfosDalCALI_periodesAffiliations getPeriodesAffiliations()
  {
    _InfosDalCALI_periodesAffiliations infraItem = m_infosDalCALIInfra.getPeriodesAffiliations();
    _InfosDalCALI_periodesAffiliationsImpl resultat = null;
    if (infraItem != null) {
      resultat = new _InfosDalCALI_periodesAffiliationsImpl(infraItem);
    }
    return resultat;
  }
  
  public void setPeriodesAffiliations(InfosDalCALI_periodesAffiliations pValeur)
  {
    if (pValeur == null)
    {
      m_infosDalCALIInfra.setPeriodesAffiliations(null);
    }
    else
    {
      _InfosDalCALI_periodesAffiliationsImpl subImpl = (_InfosDalCALI_periodesAffiliationsImpl)pValeur;
      m_infosDalCALIInfra.setPeriodesAffiliations(subImpl.getInfosDalCALI_periodesAffiliationsInfra());
    }
  }
  
  public InfosDalCALI_periodesAffiliations setNewInfosDalCALI_periodesAffiliations()
  {
    _InfosDalCALI_periodesAffiliationsImpl item = new _InfosDalCALI_periodesAffiliationsImpl();
    m_infosDalCALIInfra.setPeriodesAffiliations(item.getInfosDalCALI_periodesAffiliationsInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public InfosDalCALI_periodesAffiliations setNewInfosDalCALI_periodesAffiliations_periodesAffiliations()
  {
    return setNewInfosDalCALI_periodesAffiliations();
  }
  
  /**
   * @deprecated
   */
  public InfosDalCALI_periodesAffiliations setNewPeriodesAffiliations()
  {
    return setNewInfosDalCALI_periodesAffiliations();
  }
  
  public InfosLiquidationDal getInfosLiquidationDAL()
  {
    _InfosLiquidationDal infraItem = m_infosDalCALIInfra.getInfosLiquidationDAL();
    _InfosLiquidationDalImpl resultat = null;
    if (infraItem != null) {
      resultat = new _InfosLiquidationDalImpl(infraItem);
    }
    return resultat;
  }
  
  public void setInfosLiquidationDAL(InfosLiquidationDal pValeur)
  {
    if (pValeur == null)
    {
      m_infosDalCALIInfra.setInfosLiquidationDAL(null);
    }
    else
    {
      _InfosLiquidationDalImpl subImpl = (_InfosLiquidationDalImpl)pValeur;
      m_infosDalCALIInfra.setInfosLiquidationDAL(subImpl.getInfosLiquidationDalInfra());
    }
  }
  
  public InfosLiquidationDal setNewInfosLiquidationDal()
  {
    _InfosLiquidationDalImpl item = new _InfosLiquidationDalImpl();
    m_infosDalCALIInfra.setInfosLiquidationDAL(item.getInfosLiquidationDalInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public InfosLiquidationDal setNewInfosLiquidationDal_infosLiquidationDAL()
  {
    return setNewInfosLiquidationDal();
  }
  
  /**
   * @deprecated
   */
  public InfosLiquidationDal setNewInfosLiquidationDAL()
  {
    return setNewInfosLiquidationDal();
  }
  
  public String getIdentifiantDemandeInstruction()
  {
    return m_infosDalCALIInfra.getIdentifiantDemandeInstruction();
  }
  
  public String getCodeErreurIdentifiantDemandeInstruction()
  {
    return m_infosDalCALIInfra.getIdentifiantDemandeInstruction_C_ERR();
  }
  
  public void setIdentifiantDemandeInstruction(String pValeur)
  {
    m_infosDalCALIInfra.setIdentifiantDemandeInstruction(pValeur);
  }
  
  public void setCodeErreurIdentifiantDemandeInstruction(String pCodeErreur)
  {
    m_infosDalCALIInfra.setIdentifiantDemandeInstruction_C_ERR(pCodeErreur);
  }
  
  public Date getDateDJA()
  {
    return m_infosDalCALIInfra.getDateDJA();
  }
  
  public String getCodeErreurDateDJA()
  {
    return m_infosDalCALIInfra.getDateDJA_C_ERR();
  }
  
  public void setDateDJA(Date pValeur)
  {
    m_infosDalCALIInfra.setDateDJA(pValeur);
  }
  
  public void setCodeErreurDateDJA(String pCodeErreur)
  {
    m_infosDalCALIInfra.setDateDJA_C_ERR(pCodeErreur);
  }
  
  public _InfosDalCALI getInfosDalCALIInfra()
  {
    return m_infosDalCALIInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurRefusPropositionFNE() != null) && 
      ("".equals(getCodeErreurRefusPropositionFNE()))) {
      return true;
    }
    if ((getCodeErreurArtisteNonSalarie() != null) && 
      ("".equals(getCodeErreurArtisteNonSalarie()))) {
      return true;
    }
    if ((getCodeErreurMarinPecheur() != null) && 
      ("".equals(getCodeErreurMarinPecheur()))) {
      return true;
    }
    if ((getCodeErreurDockerOccasionnel() != null) && 
      ("".equals(getCodeErreurDockerOccasionnel()))) {
      return true;
    }
    if ((getCodeErreurDetenuLibere() != null) && 
      ("".equals(getCodeErreurDetenuLibere()))) {
      return true;
    }
    if ((getCodeErreurSalarieExpatrie() != null) && 
      ("".equals(getCodeErreurSalarieExpatrie()))) {
      return true;
    }
    if ((getCodeErreurStatutDemande() != null) && 
      ("".equals(getCodeErreurStatutDemande()))) {
      return true;
    }
    if ((getCodeErreurRefExterne() != null) && 
      ("".equals(getCodeErreurRefExterne()))) {
      return true;
    }
    Object objInfosDalCALI_periodesAffiliations = getPeriodesAffiliations();
    if ((objInfosDalCALI_periodesAffiliations != null) && 
      (getPeriodesAffiliations().isEnErreur())) {
      return true;
    }
    Object objInfosDalCALI_infosLiquidationDAL = getInfosLiquidationDAL();
    if ((objInfosDalCALI_infosLiquidationDAL != null) && 
      (getInfosLiquidationDAL().isEnErreur())) {
      return true;
    }
    if ((getCodeErreurIdentifiantDemandeInstruction() != null) && 
      ("".equals(getCodeErreurIdentifiantDemandeInstruction()))) {
      return true;
    }
    if ((getCodeErreurDateDJA() != null) && 
      ("".equals(getCodeErreurDateDJA()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _InfosDalCALIImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */