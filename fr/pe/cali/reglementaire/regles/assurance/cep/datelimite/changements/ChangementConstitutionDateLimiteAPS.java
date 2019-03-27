package fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.impl.OutilConstitutionDateLimiteAPSApresCRA;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.impl.OutilConstitutionDateLimiteAPSApresDroitCommun;

public class ChangementConstitutionDateLimiteAPS
  extends ChangementCorpsRegle
{
  private static ChangementConstitutionDateLimiteAPS instance = new ChangementConstitutionDateLimiteAPS();
  
  private ChangementConstitutionDateLimiteAPS()
  {
    setNomCorpsRegle("ConstitutionDateLimite");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(OutilConstitutionDateLimiteAPSApresDroitCommun.getInstance());
    ajouterCorpsRegle(OutilConstitutionDateLimiteAPSApresCRA.getInstance());
  }
  
  public static ChangementConstitutionDateLimiteAPS getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConstitutionDateLimiteAPS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */