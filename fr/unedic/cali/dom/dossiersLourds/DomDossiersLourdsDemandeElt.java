package fr.unedic.cali.dom.dossiersLourds;

import fr.unedic.util.services.Dom;

public class DomDossiersLourdsDemandeElt
  implements Dom
{
  private String m_demande;
  private String m_gamme;
  private String m_produit;
  private String m_identifiant;
  private String m_referenceExterne;
  
  public String getDemande()
  {
    return m_demande;
  }
  
  public void setDemande(String p_demande)
  {
    m_demande = p_demande;
  }
  
  public String getGamme()
  {
    return m_gamme;
  }
  
  public void setGamme(String p_gamme)
  {
    m_gamme = p_gamme;
  }
  
  public String getProduit()
  {
    return m_produit;
  }
  
  public void setProduit(String p_produit)
  {
    m_produit = p_produit;
  }
  
  public String getIdentifiant()
  {
    return m_identifiant;
  }
  
  public void setIdentifiant(String p_identifiant)
  {
    m_identifiant = p_identifiant;
  }
  
  public String getReferenceExterne()
  {
    return m_referenceExterne;
  }
  
  public void setReferenceExterne(String p_referenceExterne)
  {
    m_referenceExterne = p_referenceExterne;
  }
}

/* Location:
 * Qualified Name:     DomDossiersLourdsDemandeElt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */