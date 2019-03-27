package fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.impl.OutilConstitutionDateLimiteEntreeClauseRattrapageSpectacle2016;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.impl.OutilConstitutionDateLimiteGeneralSpectacle2016;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.impl.OutilConstitutionDateLimiteReadClauseRattrapageSpectacle2016;

public final class ChangementConstitutionDateLimiteSpectacle2016
  extends ChangementCorpsRegle
{
  private static ChangementConstitutionDateLimiteSpectacle2016 instance = new ChangementConstitutionDateLimiteSpectacle2016();
  
  private ChangementConstitutionDateLimiteSpectacle2016()
  {
    setNomCorpsRegle("ConstitutionDateLimite");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(OutilConstitutionDateLimiteGeneralSpectacle2016.getInstance());
    ajouterCorpsRegle(OutilConstitutionDateLimiteReadClauseRattrapageSpectacle2016.getInstance());
    ajouterCorpsRegle(OutilConstitutionDateLimiteEntreeClauseRattrapageSpectacle2016.getInstance());
  }
  
  public static ChangementConstitutionDateLimiteSpectacle2016 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConstitutionDateLimiteSpectacle2016
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */