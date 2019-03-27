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

public abstract class ProduitAriAbstrait
  extends ProduitAbstrait
  implements ProduitAriSpec
{
  private static final long serialVersionUID = 1L;
  
  public void controlerContexteDonneesForcees(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAriDelegue() != null) {
      getProduitAriDelegue().controlerContexteDonneesForcees(contexte);
    }
  }
  
  public boolean proposerNotification()
  {
    if (getProduitAriDelegue() == null) {
      return false;
    }
    return getProduitAriDelegue().proposerNotification();
  }
  
  public boolean estProduitCandidatPourDemande(DemandeSpec demande)
  {
    if (getProduitAriDelegue() == null) {
      return false;
    }
    return getProduitAriDelegue().estProduitCandidatPourDemande(demande);
  }
  
  public Resultat determinerConstituantsSupplementaires(Contexte contexte)
    throws ApplicativeException
  {
    if (getProduitAriDelegue() == null) {
      return null;
    }
    return getProduitAriDelegue().determinerConstituantsSupplementaires(contexte);
  }
  
  public String determinerPeriodeGaecAChargerSurLectureDecision(DemandeSpec demandeDecisionne)
  {
    if (getProduitAriDelegue() == null) {
      return null;
    }
    return getProduitAriDelegue().determinerPeriodeGaecAChargerSurLectureDecision(demandeDecisionne);
  }
  
  public void controlerDonneesForceesAri(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    if (getProduitAriDelegue() != null) {
      getProduitAriDelegue().controlerDonneesForceesAri(demande);
    }
  }
  
  public AttributionSpec creerAttributionProduit(DemandeSpec demande)
  {
    if (getProduitAriDelegue() == null) {
      return null;
    }
    return getProduitAriDelegue().creerAttributionProduit(demande);
  }
  
  private ProduitAriDelegueSpec getProduitAriDelegue()
  {
    return (ProduitAriDelegueSpec)getProduitDelegue();
  }
  
  public FormuleMontantSpec getFormuleMontant(String code)
  {
    return getProduitAriDelegue().getFormuleMontant(code);
  }
  
  public Hashtable getElementsDonneesImposeesVides()
    throws CoucheLogiqueException
  {
    return getProduitAriDelegue().getElementsDonneesImposeesVides();
  }
  
  public Hashtable recupererDonneesImposees(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    return getProduitAriDelegue().recupererDonneesImposees(demande);
  }
  
  public void leverAlertesNonBloquantes(DemandeSpec demande)
    throws ApplicativeException
  {
    getProduitAriDelegue().leverAlertesNonBloquantes(demande);
  }
  
  public boolean besoinDifferenceSystematique()
  {
    return getProduitAriDelegue().besoinDifferenceSystematique();
  }
  
  public String determinerCodeSousProduitPourSigma(AttributionSpec attribution)
  {
    if (getProduitAriDelegue() == null) {
      return null;
    }
    return getProduitAriDelegue().determinerCodeSousProduitPourSigma(attribution);
  }
  
  public MontantBaseSpec recupererMontant(DonneesEntreesRecuperationMontant donneeEntreeRecuperationMontant)
    throws ApplicativeException
  {
    return getProduitAriDelegue().recupererMontant(donneeEntreeRecuperationMontant);
  }
}

/* Location:
 * Qualified Name:     ProduitAriAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */