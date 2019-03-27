package fr.pe.d12dal.service.es.dal;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _PeriodeAffiliationImpl
  extends PeriodeAffiliation
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _PeriodeAffiliation m_periodeAffiliationInfra;
  
  public _PeriodeAffiliationImpl()
  {
    m_periodeAffiliationInfra = new _PeriodeAffiliation();
  }
  
  public _PeriodeAffiliationImpl(_PeriodeAffiliation pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("PeriodeAffiliationInfra", pValeur);
    
    m_periodeAffiliationInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_periodeAffiliationInfra;
  }
  
  public String getIdentifiant()
  {
    return m_periodeAffiliationInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_periodeAffiliationInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_periodeAffiliationInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_periodeAffiliationInfra.set_C_ETAT(pCode);
  }
  
  public Date getDateDebut()
  {
    return m_periodeAffiliationInfra.getDateDebut();
  }
  
  public String getCodeErreurDateDebut()
  {
    return m_periodeAffiliationInfra.getDateDebut_C_ERR();
  }
  
  public void setDateDebut(Date pValeur)
  {
    m_periodeAffiliationInfra.setDateDebut(pValeur);
  }
  
  public void setCodeErreurDateDebut(String pCodeErreur)
  {
    m_periodeAffiliationInfra.setDateDebut_C_ERR(pCodeErreur);
  }
  
  public Date getDateFin()
  {
    return m_periodeAffiliationInfra.getDateFin();
  }
  
  public String getCodeErreurDateFin()
  {
    return m_periodeAffiliationInfra.getDateFin_C_ERR();
  }
  
  public void setDateFin(Date pValeur)
  {
    m_periodeAffiliationInfra.setDateFin(pValeur);
  }
  
  public void setCodeErreurDateFin(String pCodeErreur)
  {
    m_periodeAffiliationInfra.setDateFin_C_ERR(pCodeErreur);
  }
  
  public String getTopPropositionCSP()
  {
    return m_periodeAffiliationInfra.getTopPropositionCSP();
  }
  
  public String getCodeErreurTopPropositionCSP()
  {
    return m_periodeAffiliationInfra.getTopPropositionCSP_C_ERR();
  }
  
  public void setTopPropositionCSP(String pValeur)
  {
    m_periodeAffiliationInfra.setTopPropositionCSP(pValeur);
  }
  
  public void setCodeErreurTopPropositionCSP(String pCodeErreur)
  {
    m_periodeAffiliationInfra.setTopPropositionCSP_C_ERR(pCodeErreur);
  }
  
  public String getStatutDeclaration()
  {
    return m_periodeAffiliationInfra.getStatutDeclaration();
  }
  
  public String getCodeErreurStatutDeclaration()
  {
    return m_periodeAffiliationInfra.getStatutDeclaration_C_ERR();
  }
  
  public void setStatutDeclaration(String pValeur)
  {
    m_periodeAffiliationInfra.setStatutDeclaration(pValeur);
  }
  
  public void setCodeErreurStatutDeclaration(String pCodeErreur)
  {
    m_periodeAffiliationInfra.setStatutDeclaration_C_ERR(pCodeErreur);
  }
  
  public String getTopPropositionPAP()
  {
    return m_periodeAffiliationInfra.getTopPropositionPAP();
  }
  
  public String getCodeErreurTopPropositionPAP()
  {
    return m_periodeAffiliationInfra.getTopPropositionPAP_C_ERR();
  }
  
  public void setTopPropositionPAP(String pValeur)
  {
    m_periodeAffiliationInfra.setTopPropositionPAP(pValeur);
  }
  
  public void setCodeErreurTopPropositionPAP(String pCodeErreur)
  {
    m_periodeAffiliationInfra.setTopPropositionPAP_C_ERR(pCodeErreur);
  }
  
  public _PeriodeAffiliation getPeriodeAffiliationInfra()
  {
    return m_periodeAffiliationInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurDateDebut() != null) && 
      ("".equals(getCodeErreurDateDebut()))) {
      return true;
    }
    if ((getCodeErreurDateFin() != null) && 
      ("".equals(getCodeErreurDateFin()))) {
      return true;
    }
    if ((getCodeErreurTopPropositionCSP() != null) && 
      ("".equals(getCodeErreurTopPropositionCSP()))) {
      return true;
    }
    if ((getCodeErreurStatutDeclaration() != null) && 
      ("".equals(getCodeErreurStatutDeclaration()))) {
      return true;
    }
    if ((getCodeErreurTopPropositionPAP() != null) && 
      ("".equals(getCodeErreurTopPropositionPAP()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _PeriodeAffiliationImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */