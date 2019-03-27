package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _IndividuImpl
  extends Individu
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _Individu m_individuInfra;
  
  public _IndividuImpl()
  {
    m_individuInfra = new _Individu();
  }
  
  public _IndividuImpl(_Individu pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("IndividuInfra", pValeur);
    
    m_individuInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_individuInfra;
  }
  
  public String getIdentifiant()
  {
    return m_individuInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_individuInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_individuInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_individuInfra.set_C_ETAT(pCode);
  }
  
  public String getIdentifiantSigma()
  {
    return m_individuInfra.getIdentifiantSigma();
  }
  
  public String getCodeErreurIdentifiantSigma()
  {
    return m_individuInfra.getIdentifiantSigma_C_ERR();
  }
  
  public void setIdentifiantSigma(String pValeur)
  {
    m_individuInfra.setIdentifiantSigma(pValeur);
  }
  
  public void setCodeErreurIdentifiantSigma(String pCodeErreur)
  {
    m_individuInfra.setIdentifiantSigma_C_ERR(pCodeErreur);
  }
  
  public String getCodeAntenne()
  {
    return m_individuInfra.getCodeAntenne();
  }
  
  public String getCodeErreurCodeAntenne()
  {
    return m_individuInfra.getCodeAntenne_C_ERR();
  }
  
  public void setCodeAntenne(String pValeur)
  {
    m_individuInfra.setCodeAntenne(pValeur);
  }
  
  public void setCodeErreurCodeAntenne(String pCodeErreur)
  {
    m_individuInfra.setCodeAntenne_C_ERR(pCodeErreur);
  }
  
  public String getNomPopulation()
  {
    return m_individuInfra.getNomPopulation();
  }
  
  public String getCodeErreurNomPopulation()
  {
    return m_individuInfra.getNomPopulation_C_ERR();
  }
  
  public void setNomPopulation(String pValeur)
  {
    m_individuInfra.setNomPopulation(pValeur);
  }
  
  public void setCodeErreurNomPopulation(String pCodeErreur)
  {
    m_individuInfra.setNomPopulation_C_ERR(pCodeErreur);
  }
  
  public Damj getDateReexecution()
  {
    return m_individuInfra.getDateReexecution();
  }
  
  public String getCodeErreurDateReexecution()
  {
    return m_individuInfra.getDateReexecution_C_ERR();
  }
  
  public void setDateReexecution(Damj pValeur)
  {
    m_individuInfra.setDateReexecution(pValeur);
  }
  
  public void setCodeErreurDateReexecution(String pCodeErreur)
  {
    m_individuInfra.setDateReexecution_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getIdentifiantBNI()
  {
    return m_individuInfra.getIdentifiantBNI();
  }
  
  public String getCodeErreurIdentifiantBNI()
  {
    return m_individuInfra.getIdentifiantBNI_C_ERR();
  }
  
  public void setIdentifiantBNI(BigDecimal pValeur)
  {
    m_individuInfra.setIdentifiantBNI(pValeur);
  }
  
  public void setCodeErreurIdentifiantBNI(String pCodeErreur)
  {
    m_individuInfra.setIdentifiantBNI_C_ERR(pCodeErreur);
  }
  
  public _Individu getIndividuInfra()
  {
    return m_individuInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurIdentifiantSigma() != null) && 
      ("".equals(getCodeErreurIdentifiantSigma()))) {
      return true;
    }
    if ((getCodeErreurCodeAntenne() != null) && 
      ("".equals(getCodeErreurCodeAntenne()))) {
      return true;
    }
    if ((getCodeErreurNomPopulation() != null) && 
      ("".equals(getCodeErreurNomPopulation()))) {
      return true;
    }
    if ((getCodeErreurDateReexecution() != null) && 
      ("".equals(getCodeErreurDateReexecution()))) {
      return true;
    }
    if ((getCodeErreurIdentifiantBNI() != null) && 
      ("".equals(getCodeErreurIdentifiantBNI()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _IndividuImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */