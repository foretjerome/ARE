package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Heure;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _ContexteServiceImpl
  extends ContexteService
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _ContexteService m_contexteServiceInfra;
  
  public _ContexteServiceImpl()
  {
    m_contexteServiceInfra = new _ContexteService();
  }
  
  public _ContexteServiceImpl(_ContexteService pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("ContexteServiceInfra", pValeur);
    
    m_contexteServiceInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_contexteServiceInfra;
  }
  
  public String getIdentifiant()
  {
    return m_contexteServiceInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_contexteServiceInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_contexteServiceInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_contexteServiceInfra.set_C_ETAT(pCode);
  }
  
  public String getIdFlux()
  {
    return m_contexteServiceInfra.getIdFlux();
  }
  
  public String getCodeErreurIdFlux()
  {
    return m_contexteServiceInfra.getIdFlux_C_ERR();
  }
  
  public void setIdFlux(String pValeur)
  {
    m_contexteServiceInfra.setIdFlux(pValeur);
  }
  
  public void setCodeErreurIdFlux(String pCodeErreur)
  {
    m_contexteServiceInfra.setIdFlux_C_ERR(pCodeErreur);
  }
  
  public String getContexteEmission()
  {
    return m_contexteServiceInfra.getContexteEmission();
  }
  
  public String getCodeErreurContexteEmission()
  {
    return m_contexteServiceInfra.getContexteEmission_C_ERR();
  }
  
  public void setContexteEmission(String pValeur)
  {
    m_contexteServiceInfra.setContexteEmission(pValeur);
  }
  
  public void setCodeErreurContexteEmission(String pCodeErreur)
  {
    m_contexteServiceInfra.setContexteEmission_C_ERR(pCodeErreur);
  }
  
  public String getSrcCodeAssedic()
  {
    return m_contexteServiceInfra.getSrcCodeAssedic();
  }
  
  public String getCodeErreurSrcCodeAssedic()
  {
    return m_contexteServiceInfra.getSrcCodeAssedic_C_ERR();
  }
  
  public void setSrcCodeAssedic(String pValeur)
  {
    m_contexteServiceInfra.setSrcCodeAssedic(pValeur);
  }
  
  public void setCodeErreurSrcCodeAssedic(String pCodeErreur)
  {
    m_contexteServiceInfra.setSrcCodeAssedic_C_ERR(pCodeErreur);
  }
  
  public String getSrcCodeApplication()
  {
    return m_contexteServiceInfra.getSrcCodeApplication();
  }
  
  public String getCodeErreurSrcCodeApplication()
  {
    return m_contexteServiceInfra.getSrcCodeApplication_C_ERR();
  }
  
  public void setSrcCodeApplication(String pValeur)
  {
    m_contexteServiceInfra.setSrcCodeApplication(pValeur);
  }
  
  public void setCodeErreurSrcCodeApplication(String pCodeErreur)
  {
    m_contexteServiceInfra.setSrcCodeApplication_C_ERR(pCodeErreur);
  }
  
  public String getSrcCodeDomaine()
  {
    return m_contexteServiceInfra.getSrcCodeDomaine();
  }
  
  public String getCodeErreurSrcCodeDomaine()
  {
    return m_contexteServiceInfra.getSrcCodeDomaine_C_ERR();
  }
  
  public void setSrcCodeDomaine(String pValeur)
  {
    m_contexteServiceInfra.setSrcCodeDomaine(pValeur);
  }
  
  public void setCodeErreurSrcCodeDomaine(String pCodeErreur)
  {
    m_contexteServiceInfra.setSrcCodeDomaine_C_ERR(pCodeErreur);
  }
  
  public String getSrcCodeProcessus()
  {
    return m_contexteServiceInfra.getSrcCodeProcessus();
  }
  
  public String getCodeErreurSrcCodeProcessus()
  {
    return m_contexteServiceInfra.getSrcCodeProcessus_C_ERR();
  }
  
  public void setSrcCodeProcessus(String pValeur)
  {
    m_contexteServiceInfra.setSrcCodeProcessus(pValeur);
  }
  
  public void setCodeErreurSrcCodeProcessus(String pCodeErreur)
  {
    m_contexteServiceInfra.setSrcCodeProcessus_C_ERR(pCodeErreur);
  }
  
  public String getSrcCodeTransaction()
  {
    return m_contexteServiceInfra.getSrcCodeTransaction();
  }
  
  public String getCodeErreurSrcCodeTransaction()
  {
    return m_contexteServiceInfra.getSrcCodeTransaction_C_ERR();
  }
  
  public void setSrcCodeTransaction(String pValeur)
  {
    m_contexteServiceInfra.setSrcCodeTransaction(pValeur);
  }
  
  public void setCodeErreurSrcCodeTransaction(String pCodeErreur)
  {
    m_contexteServiceInfra.setSrcCodeTransaction_C_ERR(pCodeErreur);
  }
  
  public String getSrcCodeProgramme()
  {
    return m_contexteServiceInfra.getSrcCodeProgramme();
  }
  
  public String getCodeErreurSrcCodeProgramme()
  {
    return m_contexteServiceInfra.getSrcCodeProgramme_C_ERR();
  }
  
  public void setSrcCodeProgramme(String pValeur)
  {
    m_contexteServiceInfra.setSrcCodeProgramme(pValeur);
  }
  
  public void setCodeErreurSrcCodeProgramme(String pCodeErreur)
  {
    m_contexteServiceInfra.setSrcCodeProgramme_C_ERR(pCodeErreur);
  }
  
  public String getSrcCodeAgent()
  {
    return m_contexteServiceInfra.getSrcCodeAgent();
  }
  
  public String getCodeErreurSrcCodeAgent()
  {
    return m_contexteServiceInfra.getSrcCodeAgent_C_ERR();
  }
  
  public void setSrcCodeAgent(String pValeur)
  {
    m_contexteServiceInfra.setSrcCodeAgent(pValeur);
  }
  
  public void setCodeErreurSrcCodeAgent(String pCodeErreur)
  {
    m_contexteServiceInfra.setSrcCodeAgent_C_ERR(pCodeErreur);
  }
  
  public String getDstCodeAssedic()
  {
    return m_contexteServiceInfra.getDstCodeAssedic();
  }
  
  public String getCodeErreurDstCodeAssedic()
  {
    return m_contexteServiceInfra.getDstCodeAssedic_C_ERR();
  }
  
  public void setDstCodeAssedic(String pValeur)
  {
    m_contexteServiceInfra.setDstCodeAssedic(pValeur);
  }
  
  public void setCodeErreurDstCodeAssedic(String pCodeErreur)
  {
    m_contexteServiceInfra.setDstCodeAssedic_C_ERR(pCodeErreur);
  }
  
  public String getDstCodeApplication()
  {
    return m_contexteServiceInfra.getDstCodeApplication();
  }
  
  public String getCodeErreurDstCodeApplication()
  {
    return m_contexteServiceInfra.getDstCodeApplication_C_ERR();
  }
  
  public void setDstCodeApplication(String pValeur)
  {
    m_contexteServiceInfra.setDstCodeApplication(pValeur);
  }
  
  public void setCodeErreurDstCodeApplication(String pCodeErreur)
  {
    m_contexteServiceInfra.setDstCodeApplication_C_ERR(pCodeErreur);
  }
  
  public String getDstCodeDomaine()
  {
    return m_contexteServiceInfra.getDstCodeDomaine();
  }
  
  public String getCodeErreurDstCodeDomaine()
  {
    return m_contexteServiceInfra.getDstCodeDomaine_C_ERR();
  }
  
  public void setDstCodeDomaine(String pValeur)
  {
    m_contexteServiceInfra.setDstCodeDomaine(pValeur);
  }
  
  public void setCodeErreurDstCodeDomaine(String pCodeErreur)
  {
    m_contexteServiceInfra.setDstCodeDomaine_C_ERR(pCodeErreur);
  }
  
  public String getCodeActivite()
  {
    return m_contexteServiceInfra.getCodeActivite();
  }
  
  public String getCodeErreurCodeActivite()
  {
    return m_contexteServiceInfra.getCodeActivite_C_ERR();
  }
  
  public void setCodeActivite(String pValeur)
  {
    m_contexteServiceInfra.setCodeActivite(pValeur);
  }
  
  public void setCodeErreurCodeActivite(String pCodeErreur)
  {
    m_contexteServiceInfra.setCodeActivite_C_ERR(pCodeErreur);
  }
  
  public String getIdCourantTracker()
  {
    return m_contexteServiceInfra.getIdCourantTracker();
  }
  
  public String getCodeErreurIdCourantTracker()
  {
    return m_contexteServiceInfra.getIdCourantTracker_C_ERR();
  }
  
  public void setIdCourantTracker(String pValeur)
  {
    m_contexteServiceInfra.setIdCourantTracker(pValeur);
  }
  
  public void setCodeErreurIdCourantTracker(String pCodeErreur)
  {
    m_contexteServiceInfra.setIdCourantTracker_C_ERR(pCodeErreur);
  }
  
  public String getIdOrigineTracker()
  {
    return m_contexteServiceInfra.getIdOrigineTracker();
  }
  
  public String getCodeErreurIdOrigineTracker()
  {
    return m_contexteServiceInfra.getIdOrigineTracker_C_ERR();
  }
  
  public void setIdOrigineTracker(String pValeur)
  {
    m_contexteServiceInfra.setIdOrigineTracker(pValeur);
  }
  
  public void setCodeErreurIdOrigineTracker(String pCodeErreur)
  {
    m_contexteServiceInfra.setIdOrigineTracker_C_ERR(pCodeErreur);
  }
  
  public String getIdPrecedentTracker()
  {
    return m_contexteServiceInfra.getIdPrecedentTracker();
  }
  
  public String getCodeErreurIdPrecedentTracker()
  {
    return m_contexteServiceInfra.getIdPrecedentTracker_C_ERR();
  }
  
  public void setIdPrecedentTracker(String pValeur)
  {
    m_contexteServiceInfra.setIdPrecedentTracker(pValeur);
  }
  
  public void setCodeErreurIdPrecedentTracker(String pCodeErreur)
  {
    m_contexteServiceInfra.setIdPrecedentTracker_C_ERR(pCodeErreur);
  }
  
  public String getCodeFlux()
  {
    return m_contexteServiceInfra.getCodeFlux();
  }
  
  public String getCodeErreurCodeFlux()
  {
    return m_contexteServiceInfra.getCodeFlux_C_ERR();
  }
  
  public void setCodeFlux(String pValeur)
  {
    m_contexteServiceInfra.setCodeFlux(pValeur);
  }
  
  public void setCodeErreurCodeFlux(String pCodeErreur)
  {
    m_contexteServiceInfra.setCodeFlux_C_ERR(pCodeErreur);
  }
  
  public String getEnvtNature()
  {
    return m_contexteServiceInfra.getEnvtNature();
  }
  
  public String getCodeErreurEnvtNature()
  {
    return m_contexteServiceInfra.getEnvtNature_C_ERR();
  }
  
  public void setEnvtNature(String pValeur)
  {
    m_contexteServiceInfra.setEnvtNature(pValeur);
  }
  
  public void setCodeErreurEnvtNature(String pCodeErreur)
  {
    m_contexteServiceInfra.setEnvtNature_C_ERR(pCodeErreur);
  }
  
  public String getEnvtBase()
  {
    return m_contexteServiceInfra.getEnvtBase();
  }
  
  public String getCodeErreurEnvtBase()
  {
    return m_contexteServiceInfra.getEnvtBase_C_ERR();
  }
  
  public void setEnvtBase(String pValeur)
  {
    m_contexteServiceInfra.setEnvtBase(pValeur);
  }
  
  public void setCodeErreurEnvtBase(String pCodeErreur)
  {
    m_contexteServiceInfra.setEnvtBase_C_ERR(pCodeErreur);
  }
  
  public String getEnvtServeur()
  {
    return m_contexteServiceInfra.getEnvtServeur();
  }
  
  public String getCodeErreurEnvtServeur()
  {
    return m_contexteServiceInfra.getEnvtServeur_C_ERR();
  }
  
  public void setEnvtServeur(String pValeur)
  {
    m_contexteServiceInfra.setEnvtServeur(pValeur);
  }
  
  public void setCodeErreurEnvtServeur(String pCodeErreur)
  {
    m_contexteServiceInfra.setEnvtServeur_C_ERR(pCodeErreur);
  }
  
  public String getAdresseIP()
  {
    return m_contexteServiceInfra.getAdresseIP();
  }
  
  public String getCodeErreurAdresseIP()
  {
    return m_contexteServiceInfra.getAdresseIP_C_ERR();
  }
  
  public void setAdresseIP(String pValeur)
  {
    m_contexteServiceInfra.setAdresseIP(pValeur);
  }
  
  public void setCodeErreurAdresseIP(String pCodeErreur)
  {
    m_contexteServiceInfra.setAdresseIP_C_ERR(pCodeErreur);
  }
  
  public String getTypeEntite()
  {
    return m_contexteServiceInfra.getTypeEntite();
  }
  
  public String getCodeErreurTypeEntite()
  {
    return m_contexteServiceInfra.getTypeEntite_C_ERR();
  }
  
  public void setTypeEntite(String pValeur)
  {
    m_contexteServiceInfra.setTypeEntite(pValeur);
  }
  
  public void setCodeErreurTypeEntite(String pCodeErreur)
  {
    m_contexteServiceInfra.setTypeEntite_C_ERR(pCodeErreur);
  }
  
  public String getRsin()
  {
    return m_contexteServiceInfra.getRsin();
  }
  
  public String getCodeErreurRsin()
  {
    return m_contexteServiceInfra.getRsin_C_ERR();
  }
  
  public void setRsin(String pValeur)
  {
    m_contexteServiceInfra.setRsin(pValeur);
  }
  
  public void setCodeErreurRsin(String pCodeErreur)
  {
    m_contexteServiceInfra.setRsin_C_ERR(pCodeErreur);
  }
  
  public String getIdEntiteAutre()
  {
    return m_contexteServiceInfra.getIdEntiteAutre();
  }
  
  public String getCodeErreurIdEntiteAutre()
  {
    return m_contexteServiceInfra.getIdEntiteAutre_C_ERR();
  }
  
  public void setIdEntiteAutre(String pValeur)
  {
    m_contexteServiceInfra.setIdEntiteAutre(pValeur);
  }
  
  public void setCodeErreurIdEntiteAutre(String pCodeErreur)
  {
    m_contexteServiceInfra.setIdEntiteAutre_C_ERR(pCodeErreur);
  }
  
  public String getCodeAntenne()
  {
    return m_contexteServiceInfra.getCodeAntenne();
  }
  
  public String getCodeErreurCodeAntenne()
  {
    return m_contexteServiceInfra.getCodeAntenne_C_ERR();
  }
  
  public void setCodeAntenne(String pValeur)
  {
    m_contexteServiceInfra.setCodeAntenne(pValeur);
  }
  
  public void setCodeErreurCodeAntenne(String pCodeErreur)
  {
    m_contexteServiceInfra.setCodeAntenne_C_ERR(pCodeErreur);
  }
  
  public Damj getDateCreation()
  {
    return m_contexteServiceInfra.getDateCreation();
  }
  
  public String getCodeErreurDateCreation()
  {
    return m_contexteServiceInfra.getDateCreation_C_ERR();
  }
  
  public void setDateCreation(Damj pValeur)
  {
    m_contexteServiceInfra.setDateCreation(pValeur);
  }
  
  public void setCodeErreurDateCreation(String pCodeErreur)
  {
    m_contexteServiceInfra.setDateCreation_C_ERR(pCodeErreur);
  }
  
  public Damj getDateTraitement()
  {
    return m_contexteServiceInfra.getDateTraitement();
  }
  
  public String getCodeErreurDateTraitement()
  {
    return m_contexteServiceInfra.getDateTraitement_C_ERR();
  }
  
  public void setDateTraitement(Damj pValeur)
  {
    m_contexteServiceInfra.setDateTraitement(pValeur);
  }
  
  public void setCodeErreurDateTraitement(String pCodeErreur)
  {
    m_contexteServiceInfra.setDateTraitement_C_ERR(pCodeErreur);
  }
  
  public Heure getHeureCreation()
  {
    return m_contexteServiceInfra.getHeureCreation();
  }
  
  public String getCodeErreurHeureCreation()
  {
    return m_contexteServiceInfra.getHeureCreation_C_ERR();
  }
  
  public void setHeureCreation(Heure pValeur)
  {
    m_contexteServiceInfra.setHeureCreation(pValeur);
  }
  
  public void setCodeErreurHeureCreation(String pCodeErreur)
  {
    m_contexteServiceInfra.setHeureCreation_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getCxala()
  {
    return m_contexteServiceInfra.getCxala();
  }
  
  public String getCodeErreurCxala()
  {
    return m_contexteServiceInfra.getCxala_C_ERR();
  }
  
  public void setCxala(BigDecimal pValeur)
  {
    m_contexteServiceInfra.setCxala(pValeur);
  }
  
  public void setCodeErreurCxala(String pCodeErreur)
  {
    m_contexteServiceInfra.setCxala_C_ERR(pCodeErreur);
  }
  
  public _ContexteService getContexteServiceInfra()
  {
    return m_contexteServiceInfra;
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
    if ((getCodeErreurSrcCodeTransaction() != null) && 
      ("".equals(getCodeErreurSrcCodeTransaction()))) {
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
    return false;
  }
}

/* Location:
 * Qualified Name:     _ContexteServiceImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */