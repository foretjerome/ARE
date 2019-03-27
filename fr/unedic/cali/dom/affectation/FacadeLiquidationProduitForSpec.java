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
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;

public abstract interface FacadeLiquidationProduitForSpec
  extends FacadeLiquidationProduitSpec
{
  public abstract void initialiserDossierExamen(DossierAffectationSpec paramDossierAffectationSpec);
  
  public abstract Resultat traiterObjectifAdmission(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract Resultat classerDemande(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract int determinerCodeMotifRejetPrincipal(RejetSpec paramRejetSpec);
  
  public abstract FormuleMontantSpec getFormuleMontant(String paramString);
  
  public abstract void alimenterDonneesComplementairesDossierExamen(DossierExamenSpec paramDossierExamenSpec);
  
  public abstract void traiterOccasionnelDossierLourds(DossierExamenSpec paramDossierExamenSpec);
  
  public abstract ElementBaseIndemnisationSpec getElementBaseIndemnisation(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract boolean estDemandeALiquider(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract void traiterEnveloppe(Resultat paramResultat, Contexte paramContexte)
    throws CoucheLogiqueException;
  
  public abstract void verifierPreconditions(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract ParcoursCali recupererParcoursConstitutionMontantBrut()
    throws CoucheLogiqueException;
  
  public abstract void mettreEnReexamen(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract String determinerCodeSousProduitPourSigma(Damj paramDamj1, Damj paramDamj2);
}

/* Location:
 * Qualified Name:     FacadeLiquidationProduitForSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */