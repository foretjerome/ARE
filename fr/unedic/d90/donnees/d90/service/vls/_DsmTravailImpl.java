package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _DsmTravailImpl
  extends DsmTravail
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _DsmTravail m_dsmTravailInfra;
  
  public _DsmTravailImpl()
  {
    m_dsmTravailInfra = new _DsmTravail();
  }
  
  public _DsmTravailImpl(_DsmTravail pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("DsmTravailInfra", pValeur);
    
    m_dsmTravailInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_dsmTravailInfra;
  }
  
  public String getIdentifiant()
  {
    return m_dsmTravailInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_dsmTravailInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_dsmTravailInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_dsmTravailInfra.set_C_ETAT(pCode);
  }
  
  public String getRaisonSociale()
  {
    return m_dsmTravailInfra.getRaisonSociale();
  }
  
  public String getCodeErreurRaisonSociale()
  {
    return m_dsmTravailInfra.getRaisonSociale_C_ERR();
  }
  
  public void setRaisonSociale(String pValeur)
  {
    m_dsmTravailInfra.setRaisonSociale(pValeur);
  }
  
  public void setCodeErreurRaisonSociale(String pCodeErreur)
  {
    m_dsmTravailInfra.setRaisonSociale_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutTravail()
  {
    return m_dsmTravailInfra.getDateDebutTravail();
  }
  
  public String getCodeErreurDateDebutTravail()
  {
    return m_dsmTravailInfra.getDateDebutTravail_C_ERR();
  }
  
  public void setDateDebutTravail(Damj pValeur)
  {
    m_dsmTravailInfra.setDateDebutTravail(pValeur);
  }
  
  public void setCodeErreurDateDebutTravail(String pCodeErreur)
  {
    m_dsmTravailInfra.setDateDebutTravail_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinTravail()
  {
    return m_dsmTravailInfra.getDateFinTravail();
  }
  
  public String getCodeErreurDateFinTravail()
  {
    return m_dsmTravailInfra.getDateFinTravail_C_ERR();
  }
  
  public void setDateFinTravail(Damj pValeur)
  {
    m_dsmTravailInfra.setDateFinTravail(pValeur);
  }
  
  public void setCodeErreurDateFinTravail(String pCodeErreur)
  {
    m_dsmTravailInfra.setDateFinTravail_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getSalaireBrut()
  {
    return m_dsmTravailInfra.getSalaireBrut();
  }
  
  public String getCodeErreurSalaireBrut()
  {
    return m_dsmTravailInfra.getSalaireBrut_C_ERR();
  }
  
  public void setSalaireBrut(BigDecimal pValeur)
  {
    m_dsmTravailInfra.setSalaireBrut(pValeur);
  }
  
  public void setCodeErreurSalaireBrut(String pCodeErreur)
  {
    m_dsmTravailInfra.setSalaireBrut_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbreHeuresDeclarees()
  {
    return m_dsmTravailInfra.getNbreHeuresDeclarees();
  }
  
  public String getCodeErreurNbreHeuresDeclarees()
  {
    return m_dsmTravailInfra.getNbreHeuresDeclarees_C_ERR();
  }
  
  public void setNbreHeuresDeclarees(BigDecimal pValeur)
  {
    m_dsmTravailInfra.setNbreHeuresDeclarees(pValeur);
  }
  
  public void setCodeErreurNbreHeuresDeclarees(String pCodeErreur)
  {
    m_dsmTravailInfra.setNbreHeuresDeclarees_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNbreCachetsDeclares()
  {
    return m_dsmTravailInfra.getNbreCachetsDeclares();
  }
  
  public String getCodeErreurNbreCachetsDeclares()
  {
    return m_dsmTravailInfra.getNbreCachetsDeclares_C_ERR();
  }
  
  public void setNbreCachetsDeclares(BigDecimal pValeur)
  {
    m_dsmTravailInfra.setNbreCachetsDeclares(pValeur);
  }
  
  public void setCodeErreurNbreCachetsDeclares(String pCodeErreur)
  {
    m_dsmTravailInfra.setNbreCachetsDeclares_C_ERR(pCodeErreur);
  }
  
  public _DsmTravail getDsmTravailInfra()
  {
    return m_dsmTravailInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurRaisonSociale() != null) && 
      ("".equals(getCodeErreurRaisonSociale()))) {
      return true;
    }
    if ((getCodeErreurDateDebutTravail() != null) && 
      ("".equals(getCodeErreurDateDebutTravail()))) {
      return true;
    }
    if ((getCodeErreurDateFinTravail() != null) && 
      ("".equals(getCodeErreurDateFinTravail()))) {
      return true;
    }
    if ((getCodeErreurSalaireBrut() != null) && 
      ("".equals(getCodeErreurSalaireBrut()))) {
      return true;
    }
    if ((getCodeErreurNbreHeuresDeclarees() != null) && 
      ("".equals(getCodeErreurNbreHeuresDeclarees()))) {
      return true;
    }
    if ((getCodeErreurNbreCachetsDeclares() != null) && 
      ("".equals(getCodeErreurNbreCachetsDeclares()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _DsmTravailImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */