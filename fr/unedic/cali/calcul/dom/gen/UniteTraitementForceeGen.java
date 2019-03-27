package fr.unedic.cali.calcul.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.dom.pc.UniteTraitementForceePC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriodeCREM;
import java.math.BigDecimal;

public abstract class UniteTraitementForceeGen
  extends ObjetChronoPeriodeCREM
  implements DomGenSpec
{
  private Quantite m_creditDecalage;
  private Quantite m_creditDecalagePNDS;
  private BigDecimal m_montantNetRevenusActiviteReprise;
  private String m_motif;
  
  public UniteTraitementForceeGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public UniteTraitementForceeGen() {}
  
  public UniteTraitementForceeGen(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  protected abstract DomPCSpec createPC();
  
  protected int rawGetStatut()
  {
    return ((UniteTraitementForceePC)getPC()).getStatut();
  }
  
  public int getStatut()
  {
    return ((UniteTraitementForceePC)getPC()).getStatut();
  }
  
  public void setStatut(int p_statut)
  {
    ((UniteTraitementForceePC)getPC()).setStatut(p_statut);
  }
  
  protected boolean rawIsIsStatutForce()
  {
    return ((UniteTraitementForceePC)getPC()).isIsStatutForce();
  }
  
  public boolean isIsStatutForce()
  {
    return ((UniteTraitementForceePC)getPC()).isIsStatutForce();
  }
  
  public void setIsStatutForce(boolean p_isStatutForce)
  {
    ((UniteTraitementForceePC)getPC()).setIsStatutForce(p_isStatutForce);
  }
  
  protected Quantite rawGetCreditDecalage()
  {
    return ((UniteTraitementForceePC)getPC()).getCreditDecalage();
  }
  
  public Quantite getCreditDecalage()
  {
    return ((UniteTraitementForceePC)getPC()).getCreditDecalage();
  }
  
  public void setCreditDecalage(Quantite p_creditDecalage)
  {
    if ((m_creditDecalage == null) || (p_creditDecalage == null))
    {
      m_creditDecalage = p_creditDecalage;
      ((UniteTraitementForceePC)getPC()).setCreditDecalage(p_creditDecalage);
    }
    else if ((m_creditDecalage != null) && (p_creditDecalage != null) && (!p_creditDecalage.equals(m_creditDecalage)))
    {
      m_creditDecalage = p_creditDecalage;
      ((UniteTraitementForceePC)getPC()).setCreditDecalage(p_creditDecalage);
    }
  }
  
  protected boolean rawIsIsCreditDecalageForce()
  {
    return ((UniteTraitementForceePC)getPC()).isIsCreditDecalageForce();
  }
  
  public boolean isIsCreditDecalageForce()
  {
    return ((UniteTraitementForceePC)getPC()).isIsCreditDecalageForce();
  }
  
  public void setIsCreditDecalageForce(boolean p_isCreditDecalageForce)
  {
    ((UniteTraitementForceePC)getPC()).setIsCreditDecalageForce(p_isCreditDecalageForce);
  }
  
  protected Quantite rawGetCreditDecalagePNDS()
  {
    return ((UniteTraitementForceePC)getPC()).getCreditDecalagePNDS();
  }
  
  public Quantite getCreditDecalagePNDS()
  {
    return ((UniteTraitementForceePC)getPC()).getCreditDecalagePNDS();
  }
  
  public void setCreditDecalagePNDS(Quantite p_creditDecalagePNDS)
  {
    if ((m_creditDecalagePNDS == null) || (p_creditDecalagePNDS == null))
    {
      m_creditDecalagePNDS = p_creditDecalagePNDS;
      ((UniteTraitementForceePC)getPC()).setCreditDecalagePNDS(p_creditDecalagePNDS);
    }
    else if ((m_creditDecalagePNDS != null) && (p_creditDecalagePNDS != null) && (!p_creditDecalagePNDS.equals(m_creditDecalagePNDS)))
    {
      m_creditDecalagePNDS = p_creditDecalagePNDS;
      ((UniteTraitementForceePC)getPC()).setCreditDecalagePNDS(p_creditDecalagePNDS);
    }
  }
  
  protected boolean rawIsIsCreditDecalagePNDSForce()
  {
    return ((UniteTraitementForceePC)getPC()).isIsCreditDecalagePNDSForce();
  }
  
  public boolean isIsCreditDecalagePNDSForce()
  {
    return ((UniteTraitementForceePC)getPC()).isIsCreditDecalagePNDSForce();
  }
  
  public void setIsCreditDecalagePNDSForce(boolean p_isCreditDecalagePNDSForce)
  {
    ((UniteTraitementForceePC)getPC()).setIsCreditDecalagePNDSForce(p_isCreditDecalagePNDSForce);
  }
  
  protected int rawGetCommissionParitaire()
  {
    return ((UniteTraitementForceePC)getPC()).getCommissionParitaire();
  }
  
  public int getCommissionParitaire()
  {
    return ((UniteTraitementForceePC)getPC()).getCommissionParitaire();
  }
  
  public void setCommissionParitaire(int p_commissionParitaire)
  {
    ((UniteTraitementForceePC)getPC()).setCommissionParitaire(p_commissionParitaire);
  }
  
  protected boolean rawIsIsCommissionParitaireForcee()
  {
    return ((UniteTraitementForceePC)getPC()).isIsCommissionParitaireForcee();
  }
  
  public boolean isIsCommissionParitaireForcee()
  {
    return ((UniteTraitementForceePC)getPC()).isIsCommissionParitaireForcee();
  }
  
  public void setIsCommissionParitaireForcee(boolean p_isCommissionParitaireForcee)
  {
    ((UniteTraitementForceePC)getPC()).setIsCommissionParitaireForcee(p_isCommissionParitaireForcee);
  }
  
  protected int rawGetRepriseMemeEmployeur()
  {
    return ((UniteTraitementForceePC)getPC()).getRepriseMemeEmployeur();
  }
  
  public int getRepriseMemeEmployeur()
  {
    return ((UniteTraitementForceePC)getPC()).getRepriseMemeEmployeur();
  }
  
  public void setRepriseMemeEmployeur(int p_repriseMemeEmployeur)
  {
    ((UniteTraitementForceePC)getPC()).setRepriseMemeEmployeur(p_repriseMemeEmployeur);
  }
  
  protected boolean rawIsIsRepriseMemeEmployeurForcee()
  {
    return ((UniteTraitementForceePC)getPC()).isIsRepriseMemeEmployeurForcee();
  }
  
  public boolean isIsRepriseMemeEmployeurForcee()
  {
    return ((UniteTraitementForceePC)getPC()).isIsRepriseMemeEmployeurForcee();
  }
  
  public void setIsRepriseMemeEmployeurForcee(boolean p_isRepriseMemeEmployeurForcee)
  {
    ((UniteTraitementForceePC)getPC()).setIsRepriseMemeEmployeurForcee(p_isRepriseMemeEmployeurForcee);
  }
  
  protected int rawGetTypeNeutralisation()
  {
    return ((UniteTraitementForceePC)getPC()).getTypeNeutralisation();
  }
  
  public int getTypeNeutralisation()
  {
    return ((UniteTraitementForceePC)getPC()).getTypeNeutralisation();
  }
  
  public void setTypeNeutralisation(int p_typeNeutralisation)
  {
    ((UniteTraitementForceePC)getPC()).setTypeNeutralisation(p_typeNeutralisation);
  }
  
  protected boolean rawIsTypeNeutralisationForce()
  {
    return ((UniteTraitementForceePC)getPC()).isTypeNeutralisationForce();
  }
  
  public boolean isTypeNeutralisationForce()
  {
    return ((UniteTraitementForceePC)getPC()).isTypeNeutralisationForce();
  }
  
  public void setTypeNeutralisationForce(boolean p_typeNeutralisationForce)
  {
    ((UniteTraitementForceePC)getPC()).setTypeNeutralisationForce(p_typeNeutralisationForce);
  }
  
  protected int rawGetEstNeutralisee()
  {
    return ((UniteTraitementForceePC)getPC()).getEstNeutralisee();
  }
  
  public int getEstNeutralisee()
  {
    return ((UniteTraitementForceePC)getPC()).getEstNeutralisee();
  }
  
  public void setEstNeutralisee(int p_estNeutralisee)
  {
    ((UniteTraitementForceePC)getPC()).setEstNeutralisee(p_estNeutralisee);
  }
  
  protected boolean rawIsEstNeutraliseForcee()
  {
    return ((UniteTraitementForceePC)getPC()).isEstNeutraliseForcee();
  }
  
  public boolean isEstNeutraliseForcee()
  {
    return ((UniteTraitementForceePC)getPC()).isEstNeutraliseForcee();
  }
  
  public void setEstNeutraliseForcee(boolean p_estNeutraliseForcee)
  {
    ((UniteTraitementForceePC)getPC()).setEstNeutraliseForcee(p_estNeutraliseForcee);
  }
  
  protected boolean rawIsEstDeblocageVariationRenumeration()
  {
    return ((UniteTraitementForceePC)getPC()).isEstDeblocageVariationRenumeration();
  }
  
  public boolean isEstDeblocageVariationRenumeration()
  {
    return ((UniteTraitementForceePC)getPC()).isEstDeblocageVariationRenumeration();
  }
  
  public void setEstDeblocageVariationRenumeration(boolean p_estDeblocageVariationRenumeration)
  {
    ((UniteTraitementForceePC)getPC()).setEstDeblocageVariationRenumeration(p_estDeblocageVariationRenumeration);
  }
  
  protected boolean rawIsIsDeblocageVariationRenumeration()
  {
    return ((UniteTraitementForceePC)getPC()).isIsDeblocageVariationRenumeration();
  }
  
  public boolean isIsDeblocageVariationRenumeration()
  {
    return ((UniteTraitementForceePC)getPC()).isIsDeblocageVariationRenumeration();
  }
  
  public void setIsDeblocageVariationRenumeration(boolean p_isDeblocageVariationRenumeration)
  {
    ((UniteTraitementForceePC)getPC()).setIsDeblocageVariationRenumeration(p_isDeblocageVariationRenumeration);
  }
  
  protected boolean rawIsEstDeblocageSeuil()
  {
    return ((UniteTraitementForceePC)getPC()).isEstDeblocageSeuil();
  }
  
  public boolean isEstDeblocageSeuil()
  {
    return ((UniteTraitementForceePC)getPC()).isEstDeblocageSeuil();
  }
  
  public void setEstDeblocageSeuil(boolean p_estDeblocageSeuil)
  {
    ((UniteTraitementForceePC)getPC()).setEstDeblocageSeuil(p_estDeblocageSeuil);
  }
  
  protected boolean rawIsIsDeblocageSeuil()
  {
    return ((UniteTraitementForceePC)getPC()).isIsDeblocageSeuil();
  }
  
  public boolean isIsDeblocageSeuil()
  {
    return ((UniteTraitementForceePC)getPC()).isIsDeblocageSeuil();
  }
  
  public void setIsDeblocageSeuil(boolean p_isDeblocageSeuil)
  {
    ((UniteTraitementForceePC)getPC()).setIsDeblocageSeuil(p_isDeblocageSeuil);
  }
  
  protected BigDecimal rawGetMontantNetRevenusActiviteReprise()
  {
    return ((UniteTraitementForceePC)getPC()).getMontantNetRevenusActiviteReprise();
  }
  
  public BigDecimal getMontantNetRevenusActiviteReprise()
  {
    return ((UniteTraitementForceePC)getPC()).getMontantNetRevenusActiviteReprise();
  }
  
  public void setMontantNetRevenusActiviteReprise(BigDecimal p_montantNetRevenusActiviteReprise)
  {
    if ((m_montantNetRevenusActiviteReprise == null) || (p_montantNetRevenusActiviteReprise == null))
    {
      m_montantNetRevenusActiviteReprise = p_montantNetRevenusActiviteReprise;
      ((UniteTraitementForceePC)getPC()).setMontantNetRevenusActiviteReprise(p_montantNetRevenusActiviteReprise);
    }
    else if ((m_montantNetRevenusActiviteReprise != null) && (p_montantNetRevenusActiviteReprise != null) && (!p_montantNetRevenusActiviteReprise.equals(m_montantNetRevenusActiviteReprise)))
    {
      m_montantNetRevenusActiviteReprise = p_montantNetRevenusActiviteReprise;
      ((UniteTraitementForceePC)getPC()).setMontantNetRevenusActiviteReprise(p_montantNetRevenusActiviteReprise);
    }
  }
  
  protected boolean rawIsIsMontantNetRevenusActiviteReprise()
  {
    return ((UniteTraitementForceePC)getPC()).isIsMontantNetRevenusActiviteReprise();
  }
  
  public boolean isIsMontantNetRevenusActiviteReprise()
  {
    return ((UniteTraitementForceePC)getPC()).isIsMontantNetRevenusActiviteReprise();
  }
  
  public void setIsMontantNetRevenusActiviteReprise(boolean p_isMontantNetRevenusActiviteReprise)
  {
    ((UniteTraitementForceePC)getPC()).setIsMontantNetRevenusActiviteReprise(p_isMontantNetRevenusActiviteReprise);
  }
  
  protected boolean rawIsIsCumulARSurUtForce()
  {
    return ((UniteTraitementForceePC)getPC()).isIsCumulARSurUtForce();
  }
  
  public boolean isIsCumulARSurUtForce()
  {
    return ((UniteTraitementForceePC)getPC()).isIsCumulARSurUtForce();
  }
  
  public void setIsCumulARSurUtForce(boolean p_isCumulARSurUtForce)
  {
    ((UniteTraitementForceePC)getPC()).setIsCumulARSurUtForce(p_isCumulARSurUtForce);
  }
  
  protected int rawGetCumulARsurUtForce()
  {
    return ((UniteTraitementForceePC)getPC()).getCumulARsurUtForce();
  }
  
  public int getCumulARsurUtForce()
  {
    return ((UniteTraitementForceePC)getPC()).getCumulARsurUtForce();
  }
  
  public void setCumulARsurUtForce(int p_cumulARsurUtForce)
  {
    ((UniteTraitementForceePC)getPC()).setCumulARsurUtForce(p_cumulARsurUtForce);
  }
  
  protected boolean rawIsPasssDesactive()
  {
    return ((UniteTraitementForceePC)getPC()).isPasssDesactive();
  }
  
  public boolean isPasssDesactive()
  {
    return ((UniteTraitementForceePC)getPC()).isPasssDesactive();
  }
  
  public void setPasssDesactive(boolean p_passsDesactive)
  {
    ((UniteTraitementForceePC)getPC()).setPasssDesactive(p_passsDesactive);
  }
  
  protected boolean rawIsEstLeverBlocageDV()
  {
    return ((UniteTraitementForceePC)getPC()).isEstLeverBlocageDV();
  }
  
  public boolean isEstLeverBlocageDV()
  {
    return ((UniteTraitementForceePC)getPC()).isEstLeverBlocageDV();
  }
  
  public void setEstLeverBlocageDV(boolean p_estLeverBlocageDV)
  {
    ((UniteTraitementForceePC)getPC()).setEstLeverBlocageDV(p_estLeverBlocageDV);
  }
  
  protected boolean rawIsEstIgnorerAEDV()
  {
    return ((UniteTraitementForceePC)getPC()).isEstIgnorerAEDV();
  }
  
  public boolean isEstIgnorerAEDV()
  {
    return ((UniteTraitementForceePC)getPC()).isEstIgnorerAEDV();
  }
  
  public void setEstIgnorerAEDV(boolean p_estIgnorerAEDV)
  {
    ((UniteTraitementForceePC)getPC()).setEstIgnorerAEDV(p_estIgnorerAEDV);
  }
  
  protected String rawGetMotif()
  {
    return ((UniteTraitementForceePC)getPC()).getMotif();
  }
  
  public String getMotif()
  {
    return ((UniteTraitementForceePC)getPC()).getMotif();
  }
  
  public void setMotif(String p_motif)
  {
    if ((m_motif == null) || (p_motif == null))
    {
      m_motif = p_motif;
      ((UniteTraitementForceePC)getPC()).setMotif(p_motif);
    }
    else if ((m_motif != null) && (p_motif != null) && (!p_motif.equals(m_motif)))
    {
      m_motif = p_motif;
      ((UniteTraitementForceePC)getPC()).setMotif(p_motif);
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    super.supprimerEnProfondeur(p_contexteSuppression);
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
  }
}

/* Location:
 * Qualified Name:     UniteTraitementForceeGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */