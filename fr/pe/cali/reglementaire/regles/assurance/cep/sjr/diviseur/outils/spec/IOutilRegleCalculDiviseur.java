package fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.outils.spec;

import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.dom.DonneesEntreesCalculDiviseur;
import fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.dom.ResultatCalculDiviseur;

public abstract interface IOutilRegleCalculDiviseur
  extends IOutilCorpsRegle
{
  public abstract ResultatCalculDiviseur calculerDiviseur(DonneesEntreesCalculDiviseur paramDonneesEntreesCalculDiviseur);
  
  public abstract ResultatCalculDiviseur calculerCoefficientAbsence(DonneesEntreesCalculDiviseur paramDonneesEntreesCalculDiviseur);
}

/* Location:
 * Qualified Name:     IOutilRegleCalculDiviseur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */