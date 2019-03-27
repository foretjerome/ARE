package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxPasDnaPeriodePrimeImpl
  extends FluxPasDnaPeriodePrime
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxPasDnaPeriodePrime m_fluxPasDnaPeriodePrimeInfra;
  
  public _FluxPasDnaPeriodePrimeImpl()
  {
    m_fluxPasDnaPeriodePrimeInfra = new _FluxPasDnaPeriodePrime();
  }
  
  public _FluxPasDnaPeriodePrimeImpl(_FluxPasDnaPeriodePrime pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxPasDnaPeriodePrimeInfra", pValeur);
    
    m_fluxPasDnaPeriodePrimeInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxPasDnaPeriodePrimeInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxPasDnaPeriodePrimeInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxPasDnaPeriodePrimeInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxPasDnaPeriodePrimeInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxPasDnaPeriodePrimeInfra.set_C_ETAT(pCode);
  }
  
  public String getNature()
  {
    return m_fluxPasDnaPeriodePrimeInfra.getNature();
  }
  
  public String getCodeErreurNature()
  {
    return m_fluxPasDnaPeriodePrimeInfra.getNature_C_ERR();
  }
  
  public void setNature(String pValeur)
  {
    m_fluxPasDnaPeriodePrimeInfra.setNature(pValeur);
  }
  
  public void setCodeErreurNature(String pCodeErreur)
  {
    m_fluxPasDnaPeriodePrimeInfra.setNature_C_ERR(pCodeErreur);
  }
  
  public String getType()
  {
    return m_fluxPasDnaPeriodePrimeInfra.getType();
  }
  
  public String getCodeErreurType()
  {
    return m_fluxPasDnaPeriodePrimeInfra.getType_C_ERR();
  }
  
  public void setType(String pValeur)
  {
    m_fluxPasDnaPeriodePrimeInfra.setType(pValeur);
  }
  
  public void setCodeErreurType(String pCodeErreur)
  {
    m_fluxPasDnaPeriodePrimeInfra.setType_C_ERR(pCodeErreur);
  }
  
  public String getIndicMontant()
  {
    return m_fluxPasDnaPeriodePrimeInfra.getIndicMontant();
  }
  
  public String getCodeErreurIndicMontant()
  {
    return m_fluxPasDnaPeriodePrimeInfra.getIndicMontant_C_ERR();
  }
  
  public void setIndicMontant(String pValeur)
  {
    m_fluxPasDnaPeriodePrimeInfra.setIndicMontant(pValeur);
  }
  
  public void setCodeErreurIndicMontant(String pCodeErreur)
  {
    m_fluxPasDnaPeriodePrimeInfra.setIndicMontant_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutPrime()
  {
    return m_fluxPasDnaPeriodePrimeInfra.getDateDebutPrime();
  }
  
  public String getCodeErreurDateDebutPrime()
  {
    return m_fluxPasDnaPeriodePrimeInfra.getDateDebutPrime_C_ERR();
  }
  
  public void setDateDebutPrime(Damj pValeur)
  {
    m_fluxPasDnaPeriodePrimeInfra.setDateDebutPrime(pValeur);
  }
  
  public void setCodeErreurDateDebutPrime(String pCodeErreur)
  {
    m_fluxPasDnaPeriodePrimeInfra.setDateDebutPrime_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinPrime()
  {
    return m_fluxPasDnaPeriodePrimeInfra.getDateFinPrime();
  }
  
  public String getCodeErreurDateFinPrime()
  {
    return m_fluxPasDnaPeriodePrimeInfra.getDateFinPrime_C_ERR();
  }
  
  public void setDateFinPrime(Damj pValeur)
  {
    m_fluxPasDnaPeriodePrimeInfra.setDateFinPrime(pValeur);
  }
  
  public void setCodeErreurDateFinPrime(String pCodeErreur)
  {
    m_fluxPasDnaPeriodePrimeInfra.setDateFinPrime_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantPrime()
  {
    return m_fluxPasDnaPeriodePrimeInfra.getMontantPrime();
  }
  
  public String getCodeErreurMontantPrime()
  {
    return m_fluxPasDnaPeriodePrimeInfra.getMontantPrime_C_ERR();
  }
  
  public void setMontantPrime(BigDecimal pValeur)
  {
    m_fluxPasDnaPeriodePrimeInfra.setMontantPrime(pValeur);
  }
  
  public void setCodeErreurMontantPrime(String pCodeErreur)
  {
    m_fluxPasDnaPeriodePrimeInfra.setMontantPrime_C_ERR(pCodeErreur);
  }
  
  public _FluxPasDnaPeriodePrime getFluxPasDnaPeriodePrimeInfra()
  {
    return m_fluxPasDnaPeriodePrimeInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurNature() != null) && 
      ("".equals(getCodeErreurNature()))) {
      return true;
    }
    if ((getCodeErreurType() != null) && 
      ("".equals(getCodeErreurType()))) {
      return true;
    }
    if ((getCodeErreurIndicMontant() != null) && 
      ("".equals(getCodeErreurIndicMontant()))) {
      return true;
    }
    if ((getCodeErreurDateDebutPrime() != null) && 
      ("".equals(getCodeErreurDateDebutPrime()))) {
      return true;
    }
    if ((getCodeErreurDateFinPrime() != null) && 
      ("".equals(getCodeErreurDateFinPrime()))) {
      return true;
    }
    if ((getCodeErreurMontantPrime() != null) && 
      ("".equals(getCodeErreurMontantPrime()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxPasDnaPeriodePrimeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */