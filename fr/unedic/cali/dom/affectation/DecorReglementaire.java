package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.affectation.parametres.AccesDecorReglementaire;
import fr.unedic.cali.dom.ConteneurAccesDecorReglementaire;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class DecorReglementaire
{
  protected List listeProduits;
  protected Periode periodeValidite;
  protected Periode periodeValiditeDateExamen;
  protected String idDecor;
  
  public void ajouterProduit(ProduitSpec produit)
  {
    if (produit != null) {
      getListeProduits().add(produit);
    }
  }
  
  public void supprimerProduit(ProduitSpec produit)
  {
    if (produit != null) {
      getListeProduits().remove(produit);
    }
  }
  
  public void setListeProduits(List listeProduits)
  {
    for (Iterator iter = getListeProduits().iterator(); iter.hasNext();)
    {
      iter.next();
      iter.remove();
    }
    Iterator iter;
    if (listeProduits != null) {
      for (iter = listeProduits.iterator(); iter.hasNext();) {
        ajouterProduit((ProduitSpec)iter.next());
      }
    }
  }
  
  public List getReglements()
  {
    List listeReglements = new ArrayList();
    for (Iterator listeDeProduits = getListeProduits().iterator(); listeDeProduits.hasNext();)
    {
      ProduitSpec produit = (ProduitSpec)listeDeProduits.next();
      for (reglementsProduits = produit.getListeReglements().iterator(); reglementsProduits.hasNext();) {
        listeReglements.add(reglementsProduits.next());
      }
    }
    Iterator reglementsProduits;
    return listeReglements;
  }
  
  public String getIdDecor()
  {
    return idDecor;
  }
  
  public Periode getPeriodeValidite()
  {
    return periodeValidite;
  }
  
  public Periode getPeriodeValiditeDateExamen()
  {
    return periodeValiditeDateExamen;
  }
  
  public List getListeProduits()
  {
    return listeProduits;
  }
  
  public ProduitSpec getProduitParDefaut()
  {
    Iterator listeDeProduits = getListeProduits().iterator();
    while (listeDeProduits.hasNext())
    {
      ProduitSpec produit = (ProduitSpec)listeDeProduits.next();
      if (Parametres.isProduitParDefaut(produit.getNomUnique())) {
        return produit;
      }
    }
    return null;
  }
  
  public boolean estDecorEnCoursSelonDate(ConteneurAccesDecorReglementaire conteneur)
  {
    return getPeriodeValidite().contient(conteneur.getDateFinContrat());
  }
  
  public ProduitSpec determinerProduitEffectifDeLaLigne(LigneSpec ligneProduitRecherche)
  {
    ProduitSpec produitRetourne = null;
    for (Iterator listeDeProduits = getListeProduits().iterator(); listeDeProduits.hasNext();)
    {
      ProduitSpec produitCourant = (ProduitSpec)listeDeProduits.next();
      if (produitCourant.getLigne().equals(ligneProduitRecherche)) {
        produitRetourne = produitCourant;
      }
    }
    return produitRetourne;
  }
  
  public boolean equals(Object obj)
  {
    boolean isEquals = false;
    if ((obj instanceof DecorReglementaire)) {
      isEquals = getIdDecor().equals(((DecorReglementaire)obj).getIdDecor());
    }
    return isEquals;
  }
  
  public abstract boolean estValide(ConteneurAccesDecorReglementaire paramConteneurAccesDecorReglementaire)
    throws CoucheLogiqueException;
  
  protected abstract void leverAlertes(ConteneurAccesDecorReglementaire paramConteneurAccesDecorReglementaire)
    throws CoucheLogiqueException;
  
  protected abstract Damj getDatePivot(ConteneurAccesDecorReglementaire paramConteneurAccesDecorReglementaire)
    throws CoucheLogiqueException;
  
  protected boolean estDecorValide(ConteneurAccesDecorReglementaire conteneur)
    throws CoucheLogiqueException
  {
    if (conteneur.getDateRecherche() != null)
    {
      if (getPeriodeValidite().contient(conteneur.getDateRecherche())) {
        return true;
      }
    }
    else
    {
      leverAlertes(conteneur);
      DecorReglementaire decorEnCours = AccesDecorReglementaire.getInstance().recupererDecorReglementaireEnCoursADate(conteneur);
      if (decorEnCours != null)
      {
        Damj datePivot = decorEnCours.getDatePivot(conteneur);
        if ((datePivot != null) && (getPeriodeValidite().contient(datePivot))) {
          return true;
        }
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     DecorReglementaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */