package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class LigneAbstrait
  implements LigneSpec
{
  private GammeSpec m_gamme = null;
  private ArrayList m_listeProduits = new ArrayList();
  private String m_libelle;
  private String m_nomUnique;
  
  public GammeSpec getGamme()
  {
    return m_gamme;
  }
  
  public List getListeProduits()
  {
    return m_listeProduits;
  }
  
  public void setGamme(GammeSpec p_gamme)
  {
    m_gamme = p_gamme;
  }
  
  public void ajouterProduit(ProduitSpec p_produit)
  {
    if (p_produit != null)
    {
      getListeProduits().add(p_produit);
      if (p_produit.getLigne() != this) {
        p_produit.setLigne(this);
      }
    }
  }
  
  public void setListeProduits(List p_listeProduits)
  {
    if (p_listeProduits == null) {
      m_listeProduits = null;
    } else {
      for (int i = 0; i < p_listeProduits.size(); i++) {
        ajouterProduit((ProduitSpec)p_listeProduits.get(i));
      }
    }
  }
  
  public ProduitSpec getProduitActif(Damj p_date)
  {
    for (Iterator listeProduits = getListeProduits().iterator(); listeProduits.hasNext();)
    {
      ProduitSpec produit = (ProduitSpec)listeProduits.next();
      if (produit.estActif(p_date)) {
        return produit;
      }
    }
    return null;
  }
  
  public String getLibelle()
  {
    return m_libelle;
  }
  
  public void setLibelle(String p_libelle)
  {
    m_libelle = p_libelle;
  }
  
  public String getNomUnique()
  {
    return m_nomUnique;
  }
  
  public void setNomUnique(String p_nomUnique)
  {
    m_nomUnique = p_nomUnique;
  }
  
  public String toString()
  {
    return getNomUnique();
  }
}

/* Location:
 * Qualified Name:     LigneAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */