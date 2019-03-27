package fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.outils.spec;

import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.dom.DonneesEntreeBeneficiaireAAH;
import fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.dom.DonneesSortieBeneficiaireAAH;
import fr.unedic.archi.logique.exception.ApplicativeException;

public abstract interface IOutilConditionBeneficiaireAAH
  extends IOutilCorpsRegle
{
  public abstract DonneesSortieBeneficiaireAAH verifierConditionBeneficiaireAAH(DonneesEntreeBeneficiaireAAH paramDonneesEntreeBeneficiaireAAH)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     IOutilConditionBeneficiaireAAH
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */