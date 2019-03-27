package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxMSAImpl
  extends FluxMSA
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxMSA m_fluxMSAInfra;
  
  public _FluxMSAImpl()
  {
    m_fluxMSAInfra = new _FluxMSA();
  }
  
  public _FluxMSAImpl(_FluxMSA pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxMSAInfra", pValeur);
    
    m_fluxMSAInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxMSAInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxMSAInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxMSAInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxMSAInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxMSAInfra.set_C_ETAT(pCode);
  }
  
  public String getTypeEnregistrement()
  {
    return m_fluxMSAInfra.getTypeEnregistrement();
  }
  
  public String getCodeErreurTypeEnregistrement()
  {
    return m_fluxMSAInfra.getTypeEnregistrement_C_ERR();
  }
  
  public void setTypeEnregistrement(String pValeur)
  {
    m_fluxMSAInfra.setTypeEnregistrement(pValeur);
  }
  
  public void setCodeErreurTypeEnregistrement(String pCodeErreur)
  {
    m_fluxMSAInfra.setTypeEnregistrement_C_ERR(pCodeErreur);
  }
  
  public String getCodeMSA()
  {
    return m_fluxMSAInfra.getCodeMSA();
  }
  
  public String getCodeErreurCodeMSA()
  {
    return m_fluxMSAInfra.getCodeMSA_C_ERR();
  }
  
  public void setCodeMSA(String pValeur)
  {
    m_fluxMSAInfra.setCodeMSA(pValeur);
  }
  
  public void setCodeErreurCodeMSA(String pCodeErreur)
  {
    m_fluxMSAInfra.setCodeMSA_C_ERR(pCodeErreur);
  }
  
  public String getNumeroAllocataire()
  {
    return m_fluxMSAInfra.getNumeroAllocataire();
  }
  
  public String getCodeErreurNumeroAllocataire()
  {
    return m_fluxMSAInfra.getNumeroAllocataire_C_ERR();
  }
  
  public void setNumeroAllocataire(String pValeur)
  {
    m_fluxMSAInfra.setNumeroAllocataire(pValeur);
  }
  
  public void setCodeErreurNumeroAllocataire(String pCodeErreur)
  {
    m_fluxMSAInfra.setNumeroAllocataire_C_ERR(pCodeErreur);
  }
  
  public String getNIRRectifie()
  {
    return m_fluxMSAInfra.getNIRRectifie();
  }
  
  public String getCodeErreurNIRRectifie()
  {
    return m_fluxMSAInfra.getNIRRectifie_C_ERR();
  }
  
  public void setNIRRectifie(String pValeur)
  {
    m_fluxMSAInfra.setNIRRectifie(pValeur);
  }
  
  public void setCodeErreurNIRRectifie(String pCodeErreur)
  {
    m_fluxMSAInfra.setNIRRectifie_C_ERR(pCodeErreur);
  }
  
  public String getIdentifiantEchangeMSA()
  {
    return m_fluxMSAInfra.getIdentifiantEchangeMSA();
  }
  
  public String getCodeErreurIdentifiantEchangeMSA()
  {
    return m_fluxMSAInfra.getIdentifiantEchangeMSA_C_ERR();
  }
  
  public void setIdentifiantEchangeMSA(String pValeur)
  {
    m_fluxMSAInfra.setIdentifiantEchangeMSA(pValeur);
  }
  
  public void setCodeErreurIdentifiantEchangeMSA(String pCodeErreur)
  {
    m_fluxMSAInfra.setIdentifiantEchangeMSA_C_ERR(pCodeErreur);
  }
  
  public String getNomPatronymique()
  {
    return m_fluxMSAInfra.getNomPatronymique();
  }
  
  public String getCodeErreurNomPatronymique()
  {
    return m_fluxMSAInfra.getNomPatronymique_C_ERR();
  }
  
  public void setNomPatronymique(String pValeur)
  {
    m_fluxMSAInfra.setNomPatronymique(pValeur);
  }
  
  public void setCodeErreurNomPatronymique(String pCodeErreur)
  {
    m_fluxMSAInfra.setNomPatronymique_C_ERR(pCodeErreur);
  }
  
  public String getPrenom()
  {
    return m_fluxMSAInfra.getPrenom();
  }
  
  public String getCodeErreurPrenom()
  {
    return m_fluxMSAInfra.getPrenom_C_ERR();
  }
  
  public void setPrenom(String pValeur)
  {
    m_fluxMSAInfra.setPrenom(pValeur);
  }
  
  public void setCodeErreurPrenom(String pCodeErreur)
  {
    m_fluxMSAInfra.setPrenom_C_ERR(pCodeErreur);
  }
  
  public String getCodePopulation()
  {
    return m_fluxMSAInfra.getCodePopulation();
  }
  
  public String getCodeErreurCodePopulation()
  {
    return m_fluxMSAInfra.getCodePopulation_C_ERR();
  }
  
  public void setCodePopulation(String pValeur)
  {
    m_fluxMSAInfra.setCodePopulation(pValeur);
  }
  
  public void setCodeErreurCodePopulation(String pCodeErreur)
  {
    m_fluxMSAInfra.setCodePopulation_C_ERR(pCodeErreur);
  }
  
  public String getDeptNumeroInseeCommune()
  {
    return m_fluxMSAInfra.getDeptNumeroInseeCommune();
  }
  
  public String getCodeErreurDeptNumeroInseeCommune()
  {
    return m_fluxMSAInfra.getDeptNumeroInseeCommune_C_ERR();
  }
  
  public void setDeptNumeroInseeCommune(String pValeur)
  {
    m_fluxMSAInfra.setDeptNumeroInseeCommune(pValeur);
  }
  
  public void setCodeErreurDeptNumeroInseeCommune(String pCodeErreur)
  {
    m_fluxMSAInfra.setDeptNumeroInseeCommune_C_ERR(pCodeErreur);
  }
  
  public String getNumeroIdentification()
  {
    return m_fluxMSAInfra.getNumeroIdentification();
  }
  
  public String getCodeErreurNumeroIdentification()
  {
    return m_fluxMSAInfra.getNumeroIdentification_C_ERR();
  }
  
  public void setNumeroIdentification(String pValeur)
  {
    m_fluxMSAInfra.setNumeroIdentification(pValeur);
  }
  
  public void setCodeErreurNumeroIdentification(String pCodeErreur)
  {
    m_fluxMSAInfra.setNumeroIdentification_C_ERR(pCodeErreur);
  }
  
  public String getCodeStatut()
  {
    return m_fluxMSAInfra.getCodeStatut();
  }
  
  public String getCodeErreurCodeStatut()
  {
    return m_fluxMSAInfra.getCodeStatut_C_ERR();
  }
  
  public void setCodeStatut(String pValeur)
  {
    m_fluxMSAInfra.setCodeStatut(pValeur);
  }
  
  public void setCodeErreurCodeStatut(String pCodeErreur)
  {
    m_fluxMSAInfra.setCodeStatut_C_ERR(pCodeErreur);
  }
  
  public String getIdentifiantIndividuBNI()
  {
    return m_fluxMSAInfra.getIdentifiantIndividuBNI();
  }
  
  public String getCodeErreurIdentifiantIndividuBNI()
  {
    return m_fluxMSAInfra.getIdentifiantIndividuBNI_C_ERR();
  }
  
  public void setIdentifiantIndividuBNI(String pValeur)
  {
    m_fluxMSAInfra.setIdentifiantIndividuBNI(pValeur);
  }
  
  public void setCodeErreurIdentifiantIndividuBNI(String pCodeErreur)
  {
    m_fluxMSAInfra.setIdentifiantIndividuBNI_C_ERR(pCodeErreur);
  }
  
  public String getNomMarital()
  {
    return m_fluxMSAInfra.getNomMarital();
  }
  
  public String getCodeErreurNomMarital()
  {
    return m_fluxMSAInfra.getNomMarital_C_ERR();
  }
  
  public void setNomMarital(String pValeur)
  {
    m_fluxMSAInfra.setNomMarital(pValeur);
  }
  
  public void setCodeErreurNomMarital(String pCodeErreur)
  {
    m_fluxMSAInfra.setNomMarital_C_ERR(pCodeErreur);
  }
  
  public String getCodeAnteriorite()
  {
    return m_fluxMSAInfra.getCodeAnteriorite();
  }
  
  public String getCodeErreurCodeAnteriorite()
  {
    return m_fluxMSAInfra.getCodeAnteriorite_C_ERR();
  }
  
  public void setCodeAnteriorite(String pValeur)
  {
    m_fluxMSAInfra.setCodeAnteriorite(pValeur);
  }
  
  public void setCodeErreurCodeAnteriorite(String pCodeErreur)
  {
    m_fluxMSAInfra.setCodeAnteriorite_C_ERR(pCodeErreur);
  }
  
  public String getZoneInfos()
  {
    return m_fluxMSAInfra.getZoneInfos();
  }
  
  public String getCodeErreurZoneInfos()
  {
    return m_fluxMSAInfra.getZoneInfos_C_ERR();
  }
  
  public void setZoneInfos(String pValeur)
  {
    m_fluxMSAInfra.setZoneInfos(pValeur);
  }
  
  public void setCodeErreurZoneInfos(String pCodeErreur)
  {
    m_fluxMSAInfra.setZoneInfos_C_ERR(pCodeErreur);
  }
  
  public Damj getDateDebutClcaAjpp()
  {
    return m_fluxMSAInfra.getDateDebutClcaAjpp();
  }
  
  public String getCodeErreurDateDebutClcaAjpp()
  {
    return m_fluxMSAInfra.getDateDebutClcaAjpp_C_ERR();
  }
  
  public void setDateDebutClcaAjpp(Damj pValeur)
  {
    m_fluxMSAInfra.setDateDebutClcaAjpp(pValeur);
  }
  
  public void setCodeErreurDateDebutClcaAjpp(String pCodeErreur)
  {
    m_fluxMSAInfra.setDateDebutClcaAjpp_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFinClcaAjpp()
  {
    return m_fluxMSAInfra.getDateFinClcaAjpp();
  }
  
  public String getCodeErreurDateFinClcaAjpp()
  {
    return m_fluxMSAInfra.getDateFinClcaAjpp_C_ERR();
  }
  
  public void setDateFinClcaAjpp(Damj pValeur)
  {
    m_fluxMSAInfra.setDateFinClcaAjpp(pValeur);
  }
  
  public void setCodeErreurDateFinClcaAjpp(String pCodeErreur)
  {
    m_fluxMSAInfra.setDateFinClcaAjpp_C_ERR(pCodeErreur);
  }
  
  public Damj getDateNaissance()
  {
    return m_fluxMSAInfra.getDateNaissance();
  }
  
  public String getCodeErreurDateNaissance()
  {
    return m_fluxMSAInfra.getDateNaissance_C_ERR();
  }
  
  public void setDateNaissance(Damj pValeur)
  {
    m_fluxMSAInfra.setDateNaissance(pValeur);
  }
  
  public void setCodeErreurDateNaissance(String pCodeErreur)
  {
    m_fluxMSAInfra.setDateNaissance_C_ERR(pCodeErreur);
  }
  
  public _FluxMSA getFluxMSAInfra()
  {
    return m_fluxMSAInfra;
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  
  public boolean isEnErreur()
  {
    if ((getCodeErreurTypeEnregistrement() != null) && 
      ("".equals(getCodeErreurTypeEnregistrement()))) {
      return true;
    }
    if ((getCodeErreurCodeMSA() != null) && 
      ("".equals(getCodeErreurCodeMSA()))) {
      return true;
    }
    if ((getCodeErreurNumeroAllocataire() != null) && 
      ("".equals(getCodeErreurNumeroAllocataire()))) {
      return true;
    }
    if ((getCodeErreurNIRRectifie() != null) && 
      ("".equals(getCodeErreurNIRRectifie()))) {
      return true;
    }
    if ((getCodeErreurIdentifiantEchangeMSA() != null) && 
      ("".equals(getCodeErreurIdentifiantEchangeMSA()))) {
      return true;
    }
    if ((getCodeErreurNomPatronymique() != null) && 
      ("".equals(getCodeErreurNomPatronymique()))) {
      return true;
    }
    if ((getCodeErreurPrenom() != null) && 
      ("".equals(getCodeErreurPrenom()))) {
      return true;
    }
    if ((getCodeErreurCodePopulation() != null) && 
      ("".equals(getCodeErreurCodePopulation()))) {
      return true;
    }
    if ((getCodeErreurDeptNumeroInseeCommune() != null) && 
      ("".equals(getCodeErreurDeptNumeroInseeCommune()))) {
      return true;
    }
    if ((getCodeErreurNumeroIdentification() != null) && 
      ("".equals(getCodeErreurNumeroIdentification()))) {
      return true;
    }
    if ((getCodeErreurCodeStatut() != null) && 
      ("".equals(getCodeErreurCodeStatut()))) {
      return true;
    }
    if ((getCodeErreurIdentifiantIndividuBNI() != null) && 
      ("".equals(getCodeErreurIdentifiantIndividuBNI()))) {
      return true;
    }
    if ((getCodeErreurNomMarital() != null) && 
      ("".equals(getCodeErreurNomMarital()))) {
      return true;
    }
    if ((getCodeErreurCodeAnteriorite() != null) && 
      ("".equals(getCodeErreurCodeAnteriorite()))) {
      return true;
    }
    if ((getCodeErreurZoneInfos() != null) && 
      ("".equals(getCodeErreurZoneInfos()))) {
      return true;
    }
    if ((getCodeErreurDateDebutClcaAjpp() != null) && 
      ("".equals(getCodeErreurDateDebutClcaAjpp()))) {
      return true;
    }
    if ((getCodeErreurDateFinClcaAjpp() != null) && 
      ("".equals(getCodeErreurDateFinClcaAjpp()))) {
      return true;
    }
    if ((getCodeErreurDateNaissance() != null) && 
      ("".equals(getCodeErreurDateNaissance()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxMSAImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */