package fr.pe.d12dal.service.es.completude;

import fr.pe.d12dal.dictionnaire.CodeRetourAppelServiceEnumeration;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _RetourSynchroniserCouleurDALImpl
  extends RetourSynchroniserCouleurDAL
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _RetourSynchroniserCouleurDAL m_retourSynchroniserCouleurDALInfra;
  
  public _RetourSynchroniserCouleurDALImpl()
  {
    m_retourSynchroniserCouleurDALInfra = new _RetourSynchroniserCouleurDAL();
  }
  
  public _RetourSynchroniserCouleurDALImpl(_RetourSynchroniserCouleurDAL pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("RetourSynchroniserCouleurDALInfra", pValeur);
    
    m_retourSynchroniserCouleurDALInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_retourSynchroniserCouleurDALInfra;
  }
  
  public String getIdentifiant()
  {
    return m_retourSynchroniserCouleurDALInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_retourSynchroniserCouleurDALInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_retourSynchroniserCouleurDALInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_retourSynchroniserCouleurDALInfra.set_C_ETAT(pCode);
  }
  
  public String getCodeRetour()
  {
    return m_retourSynchroniserCouleurDALInfra.getCodeRetour();
  }
  
  public CodeRetourAppelServiceEnumeration getEnumerationCodeRetour()
  {
    return CodeRetourAppelServiceEnumeration.getPourValeur(m_retourSynchroniserCouleurDALInfra.getCodeRetour());
  }
  
  public void setEnumerationCodeRetour(CodeRetourAppelServiceEnumeration pEnumeration)
  {
    m_retourSynchroniserCouleurDALInfra.setCodeRetour(pEnumeration.getValeur());
  }
  
  public void setCodeRetour(String pValeur)
  {
    m_retourSynchroniserCouleurDALInfra.setCodeRetour(pValeur);
  }
  
  public String getCodeErreurCodeRetour()
  {
    return m_retourSynchroniserCouleurDALInfra.getCodeRetour_C_ERR();
  }
  
  public void setCodeErreurCodeRetour(String pCodeErreur)
  {
    m_retourSynchroniserCouleurDALInfra.setCodeRetour_C_ERR(pCodeErreur);
  }
  
  public _RetourSynchroniserCouleurDAL getRetourSynchroniserCouleurDALInfra()
  {
    return m_retourSynchroniserCouleurDALInfra;
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
 * Qualified Name:     _RetourSynchroniserCouleurDALImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */