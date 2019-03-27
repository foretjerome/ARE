package fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.dom.DonneesEntreeBeneficiaireAAH;
import fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.dom.DonneesSortieBeneficiaireAAH;
import fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.outils.spec.IOutilConditionBeneficiaireAAH;
import fr.unedic.cali.dom.PeriodeDroitAAH;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.List;

public class OutilConditionBeneficiaireAAH
  implements IOutilConditionBeneficiaireAAH
{
  private static final String NOM_OUTIL = OutilConditionBeneficiaireAAH.class.getPackage().getName() + '/' + OutilConditionBeneficiaireAAH.class.toString();
  private static OutilConditionBeneficiaireAAH instance;
  
  public static OutilConditionBeneficiaireAAH getInstance()
  {
    if (instance == null) {
      instance = new OutilConditionBeneficiaireAAH();
    }
    return instance;
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return true;
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilConditionBeneficiaireAAH();
  }
  
  public String getNomOutil()
  {
    return NOM_OUTIL;
  }
  
  public DonneesSortieBeneficiaireAAH verifierConditionBeneficiaireAAH(DonneesEntreeBeneficiaireAAH donneesEntreeBeneficiaireAAH)
  {
    DonneesSortieBeneficiaireAAH donneesSortieBeneficiaireAAH = new DonneesSortieBeneficiaireAAH();
    
    List<PeriodeDroitAAH> listePeriodeDroitAAH = donneesEntreeBeneficiaireAAH.getPeriodesDroitAAH();
    Damj dateExamen = donneesEntreeBeneficiaireAAH.getDateExamen();
    Boolean conditionNonCumulAahDF = donneesEntreeBeneficiaireAAH.getConditionNonCumulAahDF();
    if (conditionNonCumulAahDF != null)
    {
      donneesSortieBeneficiaireAAH.setSatisfait(conditionNonCumulAahDF.booleanValue());
    }
    else
    {
      donneesSortieBeneficiaireAAH.setSatisfait(true);
      PeriodeDroitAAH periodeAAHCible = recupererPeriodeAAHContenantDateExamen(listePeriodeDroitAAH, dateExamen);
      if (periodeAAHCible != null)
      {
        donneesSortieBeneficiaireAAH.setSatisfait(false);
        donneesSortieBeneficiaireAAH.setPeriodeDroitAAH(periodeAAHCible);
      }
    }
    return donneesSortieBeneficiaireAAH;
  }
  
  protected PeriodeDroitAAH recupererPeriodeAAHContenantDateExamen(List<PeriodeDroitAAH> listePeriodeDroitAAH, Damj dateExamen)
  {
    PeriodeDroitAAH periodeAAHCible = null;
    if (listePeriodeDroitAAH != null) {
      for (PeriodeDroitAAH periodeDroitAAH : listePeriodeDroitAAH) {
        if (periodeDroitAAH.getPeriodeDroit().contient(dateExamen))
        {
          periodeAAHCible = periodeDroitAAH;
          break;
        }
      }
    }
    return periodeAAHCible;
  }
}

/* Location:
 * Qualified Name:     OutilConditionBeneficiaireAAH
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */