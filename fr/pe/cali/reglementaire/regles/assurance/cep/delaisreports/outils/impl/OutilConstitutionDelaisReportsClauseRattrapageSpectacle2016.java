package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.List;

public class OutilConstitutionDelaisReportsClauseRattrapageSpectacle2016
  extends OutilConstitutionDelaisReportsSpectacle2016
{
  private static final int FORFAIT_FRANCHISE_MENSUELLE_0_JOURS = 0;
  private static final int FORFAIT_FRANCHISE_MENSUELLE_1_JOURS = 1;
  private static final int FORFAIT_FRANCHISE_MENSUELLE_2_JOURS = 2;
  private static final int JOURS_MAX_FRANCHISE_SALAIRE = 2;
  
  public static OutilConstitutionDelaisReportsClauseRattrapageSpectacle2016 getInstance()
  {
    return new OutilConstitutionDelaisReportsClauseRattrapageSpectacle2016();
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilConstitutionDelaisReportsClauseRattrapageSpectacle2016();
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    boolean estApplicable = false;
    if ((criteres != null) && (criteres.getListeContextesReglementaires() != null) && (criteres.getListeContextesReglementaires().contains("DateLimiteContexteEntreeClauseRattrapage"))) {
      estApplicable = true;
    }
    return estApplicable;
  }
  
  public int calculerMensualisationFranchiseCP(int nombreJoursFranchiseCP)
  {
    int forfait = 0;
    if (nombreJoursFranchiseCP == 1) {
      forfait = 1;
    } else if (nombreJoursFranchiseCP > 1) {
      forfait = 2;
    }
    return forfait;
  }
  
  public int calculerMensualisationFranchiseSalaire(int nombreJoursFranchiseSalaire, Damj dateAttribution, Damj dateLimiteIndemnisation)
  {
    int nombreMoisCivil = calculerMoisCivilsEntre(dateAttribution, dateLimiteIndemnisation);
    
    BigDecimal moisCivilsBD = BigDecimal.valueOf(nombreMoisCivil);
    BigDecimal franchiseSalaireBD = BigDecimal.valueOf(nombreJoursFranchiseSalaire);
    
    BigDecimal franchiseSalaireMensuelleBD = franchiseSalaireBD.divide(moisCivilsBD, 0);
    
    return Math.min(2, franchiseSalaireMensuelleBD.intValue());
  }
}

/* Location:
 * Qualified Name:     OutilConstitutionDelaisReportsClauseRattrapageSpectacle2016
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */