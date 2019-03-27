package fr.pe.cali.reglementaire.regles.assurance.affiliation.fabrique;

import fr.pe.cali.reglementaire.decors.fabrique.FabriqueCorpsRegle;
import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.spec.IOutilPeriodeNonAssimilable;

public class FabriqueCorpsReglePeriodesSuspensionsNonAssimilables
  extends FabriqueCorpsRegle
{
  private static FabriqueCorpsReglePeriodesSuspensionsNonAssimilables instance = new FabriqueCorpsReglePeriodesSuspensionsNonAssimilables();
  
  private FabriqueCorpsReglePeriodesSuspensionsNonAssimilables()
  {
    setNomCorpsRegle("PeriodeSuspendueNonAssimilable");
  }
  
  public static FabriqueCorpsReglePeriodesSuspensionsNonAssimilables getInstance()
  {
    return instance;
  }
  
  public IOutilPeriodeNonAssimilable recupererOutilCorpsRegle(CriteresFabriqueReglementaire criteres)
  {
    return (IOutilPeriodeNonAssimilable)super.recupererOutilCorpsRegle(criteres);
  }
}

/* Location:
 * Qualified Name:     FabriqueCorpsReglePeriodesSuspensionsNonAssimilables
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */