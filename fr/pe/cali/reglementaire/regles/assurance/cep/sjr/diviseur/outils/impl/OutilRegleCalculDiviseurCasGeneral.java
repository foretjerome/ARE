package fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.dom.DonneesEntreesCalculDiviseur;
import fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.dom.ResultatCalculDiviseur;
import fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.outils.spec.IOutilRegleCalculDiviseur;
import java.math.BigDecimal;

public class OutilRegleCalculDiviseurCasGeneral
  implements IOutilRegleCalculDiviseur
{
  private static final String NOM_OUTIL = "OutilRegleCalculDiviseurCasGeneral";
  private static OutilRegleCalculDiviseurCasGeneral instance = new OutilRegleCalculDiviseurCasGeneral();
  private static final String FORMULE_COEFFICIENT_ABSENCE = "[1 - (Nb jour absence / Nb jour emploi)]";
  private static final String FORMULE_DIVISEUR = "Min [NJCP ; 261] x coef. absence x 1.4";
  private static final int PLAFOND_AFFILIATION = 261;
  private static final BigDecimal coefficientCalendaire = BigDecimal.valueOf(1.4D);
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return true;
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilRegleCalculDiviseurCasGeneral();
  }
  
  public String getNomOutil()
  {
    return "OutilRegleCalculDiviseurCasGeneral";
  }
  
  public static OutilRegleCalculDiviseurCasGeneral getInstance()
  {
    return instance;
  }
  
  public ResultatCalculDiviseur calculerDiviseur(DonneesEntreesCalculDiviseur donneesEntrees)
  {
    ResultatCalculDiviseur resultat = calculerCoefficientAbsence(donneesEntrees);
    resultat.setFormuleCalculDiviseur("Min [NJCP ; 261] x coef. absence x 1.4");
    BigDecimal diviseurTravaille = BigDecimal.valueOf(Math.min(261, donneesEntrees.getNombreJoursContratPlafonnes())).multiply(resultat.getCoefficientAbsence());
    resultat.setDiviseurTravaille(diviseurTravaille);
    resultat.setDiviseur(diviseurTravaille.multiply(coefficientCalendaire).setScale(2, 4));
    return resultat;
  }
  
  public ResultatCalculDiviseur calculerCoefficientAbsence(DonneesEntreesCalculDiviseur donneesEntrees)
  {
    ResultatCalculDiviseur resultat = new ResultatCalculDiviseur();
    resultat.setFormuleCalculCoefficientAbsence("[1 - (Nb jour absence / Nb jour emploi)]");
    BigDecimal coefficientAbsence = BigDecimal.ONE;
    if (donneesEntrees.getNombreJoursAbsence().compareTo(BigDecimal.ZERO) > 0)
    {
      coefficientAbsence = donneesEntrees.getNombreJoursAbsence().divide(BigDecimal.valueOf(donneesEntrees.getNombreJoursEmploi()), 4, 4);
      
      coefficientAbsence = BigDecimal.ONE.subtract(coefficientAbsence);
    }
    resultat.setCoefficientAbsence(coefficientAbsence);
    return resultat;
  }
}

/* Location:
 * Qualified Name:     OutilRegleCalculDiviseurCasGeneral
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */