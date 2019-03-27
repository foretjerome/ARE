package fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.dom.DonneesEntreesDureeReglementaireConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.dom.ResultatDureeReglementaireConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.parametres.IParametres;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.parametres.Parametres;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.parametres.ParametresConversionUnite;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.parametres.ParametresPlafondDuree;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.parametres.ParametresRechargement;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.spec.IOutilConstitutionDureeReglementaireConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.spec.IOutilFonctionnelDureeReglementaireConvention2017;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.UniteAffiliation;
import fr.unedic.util.services.CoucheLogiqueException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OutilConstitutionDureeReglementaireConvention2017
  implements IOutilConstitutionDureeReglementaireConvention2017
{
  private static final String NOM_OUTIL = "Duree Reglementaire ARE 2017";
  private static final int DUREE_ALLONGEMENT_MAXIMALE = 182;
  private static final int AGE_53 = 53;
  private static final int AGE_54 = 54;
  
  public static OutilConstitutionDureeReglementaireConvention2017 getInstance()
  {
    return new OutilConstitutionDureeReglementaireConvention2017();
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    boolean estApplicable = false;
    if ((criteres.getListeContextesReglementaires() == null) || (criteres.getListeContextesReglementaires().isEmpty()) || (criteres.getListeContextesReglementaires().contains("DureeReglementaireContexteGeneral"))) {
      estApplicable = true;
    }
    return estApplicable;
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilConstitutionDureeReglementaireConvention2017();
  }
  
  public String getNomOutil()
  {
    return "Duree Reglementaire ARE 2017";
  }
  
  public ResultatDureeReglementaireConvention2017 determinerDureeReglementaire(DonneesEntreesDureeReglementaireConvention2017 donnees)
    throws CoucheLogiqueException
  {
    ResultatDureeReglementaireConvention2017 resultat = new ResultatDureeReglementaireConvention2017();
    if (donnees.getDureeTheoriqueForcee() != null) {
      alimenterDonneeForcee(donnees, resultat);
    } else {
      calculerDureeReglementaire(donnees, resultat);
    }
    return resultat;
  }
  
  protected void alimenterDonneeForcee(DonneesEntreesDureeReglementaireConvention2017 donnees, ResultatDureeReglementaireConvention2017 resultat)
  {
    BigDecimal dureeTheoriqueForceePlafonnee = appliquerPlafond(donnees.getDureeTheoriqueForcee(), donnees.getAgeDemandeur());
    resultat.setDureeTheoriqueDroitCourant(dureeTheoriqueForceePlafonnee.intValue());
    resultat.setDureeTheoriqueAvantImputation(donnees.getDureeTheoriqueForcee().intValue());
    if ((donnees.getDureeAllongementArefForcee() != null) && (estEligibleAllongementAref(donnees, resultat))) {
      alimenterDureeAllongementForcee(donnees, resultat);
    }
  }
  
  protected void calculerDureeReglementaire(DonneesEntreesDureeReglementaireConvention2017 donnees, ResultatDureeReglementaireConvention2017 resultat)
    throws CoucheLogiqueException
  {
    List<UniteAffiliation> unitesRecherchees = getUnitesPourReglement(donnees.getNomReglement(), donnees.isContexteRechargement());
    List<Quantite> quantitesTrouvees = getQuantitesAffiliationRetenues(donnees, unitesRecherchees);
    
    BigDecimal dureeMax = calculerDureeMax(quantitesTrouvees, resultat);
    resultat.setDureeCalculeeAvantPlafondPlancher(dureeMax.intValue());
    
    dureeMax = appliquerPlancher(dureeMax, donnees.isDemandeRechargement());
    resultat.setDureeMinimale(getPlancher(donnees.isDemandeRechargement()).intValue());
    resultat.setDureeTheoriqueAvantImputation(dureeMax.intValue());
    
    dureeMax = appliquerPlafond(dureeMax, donnees.getAgeDemandeur());
    resultat.setDureeMaximale(getPlafond(donnees.getAgeDemandeur()).intValue());
    
    BigDecimal imputationFormation = donnees.getOutilFonctionnel().determinerDureeImputationFormationDroitCourant(dureeMax);
    
    dureeMax = appliquerImputation(donnees.getImputationDroitCourantForcee(), imputationFormation, dureeMax);
    
    resultat.setDureeTheoriqueDroitCourant(dureeMax.intValue());
    resultat.setDureeImputationFormation(imputationFormation.intValue());
    if (donnees.getImputationDroitCourantForcee() != null) {
      resultat.setDureeImputationForcee(donnees.getImputationDroitCourantForcee().intValue());
    }
    if (estEligibleAllongementAref(donnees, resultat)) {
      if (donnees.getDureeAllongementArefForcee() != null) {
        alimenterDureeAllongementForcee(donnees, resultat);
      } else {
        calculerDureeAllongement(donnees, resultat);
      }
    }
  }
  
  protected void alimenterDureeAllongementForcee(DonneesEntreesDureeReglementaireConvention2017 donnees, ResultatDureeReglementaireConvention2017 resultat)
  {
    resultat.setDureeAllongementPossible(donnees.getDureeAllongementArefForcee().intValue());
  }
  
  private BigDecimal appliquerImputation(BigDecimal forcage, BigDecimal imputationFormation, BigDecimal dureeMax)
  {
    BigDecimal imputationTotale = imputationFormation;
    if (forcage != null) {
      imputationTotale = imputationTotale.add(forcage);
    }
    return BigDecimal.ZERO.max(dureeMax.subtract(imputationTotale));
  }
  
  protected BigDecimal appliquerPlancher(BigDecimal dureeMax, boolean demandeRechargement)
  {
    return dureeMax.max(getPlancher(demandeRechargement));
  }
  
  protected BigDecimal appliquerPlafond(BigDecimal dureeMax, int ageDE)
  {
    return dureeMax.min(getPlafond(ageDE));
  }
  
  protected BigDecimal calculerDureeMax(List<Quantite> quantites, ResultatDureeReglementaireConvention2017 resultat)
    throws CoucheLogiqueException
  {
    BigDecimal dureeMax = BigDecimal.ZERO;
    
    resultat.setPlusieursUnites(quantites.size() > 1);
    for (Quantite quantite : quantites)
    {
      BigDecimal duree = calculerDuree(quantite);
      if (duree.compareTo(dureeMax) > 0)
      {
        dureeMax = duree;
        resultat.setUniteRetenu(quantite.getUnite());
      }
    }
    return dureeMax;
  }
  
  protected BigDecimal calculerDuree(Quantite quantite)
    throws CoucheLogiqueException
  {
    BigDecimal coefficient = getCoefficientPourUnite(quantite.getUnite().getCode());
    BigDecimal duree = coefficient.multiply(quantite.getValeur());
    duree = duree.setScale(0, 0);
    return duree;
  }
  
  protected List<Quantite> getQuantitesAffiliationRetenues(DonneesEntreesDureeReglementaireConvention2017 donnees, List<UniteAffiliation> unites)
    throws CoucheLogiqueException
  {
    List<Quantite> quantites = new ArrayList();
    for (Unite unite : unites)
    {
      if (estUniteCorrespondante(donnees.getAffiliationPrincipale(), unite)) {
        quantites.add(donnees.getAffiliationPrincipale());
      }
      if (estUniteCorrespondante(donnees.getAffiliationSecondaire(), unite)) {
        quantites.add(donnees.getAffiliationSecondaire());
      }
    }
    if (quantites.size() != unites.size()) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_UNITES_DUREE_REGLEMENTAIRE");
    }
    return quantites;
  }
  
  protected boolean estUniteCorrespondante(Quantite affiliation, Unite unite)
  {
    return (affiliation != null) && (affiliation.getUnite().getCode().equals(unite.getCode()));
  }
  
  protected BigDecimal getPlancher(boolean demandeRechargement)
  {
    IParametres parametres;
    IParametres parametres;
    if (demandeRechargement) {
      parametres = ParametresRechargement.getInstance();
    } else {
      parametres = Parametres.getInstance();
    }
    return parametres.getPlancher();
  }
  
  protected BigDecimal getPlafond(int ageDE)
  {
    return ParametresPlafondDuree.getInstance().getPlafondPourAge(ageDE);
  }
  
  protected BigDecimal getCoefficientPourUnite(String codeUnite)
    throws CoucheLogiqueException
  {
    BigDecimal coefficient = ParametresConversionUnite.getInstance().getCoefficientPourUnite(codeUnite);
    if (coefficient == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_UNITES_DUREE2_REGLEMENTAIRE");
    }
    return coefficient;
  }
  
  protected List<UniteAffiliation> getUnitesPourReglement(String nomReglement, boolean contexteRechargement)
    throws CoucheLogiqueException
  {
    IParametres parametres;
    IParametres parametres;
    if (contexteRechargement) {
      parametres = ParametresRechargement.getInstance();
    } else {
      parametres = Parametres.getInstance();
    }
    List<UniteAffiliation> unites = parametres.getUnitesPourReglement(nomReglement);
    if (unites == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_REGLEMENT_DUREE_REGLEMENTAIRE");
    }
    return unites;
  }
  
  protected boolean estEligibleAllongementAref(DonneesEntreesDureeReglementaireConvention2017 donnees, ResultatDureeReglementaireConvention2017 resultat)
  {
    int ageDuDemandeur = donnees.getAgeDemandeur();
    String nomReglement = donnees.getNomReglement();
    boolean estAgeDemandeurEligible = (ageDuDemandeur == 53) || (ageDuDemandeur == 54);
    boolean estDureeTheoriqueSuperieureMax = resultat.getDureeTheoriqueAvantImputation() > getPlafond(53).intValue();
    boolean reglementNonA9 = "A9B".compareTo(nomReglement) != 0;
    
    boolean estEligible = (estAgeDemandeurEligible) && (estDureeTheoriqueSuperieureMax) && (reglementNonA9);
    resultat.setEligibleAllongement(estEligible);
    
    return estEligible;
  }
  
  protected void calculerDureeAllongement(DonneesEntreesDureeReglementaireConvention2017 donnees, ResultatDureeReglementaireConvention2017 resultat)
  {
    int difference = resultat.getDureeTheoriqueAvantImputation() - getPlafond(53).intValue();
    resultat.setDureeAllongementPossible(Math.min(difference, 182));
  }
}

/* Location:
 * Qualified Name:     OutilConstitutionDureeReglementaireConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */