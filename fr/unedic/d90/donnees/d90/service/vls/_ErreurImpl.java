package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ErreurImpl
  extends Erreur
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _Erreur m_erreurInfra;
  
  public _ErreurImpl()
  {
    m_erreurInfra = new _Erreur();
  }
  
  public _ErreurImpl(_Erreur pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("ErreurInfra", pValeur);
    
    m_erreurInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_erreurInfra;
  }
  
  public String getIdentifiant()
  {
    return m_erreurInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_erreurInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_erreurInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_erreurInfra.set_C_ETAT(pCode);
  }
  
  public String getCode()
  {
    return m_erreurInfra.getCode();
  }
  
  public String getCodeErreurCode()
  {
    return m_erreurInfra.getCode_C_ERR();
  }
  
  public void setCode(String pValeur)
  {
    m_erreurInfra.setCode(pValeur);
  }
  
  public void setCodeErreurCode(String pCodeErreur)
  {
    m_erreurInfra.setCode_C_ERR(pCodeErreur);
  }
  
  public String getLibelle()
  {
    return m_erreurInfra.getLibelle();
  }
  
  public String getCodeErreurLibelle()
  {
    return m_erreurInfra.getLibelle_C_ERR();
  }
  
  public void setLibelle(String pValeur)
  {
    m_erreurInfra.setLibelle(pValeur);
  }
  
  public void setCodeErreurLibelle(String pCodeErreur)
  {
    m_erreurInfra.setLibelle_C_ERR(pCodeErreur);
  }
  
  public String getItem()
  {
    return m_erreurInfra.getItem();
  }
  
  public String getCodeErreurItem()
  {
    return m_erreurInfra.getItem_C_ERR();
  }
  
  public void setItem(String pValeur)
  {
    m_erreurInfra.setItem(pValeur);
  }
  
  public void setCodeErreurItem(String pCodeErreur)
  {
    m_erreurInfra.setItem_C_ERR(pCodeErreur);
  }
  
  public String getParametres()
  {
    return m_erreurInfra.getParametres();
  }
  
  public String getCodeErreurParametres()
  {
    return m_erreurInfra.getParametres_C_ERR();
  }
  
  public void setParametres(String pValeur)
  {
    m_erreurInfra.setParametres(pValeur);
  }
  
  public void setCodeErreurParametres(String pCodeErreur)
  {
    m_erreurInfra.setParametres_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNiveau()
  {
    return m_erreurInfra.getNiveau();
  }
  
  public String getCodeErreurNiveau()
  {
    return m_erreurInfra.getNiveau_C_ERR();
  }
  
  public void setNiveau(BigDecimal pValeur)
  {
    m_erreurInfra.setNiveau(pValeur);
  }
  
  public void setCodeErreurNiveau(String pCodeErreur)
  {
    m_erreurInfra.setNiveau_C_ERR(pCodeErreur);
  }
  
  public _Erreur getErreurInfra()
  {
    return m_erreurInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurCode() != null) && 
      ("".equals(getCodeErreurCode()))) {
      return true;
    }
    if ((getCodeErreurLibelle() != null) && 
      ("".equals(getCodeErreurLibelle()))) {
      return true;
    }
    if ((getCodeErreurItem() != null) && 
      ("".equals(getCodeErreurItem()))) {
      return true;
    }
    if ((getCodeErreurParametres() != null) && 
      ("".equals(getCodeErreurParametres()))) {
      return true;
    }
    if ((getCodeErreurNiveau() != null) && 
      ("".equals(getCodeErreurNiveau()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ErreurImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */