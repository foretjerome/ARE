package fr.unedic.cali.autresdoms.cohab.sigma.demande.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec;
import fr.unedic.util.temps.Damj;

public class Demande
  implements DemandeSpec
{
  private String m_gamme;
  private String m_ligne;
  private String m_produit;
  private String m_typeExamen;
  private Damj m_dateDepot;
  private Damj m_dateDemande;
  private int m_idPec;
  private String m_refExterne;
  private String m_etatLiquidable;
  private String m_presenceAE;
  private int m_idFormation;
  private String m_propositionCrp;
  private boolean m_droitCongeReclassement;
  private String m_refusFne;
  private int m_referenceRejetDV;
  private String m_numeroSuivi;
  private boolean m_estEnvoiDalEffectue;
  private boolean m_estDemandeMandatee;
  private String m_IdentifiantTiersBeneficiaire;
  private String m_IdentifiantTiersDemandeur;
  private String m_deploiementDalInstruction;
  
  public int getReferenceRejetDV()
  {
    return m_referenceRejetDV;
  }
  
  public void setReferenceRejetDV(int p_rejetDV)
  {
    m_referenceRejetDV = p_rejetDV;
  }
  
  public String getGamme()
  {
    return m_gamme;
  }
  
  public String getLigne()
  {
    return m_ligne;
  }
  
  public String getProduit()
  {
    return m_produit;
  }
  
  public String getTypeExamen()
  {
    return m_typeExamen;
  }
  
  public Damj getDateDepot()
  {
    return m_dateDepot;
  }
  
  public Damj getDateDemande()
  {
    return m_dateDemande;
  }
  
  public String getIdentifiantDemande()
  {
    return m_refExterne;
  }
  
  public String getEtatLiquidable()
  {
    return m_etatLiquidable;
  }
  
  public String getPresenceAE()
  {
    return m_presenceAE;
  }
  
  public int getIdentifiantPec()
  {
    return m_idPec;
  }
  
  public int getIdentifiantFormation()
  {
    return m_idFormation;
  }
  
  public String getPropositionCrpCtp()
  {
    return m_propositionCrp;
  }
  
  public boolean isDroitCongeReclassement()
  {
    return m_droitCongeReclassement;
  }
  
  public String getRefusFNE()
  {
    return m_refusFne;
  }
  
  public void setGamme(String p_gamme)
  {
    m_gamme = p_gamme;
  }
  
  public void setLigne(String p_ligne)
  {
    m_ligne = p_ligne;
  }
  
  public void setProduit(String p_produit)
  {
    m_produit = p_produit;
  }
  
  public void setTypeExamen(String p_type)
  {
    m_typeExamen = p_type;
  }
  
  public void setDateDepot(Damj p_date)
  {
    m_dateDepot = p_date;
  }
  
  public void setDateDemande(Damj p_date)
  {
    m_dateDemande = p_date;
  }
  
  public void setIdentifiantDemande(String p_ref)
  {
    m_refExterne = p_ref;
  }
  
  public void setEtatLiquidable(String p_etat)
  {
    m_etatLiquidable = p_etat;
  }
  
  public void setPresenceAE(String p_presenceAE)
  {
    m_presenceAE = p_presenceAE;
  }
  
  public void setIdentifiantPec(int p_idPec)
  {
    m_idPec = p_idPec;
  }
  
  public void setIdentifiantFormation(int p_idFormation)
  {
    m_idFormation = p_idFormation;
  }
  
  public String toString()
  {
    return "Demande [id : " + getIdentifiantDemande() + ", " + "Gamme : " + getGamme() + ", " + "Ligne : " + getLigne() + ", " + "Produit : " + getProduit() + ", " + "Examen : " + getTypeExamen() + ", " + "Date Depot : " + getDateDepot() + ", " + "Date Examen : " + getDateDemande() + ", " + "PEC : " + getIdentifiantPec() + ", " + "Etat Liq. : " + getEtatLiquidable() + ", " + "Presence AE : " + getPresenceAE() + ", " + "Formation : " + getIdentifiantFormation() + "]";
  }
  
  public void setPropositionCrpCtp(String p_proposition)
  {
    m_propositionCrp = p_proposition;
  }
  
  public void setDroitCongeReclassement(boolean p_droit)
  {
    m_droitCongeReclassement = p_droit;
  }
  
  public void setRefusFNE(String p_refusFNE)
  {
    m_refusFne = p_refusFNE;
  }
  
  public String getNumeroSuivi()
  {
    return m_numeroSuivi;
  }
  
  public void setNumeroSuivi(String p_numeroSuivi)
  {
    m_numeroSuivi = p_numeroSuivi;
  }
  
  public boolean estEnvoiDalEffectue()
  {
    return m_estEnvoiDalEffectue;
  }
  
  public void setEstEnvoiDalEffectue(boolean p_estEnvoiDalEffectue)
  {
    m_estEnvoiDalEffectue = p_estEnvoiDalEffectue;
  }
  
  public boolean estDemandeMandatee()
  {
    return m_estDemandeMandatee;
  }
  
  public String getIdentifiantTiersBeneficiaire()
  {
    return m_IdentifiantTiersBeneficiaire;
  }
  
  public String getIdentifiantTiersDemandeur()
  {
    return m_IdentifiantTiersDemandeur;
  }
  
  public void setEstDemandeMandatee(boolean p_estDemandeMandatee)
  {
    m_estDemandeMandatee = p_estDemandeMandatee;
  }
  
  public void setIdentifiantTiersBeneficiaire(String p_identifiantTiersBeneficiaire)
  {
    m_IdentifiantTiersBeneficiaire = p_identifiantTiersBeneficiaire;
  }
  
  public void setIdentifiantTiersDemandeur(String p_identifiantTiersDemandeur)
  {
    m_IdentifiantTiersDemandeur = p_identifiantTiersDemandeur;
  }
  
  public String getDeploiementDalInstruction()
  {
    return m_deploiementDalInstruction;
  }
  
  public void setDeploiementDalInstruction(String p_deploiementDalInstruction)
  {
    m_deploiementDalInstruction = p_deploiementDalInstruction;
  }
}

/* Location:
 * Qualified Name:     Demande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */