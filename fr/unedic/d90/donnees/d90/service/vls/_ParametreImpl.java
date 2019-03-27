package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ParametreImpl
  extends Parametre
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _Parametre m_parametreInfra;
  
  public _ParametreImpl()
  {
    m_parametreInfra = new _Parametre();
  }
  
  public _ParametreImpl(_Parametre pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("ParametreInfra", pValeur);
    
    m_parametreInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_parametreInfra;
  }
  
  public String getIdentifiant()
  {
    return m_parametreInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_parametreInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_parametreInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_parametreInfra.set_C_ETAT(pCode);
  }
  
  public String getId()
  {
    return m_parametreInfra.getId();
  }
  
  public String getCodeErreurId()
  {
    return m_parametreInfra.getId_C_ERR();
  }
  
  public void setId(String pValeur)
  {
    m_parametreInfra.setId(pValeur);
  }
  
  public void setCodeErreurId(String pCodeErreur)
  {
    m_parametreInfra.setId_C_ERR(pCodeErreur);
  }
  
  public String getValeur()
  {
    return m_parametreInfra.getValeur();
  }
  
  public String getCodeErreurValeur()
  {
    return m_parametreInfra.getValeur_C_ERR();
  }
  
  public void setValeur(String pValeur)
  {
    m_parametreInfra.setValeur(pValeur);
  }
  
  public void setCodeErreurValeur(String pCodeErreur)
  {
    m_parametreInfra.setValeur_C_ERR(pCodeErreur);
  }
  
  public _Parametre getParametreInfra()
  {
    return m_parametreInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurId() != null) && 
      ("".equals(getCodeErreurId()))) {
      return true;
    }
    if ((getCodeErreurValeur() != null) && 
      ("".equals(getCodeErreurValeur()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ParametreImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */