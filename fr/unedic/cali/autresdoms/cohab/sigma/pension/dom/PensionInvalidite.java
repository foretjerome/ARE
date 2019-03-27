package fr.unedic.cali.autresdoms.cohab.sigma.pension.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec.PensionInvaliditeSpec;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;

public class PensionInvalidite
  implements PensionInvaliditeSpec
{
  Damj m_dateDebut = null;
  Damj m_dateFin = null;
  String m_codeNature = null;
  QuantiteEuro m_quantiteEuro = null;
  String m_libelleNature = null;
  String m_organismeFinanceur = null;
  String m_etat = null;
  
  public Damj getDateDebut()
  {
    return m_dateDebut;
  }
  
  public Damj getDateFin()
  {
    return m_dateFin;
  }
  
  public String getCodeNature()
  {
    return m_codeNature;
  }
  
  public QuantiteEuro getMontant()
  {
    return m_quantiteEuro;
  }
  
  public void setCodeNature(String p_nature)
  {
    m_codeNature = p_nature;
  }
  
  public void setDateDebut(Damj p_dateDebut)
  {
    m_dateDebut = p_dateDebut;
  }
  
  public void setDateFin(Damj p_dateFin)
  {
    m_dateFin = p_dateFin;
  }
  
  public void setQuantiteEuro(QuantiteEuro p_quantiteEuro)
  {
    m_quantiteEuro = p_quantiteEuro;
  }
  
  public String getLibelleNature()
  {
    return m_libelleNature;
  }
  
  public void setLibelleNature(String p_nature)
  {
    m_libelleNature = p_nature;
  }
  
  public String getOrganismeFinanceur()
  {
    return m_organismeFinanceur;
  }
  
  public void setOrganismeFinanceur(String p_organismeFinanceur)
  {
    m_organismeFinanceur = p_organismeFinanceur;
  }
  
  public String getEtat()
  {
    return m_etat;
  }
  
  public void setEtat(String p_etat)
  {
    m_etat = p_etat;
  }
}

/* Location:
 * Qualified Name:     PensionInvalidite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */