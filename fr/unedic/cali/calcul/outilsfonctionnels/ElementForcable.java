package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.lang.builder.HashCodeBuilder;

public final class ElementForcable
{
  public static final String DECALAGE_FORCE = "DECALAGE_FORCE";
  public static final String DECALAGE_CALCULE = "DECALAGE_CALCULE";
  public static final String DECALAGE_SANCTION_FORCE = "DECALAGE_SANCTION_FORCE";
  public static final String DECALAGE_SANCTION_CALCULE = "DECALAGE_SANCTION_CALCULE";
  public static final String STATUT_UT_FORCE = "STATUT_UT_FORCE";
  public static final String CUMUL_AR_FORCE = "CUMUL_AR_FORCE";
  public static final String NEUTRALISATION_FORCE = "NEUTRALISE_FORCE";
  public static final String TYPE_NEUTRALISATION_FORCE = "TYPE_NEUTRALISATION_FORCE";
  public static final String REPRISE_MEME_EMPLOYEUR_CALCULE = "REPRISE_MEME_EMPLOYEUR_CALCULE";
  public static final String REPRISE_MEME_EMPLOYEUR_FORCE = "REPRISE_MEME_EMPLOYEUR_FORCE";
  public static final String DEBLOCAGE_ATTEINTE_SEUIL_FORCE = "DEBLOCAGE_ATTEINTE_SEUIL_FORCE";
  public static final String DEBLOCAGE_VARIATION_REMUNERATION_FORCE = "DEBLOCAGE_VARIATION_REMUNERATION_FORCE";
  public static final String MONTANT_NET_REVENUS_ACTIVITE_REPRISE_FORCE = "MONTANT_NET_REVENUS_ACTIVITE_REPRISE_FORCE";
  public static final String DEBLOCAGE_IGNORER_AE_DV = "IGNORER_AE_DV";
  public static final String DEBLOCAGE_LEVER_BLOCAGE_MANDATEMENT = "DEBLOCAGE_LEVER_BLOCAGE_MANDATEMENT";
  private ProduitSpec produit = null;
  private String nomElementForcable;
  private static Map<String, ElementForcable> s_listeElementForcable = null;
  
  private ElementForcable(String elementForcable, ProduitSpec produit)
  {
    nomElementForcable = elementForcable;
    this.produit = produit;
  }
  
  public static ElementForcable getInstance(String nomElement, ProduitSpec produit)
  {
    if (s_listeElementForcable == null) {
      s_listeElementForcable = new Hashtable();
    }
    String clef = nomElement + "|" + produit.getNom();
    
    ElementForcable elementForcable = (ElementForcable)s_listeElementForcable.get(clef);
    if (elementForcable == null)
    {
      elementForcable = new ElementForcable(nomElement, produit);
      s_listeElementForcable.put(clef, elementForcable);
    }
    return elementForcable;
  }
  
  public static ElementForcable getInstance(String nomUnique)
  {
    StringTokenizer nom = new StringTokenizer(nomUnique, "|");
    String nomElement = nom.nextToken();
    String nomProduit = nom.nextToken();
    
    return getInstance(nomElement, Parametres.getProduit(nomProduit));
  }
  
  public ProduitSpec getProduit()
  {
    return produit;
  }
  
  public void setProduit(ProduitSpec produit)
  {
    this.produit = produit;
  }
  
  public String getNomElementForcable()
  {
    return nomElementForcable;
  }
  
  public String toString()
  {
    return getNomElementForcable() + " / " + getProduit().getNom();
  }
  
  public boolean equals(Object object)
  {
    if (!(object instanceof ElementForcable)) {
      return false;
    }
    ElementForcable aComparer = (ElementForcable)object;
    
    return (elementsForcablesEgaux(aComparer)) && ((getProduit().estIdentiqueAuProduit(aComparer.getProduit())) || (aComparer.getProduit().estIdentiqueAuProduit(getProduit())));
  }
  
  private boolean elementsForcablesEgaux(ElementForcable elementForcableAComparer)
  {
    return estNomElementIdentique(elementForcableAComparer.getNomElementForcable());
  }
  
  public boolean estNomElementIdentique(String nomElementAComparer)
  {
    return getNomElementForcable().equals(nomElementAComparer);
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder().append(getNomElementForcable()).append(getProduit().getCode()).toHashCode();
  }
  
  public void setNomReglement(String nomReglement)
  {
    nomElementForcable = nomReglement;
  }
}

/* Location:
 * Qualified Name:     ElementForcable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */