package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _IndicateurImpl
  extends Indicateur
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _Indicateur m_indicateurInfra;
  
  public _IndicateurImpl()
  {
    m_indicateurInfra = new _Indicateur();
  }
  
  public _IndicateurImpl(_Indicateur pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("IndicateurInfra", pValeur);
    
    m_indicateurInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_indicateurInfra;
  }
  
  public String getIdentifiant()
  {
    return m_indicateurInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_indicateurInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_indicateurInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_indicateurInfra.set_C_ETAT(pCode);
  }
  
  public String getNom()
  {
    return m_indicateurInfra.getNom();
  }
  
  public String getCodeErreurNom()
  {
    return m_indicateurInfra.getNom_C_ERR();
  }
  
  public void setNom(String pValeur)
  {
    m_indicateurInfra.setNom(pValeur);
  }
  
  public void setCodeErreurNom(String pCodeErreur)
  {
    m_indicateurInfra.setNom_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getValeur()
  {
    return m_indicateurInfra.getValeur();
  }
  
  public String getCodeErreurValeur()
  {
    return m_indicateurInfra.getValeur_C_ERR();
  }
  
  public void setValeur(BigDecimal pValeur)
  {
    m_indicateurInfra.setValeur(pValeur);
  }
  
  public void setCodeErreurValeur(String pCodeErreur)
  {
    m_indicateurInfra.setValeur_C_ERR(pCodeErreur);
  }
  
  public _Indicateur getIndicateurInfra()
  {
    return m_indicateurInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurNom() != null) && 
      ("".equals(getCodeErreurNom()))) {
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
 * Qualified Name:     _IndicateurImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */