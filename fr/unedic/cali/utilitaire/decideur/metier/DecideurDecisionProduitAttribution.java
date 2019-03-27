package fr.unedic.cali.utilitaire.decideur.metier;

import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.ElementComparaisonReexamen;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DecideurDecisionProduitAttribution
  implements DecideurDecisionSpec
{
  private final transient List<String> produitsAvant;
  private final transient List<String> produitsApres;
  
  public DecideurDecisionProduitAttribution(List<ProduitSpec> produitsAvant, List<ProduitSpec> produitsApres)
  {
    this.produitsAvant = new ArrayList();
    this.produitsApres = new ArrayList();
    
    alimenter(this.produitsAvant, produitsAvant);
    alimenter(this.produitsApres, produitsApres);
  }
  
  private void alimenter(List<String> libelles, List<ProduitSpec> natures)
  {
    if ((natures != null) && (!natures.isEmpty()))
    {
      Iterator<ProduitSpec> iterator = natures.iterator();
      while (iterator.hasNext())
      {
        ProduitSpec produit = (ProduitSpec)iterator.next();
        libelles.add(produit.getLibelleLong());
      }
    }
  }
  
  public boolean decisionsIdentiques(DemandeSpec demandeAvant, DemandeSpec demandeApres, List eltsComparaison, ComportementSpec comportement)
  {
    boolean retour = false;
    if ((eltsComparaison != null) && (!eltsComparaison.isEmpty()))
    {
      Iterator iterator = eltsComparaison.iterator();
      retour = true;
      while (iterator.hasNext())
      {
        ElementComparaisonReexamen eltComparaison = (ElementComparaisonReexamen)iterator.next();
        if (!accepterChangement(eltComparaison)) {
          retour = false;
        }
      }
    }
    if (retour) {
      comportement.setUtilise(true);
    }
    return retour;
  }
  
  private boolean accepterChangement(ElementComparaisonReexamen eltComparaison)
  {
    boolean retour = false;
    if ("Produit Proposé".equals(eltComparaison.getLibelleElement()))
    {
      String valeurAvant = (String)eltComparaison.getValeurAvantReexamen();
      String valeurApres = (String)eltComparaison.getValeurApresReexamen();
      if ((valeurAvant != null) && (valeurApres != null) && (produitsAvant.contains(valeurAvant)) && (produitsApres.contains(valeurApres))) {
        retour = true;
      }
    }
    return retour;
  }
  
  public String getLibelle()
  {
    return "La décisions sont identiques si on passe d'un produit A à un produit B";
  }
  
  public List getListeDecideursAppliques()
  {
    return null;
  }
  
  public boolean ignorerElementComparaison(DemandeSpec demandeAvant, DemandeSpec demandeApres, ElementComparaisonReexamen elementComparaison)
  {
    return accepterChangement(elementComparaison);
  }
}

/* Location:
 * Qualified Name:     DecideurDecisionProduitAttribution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */