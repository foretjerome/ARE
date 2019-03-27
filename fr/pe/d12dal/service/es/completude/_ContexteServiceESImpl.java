package fr.pe.d12dal.service.es.completude;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Heure;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ContexteServiceESImpl
  extends ContexteServiceES
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ContexteServiceES m_contexteServiceESInfra;
  
  public _ContexteServiceESImpl()
  {
    m_contexteServiceESInfra = new _ContexteServiceES();
  }
  
  public _ContexteServiceESImpl(_ContexteServiceES pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("ContexteServiceESInfra", pValeur);
    
    m_contexteServiceESInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_contexteServiceESInfra;
  }
  
  public String getIdentifiant()
  {
    return m_contexteServiceESInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_contexteServiceESInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_contexteServiceESInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_contexteServiceESInfra.set_C_ETAT(pCode);
  }
  
  public String getIdFlux()
  {
    return m_contexteServiceESInfra.getIdFlux();
  }
  
  public String getCodeErreurIdFlux()
  {
    return m_contexteServiceESInfra.getIdFlux_C_ERR();
  }
  
  public void setIdFlux(String pValeur)
  {
    m_contexteServiceESInfra.setIdFlux(pValeur);
  }
  
  public void setCodeErreurIdFlux(String pCodeErreur)
  {
    m_contexteServiceESInfra.setIdFlux_C_ERR(pCodeErreur);
  }
  
  public String getContexteEmission()
  {
    return m_contexteServiceESInfra.getContexteEmission();
  }
  
  public String getCodeErreurContexteEmission()
  {
    return m_contexteServiceESInfra.getContexteEmission_C_ERR();
  }
  
  public void setContexteEmission(String pValeur)
  {
    m_contexteServiceESInfra.setContexteEmission(pValeur);
  }
  
  public void setCodeErreurContexteEmission(String pCodeErreur)
  {
    m_contexteServiceESInfra.setContexteEmission_C_ERR(pCodeErreur);
  }
  
  public String getSrcCodeAssedic()
  {
    return m_contexteServiceESInfra.getSrcCodeAssedic();
  }
  
  public String getCodeErreurSrcCodeAssedic()
  {
    return m_contexteServiceESInfra.getSrcCodeAssedic_C_ERR();
  }
  
  public void setSrcCodeAssedic(String pValeur)
  {
    m_contexteServiceESInfra.setSrcCodeAssedic(pValeur);
  }
  
  public void setCodeErreurSrcCodeAssedic(String pCodeErreur)
  {
    m_contexteServiceESInfra.setSrcCodeAssedic_C_ERR(pCodeErreur);
  }
  
  public String getSrcCodeApplication()
  {
    return m_contexteServiceESInfra.getSrcCodeApplication();
  }
  
  public String getCodeErreurSrcCodeApplication()
  {
    return m_contexteServiceESInfra.getSrcCodeApplication_C_ERR();
  }
  
  public void setSrcCodeApplication(String pValeur)
  {
    m_contexteServiceESInfra.setSrcCodeApplication(pValeur);
  }
  
  public void setCodeErreurSrcCodeApplication(String pCodeErreur)
  {
    m_contexteServiceESInfra.setSrcCodeApplication_C_ERR(pCodeErreur);
  }
  
  public String getSrcCodeDomaine()
  {
    return m_contexteServiceESInfra.getSrcCodeDomaine();
  }
  
  public String getCodeErreurSrcCodeDomaine()
  {
    return m_contexteServiceESInfra.getSrcCodeDomaine_C_ERR();
  }
  
  public void setSrcCodeDomaine(String pValeur)
  {
    m_contexteServiceESInfra.setSrcCodeDomaine(pValeur);
  }
  
  public void setCodeErreurSrcCodeDomaine(String pCodeErreur)
  {
    m_contexteServiceESInfra.setSrcCodeDomaine_C_ERR(pCodeErreur);
  }
  
  public String getSrcCodeProcessus()
  {
    return m_contexteServiceESInfra.getSrcCodeProcessus();
  }
  
  public String getCodeErreurSrcCodeProcessus()
  {
    return m_contexteServiceESInfra.getSrcCodeProcessus_C_ERR();
  }
  
  public void setSrcCodeProcessus(String pValeur)
  {
    m_contexteServiceESInfra.setSrcCodeProcessus(pValeur);
  }
  
  public void setCodeErreurSrcCodeProcessus(String pCodeErreur)
  {
    m_contexteServiceESInfra.setSrcCodeProcessus_C_ERR(pCodeErreur);
  }
  
  public String getSrcCodeProgramme()
  {
    return m_contexteServiceESInfra.getSrcCodeProgramme();
  }
  
  public String getCodeErreurSrcCodeProgramme()
  {
    return m_contexteServiceESInfra.getSrcCodeProgramme_C_ERR();
  }
  
  public void setSrcCodeProgramme(String pValeur)
  {
    m_contexteServiceESInfra.setSrcCodeProgramme(pValeur);
  }
  
  public void setCodeErreurSrcCodeProgramme(String pCodeErreur)
  {
    m_contexteServiceESInfra.setSrcCodeProgramme_C_ERR(pCodeErreur);
  }
  
  public String getSrcCodeAgent()
  {
    return m_contexteServiceESInfra.getSrcCodeAgent();
  }
  
  public String getCodeErreurSrcCodeAgent()
  {
    return m_contexteServiceESInfra.getSrcCodeAgent_C_ERR();
  }
  
  public void setSrcCodeAgent(String pValeur)
  {
    m_contexteServiceESInfra.setSrcCodeAgent(pValeur);
  }
  
  public void setCodeErreurSrcCodeAgent(String pCodeErreur)
  {
    m_contexteServiceESInfra.setSrcCodeAgent_C_ERR(pCodeErreur);
  }
  
  public String getDstCodeAssedic()
  {
    return m_contexteServiceESInfra.getDstCodeAssedic();
  }
  
  public String getCodeErreurDstCodeAssedic()
  {
    return m_contexteServiceESInfra.getDstCodeAssedic_C_ERR();
  }
  
  public void setDstCodeAssedic(String pValeur)
  {
    m_contexteServiceESInfra.setDstCodeAssedic(pValeur);
  }
  
  public void setCodeErreurDstCodeAssedic(String pCodeErreur)
  {
    m_contexteServiceESInfra.setDstCodeAssedic_C_ERR(pCodeErreur);
  }
  
  public String getDstCodeApplication()
  {
    return m_contexteServiceESInfra.getDstCodeApplication();
  }
  
  public String getCodeErreurDstCodeApplication()
  {
    return m_contexteServiceESInfra.getDstCodeApplication_C_ERR();
  }
  
  public void setDstCodeApplication(String pValeur)
  {
    m_contexteServiceESInfra.setDstCodeApplication(pValeur);
  }
  
  public void setCodeErreurDstCodeApplication(String pCodeErreur)
  {
    m_contexteServiceESInfra.setDstCodeApplication_C_ERR(pCodeErreur);
  }
  
  public String getDstCodeDomaine()
  {
    return m_contexteServiceESInfra.getDstCodeDomaine();
  }
  
  public String getCodeErreurDstCodeDomaine()
  {
    return m_contexteServiceESInfra.getDstCodeDomaine_C_ERR();
  }
  
  public void setDstCodeDomaine(String pValeur)
  {
    m_contexteServiceESInfra.setDstCodeDomaine(pValeur);
  }
  
  public void setCodeErreurDstCodeDomaine(String pCodeErreur)
  {
    m_contexteServiceESInfra.setDstCodeDomaine_C_ERR(pCodeErreur);
  }
  
  public String getCodeActivite()
  {
    return m_contexteServiceESInfra.getCodeActivite();
  }
  
  public String getCodeErreurCodeActivite()
  {
    return m_contexteServiceESInfra.getCodeActivite_C_ERR();
  }
  
  public void setCodeActivite(String pValeur)
  {
    m_contexteServiceESInfra.setCodeActivite(pValeur);
  }
  
  public void setCodeErreurCodeActivite(String pCodeErreur)
  {
    m_contexteServiceESInfra.setCodeActivite_C_ERR(pCodeErreur);
  }
  
  public String getIdCourantTracker()
  {
    return m_contexteServiceESInfra.getIdCourantTracker();
  }
  
  public String getCodeErreurIdCourantTracker()
  {
    return m_contexteServiceESInfra.getIdCourantTracker_C_ERR();
  }
  
  public void setIdCourantTracker(String pValeur)
  {
    m_contexteServiceESInfra.setIdCourantTracker(pValeur);
  }
  
  public void setCodeErreurIdCourantTracker(String pCodeErreur)
  {
    m_contexteServiceESInfra.setIdCourantTracker_C_ERR(pCodeErreur);
  }
  
  public String getIdOrigineTracker()
  {
    return m_contexteServiceESInfra.getIdOrigineTracker();
  }
  
  public String getCodeErreurIdOrigineTracker()
  {
    return m_contexteServiceESInfra.getIdOrigineTracker_C_ERR();
  }
  
  public void setIdOrigineTracker(String pValeur)
  {
    m_contexteServiceESInfra.setIdOrigineTracker(pValeur);
  }
  
  public void setCodeErreurIdOrigineTracker(String pCodeErreur)
  {
    m_contexteServiceESInfra.setIdOrigineTracker_C_ERR(pCodeErreur);
  }
  
  public String getIdPrecedentTracker()
  {
    return m_contexteServiceESInfra.getIdPrecedentTracker();
  }
  
  public String getCodeErreurIdPrecedentTracker()
  {
    return m_contexteServiceESInfra.getIdPrecedentTracker_C_ERR();
  }
  
  public void setIdPrecedentTracker(String pValeur)
  {
    m_contexteServiceESInfra.setIdPrecedentTracker(pValeur);
  }
  
  public void setCodeErreurIdPrecedentTracker(String pCodeErreur)
  {
    m_contexteServiceESInfra.setIdPrecedentTracker_C_ERR(pCodeErreur);
  }
  
  public String getCodeFlux()
  {
    return m_contexteServiceESInfra.getCodeFlux();
  }
  
  public String getCodeErreurCodeFlux()
  {
    return m_contexteServiceESInfra.getCodeFlux_C_ERR();
  }
  
  public void setCodeFlux(String pValeur)
  {
    m_contexteServiceESInfra.setCodeFlux(pValeur);
  }
  
  public void setCodeErreurCodeFlux(String pCodeErreur)
  {
    m_contexteServiceESInfra.setCodeFlux_C_ERR(pCodeErreur);
  }
  
  public String getEnvtNature()
  {
    return m_contexteServiceESInfra.getEnvtNature();
  }
  
  public String getCodeErreurEnvtNature()
  {
    return m_contexteServiceESInfra.getEnvtNature_C_ERR();
  }
  
  public void setEnvtNature(String pValeur)
  {
    m_contexteServiceESInfra.setEnvtNature(pValeur);
  }
  
  public void setCodeErreurEnvtNature(String pCodeErreur)
  {
    m_contexteServiceESInfra.setEnvtNature_C_ERR(pCodeErreur);
  }
  
  public String getEnvtBase()
  {
    return m_contexteServiceESInfra.getEnvtBase();
  }
  
  public String getCodeErreurEnvtBase()
  {
    return m_contexteServiceESInfra.getEnvtBase_C_ERR();
  }
  
  public void setEnvtBase(String pValeur)
  {
    m_contexteServiceESInfra.setEnvtBase(pValeur);
  }
  
  public void setCodeErreurEnvtBase(String pCodeErreur)
  {
    m_contexteServiceESInfra.setEnvtBase_C_ERR(pCodeErreur);
  }
  
  public String getEnvtServeur()
  {
    return m_contexteServiceESInfra.getEnvtServeur();
  }
  
  public String getCodeErreurEnvtServeur()
  {
    return m_contexteServiceESInfra.getEnvtServeur_C_ERR();
  }
  
  public void setEnvtServeur(String pValeur)
  {
    m_contexteServiceESInfra.setEnvtServeur(pValeur);
  }
  
  public void setCodeErreurEnvtServeur(String pCodeErreur)
  {
    m_contexteServiceESInfra.setEnvtServeur_C_ERR(pCodeErreur);
  }
  
  public String getAdresseIP()
  {
    return m_contexteServiceESInfra.getAdresseIP();
  }
  
  public String getCodeErreurAdresseIP()
  {
    return m_contexteServiceESInfra.getAdresseIP_C_ERR();
  }
  
  public void setAdresseIP(String pValeur)
  {
    m_contexteServiceESInfra.setAdresseIP(pValeur);
  }
  
  public void setCodeErreurAdresseIP(String pCodeErreur)
  {
    m_contexteServiceESInfra.setAdresseIP_C_ERR(pCodeErreur);
  }
  
  public String getTypeEntite()
  {
    return m_contexteServiceESInfra.getTypeEntite();
  }
  
  public String getCodeErreurTypeEntite()
  {
    return m_contexteServiceESInfra.getTypeEntite_C_ERR();
  }
  
  public void setTypeEntite(String pValeur)
  {
    m_contexteServiceESInfra.setTypeEntite(pValeur);
  }
  
  public void setCodeErreurTypeEntite(String pCodeErreur)
  {
    m_contexteServiceESInfra.setTypeEntite_C_ERR(pCodeErreur);
  }
  
  public String getRsin()
  {
    return m_contexteServiceESInfra.getRsin();
  }
  
  public String getCodeErreurRsin()
  {
    return m_contexteServiceESInfra.getRsin_C_ERR();
  }
  
  public void setRsin(String pValeur)
  {
    m_contexteServiceESInfra.setRsin(pValeur);
  }
  
  public void setCodeErreurRsin(String pCodeErreur)
  {
    m_contexteServiceESInfra.setRsin_C_ERR(pCodeErreur);
  }
  
  public String getIdEntiteAutre()
  {
    return m_contexteServiceESInfra.getIdEntiteAutre();
  }
  
  public String getCodeErreurIdEntiteAutre()
  {
    return m_contexteServiceESInfra.getIdEntiteAutre_C_ERR();
  }
  
  public void setIdEntiteAutre(String pValeur)
  {
    m_contexteServiceESInfra.setIdEntiteAutre(pValeur);
  }
  
  public void setCodeErreurIdEntiteAutre(String pCodeErreur)
  {
    m_contexteServiceESInfra.setIdEntiteAutre_C_ERR(pCodeErreur);
  }
  
  public String getCodeAntenne()
  {
    return m_contexteServiceESInfra.getCodeAntenne();
  }
  
  public String getCodeErreurCodeAntenne()
  {
    return m_contexteServiceESInfra.getCodeAntenne_C_ERR();
  }
  
  public void setCodeAntenne(String pValeur)
  {
    m_contexteServiceESInfra.setCodeAntenne(pValeur);
  }
  
  public void setCodeErreurCodeAntenne(String pCodeErreur)
  {
    m_contexteServiceESInfra.setCodeAntenne_C_ERR(pCodeErreur);
  }
  
  public Damj getDateCreation()
  {
    return m_contexteServiceESInfra.getDateCreation();
  }
  
  public String getCodeErreurDateCreation()
  {
    return m_contexteServiceESInfra.getDateCreation_C_ERR();
  }
  
  public void setDateCreation(Damj pValeur)
  {
    m_contexteServiceESInfra.setDateCreation(pValeur);
  }
  
  public void setCodeErreurDateCreation(String pCodeErreur)
  {
    m_contexteServiceESInfra.setDateCreation_C_ERR(pCodeErreur);
  }
  
  public Damj getDateTraitement()
  {
    return m_contexteServiceESInfra.getDateTraitement();
  }
  
  public String getCodeErreurDateTraitement()
  {
    return m_contexteServiceESInfra.getDateTraitement_C_ERR();
  }
  
  public void setDateTraitement(Damj pValeur)
  {
    m_contexteServiceESInfra.setDateTraitement(pValeur);
  }
  
  public void setCodeErreurDateTraitement(String pCodeErreur)
  {
    m_contexteServiceESInfra.setDateTraitement_C_ERR(pCodeErreur);
  }
  
  public Heure getHeureCreation()
  {
    return m_contexteServiceESInfra.getHeureCreation();
  }
  
  public String getCodeErreurHeureCreation()
  {
    return m_contexteServiceESInfra.getHeureCreation_C_ERR();
  }
  
  public void setHeureCreation(Heure pValeur)
  {
    m_contexteServiceESInfra.setHeureCreation(pValeur);
  }
  
  public void setCodeErreurHeureCreation(String pCodeErreur)
  {
    m_contexteServiceESInfra.setHeureCreation_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getCxala()
  {
    return m_contexteServiceESInfra.getCxala();
  }
  
  public String getCodeErreurCxala()
  {
    return m_contexteServiceESInfra.getCxala_C_ERR();
  }
  
  public void setCxala(BigDecimal pValeur)
  {
    m_contexteServiceESInfra.setCxala(pValeur);
  }
  
  public void setCodeErreurCxala(String pCodeErreur)
  {
    m_contexteServiceESInfra.setCxala_C_ERR(pCodeErreur);
  }
  
  public Damj getDateHeureCreation()
  {
    return m_contexteServiceESInfra.getDateHeureCreation();
  }
  
  public String getCodeErreurDateHeureCreation()
  {
    return m_contexteServiceESInfra.getDateHeureCreation_C_ERR();
  }
  
  public void setDateHeureCreation(Damj pValeur)
  {
    m_contexteServiceESInfra.setDateHeureCreation(pValeur);
  }
  
  public void setCodeErreurDateHeureCreation(String pCodeErreur)
  {
    m_contexteServiceESInfra.setDateHeureCreation_C_ERR(pCodeErreur);
  }
  
  public String getSrcCodeTransaction()
  {
    return m_contexteServiceESInfra.getSrcCodeTransaction();
  }
  
  public String getCodeErreurSrcCodeTransaction()
  {
    return m_contexteServiceESInfra.getSrcCodeTransaction_C_ERR();
  }
  
  public void setSrcCodeTransaction(String pValeur)
  {
    m_contexteServiceESInfra.setSrcCodeTransaction(pValeur);
  }
  
  public void setCodeErreurSrcCodeTransaction(String pCodeErreur)
  {
    m_contexteServiceESInfra.setSrcCodeTransaction_C_ERR(pCodeErreur);
  }
  
  public _ContexteServiceES getContexteServiceESInfra()
  {
    return m_contexteServiceESInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurIdFlux() != null) && 
      ("".equals(getCodeErreurIdFlux()))) {
      return true;
    }
    if ((getCodeErreurContexteEmission() != null) && 
      ("".equals(getCodeErreurContexteEmission()))) {
      return true;
    }
    if ((getCodeErreurSrcCodeAssedic() != null) && 
      ("".equals(getCodeErreurSrcCodeAssedic()))) {
      return true;
    }
    if ((getCodeErreurSrcCodeApplication() != null) && 
      ("".equals(getCodeErreurSrcCodeApplication()))) {
      return true;
    }
    if ((getCodeErreurSrcCodeDomaine() != null) && 
      ("".equals(getCodeErreurSrcCodeDomaine()))) {
      return true;
    }
    if ((getCodeErreurSrcCodeProcessus() != null) && 
      ("".equals(getCodeErreurSrcCodeProcessus()))) {
      return true;
    }
    if ((getCodeErreurSrcCodeProgramme() != null) && 
      ("".equals(getCodeErreurSrcCodeProgramme()))) {
      return true;
    }
    if ((getCodeErreurSrcCodeAgent() != null) && 
      ("".equals(getCodeErreurSrcCodeAgent()))) {
      return true;
    }
    if ((getCodeErreurDstCodeAssedic() != null) && 
      ("".equals(getCodeErreurDstCodeAssedic()))) {
      return true;
    }
    if ((getCodeErreurDstCodeApplication() != null) && 
      ("".equals(getCodeErreurDstCodeApplication()))) {
      return true;
    }
    if ((getCodeErreurDstCodeDomaine() != null) && 
      ("".equals(getCodeErreurDstCodeDomaine()))) {
      return true;
    }
    if ((getCodeErreurCodeActivite() != null) && 
      ("".equals(getCodeErreurCodeActivite()))) {
      return true;
    }
    if ((getCodeErreurIdCourantTracker() != null) && 
      ("".equals(getCodeErreurIdCourantTracker()))) {
      return true;
    }
    if ((getCodeErreurIdOrigineTracker() != null) && 
      ("".equals(getCodeErreurIdOrigineTracker()))) {
      return true;
    }
    if ((getCodeErreurIdPrecedentTracker() != null) && 
      ("".equals(getCodeErreurIdPrecedentTracker()))) {
      return true;
    }
    if ((getCodeErreurCodeFlux() != null) && 
      ("".equals(getCodeErreurCodeFlux()))) {
      return true;
    }
    if ((getCodeErreurEnvtNature() != null) && 
      ("".equals(getCodeErreurEnvtNature()))) {
      return true;
    }
    if ((getCodeErreurEnvtBase() != null) && 
      ("".equals(getCodeErreurEnvtBase()))) {
      return true;
    }
    if ((getCodeErreurEnvtServeur() != null) && 
      ("".equals(getCodeErreurEnvtServeur()))) {
      return true;
    }
    if ((getCodeErreurAdresseIP() != null) && 
      ("".equals(getCodeErreurAdresseIP()))) {
      return true;
    }
    if ((getCodeErreurTypeEntite() != null) && 
      ("".equals(getCodeErreurTypeEntite()))) {
      return true;
    }
    if ((getCodeErreurRsin() != null) && 
      ("".equals(getCodeErreurRsin()))) {
      return true;
    }
    if ((getCodeErreurIdEntiteAutre() != null) && 
      ("".equals(getCodeErreurIdEntiteAutre()))) {
      return true;
    }
    if ((getCodeErreurCodeAntenne() != null) && 
      ("".equals(getCodeErreurCodeAntenne()))) {
      return true;
    }
    if ((getCodeErreurDateCreation() != null) && 
      ("".equals(getCodeErreurDateCreation()))) {
      return true;
    }
    if ((getCodeErreurDateTraitement() != null) && 
      ("".equals(getCodeErreurDateTraitement()))) {
      return true;
    }
    if ((getCodeErreurHeureCreation() != null) && 
      ("".equals(getCodeErreurHeureCreation()))) {
      return true;
    }
    if ((getCodeErreurCxala() != null) && 
      ("".equals(getCodeErreurCxala()))) {
      return true;
    }
    if ((getCodeErreurDateHeureCreation() != null) && 
      ("".equals(getCodeErreurDateHeureCreation()))) {
      return true;
    }
    if ((getCodeErreurSrcCodeTransaction() != null) && 
      ("".equals(getCodeErreurSrcCodeTransaction()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _ContexteServiceESImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */