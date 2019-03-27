package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeriodeProduitsConstants
{
  private List m_listeProduits;
  private Periode m_periodeValidite;
  private String m_idDecor;
  
  public PeriodeProduitsConstants(Periode p_periodeValidite, String p_idDecor)
  {
    m_periodeValidite = p_periodeValidite;
    m_idDecor = p_idDecor;
    m_listeProduits = new ArrayList();
  }
  
  public void ajouterProduit(ProduitSpec p_produit)
  {
    if (p_produit != null) {
      getListeProduits().add(p_produit);
    }
  }
  
  public void supprimerProduit(ProduitSpec p_produit)
  {
    if (p_produit != null) {
      getListeProduits().remove(p_produit);
    }
  }
  
  public void setListeProduits(List p_listeProduits)
  {
    for (Iterator iter = getListeProduits().iterator(); iter.hasNext();)
    {
      ProduitSpec produit = (ProduitSpec)iter.next();
      iter.remove();
    }
    Iterator iter;
    if (p_listeProduits != null) {
      for (iter = p_listeProduits.iterator(); iter.hasNext();) {
        ajouterProduit((ProduitSpec)iter.next());
      }
    }
  }
  
  public List getReglements()
  {
    List listeReglements = new ArrayList();
    ProduitSpec produit = null;
    for (Iterator listeProduits = getListeProduits().iterator(); listeProduits.hasNext();)
    {
      produit = (ProduitSpec)listeProduits.next();
      for (reglementsProduits = produit.getListeReglements().iterator(); reglementsProduits.hasNext();) {
        listeReglements.add(reglementsProduits.next());
      }
    }
    Iterator reglementsProduits;
    return listeReglements;
  }
  
  public String getIdDecor()
  {
    return m_idDecor;
  }
  
  public Periode getPeriodeValidite()
  {
    return m_periodeValidite;
  }
  
  public List getListeProduits()
  {
    return m_listeProduits;
  }
  
  public ProduitSpec getProduitParDefaut()
  {
    Iterator listeProduits = getListeProduits().iterator();
    while (listeProduits.hasNext())
    {
      ProduitSpec produit = (ProduitSpec)listeProduits.next();
      if (Parametres.isProduitParDefaut(produit.getNomUnique())) {
        return produit;
      }
    }
    return null;
  }
  
  public ProduitSpec determinerProduitEffectifDeLaLigne(LigneSpec p_ligneProduitRecherche)
  {
    ProduitSpec produitRetourne = null;
    
    ProduitSpec produitCourant = null;
    for (Iterator listeProduits = getListeProduits().iterator(); listeProduits.hasNext();)
    {
      produitCourant = (ProduitSpec)listeProduits.next();
      if (produitCourant.getLigne().equals(p_ligneProduitRecherche)) {
        produitRetourne = produitCourant;
      }
    }
    return produitRetourne;
  }
  
  public boolean equals(Object p_obj)
  {
    boolean isEquals = false;
    if ((p_obj instanceof PeriodeProduitsConstants)) {
      isEquals = getIdDecor().equals(((PeriodeProduitsConstants)p_obj).getIdDecor());
    }
    return isEquals;
  }
}

/* Location:
 * Qualified Name:     PeriodeProduitsConstants
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */