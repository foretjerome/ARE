package fr.unedic.cali.calcul;

import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.ContexteUT;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.dom.QuantiteIndemnisationSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import java.math.BigDecimal;

public final class TraitementPlafonnement
{
  public static void determinerPlafondSurPa(PeriodeAnalyseSpec pa, UniteTraitement ut, AttributionSpec attribution, Quantite quantiteImputableSurLaPA, FacadeCalculProduitPeriodiqueSpec facadeCalculProduit, ContexteUT contexteUT, ConstituantsIndemnisation constituantsIndemnisation)
    throws CoucheLogiqueException
  {
    QuantiteIndemnisationSpec quantiteIndemnisation = OutillageQuantites.recupererPremiereQuantiteIndemnisationActive(constituantsIndemnisation.getCollectionQuantiteDroit());
    String codeFormuleMontant;
    String codeFormuleMontant;
    if (quantiteIndemnisation == null) {
      codeFormuleMontant = constituantsIndemnisation.getCodeFormuleMontant();
    } else {
      codeFormuleMontant = quantiteIndemnisation.getCodeFormuleMontant();
    }
    MontantBaseSpec montant = facadeCalculProduit.calculMontant(attribution.getFormuleMontant(codeFormuleMontant), constituantsIndemnisation, pa.getDateDebut());
    
    BigDecimal montantDisponible = facadeCalculProduit.determinerMontantRestantAvantPlafond(attribution, ut, contexteUT, constituantsIndemnisation, montant, pa);
    if (montantDisponible != null)
    {
      Quantite quantite;
      Quantite quantite;
      if ((montant.getMontantBrut() != null) && (montant.getMontantBrut().getValeurEntiere() != 0)) {
        quantite = facadeCalculProduit.determinerQuantiteAvantPlafond(montantDisponible, montant.getMontantBrut().getValeur(), pa.getUniteParDefautQuantites(), ut);
      } else {
        quantite = quantiteImputableSurLaPA;
      }
      if (quantite.compareTo(quantiteImputableSurLaPA) < 0) {
        ut.setAtteintePlafondContexteMobilite(true);
      }
      Quantite quantiteAImputerSurLaPA = quantiteImputableSurLaPA.min(quantite);
      pa.setEstUnePaAvecPlafond(true);
      Quantite quantiteRestante;
      Quantite quantiteRestante;
      if ((quantiteIndemnisation != null) && (quantiteIndemnisation.getQuantiteCourante() != null) && (quantite.getValeur().compareTo(quantiteIndemnisation.getQuantiteCourante().getValeur()) >= 0)) {
        quantiteRestante = new Quantite(quantiteImputableSurLaPA.getValeur().min(quantiteIndemnisation.getQuantiteCourante().getValeur()).subtract(quantiteAImputerSurLaPA.getValeur()).max(BigDecimal.ZERO), pa.getUniteParDefautQuantites());
      } else {
        quantiteRestante = new Quantite(quantiteImputableSurLaPA.getValeur().subtract(quantiteAImputerSurLaPA.getValeur()), pa.getUniteParDefautQuantites());
      }
      pa.setQuantitePlafonnee(quantiteRestante);
      pa.setQuantiteNonIndemnisee(pa.getQuantiteNonIndemnisee().ajouter(quantiteRestante));
    }
  }
}

/* Location:
 * Qualified Name:     TraitementPlafonnement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */