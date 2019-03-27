package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxCaliDesengImpl
  extends FluxCaliDeseng
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxCaliDeseng m_fluxCaliDesengInfra;
  
  public _FluxCaliDesengImpl()
  {
    m_fluxCaliDesengInfra = new _FluxCaliDeseng();
  }
  
  public _FluxCaliDesengImpl(_FluxCaliDeseng pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxCaliDesengInfra", pValeur);
    
    m_fluxCaliDesengInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxCaliDesengInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxCaliDesengInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxCaliDesengInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxCaliDesengInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxCaliDesengInfra.set_C_ETAT(pCode);
  }
  
  public String getCxala()
  {
    return m_fluxCaliDesengInfra.getCxala();
  }
  
  public String getCodeErreurCxala()
  {
    return m_fluxCaliDesengInfra.getCxala_C_ERR();
  }
  
  public void setCxala(String pValeur)
  {
    m_fluxCaliDesengInfra.setCxala(pValeur);
  }
  
  public void setCodeErreurCxala(String pCodeErreur)
  {
    m_fluxCaliDesengInfra.setCxala_C_ERR(pCodeErreur);
  }
  
  public String getRsin()
  {
    return m_fluxCaliDesengInfra.getRsin();
  }
  
  public String getCodeErreurRsin()
  {
    return m_fluxCaliDesengInfra.getRsin_C_ERR();
  }
  
  public void setRsin(String pValeur)
  {
    m_fluxCaliDesengInfra.setRsin(pValeur);
  }
  
  public void setCodeErreurRsin(String pCodeErreur)
  {
    m_fluxCaliDesengInfra.setRsin_C_ERR(pCodeErreur);
  }
  
  public String getCxass()
  {
    return m_fluxCaliDesengInfra.getCxass();
  }
  
  public String getCodeErreurCxass()
  {
    return m_fluxCaliDesengInfra.getCxass_C_ERR();
  }
  
  public void setCxass(String pValeur)
  {
    m_fluxCaliDesengInfra.setCxass(pValeur);
  }
  
  public void setCodeErreurCxass(String pCodeErreur)
  {
    m_fluxCaliDesengInfra.setCxass_C_ERR(pCodeErreur);
  }
  
  public Damj getDateAppel()
  {
    return m_fluxCaliDesengInfra.getDateAppel();
  }
  
  public String getCodeErreurDateAppel()
  {
    return m_fluxCaliDesengInfra.getDateAppel_C_ERR();
  }
  
  public void setDateAppel(Damj pValeur)
  {
    m_fluxCaliDesengInfra.setDateAppel(pValeur);
  }
  
  public void setCodeErreurDateAppel(String pCodeErreur)
  {
    m_fluxCaliDesengInfra.setDateAppel_C_ERR(pCodeErreur);
  }
  
  public String getIdAide()
  {
    return m_fluxCaliDesengInfra.getIdAide();
  }
  
  public String getCodeErreurIdAide()
  {
    return m_fluxCaliDesengInfra.getIdAide_C_ERR();
  }
  
  public void setIdAide(String pValeur)
  {
    m_fluxCaliDesengInfra.setIdAide(pValeur);
  }
  
  public void setCodeErreurIdAide(String pCodeErreur)
  {
    m_fluxCaliDesengInfra.setIdAide_C_ERR(pCodeErreur);
  }
  
  public _FluxCaliDeseng getFluxCaliDesengInfra()
  {
    return m_fluxCaliDesengInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurCxala() != null) && 
      ("".equals(getCodeErreurCxala()))) {
      return true;
    }
    if ((getCodeErreurRsin() != null) && 
      ("".equals(getCodeErreurRsin()))) {
      return true;
    }
    if ((getCodeErreurCxass() != null) && 
      ("".equals(getCodeErreurCxass()))) {
      return true;
    }
    if ((getCodeErreurDateAppel() != null) && 
      ("".equals(getCodeErreurDateAppel()))) {
      return true;
    }
    if ((getCodeErreurIdAide() != null) && 
      ("".equals(getCodeErreurIdAide()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxCaliDesengImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */