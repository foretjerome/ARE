package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxCPAMImpl
  extends FluxCPAM
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxCPAM m_fluxCPAMInfra;
  
  public _FluxCPAMImpl()
  {
    m_fluxCPAMInfra = new _FluxCPAM();
  }
  
  public _FluxCPAMImpl(_FluxCPAM pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxCPAMInfra", pValeur);
    
    m_fluxCPAMInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxCPAMInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxCPAMInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxCPAMInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxCPAMInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxCPAMInfra.set_C_ETAT(pCode);
  }
  
  public String getNumeroAllocataire()
  {
    return m_fluxCPAMInfra.getNumeroAllocataire();
  }
  
  public String getCodeErreurNumeroAllocataire()
  {
    return m_fluxCPAMInfra.getNumeroAllocataire_C_ERR();
  }
  
  public void setNumeroAllocataire(String pValeur)
  {
    m_fluxCPAMInfra.setNumeroAllocataire(pValeur);
  }
  
  public void setCodeErreurNumeroAllocataire(String pCodeErreur)
  {
    m_fluxCPAMInfra.setNumeroAllocataire_C_ERR(pCodeErreur);
  }
  
  public String getIndicateurCarence()
  {
    return m_fluxCPAMInfra.getIndicateurCarence();
  }
  
  public String getCodeErreurIndicateurCarence()
  {
    return m_fluxCPAMInfra.getIndicateurCarence_C_ERR();
  }
  
  public void setIndicateurCarence(String pValeur)
  {
    m_fluxCPAMInfra.setIndicateurCarence(pValeur);
  }
  
  public void setCodeErreurIndicateurCarence(String pCodeErreur)
  {
    m_fluxCPAMInfra.setIndicateurCarence_C_ERR(pCodeErreur);
  }
  
  public String getNir()
  {
    return m_fluxCPAMInfra.getNir();
  }
  
  public String getCodeErreurNir()
  {
    return m_fluxCPAMInfra.getNir_C_ERR();
  }
  
  public void setNir(String pValeur)
  {
    m_fluxCPAMInfra.setNir(pValeur);
  }
  
  public void setCodeErreurNir(String pCodeErreur)
  {
    m_fluxCPAMInfra.setNir_C_ERR(pCodeErreur);
  }
  
  public String getNom()
  {
    return m_fluxCPAMInfra.getNom();
  }
  
  public String getCodeErreurNom()
  {
    return m_fluxCPAMInfra.getNom_C_ERR();
  }
  
  public void setNom(String pValeur)
  {
    m_fluxCPAMInfra.setNom(pValeur);
  }
  
  public void setCodeErreurNom(String pCodeErreur)
  {
    m_fluxCPAMInfra.setNom_C_ERR(pCodeErreur);
  }
  
  public String getNomUsuel()
  {
    return m_fluxCPAMInfra.getNomUsuel();
  }
  
  public String getCodeErreurNomUsuel()
  {
    return m_fluxCPAMInfra.getNomUsuel_C_ERR();
  }
  
  public void setNomUsuel(String pValeur)
  {
    m_fluxCPAMInfra.setNomUsuel(pValeur);
  }
  
  public void setCodeErreurNomUsuel(String pCodeErreur)
  {
    m_fluxCPAMInfra.setNomUsuel_C_ERR(pCodeErreur);
  }
  
  public String getPrenom()
  {
    return m_fluxCPAMInfra.getPrenom();
  }
  
  public String getCodeErreurPrenom()
  {
    return m_fluxCPAMInfra.getPrenom_C_ERR();
  }
  
  public void setPrenom(String pValeur)
  {
    m_fluxCPAMInfra.setPrenom(pValeur);
  }
  
  public void setCodeErreurPrenom(String pCodeErreur)
  {
    m_fluxCPAMInfra.setPrenom_C_ERR(pCodeErreur);
  }
  
  public String getCodeAssedic()
  {
    return m_fluxCPAMInfra.getCodeAssedic();
  }
  
  public String getCodeErreurCodeAssedic()
  {
    return m_fluxCPAMInfra.getCodeAssedic_C_ERR();
  }
  
  public void setCodeAssedic(String pValeur)
  {
    m_fluxCPAMInfra.setCodeAssedic(pValeur);
  }
  
  public void setCodeErreurCodeAssedic(String pCodeErreur)
  {
    m_fluxCPAMInfra.setCodeAssedic_C_ERR(pCodeErreur);
  }
  
  public String getCodePostal()
  {
    return m_fluxCPAMInfra.getCodePostal();
  }
  
  public String getCodeErreurCodePostal()
  {
    return m_fluxCPAMInfra.getCodePostal_C_ERR();
  }
  
  public void setCodePostal(String pValeur)
  {
    m_fluxCPAMInfra.setCodePostal(pValeur);
  }
  
  public void setCodeErreurCodePostal(String pCodeErreur)
  {
    m_fluxCPAMInfra.setCodePostal_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebut()
  {
    return m_fluxCPAMInfra.getDateDebut();
  }
  
  public String getCodeErreurDateDebut()
  {
    return m_fluxCPAMInfra.getDateDebut_C_ERR();
  }
  
  public void setDateDebut(Damj pValeur)
  {
    m_fluxCPAMInfra.setDateDebut(pValeur);
  }
  
  public void setCodeErreurDateDebut(String pCodeErreur)
  {
    m_fluxCPAMInfra.setDateDebut_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFin()
  {
    return m_fluxCPAMInfra.getDateFin();
  }
  
  public String getCodeErreurDateFin()
  {
    return m_fluxCPAMInfra.getDateFin_C_ERR();
  }
  
  public void setDateFin(Damj pValeur)
  {
    m_fluxCPAMInfra.setDateFin(pValeur);
  }
  
  public void setCodeErreurDateFin(String pCodeErreur)
  {
    m_fluxCPAMInfra.setDateFin_C_ERR(pCodeErreur);
  }
  
  public Damj getDateNaissance()
  {
    return m_fluxCPAMInfra.getDateNaissance();
  }
  
  public String getCodeErreurDateNaissance()
  {
    return m_fluxCPAMInfra.getDateNaissance_C_ERR();
  }
  
  public void setDateNaissance(Damj pValeur)
  {
    m_fluxCPAMInfra.setDateNaissance(pValeur);
  }
  
  public void setCodeErreurDateNaissance(String pCodeErreur)
  {
    m_fluxCPAMInfra.setDateNaissance_C_ERR(pCodeErreur);
  }
  
  public BigDecimal getNumeroCPAM()
  {
    return m_fluxCPAMInfra.getNumeroCPAM();
  }
  
  public String getCodeErreurNumeroCPAM()
  {
    return m_fluxCPAMInfra.getNumeroCPAM_C_ERR();
  }
  
  public void setNumeroCPAM(BigDecimal pValeur)
  {
    m_fluxCPAMInfra.setNumeroCPAM(pValeur);
  }
  
  public void setCodeErreurNumeroCPAM(String pCodeErreur)
  {
    m_fluxCPAMInfra.setNumeroCPAM_C_ERR(pCodeErreur);
  }
  
  public _FluxCPAM getFluxCPAMInfra()
  {
    return m_fluxCPAMInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurNumeroAllocataire() != null) && 
      ("".equals(getCodeErreurNumeroAllocataire()))) {
      return true;
    }
    if ((getCodeErreurIndicateurCarence() != null) && 
      ("".equals(getCodeErreurIndicateurCarence()))) {
      return true;
    }
    if ((getCodeErreurNir() != null) && 
      ("".equals(getCodeErreurNir()))) {
      return true;
    }
    if ((getCodeErreurNom() != null) && 
      ("".equals(getCodeErreurNom()))) {
      return true;
    }
    if ((getCodeErreurNomUsuel() != null) && 
      ("".equals(getCodeErreurNomUsuel()))) {
      return true;
    }
    if ((getCodeErreurPrenom() != null) && 
      ("".equals(getCodeErreurPrenom()))) {
      return true;
    }
    if ((getCodeErreurCodeAssedic() != null) && 
      ("".equals(getCodeErreurCodeAssedic()))) {
      return true;
    }
    if ((getCodeErreurCodePostal() != null) && 
      ("".equals(getCodeErreurCodePostal()))) {
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
    if ((getCodeErreurDateNaissance() != null) && 
      ("".equals(getCodeErreurDateNaissance()))) {
      return true;
    }
    if ((getCodeErreurNumeroCPAM() != null) && 
      ("".equals(getCodeErreurNumeroCPAM()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxCPAMImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */