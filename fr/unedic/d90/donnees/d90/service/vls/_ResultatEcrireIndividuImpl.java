package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ResultatEcrireIndividuImpl
  extends ResultatEcrireIndividu
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ResultatEcrireIndividu m_resultatEcrireIndividuInfra;
  
  public _ResultatEcrireIndividuImpl()
  {
    m_resultatEcrireIndividuInfra = new _ResultatEcrireIndividu();
  }
  
  public _ResultatEcrireIndividuImpl(_ResultatEcrireIndividu pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("ResultatEcrireIndividuInfra", pValeur);
    
    m_resultatEcrireIndividuInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_resultatEcrireIndividuInfra;
  }
  
  public String getIdentifiant()
  {
    return m_resultatEcrireIndividuInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_resultatEcrireIndividuInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_resultatEcrireIndividuInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_resultatEcrireIndividuInfra.set_C_ETAT(pCode);
  }
  
  public _ResultatEcrireIndividu getResultatEcrireIndividuInfra()
  {
    return m_resultatEcrireIndividuInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     _ResultatEcrireIndividuImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */