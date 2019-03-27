package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxFctDnaPreavisImpl
  extends FluxFctDnaPreavis
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxFctDnaPreavis m_fluxFctDnaPreavisInfra;
  
  public _FluxFctDnaPreavisImpl()
  {
    m_fluxFctDnaPreavisInfra = new _FluxFctDnaPreavis();
  }
  
  public _FluxFctDnaPreavisImpl(_FluxFctDnaPreavis pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxFctDnaPreavisInfra", pValeur);
    
    m_fluxFctDnaPreavisInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxFctDnaPreavisInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxFctDnaPreavisInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxFctDnaPreavisInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxFctDnaPreavisInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxFctDnaPreavisInfra.set_C_ETAT(pCode);
  }
  
  public String getTypePreavis()
  {
    return m_fluxFctDnaPreavisInfra.getTypePreavis();
  }
  
  public String getCodeErreurTypePreavis()
  {
    return m_fluxFctDnaPreavisInfra.getTypePreavis_C_ERR();
  }
  
  public void setTypePreavis(String pValeur)
  {
    m_fluxFctDnaPreavisInfra.setTypePreavis(pValeur);
  }
  
  public void setCodeErreurTypePreavis(String pCodeErreur)
  {
    m_fluxFctDnaPreavisInfra.setTypePreavis_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutPreavis()
  {
    return m_fluxFctDnaPreavisInfra.getDateDebutPreavis();
  }
  
  public String getCodeErreurDateDebutPreavis()
  {
    return m_fluxFctDnaPreavisInfra.getDateDebutPreavis_C_ERR();
  }
  
  public void setDateDebutPreavis(Damj pValeur)
  {
    m_fluxFctDnaPreavisInfra.setDateDebutPreavis(pValeur);
  }
  
  public void setCodeErreurDateDebutPreavis(String pCodeErreur)
  {
    m_fluxFctDnaPreavisInfra.setDateDebutPreavis_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinPreavis()
  {
    return m_fluxFctDnaPreavisInfra.getDateFinPreavis();
  }
  
  public String getCodeErreurDateFinPreavis()
  {
    return m_fluxFctDnaPreavisInfra.getDateFinPreavis_C_ERR();
  }
  
  public void setDateFinPreavis(Damj pValeur)
  {
    m_fluxFctDnaPreavisInfra.setDateFinPreavis(pValeur);
  }
  
  public void setCodeErreurDateFinPreavis(String pCodeErreur)
  {
    m_fluxFctDnaPreavisInfra.setDateFinPreavis_C_ERR(pCodeErreur);
  }
  
  public _FluxFctDnaPreavis getFluxFctDnaPreavisInfra()
  {
    return m_fluxFctDnaPreavisInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurTypePreavis() != null) && 
      ("".equals(getCodeErreurTypePreavis()))) {
      return true;
    }
    if ((getCodeErreurDateDebutPreavis() != null) && 
      ("".equals(getCodeErreurDateDebutPreavis()))) {
      return true;
    }
    if ((getCodeErreurDateFinPreavis() != null) && 
      ("".equals(getCodeErreurDateFinPreavis()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxFctDnaPreavisImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */