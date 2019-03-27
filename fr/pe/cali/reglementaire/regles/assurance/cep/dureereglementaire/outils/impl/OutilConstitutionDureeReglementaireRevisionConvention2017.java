package fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.dom.CoupleDureeAllongementMontant;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.dom.DonneesEntreesDureeReglementaireConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.dom.ResultatDureeReglementaireConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.spec.IOutilConstitutionDureeReglementaireConvention2017;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.services.CoucheLogiqueException;
import java.math.BigDecimal;
import java.util.List;

public class OutilConstitutionDureeReglementaireRevisionConvention2017
  implements IOutilConstitutionDureeReglementaireConvention2017
{
  private static final String NOM_OUTIL = "Duree Reglementaire Revision ARE 2017";
  private final BigDecimal plafondAllongementRevision = new BigDecimal(182);
  private static final int AGE_55 = 55;
  
  public static OutilConstitutionDureeReglementaireRevisionConvention2017 getInstance()
  {
    return new OutilConstitutionDureeReglementaireRevisionConvention2017();
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    boolean estApplicable = false;
    if ((criteres.getListeContextesReglementaires() != null) && (criteres.getListeContextesReglementaires().contains("DureeReglementaireContexteRevision"))) {
      estApplicable = true;
    }
    return estApplicable;
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilConstitutionDureeReglementaireRevisionConvention2017();
  }
  
  public String getNomOutil()
  {
    return "Duree Reglementaire Revision ARE 2017";
  }
  
  public ResultatDureeReglementaireConvention2017 determinerDureeReglementaire(DonneesEntreesDureeReglementaireConvention2017 donnees)
    throws CoucheLogiqueException
  {
    ResultatDureeReglementaireConvention2017 resultat = new ResultatDureeReglementaireConvention2017();
    determinerDureeSansAllongement(donnees.getMontantJournalierBrutRevision(), donnees.getCapitalRevision(), resultat);
    if (estEligibleAllongementAREFSurRevisionSurconditionAge(donnees.getAgeDemandeur())) {
      determinerAllongementAREF(donnees.getListeCoupleDureeMontantDroitTheorique(), donnees.getCoupleReliquatDureeMontantAttributionRevisee(), resultat);
    }
    return resultat;
  }
  
  protected boolean estEligibleAllongementAREFSurRevisionSurconditionAge(int ageDE)
  {
    return ageDE < 55;
  }
  
  protected void determinerAllongementAREF(List<CoupleDureeAllongementMontant> listeCoupleDureeMontantDroitTheorique, CoupleDureeAllongementMontant coupleReliquatDureeMontantAttributionRevisee, ResultatDureeReglementaireConvention2017 resultat)
  {
    BigDecimal montantAttributionRevisee = coupleReliquatDureeMontantAttributionRevisee.getMontant();
    BigDecimal dureeReliquatAllongementAttributionRevisee = new BigDecimal(coupleReliquatDureeMontantAttributionRevisee.getDureeAllongement());
    BigDecimal capitalAllongementReliquatDroit = montantAttributionRevisee.multiply(dureeReliquatAllongementAttributionRevisee);
    
    BigDecimal capitalAllongementDroitTheorique = BigDecimal.ZERO;
    BigDecimal sommeMontantJournalierBrutDroitTheorique = BigDecimal.ZERO;
    for (CoupleDureeAllongementMontant couple : listeCoupleDureeMontantDroitTheorique)
    {
      BigDecimal montantAttributionDroitTheorique = couple.getMontant();
      BigDecimal dureeAllongementDroitTheorique = new BigDecimal(couple.getDureeAllongement());
      capitalAllongementDroitTheorique = capitalAllongementDroitTheorique.add(montantAttributionDroitTheorique.multiply(dureeAllongementDroitTheorique));
      
      sommeMontantJournalierBrutDroitTheorique = sommeMontantJournalierBrutDroitTheorique.add(montantAttributionDroitTheorique);
    }
    BigDecimal dureeAllongementDroitTheorique = BigDecimal.ZERO;
    if ((!capitalAllongementDroitTheorique.equals(BigDecimal.ZERO)) && (!sommeMontantJournalierBrutDroitTheorique.equals(BigDecimal.ZERO))) {
      dureeAllongementDroitTheorique = capitalAllongementDroitTheorique.divide(sommeMontantJournalierBrutDroitTheorique, 0, 0);
    }
    BigDecimal sommeCapitaux = capitalAllongementReliquatDroit.add(capitalAllongementDroitTheorique);
    
    BigDecimal sommeMontantJournalierBrut = montantAttributionRevisee.add(sommeMontantJournalierBrutDroitTheorique);
    
    BigDecimal dureeAllongementCalculee = BigDecimal.ZERO;
    if ((!sommeCapitaux.equals(BigDecimal.ZERO)) && (!sommeMontantJournalierBrut.equals(BigDecimal.ZERO))) {
      dureeAllongementCalculee = sommeCapitaux.divide(sommeMontantJournalierBrut, 0, 0);
    }
    boolean estAllongementCalculee = !dureeAllongementCalculee.equals(BigDecimal.ZERO);
    
    resultat.setDureeAllongementPossible(dureeAllongementCalculee.min(plafondAllongementRevision).intValue());
    resultat.setDureeAllongementPossibleDroitSousJacent(dureeAllongementDroitTheorique.min(plafondAllongementRevision).intValue());
    resultat.setEligibleAllongement(estAllongementCalculee);
  }
  
  protected void determinerDureeSansAllongement(BigDecimal montant, BigDecimal capital, ResultatDureeReglementaireConvention2017 resultat)
  {
    BigDecimal dureeSansAllongement = calculerDuree(capital, montant);
    resultat.setDureeTheoriqueAvantImputation(dureeSansAllongement.intValue());
    resultat.setDureeTheoriqueDroitCourant(dureeSansAllongement.intValue());
  }
  
  public BigDecimal calculerDuree(BigDecimal pCapital, BigDecimal pMontant)
  {
    if ((pCapital == null) || (pMontant == null) || (pMontant.compareTo(BigDecimal.ZERO) == 0)) {
      return BigDecimal.ZERO;
    }
    BigDecimal dureeRevision = Mathematiques.diviseParDefaut(pCapital, pMontant);
    dureeRevision = dureeRevision.setScale(0, 0);
    return dureeRevision;
  }
}

/* Location:
 * Qualified Name:     OutilConstitutionDureeReglementaireRevisionConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */