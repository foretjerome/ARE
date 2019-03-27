package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.gen.UniteTraitementForceeGen;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public abstract class UniteTraitementForcee
  extends UniteTraitementForceeGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = 1682529066579729991L;
  public static final int ETAT_NON_NEUTRALISE = 0;
  public static final int ETAT_NEUTRALISE = 1;
  
  protected UniteTraitementForcee() {}
  
  public UniteTraitementForcee(DomPCSpec pc)
  {
    super(pc);
  }
  
  public UniteTraitementForcee(Damj dateDebut, Damj dateFin)
  {
    super(dateDebut, dateFin);
  }
  
  public boolean isUTForcee()
  {
    return (isStatutForce()) || (estUtForceeContexteDivers()) || (estUtForceeContexteNeutralisation()) || (estUtForceeContexteProduit());
  }
  
  private boolean estUtForceeContexteProduit()
  {
    return (estUtForceeContexteADR()) || (estUtForceeContexteMayotte()) || (estUtForceeContexteDecalage());
  }
  
  private boolean estUtForceeContexteDivers()
  {
    return (isCommissionParitaireForcee()) || (isRepriseMemeEmployeurForcee());
  }
  
  private boolean estUtForceeContexteMayotte()
  {
    return (isEstLeverBlocageDV()) || (isEstIgnorerAEDV());
  }
  
  private boolean estUtForceeContexteADR()
  {
    return (isDeblocageSeuil()) || (isDeblocageVariationRemuneration()) || (isMontantNetActiviteReprise());
  }
  
  private boolean estUtForceeContexteDecalage()
  {
    return (isCreditDecalageForce()) || (isCreditDecalagePNDSForce());
  }
  
  private boolean estUtForceeContexteNeutralisation()
  {
    return (isEstNeutraliseForcee()) || (isTypeNeutralisationForce());
  }
  
  public void setStatut(int statut)
  {
    super.setStatut(statut);
    super.setIsStatutForce(true);
  }
  
  public boolean isStatutForce()
  {
    return super.isIsStatutForce();
  }
  
  public void annulerForcageStatut()
  {
    super.setIsStatutForce(false);
    super.setStatut(0);
  }
  
  public void setCreditDecalage(Quantite creditDecalage)
  {
    super.setCreditDecalage(creditDecalage);
    super.setIsCreditDecalageForce(true);
  }
  
  public boolean isCreditDecalageForce()
  {
    return super.isIsCreditDecalageForce();
  }
  
  public void annulerForcageCreditDecalage()
  {
    super.setIsCreditDecalageForce(false);
    super.setCreditDecalage(null);
  }
  
  public void setCommissionParitaire(int commissionParitaire)
  {
    super.setCommissionParitaire(commissionParitaire);
    super.setIsCommissionParitaireForcee(true);
  }
  
  public boolean isCommissionParitaireForcee()
  {
    return super.isIsCommissionParitaireForcee();
  }
  
  public void annulerForcageCommissionParitaire()
  {
    super.setIsCreditDecalagePNDSForce(false);
    super.setCreditDecalagePNDS(null);
  }
  
  public void setRepriseMemeEmployeur(int repriseMemeEmployeur)
  {
    super.setRepriseMemeEmployeur(repriseMemeEmployeur);
    super.setIsRepriseMemeEmployeurForcee(true);
  }
  
  public boolean isRepriseMemeEmployeurForcee()
  {
    return super.isIsRepriseMemeEmployeurForcee();
  }
  
  public void annulerRepriseMemeEmployeur()
  {
    super.setIsRepriseMemeEmployeurForcee(false);
    super.setRepriseMemeEmployeur(0);
  }
  
  public void setTypeNeutralisation(int typeNeutralisation)
  {
    super.setTypeNeutralisation(typeNeutralisation);
    super.setTypeNeutralisationForce(true);
  }
  
  public boolean isTypeNeutralisationForce()
  {
    return super.isTypeNeutralisationForce();
  }
  
  public void annulerTypeNeutralisation()
  {
    super.setTypeNeutralisationForce(false);
    super.setTypeNeutralisation(0);
  }
  
  public void setEstNeutralisee(int estNeutralisee)
  {
    super.setEstNeutralisee(estNeutralisee);
    super.setEstNeutraliseForcee(true);
  }
  
  public boolean isEstNeutraliseForcee()
  {
    return super.isEstNeutraliseForcee();
  }
  
  public void annulerEstNeutralisee()
  {
    super.setEstNeutraliseForcee(false);
    super.setEstNeutralisee(0);
  }
  
  public void setCreditDecalagePNDS(Quantite creditDecalagePNDS)
  {
    super.setCreditDecalagePNDS(creditDecalagePNDS);
    super.setIsCreditDecalagePNDSForce(true);
  }
  
  public boolean isCreditDecalagePNDSForce()
  {
    return super.isIsCreditDecalagePNDSForce();
  }
  
  public void annulerForcageCreditDecalagePNDS()
  {
    super.setIsCreditDecalagePNDSForce(false);
    super.setCreditDecalagePNDS(null);
  }
  
  public void setEstDeblocageSeuil()
  {
    super.setEstDeblocageSeuil(true);
  }
  
  public boolean isDeblocageSeuil()
  {
    return super.isEstDeblocageSeuil();
  }
  
  public void annulerEstDeblocageSeuil()
  {
    super.setEstDeblocageSeuil(false);
  }
  
  public void setEstDeblocageVariationRemuneration()
  {
    super.setEstDeblocageVariationRenumeration(true);
  }
  
  public boolean isDeblocageVariationRemuneration()
  {
    return super.isEstDeblocageVariationRenumeration();
  }
  
  public void annulerEstDeblocageVariationRemuneration()
  {
    super.setEstDeblocageVariationRenumeration(false);
  }
  
  public void annulerEstLeverBlocageAEDV()
  {
    super.setEstLeverBlocageDV(false);
  }
  
  public void annulerEstIgnorerAEDv()
  {
    super.setEstIgnorerAEDV(false);
  }
  
  public void annulerEstMotifDV()
  {
    super.setMotif(null);
  }
  
  public void setMontantNetActiviteReprise(BigDecimal montantNetRevenusActiviteReprise)
  {
    super.setMontantNetRevenusActiviteReprise(montantNetRevenusActiviteReprise);
    super.setIsMontantNetRevenusActiviteReprise(true);
  }
  
  public boolean isMontantNetActiviteReprise()
  {
    return super.isIsMontantNetRevenusActiviteReprise();
  }
  
  public void annulerMontantNetActiviteReprise()
  {
    super.setIsMontantNetRevenusActiviteReprise(false);
    super.setMontantNetRevenusActiviteReprise(null);
  }
  
  public boolean isCumulAR()
  {
    return super.isIsCumulARSurUtForce();
  }
  
  public void annulerCumulARSurUt()
  {
    super.setIsCumulARSurUtForce(false);
    super.setCumulARsurUtForce(0);
  }
  
  public void setCumulARSurUt(int cumulAR)
  {
    super.setCumulARsurUtForce(cumulAR);
    super.setIsCumulARSurUtForce(true);
  }
  
  public String toString()
  {
    StringBuffer string = new StringBuffer();
    string.append("Du " + getPeriode().getDebut() + " au " + getPeriode().getFin());
    string.append("\nStatut                : " + isStatutForce() + " - " + getStatut());
    string.append("\nCredit Decalage       : " + isCreditDecalageForce() + " - " + getCreditDecalage());
    string.append("\nCredit Decalage PNDS  : " + isCreditDecalagePNDSForce() + " - " + getCreditDecalagePNDS());
    string.append("\nCommission Paritaire  : " + isCommissionParitaireForcee() + " - " + getCommissionParitaire());
    string.append("\nReprise même employeur: " + isRepriseMemeEmployeurForcee() + " - " + getRepriseMemeEmployeur());
    string.append("\nNeutralisation        : " + isEstNeutraliseForcee() + " - " + getEstNeutralisee());
    string.append("\nType neutralisation   : " + isTypeNeutralisationForce() + " - " + getTypeNeutralisation());
    string.append("\nBlocage Variation     : " + isIsDeblocageVariationRenumeration() + " - " + isDeblocageVariationRemuneration());
    string.append("\nBlocage Seuil         : " + isIsDeblocageSeuil() + " - " + isDeblocageSeuil());
    string.append("\nMontant Net Activite Reprise : " + isIsMontantNetRevenusActiviteReprise() + " - " + getMontantNetRevenusActiviteReprise());
    
    return string.toString();
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    UniteTraitementForcee copie = (UniteTraitementForcee)pcopie;
    copie.setDateDebut(getDateDebut());
    copie.setDateFin(getDateFin());
    
    copie.setStatut(getStatut());
    copie.setIsStatutForce(isStatutForce());
    
    copie.setCreditDecalage(getCreditDecalage());
    copie.setIsCreditDecalageForce(isCreditDecalageForce());
    
    copie.setCreditDecalagePNDS(getCreditDecalagePNDS());
    copie.setIsCreditDecalagePNDSForce(isCreditDecalagePNDSForce());
    
    copie.setEstNeutralisee(getEstNeutralisee());
    copie.setEstNeutraliseForcee(isEstNeutraliseForcee());
    
    copie.setTypeNeutralisation(getTypeNeutralisation());
    copie.setTypeNeutralisationForce(isTypeNeutralisationForce());
    
    copie.setCommissionParitaire(getCommissionParitaire());
    copie.setIsCommissionParitaireForcee(isCommissionParitaireForcee());
    
    copie.setRepriseMemeEmployeur(getRepriseMemeEmployeur());
    copie.setIsRepriseMemeEmployeurForcee(isRepriseMemeEmployeurForcee());
    
    copie.setEstDeblocageSeuil(isDeblocageSeuil());
    copie.setIsDeblocageSeuil(isIsDeblocageSeuil());
    
    copie.setEstDeblocageVariationRenumeration(isDeblocageVariationRemuneration());
    copie.setIsDeblocageVariationRenumeration(isIsDeblocageVariationRenumeration());
    
    copie.setMontantNetActiviteReprise(getMontantNetRevenusActiviteReprise());
    copie.setIsMontantNetRevenusActiviteReprise(isIsMontantNetRevenusActiviteReprise());
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void marquerGraphePersistant() {}
  
  public void jdoPreStore() {}
}

/* Location:
 * Qualified Name:     UniteTraitementForcee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */