package fr.pe.d12dal.service.es.completude;

import fr.pe.d12dal.dictionnaire.CodeRetourAppelServiceEnumeration;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _RetourAjouterPieceJustificativeImpl
  extends RetourAjouterPieceJustificative
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _RetourAjouterPieceJustificative m_retourAjouterPieceJustificativeInfra;
  
  public _RetourAjouterPieceJustificativeImpl()
  {
    m_retourAjouterPieceJustificativeInfra = new _RetourAjouterPieceJustificative();
  }
  
  public _RetourAjouterPieceJustificativeImpl(_RetourAjouterPieceJustificative pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("RetourAjouterPieceJustificativeInfra", pValeur);
    
    m_retourAjouterPieceJustificativeInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_retourAjouterPieceJustificativeInfra;
  }
  
  public String getIdentifiant()
  {
    return m_retourAjouterPieceJustificativeInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_retourAjouterPieceJustificativeInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_retourAjouterPieceJustificativeInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_retourAjouterPieceJustificativeInfra.set_C_ETAT(pCode);
  }
  
  public String getCodeRetour()
  {
    return m_retourAjouterPieceJustificativeInfra.getCodeRetour();
  }
  
  public CodeRetourAppelServiceEnumeration getEnumerationCodeRetour()
  {
    return CodeRetourAppelServiceEnumeration.getPourValeur(m_retourAjouterPieceJustificativeInfra.getCodeRetour());
  }
  
  public void setEnumerationCodeRetour(CodeRetourAppelServiceEnumeration pEnumeration)
  {
    m_retourAjouterPieceJustificativeInfra.setCodeRetour(pEnumeration.getValeur());
  }
  
  public void setCodeRetour(String pValeur)
  {
    m_retourAjouterPieceJustificativeInfra.setCodeRetour(pValeur);
  }
  
  public String getCodeErreurCodeRetour()
  {
    return m_retourAjouterPieceJustificativeInfra.getCodeRetour_C_ERR();
  }
  
  public void setCodeErreurCodeRetour(String pCodeErreur)
  {
    m_retourAjouterPieceJustificativeInfra.setCodeRetour_C_ERR(pCodeErreur);
  }
  
  public _RetourAjouterPieceJustificative getRetourAjouterPieceJustificativeInfra()
  {
    return m_retourAjouterPieceJustificativeInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurCodeRetour() != null) && 
      ("".equals(getCodeErreurCodeRetour()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _RetourAjouterPieceJustificativeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */