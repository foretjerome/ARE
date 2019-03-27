package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionAssuranceSpec;
import fr.unedic.cali.dom.FormulaireAbstrait;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresTraitementPopulation;
import fr.unedic.cali.occasionnel.outilsfonctionnels.FabriqueTraitementPopulationSpec;
import fr.unedic.cali.occasionnel.outilsfonctionnels.ResultatTraitementPopulation;
import fr.unedic.cali.occasionnel.outilsfonctionnels.TraitementPopulationSpec;
import fr.unedic.cali.parcours.DomLiquidationDemande;
import fr.unedic.util.services.CoucheLogiqueException;

public abstract class GammeDelegueAbstrait
  implements GammeDelegueSpec
{
  public void controlerInvestigationFrauduleuse(DomLiquidationDemande p_dom) {}
  
  protected void creerFormulaire(fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec p_demande, FormulaireAbstrait p_formulaire)
  {
    p_formulaire.setNomGamme(p_demande.getGamme());
    p_formulaire.setNomLigne(p_demande.getLigne());
    p_formulaire.setNomProduit(p_demande.getProduit());
    p_formulaire.setDateCreationDal(p_demande.getDateDemande());
    p_formulaire.setNumeroSuivi(p_demande.getNumeroSuivi());
    p_formulaire.setEstEnvoiDalEffectue(p_demande.estEnvoiDalEffectue());
  }
  
  public ResultatTraitementPopulation effectuerTraitementOccasionnel(CriteresTraitementPopulation p_criteres)
    throws ApplicativeException
  {
    TraitementPopulationSpec outil = getFabriqueTraitementPopulation().getInstance(p_criteres.getNomPopulation());
    if (outil != null) {
      return outil.effectuerTraitement(p_criteres);
    }
    return null;
  }
  
  protected abstract FabriqueTraitementPopulationSpec getFabriqueTraitementPopulation();
  
  public void controlerPresenceDemandeRevision(fr.unedic.cali.dom.DemandeSpec demande, AttributionAssuranceSpec attributionAssurancePrecedente)
    throws CoucheLogiqueException
  {}
  
  public void controlerPresenceDemandeRevisionPostLiquidation(fr.unedic.cali.dom.DemandeSpec demande, AttributionAssuranceSpec attributionAssurancePrecedente)
    throws CoucheLogiqueException
  {}
  
  public boolean controlerPrescription(FormulaireSpec formulaire)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     GammeDelegueAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */