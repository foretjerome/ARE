package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxDSMImpl
  extends FluxDSM
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxDSM m_fluxDSMInfra;
  
  public _FluxDSMImpl()
  {
    m_fluxDSMInfra = new _FluxDSM();
  }
  
  public _FluxDSMImpl(_FluxDSM pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxDSMInfra", pValeur);
    
    m_fluxDSMInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxDSMInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxDSMInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxDSMInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxDSMInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxDSMInfra.set_C_ETAT(pCode);
  }
  
  public ListeDSMTravail getListeDSMTravail()
  {
    _ListeDSMTravail infraItem = m_fluxDSMInfra.getListeDSMTravail();
    _ListeDSMTravailImpl resultat = null;
    if (infraItem != null) {
      resultat = new _ListeDSMTravailImpl(infraItem);
    }
    return resultat;
  }
  
  public void setListeDSMTravail(ListeDSMTravail pValeur)
  {
    if (pValeur == null)
    {
      m_fluxDSMInfra.setListeDSMTravail(null);
    }
    else
    {
      _ListeDSMTravailImpl subImpl = (_ListeDSMTravailImpl)pValeur;
      m_fluxDSMInfra.setListeDSMTravail(subImpl.getListeDSMTravailInfra());
    }
  }
  
  public ListeDSMTravail setNewListeDSMTravail()
  {
    _ListeDSMTravailImpl item = new _ListeDSMTravailImpl();
    m_fluxDSMInfra.setListeDSMTravail(item.getListeDSMTravailInfra());
    return item;
  }
  
  /**
   * @deprecated
   */
  public ListeDSMTravail setNewListeDSMTravail_listeDSMTravail()
  {
    return setNewListeDSMTravail();
  }
  
  public String getFlagA8A10()
  {
    return m_fluxDSMInfra.getFlagA8A10();
  }
  
  public String getCodeErreurFlagA8A10()
  {
    return m_fluxDSMInfra.getFlagA8A10_C_ERR();
  }
  
  public void setFlagA8A10(String pValeur)
  {
    m_fluxDSMInfra.setFlagA8A10(pValeur);
  }
  
  public void setCodeErreurFlagA8A10(String pCodeErreur)
  {
    m_fluxDSMInfra.setFlagA8A10_C_ERR(pCodeErreur);
  }
  
  public String getDeclareJustifie()
  {
    return m_fluxDSMInfra.getDeclareJustifie();
  }
  
  public String getCodeErreurDeclareJustifie()
  {
    return m_fluxDSMInfra.getDeclareJustifie_C_ERR();
  }
  
  public void setDeclareJustifie(String pValeur)
  {
    m_fluxDSMInfra.setDeclareJustifie(pValeur);
  }
  
  public void setCodeErreurDeclareJustifie(String pCodeErreur)
  {
    m_fluxDSMInfra.setDeclareJustifie_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurPresenceTravail()
  {
    return m_fluxDSMInfra.getIndicateurPresenceTravail();
  }
  
  public String getCodeErreurIndicateurPresenceTravail()
  {
    return m_fluxDSMInfra.getIndicateurPresenceTravail_C_ERR();
  }
  
  public void setIndicateurPresenceTravail(String pValeur)
  {
    m_fluxDSMInfra.setIndicateurPresenceTravail(pValeur);
  }
  
  public void setCodeErreurIndicateurPresenceTravail(String pCodeErreur)
  {
    m_fluxDSMInfra.setIndicateurPresenceTravail_C_ERR(pCodeErreur);
  }
  
  public String getOrigineSaisieDsm()
  {
    return m_fluxDSMInfra.getOrigineSaisieDsm();
  }
  
  public String getCodeErreurOrigineSaisieDsm()
  {
    return m_fluxDSMInfra.getOrigineSaisieDsm_C_ERR();
  }
  
  public void setOrigineSaisieDsm(String pValeur)
  {
    m_fluxDSMInfra.setOrigineSaisieDsm(pValeur);
  }
  
  public void setCodeErreurOrigineSaisieDsm(String pCodeErreur)
  {
    m_fluxDSMInfra.setOrigineSaisieDsm_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutFormation()
  {
    return m_fluxDSMInfra.getDateDebutFormation();
  }
  
  public String getCodeErreurDateDebutFormation()
  {
    return m_fluxDSMInfra.getDateDebutFormation_C_ERR();
  }
  
  public void setDateDebutFormation(Damj pValeur)
  {
    m_fluxDSMInfra.setDateDebutFormation(pValeur);
  }
  
  public void setCodeErreurDateDebutFormation(String pCodeErreur)
  {
    m_fluxDSMInfra.setDateDebutFormation_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinFormation()
  {
    return m_fluxDSMInfra.getDateFinFormation();
  }
  
  public String getCodeErreurDateFinFormation()
  {
    return m_fluxDSMInfra.getDateFinFormation_C_ERR();
  }
  
  public void setDateFinFormation(Damj pValeur)
  {
    m_fluxDSMInfra.setDateFinFormation(pValeur);
  }
  
  public void setCodeErreurDateFinFormation(String pCodeErreur)
  {
    m_fluxDSMInfra.setDateFinFormation_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutMaladie()
  {
    return m_fluxDSMInfra.getDateDebutMaladie();
  }
  
  public String getCodeErreurDateDebutMaladie()
  {
    return m_fluxDSMInfra.getDateDebutMaladie_C_ERR();
  }
  
  public void setDateDebutMaladie(Damj pValeur)
  {
    m_fluxDSMInfra.setDateDebutMaladie(pValeur);
  }
  
  public void setCodeErreurDateDebutMaladie(String pCodeErreur)
  {
    m_fluxDSMInfra.setDateDebutMaladie_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinMaladie()
  {
    return m_fluxDSMInfra.getDateFinMaladie();
  }
  
  public String getCodeErreurDateFinMaladie()
  {
    return m_fluxDSMInfra.getDateFinMaladie_C_ERR();
  }
  
  public void setDateFinMaladie(Damj pValeur)
  {
    m_fluxDSMInfra.setDateFinMaladie(pValeur);
  }
  
  public void setCodeErreurDateFinMaladie(String pCodeErreur)
  {
    m_fluxDSMInfra.setDateFinMaladie_C_ERR(pCodeErreur);
  }
  
  public Damj getMoisActualisation()
  {
    return m_fluxDSMInfra.getMoisActualisation();
  }
  
  public String getCodeErreurMoisActualisation()
  {
    return m_fluxDSMInfra.getMoisActualisation_C_ERR();
  }
  
  public void setMoisActualisation(Damj pValeur)
  {
    m_fluxDSMInfra.setMoisActualisation(pValeur);
  }
  
  public void setCodeErreurMoisActualisation(String pCodeErreur)
  {
    m_fluxDSMInfra.setMoisActualisation_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbreHeuresActRed()
  {
    return m_fluxDSMInfra.getNbreHeuresActRed();
  }
  
  public String getCodeErreurNbreHeuresActRed()
  {
    return m_fluxDSMInfra.getNbreHeuresActRed_C_ERR();
  }
  
  public void setNbreHeuresActRed(BigDecimal pValeur)
  {
    m_fluxDSMInfra.setNbreHeuresActRed(pValeur);
  }
  
  public void setCodeErreurNbreHeuresActRed(String pCodeErreur)
  {
    m_fluxDSMInfra.setNbreHeuresActRed_C_ERR(pCodeErreur);
  }
  
  public _FluxDSM getFluxDSMInfra()
  {
    return m_fluxDSMInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    Object objListeDSMTravail = getListeDSMTravail();
    if ((objListeDSMTravail != null) && 
      (getListeDSMTravail().isEnErreur())) {
      return true;
    }
    if ((getCodeErreurFlagA8A10() != null) && 
      ("".equals(getCodeErreurFlagA8A10()))) {
      return true;
    }
    if ((getCodeErreurDeclareJustifie() != null) && 
      ("".equals(getCodeErreurDeclareJustifie()))) {
      return true;
    }
    if ((getCodeErreurIndicateurPresenceTravail() != null) && 
      ("".equals(getCodeErreurIndicateurPresenceTravail()))) {
      return true;
    }
    if ((getCodeErreurOrigineSaisieDsm() != null) && 
      ("".equals(getCodeErreurOrigineSaisieDsm()))) {
      return true;
    }
    if ((getCodeErreurDateDebutFormation() != null) && 
      ("".equals(getCodeErreurDateDebutFormation()))) {
      return true;
    }
    if ((getCodeErreurDateFinFormation() != null) && 
      ("".equals(getCodeErreurDateFinFormation()))) {
      return true;
    }
    if ((getCodeErreurDateDebutMaladie() != null) && 
      ("".equals(getCodeErreurDateDebutMaladie()))) {
      return true;
    }
    if ((getCodeErreurDateFinMaladie() != null) && 
      ("".equals(getCodeErreurDateFinMaladie()))) {
      return true;
    }
    if ((getCodeErreurMoisActualisation() != null) && 
      ("".equals(getCodeErreurMoisActualisation()))) {
      return true;
    }
    if ((getCodeErreurNbreHeuresActRed() != null) && 
      ("".equals(getCodeErreurNbreHeuresActRed()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxDSMImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */