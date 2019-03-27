package fr.unedic.cali.calcul.prime;

import fr.unedic.cali.calcul.dom.EvenementPaiementProduitPonctuel;
import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.pbjc.dom.PrimePbjcNcp;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.services.CoucheLogiqueException;

public abstract interface FacadePrimeProduitSpec
{
  public abstract PrimePbjcNcp creerPrimeNcp(UniteTraitement paramUniteTraitement, Somme paramSomme, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract PrimePbjcNcp creerPrimeProduitPonctuelNcp(EvenementPaiementProduitPonctuel paramEvenementPaiementProduitPonctuel, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract PrimePbjcNcp creerPrimeFiancementNcp(UniteTraitement paramUniteTraitement, Somme paramSomme, AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     FacadePrimeProduitSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */