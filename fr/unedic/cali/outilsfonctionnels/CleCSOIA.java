package fr.unedic.cali.outilsfonctionnels;

public class CleCSOIA
{
  private String m_gamme;
  private String m_ligne;
  private String m_produit;
  private String m_csoia;
  
  public CleCSOIA(String p_gamme, String p_ligne, String p_produit, String p_csoia)
  {
    setGamme(p_gamme);
    setLigne(p_ligne);
    setProduit(p_produit);
    setCsoia(p_csoia);
  }
  
  public int hashCode()
  {
    StringBuffer strCle = new StringBuffer();
    strCle.append(m_gamme);
    strCle.append(m_ligne);
    strCle.append(m_produit);
    strCle.append(m_csoia);
    
    return strCle.toString().hashCode();
  }
  
  public String getCsoia()
  {
    return m_csoia;
  }
  
  public void setCsoia(String p_csoia)
  {
    if ((p_csoia != null) && (p_csoia.equals(""))) {
      p_csoia = null;
    }
    m_csoia = p_csoia;
  }
  
  public String getGamme()
  {
    return m_gamme;
  }
  
  public void setGamme(String p_gamme)
  {
    if ((p_gamme != null) && (p_gamme.equals(""))) {
      p_gamme = null;
    }
    m_gamme = p_gamme;
  }
  
  public String getLigne()
  {
    return m_ligne;
  }
  
  public void setLigne(String p_ligne)
  {
    if ((p_ligne != null) && (p_ligne.equals(""))) {
      p_ligne = null;
    }
    m_ligne = p_ligne;
  }
  
  public String getProduit()
  {
    return m_produit;
  }
  
  public void setProduit(String p_produit)
  {
    if ((p_produit != null) && (p_produit.equals(""))) {
      p_produit = null;
    }
    m_produit = p_produit;
  }
  
  public boolean equals(Object p_object)
  {
    try
    {
      CleCSOIA cle = (CleCSOIA)p_object;
      return (equalsElement(m_gamme, cle.getGamme())) && (equalsElement(m_ligne, cle.getLigne())) && (equalsElement(m_produit, cle.getProduit())) && (equalsElement(m_csoia, cle.getCsoia()));
    }
    catch (ClassCastException ex) {}
    return false;
  }
  
  private boolean equalsElement(String p_contenu, String p_recu)
  {
    return ((p_contenu == null) && (p_recu == null)) || ((p_contenu != null) && (p_contenu.equalsIgnoreCase(p_recu)));
  }
}

/* Location:
 * Qualified Name:     CleCSOIA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */