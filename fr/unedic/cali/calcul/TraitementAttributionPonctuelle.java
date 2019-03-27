package fr.unedic.cali.calcul;

import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.EvenementPaiementProduitPonctuel;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.services.CoucheLogiqueException;

public class TraitementAttributionPonctuelle
{
  public static EvenementPaiementProduitPonctuel executerAttribution(AttributionSpec p_attribution, FacadeCalculProduitPonctuelSpec p_facadeCalculProduit, ConstituantsIndemnisation p_constituantsIndemnisation)
    throws CoucheLogiqueException
  {
    EvenementPaiementProduitPonctuel evenementPaiementProduitPonctuel = null;
    
    ConstituantsIndemnisation constituantsIndemnisation = null;
    
    constituantsIndemnisation = (ConstituantsIndemnisation)p_constituantsIndemnisation.copie();
    
    evenementPaiementProduitPonctuel = new EvenementPaiementProduitPonctuel(p_attribution.getDateEffet(), p_facadeCalculProduit.calculMontant(p_attribution.getFormuleMontant(constituantsIndemnisation.getCodeFormuleMontant()), p_constituantsIndemnisation, p_attribution.getDateEffet()));
    
    return evenementPaiementProduitPonctuel;
  }
}

/* Location:
 * Qualified Name:     TraitementAttributionPonctuelle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */