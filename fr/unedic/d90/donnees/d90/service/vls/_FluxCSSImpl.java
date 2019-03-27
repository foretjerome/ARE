package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxCSSImpl
  extends FluxCSS
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxCSS m_fluxCSSInfra;
  
  public _FluxCSSImpl()
  {
    m_fluxCSSInfra = new _FluxCSS();
  }
  
  public _FluxCSSImpl(_FluxCSS pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxCSSInfra", pValeur);
    
    m_fluxCSSInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxCSSInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxCSSInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxCSSInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxCSSInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxCSSInfra.set_C_ETAT(pCode);
  }
  
  public String getReferenceFormulaire()
  {
    return m_fluxCSSInfra.getReferenceFormulaire();
  }
  
  public String getCodeErreurReferenceFormulaire()
  {
    return m_fluxCSSInfra.getReferenceFormulaire_C_ERR();
  }
  
  public void setReferenceFormulaire(String pValeur)
  {
    m_fluxCSSInfra.setReferenceFormulaire(pValeur);
  }
  
  public void setCodeErreurReferenceFormulaire(String pCodeErreur)
  {
    m_fluxCSSInfra.setReferenceFormulaire_C_ERR(pCodeErreur);
  }
  
  public String getMotif()
  {
    return m_fluxCSSInfra.getMotif();
  }
  
  public String getCodeErreurMotif()
  {
    return m_fluxCSSInfra.getMotif_C_ERR();
  }
  
  public void setMotif(String pValeur)
  {
    m_fluxCSSInfra.setMotif(pValeur);
  }
  
  public void setCodeErreurMotif(String pCodeErreur)
  {
    m_fluxCSSInfra.setMotif_C_ERR(pCodeErreur);
  }
  
  public _FluxCSS getFluxCSSInfra()
  {
    return m_fluxCSSInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurReferenceFormulaire() != null) && 
      ("".equals(getCodeErreurReferenceFormulaire()))) {
      return true;
    }
    if ((getCodeErreurMotif() != null) && 
      ("".equals(getCodeErreurMotif()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxCSSImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */