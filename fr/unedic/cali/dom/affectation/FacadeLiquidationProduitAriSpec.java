package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.FormuleMontantSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.dom.conteneurs.DonneesEntreesRecuperationMontant;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import java.util.Hashtable;

public abstract interface FacadeLiquidationProduitAriSpec
  extends FacadeLiquidationProduitSpec
{
  public abstract void controlerContexteDonneesForcees(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract boolean proposerNotification();
  
  public abstract boolean estProduitCandidatPourDemande(DemandeSpec paramDemandeSpec);
  
  public abstract Resultat determinerConstituantsSupplementaires(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract void controlerDonneesForceesAri(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract AttributionSpec creerAttributionProduit(DemandeSpec paramDemandeSpec);
  
  public abstract FormuleMontantSpec getFormuleMontant(String paramString);
  
  public abstract Hashtable recupererDonneesImposees(DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  public abstract Hashtable getElementsDonneesImposeesVides()
    throws CoucheLogiqueException;
  
  public abstract void leverAlertesNonBloquantes(DemandeSpec paramDemandeSpec)
    throws ApplicativeException;
  
  public abstract boolean besoinDifferenceSystematique();
  
  public abstract String determinerCodeSousProduitPourSigma(AttributionSpec paramAttributionSpec);
  
  public abstract MontantBaseSpec recupererMontant(DonneesEntreesRecuperationMontant paramDonneesEntreesRecuperationMontant)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     FacadeLiquidationProduitAriSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */