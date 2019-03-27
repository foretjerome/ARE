package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.ElementBaseIndemnisationSpec;
import fr.unedic.cali.dom.FormuleMontantSpec;
import fr.unedic.cali.dom.RejetSpec;
import fr.unedic.cali.parcours.ParcoursCali;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;

public abstract class ProduitForAbstrait
  extends ProduitAbstrait
  implements ProduitForSpec
{
  private ProduitForDelegueSpec getProduitForDelegue()
  {
    return (ProduitForDelegueSpec)getProduitDelegue();
  }
  
  public Resultat traiterObjectifAdmission(Contexte p_contexte)
    throws ApplicativeException
  {
    if (getProduitForDelegue() == null) {
      return null;
    }
    return getProduitForDelegue().traiterObjectifAdmission(p_contexte);
  }
  
  public Resultat classerDemande(Contexte p_contexte)
    throws ApplicativeException
  {
    if (getProduitForDelegue() == null) {
      return null;
    }
    return getProduitForDelegue().classerDemande(p_contexte);
  }
  
  public void initialiserDossierExamen(DossierAffectationSpec p_dossierAffecte)
  {
    if (getProduitForDelegue() != null) {
      getProduitForDelegue().initialiserDossierExamen(p_dossierAffecte);
    }
  }
  
  public int determinerCodeMotifRejetPrincipal(RejetSpec p_rejet)
  {
    return getProduitForDelegue().determinerCodeMotifRejetPrincipal(p_rejet);
  }
  
  public FormuleMontantSpec getFormuleMontant(String p_code)
  {
    return getProduitForDelegue().getFormuleMontant(p_code);
  }
  
  public void controlerContexteDonneesForcees(Contexte p_contexte)
    throws ContexteException, ApplicativeException
  {
    getProduitForDelegue().controlerContexteDonneesForcees(p_contexte);
  }
  
  public void alimenterDonneesComplementairesDossierExamen(DossierExamenSpec p_dossierExamenDecisionne)
  {
    if (getProduitForDelegue() != null) {
      getProduitForDelegue().alimenterDonneesComplementairesDossierExamen(p_dossierExamenDecisionne);
    }
  }
  
  public String determinerPeriodeGaecAChargerSurLectureDecision(DemandeSpec p_demandeDecisionne)
  {
    if (getProduitForDelegue() == null) {
      return null;
    }
    return getProduitForDelegue().determinerPeriodeGaecAChargerSurLectureDecision(p_demandeDecisionne);
  }
  
  public void traiterOccasionnelDossierLourds(DossierExamenSpec p_dossierExamenDecisionne)
  {
    if (getProduitForDelegue() != null) {
      getProduitForDelegue().traiterOccasionnelDossierLourds(p_dossierExamenDecisionne);
    }
  }
  
  public ElementBaseIndemnisationSpec getElementBaseIndemnisation(AttributionSpec p_attribution)
    throws CoucheLogiqueException
  {
    if (getProduitForDelegue() == null) {
      return null;
    }
    return getProduitForDelegue().getElementBaseIndemnisation(p_attribution);
  }
  
  public boolean estDemandeALiquider(Contexte p_contexte)
    throws ApplicativeException
  {
    return getProduitForDelegue().estDemandeALiquider(p_contexte);
  }
  
  public void traiterEnveloppe(Resultat p_resultat, Contexte p_contexte)
    throws CoucheLogiqueException
  {
    getProduitForDelegue().traiterEnveloppe(p_resultat, p_contexte);
  }
  
  public void verifierPreconditions(DemandeSpec p_demande)
    throws CoucheLogiqueException
  {
    getProduitForDelegue().verifierPreconditions(p_demande);
  }
  
  public ParcoursCali recupererParcoursConstitutionMontantBrut()
    throws CoucheLogiqueException
  {
    return getProduitForDelegue().recupererParcoursConstitutionMontantBrut();
  }
  
  public void mettreEnReexamen(DemandeSpec p_demande)
    throws CoucheLogiqueException
  {
    getProduitForDelegue().mettreEnReexamen(p_demande);
  }
  
  public String determinerCodeSousProduitPourSigma(Damj p_dateDebutFormation, Damj p_dateValidationFormation)
  {
    return getProduitForDelegue().determinerCodeSousProduitPourSigma(p_dateDebutFormation, p_dateValidationFormation);
  }
}

/* Location:
 * Qualified Name:     ProduitForAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */