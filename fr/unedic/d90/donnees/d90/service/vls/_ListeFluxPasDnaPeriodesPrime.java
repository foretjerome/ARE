package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.databean.Attribute;
import fr.unedic.archi.databean.DataBean;
import fr.unedic.archi.databean.DataBeanImpl;
import fr.unedic.archi.databean.DataList;
import fr.unedic.archi.databean.GettersHandler;
import fr.unedic.archi.databean.PropertyInfo;
import fr.unedic.archi.databean.SettersHandler;
import fr.unedic.archi.databean.StringAttribute;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class _ListeFluxPasDnaPeriodesPrime
  extends DataBeanImpl
  implements DataBean, Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private DataList m_fluxPasDnaPeriodePrime = _getInstanceListe();
  private String m__C_ETAT;
  private String m__IDENT;
  
  public String get_C_ETAT()
  {
    return m__C_ETAT;
  }
  
  public String get_IDENT()
  {
    return m__IDENT;
  }
  
  public void set_C_ETAT(String pCETAT)
  {
    m__C_ETAT = pCETAT;
  }
  
  public void set_IDENT(String pIDENT)
  {
    m__IDENT = pIDENT;
  }
  
  public _FluxPasDnaPeriodePrime[] getListeFluxPasDnaPeriodesPrime()
  {
    Object[] objTab = _getArrayFromList(m_fluxPasDnaPeriodePrime, _FluxPasDnaPeriodePrime.class);
    int length = objTab.length;
    _FluxPasDnaPeriodePrime[] tab = new _FluxPasDnaPeriodePrime[length];
    for (int i = 0; i < length; i++) {
      tab[i] = ((_FluxPasDnaPeriodePrime)objTab[i]);
    }
    return tab;
  }
  
  public DataList getInternalListeFluxPasDnaPeriodesPrime()
  {
    return m_fluxPasDnaPeriodePrime;
  }
  
  public int getNbListeFluxPasDnaPeriodesPrime()
  {
    return m_fluxPasDnaPeriodePrime.getNbElement();
  }
  
  public _FluxPasDnaPeriodePrime getListeFluxPasDnaPeriodesPrime(int pIndex)
  {
    Object obj = m_fluxPasDnaPeriodePrime.getElement(pIndex);
    ExceptionUtil.assertInstanceOf("element", obj, _FluxPasDnaPeriodePrime.class);
    return (_FluxPasDnaPeriodePrime)obj;
  }
  
  public void addListeFluxPasDnaPeriodesPrime(_FluxPasDnaPeriodePrime pElement)
  {
    ExceptionUtil.assertMethodParamNotNull("element", pElement);
    m_fluxPasDnaPeriodePrime.addElement(pElement);
  }
  
  public void removeFluxPasDnaPeriodePrime(int pIndex)
  {
    m_fluxPasDnaPeriodePrime.removeElement(pIndex);
  }
  
  public void removeFluxPasDnaPeriodePrime(_FluxPasDnaPeriodePrime pElement)
  {
    m_fluxPasDnaPeriodePrime.removeElement(pElement);
  }
  
  public void setListeFluxPasDnaPeriodesPrime(_FluxPasDnaPeriodePrime[] pIn)
  {
    _setArrayToList(pIn, m_fluxPasDnaPeriodePrime);
  }
  
  public Class _getAttributeType(String pPropertyName, String pAttributeName)
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      return String.class;
    }
    if ("m__IDENT".equals(attrName)) {
      return String.class;
    }
    return null;
  }
  
  public PropertyInfo _getPropertyInfo(String pElementName)
    throws TechniqueException
  {
    PropertyInfo resultat = null;
    if ("FluxPasDnaPeriodePrime".equals(pElementName)) {
      resultat = new PropertyInfo(pElementName, true, false, _FluxPasDnaPeriodePrime.class, false);
    }
    return resultat;
  }
  
  public int _getPropertyLength(String pElementName)
  {
    return -1;
  }
  
  public Object _getProperty(String pName)
    throws Exception
  {
    Object resultat = null;
    if ("FluxPasDnaPeriodePrime".equals(pName)) {
      resultat = m_fluxPasDnaPeriodePrime;
    }
    return resultat;
  }
  
  public Iterator _getPropertyNames()
    throws Exception
  {
    ArrayList liste = new ArrayList();
    
    liste.add("FluxPasDnaPeriodePrime");
    
    return liste.iterator();
  }
  
  public ArrayList _getPropertyNames(ArrayList pListe)
    throws Exception
  {
    pListe.add("FluxPasDnaPeriodePrime");
    
    return pListe;
  }
  
  public void _setProperty(String pName, Object pValeur)
    throws Exception
  {
    if ("FluxPasDnaPeriodePrime".equals(pName))
    {
      ExceptionUtil.assertMethodParamNotNull("pValeur", pValeur, _FluxPasDnaPeriodePrime.class);
      if (m_fluxPasDnaPeriodePrime != null)
      {
        m_fluxPasDnaPeriodePrime.addElement(pValeur);
      }
      else
      {
        m_fluxPasDnaPeriodePrime = _getInstanceListe();
        m_fluxPasDnaPeriodePrime.addElement(pValeur);
      }
    }
  }
  
  public void _setAttribute(String pPropertyName, String pAttributeName, String pValeur)
    throws Exception
  {
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      m__C_ETAT = pValeur;
    }
    if ("m__IDENT".equals(attrName)) {
      m__IDENT = pValeur;
    }
  }
  
  public String _getAttribute(String pPropertyName, String pAttributeName)
  {
    String resultat = null;
    StringBuffer attr = new StringBuffer();
    attr.append("m_");
    if (pPropertyName != null) {
      attr.append(pPropertyName);
    }
    attr.append("_").append(pAttributeName);
    String attrName = attr.toString();
    if ("m__C_ETAT".equals(attrName)) {
      resultat = m__C_ETAT;
    }
    if ("m__IDENT".equals(attrName)) {
      resultat = m__IDENT;
    }
    return resultat;
  }
  
  public boolean equals(Object pObjet)
  {
    if (!(pObjet instanceof _ListeFluxPasDnaPeriodesPrime)) {
      return false;
    }
    _ListeFluxPasDnaPeriodesPrime x = (_ListeFluxPasDnaPeriodesPrime)pObjet;
    if ((m_fluxPasDnaPeriodePrime == null) && (m_fluxPasDnaPeriodePrime == null)) {
      return true;
    }
    if ((m_fluxPasDnaPeriodePrime != null) && (m_fluxPasDnaPeriodePrime == null)) {
      return false;
    }
    if ((m_fluxPasDnaPeriodePrime == null) && (m_fluxPasDnaPeriodePrime != null)) {
      return false;
    }
    if (getListeFluxPasDnaPeriodesPrime().length != x.getListeFluxPasDnaPeriodesPrime().length) {
      return false;
    }
    for (int i = 0; i < getListeFluxPasDnaPeriodesPrime().length; i++) {
      if ((getListeFluxPasDnaPeriodesPrime()[i] != null) && 
        (!getListeFluxPasDnaPeriodesPrime()[i].equals(x.getListeFluxPasDnaPeriodesPrime()[i]))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int resultat = 0;
    if (m_fluxPasDnaPeriodePrime != null) {
      for (int i = 0; i < getListeFluxPasDnaPeriodesPrime().length; i++) {
        if (getListeFluxPasDnaPeriodesPrime()[i] != null) {
          resultat += getListeFluxPasDnaPeriodesPrime()[i].hashCode();
        }
      }
    }
    return resultat;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    _ListeFluxPasDnaPeriodesPrime clone_ListeFluxPasDnaPeriodesPrime = new _ListeFluxPasDnaPeriodesPrime();
    
    clone_ListeFluxPasDnaPeriodesPrime.populateFrom_ListeFluxPasDnaPeriodesPrime(this);
    
    return clone_ListeFluxPasDnaPeriodesPrime;
  }
  
  public void populateFrom_ListeFluxPasDnaPeriodesPrime(_ListeFluxPasDnaPeriodesPrime pSource)
  {
    setListeFluxPasDnaPeriodesPrime(pSource.getListeFluxPasDnaPeriodesPrime());
  }
  
  public String toString()
  {
    StringBuffer s = new StringBuffer("[_ListeFluxPasDnaPeriodesPrime");
    
    subToString(s);
    
    s.append("]");
    
    return s.toString();
  }
  
  protected void subToString(StringBuffer pSource)
  {
    pSource.append(", FluxPasDnaPeriodePrime: ");
    if (m_fluxPasDnaPeriodePrime == null)
    {
      pSource.append("null");
    }
    else
    {
      pSource.append("{");
      for (int i = 0; i < getListeFluxPasDnaPeriodesPrime().length; i++)
      {
        if (i > 0) {
          pSource.append(", ");
        }
        pSource.append(getListeFluxPasDnaPeriodesPrime()[i]);
      }
      pSource.append("}");
    }
  }
  
  public void goThrough(GettersHandler pHandler)
    throws Exception
  {
    pHandler.startGoThrough(new Attribute[] { new StringAttribute("C_ETAT", get_C_ETAT()), new StringAttribute("IDENT", get_IDENT()) });
    
    subGoThrough(pHandler);
    
    pHandler.endGoThrough();
  }
  
  protected void subGoThrough(GettersHandler pHandler)
    throws Exception
  {
    DataBean[] FluxPasDnaPeriodePrime_Value = getListeFluxPasDnaPeriodesPrime();
    GettersHandler[] FluxPasDnaPeriodePrime_GettersHandler = pHandler.property("FluxPasDnaPeriodePrime", FluxPasDnaPeriodePrime_Value, null);
    if ((FluxPasDnaPeriodePrime_GettersHandler != null) && (FluxPasDnaPeriodePrime_Value != null)) {
      for (int i = 0; i < FluxPasDnaPeriodePrime_GettersHandler.length; i++) {
        if ((FluxPasDnaPeriodePrime_GettersHandler[i] != null) && (FluxPasDnaPeriodePrime_Value[i] != null)) {
          FluxPasDnaPeriodePrime_Value[i].goThrough(FluxPasDnaPeriodePrime_GettersHandler[i]);
        }
      }
    }
  }
  
  public void goThrough(SettersHandler pHandler)
    throws Exception
  {
    pHandler.startGoThrough();
    
    subGoThrough(pHandler);
    
    pHandler.endGoThrough();
  }
  
  protected void subGoThrough(SettersHandler pHandler)
    throws Exception
  {
    set_C_ETAT(pHandler.stringAttribute("C_ETAT"));
    set_IDENT(pHandler.stringAttribute("IDENT"));
    
    DataBean[] FluxPasDnaPeriodePrime_dbs = pHandler.databeanArrayProperty("FluxPasDnaPeriodePrime", _FluxPasDnaPeriodePrime.class);
    if (FluxPasDnaPeriodePrime_dbs == null)
    {
      setListeFluxPasDnaPeriodesPrime(null);
    }
    else
    {
      _FluxPasDnaPeriodePrime[] FluxPasDnaPeriodePrime_array = new _FluxPasDnaPeriodePrime[FluxPasDnaPeriodePrime_dbs.length];
      for (int i = 0; i < FluxPasDnaPeriodePrime_dbs.length; i++) {
        FluxPasDnaPeriodePrime_array[i] = ((_FluxPasDnaPeriodePrime)FluxPasDnaPeriodePrime_dbs[i]);
      }
      setListeFluxPasDnaPeriodesPrime(FluxPasDnaPeriodePrime_array);
    }
  }
  
  public String _getDatabeanName()
  {
    return "ListeFluxPasDnaPeriodesPrime";
  }
  
  public boolean _isValidProperty(String pElementName)
  {
    if ("FluxPasDnaPeriodePrime".equals(pElementName)) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ListeFluxPasDnaPeriodesPrime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */