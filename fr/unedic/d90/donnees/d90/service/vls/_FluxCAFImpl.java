package fr.unedic.d90.donnees.d90.service.vls;

import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.adaptateur.ObjetSerialisableFournisseur;
import fr.unedic.util.temps.Damj;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class _FluxCAFImpl
  extends FluxCAF
  implements ObjetSerialisableFournisseur, Serializable
{
  private static final long serialVersionUID = 1L;
  private final _FluxCAF m_fluxCAFInfra;
  
  public _FluxCAFImpl()
  {
    m_fluxCAFInfra = new _FluxCAF();
  }
  
  public _FluxCAFImpl(_FluxCAF pValeur)
  {
    ExceptionUtil.assertMethodParamNotNull("FluxCAFInfra", pValeur);
    
    m_fluxCAFInfra = pValeur;
  }
  
  public Object getObjet()
  {
    return m_fluxCAFInfra;
  }
  
  public String getIdentifiant()
  {
    return m_fluxCAFInfra.get_IDENT();
  }
  
  public void setIdentifiant(String pIdentifiant)
  {
    m_fluxCAFInfra.set_IDENT(pIdentifiant);
  }
  
  public String getCodeEtat()
  {
    return m_fluxCAFInfra.get_C_ETAT();
  }
  
  public void setCodeEtat(String pCode)
  {
    m_fluxCAFInfra.set_C_ETAT(pCode);
  }
  
  public String getTypeEnregistrement()
  {
    return m_fluxCAFInfra.getTypeEnregistrement();
  }
  
  public String getCodeErreurTypeEnregistrement()
  {
    return m_fluxCAFInfra.getTypeEnregistrement_C_ERR();
  }
  
  public void setTypeEnregistrement(String pValeur)
  {
    m_fluxCAFInfra.setTypeEnregistrement(pValeur);
  }
  
  public void setCodeErreurTypeEnregistrement(String pCodeErreur)
  {
    m_fluxCAFInfra.setTypeEnregistrement_C_ERR(pCodeErreur);
  }
  
  public String getCodeCAF()
  {
    return m_fluxCAFInfra.getCodeCAF();
  }
  
  public String getCodeErreurCodeCAF()
  {
    return m_fluxCAFInfra.getCodeCAF_C_ERR();
  }
  
  public void setCodeCAF(String pValeur)
  {
    m_fluxCAFInfra.setCodeCAF(pValeur);
  }
  
  public void setCodeErreurCodeCAF(String pCodeErreur)
  {
    m_fluxCAFInfra.setCodeCAF_C_ERR(pCodeErreur);
  }
  
  public String getNumeroAllocataire()
  {
    return m_fluxCAFInfra.getNumeroAllocataire();
  }
  
  public String getCodeErreurNumeroAllocataire()
  {
    return m_fluxCAFInfra.getNumeroAllocataire_C_ERR();
  }
  
  public void setNumeroAllocataire(String pValeur)
  {
    m_fluxCAFInfra.setNumeroAllocataire(pValeur);
  }
  
  public void setCodeErreurNumeroAllocataire(String pCodeErreur)
  {
    m_fluxCAFInfra.setNumeroAllocataire_C_ERR(pCodeErreur);
  }
  
  public String getNIR()
  {
    return m_fluxCAFInfra.getNIR();
  }
  
  public String getCodeErreurNIR()
  {
    return m_fluxCAFInfra.getNIR_C_ERR();
  }
  
  public void setNIR(String pValeur)
  {
    m_fluxCAFInfra.setNIR(pValeur);
  }
  
  public void setCodeErreurNIR(String pCodeErreur)
  {
    m_fluxCAFInfra.setNIR_C_ERR(pCodeErreur);
  }
  
  public String getIdentifiantDemandeurCAF()
  {
    return m_fluxCAFInfra.getIdentifiantDemandeurCAF();
  }
  
  public String getCodeErreurIdentifiantDemandeurCAF()
  {
    return m_fluxCAFInfra.getIdentifiantDemandeurCAF_C_ERR();
  }
  
  public void setIdentifiantDemandeurCAF(String pValeur)
  {
    m_fluxCAFInfra.setIdentifiantDemandeurCAF(pValeur);
  }
  
  public void setCodeErreurIdentifiantDemandeurCAF(String pCodeErreur)
  {
    m_fluxCAFInfra.setIdentifiantDemandeurCAF_C_ERR(pCodeErreur);
  }
  
  public String getNomPatronymique()
  {
    return m_fluxCAFInfra.getNomPatronymique();
  }
  
  public String getCodeErreurNomPatronymique()
  {
    return m_fluxCAFInfra.getNomPatronymique_C_ERR();
  }
  
  public void setNomPatronymique(String pValeur)
  {
    m_fluxCAFInfra.setNomPatronymique(pValeur);
  }
  
  public void setCodeErreurNomPatronymique(String pCodeErreur)
  {
    m_fluxCAFInfra.setNomPatronymique_C_ERR(pCodeErreur);
  }
  
  public String getPrenom()
  {
    return m_fluxCAFInfra.getPrenom();
  }
  
  public String getCodeErreurPrenom()
  {
    return m_fluxCAFInfra.getPrenom_C_ERR();
  }
  
  public void setPrenom(String pValeur)
  {
    m_fluxCAFInfra.setPrenom(pValeur);
  }
  
  public void setCodeErreurPrenom(String pCodeErreur)
  {
    m_fluxCAFInfra.setPrenom_C_ERR(pCodeErreur);
  }
  
  public String getCodePopulation()
  {
    return m_fluxCAFInfra.getCodePopulation();
  }
  
  public String getCodeErreurCodePopulation()
  {
    return m_fluxCAFInfra.getCodePopulation_C_ERR();
  }
  
  public void setCodePopulation(String pValeur)
  {
    m_fluxCAFInfra.setCodePopulation(pValeur);
  }
  
  public void setCodeErreurCodePopulation(String pCodeErreur)
  {
    m_fluxCAFInfra.setCodePopulation_C_ERR(pCodeErreur);
  }
  
  public String getNumeroInseeCommune()
  {
    return m_fluxCAFInfra.getNumeroInseeCommune();
  }
  
  public String getCodeErreurNumeroInseeCommune()
  {
    return m_fluxCAFInfra.getNumeroInseeCommune_C_ERR();
  }
  
  public void setNumeroInseeCommune(String pValeur)
  {
    m_fluxCAFInfra.setNumeroInseeCommune(pValeur);
  }
  
  public void setCodeErreurNumeroInseeCommune(String pCodeErreur)
  {
    m_fluxCAFInfra.setNumeroInseeCommune_C_ERR(pCodeErreur);
  }
  
  public String getNumeroIdentification()
  {
    return m_fluxCAFInfra.getNumeroIdentification();
  }
  
  public String getCodeErreurNumeroIdentification()
  {
    return m_fluxCAFInfra.getNumeroIdentification_C_ERR();
  }
  
  public void setNumeroIdentification(String pValeur)
  {
    m_fluxCAFInfra.setNumeroIdentification(pValeur);
  }
  
  public void setCodeErreurNumeroIdentification(String pCodeErreur)
  {
    m_fluxCAFInfra.setNumeroIdentification_C_ERR(pCodeErreur);
  }
  
  public String getCodeStatut()
  {
    return m_fluxCAFInfra.getCodeStatut();
  }
  
  public String getCodeErreurCodeStatut()
  {
    return m_fluxCAFInfra.getCodeStatut_C_ERR();
  }
  
  public void setCodeStatut(String pValeur)
  {
    m_fluxCAFInfra.setCodeStatut(pValeur);
  }
  
  public void setCodeErreurCodeStatut(String pCodeErreur)
  {
    m_fluxCAFInfra.setCodeStatut_C_ERR(pCodeErreur);
  }
  
  public String getIdentifiantIndividuRNA()
  {
    return m_fluxCAFInfra.getIdentifiantIndividuRNA();
  }
  
  public String getCodeErreurIdentifiantIndividuRNA()
  {
    return m_fluxCAFInfra.getIdentifiantIndividuRNA_C_ERR();
  }
  
  public void setIdentifiantIndividuRNA(String pValeur)
  {
    m_fluxCAFInfra.setIdentifiantIndividuRNA(pValeur);
  }
  
  public void setCodeErreurIdentifiantIndividuRNA(String pCodeErreur)
  {
    m_fluxCAFInfra.setIdentifiantIndividuRNA_C_ERR(pCodeErreur);
  }
  
  public String getNomMarital()
  {
    return m_fluxCAFInfra.getNomMarital();
  }
  
  public String getCodeErreurNomMarital()
  {
    return m_fluxCAFInfra.getNomMarital_C_ERR();
  }
  
  public void setNomMarital(String pValeur)
  {
    m_fluxCAFInfra.setNomMarital(pValeur);
  }
  
  public void setCodeErreurNomMarital(String pCodeErreur)
  {
    m_fluxCAFInfra.setNomMarital_C_ERR(pCodeErreur);
  }
  
  public String getCodeAnteriorite()
  {
    return m_fluxCAFInfra.getCodeAnteriorite();
  }
  
  public String getCodeErreurCodeAnteriorite()
  {
    return m_fluxCAFInfra.getCodeAnteriorite_C_ERR();
  }
  
  public void setCodeAnteriorite(String pValeur)
  {
    m_fluxCAFInfra.setCodeAnteriorite(pValeur);
  }
  
  public void setCodeErreurCodeAnteriorite(String pCodeErreur)
  {
    m_fluxCAFInfra.setCodeAnteriorite_C_ERR(pCodeErreur);
  }
  
  public String getZoneInfos()
  {
    return m_fluxCAFInfra.getZoneInfos();
  }
  
  public String getCodeErreurZoneInfos()
  {
    return m_fluxCAFInfra.getZoneInfos_C_ERR();
  }
  
  public void setZoneInfos(String pValeur)
  {
    m_fluxCAFInfra.setZoneInfos(pValeur);
  }
  
  public void setCodeErreurZoneInfos(String pCodeErreur)
  {
    m_fluxCAFInfra.setZoneInfos_C_ERR(pCodeErreur);
  }
  
  public String getMoisEntree()
  {
    return m_fluxCAFInfra.getMoisEntree();
  }
  
  public String getCodeErreurMoisEntree()
  {
    return m_fluxCAFInfra.getMoisEntree_C_ERR();
  }
  
  public void setMoisEntree(String pValeur)
  {
    m_fluxCAFInfra.setMoisEntree(pValeur);
  }
  
  public void setCodeErreurMoisEntree(String pCodeErreur)
  {
    m_fluxCAFInfra.setMoisEntree_C_ERR(pCodeErreur);
  }
  
  public String getMoisSortie()
  {
    return m_fluxCAFInfra.getMoisSortie();
  }
  
  public String getCodeErreurMoisSortie()
  {
    return m_fluxCAFInfra.getMoisSortie_C_ERR();
  }
  
  public void setMoisSortie(String pValeur)
  {
    m_fluxCAFInfra.setMoisSortie(pValeur);
  }
  
  public void setCodeErreurMoisSortie(String pCodeErreur)
  {
    m_fluxCAFInfra.setMoisSortie_C_ERR(pCodeErreur);
  }
  
  public Damj getDateNaissance()
  {
    return m_fluxCAFInfra.getDateNaissance();
  }
  
  public String getCodeErreurDateNaissance()
  {
    return m_fluxCAFInfra.getDateNaissance_C_ERR();
  }
  
  public void setDateNaissance(Damj pValeur)
  {
    m_fluxCAFInfra.setDateNaissance(pValeur);
  }
  
  public void setCodeErreurDateNaissance(String pCodeErreur)
  {
    m_fluxCAFInfra.setDateNaissance_C_ERR(pCodeErreur);
  }
  
  public Damj getDateFichierExterne()
  {
    return m_fluxCAFInfra.getDateFichierExterne();
  }
  
  public String getCodeErreurDateFichierExterne()
  {
    return m_fluxCAFInfra.getDateFichierExterne_C_ERR();
  }
  
  public void setDateFichierExterne(Damj pValeur)
  {
    m_fluxCAFInfra.setDateFichierExterne(pValeur);
  }
  
  public void setCodeErreurDateFichierExterne(String pCodeErreur)
  {
    m_fluxCAFInfra.setDateFichierExterne_C_ERR(pCodeErreur);
  }
  
  public _FluxCAF getFluxCAFInfra()
  {
    return m_fluxCAFInfra;
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
    if ((getCodeErreurCodeCAF() != null) && 
      ("".equals(getCodeErreurCodeCAF()))) {
      return true;
    }
    if ((getCodeErreurNumeroAllocataire() != null) && 
      ("".equals(getCodeErreurNumeroAllocataire()))) {
      return true;
    }
    if ((getCodeErreurNIR() != null) && 
      ("".equals(getCodeErreurNIR()))) {
      return true;
    }
    if ((getCodeErreurIdentifiantDemandeurCAF() != null) && 
      ("".equals(getCodeErreurIdentifiantDemandeurCAF()))) {
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
    if ((getCodeErreurNumeroInseeCommune() != null) && 
      ("".equals(getCodeErreurNumeroInseeCommune()))) {
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
    if ((getCodeErreurIdentifiantIndividuRNA() != null) && 
      ("".equals(getCodeErreurIdentifiantIndividuRNA()))) {
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
    if ((getCodeErreurMoisEntree() != null) && 
      ("".equals(getCodeErreurMoisEntree()))) {
      return true;
    }
    if ((getCodeErreurMoisSortie() != null) && 
      ("".equals(getCodeErreurMoisSortie()))) {
      return true;
    }
    if ((getCodeErreurDateNaissance() != null) && 
      ("".equals(getCodeErreurDateNaissance()))) {
      return true;
    }
    if ((getCodeErreurDateFichierExterne() != null) && 
      ("".equals(getCodeErreurDateFichierExterne()))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     _FluxCAFImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */