package fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.dom;

import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.spec.IOutilFonctionnelDureeReglementaireConvention2017;
import fr.unedic.util.Quantite;
import java.math.BigDecimal;
import java.util.List;

public class DonneesEntreesDureeReglementaireConvention2017
{
  private String nomReglement;
  private Quantite affiliationPrincipale;
  private Quantite affiliationSecondaire;
  private boolean contexteRechargement;
  private boolean demandeRechargement;
  private int ageDemandeur;
  private BigDecimal imputationDroitCourantForcee = BigDecimal.ZERO;
  private BigDecimal dureeTheoriqueForcee;
  private BigDecimal dureeAllongementArefForcee;
  private IOutilFonctionnelDureeReglementaireConvention2017 outilFonctionnel;
  private List<CoupleDureeAllongementMontant> listeCoupleDureeMontantDroitTheorique;
  private CoupleDureeAllongementMontant coupleReliquatDureeMontantAttributionRevisee;
  private BigDecimal capitalRevision;
  private BigDecimal montantJournalierBrutRevision;
  
  public List<CoupleDureeAllongementMontant> getListeCoupleDureeMontantDroitTheorique()
  {
    return listeCoupleDureeMontantDroitTheorique;
  }
  
  public void setListeCoupleDureeMontantDroitTheorique(List<CoupleDureeAllongementMontant> listeCoupleDureeMontantDroitTheorique)
  {
    this.listeCoupleDureeMontantDroitTheorique = listeCoupleDureeMontantDroitTheorique;
  }
  
  public CoupleDureeAllongementMontant getCoupleReliquatDureeMontantAttributionRevisee()
  {
    return coupleReliquatDureeMontantAttributionRevisee;
  }
  
  public void setCoupleReliquatDureeMontantAttributionRevisee(CoupleDureeAllongementMontant coupleReliquatDureeMontantAttributionRevisee)
  {
    this.coupleReliquatDureeMontantAttributionRevisee = coupleReliquatDureeMontantAttributionRevisee;
  }
  
  public BigDecimal getCapitalRevision()
  {
    return capitalRevision;
  }
  
  public void setCapitalRevision(BigDecimal capitalRevision)
  {
    this.capitalRevision = capitalRevision;
  }
  
  public BigDecimal getMontantJournalierBrutRevision()
  {
    return montantJournalierBrutRevision;
  }
  
  public void setMontantJournalierBrutRevision(BigDecimal montantJournalierBrutRevision)
  {
    this.montantJournalierBrutRevision = montantJournalierBrutRevision;
  }
  
  public int getAgeDemandeur()
  {
    return ageDemandeur;
  }
  
  public void setAgeDemandeur(int ageDemandeur)
  {
    this.ageDemandeur = ageDemandeur;
  }
  
  public String getNomReglement()
  {
    return nomReglement;
  }
  
  public void setNomReglement(String nomReglement)
  {
    this.nomReglement = nomReglement;
  }
  
  public Quantite getAffiliationPrincipale()
  {
    return affiliationPrincipale;
  }
  
  public void setAffiliationPrincipale(Quantite affiliationPrincipale)
  {
    this.affiliationPrincipale = affiliationPrincipale;
  }
  
  public Quantite getAffiliationSecondaire()
  {
    return affiliationSecondaire;
  }
  
  public void setAffiliationSecondaire(Quantite affiliationSecondaire)
  {
    this.affiliationSecondaire = affiliationSecondaire;
  }
  
  public boolean isContexteRechargement()
  {
    return contexteRechargement;
  }
  
  public void setContexteRechargement(boolean contexteRechargement)
  {
    this.contexteRechargement = contexteRechargement;
  }
  
  public IOutilFonctionnelDureeReglementaireConvention2017 getOutilFonctionnel()
  {
    return outilFonctionnel;
  }
  
  public void setOutilFonctionnel(IOutilFonctionnelDureeReglementaireConvention2017 outilFonctionnel)
  {
    this.outilFonctionnel = outilFonctionnel;
  }
  
  public BigDecimal getImputationDroitCourantForcee()
  {
    return imputationDroitCourantForcee;
  }
  
  public void setImputationDroitCourantForcee(BigDecimal imputationDroitCourantForcee)
  {
    this.imputationDroitCourantForcee = imputationDroitCourantForcee;
  }
  
  public boolean isDemandeRechargement()
  {
    return demandeRechargement;
  }
  
  public void setDemandeRechargement(boolean demandeRechargement)
  {
    this.demandeRechargement = demandeRechargement;
  }
  
  public BigDecimal getDureeTheoriqueForcee()
  {
    return dureeTheoriqueForcee;
  }
  
  public void setDureeTheoriqueForcee(BigDecimal dureeTheoriqueForcee)
  {
    this.dureeTheoriqueForcee = dureeTheoriqueForcee;
  }
  
  public BigDecimal getDureeAllongementArefForcee()
  {
    return dureeAllongementArefForcee;
  }
  
  public void setDureeAllongementArefForcee(BigDecimal dureeAllongementArefForcee)
  {
    this.dureeAllongementArefForcee = dureeAllongementArefForcee;
  }
}

/* Location:
 * Qualified Name:     DonneesEntreesDureeReglementaireConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */