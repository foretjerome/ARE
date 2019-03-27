package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxCaliImpl
  extends FluxCali
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxCali m_fluxCaliInfra;
  
  public _FluxCaliImpl()
  {
    m_fluxCaliInfra = new _FluxCali();
  }
  
  public _FluxCaliImpl(_FluxCali pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxCaliInfra", pValeur);
    
    m_fluxCaliInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxCaliInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxCaliInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxCaliInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxCaliInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxCaliInfra.set_C_ETAT(pCode);
  }
  
  public String getCxass()
  {
    return m_fluxCaliInfra.getCxass();
  }
  
  public String getCodeErreurCxass()
  {
    return m_fluxCaliInfra.getCxass_C_ERR();
  }
  
  public void setCxass(String pValeur)
  {
    m_fluxCaliInfra.setCxass(pValeur);
  }
  
  public void setCodeErreurCxass(String pCodeErreur)
  {
    m_fluxCaliInfra.setCxass_C_ERR(pCodeErreur);
  }
  
  public String getRsin()
  {
    return m_fluxCaliInfra.getRsin();
  }
  
  public String getCodeErreurRsin()
  {
    return m_fluxCaliInfra.getRsin_C_ERR();
  }
  
  public void setRsin(String pValeur)
  {
    m_fluxCaliInfra.setRsin(pValeur);
  }
  
  public void setCodeErreurRsin(String pCodeErreur)
  {
    m_fluxCaliInfra.setRsin_C_ERR(pCodeErreur);
  }
  
  public String getCxala()
  {
    return m_fluxCaliInfra.getCxala();
  }
  
  public String getCodeErreurCxala()
  {
    return m_fluxCaliInfra.getCxala_C_ERR();
  }
  
  public void setCxala(String pValeur)
  {
    m_fluxCaliInfra.setCxala(pValeur);
  }
  
  public void setCodeErreurCxala(String pCodeErreur)
  {
    m_fluxCaliInfra.setCxala_C_ERR(pCodeErreur);
  }
  
  public Damj getDateTraitement()
  {
    return m_fluxCaliInfra.getDateTraitement();
  }
  
  public String getCodeErreurDateTraitement()
  {
    return m_fluxCaliInfra.getDateTraitement_C_ERR();
  }
  
  public void setDateTraitement(Damj pValeur)
  {
    m_fluxCaliInfra.setDateTraitement(pValeur);
  }
  
  public void setCodeErreurDateTraitement(String pCodeErreur)
  {
    m_fluxCaliInfra.setDateTraitement_C_ERR(pCodeErreur);
  }
  
  public Damj getDateReexecution()
  {
    return m_fluxCaliInfra.getDateReexecution();
  }
  
  public String getCodeErreurDateReexecution()
  {
    return m_fluxCaliInfra.getDateReexecution_C_ERR();
  }
  
  public void setDateReexecution(Damj pValeur)
  {
    m_fluxCaliInfra.setDateReexecution(pValeur);
  }
  
  public void setCodeErreurDateReexecution(String pCodeErreur)
  {
    m_fluxCaliInfra.setDateReexecution_C_ERR(pCodeErreur);
  }
  
  public _FluxCali getFluxCaliInfra()
  {
    return m_fluxCaliInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurCxass() != null) && 
      ("".equals(getCodeErreurCxass()))) {
      return true;
    }
    if ((getCodeErreurRsin() != null) && 
      ("".equals(getCodeErreurRsin()))) {
      return true;
    }
    if ((getCodeErreurCxala() != null) && 
      ("".equals(getCodeErreurCxala()))) {
      return true;
    }
    if ((getCodeErreurDateTraitement() != null) && 
      ("".equals(getCodeErreurDateTraitement()))) {
      return true;
    }
    if ((getCodeErreurDateReexecution() != null) && 
      ("".equals(getCodeErreurDateReexecution()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxCaliImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */