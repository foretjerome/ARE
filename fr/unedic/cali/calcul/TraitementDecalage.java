package fr.unedic.cali.calcul;

import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ElementBaseIndemnisationSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.dom.QuantiteIndemnisationSpec;
import fr.unedic.cali.dom.SalaireJournalierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import java.math.BigDecimal;

public class TraitementDecalage
{
  public static Quantite imputationDecalageSurUnePa(Quantite p_creditDecalage, PeriodeAnalyseSpec p_pa)
    throws CoucheLogiqueException
  {
    Quantite quantiteAImputer = null;
    Quantite nombreDeJourDeDecalageImputes = null;
    
    quantiteAImputer = p_pa.getQuantiteIndemnisable().soustraire(p_pa.getQuantiteNonIndemnisee());
    
    nombreDeJourDeDecalageImputes = quantiteAImputer.min(p_creditDecalage);
    
    p_pa.setQuantiteNonIndemnisee(p_pa.getQuantiteNonIndemnisee().ajouter(nombreDeJourDeDecalageImputes));
    
    return nombreDeJourDeDecalageImputes;
  }
  
  public static Quantite traitementActiviteReduiteSurPa(PeriodeAnalyseSpec p_pa, FacadeCalculProduitPeriodiqueSpec p_facadeCalculProduit, UniteTraitement p_ut, AttributionSpec p_attribution, ConstituantsIndemnisation p_constituantsIndemnisation)
    throws CoucheLogiqueException
  {
    QuantiteIndemnisationSpec quantiteIndemnisation = null;
    String codeFormuleMontant = null;
    quantiteIndemnisation = OutillageQuantites.recupererPremiereQuantiteIndemnisationActive(p_constituantsIndemnisation.getCollectionQuantiteDroit());
    if (quantiteIndemnisation == null) {
      codeFormuleMontant = p_constituantsIndemnisation.getCodeFormuleMontant();
    } else {
      codeFormuleMontant = quantiteIndemnisation.getCodeFormuleMontant();
    }
    MontantBaseSpec montant = p_facadeCalculProduit.calculMontant(p_attribution.getFormuleMontant(codeFormuleMontant), p_constituantsIndemnisation, p_pa.getDateDebut());
    
    BigDecimal sjr = null;
    if ((p_constituantsIndemnisation.getElementBaseIndemnisationCourant() != null) && (p_constituantsIndemnisation.getElementBaseIndemnisationCourant().getSalaireJournalier() != null)) {
      sjr = p_constituantsIndemnisation.getElementBaseIndemnisationCourant().getSalaireJournalier().getSalaire();
    }
    if ((montant != null) && (new BigDecimal("0").compareTo(montant.getMontantBrut().getValeur()) < 0)) {
      p_facadeCalculProduit.traitementActiviteReduiteSurPa(p_pa, p_ut, p_attribution, montant, sjr);
    }
    return p_pa.getQuantiteDecalee() == null ? new Quantite(new BigDecimal(0), p_ut.getUniteParDefautQuantites()) : p_pa.getQuantiteDecalee();
  }
}

/* Location:
 * Qualified Name:     TraitementDecalage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */