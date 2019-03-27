package fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.dom.DonneesEntreeBeneficiaireAAH;
import fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.dom.DonneesSortieBeneficiaireAAH;
import fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.outils.spec.IOutilConditionBeneficiaireAAH;
import fr.unedic.archi.logique.exception.ApplicativeException;

public class OutilConditionSatisfaite
  implements IOutilConditionBeneficiaireAAH
{
  private static final String NOM_OUTIL = OutilConditionSatisfaite.class.getPackage().getName() + '/' + OutilConditionSatisfaite.class.toString();
  private static OutilConditionSatisfaite instance;
  
  public static OutilConditionSatisfaite getInstance()
  {
    if (instance == null) {
      instance = new OutilConditionSatisfaite();
    }
    return instance;
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return true;
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilConditionSatisfaite();
  }
  
  public String getNomOutil()
  {
    return NOM_OUTIL;
  }
  
  public DonneesSortieBeneficiaireAAH verifierConditionBeneficiaireAAH(DonneesEntreeBeneficiaireAAH donneesEntreeBeneficiaireAAH)
    throws ApplicativeException
  {
    DonneesSortieBeneficiaireAAH donneesSortieBeneficiaireAAH = new DonneesSortieBeneficiaireAAH();
    donneesSortieBeneficiaireAAH.setSatisfait(true);
    return donneesSortieBeneficiaireAAH;
  }
}

/* Location:
 * Qualified Name:     OutilConditionSatisfaite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */