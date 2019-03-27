package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxPrimesIndemVerseesDsnImpl
  extends FluxPrimesIndemVerseesDsn
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxPrimesIndemVerseesDsn m_fluxPrimesIndemVerseesDsnInfra;
  
  public _FluxPrimesIndemVerseesDsnImpl()
  {
    m_fluxPrimesIndemVerseesDsnInfra = new _FluxPrimesIndemVerseesDsn();
  }
  
  public _FluxPrimesIndemVerseesDsnImpl(_FluxPrimesIndemVerseesDsn pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxPrimesIndemVerseesDsnInfra", pValeur);
    
    m_fluxPrimesIndemVerseesDsnInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxPrimesIndemVerseesDsnInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxPrimesIndemVerseesDsnInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxPrimesIndemVerseesDsnInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxPrimesIndemVerseesDsnInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxPrimesIndemVerseesDsnInfra.set_C_ETAT(pCode);
  }
  
  public String getTypePrimeIndem()
  {
    return m_fluxPrimesIndemVerseesDsnInfra.getTypePrimeIndem();
  }
  
  public String getCodeErreurTypePrimeIndem()
  {
    return m_fluxPrimesIndemVerseesDsnInfra.getTypePrimeIndem_C_ERR();
  }
  
  public void setTypePrimeIndem(String pValeur)
  {
    m_fluxPrimesIndemVerseesDsnInfra.setTypePrimeIndem(pValeur);
  }
  
  public void setCodeErreurTypePrimeIndem(String pCodeErreur)
  {
    m_fluxPrimesIndemVerseesDsnInfra.setTypePrimeIndem_C_ERR(pCodeErreur);
  }
  
  public String getSigneMtantPrimeIndem()
  {
    return m_fluxPrimesIndemVerseesDsnInfra.getSigneMtantPrimeIndem();
  }
  
  public String getCodeErreurSigneMtantPrimeIndem()
  {
    return m_fluxPrimesIndemVerseesDsnInfra.getSigneMtantPrimeIndem_C_ERR();
  }
  
  public void setSigneMtantPrimeIndem(String pValeur)
  {
    m_fluxPrimesIndemVerseesDsnInfra.setSigneMtantPrimeIndem(pValeur);
  }
  
  public void setCodeErreurSigneMtantPrimeIndem(String pCodeErreur)
  {
    m_fluxPrimesIndemVerseesDsnInfra.setSigneMtantPrimeIndem_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getMontantPrimeIndem()
  {
    return m_fluxPrimesIndemVerseesDsnInfra.getMontantPrimeIndem();
  }
  
  public String getCodeErreurMontantPrimeIndem()
  {
    return m_fluxPrimesIndemVerseesDsnInfra.getMontantPrimeIndem_C_ERR();
  }
  
  public void setMontantPrimeIndem(BigDecimal pValeur)
  {
    m_fluxPrimesIndemVerseesDsnInfra.setMontantPrimeIndem(pValeur);
  }
  
  public void setCodeErreurMontantPrimeIndem(String pCodeErreur)
  {
    m_fluxPrimesIndemVerseesDsnInfra.setMontantPrimeIndem_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutPrime()
  {
    return m_fluxPrimesIndemVerseesDsnInfra.getDateDebutPrime();
  }
  
  public String getCodeErreurDateDebutPrime()
  {
    return m_fluxPrimesIndemVerseesDsnInfra.getDateDebutPrime_C_ERR();
  }
  
  public void setDateDebutPrime(Damj pValeur)
  {
    m_fluxPrimesIndemVerseesDsnInfra.setDateDebutPrime(pValeur);
  }
  
  public void setCodeErreurDateDebutPrime(String pCodeErreur)
  {
    m_fluxPrimesIndemVerseesDsnInfra.setDateDebutPrime_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinPrime()
  {
    return m_fluxPrimesIndemVerseesDsnInfra.getDateFinPrime();
  }
  
  public String getCodeErreurDateFinPrime()
  {
    return m_fluxPrimesIndemVerseesDsnInfra.getDateFinPrime_C_ERR();
  }
  
  public void setDateFinPrime(Damj pValeur)
  {
    m_fluxPrimesIndemVerseesDsnInfra.setDateFinPrime(pValeur);
  }
  
  public void setCodeErreurDateFinPrime(String pCodeErreur)
  {
    m_fluxPrimesIndemVerseesDsnInfra.setDateFinPrime_C_ERR(pCodeErreur);
  }
  
  public Damj getDatePaiement()
  {
    return m_fluxPrimesIndemVerseesDsnInfra.getDatePaiement();
  }
  
  public String getCodeErreurDatePaiement()
  {
    return m_fluxPrimesIndemVerseesDsnInfra.getDatePaiement_C_ERR();
  }
  
  public void setDatePaiement(Damj pValeur)
  {
    m_fluxPrimesIndemVerseesDsnInfra.setDatePaiement(pValeur);
  }
  
  public void setCodeErreurDatePaiement(String pCodeErreur)
  {
    m_fluxPrimesIndemVerseesDsnInfra.setDatePaiement_C_ERR(pCodeErreur);
  }
  
  public _FluxPrimesIndemVerseesDsn getFluxPrimesIndemVerseesDsnInfra()
  {
    return m_fluxPrimesIndemVerseesDsnInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurTypePrimeIndem() != null) && 
      ("".equals(getCodeErreurTypePrimeIndem()))) {
      return true;
    }
    if ((getCodeErreurSigneMtantPrimeIndem() != null) && 
      ("".equals(getCodeErreurSigneMtantPrimeIndem()))) {
      return true;
    }
    if ((getCodeErreurMontantPrimeIndem() != null) && 
      ("".equals(getCodeErreurMontantPrimeIndem()))) {
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
    if ((getCodeErreurDatePaiement() != null) && 
      ("".equals(getCodeErreurDatePaiement()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxPrimesIndemVerseesDsnImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */