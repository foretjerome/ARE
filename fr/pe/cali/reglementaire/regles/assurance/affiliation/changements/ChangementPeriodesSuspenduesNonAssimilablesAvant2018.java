package fr.pe.cali.reglementaire.regles.assurance.affiliation.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl.OutilPeriodeNonAssimilableFgdAvant2018;

public class ChangementPeriodesSuspenduesNonAssimilablesAvant2018
  extends ChangementCorpsRegle
{
  private static ChangementPeriodesSuspenduesNonAssimilablesAvant2018 instance = new ChangementPeriodesSuspenduesNonAssimilablesAvant2018();
  
  private ChangementPeriodesSuspenduesNonAssimilablesAvant2018()
  {
    setNomCorpsRegle("PeriodeSuspendueNonAssimilable");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(new OutilPeriodeNonAssimilableFgdAvant2018());
  }
  
  public static final ChangementPeriodesSuspenduesNonAssimilablesAvant2018 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementPeriodesSuspenduesNonAssimilablesAvant2018
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */