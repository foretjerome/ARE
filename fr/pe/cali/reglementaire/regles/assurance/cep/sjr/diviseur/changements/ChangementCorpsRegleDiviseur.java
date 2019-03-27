package fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.outils.impl.OutilRegleCalculDiviseurCasGeneral;

public class ChangementCorpsRegleDiviseur
  extends ChangementCorpsRegle
{
  private static ChangementCorpsRegleDiviseur instance = new ChangementCorpsRegleDiviseur();
  
  private ChangementCorpsRegleDiviseur()
  {
    setNomCorpsRegle("ConstitutionSjrCalculDiviseur");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(OutilRegleCalculDiviseurCasGeneral.getInstance());
  }
  
  public static ChangementCorpsRegleDiviseur getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementCorpsRegleDiviseur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */