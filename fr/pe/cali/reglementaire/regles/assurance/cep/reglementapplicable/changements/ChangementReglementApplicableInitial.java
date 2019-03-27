package fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.impl.OutilReglementApplicableAspSousJacent;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.impl.OutilReglementApplicableClassique;

public class ChangementReglementApplicableInitial
  extends ChangementCorpsRegle
{
  private static ChangementReglementApplicableInitial instance = new ChangementReglementApplicableInitial();
  
  private ChangementReglementApplicableInitial()
  {
    setNomCorpsRegle("ConstitutionReglementApplicable");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(OutilReglementApplicableClassique.getInstance());
    ajouterCorpsRegle(OutilReglementApplicableAspSousJacent.getInstance());
  }
  
  public static ChangementReglementApplicableInitial getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementReglementApplicableInitial
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */