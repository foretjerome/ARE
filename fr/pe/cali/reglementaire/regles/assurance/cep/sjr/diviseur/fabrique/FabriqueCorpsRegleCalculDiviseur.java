package fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.fabrique;

import fr.pe.cali.reglementaire.decors.fabrique.FabriqueCorpsRegle;
import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.outils.spec.IOutilRegleCalculDiviseur;

public class FabriqueCorpsRegleCalculDiviseur
  extends FabriqueCorpsRegle
{
  private static FabriqueCorpsRegleCalculDiviseur instance = new FabriqueCorpsRegleCalculDiviseur();
  
  private FabriqueCorpsRegleCalculDiviseur()
  {
    setNomCorpsRegle("ConstitutionSjrCalculDiviseur");
  }
  
  public static FabriqueCorpsRegleCalculDiviseur getInstance()
  {
    return instance;
  }
  
  public IOutilRegleCalculDiviseur recupererOutilCorpsRegle(CriteresFabriqueReglementaire criteres)
  {
    return (IOutilRegleCalculDiviseur)super.recupererOutilCorpsRegle(criteres);
  }
}

/* Location:
 * Qualified Name:     FabriqueCorpsRegleCalculDiviseur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */