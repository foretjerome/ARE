package fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.fabrique;

import fr.pe.cali.reglementaire.decors.fabrique.FabriqueCorpsRegle;
import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.spec.IOutilConstitutionDateLimite;

public final class FabriqueCorpsRegleConstitutionDateLimite
  extends FabriqueCorpsRegle
{
  private static FabriqueCorpsRegleConstitutionDateLimite instance = new FabriqueCorpsRegleConstitutionDateLimite();
  
  private FabriqueCorpsRegleConstitutionDateLimite()
  {
    setNomCorpsRegle("ConstitutionDateLimite");
  }
  
  public static FabriqueCorpsRegleConstitutionDateLimite getInstance()
  {
    return instance;
  }
  
  public IOutilConstitutionDateLimite recupererOutilCorpsRegle(CriteresFabriqueReglementaire criteres)
  {
    return (IOutilConstitutionDateLimite)super.recupererOutilCorpsRegle(criteres);
  }
}

/* Location:
 * Qualified Name:     FabriqueCorpsRegleConstitutionDateLimite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */