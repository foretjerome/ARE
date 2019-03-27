package fr.pe.cali.reglementaire.regles.assurance.affiliation.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl.OutilPeriodeNonAssimilableFgdApres2018;

public class ChangementPeriodesSuspenduesNonAssimilablesApres2018
  extends ChangementCorpsRegle
{
  private static ChangementPeriodesSuspenduesNonAssimilablesApres2018 instance = new ChangementPeriodesSuspenduesNonAssimilablesApres2018();
  
  private ChangementPeriodesSuspenduesNonAssimilablesApres2018()
  {
    setNomCorpsRegle("PeriodeSuspendueNonAssimilable");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(new OutilPeriodeNonAssimilableFgdApres2018());
  }
  
  public static final ChangementPeriodesSuspenduesNonAssimilablesApres2018 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementPeriodesSuspenduesNonAssimilablesApres2018
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */