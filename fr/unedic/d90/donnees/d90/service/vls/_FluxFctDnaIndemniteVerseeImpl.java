package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxFctDnaIndemniteVerseeImpl
  extends FluxFctDnaIndemniteVersee
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxFctDnaIndemniteVersee m_fluxFctDnaIndemniteVerseeInfra;
  
  public _FluxFctDnaIndemniteVerseeImpl()
  {
    m_fluxFctDnaIndemniteVerseeInfra = new _FluxFctDnaIndemniteVersee();
  }
  
  public _FluxFctDnaIndemniteVerseeImpl(_FluxFctDnaIndemniteVersee pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxFctDnaIndemniteVerseeInfra", pValeur);
    
    m_fluxFctDnaIndemniteVerseeInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxFctDnaIndemniteVerseeInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxFctDnaIndemniteVerseeInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxFctDnaIndemniteVerseeInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxFctDnaIndemniteVerseeInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxFctDnaIndemniteVerseeInfra.set_C_ETAT(pCode);
  }
  
  public String getTypeIndemnite()
  {
    return m_fluxFctDnaIndemniteVerseeInfra.getTypeIndemnite();
  }
  
  public String getCodeErreurTypeIndemnite()
  {
    return m_fluxFctDnaIndemniteVerseeInfra.getTypeIndemnite_C_ERR();
  }
  
  public void setTypeIndemnite(String pValeur)
  {
    m_fluxFctDnaIndemniteVerseeInfra.setTypeIndemnite(pValeur);
  }
  
  public void setCodeErreurTypeIndemnite(String pCodeErreur)
  {
    m_fluxFctDnaIndemniteVerseeInfra.setTypeIndemnite_C_ERR(pCodeErreur);
  }
  
  public String getNature()
  {
    return m_fluxFctDnaIndemniteVerseeInfra.getNature();
  }
  
  public String getCodeErreurNature()
  {
    return m_fluxFctDnaIndemniteVerseeInfra.getNature_C_ERR();
  }
  
  public void setNature(String pValeur)
  {
    m_fluxFctDnaIndemniteVerseeInfra.setNature(pValeur);
  }
  
  public void setCodeErreurNature(String pCodeErreur)
  {
    m_fluxFctDnaIndemniteVerseeInfra.setNature_C_ERR(pCodeErreur);
  }
  
  public String getIndicMontant()
  {
    return m_fluxFctDnaIndemniteVerseeInfra.getIndicMontant();
  }
  
  public String getCodeErreurIndicMontant()
  {
    return m_fluxFctDnaIndemniteVerseeInfra.getIndicMontant_C_ERR();
  }
  
  public void setIndicMontant(String pValeur)
  {
    m_fluxFctDnaIndemniteVerseeInfra.setIndicMontant(pValeur);
  }
  
  public void setCodeErreurIndicMontant(String pCodeErreur)
  {
    m_fluxFctDnaIndemniteVerseeInfra.setIndicMontant_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebut()
  {
    return m_fluxFctDnaIndemniteVerseeInfra.getDateDebut();
  }
  
  public String getCodeErreurDateDebut()
  {
    return m_fluxFctDnaIndemniteVerseeInfra.getDateDebut_C_ERR();
  }
  
  public void setDateDebut(Damj pValeur)
  {
    m_fluxFctDnaIndemniteVerseeInfra.setDateDebut(pValeur);
  }
  
  public void setCodeErreurDateDebut(String pCodeErreur)
  {
    m_fluxFctDnaIndemniteVerseeInfra.setDateDebut_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFin()
  {
    return m_fluxFctDnaIndemniteVerseeInfra.getDateFin();
  }
  
  public String getCodeErreurDateFin()
  {
    return m_fluxFctDnaIndemniteVerseeInfra.getDateFin_C_ERR();
  }
  
  public void setDateFin(Damj pValeur)
  {
    m_fluxFctDnaIndemniteVerseeInfra.setDateFin(pValeur);
  }
  
  public void setCodeErreurDateFin(String pCodeErreur)
  {
    m_fluxFctDnaIndemniteVerseeInfra.setDateFin_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantIndemnite()
  {
    return m_fluxFctDnaIndemniteVerseeInfra.getMontantIndemnite();
  }
  
  public String getCodeErreurMontantIndemnite()
  {
    return m_fluxFctDnaIndemniteVerseeInfra.getMontantIndemnite_C_ERR();
  }
  
  public void setMontantIndemnite(BigDecimal pValeur)
  {
    m_fluxFctDnaIndemniteVerseeInfra.setMontantIndemnite(pValeur);
  }
  
  public void setCodeErreurMontantIndemnite(String pCodeErreur)
  {
    m_fluxFctDnaIndemniteVerseeInfra.setMontantIndemnite_C_ERR(pCodeErreur);
  }
  
  public _FluxFctDnaIndemniteVersee getFluxFctDnaIndemniteVerseeInfra()
  {
    return m_fluxFctDnaIndemniteVerseeInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurTypeIndemnite() != null) && 
      ("".equals(getCodeErreurTypeIndemnite()))) {
      return true;
    }
    if ((getCodeErreurNature() != null) && 
      ("".equals(getCodeErreurNature()))) {
      return true;
    }
    if ((getCodeErreurIndicMontant() != null) && 
      ("".equals(getCodeErreurIndicMontant()))) {
      return true;
    }
    if ((getCodeErreurDateDebut() != null) && 
      ("".equals(getCodeErreurDateDebut()))) {
      return true;
    }
    if ((getCodeErreurDateFin() != null) && 
      ("".equals(getCodeErreurDateFin()))) {
      return true;
    }
    if ((getCodeErreurMontantIndemnite() != null) && 
      ("".equals(getCodeErreurMontantIndemnite()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxFctDnaIndemniteVerseeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */